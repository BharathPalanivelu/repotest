package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.beetalklib.network.file.a.i;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.h.a.g;
import com.shopee.app.h.f;
import com.shopee.app.h.l;
import com.shopee.app.h.p;
import com.shopee.app.util.f.a;
import com.shopee.app.util.n;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class cu extends com.shopee.app.d.c.a.a<b> {

    /* renamed from: d  reason: collision with root package name */
    private final com.shopee.app.util.f.a f16727d;

    /* renamed from: e  reason: collision with root package name */
    private SettingConfigStore f16728e;

    class a extends com.shopee.app.util.f.a {
        public a(p pVar, UserInfo userInfo) {
            super(pVar, userInfo);
        }

        public void a(int i) {
            super.a(i);
            this.f26352c.g();
        }

        public int a(String str) {
            g.f17615a.a(this.f26352c.d(), str, f.a().b(str), String.valueOf(this.f26353d.getUserId()), (i) this);
            try {
                return ((Integer) this.f26351b.take()).intValue();
            } catch (InterruptedException unused) {
                return 2;
            }
        }
    }

    protected cu(n nVar, SettingConfigStore settingConfigStore, p pVar, UserInfo userInfo) {
        super(nVar);
        this.f16728e = settingConfigStore;
        this.f16727d = new a(pVar, userInfo);
    }

    public void a(String str) {
        b(new b(str));
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        final String a2 = bVar.f16732a;
        Uri parse = Uri.parse(bVar.f16732a);
        l.b b2 = l.b(parse);
        ImageConfig imageSearchConfig = this.f16728e.getImageSearchConfig();
        Bitmap a3 = l.a().a(parse, imageSearchConfig.getFullImageWidth(), imageSearchConfig.getFullImageHeight());
        int width = a3.getWidth();
        int height = a3.getHeight();
        double min = (double) Math.min(b2.f17678a, b2.f17679b);
        double min2 = (double) Math.min(width, height);
        Double.isNaN(min);
        Double.isNaN(min2);
        double d2 = min / min2;
        if (a3 == null) {
            a(a2, 1);
            return;
        }
        String a4 = a(a3, imageSearchConfig);
        if (!TextUtils.isEmpty(a4)) {
            com.garena.android.appkit.d.a.b("image_search getImageId %s with size %dx%d", a4, Integer.valueOf(a3.getWidth()), Integer.valueOf(a3.getHeight()));
        }
        if (!a3.isRecycled()) {
            a3.recycle();
        }
        if (a4 == null) {
            a(a2, 2);
        } else if (this.f16727d.a(a4, (a.C0402a) new a.C0402a() {
            public void onProgress(int i, int i2) {
                if (i > 0) {
                    cu.this.b(a2, (int) ((((float) i2) * 90.0f) / ((float) i)));
                }
            }
        }) != 1) {
            a(a2, 3);
        } else {
            try {
                Request.Builder builder = new Request.Builder();
                Response execute = FirebasePerfOkHttpClient.execute(new OkHttpClient().newCall(builder.url(com.shopee.app.util.i.f7040c + "api/v2/" + "image_search" + "?offset=0&limit=10&md5=" + a4).build()));
                com.garena.android.appkit.d.a.b("image_search response %s", execute.toString());
                if (execute.isSuccessful()) {
                    b(a2, 100);
                    String string = execute.body().string();
                    com.garena.android.appkit.d.a.b("image_search response body %s", string);
                    if (!TextUtils.isEmpty(string) && string.contains("data") && string.contains("image")) {
                        if (string.contains("bounding_box")) {
                            JSONObject jSONObject = new JSONObject(string);
                            int i = jSONObject.getInt("error");
                            if (i == 0) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("image").getJSONObject("bounding_box");
                                int i2 = jSONObject2.getInt("width");
                                int i3 = jSONObject2.getInt("height");
                                int i4 = jSONObject2.getInt(ViewProps.TOP);
                                int i5 = jSONObject2.getInt(ViewProps.LEFT);
                                a(a2, a4, d2, new Rect(i5, i4, i2 + i5, i3 + i4));
                                return;
                            }
                            com.garena.android.appkit.d.a.a("image_search response mall api return error " + i, new Object[0]);
                            a(a2, 4);
                            return;
                        }
                    }
                    com.garena.android.appkit.d.a.a("image_search response not bounding box found", new Object[0]);
                    a(a2, 4);
                    return;
                }
                com.garena.android.appkit.d.a.a("image_search response fail", new Object[0]);
                a(a2, 4);
            } catch (IOException e2) {
                com.garena.android.appkit.d.a.a("image_search request network fail", new Object[0]);
                com.garena.android.appkit.d.a.a(e2);
                a(a2, 4);
            } catch (JSONException e3) {
                com.garena.android.appkit.d.a.a("image_search response json format error", new Object[0]);
                com.garena.android.appkit.d.a.a(e3);
                a(a2, 4);
            }
        }
    }

    private void a(String str, int i) {
        c cVar = new c(str);
        cVar.f16733a = i;
        this.f16405a.a("ON_IMAGE_SEARCH_PREPARE_FAIL", new com.garena.android.appkit.b.a(cVar));
    }

    /* access modifiers changed from: private */
    public void b(String str, int i) {
        c cVar = new c(str);
        cVar.f16734b = i;
        this.f16405a.a("ON_IMAGE_SEARCH_PREPARE_PROGRESS", new com.garena.android.appkit.b.a(cVar));
    }

    private void a(String str, String str2, double d2, Rect rect) {
        c cVar = new c(str);
        cVar.f16735c = str2;
        cVar.f16737e = d2;
        cVar.f16738f = rect;
        this.f16405a.a("ON_IMAGE_SEARCH_PREPARE_DONE", new com.garena.android.appkit.b.a(cVar));
    }

    private String a(Bitmap bitmap, ImageConfig imageConfig) {
        byte[] a2 = l.a().a(bitmap, imageConfig.getFullImageQuality());
        byte[] bArr = new byte[0];
        return com.shopee.app.h.b.a.a().a(a2);
    }

    static class b extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f16732a;

        b(String str) {
            super("PrepareImageSearchImageInteractor" + str, "use_case", 0, false);
            this.f16732a = str;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f16733a;

        /* renamed from: b  reason: collision with root package name */
        public int f16734b;

        /* renamed from: c  reason: collision with root package name */
        public String f16735c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16736d;

        /* renamed from: e  reason: collision with root package name */
        public double f16737e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f16738f;

        public c(String str) {
            this.f16736d = str;
        }

        public String toString() {
            return "PrepareImageSearchResult{error=" + this.f16733a + ", percent=" + this.f16734b + ", imageId='" + this.f16735c + '\'' + ", path='" + this.f16736d + '\'' + ", scale=" + this.f16737e + ", bound=" + this.f16738f + '}';
        }
    }
}
