package com.nx.search.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nx.search.mapper.NxSearchMapper;
import com.nx.search.model.NxSearchModel;
import com.nx.search.utils.CommonUtil;
import com.nx.search.utils.Result;
import com.nx.search.utils.xls.ExcelCellModel;
import com.nx.search.utils.xls.ExcelReader;
import com.nx.search.utils.xls.ExcelRowModel;
import com.nx.search.utils.xls.ExcelSheetModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: caidchen
 * @create: 2018-03-20 10:04
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class NxSearchServiceImpl implements INxSearchService {

    @Autowired
    private NxSearchMapper nxSearchMapper;

    private static final String EXL_HEADER = "险种,报案号,保单号,被保险人,出险日期,赔款金额,结案日期,身份证," ;

    @Override
    public Result findAllByPage(int pageNum, int pageSize) {

        Result result = new Result();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<NxSearchModel> list = nxSearchMapper.findAllNxSearch();
            PageInfo<NxSearchModel> page = new PageInfo<>(list);

            result.setSuccess(true);
            result.setData(page);
            result.setMessage("查询成功");
        } catch (Exception e) {
            log.error("INxSearchService.findAllByPage --> error, message:"+e.getMessage());

            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setIsException(true);
        }

        return result;
    }

    @Override
    public Result importData(MultipartFile file) {

        Result result = new Result();
        if(file == null) {
            result.setSuccess(false);
            result.setMessage("上传文件为空");
            return result;
        }

        try {
            List<ExcelSheetModel> sheetModels = ExcelReader.read((FileInputStream) file.getInputStream(), FilenameUtils.getExtension(file.getOriginalFilename())) ;
            if(sheetModels != null) {
                String errorMsg = null;

                List<NxSearchModel> searchModels = new ArrayList<>() ;

                for (ExcelSheetModel sheetModel : sheetModels) {
                    for (ExcelRowModel row : sheetModel.getRowList()) {

                        if(row.getRowNum() == 0) {
                            StringBuilder header = new StringBuilder() ;
                            for (ExcelCellModel cell : row.getCellList()) {
                                header.append(cell.getColVal().trim()).append(",") ;
                            }
                            if(!header.toString().equals(EXL_HEADER)) {
                                errorMsg = "导入表格标题格式不正确，请修改好后重新导入。" ;
                                break;
                            }
                        } else {
                            NxSearchModel searchModel = new NxSearchModel() ;
                            searchModel.setInsCode(row.getCellList().get(0).getColVal());
                            searchModel.setReportNumber(row.getCellList().get(1).getColVal());
                            searchModel.setPolicyNumber(row.getCellList().get(2).getColVal());
                            searchModel.setInsured(row.getCellList().get(3).getColVal());
                            searchModel.setRiskDate(CommonUtil.str2Date(row.getCellList().get(4).getColVal()));
                            searchModel.setClaimAmount(CommonUtil.str2Double(row.getCellList().get(5).getColVal()));
                            searchModel.setClosingDate(CommonUtil.str2Date(row.getCellList().get(6).getColVal()));
                            searchModel.setIdCard(row.getCellList().get(7).getColVal().trim());
                            searchModels.add(searchModel);
                        }
                    }
                }

                if(errorMsg != null) {
                    result.setSuccess(false);
                    result.setMessage(errorMsg);
                } else {

                    int count = nxSearchMapper.insertNxSearch(searchModels) ;

                    result.setSuccess(true);
                    result.setData(count);
                    result.setMessage("导入成功");
                }
            }
        } catch (Exception e) {
            log.error("INxSearchService.importData --> error, message:"+e.getMessage());

            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setIsException(true);
        }

        return result;
    }
}
