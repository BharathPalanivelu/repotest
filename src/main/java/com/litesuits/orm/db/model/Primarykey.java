package com.litesuits.orm.db.model;

import com.litesuits.orm.db.enums.AssignType;
import java.lang.reflect.Field;

public class Primarykey extends Property {
    private static final long serialVersionUID = 2304252505493855513L;
    public AssignType assign;

    public Primarykey(Property property, AssignType assignType) {
        this(property.column, property.field, property.classType, assignType);
    }

    public Primarykey(String str, Field field, int i, AssignType assignType) {
        super(str, field, i);
        this.assign = assignType;
    }

    public boolean isAssignedBySystem() {
        return this.assign == AssignType.AUTO_INCREMENT;
    }

    public boolean isAssignedByMyself() {
        return this.assign == AssignType.BY_MYSELF;
    }
}
