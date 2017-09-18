package com.didispace.enums;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public enum MessageStatus {

    waitConfirmed("待确认","0"),waitSend("待发送","1");

    private String name;
    private String  value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    MessageStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
