package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__4.48__";
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidDatabaseConnection.class);
    private final boolean cancelQueriesEnabled;
    private final SQLiteDatabase db;
    private final boolean readWrite;

    public boolean isAutoCommitSupported() {
        return true;
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", (Object) this, (Object) sQLiteDatabase, (Object) Boolean.valueOf(z));
    }

    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", (Object) this, (Object) Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e2);
        }
    }

    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.db.inTransaction()) {
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            }
        } else if (!this.db.inTransaction()) {
            this.db.beginTransaction();
        }
    }

    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", (Object) this, (Object) str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems beginning transaction " + str, e2);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", (Object) this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", (Object) this, (Object) savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e2) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems commiting transaction", e2);
            }
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e2);
        }
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", (Object) this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", (Object) this, (Object) savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e2) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e2);
            }
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e2);
        }
    }

    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled);
        logger.trace("{}: compiled statement got {}: {}", (Object) this, (Object) androidCompiledStatement, (Object) str);
        return androidCompiledStatement;
    }

    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteStatement compileStatement = this.db.compileStatement(str);
            bindArgs(compileStatement, objArr, fieldTypeArr);
            long executeInsert = compileStatement.executeInsert();
            if (generatedKeyHolder != null) {
                generatedKeyHolder.addKey(Long.valueOf(executeInsert));
            }
            logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
            if (compileStatement != null) {
                compileStatement.close();
            }
            return 1;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("inserting to database failed: " + str, e2);
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object queryForOne(java.lang.String r4, java.lang.Object[] r5, com.j256.ormlite.field.FieldType[] r6, com.j256.ormlite.stmt.GenericRowMapper<T> r7, com.j256.ormlite.dao.ObjectCache r8) throws java.sql.SQLException {
        /*
            r3 = this;
            r6 = 0
            android.database.sqlite.SQLiteDatabase r0 = r3.db     // Catch:{ SQLException -> 0x0040, all -> 0x003d }
            java.lang.String[] r5 = r3.toStrings(r5)     // Catch:{ SQLException -> 0x0040, all -> 0x003d }
            android.database.Cursor r5 = r0.rawQuery(r4, r5)     // Catch:{ SQLException -> 0x0040, all -> 0x003d }
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch:{ SQLException -> 0x003b }
            r0.<init>(r5, r8)     // Catch:{ SQLException -> 0x003b }
            com.j256.ormlite.logger.Logger r8 = logger     // Catch:{ SQLException -> 0x003b }
            java.lang.String r1 = "{}: queried for one result: {}"
            r8.trace((java.lang.String) r1, (java.lang.Object) r3, (java.lang.Object) r4)     // Catch:{ SQLException -> 0x003b }
            boolean r8 = r0.first()     // Catch:{ SQLException -> 0x003b }
            if (r8 != 0) goto L_0x0023
            if (r5 == 0) goto L_0x0022
            r5.close()
        L_0x0022:
            return r6
        L_0x0023:
            java.lang.Object r6 = r7.mapRow(r0)     // Catch:{ SQLException -> 0x003b }
            boolean r7 = r0.next()     // Catch:{ SQLException -> 0x003b }
            if (r7 == 0) goto L_0x0035
            java.lang.Object r4 = MORE_THAN_ONE     // Catch:{ SQLException -> 0x003b }
            if (r5 == 0) goto L_0x0034
            r5.close()
        L_0x0034:
            return r4
        L_0x0035:
            if (r5 == 0) goto L_0x003a
            r5.close()
        L_0x003a:
            return r6
        L_0x003b:
            r6 = move-exception
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
            r5 = r6
            goto L_0x005b
        L_0x0040:
            r5 = move-exception
            r2 = r6
            r6 = r5
            r5 = r2
        L_0x0044:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r7.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r8 = "queryForOne from database failed: "
            r7.append(r8)     // Catch:{ all -> 0x005a }
            r7.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x005a }
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r6)     // Catch:{ all -> 0x005a }
            throw r4     // Catch:{ all -> 0x005a }
        L_0x005a:
            r4 = move-exception
        L_0x005b:
            if (r5 == 0) goto L_0x0060
            r5.close()
        L_0x0060:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForOne(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], com.j256.ormlite.stmt.GenericRowMapper, com.j256.ormlite.dao.ObjectCache):java.lang.Object");
    }

    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = this.db.compileStatement(str);
            long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
            logger.trace("{}: query for long simple query returned {}: {}", (Object) this, (Object) Long.valueOf(simpleQueryForLong), (Object) str);
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            return simpleQueryForLong;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e2);
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long queryForLong(java.lang.String r6, java.lang.Object[] r7, com.j256.ormlite.field.FieldType[] r8) throws java.sql.SQLException {
        /*
            r5 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r5.db     // Catch:{ SQLException -> 0x0034, all -> 0x0031 }
            java.lang.String[] r7 = r5.toStrings(r7)     // Catch:{ SQLException -> 0x0034, all -> 0x0031 }
            android.database.Cursor r7 = r0.rawQuery(r6, r7)     // Catch:{ SQLException -> 0x0034, all -> 0x0031 }
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch:{ SQLException -> 0x002f }
            r0.<init>(r7, r8)     // Catch:{ SQLException -> 0x002f }
            boolean r8 = r0.first()     // Catch:{ SQLException -> 0x002f }
            if (r8 == 0) goto L_0x001c
            r8 = 0
            long r0 = r0.getLong(r8)     // Catch:{ SQLException -> 0x002f }
            goto L_0x001e
        L_0x001c:
            r0 = 0
        L_0x001e:
            com.j256.ormlite.logger.Logger r8 = logger     // Catch:{ SQLException -> 0x002f }
            java.lang.String r2 = "{}: query for long raw query returned {}: {}"
            java.lang.Long r3 = java.lang.Long.valueOf(r0)     // Catch:{ SQLException -> 0x002f }
            r8.trace((java.lang.String) r2, (java.lang.Object) r5, (java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ SQLException -> 0x002f }
            if (r7 == 0) goto L_0x002e
            r7.close()
        L_0x002e:
            return r0
        L_0x002f:
            r8 = move-exception
            goto L_0x0038
        L_0x0031:
            r6 = move-exception
            r7 = r8
            goto L_0x004f
        L_0x0034:
            r7 = move-exception
            r4 = r8
            r8 = r7
            r7 = r4
        L_0x0038:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r0.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "queryForLong from database failed: "
            r0.append(r1)     // Catch:{ all -> 0x004e }
            r0.append(r6)     // Catch:{ all -> 0x004e }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x004e }
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r6, r8)     // Catch:{ all -> 0x004e }
            throw r6     // Catch:{ all -> 0x004e }
        L_0x004e:
            r6 = move-exception
        L_0x004f:
            if (r7 == 0) goto L_0x0054
            r7.close()
        L_0x0054:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForLong(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[]):long");
    }

    public void close() throws SQLException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", (Object) this, (Object) this.db);
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems closing the database connection", e2);
        }
    }

    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", (Object) this, (Object) this.db, (Object) Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e2);
        }
    }

    public boolean isTableExists(String str) {
        SQLiteDatabase sQLiteDatabase = this.db;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", (String[]) null);
        try {
            boolean z = rawQuery.getCount() > 0;
            logger.trace("{}: isTableExists '{}' returned {}", (Object) this, (Object) str, (Object) Boolean.valueOf(z));
            return z;
        } finally {
            rawQuery.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r0 != null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        if (r0 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        logger.trace("{} statement is compiled and executed, changed {}: {}", (java.lang.Object) r6, (java.lang.Object) java.lang.Integer.valueOf(r5), (java.lang.Object) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        return r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int update(java.lang.String r3, java.lang.Object[] r4, com.j256.ormlite.field.FieldType[] r5, java.lang.String r6) throws java.sql.SQLException {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.db     // Catch:{ SQLException -> 0x0047 }
            android.database.sqlite.SQLiteStatement r1 = r1.compileStatement(r3)     // Catch:{ SQLException -> 0x0047 }
            r2.bindArgs(r1, r4, r5)     // Catch:{ SQLException -> 0x0042, all -> 0x003f }
            r1.execute()     // Catch:{ SQLException -> 0x0042, all -> 0x003f }
            if (r1 == 0) goto L_0x0013
            r1.close()
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r4 = r2.db     // Catch:{ SQLException -> 0x002e, all -> 0x0027 }
            java.lang.String r5 = "SELECT CHANGES()"
            android.database.sqlite.SQLiteStatement r0 = r4.compileStatement(r5)     // Catch:{ SQLException -> 0x002e, all -> 0x0027 }
            long r4 = r0.simpleQueryForLong()     // Catch:{ SQLException -> 0x002e, all -> 0x0027 }
            int r5 = (int) r4
            if (r0 == 0) goto L_0x0033
        L_0x0023:
            r0.close()
            goto L_0x0033
        L_0x0027:
            r3 = move-exception
            if (r0 == 0) goto L_0x002d
            r0.close()
        L_0x002d:
            throw r3
        L_0x002e:
            r5 = 1
            if (r0 == 0) goto L_0x0033
            goto L_0x0023
        L_0x0033:
            com.j256.ormlite.logger.Logger r4 = logger
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            java.lang.String r1 = "{} statement is compiled and executed, changed {}: {}"
            r4.trace((java.lang.String) r1, (java.lang.Object) r6, (java.lang.Object) r0, (java.lang.Object) r3)
            return r5
        L_0x003f:
            r3 = move-exception
            r0 = r1
            goto L_0x005e
        L_0x0042:
            r4 = move-exception
            r0 = r1
            goto L_0x0048
        L_0x0045:
            r3 = move-exception
            goto L_0x005e
        L_0x0047:
            r4 = move-exception
        L_0x0048:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r5.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "updating database failed: "
            r5.append(r6)     // Catch:{ all -> 0x0045 }
            r5.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0045 }
            java.sql.SQLException r3 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r4)     // Catch:{ all -> 0x0045 }
            throw r3     // Catch:{ all -> 0x0045 }
        L_0x005e:
            if (r0 == 0) goto L_0x0063
            r0.close()
        L_0x0063:
            goto L_0x0065
        L_0x0064:
            throw r3
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.update(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], java.lang.String):int");
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                byte[] bArr = objArr[i];
                if (bArr == null) {
                    sQLiteStatement.bindNull(i + 1);
                } else {
                    SqlType sqlType = fieldTypeArr[i].getSqlType();
                    switch (sqlType) {
                        case STRING:
                        case LONG_STRING:
                        case CHAR:
                            sQLiteStatement.bindString(i + 1, bArr.toString());
                            break;
                        case BOOLEAN:
                        case BYTE:
                        case SHORT:
                        case INTEGER:
                        case LONG:
                            sQLiteStatement.bindLong(i + 1, ((Number) bArr).longValue());
                            break;
                        case FLOAT:
                        case DOUBLE:
                            sQLiteStatement.bindDouble(i + 1, ((Number) bArr).doubleValue());
                            break;
                        case BYTE_ARRAY:
                        case SERIALIZABLE:
                            sQLiteStatement.bindBlob(i + 1, bArr);
                            break;
                        case DATE:
                        case BLOB:
                        case BIG_DECIMAL:
                            throw new SQLException("Invalid Android type: " + sqlType);
                        default:
                            throw new SQLException("Unknown sql argument type: " + sqlType);
                    }
                }
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    private static class OurSavePoint implements Savepoint {
        private String name;

        public int getSavepointId() {
            return 0;
        }

        public OurSavePoint(String str) {
            this.name = str;
        }

        public String getSavepointName() {
            return this.name;
        }
    }
}
