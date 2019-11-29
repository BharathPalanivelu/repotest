package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.d.a;

public class NPALinearLayoutManager extends LinearLayoutManager {
    public boolean c() {
        return false;
    }

    public NPALinearLayoutManager(Context context) {
        super(context);
    }

    public NPALinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public int b(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        try {
            return super.b(i, pVar, tVar);
        } catch (Exception e2) {
            a.a(e2);
            return 0;
        }
    }
}
