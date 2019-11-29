package com.airpay.paysdk.base.bean;

import java.util.ArrayList;
import java.util.List;

public class BPEventRuleInfo implements Comparable<BPEventRuleInfo> {
    public long lowerBound;
    public List<BPRuleOp> ops = new ArrayList();

    public BPEventRuleInfo(long j) {
        this.lowerBound = j;
    }

    public int compareTo(BPEventRuleInfo bPEventRuleInfo) {
        return Long.valueOf(bPEventRuleInfo.lowerBound).compareTo(Long.valueOf(this.lowerBound));
    }

    public void addOp(int i, int i2, long j) {
        this.ops.add(new BPRuleOp(i, i2, j));
    }

    public String toString() {
        return "BPEventRuleInfo{lowerBound=" + this.lowerBound + "\n ops=" + this.ops + '}';
    }
}
