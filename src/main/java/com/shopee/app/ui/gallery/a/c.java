package com.shopee.app.ui.gallery.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.h.r;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.gallery.GalleryData;
import com.shopee.app.ui.gallery.f;
import com.shopee.app.ui.gallery.m;
import com.shopee.app.ui.gallery.n;
import com.shopee.app.ui.video.VideoViewerActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class c extends FrameLayout implements f.b {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f21856a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21857b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.ui.gallery.c f21858c;

    /* renamed from: d  reason: collision with root package name */
    TextView f21859d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21860e;

    /* renamed from: f  reason: collision with root package name */
    bc f21861f;

    /* renamed from: g  reason: collision with root package name */
    a f21862g;
    ak h;
    a i;
    Activity j;
    bi k;
    UserInfo l;
    f m;
    /* access modifiers changed from: private */
    public int n;

    public c(Context context, int i2) {
        super(context);
        this.n = i2;
        ((m) ((x) context).b()).a(this);
        setBackgroundColor(Color.parseColor("#161719"));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21861f.a(this.f21862g);
        this.f21862g.a(this);
        this.f21856a.setHasFixedSize(true);
        this.f21856a.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f21856a.a((RecyclerView.h) new n(b.a.f7693d));
        this.m = new f(false, "");
        this.m.a((f.b) this);
        this.m.setHasStableIds(true);
        this.m.a((f.a) this.f21862g);
        this.f21856a.setAdapter(this.m);
        this.f21862g.a(this.n);
        this.f21858c.setAlbumSelectListener(this.f21862g);
        this.f21860e.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_no_videos));
        b(0);
    }

    public void a(List<GalleryItemInfo> list) {
        if (!list.isEmpty()) {
            this.m.a(list);
            this.m.notifyDataSetChanged();
            this.f21860e.setVisibility(8);
        }
    }

    public void setSelectedAlbum(String str) {
        this.f21857b.setText(str);
    }

    public void b(List<GalleryAlbumInfo> list) {
        this.f21858c.setData(list);
    }

    public void a(int i2) {
        this.k.a().f7526f.a();
    }

    public void b(int i2) {
        TextView textView = this.f21859d;
        textView.setText(i2 + Constants.URL_PATH_DELIMITER + this.n);
    }

    public void a(String str) {
        r.a().a(str);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f21858c.d();
    }

    public void a(List list, int i2, GalleryData galleryData) {
        VideoViewerActivity_.a(getContext()).a(this.m.a(i2).getPath()).a();
    }

    public int getCheckedCount() {
        return this.f21862g.f();
    }

    public List<String> getSelected() {
        return this.f21862g.e();
    }

    public void a(final GalleryItemInfo galleryItemInfo) {
        com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_video_gallery_replace_text, (int) R.string.sp_label_cancel, (int) R.string.sp_label_replace, (f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                fVar.dismiss();
                int unused = c.this.n = 1;
                c.this.f21862g.a(galleryItemInfo, c.this.n);
            }
        }, false);
    }
}
