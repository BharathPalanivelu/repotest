package com.shopee.app.ui.product.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.a.b;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.app.application.ar;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.image.d;
import com.shopee.app.ui.image.j;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.id.R;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import com.squareup.a.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProductImageControl extends d {
    private static CharSequence[] m = new CharSequence[6];
    private static CharSequence[] n = new CharSequence[4];
    private static CharSequence[] o = new CharSequence[1];
    private static CharSequence[] p = new CharSequence[4];
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ProgressWheel f24587d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c f24588e;

    /* renamed from: f  reason: collision with root package name */
    private a f24589f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f24590g;
    private int h = 100;
    private a.c i = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                ProductImageControl.this.c();
            } else if (i == 1) {
                PhotoProxyActivity_.a a2 = PhotoProxyActivity_.a(ProductImageControl.this.getContext());
                ProductImageControl productImageControl = ProductImageControl.this;
                a2.a(productImageControl.b(((MediaData) productImageControl.f22821b.get(ProductImageControl.this.f22822c)).getPath())).h(true).a(4);
            } else if (i == 2) {
                PhotoProxyActivity_.a(ProductImageControl.this.getContext()).a(true).i((int) R.string.sp_camera_hint).c(true).g(true).a(4);
            } else if (i == 3) {
                PhotoProxyActivity_.a(ProductImageControl.this.getContext()).d(true).c(true).g(true).b(ProductImageControl.this.getImageFilterCode()).a(4);
            }
            fVar.dismiss();
        }
    };
    private a.c j = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                ProductImageControl.this.c();
            } else if (i == 1) {
                PhotoProxyActivity_.a a2 = PhotoProxyActivity_.a(ProductImageControl.this.getContext());
                ProductImageControl productImageControl = ProductImageControl.this;
                a2.a(productImageControl.b(((MediaData) productImageControl.f22821b.get(ProductImageControl.this.f22822c)).getPath())).h(true).a(4);
            } else if (i == 2) {
                PhotoProxyActivity_.a(ProductImageControl.this.getContext()).a(true).i((int) R.string.sp_camera_hint_add_product).a(4);
            } else if (i == 3) {
                PhotoProxyActivity_.a(ProductImageControl.this.getContext()).d(true).b(ProductImageControl.this.getImageFilterCode()).a(4);
            } else if (i == 4) {
                ArrayList arrayList = new ArrayList();
                int size = ProductImageControl.this.f22821b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 == 0) {
                        arrayList.add(ProductImageControl.this.f22821b.get(ProductImageControl.this.f22822c));
                        ProductImageControl.this.f22821b.remove(ProductImageControl.this.f22822c);
                    } else {
                        arrayList.add(ProductImageControl.this.f22821b.get(i2 - 1));
                    }
                }
                List unused = ProductImageControl.this.f22821b = arrayList;
                ProductImageControl.this.a();
                PhotoProxyActivity_.a a3 = PhotoProxyActivity_.a(ProductImageControl.this.getContext());
                ProductImageControl productImageControl2 = ProductImageControl.this;
                a3.a(productImageControl2.b(((MediaData) productImageControl2.f22821b.get(0)).getPath())).c(true).g(true).a(4);
                int unused2 = ProductImageControl.this.f22822c = 0;
            } else if (i == 5) {
                MediaData mediaData = (MediaData) ProductImageControl.this.f22821b.remove(ProductImageControl.this.f22822c);
                ProductImageControl.this.a();
                if (ProductImageControl.this.f24588e != null) {
                    ProductImageControl.this.f24588e.a(mediaData);
                }
            }
            fVar.dismiss();
        }
    };
    private a.c k = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                MediaData mediaData = (MediaData) ProductImageControl.this.f22821b.remove(ProductImageControl.this.f22822c);
                ProductImageControl.this.a();
                if (ProductImageControl.this.f24588e != null) {
                    ProductImageControl.this.f24588e.a(mediaData);
                }
            }
            fVar.dismiss();
        }
    };
    private a.c l = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                ProductImageControl.this.c();
            } else if (i == 1) {
                PhotoProxyActivity_.a(ProductImageControl.this.getContext()).a(true).b(1).i((int) R.string.sp_camera_hint_add_product).a(4);
            } else if (i == 2) {
                PhotoProxyActivity_.a(ProductImageControl.this.getContext()).c(1).d(true).a(4);
            } else if (i == 3) {
                MediaData mediaData = (MediaData) ProductImageControl.this.f22821b.remove(ProductImageControl.this.f22822c);
                ProductImageControl.this.a();
                if (ProductImageControl.this.f24588e != null) {
                    ProductImageControl.this.f24588e.a(mediaData);
                }
            }
            fVar.dismiss();
        }
    };

    public interface a {
        void a(List<MediaData> list);
    }

    public interface c {
        void a(MediaData mediaData);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, int i2) {
    }

    public String getImageFilterCode() {
        return "LISTING_CONTROL_FILTER";
    }

    public ProductImageControl(Context context) {
        super(context);
    }

    public ProductImageControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void a() {
        a aVar = this.f24589f;
        if (aVar != null) {
            aVar.a(this.f22821b);
        }
        super.a();
    }

    public int a(String str) {
        MediaData newImageData = MediaData.newImageData(str);
        if (this.f22822c == -1) {
            this.f22821b.add(newImageData);
            a();
            return this.f22821b.size() - 1;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f22821b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == this.f22822c) {
                arrayList.add(newImageData);
            } else {
                arrayList.add(this.f22821b.get(i2));
            }
        }
        this.f22821b = arrayList;
        a();
        return this.f22822c;
    }

    public int a(String str, String str2, int i2, int i3, int i4, boolean z) {
        MediaData newVideoData = MediaData.newVideoData(str, str2, i2, i3, i4, z);
        if (this.f22821b.size() < 2) {
            this.f22821b.add(newVideoData);
            a();
            return this.f22821b.size() - 1;
        }
        if (((MediaData) this.f22821b.get(1)).isVideo()) {
            this.f22821b.set(1, newVideoData);
        } else {
            ArrayList arrayList = new ArrayList();
            int size = this.f22821b.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (i5 == 1) {
                    arrayList.add(newVideoData);
                    arrayList.add(this.f22821b.get(i5));
                } else {
                    arrayList.add(this.f22821b.get(i5));
                }
            }
            this.f22821b = arrayList;
        }
        a();
        return 1;
    }

    public void a(double d2) {
        if (this.f22821b.size() >= 2 && ((MediaData) this.f22821b.get(1)).isVideo()) {
            ProgressWheel progressWheel = this.f24587d;
            if (progressWheel != null) {
                progressWheel.setProgress((float) d2);
                TextView textView = this.f24590g;
                textView.setText(((int) (d2 * 100.0d)) + "%");
            }
        }
    }

    public void a(int i2, String str) {
        MediaData newImageData = MediaData.newImageData(str);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (MediaData mediaData : this.f22821b) {
            if (i3 == i2) {
                arrayList.add(newImageData);
            } else {
                arrayList.add(mediaData);
            }
            i3++;
        }
        this.f22821b = arrayList;
        a();
    }

    public void setImages(String str) {
        String[] split = str.split(",");
        this.f22821b.clear();
        for (String newImageData : split) {
            this.f22821b.add(MediaData.newImageData(newImageData));
        }
        a();
    }

    public void setMaxImageCount(int i2) {
        this.h = i2;
    }

    public int getMaxImageCount() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public com.shopee.app.ui.image.b getViewAdapter() {
        return new b();
    }

    public void b() {
        this.f22822c = -1;
        PhotoProxyActivity_.a(getContext()).d(true).f(this.h - getImagesCount()).g(1 - getVideoPaths().size()).c(ar.f().e().settingConfigStore().videoEnabled() ? 2 : 0).b(getImageFilterCode()).a(4);
    }

    public void a(View view, int i2) {
        this.f22822c = i2;
        if (i2 == 0) {
            com.shopee.app.ui.dialog.a.a(getContext(), p, this.i);
        } else if (i2 != 1 || !((MediaData) this.f22821b.get(i2)).isVideo()) {
            com.shopee.app.ui.dialog.a.a(getContext(), m, this.j);
        } else if (((MediaData) this.f22821b.get(i2)).isDummy()) {
            com.shopee.app.ui.dialog.a.a(getContext(), o, this.k);
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), n, this.l);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        ArrayList arrayList = new ArrayList();
        for (MediaData mediaData : this.f22821b) {
            if (!mediaData.isVideo()) {
                String b2 = com.shopee.app.h.f.a().b(mediaData.getPath());
                if (!new File(b2).exists()) {
                    b2 = "http://cf.shopee.co.id/file/" + mediaData.getPath();
                }
                arrayList.add(MediaData.newImageData(b2));
            } else {
                arrayList.add(mediaData);
            }
        }
        ImageBrowserActivity_.a(getContext()).a((ArrayList<MediaData>) arrayList).b(this.f22822c).a();
    }

    /* access modifiers changed from: private */
    public String b(String str) {
        File file = new File(com.shopee.app.h.f.a().b(str));
        if (file.exists()) {
            return Uri.fromFile(file).toString();
        }
        return "http://cf.shopee.co.id/file/" + str;
    }

    private class b extends com.shopee.app.ui.image.b {
        public int a() {
            return 10;
        }

        private b() {
        }

        public View a(int i, int i2, int i3, View view) {
            int i4 = i;
            Context context = view.getContext();
            if (i4 == ProductImageControl.this.f22821b.size()) {
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setBackgroundResource(R.drawable.border_all_sides_primary);
                RelativeLayout relativeLayout2 = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                TextView textView = new TextView(context);
                int i5 = ar.f().e().settingConfigStore().videoEnabled() ? R.string.sp_label_add_photo_video : R.string.sp_label_add_photo;
                textView.setText("+ " + com.garena.android.appkit.tools.b.e(i5));
                textView.setGravity(17);
                textView.setTextColor(com.garena.android.appkit.tools.b.a(R.color.primary));
                textView.setTextSize(2, 10.0f);
                relativeLayout2.addView(textView, layoutParams);
                relativeLayout.addView(relativeLayout2);
                return relativeLayout;
            }
            if (i4 == 1) {
                MediaData mediaData = (MediaData) ProductImageControl.this.f22821b.get(i4);
                if (mediaData.isVideo()) {
                    ImageView imageView = new ImageView(context);
                    if (!TextUtils.isEmpty(mediaData.getThumb())) {
                        String str = mediaData.getThumb() + "_tn";
                        File file = new File(com.shopee.app.h.f.a().b(str));
                        if (file.exists()) {
                            w.a(ProductImageControl.this.getContext()).a(file).a().a(imageView);
                        } else {
                            w.a(ProductImageControl.this.getContext()).a("http://cf.shopee.co.id/file/" + str).a().a(imageView);
                        }
                    } else {
                        j.a(ProductImageControl.this.getContext()).a("video://" + mediaData.getPath()).a().a(imageView);
                    }
                    RelativeLayout relativeLayout3 = new RelativeLayout(context);
                    int a2 = com.garena.android.appkit.tools.c.a().a(104);
                    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(a2, a2);
                    relativeLayout3.setLayoutParams(layoutParams2);
                    relativeLayout3.addView(imageView, layoutParams2);
                    int a3 = com.garena.android.appkit.tools.c.a().a(5);
                    TextView textView2 = new TextView(context);
                    textView2.setBackgroundColor(RNCartPanelDataEntity.NULL_VALUE);
                    textView2.setTextColor(-1);
                    textView2.setText(com.garena.videolib.c.a.a((long) (mediaData.getDuration() * 1000)));
                    textView2.setTextSize(2, 12.0f);
                    textView2.setGravity(21);
                    textView2.setId(R.id.video_duration);
                    textView2.setPadding(a3, a3, a3, a3);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a2, com.garena.android.appkit.tools.c.a().a(24));
                    layoutParams3.addRule(12);
                    relativeLayout3.addView(textView2, layoutParams3);
                    ImageView imageView2 = new ImageView(context);
                    imageView2.setImageResource(R.drawable.ic_description_video);
                    imageView2.setPadding(a3, a3, a3, a3);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(9);
                    layoutParams4.addRule(12);
                    layoutParams4.addRule(6, R.id.video_duration);
                    layoutParams4.addRule(8, R.id.video_duration);
                    relativeLayout3.addView(imageView2, layoutParams4);
                    if (mediaData.isDummy()) {
                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams5.addRule(13);
                        ProgressWheel progressWheel = new ProgressWheel(ProductImageControl.this.getContext());
                        progressWheel.setLayoutParams(layoutParams5);
                        progressWheel.setCircleRadius(b.a.m + b.a.f7693d);
                        progressWheel.setBarColor(com.garena.android.appkit.tools.b.a(R.color.white));
                        progressWheel.setRimColor(com.garena.android.appkit.tools.b.a(R.color.rim_bg));
                        progressWheel.setBarWidth(b.a.f7691b);
                        progressWheel.setRimWidth(b.a.f7691b);
                        progressWheel.setBackgroundColor(RNCartPanelDataEntity.NULL_VALUE);
                        progressWheel.setLinearProgress(true);
                        ProgressWheel unused = ProductImageControl.this.f24587d = progressWheel;
                        relativeLayout3.addView(progressWheel, layoutParams5);
                        ProductImageControl.this.f24587d.setVisibility(0);
                        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams6.addRule(13);
                        ProductImageControl productImageControl = ProductImageControl.this;
                        TextView unused2 = productImageControl.f24590g = new TextView(productImageControl.getContext());
                        ProductImageControl.this.f24590g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
                        relativeLayout3.addView(ProductImageControl.this.f24590g, layoutParams6);
                    } else if (ProductImageControl.this.f24587d != null) {
                        ProductImageControl.this.f24587d.setVisibility(8);
                    }
                    relativeLayout3.setBackgroundResource(R.drawable.border_all_sides);
                    return relativeLayout3;
                }
            }
            ImageView imageView3 = new ImageView(context);
            String str2 = ((MediaData) ProductImageControl.this.f22821b.get(i4)).getPath() + "_tn";
            File file2 = new File(com.shopee.app.h.f.a().b(str2));
            if (file2.exists()) {
                w.a(ProductImageControl.this.getContext()).a(file2).a().a(imageView3);
            } else {
                w.a(ProductImageControl.this.getContext()).a("http://cf.shopee.co.id/file/" + str2).a().a(imageView3);
            }
            if (i4 == 0) {
                RelativeLayout relativeLayout4 = new RelativeLayout(context);
                int a4 = com.garena.android.appkit.tools.c.a().a(104);
                ViewGroup.LayoutParams layoutParams7 = new ViewGroup.LayoutParams(a4, a4);
                relativeLayout4.setLayoutParams(layoutParams7);
                relativeLayout4.addView(imageView3, layoutParams7);
                TextView textView3 = new TextView(context);
                textView3.setBackgroundColor(RNCartPanelDataEntity.NULL_VALUE);
                textView3.setTextColor(-1);
                textView3.setText(R.string.sp_label_cover_photo);
                textView3.setTextSize(2, 12.0f);
                textView3.setGravity(17);
                RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a4, com.garena.android.appkit.tools.c.a().a(24));
                layoutParams8.addRule(12);
                relativeLayout4.addView(textView3, layoutParams8);
                relativeLayout4.setBackgroundResource(R.drawable.border_all_sides);
                return relativeLayout4;
            }
            imageView3.setBackgroundResource(R.drawable.border_all_sides);
            return imageView3;
        }

        public int b() {
            return ProductImageControl.this.f22821b.size() + 1;
        }

        public int c() {
            return ProductImageControl.this.f22821b.size() + 1;
        }
    }

    static {
        m[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_view);
        m[1] = com.garena.android.appkit.tools.b.e(R.string.sp_edit);
        m[2] = com.garena.android.appkit.tools.b.e(R.string.sp_take_photo);
        m[3] = com.garena.android.appkit.tools.b.e(R.string.sp_choose_existing);
        m[4] = com.garena.android.appkit.tools.b.e(R.string.sp_label_mark_cover);
        m[5] = com.garena.android.appkit.tools.b.e(R.string.sp_label_delete);
        n[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_view);
        n[1] = com.garena.android.appkit.tools.b.e(R.string.sp_label_record_video);
        n[2] = com.garena.android.appkit.tools.b.e(R.string.sp_choose_existing);
        n[3] = com.garena.android.appkit.tools.b.e(R.string.sp_label_delete);
        o[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_delete);
        p[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_view);
        p[1] = com.garena.android.appkit.tools.b.e(R.string.sp_edit);
        p[2] = com.garena.android.appkit.tools.b.e(R.string.sp_take_photo);
        p[3] = com.garena.android.appkit.tools.b.e(R.string.sp_choose_existing);
    }

    public void setRemoveListener(c cVar) {
        this.f24588e = cVar;
    }

    public void setDataSetChangeListener(a aVar) {
        this.f24589f = aVar;
    }
}
