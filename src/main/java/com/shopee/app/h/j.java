package com.shopee.app.h;

import com.shopee.protocol.action.FeedComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class j {

    /* renamed from: b  reason: collision with root package name */
    private static j f17666b;

    /* renamed from: a  reason: collision with root package name */
    Map<Long, List<FeedComment>> f17667a = new HashMap();

    public static j a() {
        if (f17666b == null) {
            f17666b = new j();
        }
        return f17666b;
    }

    private j() {
    }

    public void a(Long l, List<FeedComment> list) {
        this.f17667a.put(l, new ArrayList(list));
    }

    public void b(Long l, List<FeedComment> list) {
        ArrayList arrayList = new ArrayList(list);
        List list2 = this.f17667a.get(l);
        if (list2 == null || list2.isEmpty()) {
            this.f17667a.put(l, arrayList);
            return;
        }
        list2.addAll(arrayList);
        this.f17667a.put(l, list2);
    }

    public List<FeedComment> a(long j) {
        return this.f17667a.get(Long.valueOf(j));
    }

    public void b(long j) {
        this.f17667a.put(Long.valueOf(j), new ArrayList());
    }
}
