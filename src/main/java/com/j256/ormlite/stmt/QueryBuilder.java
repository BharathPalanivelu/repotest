package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
    private boolean distinct;
    private List<String> groupByList;
    private String groupByRaw;
    private String having;
    private final FieldType idField;
    private boolean isCountOfQuery;
    private boolean isInnerQuery;
    private List<QueryBuilder<T, ID>.JoinInfo> joinList;
    private Long limit;
    private Long offset;
    private ArgumentHolder[] orderByArgs;
    private List<OrderBy> orderByList;
    private String orderByRaw;
    private FieldType[] resultFieldTypes;
    private List<String> selectColumnList;
    private boolean selectIdColumn = true;
    private List<String> selectRawList;

    public QueryBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.SELECT);
        this.idField = tableInfo.getIdField();
    }

    /* access modifiers changed from: package-private */
    public void enableInnerQuery() {
        this.isInnerQuery = true;
    }

    /* access modifiers changed from: package-private */
    public int getSelectColumnCount() {
        if (this.isCountOfQuery) {
            return 1;
        }
        List<String> list = this.selectRawList;
        if (list != null && !list.isEmpty()) {
            return this.selectRawList.size();
        }
        List<String> list2 = this.selectColumnList;
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    /* access modifiers changed from: package-private */
    public List<String> getSelectColumns() {
        if (this.isCountOfQuery) {
            return Collections.singletonList("COUNT(*)");
        }
        List<String> list = this.selectRawList;
        if (list != null && !list.isEmpty()) {
            return this.selectRawList;
        }
        List<String> list2 = this.selectColumnList;
        return list2 == null ? Collections.emptyList() : list2;
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return super.prepareStatement(this.limit);
    }

    public QueryBuilder<T, ID> selectColumns(String... strArr) {
        if (this.selectColumnList == null) {
            this.selectColumnList = new ArrayList();
        }
        for (String addSelectColumnToList : strArr) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectColumns(Iterable<String> iterable) {
        if (this.selectColumnList == null) {
            this.selectColumnList = new ArrayList();
        }
        for (String addSelectColumnToList : iterable) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectRaw(String... strArr) {
        if (this.selectRawList == null) {
            this.selectRawList = new ArrayList();
        }
        for (String add : strArr) {
            this.selectRawList.add(add);
        }
        return this;
    }

    public QueryBuilder<T, ID> groupBy(String str) {
        if (!verifyColumnName(str).isForeignCollection()) {
            if (this.groupByList == null) {
                this.groupByList = new ArrayList();
            }
            this.groupByList.add(str);
            this.selectIdColumn = false;
            return this;
        }
        throw new IllegalArgumentException("Can't groupBy foreign colletion field: " + str);
    }

    public QueryBuilder<T, ID> groupByRaw(String str) {
        this.groupByRaw = str;
        return this;
    }

    public QueryBuilder<T, ID> orderBy(String str, boolean z) {
        if (!verifyColumnName(str).isForeignCollection()) {
            if (this.orderByList == null) {
                this.orderByList = new ArrayList();
            }
            this.orderByList.add(new OrderBy(str, z));
            return this;
        }
        throw new IllegalArgumentException("Can't orderBy foreign colletion field: " + str);
    }

    public QueryBuilder<T, ID> orderByRaw(String str) {
        return orderByRaw(str, (ArgumentHolder[]) null);
    }

    public QueryBuilder<T, ID> orderByRaw(String str, ArgumentHolder... argumentHolderArr) {
        this.orderByRaw = str;
        this.orderByArgs = argumentHolderArr;
        return this;
    }

    public QueryBuilder<T, ID> distinct() {
        this.distinct = true;
        this.selectIdColumn = false;
        return this;
    }

    @Deprecated
    public QueryBuilder<T, ID> limit(int i) {
        return limit(Long.valueOf((long) i));
    }

    public QueryBuilder<T, ID> limit(Long l) {
        this.limit = l;
        return this;
    }

    @Deprecated
    public QueryBuilder<T, ID> offset(int i) throws SQLException {
        return offset(Long.valueOf((long) i));
    }

    public QueryBuilder<T, ID> offset(Long l) throws SQLException {
        if (this.databaseType.isOffsetSqlSupported()) {
            this.offset = l;
            return this;
        }
        throw new SQLException("Offset is not supported by this database");
    }

    public QueryBuilder<T, ID> setCountOf(boolean z) {
        this.isCountOfQuery = z;
        return this;
    }

    public QueryBuilder<T, ID> having(String str) {
        this.having = str;
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo("INNER", queryBuilder, StatementBuilder.WhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> joinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo("INNER", queryBuilder, StatementBuilder.WhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo("LEFT", queryBuilder, StatementBuilder.WhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> leftJoinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo("LEFT", queryBuilder, StatementBuilder.WhereOperation.OR);
        return this;
    }

    public List<T> query() throws SQLException {
        return this.dao.query(prepare());
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]);
    }

    public T queryForFirst() throws SQLException {
        return this.dao.queryForFirst(prepare());
    }

    public String[] queryRawFirst() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return this.dao.iterator(prepare());
    }

    public long countOf() throws SQLException {
        setCountOf(true);
        return this.dao.countOf(prepare());
    }

    @Deprecated
    public void clear() {
        reset();
    }

    public void reset() {
        super.reset();
        this.distinct = false;
        this.selectIdColumn = true;
        this.selectColumnList = null;
        this.selectRawList = null;
        this.orderByList = null;
        this.orderByRaw = null;
        this.groupByList = null;
        this.groupByRaw = null;
        this.isInnerQuery = false;
        this.isCountOfQuery = false;
        this.having = null;
        this.limit = null;
        this.offset = null;
        List<QueryBuilder<T, ID>.JoinInfo> list = this.joinList;
        if (list != null) {
            list.clear();
            this.joinList = null;
        }
        this.addTableName = false;
    }

    /* access modifiers changed from: protected */
    public void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        if (this.joinList == null) {
            setAddTableName(false);
        } else {
            setAddTableName(true);
        }
        sb.append("SELECT ");
        if (this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        if (this.isCountOfQuery) {
            this.type = StatementBuilder.StatementType.SELECT_LONG;
            sb.append("COUNT(*) ");
        } else {
            List<String> list2 = this.selectRawList;
            if (list2 == null || list2.isEmpty()) {
                this.type = StatementBuilder.StatementType.SELECT;
                appendColumns(sb);
            } else {
                this.type = StatementBuilder.StatementType.SELECT_RAW;
                appendSelectRaw(sb);
            }
        }
        sb.append("FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableName);
        sb.append(' ');
        if (this.joinList != null) {
            appendJoinSql(sb);
        }
    }

    /* access modifiers changed from: protected */
    public FieldType[] getResultFieldTypes() {
        return this.resultFieldTypes;
    }

    /* access modifiers changed from: protected */
    public boolean appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, StatementBuilder.WhereOperation whereOperation) throws SQLException {
        StatementBuilder.WhereOperation whereOperation2;
        boolean z = whereOperation == StatementBuilder.WhereOperation.FIRST;
        if (this.where != null) {
            z = super.appendWhereStatement(sb, list, whereOperation);
        }
        List<QueryBuilder<T, ID>.JoinInfo> list2 = this.joinList;
        if (list2 != null) {
            for (JoinInfo next : list2) {
                if (z) {
                    whereOperation2 = StatementBuilder.WhereOperation.FIRST;
                } else {
                    whereOperation2 = next.operation;
                }
                z = next.queryBuilder.appendWhereStatement(sb, list, whereOperation2);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendGroupBys(sb);
        appendHaving(sb);
        appendOrderBys(sb, list);
        if (!this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        appendOffset(sb);
        setAddTableName(false);
    }

    /* access modifiers changed from: protected */
    public boolean shouldPrependTableNameToColumns() {
        return this.joinList != null;
    }

    private void setAddTableName(boolean z) {
        this.addTableName = z;
        List<QueryBuilder<T, ID>.JoinInfo> list = this.joinList;
        if (list != null) {
            for (QueryBuilder<T, ID>.JoinInfo joinInfo : list) {
                joinInfo.queryBuilder.setAddTableName(z);
            }
        }
    }

    private void addJoinInfo(String str, QueryBuilder<?, ?> queryBuilder, StatementBuilder.WhereOperation whereOperation) throws SQLException {
        JoinInfo joinInfo = new JoinInfo(str, queryBuilder, whereOperation);
        matchJoinedFields(joinInfo, queryBuilder);
        if (this.joinList == null) {
            this.joinList = new ArrayList();
        }
        this.joinList.add(joinInfo);
    }

    private void matchJoinedFields(QueryBuilder<T, ID>.JoinInfo joinInfo, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            FieldType fieldType = fieldTypes[i2];
            FieldType foreignIdField = fieldType.getForeignIdField();
            if (!fieldType.isForeign() || !foreignIdField.equals(queryBuilder.tableInfo.getIdField())) {
                i2++;
            } else {
                joinInfo.localField = fieldType;
                joinInfo.remoteField = foreignIdField;
                return;
            }
        }
        FieldType[] fieldTypes2 = queryBuilder.tableInfo.getFieldTypes();
        int length2 = fieldTypes2.length;
        while (i < length2) {
            FieldType fieldType2 = fieldTypes2[i];
            if (!fieldType2.isForeign() || !fieldType2.getForeignIdField().equals(this.idField)) {
                i++;
            } else {
                joinInfo.localField = this.idField;
                joinInfo.remoteField = fieldType2;
                return;
            }
        }
        throw new SQLException("Could not find a foreign " + this.tableInfo.getDataClass() + " field in " + queryBuilder.tableInfo.getDataClass() + " or vice versa");
    }

    private void addSelectColumnToList(String str) {
        verifyColumnName(str);
        this.selectColumnList.add(str);
    }

    private void appendJoinSql(StringBuilder sb) {
        for (JoinInfo next : this.joinList) {
            sb.append(next.type);
            sb.append(" JOIN ");
            this.databaseType.appendEscapedEntityName(sb, next.queryBuilder.tableName);
            sb.append(" ON ");
            this.databaseType.appendEscapedEntityName(sb, this.tableName);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, next.localField.getColumnName());
            sb.append(" = ");
            this.databaseType.appendEscapedEntityName(sb, next.queryBuilder.tableName);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, next.remoteField.getColumnName());
            sb.append(' ');
            if (next.queryBuilder.joinList != null) {
                next.queryBuilder.appendJoinSql(sb);
            }
        }
    }

    private void appendSelectRaw(StringBuilder sb) {
        boolean z = true;
        for (String next : this.selectRawList) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append(' ');
    }

    private void appendColumns(StringBuilder sb) {
        List<String> list = this.selectColumnList;
        if (list == null) {
            if (this.addTableName) {
                this.databaseType.appendEscapedEntityName(sb, this.tableName);
                sb.append('.');
            }
            sb.append("* ");
            this.resultFieldTypes = this.tableInfo.getFieldTypes();
            return;
        }
        boolean z = this.isInnerQuery;
        ArrayList arrayList = new ArrayList(list.size() + 1);
        boolean z2 = true;
        for (String fieldTypeByColumnName : this.selectColumnList) {
            FieldType fieldTypeByColumnName2 = this.tableInfo.getFieldTypeByColumnName(fieldTypeByColumnName);
            if (fieldTypeByColumnName2.isForeignCollection()) {
                arrayList.add(fieldTypeByColumnName2);
            } else {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(',');
                }
                appendFieldColumnName(sb, fieldTypeByColumnName2, arrayList);
                if (fieldTypeByColumnName2 == this.idField) {
                    z = true;
                }
            }
        }
        if (!z && this.selectIdColumn) {
            if (!z2) {
                sb.append(',');
            }
            appendFieldColumnName(sb, this.idField, arrayList);
        }
        sb.append(' ');
        this.resultFieldTypes = (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
    }

    private void appendFieldColumnName(StringBuilder sb, FieldType fieldType, List<FieldType> list) {
        appendColumnName(sb, fieldType.getColumnName());
        if (list != null) {
            list.add(fieldType);
        }
    }

    private void appendLimit(StringBuilder sb) {
        if (this.limit != null && this.databaseType.isLimitSqlSupported()) {
            this.databaseType.appendLimitValue(sb, this.limit.longValue(), this.offset);
        }
    }

    private void appendOffset(StringBuilder sb) throws SQLException {
        if (this.offset != null) {
            if (!this.databaseType.isOffsetLimitArgument()) {
                this.databaseType.appendOffsetValue(sb, this.offset.longValue());
            } else if (this.limit == null) {
                throw new SQLException("If the offset is specified, limit must also be specified with this database");
            }
        }
    }

    private void appendGroupBys(StringBuilder sb) {
        boolean z = true;
        if (hasGroupStuff()) {
            appendGroupBys(sb, true);
            z = false;
        }
        List<QueryBuilder<T, ID>.JoinInfo> list = this.joinList;
        if (list != null) {
            for (JoinInfo next : list) {
                if (next.queryBuilder != null && next.queryBuilder.hasGroupStuff()) {
                    next.queryBuilder.appendGroupBys(sb, z);
                }
            }
        }
    }

    private boolean hasGroupStuff() {
        List<String> list = this.groupByList;
        return (list != null && !list.isEmpty()) || this.groupByRaw != null;
    }

    private void appendGroupBys(StringBuilder sb, boolean z) {
        if (z) {
            sb.append("GROUP BY ");
        }
        if (this.groupByRaw != null) {
            if (!z) {
                sb.append(',');
            }
            sb.append(this.groupByRaw);
        } else {
            for (String next : this.groupByList) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                appendColumnName(sb, next);
            }
        }
        sb.append(' ');
    }

    private void appendOrderBys(StringBuilder sb, List<ArgumentHolder> list) {
        boolean z = true;
        if (hasOrderStuff()) {
            appendOrderBys(sb, true, list);
            z = false;
        }
        List<QueryBuilder<T, ID>.JoinInfo> list2 = this.joinList;
        if (list2 != null) {
            for (JoinInfo next : list2) {
                if (next.queryBuilder != null && next.queryBuilder.hasOrderStuff()) {
                    next.queryBuilder.appendOrderBys(sb, z, list);
                }
            }
        }
    }

    private boolean hasOrderStuff() {
        List<OrderBy> list = this.orderByList;
        return (list != null && !list.isEmpty()) || this.orderByRaw != null;
    }

    private void appendOrderBys(StringBuilder sb, boolean z, List<ArgumentHolder> list) {
        if (z) {
            sb.append("ORDER BY ");
        }
        if (this.orderByRaw != null) {
            if (!z) {
                sb.append(',');
            }
            sb.append(this.orderByRaw);
            ArgumentHolder[] argumentHolderArr = this.orderByArgs;
            if (argumentHolderArr != null) {
                for (ArgumentHolder add : argumentHolderArr) {
                    list.add(add);
                }
            }
            z = false;
        }
        List<OrderBy> list2 = this.orderByList;
        if (list2 != null) {
            for (OrderBy next : list2) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                appendColumnName(sb, next.getColumnName());
                if (!next.isAscending()) {
                    sb.append(com.litesuits.orm.db.assit.QueryBuilder.DESC);
                }
            }
        }
        sb.append(' ');
    }

    private void appendColumnName(StringBuilder sb, String str) {
        if (this.addTableName) {
            this.databaseType.appendEscapedEntityName(sb, this.tableName);
            sb.append('.');
        }
        this.databaseType.appendEscapedEntityName(sb, str);
    }

    private void appendHaving(StringBuilder sb) {
        if (this.having != null) {
            sb.append("HAVING ");
            sb.append(this.having);
            sb.append(' ');
        }
    }

    private class JoinInfo {
        FieldType localField;
        StatementBuilder.WhereOperation operation;
        final QueryBuilder<?, ?> queryBuilder;
        FieldType remoteField;
        final String type;

        public JoinInfo(String str, QueryBuilder<?, ?> queryBuilder2, StatementBuilder.WhereOperation whereOperation) {
            this.type = str;
            this.queryBuilder = queryBuilder2;
            this.operation = whereOperation;
        }
    }

    public static class InternalQueryBuilderWrapper {
        private final QueryBuilder<?, ?> queryBuilder;

        InternalQueryBuilderWrapper(QueryBuilder<?, ?> queryBuilder2) {
            this.queryBuilder = queryBuilder2;
        }

        public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
            this.queryBuilder.appendStatementString(sb, list);
        }

        public FieldType[] getResultFieldTypes() {
            return this.queryBuilder.getResultFieldTypes();
        }
    }
}
