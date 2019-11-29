package com.shopee.live.livestreaming.sztracking.creator;

import android.text.TextUtils;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.base.util.NetStatusUtil;
import com.shopee.live.livestreaming.sztracking.proto.Event;
import com.shopee.live.livestreaming.sztracking.proto.Header;
import com.shopee.live.livestreaming.sztracking.proto.SceneID;
import com.squareup.wire.Message;
import e.f;

public abstract class AbstractSZTrackingEventCreator<T extends Message> implements SZTrackingEventBuildInterface {
    protected int eventId;
    protected T mBody;
    protected Header mHeader;
    protected String mServerIp;
    protected int scendId;
    protected SZTrackingSettings settings;

    public abstract T buildBody();

    public abstract Message rebuildEvent(String str);

    public AbstractSZTrackingEventCreator(SZTrackingSettings sZTrackingSettings, int i) {
        this(sZTrackingSettings, i, SceneID.LiveStreaming.getValue());
    }

    public AbstractSZTrackingEventCreator(SZTrackingSettings sZTrackingSettings, int i, int i2) {
        this.settings = sZTrackingSettings;
        this.eventId = i;
        this.scendId = i2;
    }

    public AbstractSZTrackingEventCreator(SZTrackingSettings sZTrackingSettings, int i, String str) {
        this(sZTrackingSettings, i, SceneID.LiveStreaming.getValue(), str);
    }

    public AbstractSZTrackingEventCreator(SZTrackingSettings sZTrackingSettings, int i, int i2, String str) {
        this.settings = sZTrackingSettings;
        this.eventId = i;
        this.scendId = i2;
        this.mServerIp = str;
    }

    private Header buildHeader(SZTrackingSettings sZTrackingSettings, int i, int i2) {
        return new Header.Builder().id(Integer.valueOf(i)).scene_id(Integer.valueOf(i2)).uid(Long.valueOf(sZTrackingSettings.getUid())).client_ip(sZTrackingSettings.getClientIp()).client_version(sZTrackingSettings.getClientVersion()).country(sZTrackingSettings.getCountry()).device_id(sZTrackingSettings.getDeviceId()).device_model(sZTrackingSettings.getDeviceModel()).os(Integer.valueOf(sZTrackingSettings.getOs())).os_version(sZTrackingSettings.getOsVersion()).network(Integer.valueOf(NetStatusUtil.getNetworkState(b.b().f28742b))).sdk_version(sZTrackingSettings.getSdkVersion()).ua(sZTrackingSettings.getUserAgent()).timestamp(Long.valueOf(System.currentTimeMillis())).build();
    }

    public boolean beforeBuildCheckSuccessFully() {
        return !TextUtils.isEmpty(this.mServerIp);
    }

    public AbstractSZTrackingEventCreator buildCreator() {
        this.mHeader = buildHeader(this.settings, this.eventId, this.scendId);
        this.mBody = buildBody();
        return this;
    }

    public Message buildEvent() {
        T t = this.mBody;
        if (t == null || this.mHeader == null) {
            return null;
        }
        return new Event(this.mHeader, f.a(t.toByteArray()));
    }
}
