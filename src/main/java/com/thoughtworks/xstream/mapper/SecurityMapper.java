package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.ForbiddenClassException;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.TypePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecurityMapper extends MapperWrapper {
    private final List permissions;

    public SecurityMapper(Mapper mapper) {
        this(mapper, (TypePermission[]) null);
    }

    public SecurityMapper(Mapper mapper, TypePermission[] typePermissionArr) {
        super(mapper);
        ArrayList arrayList;
        if (typePermissionArr == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(Arrays.asList(typePermissionArr));
        }
        this.permissions = arrayList;
    }

    public void addPermission(TypePermission typePermission) {
        if (typePermission.equals(NoTypePermission.NONE) || typePermission.equals(AnyTypePermission.ANY)) {
            this.permissions.clear();
        }
        this.permissions.add(0, typePermission);
    }

    public Class realClass(String str) {
        Class realClass = super.realClass(str);
        for (int i = 0; i < this.permissions.size(); i++) {
            if (((TypePermission) this.permissions.get(i)).allows(realClass)) {
                return realClass;
            }
        }
        throw new ForbiddenClassException(realClass);
    }
}
