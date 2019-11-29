package com.shopee.arcatch.data.config_bean;

public class AudioConfigBean {
    public static final String URL = "https://deo.shopeemobile.com/shopee/mkt/arcatch/audio/";
    public String bombCaughtVoice;
    public String countDownVoice;
    public String gamePageBGM;
    public String normalPropCaughtVoice;
    public String timesUpVoice;

    public String toString() {
        return "AudioConfigBean{gamePageBGM='" + this.gamePageBGM + '\'' + ", countDownVoice='" + this.countDownVoice + '\'' + ", normalPropCaughtVoice='" + this.normalPropCaughtVoice + '\'' + ", bombCaughtVoice='" + this.bombCaughtVoice + '\'' + ", timesUpVoice='" + this.timesUpVoice + '\'' + '}';
    }
}
