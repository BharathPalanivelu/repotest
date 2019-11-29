package com.google.android.gms.internal.p000firebaseperf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgr  reason: invalid package */
final class zzgr extends zzgs<FieldDescriptorType, Object> {
    zzgr(int i) {
        super(i, (zzgr) null);
    }

    public final void zzgf() {
        if (!isImmutable()) {
            for (int i = 0; i < zziz(); i++) {
                Map.Entry zzau = zzau(i);
                if (((zzem) zzau.getKey()).zzhd()) {
                    zzau.setValue(Collections.unmodifiableList((List) zzau.getValue()));
                }
            }
            for (Map.Entry entry : zzja()) {
                if (((zzem) entry.getKey()).zzhd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzgf();
    }
}
