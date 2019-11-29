package com.thoughtworks.xstream.mapper;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAttributeAliasingMapper extends MapperWrapper {
    protected final Map aliasToName = new HashMap();
    protected transient Map nameToAlias = new HashMap();

    public AbstractAttributeAliasingMapper(Mapper mapper) {
        super(mapper);
    }

    public void addAliasFor(String str, String str2) {
        this.aliasToName.put(str2, str);
        this.nameToAlias.put(str, str2);
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        this.nameToAlias = new HashMap();
        for (Object next : this.aliasToName.keySet()) {
            this.nameToAlias.put(this.aliasToName.get(next), next);
        }
        return this;
    }
}
