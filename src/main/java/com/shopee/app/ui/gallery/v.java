package com.shopee.app.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.facebook.internal.ServerProtocol;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.h.r;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.gallery.f;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.w;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends FrameLayout implements f.b {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f22018a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22019b;

    /* renamed from: c  reason: collision with root package name */
    c f22020c;

    /* renamed from: d  reason: collision with root package name */
    TextView f22021d;

    /* renamed from: e  reason: collision with root package name */
    TextView f22022e;

    /* renamed from: f  reason: collision with root package name */
    bc f22023f;

    /* renamed from: g  reason: collision with root package name */
    q f22024g;
    ak h;
    a i;
    Activity j;
    bi k;
    UserInfo l;
    private f m;
    private final int n;
    private final String o;

    public v(Context context, int i2, String str) {
        super(context);
        this.n = i2;
        this.o = str;
        setId(R.id.view);
        ((m) ((x) context).b()).a(this);
        setBackgroundColor(Color.parseColor("#161719"));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22023f.a(this.f22024g);
        this.f22024g.a(this);
        boolean z = this.n == 1;
        this.f22018a.setHasFixedSize(true);
        this.f22018a.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f22018a.a((RecyclerView.h) new n(b.a.f7693d));
        this.m = new f(z, this.o);
        this.m.a((f.b) this);
        this.m.setHasStableIds(true);
        this.m.a((f.a) this.f22024g);
        this.f22018a.setAdapter(this.m);
        this.f22024g.a(this.n);
        this.f22020c.setAlbumSelectListener(this.f22024g);
        if (z) {
            this.f22021d.setVisibility(8);
        }
        this.f22022e.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_no_photos));
        b();
    }

    public void b() {
        int h2 = this.f22024g.h();
        a(h2);
        b(h2);
    }

    public void a(List<GalleryItemInfo> list) {
        if (!list.isEmpty()) {
            this.m.a(list);
            this.m.notifyDataSetChanged();
            this.f22022e.setVisibility(8);
        }
    }

    public void b(List<GalleryAlbumInfo> list) {
        this.f22020c.setData(list);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f22020c.d();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f22024g.e().size() > 0) {
            GalleryBrowserActivity_.a(getContext()).a((ArrayList<GalleryData>) new ArrayList(this.f22024g.f())).c(this.n).b(this.f22024g.h()).a(this.o).a(10092);
        }
    }

    public void setSelectedAlbum(String str) {
        this.f22019b.setText(str);
    }

    public void a(List<GalleryData> list, int i2, GalleryData galleryData) {
        if (galleryData.a()) {
            String a2 = w.a(this.o);
            if (!TextUtils.isEmpty(a2)) {
                r.a().a(a2);
                return;
            }
            return;
        }
        GalleryBrowserActivity_.a(getContext()).a((ArrayList<GalleryData>) new ArrayList(list)).a(this.f22024g.g()).c(this.n).b(this.f22024g.h()).a(galleryData).a(this.o).a(10092);
    }

    public void a(int i2) {
        this.k.a().f7526f.a();
    }

    public void b(int i2) {
        TextView textView = this.f22021d;
        textView.setText(i2 + Constants.URL_PATH_DELIMITER + this.n);
    }

    public void a(String str) {
        r.a().a(str);
    }

    public void c(List<GalleryData> list) {
        this.f22024g.a(list);
    }

    public void e() {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f22024g.e().iterator();
        while (it.hasNext()) {
            arrayList.add(Uri.fromFile(new File(it.next())).toString());
        }
        intent.putStringArrayListExtra("imageList", arrayList);
        this.j.setResult(-1, intent);
        this.j.finish();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putBundle(ServerProtocol.DIALOG_PARAM_STATE, this.f22024g.i());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f22024g.a(bundle.getBundle(ServerProtocol.DIALOG_PARAM_STATE));
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public int getCheckedCount() {
        return this.f22024g.h();
    }

    public List<String> getSelected() {
        return this.f22024g.e();
    }
}
