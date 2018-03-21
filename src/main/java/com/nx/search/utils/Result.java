package com.nx.search.utils;

import lombok.Data;

/**
 * 任务结果
 *
 * @author: caidchen
 * @create: 2017-05-11 11:13
 * To change this template use File | Settings | File Templates.
 */
@Data
public class Result {
    private String errorCode;//错误代码
    private Boolean success;//请求是否成功
    private Boolean isException;//是否抛出异常，抛出异常则success为false，优先级大于success
    private String exName;//异常名称
    private String exDetails;//异常详细信息
    private String message;
    private Object data;
}
