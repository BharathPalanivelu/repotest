package com.shopee.arcatch.data.config_bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageConfigBean {
    public String bgmOffIcon;
    public String bgmOnIcon;
    public Map<String, String> bombImages = new HashMap();
    public Map<String, String> coinImages = new HashMap();
    public String coinsScoreBackground;
    public Map<String, String> cryEyesImages = new HashMap();
    public Map<String, String> explosionImages = new HashMap();
    public List<String> guideImageForNewUsers = new ArrayList();
    public String hatBackground;
    public String hatForeground;
    public String imageCover;
    public String imageVideoBorder;
    public String imageWaterMark;
    public String playTimeCountDownBackground;

    public String toString() {
        return "ImageConfigBean{guideImageForNewUsers=" + this.guideImageForNewUsers + ", imageCover='" + this.imageCover + '\'' + ", hatForeground='" + this.hatForeground + '\'' + ", hatBackground='" + this.hatBackground + '\'' + ", playTimeCountDownBackground='" + this.playTimeCountDownBackground + '\'' + ", coinsScoreBackground='" + this.coinsScoreBackground + '\'' + ", bgmOnIcon='" + this.bgmOnIcon + '\'' + ", bgmOffIcon='" + this.bgmOffIcon + '\'' + ", coinImages=" + this.coinImages + ", bombImages=" + this.bombImages + ", explosionImages=" + this.explosionImages + ", cryEyesImages=" + this.cryEyesImages + '}';
    }
}
