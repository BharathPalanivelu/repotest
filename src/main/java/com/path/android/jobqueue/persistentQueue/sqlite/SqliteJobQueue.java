package com.path.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteStatement;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.JobQueue;
import com.path.android.jobqueue.TagConstraint;
import com.path.android.jobqueue.log.JqLog;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SqliteJobQueue implements JobQueue {
    SQLiteDatabase db;
    DbOpenHelper dbOpenHelper;
    JobSerializer jobSerializer;
    QueryCache nextJobDelayUntilQueryCache;
    QueryCache nextJobsQueryCache;
    Set<Long> pendingCancelations = new HashSet();
    QueryCache readyJobsQueryCache;
    private final long sessionId;
    SqlHelper sqlHelper;

    public interface JobSerializer {
        <T extends Job> T deserialize(byte[] bArr) throws IOException, ClassNotFoundException;

        byte[] serialize(Object obj) throws IOException;
    }

    public SqliteJobQueue(Context context, long j, String str, JobSerializer jobSerializer2, boolean z) {
        String str2;
        this.sessionId = j;
        if (z) {
            str2 = null;
        } else {
            str2 = "db_" + str;
        }
        this.dbOpenHelper = new DbOpenHelper(context, str2);
        this.db = this.dbOpenHelper.getWritableDatabase();
        this.sqlHelper = new SqlHelper(this.db, "job_holder", DbOpenHelper.ID_COLUMN.columnName, 9, "job_holder_tags", 3, j);
        this.jobSerializer = jobSerializer2;
        this.readyJobsQueryCache = new QueryCache();
        this.nextJobsQueryCache = new QueryCache();
        this.nextJobDelayUntilQueryCache = new QueryCache();
        this.sqlHelper.resetDelayTimesTo(Long.MIN_VALUE);
    }

    public long insert(JobHolder jobHolder) {
        long executeInsert;
        if (jobHolder.hasTags()) {
            return insertWithTags(jobHolder);
        }
        SQLiteStatement insertStatement = this.sqlHelper.getInsertStatement();
        synchronized (insertStatement) {
            insertStatement.clearBindings();
            bindValues(insertStatement, jobHolder);
            executeInsert = insertStatement.executeInsert();
        }
        jobHolder.setId(Long.valueOf(executeInsert));
        return executeInsert;
    }

    private long insertWithTags(JobHolder jobHolder) {
        long executeInsert;
        SQLiteStatement insertStatement = this.sqlHelper.getInsertStatement();
        SQLiteStatement insertTagsStatement = this.sqlHelper.getInsertTagsStatement();
        synchronized (insertStatement) {
            this.db.beginTransaction();
            try {
                insertStatement.clearBindings();
                bindValues(insertStatement, jobHolder);
                executeInsert = insertStatement.executeInsert();
                for (String bindTag : jobHolder.getTags()) {
                    insertTagsStatement.clearBindings();
                    bindTag(insertTagsStatement, executeInsert, bindTag);
                    insertTagsStatement.executeInsert();
                }
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        jobHolder.setId(Long.valueOf(executeInsert));
        return executeInsert;
    }

    private void bindTag(SQLiteStatement sQLiteStatement, long j, String str) {
        sQLiteStatement.bindLong(DbOpenHelper.TAGS_JOB_ID_COLUMN.columnIndex + 1, j);
        sQLiteStatement.bindString(DbOpenHelper.TAGS_NAME_COLUMN.columnIndex + 1, str);
    }

    private void bindValues(SQLiteStatement sQLiteStatement, JobHolder jobHolder) {
        if (jobHolder.getId() != null) {
            sQLiteStatement.bindLong(DbOpenHelper.ID_COLUMN.columnIndex + 1, jobHolder.getId().longValue());
        }
        sQLiteStatement.bindLong(DbOpenHelper.PRIORITY_COLUMN.columnIndex + 1, (long) jobHolder.getPriority());
        if (jobHolder.getGroupId() != null) {
            sQLiteStatement.bindString(DbOpenHelper.GROUP_ID_COLUMN.columnIndex + 1, jobHolder.getGroupId());
        }
        sQLiteStatement.bindLong(DbOpenHelper.RUN_COUNT_COLUMN.columnIndex + 1, (long) jobHolder.getRunCount());
        byte[] serializeJob = getSerializeJob(jobHolder);
        if (serializeJob != null) {
            sQLiteStatement.bindBlob(DbOpenHelper.BASE_JOB_COLUMN.columnIndex + 1, serializeJob);
        }
        sQLiteStatement.bindLong(DbOpenHelper.CREATED_NS_COLUMN.columnIndex + 1, jobHolder.getCreatedNs());
        sQLiteStatement.bindLong(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnIndex + 1, jobHolder.getDelayUntilNs());
        sQLiteStatement.bindLong(DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnIndex + 1, jobHolder.getRunningSessionId());
        sQLiteStatement.bindLong(DbOpenHelper.REQUIRES_NETWORK_COLUMN.columnIndex + 1, jobHolder.requiresNetwork() ? 1 : 0);
    }

    public long insertOrReplace(JobHolder jobHolder) {
        long executeInsert;
        if (jobHolder.getId() == null) {
            return insert(jobHolder);
        }
        jobHolder.setRunningSessionId(Long.MIN_VALUE);
        SQLiteStatement insertOrReplaceStatement = this.sqlHelper.getInsertOrReplaceStatement();
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            bindValues(insertOrReplaceStatement, jobHolder);
            executeInsert = insertOrReplaceStatement.executeInsert();
        }
        jobHolder.setId(Long.valueOf(executeInsert));
        return executeInsert;
    }

    public void remove(JobHolder jobHolder) {
        if (jobHolder.getId() == null) {
            JqLog.e("called remove with null job id.", new Object[0]);
        } else {
            delete(jobHolder.getId());
        }
    }

    private void delete(Long l) {
        this.pendingCancelations.remove(l);
        SQLiteStatement deleteStatement = this.sqlHelper.getDeleteStatement();
        synchronized (deleteStatement) {
            deleteStatement.clearBindings();
            deleteStatement.bindLong(1, l.longValue());
            deleteStatement.execute();
        }
    }

    public int count() {
        int simpleQueryForLong;
        SQLiteStatement countStatement = this.sqlHelper.getCountStatement();
        synchronized (countStatement) {
            countStatement.clearBindings();
            countStatement.bindLong(1, this.sessionId);
            simpleQueryForLong = (int) countStatement.simpleQueryForLong();
        }
        return simpleQueryForLong;
    }

    public int countReadyJobs(boolean z, Collection<String> collection) {
        String str = this.readyJobsQueryCache.get(z, collection);
        if (str == null) {
            str = "SELECT SUM(case WHEN " + DbOpenHelper.GROUP_ID_COLUMN.columnName + " is null then group_cnt else 1 end) from (" + ("SELECT count(*) group_cnt, " + DbOpenHelper.GROUP_ID_COLUMN.columnName + " FROM " + "job_holder" + " WHERE " + createReadyJobWhereSql(z, collection, true)) + SQLBuilder.PARENTHESES_RIGHT;
            this.readyJobsQueryCache.set(str, z, collection);
        }
        Cursor rawQuery = this.db.rawQuery(str, new String[]{Long.toString(this.sessionId), Long.toString(System.nanoTime())});
        try {
            if (!rawQuery.moveToNext()) {
                return 0;
            }
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } finally {
            rawQuery.close();
        }
    }

    public JobHolder findJobById(long j) {
        Cursor rawQuery = this.db.rawQuery(this.sqlHelper.FIND_BY_ID_QUERY, new String[]{Long.toString(j)});
        try {
            if (!rawQuery.moveToFirst()) {
                return null;
            }
            JobHolder createJobHolderFromCursor = createJobHolderFromCursor(rawQuery);
            rawQuery.close();
            return createJobHolderFromCursor;
        } catch (InvalidJobException e2) {
            JqLog.e(e2, "invalid job on findJobById", new Object[0]);
            return null;
        } finally {
            rawQuery.close();
        }
    }

    public Set<JobHolder> findJobsByTags(TagConstraint tagConstraint, boolean z, Collection<Long> collection, String... strArr) {
        int i;
        if (strArr == null || strArr.length == 0) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        if (collection == null) {
            i = 0;
        } else {
            i = collection.size();
        }
        if (z) {
            i += this.pendingCancelations.size();
        }
        String createFindByTagsQuery = this.sqlHelper.createFindByTagsQuery(tagConstraint, i, strArr.length);
        JqLog.d(createFindByTagsQuery, new Object[0]);
        if (i != 0) {
            String[] strArr2 = new String[(i + strArr.length)];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            int length = strArr.length;
            for (Long l : collection) {
                strArr2[length] = l.toString();
                length++;
            }
            if (z) {
                for (Long l2 : this.pendingCancelations) {
                    strArr2[length] = l2.toString();
                    length++;
                }
            }
            strArr = strArr2;
        }
        Cursor rawQuery = this.db.rawQuery(createFindByTagsQuery, strArr);
        while (rawQuery.moveToNext()) {
            try {
                hashSet.add(createJobHolderFromCursor(rawQuery));
            } catch (InvalidJobException e2) {
                JqLog.e(e2, "invalid job found by tags.", new Object[0]);
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
        rawQuery.close();
        return hashSet;
    }

    public void onJobCancelled(JobHolder jobHolder) {
        this.pendingCancelations.add(jobHolder.getId());
        setSessionIdOnJob(jobHolder);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0072, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        delete(java.lang.Long.valueOf(r11.getLong(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0086, code lost:
        return nextJobAndIncRunCount(true, (java.util.Collection<java.lang.String>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0087, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0074 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.path.android.jobqueue.JobHolder nextJobAndIncRunCount(boolean r11, java.util.Collection<java.lang.String> r12) {
        /*
            r10 = this;
            com.path.android.jobqueue.persistentQueue.sqlite.QueryCache r0 = r10.nextJobsQueryCache
            java.lang.String r0 = r0.get(r11, r12)
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = r10.createReadyJobWhereSql(r11, r12, r3)
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper r4 = r10.sqlHelper
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r6 = 3
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order[] r6 = new com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order[r6]
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order r7 = new com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Property r8 = com.path.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.PRIORITY_COLUMN
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order$Type r9 = com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order.Type.DESC
            r7.<init>(r8, r9)
            r6[r3] = r7
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order r7 = new com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Property r8 = com.path.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.CREATED_NS_COLUMN
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order$Type r9 = com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order.Type.ASC
            r7.<init>(r8, r9)
            r6[r2] = r7
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order r7 = new com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Property r8 = com.path.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.ID_COLUMN
            com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order$Type r9 = com.path.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order.Type.ASC
            r7.<init>(r8, r9)
            r6[r1] = r7
            java.lang.String r0 = r4.createSelect(r0, r5, r6)
            com.path.android.jobqueue.persistentQueue.sqlite.QueryCache r4 = r10.nextJobsQueryCache
            r4.set(r0, r11, r12)
        L_0x0042:
            android.database.sqlite.SQLiteDatabase r11 = r10.db
            java.lang.String[] r12 = new java.lang.String[r1]
            long r4 = r10.sessionId
            java.lang.String r1 = java.lang.Long.toString(r4)
            r12[r3] = r1
            long r4 = java.lang.System.nanoTime()
            java.lang.String r1 = java.lang.Long.toString(r4)
            r12[r2] = r1
            android.database.Cursor r11 = r11.rawQuery(r0, r12)
            r12 = 0
            boolean r0 = r11.moveToNext()     // Catch:{ InvalidJobException -> 0x0074 }
            if (r0 != 0) goto L_0x0067
            r11.close()
            return r12
        L_0x0067:
            com.path.android.jobqueue.JobHolder r0 = r10.createJobHolderFromCursor(r11)     // Catch:{ InvalidJobException -> 0x0074 }
            r10.setSessionIdOnJob(r0)     // Catch:{ InvalidJobException -> 0x0074 }
            r11.close()
            return r0
        L_0x0072:
            r12 = move-exception
            goto L_0x0087
        L_0x0074:
            long r0 = r11.getLong(r3)     // Catch:{ all -> 0x0072 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0072 }
            r10.delete(r0)     // Catch:{ all -> 0x0072 }
            com.path.android.jobqueue.JobHolder r12 = r10.nextJobAndIncRunCount(r2, r12)     // Catch:{ all -> 0x0072 }
            r11.close()
            return r12
        L_0x0087:
            r11.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.nextJobAndIncRunCount(boolean, java.util.Collection):com.path.android.jobqueue.JobHolder");
    }

    private String createReadyJobWhereSql(boolean z, Collection<String> collection, boolean z2) {
        String str = DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " != ? " + " AND " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + " <= ? ";
        if (!z) {
            str = str + " AND " + DbOpenHelper.REQUIRES_NETWORK_COLUMN.columnName + " != 1 ";
        }
        String str2 = null;
        if (collection != null && collection.size() > 0) {
            str2 = DbOpenHelper.GROUP_ID_COLUMN.columnName + " IS NULL OR " + DbOpenHelper.GROUP_ID_COLUMN.columnName + " NOT IN('" + SqlHelper.joinStrings("','", collection) + "')";
        }
        if (z2) {
            String str3 = str + QueryBuilder.GROUP_BY + DbOpenHelper.GROUP_ID_COLUMN.columnName;
            if (str2 == null) {
                return str3;
            }
            return str3 + QueryBuilder.HAVING + str2;
        } else if (str2 == null) {
            return str;
        } else {
            return str + " AND ( " + str2 + " )";
        }
    }

    public Long getNextJobDelayUntilNs(boolean z, Collection<String> collection) {
        Long valueOf;
        if (!(collection != null && !collection.isEmpty())) {
            SQLiteStatement nextJobDelayedUntilWithNetworkStatement = z ? this.sqlHelper.getNextJobDelayedUntilWithNetworkStatement() : this.sqlHelper.getNextJobDelayedUntilWithoutNetworkStatement();
            synchronized (nextJobDelayedUntilWithNetworkStatement) {
                try {
                    nextJobDelayedUntilWithNetworkStatement.clearBindings();
                    valueOf = Long.valueOf(nextJobDelayedUntilWithNetworkStatement.simpleQueryForLong());
                } catch (SQLiteDoneException unused) {
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return valueOf;
        }
        String str = this.nextJobDelayUntilQueryCache.get(z, collection);
        if (str == null) {
            str = this.sqlHelper.createNextJobDelayUntilQuery(z, collection);
            this.nextJobDelayUntilQueryCache.set(str, z, collection);
        }
        Cursor rawQuery = this.db.rawQuery(str, new String[0]);
        try {
            if (!rawQuery.moveToNext()) {
                return null;
            }
            Long valueOf2 = Long.valueOf(rawQuery.getLong(0));
            rawQuery.close();
            return valueOf2;
        } finally {
            rawQuery.close();
        }
    }

    public void clear() {
        this.sqlHelper.truncate();
        this.readyJobsQueryCache.clear();
        this.nextJobsQueryCache.clear();
    }

    private void setSessionIdOnJob(JobHolder jobHolder) {
        SQLiteStatement onJobFetchedForRunningStatement = this.sqlHelper.getOnJobFetchedForRunningStatement();
        jobHolder.setRunCount(jobHolder.getRunCount() + 1);
        jobHolder.setRunningSessionId(this.sessionId);
        synchronized (onJobFetchedForRunningStatement) {
            onJobFetchedForRunningStatement.clearBindings();
            onJobFetchedForRunningStatement.bindLong(1, (long) jobHolder.getRunCount());
            onJobFetchedForRunningStatement.bindLong(2, this.sessionId);
            onJobFetchedForRunningStatement.bindLong(3, jobHolder.getId().longValue());
            onJobFetchedForRunningStatement.execute();
        }
    }

    private JobHolder createJobHolderFromCursor(Cursor cursor) throws InvalidJobException {
        Job safeDeserialize = safeDeserialize(cursor.getBlob(DbOpenHelper.BASE_JOB_COLUMN.columnIndex));
        if (safeDeserialize != null) {
            return new JobHolder(Long.valueOf(cursor.getLong(DbOpenHelper.ID_COLUMN.columnIndex)), cursor.getInt(DbOpenHelper.PRIORITY_COLUMN.columnIndex), cursor.getString(DbOpenHelper.GROUP_ID_COLUMN.columnIndex), cursor.getInt(DbOpenHelper.RUN_COUNT_COLUMN.columnIndex), safeDeserialize, cursor.getLong(DbOpenHelper.CREATED_NS_COLUMN.columnIndex), cursor.getLong(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnIndex), cursor.getLong(DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnIndex));
        }
        throw new InvalidJobException();
    }

    private Job safeDeserialize(byte[] bArr) {
        try {
            return this.jobSerializer.deserialize(bArr);
        } catch (Throwable th) {
            JqLog.e(th, "error while deserializing job", new Object[0]);
            return null;
        }
    }

    private byte[] getSerializeJob(JobHolder jobHolder) {
        return safeSerialize(jobHolder.getJob());
    }

    private byte[] safeSerialize(Object obj) {
        try {
            return this.jobSerializer.serialize(obj);
        } catch (Throwable th) {
            JqLog.e(th, "error while serializing object %s", obj.getClass().getSimpleName());
            return null;
        }
    }

    private static class InvalidJobException extends Exception {
        private InvalidJobException() {
        }
    }

    public static class JavaSerializer implements JobSerializer {
        /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] serialize(java.lang.Object r3) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                if (r3 != 0) goto L_0x0004
                return r0
            L_0x0004:
                java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x001b }
                r1.<init>()     // Catch:{ all -> 0x001b }
                java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0019 }
                r0.<init>(r1)     // Catch:{ all -> 0x0019 }
                r0.writeObject(r3)     // Catch:{ all -> 0x0019 }
                byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x0019 }
                r1.close()
                return r3
            L_0x0019:
                r3 = move-exception
                goto L_0x001d
            L_0x001b:
                r3 = move-exception
                r1 = r0
            L_0x001d:
                if (r1 == 0) goto L_0x0022
                r1.close()
            L_0x0022:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.JavaSerializer.serialize(java.lang.Object):byte[]");
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T extends com.path.android.jobqueue.Job> T deserialize(byte[] r4) throws java.io.IOException, java.lang.ClassNotFoundException {
            /*
                r3 = this;
                r0 = 0
                if (r4 == 0) goto L_0x0025
                int r1 = r4.length
                if (r1 != 0) goto L_0x0007
                goto L_0x0025
            L_0x0007:
                java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ all -> 0x001e }
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x001e }
                r2.<init>(r4)     // Catch:{ all -> 0x001e }
                r1.<init>(r2)     // Catch:{ all -> 0x001e }
                java.lang.Object r4 = r1.readObject()     // Catch:{ all -> 0x001b }
                com.path.android.jobqueue.Job r4 = (com.path.android.jobqueue.Job) r4     // Catch:{ all -> 0x001b }
                r1.close()
                return r4
            L_0x001b:
                r4 = move-exception
                r0 = r1
                goto L_0x001f
            L_0x001e:
                r4 = move-exception
            L_0x001f:
                if (r0 == 0) goto L_0x0024
                r0.close()
            L_0x0024:
                throw r4
            L_0x0025:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.JavaSerializer.deserialize(byte[]):com.path.android.jobqueue.Job");
        }
    }
}
