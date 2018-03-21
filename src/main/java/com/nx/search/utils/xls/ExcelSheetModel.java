package com.nx.search.utils.xls;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 解析Excel数据
 *
 * @author: caidchen
 * @create: 2017-05-22 13:40
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ExcelSheetModel implements Serializable {

    private int sheetNum;
    private String name;    // 名称
    private int totalNum ;      // 总记录数
    private List<ExcelRowModel> rowList ;  // 每行数据

    public ExcelSheetModel(String name, List<ExcelRowModel> rowList) {
        this.name = name;
        this.rowList = rowList;
    }

    public ExcelSheetModel(String name, List<ExcelRowModel> rowList, int sheetNum) {
        this.name = name;
        this.rowList = rowList;
        this.sheetNum = sheetNum ;
    }
}
