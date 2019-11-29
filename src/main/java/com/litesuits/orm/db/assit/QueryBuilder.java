package com.litesuits.orm.db.assit;

import com.litesuits.orm.db.TableManager;
import java.util.regex.Pattern;

public class QueryBuilder<T> {
    public static final String AND = " AND ";
    public static final String ASC = " ASC";
    public static final String ASTERISK = "*";
    public static final String COMMA = ",";
    public static final String COMMA_HOLDER = ",?";
    public static final String DESC = " DESC";
    public static final String DISTINCT = " DISTINCT ";
    public static final String EQUAL_HOLDER = "=?";
    public static final String FROM = " FROM ";
    public static final String GROUP_BY = " GROUP BY ";
    public static final String HAVING = " HAVING ";
    public static final String LIMIT = " LIMIT ";
    public static final String OR = " OR ";
    public static final String ORDER_BY = " ORDER BY ";
    public static final String SELECT = "SELECT ";
    public static final String SELECT_COUNT = "SELECT COUNT(*) FROM ";
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    protected Class<T> clazz;
    protected Class clazzMapping;
    protected String[] columns;
    protected boolean distinct;
    protected String group;
    protected String having;
    protected String limit;
    protected String order;
    protected WhereBuilder whereBuilder;

    public Class<T> getQueryClass() {
        return this.clazz;
    }

    public QueryBuilder(Class<T> cls) {
        this.clazz = cls;
        this.whereBuilder = new WhereBuilder(cls);
    }

    public static <T> QueryBuilder<T> create(Class<T> cls) {
        return new QueryBuilder<>(cls);
    }

    public QueryBuilder<T> where(WhereBuilder whereBuilder2) {
        this.whereBuilder = whereBuilder2;
        return this;
    }

    public WhereBuilder getwhereBuilder() {
        return this.whereBuilder;
    }

    public QueryBuilder<T> where(String str, Object... objArr) {
        this.whereBuilder.where(str, objArr);
        return this;
    }

    public QueryBuilder<T> whereAppend(String str, Object... objArr) {
        this.whereBuilder.append((String) null, str, objArr);
        return this;
    }

    public QueryBuilder<T> whereAnd(String str, Object... objArr) {
        this.whereBuilder.and(str, objArr);
        return this;
    }

    public QueryBuilder<T> whereOr(String str, Object... objArr) {
        this.whereBuilder.or(str, objArr);
        return this;
    }

    public QueryBuilder<T> whereAppendAnd() {
        this.whereBuilder.and();
        return this;
    }

    public QueryBuilder<T> whereAppendOr() {
        this.whereBuilder.or();
        return this;
    }

    public QueryBuilder<T> whereAppendNot() {
        this.whereBuilder.not();
        return this;
    }

    public QueryBuilder<T> whereNoEquals(String str, Object obj) {
        this.whereBuilder.noEquals(str, obj);
        return this;
    }

    public QueryBuilder<T> whereGreaterThan(String str, Object obj) {
        this.whereBuilder.greaterThan(str, obj);
        return this;
    }

    public QueryBuilder<T> whereLessThan(String str, Object obj) {
        this.whereBuilder.lessThan(str, obj);
        return this;
    }

    public QueryBuilder<T> whereEquals(String str, Object obj) {
        this.whereBuilder.equals(str, obj);
        return this;
    }

    public QueryBuilder<T> whereIn(String str, Object... objArr) {
        this.whereBuilder.in(str, objArr);
        return this;
    }

    public QueryBuilder<T> columns(String[] strArr) {
        this.columns = strArr;
        return this;
    }

    public QueryBuilder<T> appendColumns(String[] strArr) {
        String[] strArr2 = this.columns;
        if (strArr2 != null) {
            String[] strArr3 = new String[(strArr2.length + strArr.length)];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            System.arraycopy(strArr, 0, strArr3, this.columns.length, strArr.length);
            this.columns = strArr3;
        } else {
            this.columns = strArr;
        }
        return this;
    }

    public QueryBuilder<T> distinct(boolean z) {
        this.distinct = z;
        return this;
    }

    public QueryBuilder<T> groupBy(String str) {
        this.group = str;
        return this;
    }

    public QueryBuilder<T> having(String str) {
        this.having = str;
        return this;
    }

    public QueryBuilder<T> orderBy(String str) {
        this.order = str;
        return this;
    }

    public QueryBuilder<T> appendOrderAscBy(String str) {
        if (this.order == null) {
            this.order = str + ASC;
        } else {
            this.order += ", " + str + ASC;
        }
        return this;
    }

    public QueryBuilder<T> appendOrderDescBy(String str) {
        if (this.order == null) {
            this.order = str + DESC;
        } else {
            this.order += ", " + str + DESC;
        }
        return this;
    }

    public QueryBuilder<T> limit(String str) {
        this.limit = str;
        return this;
    }

    public QueryBuilder<T> limit(int i, int i2) {
        this.limit = i + "," + i2;
        return this;
    }

    public QueryBuilder<T> queryMappingInfo(Class cls) {
        this.clazzMapping = cls;
        return this;
    }

    public SQLStatement createStatement() {
        if (this.clazz == null) {
            throw new IllegalArgumentException("U Must Set A Query Entity Class By queryWho(Class) or QueryBuilder(Class)");
        } else if (Checker.isEmpty((CharSequence) this.group) && !Checker.isEmpty((CharSequence) this.having)) {
            throw new IllegalArgumentException("HAVING仅允许在有GroupBy的时候使用(HAVING clauses are only permitted when using a groupBy clause)");
        } else if (Checker.isEmpty((CharSequence) this.limit) || limitPattern.matcher(this.limit).matches()) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.distinct) {
                sb.append(DISTINCT);
            }
            if (!Checker.isEmpty((Object[]) this.columns)) {
                appendColumns(sb, this.columns);
            } else {
                sb.append("*");
            }
            sb.append(" FROM ");
            sb.append(getTableName());
            sb.append(this.whereBuilder.createWhereString());
            appendClause(sb, GROUP_BY, this.group);
            appendClause(sb, HAVING, this.having);
            appendClause(sb, " ORDER BY ", this.order);
            appendClause(sb, " LIMIT ", this.limit);
            SQLStatement sQLStatement = new SQLStatement();
            sQLStatement.sql = sb.toString();
            sQLStatement.bindArgs = this.whereBuilder.transToStringArray();
            return sQLStatement;
        } else {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + this.limit);
        }
    }

    public SQLStatement createStatementForCount() {
        StringBuilder sb = new StringBuilder(120);
        sb.append(SELECT_COUNT);
        sb.append(getTableName());
        SQLStatement sQLStatement = new SQLStatement();
        WhereBuilder whereBuilder2 = this.whereBuilder;
        if (whereBuilder2 != null) {
            sb.append(whereBuilder2.createWhereString());
            sQLStatement.bindArgs = this.whereBuilder.transToStringArray();
        }
        sQLStatement.sql = sb.toString();
        return sQLStatement;
    }

    public String getTableName() {
        Class cls = this.clazzMapping;
        if (cls == null) {
            return TableManager.getTableName(this.clazz);
        }
        return TableManager.getMapTableName((Class) this.clazz, cls);
    }

    private static void appendClause(StringBuilder sb, String str, String str2) {
        if (!Checker.isEmpty((CharSequence) str2)) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private static void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        sb.append(SQLBuilder.BLANK);
    }

    private String buildWhereIn(String str, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" IN (?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb.toString();
    }
}
