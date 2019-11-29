package com.modiface.mfemakeupkit.effects;

import com.google.a.l;
import com.google.a.n;
import com.google.a.o;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import com.google.a.w;
import java.io.IOException;
import java.lang.reflect.Type;

public class MFEMakeupMaskLayer extends MFEMakeupLayer {
    private static final String kRelativePath = "MFELiveMakeup/";
    public BlendMode blendMode = BlendMode.Makeup;
    public boolean isMaskPathRelative = false;
    public int maskImageHeight;
    @com.google.a.a.b(a = b.class)
    private a maskImagePath = new a();
    @com.google.a.a.b(a = d.class)
    private c maskImageSize = new c();
    public int maskImageWidth;
    public String maskPath = null;
    @com.google.a.a.b(a = e.class)
    public int sourceSide = 1;
    @com.google.a.a.b(a = e.class)
    public int targetSide = 3;

    public enum BlendMode {
        Makeup,
        AlphaBlend,
        MakeupBlend,
        SolidColorBlend;

        public static String[] getEnumNames() {
            BlendMode[] values = values();
            String[] strArr = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                strArr[i] = values[i].name();
            }
            return strArr;
        }
    }

    public static final class Side {
        public static final int Both = 3;
        public static final int Left = 1;
        public static final int None = 0;
        public static final int Right = 2;
    }

    private class a {
        private a() {
        }

        /* access modifiers changed from: package-private */
        public String a() {
            MFEMakeupMaskLayer mFEMakeupMaskLayer = MFEMakeupMaskLayer.this;
            if (mFEMakeupMaskLayer.maskPath == null || !mFEMakeupMaskLayer.isMaskPathRelative) {
                return MFEMakeupMaskLayer.this.maskPath;
            }
            return MFEMakeupMaskLayer.kRelativePath + MFEMakeupMaskLayer.this.maskPath;
        }
    }

    private static final class b implements t<a> {
        private b() {
        }

        /* renamed from: a */
        public l serialize(a aVar, Type type, s sVar) {
            String a2 = aVar != null ? aVar.a() : null;
            if (a2 == null) {
                return n.f8933a;
            }
            return new r(a2);
        }
    }

    private class c {
        private c() {
        }

        /* access modifiers changed from: private */
        public int a() {
            return MFEMakeupMaskLayer.this.maskImageHeight;
        }

        /* access modifiers changed from: private */
        public int b() {
            return MFEMakeupMaskLayer.this.maskImageWidth;
        }
    }

    private static final class d implements t<c> {
        private d() {
        }

        /* renamed from: a */
        public l serialize(c cVar, Type type, s sVar) {
            int i;
            int i2 = 0;
            if (cVar != null) {
                i2 = cVar.b();
                i = cVar.a();
            } else {
                i = 0;
            }
            if (i2 <= 0 || i <= 0) {
                return n.f8933a;
            }
            o oVar = new o();
            oVar.a("width", (Number) Integer.valueOf(i2));
            oVar.a("height", (Number) Integer.valueOf(i));
            return oVar;
        }
    }

    private static final class e extends w<Integer> {
        private e() {
        }

        /* renamed from: a */
        public void write(com.google.a.d.c cVar, Integer num) throws IOException {
            if (num == null) {
                cVar.b("MFEMakeupLayerSideLeft");
                return;
            }
            int intValue = num.intValue();
            if (intValue == 0) {
                cVar.b("MFEMakeupLayerSideNone");
            } else if (intValue == 1) {
                cVar.b("MFEMakeupLayerSideLeft");
            } else if (intValue == 2) {
                cVar.b("MFEMakeupLayerSideRight");
            } else if (intValue != 3) {
                cVar.b("MFEMakeupLayerSideLeft");
            } else {
                cVar.b("MFEMakeupLayerSideBoth");
            }
        }

        public Integer read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return 1;
            }
            String h = aVar.h();
            char c2 = 65535;
            int hashCode = h.hashCode();
            if (hashCode != -678311436) {
                if (hashCode != -678023558) {
                    if (hashCode != -677954133) {
                        if (hashCode == 461767177 && h.equals("MFEMakeupLayerSideRight")) {
                            c2 = 1;
                        }
                    } else if (h.equals("MFEMakeupLayerSideNone")) {
                        c2 = 3;
                    }
                } else if (h.equals("MFEMakeupLayerSideLeft")) {
                    c2 = 0;
                }
            } else if (h.equals("MFEMakeupLayerSideBoth")) {
                c2 = 2;
            }
            if (c2 == 0) {
                return 1;
            }
            if (c2 == 1) {
                return 2;
            }
            if (c2 == 2) {
                return 3;
            }
            if (c2 != 3) {
                return 1;
            }
            return 0;
        }
    }

    public MFEMakeupMaskLayer() {
    }

    public MFEMakeupMaskLayer(MFEMakeupProduct mFEMakeupProduct) {
        super(mFEMakeupProduct);
    }
}
