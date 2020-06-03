package com.odin.analysis.demo.data;

import java.io.Serializable;
import java.util.List;

/**
 * 事件收集后需要展示的信息数据
 */
public class EventShowData implements Serializable {

    private String eventName;

    private String extraInfo;

    private List<InfoItem> infoItemList;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public List<InfoItem> getInfoItemList() {
        return infoItemList;
    }

    public void setInfoItemList(List<InfoItem> infoItemList) {
        this.infoItemList = infoItemList;
    }
}
