package com.litesuits.orm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.db.DataBase;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.CollSpliter;
import com.litesuits.orm.db.assit.Querier;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.SQLiteHelper;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.impl.CascadeSQLiteImpl;
import com.litesuits.orm.db.impl.SingleSQLiteImpl;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.MapProperty;
import com.litesuits.orm.db.model.RelationKey;
import com.litesuits.orm.db.utils.ClassUtil;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import com.litesuits.orm.log.OrmLog;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class LiteOrm extends SQLiteClosable implements DataBase {
    public static final String TAG = "LiteOrm";
    protected DataBaseConfig mConfig;
    protected SQLiteHelper mHelper;
    /* access modifiers changed from: protected */
    public TableManager mTableManager;
    protected LiteOrm otherDatabase;

    public abstract LiteOrm cascade();

    public abstract LiteOrm single();

    protected LiteOrm(LiteOrm liteOrm) {
        this.mHelper = liteOrm.mHelper;
        this.mConfig = liteOrm.mConfig;
        this.mTableManager = liteOrm.mTableManager;
        this.otherDatabase = liteOrm;
    }

    protected LiteOrm(DataBaseConfig dataBaseConfig) {
        dataBaseConfig.context = dataBaseConfig.context.getApplicationContext();
        if (dataBaseConfig.dbName == null) {
            dataBaseConfig.dbName = DataBaseConfig.DEFAULT_DB_NAME;
        }
        if (dataBaseConfig.dbVersion <= 0) {
            dataBaseConfig.dbVersion = 1;
        }
        this.mConfig = dataBaseConfig;
        setDebugged(dataBaseConfig.debugged);
        openOrCreateDatabase();
    }

    public SQLiteDatabase openOrCreateDatabase() {
        initDatabasePath(this.mConfig.dbName);
        if (this.mHelper != null) {
            justRelease();
        }
        this.mHelper = new SQLiteHelper(this.mConfig.context.getApplicationContext(), this.mConfig.dbName, (SQLiteDatabase.CursorFactory) null, this.mConfig.dbVersion, this.mConfig.onUpdateListener);
        this.mTableManager = new TableManager(this.mConfig.dbName, this.mHelper.getReadableDatabase());
        return this.mHelper.getWritableDatabase();
    }

    private void initDatabasePath(String str) {
        String str2 = TAG;
        OrmLog.i(str2, "create  database path: " + str);
        String path = this.mConfig.context.getDatabasePath(this.mConfig.dbName).getPath();
        String str3 = TAG;
        OrmLog.i(str3, "context database path: " + path);
        File parentFile = new File(path).getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            boolean mkdirs = parentFile.mkdirs();
            String str4 = TAG;
            OrmLog.i(str4, "create database, parent file mkdirs: " + mkdirs + "  path:" + parentFile.getAbsolutePath());
        }
    }

    public static LiteOrm newSingleInstance(Context context, String str) {
        return newSingleInstance(new DataBaseConfig(context, str));
    }

    public static synchronized LiteOrm newSingleInstance(DataBaseConfig dataBaseConfig) {
        LiteOrm newInstance;
        synchronized (LiteOrm.class) {
            newInstance = SingleSQLiteImpl.newInstance(dataBaseConfig);
        }
        return newInstance;
    }

    public static LiteOrm newCascadeInstance(Context context, String str) {
        return newCascadeInstance(new DataBaseConfig(context, str));
    }

    public static synchronized LiteOrm newCascadeInstance(DataBaseConfig dataBaseConfig) {
        LiteOrm newInstance;
        synchronized (LiteOrm.class) {
            newInstance = CascadeSQLiteImpl.newInstance(dataBaseConfig);
        }
        return newInstance;
    }

    public void setDebugged(boolean z) {
        this.mConfig.debugged = z;
        OrmLog.isPrint = z;
    }

    public ArrayList<RelationKey> queryRelation(Class cls, Class cls2, List<String> list) {
        acquireReference();
        ArrayList<RelationKey> arrayList = new ArrayList<>();
        try {
            final EntityTable table = TableManager.getTable((Class<?>) cls);
            final EntityTable table2 = TableManager.getTable((Class<?>) cls2);
            if (this.mTableManager.isSQLMapTableCreated(table.name, table2.name)) {
                final Class cls3 = cls;
                final Class cls4 = cls2;
                final List<String> list2 = list;
                final ArrayList<RelationKey> arrayList2 = arrayList;
                CollSpliter.split(list, SQLStatement.IN_TOP_LIMIT, new CollSpliter.Spliter<String>() {
                    public int oneSplit(ArrayList<String> arrayList) throws Exception {
                        Querier.doQuery(LiteOrm.this.mHelper.getReadableDatabase(), SQLBuilder.buildQueryRelationSql(cls3, cls4, (List<String>) list2), new Querier.CursorParser() {
                            public void parseEachCursor(SQLiteDatabase sQLiteDatabase, Cursor cursor) throws Exception {
                                RelationKey relationKey = new RelationKey();
                                relationKey.key1 = cursor.getString(cursor.getColumnIndex(table.name));
                                relationKey.key2 = cursor.getString(cursor.getColumnIndex(table2.name));
                                arrayList2.add(relationKey);
                            }
                        });
                        return 0;
                    }
                });
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

    public <E, T> boolean mapping(Collection<E> collection, Collection<T> collection2) {
        if (Checker.isEmpty((Collection<?>) collection) || Checker.isEmpty((Collection<?>) collection2)) {
            return false;
        }
        acquireReference();
        try {
            return keepMapping(collection2, collection) | keepMapping(collection, collection2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            releaseReference();
        }
    }

    public SQLStatement createSQLStatement(String str, Object[] objArr) {
        return new SQLStatement(str, objArr);
    }

    public boolean execute(SQLiteDatabase sQLiteDatabase, SQLStatement sQLStatement) {
        acquireReference();
        if (sQLStatement != null) {
            try {
                boolean execute = sQLStatement.execute(sQLiteDatabase);
                releaseReference();
                return execute;
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                releaseReference();
                throw th;
            }
        }
        releaseReference();
        return false;
    }

    @Deprecated
    public boolean dropTable(Object obj) {
        return dropTable(obj.getClass());
    }

    public boolean dropTable(Class<?> cls) {
        return dropTable(TableManager.getTable(cls, false).name);
    }

    /* JADX INFO: finally extract failed */
    public boolean dropTable(String str) {
        acquireReference();
        try {
            boolean execute = SQLBuilder.buildDropTable(str).execute(this.mHelper.getWritableDatabase());
            releaseReference();
            return execute;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return false;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public <T> long queryCount(Class<T> cls) {
        return queryCount(new QueryBuilder(cls));
    }

    /* JADX INFO: finally extract failed */
    public long queryCount(QueryBuilder queryBuilder) {
        acquireReference();
        try {
            if (this.mTableManager.isSQLTableCreated(queryBuilder.getTableName())) {
                long queryForLong = queryBuilder.createStatementForCount().queryForLong(this.mHelper.getReadableDatabase());
                releaseReference();
                return queryForLong;
            }
            releaseReference();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public int update(WhereBuilder whereBuilder, ColumnsValue columnsValue, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            int execUpdate = SQLBuilder.buildUpdateSql(whereBuilder, columnsValue, conflictAlgorithm).execUpdate(this.mHelper.getWritableDatabase());
            releaseReference();
            return execUpdate;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        return this.mHelper.getReadableDatabase();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        return this.mHelper.getWritableDatabase();
    }

    public TableManager getTableManager() {
        return this.mTableManager;
    }

    public SQLiteHelper getSQLiteHelper() {
        return this.mHelper;
    }

    public DataBaseConfig getDataBaseConfig() {
        return this.mConfig;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(this.mConfig.context.getDatabasePath(this.mConfig.dbName).getPath(), cursorFactory);
    }

    public boolean deleteDatabase() {
        String path = this.mHelper.getWritableDatabase().getPath();
        justRelease();
        String str = TAG;
        OrmLog.i(str, "data has cleared. delete Database path: " + path);
        return deleteDatabase(new File(path));
    }

    public boolean deleteDatabase(File file) {
        acquireReference();
        if (file != null) {
            try {
                boolean delete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    final String str = file.getName() + "-mj";
                    boolean z = delete;
                    for (File delete2 : parentFile.listFiles(new FileFilter() {
                        public boolean accept(File file) {
                            return file.getName().startsWith(str);
                        }
                    })) {
                        z |= delete2.delete();
                    }
                    delete = z;
                }
                return delete;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalArgumentException("file must not be null");
        }
    }

    public synchronized void close() {
        releaseReference();
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        justRelease();
    }

    /* access modifiers changed from: protected */
    public void justRelease() {
        SQLiteHelper sQLiteHelper = this.mHelper;
        if (sQLiteHelper != null) {
            sQLiteHelper.getWritableDatabase().close();
            this.mHelper.close();
            this.mHelper = null;
        }
        TableManager tableManager = this.mTableManager;
        if (tableManager != null) {
            tableManager.release();
            this.mTableManager = null;
        }
    }

    public static int releaseMemory() {
        return SQLiteDatabase.releaseMemory();
    }

    private <E, T> boolean keepMapping(Collection<E> collection, Collection<T> collection2) throws IllegalAccessException, InstantiationException {
        Class<?> cls = collection.iterator().next().getClass();
        Class<?> cls2 = collection2.iterator().next().getClass();
        EntityTable table = TableManager.getTable(cls);
        EntityTable table2 = TableManager.getTable(cls2);
        if (table.mappingList == null) {
            return false;
        }
        Iterator<MapProperty> it = table.mappingList.iterator();
        while (it.hasNext()) {
            MapProperty next = it.next();
            Class<?> type = next.field.getType();
            if (next.isToMany()) {
                if (ClassUtil.isCollection(type)) {
                    type = FieldUtil.getGenericType(next.field);
                } else if (type.isArray()) {
                    type = FieldUtil.getComponentType(next.field);
                } else {
                    throw new RuntimeException("OneToMany and ManyToMany Relation, Must use collection or array object");
                }
            }
            if (type == cls2) {
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                for (E next2 : collection) {
                    if (next2 != null) {
                        Object obj = FieldUtil.get(table.key.field, next2);
                        if (obj != null) {
                            arrayList.add(obj.toString());
                            hashMap.put(obj.toString(), next2);
                        }
                    }
                }
                ArrayList<RelationKey> queryRelation = queryRelation(cls, cls2, arrayList);
                if (!Checker.isEmpty((Collection<?>) queryRelation)) {
                    HashMap hashMap2 = new HashMap();
                    for (T next3 : collection2) {
                        if (next3 != null) {
                            Object obj2 = FieldUtil.get(table2.key.field, next3);
                            if (obj2 != null) {
                                hashMap2.put(obj2.toString(), next3);
                            }
                        }
                    }
                    HashMap hashMap3 = new HashMap();
                    Iterator<RelationKey> it2 = queryRelation.iterator();
                    while (it2.hasNext()) {
                        RelationKey next4 = it2.next();
                        Object obj3 = hashMap.get(next4.key1);
                        Object obj4 = hashMap2.get(next4.key2);
                        if (!(obj3 == null || obj4 == null)) {
                            if (next.isToMany()) {
                                ArrayList arrayList2 = (ArrayList) hashMap3.get(obj3);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    hashMap3.put(obj3, arrayList2);
                                }
                                arrayList2.add(obj4);
                            } else {
                                FieldUtil.set(next.field, obj3, obj4);
                            }
                        }
                    }
                    if (Checker.isEmpty((Map<?, ?>) hashMap3)) {
                        return true;
                    }
                    for (Map.Entry entry : hashMap3.entrySet()) {
                        Object key = entry.getKey();
                        Collection collection3 = (Collection) entry.getValue();
                        if (ClassUtil.isCollection(type)) {
                            Collection collection4 = (Collection) FieldUtil.get(next.field, key);
                            if (collection4 == null) {
                                FieldUtil.set(next.field, key, collection3);
                            } else {
                                collection4.addAll(collection3);
                            }
                        } else if (ClassUtil.isArray(type)) {
                            Object[] objArr = (Object[]) ClassUtil.newArray(type, collection3.size());
                            collection3.toArray(objArr);
                            Object[] objArr2 = (Object[]) FieldUtil.get(next.field, key);
                            if (objArr2 == null) {
                                FieldUtil.set(next.field, key, objArr);
                            } else {
                                FieldUtil.set(next.field, key, DataUtil.concat(objArr2, objArr));
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
