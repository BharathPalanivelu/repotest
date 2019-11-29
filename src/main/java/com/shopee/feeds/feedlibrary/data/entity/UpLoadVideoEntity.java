package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.data.entity.BaseUploadEntity;
import java.io.Serializable;
import java.util.ArrayList;

public class UpLoadVideoEntity extends BaseUploadEntity {
    private String app_version;
    private Content content;
    private String device_model;
    private String feed_id;
    private String system_os;
    private String system_version;

    public String getSystem_os() {
        String str = this.system_os;
        return str == null ? "" : str;
    }

    public void setSystem_os(String str) {
        this.system_os = str;
    }

    public String getApp_version() {
        String str = this.app_version;
        return str == null ? "" : str;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public String getDevice_model() {
        String str = this.device_model;
        return str == null ? "" : str;
    }

    public void setDevice_model(String str) {
        this.device_model = str;
    }

    public String getSystem_version() {
        String str = this.system_version;
        return str == null ? "" : str;
    }

    public void setSystem_version(String str) {
        this.system_version = str;
    }

    public String getFeed_id() {
        String str = this.feed_id;
        return str == null ? "" : str;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content2) {
        this.content = content2;
    }

    public class Content implements Serializable {
        private String caption;
        private String cover;
        private int duration;
        ArrayList<String> hashtags;
        private ArrayList<String> ins_urls;
        ArrayList<Integer> mentions;
        private Video video;
        private String video_url;

        public Content() {
        }

        public void setIns_urls(ArrayList<String> arrayList) {
            this.ins_urls = arrayList;
        }

        public ArrayList<String> getIns_urls() {
            return this.ins_urls;
        }

        public ArrayList<String> getHashtags() {
            ArrayList<String> arrayList = this.hashtags;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setHashtags(ArrayList<String> arrayList) {
            this.hashtags = arrayList;
        }

        public String getCaption() {
            String str = this.caption;
            return str == null ? "" : str;
        }

        public void setCaption(String str) {
            this.caption = str;
        }

        public ArrayList<Integer> getMentions() {
            ArrayList<Integer> arrayList = this.mentions;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setMentions(ArrayList<Integer> arrayList) {
            this.mentions = arrayList;
        }

        public String getVideo_url() {
            String str = this.video_url;
            return str == null ? "" : str;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public String getCover() {
            String str = this.cover;
            return str == null ? "" : str;
        }

        public void setCover(String str) {
            this.cover = str;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public Video getVideo() {
            return this.video;
        }

        public void setVideo(Video video2) {
            this.video = video2;
        }
    }

    public class Video implements Serializable {
        private ArrayList<BaseUploadEntity.Sticker> comment_stickers;
        private String display_hierarchy;
        private int height;
        private ArrayList<BaseUploadEntity.ImageTag> item_tags;
        private ArrayList<BaseUploadEntity.Sticker> mention_stickers;
        private ArrayList<BaseUploadEntity.Sticker> subscript_stickers;
        private ArrayList<BaseUploadEntity.Text> texts;
        private ArrayList<BaseUploadEntity.UserTag> user_tags;
        private ArrayList<BaseUploadEntity.Sticker> voucher_stickers;
        private int width;

        public Video() {
        }

        public int getWidth() {
            return this.width;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public ArrayList<BaseUploadEntity.ImageTag> getItem_tags() {
            ArrayList<BaseUploadEntity.ImageTag> arrayList = this.item_tags;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setItem_tags(ArrayList<BaseUploadEntity.ImageTag> arrayList) {
            this.item_tags = arrayList;
        }

        public ArrayList<BaseUploadEntity.UserTag> getUser_tags() {
            ArrayList<BaseUploadEntity.UserTag> arrayList = this.user_tags;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setUser_tags(ArrayList<BaseUploadEntity.UserTag> arrayList) {
            this.user_tags = arrayList;
        }

        public ArrayList<BaseUploadEntity.Sticker> getMention_stickers() {
            ArrayList<BaseUploadEntity.Sticker> arrayList = this.mention_stickers;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setMention_stickers(ArrayList<BaseUploadEntity.Sticker> arrayList) {
            this.mention_stickers = arrayList;
        }

        public ArrayList<BaseUploadEntity.Sticker> getSubscript_stickers() {
            ArrayList<BaseUploadEntity.Sticker> arrayList = this.subscript_stickers;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setSubscript_stickers(ArrayList<BaseUploadEntity.Sticker> arrayList) {
            this.subscript_stickers = arrayList;
        }

        public ArrayList<BaseUploadEntity.Sticker> getComment_stickers() {
            ArrayList<BaseUploadEntity.Sticker> arrayList = this.comment_stickers;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setComment_stickers(ArrayList<BaseUploadEntity.Sticker> arrayList) {
            this.comment_stickers = arrayList;
        }

        public ArrayList<BaseUploadEntity.Sticker> getVoucher_stickers() {
            ArrayList<BaseUploadEntity.Sticker> arrayList = this.voucher_stickers;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setVoucher_stickers(ArrayList<BaseUploadEntity.Sticker> arrayList) {
            this.voucher_stickers = arrayList;
        }

        public ArrayList<BaseUploadEntity.Text> getTexts() {
            ArrayList<BaseUploadEntity.Text> arrayList = this.texts;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setTexts(ArrayList<BaseUploadEntity.Text> arrayList) {
            this.texts = arrayList;
        }

        public String getDisplay_hierarchy() {
            String str = this.display_hierarchy;
            return str == null ? "" : str;
        }

        public void setDisplay_hierarchy(String str) {
            this.display_hierarchy = str;
        }
    }
}
