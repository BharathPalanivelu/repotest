package com.litesuits.orm.db.assit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Querier;
import com.litesuits.orm.db.assit.Transaction;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.MapInfo;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.db.utils.ClassUtil;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import com.litesuits.orm.log.OrmLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class SQLStatement implements Serializable {
    public static final int IN_TOP_LIMIT = 999;
    public static final short NONE = -1;
    public static final short NORMAL = 0;
    /* access modifiers changed from: private */
    public static final String TAG = "SQLStatement";
    private static final long serialVersionUID = -3790876762607683712L;
    public Object[] bindArgs;
    private SQLiteStatement mStatement;
    public String sql;

    public SQLStatement() {
    }

    public SQLStatement(String str, Object[] objArr) {
        this.sql = str;
        this.bindArgs = objArr;
    }

    /* access modifiers changed from: protected */
    public void bind(int i, Object obj) throws IOException {
        if (obj == null) {
            this.mStatement.bindNull(i);
        } else if ((obj instanceof CharSequence) || (obj instanceof Boolean) || (obj instanceof Character)) {
            this.mStatement.bindString(i, String.valueOf(obj));
        } else if ((obj instanceof Float) || (obj instanceof Double)) {
            this.mStatement.bindDouble(i, ((Number) obj).doubleValue());
        } else if (obj instanceof Number) {
            this.mStatement.bindLong(i, ((Number) obj).longValue());
        } else if (obj instanceof Date) {
            this.mStatement.bindLong(i, ((Date) obj).getTime());
        } else if (obj instanceof byte[]) {
            this.mStatement.bindBlob(i, (byte[]) obj);
        } else if (obj instanceof Serializable) {
            this.mStatement.bindBlob(i, DataUtil.objectToByte(obj));
        } else {
            this.mStatement.bindNull(i);
        }
    }

    public long execInsert(SQLiteDatabase sQLiteDatabase) throws IOException, IllegalAccessException {
        return execInsertWithMapping(sQLiteDatabase, (Object) null, (TableManager) null);
    }

    public long execInsert(SQLiteDatabase sQLiteDatabase, Object obj) throws IOException, IllegalAccessException {
        return execInsertWithMapping(sQLiteDatabase, obj, (TableManager) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long execInsertWithMapping(android.database.sqlite.SQLiteDatabase r11, java.lang.Object r12, com.litesuits.orm.db.TableManager r13) throws java.lang.IllegalAccessException, java.io.IOException {
        /*
            r10 = this;
            r10.printSQL()
            java.lang.String r0 = r10.sql
            android.database.sqlite.SQLiteStatement r0 = r11.compileStatement(r0)
            r10.mStatement = r0
            java.lang.Object[] r0 = r10.bindArgs
            boolean r0 = com.litesuits.orm.db.assit.Checker.isEmpty((java.lang.Object[]) r0)
            if (r0 != 0) goto L_0x0026
            java.lang.Object[] r0 = r10.bindArgs
            r1 = 0
            r0 = r0[r1]
        L_0x0018:
            java.lang.Object[] r2 = r10.bindArgs
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0027
            int r3 = r1 + 1
            r1 = r2[r1]
            r10.bind(r3, r1)
            r1 = r3
            goto L_0x0018
        L_0x0026:
            r0 = 0
        L_0x0027:
            android.database.sqlite.SQLiteStatement r1 = r10.mStatement     // Catch:{ all -> 0x006b }
            long r1 = r1.executeInsert()     // Catch:{ all -> 0x006b }
            r10.realease()
            boolean r3 = com.litesuits.orm.log.OrmLog.isPrint
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "SQL Execute Insert RowID --> "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = "    sql: "
            r4.append(r5)
            java.lang.String r5 = r10.sql
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.litesuits.orm.log.OrmLog.i((java.lang.String) r3, (java.lang.String) r4)
        L_0x0054:
            if (r12 == 0) goto L_0x005f
            com.litesuits.orm.db.model.EntityTable r3 = com.litesuits.orm.db.TableManager.getTable((java.lang.Object) r12)
            com.litesuits.orm.db.model.Primarykey r3 = r3.key
            com.litesuits.orm.db.utils.FieldUtil.setKeyValueIfneed(r12, r3, r0, r1)
        L_0x005f:
            if (r13 == 0) goto L_0x006a
            r6 = 1
            r7 = 1
            r4 = r10
            r5 = r12
            r8 = r11
            r9 = r13
            r4.mapRelationToDb(r5, r6, r7, r8, r9)
        L_0x006a:
            return r1
        L_0x006b:
            r11 = move-exception
            r10.realease()
            goto L_0x0071
        L_0x0070:
            throw r11
        L_0x0071:
            goto L_0x0070
        */
        throw new UnsupportedOperationException("Method not decompiled: com.litesuits.orm.db.assit.SQLStatement.execInsertWithMapping(android.database.sqlite.SQLiteDatabase, java.lang.Object, com.litesuits.orm.db.TableManager):long");
    }

    public int execInsertCollection(SQLiteDatabase sQLiteDatabase, Collection<?> collection) {
        return execInsertCollectionWithMapping(sQLiteDatabase, collection, (TableManager) null);
    }

    /* JADX INFO: finally extract failed */
    public int execInsertCollectionWithMapping(SQLiteDatabase sQLiteDatabase, Collection<?> collection, TableManager tableManager) {
        int i;
        Object obj;
        printSQL();
        sQLiteDatabase.beginTransaction();
        if (OrmLog.isPrint) {
            OrmLog.i(TAG, "----> BeginTransaction[insert col]");
        }
        try {
            this.mStatement = sQLiteDatabase.compileStatement(this.sql);
            EntityTable entityTable = null;
            boolean z = true;
            for (Object next : collection) {
                this.mStatement.clearBindings();
                if (entityTable == null) {
                    entityTable = TableManager.getTable((Object) next);
                }
                if (entityTable.key != null) {
                    obj = FieldUtil.getAssignedKeyObject(entityTable.key, next);
                    i = 2;
                    bind(1, obj);
                } else {
                    obj = null;
                    i = 1;
                }
                if (!Checker.isEmpty((Map<?, ?>) entityTable.pmap)) {
                    for (Property property : entityTable.pmap.values()) {
                        bind(i, FieldUtil.get(property.field, next));
                        i++;
                    }
                }
                FieldUtil.setKeyValueIfneed(next, entityTable.key, obj, this.mStatement.executeInsert());
                if (tableManager != null) {
                    mapRelationToDb(next, true, z, sQLiteDatabase, tableManager);
                    z = false;
                }
            }
            if (OrmLog.isPrint) {
                OrmLog.i(TAG, "Exec insert [" + collection.size() + "] rows , SQL: " + this.sql);
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (OrmLog.isPrint) {
                OrmLog.i(TAG, "----> BeginTransaction[insert col] Successful");
            }
            int size = collection.size();
            realease();
            sQLiteDatabase.endTransaction();
            return size;
        } catch (Exception e2) {
            if (OrmLog.isPrint) {
                OrmLog.e(TAG, "----> BeginTransaction[insert col] Failling");
            }
            e2.printStackTrace();
            realease();
            sQLiteDatabase.endTransaction();
            return -1;
        } catch (Throwable th) {
            realease();
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    public int execUpdate(SQLiteDatabase sQLiteDatabase) throws IOException {
        return execUpdateWithMapping(sQLiteDatabase, (Object) null, (TableManager) null);
    }

    public int execUpdateWithMapping(SQLiteDatabase sQLiteDatabase, Object obj, TableManager tableManager) throws IOException {
        printSQL();
        this.mStatement = sQLiteDatabase.compileStatement(this.sql);
        int i = 0;
        if (!Checker.isEmpty(this.bindArgs)) {
            int i2 = 0;
            while (true) {
                Object[] objArr = this.bindArgs;
                if (i2 >= objArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                bind(i3, objArr[i2]);
                i2 = i3;
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.mStatement.execute();
        } else {
            i = this.mStatement.executeUpdateDelete();
        }
        realease();
        if (OrmLog.isPrint) {
            String str = TAG;
            OrmLog.i(str, "SQL Execute update, changed rows --> " + i);
        }
        if (!(tableManager == null || obj == null)) {
            mapRelationToDb(obj, true, true, sQLiteDatabase, tableManager);
        }
        return i;
    }

    public int execUpdateCollection(SQLiteDatabase sQLiteDatabase, Collection<?> collection, ColumnsValue columnsValue) {
        return execUpdateCollectionWithMapping(sQLiteDatabase, collection, columnsValue, (TableManager) null);
    }

    /* JADX INFO: finally extract failed */
    public int execUpdateCollectionWithMapping(SQLiteDatabase sQLiteDatabase, Collection<?> collection, ColumnsValue columnsValue, TableManager tableManager) {
        printSQL();
        sQLiteDatabase.beginTransaction();
        if (OrmLog.isPrint) {
            OrmLog.d(TAG, "----> BeginTransaction[update col]");
        }
        try {
            this.mStatement = sQLiteDatabase.compileStatement(this.sql);
            EntityTable entityTable = null;
            boolean z = true;
            for (Object next : collection) {
                this.mStatement.clearBindings();
                if (entityTable == null) {
                    entityTable = TableManager.getTable((Object) next);
                }
                this.bindArgs = SQLBuilder.buildUpdateSqlArgsOnly(next, columnsValue);
                if (!Checker.isEmpty(this.bindArgs)) {
                    int i = 0;
                    while (i < this.bindArgs.length) {
                        int i2 = i + 1;
                        bind(i2, this.bindArgs[i]);
                        i = i2;
                    }
                }
                this.mStatement.execute();
                if (tableManager != null) {
                    mapRelationToDb(next, true, z, sQLiteDatabase, tableManager);
                    z = false;
                }
            }
            if (OrmLog.isPrint) {
                String str = TAG;
                OrmLog.i(str, "Exec update [" + collection.size() + "] rows , SQL: " + this.sql);
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (OrmLog.isPrint) {
                OrmLog.d(TAG, "----> BeginTransaction[update col] Successful");
            }
            int size = collection.size();
            realease();
            sQLiteDatabase.endTransaction();
            return size;
        } catch (Exception e2) {
            if (OrmLog.isPrint) {
                OrmLog.e(TAG, "----> BeginTransaction[update col] Failling");
            }
            e2.printStackTrace();
            realease();
            sQLiteDatabase.endTransaction();
            return -1;
        } catch (Throwable th) {
            realease();
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    public int execDelete(SQLiteDatabase sQLiteDatabase) throws IOException {
        return execDeleteWithMapping(sQLiteDatabase, (Object) null, (TableManager) null);
    }

    public int execDeleteWithMapping(SQLiteDatabase sQLiteDatabase, Object obj, TableManager tableManager) throws IOException {
        printSQL();
        this.mStatement = sQLiteDatabase.compileStatement(this.sql);
        int i = 0;
        if (this.bindArgs != null) {
            int i2 = 0;
            while (true) {
                Object[] objArr = this.bindArgs;
                if (i2 >= objArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                bind(i3, objArr[i2]);
                i2 = i3;
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.mStatement.execute();
        } else {
            i = this.mStatement.executeUpdateDelete();
        }
        if (OrmLog.isPrint) {
            String str = TAG;
            OrmLog.v(str, "SQL execute delete, changed rows--> " + i);
        }
        realease();
        if (!(tableManager == null || obj == null)) {
            mapRelationToDb(obj, false, false, sQLiteDatabase, tableManager);
        }
        return i;
    }

    public int execDeleteCollection(SQLiteDatabase sQLiteDatabase, Collection<?> collection) throws IOException {
        return execDeleteCollectionWithMapping(sQLiteDatabase, collection, (TableManager) null);
    }

    public int execDeleteCollectionWithMapping(SQLiteDatabase sQLiteDatabase, final Collection<?> collection, final TableManager tableManager) throws IOException {
        int i;
        printSQL();
        this.mStatement = sQLiteDatabase.compileStatement(this.sql);
        if (this.bindArgs != null) {
            int i2 = 0;
            while (true) {
                Object[] objArr = this.bindArgs;
                if (i2 >= objArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                bind(i3, objArr[i2]);
                i2 = i3;
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.mStatement.execute();
            i = collection.size();
        } else {
            i = this.mStatement.executeUpdateDelete();
        }
        if (OrmLog.isPrint) {
            String str = TAG;
            OrmLog.v(str, "SQL execute delete, changed rows --> " + i);
        }
        realease();
        if (tableManager != null) {
            Boolean bool = (Boolean) Transaction.execute(sQLiteDatabase, new Transaction.Worker<Boolean>() {
                /* renamed from: a */
                public Boolean doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                    boolean z = true;
                    for (Object access$000 : collection) {
                        SQLStatement.this.mapRelationToDb(access$000, false, z, sQLiteDatabase, tableManager);
                        z = false;
                    }
                    return true;
                }
            });
            if (OrmLog.isPrint) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Exec delete collection mapping: ");
                sb.append((bool == null || !bool.booleanValue()) ? "失败" : "成功");
                OrmLog.i(str2, sb.toString());
            }
        }
        return i;
    }

    public boolean execute(SQLiteDatabase sQLiteDatabase) {
        printSQL();
        try {
            this.mStatement = sQLiteDatabase.compileStatement(this.sql);
            if (this.bindArgs != null) {
                int i = 0;
                while (i < this.bindArgs.length) {
                    int i2 = i + 1;
                    bind(i2, this.bindArgs[i]);
                    i = i2;
                }
            }
            this.mStatement.execute();
            realease();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            realease();
            return false;
        } catch (Throwable th) {
            realease();
            throw th;
        }
    }

    public long queryForLong(SQLiteDatabase sQLiteDatabase) {
        printSQL();
        long j = 0;
        try {
            this.mStatement = sQLiteDatabase.compileStatement(this.sql);
            if (this.bindArgs != null) {
                int i = 0;
                while (i < this.bindArgs.length) {
                    int i2 = i + 1;
                    bind(i2, this.bindArgs[i]);
                    i = i2;
                }
            }
            j = this.mStatement.simpleQueryForLong();
            if (OrmLog.isPrint) {
                String str = TAG;
                OrmLog.i(str, "SQL execute query for count --> " + j);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            realease();
            throw th;
        }
        realease();
        return j;
    }

    public <T> ArrayList<T> query(SQLiteDatabase sQLiteDatabase, final Class<T> cls) {
        printSQL();
        final ArrayList<T> arrayList = new ArrayList<>();
        try {
            final EntityTable table = TableManager.getTable(cls, false);
            Querier.doQuery(sQLiteDatabase, this, new Querier.CursorParser() {
                public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                    Object newInstance = ClassUtil.newInstance(cls);
                    DataUtil.injectDataToObject(cursor, newInstance, table);
                    arrayList.add(newInstance);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public <T> T queryOneEntity(SQLiteDatabase sQLiteDatabase, final Class<T> cls) {
        printSQL();
        final EntityTable table = TableManager.getTable(cls, false);
        return Querier.doQuery(sQLiteDatabase, this, new Querier.CursorParser<T>() {

            /* renamed from: a  reason: collision with root package name */
            T f15124a;

            public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                this.f15124a = ClassUtil.newInstance(cls);
                DataUtil.injectDataToObject(cursor, this.f15124a, table);
                stopParse();
            }

            public T returnResult() {
                return this.f15124a;
            }
        });
    }

    public String toString() {
        return "SQLStatement [sql=" + this.sql + ", bindArgs=" + Arrays.toString(this.bindArgs) + ", mStatement=" + this.mStatement + "]";
    }

    /* access modifiers changed from: private */
    public void mapRelationToDb(Object obj, boolean z, boolean z2, SQLiteDatabase sQLiteDatabase, TableManager tableManager) {
        final MapInfo buildMappingInfo = SQLBuilder.buildMappingInfo(obj, z, tableManager);
        if (buildMappingInfo != null && !buildMappingInfo.isEmpty()) {
            final boolean z3 = z;
            final boolean z4 = z2;
            final TableManager tableManager2 = tableManager;
            Transaction.execute(sQLiteDatabase, new Transaction.Worker<Boolean>() {
                /* renamed from: a */
                public Boolean doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                    if (z3 && z4) {
                        Iterator<MapInfo.MapTable> it = buildMappingInfo.tableList.iterator();
                        while (it.hasNext()) {
                            MapInfo.MapTable next = it.next();
                            tableManager2.checkOrCreateMappingTable(sQLiteDatabase, next.name, next.column1, next.column2);
                        }
                    }
                    if (buildMappingInfo.delOldRelationSQL != null) {
                        Iterator<SQLStatement> it2 = buildMappingInfo.delOldRelationSQL.iterator();
                        while (it2.hasNext()) {
                            long execDelete = (long) it2.next().execDelete(sQLiteDatabase);
                            if (OrmLog.isPrint) {
                                String access$100 = SQLStatement.TAG;
                                OrmLog.v(access$100, "Exec delete mapping success, nums: " + execDelete);
                            }
                        }
                    }
                    if (z3 && buildMappingInfo.mapNewRelationSQL != null) {
                        Iterator<SQLStatement> it3 = buildMappingInfo.mapNewRelationSQL.iterator();
                        while (it3.hasNext()) {
                            long execInsert = it3.next().execInsert(sQLiteDatabase);
                            if (OrmLog.isPrint) {
                                String access$1002 = SQLStatement.TAG;
                                OrmLog.v(access$1002, "Exec save mapping success, nums: " + execInsert);
                            }
                        }
                    }
                    return true;
                }
            });
        }
    }

    private void printSQL() {
        if (OrmLog.isPrint) {
            String str = TAG;
            OrmLog.d(str, "SQL Execute: [" + this.sql + "] ARGS--> " + Arrays.toString(this.bindArgs));
        }
    }

    private void realease() {
        SQLiteStatement sQLiteStatement = this.mStatement;
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
        }
        this.bindArgs = null;
        this.mStatement = null;
    }
}
