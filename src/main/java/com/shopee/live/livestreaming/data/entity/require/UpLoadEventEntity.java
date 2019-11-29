package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class UpLoadEventEntity implements Serializable {
    private String operation;
    private String page_id;
    private String page_section;
    private String page_type;
    private String target_type;

    public String getPage_id() {
        String str = this.page_id;
        return str == null ? "" : str;
    }

    public void setPage_id(String str) {
        this.page_id = str;
    }

    public String getPage_type() {
        String str = this.page_type;
        return str == null ? "" : str;
    }

    public void setPage_type(String str) {
        this.page_type = str;
    }

    public String getOperation() {
        String str = this.operation;
        return str == null ? "" : str;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public String getPage_section() {
        String str = this.page_section;
        return str == null ? "" : str;
    }

    public void setPage_section(String str) {
        this.page_section = str;
    }

    public String getTarget_type() {
        String str = this.target_type;
        return str == null ? "" : str;
    }

    public void setTarget_type(String str) {
        this.target_type = str;
    }
}
