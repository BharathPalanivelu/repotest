package com.shopee.app.react.modules.app.a;

import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.share.internal.ShareConstants;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.sunmi.peripheral.printer.d;
import com.sunmi.peripheral.printer.f;
import com.sunmi.peripheral.printer.g;
import com.sunmi.peripheral.printer.h;
import d.d.b.j;
import d.h.m;
import java.io.File;
import java.util.Map;

public final class b implements com.shopee.react.sdk.bridge.modules.app.edcprinter.a {

    /* renamed from: a  reason: collision with root package name */
    private final double f18719a = 384.0d;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public h f18720b;

    /* renamed from: c  reason: collision with root package name */
    private c f18721c;

    /* renamed from: d  reason: collision with root package name */
    private final c f18722d = new c();

    /* renamed from: e  reason: collision with root package name */
    private final IntentFilter f18723e;

    /* renamed from: f  reason: collision with root package name */
    private final ReactApplicationContext f18724f;

    public b(ReactApplicationContext reactApplicationContext) {
        j.b(reactApplicationContext, "context");
        this.f18724f = reactApplicationContext;
        IntentFilter intentFilter = new IntentFilter();
        for (Map.Entry key : a.a().entrySet()) {
            intentFilter.addAction((String) key.getKey());
        }
        this.f18723e = intentFilter;
    }

    public void a(com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
        j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (this.f18721c == null) {
            this.f18721c = new c(this.f18724f);
            this.f18724f.getApplicationContext().registerReceiver(this.f18721c, this.f18723e);
            f.a().a(this.f18724f.getApplicationContext(), this.f18722d.a(cVar));
            return;
        }
        com.garena.android.appkit.d.a.c("EDC printer : Already init previously and do nothing by this init command !", new Object[0]);
    }

    public void b(com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
        j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
        c(cVar);
    }

    public void a() {
        c((com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>>) null);
    }

    private final void c(com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
        if (this.f18721c != null) {
            this.f18724f.getApplicationContext().unregisterReceiver(this.f18721c);
            this.f18721c = null;
        }
        if (this.f18720b != null) {
            f.a().b(this.f18724f.getApplicationContext(), this.f18722d.a(cVar));
            this.f18720b = null;
        }
    }

    public void a(String str, com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
        j.b(str, ShareConstants.MEDIA_URI);
        j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (this.f18720b == null) {
            cVar.a(DataResponse.error(10, "Did not init printer"));
            return;
        }
        Bitmap bitmap = null;
        if (!m.a(str, "file://", false, 2, (Object) null)) {
            cVar.a(DataResponse.error(2, "invalid params"));
            return;
        }
        Uri parse = Uri.parse(str);
        j.a((Object) parse, "Uri.parse(uri)");
        File file = new File(parse.getPath());
        if (file.exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (((double) options.outWidth) > this.f18719a) {
                cVar.a(DataResponse.error(3, "invalid bitmap density"));
                return;
            }
            options.inJustDecodeBounds = false;
            try {
                bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            } catch (OutOfMemoryError unused) {
            }
            if (bitmap == null) {
                cVar.a(DataResponse.error(2, "invalid params"));
                return;
            }
            h hVar = this.f18720b;
            if (hVar != null) {
                hVar.a(bitmap, 2, (com.sunmi.peripheral.printer.a) new a(cVar).a());
                return;
            }
            b bVar = this;
            cVar.a(DataResponse.error(10, "Did not init printer"));
            return;
        }
        cVar.a(DataResponse.error(2, "invalid params"));
    }

    public void a(int i, com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
        j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
        h hVar = this.f18720b;
        if (hVar != null) {
            hVar.a(i, (com.sunmi.peripheral.printer.a) new a(cVar).a());
            return;
        }
        b bVar = this;
        cVar.a(DataResponse.error(10, "Did not init printer"));
    }

    public final class c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> f18734b;

        /* renamed from: c  reason: collision with root package name */
        private final a f18735c = new a(this);

        public c() {
        }

        public static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f18736a;

            a(c cVar) {
                this.f18736a = cVar;
            }

            /* access modifiers changed from: protected */
            public void a(h hVar) {
                b.this.f18720b = hVar;
                com.shopee.react.sdk.bridge.modules.base.c a2 = this.f18736a.f18734b;
                if (a2 != null) {
                    a2.a(DataResponse.success());
                }
                this.f18736a.f18734b = null;
            }

            /* access modifiers changed from: protected */
            public void a() {
                com.shopee.react.sdk.bridge.modules.base.c a2 = this.f18736a.f18734b;
                if (a2 != null) {
                    a2.a(DataResponse.success());
                }
                this.f18736a.f18734b = null;
            }
        }

        public final d a(com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
            this.f18734b = cVar;
            return this.f18735c;
        }
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final C0281b f18725a = new C0281b();

        /* renamed from: b  reason: collision with root package name */
        private final C0280a f18726b;

        public a(com.shopee.react.sdk.bridge.modules.base.c<DataResponse<com.shopee.navigator.b>> cVar) {
            j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
            this.f18726b = new C0280a(this, cVar);
        }

        /* renamed from: com.shopee.app.react.modules.app.a.b$a$a  reason: collision with other inner class name */
        public static final class C0280a extends g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f18727a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.shopee.react.sdk.bridge.modules.base.c f18728b;

            C0280a(a aVar, com.shopee.react.sdk.bridge.modules.base.c cVar) {
                this.f18727a = aVar;
                this.f18728b = cVar;
            }

            public void a(boolean z) {
                this.f18727a.f18725a.a(z ^ true ? 1 : 0);
                if (z) {
                    this.f18728b.a(DataResponse.success());
                }
            }

            public void a(int i, String str) {
                this.f18727a.f18725a.b(i);
                if (i == 0) {
                    this.f18728b.a(DataResponse.success());
                }
            }

            public void a(String str) {
                C0281b a2 = this.f18727a.f18725a;
                if (str == null) {
                    str = "";
                }
                a2.a(str);
            }

            public void b(int i, String str) {
                this.f18727a.f18725a.c(i);
                String b2 = com.shopee.react.sdk.a.a.f30143a.b((Object) this.f18727a.f18725a);
                this.f18728b.a(DataResponse.error(1, b2));
                com.garena.android.appkit.d.a.a(i + " : " + str + " \n details : " + b2, new Object[0]);
            }
        }

        public final g a() {
            return this.f18726b;
        }
    }

    /* renamed from: com.shopee.app.react.modules.app.a.b$b  reason: collision with other inner class name */
    public static final class C0281b {

        /* renamed from: a  reason: collision with root package name */
        private int f18729a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f18730b = -1;

        /* renamed from: c  reason: collision with root package name */
        private String f18731c = "";

        /* renamed from: d  reason: collision with root package name */
        private int f18732d = -1;

        public final void a(int i) {
            this.f18729a = i;
        }

        public final void b(int i) {
            this.f18730b = i;
        }

        public final void a(String str) {
            j.b(str, "<set-?>");
            this.f18731c = str;
        }

        public final void c(int i) {
            this.f18732d = i;
        }
    }
}
