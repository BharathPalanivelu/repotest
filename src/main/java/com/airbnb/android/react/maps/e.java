package com.airbnb.android.react.maps;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Property;
import android.view.View;
import android.widget.LinearLayout;
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
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class e extends c {
    private boolean A = false;
    private boolean B = true;
    private boolean C = false;
    private final DraweeHolder<?> D;
    /* access modifiers changed from: private */
    public DataSource<CloseableReference<CloseableImage>> E;
    private final ControllerListener<ImageInfo> F = new BaseControllerListener<ImageInfo>() {
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFinalImageSet(java.lang.String r3, com.facebook.imagepipeline.image.ImageInfo r4, android.graphics.drawable.Animatable r5) {
            /*
                r2 = this;
                r3 = 0
                com.airbnb.android.react.maps.e r4 = com.airbnb.android.react.maps.e.this     // Catch:{ all -> 0x004f }
                com.facebook.datasource.DataSource r4 = r4.E     // Catch:{ all -> 0x004f }
                java.lang.Object r4 = r4.getResult()     // Catch:{ all -> 0x004f }
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4     // Catch:{ all -> 0x004f }
                r3 = 1
                if (r4 == 0) goto L_0x003b
                java.lang.Object r5 = r4.get()     // Catch:{ all -> 0x0039 }
                com.facebook.imagepipeline.image.CloseableImage r5 = (com.facebook.imagepipeline.image.CloseableImage) r5     // Catch:{ all -> 0x0039 }
                if (r5 == 0) goto L_0x003b
                boolean r0 = r5 instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap     // Catch:{ all -> 0x0039 }
                if (r0 == 0) goto L_0x003b
                com.facebook.imagepipeline.image.CloseableStaticBitmap r5 = (com.facebook.imagepipeline.image.CloseableStaticBitmap) r5     // Catch:{ all -> 0x0039 }
                android.graphics.Bitmap r5 = r5.getUnderlyingBitmap()     // Catch:{ all -> 0x0039 }
                if (r5 == 0) goto L_0x003b
                android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0039 }
                android.graphics.Bitmap r5 = r5.copy(r0, r3)     // Catch:{ all -> 0x0039 }
                com.airbnb.android.react.maps.e r0 = com.airbnb.android.react.maps.e.this     // Catch:{ all -> 0x0039 }
                android.graphics.Bitmap unused = r0.q = r5     // Catch:{ all -> 0x0039 }
                com.airbnb.android.react.maps.e r0 = com.airbnb.android.react.maps.e.this     // Catch:{ all -> 0x0039 }
                com.google.android.gms.maps.model.BitmapDescriptor r5 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r5)     // Catch:{ all -> 0x0039 }
                com.google.android.gms.maps.model.BitmapDescriptor unused = r0.p = r5     // Catch:{ all -> 0x0039 }
                goto L_0x003b
            L_0x0039:
                r3 = move-exception
                goto L_0x0053
            L_0x003b:
                com.airbnb.android.react.maps.e r5 = com.airbnb.android.react.maps.e.this
                com.facebook.datasource.DataSource r5 = r5.E
                r5.close()
                if (r4 == 0) goto L_0x0049
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r4)
            L_0x0049:
                com.airbnb.android.react.maps.e r4 = com.airbnb.android.react.maps.e.this
                r4.a((boolean) r3)
                return
            L_0x004f:
                r4 = move-exception
                r1 = r4
                r4 = r3
                r3 = r1
            L_0x0053:
                com.airbnb.android.react.maps.e r5 = com.airbnb.android.react.maps.e.this
                com.facebook.datasource.DataSource r5 = r5.E
                r5.close()
                if (r4 == 0) goto L_0x0061
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r4)
            L_0x0061:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.maps.e.AnonymousClass1.onFinalImageSet(java.lang.String, com.facebook.imagepipeline.image.ImageInfo, android.graphics.drawable.Animatable):void");
        }
    };
    private Bitmap G = null;

    /* renamed from: a  reason: collision with root package name */
    private MarkerOptions f3267a;

    /* renamed from: b  reason: collision with root package name */
    private Marker f3268b;

    /* renamed from: c  reason: collision with root package name */
    private int f3269c;

    /* renamed from: d  reason: collision with root package name */
    private int f3270d;

    /* renamed from: e  reason: collision with root package name */
    private String f3271e;

    /* renamed from: f  reason: collision with root package name */
    private LatLng f3272f;

    /* renamed from: g  reason: collision with root package name */
    private String f3273g;
    private String h;
    private boolean i;
    private float j;
    private float k;
    private a l;
    private View m;
    private final Context n;
    private float o = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public BitmapDescriptor p;
    /* access modifiers changed from: private */
    public Bitmap q;
    private float r = BitmapDescriptorFactory.HUE_RED;
    private boolean s = false;
    private boolean t = false;
    private int u = 0;
    private float v = 1.0f;
    private float w;
    private float x;
    private boolean y;
    private boolean z = true;

    public e(Context context) {
        super(context);
        this.n = context;
        this.D = DraweeHolder.create(c(), context);
        this.D.onAttach();
    }

    public e(Context context, MarkerOptions markerOptions) {
        super(context);
        this.n = context;
        this.D = DraweeHolder.create(c(), context);
        this.D.onAttach();
        this.f3272f = markerOptions.getPosition();
        a((double) markerOptions.getAnchorU(), (double) markerOptions.getAnchorV());
        b((double) markerOptions.getInfoWindowAnchorU(), (double) markerOptions.getInfoWindowAnchorV());
        setTitle(markerOptions.getTitle());
        setSnippet(markerOptions.getSnippet());
        setRotation(markerOptions.getRotation());
        setFlat(markerOptions.isFlat());
        setDraggable(markerOptions.isDraggable());
        setZIndex(Math.round(markerOptions.getZIndex()));
        setAlpha(markerOptions.getAlpha());
        this.p = markerOptions.getIcon();
    }

    private GenericDraweeHierarchy c() {
        return new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setCoordinate(ReadableMap readableMap) {
        this.f3272f = new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude"));
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setPosition(this.f3272f);
        }
        a(false);
    }

    public void setIdentifier(String str) {
        this.f3271e = str;
        a(false);
    }

    public String getIdentifier() {
        return this.f3271e;
    }

    public void setTitle(String str) {
        this.f3273g = str;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setTitle(str);
        }
        a(false);
    }

    public void setSnippet(String str) {
        this.h = str;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setSnippet(str);
        }
        a(false);
    }

    public void setRotation(float f2) {
        this.r = f2;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setRotation(f2);
        }
        a(false);
    }

    public void setFlat(boolean z2) {
        this.s = z2;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setFlat(z2);
        }
        a(false);
    }

    public void setDraggable(boolean z2) {
        this.t = z2;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setDraggable(z2);
        }
        a(false);
    }

    public void setZIndex(int i2) {
        this.u = i2;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setZIndex((float) i2);
        }
        a(false);
    }

    public void setOpacity(float f2) {
        this.v = f2;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setAlpha(f2);
        }
        a(false);
    }

    public void setMarkerHue(float f2) {
        this.o = f2;
        a(false);
    }

    public void a(double d2, double d3) {
        this.i = true;
        this.j = (float) d2;
        this.k = (float) d3;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setAnchor(this.j, this.k);
        }
        a(false);
    }

    public void b(double d2, double d3) {
        this.y = true;
        this.w = (float) d2;
        this.x = (float) d3;
        Marker marker = this.f3268b;
        if (marker != null) {
            marker.setInfoWindowAnchor(this.w, this.x);
        }
        a(false);
    }

    public void setTracksViewChanges(boolean z2) {
        this.z = z2;
        d();
    }

    private void d() {
        boolean z2 = this.z && this.C && this.f3268b != null;
        if (z2 != this.A) {
            this.A = z2;
            if (z2) {
                s.a().a(this);
                return;
            }
            s.a().b(this);
            b();
        }
    }

    public boolean a() {
        if (!this.A) {
            return false;
        }
        b();
        return true;
    }

    public void b() {
        if (this.B) {
            if (!this.C) {
                this.B = false;
            }
            Marker marker = this.f3268b;
            if (marker != null) {
                marker.setIcon(getIcon());
            }
        }
    }

    public LatLng a(float f2, LatLng latLng, LatLng latLng2) {
        double d2 = latLng2.latitude - latLng.latitude;
        double d3 = (double) f2;
        Double.isNaN(d3);
        Double.isNaN(d3);
        return new LatLng((d2 * d3) + latLng.latitude, ((latLng2.longitude - latLng.longitude) * d3) + latLng.longitude);
    }

    public void a(LatLng latLng, Integer num) {
        AnonymousClass2 r0 = new TypeEvaluator<LatLng>() {
            /* renamed from: a */
            public LatLng evaluate(float f2, LatLng latLng, LatLng latLng2) {
                return e.this.a(f2, latLng, latLng2);
            }
        };
        Property<LatLng, V> of = Property.of(Marker.class, LatLng.class, ViewProps.POSITION);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f3268b, of, r0, new LatLng[]{latLng});
        ofObject.setDuration((long) num.intValue());
        ofObject.start();
    }

    public void setImage(String str) {
        this.B = true;
        if (str == null) {
            this.p = null;
            a(true);
        } else if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("asset://")) {
            ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
            this.E = Fresco.getImagePipeline().fetchDecodedImage(build, this);
            this.D.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(build)).setControllerListener(this.F)).setOldController(this.D.getController())).build());
        } else {
            this.p = b(str);
            if (this.p != null) {
                int a2 = a(str);
                this.q = BitmapFactory.decodeResource(getResources(), a2);
                if (this.q == null) {
                    Drawable drawable = getResources().getDrawable(a2);
                    this.q = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    drawable.draw(new Canvas(this.q));
                }
            }
            a(true);
        }
    }

    public MarkerOptions getMarkerOptions() {
        if (this.f3267a == null) {
            this.f3267a = new MarkerOptions();
        }
        a(this.f3267a);
        return this.f3267a;
    }

    public void addView(View view, int i2) {
        super.addView(view, i2);
        if (!(view instanceof a)) {
            this.C = true;
            d();
        }
        a(true);
    }

    public void requestLayout() {
        super.requestLayout();
        if (getChildCount() == 0 && this.C) {
            this.C = false;
            e();
            d();
            a(true);
        }
    }

    public Object getFeature() {
        return this.f3268b;
    }

    public void a(GoogleMap googleMap) {
        this.f3268b = googleMap.addMarker(getMarkerOptions());
        d();
    }

    public void b(GoogleMap googleMap) {
        this.f3268b.remove();
        this.f3268b = null;
        d();
    }

    private BitmapDescriptor getIcon() {
        if (!this.C) {
            BitmapDescriptor bitmapDescriptor = this.p;
            if (bitmapDescriptor != null) {
                return bitmapDescriptor;
            }
            return BitmapDescriptorFactory.defaultMarker(this.o);
        } else if (this.p == null) {
            return BitmapDescriptorFactory.fromBitmap(f());
        } else {
            Bitmap f2 = f();
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(this.q.getWidth(), f2.getWidth()), Math.max(this.q.getHeight(), f2.getHeight()), this.q.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(this.q, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
            canvas.drawBitmap(f2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
            return BitmapDescriptorFactory.fromBitmap(createBitmap);
        }
    }

    private MarkerOptions a(MarkerOptions markerOptions) {
        markerOptions.position(this.f3272f);
        if (this.i) {
            markerOptions.anchor(this.j, this.k);
        }
        if (this.y) {
            markerOptions.infoWindowAnchor(this.w, this.x);
        }
        markerOptions.title(this.f3273g);
        markerOptions.snippet(this.h);
        markerOptions.rotation(this.r);
        markerOptions.flat(this.s);
        markerOptions.draggable(this.t);
        markerOptions.zIndex((float) this.u);
        markerOptions.alpha(this.v);
        markerOptions.icon(getIcon());
        return markerOptions;
    }

    public void a(boolean z2) {
        if (this.f3268b != null) {
            if (z2) {
                b();
            }
            if (this.i) {
                this.f3268b.setAnchor(this.j, this.k);
            } else {
                this.f3268b.setAnchor(0.5f, 1.0f);
            }
            if (this.y) {
                this.f3268b.setInfoWindowAnchor(this.w, this.x);
            } else {
                this.f3268b.setInfoWindowAnchor(0.5f, BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    public void a(int i2, int i3) {
        this.f3269c = i2;
        this.f3270d = i3;
        a(true);
    }

    private void e() {
        this.G = null;
    }

    private Bitmap f() {
        int i2 = this.f3269c;
        int i3 = 100;
        if (i2 <= 0) {
            i2 = 100;
        }
        int i4 = this.f3270d;
        if (i4 > 0) {
            i3 = i4;
        }
        buildDrawingCache();
        Bitmap bitmap = this.G;
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() != i2 || bitmap.getHeight() != i3) {
            bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.G = bitmap;
        } else {
            bitmap.eraseColor(0);
        }
        draw(new Canvas(bitmap));
        return bitmap;
    }

    public void setCalloutView(a aVar) {
        this.l = aVar;
    }

    public a getCalloutView() {
        return this.l;
    }

    public View getCallout() {
        if (this.l == null) {
            return null;
        }
        if (this.m == null) {
            g();
        }
        if (this.l.getTooltip()) {
            return this.m;
        }
        return null;
    }

    public View getInfoContents() {
        if (this.l == null) {
            return null;
        }
        if (this.m == null) {
            g();
        }
        if (this.l.getTooltip()) {
            return null;
        }
        return this.m;
    }

    private void g() {
        a aVar = this.l;
        if (aVar != null && aVar.getChildCount() != 0) {
            LinearLayout linearLayout = new LinearLayout(this.n);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.l.f3248a, this.l.f3249b, BitmapDescriptorFactory.HUE_RED));
            LinearLayout linearLayout2 = new LinearLayout(this.n);
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(this.l.f3248a, this.l.f3249b, BitmapDescriptorFactory.HUE_RED));
            linearLayout.addView(linearLayout2);
            linearLayout2.addView(this.l);
            this.m = linearLayout;
        }
    }

    private int a(String str) {
        return getResources().getIdentifier(str, "drawable", getContext().getPackageName());
    }

    private BitmapDescriptor b(String str) {
        return BitmapDescriptorFactory.fromResource(a(str));
    }
}
