package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class HashTagEntity implements Serializable {
    ArrayList<HashTag> hashtags;

    public ArrayList<HashTag> getHashtags() {
        ArrayList<HashTag> arrayList = this.hashtags;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setHashtags(ArrayList<HashTag> arrayList) {
        this.hashtags = arrayList;
    }

    public class HashTag implements Serializable {
        private String cover;
        private long feed_cnt;
        private String id;
        private String text;

        public HashTag() {
        }

        public String getCover() {
            String str = this.cover;
            return str == null ? "" : str;
        }

        public void setCover(String str) {
            this.cover = str;
        }

        public String getId() {
            String str = this.id;
            return str == null ? "" : str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getText() {
            String str = this.text;
            return str == null ? "" : str;
        }

        public void setText(String str) {
            this.text = str;
        }

        public long getFeed_cnt() {
            return this.feed_cnt;
        }

        public void setFeed_cnt(long j) {
            this.feed_cnt = j;
        }
    }
}
