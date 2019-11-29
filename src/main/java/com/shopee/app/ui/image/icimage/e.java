package com.shopee.app.ui.image.icimage;

import a.h;
import a.k;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.garena.android.appkit.d.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.h.f;
import com.shopee.app.h.l;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.image.bound.j;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23000a;

    /* renamed from: b  reason: collision with root package name */
    j f23001b;

    /* renamed from: c  reason: collision with root package name */
    View f23002c;

    /* renamed from: d  reason: collision with root package name */
    ImageButton f23003d;

    /* renamed from: e  reason: collision with root package name */
    Activity f23004e;

    /* renamed from: f  reason: collision with root package name */
    r f23005f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f23006g;
    /* access modifiers changed from: private */
    public int h;
    private PhotoFrameInfo i;
    private IcCamera3Info j;

    public e(Context context, String str, PhotoFrameInfo photoFrameInfo, IcCamera3Info icCamera3Info, int i2) {
        super(context);
        this.f23006g = str;
        this.i = photoFrameInfo;
        this.j = icCamera3Info;
        this.h = i2;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: protected */
    public void a() {
        PhotoFrameInfo photoFrameInfo = this.i;
        if (photoFrameInfo != null && photoFrameInfo.getFrameRatio() > BitmapDescriptorFactory.HUE_RED) {
            this.f23001b.setVisibility(0);
            this.f23001b.a(this.i.getFrameRatio(), this.i.getHorizontalMargin());
        }
        IcCamera3Info icCamera3Info = this.j;
        if (icCamera3Info == null || icCamera3Info.getType() != 2) {
            this.f23002c.setRotation((float) (-this.h));
            w.a(getContext()).a(Uri.parse(this.f23006g)).a().c(8388659).a(this.f23000a);
            return;
        }
        w.a(getContext()).a(Uri.parse(this.f23006g)).a().e().a(this.f23000a);
    }

    public void b() {
        this.f23005f.a();
        PhotoFrameInfo photoFrameInfo = this.i;
        if (photoFrameInfo == null || photoFrameInfo.getFrameRatio() <= BitmapDescriptorFactory.HUE_RED) {
            Intent intent = new Intent();
            intent.putExtra("PHOTO_SOURCE", this.f23006g);
            intent.putExtra("PHOTO_ORIENTATION", this.h);
            this.f23004e.setResult(-1, intent);
            this.f23004e.finish();
            return;
        }
        final int width = this.f23000a.getWidth();
        final int height = this.f23000a.getHeight();
        final float f2 = ((float) width) / ((float) height);
        final int width2 = this.f23001b.f22788g.getWidth();
        final int height2 = this.f23001b.f22788g.getHeight();
        final int i2 = (height - height2) / 2;
        final int i3 = (width - width2) / 2;
        k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                float f2;
                Bitmap a2 = l.a().a(Uri.parse(e.this.f23006g).getPath());
                float width = (float) a2.getWidth();
                float height = (float) a2.getHeight();
                if (width / height > f2) {
                    f2 = ((float) height) / height;
                } else {
                    f2 = ((float) width) / width;
                }
                int i = width2;
                if (i > 0) {
                    int i2 = height2;
                    if (i2 > 0) {
                        double d2 = (double) i3;
                        double d3 = (double) f2;
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        double d4 = (double) i2;
                        Double.isNaN(d4);
                        Double.isNaN(d3);
                        double d5 = (double) i;
                        Double.isNaN(d5);
                        Double.isNaN(d3);
                        double d6 = (double) i2;
                        Double.isNaN(d6);
                        Double.isNaN(d3);
                        Bitmap createBitmap = Bitmap.createBitmap(a2, (int) (d2 / d3), (int) (d4 / d3), (int) (d5 / d3), (int) (d6 / d3));
                        a2.recycle();
                        File file = new File(f.a().b("ic_camera_cropped.jpg"));
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                        String uri = Uri.fromFile(file).toString();
                        createBitmap.recycle();
                        return uri;
                    }
                }
                return "";
            }
        }).a(new h<String, Void>() {
            /* renamed from: a */
            public Void then(k<String> kVar) {
                e.this.f23005f.b();
                if (kVar.e()) {
                    com.shopee.app.h.r.a().a((int) R.string.sp_image_save_fail);
                    a.a(kVar.g());
                    return null;
                }
                Intent intent = new Intent();
                intent.putExtra("PHOTO_SOURCE", kVar.f());
                intent.putExtra("PHOTO_ORIENTATION", e.this.h);
                e.this.f23004e.setResult(-1, intent);
                e.this.f23004e.finish();
                return null;
            }
        }, k.f377b);
    }

    public void c() {
        this.f23004e.finish();
    }
}
