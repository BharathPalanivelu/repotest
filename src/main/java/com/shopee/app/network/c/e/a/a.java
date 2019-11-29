package com.shopee.app.network.c.e.a;

import android.util.Pair;
import com.shopee.app.h.o;
import com.shopee.app.network.c.e.b;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ServerID;
import com.shopee.protocol.fraud_check.action.Command;
import com.shopee.protocol.fraud_check.action.SyncLoginInfoResponse;

public final class a implements b<SyncLoginInfoResponse> {
    public void a(String str, SyncLoginInfoResponse syncLoginInfoResponse) {
        o.a().f(str);
        StringBuilder sb = new StringBuilder();
        sb.append("SyncLoginInfoProcessor - onProcess requestId = ");
        sb.append(str);
        sb.append(", errorCode = ");
        sb.append(syncLoginInfoResponse != null ? syncLoginInfoResponse.errcode : null);
        com.garena.android.appkit.d.a.e(sb.toString(), new Object[0]);
    }

    public int a() {
        return Command.CMD_FRAUD_SYNC_LOGININFO.getValue();
    }

    public int b() {
        return ServerID.FRAUD_CHECK_SERVER.getValue();
    }

    public Pair<String, SyncLoginInfoResponse> a(byte[] bArr) {
        SyncLoginInfoResponse syncLoginInfoResponse = (SyncLoginInfoResponse) f.f18486a.parseFrom(bArr, 0, bArr != null ? bArr.length : 0, SyncLoginInfoResponse.class);
        return new Pair<>(syncLoginInfoResponse.requestid, syncLoginInfoResponse);
    }
}
