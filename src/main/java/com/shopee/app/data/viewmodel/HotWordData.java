package com.shopee.app.data.viewmodel;

public final class HotWordData {
    private final String algorithm_info;
    private final String conceptid;
    private final String data_type;
    private final String image;
    private final String recommendation_algorithm;
    private final String text;

    public HotWordData(String str, String str2, String str3, String str4, String str5, String str6) {
        this.algorithm_info = str;
        this.recommendation_algorithm = str2;
        this.conceptid = str3;
        this.text = str4;
        this.image = str5;
        this.data_type = str6;
    }

    public final String getAlgorithm_info() {
        return this.algorithm_info;
    }

    public final String getRecommendation_algorithm() {
        return this.recommendation_algorithm;
    }

    public final String getConceptid() {
        return this.conceptid;
    }

    public final String getText() {
        return this.text;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getData_type() {
        return this.data_type;
    }
}
