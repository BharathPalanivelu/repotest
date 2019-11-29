package com.litesuits.orm.db.utils;

import android.annotation.TargetApi;
import android.database.Cursor;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.log.OrmLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataUtil implements Serializable {
    public static final String BLOB = " BLOB ";
    public static final int CLASS_TYPE_BOOLEAN = 2;
    public static final int CLASS_TYPE_BYTE = 8;
    public static final int CLASS_TYPE_BYTE_ARRAY = 9;
    public static final int CLASS_TYPE_CHAR = 10;
    public static final int CLASS_TYPE_DATE = 11;
    public static final int CLASS_TYPE_DOUBLE = 3;
    public static final int CLASS_TYPE_FLOAT = 4;
    public static final int CLASS_TYPE_INT = 6;
    public static final int CLASS_TYPE_LONG = 5;
    public static final int CLASS_TYPE_NONE = 0;
    public static final int CLASS_TYPE_SERIALIZABLE = 12;
    public static final int CLASS_TYPE_SHORT = 7;
    public static final int CLASS_TYPE_STRING = 1;
    public static final int CLASS_TYPE_UNKNOWN = 13;
    public static final int FIELD_TYPE_BLOB = 4;
    public static final int FIELD_TYPE_DATE = 5;
    public static final int FIELD_TYPE_LONG = 1;
    public static final int FIELD_TYPE_NULL = 0;
    public static final int FIELD_TYPE_REAL = 2;
    public static final int FIELD_TYPE_SERIALIZABLE = 6;
    public static final int FIELD_TYPE_STRING = 3;
    public static final String INTEGER = " INTEGER ";
    public static final String NULL = " NULL ";
    public static final String REAL = " REAL ";
    public static final String TAG = "DataUtil";
    public static final String TEXT = " TEXT ";
    private static final long serialVersionUID = 6668874253056236676L;

    public static String getSQLDataType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 10:
                return TEXT;
            case 3:
            case 4:
                return REAL;
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
                return INTEGER;
            default:
                return BLOB;
        }
    }

    public static int getType(Object obj) {
        if (obj == null) {
            return 0;
        }
        if ((obj instanceof CharSequence) || (obj instanceof Boolean) || (obj instanceof Character)) {
            return 3;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if (obj instanceof Number) {
            return 1;
        }
        if (obj instanceof Date) {
            return 5;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if (obj instanceof Serializable) {
            return 6;
        }
        return 0;
    }

    public static void injectDataToObject(Cursor cursor, Object obj, EntityTable entityTable) throws Exception {
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            String columnName = cursor.getColumnName(i);
            Property property = null;
            if (!Checker.isEmpty((Map<?, ?>) entityTable.pmap)) {
                property = entityTable.pmap.get(columnName);
            }
            if (property == null && entityTable.key != null && columnName.equals(entityTable.key.column)) {
                property = entityTable.key;
            }
            if (property != null) {
                Field field = property.field;
                field.setAccessible(true);
                switch (property.classType) {
                    case 1:
                        field.set(obj, cursor.getString(i));
                        break;
                    case 2:
                        field.set(obj, Boolean.valueOf(Boolean.parseBoolean(cursor.getString(i))));
                        break;
                    case 3:
                        field.set(obj, Double.valueOf(cursor.getDouble(i)));
                        break;
                    case 4:
                        field.set(obj, Float.valueOf(cursor.getFloat(i)));
                        break;
                    case 5:
                        field.set(obj, Long.valueOf(cursor.getLong(i)));
                        break;
                    case 6:
                        field.set(obj, Integer.valueOf(cursor.getInt(i)));
                        break;
                    case 7:
                        field.set(obj, Short.valueOf(cursor.getShort(i)));
                        break;
                    case 8:
                        if (cursor.getString(i) == null) {
                            break;
                        } else {
                            field.set(obj, Byte.valueOf(Byte.parseByte(cursor.getString(i))));
                            break;
                        }
                    case 9:
                        field.set(obj, cursor.getBlob(i));
                        break;
                    case 10:
                        String string = cursor.getString(i);
                        if (Checker.isEmpty((CharSequence) string)) {
                            break;
                        } else {
                            field.set(obj, Character.valueOf(string.charAt(0)));
                            break;
                        }
                    case 11:
                        Long valueOf = Long.valueOf(cursor.getLong(i));
                        if (valueOf == null) {
                            break;
                        } else {
                            field.set(obj, new Date(valueOf.longValue()));
                            break;
                        }
                    case 12:
                        byte[] blob = cursor.getBlob(i);
                        if (blob == null) {
                            break;
                        } else {
                            field.set(obj, byteToObject(blob));
                            break;
                        }
                }
            } else if (OrmLog.isPrint) {
                String str = TAG;
                OrmLog.w(str, "数据库字段[" + columnName + "]已在实体中被移除");
            }
        }
    }

    public static int getFieldClassType(Field field) {
        Class<?> type = field.getType();
        if (CharSequence.class.isAssignableFrom(type)) {
            return 1;
        }
        if (Boolean.TYPE.isAssignableFrom(type) || Boolean.class.isAssignableFrom(type)) {
            return 2;
        }
        if (Double.TYPE.isAssignableFrom(type) || Double.class.isAssignableFrom(type)) {
            return 3;
        }
        if (Float.TYPE.isAssignableFrom(type) || Float.class.isAssignableFrom(type)) {
            return 4;
        }
        if (Long.TYPE.isAssignableFrom(type) || Long.class.isAssignableFrom(type)) {
            return 5;
        }
        if (Integer.TYPE.isAssignableFrom(type) || Integer.class.isAssignableFrom(type)) {
            return 6;
        }
        if (Short.TYPE.isAssignableFrom(type) || Short.class.isAssignableFrom(type)) {
            return 7;
        }
        if (Byte.TYPE.isAssignableFrom(type) || Byte.class.isAssignableFrom(type)) {
            return 8;
        }
        if (byte[].class.isAssignableFrom(type) || Byte[].class.isAssignableFrom(type)) {
            return 9;
        }
        if (Character.TYPE.isAssignableFrom(type) || Character.class.isAssignableFrom(type)) {
            return 10;
        }
        if (Date.class.isAssignableFrom(type)) {
            return 11;
        }
        return Serializable.class.isAssignableFrom(type) ? 12 : 13;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object byteToObject(byte[] r3) throws java.lang.Exception {
        /*
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0016 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0016 }
            r2.<init>(r3)     // Catch:{ all -> 0x0016 }
            r1.<init>(r2)     // Catch:{ all -> 0x0016 }
            java.lang.Object r3 = r1.readObject()     // Catch:{ all -> 0x0013 }
            r1.close()
            return r3
        L_0x0013:
            r3 = move-exception
            r0 = r1
            goto L_0x0017
        L_0x0016:
            r3 = move-exception
        L_0x0017:
            if (r0 == 0) goto L_0x001c
            r0.close()
        L_0x001c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.litesuits.orm.db.utils.DataUtil.byteToObject(byte[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] objectToByte(java.lang.Object r3) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0019 }
            r1.<init>()     // Catch:{ all -> 0x0019 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0019 }
            r2.<init>(r1)     // Catch:{ all -> 0x0019 }
            r2.writeObject(r3)     // Catch:{ all -> 0x0016 }
            byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x0016 }
            r2.close()
            return r3
        L_0x0016:
            r3 = move-exception
            r0 = r2
            goto L_0x001a
        L_0x0019:
            r3 = move-exception
        L_0x001a:
            if (r0 == 0) goto L_0x001f
            r0.close()
        L_0x001f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.litesuits.orm.db.utils.DataUtil.objectToByte(java.lang.Object):byte[]");
    }

    public static List<?> arrayToList(Object[] objArr) {
        return Arrays.asList(objArr);
    }

    public static Object[] arrayToList(Collection<?> collection) {
        return collection.toArray();
    }

    @TargetApi(9)
    public static <T> T[] concat(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    @TargetApi(9)
    public static <T> T[] concatAll(T[] tArr, T[]... tArr2) {
        int length = tArr.length;
        for (T[] length2 : tArr2) {
            length += length2.length;
        }
        T[] copyOf = Arrays.copyOf(tArr, length);
        int length3 = tArr.length;
        int i = length3;
        for (T[] tArr3 : tArr2) {
            System.arraycopy(tArr3, 0, copyOf, i, tArr3.length);
            i += tArr3.length;
        }
        return copyOf;
    }
}
