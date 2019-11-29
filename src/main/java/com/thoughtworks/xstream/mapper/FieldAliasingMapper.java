package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.core.util.FastField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class FieldAliasingMapper extends MapperWrapper {
    protected final Map aliasToFieldMap = new HashMap();
    protected final Map fieldToAliasMap = new HashMap();
    protected final Set fieldsToOmit = new HashSet();
    protected final Set unknownFieldsToIgnore = new LinkedHashSet();

    public FieldAliasingMapper(Mapper mapper) {
        super(mapper);
    }

    public void addFieldAlias(String str, Class cls, String str2) {
        this.fieldToAliasMap.put(key(cls, str2), str);
        this.aliasToFieldMap.put(key(cls, str), str2);
    }

    public void addFieldsToIgnore(Pattern pattern) {
        this.unknownFieldsToIgnore.add(pattern);
    }

    private Object key(Class cls, String str) {
        return new FastField(cls, str);
    }

    public String serializedMember(Class cls, String str) {
        String member = getMember(cls, str, this.fieldToAliasMap);
        return member == null ? super.serializedMember(cls, str) : member;
    }

    public String realMember(Class cls, String str) {
        String member = getMember(cls, str, this.aliasToFieldMap);
        return member == null ? super.realMember(cls, str) : member;
    }

    private String getMember(Class<? super Object> cls, String str, Map map) {
        String str2 = null;
        while (str2 == null && cls != Object.class && cls != null) {
            str2 = (String) map.get(key(cls, str));
            cls = cls.getSuperclass();
        }
        return str2;
    }

    public boolean shouldSerializeMember(Class cls, String str) {
        if (this.fieldsToOmit.contains(key(cls, str))) {
            return false;
        }
        if (cls != Object.class || this.unknownFieldsToIgnore.isEmpty()) {
            return true;
        }
        for (Pattern matcher : this.unknownFieldsToIgnore) {
            if (matcher.matcher(str).matches()) {
                return false;
            }
        }
        return true;
    }

    public void omitField(Class cls, String str) {
        this.fieldsToOmit.add(key(cls, str));
    }
}
