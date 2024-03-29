package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public TransactionManager(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
        initialize();
    }

    public void initialize() {
        if (this.connectionSource == null) {
            throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return callInTransaction(this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource2, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource2.getReadWriteConnection();
        try {
            return callInTransaction(readWriteConnection, connectionSource2.saveSpecialConnection(readWriteConnection), connectionSource2.getDatabaseType(), callable);
        } finally {
            connectionSource2.clearSpecialConnection(readWriteConnection);
            connectionSource2.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:31|32|33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:39|40|41|42) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[Catch:{ SQLException -> 0x0086, Exception -> 0x0073, all -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x007a=Splitter:B:33:0x007a, B:41:0x008d=Splitter:B:41:0x008d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r6, boolean r7, com.j256.ormlite.db.DatabaseType r8, java.util.concurrent.Callable<T> r9) throws java.sql.SQLException {
        /*
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            r1 = 0
            java.lang.String r2 = "restored auto-commit to true"
            r3 = 1
            r4 = 0
            if (r7 != 0) goto L_0x0012
            boolean r7 = r8.isNestedSavePointsSupported()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r7 = 0
            goto L_0x005b
        L_0x0012:
            boolean r7 = r6.isAutoCommitSupported()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0029
            boolean r7 = r6.isAutoCommit()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0028
            r6.setAutoCommit(r4)     // Catch:{ all -> 0x006f }
            com.j256.ormlite.logger.Logger r8 = logger     // Catch:{ all -> 0x006f }
            java.lang.String r1 = "had to set auto-commit to false"
            r8.debug(r1)     // Catch:{ all -> 0x006f }
        L_0x0028:
            r4 = r7
        L_0x0029:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r7.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = "ORMLITE"
            r7.append(r8)     // Catch:{ all -> 0x0093 }
            java.util.concurrent.atomic.AtomicInteger r8 = savePointCounter     // Catch:{ all -> 0x0093 }
            int r8 = r8.incrementAndGet()     // Catch:{ all -> 0x0093 }
            r7.append(r8)     // Catch:{ all -> 0x0093 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0093 }
            java.sql.Savepoint r1 = r6.setSavePoint(r7)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x004e
            com.j256.ormlite.logger.Logger r7 = logger     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = "started savePoint transaction"
            r7.debug(r8)     // Catch:{ all -> 0x0093 }
            goto L_0x0059
        L_0x004e:
            com.j256.ormlite.logger.Logger r7 = logger     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = "started savePoint transaction {}"
            java.lang.String r5 = r1.getSavepointName()     // Catch:{ all -> 0x0093 }
            r7.debug((java.lang.String) r8, (java.lang.Object) r5)     // Catch:{ all -> 0x0093 }
        L_0x0059:
            r7 = r4
            r4 = 1
        L_0x005b:
            java.lang.Object r8 = r9.call()     // Catch:{ SQLException -> 0x0086, Exception -> 0x0073 }
            if (r4 == 0) goto L_0x0064
            commit(r6, r1)     // Catch:{ SQLException -> 0x0086, Exception -> 0x0073 }
        L_0x0064:
            if (r7 == 0) goto L_0x006e
            r6.setAutoCommit(r3)
            com.j256.ormlite.logger.Logger r6 = logger
            r6.debug(r2)
        L_0x006e:
            return r8
        L_0x006f:
            r8 = move-exception
            r4 = r7
            r7 = r8
            goto L_0x0094
        L_0x0073:
            r8 = move-exception
            if (r4 == 0) goto L_0x007f
            rollBack(r6, r1)     // Catch:{ SQLException -> 0x007a }
            goto L_0x007f
        L_0x007a:
            com.j256.ormlite.logger.Logger r9 = logger     // Catch:{ all -> 0x006f }
            r9.error((java.lang.Throwable) r8, (java.lang.String) r0)     // Catch:{ all -> 0x006f }
        L_0x007f:
            java.lang.String r9 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r9, r8)     // Catch:{ all -> 0x006f }
            throw r8     // Catch:{ all -> 0x006f }
        L_0x0086:
            r8 = move-exception
            if (r4 == 0) goto L_0x0092
            rollBack(r6, r1)     // Catch:{ SQLException -> 0x008d }
            goto L_0x0092
        L_0x008d:
            com.j256.ormlite.logger.Logger r9 = logger     // Catch:{ all -> 0x006f }
            r9.error((java.lang.Throwable) r8, (java.lang.String) r0)     // Catch:{ all -> 0x006f }
        L_0x0092:
            throw r8     // Catch:{ all -> 0x006f }
        L_0x0093:
            r7 = move-exception
        L_0x0094:
            if (r4 == 0) goto L_0x009e
            r6.setAutoCommit(r3)
            com.j256.ormlite.logger.Logger r6 = logger
            r6.debug(r2)
        L_0x009e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }

    public void setConnectionSource(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", (Object) savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", (Object) savepointName);
        }
    }
}
