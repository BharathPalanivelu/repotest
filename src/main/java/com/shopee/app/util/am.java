package com.shopee.app.util;

import android.content.Context;
import com.path.android.jobqueue.network.NetworkEventProvider;
import com.path.android.jobqueue.network.NetworkUtil;
import com.shopee.app.network.e;

public class am implements NetworkEventProvider, NetworkUtil {

    /* renamed from: a  reason: collision with root package name */
    NetworkEventProvider.Listener f26157a = null;

    public void setListener(NetworkEventProvider.Listener listener) {
        this.f26157a = listener;
    }

    public void a() {
        NetworkEventProvider.Listener listener = this.f26157a;
        if (listener != null) {
            listener.onNetworkChange(e.c().f());
        }
    }

    public boolean isConnected(Context context) {
        return e.c().f();
    }
}
