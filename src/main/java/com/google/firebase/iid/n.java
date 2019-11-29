package com.google.firebase.iid;

import android.os.Bundle;

final class n extends m<Void> {
    n(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a(null);
        } else {
            a(new p(4, "Invalid response to one way request"));
        }
    }
}
