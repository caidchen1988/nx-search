package com.nx.search.rest;

import com.nx.search.service.INxSearchService;
import com.nx.search.service.wechat.IWxCoreService;
import com.nx.search.wechat.entity.menu.Button;
import com.nx.search.wechat.entity.menu.Menu;
import com.nx.search.wechat.service.MenuService;
import com.nx.search.wechat.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 微信公众号回调接口
 *
 * @author: caidchen
 * @create: 2018-03-22 16:24
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping("/wx")
public class WechatCallbackApi {

    @Autowired private IWxCoreService wxCoreService;

    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response)  {

        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignService.checkSignature(request)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            log.error("WechatCallbackApi.get error --> message: %s", e.getMessage());
        } finally {
            out.close();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("WechatCallbackApi.post UnsupportedEncoding error --> message: %s", e.getMessage());
        }

        response.setCharacterEncoding("UTF-8");
        // 调用核心业务类接收消息、处理消息
        String respMessage = wxCoreService.processRequest(request);

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {
            log.error("WechatCallbackApi.post IO error --> message: %s", e.getMessage());
        } finally {
            out.close();
        }
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public void createMenu(HttpServletRequest request, HttpServletResponse response) {
        Button sb2 = new Button("微客服", "click", "wchat_CustomerService_01", null, null);
		Button btn1 = new Button("微服务", "click", null, null, new Button[] {sb2 });

		Button sb3 = new Button("公司简介", "click", "23", null, null);
		Button sb4 = new Button("有问必答", "click", "45", null, null);

		Button btn2 = new Button("音智达", "click", null, null, new Button[] {
				sb3, sb4 });

		Button sb6 = new Button("view类型", "view", null, "http://47.96.11.114/search",
				null);

		Button btn3 = new Button("最新动态", "click", null, null, new Button[] {
				sb6 });

		Menu menu = new Menu(new Button[] { btn1, btn2, btn3 });
        MenuService.createMenu(menu);

        log.info("自定义菜单创建成功");
    }

}