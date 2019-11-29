package com.shopee.arcatch.data.h5_bean;

import com.google.a.a.c;
import com.shopee.arcatch.data.network_bean.game.PropsBean;
import java.util.List;

public class ArCatchH5BeginBean {
    @c(a = "duration")
    private int duration;
    @c(a = "end_url")
    private String endUrl;
    @c(a = "error_url")
    private String errorUrl;
    @c(a = "event_id")
    private String eventId;
    @c(a = "instance_id")
    private String instanceId;
    @c(a = "meta")
    private MetaBean meta;
    @c(a = "mute")
    private boolean mute;
    @c(a = "peak_throttle_time")
    private int peakThrottleTime;
    @c(a = "props")
    private List<PropsBean> props;
    @c(a = "save_video")
    private boolean saveVideo;
    @c(a = "session_id")
    private String sessionId;
    @c(a = "session_name")
    private String sessionName;
    @c(a = "source")
    private String source;

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public MetaBean getMeta() {
        return this.meta;
    }

    public void setMeta(MetaBean metaBean) {
        this.meta = metaBean;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public boolean isMute() {
        return this.mute;
    }

    public void setMute(boolean z) {
        this.mute = z;
    }

    public boolean isSaveVideo() {
        return this.saveVideo;
    }

    public void setSaveVideo(boolean z) {
        this.saveVideo = z;
    }

    public List<PropsBean> getProps() {
        return this.props;
    }

    public void setProps(List<PropsBean> list) {
        this.props = list;
    }

    public String getEndUrl() {
        return this.endUrl;
    }

    public void setEndUrl(String str) {
        this.endUrl = str;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public void setSessionName(String str) {
        this.sessionName = str;
    }

    public String getErrorUrl() {
        return this.errorUrl;
    }

    public void setErrorUrl(String str) {
        this.errorUrl = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public int getPeakThrottleTime() {
        return this.peakThrottleTime;
    }

    public void setPeakThrottleTime(int i) {
        this.peakThrottleTime = i;
    }

    public String toString() {
        return "ArCatchH5BeginBean{eventId='" + this.eventId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", sessionName='" + this.sessionName + '\'' + ", meta=" + this.meta + ", instanceId='" + this.instanceId + '\'' + ", duration=" + this.duration + ", mute=" + this.mute + ", saveVideo=" + this.saveVideo + ", props=" + this.props + ", endUrl='" + this.endUrl + '\'' + ", errorUrl='" + this.errorUrl + '\'' + ", source='" + this.source + '\'' + ", peakThrottleTime=" + this.peakThrottleTime + '}';
    }
}
