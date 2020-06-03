package com.odin.analysis.demo.data;

/**
 * 主页Item的数据
 */
public class MenuType {

    private int adapterType;
    private String name;

    private Event event;

    public MenuType(int adapterType, String name, Event event) {
        this.adapterType = adapterType;
        this.name = name;
        this.event = event;
    }

    public int getAdapterType() {
        return adapterType;
    }

    public void setAdapterType(int adapterType) {
        this.adapterType = adapterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
