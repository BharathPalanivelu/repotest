package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBBIReport;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.List;

public class e extends a<DBBIReport, String> {
    public e(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBBIReport.class);
    }

    public List<DBBIReport> a(long j) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.limit(Long.valueOf(j)).orderBy("timestamp", true).where().eq("endpoint", "/batchrecord");
            return queryBuilder.query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void b(long j) {
        try {
            Dao b2 = b();
            List<DBBIReport> a2 = a(j);
            DeleteBuilder deleteBuilder = b2.deleteBuilder();
            deleteBuilder.where().in("id", (Iterable<?>) af.a(a2, new af.b<Integer, DBBIReport>() {
                /* renamed from: a */
                public Integer map(DBBIReport dBBIReport) {
                    return Integer.valueOf(dBBIReport.f());
                }
            }));
            deleteBuilder.delete();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public long e() {
        try {
            return b().queryBuilder().where().eq("endpoint", "/batchrecord").countOf();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return 0;
        }
    }
}
