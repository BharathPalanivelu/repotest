package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.u;
import java.util.List;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final u.c f7265a = new u.c();

    public static u.b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Window start can't be less than 0");
        } else if (i2 >= i) {
            return new u.b(i, i2);
        } else {
            throw new IllegalArgumentException("Window end can't be less than window start");
        }
    }

    public static u.a a(List<w> list) {
        if (list != null && !list.isEmpty()) {
            return new u.a(list);
        }
        throw new IllegalArgumentException("Uris must not be null or empty.");
    }
}
