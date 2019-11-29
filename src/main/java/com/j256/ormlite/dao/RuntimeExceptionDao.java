package com.j256.ormlite.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class RuntimeExceptionDao<T, ID> implements CloseableIterable<T> {
    private static final Log.Level LOG_LEVEL = Log.Level.DEBUG;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) RuntimeExceptionDao.class);
    private Dao<T, ID> dao;

    public RuntimeExceptionDao(Dao<T, ID> dao2) {
        this.dao = dao2;
    }

    public static <T, ID> RuntimeExceptionDao<T, ID> createDao(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return new RuntimeExceptionDao<>(DaoManager.createDao(connectionSource, cls));
    }

    public static <T, ID> RuntimeExceptionDao<T, ID> createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return new RuntimeExceptionDao<>(DaoManager.createDao(connectionSource, databaseTableConfig));
    }

    public T queryForId(ID id) {
        try {
            return this.dao.queryForId(id);
        } catch (SQLException e2) {
            logMessage(e2, "queryForId threw exception on: " + id);
            throw new RuntimeException(e2);
        }
    }

    public T queryForFirst(PreparedQuery<T> preparedQuery) {
        try {
            return this.dao.queryForFirst(preparedQuery);
        } catch (SQLException e2) {
            logMessage(e2, "queryForFirst threw exception on: " + preparedQuery);
            throw new RuntimeException(e2);
        }
    }

    public List<T> queryForAll() {
        try {
            return this.dao.queryForAll();
        } catch (SQLException e2) {
            logMessage(e2, "queryForAll threw exception");
            throw new RuntimeException(e2);
        }
    }

    public List<T> queryForEq(String str, Object obj) {
        try {
            return this.dao.queryForEq(str, obj);
        } catch (SQLException e2) {
            logMessage(e2, "queryForEq threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public List<T> queryForMatching(T t) {
        try {
            return this.dao.queryForMatching(t);
        } catch (SQLException e2) {
            logMessage(e2, "queryForMatching threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public List<T> queryForMatchingArgs(T t) {
        try {
            return this.dao.queryForMatchingArgs(t);
        } catch (SQLException e2) {
            logMessage(e2, "queryForMatchingArgs threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public List<T> queryForFieldValues(Map<String, Object> map) {
        try {
            return this.dao.queryForFieldValues(map);
        } catch (SQLException e2) {
            logMessage(e2, "queryForFieldValues threw exception");
            throw new RuntimeException(e2);
        }
    }

    public List<T> queryForFieldValuesArgs(Map<String, Object> map) {
        try {
            return this.dao.queryForFieldValuesArgs(map);
        } catch (SQLException e2) {
            logMessage(e2, "queryForFieldValuesArgs threw exception");
            throw new RuntimeException(e2);
        }
    }

    public T queryForSameId(T t) {
        try {
            return this.dao.queryForSameId(t);
        } catch (SQLException e2) {
            logMessage(e2, "queryForSameId threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public QueryBuilder<T, ID> queryBuilder() {
        return this.dao.queryBuilder();
    }

    public UpdateBuilder<T, ID> updateBuilder() {
        return this.dao.updateBuilder();
    }

    public DeleteBuilder<T, ID> deleteBuilder() {
        return this.dao.deleteBuilder();
    }

    public List<T> query(PreparedQuery<T> preparedQuery) {
        try {
            return this.dao.query(preparedQuery);
        } catch (SQLException e2) {
            logMessage(e2, "query threw exception on: " + preparedQuery);
            throw new RuntimeException(e2);
        }
    }

    public int create(T t) {
        try {
            return this.dao.create(t);
        } catch (SQLException e2) {
            logMessage(e2, "create threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public T createIfNotExists(T t) {
        try {
            return this.dao.createIfNotExists(t);
        } catch (SQLException e2) {
            logMessage(e2, "createIfNotExists threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public Dao.CreateOrUpdateStatus createOrUpdate(T t) {
        try {
            return this.dao.createOrUpdate(t);
        } catch (SQLException e2) {
            logMessage(e2, "createOrUpdate threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public int update(T t) {
        try {
            return this.dao.update(t);
        } catch (SQLException e2) {
            logMessage(e2, "update threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public int updateId(T t, ID id) {
        try {
            return this.dao.updateId(t, id);
        } catch (SQLException e2) {
            logMessage(e2, "updateId threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public int update(PreparedUpdate<T> preparedUpdate) {
        try {
            return this.dao.update(preparedUpdate);
        } catch (SQLException e2) {
            logMessage(e2, "update threw exception on: " + preparedUpdate);
            throw new RuntimeException(e2);
        }
    }

    public int refresh(T t) {
        try {
            return this.dao.refresh(t);
        } catch (SQLException e2) {
            logMessage(e2, "refresh threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public int delete(T t) {
        try {
            return this.dao.delete(t);
        } catch (SQLException e2) {
            logMessage(e2, "delete threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public int deleteById(ID id) {
        try {
            return this.dao.deleteById(id);
        } catch (SQLException e2) {
            logMessage(e2, "deleteById threw exception on: " + id);
            throw new RuntimeException(e2);
        }
    }

    public int delete(Collection<T> collection) {
        try {
            return this.dao.delete(collection);
        } catch (SQLException e2) {
            logMessage(e2, "delete threw exception on: " + collection);
            throw new RuntimeException(e2);
        }
    }

    public int deleteIds(Collection<ID> collection) {
        try {
            return this.dao.deleteIds(collection);
        } catch (SQLException e2) {
            logMessage(e2, "deleteIds threw exception on: " + collection);
            throw new RuntimeException(e2);
        }
    }

    public int delete(PreparedDelete<T> preparedDelete) {
        try {
            return this.dao.delete(preparedDelete);
        } catch (SQLException e2) {
            logMessage(e2, "delete threw exception on: " + preparedDelete);
            throw new RuntimeException(e2);
        }
    }

    public CloseableIterator<T> iterator() {
        return this.dao.iterator();
    }

    public CloseableIterator<T> closeableIterator() {
        return this.dao.closeableIterator();
    }

    public CloseableIterator<T> iterator(int i) {
        return this.dao.iterator(i);
    }

    public CloseableWrappedIterable<T> getWrappedIterable() {
        return this.dao.getWrappedIterable();
    }

    public CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> preparedQuery) {
        return this.dao.getWrappedIterable(preparedQuery);
    }

    public void closeLastIterator() {
        try {
            this.dao.closeLastIterator();
        } catch (SQLException e2) {
            logMessage(e2, "closeLastIterator threw exception");
            throw new RuntimeException(e2);
        }
    }

    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) {
        try {
            return this.dao.iterator(preparedQuery);
        } catch (SQLException e2) {
            logMessage(e2, "iterator threw exception on: " + preparedQuery);
            throw new RuntimeException(e2);
        }
    }

    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i) {
        try {
            return this.dao.iterator(preparedQuery, i);
        } catch (SQLException e2) {
            logMessage(e2, "iterator threw exception on: " + preparedQuery);
            throw new RuntimeException(e2);
        }
    }

    public GenericRawResults<String[]> queryRaw(String str, String... strArr) {
        try {
            return this.dao.queryRaw(str, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "queryRaw threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public long queryRawValue(String str, String... strArr) {
        try {
            return this.dao.queryRawValue(str, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "queryRawValue threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(String str, RawRowMapper<UO> rawRowMapper, String... strArr) {
        try {
            return this.dao.queryRaw(str, rawRowMapper, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "queryRaw threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String... strArr) {
        try {
            return this.dao.queryRaw(str, dataTypeArr, rawRowObjectMapper, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "queryRaw threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr) {
        try {
            return this.dao.queryRaw(str, dataTypeArr, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "queryRaw threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public int executeRaw(String str, String... strArr) {
        try {
            return this.dao.executeRaw(str, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "executeRaw threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public int executeRawNoArgs(String str) {
        try {
            return this.dao.executeRawNoArgs(str);
        } catch (SQLException e2) {
            logMessage(e2, "executeRawNoArgs threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public int updateRaw(String str, String... strArr) {
        try {
            return this.dao.updateRaw(str, strArr);
        } catch (SQLException e2) {
            logMessage(e2, "updateRaw threw exception on: " + str);
            throw new RuntimeException(e2);
        }
    }

    public <CT> CT callBatchTasks(Callable<CT> callable) {
        try {
            return this.dao.callBatchTasks(callable);
        } catch (Exception e2) {
            logMessage(e2, "callBatchTasks threw exception on: " + callable);
            throw new RuntimeException(e2);
        }
    }

    public String objectToString(T t) {
        return this.dao.objectToString(t);
    }

    public boolean objectsEqual(T t, T t2) {
        try {
            return this.dao.objectsEqual(t, t2);
        } catch (SQLException e2) {
            logMessage(e2, "objectsEqual threw exception on: " + t + " and " + t2);
            throw new RuntimeException(e2);
        }
    }

    public ID extractId(T t) {
        try {
            return this.dao.extractId(t);
        } catch (SQLException e2) {
            logMessage(e2, "extractId threw exception on: " + t);
            throw new RuntimeException(e2);
        }
    }

    public Class<T> getDataClass() {
        return this.dao.getDataClass();
    }

    public FieldType findForeignFieldType(Class<?> cls) {
        return this.dao.findForeignFieldType(cls);
    }

    public boolean isUpdatable() {
        return this.dao.isUpdatable();
    }

    public boolean isTableExists() {
        try {
            return this.dao.isTableExists();
        } catch (SQLException e2) {
            logMessage(e2, "isTableExists threw exception");
            throw new RuntimeException(e2);
        }
    }

    public long countOf() {
        try {
            return this.dao.countOf();
        } catch (SQLException e2) {
            logMessage(e2, "countOf threw exception");
            throw new RuntimeException(e2);
        }
    }

    public long countOf(PreparedQuery<T> preparedQuery) {
        try {
            return this.dao.countOf(preparedQuery);
        } catch (SQLException e2) {
            logMessage(e2, "countOf threw exception on " + preparedQuery);
            throw new RuntimeException(e2);
        }
    }

    public void assignEmptyForeignCollection(T t, String str) {
        try {
            this.dao.assignEmptyForeignCollection(t, str);
        } catch (SQLException e2) {
            logMessage(e2, "assignEmptyForeignCollection threw exception on " + str);
            throw new RuntimeException(e2);
        }
    }

    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String str) {
        try {
            return this.dao.getEmptyForeignCollection(str);
        } catch (SQLException e2) {
            logMessage(e2, "getEmptyForeignCollection threw exception on " + str);
            throw new RuntimeException(e2);
        }
    }

    public void setObjectCache(boolean z) {
        try {
            this.dao.setObjectCache(z);
        } catch (SQLException e2) {
            logMessage(e2, "setObjectCache(" + z + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    public ObjectCache getObjectCache() {
        return this.dao.getObjectCache();
    }

    public void setObjectCache(ObjectCache objectCache) {
        try {
            this.dao.setObjectCache(objectCache);
        } catch (SQLException e2) {
            logMessage(e2, "setObjectCache threw exception on " + objectCache);
            throw new RuntimeException(e2);
        }
    }

    public void clearObjectCache() {
        this.dao.clearObjectCache();
    }

    public T mapSelectStarRow(DatabaseResults databaseResults) {
        try {
            return this.dao.mapSelectStarRow(databaseResults);
        } catch (SQLException e2) {
            logMessage(e2, "mapSelectStarRow threw exception on results");
            throw new RuntimeException(e2);
        }
    }

    public GenericRowMapper<T> getSelectStarRowMapper() {
        try {
            return this.dao.getSelectStarRowMapper();
        } catch (SQLException e2) {
            logMessage(e2, "getSelectStarRowMapper threw exception");
            throw new RuntimeException(e2);
        }
    }

    public boolean idExists(ID id) {
        try {
            return this.dao.idExists(id);
        } catch (SQLException e2) {
            logMessage(e2, "idExists threw exception on " + id);
            throw new RuntimeException(e2);
        }
    }

    public DatabaseConnection startThreadConnection() {
        try {
            return this.dao.startThreadConnection();
        } catch (SQLException e2) {
            logMessage(e2, "startThreadConnection() threw exception");
            throw new RuntimeException(e2);
        }
    }

    public void endThreadConnection(DatabaseConnection databaseConnection) {
        try {
            this.dao.endThreadConnection(databaseConnection);
        } catch (SQLException e2) {
            logMessage(e2, "endThreadConnection(" + databaseConnection + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    @Deprecated
    public void setAutoCommit(boolean z) {
        try {
            this.dao.setAutoCommit(z);
        } catch (SQLException e2) {
            logMessage(e2, "setAutoCommit(" + z + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    public void setAutoCommit(DatabaseConnection databaseConnection, boolean z) {
        try {
            this.dao.setAutoCommit(databaseConnection, z);
        } catch (SQLException e2) {
            logMessage(e2, "setAutoCommit(" + databaseConnection + "," + z + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    @Deprecated
    public boolean isAutoCommit() {
        try {
            return this.dao.isAutoCommit();
        } catch (SQLException e2) {
            logMessage(e2, "isAutoCommit() threw exception");
            throw new RuntimeException(e2);
        }
    }

    public boolean isAutoCommit(DatabaseConnection databaseConnection) {
        try {
            return this.dao.isAutoCommit(databaseConnection);
        } catch (SQLException e2) {
            logMessage(e2, "isAutoCommit(" + databaseConnection + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    public void commit(DatabaseConnection databaseConnection) {
        try {
            this.dao.commit(databaseConnection);
        } catch (SQLException e2) {
            logMessage(e2, "commit(" + databaseConnection + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    public void rollBack(DatabaseConnection databaseConnection) {
        try {
            this.dao.rollBack(databaseConnection);
        } catch (SQLException e2) {
            logMessage(e2, "rollBack(" + databaseConnection + ") threw exception");
            throw new RuntimeException(e2);
        }
    }

    public void setObjectFactory(ObjectFactory<T> objectFactory) {
        this.dao.setObjectFactory(objectFactory);
    }

    public RawRowMapper<T> getRawRowMapper() {
        return this.dao.getRawRowMapper();
    }

    public ConnectionSource getConnectionSource() {
        return this.dao.getConnectionSource();
    }

    private void logMessage(Exception exc, String str) {
        logger.log(LOG_LEVEL, (Throwable) exc, str);
    }
}
