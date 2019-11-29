package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger((Class<?>) TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, cls, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, cls, true);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, databaseTableConfig, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, databaseTableConfig, true);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), false);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), false);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        return doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, (BaseDaoImpl) null, databaseTableConfig), z);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            extractTableName = extractTableName.toUpperCase();
        }
        return clearTable(connectionSource, extractTableName);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        return doCreateTable(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doCreateTable(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), z);
    }

    private static <T> int clearTable(ConnectionSource connectionSource, String str) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder sb = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            sb.append("TRUNCATE TABLE ");
        } else {
            sb.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(sb, str);
        String sb2 = sb.toString();
        logger.info("clearing table '{}' with '{}", (Object) str, (Object) sb2);
        CompiledStatement compiledStatement = null;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            compiledStatement = readWriteConnection.compileStatement(sb2, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
            return compiledStatement.runExecute();
        } finally {
            if (compiledStatement != null) {
                compiledStatement.close();
            }
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", (Object) tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        HashSet<String> hashSet = new HashSet<>();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", (Object) str, (Object) tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        FieldType[] fieldTypeArr;
        int i;
        int i2;
        boolean z2;
        DatabaseType databaseType2 = databaseType;
        TableInfo<T, ID> tableInfo2 = tableInfo;
        List<String> list3 = list;
        boolean z3 = z;
        StringBuilder sb = new StringBuilder(256);
        sb.append("CREATE TABLE ");
        if (z3 && databaseType.isCreateIfNotExistsSupported()) {
            sb.append("IF NOT EXISTS ");
        }
        databaseType2.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(" (");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        boolean z4 = true;
        int i3 = 0;
        while (i3 < length) {
            FieldType fieldType = fieldTypes[i3];
            if (fieldType.isForeignCollection()) {
                i2 = i3;
                i = length;
                fieldTypeArr = fieldTypes;
            } else {
                if (z4) {
                    z2 = false;
                } else {
                    sb.append(", ");
                    z2 = z4;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    i2 = i3;
                    i = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    i2 = i3;
                    i = length;
                    fieldTypeArr = fieldTypes;
                    databaseType2.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ');
                    sb.append(columnDefinition);
                    sb.append(' ');
                }
                z4 = z2;
            }
            i3 = i2 + 1;
            TableInfo<T, ID> tableInfo3 = tableInfo;
            length = i;
            fieldTypes = fieldTypeArr;
        }
        DatabaseType databaseType3 = databaseType;
        String str = ", ";
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = arrayList3;
        List<String> list4 = list2;
        databaseType3.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList4, arrayList5, arrayList6, list4);
        databaseType3.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList4, arrayList5, arrayList6, list4);
        for (String append : arrayList) {
            sb.append(str);
            sb.append(append);
        }
        sb.append(") ");
        databaseType2.appendCreateTableSuffix(sb);
        list3.addAll(arrayList2);
        list3.add(sb.toString());
        list3.addAll(arrayList3);
        TableInfo<T, ID> tableInfo4 = tableInfo;
        addCreateIndexStatements(databaseType2, tableInfo4, list3, z3, false);
        addCreateIndexStatements(databaseType2, tableInfo4, list3, z3, true);
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        String str;
        HashMap hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (z2) {
                str = fieldType.getUniqueIndexName();
            } else {
                str = fieldType.getIndexName();
            }
            if (str != null) {
                List list2 = (List) hashMap.get(str);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(str, list2);
                }
                list2.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry entry : hashMap.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), (Object) tableInfo.getTableName());
            sb.append(SQLBuilder.CREATE);
            if (z2) {
                sb.append(SQLBuilder.UNIQUE);
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str2 : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str2);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType dropColumnArg : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(dropColumnArg, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(SQLBuilder.DROP_TABLE);
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", (Object) tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r3 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r4 >= 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r12 == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        throw new java.sql.SQLException("SQL statement " + r2 + " updated " + r4 + " rows, we were expecting >= 0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        if (r4 <= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r13 != false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        throw new java.sql.SQLException("SQL statement updated " + r4 + " rows, we were expecting == 0: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0091, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r3 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        r3.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[SYNTHETIC, Splitter:B:15:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095 A[SYNTHETIC, Splitter:B:27:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int doStatements(com.j256.ormlite.support.DatabaseConnection r8, java.lang.String r9, java.util.Collection<java.lang.String> r10, boolean r11, boolean r12, boolean r13) throws java.sql.SQLException {
        /*
            java.util.Iterator r10 = r10.iterator()
            r0 = 0
            r1 = 0
        L_0x0006:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00b1
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r4 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch:{ SQLException -> 0x0036 }
            com.j256.ormlite.field.FieldType[] r5 = noFieldTypes     // Catch:{ SQLException -> 0x0036 }
            r6 = -1
            com.j256.ormlite.support.CompiledStatement r3 = r8.compileStatement(r2, r4, r5, r6)     // Catch:{ SQLException -> 0x0036 }
            int r4 = r3.runExecute()     // Catch:{ SQLException -> 0x0036 }
            com.j256.ormlite.logger.Logger r5 = logger     // Catch:{ SQLException -> 0x0031 }
            java.lang.String r6 = "executed {} table statement changed {} rows: {}"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLException -> 0x0031 }
            r5.info((java.lang.String) r6, (java.lang.Object) r9, (java.lang.Object) r7, (java.lang.Object) r2)     // Catch:{ SQLException -> 0x0031 }
            if (r3 == 0) goto L_0x0044
        L_0x002d:
            r3.close()
            goto L_0x0044
        L_0x0031:
            r5 = move-exception
            goto L_0x0038
        L_0x0033:
            r8 = move-exception
            goto L_0x00ab
        L_0x0036:
            r5 = move-exception
            r4 = 0
        L_0x0038:
            if (r11 == 0) goto L_0x0095
            com.j256.ormlite.logger.Logger r6 = logger     // Catch:{ all -> 0x0033 }
            java.lang.String r7 = "ignoring {} error '{}' for statement: {}"
            r6.info((java.lang.String) r7, (java.lang.Object) r9, (java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0044
            goto L_0x002d
        L_0x0044:
            if (r4 >= 0) goto L_0x006d
            if (r12 == 0) goto L_0x0049
            goto L_0x0091
        L_0x0049:
            java.sql.SQLException r8 = new java.sql.SQLException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "SQL statement "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = " updated "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = " rows, we were expecting >= 0"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x006d:
            if (r4 <= 0) goto L_0x0091
            if (r13 != 0) goto L_0x0072
            goto L_0x0091
        L_0x0072:
            java.sql.SQLException r8 = new java.sql.SQLException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "SQL statement updated "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = " rows, we were expecting == 0: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0091:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0095:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r8.<init>()     // Catch:{ all -> 0x0033 }
            java.lang.String r9 = "SQL statement failed: "
            r8.append(r9)     // Catch:{ all -> 0x0033 }
            r8.append(r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0033 }
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r8, r5)     // Catch:{ all -> 0x0033 }
            throw r8     // Catch:{ all -> 0x0033 }
        L_0x00ab:
            if (r3 == 0) goto L_0x00b0
            r3.close()
        L_0x00b0:
            throw r8
        L_0x00b1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doStatements(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.util.Collection, boolean, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int doCreateTestQueries(com.j256.ormlite.support.DatabaseConnection r6, com.j256.ormlite.db.DatabaseType r7, java.util.List<java.lang.String> r8) throws java.sql.SQLException {
        /*
            java.util.Iterator r7 = r8.iterator()
            r8 = 0
            r0 = 0
        L_0x0006:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r3 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT     // Catch:{ SQLException -> 0x0049 }
            com.j256.ormlite.field.FieldType[] r4 = noFieldTypes     // Catch:{ SQLException -> 0x0049 }
            r5 = -1
            com.j256.ormlite.support.CompiledStatement r3 = r6.compileStatement(r1, r3, r4, r5)     // Catch:{ SQLException -> 0x0049 }
            com.j256.ormlite.support.DatabaseResults r2 = r3.runQuery(r2)     // Catch:{ SQLException -> 0x0044, all -> 0x0041 }
            boolean r4 = r2.first()     // Catch:{ SQLException -> 0x0044, all -> 0x0041 }
            r5 = 0
        L_0x0025:
            if (r4 == 0) goto L_0x002e
            int r5 = r5 + 1
            boolean r4 = r2.next()     // Catch:{ SQLException -> 0x0044, all -> 0x0041 }
            goto L_0x0025
        L_0x002e:
            com.j256.ormlite.logger.Logger r2 = logger     // Catch:{ SQLException -> 0x0044, all -> 0x0041 }
            java.lang.String r4 = "executing create table after-query got {} results: {}"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLException -> 0x0044, all -> 0x0041 }
            r2.info((java.lang.String) r4, (java.lang.Object) r5, (java.lang.Object) r1)     // Catch:{ SQLException -> 0x0044, all -> 0x0041 }
            if (r3 == 0) goto L_0x003e
            r3.close()
        L_0x003e:
            int r0 = r0 + 1
            goto L_0x0006
        L_0x0041:
            r6 = move-exception
            r2 = r3
            goto L_0x0060
        L_0x0044:
            r6 = move-exception
            r2 = r3
            goto L_0x004a
        L_0x0047:
            r6 = move-exception
            goto L_0x0060
        L_0x0049:
            r6 = move-exception
        L_0x004a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r7.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r8 = "executing create table after-query failed: "
            r7.append(r8)     // Catch:{ all -> 0x0047 }
            r7.append(r1)     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0047 }
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r7, r6)     // Catch:{ all -> 0x0047 }
            throw r6     // Catch:{ all -> 0x0047 }
        L_0x0060:
            if (r2 == 0) goto L_0x0065
            r2.close()
        L_0x0065:
            throw r6
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doCreateTestQueries(com.j256.ormlite.support.DatabaseConnection, com.j256.ormlite.db.DatabaseType, java.util.List):int");
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }
}
