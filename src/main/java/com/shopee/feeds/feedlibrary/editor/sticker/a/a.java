package com.shopee.feeds.feedlibrary.editor.sticker.a;

public class a extends d {
    private String mBuyerName;
    private String mComments;
    private String mRatingId;
    private int mRatings = 0;

    public void b(String str) {
        this.mRatingId = str;
    }

    public String m() {
        return this.mRatingId;
    }

    public a() {
        super(5);
    }

    public void c(String str) {
        this.mBuyerName = str;
    }

    public String n() {
        return this.mBuyerName;
    }

    public void b(int i) {
        this.mRatings = i;
    }

    public int o() {
        return this.mRatings;
    }

    public void d(String str) {
        this.mComments = str;
    }

    public String p() {
        return this.mComments;
    }
}
