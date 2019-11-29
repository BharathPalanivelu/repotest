package com.airbnb.android.react.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

public class i extends c {

    /* renamed from: a  reason: collision with root package name */
    private TileOverlayOptions f3297a;

    /* renamed from: b  reason: collision with root package name */
    private TileOverlay f3298b;

    /* renamed from: c  reason: collision with root package name */
    private a f3299c;

    /* renamed from: d  reason: collision with root package name */
    private String f3300d;

    /* renamed from: e  reason: collision with root package name */
    private float f3301e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f3302f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f3303g;

    class a extends UrlTileProvider {

        /* renamed from: b  reason: collision with root package name */
        private String f3305b;

        public a(int i, int i2, String str) {
            super(i, i2);
            this.f3305b = str;
        }

        public synchronized URL getTileUrl(int i, int i2, int i3) {
            String replace = this.f3305b.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
            if (i.this.f3302f > BitmapDescriptorFactory.HUE_RED && ((float) i3) > i.this.f3302f) {
                return null;
            }
            if (i.this.f3303g > BitmapDescriptorFactory.HUE_RED && ((float) i3) < i.this.f3303g) {
                return null;
            }
            try {
                return new URL(replace);
            } catch (MalformedURLException e2) {
                throw new AssertionError(e2);
            }
        }

        public void a(String str) {
            this.f3305b = str;
        }
    }

    public i(Context context) {
        super(context);
    }

    public void setUrlTemplate(String str) {
        this.f3300d = str;
        a aVar = this.f3299c;
        if (aVar != null) {
            aVar.a(str);
        }
        TileOverlay tileOverlay = this.f3298b;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setZIndex(float f2) {
        this.f3301e = f2;
        TileOverlay tileOverlay = this.f3298b;
        if (tileOverlay != null) {
            tileOverlay.setZIndex(f2);
        }
    }

    public void setMaximumZ(float f2) {
        this.f3302f = f2;
        TileOverlay tileOverlay = this.f3298b;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setMinimumZ(float f2) {
        this.f3303g = f2;
        TileOverlay tileOverlay = this.f3298b;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.f3297a == null) {
            this.f3297a = a();
        }
        return this.f3297a;
    }

    private TileOverlayOptions a() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.f3301e);
        this.f3299c = new a(256, 256, this.f3300d);
        tileOverlayOptions.tileProvider(this.f3299c);
        return tileOverlayOptions;
    }

    public Object getFeature() {
        return this.f3298b;
    }

    public void a(GoogleMap googleMap) {
        this.f3298b = googleMap.addTileOverlay(getTileOverlayOptions());
    }

    public void b(GoogleMap googleMap) {
        this.f3298b.remove();
    }
}
