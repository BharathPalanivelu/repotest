package com.thoughtworks.xstream.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ExplicitTypePermission implements TypePermission {
    final Set names;

    public ExplicitTypePermission(final Class[] clsArr) {
        this(new Object() {
            public String[] getNames() {
                Class[] clsArr = clsArr;
                if (clsArr == null) {
                    return null;
                }
                String[] strArr = new String[clsArr.length];
                int i = 0;
                while (true) {
                    Class[] clsArr2 = clsArr;
                    if (i >= clsArr2.length) {
                        return strArr;
                    }
                    strArr[i] = clsArr2[i].getName();
                    i++;
                }
            }
        }.getNames());
    }

    public ExplicitTypePermission(String[] strArr) {
        this.names = strArr == null ? Collections.EMPTY_SET : new HashSet(Arrays.asList(strArr));
    }

    public boolean allows(Class cls) {
        if (cls == null) {
            return false;
        }
        return this.names.contains(cls.getName());
    }
}
