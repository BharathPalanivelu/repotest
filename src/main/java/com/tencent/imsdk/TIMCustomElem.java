package com.tencent.imsdk;

public class TIMCustomElem extends TIMElem {
    byte[] data;
    private String desc;
    byte[] ext;
    byte[] sound;

    public TIMCustomElem() {
        this.type = TIMElemType.Custom;
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        return bArr == null ? "".getBytes() : bArr;
    }

    public String getDesc() {
        String str = this.desc;
        return str == null ? "" : str;
    }

    public byte[] getExt() {
        byte[] bArr = this.ext;
        return bArr == null ? "".getBytes() : bArr;
    }

    public byte[] getSound() {
        byte[] bArr = this.sound;
        return bArr == null ? "".getBytes() : bArr;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExt(byte[] bArr) {
        this.ext = bArr;
    }

    public void setSound(byte[] bArr) {
        this.sound = bArr;
    }
}
