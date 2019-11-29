package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.shopee.app.database.orm.bean.DBShopInfo;
import java.sql.SQLException;

public class aa extends a<DBShopInfo, Integer> {
    public aa(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBShopInfo.class);
    }

    public DBShopInfo a(int i) {
        try {
            return (DBShopInfo) b().queryForId(Integer.valueOf(i));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(DBShopInfo dBShopInfo) {
        try {
            b().createOrUpdate(dBShopInfo);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
