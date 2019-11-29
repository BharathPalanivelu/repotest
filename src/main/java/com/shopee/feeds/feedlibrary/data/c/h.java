package com.shopee.feeds.feedlibrary.data.c;

import android.content.Context;
import com.google.a.f;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.a.a.c;
import com.shopee.feeds.feedlibrary.a.a.d;
import com.shopee.feeds.feedlibrary.data.entity.HashTagEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private Context f27714a;

    public h(Context context) {
        this.f27714a = context;
    }

    public void a(String str, int i, int i2, boolean z, final a aVar) {
        d.a aVar2 = new d.a(this.f27714a);
        String str2 = b.k;
        aVar2.a(com.shopee.feeds.feedlibrary.util.d.a(str2, "query=" + str, "limit=" + i)).b().e().a(i2);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        HashTagEntity hashTagEntity = (HashTagEntity) new f().a(new JSONObject(cVar.a()).toString(), HashTagEntity.class);
                        if (hashTagEntity != null && aVar != null) {
                            aVar.a(hashTagEntity, "from_network");
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

    public void a(String str, int i, int i2, int i3, boolean z, int i4, final a aVar) {
        d.a aVar2 = new d.a(this.f27714a);
        String str2 = b.l;
        aVar2.a(com.shopee.feeds.feedlibrary.util.d.a(str2, "query=" + str, "filter=" + i, "offset=" + i2, "limit=" + i3)).b().e().a(i4);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        SearchUserEntity searchUserEntity = (SearchUserEntity) new f().a(new JSONObject(cVar.a()).toString(), SearchUserEntity.class);
                        if (searchUserEntity != null && aVar != null) {
                            aVar.a(searchUserEntity, "from_network");
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

    public void a(String str, String str2, int i, int i2, int i3, boolean z, int i4, final a aVar) {
        d.a aVar2 = new d.a(this.f27714a);
        String str3 = b.m;
        String a2 = com.shopee.feeds.feedlibrary.util.d.a(str3, "query=" + str, "limit=" + i2, "offset=" + i);
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("BaseProductSearchActivitydb url ");
        sb3.append(sb2);
        com.shopee.feeds.feedlibrary.util.h.b("%s", sb3.toString());
        aVar2.a(sb2).b().e().a(i4);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(cVar.a());
                        ProductEntity productEntity = (ProductEntity) new f().a(jSONObject.toString(), ProductEntity.class);
                        if (!(productEntity == null || aVar == null)) {
                            aVar.a(productEntity, "from_network");
                        }
                        com.shopee.feeds.feedlibrary.util.h.b("%s", "BaseProductSearchActivitydb result " + jSONObject);
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

    public String a(com.shopee.feeds.feedlibrary.data.e.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar.f27738a == 0) {
            if (aVar.f27739b == 0) {
                stringBuffer.append("&cate=");
                stringBuffer.append("relevance");
            } else if (aVar.f27739b == 1) {
                stringBuffer.append("&cate=");
                stringBuffer.append("nearby");
            }
        } else if (aVar.f27738a == 1) {
            stringBuffer.append("&cate=");
            stringBuffer.append("latest");
        } else if (aVar.f27738a == 2) {
            stringBuffer.append("&cate=");
            stringBuffer.append("topsales");
        } else if (aVar.f27738a == 3) {
            if (aVar.f27740c == 0) {
                stringBuffer.append("&cate=");
                stringBuffer.append("price_asc");
            } else if (aVar.f27740c == 1) {
                stringBuffer.append("&cate=");
                stringBuffer.append("price_desc");
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        HashSet<String> hashSet = aVar.f27741d;
        int i = 0;
        if (hashSet != null && hashSet.size() > 0) {
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (i < hashSet.size() - 1) {
                    stringBuffer2.append(next);
                    stringBuffer2.append(",");
                } else {
                    stringBuffer2.append(next);
                }
                i++;
            }
            stringBuffer.append("&filters=");
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }
}
