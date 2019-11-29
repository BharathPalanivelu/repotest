package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class Variant extends Message {
    public static final Boolean DEFAULT_BOOL = false;
    public static final List<Boolean> DEFAULT_BOOLLIST = Collections.emptyList();
    public static final f DEFAULT_BYTES = f.f32736b;
    public static final List<f> DEFAULT_BYTESLIST = Collections.emptyList();
    public static final Double DEFAULT_FLOAT = Double.valueOf(0.0d);
    public static final List<Double> DEFAULT_FLOATLIST = Collections.emptyList();
    public static final Long DEFAULT_INT = 0L;
    public static final List<Long> DEFAULT_INTLIST = Collections.emptyList();
    public static final String DEFAULT_STRING = "";
    public static final List<String> DEFAULT_STRINGLIST = Collections.emptyList();
    public static final Long DEFAULT_UINT = 0L;
    public static final List<Long> DEFAULT_UINTLIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean Bool;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.BOOL)
    public final List<Boolean> BoolList;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f Bytes;
    @ProtoField(label = Message.Label.REPEATED, tag = 11, type = Message.Datatype.BYTES)
    public final List<f> BytesList;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double Float;
    @ProtoField(label = Message.Label.REPEATED, tag = 12, type = Message.Datatype.DOUBLE)
    public final List<Double> FloatList;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long Int;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT64)
    public final List<Long> IntList;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String String;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.STRING)
    public final List<String> StringList;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long Uint;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.UINT64)
    public final List<Long> UintList;

    public Variant(Long l, Long l2, Boolean bool, String str, f fVar, Double d2, List<Long> list, List<Long> list2, List<Boolean> list3, List<String> list4, List<f> list5, List<Double> list6) {
        this.Int = l;
        this.Uint = l2;
        this.Bool = bool;
        this.String = str;
        this.Bytes = fVar;
        this.Float = d2;
        this.IntList = immutableCopyOf(list);
        this.UintList = immutableCopyOf(list2);
        this.BoolList = immutableCopyOf(list3);
        this.StringList = immutableCopyOf(list4);
        this.BytesList = immutableCopyOf(list5);
        this.FloatList = immutableCopyOf(list6);
    }

    private Variant(Builder builder) {
        this(builder.Int, builder.Uint, builder.Bool, builder.String, builder.Bytes, builder.Float, builder.IntList, builder.UintList, builder.BoolList, builder.StringList, builder.BytesList, builder.FloatList);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Variant)) {
            return false;
        }
        Variant variant = (Variant) obj;
        if (!equals((Object) this.Int, (Object) variant.Int) || !equals((Object) this.Uint, (Object) variant.Uint) || !equals((Object) this.Bool, (Object) variant.Bool) || !equals((Object) this.String, (Object) variant.String) || !equals((Object) this.Bytes, (Object) variant.Bytes) || !equals((Object) this.Float, (Object) variant.Float) || !equals((List<?>) this.IntList, (List<?>) variant.IntList) || !equals((List<?>) this.UintList, (List<?>) variant.UintList) || !equals((List<?>) this.BoolList, (List<?>) variant.BoolList) || !equals((List<?>) this.StringList, (List<?>) variant.StringList) || !equals((List<?>) this.BytesList, (List<?>) variant.BytesList) || !equals((List<?>) this.FloatList, (List<?>) variant.FloatList)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.Int;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.Uint;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.Bool;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.String;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.Bytes;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Double d2 = this.Float;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = (hashCode5 + i2) * 37;
        List<Long> list = this.IntList;
        int i4 = 1;
        int hashCode6 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.UintList;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Boolean> list3 = this.BoolList;
        int hashCode8 = (hashCode7 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<String> list4 = this.StringList;
        int hashCode9 = (hashCode8 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<f> list5 = this.BytesList;
        int hashCode10 = (hashCode9 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<Double> list6 = this.FloatList;
        if (list6 != null) {
            i4 = list6.hashCode();
        }
        int i5 = hashCode10 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<Variant> {
        public Boolean Bool;
        public List<Boolean> BoolList;
        public f Bytes;
        public List<f> BytesList;
        public Double Float;
        public List<Double> FloatList;
        public Long Int;
        public List<Long> IntList;
        public String String;
        public List<String> StringList;
        public Long Uint;
        public List<Long> UintList;

        public Builder() {
        }

        public Builder(Variant variant) {
            super(variant);
            if (variant != null) {
                this.Int = variant.Int;
                this.Uint = variant.Uint;
                this.Bool = variant.Bool;
                this.String = variant.String;
                this.Bytes = variant.Bytes;
                this.Float = variant.Float;
                this.IntList = Variant.copyOf(variant.IntList);
                this.UintList = Variant.copyOf(variant.UintList);
                this.BoolList = Variant.copyOf(variant.BoolList);
                this.StringList = Variant.copyOf(variant.StringList);
                this.BytesList = Variant.copyOf(variant.BytesList);
                this.FloatList = Variant.copyOf(variant.FloatList);
            }
        }

        public Builder Int(Long l) {
            this.Int = l;
            return this;
        }

        public Builder Uint(Long l) {
            this.Uint = l;
            return this;
        }

        public Builder Bool(Boolean bool) {
            this.Bool = bool;
            return this;
        }

        public Builder String(String str) {
            this.String = str;
            return this;
        }

        public Builder Bytes(f fVar) {
            this.Bytes = fVar;
            return this;
        }

        public Builder Float(Double d2) {
            this.Float = d2;
            return this;
        }

        public Builder IntList(List<Long> list) {
            this.IntList = checkForNulls(list);
            return this;
        }

        public Builder UintList(List<Long> list) {
            this.UintList = checkForNulls(list);
            return this;
        }

        public Builder BoolList(List<Boolean> list) {
            this.BoolList = checkForNulls(list);
            return this;
        }

        public Builder StringList(List<String> list) {
            this.StringList = checkForNulls(list);
            return this;
        }

        public Builder BytesList(List<f> list) {
            this.BytesList = checkForNulls(list);
            return this;
        }

        public Builder FloatList(List<Double> list) {
            this.FloatList = checkForNulls(list);
            return this;
        }

        public Variant build() {
            return new Variant(this);
        }
    }
}
