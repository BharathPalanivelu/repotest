package com.shopee.app.data.store.setting;

import com.shopee.app.util.ad;
import java.lang.reflect.Field;
import java.util.Map;

public class ConfigHelper {
    private static final String DEFAULT = "default";
    private static final String REGION_CODE = "ID";

    private ConfigHelper() {
    }

    public static <T> T getConfig(Map<String, T> map, T t) {
        if (map == null) {
            return t;
        }
        if (map.containsKey("ID")) {
            return map.get("ID");
        }
        return map.containsKey(DEFAULT) ? map.get(DEFAULT) : t;
    }

    public static <T1> T1 configFrom(T1 t1, ad<T1> adVar, ad<T1> adVar2) {
        return t1 != null ? t1 : adVar.a();
    }

    private static <T1, T2> void copy(T1 t1, T2 t2) throws IllegalAccessException, NoSuchFieldException {
        for (Field field : t1.getClass().getDeclaredFields()) {
            Object obj = field.get(t1);
            if (obj != null) {
                field.set(t2, obj);
            }
        }
    }
}
