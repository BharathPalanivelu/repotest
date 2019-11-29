package com.tencent.imcore;

public enum PendencyType {
    PendencyTypeComeIn((String) 1),
    PendencyTypeSendOut((String) 2),
    PendencyTypeBoth((String) 3);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30654a;

        static /* synthetic */ int a() {
            int i = f30654a;
            f30654a = i + 1;
            return i;
        }
    }

    private PendencyType(int i) {
        this.swigValue = i;
        int unused = aa.f30654a = i + 1;
    }

    private PendencyType(PendencyType pendencyType) {
        this.swigValue = pendencyType.swigValue;
        int unused = aa.f30654a = this.swigValue + 1;
    }

    public static PendencyType swigToEnum(int i) {
        PendencyType[] pendencyTypeArr = (PendencyType[]) PendencyType.class.getEnumConstants();
        if (i < pendencyTypeArr.length && i >= 0 && pendencyTypeArr[i].swigValue == i) {
            return pendencyTypeArr[i];
        }
        for (PendencyType pendencyType : pendencyTypeArr) {
            if (pendencyType.swigValue == i) {
                return pendencyType;
            }
        }
        throw new IllegalArgumentException("No enum " + PendencyType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
