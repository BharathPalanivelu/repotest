package com.tencent.liteav.txcvodplayer.a;

import com.appsflyer.share.Constants;
import com.tencent.ijk.media.player.IjkMediaMeta;

public class a {

    /* renamed from: a  reason: collision with root package name */
    String f32053a;

    /* renamed from: b  reason: collision with root package name */
    String f32054b;

    /* renamed from: c  reason: collision with root package name */
    String f32055c;

    a(String str, String str2, String str3) {
        this.f32053a = str2;
        this.f32054b = str;
        this.f32055c = str3;
    }

    public String a() {
        if ("mp4".equals(this.f32055c)) {
            return c();
        }
        return null;
    }

    public String b() {
        if (IjkMediaMeta.IJKM_KEY_M3U8.equals(this.f32055c)) {
            return c();
        }
        return null;
    }

    public String c() {
        return this.f32053a + Constants.URL_PATH_DELIMITER + this.f32054b;
    }

    public String d() {
        return this.f32054b;
    }
}
