package com.shopee.live.livestreaming.data.entity;

import android.text.TextUtils;
import com.shopee.sdk.b.a;

public class LiveAdDataEntity extends a {
    private AdSpot ad_spot;
    private int refresh_interval;

    public AdSpot getAd_spot() {
        return this.ad_spot;
    }

    public void setAd_spot(AdSpot adSpot) {
        this.ad_spot = adSpot;
    }

    public int getRefresh_interval() {
        return this.refresh_interval;
    }

    public void setRefresh_interval(int i) {
        this.refresh_interval = i;
    }

    public static class AdSpot {
        private long ad_spot_id;
        private long end_time;
        private String link_url;
        private String operator;
        private String pic;
        private long start_time;
        private int status;
        private String title;

        public long getAd_spot_id() {
            return this.ad_spot_id;
        }

        public void setAd_spot_id(long j) {
            this.ad_spot_id = j;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getPic() {
            return this.pic;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public String getLink_url() {
            return this.link_url;
        }

        public void setLink_url(String str) {
            this.link_url = str;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
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

        public String getOperator() {
            return this.operator;
        }

        public void setOperator(String str) {
            this.operator = str;
        }
    }

    public boolean isCurrentAvailable() {
        AdSpot ad_spot2 = getAd_spot();
        if (ad_spot2 == null) {
            return false;
        }
        String pic = ad_spot2.getPic();
        String link_url = ad_spot2.getLink_url();
        long start_time = ad_spot2.getStart_time();
        long end_time = ad_spot2.getEnd_time();
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(pic) || TextUtils.isEmpty(link_url) || currentTimeMillis < start_time || currentTimeMillis > end_time) {
            return false;
        }
        return true;
    }
}
