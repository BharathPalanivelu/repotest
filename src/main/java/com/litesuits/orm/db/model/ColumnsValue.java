package com.litesuits.orm.db.model;

import com.litesuits.orm.db.assit.Checker;
import java.util.HashMap;
import java.util.Map;

public class ColumnsValue {
    public String[] columns;
    private Map<String, Object> map = new HashMap();

    public ColumnsValue(Map<String, Object> map2) {
        if (!Checker.isEmpty((Map<?, ?>) map2)) {
            this.columns = new String[map2.size()];
            int i = 0;
            for (Map.Entry<String, Object> key : map2.entrySet()) {
                this.columns[i] = (String) key.getKey();
                i++;
            }
            this.map = map2;
        }
    }

    public ColumnsValue(String[] strArr) {
        this.columns = strArr;
        for (String put : strArr) {
            this.map.put(put, (Object) null);
        }
    }

    public ColumnsValue(String[] strArr, Object[] objArr) {
        this.columns = strArr;
        int i = 0;
        if (objArr == null) {
            int length = strArr.length;
            while (i < length) {
                this.map.put(strArr[i], (Object) null);
                i++;
            }
        } else if (strArr.length == objArr.length) {
            int length2 = strArr.length;
            int i2 = 0;
            while (i < length2) {
                this.map.put(strArr[i], objArr[i2]);
                i++;
                i2++;
            }
        } else {
            throw new IllegalArgumentException("length of columns and values must be the same");
        }
    }

    public boolean checkColumns() {
        if (this.columns != null) {
            return true;
        }
        throw new IllegalArgumentException("columns must not be null");
    }

    public Object getValue(String str) {
        return this.map.get(str);
    }
}
