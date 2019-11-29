package com.litesuits.orm.db.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.Querier;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.Transaction;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.MapProperty;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.db.model.RelationKey;
import com.litesuits.orm.db.utils.ClassUtil;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class CascadeSQLiteImpl extends LiteOrm {
    public static final String TAG = "CascadeSQLiteImpl";
    public static final int TYPE_DELETE = 3;
    public static final int TYPE_INSERT = 1;
    public static final int TYPE_UPDATE = 2;

    public LiteOrm cascade() {
        return this;
    }

    protected CascadeSQLiteImpl(LiteOrm liteOrm) {
        super(liteOrm);
    }

    private CascadeSQLiteImpl(DataBaseConfig dataBaseConfig) {
        super(dataBaseConfig);
    }

    public static synchronized LiteOrm newInstance(DataBaseConfig dataBaseConfig) {
        CascadeSQLiteImpl cascadeSQLiteImpl;
        synchronized (CascadeSQLiteImpl.class) {
            cascadeSQLiteImpl = new CascadeSQLiteImpl(dataBaseConfig);
        }
        return cascadeSQLiteImpl;
    }

    public LiteOrm single() {
        if (this.otherDatabase == null) {
            this.otherDatabase = new SingleSQLiteImpl((LiteOrm) this);
        }
        return this.otherDatabase;
    }

    public long save(final Object obj) {
        long j;
        acquireReference();
        try {
            Long l = (Long) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Long>() {
                /* renamed from: a */
                public Long doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                    return Long.valueOf(CascadeSQLiteImpl.this.checkTableAndSaveRecursive(obj, sQLiteDatabase, new HashMap()));
                }
            });
            if (l == null) {
                j = -1;
            } else {
                j = l.longValue();
            }
            return j;
        } finally {
            releaseReference();
        }
    }

    public <T> int save(Collection<T> collection) {
        acquireReference();
        try {
            return saveCollection(collection);
        } finally {
            releaseReference();
        }
    }

    public long insert(Object obj) {
        return insert(obj, (ConflictAlgorithm) null);
    }

    public long insert(final Object obj, final ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        long j = -1;
        try {
            Long l = (Long) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Long>() {
                /* renamed from: a */
                public Long doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                    CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(sQLiteDatabase, obj);
                    return Long.valueOf(CascadeSQLiteImpl.this.insertRecursive(SQLBuilder.buildInsertSql(obj, conflictAlgorithm), obj, sQLiteDatabase, new HashMap()));
                }
            });
            if (l != null) {
                j = l.longValue();
            }
            return j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            releaseReference();
        }
    }

    public <T> int insert(Collection<T> collection) {
        return insert(collection, (ConflictAlgorithm) null);
    }

    /* JADX INFO: finally extract failed */
    public <T> int insert(Collection<T> collection, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            int insertCollection = insertCollection(collection, conflictAlgorithm);
            releaseReference();
            return insertCollection;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public int update(Object obj) {
        return update(obj, (ColumnsValue) null, (ConflictAlgorithm) null);
    }

    public int update(Object obj, ConflictAlgorithm conflictAlgorithm) {
        return update(obj, (ColumnsValue) null, conflictAlgorithm);
    }

    public int update(final Object obj, final ColumnsValue columnsValue, final ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        int i = -1;
        try {
            Integer num = (Integer) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
                /* renamed from: a */
                public Integer doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                    HashMap hashMap = new HashMap();
                    SQLStatement buildUpdateSql = SQLBuilder.buildUpdateSql(obj, columnsValue, conflictAlgorithm);
                    CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(sQLiteDatabase, obj);
                    return Integer.valueOf(CascadeSQLiteImpl.this.updateRecursive(buildUpdateSql, obj, sQLiteDatabase, hashMap));
                }
            });
            if (num != null) {
                i = num.intValue();
            }
            return i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            releaseReference();
        }
    }

    public <T> int update(Collection<T> collection) {
        return update(collection, (ColumnsValue) null, (ConflictAlgorithm) null);
    }

    public <T> int update(Collection<T> collection, ConflictAlgorithm conflictAlgorithm) {
        return update(collection, (ColumnsValue) null, conflictAlgorithm);
    }

    /* JADX INFO: finally extract failed */
    public <T> int update(Collection<T> collection, ColumnsValue columnsValue, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            int updateCollection = updateCollection(collection, columnsValue, conflictAlgorithm);
            releaseReference();
            return updateCollection;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public int delete(final Object obj) {
        acquireReference();
        try {
            Integer num = (Integer) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
                /* renamed from: a */
                public Integer doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                    return Integer.valueOf(CascadeSQLiteImpl.this.checkTableAndDeleteRecursive(obj, sQLiteDatabase, new HashMap()));
                }
            });
            if (num != null) {
                int intValue = num.intValue();
                releaseReference();
                return intValue;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
        releaseReference();
        return -1;
    }

    public <T> int delete(Class<T> cls) {
        return deleteAll(cls);
    }

    /* JADX INFO: finally extract failed */
    public <T> int delete(Collection<T> collection) {
        acquireReference();
        try {
            int deleteCollectionIfTableHasCreated = deleteCollectionIfTableHasCreated(collection);
            releaseReference();
            return deleteCollectionIfTableHasCreated;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public <T> int delete(Class<T> cls, WhereBuilder whereBuilder) {
        acquireReference();
        try {
            EntityTable table = TableManager.getTable((Class<?>) cls);
            delete(query(QueryBuilder.create(cls).columns(new String[]{table.key.column}).where(whereBuilder)));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
        releaseReference();
        return -1;
    }

    public int delete(WhereBuilder whereBuilder) {
        acquireReference();
        try {
            EntityTable table = TableManager.getTable((Class<?>) whereBuilder.getTableClass());
            deleteCollectionIfTableHasCreated(query(QueryBuilder.create(whereBuilder.getTableClass()).columns(new String[]{table.key.column}).where(whereBuilder)));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
        releaseReference();
        return -1;
    }

    public <T> int deleteAll(Class<T> cls) {
        acquireReference();
        try {
            EntityTable table = TableManager.getTable((Class<?>) cls);
            return delete(query(QueryBuilder.create(cls).columns(new String[]{table.key.column})));
        } finally {
            releaseReference();
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x005d=Splitter:B:15:0x005d, B:11:0x001f=Splitter:B:11:0x001f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> int delete(java.lang.Class<T> r4, long r5, long r7, java.lang.String r9) {
        /*
            r3 = this;
            r3.acquireReference()
            r0 = 0
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x005d
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x005d
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0014
            r0 = 1
            long r5 = r5 - r0
        L_0x0014:
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x001e
            r7 = -1
            goto L_0x001f
        L_0x001e:
            long r7 = r7 - r5
        L_0x001f:
            com.litesuits.orm.db.model.EntityTable r0 = com.litesuits.orm.db.TableManager.getTable((java.lang.Class<?>) r4)     // Catch:{ all -> 0x0065 }
            com.litesuits.orm.db.assit.QueryBuilder r4 = com.litesuits.orm.db.assit.QueryBuilder.create(r4)     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            r1.append(r5)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = ","
            r1.append(r5)     // Catch:{ all -> 0x0065 }
            r1.append(r7)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0065 }
            com.litesuits.orm.db.assit.QueryBuilder r4 = r4.limit(r5)     // Catch:{ all -> 0x0065 }
            com.litesuits.orm.db.assit.QueryBuilder r4 = r4.appendOrderAscBy(r9)     // Catch:{ all -> 0x0065 }
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0065 }
            r6 = 0
            com.litesuits.orm.db.model.Primarykey r7 = r0.key     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = r7.column     // Catch:{ all -> 0x0065 }
            r5[r6] = r7     // Catch:{ all -> 0x0065 }
            com.litesuits.orm.db.assit.QueryBuilder r4 = r4.columns(r5)     // Catch:{ all -> 0x0065 }
            java.util.ArrayList r4 = r3.query(r4)     // Catch:{ all -> 0x0065 }
            int r4 = r3.delete(r4)     // Catch:{ all -> 0x0065 }
            r3.releaseReference()
            return r4
        L_0x005d:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = "start must >=0 and smaller than end"
            r4.<init>(r5)     // Catch:{ all -> 0x0065 }
            throw r4     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r4 = move-exception
            r3.releaseReference()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.litesuits.orm.db.impl.CascadeSQLiteImpl.delete(java.lang.Class, long, long, java.lang.String):int");
    }

    public <T> ArrayList<T> query(Class<T> cls) {
        return checkTableAndQuery(cls, new QueryBuilder(cls));
    }

    public <T> ArrayList<T> query(QueryBuilder<T> queryBuilder) {
        return checkTableAndQuery(queryBuilder.getQueryClass(), queryBuilder);
    }

    public <T> T queryById(long j, Class<T> cls) {
        return queryById(String.valueOf(j), cls);
    }

    public <T> T queryById(String str, Class<T> cls) {
        ArrayList<T> checkTableAndQuery = checkTableAndQuery(cls, new QueryBuilder(cls).whereEquals(TableManager.getTable((Class<?>) cls).key.column, String.valueOf(str)));
        if (!Checker.isEmpty((Collection<?>) checkTableAndQuery)) {
            return checkTableAndQuery.get(0);
        }
        return null;
    }

    private <T> ArrayList<T> checkTableAndQuery(Class<T> cls, QueryBuilder queryBuilder) {
        acquireReference();
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            final EntityTable table = TableManager.getTable(cls, false);
            if (this.mTableManager.isSQLTableCreated(table.name)) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                SQLiteDatabase readableDatabase = this.mHelper.getReadableDatabase();
                final Class<T> cls2 = cls;
                final ArrayList<T> arrayList2 = arrayList;
                final HashMap hashMap3 = hashMap;
                Querier.doQuery(readableDatabase, queryBuilder.createStatement(), new Querier.CursorParser() {
                    public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                        Object newInstance = ClassUtil.newInstance(cls2);
                        DataUtil.injectDataToObject(cursor, newInstance, table);
                        arrayList2.add(newInstance);
                        HashMap hashMap = hashMap3;
                        hashMap.put(table.name + FieldUtil.get(table.key.field, newInstance), newInstance);
                    }
                });
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    queryForMappingRecursive(it.next(), readableDatabase, hashMap2, hashMap);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
        releaseReference();
        return arrayList;
    }

    private void queryForMappingRecursive(Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap, HashMap<String, Object> hashMap2) throws IllegalAccessException, InstantiationException {
        EntityTable table = TableManager.getTable(obj);
        Object assignedKeyObject = FieldUtil.getAssignedKeyObject(table.key, obj);
        String str = table.name + assignedKeyObject;
        if (hashMap.get(str) == null) {
            hashMap.put(str, 1);
            if (table.mappingList != null) {
                Iterator<MapProperty> it = table.mappingList.iterator();
                while (it.hasNext()) {
                    MapProperty next = it.next();
                    if (next.isToOne()) {
                        queryMapToOne(table, assignedKeyObject, obj, next.field, sQLiteDatabase, hashMap, hashMap2);
                    } else if (next.isToMany()) {
                        queryMapToMany(table, assignedKeyObject, obj, next.field, sQLiteDatabase, hashMap, hashMap2);
                    }
                }
            }
        }
    }

    private void queryMapToOne(final EntityTable entityTable, Object obj, Object obj2, Field field, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap, HashMap<String, Object> hashMap2) throws IllegalAccessException, InstantiationException {
        final EntityTable table = TableManager.getTable(field.getType());
        if (this.mTableManager.isSQLMapTableCreated(entityTable.name, table.name)) {
            SQLStatement buildQueryRelationSql = SQLBuilder.buildQueryRelationSql(entityTable, table, obj);
            final RelationKey relationKey = new RelationKey();
            Querier.doQuery(sQLiteDatabase, buildQueryRelationSql, new Querier.CursorParser() {
                public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                    relationKey.key1 = cursor.getString(cursor.getColumnIndex(entityTable.name));
                    relationKey.key2 = cursor.getString(cursor.getColumnIndex(table.name));
                    stopParse();
                }
            });
            if (relationKey.isOK()) {
                String str = table.name + relationKey.key2;
                Object obj3 = hashMap2.get(str);
                if (obj3 == null) {
                    obj3 = SQLBuilder.buildQueryMapEntitySql(table, relationKey.key2).queryOneEntity(sQLiteDatabase, table.claxx);
                    hashMap2.put(str, obj3);
                }
                if (obj3 != null) {
                    FieldUtil.set(field, obj2, obj3);
                    queryForMappingRecursive(obj3, sQLiteDatabase, hashMap, hashMap2);
                }
            }
        }
    }

    private void queryMapToMany(EntityTable entityTable, Object obj, Object obj2, Field field, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap, HashMap<String, Object> hashMap2) throws IllegalAccessException, InstantiationException {
        Class<?> componentType;
        EntityTable entityTable2 = entityTable;
        Object obj3 = obj2;
        Field field2 = field;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        HashMap<String, Object> hashMap3 = hashMap2;
        String str = "OneToMany and ManyToMany Relation, you must use collection or array object";
        if (Collection.class.isAssignableFrom(field.getType())) {
            componentType = FieldUtil.getGenericType(field);
        } else if (field.getType().isArray()) {
            componentType = FieldUtil.getComponentType(field);
        } else {
            throw new RuntimeException(str);
        }
        Class<?> cls = componentType;
        final EntityTable table = TableManager.getTable(cls);
        if (this.mTableManager.isSQLMapTableCreated(entityTable2.name, table.name)) {
            SQLStatement buildQueryRelationSql = SQLBuilder.buildQueryRelationSql(entityTable2, table, obj);
            final ArrayList arrayList = new ArrayList();
            Querier.doQuery(sQLiteDatabase2, buildQueryRelationSql, new Querier.CursorParser() {
                public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                    arrayList.add(cursor.getString(cursor.getColumnIndex(table.name)));
                }
            });
            if (!Checker.isEmpty((Collection<?>) arrayList)) {
                ArrayList arrayList2 = new ArrayList();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Object obj4 = hashMap3.get(table.name + ((String) arrayList.get(size)));
                    if (obj4 != null) {
                        arrayList2.add(obj4);
                        arrayList.remove(size);
                    }
                }
                int i = 0;
                int i2 = 0;
                while (i < arrayList.size()) {
                    int i3 = i2 + 1;
                    int i4 = i3 * SQLStatement.IN_TOP_LIMIT;
                    List subList = arrayList.subList(i, Math.min(arrayList.size(), i4));
                    ArrayList arrayList3 = arrayList;
                    AnonymousClass11 r14 = r0;
                    final Class<?> cls2 = cls;
                    String str2 = str;
                    SQLStatement createStatement = QueryBuilder.create(cls).whereIn(table.key.column, subList.toArray(new String[subList.size()])).createStatement();
                    final EntityTable entityTable3 = table;
                    int i5 = i4;
                    final ArrayList arrayList4 = arrayList2;
                    int i6 = i3;
                    final HashMap<String, Object> hashMap4 = hashMap2;
                    AnonymousClass11 r0 = new Querier.CursorParser() {
                        public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                            Object newInstance = ClassUtil.newInstance(cls2);
                            DataUtil.injectDataToObject(cursor, newInstance, entityTable3);
                            arrayList4.add(newInstance);
                            HashMap hashMap = hashMap4;
                            hashMap.put(entityTable3.name + FieldUtil.get(entityTable3.key.field, newInstance), newInstance);
                        }
                    };
                    Querier.doQuery(sQLiteDatabase2, createStatement, r14);
                    arrayList = arrayList3;
                    str = str2;
                    i = i5;
                    i2 = i6;
                }
                String str3 = str;
                if (!Checker.isEmpty((Collection<?>) arrayList2)) {
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        Collection collection = (Collection) ClassUtil.newCollectionForField(field);
                        collection.addAll(arrayList2);
                        FieldUtil.set(field2, obj3, collection);
                    } else if (field.getType().isArray()) {
                        FieldUtil.set(field2, obj3, arrayList2.toArray((Object[]) ClassUtil.newArray(cls, arrayList2.size())));
                    } else {
                        throw new RuntimeException(str3);
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        queryForMappingRecursive(it.next(), sQLiteDatabase2, hashMap, hashMap3);
                    }
                }
            }
        }
    }

    private <T> int saveCollection(final Collection<T> collection) {
        if (Checker.isEmpty((Collection<?>) collection)) {
            return -1;
        }
        Integer num = (Integer) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            /* renamed from: a */
            public Integer doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                HashMap hashMap = new HashMap();
                Iterator it = collection.iterator();
                Object next = it.next();
                SQLStatement buildReplaceSql = SQLBuilder.buildReplaceSql(next);
                CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(sQLiteDatabase, next);
                long unused = CascadeSQLiteImpl.this.insertRecursive(buildReplaceSql, next, sQLiteDatabase, hashMap);
                while (it.hasNext()) {
                    Object next2 = it.next();
                    buildReplaceSql.bindArgs = SQLBuilder.buildInsertSqlArgsOnly(next2);
                    long unused2 = CascadeSQLiteImpl.this.insertRecursive(buildReplaceSql, next2, sQLiteDatabase, hashMap);
                }
                return Integer.valueOf(collection.size());
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private <T> int insertCollection(final Collection<T> collection, final ConflictAlgorithm conflictAlgorithm) {
        if (Checker.isEmpty((Collection<?>) collection)) {
            return -1;
        }
        Integer num = (Integer) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            /* renamed from: a */
            public Integer doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                HashMap hashMap = new HashMap();
                Iterator it = collection.iterator();
                Object next = it.next();
                SQLStatement buildInsertSql = SQLBuilder.buildInsertSql(next, conflictAlgorithm);
                CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(sQLiteDatabase, next);
                long unused = CascadeSQLiteImpl.this.insertRecursive(buildInsertSql, next, sQLiteDatabase, hashMap);
                while (it.hasNext()) {
                    Object next2 = it.next();
                    buildInsertSql.bindArgs = SQLBuilder.buildInsertSqlArgsOnly(next2);
                    long unused2 = CascadeSQLiteImpl.this.insertRecursive(buildInsertSql, next2, sQLiteDatabase, hashMap);
                }
                return Integer.valueOf(collection.size());
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private <T> int updateCollection(final Collection<T> collection, final ColumnsValue columnsValue, final ConflictAlgorithm conflictAlgorithm) {
        if (Checker.isEmpty((Collection<?>) collection)) {
            return -1;
        }
        Integer num = (Integer) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            /* renamed from: a */
            public Integer doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                HashMap hashMap = new HashMap();
                Iterator it = collection.iterator();
                Object next = it.next();
                SQLStatement buildUpdateSql = SQLBuilder.buildUpdateSql(next, columnsValue, conflictAlgorithm);
                CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(sQLiteDatabase, next);
                int unused = CascadeSQLiteImpl.this.updateRecursive(buildUpdateSql, next, sQLiteDatabase, hashMap);
                while (it.hasNext()) {
                    Object next2 = it.next();
                    buildUpdateSql.bindArgs = SQLBuilder.buildUpdateSqlArgsOnly(next2, columnsValue);
                    int unused2 = CascadeSQLiteImpl.this.updateRecursive(buildUpdateSql, next2, sQLiteDatabase, hashMap);
                }
                return Integer.valueOf(collection.size());
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private <T> int deleteCollectionIfTableHasCreated(final Collection<T> collection) {
        if (Checker.isEmpty((Collection<?>) collection)) {
            return -1;
        }
        final Iterator<T> it = collection.iterator();
        final T next = it.next();
        if (!this.mTableManager.isSQLTableCreated(TableManager.getTable((Object) next).name)) {
            return -1;
        }
        Integer num = (Integer) Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            /* renamed from: a */
            public Integer doTransaction(SQLiteDatabase sQLiteDatabase) throws Exception {
                HashMap hashMap = new HashMap();
                SQLStatement buildDeleteSql = SQLBuilder.buildDeleteSql(next);
                int unused = CascadeSQLiteImpl.this.deleteRecursive(buildDeleteSql, next, sQLiteDatabase, hashMap);
                while (it.hasNext()) {
                    Object next = it.next();
                    buildDeleteSql.bindArgs = CascadeSQLiteImpl.getDeleteStatementArgs(next);
                    int unused2 = CascadeSQLiteImpl.this.deleteRecursive(buildDeleteSql, next, sQLiteDatabase, hashMap);
                }
                return Integer.valueOf(collection.size());
            }
        });
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static Object[] getDeleteStatementArgs(Object obj) throws IllegalAccessException {
        EntityTable table = TableManager.getTable(obj);
        int i = 0;
        if (table.key != null) {
            return new String[]{String.valueOf(FieldUtil.get(table.key.field, obj))};
        } else if (Checker.isEmpty((Map<?, ?>) table.pmap)) {
            return null;
        } else {
            Object[] objArr = new Object[table.pmap.size()];
            for (Property property : table.pmap.values()) {
                objArr[i] = FieldUtil.get(property.field, obj);
                i++;
            }
            return objArr;
        }
    }

    private long handleEntityRecursive(int i, SQLStatement sQLStatement, Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap) throws Exception {
        Object obj2;
        int i2;
        int i3 = i;
        SQLStatement sQLStatement2 = sQLStatement;
        Object obj3 = obj;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        HashMap<String, Integer> hashMap2 = hashMap;
        EntityTable table = TableManager.getTable(obj);
        Object obj4 = FieldUtil.get(table.key.field, obj);
        long j = -1;
        if (hashMap2.get(table.name + obj4) != null) {
            return -1;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = sQLStatement.execUpdate(sQLiteDatabase2);
                j = (long) i2;
            } else if (i3 == 3) {
                i2 = sQLStatement.execDelete(sQLiteDatabase2);
                j = (long) i2;
            }
            obj2 = obj4;
        } else {
            j = sQLStatement.execInsert(sQLiteDatabase2, obj);
            obj2 = FieldUtil.get(table.key.field, obj);
        }
        hashMap2.put(table.name + obj2, 1);
        handleMapping(obj2, obj, sQLiteDatabase, i3 != 3, hashMap);
        return j;
    }

    /* access modifiers changed from: private */
    public int updateRecursive(SQLStatement sQLStatement, Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap) throws Exception {
        EntityTable table = TableManager.getTable(obj);
        Object obj2 = FieldUtil.get(table.key.field, obj);
        if (hashMap.get(table.name + obj2) != null) {
            return -1;
        }
        int execUpdate = sQLStatement.execUpdate(sQLiteDatabase);
        Object obj3 = FieldUtil.get(table.key.field, obj);
        hashMap.put(table.name + obj3, 1);
        handleMapping(obj3, obj, sQLiteDatabase, true, hashMap);
        return execUpdate;
    }

    /* access modifiers changed from: private */
    public int deleteRecursive(SQLStatement sQLStatement, Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap) throws Exception {
        EntityTable table = TableManager.getTable(obj);
        Object obj2 = FieldUtil.get(table.key.field, obj);
        if (hashMap.get(table.name + obj2) != null) {
            return -1;
        }
        int execDelete = sQLStatement.execDelete(sQLiteDatabase);
        hashMap.put(table.name + obj2, 1);
        handleMapping(obj2, obj, sQLiteDatabase, false, hashMap);
        return execDelete;
    }

    /* access modifiers changed from: private */
    public long insertRecursive(SQLStatement sQLStatement, Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap) throws Exception {
        EntityTable table = TableManager.getTable(obj);
        Object obj2 = FieldUtil.get(table.key.field, obj);
        if (hashMap.get(table.name + obj2) != null) {
            return -1;
        }
        long execInsert = sQLStatement.execInsert(sQLiteDatabase, obj);
        Object obj3 = FieldUtil.get(table.key.field, obj);
        hashMap.put(table.name + obj3, 1);
        handleMapping(obj3, obj, sQLiteDatabase, true, hashMap);
        return execInsert;
    }

    /* access modifiers changed from: private */
    public long checkTableAndSaveRecursive(Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap) throws Exception {
        this.mTableManager.checkOrCreateTable(sQLiteDatabase, obj);
        return insertRecursive(SQLBuilder.buildReplaceSql(obj), obj, sQLiteDatabase, hashMap);
    }

    /* access modifiers changed from: private */
    public int checkTableAndDeleteRecursive(Object obj, SQLiteDatabase sQLiteDatabase, HashMap<String, Integer> hashMap) throws Exception {
        if (this.mTableManager.isSQLTableCreated(TableManager.getTable(obj).name)) {
            return deleteRecursive(SQLBuilder.buildDeleteSql(obj), obj, sQLiteDatabase, hashMap);
        }
        return -1;
    }

    private void handleMapping(Object obj, Object obj2, SQLiteDatabase sQLiteDatabase, boolean z, HashMap<String, Integer> hashMap) throws Exception {
        EntityTable table = TableManager.getTable(obj2);
        if (table.mappingList != null) {
            Iterator<MapProperty> it = table.mappingList.iterator();
            while (it.hasNext()) {
                MapProperty next = it.next();
                if (next.isToOne()) {
                    Object obj3 = FieldUtil.get(next.field, obj2);
                    handleMapToOne(table, TableManager.getTable(next.field.getType()), obj, obj3, sQLiteDatabase, z, hashMap);
                } else if (next.isToMany()) {
                    Object obj4 = FieldUtil.get(next.field, obj2);
                    if (ClassUtil.isCollection(next.field.getType())) {
                        handleMapToMany(table, TableManager.getTable(FieldUtil.getGenericType(next.field)), obj, (Collection) obj4, sQLiteDatabase, z, hashMap);
                    } else if (ClassUtil.isArray(next.field.getType())) {
                        EntityTable table2 = TableManager.getTable(FieldUtil.getComponentType(next.field));
                        List list = null;
                        if (obj4 != null) {
                            list = Arrays.asList((Object[]) obj4);
                        }
                        handleMapToMany(table, table2, obj, list, sQLiteDatabase, z, hashMap);
                    } else {
                        throw new RuntimeException("OneToMany and ManyToMany Relation, you must use collection or array object");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private void handleMapToOne(EntityTable entityTable, EntityTable entityTable2, Object obj, Object obj2, SQLiteDatabase sQLiteDatabase, boolean z, HashMap<String, Integer> hashMap) throws Exception {
        if (obj2 != null) {
            if (z) {
                checkTableAndSaveRecursive(obj2, sQLiteDatabase, hashMap);
            } else {
                checkTableAndDeleteRecursive(obj2, sQLiteDatabase, hashMap);
            }
        }
        String mapTableName = TableManager.getMapTableName(entityTable, entityTable2);
        this.mTableManager.checkOrCreateMappingTable(sQLiteDatabase, mapTableName, entityTable.name, entityTable2.name);
        SQLBuilder.buildMappingDeleteSql(mapTableName, obj, entityTable).execDelete(sQLiteDatabase);
        if (z && obj2 != null) {
            SQLStatement buildMappingToOneSql = SQLBuilder.buildMappingToOneSql(mapTableName, obj, FieldUtil.get(entityTable2.key.field, obj2), entityTable, entityTable2);
            if (buildMappingToOneSql != null) {
                buildMappingToOneSql.execInsert(sQLiteDatabase);
            }
        }
    }

    private void handleMapToMany(EntityTable entityTable, EntityTable entityTable2, Object obj, Collection collection, SQLiteDatabase sQLiteDatabase, boolean z, HashMap<String, Integer> hashMap) throws Exception {
        if (collection != null) {
            for (Object next : collection) {
                if (next != null) {
                    if (z) {
                        checkTableAndSaveRecursive(next, sQLiteDatabase, hashMap);
                    } else {
                        checkTableAndDeleteRecursive(next, sQLiteDatabase, hashMap);
                    }
                }
            }
        }
        String mapTableName = TableManager.getMapTableName(entityTable, entityTable2);
        this.mTableManager.checkOrCreateMappingTable(sQLiteDatabase, mapTableName, entityTable.name, entityTable2.name);
        SQLBuilder.buildMappingDeleteSql(mapTableName, obj, entityTable).execDelete(sQLiteDatabase);
        if (z && !Checker.isEmpty((Collection<?>) collection)) {
            ArrayList<SQLStatement> buildMappingToManySql = SQLBuilder.buildMappingToManySql(obj, entityTable, entityTable2, collection);
            if (!Checker.isEmpty((Collection<?>) buildMappingToManySql)) {
                Iterator<SQLStatement> it = buildMappingToManySql.iterator();
                while (it.hasNext()) {
                    it.next().execInsert(sQLiteDatabase);
                }
            }
        }
    }
}
