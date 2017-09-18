package com.didispace.domain.p;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Entity
public class Message {

    //主键ID
    @Id
    @GeneratedValue
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
    private int messageSendTimes;

    //是否死亡
    private String areadlydead;

    public String getAreadlydead() {
        return areadlydead;
    }

    public void setAreadlydead(String areadlydead) {
        this.areadlydead = areadlydead;
    }

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

    public int getMessageSendTimes() {
        return messageSendTimes;
    }

    public void setMessageSendTimes(int messageSendTimes) {
        this.messageSendTimes = messageSendTimes;
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

    public Message(int version, String editor, String creater, Date editTime, Date createTime, String messsageId, String messageBody, String messageDataType, String consumerQueue, int messageSendTimes, String areadlydead, String status, String remark) {
        this.version = version;
        this.editor = editor;
        this.creater = creater;
        this.editTime = editTime;
        this.createTime = createTime;
        this.messsageId = messsageId;
        this.messageBody = messageBody;
        this.messageDataType = messageDataType;
        this.consumerQueue = consumerQueue;
        this.messageSendTimes = messageSendTimes;
        this.areadlydead = areadlydead;
        this.status = status;
        this.remark = remark;
    }

    public Message() {

    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", version=" + version +
                ", editor='" + editor + '\'' +
                ", creater='" + creater + '\'' +
                ", editTime=" + editTime +
                ", createTime=" + createTime +
                ", messsageId='" + messsageId + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", messageDataType='" + messageDataType + '\'' +
                ", consumerQueue='" + consumerQueue + '\'' +
                ", messageSendTimes='" + messageSendTimes + '\'' +
                ", areadlydead='" + areadlydead + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
