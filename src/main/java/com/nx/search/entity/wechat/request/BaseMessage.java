//package com.nx.search.entity.wechat.request;
//
//import lombok.Data;
//
///**
// * 微信请求消息
// * 消息基类（用户 -> 公众帐号）
// * 1 文本消息 2 图片消息 3 语音消息 4 视频消息 5 地理位置消息 6 链接消息
// *
// * @author: caidchen
// * @create: 2018-03-22 17:27
// * To change this template use File | Settings | File Templates.
// */
//@Data
//public class BaseMessage {
//    /**
//     * 接收方微信号
//     */
//    private String ToUserName;
//    /**
//     * 发送方微信号，若为普通用户，则是一个OpenID
//     */
//    private String FromUserName;
//    /**
//     * 消息创建时间 （整型）
//     */
//    private long CreateTime;
//
//    /**
//     * 消息类型 text、image、location、link
//     */
//    private String MsgType;
//
//    /**
//     * 消息id，64位整型
//     */
//    private long MsgId;
//}
