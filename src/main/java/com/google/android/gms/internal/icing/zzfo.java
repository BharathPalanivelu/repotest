package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzfo extends zzfp<FieldDescriptorType, Object> {
    zzfo(int i) {
        super(i, (zzfo) null);
    }

    public final void zzah() {
        if (!isImmutable()) {
            for (int i = 0; i < zzde(); i++) {
                Map.Entry zzaj = zzaj(i);
                if (((zzdl) zzaj.getKey()).zzbi()) {
                    zzaj.setValue(Collections.unmodifiableList((List) zzaj.getValue()));
                }
            }
            for (Map.Entry entry : zzdf()) {
                if (((zzdl) entry.getKey()).zzbi()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzah();
    }
}
