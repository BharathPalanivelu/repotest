package com.shopee.feeds.feedlibrary.data.c;

import android.content.Context;
import com.google.a.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.a.a.c;
import com.shopee.feeds.feedlibrary.a.a.d;
import com.shopee.feeds.feedlibrary.data.entity.ImageStickerItemEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductRequestItem;
import com.shopee.feeds.feedlibrary.data.entity.VoucherEntity;
import com.shopee.sdk.b;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f27688a;

    public d(Context context) {
        this.f27688a = context;
    }

    public void a(final a aVar) {
        OkHttpClient a2 = b.a().g().a();
        CacheControl build = new CacheControl.Builder().noCache().build();
        if (a2 != null) {
            Request.Builder builder = new Request.Builder();
            builder.url(b.k());
            builder.cacheControl(build);
            FirebasePerfOkHttpClient.enqueue(a2.newCall(builder.build()), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                }

                public void onResponse(Call call, Response response) throws IOException {
                    ResponseBody body = response.body();
                    if (body != null) {
                        String string = body.string();
                        if (string != null && !com.shopee.feeds.feedlibrary.util.d.a(string)) {
                            try {
                                final MediaCompressParam mediaCompressParam = (MediaCompressParam) new f().a(string, MediaCompressParam.class);
                                if (mediaCompressParam != null && aVar != null) {
                                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                                        public void run() {
                                            aVar.a(mediaCompressParam, "from_network");
                                        }
                                    });
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    public void b(final a aVar) {
        OkHttpClient a2 = b.a().g().a();
        CacheControl build = new CacheControl.Builder().noCache().build();
        if (a2 != null) {
            Request.Builder builder = new Request.Builder();
            builder.url(b.j());
            builder.cacheControl(build);
            FirebasePerfOkHttpClient.enqueue(a2.newCall(builder.build()), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                }

                public void onResponse(Call call, Response response) throws IOException {
                    ResponseBody body = response.body();
                    if (body != null) {
                        String string = body.string();
                        if (string != null && !com.shopee.feeds.feedlibrary.util.d.a(string)) {
                            try {
                                final ArrayList arrayList = (ArrayList) new f().a(new JSONArray(string).toString(), new com.google.a.c.a<ArrayList<ImageStickerItemEntity>>() {
                                }.getType());
                                if (arrayList != null && aVar != null) {
                                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                                        public void run() {
                                            aVar.a(arrayList, "from_network");
                                        }
                                    });
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(int i, boolean z, final a aVar) {
        d.a aVar2 = new d.a(this.f27688a);
        aVar2.a(b.w).b().e().a(i);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        ArrayList arrayList = (ArrayList) new f().a(new JSONArray(cVar.a()).toString(), new com.google.a.c.a<ArrayList<VoucherEntity>>() {
                        }.getType());
                        if (arrayList != null && aVar != null) {
                            aVar.a(arrayList, "from_network");
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void a(int i, String str) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str);
                }
            }
        });
        aVar2.f().a();
    }

    public void a(ProductRequestItem productRequestItem, boolean z, final a aVar) {
        d.a aVar2 = new d.a(this.f27688a);
        if (z) {
            aVar2.c();
        }
        String a2 = b.a();
        aVar2.a(com.shopee.feeds.feedlibrary.util.d.a(a2, "shop_id=" + productRequestItem.getShop_id(), "item_ids=" + productRequestItem.getItem_ids())).b().e().a(3);
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        ArrayList arrayList = (ArrayList) new f().a(new JSONArray(new JSONObject(cVar.a()).optString("items")).toString(), new com.google.a.c.a<ArrayList<ProductEntity.ProductItem>>() {
                        }.getType());
                        if (arrayList != null && aVar != null) {
                            aVar.a(arrayList, "from_network");
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void a(int i, String str) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str);
                }
            }
        });
        aVar2.f().a();
    }
}
