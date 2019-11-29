package com.shopee.app.data.viewmodel;

import android.text.TextUtils;
import com.shopee.app.application.ar;
import com.shopee.app.util.af;
import java.util.Arrays;
import java.util.List;

public class VMItemAttribute {
    private int attrId;
    private int attrType;
    private String country;
    private int ctime;
    private String displayName;
    private byte[] extinfo;
    private int inputType;
    private boolean mallMandatory;
    private int mandatory;
    private int modelId;
    private int mtime;
    private String name;
    private String placeHolder;
    private byte[] signature;
    private int status;
    private List<String> subAttributes;
    private String toolTip;
    private int validateType;

    public final int getAttrId() {
        return this.attrId;
    }

    public void setAttrId(int i) {
        this.attrId = i;
    }

    public final String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public final int getInputType() {
        return this.inputType;
    }

    public void setInputType(int i) {
        this.inputType = i;
    }

    public final int getAttrType() {
        return this.attrType;
    }

    public void setAttrType(int i) {
        this.attrType = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public final int getValidateType() {
        return this.validateType;
    }

    public void setValidateType(int i) {
        this.validateType = i;
    }

    public final byte[] getExtinfo() {
        return this.extinfo;
    }

    public void setExtinfo(byte[] bArr) {
        this.extinfo = bArr;
    }

    public final boolean isMandatory() {
        if (ar.f().e().loggedInUser().isMall()) {
            return this.mallMandatory;
        }
        return this.mandatory == 1;
    }

    public void setMandatory(int i) {
        this.mandatory = i;
    }

    public final String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public final int getCtime() {
        return this.ctime;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public final int getMtime() {
        return this.mtime;
    }

    public void setMtime(int i) {
        this.mtime = i;
    }

    public final String getDisplayName() {
        return TextUtils.isEmpty(this.displayName) ? getName() : this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setSubAttributes(List<String> list) {
        this.subAttributes = list;
    }

    public List<String> getSubAttributes() {
        return this.subAttributes;
    }

    public String toString() {
        return "VMItemAttribute{attrId=" + this.attrId + ", name='" + this.name + '\'' + ", inputType=" + this.inputType + ", attrType=" + this.attrType + ", status=" + this.status + ", validateType=" + this.validateType + ", extinfo=" + Arrays.toString(this.extinfo) + ", mandatory=" + this.mandatory + ", country='" + this.country + '\'' + ", ctime=" + this.ctime + ", mtime=" + this.mtime + ", displayName='" + this.displayName + '\'' + ", subAttributes=" + this.subAttributes + '}';
    }

    public boolean hasSelfDefine() {
        int i = this.inputType;
        return i == 3 || i == 2;
    }

    public boolean hasSubAttributes() {
        return !af.a(this.subAttributes);
    }

    public void setSignature(byte[] bArr) {
        this.signature = bArr;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public void setModelId(int i) {
        this.modelId = i;
    }

    public int getModelId() {
        return this.modelId;
    }

    public boolean isSelfDefined() {
        return this.inputType == 2;
    }

    public boolean isTimestampType() {
        return this.validateType == 6;
    }

    public boolean isKnowType() {
        int i = this.validateType;
        return i >= 1 && i <= 6 && i != 5;
    }

    public void setToolTip(String str) {
        this.toolTip = str;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public void setPlaceHolder(String str) {
        this.placeHolder = str;
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public void setMallMandatory(boolean z) {
        this.mallMandatory = z;
    }
}
