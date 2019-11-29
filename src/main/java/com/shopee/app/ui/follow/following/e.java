package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.a.s;

public class e implements s<t> {
    public int a() {
        return 5;
    }

    public int a(t tVar, int i) {
        return tVar.j();
    }

    public View a(Context context, int i) {
        if (i == 0) {
            return b.a(context);
        }
        if (i == 1) {
            return z.a(context);
        }
        if (i == 2) {
            return v.a(context);
        }
        if (i == 3) {
            return s.a(context);
        }
        if (i != 4) {
            return null;
        }
        return q.a(context);
    }
}
