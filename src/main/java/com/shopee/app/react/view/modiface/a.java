package com.shopee.app.react.view.modiface;

import android.graphics.Color;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer;
import com.modiface.mfemakeupkit.effects.MFEMakeupConcealerLayer;
import com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer;
import com.modiface.mfemakeupkit.effects.MFEMakeupEyeshadowLayer;
import com.modiface.mfemakeupkit.effects.MFEMakeupLayer;
import com.modiface.mfemakeupkit.effects.MFEMakeupLook;
import com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer;
import com.modiface.mfemakeupkit.effects.MFEMakeupProduct;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public MFEMakeupLook f19054a = new MFEMakeupLook();

    /* renamed from: b  reason: collision with root package name */
    private final b f19055b;

    /* renamed from: com.shopee.app.react.view.modiface.a$a  reason: collision with other inner class name */
    static final class C0290a extends k implements d.d.a.b<Object, p> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0290a(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public /* synthetic */ Object a(Object obj) {
            b(obj);
            return p.f32714a;
        }

        public final void b(Object obj) {
            if (!(obj instanceof ReadableMap)) {
                obj = null;
            }
            ReadableMap readableMap = (ReadableMap) obj;
            if (readableMap != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                mFEMakeupProduct.color = this.this$0.l(readableMap);
                mFEMakeupProduct.amount = this.this$0.m(readableMap);
                mFEMakeupProduct.gloss = this.this$0.r(readableMap);
                mFEMakeupProduct.glitter = this.this$0.p(readableMap);
                mFEMakeupProduct.glitterColor = this.this$0.q(readableMap);
                this.this$0.f19054a.blushLayers.add(new MFEMakeupBlushLayer(this.this$0.A(readableMap), mFEMakeupProduct));
            }
        }
    }

    static final class b extends k implements d.d.a.b<Object, p> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public /* synthetic */ Object a(Object obj) {
            b(obj);
            return p.f32714a;
        }

        public final void b(Object obj) {
            if (!(obj instanceof ReadableMap)) {
                obj = null;
            }
            ReadableMap readableMap = (ReadableMap) obj;
            if (readableMap != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                mFEMakeupProduct.color = this.this$0.l(readableMap);
                mFEMakeupProduct.amount = this.this$0.m(readableMap);
                mFEMakeupProduct.gloss = this.this$0.r(readableMap);
                mFEMakeupProduct.glitter = this.this$0.p(readableMap);
                mFEMakeupProduct.glitterColor = this.this$0.q(readableMap);
                this.this$0.f19054a.eyeLinerLayers.add(new MFEMakeupEyeLinerLayer(this.this$0.y(readableMap), mFEMakeupProduct));
            }
        }
    }

    static final class c extends k implements d.d.a.b<Object, p> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public /* synthetic */ Object a(Object obj) {
            b(obj);
            return p.f32714a;
        }

        public final void b(Object obj) {
            if (!(obj instanceof ReadableMap)) {
                obj = null;
            }
            ReadableMap readableMap = (ReadableMap) obj;
            if (readableMap != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                mFEMakeupProduct.color = this.this$0.l(readableMap);
                mFEMakeupProduct.amount = this.this$0.m(readableMap);
                mFEMakeupProduct.gloss = this.this$0.r(readableMap);
                mFEMakeupProduct.glitter = this.this$0.p(readableMap);
                mFEMakeupProduct.glitterColor = this.this$0.q(readableMap);
                this.this$0.f19054a.eyeShadowLayers.add(new MFEMakeupEyeshadowLayer(MFEMakeupEyeshadowLayer.Presets.FullLid, mFEMakeupProduct));
            }
        }
    }

    static final class d extends k implements d.d.a.b<Object, p> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public /* synthetic */ Object a(Object obj) {
            b(obj);
            return p.f32714a;
        }

        public final void b(Object obj) {
            if (!(obj instanceof ReadableMap)) {
                obj = null;
            }
            ReadableMap readableMap = (ReadableMap) obj;
            if (readableMap != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                mFEMakeupProduct.color = this.this$0.l(readableMap);
                mFEMakeupProduct.amount = this.this$0.m(readableMap);
                this.this$0.f19054a.mascaraLayers.add(new MFEMakeupMascaraLayer(this.this$0.z(readableMap), mFEMakeupProduct));
            }
        }
    }

    public a(b bVar) {
        j.b(bVar, "modiFaceView");
        this.f19055b = bVar;
    }

    public final void a() {
        this.f19055b.setLook(this.f19054a);
    }

    public final a b() {
        this.f19054a = new MFEMakeupLook();
        return this;
    }

    /* access modifiers changed from: private */
    public final int l(ReadableMap readableMap) {
        try {
            return Color.parseColor(readableMap.getString("hexColor"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public final int m(ReadableMap readableMap) {
        return readableMap.getInt("intensity");
    }

    private final int n(ReadableMap readableMap) {
        return readableMap.getInt("amount");
    }

    private final int o(ReadableMap readableMap) {
        return readableMap.getInt("glitter");
    }

    /* access modifiers changed from: private */
    public final int p(ReadableMap readableMap) {
        return readableMap.getInt("sparkle");
    }

    /* access modifiers changed from: private */
    public final int q(ReadableMap readableMap) {
        try {
            return Color.parseColor(readableMap.getString("sparkleHex"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public final int r(ReadableMap readableMap) {
        return readableMap.getInt("gloss");
    }

    private final int s(ReadableMap readableMap) {
        return readableMap.getInt("wetness");
    }

    private final int t(ReadableMap readableMap) {
        return readableMap.getInt("lipWetness");
    }

    private final int u(ReadableMap readableMap) {
        return readableMap.getInt("glossDetail");
    }

    private final int v(ReadableMap readableMap) {
        return readableMap.getInt("foundationGlow");
    }

    private final int w(ReadableMap readableMap) {
        return readableMap.getInt("foundationSmoothing");
    }

    private final int x(ReadableMap readableMap) {
        return readableMap.getInt("foundationMatteness");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        if (r2 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets y(com.facebook.react.bridge.ReadableMap r2) {
        /*
            r1 = this;
            java.lang.String r0 = "eyelinerType"
            java.lang.String r2 = r2.getString(r0)
            if (r2 == 0) goto L_0x001e
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r0)
            if (r2 == 0) goto L_0x001e
            goto L_0x0020
        L_0x0016:
            d.m r2 = new d.m
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r2.<init>(r0)
            throw r2
        L_0x001e:
            java.lang.String r2 = ""
        L_0x0020:
            int r0 = r2.hashCode()
            switch(r0) {
                case -2099154286: goto L_0x01a1;
                case -2033515204: goto L_0x0196;
                case -1762577237: goto L_0x018b;
                case -1663051630: goto L_0x0180;
                case -1367543141: goto L_0x0175;
                case -1349088399: goto L_0x016a;
                case -1267302372: goto L_0x015f;
                case -940638868: goto L_0x0154;
                case -898537713: goto L_0x0149;
                case -891528531: goto L_0x013d;
                case -787749398: goto L_0x0131;
                case -697734626: goto L_0x0125;
                case -305914256: goto L_0x0119;
                case -86679876: goto L_0x010d;
                case -73202823: goto L_0x0101;
                case -72798333: goto L_0x00f5;
                case -12963834: goto L_0x00e9;
                case 3297640: goto L_0x00dd;
                case 107031124: goto L_0x00d1;
                case 109562243: goto L_0x00c5;
                case 311132151: goto L_0x00b9;
                case 434574433: goto L_0x00ad;
                case 555835639: goto L_0x00a1;
                case 910775096: goto L_0x0095;
                case 1058743622: goto L_0x0089;
                case 1116472035: goto L_0x007d;
                case 1191916757: goto L_0x0071;
                case 1728911401: goto L_0x0065;
                case 1802260394: goto L_0x0059;
                case 1823031597: goto L_0x004d;
                case 1832058424: goto L_0x0041;
                case 2037436765: goto L_0x0035;
                case 2056645929: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x01ac
        L_0x0029:
            java.lang.String r0 = "natural2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Natural2
            goto L_0x01ae
        L_0x0035:
            java.lang.String r0 = "wingedsmall"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedSmall
            goto L_0x01ae
        L_0x0041:
            java.lang.String r0 = "naturalfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.NaturalFull
            goto L_0x01ae
        L_0x004d:
            java.lang.String r0 = "smokywinged"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.SmokyWinged
            goto L_0x01ae
        L_0x0059:
            java.lang.String r0 = "cateyefull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.CatEyeFull
            goto L_0x01ae
        L_0x0065:
            java.lang.String r0 = "natural"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Natural
            goto L_0x01ae
        L_0x0071:
            java.lang.String r0 = "smokynaturalfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.SmokyNaturalFull
            goto L_0x01ae
        L_0x007d:
            java.lang.String r0 = "puppyfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.PuppyFull
            goto L_0x01ae
        L_0x0089:
            java.lang.String r0 = "smokynatural"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.SmokyNatural
            goto L_0x01ae
        L_0x0095:
            java.lang.String r0 = "natural2full"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Natural2Full
            goto L_0x01ae
        L_0x00a1:
            java.lang.String r0 = "cateye2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.CatEye2
            goto L_0x01ae
        L_0x00ad:
            java.lang.String r0 = "wingedextrasmall"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedExtraSmall
            goto L_0x01ae
        L_0x00b9:
            java.lang.String r0 = "kohlfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.KohlFull
            goto L_0x01ae
        L_0x00c5:
            java.lang.String r0 = "smoky"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Smoky
            goto L_0x01ae
        L_0x00d1:
            java.lang.String r0 = "puppy"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Puppy
            goto L_0x01ae
        L_0x00dd:
            java.lang.String r0 = "kohl"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Kohl
            goto L_0x01ae
        L_0x00e9:
            java.lang.String r0 = "cateye2full"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.CatEye2Full
            goto L_0x01ae
        L_0x00f5:
            java.lang.String r0 = "wingedthin"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedThin
            goto L_0x01ae
        L_0x0101:
            java.lang.String r0 = "wingedfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedFull
            goto L_0x01ae
        L_0x010d:
            java.lang.String r0 = "subtlefull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.SubtleFull
            goto L_0x01ae
        L_0x0119:
            java.lang.String r0 = "wingedextrasmallfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedExtraSmallFull
            goto L_0x01ae
        L_0x0125:
            java.lang.String r0 = "smoky2full"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Smoky2Full
            goto L_0x01ae
        L_0x0131:
            java.lang.String r0 = "winged"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Winged
            goto L_0x01ae
        L_0x013d:
            java.lang.String r0 = "subtle"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Subtle
            goto L_0x01ae
        L_0x0149:
            java.lang.String r0 = "smoky2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Smoky2
            goto L_0x01ae
        L_0x0154:
            java.lang.String r0 = "wingedsmallfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedSmallFull
            goto L_0x01ae
        L_0x015f:
            java.lang.String r0 = "wingedsimple"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedSimple
            goto L_0x01ae
        L_0x016a:
            java.lang.String r0 = "custom"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Custom
            goto L_0x01ae
        L_0x0175:
            java.lang.String r0 = "cateye"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.CatEye
            goto L_0x01ae
        L_0x0180:
            java.lang.String r0 = "wingedthinfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedThinFull
            goto L_0x01ae
        L_0x018b:
            java.lang.String r0 = "wingedsimplefull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.WingedSimpleFull
            goto L_0x01ae
        L_0x0196:
            java.lang.String r0 = "smokywingedfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.SmokyWingedFull
            goto L_0x01ae
        L_0x01a1:
            java.lang.String r0 = "smokyfull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01ac
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.SmokyFull
            goto L_0x01ae
        L_0x01ac:
            com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer.Presets.Natural
        L_0x01ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.view.modiface.a.y(com.facebook.react.bridge.ReadableMap):com.modiface.mfemakeupkit.effects.MFEMakeupEyeLinerLayer$Presets");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        if (r2 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets z(com.facebook.react.bridge.ReadableMap r2) {
        /*
            r1 = this;
            java.lang.String r0 = "mascaraType"
            java.lang.String r2 = r2.getString(r0)
            if (r2 == 0) goto L_0x001e
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r0)
            if (r2 == 0) goto L_0x001e
            goto L_0x0020
        L_0x0016:
            d.m r2 = new d.m
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r2.<init>(r0)
            throw r2
        L_0x001e:
            java.lang.String r2 = ""
        L_0x0020:
            int r0 = r2.hashCode()
            switch(r0) {
                case -1349088399: goto L_0x011d;
                case -1233992444: goto L_0x0112;
                case -1106363674: goto L_0x0107;
                case -988682624: goto L_0x00fc;
                case -916704537: goto L_0x00f1;
                case -891528531: goto L_0x00e6;
                case -810883302: goto L_0x00db;
                case -171388849: goto L_0x00d0;
                case -138079882: goto L_0x00c5;
                case -86679876: goto L_0x00b9;
                case 3089227: goto L_0x00ad;
                case 29027670: goto L_0x00a1;
                case 95470367: goto L_0x0095;
                case 95766087: goto L_0x0089;
                case 95844967: goto L_0x007d;
                case 99665299: goto L_0x0071;
                case 103164673: goto L_0x0065;
                case 632421464: goto L_0x0059;
                case 910775096: goto L_0x004d;
                case 1728911401: goto L_0x0041;
                case 1803304494: goto L_0x0035;
                case 2056645929: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0128
        L_0x0029:
            java.lang.String r0 = "natural2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Natural2
            goto L_0x012a
        L_0x0035:
            java.lang.String r0 = "densefull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.DenseFull
            goto L_0x012a
        L_0x0041:
            java.lang.String r0 = "natural"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Natural
            goto L_0x012a
        L_0x004d:
            java.lang.String r0 = "natural2full"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Natural2Full
            goto L_0x012a
        L_0x0059:
            java.lang.String r0 = "volume2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Volume2
            goto L_0x012a
        L_0x0065:
            java.lang.String r0 = "lower"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Lower
            goto L_0x012a
        L_0x0071:
            java.lang.String r0 = "grandiosefull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.GrandioseFull
            goto L_0x012a
        L_0x007d:
            java.lang.String r0 = "drama"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Drama
            goto L_0x012a
        L_0x0089:
            java.lang.String r0 = "doll2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Doll2
            goto L_0x012a
        L_0x0095:
            java.lang.String r0 = "dense"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Dense
            goto L_0x012a
        L_0x00a1:
            java.lang.String r0 = "doll2full"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Doll2Full
            goto L_0x012a
        L_0x00ad:
            java.lang.String r0 = "doll"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Doll
            goto L_0x012a
        L_0x00b9:
            java.lang.String r0 = "subtlefull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.SubtleFull
            goto L_0x012a
        L_0x00c5:
            java.lang.String r0 = "dramafull"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.DramaFull
            goto L_0x012a
        L_0x00d0:
            java.lang.String r0 = "naturallength"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.NaturalLength
            goto L_0x012a
        L_0x00db:
            java.lang.String r0 = "volume"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Volume
            goto L_0x012a
        L_0x00e6:
            java.lang.String r0 = "subtle"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Subtle
            goto L_0x012a
        L_0x00f1:
            java.lang.String r0 = "volume2full"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Volume2Full
            goto L_0x012a
        L_0x00fc:
            java.lang.String r0 = "volumelength"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.VolumeLength
            goto L_0x012a
        L_0x0107:
            java.lang.String r0 = "length"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Length
            goto L_0x012a
        L_0x0112:
            java.lang.String r0 = "grandiose"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Grandiose
            goto L_0x012a
        L_0x011d:
            java.lang.String r0 = "custom"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0128
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Custom
            goto L_0x012a
        L_0x0128:
            com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer.Presets.Natural
        L_0x012a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.view.modiface.a.z(com.facebook.react.bridge.ReadableMap):com.modiface.mfemakeupkit.effects.MFEMakeupMascaraLayer$Presets");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        if (r2 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer.Presets A(com.facebook.react.bridge.ReadableMap r2) {
        /*
            r1 = this;
            java.lang.String r0 = "blushType"
            java.lang.String r2 = r2.getString(r0)
            if (r2 == 0) goto L_0x001e
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r0)
            if (r2 == 0) goto L_0x001e
            goto L_0x0020
        L_0x0016:
            d.m r2 = new d.m
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r2.<init>(r0)
            throw r2
        L_0x001e:
            java.lang.String r2 = ""
        L_0x0020:
            int r0 = r2.hashCode()
            switch(r0) {
                case -1349088399: goto L_0x0049;
                case -681210700: goto L_0x003e;
                case 93838592: goto L_0x0033;
                case 951540442: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0054
        L_0x0028:
            java.lang.String r0 = "contour"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0054
            com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer.Presets.Contour
            goto L_0x0056
        L_0x0033:
            java.lang.String r0 = "blush"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0054
            com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer.Presets.Blush
            goto L_0x0056
        L_0x003e:
            java.lang.String r0 = "highlight"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0054
            com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer.Presets.Highlight
            goto L_0x0056
        L_0x0049:
            java.lang.String r0 = "custom"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0054
            com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer.Presets.Custom
            goto L_0x0056
        L_0x0054:
            com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer$Presets r2 = com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer.Presets.Blush
        L_0x0056:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.view.modiface.a.A(com.facebook.react.bridge.ReadableMap):com.modiface.mfemakeupkit.effects.MFEMakeupBlushLayer$Presets");
    }

    public final a a(ReadableMap readableMap) {
        j.b(readableMap, "makeupLook");
        if (readableMap.hasKey("skinClearingAmount")) {
            this.f19054a.skinClearingAmount = (float) readableMap.getDouble("skinClearingAmount");
        }
        if (readableMap.hasKey("skinGlowAmount")) {
            this.f19054a.skinGlowAmount = (float) readableMap.getDouble("skinGlowAmount");
        }
        return this;
    }

    public a b(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("lipcolor")) {
            ReadableMap map = readableMap.getMap("lipcolor");
            if (map != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                j.a((Object) map, "it");
                mFEMakeupProduct.color = l(map);
                mFEMakeupProduct.amount = m(map);
                mFEMakeupProduct.gloss = r(map);
                mFEMakeupProduct.glossDetail = u(map);
                mFEMakeupProduct.glitter = p(map);
                mFEMakeupProduct.envMappingIntensity = t(map);
                this.f19054a.lipLayer = new MFEMakeupLayer(mFEMakeupProduct);
            }
        }
        return this;
    }

    public a c(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("lipLayer")) {
            ReadableMap map = readableMap.getMap("lipLayer");
            if (map != null) {
                int i = map.getInt("a");
                int i2 = map.getInt("r");
                int i3 = map.getInt("g");
                int i4 = map.getInt("b");
                j.a((Object) map, "this");
                int n = n(map);
                int o = o(map);
                int r = r(map);
                int s = s(map);
                int u = u(map);
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                mFEMakeupProduct.color = Color.argb(i, i2, i3, i4);
                mFEMakeupProduct.amount = n;
                mFEMakeupProduct.gloss = r;
                mFEMakeupProduct.glossDetail = u;
                mFEMakeupProduct.glitter = o;
                mFEMakeupProduct.envMappingIntensity = s;
                this.f19054a.lipLayer = new MFEMakeupLayer(mFEMakeupProduct);
            }
        }
        return this;
    }

    public a d(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("blush")) {
            ReadableArray array = readableMap.getArray("blush");
            if (array != null) {
                f.a(array, new C0290a(this));
            }
        }
        return this;
    }

    public a e(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("brow")) {
            ReadableMap map = readableMap.getMap("brow");
            if (map != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                j.a((Object) map, "it");
                mFEMakeupProduct.color = l(map);
                mFEMakeupProduct.amount = m(map);
                this.f19054a.browLayer = new MFEMakeupLayer(mFEMakeupProduct);
            }
        }
        return this;
    }

    public a f(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("concealer")) {
            ReadableMap map = readableMap.getMap("concealer");
            if (map != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                j.a((Object) map, "it");
                mFEMakeupProduct.color = l(map);
                mFEMakeupProduct.amount = m(map);
                mFEMakeupProduct.gloss = r(map);
                mFEMakeupProduct.glitter = p(map);
                mFEMakeupProduct.glitterColor = q(map);
                this.f19054a.concealerLayer = new MFEMakeupConcealerLayer(MFEMakeupConcealerLayer.Presets.Default, mFEMakeupProduct);
            }
        }
        return this;
    }

    public a g(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("eyeliner")) {
            ReadableArray array = readableMap.getArray("eyeliner");
            if (array != null) {
                f.a(array, new b(this));
            }
        }
        return this;
    }

    public a h(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("eyeshadow")) {
            ReadableArray array = readableMap.getArray("eyeshadow");
            if (array != null) {
                f.a(array, new c(this));
            }
        }
        return this;
    }

    public a i(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("foundation")) {
            ReadableMap map = readableMap.getMap("foundation");
            if (map != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                j.a((Object) map, "it");
                mFEMakeupProduct.color = l(map);
                mFEMakeupProduct.amount = m(map);
                mFEMakeupProduct.skinGlow = v(map);
                mFEMakeupProduct.skinClearing = w(map);
                mFEMakeupProduct.contrastBoost = x(map);
                this.f19054a.foundationLayer = new MFEMakeupLayer(mFEMakeupProduct);
            }
        }
        return this;
    }

    public a j(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("lipliner")) {
            ReadableMap map = readableMap.getMap("lipliner");
            if (map != null) {
                MFEMakeupProduct mFEMakeupProduct = new MFEMakeupProduct();
                j.a((Object) map, "it");
                mFEMakeupProduct.color = l(map);
                mFEMakeupProduct.amount = m(map);
                mFEMakeupProduct.gloss = r(map);
                mFEMakeupProduct.glossDetail = u(map);
                mFEMakeupProduct.glitter = p(map);
                mFEMakeupProduct.glitterColor = q(map);
                this.f19054a.lipLinerLayer = new MFEMakeupLayer(mFEMakeupProduct);
            }
        }
        return this;
    }

    public a k(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("mascara")) {
            ReadableArray array = readableMap.getArray("mascara");
            if (array != null) {
                f.a(array, new d(this));
            }
        }
        return this;
    }
}
