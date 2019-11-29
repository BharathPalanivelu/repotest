package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.shopee.app.util.af;
import java.util.List;

public class ap extends i {
    public ap(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public List<Integer> c() {
        return af.a(b(), new af.b<Integer, Long>() {
            /* renamed from: a */
            public Integer map(Long l) {
                return Integer.valueOf((int) l.longValue());
            }
        });
    }

    public void b(List<Integer> list) {
        a((List<Long>) af.a(list, new af.b<Long, Integer>() {
            /* renamed from: a */
            public Long map(Integer num) {
                return Long.valueOf((long) num.intValue());
            }
        }));
    }
}
