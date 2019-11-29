package com.shopee.app.ui.product.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.f;
import com.shopee.app.a;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.image.d;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.af;
import com.shopee.app.util.ap;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.protocol.shop.ShopCover;
import com.squareup.a.ah;
import com.squareup.a.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShopCoverControl2 extends d {
    private static CharSequence[] j = new CharSequence[6];
    private static CharSequence[] k = new CharSequence[4];

    /* renamed from: d  reason: collision with root package name */
    bi f24598d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f24599e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f24600f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a.f f24601g;
    private a.c h;
    private a.c i;

    public interface a {
        void a(ShopCoverControl2 shopCoverControl2);
    }

    public interface b {
        void a();
    }

    /* access modifiers changed from: protected */
    public void a(Context context, int i2) {
    }

    public ShopCoverControl2(Context context) {
        super(context);
        this.f24601g = new a.f() {
            public void a() {
            }

            public void a(String str) {
                ShopCoverControl2.this.f24598d.a("GET_YOUTUBE_URL", new com.garena.android.appkit.b.a(str));
            }
        };
        this.h = new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i == 0) {
                    MediaData mediaData = (MediaData) ShopCoverControl2.this.f22821b.get(ShopCoverControl2.this.f22822c);
                    if (mediaData.isVideo()) {
                        ShopCoverControl2.this.f24598d.a("PLAY_YOUTUBE_ID", new com.garena.android.appkit.b.a(mediaData.getPath()));
                    } else {
                        ShopCoverControl2.this.c();
                    }
                } else if (i == 1) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).a(true).e(1).d(2).f(true).c(true).i((int) R.string.sp_camera_hint_shop).a(4);
                } else if (i == 2) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).d(true).e(1).d(2).c(true).a(4);
                } else if (i == 3) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).e(true).e(1).d(2).c(true).a(4);
                } else if (i == 4) {
                    com.shopee.app.ui.dialog.a.a(ShopCoverControl2.this.getContext(), (int) R.string.sp_add_youtube_video_url, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, ShopCoverControl2.this.f24601g);
                } else if (i == 5) {
                    ShopCoverControl2.this.f22821b.remove(ShopCoverControl2.this.f22822c);
                    if (ShopCoverControl2.this.f24600f != null) {
                        ShopCoverControl2.this.f24600f.a();
                    }
                    ShopCoverControl2.this.a();
                }
                fVar.dismiss();
            }
        };
        this.i = new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i == 0) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).a(true).e(1).d(2).f(true).c(true).i((int) R.string.sp_camera_hint_shop).a(4);
                } else if (i == 1) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).d(true).e(1).d(2).c(true).a(4);
                } else if (i == 2) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).e(true).e(1).d(2).c(true).a(4);
                } else if (i == 3) {
                    com.shopee.app.ui.dialog.a.a(ShopCoverControl2.this.getContext(), (int) R.string.sp_add_youtube_video_url, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, ShopCoverControl2.this.f24601g);
                }
                fVar.dismiss();
            }
        };
        this.f24599e = 5;
        a(context);
    }

    public ShopCoverControl2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24601g = new a.f() {
            public void a() {
            }

            public void a(String str) {
                ShopCoverControl2.this.f24598d.a("GET_YOUTUBE_URL", new com.garena.android.appkit.b.a(str));
            }
        };
        this.h = new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i == 0) {
                    MediaData mediaData = (MediaData) ShopCoverControl2.this.f22821b.get(ShopCoverControl2.this.f22822c);
                    if (mediaData.isVideo()) {
                        ShopCoverControl2.this.f24598d.a("PLAY_YOUTUBE_ID", new com.garena.android.appkit.b.a(mediaData.getPath()));
                    } else {
                        ShopCoverControl2.this.c();
                    }
                } else if (i == 1) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).a(true).e(1).d(2).f(true).c(true).i((int) R.string.sp_camera_hint_shop).a(4);
                } else if (i == 2) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).d(true).e(1).d(2).c(true).a(4);
                } else if (i == 3) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).e(true).e(1).d(2).c(true).a(4);
                } else if (i == 4) {
                    com.shopee.app.ui.dialog.a.a(ShopCoverControl2.this.getContext(), (int) R.string.sp_add_youtube_video_url, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, ShopCoverControl2.this.f24601g);
                } else if (i == 5) {
                    ShopCoverControl2.this.f22821b.remove(ShopCoverControl2.this.f22822c);
                    if (ShopCoverControl2.this.f24600f != null) {
                        ShopCoverControl2.this.f24600f.a();
                    }
                    ShopCoverControl2.this.a();
                }
                fVar.dismiss();
            }
        };
        this.i = new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i == 0) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).a(true).e(1).d(2).f(true).c(true).i((int) R.string.sp_camera_hint_shop).a(4);
                } else if (i == 1) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).d(true).e(1).d(2).c(true).a(4);
                } else if (i == 2) {
                    PhotoProxyActivity_.a(ShopCoverControl2.this.getContext()).e(true).e(1).d(2).c(true).a(4);
                } else if (i == 3) {
                    com.shopee.app.ui.dialog.a.a(ShopCoverControl2.this.getContext(), (int) R.string.sp_add_youtube_video_url, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, ShopCoverControl2.this.f24601g);
                }
                fVar.dismiss();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.ProductImageControl);
        this.f24599e = obtainStyledAttributes.getInt(1, 5);
        obtainStyledAttributes.recycle();
        a(context);
    }

    private void a(Context context) {
        a(com.garena.android.appkit.tools.c.a().a(172), com.garena.android.appkit.tools.c.a().a(86));
        ((a) ((x) context).b()).a(this);
    }

    private int a(MediaData mediaData) {
        if (this.f22822c == -1) {
            this.f22821b.add(mediaData);
            a();
            return this.f22821b.size() - 1;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f22821b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == this.f22822c) {
                arrayList.add(mediaData);
            } else {
                arrayList.add(this.f22821b.get(i2));
            }
        }
        this.f22821b = arrayList;
        a();
        return this.f22822c;
    }

    public int a(String str) {
        return a(MediaData.newImageData(str));
    }

    public int a(String str, String str2) {
        return a(MediaData.newVideoData(str, str2, 0));
    }

    public void a(int i2, String str) {
        MediaData mediaData;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (MediaData mediaData2 : this.f22821b) {
            if (i3 == i2) {
                if (mediaData2.isVideo()) {
                    mediaData = MediaData.newVideoData(str, mediaData2.getPath(), mediaData2.getDuration());
                } else {
                    mediaData = MediaData.newImageData(str);
                }
                arrayList.add(mediaData);
            } else {
                arrayList.add(mediaData2);
            }
            i3++;
        }
        this.f22821b = arrayList;
        a();
    }

    public void setCovers(List<ShopCover> list) {
        this.f22821b.clear();
        this.f22821b.addAll(af.a(list, new af.b<MediaData, ShopCover>() {
            /* renamed from: a */
            public MediaData map(ShopCover shopCover) {
                if (shopCover.type.intValue() == 1) {
                    return MediaData.newVideoData(shopCover.image_url, shopCover.video_url, 0);
                }
                return MediaData.newImageData(shopCover.image_url);
            }
        }));
        a();
    }

    /* access modifiers changed from: protected */
    public com.shopee.app.ui.image.b getViewAdapter() {
        return new c();
    }

    public void b() {
        this.f22822c = -1;
        com.shopee.app.ui.dialog.a.a(getContext(), k, this.i);
    }

    public void a(View view, int i2) {
        this.f22822c = i2;
        com.shopee.app.ui.dialog.a.a(getContext(), j, this.h);
    }

    /* access modifiers changed from: private */
    public void c() {
        ArrayList arrayList = new ArrayList();
        for (MediaData mediaData : this.f22821b) {
            String path = mediaData.getPath();
            if (mediaData.isVideo()) {
                path = mediaData.getThumb();
            }
            String b2 = com.shopee.app.h.f.a().b(path);
            if (new File(b2).exists()) {
                arrayList.add(MediaData.newImageData(b2));
            } else {
                arrayList.add(MediaData.newImageData("http://cf.shopee.co.id/file/" + b2));
            }
        }
        ImageBrowserActivity_.a(getContext()).a((ArrayList<MediaData>) arrayList).b(this.f22822c).a();
    }

    public List<ShopCover> getShopCovers() {
        return af.a(this.f22821b, new af.b<ShopCover, MediaData>() {
            /* renamed from: a */
            public ShopCover map(MediaData mediaData) {
                ShopCover.Builder builder = new ShopCover.Builder();
                if (mediaData.isVideo()) {
                    builder.image_url(mediaData.getThumb());
                    builder.video_url(mediaData.getPath());
                    builder.type(1);
                } else {
                    builder.image_url(mediaData.getPath());
                    builder.type(0);
                }
                return builder.build();
            }
        });
    }

    public void setOnImageRemoveListener(b bVar) {
        this.f24600f = bVar;
    }

    private class c extends com.shopee.app.ui.image.b {
        private c() {
        }

        public int a() {
            return ShopCoverControl2.this.f24599e;
        }

        public View a(int i, int i2, int i3, View view) {
            String str;
            Context context = view.getContext();
            if (i == ShopCoverControl2.this.f22821b.size()) {
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setBackgroundResource(R.drawable.border_all_sides_primary);
                RelativeLayout relativeLayout2 = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setImageDrawable(com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_add));
                relativeLayout2.addView(imageView, layoutParams);
                relativeLayout.addView(relativeLayout2);
                return relativeLayout;
            }
            MediaData mediaData = (MediaData) ShopCoverControl2.this.f22821b.get(i);
            ImageView imageView2 = new ImageView(context);
            if (mediaData.isVideo()) {
                str = mediaData.getThumb() + "_tn";
            } else {
                str = mediaData.getPath() + "_tn";
            }
            File file = new File(com.shopee.app.h.f.a().b(str));
            com.garena.android.appkit.d.a.b("HELLO: %s", String.valueOf(file.exists()));
            if (file.exists()) {
                if (mediaData.isVideo()) {
                    w.a(ShopCoverControl2.this.getContext()).a(file).a((ah) new ap(R.drawable.ic_description_video)).a(imageView2);
                } else {
                    w.a(ShopCoverControl2.this.getContext()).a(file).a().a(imageView2);
                }
            } else if (mediaData.isVideo()) {
                w.a(ShopCoverControl2.this.getContext()).a("http://cf.shopee.co.id/file/" + str).a((ah) new ap(R.drawable.ic_description_video)).a(imageView2);
            } else {
                w.a(ShopCoverControl2.this.getContext()).a("http://cf.shopee.co.id/file/" + str).a().a(imageView2);
            }
            imageView2.setBackgroundResource(R.drawable.border_all_sides);
            return imageView2;
        }

        public int b() {
            return ShopCoverControl2.this.f22821b.size() >= c() ? c() : ShopCoverControl2.this.f22821b.size() + 1;
        }

        public int c() {
            return ShopCoverControl2.this.f24599e;
        }
    }

    static {
        j[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_view);
        j[1] = com.garena.android.appkit.tools.b.e(R.string.sp_bt_camera);
        j[2] = com.garena.android.appkit.tools.b.e(R.string.sp_label_gallery);
        j[3] = com.garena.android.appkit.tools.b.e(R.string.sp_label_instagram);
        j[4] = com.garena.android.appkit.tools.b.e(R.string.sp_youtube_video);
        j[5] = com.garena.android.appkit.tools.b.e(R.string.sp_label_delete);
        k[0] = com.garena.android.appkit.tools.b.e(R.string.sp_bt_camera);
        k[1] = com.garena.android.appkit.tools.b.e(R.string.sp_label_gallery);
        k[2] = com.garena.android.appkit.tools.b.e(R.string.sp_label_instagram);
        k[3] = com.garena.android.appkit.tools.b.e(R.string.sp_youtube_video);
    }
}
