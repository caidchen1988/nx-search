package com.nx.search.service;

import com.nx.search.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dell on 2018/3/20.
 */
public interface INxSearchService {

    Result findAllByPage(int pageNum, int pageSize) ;

    Result importData(MultipartFile file) ;

    Result findOnlyByIdCard(String card, String name) ;

    Result findOnlyByReport(String report, String name) ;
}
