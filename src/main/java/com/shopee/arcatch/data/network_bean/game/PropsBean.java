package com.shopee.arcatch.data.network_bean.game;

import com.google.a.a.c;

public class PropsBean {
    @c(a = "bomb_eye_left")
    private String bombEyeLeft;
    @c(a = "bomb_eye_right")
    private String bombEyeRight;
    @c(a = "bomb_icon")
    private String bombIcon;
    @c(a = "falling_count")
    private int fallingCount;
    @c(a = "id")
    private String id;
    @c(a = "name")
    private String name;
    @c(a = "prop_icon")
    private String propIcon;
    @PropType
    @c(a = "prop_type")
    private int propType;
    @c(a = "prop_value")
    private float propValue;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @PropType
    public int getPropType() {
        return this.propType;
    }

    public void setPropType(@PropType int i) {
        this.propType = i;
    }

    public float getPropValue() {
        return this.propValue;
    }

    public void setPropValue(float f2) {
        this.propValue = f2;
    }

    public String getPropIcon() {
        return this.propIcon;
    }

    public void setPropIcon(String str) {
        this.propIcon = str;
    }

    public String getBombIcon() {
        return this.bombIcon;
    }

    public void setBombIcon(String str) {
        this.bombIcon = str;
    }

    public String getBombEyeLeft() {
        return this.bombEyeLeft;
    }

    public void setBombEyeLeft(String str) {
        this.bombEyeLeft = str;
    }

    public String getBombEyeRight() {
        return this.bombEyeRight;
    }

    public void setBombEyeRight(String str) {
        this.bombEyeRight = str;
    }

    public int getFallingCount() {
        return this.fallingCount;
    }

    public void setFallingCount(int i) {
        this.fallingCount = i;
    }

    public String toString() {
        return "PropsBean{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", propType=" + this.propType + ", propValue=" + this.propValue + ", propIcon='" + this.propIcon + '\'' + ", bombIcon='" + this.bombIcon + '\'' + ", bombEyeLeft='" + this.bombEyeLeft + '\'' + ", bombEyeRight='" + this.bombEyeRight + '\'' + ", fallingCount=" + this.fallingCount + '}';
    }
}
