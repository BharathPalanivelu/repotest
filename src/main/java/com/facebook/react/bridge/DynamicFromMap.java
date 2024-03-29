package com.facebook.react.bridge;

import androidx.core.util.Pools;

public class DynamicFromMap implements Dynamic {
    private static final ThreadLocal<Pools.SimplePool<DynamicFromMap>> sPool = new ThreadLocal<Pools.SimplePool<DynamicFromMap>>() {
        /* access modifiers changed from: protected */
        public Pools.SimplePool<DynamicFromMap> initialValue() {
            return new Pools.SimplePool<>(10);
        }
    };
    private ReadableMap mMap;
    private String mName;

    private DynamicFromMap() {
    }

    public static DynamicFromMap create(ReadableMap readableMap, String str) {
        DynamicFromMap dynamicFromMap = (DynamicFromMap) sPool.get().acquire();
        if (dynamicFromMap == null) {
            dynamicFromMap = new DynamicFromMap();
        }
        dynamicFromMap.mMap = readableMap;
        dynamicFromMap.mName = str;
        return dynamicFromMap;
    }

    public void recycle() {
        this.mMap = null;
        this.mName = null;
        sPool.get().release(this);
    }

    public boolean isNull() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.isNull(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public boolean asBoolean() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getBoolean(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public double asDouble() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getDouble(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public int asInt() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getInt(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public String asString() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getString(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public ReadableArray asArray() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getArray(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public ReadableMap asMap() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getMap(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public ReadableType getType() {
        ReadableMap readableMap = this.mMap;
        if (readableMap != null) {
            String str = this.mName;
            if (str != null) {
                return readableMap.getType(str);
            }
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
