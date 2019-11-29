package com.shopee.arcatch.c.f;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.google.a.o;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.c.d.a;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.data.config_bean.ParamsConfigBean;
import com.shopee.arcatch.data.network_bean.game.EndGameData;
import com.shopee.arcatch.page.activity.ArCatchActivity;
import com.shopee.arcatch.page.activity.FaceMatchActivity;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;

public class d {
    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, FaceMatchActivity.class));
    }

    public static void b(Activity activity) {
        a.a().b();
        activity.startActivity(new Intent(activity, ArCatchActivity.class));
    }

    public static boolean c(Activity activity) {
        ConfigBean b2 = b.a().b();
        if (b2 == null || b2.paramsConfigBean == null) {
            return false;
        }
        String str = b2.paramsConfigBean.errorUrl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.shopee.sdk.b.a().e().a(activity, NavigationPath.a(str), (o) null);
        return true;
    }

    public static boolean a(Activity activity, String str, EndGameData endGameData) {
        ConfigBean b2 = b.a().b();
        if (b2 == null || b2.paramsConfigBean == null) {
            return false;
        }
        ParamsConfigBean paramsConfigBean = b2.paramsConfigBean;
        String str2 = paramsConfigBean.endUrl;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        boolean z = paramsConfigBean.saveVideo;
        boolean z2 = paramsConfigBean.mute;
        String str3 = paramsConfigBean.source;
        StringBuilder sb = new StringBuilder();
        sb.append("mute=");
        sb.append(z2);
        if (z) {
            sb.append("&save_video=");
            sb.append(z);
        }
        if (endGameData != null) {
            sb.append("&group_bonus=");
            sb.append(endGameData.getGroupBonus());
            sb.append("&catch_coins=");
            sb.append(endGameData.getCatchCoins());
            String award = endGameData.getAward();
            if (!TextUtils.isEmpty(award)) {
                sb.append("&award=");
                sb.append(award);
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&source=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append("&video_save_path=");
            sb.append(str);
            sb.append("&asset_local_identifier=");
            sb.append(str);
        }
        com.shopee.e.a.a.a((Object) "encodeParams " + sb.toString());
        String encodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2.contains("?") ? "&result=" : "?result=");
        sb2.append(encodeToString);
        String str4 = str2 + sb2.toString();
        com.shopee.e.a.a.a((Object) "endUrl " + str4);
        com.shopee.sdk.b.a().e().a(activity, NavigationPath.a(str4), (o) null);
        return true;
    }
}
