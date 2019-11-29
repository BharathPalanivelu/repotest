package com.airbnb.android.react.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class m {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l f3342a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3343b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f3344c;

    /* renamed from: d  reason: collision with root package name */
    private final DraweeHolder<?> f3345d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DataSource<CloseableReference<CloseableImage>> f3346e;

    /* renamed from: f  reason: collision with root package name */
    private final ControllerListener<ImageInfo> f3347f = new BaseControllerListener<ImageInfo>() {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFinalImageSet(java.lang.String r3, com.facebook.imagepipeline.image.ImageInfo r4, android.graphics.drawable.Animatable r5) {
            /*
                r2 = this;
                r3 = 0
                com.airbnb.android.react.maps.m r4 = com.airbnb.android.react.maps.m.this     // Catch:{ all -> 0x005b }
                com.facebook.datasource.DataSource r4 = r4.f3346e     // Catch:{ all -> 0x005b }
                java.lang.Object r4 = r4.getResult()     // Catch:{ all -> 0x005b }
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4     // Catch:{ all -> 0x005b }
                if (r4 == 0) goto L_0x0043
                java.lang.Object r3 = r4.get()     // Catch:{ all -> 0x0041 }
                com.facebook.imagepipeline.image.CloseableImage r3 = (com.facebook.imagepipeline.image.CloseableImage) r3     // Catch:{ all -> 0x0041 }
                if (r3 == 0) goto L_0x0043
                boolean r5 = r3 instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap     // Catch:{ all -> 0x0041 }
                if (r5 == 0) goto L_0x0043
                com.facebook.imagepipeline.image.CloseableStaticBitmap r3 = (com.facebook.imagepipeline.image.CloseableStaticBitmap) r3     // Catch:{ all -> 0x0041 }
                android.graphics.Bitmap r3 = r3.getUnderlyingBitmap()     // Catch:{ all -> 0x0041 }
                if (r3 == 0) goto L_0x0043
                android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0041 }
                r0 = 1
                android.graphics.Bitmap r3 = r3.copy(r5, r0)     // Catch:{ all -> 0x0041 }
                com.airbnb.android.react.maps.m r5 = com.airbnb.android.react.maps.m.this     // Catch:{ all -> 0x0041 }
                com.airbnb.android.react.maps.l r5 = r5.f3342a     // Catch:{ all -> 0x0041 }
                r5.setIconBitmap(r3)     // Catch:{ all -> 0x0041 }
                com.airbnb.android.react.maps.m r5 = com.airbnb.android.react.maps.m.this     // Catch:{ all -> 0x0041 }
                com.airbnb.android.react.maps.l r5 = r5.f3342a     // Catch:{ all -> 0x0041 }
                com.google.android.gms.maps.model.BitmapDescriptor r3 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r3)     // Catch:{ all -> 0x0041 }
                r5.setIconBitmapDescriptor(r3)     // Catch:{ all -> 0x0041 }
                goto L_0x0043
            L_0x0041:
                r3 = move-exception
                goto L_0x005f
            L_0x0043:
                com.airbnb.android.react.maps.m r3 = com.airbnb.android.react.maps.m.this
                com.facebook.datasource.DataSource r3 = r3.f3346e
                r3.close()
                if (r4 == 0) goto L_0x0051
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r4)
            L_0x0051:
                com.airbnb.android.react.maps.m r3 = com.airbnb.android.react.maps.m.this
                com.airbnb.android.react.maps.l r3 = r3.f3342a
                r3.a()
                return
            L_0x005b:
                r4 = move-exception
                r1 = r4
                r4 = r3
                r3 = r1
            L_0x005f:
                com.airbnb.android.react.maps.m r5 = com.airbnb.android.react.maps.m.this
                com.facebook.datasource.DataSource r5 = r5.f3346e
                r5.close()
                if (r4 == 0) goto L_0x006d
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r4)
            L_0x006d:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.maps.m.AnonymousClass1.onFinalImageSet(java.lang.String, com.facebook.imagepipeline.image.ImageInfo, android.graphics.drawable.Animatable):void");
        }
    };

    public m(Context context, Resources resources, l lVar) {
        this.f3343b = context;
        this.f3344c = resources;
        this.f3342a = lVar;
        this.f3345d = DraweeHolder.create(a(resources), context);
        this.f3345d.onAttach();
    }

    private GenericDraweeHierarchy a(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void a(String str) {
        if (str == null) {
            this.f3342a.setIconBitmapDescriptor((BitmapDescriptor) null);
            this.f3342a.a();
        } else if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("asset://")) {
            ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
            this.f3346e = Fresco.getImagePipeline().fetchDecodedImage(build, this);
            this.f3345d.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(build)).setControllerListener(this.f3347f)).setOldController(this.f3345d.getController())).build());
        } else {
            BitmapDescriptor c2 = c(str);
            if (c2 != null) {
                this.f3342a.setIconBitmapDescriptor(c2);
                this.f3342a.setIconBitmap(BitmapFactory.decodeResource(this.f3344c, b(str)));
            }
            this.f3342a.a();
        }
    }

    private int b(String str) {
        return this.f3344c.getIdentifier(str, "drawable", this.f3343b.getPackageName());
    }

    private BitmapDescriptor c(String str) {
        return BitmapDescriptorFactory.fromResource(b(str));
    }
}
