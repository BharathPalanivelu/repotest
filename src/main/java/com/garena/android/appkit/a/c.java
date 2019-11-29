package com.garena.android.appkit.a;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private int f7608a;

    /* renamed from: b  reason: collision with root package name */
    private int f7609b;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f7610c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<d> f7611d = new ArrayList<>();

    /* access modifiers changed from: protected */
    public abstract List<d> b();

    public c(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f7608a = i;
        this.f7609b = i2;
        this.f7610c = sQLiteDatabase;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f7611d.addAll(b());
    }

    public void c() {
        a();
        try {
            Iterator<d> it = this.f7611d.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.a(this.f7608a, this.f7609b)) {
                    for (String str : next.a().split(";")) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f7610c.execSQL(str);
                        }
                    }
                }
            }
        } catch (SQLException e2) {
            throw e2;
        }
    }
}
