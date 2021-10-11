package com.mooye.business.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <h1>MessageVo<h1>
 * <p>Copyright (C), 星期一,11,10月,2021,</p>
 * <br/>
 * <hr>
 * <h3>File Info:</h3>
 * <p>FileName: MessageVo</p>
 * <p>Author:   mooye</p>
 * <p>Work_Email： lidy@skyvis.com.cn</p>
 * <p>E-mail： curtainldy@163.com</p>
 * <p>Date:     2021/10/11</p>
 * <p>Description: 消息模型</p>
 * <hr>
 * <h3>History:</h3>
 * <hr>
 * <table>
 *  <thead>
 *  <tr><td style='width:100px;' center>作者姓名</td><td style='width:200px;' center>修改时间</td><td style='width:100px;' center>版本号</td><td style='width:100px;' center>描述</td></tr>
 *  </thead>
 *  <tbody>
 *    <tr><td style='width:100px;' center>mooye</td><td style='width:200px;' center>11:41 2021/10/11</td><td style='width:100px;' center>v_0.0.1</td><td style='width:100px;' center>创建</td></tr>
 *  </tbody>
 * </table>
 * <hr>
 * <br/>
 *
 * @author mooye
 */

@Data
public class MessageVo implements Serializable {
    /**
     * 消息 id
     */
    private String messageId;
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息头 文字消息为 text ;图片为 pic ...
     */
    private MessageHead messageHead;
    /**
     * 消息正文
     */
    private String messageBody;
    /**
     * 消息状态 发送成功:1,发送失败:0
     */
    private Integer messageStatus;
    
    public static MessageVo analysisMessage(JSONObject message){
        MessageVo messageVo = new MessageVo();
        messageVo.setMessageId(message.getString("messageId"));
        messageVo.setMessageType(message.getString("messageType"));
        MessageHead head = MessageHead.analysisMessageHead(JSONObject.parseObject(message.getString("messageHead")));
        messageVo.setMessageHead(head);
        messageVo.setMessageBody(message.getString("messageBody"));
        messageVo.setMessageStatus(message.getInteger("messageStatus"));
        return messageVo;
    }
    
    public static JSONObject analysisMessage(MessageVo message){
        JSONObject json = new JSONObject();
        json.put("messageId",message.getMessageId());
        json.put("messageType",message.getMessageType());
        json.put("messageHead",MessageHead.analysisMessageHead(message.getMessageHead()));
        json.put("messageBody",message.getMessageBody());
        json.put("messageStatus",message.getMessageStatus());
        return json;
    }
}
