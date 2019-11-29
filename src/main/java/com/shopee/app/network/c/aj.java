package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class aj extends c {
    public int a() {
        return 27;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ar.f().e().getMinAppProcessor().a((ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17800a;

        /* renamed from: b  reason: collision with root package name */
        private final SettingConfigStore f17801b;

        /* renamed from: c  reason: collision with root package name */
        private final be f17802c;

        public a(n nVar, SettingConfigStore settingConfigStore, be beVar) {
            this.f17800a = nVar;
            this.f17801b = settingConfigStore;
            this.f17802c = beVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                boolean z = true;
                if (297 < responseCommon.minappversion.intValue()) {
                    this.f17800a.a("MIN_VERSION_PROBLEM", new com.garena.android.appkit.b.a(true));
                    return;
                }
                boolean z2 = 297 <= this.f17801b.getMinSupportedVersion();
                if (com.garena.android.appkit.tools.a.a.a() - this.f17802c.u() <= this.f17801b.getLatestVersionPromptCheckDays() * 24 * 60 * 60) {
                    z = false;
                }
                if (z2 && z) {
                    this.f17800a.a("MIN_VERSION_PROBLEM", new com.garena.android.appkit.b.a(false));
                    this.f17802c.v();
                }
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            return responseCommon.errcode.intValue() == 0;
        }
    }
}
