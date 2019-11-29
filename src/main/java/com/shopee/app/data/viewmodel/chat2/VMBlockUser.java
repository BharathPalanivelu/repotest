package com.shopee.app.data.viewmodel.chat2;

import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;

public class VMBlockUser {
    private boolean blocked;
    private int userid;

    public final int getUserid() {
        return this.userid;
    }

    public void setUserid(int i) {
        this.userid = i;
    }

    public final boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked(boolean z) {
        this.blocked = z;
    }

    public static void map(DBBlockUser dBBlockUser, VMBlockUser vMBlockUser) {
        vMBlockUser.setUserid(dBBlockUser.a());
        vMBlockUser.setBlocked(dBBlockUser.b());
    }
}
