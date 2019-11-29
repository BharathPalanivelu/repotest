package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class ReplayRecordEntity extends a {
    private ReplayInfoBean replay_info;

    public ReplayInfoBean getReplay_info() {
        return this.replay_info;
    }

    public void setReplay_info(ReplayInfoBean replayInfoBean) {
        this.replay_info = replayInfoBean;
    }

    public static class ReplayInfoBean {
        private long end_time;
        private String file_format;
        private int record_id;
        private String record_url;
        private int session_id;
        private long start_time;
        private int uid;
        private String username;
        private long view_count;

        public int getRecord_id() {
            return this.record_id;
        }

        public void setRecord_id(int i) {
            this.record_id = i;
        }

        public int getSession_id() {
            return this.session_id;
        }

        public void setSession_id(int i) {
            this.session_id = i;
        }

        public int getUid() {
            return this.uid;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public String getRecord_url() {
            return this.record_url;
        }

        public void setRecord_url(String str) {
            this.record_url = str;
        }

        public String getFile_format() {
            return this.file_format;
        }

        public void setFile_format(String str) {
            this.file_format = str;
        }

        public long getStart_time() {
            return this.start_time;
        }

        public void setStart_time(long j) {
            this.start_time = j;
        }

        public long getEnd_time() {
            return this.end_time;
        }

        public void setEnd_time(long j) {
            this.end_time = j;
        }

        public long getView_count() {
            return this.view_count;
        }

        public void setView_count(long j) {
            this.view_count = j;
        }
    }
}
