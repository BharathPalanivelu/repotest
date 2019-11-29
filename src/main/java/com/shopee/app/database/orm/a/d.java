package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.util.af;
import java.sql.SQLException;
import java.util.List;

public class d extends a<DBAttributeCache, Integer> {
    public d(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBAttributeCache.class);
    }

    public DBAttributeCache a(String str) {
        try {
            List queryForEq = b().queryForEq("request_key", str);
            if (!af.a(queryForEq)) {
                return (DBAttributeCache) queryForEq.get(0);
            }
            return null;
        } catch (SQLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(DBAttributeCache dBAttributeCache) {
        try {
            b().createOrUpdate(dBAttributeCache);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public DBAttributeCache a(byte[] bArr) {
        try {
            List queryForEq = b().queryForEq("signature", DBAttributeCache.b(bArr));
            if (!af.a(queryForEq)) {
                return (DBAttributeCache) queryForEq.get(0);
            }
            return null;
        } catch (SQLException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
