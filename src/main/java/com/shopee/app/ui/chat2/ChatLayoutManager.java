package com.shopee.app.ui.chat2;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChatLayoutManager extends LinearLayoutManager {
    public boolean c() {
        return false;
    }

    public ChatLayoutManager(Context context) {
        super(context);
    }

    public ChatLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public int b(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        try {
            return super.b(i, pVar, tVar);
        } catch (Exception unused) {
            return 0;
        }
    }
}
