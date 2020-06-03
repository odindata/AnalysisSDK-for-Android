package com.odin.analysis.demo.data;

import java.io.Serializable;

/**
 * 一个键值对信息
 */
public class InfoItem implements Serializable {

    private String name;
    private String value;

    public InfoItem(String name, String value) {
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
