package com.odin.analysis.demo.data;

import java.io.Serializable;
import java.util.List;

/**
 * 事件数据：包含如下信息，1、事件的名称和描述；2、事件的属性信息。
 */
public class Event implements Serializable {

    private String name;
    private String description;
    private List<EventInfo> eventInfoList;

    public Event(String name, String description, List<EventInfo> eventInfoList) {
        this.name = name;
        this.description = description;
        this.eventInfoList = eventInfoList;
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

    public List<EventInfo> getEventInfoList() {
        return eventInfoList;
    }

    public void setEventInfoList(List<EventInfo> eventInfoList) {
        this.eventInfoList = eventInfoList;
    }
}
