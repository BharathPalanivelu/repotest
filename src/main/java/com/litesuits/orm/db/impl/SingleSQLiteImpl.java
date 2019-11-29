package com.litesuits.orm.db.impl;

import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.CollSpliter;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import java.util.ArrayList;
import java.util.Collection;

public final class SingleSQLiteImpl extends LiteOrm {
    public static final String TAG = "SingleSQLiteImpl";

    public LiteOrm single() {
        return this;
    }

    protected SingleSQLiteImpl(LiteOrm liteOrm) {
        super(liteOrm);
    }

    private SingleSQLiteImpl(DataBaseConfig dataBaseConfig) {
        super(dataBaseConfig);
    }

    public static synchronized LiteOrm newInstance(DataBaseConfig dataBaseConfig) {
        SingleSQLiteImpl singleSQLiteImpl;
        synchronized (SingleSQLiteImpl.class) {
            singleSQLiteImpl = new SingleSQLiteImpl(dataBaseConfig);
        }
        return singleSQLiteImpl;
    }

    public LiteOrm cascade() {
        if (this.otherDatabase == null) {
            this.otherDatabase = new CascadeSQLiteImpl((LiteOrm) this);
        }
        return this.otherDatabase;
    }

    /* JADX INFO: finally extract failed */
    public long save(Object obj) {
        acquireReference();
        try {
            SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
            this.mTableManager.checkOrCreateTable(writableDatabase, obj);
            long execInsert = SQLBuilder.buildReplaceSql(obj).execInsert(writableDatabase, obj);
            releaseReference();
            return execInsert;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public <T> int save(Collection<T> collection) {
        acquireReference();
        try {
            if (!Checker.isEmpty((Collection<?>) collection)) {
                SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
                T next = collection.iterator().next();
                this.mTableManager.checkOrCreateTable(writableDatabase, (Object) next);
                int execInsertCollection = SQLBuilder.buildReplaceAllSql(next).execInsertCollection(writableDatabase, collection);
                releaseReference();
                return execInsertCollection;
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

    public long insert(Object obj) {
        return insert(obj, (ConflictAlgorithm) null);
    }

    /* JADX INFO: finally extract failed */
    public long insert(Object obj, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
            this.mTableManager.checkOrCreateTable(writableDatabase, obj);
            long execInsert = SQLBuilder.buildInsertSql(obj, conflictAlgorithm).execInsert(writableDatabase, obj);
            releaseReference();
            return execInsert;
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseReference();
            return -1;
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public <T> int insert(Collection<T> collection) {
        return insert(collection, (ConflictAlgorithm) null);
    }

    public <T> int insert(Collection<T> collection, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            if (!Checker.isEmpty((Collection<?>) collection)) {
                SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
                T next = collection.iterator().next();
                SQLStatement buildInsertAllSql = SQLBuilder.buildInsertAllSql(next, conflictAlgorithm);
                this.mTableManager.checkOrCreateTable(writableDatabase, (Object) next);
                int execInsertCollection = buildInsertAllSql.execInsertCollection(writableDatabase, collection);
                releaseReference();
                return execInsertCollection;
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

    public int update(Object obj) {
        return update(obj, (ColumnsValue) null, (ConflictAlgorithm) null);
    }

    public int update(Object obj, ConflictAlgorithm conflictAlgorithm) {
        return update(obj, (ColumnsValue) null, conflictAlgorithm);
    }

    /* JADX INFO: finally extract failed */
    public int update(Object obj, ColumnsValue columnsValue, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
            this.mTableManager.checkOrCreateTable(writableDatabase, obj);
            int execUpdate = SQLBuilder.buildUpdateSql(obj, columnsValue, conflictAlgorithm).execUpdate(writableDatabase);
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

    public <T> int update(Collection<T> collection) {
        return update(collection, (ColumnsValue) null, (ConflictAlgorithm) null);
    }

    public <T> int update(Collection<T> collection, ConflictAlgorithm conflictAlgorithm) {
        return update(collection, (ColumnsValue) null, conflictAlgorithm);
    }

    public <T> int update(Collection<T> collection, ColumnsValue columnsValue, ConflictAlgorithm conflictAlgorithm) {
        acquireReference();
        try {
            if (!Checker.isEmpty((Collection<?>) collection)) {
                SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
                T next = collection.iterator().next();
                this.mTableManager.checkOrCreateTable(writableDatabase, (Object) next);
                int execUpdateCollection = SQLBuilder.buildUpdateAllSql(next, columnsValue, conflictAlgorithm).execUpdateCollection(writableDatabase, collection, columnsValue);
                releaseReference();
                return execUpdateCollection;
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

    public int delete(Object obj) {
        if (!this.mTableManager.isSQLTableCreated(TableManager.getTable(obj).name)) {
            return -1;
        }
        acquireReference();
        try {
            return SQLBuilder.buildDeleteSql(obj).execDelete(this.mHelper.getWritableDatabase());
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            releaseReference();
        }
    }

    public <T> int delete(Class<T> cls) {
        return deleteAll(cls);
    }

    public <T> int delete(Collection<T> collection) {
        final SQLiteDatabase writableDatabase;
        acquireReference();
        try {
            if (!Checker.isEmpty((Collection<?>) collection)) {
                if (this.mTableManager.isSQLTableCreated(TableManager.getTable((Object) collection.iterator().next()).name)) {
                    writableDatabase = this.mHelper.getWritableDatabase();
                    writableDatabase.beginTransaction();
                    int split = CollSpliter.split(collection, SQLStatement.IN_TOP_LIMIT, new CollSpliter.Spliter<T>() {
                        public int oneSplit(ArrayList<T> arrayList) throws Exception {
                            return SQLBuilder.buildDeleteSql((Collection<?>) arrayList).execDeleteCollection(writableDatabase, arrayList);
                        }
                    });
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    releaseReference();
                    return split;
                }
            }
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Throwable th) {
                releaseReference();
                throw th;
            }
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
        releaseReference();
        return -1;
    }

    @Deprecated
    public <T> int delete(Class<T> cls, WhereBuilder whereBuilder) {
        return delete(whereBuilder);
    }

    public int delete(WhereBuilder whereBuilder) {
        if (!this.mTableManager.isSQLTableCreated(TableManager.getTable(whereBuilder.getTableClass(), false).name)) {
            return -1;
        }
        acquireReference();
        try {
            return whereBuilder.createStatementDelete().execDelete(this.mHelper.getWritableDatabase());
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            releaseReference();
        }
    }

    public <T> int deleteAll(Class<T> cls) {
        if (!this.mTableManager.isSQLTableCreated(TableManager.getTable(cls, false).name)) {
            return -1;
        }
        acquireReference();
        try {
            return SQLBuilder.buildDeleteAllSql(cls).execDelete(this.mHelper.getWritableDatabase());
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            releaseReference();
        }
    }

    public <T> int delete(Class<T> cls, long j, long j2, String str) {
        if (!this.mTableManager.isSQLTableCreated(TableManager.getTable(cls, false).name)) {
            return -1;
        }
        acquireReference();
        if (j < 0 || j2 < j) {
            throw new RuntimeException("start must >=0 and smaller than end");
        }
        if (j != 0) {
            j--;
        }
        long j3 = j;
        try {
            return SQLBuilder.buildDeleteSql(cls, j3, j2 == 2147483647L ? -1 : j2 - j3, str).execDelete(this.mHelper.getWritableDatabase());
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            releaseReference();
        }
    }

    public <T> ArrayList<T> query(Class<T> cls) {
        return query(new QueryBuilder(cls));
    }

    public <T> ArrayList<T> query(QueryBuilder<T> queryBuilder) {
        if (!this.mTableManager.isSQLTableCreated(TableManager.getTable(queryBuilder.getQueryClass(), false).name)) {
            return new ArrayList<>();
        }
        acquireReference();
        try {
            return queryBuilder.createStatement().query(this.mHelper.getReadableDatabase(), queryBuilder.getQueryClass());
        } finally {
            releaseReference();
        }
    }

    public <T> T queryById(long j, Class<T> cls) {
        return queryById(String.valueOf(j), cls);
    }

    public <T> T queryById(String str, Class<T> cls) {
        EntityTable table = TableManager.getTable(cls, false);
        if (!this.mTableManager.isSQLTableCreated(table.name)) {
            return null;
        }
        acquireReference();
        try {
            QueryBuilder queryBuilder = new QueryBuilder(cls);
            ArrayList<T> query = queryBuilder.where(table.key.column + "=?", str).createStatement().query(this.mHelper.getReadableDatabase(), cls);
            if (!Checker.isEmpty((Collection<?>) query)) {
                return query.get(0);
            }
            releaseReference();
            return null;
        } finally {
            releaseReference();
        }
    }
}
