package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.a;
import com.google.firebase.remoteconfig.i;

public final class zzfe implements i {
    private final String value;
    private final int zzmc;

    zzfe(String str, int i) {
        this.value = str;
        this.zzmc = i;
    }

    public final long asLong() {
        if (this.zzmc == 0) {
            return 0;
        }
        String trim = asString().trim();
        try {
            return Long.valueOf(trim).longValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{trim, "long"}), e2);
        }
    }

    public final double asDouble() {
        if (this.zzmc == 0) {
            return 0.0d;
        }
        String trim = asString().trim();
        try {
            return Double.valueOf(trim).doubleValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{trim, "double"}), e2);
        }
    }

    public final String asString() {
        if (this.zzmc == 0) {
            return "";
        }
        String str = this.value;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    public final byte[] asByteArray() {
        if (this.zzmc == 0) {
            return a.f14341a;
        }
        return this.value.getBytes(zzew.zzln);
    }

    public final boolean asBoolean() throws IllegalArgumentException {
        if (this.zzmc == 0) {
            return false;
        }
        String trim = asString().trim();
        if (zzew.zzlo.matcher(trim).matches()) {
            return true;
        }
        if (zzew.zzlp.matcher(trim).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{trim, "boolean"}));
    }

    public final int getSource() {
        return this.zzmc;
    }
}
