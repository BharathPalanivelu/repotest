package twitter4j;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.Serializable;

abstract class EntityIndex implements Serializable, Comparable<EntityIndex> {
    private static final long serialVersionUID = 3757474748266170719L;
    private int end = -1;
    private int start = -1;

    EntityIndex() {
    }

    public int compareTo(EntityIndex entityIndex) {
        long j = (long) (this.start - entityIndex.start);
        if (j < -2147483648L) {
            return RNCartPanelDataEntity.NULL_VALUE;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    /* access modifiers changed from: package-private */
    public void setStart(int i) {
        this.start = i;
    }

    /* access modifiers changed from: package-private */
    public void setEnd(int i) {
        this.end = i;
    }

    /* access modifiers changed from: package-private */
    public int getStart() {
        return this.start;
    }

    /* access modifiers changed from: package-private */
    public int getEnd() {
        return this.end;
    }
}
