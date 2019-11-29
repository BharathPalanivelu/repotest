package com.tencent.liteav.basic.module;

public class a {
    private String mID = "";

    public void finalize() throws Throwable {
        clearID();
        super.finalize();
    }

    public void setID(String str) {
        clearID();
        synchronized (this) {
            if (str.length() != 0) {
                this.mID = str;
                TXCStatus.a(this.mID);
            }
        }
    }

    public void clearID() {
        synchronized (this) {
            if (this.mID.length() != 0) {
                TXCStatus.b(this.mID);
                this.mID = "";
            }
        }
    }

    public String getID() {
        return this.mID;
    }

    public boolean setStatusValue(int i, Object obj) {
        return TXCStatus.a(this.mID, i, obj);
    }

    public boolean setStatusValue(int i, int i2, Object obj) {
        return TXCStatus.a(this.mID, i, i2, obj);
    }

    public long getLongValue(int i) {
        return TXCStatus.a(this.mID, i);
    }

    public String getStringValue(int i) {
        return TXCStatus.b(this.mID, i);
    }

    public int getIntValue(int i) {
        return TXCStatus.c(this.mID, i);
    }

    public double getDoubleValue(int i) {
        return TXCStatus.d(this.mID, i);
    }

    public String getStringValue(int i, int i2) {
        return TXCStatus.b(this.mID, i, i2);
    }

    public int getIntValue(int i, int i2) {
        return TXCStatus.c(this.mID, i, i2);
    }

    public long getLongValue(int i, int i2) {
        return TXCStatus.a(this.mID, i, i2);
    }

    public double getDoubleValue(int i, int i2) {
        return TXCStatus.d(this.mID, i, i2);
    }
}
