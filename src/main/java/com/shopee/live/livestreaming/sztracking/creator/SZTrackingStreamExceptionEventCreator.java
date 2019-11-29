package com.shopee.live.livestreaming.sztracking.creator;

import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.proto.EventID;
import com.shopee.live.livestreaming.sztracking.proto.Header;
import com.shopee.live.livestreaming.sztracking.proto.StreamExceptionEvent;
import com.shopee.live.livestreaming.util.f;
import com.squareup.wire.Message;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public class SZTrackingStreamExceptionEventCreator extends AbstractSZTrackingEventCreator<StreamExceptionEvent> {
    public static final int PLAYER_EVENT_WIDTH_BUNDLELIST = 3;
    public static final int PUSHER_EMPTY_BODY_EVENT = 2;
    public static final int PUSHER_NAME_LESS_EVENT = 1;
    private List<BundleRecord> bundleRecords;
    private String eventName;
    private Bundle mBundle;
    private int type;

    public boolean beforeBuildCheckSuccessFully() {
        return true;
    }

    public Message rebuildEvent(String str) {
        return null;
    }

    public SZTrackingStreamExceptionEventCreator(SZTrackingSettings sZTrackingSettings, String str, int i) {
        super(sZTrackingSettings, EventID.StreamExceptionEvent.getValue());
        this.type = i;
        this.eventName = str;
    }

    public SZTrackingStreamExceptionEventCreator(SZTrackingSettings sZTrackingSettings, String str, List<BundleRecord> list, int i) {
        super(sZTrackingSettings, EventID.StreamExceptionEvent.getValue());
        this.type = i;
        this.eventName = str;
        this.bundleRecords = list;
    }

    public SZTrackingStreamExceptionEventCreator(SZTrackingSettings sZTrackingSettings, Bundle bundle, int i) {
        super(sZTrackingSettings, EventID.StreamExceptionEvent.getValue());
        this.type = i;
        this.mBundle = bundle;
    }

    public StreamExceptionEvent buildBody() {
        int i = this.type;
        if (i == 1) {
            return createPusherNamelessEvent(this.settings, this.mHeader, this.mBundle);
        }
        if (i == 2) {
            return createPusherEmptyBodyEvent(this.settings, this.mHeader, this.eventName);
        }
        if (i != 3) {
            return null;
        }
        return createPlayerEventWithBundleList(this.settings, this.bundleRecords, this.eventName);
    }

    private StreamExceptionEvent createPusherNamelessEvent(SZTrackingSettings sZTrackingSettings, Header header, Bundle bundle) {
        Bundle bundle2 = bundle;
        int f2 = f.a().f();
        int g2 = f.a().g();
        long l = f.a().l();
        String sDKVersionStr = TXLiveBase.getSDKVersionStr();
        String valueOf = String.valueOf(f.a().c());
        String systemCpuUsage = getSystemCpuUsage(bundle2.getString(TXLiveConstants.NET_STATUS_CPU_USAGE));
        String str = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "x" + bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT);
        String str2 = bundle2.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "";
        String str3 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS) + "";
        String str4 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "";
        String str5 = bundle2.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "";
        String str6 = bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "";
        String string = bundle2.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
        int i = g2;
        String valueOf2 = String.valueOf(bundle2.getInt(TXLiveConstants.NET_STATUS_NET_JITTER));
        String str7 = sDKVersionStr;
        StringBuilder sb = new StringBuilder();
        String str8 = string;
        sb.append(bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE));
        sb.append("");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        String str9 = sb2;
        sb3.append(bundle2.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE));
        sb3.append("");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        String str10 = sb4;
        sb5.append(bundle2.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP));
        sb5.append("");
        String sb6 = sb5.toString();
        String str11 = bundle2.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "";
        return new StreamExceptionEvent.Builder().session_id(String.valueOf(f2)).start_time(Long.valueOf(l)).cpu(systemCpuUsage + ";").cache_size(";").resolution(str + ";").battery(valueOf + ";").speed(str2 + ";").fps(str3 + ";").gop(str4 + ";").audio_rate(str5 + ";").video_rate(str6 + ";").drop_cnt(";").drop_size(";").jitter(valueOf2 + ";").net_time(header.timestamp + ";").stream_evt("").server_ip(str8).is_host(true).tx_sdk_version(str7).video_cache(str9 + ";").audio_cache(str10 + ";").video_drop(sb6 + ";").audio_drop(str11 + ";").multi_cdn(Boolean.valueOf(sZTrackingSettings.isMultiCdn())).video_url(sZTrackingSettings.getVideoUrl()).room_id(String.valueOf(i)).build();
    }

    private StreamExceptionEvent createPusherEmptyBodyEvent(SZTrackingSettings sZTrackingSettings, Header header, String str) {
        int f2 = f.a().f();
        int g2 = f.a().g();
        long l = f.a().l();
        String sDKVersionStr = TXLiveBase.getSDKVersionStr();
        String valueOf = String.valueOf(f.a().c());
        StreamExceptionEvent.Builder resolution = new StreamExceptionEvent.Builder().session_id(String.valueOf(f2)).start_time(Long.valueOf(l)).cpu(";").cache_size(";").resolution(";");
        StreamExceptionEvent.Builder jitter = resolution.battery(valueOf + ";").speed(";").fps(";").gop(";").audio_rate(";").video_rate(";").drop_cnt(";").drop_size(";").jitter(";");
        return jitter.net_time(header.timestamp + ";").video_cache(";").audio_cache(";").video_drop(";").audio_drop(";").multi_cdn(Boolean.valueOf(sZTrackingSettings.isMultiCdn())).video_url(sZTrackingSettings.getVideoUrl()).stream_evt(str).server_ip("").is_host(true).tx_sdk_version(sDKVersionStr).room_id(String.valueOf(g2)).build();
    }

    private StreamExceptionEvent createPlayerEventWithBundleList(SZTrackingSettings sZTrackingSettings, List<BundleRecord> list, String str) {
        int f2 = f.a().f();
        int g2 = f.a().g();
        long l = f.a().l();
        String sDKVersionStr = TXLiveBase.getSDKVersionStr();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();
        StringBuilder sb9 = new StringBuilder();
        StringBuilder sb10 = new StringBuilder();
        StringBuilder sb11 = new StringBuilder();
        int i = g2;
        StringBuilder sb12 = new StringBuilder();
        String str2 = sDKVersionStr;
        StringBuilder sb13 = new StringBuilder();
        long j = l;
        StringBuilder sb14 = new StringBuilder();
        StringBuilder sb15 = new StringBuilder();
        int i2 = f2;
        StringBuilder sb16 = new StringBuilder();
        StringBuilder sb17 = new StringBuilder();
        StringBuilder sb18 = new StringBuilder();
        for (BundleRecord next : list) {
            if (next.getBundle() == null) {
                break;
            }
            StringBuilder sb19 = sb15;
            sb.append(getSystemCpuUsage(next.getBundle().getString(TXLiveConstants.NET_STATUS_CPU_USAGE)));
            sb.append(";");
            sb2.append(";");
            StringBuilder sb20 = new StringBuilder();
            StringBuilder sb21 = sb2;
            StringBuilder sb22 = sb;
            sb20.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH));
            sb20.append("x");
            sb20.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT));
            sb3.append(sb20.toString());
            sb3.append(";");
            sb4.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "");
            sb4.append(";");
            StringBuilder sb23 = new StringBuilder();
            StringBuilder sb24 = sb4;
            sb23.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS));
            sb23.append("");
            sb5.append(sb23.toString());
            sb5.append(";");
            sb6.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s");
            sb6.append(";");
            sb7.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "");
            sb7.append(";");
            sb8.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "");
            sb8.append(";");
            sb9.append(next.getBundle().getString(TXLiveConstants.NET_STATUS_SERVER_IP));
            sb9.append(";");
            sb10.append(";");
            sb11.append(";");
            sb12.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_NET_JITTER) + "");
            sb12.append(";");
            StringBuilder sb25 = new StringBuilder();
            StringBuilder sb26 = sb9;
            sb25.append(next.getTimestamp());
            sb25.append("");
            sb13.append(sb25.toString());
            sb13.append(";");
            sb14.append(next.getBattery());
            sb14.append(";");
            StringBuilder sb27 = sb19;
            sb27.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "");
            sb27.append(";");
            StringBuilder sb28 = new StringBuilder();
            StringBuilder sb29 = sb26;
            sb28.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE));
            sb28.append("");
            StringBuilder sb30 = sb16;
            sb30.append(sb28.toString());
            sb30.append(";");
            StringBuilder sb31 = sb17;
            sb31.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP) + "");
            sb31.append(";");
            StringBuilder sb32 = sb18;
            sb32.append(next.getBundle().getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "");
            sb32.append(";");
            sb18 = sb32;
            sb10 = sb10;
            sb15 = sb27;
            sb2 = sb21;
            sb = sb22;
            sb4 = sb24;
            sb9 = sb29;
        }
        StringBuilder sb33 = sb9;
        return new StreamExceptionEvent.Builder().session_id(String.valueOf(i2)).start_time(Long.valueOf(j)).cpu(sb.toString()).cache_size(sb2.toString()).resolution(sb3.toString()).battery(sb14.toString()).speed(sb4.toString()).fps(sb5.toString()).gop(sb6.toString()).audio_rate(sb7.toString()).video_rate(sb8.toString()).drop_cnt(sb10.toString()).drop_size(sb11.toString()).jitter(sb12.toString()).net_time(sb13.toString()).video_cache(sb15.toString()).audio_cache(sb16.toString()).video_drop(sb17.toString()).audio_drop(sb18.toString()).multi_cdn(Boolean.valueOf(sZTrackingSettings.isMultiCdn())).video_url(sZTrackingSettings.getVideoUrl()).stream_evt(str).server_ip(sb33.toString()).is_host(false).tx_sdk_version(str2).room_id(String.valueOf(i)).build();
    }

    private String getSystemCpuUsage(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(Constants.URL_PATH_DELIMITER);
        if (indexOf < 0) {
            indexOf = str.indexOf("|");
        }
        if (indexOf < 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("%");
        if (lastIndexOf > indexOf) {
            return str.substring(indexOf + 1, lastIndexOf);
        }
        return "";
    }

    public static class BundleRecord {
        private String battery;
        private Bundle bundle;
        private long timestamp;

        public BundleRecord(Bundle bundle2, long j, String str) {
            this.bundle = bundle2;
            this.timestamp = j;
            this.battery = str;
        }

        public Bundle getBundle() {
            return this.bundle;
        }

        public void setBundle(Bundle bundle2) {
            this.bundle = bundle2;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public String getBattery() {
            return this.battery;
        }

        public void setBattery(String str) {
            this.battery = str;
        }
    }
}
