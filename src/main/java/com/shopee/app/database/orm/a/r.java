package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.shopee.app.database.orm.bean.DBModelAttrIdMap;

public class r extends a<DBModelAttrIdMap, Integer> {
    public r(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBModelAttrIdMap.class);
    }

    public DBModelAttrIdMap a(int i) {
        try {
            return (DBModelAttrIdMap) b().queryForId(Integer.valueOf(i));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(DBModelAttrIdMap dBModelAttrIdMap) {
        try {
            b().createOrUpdate(dBModelAttrIdMap);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
