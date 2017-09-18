package com.didispace.domain.s;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Component
public class Message {

    private Long id;
    //版本号
    private int version;
    //修改者
    private String editor;
    //创建者
    private String creater;
    //最后修改时间
    private Date editTime;
    //创建时间
    private Date createTime;
    //消息ID
    private String messsageId;
    //消息内容
    private String messageBody;
    //消息数据类型
    private String messageDataType;
    //消费队列
    private String consumerQueue;
    //消息重发次数
    private String messageSendTimes;
    //是否死亡
    private String areadlydead;
    //状态
    private String status;
    //备注
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMesssageId() {
        return messsageId;
    }

    public void setMesssageId(String messsageId) {
        this.messsageId = messsageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageDataType() {
        return messageDataType;
    }

    public void setMessageDataType(String messageDataType) {
        this.messageDataType = messageDataType;
    }

    public String getConsumerQueue() {
        return consumerQueue;
    }

    public void setConsumerQueue(String consumerQueue) {
        this.consumerQueue = consumerQueue;
    }

    public String getMessageSendTimes() {
        return messageSendTimes;
    }

    public void setMessageSendTimes(String messageSendTimes) {
        this.messageSendTimes = messageSendTimes;
    }

    public String getAreadlydead() {
        return areadlydead;
    }

    public void setAreadlydead(String areadlydead) {
        this.areadlydead = areadlydead;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Message() {

    }
}
