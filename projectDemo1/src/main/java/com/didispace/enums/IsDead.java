package com.didispace.enums;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public enum IsDead {

    AreadlyDead("已经死亡","1"),NoDead("未死亡","0");

    private String name;
    private String value;

    IsDead(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
