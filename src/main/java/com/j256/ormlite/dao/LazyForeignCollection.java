package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    public boolean isEager() {
        return false;
    }

    public int refreshCollection() {
        return 0;
    }

    public LazyForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        super(dao, obj, obj2, fieldType, str, z);
    }

    public CloseableIterator<T> iterator() {
        return closeableIterator(-1);
    }

    public CloseableIterator<T> iterator(int i) {
        return closeableIterator(i);
    }

    public CloseableIterator<T> closeableIterator() {
        return closeableIterator(-1);
    }

    public CloseableIterator<T> closeableIterator(int i) {
        try {
            return iteratorThrow(i);
        } catch (SQLException e2) {
            throw new IllegalStateException("Could not build lazy iterator for " + this.dao.getDataClass(), e2);
        }
    }

    public CloseableIterator<T> iteratorThrow() throws SQLException {
        return iteratorThrow(-1);
    }

    public CloseableIterator<T> iteratorThrow(int i) throws SQLException {
        this.lastIterator = seperateIteratorThrow(i);
        return this.lastIterator;
    }

    public CloseableWrappedIterable<T> getWrappedIterable() {
        return getWrappedIterable(-1);
    }

    public CloseableWrappedIterable<T> getWrappedIterable(final int i) {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow(i);
                } catch (Exception e2) {
                    throw new IllegalStateException("Could not build lazy iterator for " + LazyForeignCollection.this.dao.getDataClass(), e2);
                }
            }
        });
    }

    public void closeLastIterator() throws SQLException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    public int size() {
        CloseableIterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            try {
                it.moveToNext();
                i++;
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
                throw th;
            }
        }
        try {
            it.close();
        } catch (SQLException unused2) {
        }
        return i;
    }

    public boolean isEmpty() {
        CloseableIterator it = iterator();
        try {
            return !it.hasNext();
        } finally {
            try {
                it.close();
            } catch (SQLException unused) {
            }
        }
    }

    public boolean contains(Object obj) {
        CloseableIterator it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                    } catch (SQLException unused) {
                    }
                    return false;
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused2) {
                }
                throw th;
            }
        } while (!it.next().equals(obj));
        try {
            it.close();
        } catch (SQLException unused3) {
        }
        return true;
    }

    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator it = iterator();
        while (it.hasNext()) {
            try {
                hashSet.remove(it.next());
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
                throw th;
            }
        }
        boolean isEmpty = hashSet.isEmpty();
        try {
            it.close();
        } catch (SQLException unused2) {
        }
        return isEmpty;
    }

    public boolean remove(Object obj) {
        CloseableIterator it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                    } catch (SQLException unused) {
                    }
                    return false;
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused2) {
                }
                throw th;
            }
        } while (!it.next().equals(obj));
        it.remove();
        try {
            it.close();
        } catch (SQLException unused3) {
        }
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        CloseableIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            try {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
                throw th;
            }
        }
        try {
            it.close();
        } catch (SQLException unused2) {
        }
        return z;
    }

    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator it = iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next());
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
                throw th;
            }
        }
        Object[] array = arrayList.toArray();
        try {
            it.close();
        } catch (SQLException unused2) {
        }
        return array;
    }

    public <E> E[] toArray(E[] eArr) {
        CloseableIterator it = iterator();
        ArrayList arrayList = null;
        int i = 0;
        while (it.hasNext()) {
            try {
                E next = it.next();
                if (i >= eArr.length) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        for (E add : eArr) {
                            arrayList.add(add);
                        }
                    }
                    arrayList.add(next);
                } else {
                    eArr[i] = next;
                }
                i++;
            } catch (Throwable th) {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
                throw th;
            }
        }
        try {
            it.close();
        } catch (SQLException unused2) {
        }
        if (arrayList != null) {
            return arrayList.toArray(eArr);
        }
        if (i < eArr.length - 1) {
            eArr[i] = null;
        }
        return eArr;
    }

    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: private */
    public CloseableIterator<T> seperateIteratorThrow(int i) throws SQLException {
        if (this.dao != null) {
            return this.dao.iterator(getPreparedQuery(), i);
        }
        throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    }
}
