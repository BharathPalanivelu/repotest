package com.shopee.app.ui.follow.following.recommend;

import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.ui.a.aa;

public class o extends aa<DBContactInfo> {
    public o(p pVar) {
        super(pVar);
    }

    public boolean a() {
        for (int i = 0; i < getCount(); i++) {
            if (!((DBContactInfo) getItem(i)).f() && ((DBContactInfo) getItem(i)).g() == 2) {
                return false;
            }
        }
        return true;
    }

    public void a(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (((DBContactInfo) getItem(i2)).d() == i) {
                ((DBContactInfo) getItem(i2)).a(true);
                return;
            }
        }
    }

    public void b() {
        for (int i = 0; i < getCount(); i++) {
            ((DBContactInfo) getItem(i)).a(true);
        }
    }

    public void b(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (((DBContactInfo) getItem(i2)).d() == i) {
                ((DBContactInfo) getItem(i2)).a(false);
                return;
            }
        }
    }
}
