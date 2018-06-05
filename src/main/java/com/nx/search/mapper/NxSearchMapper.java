package com.nx.search.mapper;

import com.nx.search.model.NxSearchModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: caidchen
 * @create: 2018-03-20 9:42
 * To change this template use File | Settings | File Templates.
 */
public interface NxSearchMapper {

    List<NxSearchModel> findAllNxSearch() ;

    int insertNxSearch(List<NxSearchModel> nxSearchModels) ;

    NxSearchModel findOnlyByIdCard(@Param("card") String card, @Param("name") String name) ;

    NxSearchModel findOnlyByReport(@Param("report") String report, @Param("name") String name) ;

}
