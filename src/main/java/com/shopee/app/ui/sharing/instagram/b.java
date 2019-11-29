package com.shopee.app.ui.sharing.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.ui.sharing.base.a;
import com.shopee.app.ui.sharing.base.helper.c;
import d.d.b.j;

public final class b extends a<InstagramStoryAppShareData> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Activity activity, com.shopee.app.ui.sharing.base.b bVar) {
        super(InstagramStoryAppShareData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return c.a((Context) activity, "com.instagram.android");
    }

    /* renamed from: a */
    public boolean b(InstagramStoryAppShareData instagramStoryAppShareData) {
        j.b(instagramStoryAppShareData, "shareData");
        return (instagramStoryAppShareData.getImage() == null && instagramStoryAppShareData.getVideo() == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(InstagramStoryAppShareData instagramStoryAppShareData) {
        j.b(instagramStoryAppShareData, "shareData");
        if (instagramStoryAppShareData.getImage() != null) {
            a(instagramStoryAppShareData.getImage());
        } else if (instagramStoryAppShareData.getVideo() != null) {
            a(instagramStoryAppShareData.getVideo());
        } else {
            a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
        }
    }

    public void c(String str) {
        j.b(str, "filePath");
        super.c(str);
        a(str, "video/*");
    }

    public void b(String str) {
        j.b(str, "filePath");
        a(str, "image/jpeg");
    }

    private final void a(String str, String str2) {
        Activity b2 = b();
        if (b2 != null) {
            try {
                Intent intent = new Intent("com.instagram.share.ADD_TO_STORY");
                intent.setType(str2);
                intent.setDataAndType(c.b(b2, str), str2);
                intent.setFlags(1);
                InstagramStoryAppShareData instagramStoryAppShareData = (InstagramStoryAppShareData) a();
                intent.putExtra(ShareConstants.STORY_DEEP_LINK_URL, instagramStoryAppShareData != null ? instagramStoryAppShareData.getLinkUrl() : null);
                b2.startActivity(intent);
                a(new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null));
            } catch (Exception unused) {
                a(new com.shopee.app.ui.sharing.base.data.a(-1, (String) null, 2, (g) null));
            }
        }
    }
}
