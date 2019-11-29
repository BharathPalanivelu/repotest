package com.garena.rnrecyclerview.library.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.garena.rnrecyclerview.library.c.d;
import java.util.HashMap;
import java.util.Map;

public class a extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Integer> f8651b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    final EventDispatcher f8652a;

    /* renamed from: c  reason: collision with root package name */
    private int f8653c = 99;

    /* renamed from: d  reason: collision with root package name */
    private String f8654d;

    /* renamed from: e  reason: collision with root package name */
    private int f8655e;

    /* renamed from: f  reason: collision with root package name */
    private String f8656f;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public a(Context context) {
        super(context);
        setClickable(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
        this.f8652a = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size2 == 0) {
            size2 = getExpectedHeight();
        }
        if (size2 != this.f8653c) {
            this.f8653c = size2;
            f8651b.put(this.f8654d, Integer.valueOf(this.f8653c));
        }
        setMeasuredDimension(size, size2);
    }

    public int getExpectedHeight() {
        int i = this.f8653c;
        return (i != 99 || f8651b.get(this.f8654d) == null) ? i : f8651b.get(this.f8654d).intValue();
    }

    public int getInnerRowId() {
        return this.f8655e;
    }

    public void a(int i, String str, String str2) {
        this.f8655e = i;
        this.f8656f = str2;
        this.f8652a.dispatchEvent(d.a(getId(), this.f8655e, str, this.f8654d, this.f8656f));
    }

    public void setViewType(String str) {
        this.f8654d = str;
    }

    public String getViewType() {
        return this.f8654d;
    }
}
