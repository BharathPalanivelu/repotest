package com.shopee.live.livestreaming.sztracking.config;

import com.shopee.sdk.b.a;
import java.io.Serializable;

public class SZTrackingConfigEntity extends a implements Serializable {
    private int black_screen_detect_time_for_first_time_connect;
    private int black_screen_detect_time_for_reconnect;
    private int db_event_table_max_records;
    private int db_event_table_remain_records;
    private int low_fps;
    private int low_fps_report_interval;
    private int network_request_timeout;
    private int sei_timestamp_send_interval_base_on_netstatus_count;
    private int send_interval;
    private int send_limit_size;
    private int sg_viewer_heartbeat_interval;
    private int sz_viewer_heartbeat_interval;

    public SZTrackingConfigEntity() {
        setDb_event_table_max_records(1000);
        setDb_event_table_remain_records(500);
        setNetwork_request_timeout(30);
        setSend_interval(10);
        setSend_limit_size(50);
        setLow_fps(10);
        setLow_fps_report_interval(10);
        setBlack_screen_detect_time_for_first_time_connect(10);
        setBlack_screen_detect_time_for_reconnect(10);
        setSei_timestamp_send_interval_base_on_netstatus_count(15);
        setSz_viewer_heartbeat_interval(30);
        setSg_viewer_heartbeat_interval(5);
    }

    public int getDb_event_table_max_records() {
        return this.db_event_table_max_records;
    }

    public void setDb_event_table_max_records(int i) {
        this.db_event_table_max_records = i;
    }

    public int getDb_event_table_remain_records() {
        return this.db_event_table_remain_records;
    }

    public void setDb_event_table_remain_records(int i) {
        this.db_event_table_remain_records = i;
    }

    public int getNetwork_request_timeout() {
        return this.network_request_timeout;
    }

    public void setNetwork_request_timeout(int i) {
        this.network_request_timeout = i;
    }

    public int getSend_interval() {
        return this.send_interval;
    }

    public void setSend_interval(int i) {
        this.send_interval = i;
    }

    public int getSend_limit_size() {
        return this.send_limit_size;
    }

    public void setSend_limit_size(int i) {
        this.send_limit_size = i;
    }

    public int getLow_fps() {
        return this.low_fps;
    }

    public void setLow_fps(int i) {
        this.low_fps = i;
    }

    public int getLow_fps_report_interval() {
        return this.low_fps_report_interval;
    }

    public void setLow_fps_report_interval(int i) {
        this.low_fps_report_interval = i;
    }

    public int getBlack_screen_detect_time_for_first_time_connect() {
        return this.black_screen_detect_time_for_first_time_connect;
    }

    public void setBlack_screen_detect_time_for_first_time_connect(int i) {
        this.black_screen_detect_time_for_first_time_connect = i;
    }

    public int getBlack_screen_detect_time_for_reconnect() {
        return this.black_screen_detect_time_for_reconnect;
    }

    public void setBlack_screen_detect_time_for_reconnect(int i) {
        this.black_screen_detect_time_for_reconnect = i;
    }

    public int getSei_timestamp_send_interval_base_on_netstatus_count() {
        return this.sei_timestamp_send_interval_base_on_netstatus_count;
    }

    public void setSei_timestamp_send_interval_base_on_netstatus_count(int i) {
        this.sei_timestamp_send_interval_base_on_netstatus_count = i;
    }

    public int getSz_viewer_heartbeat_interval() {
        return this.sz_viewer_heartbeat_interval;
    }

    public void setSz_viewer_heartbeat_interval(int i) {
        this.sz_viewer_heartbeat_interval = i;
    }

    public int getSg_viewer_heartbeat_interval() {
        return this.sg_viewer_heartbeat_interval;
    }

    public void setSg_viewer_heartbeat_interval(int i) {
        this.sg_viewer_heartbeat_interval = i;
    }

    public boolean isAvailable() {
        return this.db_event_table_max_records > 0 && this.db_event_table_remain_records > 0 && this.network_request_timeout > 0 && this.send_interval > 0 && this.send_limit_size > 0;
    }
}
