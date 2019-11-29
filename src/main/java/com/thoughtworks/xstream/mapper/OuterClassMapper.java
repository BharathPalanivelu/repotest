package com.thoughtworks.xstream.mapper;

public class OuterClassMapper extends MapperWrapper {
    private final String alias;

    public OuterClassMapper(Mapper mapper) {
        this(mapper, "outer-class");
    }

    public OuterClassMapper(Mapper mapper, String str) {
        super(mapper);
        this.alias = str;
    }

    public String serializedMember(Class cls, String str) {
        if (str.equals("this$0")) {
            return this.alias;
        }
        return super.serializedMember(cls, str);
    }

    public String realMember(Class cls, String str) {
        if (str.equals(this.alias)) {
            return "this$0";
        }
        return super.realMember(cls, str);
    }
}
