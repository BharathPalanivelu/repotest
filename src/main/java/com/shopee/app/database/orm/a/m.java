package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class m extends a<DBItemAttribute, Integer> {
    public m(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBItemAttribute.class);
    }

    public DBItemAttribute a(int i) {
        try {
            return (DBItemAttribute) b().queryForId(Integer.valueOf(i));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBItemAttribute> a(List<Integer> list) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Integer intValue : list) {
                arrayList.add(a(intValue.intValue()));
            }
            return arrayList;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void b(final List<DBItemAttribute> list) {
        if (list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBItemAttribute createOrUpdate : list) {
                            b2.createOrUpdate(createOrUpdate);
                        }
                        return null;
                    }
                });
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }
}
