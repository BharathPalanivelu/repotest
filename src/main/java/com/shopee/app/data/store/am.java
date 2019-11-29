package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.a;
import com.shopee.app.util.ad;
import java.util.ArrayList;
import java.util.List;

public class am extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<List<String>> f17187a;

    /* renamed from: b  reason: collision with root package name */
    private a f17188b;

    public am(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17187a = new ad<>(sharedPreferences, "messageShortcut", "[]", new com.google.a.c.a<List<String>>() {
        });
        this.f17188b = new a(sharedPreferences, "messageShortcutOption");
    }

    public void a(List<String> list) {
        this.f17187a.a(list);
    }

    public List<String> a() {
        List<String> a2 = this.f17187a.a();
        return a2 == null ? new ArrayList() : a2;
    }

    public List<String> a(int i) {
        List<String> a2 = this.f17187a.a();
        if (a2.size() < i && !a2.contains("")) {
            a2.add("");
        }
        return a2;
    }

    public void a(int i, String str) throws IndexOutOfBoundsException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a());
        if (arrayList.size() > i) {
            arrayList.remove(i);
            arrayList.add(i, str);
            a((List<String>) arrayList);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void b(int i) throws IndexOutOfBoundsException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a());
        if (arrayList.size() > i) {
            arrayList.remove(i);
            a((List<String>) arrayList);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean b() {
        return this.f17188b.a();
    }

    public void a(boolean z) {
        this.f17188b.a(z);
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a());
        arrayList.add(str);
        a((List<String>) arrayList);
    }
}
