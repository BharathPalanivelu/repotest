package com.tencent.qalsdk;

import android.content.Context;

public class QALOffLineMsg {
    private String cmd = null;
    private Context context = null;
    private String identifer = null;
    private byte[] msgBody = null;

    public String getID() {
        return this.identifer;
    }

    public void setID(String str) {
        this.identifer = str;
    }

    public String getCmd() {
        return this.cmd;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public byte[] getBody() {
        return this.msgBody;
    }

    public void setBody(byte[] bArr) {
        this.msgBody = bArr;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }
}
