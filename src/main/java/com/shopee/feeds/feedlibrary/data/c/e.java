package com.shopee.feeds.feedlibrary.data.c;

import android.content.Context;
import com.google.a.f;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.a.a.c;
import com.shopee.feeds.feedlibrary.a.a.d;
import com.shopee.feeds.feedlibrary.data.entity.FollowingEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f27704a;

    public e(Context context) {
        this.f27704a = context;
    }

    public void a(String str, int i, boolean z, int i2, final a aVar) {
        d.a aVar2 = new d.a(this.f27704a);
        String str2 = b.n;
        aVar2.a(com.shopee.feeds.feedlibrary.util.d.a(str2, "last_id=" + str, "limit=" + i)).b().e().a(i2);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        FollowingEntity followingEntity = (FollowingEntity) new f().a(new JSONObject(cVar.a()).toString(), FollowingEntity.class);
                        if (followingEntity != null && aVar != null) {
                            aVar.a(followingEntity, "from_network");
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
