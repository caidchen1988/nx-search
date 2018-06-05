package com.nx.search.service.wechat;

import com.nx.search.wechat.util.WeixinUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 微信自定义菜单
 *
 * @author: caidchen
 * @create: 2018-03-23 13:05
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class WxMenuServiceImpl implements IWxMenuService {

    // 菜单创建（POST） 限100（次/天）
    public static String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    @Override
    public String createMenu(String jsonMenu) {

        String resultStr = "";
        // 调用接口获取token
        String token = WeixinUtil.getToken();
        if (token != null) {
            // 调用接口创建菜单
            int result = createMenu(jsonMenu, token);
            // 判断菜单创建结果
            if (0 == result) {
                resultStr = "菜单创建成功";
                log.info(resultStr);
            } else {
                resultStr = "菜单创建失败，错误码：" + result;
                log.error(resultStr);
            }
        }

        return resultStr;
    }

    /**
     * 创建菜单
     *
     * @param jsonMenu
     *            菜单的json格式
     * @param accessToken
     *            有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public static int createMenu(String jsonMenu, String accessToken) {

        int result = 0;
//        // 拼装创建菜单的url
//        String url = MENU_CREATE.replace("ACCESS_TOKEN", accessToken);
//        // 调用接口创建菜单
//        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonMenu);
//
//        if (null != jsonObject) {
//            if (0 != jsonObject.getInt("errcode")) {
//                result = jsonObject.getInt("errcode");
//                log.error("创建菜单失败 errcode:" + jsonObject.getInt("errcode") + "，errmsg:" + jsonObject.getString("errmsg"));
//            }
//        }

        return result;
    }
}
