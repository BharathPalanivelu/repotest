package com.airbnb.android.react.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private TileOverlayOptions f3258a;

    /* renamed from: b  reason: collision with root package name */
    private TileOverlay f3259b;

    /* renamed from: c  reason: collision with root package name */
    private a f3260c;

    /* renamed from: d  reason: collision with root package name */
    private String f3261d;

    /* renamed from: e  reason: collision with root package name */
    private float f3262e;

    /* renamed from: f  reason: collision with root package name */
    private float f3263f;

    class a implements TileProvider {

        /* renamed from: b  reason: collision with root package name */
        private int f3265b;

        /* renamed from: c  reason: collision with root package name */
        private String f3266c;

        public a(int i, String str) {
            this.f3265b = i;
            this.f3266c = str;
        }

        public Tile getTile(int i, int i2, int i3) {
            byte[] a2 = a(i, i2, i3);
            if (a2 == null) {
                return TileProvider.NO_TILE;
            }
            int i4 = this.f3265b;
            return new Tile(i4, i4, a2);
        }

        public void a(String str) {
            this.f3266c = str;
        }

        public void a(int i) {
            this.f3265b = i;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|(2:8|(1:10)(1:64))|11|12|13|14|15|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x004e A[SYNTHETIC, Splitter:B:33:0x004e] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0055 A[SYNTHETIC, Splitter:B:37:0x0055] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0061 A[SYNTHETIC, Splitter:B:46:0x0061] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0068 A[SYNTHETIC, Splitter:B:50:0x0068] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x006f A[SYNTHETIC, Splitter:B:56:0x006f] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0076 A[SYNTHETIC, Splitter:B:60:0x0076] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0049=Splitter:B:30:0x0049, B:43:0x005c=Splitter:B:43:0x005c} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private byte[] a(int r7, int r8, int r9) {
            /*
                r6 = this;
                java.io.File r0 = new java.io.File
                java.lang.String r7 = r6.b(r7, r8, r9)
                r0.<init>(r7)
                r7 = 0
                java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0059, OutOfMemoryError -> 0x0046, all -> 0x0041 }
                r8.<init>(r0)     // Catch:{ IOException -> 0x0059, OutOfMemoryError -> 0x0046, all -> 0x0041 }
                java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x003e, OutOfMemoryError -> 0x003b, all -> 0x0036 }
                r9.<init>()     // Catch:{ IOException -> 0x003e, OutOfMemoryError -> 0x003b, all -> 0x0036 }
                r0 = 16384(0x4000, float:2.2959E-41)
                byte[] r1 = new byte[r0]     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            L_0x0018:
                r2 = 0
                int r3 = r8.read(r1, r2, r0)     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
                r4 = -1
                if (r3 == r4) goto L_0x0024
                r9.write(r1, r2, r3)     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
                goto L_0x0018
            L_0x0024:
                r9.flush()     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
                byte[] r7 = r9.toByteArray()     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
                r8.close()     // Catch:{ Exception -> 0x002e }
            L_0x002e:
                r9.close()     // Catch:{ Exception -> 0x0031 }
            L_0x0031:
                return r7
            L_0x0032:
                r0 = move-exception
                goto L_0x0049
            L_0x0034:
                r0 = move-exception
                goto L_0x005c
            L_0x0036:
                r9 = move-exception
                r5 = r9
                r9 = r7
                r7 = r5
                goto L_0x006d
            L_0x003b:
                r0 = move-exception
                r9 = r7
                goto L_0x0049
            L_0x003e:
                r0 = move-exception
                r9 = r7
                goto L_0x005c
            L_0x0041:
                r8 = move-exception
                r9 = r7
                r7 = r8
                r8 = r9
                goto L_0x006d
            L_0x0046:
                r0 = move-exception
                r8 = r7
                r9 = r8
            L_0x0049:
                r0.printStackTrace()     // Catch:{ all -> 0x006c }
                if (r8 == 0) goto L_0x0053
                r8.close()     // Catch:{ Exception -> 0x0052 }
                goto L_0x0053
            L_0x0052:
            L_0x0053:
                if (r9 == 0) goto L_0x0058
                r9.close()     // Catch:{ Exception -> 0x0058 }
            L_0x0058:
                return r7
            L_0x0059:
                r0 = move-exception
                r8 = r7
                r9 = r8
            L_0x005c:
                r0.printStackTrace()     // Catch:{ all -> 0x006c }
                if (r8 == 0) goto L_0x0066
                r8.close()     // Catch:{ Exception -> 0x0065 }
                goto L_0x0066
            L_0x0065:
            L_0x0066:
                if (r9 == 0) goto L_0x006b
                r9.close()     // Catch:{ Exception -> 0x006b }
            L_0x006b:
                return r7
            L_0x006c:
                r7 = move-exception
            L_0x006d:
                if (r8 == 0) goto L_0x0074
                r8.close()     // Catch:{ Exception -> 0x0073 }
                goto L_0x0074
            L_0x0073:
            L_0x0074:
                if (r9 == 0) goto L_0x0079
                r9.close()     // Catch:{ Exception -> 0x0079 }
            L_0x0079:
                goto L_0x007b
            L_0x007a:
                throw r7
            L_0x007b:
                goto L_0x007a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.maps.d.a.a(int, int, int):byte[]");
        }

        private String b(int i, int i2, int i3) {
            return this.f3266c.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
        }
    }

    public d(Context context) {
        super(context);
    }

    public void setPathTemplate(String str) {
        this.f3261d = str;
        a aVar = this.f3260c;
        if (aVar != null) {
            aVar.a(str);
        }
        TileOverlay tileOverlay = this.f3259b;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setZIndex(float f2) {
        this.f3263f = f2;
        TileOverlay tileOverlay = this.f3259b;
        if (tileOverlay != null) {
            tileOverlay.setZIndex(f2);
        }
    }

    public void setTileSize(float f2) {
        this.f3262e = f2;
        a aVar = this.f3260c;
        if (aVar != null) {
            aVar.a((int) f2);
        }
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.f3258a == null) {
            this.f3258a = a();
        }
        return this.f3258a;
    }

    private TileOverlayOptions a() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.f3263f);
        this.f3260c = new a((int) this.f3262e, this.f3261d);
        tileOverlayOptions.tileProvider(this.f3260c);
        return tileOverlayOptions;
    }

    public Object getFeature() {
        return this.f3259b;
    }

    public void a(GoogleMap googleMap) {
        this.f3259b = googleMap.addTileOverlay(getTileOverlayOptions());
    }

    public void b(GoogleMap googleMap) {
        this.f3259b.remove();
    }
}
