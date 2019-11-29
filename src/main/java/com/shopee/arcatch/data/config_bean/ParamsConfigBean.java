package com.shopee.arcatch.data.config_bean;

import com.shopee.arcatch.data.network_bean.game.PropsBean;
import java.util.List;

public class ParamsConfigBean {
    public int duration;
    public String endUrl;
    public String errorUrl;
    public String eventId;
    public String instanceId;
    public boolean mute;
    public int peakThrottleTime;
    public List<PropsBean> props;
    public boolean saveVideo;
    public String sessionId;
    public String source;

    public String toString() {
        return "ParamsConfigBean{eventId='" + this.eventId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", instanceId='" + this.instanceId + '\'' + ", mute=" + this.mute + ", saveVideo=" + this.saveVideo + ", duration=" + this.duration + ", props=" + this.props + ", endUrl='" + this.endUrl + '\'' + ", errorUrl='" + this.errorUrl + '\'' + ", source='" + this.source + '\'' + ", peakThrottleTime=" + this.peakThrottleTime + '}';
    }
}
