package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class ImageCompressUploadParams implements Serializable {
    private int crop_file_size;
    private String crop_screen_resolution;
    private int default_compress_quality;
    private int default_file_size;
    private String default_screen_resolution;
    private String feed_id;
    private int final_compress_quality;
    private int final_file_size;
    private String final_resolution;
    private int from;
    private int hit_quality;
    private int hit_size;
    private String image_url;
    private int original_file_size;
    private String original_resolution;
    private String path;

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public String getDefault_screen_resolution() {
        String str = this.default_screen_resolution;
        return str == null ? "" : str;
    }

    public void setDefault_screen_resolution(String str) {
        this.default_screen_resolution = str;
    }

    public int getDefault_file_size() {
        return this.default_file_size;
    }

    public void setDefault_file_size(int i) {
        this.default_file_size = i;
    }

    public String getFeed_id() {
        String str = this.feed_id;
        return str == null ? "" : str;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public String getOriginal_resolution() {
        String str = this.original_resolution;
        return str == null ? "" : str;
    }

    public void setOriginal_resolution(String str) {
        this.original_resolution = str;
    }

    public int getOriginal_file_size() {
        return this.original_file_size;
    }

    public void setOriginal_file_size(int i) {
        this.original_file_size = i;
    }

    public String getCrop_screen_resolution() {
        String str = this.crop_screen_resolution;
        return str == null ? "" : str;
    }

    public void setCrop_screen_resolution(String str) {
        this.crop_screen_resolution = str;
    }

    public int getCrop_file_size() {
        return this.crop_file_size;
    }

    public void setCrop_file_size(int i) {
        this.crop_file_size = i;
    }

    public int getDefault_compress_quality() {
        return this.default_compress_quality;
    }

    public void setDefault_compress_quality(int i) {
        this.default_compress_quality = i;
    }

    public String getFinal_resolution() {
        String str = this.final_resolution;
        return str == null ? "" : str;
    }

    public void setFinal_resolution(String str) {
        this.final_resolution = str;
    }

    public int getFinal_file_size() {
        return this.final_file_size;
    }

    public void setFinal_file_size(int i) {
        this.final_file_size = i;
    }

    public int getFinal_compress_quality() {
        return this.final_compress_quality;
    }

    public void setFinal_compress_quality(int i) {
        this.final_compress_quality = i;
    }

    public String getImage_url() {
        String str = this.image_url;
        return str == null ? "" : str;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public int getHit_size() {
        return this.hit_size;
    }

    public void setHit_size(int i) {
        this.hit_size = i;
    }

    public int getHit_quality() {
        return this.hit_quality;
    }

    public void setHit_quality(int i) {
        this.hit_quality = i;
    }

    public String getPath() {
        String str = this.path;
        return str == null ? "" : str;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
