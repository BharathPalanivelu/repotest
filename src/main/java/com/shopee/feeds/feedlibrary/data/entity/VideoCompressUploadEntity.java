package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class VideoCompressUploadEntity implements Serializable {
    private float compression_cost_time;
    private String feed_id;
    private int hit_bitrate;
    private int hit_duration;
    private int video_duration;
    private int video_max_width;
    private int video_original_file_size;
    private String video_original_resolution;
    private int video_output_file_size;
    private String video_output_resolution;
    private String video_url;

    public String getFeed_id() {
        String str = this.feed_id;
        return str == null ? "" : str;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public String getVideo_original_resolution() {
        String str = this.video_original_resolution;
        return str == null ? "" : str;
    }

    public void setVideo_original_resolution(String str) {
        this.video_original_resolution = str;
    }

    public int getVideo_duration() {
        return this.video_duration;
    }

    public void setVideo_duration(int i) {
        this.video_duration = i;
    }

    public int getVideo_original_file_size() {
        return this.video_original_file_size;
    }

    public void setVideo_original_file_size(int i) {
        this.video_original_file_size = i;
    }

    public int getVideo_max_width() {
        return this.video_max_width;
    }

    public void setVideo_max_width(int i) {
        this.video_max_width = i;
    }

    public int getHit_duration() {
        return this.hit_duration;
    }

    public void setHit_duration(int i) {
        this.hit_duration = i;
    }

    public int getHit_bitrate() {
        return this.hit_bitrate;
    }

    public void setHit_bitrate(int i) {
        this.hit_bitrate = i;
    }

    public float getCompression_cost_time() {
        return this.compression_cost_time;
    }

    public void setCompression_cost_time(float f2) {
        this.compression_cost_time = f2;
    }

    public String getVideo_output_resolution() {
        String str = this.video_output_resolution;
        return str == null ? "" : str;
    }

    public void setVideo_output_resolution(String str) {
        this.video_output_resolution = str;
    }

    public int getVideo_output_file_size() {
        return this.video_output_file_size;
    }

    public void setVideo_output_file_size(int i) {
        this.video_output_file_size = i;
    }

    public String getVideo_url() {
        String str = this.video_url;
        return str == null ? "" : str;
    }

    public void setVideo_url(String str) {
        this.video_url = str;
    }
}
