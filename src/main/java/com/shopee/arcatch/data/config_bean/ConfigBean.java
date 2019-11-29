package com.shopee.arcatch.data.config_bean;

public class ConfigBean {
    public AudioConfigBean audioConfigBean;
    public ImageConfigBean imageConfigBean;
    public ParamsConfigBean paramsConfigBean;
    public TextConfigBean textConfigBean;

    public String toString() {
        return "ConfigBean{textConfigBean=" + this.textConfigBean + ", imageConfigBean=" + this.imageConfigBean + ", audioConfigBean=" + this.audioConfigBean + ", paramsConfigBean=" + this.paramsConfigBean + '}';
    }
}
