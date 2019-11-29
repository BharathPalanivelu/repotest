package com.shopee.app.data.store.c;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.ay;
import com.shopee.app.util.j.b;
import com.shopee.protocol.action.ReturnSubListType;
import java.util.List;

public class d extends ay {

    /* renamed from: a  reason: collision with root package name */
    private b<Long> f17286a;

    /* renamed from: b  reason: collision with root package name */
    private b<Long> f17287b;

    /* renamed from: c  reason: collision with root package name */
    private b<Long> f17288c;

    public d(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        String valueOf = String.valueOf(ak.a().d().b(-1));
        this.f17286a = new b<>(sharedPreferences, "return_all_list" + valueOf, new a<List<Long>>() {
        });
        this.f17287b = new b<>(sharedPreferences, "return_unprocessed_list" + valueOf, new a<List<Long>>() {
        });
        this.f17288c = new b<>(sharedPreferences, "return_processed_list" + valueOf, new a<List<Long>>() {
        });
    }

    public void a(int i) {
        c(i).c();
    }

    public List<Long> b(int i) {
        return (List) c(i).a();
    }

    public void a(int i, List<Long> list) {
        c(i).a(list);
    }

    private b<Long> c(int i) {
        if (i == ReturnSubListType.RETURN_SUB_LIST_UNPROCESSED.getValue()) {
            return this.f17287b;
        }
        if (i == ReturnSubListType.RETURN_SUB_LIST_PROCESSED.getValue()) {
            return this.f17288c;
        }
        return this.f17286a;
    }
}
