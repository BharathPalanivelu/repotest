package com.airpay.paysdk.base.bean;

import com.airpay.paysdk.base.a.a;
import java.math.BigInteger;

public class BPRuleOp {
    private final int OPR_ADD = 0;
    private final int OPR_MUL = 1;
    public int operator;
    public int source;
    public long value;

    public BPRuleOp(int i, int i2, long j) {
        this.source = i;
        this.operator = i2;
        this.value = j;
    }

    public long applyRule(long j) {
        int i = this.operator;
        if (i == 0) {
            return j + this.value;
        }
        if (i != 1) {
            return j;
        }
        return new BigInteger(String.valueOf(j)).multiply(new BigInteger(String.valueOf(this.value))).divide(a.f3783a).longValue();
    }

    public String toString() {
        return "BPRuleOp{OPR_ADD=0\n OPR_MUL=1\n source=" + this.source + "\n operator=" + this.operator + "\n value=" + this.value + '}';
    }
}
