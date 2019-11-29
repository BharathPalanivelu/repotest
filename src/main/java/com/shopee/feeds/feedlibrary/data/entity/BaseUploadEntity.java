package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class BaseUploadEntity implements Serializable {
    public static final int SOURCE_INS = 2;
    public static final int SOURCE_SKU = 1;
    public static final int SOURCE_UPLOAD = 0;
    public static final String TYPE_COMMENT_STICKER = "5";
    public static final String TYPE_INPUT_TEXT = "7";
    public static final String TYPE_MENTION_STICKER = "3";
    public static final String TYPE_PRODUCT_TAG = "1";
    public static final String TYPE_RATE_STICKER = "8";
    public static final String TYPE_SUBSCRIPT_STICKER = "4";
    public static final String TYPE_USER_TAG = "2";
    public static final String TYPE_VOUCHER_STICKER = "6";

    public class Sticker implements Serializable {
        private String cmt_id;
        private String comment;
        private float fix_scale;
        private String id;
        private float pos_x;
        private float pos_y;
        private String promotion_id;
        private String question;
        private int rotate;
        private float scale;
        private String signature;
        private int user_id;
        private String voucher_code;
        private int voucher_count;

        public Sticker() {
        }

        public float getFix_scale() {
            return this.fix_scale;
        }

        public void setFix_scale(float f2) {
            this.fix_scale = f2;
        }

        public String getCmt_id() {
            String str = this.cmt_id;
            return str == null ? "" : str;
        }

        public void setCmt_id(String str) {
            this.cmt_id = str;
        }

        public String getComment() {
            String str = this.comment;
            return str == null ? "" : str;
        }

        public void setComment(String str) {
            this.comment = str;
        }

        public String getSignature() {
            String str = this.signature;
            return str == null ? "" : str;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public String getId() {
            String str = this.id;
            return str == null ? "" : str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getQuestion() {
            String str = this.question;
            return str == null ? "" : str;
        }

        public void setQuestion(String str) {
            this.question = str;
        }

        public int getVoucher_count() {
            return this.voucher_count;
        }

        public void setVoucher_count(int i) {
            this.voucher_count = i;
        }

        public String getPromotion_id() {
            String str = this.promotion_id;
            return str == null ? "" : str;
        }

        public void setPromotion_id(String str) {
            this.promotion_id = str;
        }

        public String getVoucher_code() {
            String str = this.voucher_code;
            return str == null ? "" : str;
        }

        public void setVoucher_code(String str) {
            this.voucher_code = str;
        }

        public int getUser_id() {
            return this.user_id;
        }

        public void setUser_id(int i) {
            this.user_id = i;
        }

        public float getPos_x() {
            return this.pos_x;
        }

        public void setPos_x(float f2) {
            this.pos_x = f2;
        }

        public float getPos_y() {
            return this.pos_y;
        }

        public void setPos_y(float f2) {
            this.pos_y = f2;
        }

        public int getRotate() {
            return this.rotate;
        }

        public void setRotate(int i) {
            this.rotate = i;
        }

        public float getScale() {
            return this.scale;
        }

        public void setScale(float f2) {
            this.scale = f2;
        }
    }

    public class Text implements Serializable {
        private String background_color;
        private String content;
        private float fix_scale;
        private String font_color;
        private int font_size;
        private float pos_x;
        private float pos_y;
        private int rotate;
        private float scale;

        public Text() {
        }

        public float getFix_scale() {
            return this.fix_scale;
        }

        public void setFix_scale(float f2) {
            this.fix_scale = f2;
        }

        public String getContent() {
            String str = this.content;
            return str == null ? "" : str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getBackground_color() {
            String str = this.background_color;
            return str == null ? "" : str;
        }

        public void setBackground_color(String str) {
            this.background_color = str;
        }

        public String getFont_color() {
            String str = this.font_color;
            return str == null ? "" : str;
        }

        public void setFont_color(String str) {
            this.font_color = str;
        }

        public float getPos_x() {
            return this.pos_x;
        }

        public void setPos_x(float f2) {
            this.pos_x = f2;
        }

        public float getPos_y() {
            return this.pos_y;
        }

        public void setPos_y(float f2) {
            this.pos_y = f2;
        }

        public int getFont_size() {
            return this.font_size;
        }

        public void setFont_size(int i) {
            this.font_size = i;
        }

        public int getRotate() {
            return this.rotate;
        }

        public void setRotate(int i) {
            this.rotate = i;
        }

        public float getScale() {
            return this.scale;
        }

        public void setScale(float f2) {
            this.scale = f2;
        }
    }

    public class ImageTag implements Serializable {
        private String item_id;
        private float pos_x;
        private float pos_y;
        private int shop_id;

        public ImageTag() {
        }

        public String getItem_id() {
            String str = this.item_id;
            return str == null ? "" : str;
        }

        public void setItem_id(String str) {
            this.item_id = str;
        }

        public int getShop_id() {
            return this.shop_id;
        }

        public void setShop_id(int i) {
            this.shop_id = i;
        }

        public float getPos_x() {
            return this.pos_x;
        }

        public void setPos_x(float f2) {
            this.pos_x = f2;
        }

        public float getPos_y() {
            return this.pos_y;
        }

        public void setPos_y(float f2) {
            this.pos_y = f2;
        }
    }

    public class UserTag implements Serializable {
        private float pos_x;
        private float pos_y;
        private int user_id;

        public UserTag() {
        }

        public int getUser_id() {
            return this.user_id;
        }

        public void setUser_id(int i) {
            this.user_id = i;
        }

        public float getPos_x() {
            return this.pos_x;
        }

        public void setPos_x(float f2) {
            this.pos_x = f2;
        }

        public float getPos_y() {
            return this.pos_y;
        }

        public void setPos_y(float f2) {
            this.pos_y = f2;
        }
    }
}
