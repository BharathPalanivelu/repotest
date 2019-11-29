package cn.tongdun.android.core.x0ox00x0oooo0xxx;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class oo0ooo0o00o0xo implements HostnameVerifier {
    oo0ooo0o00o0xo() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith(o00xxox0x0xoox.o00xxox0x0xoox("3c093a1a2e0b270336052d147b5976", 105)) && !str.endsWith(o00xxox0x0xoox.o00xxox0x0xoox("3c2935283c2b2d306d706661", 91))) {
            return false;
        }
        String peerHost = sSLSession.getPeerHost();
        return peerHost.endsWith(o00xxox0x0xoox.o00xxox0x0xoox("3c653a762e67276f36692d787b3576", 5)) || peerHost.endsWith(o00xxox0x0xoox.o00xxox0x0xoox("3c2b352a3c292d326d726663", 89));
    }
}
