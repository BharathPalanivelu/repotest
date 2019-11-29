package com.path.android.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.TagConstraint;
import com.path.android.jobqueue.log.JqLog;
import java.util.Collection;

public class SqlHelper {
    String FIND_BY_ID_QUERY;
    String FIND_BY_TAG_QUERY;
    final int columnCount;
    private SQLiteStatement countStatement;
    final SQLiteDatabase db;
    private SQLiteStatement deleteStatement;
    private SQLiteStatement insertOrReplaceStatement;
    private SQLiteStatement insertStatement;
    private SQLiteStatement insertTagsStatement;
    private SQLiteStatement nextJobDelayedUntilWithNetworkStatement;
    private SQLiteStatement nextJobDelayedUntilWithoutNetworkStatement;
    private SQLiteStatement onJobFetchedForRunningStatement;
    final String primaryKeyColumnName;
    final long sessionId;
    final String tableName;
    final int tagsColumnCount;
    final String tagsTableName;

    public SqlHelper(SQLiteDatabase sQLiteDatabase, String str, String str2, int i, String str3, int i2, long j) {
        this.db = sQLiteDatabase;
        this.tableName = str;
        this.columnCount = i;
        this.primaryKeyColumnName = str2;
        this.sessionId = j;
        this.tagsColumnCount = i2;
        this.tagsTableName = str3;
        this.FIND_BY_ID_QUERY = SQLBuilder.SELECT_ANY_FROM + str + " WHERE " + DbOpenHelper.ID_COLUMN.columnName + " = ?";
        this.FIND_BY_TAG_QUERY = SQLBuilder.SELECT_ANY_FROM + str + " WHERE " + DbOpenHelper.ID_COLUMN.columnName + " IN ( SELECT " + DbOpenHelper.TAGS_JOB_ID_COLUMN.columnName + " FROM " + str3 + " WHERE " + DbOpenHelper.TAGS_NAME_COLUMN.columnName + " = ?)";
    }

    public static String create(String str, Property property, Property... propertyArr) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(property.columnName);
        sb.append(SQLBuilder.BLANK);
        sb.append(property.type);
        sb.append("  primary key autoincrement ");
        for (Property property2 : propertyArr) {
            sb.append(", `");
            sb.append(property2.columnName);
            sb.append("` ");
            sb.append(property2.type);
        }
        for (Property property3 : propertyArr) {
            if (property3.foreignKey != null) {
                ForeignKey foreignKey = property3.foreignKey;
                sb.append(", FOREIGN KEY(`");
                sb.append(property3.columnName);
                sb.append("`) REFERENCES ");
                sb.append(foreignKey.targetTable);
                sb.append("(`");
                sb.append(foreignKey.targetFieldName);
                sb.append("`) ON DELETE CASCADE");
            }
        }
        sb.append(" );");
        JqLog.d(sb.toString(), new Object[0]);
        return sb.toString();
    }

    public String createFindByTagsQuery(TagConstraint tagConstraint, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String createPlaceholders = createPlaceholders(i2);
        sb.append(SQLBuilder.SELECT_ANY_FROM);
        sb.append(this.tableName);
        sb.append(" WHERE ");
        sb.append(DbOpenHelper.ID_COLUMN.columnName);
        sb.append(" IN ( SELECT ");
        sb.append(DbOpenHelper.TAGS_JOB_ID_COLUMN.columnName);
        sb.append(" FROM ");
        sb.append(this.tagsTableName);
        sb.append(" WHERE ");
        sb.append(DbOpenHelper.TAGS_NAME_COLUMN.columnName);
        sb.append(" IN (");
        sb.append(createPlaceholders);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        if (tagConstraint == TagConstraint.ANY) {
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
        } else if (tagConstraint == TagConstraint.ALL) {
            sb.append(" GROUP BY (`");
            sb.append(DbOpenHelper.TAGS_JOB_ID_COLUMN.columnName);
            sb.append("`)");
            sb.append(" HAVING count(*) = ");
            sb.append(i2);
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
        } else {
            throw new IllegalArgumentException("unknown constraint " + tagConstraint);
        }
        if (i > 0) {
            String createPlaceholders2 = createPlaceholders(i);
            sb.append(" AND ");
            sb.append(DbOpenHelper.ID_COLUMN.columnName);
            sb.append(" NOT IN(");
            sb.append(createPlaceholders2);
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
        }
        return sb.toString();
    }

    public static String drop(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public SQLiteStatement getInsertStatement() {
        if (this.insertStatement == null) {
            StringBuilder sb = new StringBuilder("INSERT INTO ");
            sb.append(this.tableName);
            sb.append(" VALUES (");
            for (int i = 0; i < this.columnCount; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append("?");
            }
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
            this.insertStatement = this.db.compileStatement(sb.toString());
        }
        return this.insertStatement;
    }

    public SQLiteStatement getInsertTagsStatement() {
        if (this.insertTagsStatement == null) {
            StringBuilder sb = new StringBuilder("INSERT INTO ");
            sb.append("job_holder_tags");
            sb.append(" VALUES (");
            for (int i = 0; i < this.tagsColumnCount; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append("?");
            }
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
            this.insertTagsStatement = this.db.compileStatement(sb.toString());
        }
        return this.insertTagsStatement;
    }

    public SQLiteStatement getCountStatement() {
        if (this.countStatement == null) {
            SQLiteDatabase sQLiteDatabase = this.db;
            this.countStatement = sQLiteDatabase.compileStatement(QueryBuilder.SELECT_COUNT + this.tableName + " WHERE " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " != ?");
        }
        return this.countStatement;
    }

    public SQLiteStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement == null) {
            StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
            sb.append(this.tableName);
            sb.append(" VALUES (");
            for (int i = 0; i < this.columnCount; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append("?");
            }
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
            this.insertOrReplaceStatement = this.db.compileStatement(sb.toString());
        }
        return this.insertOrReplaceStatement;
    }

    public SQLiteStatement getDeleteStatement() {
        if (this.deleteStatement == null) {
            SQLiteDatabase sQLiteDatabase = this.db;
            this.deleteStatement = sQLiteDatabase.compileStatement("DELETE FROM " + this.tableName + " WHERE " + this.primaryKeyColumnName + " = ?");
        }
        return this.deleteStatement;
    }

    public SQLiteStatement getOnJobFetchedForRunningStatement() {
        if (this.onJobFetchedForRunningStatement == null) {
            this.onJobFetchedForRunningStatement = this.db.compileStatement(SQLBuilder.UPDATE + this.tableName + SQLBuilder.SET + DbOpenHelper.RUN_COUNT_COLUMN.columnName + " = ? , " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " = ? " + " WHERE " + this.primaryKeyColumnName + " = ? ");
        }
        return this.onJobFetchedForRunningStatement;
    }

    public SQLiteStatement getNextJobDelayedUntilWithNetworkStatement() {
        if (this.nextJobDelayedUntilWithNetworkStatement == null) {
            this.nextJobDelayedUntilWithNetworkStatement = this.db.compileStatement("SELECT " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + " FROM " + this.tableName + " WHERE " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " != " + this.sessionId + " ORDER BY " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + QueryBuilder.ASC + " LIMIT 1");
        }
        return this.nextJobDelayedUntilWithNetworkStatement;
    }

    public SQLiteStatement getNextJobDelayedUntilWithoutNetworkStatement() {
        if (this.nextJobDelayedUntilWithoutNetworkStatement == null) {
            this.nextJobDelayedUntilWithoutNetworkStatement = this.db.compileStatement("SELECT " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + " FROM " + this.tableName + " WHERE " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " != " + this.sessionId + " AND " + DbOpenHelper.REQUIRES_NETWORK_COLUMN.columnName + " != 1" + " ORDER BY " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + QueryBuilder.ASC + " LIMIT 1");
        }
        return this.nextJobDelayedUntilWithoutNetworkStatement;
    }

    public String createNextJobDelayUntilQuery(boolean z, Collection<String> collection) {
        String str = "SELECT " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + " FROM " + this.tableName + " WHERE " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " != " + this.sessionId;
        if (!z) {
            str = str + " AND " + DbOpenHelper.REQUIRES_NETWORK_COLUMN.columnName + " != 1";
        }
        if (collection != null && collection.size() > 0) {
            str = str + " AND (" + DbOpenHelper.GROUP_ID_COLUMN.columnName + " IS NULL OR " + DbOpenHelper.GROUP_ID_COLUMN.columnName + " NOT IN('" + joinStrings("','", collection) + "'))";
        }
        return str + " ORDER BY " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + QueryBuilder.ASC + " LIMIT 1";
    }

    public String createSelect(String str, Integer num, Order... orderArr) {
        StringBuilder sb = new StringBuilder(SQLBuilder.SELECT_ANY_FROM);
        sb.append(this.tableName);
        if (str != null) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        int length = orderArr.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            Order order = orderArr[i];
            if (z) {
                sb.append(" ORDER BY ");
            } else {
                sb.append(",");
            }
            sb.append(order.property.columnName);
            sb.append(SQLBuilder.BLANK);
            sb.append(order.type);
            i++;
            z = false;
        }
        if (num != null) {
            sb.append(" LIMIT ");
            sb.append(num);
        }
        return sb.toString();
    }

    private static String createPlaceholders(int i) {
        if (i != 0) {
            StringBuilder sb = new StringBuilder("?");
            for (int i2 = 1; i2 < i; i2++) {
                sb.append(",?");
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("cannot create placeholders for 0 items");
    }

    public void truncate() {
        this.db.execSQL("DELETE FROM job_holder");
        vacuum();
    }

    public void vacuum() {
        this.db.execSQL("VACUUM");
    }

    public void resetDelayTimesTo(long j) {
        SQLiteDatabase sQLiteDatabase = this.db;
        sQLiteDatabase.execSQL("UPDATE job_holder SET " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + "=?", new Object[]{Long.valueOf(j)});
    }

    public static String joinStrings(String str, Collection<String> collection) {
        StringBuilder sb = new StringBuilder();
        for (String next : collection) {
            if (sb.length() != 0) {
                sb.append(str);
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public static class Property {
        public final int columnIndex;
        final String columnName;
        public final ForeignKey foreignKey;
        final String type;

        public Property(String str, String str2, int i) {
            this(str, str2, i, (ForeignKey) null);
        }

        public Property(String str, String str2, int i, ForeignKey foreignKey2) {
            this.columnName = str;
            this.type = str2;
            this.columnIndex = i;
            this.foreignKey = foreignKey2;
        }
    }

    public static class ForeignKey {
        final String targetFieldName;
        final String targetTable;

        public ForeignKey(String str, String str2) {
            this.targetTable = str;
            this.targetFieldName = str2;
        }
    }

    public static class Order {
        final Property property;
        final Type type;

        public enum Type {
            ASC,
            DESC
        }

        public Order(Property property2, Type type2) {
            this.property = property2;
            this.type = type2;
        }
    }
}
