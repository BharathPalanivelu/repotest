package com.garena.android.appkit.a.a;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.sql.SQLException;

public abstract class a<D, T> {

    /* renamed from: a  reason: collision with root package name */
    private Dao<D, T> f7605a;

    /* renamed from: b  reason: collision with root package name */
    private final com.garena.android.appkit.a.a f7606b;

    /* renamed from: c  reason: collision with root package name */
    private Class<D> f7607c;

    public a(com.garena.android.appkit.a.a aVar, Class<D> cls) {
        this.f7606b = aVar;
        this.f7607c = cls;
    }

    /* access modifiers changed from: protected */
    public com.garena.android.appkit.a.a a() {
        return this.f7606b;
    }

    /* access modifiers changed from: protected */
    public Dao<D, T> b() throws SQLException {
        if (this.f7605a == null) {
            this.f7605a = DaoManager.createDao(a().getConnectionSource(), c());
            this.f7605a.setObjectCache(true);
        }
        return this.f7605a;
    }

    public Class c() {
        return this.f7607c;
    }

    public void d() {
        Dao<D, T> dao = this.f7605a;
        if (dao != null) {
            dao.clearObjectCache();
        }
    }
}
