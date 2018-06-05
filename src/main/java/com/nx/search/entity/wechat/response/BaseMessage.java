//package com.nx.search.entity.wechat.response;
//
//import lombok.Data;
//
///**
// * 微信响应消息
// * 消息基类（公众帐号 -> 用户）
// *
// * @author: caidchen
// * @create: 2018-03-22 17:28
// * To change this template use File | Settings | File Templates.
// */
//@Data
//public class BaseMessage {
//    /**
//     * 发送方帐号（一个OpenID）
//     */
//    private String ToUserName;
//    /**
//     * 开发者微信号
//     */
//    private String FromUserName;
//    /**
//     * 消息创建时间 （整型）
//     */
//    private long CreateTime;
//
//    /**
//     * 位0x0001被标志时，星标刚收到的消息
//     */
//    private int FuncFlag;
//
//    /**
//     * 消息类型，event
//     */
//    private String MsgType;
//    /**
//     * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
//     */
//    private String Event;
//}
