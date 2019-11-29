package com.shopee.app.ui.image;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.a.b;
import com.google.a.c.a;
import com.shopee.app.web.WebRegister;
import java.util.ArrayList;
import java.util.List;

public abstract class d extends LinearLayout implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected b f22820a;

    /* renamed from: b  reason: collision with root package name */
    protected List<MediaData> f22821b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected int f22822c = -1;

    /* renamed from: d  reason: collision with root package name */
    private c f22823d;

    /* access modifiers changed from: protected */
    public abstract void a(Context context, int i);

    public abstract void a(View view, int i);

    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract b getViewAdapter();

    public d(Context context) {
        super(context);
        a(context);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        setMinimumHeight(b.a.f7696g * 8);
        this.f22823d = new c(context);
        this.f22823d.setEditable(false);
        this.f22820a = getViewAdapter();
        this.f22823d.setAdapter(this.f22820a);
        this.f22823d.setOnItemClickListener(this);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.addView(this.f22823d, new LinearLayout.LayoutParams(-1, -1));
        addView(horizontalScrollView, new LinearLayout.LayoutParams(-1, -1));
    }

    public void setEditable(boolean z) {
        this.f22823d.setEditable(z);
    }

    public void a(int i, int i2) {
        this.f22823d.a_(i, i2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("mPosition", this.f22822c);
        bundle.putString("map", WebRegister.GSON.b(this.f22821b, new a<List<MediaData>>() {
        }.getType()));
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f22821b = (List) WebRegister.GSON.a(bundle.getString("map"), new a<List<MediaData>>() {
            }.getType());
            this.f22822c = bundle.getInt("mPosition", -1);
            parcelable = bundle.getParcelable("superState");
            a();
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Context context = getContext();
        if (!b(context)) {
            return;
        }
        if (i == this.f22820a.b() - 1 && this.f22821b.size() != this.f22820a.c()) {
            b();
        } else if (this.f22823d.d()) {
            a(view, i);
        } else {
            a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f22823d.c();
    }

    private boolean b(Context context) {
        return context != null && (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    public ArrayList<MediaData> getImages() {
        return new ArrayList<>(this.f22821b);
    }

    public int getImagesCount() {
        return this.f22821b.size() - getVideoPaths().size();
    }

    public ArrayList<String> getImagePaths() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (MediaData next : this.f22821b) {
            arrayList.add(next.isVideo() ? next.getThumb() : next.getPath());
        }
        return arrayList;
    }

    public ArrayList<String> getVideoPaths() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (MediaData next : this.f22821b) {
            if (next.isVideo()) {
                arrayList.add(next.getPath());
            }
        }
        return arrayList;
    }
}
