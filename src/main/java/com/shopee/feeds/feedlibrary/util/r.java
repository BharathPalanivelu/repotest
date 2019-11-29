package com.shopee.feeds.feedlibrary.util;

import a.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.google.a.f;
import com.shopee.feeds.feedlibrary.a.a.d;
import com.shopee.feeds.feedlibrary.data.c.c;
import com.shopee.feeds.feedlibrary.data.c.d;
import com.shopee.feeds.feedlibrary.data.c.g;
import com.shopee.feeds.feedlibrary.data.entity.ImageStickerItemEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductRequestItem;
import com.shopee.feeds.feedlibrary.data.entity.SignatureEntity;
import com.shopee.feeds.feedlibrary.data.entity.UserEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.view.preview.j;
import com.squareup.a.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class r {

    /* renamed from: a  reason: collision with root package name */
    d f28361a;

    /* renamed from: b  reason: collision with root package name */
    g f28362b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.data.c.a f28363c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.data.d.b f28364d = com.shopee.feeds.feedlibrary.b.b().a();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f28365e;

    public interface a {
        void a(String str);
    }

    public interface b {
        void a();
    }

    public r(Context context) {
        this.f28365e = context;
        this.f28361a = new d(context);
        this.f28362b = new g(context);
        this.f28363c = new com.shopee.feeds.feedlibrary.data.c.a(context);
    }

    public void a(final com.shopee.feeds.feedlibrary.a.a aVar) {
        this.f28361a.a(new com.shopee.feeds.feedlibrary.a.a() {
            public void a(String str) {
            }

            public void a(Object obj, String str) {
                MediaCompressParam mediaCompressParam = (MediaCompressParam) obj;
                if (mediaCompressParam != null) {
                    com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(mediaCompressParam, "");
                    }
                }
            }
        });
    }

    public void a() {
        this.f28361a.b(new com.shopee.feeds.feedlibrary.a.a() {
            public void a(String str) {
            }

            public void a(final Object obj, String str) {
                k.a(new Callable<Void>() {
                    /* renamed from: a */
                    public Void call() throws Exception {
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList == null || arrayList.size() <= 0) {
                            return null;
                        }
                        for (int i = 0; i < arrayList.size(); i++) {
                            w.a(r.this.f28365e).a(com.shopee.feeds.feedlibrary.data.c.b.b(((ImageStickerItemEntity) arrayList.get(i)).getUrl())).i();
                        }
                        return null;
                    }
                });
            }
        });
    }

    public void b() {
        this.f28362b.c(0, 10, 3, false, new com.shopee.feeds.feedlibrary.a.a() {
            public void a(String str) {
            }

            public void a(Object obj, String str) {
                final ProductEntity productEntity = (ProductEntity) obj;
                if (productEntity != null && productEntity.getItems().size() > 0) {
                    k.a(new Callable<Object>() {
                        public Object call() throws Exception {
                            ArrayList<ProductEntity.ProductItem> items = productEntity.getItems();
                            if (items.size() <= 0) {
                                return null;
                            }
                            com.shopee.feeds.feedlibrary.data.d.a.a(r.this.f28365e).a("key_my_product", (Serializable) productEntity);
                            for (int i = 0; i < Math.min(4, items.size()); i++) {
                                w.a(r.this.f28365e).a(com.shopee.feeds.feedlibrary.data.c.b.b(items.get(i).getImage())).i();
                            }
                            return null;
                        }
                    });
                }
            }
        });
    }

    public void c() {
        this.f28362b.a(0, 10, 3, false, new com.shopee.feeds.feedlibrary.a.a() {
            public void a(String str) {
            }

            public void a(Object obj, String str) {
                final ProductEntity productEntity = (ProductEntity) obj;
                if (productEntity != null && productEntity.getItems().size() > 0) {
                    k.a(new Callable<Object>() {
                        public Object call() throws Exception {
                            ArrayList<ProductEntity.ProductItem> items = productEntity.getItems();
                            if (items.size() <= 0) {
                                return null;
                            }
                            com.shopee.feeds.feedlibrary.data.d.a.a(r.this.f28365e).a("key_fav_product", (Serializable) productEntity);
                            for (int i = 0; i < Math.min(4, items.size()); i++) {
                                w.a(r.this.f28365e).a(com.shopee.feeds.feedlibrary.data.c.b.b(items.get(i).getImage())).i();
                            }
                            return null;
                        }
                    });
                }
            }
        });
    }

    public void d() {
        this.f28364d.a(4);
        if (c.f27687a == 0) {
            this.f28364d.a(4);
        } else {
            this.f28363c.b(3, false, new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    if (((UserEntity) obj).is_seller()) {
                        r.this.f28364d.a(4);
                    } else {
                        r.this.f28364d.a(5);
                    }
                }

                public void a(String str) {
                    if (!d.a(str)) {
                        u.a(r.this.f28365e, str);
                    }
                    r.this.f28364d.a(4);
                }
            });
        }
    }

    public void e() {
        d.a aVar = new d.a(this.f28365e);
        aVar.a(com.shopee.feeds.feedlibrary.data.c.b.p).b().e().a(3);
        aVar.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    try {
                        SignatureEntity signatureEntity = (SignatureEntity) new f().a(new JSONObject(cVar.a()).toString(), SignatureEntity.class);
                        if (signatureEntity != null) {
                            j.a().e(signatureEntity.getSign());
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void a(int i, String str) {
                h.b("", "");
            }
        });
        aVar.f().a();
    }

    public void a(Context context, String str, a aVar, VideoEditEntity videoEditEntity) {
        final String str2 = str;
        final Context context2 = context;
        final VideoEditEntity videoEditEntity2 = videoEditEntity;
        final a aVar2 = aVar;
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                try {
                    h.b("PostStatusTask", "maybe PostStatusTask getCover " + str2);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str2);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    if (frameAtTime != null) {
                        String a2 = k.a(context2, frameAtTime);
                        if (!d.a(a2)) {
                            j.a().f(a2);
                            videoEditEntity2.setCoverPath(a2);
                        }
                    }
                } catch (Throwable th) {
                    h.b("", "PostStatusTask getCoverFromVideoByPost excpetion ");
                    th.printStackTrace();
                }
                aVar2.a(j.a().z());
                return null;
            }
        });
    }

    public void a(final b bVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                j.a(true);
                bVar.a();
                return null;
            }
        });
    }

    public void a(final Context context, final String str, final a aVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                final String str;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                if (frameAtTime != null) {
                    str = k.a(context, frameAtTime);
                    if (!d.a(str)) {
                        j.a().f(str);
                    }
                } else {
                    str = null;
                }
                com.garena.android.appkit.f.f.a().a(new Runnable() {
                    public void run() {
                        aVar.a(str);
                    }
                });
                return null;
            }
        });
    }

    public void a(int i, String str, com.shopee.feeds.feedlibrary.a.a aVar) {
        com.shopee.feeds.feedlibrary.data.c.b.h();
        ProductRequestItem productRequestItem = new ProductRequestItem();
        productRequestItem.setItem_ids(str);
        productRequestItem.setShop_id(String.valueOf(i));
        this.f28361a.a(productRequestItem, false, aVar);
    }

    public void f() {
        com.shopee.feeds.feedlibrary.data.d.a.a(this.f28365e).c("key_my_product");
        com.shopee.feeds.feedlibrary.data.d.a.a(this.f28365e).c("key_fav_product");
    }
}
