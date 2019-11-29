package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.sql.SQLException;
import java.util.List;

public class MappedQueryForId<T, ID> extends BaseMappedQuery<T, ID> {
    private final String label;

    protected MappedQueryForId(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, String str2) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.label = str2;
    }

    public T execute(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        if (objectCache != null) {
            T t = objectCache.get(this.clazz, id);
            if (t != null) {
                return t;
            }
        }
        Object[] objArr = {convertIdToFieldObject(id)};
        T queryForOne = databaseConnection.queryForOne(this.statement, objArr, this.argFieldTypes, this, objectCache);
        if (queryForOne == null) {
            logger.debug("{} using '{}' and {} args, got no results", (Object) this.label, (Object) this.statement, (Object) Integer.valueOf(objArr.length));
        } else if (queryForOne != DatabaseConnection.MORE_THAN_ONE) {
            logger.debug("{} using '{}' and {} args, got 1 result", (Object) this.label, (Object) this.statement, (Object) Integer.valueOf(objArr.length));
        } else {
            logger.error("{} using '{}' and {} args, got >1 results", (Object) this.label, (Object) this.statement, (Object) Integer.valueOf(objArr.length));
            logArgs(objArr);
            throw new SQLException(this.label + " got more than 1 result: " + this.statement);
        }
        logArgs(objArr);
        return queryForOne;
    }

    public static <T, ID> MappedQueryForId<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo, FieldType fieldType) throws SQLException {
        if (fieldType == null) {
            fieldType = tableInfo.getIdField();
            if (fieldType == null) {
                throw new SQLException("Cannot query-for-id with " + tableInfo.getDataClass() + " because it doesn't have an id field");
            }
        }
        return new MappedQueryForId(tableInfo, buildStatement(databaseType, tableInfo, fieldType), new FieldType[]{fieldType}, tableInfo.getFieldTypes(), "query-for-id");
    }

    protected static <T, ID> String buildStatement(DatabaseType databaseType, TableInfo<T, ID> tableInfo, FieldType fieldType) {
        StringBuilder sb = new StringBuilder(64);
        appendTableName(databaseType, sb, SQLBuilder.SELECT_ANY_FROM, tableInfo.getTableName());
        appendWhereFieldEq(databaseType, fieldType, sb, (List<FieldType>) null);
        return sb.toString();
    }

    private void logArgs(Object[] objArr) {
        if (objArr.length > 0) {
            logger.trace("{} arguments: {}", (Object) this.label, (Object) objArr);
        }
    }
}
