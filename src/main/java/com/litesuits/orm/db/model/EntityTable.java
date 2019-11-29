package com.litesuits.orm.db.model;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EntityTable implements Serializable {
    private static final long serialVersionUID = 421721084878061123L;
    public Class claxx;
    public Primarykey key;
    public ArrayList<MapProperty> mappingList;
    public String name;
    public LinkedHashMap<String, Property> pmap;

    public void addMapping(MapProperty mapProperty) {
        if (this.mappingList == null) {
            this.mappingList = new ArrayList<>();
        }
        this.mappingList.add(mapProperty);
    }

    public Annotation getAnnotation(Class cls) {
        Class cls2 = this.claxx;
        if (cls2 != null) {
            return cls2.getAnnotation(cls);
        }
        return null;
    }

    public String toString() {
        return "EntityTable{claxx=" + this.claxx + ", name='" + this.name + '\'' + ", key=" + this.key + ", pmap=" + this.pmap + ", mappingList=" + this.mappingList + '}';
    }
}
