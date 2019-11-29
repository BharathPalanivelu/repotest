package com.shopee.app.react.view.mediabrowserview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.shopee.app.h.l;
import com.shopee.app.react.view.mediabrowserview.a.b;
import com.shopee.app.react.view.mediabrowserview.a.c;
import com.shopee.app.react.view.mediabrowserview.a.d;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.image.s;
import com.shopee.app.ui.video.VideoViewerView;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.r;
import com.squareup.a.w;
import io.b.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final GImageBrowserView f19032a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<MediaData> f19033b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.shopee.app.ui.image.a.a f19034c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final EventDispatcher f19035d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ImageView> f19036e = new WeakReference<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private int f19037f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Parcelable f19038g;
    /* access modifiers changed from: private */
    public final Runnable h = new Runnable() {
        public void run() {
            a aVar = a.this;
            aVar.measure(View.MeasureSpec.makeMeasureSpec(aVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(a.this.getHeight(), 1073741824));
            a aVar2 = a.this;
            aVar2.layout(aVar2.getLeft(), a.this.getTop(), a.this.getRight(), a.this.getBottom());
        }
    };

    public a(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f19032a = new GImageBrowserView(themedReactContext);
        addView(this.f19032a, new FrameLayout.LayoutParams(-1, -1));
        this.f19033b = new ArrayList();
        Activity currentActivity = themedReactContext.getCurrentActivity();
        if (currentActivity instanceof e) {
            e eVar = (e) currentActivity;
            this.f19034c = new com.shopee.app.ui.image.a.a(new com.shopee.app.tracking.trackingv3.b(eVar.A(), eVar.j()));
        } else {
            this.f19034c = null;
        }
        this.f19035d = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.f19032a.setBackgroundColor(-16777216);
        this.f19032a.setAdapter(new C0289a());
        this.f19032a.a();
        this.f19032a.setPageChangeListener(new GImageBrowserView.b() {
            public void a(int i, int i2) {
                a.this.f19035d.dispatchEvent(new b(a.this.getId(), i2));
                if (i2 == a.this.f19033b.size() - 1) {
                    a.this.f19035d.dispatchEvent(new com.shopee.app.react.view.mediabrowserview.a.a(a.this.getId()));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", this.f19032a.getSelectedIndex());
        VideoViewerView b2 = b();
        if (b2 != null) {
            bundle.putParcelable("video", b2.onSaveInstanceState());
        }
        bundle.putParcelable("super", super.onSaveInstanceState());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Parcelable parcelable2 = bundle.getParcelable("super");
            this.f19032a.setSelectedIndex(bundle.getInt("pos"));
            this.f19038g = bundle.getParcelable("video");
            parcelable = parcelable2;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private VideoViewerView b() {
        View findViewWithTag = ((com.garena.android.uikit.image.a.a) this.f19032a.getChildAt(0)).findViewWithTag("video_view");
        if (findViewWithTag != null) {
            return (VideoViewerView) findViewWithTag;
        }
        return null;
    }

    public void setMediaSources(List<MediaData> list) {
        this.f19033b = list;
        this.f19032a.a();
        int i = this.f19037f;
        if (i >= 0 && i < this.f19033b.size()) {
            this.f19032a.setSelectedIndex(this.f19037f);
            this.f19037f = -1;
        }
    }

    public void setStartIndex(int i) {
        this.f19037f = i;
        this.f19032a.setSelectedIndex(i);
    }

    /* renamed from: com.shopee.app.react.view.mediabrowserview.a$a  reason: collision with other inner class name */
    private class C0289a extends s {
        public View a(Context context, MediaData mediaData, int i) {
            return null;
        }

        private C0289a() {
        }

        public List<MediaData> a() {
            return a.this.f19033b;
        }

        public void a(View view, View view2, int i) {
            super.a(view, view2, i);
            if (!((MediaData) a.this.f19033b.get(i)).isVideo()) {
                af afVar = (af) view.getTag();
                if (afVar != null) {
                    w.a(a.this.getContext()).a(afVar);
                }
                view.setTag("");
            }
        }

        public void a(VideoViewerView videoViewerView, final MediaData mediaData, int i) {
            videoViewerView.setTag("video_view");
            videoViewerView.a(Uri.parse(mediaData.getPath()).getPath(), false);
            if (a.this.f19038g != null) {
                videoViewerView.onRestoreInstanceState(a.this.f19038g);
                Parcelable unused = a.this.f19038g = null;
            }
            videoViewerView.setVideoStateListener(new VideoViewerView.a() {
                public void a(long j, long j2) {
                    if (a.this.f19034c != null) {
                        a.this.f19034c.a(mediaData, j, j2);
                    }
                }

                public void a() {
                    if (a.this.f19034c != null) {
                        a.this.f19034c.a(mediaData);
                    }
                }
            });
            a aVar = a.this;
            aVar.post(aVar.h);
        }

        public void a(final com.garena.android.uikit.image.c.a aVar, String str, int i) {
            b bVar = new b(aVar);
            aVar.setTag(bVar);
            aVar.a();
            double b2 = (double) com.garena.android.appkit.tools.b.b();
            Double.isNaN(b2);
            int d2 = com.garena.android.appkit.tools.b.d();
            w.a(a.this.getContext()).a(str).b((int) (b2 * 1.5d), d2).e().f().a(r.NO_CACHE, r.NO_STORE).a((af) bVar);
            aVar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.f19035d.dispatchEvent(new c(a.this.getId()));
                }
            });
            aVar.setImageOnTapListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.f19035d.dispatchEvent(new c(a.this.getId()));
                }
            });
            aVar.setImageOnLongTapListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    WeakReference unused = a.this.f19036e = new WeakReference(aVar.getActualImageView());
                    a.this.f19035d.dispatchEvent(new d(a.this.getId()));
                    return false;
                }
            });
            a aVar2 = a.this;
            aVar2.post(aVar2.h);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        final ImageView imageView = (ImageView) this.f19036e.get();
        if (imageView == null || imageView.getDrawable() == null) {
            com.shopee.app.h.r.a().b((int) R.string.sp_image_save_fail);
            this.f19035d.dispatchEvent(new com.shopee.app.react.view.mediabrowserview.a.e(getId()));
            return;
        }
        q.a(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() {
                Bitmap a2 = com.shopee.app.h.b.a.a().a(imageView.getDrawable());
                String a3 = com.shopee.app.g.c.a(l.a().a(a2, 80));
                l a4 = l.a();
                return Boolean.valueOf(a4.a(a2, "Shopee_" + a3 + ".jpg"));
            }
        }).b(io.b.h.a.b()).a(io.b.a.b.a.a()).a(new io.b.s<Boolean>() {
            public void a(io.b.b.b bVar) {
            }

            public void a(Throwable th) {
            }

            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    com.shopee.app.h.r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_save_image_into_camera));
                    return;
                }
                com.shopee.app.h.r.a().b((int) R.string.sp_image_save_fail);
                a.this.f19035d.dispatchEvent(new com.shopee.app.react.view.mediabrowserview.a.e(a.this.getId()));
            }
        });
    }

    class b implements af {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<com.garena.android.uikit.image.c.a> f19052b;

        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }

        b(com.garena.android.uikit.image.c.a aVar) {
            this.f19052b = new WeakReference<>(aVar);
        }

        public void a(Bitmap bitmap, w.d dVar) {
            com.garena.android.uikit.image.c.a aVar = (com.garena.android.uikit.image.c.a) this.f19052b.get();
            if (aVar != null) {
                aVar.setImageBitmap(bitmap);
                a aVar2 = a.this;
                aVar2.post(aVar2.h);
            }
        }
    }
}
