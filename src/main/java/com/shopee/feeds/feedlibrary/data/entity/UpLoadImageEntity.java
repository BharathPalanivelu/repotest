package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.data.entity.BaseUploadEntity;
import java.io.Serializable;
import java.util.ArrayList;

public class UpLoadImageEntity extends BaseUploadEntity {
    private String app_version;
    private PostContent content;
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

    public PostContent getContent() {
        return this.content;
    }

    public void setContent(PostContent postContent) {
        this.content = postContent;
    }

    public class PostContent implements Serializable {
        private String caption;
        private ArrayList<String> hashtags;
        private ArrayList<Image> images;
        private ArrayList<String> ins_urls;
        private ArrayList<Integer> mentions;

        public PostContent() {
        }

        public ArrayList<String> getIns_urls() {
            ArrayList<String> arrayList = this.ins_urls;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setIns_urls(ArrayList<String> arrayList) {
            this.ins_urls = arrayList;
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

        public ArrayList<String> getHashtags() {
            ArrayList<String> arrayList = this.hashtags;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setHashtags(ArrayList<String> arrayList) {
            this.hashtags = arrayList;
        }

        public ArrayList<Image> getImages() {
            ArrayList<Image> arrayList = this.images;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setImages(ArrayList<Image> arrayList) {
            this.images = arrayList;
        }
    }

    public class Image implements Serializable {
        private ArrayList<BaseUploadEntity.Sticker> comment_stickers;
        private String display_hierarchy;
        private int height;
        private ArrayList<BaseUploadEntity.ImageTag> item_tags;
        private String main_color;
        private ArrayList<BaseUploadEntity.Sticker> mention_stickers;
        private ArrayList<BaseUploadEntity.Sticker> rating_stickers;
        private int source;
        private ArrayList<BaseUploadEntity.Sticker> subscript_stickers;
        private ArrayList<BaseUploadEntity.Text> texts;
        private String url;
        private ArrayList<BaseUploadEntity.UserTag> user_tags;
        private ArrayList<BaseUploadEntity.Sticker> voucher_stickers;
        private int width;

        public Image() {
        }

        public String getMain_color() {
            String str = this.main_color;
            return str == null ? "" : str;
        }

        public void setMain_color(String str) {
            this.main_color = str;
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

        public String getDisplay_hierarchy() {
            String str = this.display_hierarchy;
            return str == null ? "" : str;
        }

        public void setDisplay_hierarchy(String str) {
            this.display_hierarchy = str;
        }

        public String getUrl() {
            String str = this.url;
            return str == null ? "" : str;
        }

        public void setUrl(String str) {
            this.url = str;
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

        public ArrayList<BaseUploadEntity.Sticker> getRating_stickers() {
            ArrayList<BaseUploadEntity.Sticker> arrayList = this.rating_stickers;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setRating_stickers(ArrayList<BaseUploadEntity.Sticker> arrayList) {
            this.rating_stickers = arrayList;
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

        public int getSource() {
            return this.source;
        }

        public void setSource(int i) {
            this.source = i;
        }
    }
}
