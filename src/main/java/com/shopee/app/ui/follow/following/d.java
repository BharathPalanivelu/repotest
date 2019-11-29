package com.shopee.app.ui.follow.following;

import com.shopee.app.ui.a.aa;

public class d extends aa<t> {
    public d(e eVar) {
        super(eVar);
    }

    public void a(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (((t) getItem(i2)).b() == i) {
                ((t) getItem(i2)).a(true);
                return;
            }
        }
    }

    public void b(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (((t) getItem(i2)).b() == i) {
                ((t) getItem(i2)).a(false);
                return;
            }
        }
    }
}
