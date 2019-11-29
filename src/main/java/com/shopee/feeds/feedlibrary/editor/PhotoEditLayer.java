package com.shopee.feeds.feedlibrary.editor;

import a.k;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.share.internal.ShareConstants;
import com.shopee.feeds.feedlibrary.activity.SelectProductActivity;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ImageCompressUploadParams;
import com.shopee.feeds.feedlibrary.data.entity.ImageSizeEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.data.entity.PhotoFileInfoEntity;
import com.shopee.feeds.feedlibrary.data.entity.SaveProductEntity;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.util.BitmapUtil;
import com.shopee.feeds.feedlibrary.util.a.a;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.util.u;
import com.squareup.a.aa;
import com.squareup.a.r;
import com.squareup.a.w;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class PhotoEditLayer extends d<ImageView> {
    private HashMap<String, String> m = new HashMap<>();
    /* access modifiers changed from: private */
    public Bitmap n;

    public interface a {
        void a();

        void a(long j);

        void a(String str, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a> arrayList);
    }

    public interface b {
        void a(String str, PhotoFileInfoEntity photoFileInfoEntity);
    }

    public int getSourceMode() {
        return 1;
    }

    public PhotoEditLayer(Context context) {
        super(context);
    }

    public PhotoEditLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PhotoEditLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f27928c = findViewById(c.e.iv_picture);
        this.f27926a.setVisibility(8);
    }

    public ImageView getSourceView() {
        return (ImageView) this.f27928c;
    }

    public void b() {
        a((SaveProductEntity) null);
        e.j();
    }

    public void a(SaveProductEntity saveProductEntity) {
        if (this.j.e()) {
            Intent intent = new Intent(getContext(), SelectProductActivity.class);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, getSourceMode());
            intent.putExtra("select", 1);
            if (saveProductEntity != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("save", saveProductEntity);
                intent.putExtras(bundle);
            }
            getContext().startActivity(intent);
        } else if (this.j.d() == 5) {
            u.a(getContext(), com.garena.android.appkit.tools.b.a(c.g.feeds_max_tags_tips, 5));
        }
    }

    public void a(int i, final String str, final ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a> arrayList, final a aVar) {
        aa aaVar;
        if (!com.shopee.feeds.feedlibrary.util.d.a(str)) {
            boolean w = j.a().w();
            this.i = str;
            final w a2 = w.a(getContext());
            final String str2 = null;
            if (w) {
                str2 = this.m.get(str);
                aaVar = a2.a(q.a(str2));
            } else {
                aaVar = a2.a(q.a(str));
            }
            if (!j.a().w()) {
                aaVar.b(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels).e().a(c.d.feeds_image_placeholder).b(c.d.feeds_image_placeholder).a(w.e.HIGH).a(r.NO_CACHE, new r[0]).a((ImageView) this.f27928c, (com.squareup.a.e) new com.squareup.a.e() {
                    public void c() {
                        if (!j.a().w()) {
                            float intrinsicWidth = (float) PhotoEditLayer.this.getSourceView().getDrawable().getIntrinsicWidth();
                            float intrinsicHeight = (float) PhotoEditLayer.this.getSourceView().getDrawable().getIntrinsicHeight();
                            DisplayMetrics displayMetrics = PhotoEditLayer.this.getContext().getResources().getDisplayMetrics();
                            float f2 = (float) displayMetrics.widthPixels;
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PhotoEditLayer.this.getLayoutParams();
                            layoutParams.width = (int) f2;
                            int i = (int) ((intrinsicHeight / intrinsicWidth) * f2);
                            layoutParams.height = i;
                            ImageSizeEntity b2 = j.a().b();
                            if (!b2.isHasSet()) {
                                b2.setWidth((long) layoutParams.width);
                                b2.setHeight((long) layoutParams.height);
                                b2.setHasSet(true);
                                j.a().a(b2);
                            }
                            PhotoEditLayer.this.setLayoutParams(layoutParams);
                            ArrayList arrayList = arrayList;
                            if (arrayList != null && arrayList.size() > 0) {
                                PhotoEditLayer.this.j.a(arrayList.size());
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    com.shopee.feeds.feedlibrary.editor.tag.a aVar = (com.shopee.feeds.feedlibrary.editor.tag.a) it.next();
                                    aVar.e((float) PhotoEditLayer.this.getMeasuredWidth());
                                    aVar.f((float) layoutParams.height);
                                    aVar.c(0.5f);
                                    aVar.d(0.5f);
                                    aVar.a(aVar.c() * aVar.e());
                                    aVar.b(aVar.d() * ((float) layoutParams.height));
                                    arrayList2.add(aVar);
                                }
                                PhotoEditLayer.this.j.a(false);
                                PhotoEditLayer.this.j.a((ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>) arrayList2);
                                aVar.a(str, arrayList2);
                            }
                            if (intrinsicWidth > intrinsicHeight) {
                                j.a().c(false);
                                i = (int) ((intrinsicHeight * ((float) displayMetrics.widthPixels)) / intrinsicWidth);
                            } else {
                                j.a().c(true);
                            }
                            aVar.a((long) i);
                        }
                    }

                    public void d() {
                        com.garena.android.appkit.d.a.b("error!!", new Object[0]);
                        aVar.a();
                    }
                });
                return;
            }
            j.a().c(true);
            aaVar.b(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels).e().a((Drawable) new ColorDrawable(Color.parseColor("#f5f5f5"))).b(c.d.feeds_image_placeholder).a(r.NO_CACHE, new r[0]).a((ImageView) this.f27928c, (com.squareup.a.e) new com.squareup.a.e() {
                public void d() {
                }

                public void c() {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PhotoEditLayer.this.getLayoutParams();
                    DisplayMetrics displayMetrics = PhotoEditLayer.this.getContext().getResources().getDisplayMetrics();
                    int max = (int) Math.max((((float) PhotoEditLayer.this.getSourceView().getDrawable().getIntrinsicWidth()) / ((float) PhotoEditLayer.this.getSourceView().getDrawable().getIntrinsicHeight())) * ((float) displayMetrics.widthPixels), (float) displayMetrics.widthPixels);
                    layoutParams.width = max;
                    layoutParams.height = max;
                    PhotoEditLayer.this.setLayoutParams(layoutParams);
                    ((ImageView) PhotoEditLayer.this.f27928c).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            });
            try {
                k.a(new Callable<Object>() {
                    public Object call() throws Exception {
                        Bitmap h = a2.a(str2).h();
                        int width = h.getWidth();
                        int height = h.getHeight();
                        Bitmap unused = PhotoEditLayer.this.n = h;
                        h.b("%s", "targetdb " + width + "," + height);
                        if (width > height) {
                            PhotoEditLayer photoEditLayer = PhotoEditLayer.this;
                            Bitmap unused2 = photoEditLayer.n = Bitmap.createBitmap(photoEditLayer.n, (width - height) / 2, 0, height, height);
                            return null;
                        } else if (width >= height) {
                            return null;
                        } else {
                            PhotoEditLayer photoEditLayer2 = PhotoEditLayer.this;
                            Bitmap unused3 = photoEditLayer2.n = Bitmap.createBitmap(photoEditLayer2.n, 0, (height - width) / 2, width, width);
                            return null;
                        }
                    }
                }).a(new a.h<Object, Object>() {
                    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|10) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0023 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public java.lang.Object then(a.k<java.lang.Object> r4) throws java.lang.Exception {
                        /*
                            r3 = this;
                            java.io.File r4 = new java.io.File
                            java.lang.String r0 = r6
                            r4.<init>(r0)
                            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002e }
                            r0.<init>(r4)     // Catch:{ Exception -> 0x002e }
                            com.shopee.feeds.feedlibrary.editor.PhotoEditLayer r4 = com.shopee.feeds.feedlibrary.editor.PhotoEditLayer.this     // Catch:{ Exception -> 0x002e }
                            android.graphics.Bitmap r4 = r4.n     // Catch:{ Exception -> 0x002e }
                            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x002e }
                            r2 = 100
                            r4.compress(r1, r2, r0)     // Catch:{ Exception -> 0x002e }
                            r0.flush()     // Catch:{ Exception -> 0x002e }
                            java.io.FileDescriptor r4 = r0.getFD()     // Catch:{ Throwable -> 0x0023 }
                            r4.sync()     // Catch:{ Throwable -> 0x0023 }
                        L_0x0023:
                            r0.close()     // Catch:{ Exception -> 0x002e }
                            com.shopee.feeds.feedlibrary.editor.PhotoEditLayer$a r4 = r8     // Catch:{ Exception -> 0x002e }
                            r0 = -1
                            r4.a(r0)     // Catch:{ Exception -> 0x002e }
                            goto L_0x0032
                        L_0x002e:
                            r4 = move-exception
                            r4.printStackTrace()
                        L_0x0032:
                            r4 = 0
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.editor.PhotoEditLayer.AnonymousClass3.then(a.k):java.lang.Object");
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public void setNetImageMap(HashMap<String, String> hashMap) {
        this.m = hashMap;
    }

    public void a(final boolean z, final boolean z2, MediaCompressParam mediaCompressParam, final b bVar, boolean z3) {
        if (l()) {
            if (z2) {
                h.b("", "Photo Edit : save album -- " + com.shopee.feeds.feedlibrary.util.k.g(this.i));
                m();
            } else if (z) {
                h.b("", "Photo Edit : upload clean -- " + com.shopee.feeds.feedlibrary.util.k.g(this.i));
                if (z3) {
                    ((ImageView) this.f27928c).setVisibility(4);
                }
                g();
            } else {
                h.b("", "Photo Edit : preview not clean -- " + com.shopee.feeds.feedlibrary.util.k.g(this.i));
            }
            n();
            final boolean z4 = z2;
            final boolean z5 = z;
            final boolean z6 = z3;
            final MediaCompressParam mediaCompressParam2 = mediaCompressParam;
            k.a(new Callable<String>() {
                /* renamed from: a */
                public String call() throws Exception {
                    String str;
                    int i;
                    FileOutputStream fileOutputStream;
                    Bitmap bitmap;
                    com.shopee.feeds.feedlibrary.view.preview.j.a(false);
                    String path = PhotoEditLayer.this.getContext().getDir("images", 0).getPath();
                    if (z4) {
                        str = com.shopee.feeds.feedlibrary.view.preview.j.a(PhotoEditLayer.this.getContext()).replace(".jpg", "save_album.jpg");
                    } else {
                        str = com.shopee.feeds.feedlibrary.view.preview.j.a(PhotoEditLayer.this.getContext()).replace(".jpg", z5 ? "temp_edit_clean.jpg" : "temp_edit.jpg");
                    }
                    File file = new File(str);
                    if (file.createNewFile()) {
                        com.garena.android.appkit.d.a.b("exit file", new Object[0]);
                    }
                    boolean z = true;
                    if (!z5 || !z6) {
                        PhotoEditLayer.this.setDrawingCacheEnabled(false);
                        fileOutputStream = new FileOutputStream(file, false);
                        PhotoEditLayer.this.setDrawingCacheEnabled(true);
                        bitmap = PhotoEditLayer.this.getDrawingCache();
                        z = false;
                        i = 0;
                    } else {
                        PhotoEditLayer.this.setDrawingCacheEnabled(false);
                        fileOutputStream = new FileOutputStream(file, false);
                        PhotoEditLayer.this.setDrawingCacheEnabled(true);
                        bitmap = BitmapUtil.a(PhotoEditLayer.this.getDrawingCache(), PhotoEditLayer.this.i);
                        MediaCompressParam s = j.a().s();
                        if (s == null || s.getAndroid() == null) {
                            s = com.shopee.feeds.feedlibrary.util.e.a();
                        }
                        i = s.getAndroid().getPictureQuality();
                    }
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    String str2 = width + " * " + height;
                    float f2 = (float) height;
                    float f3 = (float) width;
                    float f4 = f3;
                    double doubleValue = new BigDecimal((double) (f2 / f3)).setScale(2, 4).doubleValue();
                    if (!z) {
                        i = 100;
                    }
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    int f5 = com.shopee.feeds.feedlibrary.util.k.f(str);
                    if (!z5 || z4 || z) {
                        return file.getAbsolutePath();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("feeds_initedit_");
                    sb.append(com.shopee.feeds.feedlibrary.util.d.a());
                    sb.append(z5 ? "_edit_clean" : "_edit");
                    String sb2 = sb.toString();
                    if (width > mediaCompressParam2.getAndroid().getMaxWidth()) {
                        float maxWidth = (float) mediaCompressParam2.getAndroid().getMaxWidth();
                        double d2 = (double) maxWidth;
                        Double.isNaN(d2);
                        f2 = (float) (d2 * doubleValue);
                        f4 = maxWidth;
                    }
                    File a2 = new a.C0435a(PhotoEditLayer.this.getContext()).a(f4).b(f2).a(mediaCompressParam2.getAndroid().getDefaultCompressQuality()).b(sb2).a(Bitmap.CompressFormat.JPEG).a(path).a().a(file);
                    String str3 = f4 + " * " + f2;
                    int defaultCompressQuality = mediaCompressParam2.getAndroid().getDefaultCompressQuality();
                    String str4 = "_edit_clean";
                    String str5 = "_edit";
                    int length = (int) (a2.length() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
                    if (!PhotoEditLayer.this.a(a2, mediaCompressParam2.getAndroid().getMaxSizeInKB())) {
                        PhotoEditLayer photoEditLayer = PhotoEditLayer.this;
                        photoEditLayer.a(photoEditLayer.i, str2, f5, defaultCompressQuality, str3, length, str3, length, defaultCompressQuality, 150, 100);
                        com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), file);
                        return a2.getAbsolutePath();
                    }
                    MediaCompressParam.CompressItem a3 = PhotoEditLayer.this.a(mediaCompressParam2, a2);
                    float min = (float) Math.min(width, a3.getWidth());
                    int i2 = defaultCompressQuality;
                    String str6 = str4;
                    double d3 = (double) min;
                    Double.isNaN(d3);
                    float f6 = (float) (d3 * doubleValue);
                    int compressQuality = a3.getCompressQuality();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("feeds_edit_");
                    sb3.append(com.shopee.feeds.feedlibrary.util.d.a());
                    if (!z5) {
                        str6 = str5;
                    }
                    sb3.append(str6);
                    File a4 = new a.C0435a(PhotoEditLayer.this.getContext()).a(min).b(f6).a(compressQuality).b(sb3.toString()).a(Bitmap.CompressFormat.JPEG).a(path).a().a(file);
                    int sizeInKB = a3.getSizeInKB();
                    PhotoEditLayer photoEditLayer2 = PhotoEditLayer.this;
                    photoEditLayer2.a(photoEditLayer2.i, str2, f5, i2, str3, length, min + " * " + f6, (int) (a4.length() / IjkMediaMeta.AV_CH_SIDE_RIGHT), compressQuality, sizeInKB, compressQuality);
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), file);
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), a2);
                    return a4.getAbsolutePath();
                }
            }).a(new a.h<String, PhotoFileInfoEntity>() {
                /* renamed from: a */
                public PhotoFileInfoEntity then(k<String> kVar) throws Exception {
                    String f2 = kVar.f();
                    if (f2 == null) {
                        f2 = PhotoEditLayer.this.i;
                    }
                    return PhotoEditLayer.a(f2);
                }
            }, (Executor) k.f376a).a(new a.h<PhotoFileInfoEntity, Void>() {
                /* renamed from: a */
                public Void then(k<PhotoFileInfoEntity> kVar) throws Exception {
                    PhotoFileInfoEntity f2 = kVar.f();
                    if (z2) {
                        PhotoEditLayer.this.o();
                    } else if (z) {
                        PhotoEditLayer.this.h();
                        ((ImageView) PhotoEditLayer.this.f27928c).setVisibility(0);
                    }
                    bVar.a(PhotoEditLayer.this.i, f2);
                    return null;
                }
            }, k.f377b);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i, int i2, String str3, int i3, String str4, int i4, int i5, int i6, int i7) {
        ImageCompressUploadParams imageCompressUploadParams = new ImageCompressUploadParams();
        imageCompressUploadParams.setCrop_screen_resolution(str2);
        imageCompressUploadParams.setCrop_file_size(i);
        imageCompressUploadParams.setDefault_screen_resolution(str3);
        imageCompressUploadParams.setDefault_file_size(i3);
        imageCompressUploadParams.setDefault_compress_quality(i2);
        imageCompressUploadParams.setFinal_resolution(str4);
        imageCompressUploadParams.setFinal_file_size(i4);
        imageCompressUploadParams.setFinal_compress_quality(i5);
        imageCompressUploadParams.setHit_size(i6);
        imageCompressUploadParams.setHit_quality(i7);
        imageCompressUploadParams.setPath(str);
        imageCompressUploadParams.setFrom(j.a().q());
        if (!j.a().w()) {
            HashMap<String, OriginImageInfo> k = j.a().k();
            if (k != null) {
                OriginImageInfo originImageInfo = k.get(str);
                if (originImageInfo != null) {
                    imageCompressUploadParams.setOriginal_resolution(originImageInfo.getOriginal_resolution());
                    imageCompressUploadParams.setOriginal_file_size(originImageInfo.getOriginal_file_size());
                }
            }
        }
        j.a().a(imageCompressUploadParams);
    }

    /* access modifiers changed from: private */
    public MediaCompressParam.CompressItem a(MediaCompressParam mediaCompressParam, File file) {
        MediaCompressParam mediaCompressParam2 = new MediaCompressParam();
        mediaCompressParam2.getClass();
        MediaCompressParam.CompressItem compressItem = new MediaCompressParam.CompressItem();
        long length = file.length() / IjkMediaMeta.AV_CH_SIDE_RIGHT;
        ArrayList<MediaCompressParam.CompressItem> list = mediaCompressParam.getAndroid().getList();
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            MediaCompressParam.CompressItem compressItem2 = list.get(i);
            if (length > ((long) compressItem2.getSizeInKB())) {
                compressItem.setCompressQuality(compressItem2.getCompressQuality());
                compressItem.setSizeInKB(compressItem2.getSizeInKB());
                compressItem.setWidth(compressItem2.getWidth());
                break;
            }
            if (i == list.size() - 1) {
                compressItem.setCompressQuality(compressItem2.getCompressQuality());
                compressItem.setSizeInKB(compressItem2.getSizeInKB());
                compressItem.setWidth(compressItem2.getWidth());
            }
            i++;
        }
        return compressItem;
    }

    /* access modifiers changed from: private */
    public boolean a(File file, int i) {
        try {
            return file.length() / IjkMediaMeta.AV_CH_SIDE_RIGHT >= ((long) i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static PhotoFileInfoEntity a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new PhotoFileInfoEntity(str, options.outWidth, options.outHeight);
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.c();
        this.f27931f.setVisibility(8);
        this.f27932g.setVisibility(8);
    }
}
