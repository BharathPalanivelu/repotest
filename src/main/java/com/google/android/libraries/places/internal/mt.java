package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class mt extends ms<FieldDescriptorType, Object> {
    mt(int i) {
        super(i, (byte) 0);
    }

    public final void a() {
        if (!this.f12986c) {
            for (int i = 0; i < b(); i++) {
                Map.Entry b2 = b(i);
                if (((kq) b2.getKey()).d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((kq) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
