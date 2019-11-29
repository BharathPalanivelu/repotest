package twitter4j;

import com.facebook.places.model.PlaceFields;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Paging implements Serializable {
    static final String COUNT = "count";
    private static final HttpParameter[] NULL_PARAMETER_ARRAY = new HttpParameter[0];
    private static final List<HttpParameter> NULL_PARAMETER_LIST = new ArrayList(0);
    static final String PER_PAGE = "per_page";
    static final char[] S = {'s'};
    static final char[] SMCP = {'s', 'm', 'c', 'p'};
    private static final long serialVersionUID = -7226113618341047983L;
    private int count;
    private long maxId;
    private int page;
    private long sinceId;

    /* access modifiers changed from: package-private */
    public List<HttpParameter> asPostParameterList() {
        return asPostParameterList(SMCP, COUNT);
    }

    /* access modifiers changed from: package-private */
    public HttpParameter[] asPostParameterArray() {
        List<HttpParameter> asPostParameterList = asPostParameterList(SMCP, COUNT);
        if (asPostParameterList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) asPostParameterList.toArray(new HttpParameter[asPostParameterList.size()]);
    }

    /* access modifiers changed from: package-private */
    public List<HttpParameter> asPostParameterList(char[] cArr) {
        return asPostParameterList(cArr, COUNT);
    }

    /* access modifiers changed from: package-private */
    public List<HttpParameter> asPostParameterList(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        char[] cArr2 = cArr;
        ArrayList arrayList2 = arrayList;
        addPostParameter(cArr2, 's', arrayList2, "since_id", getSinceId());
        addPostParameter(cArr2, 'm', arrayList2, "max_id", getMaxId());
        addPostParameter(cArr2, 'c', arrayList2, str, (long) getCount());
        addPostParameter(cArr2, 'p', arrayList2, PlaceFields.PAGE, (long) getPage());
        return arrayList.size() == 0 ? NULL_PARAMETER_LIST : arrayList;
    }

    /* access modifiers changed from: package-private */
    public HttpParameter[] asPostParameterArray(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        char[] cArr2 = cArr;
        ArrayList arrayList2 = arrayList;
        addPostParameter(cArr2, 's', arrayList2, "since_id", getSinceId());
        addPostParameter(cArr2, 'm', arrayList2, "max_id", getMaxId());
        addPostParameter(cArr2, 'c', arrayList2, str, (long) getCount());
        addPostParameter(cArr2, 'p', arrayList2, PlaceFields.PAGE, (long) getPage());
        if (arrayList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void addPostParameter(char[] cArr, char c2, List<HttpParameter> list, String str, long j) {
        int length = cArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (cArr[i] == c2) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z && -1 != j) {
            throw new IllegalStateException("Paging parameter [" + str + "] is not supported with this operation.");
        } else if (-1 != j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
        }
    }

    public Paging() {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1;
        this.maxId = -1;
    }

    public Paging(int i) {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1;
        this.maxId = -1;
        setPage(i);
    }

    public Paging(long j) {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1;
        this.maxId = -1;
        setSinceId(j);
    }

    public Paging(int i, int i2) {
        this(i);
        setCount(i2);
    }

    public Paging(int i, long j) {
        this(i);
        setSinceId(j);
    }

    public Paging(int i, int i2, long j) {
        this(i, i2);
        setSinceId(j);
    }

    public Paging(int i, int i2, long j, long j2) {
        this(i, i2, j);
        setMaxId(j2);
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int i) {
        if (i >= 1) {
            this.page = i;
            return;
        }
        throw new IllegalArgumentException("page should be positive integer. passed:" + i);
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        if (i >= 1) {
            this.count = i;
            return;
        }
        throw new IllegalArgumentException("count should be positive integer. passed:" + i);
    }

    public Paging count(int i) {
        setCount(i);
        return this;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public void setSinceId(long j) {
        if (j >= 1) {
            this.sinceId = j;
            return;
        }
        throw new IllegalArgumentException("since_id should be positive integer. passed:" + j);
    }

    public Paging sinceId(long j) {
        setSinceId(j);
        return this;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public void setMaxId(long j) {
        if (j >= 1) {
            this.maxId = j;
            return;
        }
        throw new IllegalArgumentException("max_id should be positive integer. passed:" + j);
    }

    public Paging maxId(long j) {
        setMaxId(j);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paging)) {
            return false;
        }
        Paging paging = (Paging) obj;
        return this.count == paging.count && this.maxId == paging.maxId && this.page == paging.page && this.sinceId == paging.sinceId;
    }

    public int hashCode() {
        long j = this.sinceId;
        long j2 = this.maxId;
        return (((((this.page * 31) + this.count) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "Paging{page=" + this.page + ", count=" + this.count + ", sinceId=" + this.sinceId + ", maxId=" + this.maxId + '}';
    }
}
