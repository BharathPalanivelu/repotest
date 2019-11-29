package com.tencent.imcore;

public enum CommStatus {
    kNotSet((String) 0),
    kClose((String) 1),
    kOpen((String) 2);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30638a;

        static /* synthetic */ int a() {
            int i = f30638a;
            f30638a = i + 1;
            return i;
        }
    }

    private CommStatus(int i) {
        this.swigValue = i;
        int unused = aa.f30638a = i + 1;
    }

    private CommStatus(CommStatus commStatus) {
        this.swigValue = commStatus.swigValue;
        int unused = aa.f30638a = this.swigValue + 1;
    }

    public static CommStatus swigToEnum(int i) {
        CommStatus[] commStatusArr = (CommStatus[]) CommStatus.class.getEnumConstants();
        if (i < commStatusArr.length && i >= 0 && commStatusArr[i].swigValue == i) {
            return commStatusArr[i];
        }
        for (CommStatus commStatus : commStatusArr) {
            if (commStatus.swigValue == i) {
                return commStatus;
            }
        }
        throw new IllegalArgumentException("No enum " + CommStatus.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
