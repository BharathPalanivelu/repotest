package com.shopee.app.data.viewmodel;

public final class CuratedHint {
    private final String image;
    private final String name;
    private int order;
    private final String tag_name_1;
    private final String tag_name_2;
    private final String tag_url_1;
    private final String tag_url_2;
    private final String url;

    public CuratedHint(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.name = str;
        this.url = str2;
        this.image = str3;
        this.tag_name_1 = str4;
        this.tag_url_1 = str5;
        this.tag_name_2 = str6;
        this.tag_url_2 = str7;
        this.order = i;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTag_name_1() {
        return this.tag_name_1;
    }

    public final String getTag_url_1() {
        return this.tag_url_1;
    }

    public final String getTag_name_2() {
        return this.tag_name_2;
    }

    public final String getTag_url_2() {
        return this.tag_url_2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CuratedHint(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, g gVar) {
        this(str, str2, str3, str4, str5, str6, str7, (i2 & 128) != 0 ? 0 : i);
    }

    public final int getOrder() {
        return this.order;
    }

    public final void setOrder(int i) {
        this.order = i;
    }
}
