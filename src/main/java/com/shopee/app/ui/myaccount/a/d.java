package com.shopee.app.ui.myaccount.a;

import android.app.Activity;
import b.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.e;
import com.shopee.app.data.store.ba;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.k.h;

public final class d implements b<b> {
    public static void a(b bVar, a aVar) {
        bVar.setMPresenter(aVar);
    }

    public static void a(b bVar, bc bcVar) {
        bVar.setMScope(bcVar);
    }

    public static void a(b bVar, ak akVar) {
        bVar.setMNavigator(akVar);
    }

    public static void a(b bVar, UserInfo userInfo) {
        bVar.setMUser(userInfo);
    }

    public static void a(b bVar, r rVar) {
        bVar.setMProgress(rVar);
    }

    public static void a(b bVar, h hVar) {
        bVar.setMUploader(hVar);
    }

    public static void a(b bVar, ba baVar) {
        bVar.setMUploadStore(baVar);
    }

    public static void a(b bVar, Activity activity) {
        bVar.setMActivity(activity);
    }

    public static void a(b bVar, e eVar) {
        bVar.setCleanTemporaryFilesInteractor(eVar);
    }
}
