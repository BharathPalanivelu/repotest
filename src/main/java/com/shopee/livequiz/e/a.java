package com.shopee.livequiz.e;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.livequiz.data.bean.LiveParams;
import com.shopee.livequiz.ui.activity.LivePlayerActivity;
import com.shopee.sdk.d.b;

public class a extends b {
    public com.shopee.sdk.d.a a() {
        return com.shopee.sdk.d.a.a("ShopeeLiveQuiz");
    }

    public boolean a(Activity activity, o oVar) {
        activity.startActivity(com.shopee.sdk.modules.ui.navigator.a.a((Context) activity, (Class<? extends Activity>) LivePlayerActivity.class, com.shopee.sdk.f.a.f30357a.a(oVar.c("param").c(), LiveParams.class)));
        return true;
    }
}
