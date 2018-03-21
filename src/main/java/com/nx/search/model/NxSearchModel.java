package com.nx.search.model;

import lombok.Data;

import java.util.Date;

/**
 * 农险搜索表
 *
 * @author: caidchen
 * @create: 2018-03-20 9:32
 * To change this template use File | Settings | File Templates.
 */
@Data
public class NxSearchModel {
    private long id;
    private String insCode;
    private String reportNumber;
    private String policyNumber;
    private String insured;
    private String idCard;
    private Date riskDate;
    private Date closingDate;
    private double claimAmount;
}
