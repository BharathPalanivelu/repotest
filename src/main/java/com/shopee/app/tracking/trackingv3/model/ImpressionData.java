package com.shopee.app.tracking.trackingv3.model;

import com.google.a.a.c;
import com.google.a.o;
import d.d.b.j;
import java.util.List;

public final class ImpressionData {
    @c(a = "viewed_objects")
    private final List<o> viewedObjects;

    public ImpressionData(List<o> list) {
        j.b(list, "viewedObjects");
        this.viewedObjects = list;
    }
}
