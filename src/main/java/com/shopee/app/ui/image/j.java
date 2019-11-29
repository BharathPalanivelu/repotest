package com.shopee.app.ui.image;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.shopee.app.application.ar;
import com.shopee.app.ui.image.indicator.PageIndicatorView;
import com.shopee.app.ui.video.VideoViewerView;
import com.shopee.app.util.aa;
import com.shopee.app.util.af;
import com.shopee.app.util.bc;
import com.shopee.app.util.bj;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.ab;
import com.squareup.a.w;
import com.squareup.a.z;
import java.io.IOException;
import java.util.List;

public class j extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static List<MediaData> f23021a;
    /* access modifiers changed from: private */
    public static CharSequence[] s = new CharSequence[1];

    /* renamed from: b  reason: collision with root package name */
    GImageBrowserView f23022b;

    /* renamed from: c  reason: collision with root package name */
    ImageButton f23023c;

    /* renamed from: d  reason: collision with root package name */
    PageIndicatorView f23024d;

    /* renamed from: e  reason: collision with root package name */
    int f23025e;

    /* renamed from: f  reason: collision with root package name */
    int f23026f;

    /* renamed from: g  reason: collision with root package name */
    Activity f23027g;
    i h;
    bc i;
    com.shopee.app.tracking.trackingv3.b j;
    /* access modifiers changed from: private */
    public final List<MediaData> k;
    /* access modifiers changed from: private */
    public final boolean l;
    private int m;
    /* access modifiers changed from: private */
    public final com.shopee.app.ui.image.a.a n;
    /* access modifiers changed from: private */
    public FrameLayout o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public Parcelable q;
    /* access modifiers changed from: private */
    public boolean r;

    public j(Context context, List<MediaData> list, boolean z, int i2, boolean z2) {
        super(context);
        ((h) ((x) context).b()).a(this);
        if (!af.a(list) || af.a(f23021a)) {
            this.k = list;
        } else {
            this.k = f23021a;
        }
        this.l = z;
        this.m = i2;
        this.n = new com.shopee.app.ui.image.a.a(this.j);
        this.r = z2;
    }

    static {
        s[0] = com.garena.android.appkit.tools.b.e(R.string.sp_saved_to_photo);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!g()) {
            this.i.a(this.h);
            this.h.a(this);
            int i2 = 0;
            this.m = Math.max(0, Math.min(this.m, this.k.size() - 1));
            this.f23022b.setBackgroundColor(-16777216);
            this.f23022b.setAdapter(new b());
            this.f23022b.a();
            this.f23022b.setSelectedIndex(this.m);
            if (!af.a(this.k)) {
                int i3 = this.m;
                if (i3 >= 0 && i3 < this.k.size() && this.k.get(this.m).isVideo()) {
                    this.p = true;
                }
            }
            int size = af.a(this.k) ? 0 : this.k.size();
            this.f23024d.setIndicators(size);
            this.f23024d.a(this.m, true);
            PageIndicatorView pageIndicatorView = this.f23024d;
            if (size <= 1) {
                i2 = 8;
            }
            pageIndicatorView.setVisibility(i2);
        }
    }

    private boolean g() {
        if (!af.a(this.k)) {
            return false;
        }
        this.f23027g.finish();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c();
    }

    public void c() {
        Intent intent = new Intent();
        intent.putExtra("index", this.f23022b.getSelectedIndex());
        VideoViewerView h2 = h();
        if (h2 != null) {
            intent.putExtra("isPlaying", h2.a());
            intent.putExtra("curTime", h2.getCurrentPosition() / 1000);
            intent.putExtra("isMuted", this.r);
        }
        this.f23027g.setResult(-1, intent);
        this.f23027g.finish();
        f23021a = null;
    }

    public Activity getActivity() {
        return this.f23027g;
    }

    public void d() {
        this.h.e();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", this.f23022b.getSelectedIndex());
        VideoViewerView h2 = h();
        if (h2 != null) {
            bundle.putParcelable("video", h2.onSaveInstanceState());
        }
        bundle.putParcelable("super", super.onSaveInstanceState());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Parcelable parcelable2 = bundle.getParcelable("super");
            this.f23022b.setSelectedIndex(bundle.getInt("pos"));
            this.q = bundle.getParcelable("video");
            parcelable = parcelable2;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void e() {
        VideoViewerView h2 = h();
        if (h2 != null) {
            h2.d();
        }
    }

    private VideoViewerView h() {
        View findViewWithTag = ((com.garena.android.uikit.image.a.a) this.f23022b.getChildAt(0)).findViewWithTag("video_view");
        if (findViewWithTag != null) {
            return (VideoViewerView) findViewWithTag;
        }
        return null;
    }

    private class b extends s implements View.OnClickListener {
        public View a(Context context, MediaData mediaData, int i) {
            return null;
        }

        private b() {
        }

        public List<MediaData> a() {
            return j.this.k;
        }

        public void b(View view, View view2, int i) {
            super.b(view, view2, i);
            j.this.f23024d.a(i, false);
            j.this.f23023c.setVisibility(0);
            if (j.this.o != null) {
                j.this.o.setVisibility(0);
            }
        }

        public void c(View view, View view2, int i) {
            super.c(view, view2, i);
            j.this.f23024d.a(i, true);
            j.this.f23023c.setVisibility(0);
            if (j.this.o != null) {
                j.this.o.setVisibility(0);
            }
        }

        public void a(View view, View view2, int i) {
            super.a(view, view2, i);
            if (!((MediaData) j.this.k.get(i)).isVideo()) {
                com.squareup.a.af afVar = (com.squareup.a.af) view.getTag();
                if (afVar != null) {
                    w.a(j.this.getContext()).a(afVar);
                }
                view.setTag("");
            }
        }

        public void a(VideoViewerView videoViewerView, final MediaData mediaData, int i) {
            videoViewerView.setTag("video_view");
            videoViewerView.setTopBarStatusListener(new com.shopee.app.ui.video.b() {
                public void a(boolean z) {
                    if (z) {
                        j.this.f23023c.setVisibility(0);
                        if (j.this.o != null) {
                            j.this.o.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    j.this.f23023c.setVisibility(8);
                    if (j.this.o != null) {
                        j.this.o.setVisibility(8);
                    }
                }
            });
            if (j.this.p) {
                videoViewerView.a(mediaData.getPath(), true, mediaData.getCurTime() * 1000);
            } else {
                videoViewerView.a(mediaData.getPath(), false);
            }
            if (j.this.q != null) {
                videoViewerView.onRestoreInstanceState(j.this.q);
                Parcelable unused = j.this.q = null;
            }
            videoViewerView.setVideoStateListener(new VideoViewerView.a() {
                public void a(long j, long j2) {
                    j.this.n.a(mediaData, j, j2);
                }

                public void a() {
                    j.this.n.a(mediaData);
                }
            });
            boolean unused2 = j.this.p = false;
            videoViewerView.a(true, j.this.r, (CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    boolean unused = j.this.r = z;
                }
            });
        }

        public void a(com.garena.android.uikit.image.c.a aVar, String str, int i) {
            if (j.this.l) {
                aVar.setImageOnTapListener(this);
            }
            aa.a(j.this.getContext(), aVar, str);
            bj.a(aVar.getActualImageView(), j.this.getContext(), j.s);
        }

        public void onClick(View view) {
            j.this.f23027g.finish();
        }
    }

    public static class a extends ab {
        public boolean a(z zVar) {
            return "data".equals(zVar.f30601d.getScheme());
        }

        public ab.a a(z zVar, int i) {
            byte[] decode = Base64.decode(zVar.f30601d.toString().split(",")[1], 2);
            return new ab.a(BitmapFactory.decodeByteArray(decode, 0, decode.length), w.d.MEMORY);
        }
    }

    public static class c extends ab {

        /* renamed from: a  reason: collision with root package name */
        public String f7019a = "video";

        public boolean a(z zVar) {
            return this.f7019a.equals(zVar.f30601d.getScheme());
        }

        public ab.a a(z zVar, int i) throws IOException {
            return new ab.a(ThumbnailUtils.createVideoThumbnail(zVar.f30601d.getPath(), 2), w.d.DISK);
        }
    }

    public static class d extends ab {

        /* renamed from: a  reason: collision with root package name */
        public String f7020a = "videothumb";

        public boolean a(z zVar) {
            return this.f7020a.equals(zVar.f30601d.getScheme());
        }

        public ab.a a(z zVar, int i) throws IOException {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            long parseLong = Long.parseLong(zVar.f30601d.getQueryParameter("time"));
            mediaMetadataRetriever.setDataSource(zVar.f30601d.getPath());
            return new ab.a(mediaMetadataRetriever.getFrameAtTime(parseLong), w.d.DISK);
        }
    }

    public static synchronized w a(Context context) {
        w b2;
        synchronized (j.class) {
            b2 = ar.f().b(context);
        }
        return b2;
    }
}
