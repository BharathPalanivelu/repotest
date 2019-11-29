package com.tencent.imcore;

public enum FutureType {
    FutureTypePendencyComeIn((String) 1),
    FutureTypePendencySendOut((String) 2),
    FutureTypeRecommend((String) 4),
    FutureTypeDecide((String) 8);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30642a;

        static /* synthetic */ int a() {
            int i = f30642a;
            f30642a = i + 1;
            return i;
        }
    }

    private FutureType(int i) {
        this.swigValue = i;
        int unused = aa.f30642a = i + 1;
    }

    private FutureType(FutureType futureType) {
        this.swigValue = futureType.swigValue;
        int unused = aa.f30642a = this.swigValue + 1;
    }

    public static FutureType swigToEnum(int i) {
        FutureType[] futureTypeArr = (FutureType[]) FutureType.class.getEnumConstants();
        if (i < futureTypeArr.length && i >= 0 && futureTypeArr[i].swigValue == i) {
            return futureTypeArr[i];
        }
        for (FutureType futureType : futureTypeArr) {
            if (futureType.swigValue == i) {
                return futureType;
            }
        }
        throw new IllegalArgumentException("No enum " + FutureType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
