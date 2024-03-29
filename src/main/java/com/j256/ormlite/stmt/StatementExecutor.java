package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import com.litesuits.orm.db.assit.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
    private static Logger logger = LoggerFactory.getLogger((Class<?>) StatementExecutor.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];
    private String countStarQuery;
    private final Dao<T, ID> dao;
    private final DatabaseType databaseType;
    private FieldType[] ifExistsFieldTypes;
    private String ifExistsQuery;
    private MappedDelete<T, ID> mappedDelete;
    private MappedCreate<T, ID> mappedInsert;
    private MappedQueryForId<T, ID> mappedQueryForId;
    private MappedRefresh<T, ID> mappedRefresh;
    private MappedUpdate<T, ID> mappedUpdate;
    private MappedUpdateId<T, ID> mappedUpdateId;
    private PreparedQuery<T> preparedQueryForAll;
    private RawRowMapper<T> rawRowMapper;
    private final TableInfo<T, ID> tableInfo;

    public StatementExecutor(DatabaseType databaseType2, TableInfo<T, ID> tableInfo2, Dao<T, ID> dao2) {
        this.databaseType = databaseType2;
        this.tableInfo = tableInfo2;
        this.dao = dao2;
    }

    public T queryForId(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedQueryForId == null) {
            this.mappedQueryForId = MappedQueryForId.build(this.databaseType, this.tableInfo, (FieldType) null);
        }
        return this.mappedQueryForId.execute(databaseConnection, id, objectCache);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T queryForFirst(com.j256.ormlite.support.DatabaseConnection r4, com.j256.ormlite.stmt.PreparedStmt<T> r5, com.j256.ormlite.dao.ObjectCache r6) throws java.sql.SQLException {
        /*
            r3 = this;
            com.j256.ormlite.stmt.StatementBuilder$StatementType r0 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT
            com.j256.ormlite.support.CompiledStatement r4 = r5.compile(r4, r0)
            r0 = 0
            com.j256.ormlite.support.DatabaseResults r6 = r4.runQuery(r6)     // Catch:{ all -> 0x003f }
            boolean r1 = r6.first()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0029
            com.j256.ormlite.logger.Logger r0 = logger     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "query-for-first of '{}' returned at least 1 result"
            java.lang.String r2 = r5.getStatement()     // Catch:{ all -> 0x003d }
            r0.debug((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x003d }
            java.lang.Object r5 = r5.mapRow(r6)     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0025
            r6.close()
        L_0x0025:
            r4.close()
            return r5
        L_0x0029:
            com.j256.ormlite.logger.Logger r1 = logger     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "query-for-first of '{}' returned at 0 results"
            java.lang.String r5 = r5.getStatement()     // Catch:{ all -> 0x003d }
            r1.debug((java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0039
            r6.close()
        L_0x0039:
            r4.close()
            return r0
        L_0x003d:
            r5 = move-exception
            goto L_0x0041
        L_0x003f:
            r5 = move-exception
            r6 = r0
        L_0x0041:
            if (r6 == 0) goto L_0x0046
            r6.close()
        L_0x0046:
            r4.close()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.queryForFirst(com.j256.ormlite.support.DatabaseConnection, com.j256.ormlite.stmt.PreparedStmt, com.j256.ormlite.dao.ObjectCache):java.lang.Object");
    }

    public List<T> queryForAll(ConnectionSource connectionSource, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return query(connectionSource, this.preparedQueryForAll, objectCache);
    }

    public long queryForCountStar(DatabaseConnection databaseConnection) throws SQLException {
        if (this.countStarQuery == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(QueryBuilder.SELECT_COUNT);
            this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
            this.countStarQuery = sb.toString();
        }
        long queryForLong = databaseConnection.queryForLong(this.countStarQuery);
        logger.debug("query of '{}' returned {}", (Object) this.countStarQuery, (Object) Long.valueOf(queryForLong));
        return queryForLong;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.j256.ormlite.dao.ObjectCache] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.j256.ormlite.support.DatabaseResults] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long queryForLong(com.j256.ormlite.support.DatabaseConnection r5, com.j256.ormlite.stmt.PreparedStmt<T> r6) throws java.sql.SQLException {
        /*
            r4 = this;
            com.j256.ormlite.stmt.StatementBuilder$StatementType r0 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT_LONG
            com.j256.ormlite.support.CompiledStatement r5 = r6.compile(r5, r0)
            r0 = 0
            com.j256.ormlite.support.DatabaseResults r0 = r5.runQuery(r0)     // Catch:{ all -> 0x003a }
            boolean r1 = r0.first()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x001f
            r6 = 0
            long r1 = r0.getLong(r6)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            r5.close()
            return r1
        L_0x001f:
            java.sql.SQLException r1 = new java.sql.SQLException     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "No result found in queryForLong: "
            r2.append(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r6 = r6.getStatement()     // Catch:{ all -> 0x003a }
            r2.append(r6)     // Catch:{ all -> 0x003a }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x003a }
            r1.<init>(r6)     // Catch:{ all -> 0x003a }
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003a:
            r6 = move-exception
            if (r0 == 0) goto L_0x0040
            r0.close()
        L_0x0040:
            r5.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.queryForLong(com.j256.ormlite.support.DatabaseConnection, com.j256.ormlite.stmt.PreparedStmt):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long queryForLong(com.j256.ormlite.support.DatabaseConnection r5, java.lang.String r6, java.lang.String[] r7) throws java.sql.SQLException {
        /*
            r4 = this;
            com.j256.ormlite.logger.Logger r0 = logger
            java.lang.String r1 = "executing raw query for long: {}"
            r0.debug((java.lang.String) r1, (java.lang.Object) r6)
            int r0 = r7.length
            if (r0 <= 0) goto L_0x0011
            com.j256.ormlite.logger.Logger r0 = logger
            java.lang.String r1 = "query arguments: {}"
            r0.trace((java.lang.String) r1, (java.lang.Object) r7)
        L_0x0011:
            r0 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r1 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT     // Catch:{ all -> 0x0051 }
            com.j256.ormlite.field.FieldType[] r2 = noFieldTypes     // Catch:{ all -> 0x0051 }
            r3 = -1
            com.j256.ormlite.support.CompiledStatement r5 = r5.compileStatement(r6, r1, r2, r3)     // Catch:{ all -> 0x0051 }
            r4.assignStatementArguments(r5, r7)     // Catch:{ all -> 0x004f }
            com.j256.ormlite.support.DatabaseResults r0 = r5.runQuery(r0)     // Catch:{ all -> 0x004f }
            boolean r7 = r0.first()     // Catch:{ all -> 0x004f }
            if (r7 == 0) goto L_0x0038
            r6 = 0
            long r6 = r0.getLong(r6)     // Catch:{ all -> 0x004f }
            if (r0 == 0) goto L_0x0032
            r0.close()
        L_0x0032:
            if (r5 == 0) goto L_0x0037
            r5.close()
        L_0x0037:
            return r6
        L_0x0038:
            java.sql.SQLException r7 = new java.sql.SQLException     // Catch:{ all -> 0x004f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "No result found in queryForLong: "
            r1.append(r2)     // Catch:{ all -> 0x004f }
            r1.append(r6)     // Catch:{ all -> 0x004f }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x004f }
            r7.<init>(r6)     // Catch:{ all -> 0x004f }
            throw r7     // Catch:{ all -> 0x004f }
        L_0x004f:
            r6 = move-exception
            goto L_0x0053
        L_0x0051:
            r6 = move-exception
            r5 = r0
        L_0x0053:
            if (r0 == 0) goto L_0x0058
            r0.close()
        L_0x0058:
            if (r5 == 0) goto L_0x005d
            r5.close()
        L_0x005d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.queryForLong(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.lang.String[]):long");
    }

    public List<T> query(ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws SQLException {
        SelectIterator<T, ID> buildIterator = buildIterator((BaseDaoImpl) null, connectionSource, preparedStmt, objectCache, -1);
        try {
            ArrayList arrayList = new ArrayList();
            while (buildIterator.hasNextThrow()) {
                arrayList.add(buildIterator.nextThrow());
            }
            logger.debug("query of '{}' returned {} results", (Object) preparedStmt.getStatement(), (Object) Integer.valueOf(arrayList.size()));
            return arrayList;
        } finally {
            buildIterator.close();
        }
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, int i, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return buildIterator(baseDaoImpl, connectionSource, this.preparedQueryForAll, objectCache, i);
    }

    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        prepareQueryForAll();
        return this.preparedQueryForAll;
    }

    public RawRowMapper<T> getRawRowMapper() {
        if (this.rawRowMapper == null) {
            this.rawRowMapper = new RawRowMapperImpl(this.tableInfo);
        }
        return this.rawRowMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.j256.ormlite.stmt.SelectIterator<T, ID> buildIterator(com.j256.ormlite.dao.BaseDaoImpl<T, ID> r14, com.j256.ormlite.support.ConnectionSource r15, com.j256.ormlite.stmt.PreparedStmt<T> r16, com.j256.ormlite.dao.ObjectCache r17, int r18) throws java.sql.SQLException {
        /*
            r13 = this;
            com.j256.ormlite.support.DatabaseConnection r10 = r15.getReadOnlyConnection()
            r1 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r0 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT     // Catch:{ all -> 0x002e }
            r4 = r16
            r2 = r18
            com.j256.ormlite.support.CompiledStatement r11 = r4.compile(r10, r0, r2)     // Catch:{ all -> 0x002e }
            com.j256.ormlite.stmt.SelectIterator r0 = new com.j256.ormlite.stmt.SelectIterator     // Catch:{ all -> 0x002b }
            r12 = r13
            com.j256.ormlite.table.TableInfo<T, ID> r1 = r12.tableInfo     // Catch:{ all -> 0x0029 }
            java.lang.Class r2 = r1.getDataClass()     // Catch:{ all -> 0x0029 }
            java.lang.String r8 = r16.getStatement()     // Catch:{ all -> 0x0029 }
            r1 = r0
            r3 = r14
            r4 = r16
            r5 = r15
            r6 = r10
            r7 = r11
            r9 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0029 }
            return r0
        L_0x0029:
            r0 = move-exception
            goto L_0x0031
        L_0x002b:
            r0 = move-exception
            r12 = r13
            goto L_0x0031
        L_0x002e:
            r0 = move-exception
            r12 = r13
            r11 = r1
        L_0x0031:
            if (r11 == 0) goto L_0x0036
            r11.close()
        L_0x0036:
            if (r10 == 0) goto L_0x003c
            r1 = r15
            r15.releaseConnection(r10)
        L_0x003c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.buildIterator(com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.support.ConnectionSource, com.j256.ormlite.stmt.PreparedStmt, com.j256.ormlite.dao.ObjectCache, int):com.j256.ormlite.stmt.SelectIterator");
    }

    public GenericRawResults<String[]> queryRaw(ConnectionSource connectionSource, String str, String[] strArr, ObjectCache objectCache) throws SQLException {
        logger.debug("executing raw query for: {}", (Object) str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatement = null;
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            assignStatementArguments(compiledStatement, strArr);
            return new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, this, objectCache);
        } catch (Throwable th) {
            if (compiledStatement != null) {
                compiledStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, RawRowMapper<UO> rawRowMapper2, String[] strArr, ObjectCache objectCache) throws SQLException {
        logger.debug("executing raw query for: {}", (Object) str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatement = null;
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            assignStatementArguments(compiledStatement, strArr);
            return new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, new UserRawRowMapper(rawRowMapper2, this), objectCache);
        } catch (Throwable th) {
            if (compiledStatement != null) {
                compiledStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <UO> com.j256.ormlite.dao.GenericRawResults<UO> queryRaw(com.j256.ormlite.support.ConnectionSource r14, java.lang.String r15, com.j256.ormlite.field.DataType[] r16, com.j256.ormlite.dao.RawRowObjectMapper<UO> r17, java.lang.String[] r18, com.j256.ormlite.dao.ObjectCache r19) throws java.sql.SQLException {
        /*
            r13 = this;
            r0 = r15
            r1 = r18
            com.j256.ormlite.logger.Logger r2 = logger
            java.lang.String r3 = "executing raw query for: {}"
            r2.debug((java.lang.String) r3, (java.lang.Object) r15)
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0014
            com.j256.ormlite.logger.Logger r2 = logger
            java.lang.String r3 = "query arguments: {}"
            r2.trace((java.lang.String) r3, (java.lang.Object) r1)
        L_0x0014:
            com.j256.ormlite.support.DatabaseConnection r9 = r14.getReadOnlyConnection()
            r2 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r3 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT     // Catch:{ all -> 0x0040 }
            com.j256.ormlite.field.FieldType[] r4 = noFieldTypes     // Catch:{ all -> 0x0040 }
            r5 = -1
            com.j256.ormlite.support.CompiledStatement r10 = r9.compileStatement(r15, r3, r4, r5)     // Catch:{ all -> 0x0040 }
            r11 = r13
            r13.assignStatementArguments(r10, r1)     // Catch:{ all -> 0x003e }
            com.j256.ormlite.stmt.RawResultsImpl r12 = new com.j256.ormlite.stmt.RawResultsImpl     // Catch:{ all -> 0x003e }
            java.lang.Class<java.lang.String[]> r5 = java.lang.String[].class
            com.j256.ormlite.stmt.StatementExecutor$UserRawRowObjectMapper r7 = new com.j256.ormlite.stmt.StatementExecutor$UserRawRowObjectMapper     // Catch:{ all -> 0x003e }
            r1 = r16
            r2 = r17
            r7.<init>(r2, r1)     // Catch:{ all -> 0x003e }
            r1 = r12
            r2 = r14
            r3 = r9
            r4 = r15
            r6 = r10
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x003e }
            return r12
        L_0x003e:
            r0 = move-exception
            goto L_0x0043
        L_0x0040:
            r0 = move-exception
            r11 = r13
            r10 = r2
        L_0x0043:
            if (r10 == 0) goto L_0x0048
            r10.close()
        L_0x0048:
            if (r9 == 0) goto L_0x004e
            r1 = r14
            r14.releaseConnection(r9)
        L_0x004e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.queryRaw(com.j256.ormlite.support.ConnectionSource, java.lang.String, com.j256.ormlite.field.DataType[], com.j256.ormlite.dao.RawRowObjectMapper, java.lang.String[], com.j256.ormlite.dao.ObjectCache):com.j256.ormlite.dao.GenericRawResults");
    }

    public GenericRawResults<Object[]> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, String[] strArr, ObjectCache objectCache) throws SQLException {
        logger.debug("executing raw query for: {}", (Object) str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection();
        CompiledStatement compiledStatement = null;
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
            assignStatementArguments(compiledStatement, strArr);
            return new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compiledStatement, new ObjectArrayRowMapper(dataTypeArr), objectCache);
        } catch (Throwable th) {
            if (compiledStatement != null) {
                compiledStatement.close();
            }
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public int updateRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw update statement: {}", (Object) str);
        if (strArr.length > 0) {
            logger.trace("update arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runUpdate();
        } finally {
            compileStatement.close();
        }
    }

    public int executeRawNoArgs(DatabaseConnection databaseConnection, String str) throws SQLException {
        logger.debug("running raw execute statement: {}", (Object) str);
        return databaseConnection.executeStatement(str, -1);
    }

    public int executeRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw execute statement: {}", (Object) str);
        if (strArr.length > 0) {
            logger.trace("execute arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runExecute();
        } finally {
            compileStatement.close();
        }
    }

    public int create(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedInsert == null) {
            this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo);
        }
        return this.mappedInsert.insert(this.databaseType, databaseConnection, t, objectCache);
    }

    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdate == null) {
            this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo);
        }
        return this.mappedUpdate.update(databaseConnection, t, objectCache);
    }

    public int updateId(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdateId == null) {
            this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo);
        }
        return this.mappedUpdateId.execute(databaseConnection, t, id, objectCache);
    }

    public int update(DatabaseConnection databaseConnection, PreparedUpdate<T> preparedUpdate) throws SQLException {
        CompiledStatement compile = preparedUpdate.compile(databaseConnection, StatementBuilder.StatementType.UPDATE);
        try {
            return compile.runUpdate();
        } finally {
            compile.close();
        }
    }

    public int refresh(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedRefresh == null) {
            this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo);
        }
        return this.mappedRefresh.executeRefresh(databaseConnection, t, objectCache);
    }

    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        return this.mappedDelete.delete(databaseConnection, t, objectCache);
    }

    public int deleteById(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        return this.mappedDelete.deleteById(databaseConnection, id, objectCache);
    }

    public int deleteObjects(DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        return MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
    }

    public int deleteIds(DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        return MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
    }

    public int delete(DatabaseConnection databaseConnection, PreparedDelete<T> preparedDelete) throws SQLException {
        CompiledStatement compile = preparedDelete.compile(databaseConnection, StatementBuilder.StatementType.DELETE);
        try {
            return compile.runUpdate();
        } finally {
            compile.close();
        }
    }

    public <CT> CT callBatchTasks(DatabaseConnection databaseConnection, boolean z, Callable<CT> callable) throws SQLException {
        if (this.databaseType.isBatchUseTransaction()) {
            return TransactionManager.callInTransaction(databaseConnection, z, this.databaseType, callable);
        }
        boolean z2 = false;
        try {
            if (databaseConnection.isAutoCommitSupported()) {
                boolean isAutoCommit = databaseConnection.isAutoCommit();
                if (isAutoCommit) {
                    try {
                        databaseConnection.setAutoCommit(false);
                        logger.debug("disabled auto-commit on table {} before batch tasks", (Object) this.tableInfo.getTableName());
                    } catch (Throwable th) {
                        th = th;
                        z2 = isAutoCommit;
                    }
                }
                z2 = isAutoCommit;
            }
            CT call = callable.call();
            if (z2) {
                databaseConnection.setAutoCommit(true);
                logger.debug("re-enabled auto-commit on table {} after batch tasks", (Object) this.tableInfo.getTableName());
            }
            return call;
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
            throw SqlExceptionUtil.create("Batch tasks callable threw non-SQL exception", e3);
        } catch (Throwable th2) {
            th = th2;
            if (z2) {
                databaseConnection.setAutoCommit(true);
                logger.debug("re-enabled auto-commit on table {} after batch tasks", (Object) this.tableInfo.getTableName());
            }
            throw th;
        }
    }

    public String[] mapRow(DatabaseResults databaseResults) throws SQLException {
        int columnCount = databaseResults.getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            strArr[i] = databaseResults.getString(i);
        }
        return strArr;
    }

    public boolean ifExists(DatabaseConnection databaseConnection, ID id) throws SQLException {
        if (this.ifExistsQuery == null) {
            QueryBuilder queryBuilder = new QueryBuilder(this.databaseType, this.tableInfo, this.dao);
            queryBuilder.selectRaw("COUNT(*)");
            queryBuilder.where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
            this.ifExistsQuery = queryBuilder.prepareStatementString();
            this.ifExistsFieldTypes = new FieldType[]{this.tableInfo.getIdField()};
        }
        long queryForLong = databaseConnection.queryForLong(this.ifExistsQuery, new Object[]{id}, this.ifExistsFieldTypes);
        logger.debug("query of '{}' returned {}", (Object) this.ifExistsQuery, (Object) Long.valueOf(queryForLong));
        if (queryForLong != 0) {
            return true;
        }
        return false;
    }

    private void assignStatementArguments(CompiledStatement compiledStatement, String[] strArr) throws SQLException {
        for (int i = 0; i < strArr.length; i++) {
            compiledStatement.setObject(i, strArr[i], SqlType.STRING);
        }
    }

    private void prepareQueryForAll() throws SQLException {
        if (this.preparedQueryForAll == null) {
            this.preparedQueryForAll = new QueryBuilder(this.databaseType, this.tableInfo, this.dao).prepare();
        }
    }

    private static class UserRawRowMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final RawRowMapper<UO> mapper;
        private final GenericRowMapper<String[]> stringRowMapper;

        public UserRawRowMapper(RawRowMapper<UO> rawRowMapper, GenericRowMapper<String[]> genericRowMapper) {
            this.mapper = rawRowMapper;
            this.stringRowMapper = genericRowMapper;
        }

        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            return this.mapper.mapRow(getColumnNames(databaseResults), this.stringRowMapper.mapRow(databaseResults));
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            this.columnNames = databaseResults.getColumnNames();
            return this.columnNames;
        }
    }

    private static class UserRawRowObjectMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final DataType[] columnTypes;
        private final RawRowObjectMapper<UO> mapper;

        public UserRawRowObjectMapper(RawRowObjectMapper<UO> rawRowObjectMapper, DataType[] dataTypeArr) {
            this.mapper = rawRowObjectMapper;
            this.columnTypes = dataTypeArr;
        }

        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    objArr[i] = null;
                } else {
                    objArr[i] = dataTypeArr[i].getDataPersister().resultToJava((FieldType) null, databaseResults, i);
                }
            }
            return this.mapper.mapRow(getColumnNames(databaseResults), this.columnTypes, objArr);
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            this.columnNames = databaseResults.getColumnNames();
            return this.columnNames;
        }
    }

    private static class ObjectArrayRowMapper implements GenericRowMapper<Object[]> {
        private final DataType[] columnTypes;

        public ObjectArrayRowMapper(DataType[] dataTypeArr) {
            this.columnTypes = dataTypeArr;
        }

        public Object[] mapRow(DatabaseResults databaseResults) throws SQLException {
            DataType dataType;
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    dataType = DataType.STRING;
                } else {
                    dataType = dataTypeArr[i];
                }
                objArr[i] = dataType.getDataPersister().resultToJava((FieldType) null, databaseResults, i);
            }
            return objArr;
        }
    }
}
