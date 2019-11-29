package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;

public class SerializableType extends BaseDataType {
    private static final SerializableType singleTon = new SerializableType();

    public boolean isAppropriateId() {
        return false;
    }

    public boolean isArgumentHolderRequired() {
        return true;
    }

    public boolean isComparable() {
        return false;
    }

    public boolean isStreamType() {
        return true;
    }

    public static SerializableType getSingleton() {
        return singleTon;
    }

    private SerializableType() {
        super(SqlType.SERIALIZABLE, new Class[0]);
    }

    protected SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBytes(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[SYNTHETIC, Splitter:B:19:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sqlArgToJava(com.j256.ormlite.field.FieldType r4, java.lang.Object r5, int r6) throws java.sql.SQLException {
        /*
            r3 = this;
            byte[] r5 = (byte[]) r5
            byte[] r5 = (byte[]) r5
            r4 = 0
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0022 }
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0022 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0022 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r6.readObject()     // Catch:{ Exception -> 0x001b, all -> 0x0017 }
            r6.close()     // Catch:{ IOException -> 0x0016 }
        L_0x0016:
            return r4
        L_0x0017:
            r4 = move-exception
            r5 = r4
            r4 = r6
            goto L_0x004b
        L_0x001b:
            r4 = move-exception
            r2 = r6
            r6 = r4
            r4 = r2
            goto L_0x0023
        L_0x0020:
            r5 = move-exception
            goto L_0x004b
        L_0x0022:
            r6 = move-exception
        L_0x0023:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            r0.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = "Could not read serialized object from byte array: "
            r0.append(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = java.util.Arrays.toString(r5)     // Catch:{ all -> 0x0020 }
            r0.append(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = "(len "
            r0.append(r1)     // Catch:{ all -> 0x0020 }
            int r5 = r5.length     // Catch:{ all -> 0x0020 }
            r0.append(r5)     // Catch:{ all -> 0x0020 }
            java.lang.String r5 = ")"
            r0.append(r5)     // Catch:{ all -> 0x0020 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0020 }
            java.sql.SQLException r5 = com.j256.ormlite.misc.SqlExceptionUtil.create(r5, r6)     // Catch:{ all -> 0x0020 }
            throw r5     // Catch:{ all -> 0x0020 }
        L_0x004b:
            if (r4 == 0) goto L_0x0050
            r4.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.SerializableType.sqlArgToJava(com.j256.ormlite.field.FieldType, java.lang.Object, int):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[SYNTHETIC, Splitter:B:18:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object javaToSqlArg(com.j256.ormlite.field.FieldType r4, java.lang.Object r5) throws java.sql.SQLException {
        /*
            r3 = this;
            r4 = 0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x001e }
            r0.<init>()     // Catch:{ Exception -> 0x001e }
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x001e }
            r1.<init>(r0)     // Catch:{ Exception -> 0x001e }
            r1.writeObject(r5)     // Catch:{ Exception -> 0x0019, all -> 0x0016 }
            r1.close()     // Catch:{ Exception -> 0x0019, all -> 0x0016 }
            byte[] r4 = r0.toByteArray()     // Catch:{ Exception -> 0x001e }
            return r4
        L_0x0016:
            r5 = move-exception
            r4 = r1
            goto L_0x0035
        L_0x0019:
            r0 = move-exception
            r4 = r1
            goto L_0x001f
        L_0x001c:
            r5 = move-exception
            goto L_0x0035
        L_0x001e:
            r0 = move-exception
        L_0x001f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r1.<init>()     // Catch:{ all -> 0x001c }
            java.lang.String r2 = "Could not write serialized object to byte array: "
            r1.append(r2)     // Catch:{ all -> 0x001c }
            r1.append(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x001c }
            java.sql.SQLException r5 = com.j256.ormlite.misc.SqlExceptionUtil.create(r5, r0)     // Catch:{ all -> 0x001c }
            throw r5     // Catch:{ all -> 0x001c }
        L_0x0035:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.SerializableType.javaToSqlArg(com.j256.ormlite.field.FieldType, java.lang.Object):java.lang.Object");
    }

    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }
}
