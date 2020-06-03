package com.odin.analysis.demo.data;

import java.io.Serializable;

/**
 * 事件的属性信息
 */
public class EventInfo implements Serializable {

    private String name;
    private String description;
    private String isNecessary;
    private String dataType;
    private String common;

    public EventInfo(String name, String description, String isNecessary, String dataType, String common) {
        this.name = name;
        this.description = description;
        this.isNecessary = isNecessary;
        this.dataType = dataType;
        this.common = common;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsNecessary() {
        return isNecessary;
    }

    public void setIsNecessary(String isNecessary) {
        this.isNecessary = isNecessary;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

}
