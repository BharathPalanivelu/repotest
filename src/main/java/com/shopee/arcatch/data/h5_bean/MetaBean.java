package com.shopee.arcatch.data.h5_bean;

import com.google.a.a.c;
import java.util.List;

public class MetaBean {
    @c(a = "session_metas")
    private List<SessionMetasBean> sessionMetas;

    public List<SessionMetasBean> getSessionMetas() {
        return this.sessionMetas;
    }

    public void setSessionMetas(List<SessionMetasBean> list) {
        this.sessionMetas = list;
    }

    public String toString() {
        return "MetaBean{sessionMetas=" + this.sessionMetas + '}';
    }
}
