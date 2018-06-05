package com.nx.search.service.wechat;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信接口
 * Created by dell on 2018/3/23.
 */
public interface IWxCoreService {

    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    String processRequest(HttpServletRequest request);
}