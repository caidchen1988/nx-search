package com.nx.search.utils.xls;

import lombok.Data;

/**
 * Excel每列数据
 *
 * @author: caidchen
 * @create: 2017-05-22 14:49
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ExcelCellModel {

    private int colNum ; // 列数
    private String colVal ; // 数据

    public ExcelCellModel(int colNum, String colVal) {
        this.colNum = colNum;
        this.colVal = colVal;
    }

}
