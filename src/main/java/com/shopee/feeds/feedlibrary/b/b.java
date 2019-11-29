package com.shopee.feeds.feedlibrary.b;

import android.app.Activity;
import android.content.Context;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.data.c.a;
import com.shopee.feeds.feedlibrary.data.c.h;
import com.shopee.feeds.feedlibrary.data.entity.CaptionTagEntity;
import com.shopee.feeds.feedlibrary.data.entity.HashTagEntity;
import com.shopee.feeds.feedlibrary.data.entity.ImageEntity;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.x;
import com.shopee.feeds.feedlibrary.view.ToogleButton;
import com.shopee.feeds.feedlibrary.view.a.a;
import java.util.ArrayList;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    a f27572a;

    /* renamed from: b  reason: collision with root package name */
    h f27573b;

    /* renamed from: c  reason: collision with root package name */
    a.C0119a f27574c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.data.d.b f27575d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f27576e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.feeds.feedlibrary.view.widget.a f27577f;

    /* renamed from: g  reason: collision with root package name */
    private x f27578g;
    private ArrayList<ImageEntity> h = new ArrayList<>();
    private boolean i = false;
    private RobotoTextView j;

    public b(Context context, a.C0119a aVar, RobotoTextView robotoTextView) {
        this.f27576e = context;
        this.f27574c = aVar;
        this.f27572a = new com.shopee.feeds.feedlibrary.data.c.a(context);
        this.f27573b = new h(context);
        this.f27577f = new com.shopee.feeds.feedlibrary.view.widget.a((Activity) context);
        this.f27578g = new x(context, this.f27577f);
        this.f27575d = com.shopee.feeds.feedlibrary.b.b().a();
        this.j = robotoTextView;
    }

    public void a(String str, int i2, int i3) {
        int i4 = i3;
        if (i4 == 1) {
            this.f27573b.a(str, i2, 3, false, new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    HashTagEntity hashTagEntity = (HashTagEntity) obj;
                    if (hashTagEntity != null && b.this.f27574c != null) {
                        b.this.f27574c.a(hashTagEntity);
                    }
                }

                public void a(String str) {
                    if (!d.a(str)) {
                        u.a(b.this.f27576e, str);
                    }
                }
            });
        } else if (i4 == 2) {
            this.f27573b.a(str, 1, 0, 5, false, 3, new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    SearchUserEntity searchUserEntity = (SearchUserEntity) obj;
                    if (searchUserEntity != null && b.this.f27574c != null) {
                        b.this.f27574c.a(searchUserEntity);
                    }
                }

                public void a(String str) {
                    if (!d.a(str)) {
                        u.a(b.this.f27576e, str);
                    }
                }
            });
        }
    }

    public ArrayList<CaptionTagEntity> a(SearchUserEntity searchUserEntity) {
        ArrayList<CaptionTagEntity> arrayList = new ArrayList<>();
        if (searchUserEntity != null && searchUserEntity.getUsers().size() > 0) {
            for (int i2 = 0; i2 < searchUserEntity.getUsers().size(); i2++) {
                SearchUserEntity.User user = searchUserEntity.getUsers().get(i2);
                CaptionTagEntity captionTagEntity = new CaptionTagEntity();
                captionTagEntity.setType(2);
                String username = user.getUsername();
                if (!d.a(username)) {
                    captionTagEntity.setName(username.toLowerCase());
                }
                captionTagEntity.setId(user.getUser_id() + "");
                captionTagEntity.setUrl(user.getAvatar());
                arrayList.add(captionTagEntity);
            }
        }
        return arrayList;
    }

    public ArrayList<CaptionTagEntity> a(HashTagEntity hashTagEntity) {
        ArrayList<CaptionTagEntity> arrayList = new ArrayList<>();
        if (hashTagEntity != null && hashTagEntity.getHashtags().size() > 0) {
            for (int i2 = 0; i2 < hashTagEntity.getHashtags().size(); i2++) {
                CaptionTagEntity captionTagEntity = new CaptionTagEntity();
                HashTagEntity.HashTag hashTag = hashTagEntity.getHashtags().get(i2);
                if (!d.a(hashTag.getText())) {
                    captionTagEntity.setName(hashTag.getText().toLowerCase());
                }
                captionTagEntity.setType(1);
                captionTagEntity.setId(hashTag.getId());
                captionTagEntity.setNum(hashTag.getFeed_cnt());
                captionTagEntity.setUrl(hashTag.getCover());
                arrayList.add(captionTagEntity);
            }
        }
        return arrayList;
    }

    public ArrayList<String> a(ArrayList<String> arrayList, HashMap<String, String> hashMap) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 0 && hashMap.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(hashMap.get(arrayList.get(i2)));
            }
        }
        return arrayList2;
    }

    public ArrayList<String> a(ArrayList<String> arrayList, VideoEditEntity videoEditEntity) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (d.a(j.a().r())) {
            return a(arrayList, videoEditEntity.getCleanEditImagePathMap());
        }
        arrayList2.addAll(arrayList);
        return arrayList2;
    }

    public void a(ToogleButton toogleButton, ToogleButton toogleButton2) {
        int a2 = com.shopee.sdk.b.a().d().a().a();
        if (toogleButton.c()) {
            this.f27575d.b(a2, 1);
        } else {
            this.f27575d.b(a2, 0);
        }
        if (toogleButton2.c()) {
            this.f27575d.a(a2, 1);
        } else {
            this.f27575d.a(a2, 0);
        }
    }

    public void a() {
        x xVar = this.f27578g;
        if (xVar != null) {
            xVar.b();
        }
    }

    public boolean b() {
        if (this.f27575d == null || com.shopee.sdk.b.a().d() == null) {
            return false;
        }
        return this.f27575d.b(com.shopee.sdk.b.a().d().a().a());
    }

    public boolean c() {
        if (this.f27575d == null || com.shopee.sdk.b.a().d() == null) {
            return false;
        }
        return this.f27575d.c(com.shopee.sdk.b.a().d().a().a());
    }
}
