package com.mooye.business.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;

/**
 * <h1>MessageHead<h1>
 * <p>Copyright (C), 星期一,11,10月,2021,</p>
 * <br/>
 * <hr>
 * <h3>File Info:</h3>
 * <p>FileName: MessageHead</p>
 * <p>Author:   mooye</p>
 * <p>Work_Email： lidy@skyvis.com.cn</p>
 * <p>E-mail： curtainldy@163.com</p>
 * <p>Date:     2021/10/11</p>
 * <p>Description: 消息头</p>
 * <hr>
 * <h3>History:</h3>
 * <hr>
 * <table>
 *  <thead>
 *  <tr><td style='width:100px;' center>作者姓名</td><td style='width:200px;' center>修改时间</td><td style='width:100px;' center>版本号</td><td style='width:100px;' center>描述</td></tr>
 *  </thead>
 *  <tbody>
 *    <tr><td style='width:100px;' center>mooye</td><td style='width:200px;' center>11:50 2021/10/11</td><td style='width:100px;' center>v_0.0.1</td><td
 *    style='width:100px;' center>创建</td></tr>
 *  </tbody>
 * </table>
 * <hr>
 * <br/>
 *
 * @author mooye
 */

@Data
public class MessageHead {
    /**
     * 发送者
     */
    private String sender;
    /**
     * 发送者 id
     */
    private String senderId;
    /**
     * 接收者
     */
    private String recipient;
    /**
     * 接收者 id
     */
    private String recipientId;
    /**
     * 发送方式
     */
    private String sendType;
    /**
     * 消息大小
     */
    private Integer messageSize;
    /**
     * 上一条消息 id
     */
    private String lastMessageId;
    /**
     * 发送时间
     */
    private Date sendTime;
    
    public static MessageHead analysisMessageHead(JSONObject messageHead) {
        MessageHead head = new MessageHead();
        head.setSender(messageHead.getString("sender"));
        head.setSenderId(messageHead.getString("senderId"));
        head.setRecipient(messageHead.getString("recipient"));
        head.setRecipientId(messageHead.getString("recipientId"));
        head.setSendType(messageHead.getString("sendType"));
        head.setMessageSize(messageHead.getInteger("messageSize"));
        head.setLastMessageId(messageHead.getString("lastMessageId"));
        head.setSendTime(messageHead.getDate("sendTime"));
        return head;
    }
    
    public static JSONObject analysisMessageHead(MessageHead messageHead){
        JSONObject json = new JSONObject();
        json.put("sender",messageHead.getSender());
        json.put("senderId",messageHead.getSenderId());
        json.put("recipient",messageHead.getRecipient());
        json.put("recipientId",messageHead.getRecipientId());
        json.put("sendType",messageHead.getSendType());
        json.put("messageSize",messageHead.getMessageSize());
        json.put("lastMessageId",messageHead.getLastMessageId());
        json.put("sendTime",messageHead.getSendTime());
        return json;
    }
}
