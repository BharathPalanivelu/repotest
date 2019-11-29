package com.shopee.app.react.view.sketchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.share.internal.ShareConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public interface d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19111b = a.f19112a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f19113a;

        /* renamed from: b  reason: collision with root package name */
        private final int f19114b;

        /* renamed from: c  reason: collision with root package name */
        private final String f19115c;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (this.f19113a == bVar.f19113a) {
                        if (!(this.f19114b == bVar.f19114b) || !j.a((Object) this.f19115c, (Object) bVar.f19115c)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = ((Integer.valueOf(this.f19113a).hashCode() * 31) + Integer.valueOf(this.f19114b).hashCode()) * 31;
            String str = this.f19115c;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SavingResponse(width=" + this.f19113a + ", height=" + this.f19114b + ", uri=" + this.f19115c + SQLBuilder.PARENTHESES_RIGHT;
        }

        public b(int i, int i2, String str) {
            j.b(str, ShareConstants.MEDIA_URI);
            this.f19113a = i;
            this.f19114b = i2;
            this.f19115c = str;
        }

        public final WritableMap a() {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("width", this.f19113a);
            createMap.putInt("height", this.f19114b);
            createMap.putString(ShareConstants.MEDIA_URI, this.f19115c);
            j.a((Object) createMap, "Arguments.createMap()\n  …\"uri\", uri)\n            }");
            return createMap;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f19112a = new a();

        private a() {
        }
    }
}
