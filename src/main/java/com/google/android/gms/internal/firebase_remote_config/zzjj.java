package com.google.android.gms.internal.firebase_remote_config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzjj extends zzjk<FieldDescriptorType, Object> {
    zzjj(int i) {
        super(i, (zzjj) null);
    }

    public final void zzes() {
        if (!isImmutable()) {
            for (int i = 0; i < zzir(); i++) {
                Map.Entry zzbm = zzbm(i);
                if (((zzhc) zzbm.getKey()).zzgq()) {
                    zzbm.setValue(Collections.unmodifiableList((List) zzbm.getValue()));
                }
            }
            for (Map.Entry entry : zzis()) {
                if (((zzhc) entry.getKey()).zzgq()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzes();
    }
}
