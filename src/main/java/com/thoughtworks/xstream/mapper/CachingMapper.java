package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.security.ForbiddenClassException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CachingMapper extends MapperWrapper implements Caching {
    private transient Map realClassCache;

    public CachingMapper(Mapper mapper) {
        super(mapper);
        readResolve();
    }

    public Class realClass(String str) {
        Object obj = this.realClassCache.get(str);
        if (obj == null) {
            try {
                Class realClass = super.realClass(str);
                this.realClassCache.put(str, realClass);
                return realClass;
            } catch (ForbiddenClassException e2) {
                this.realClassCache.put(str, e2);
                throw e2;
            } catch (CannotResolveClassException e3) {
                this.realClassCache.put(str, e3);
                throw e3;
            }
        } else if (obj instanceof Class) {
            return (Class) obj;
        } else {
            throw ((XStreamException) obj);
        }
    }

    public void flushCache() {
        this.realClassCache.clear();
    }

    private Object readResolve() {
        this.realClassCache = Collections.synchronizedMap(new HashMap(128));
        return this;
    }
}
