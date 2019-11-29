package com.tencent.imcore;

public enum SessionType {
    kNull((String) 0),
    kC2C,
    kGroup,
    kSystemSessionType;
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30657a;

        static /* synthetic */ int a() {
            int i = f30657a;
            f30657a = i + 1;
            return i;
        }
    }

    private SessionType(int i) {
        this.swigValue = i;
        int unused = aa.f30657a = i + 1;
    }

    private SessionType(SessionType sessionType) {
        this.swigValue = sessionType.swigValue;
        int unused = aa.f30657a = this.swigValue + 1;
    }

    public static SessionType swigToEnum(int i) {
        SessionType[] sessionTypeArr = (SessionType[]) SessionType.class.getEnumConstants();
        if (i < sessionTypeArr.length && i >= 0 && sessionTypeArr[i].swigValue == i) {
            return sessionTypeArr[i];
        }
        for (SessionType sessionType : sessionTypeArr) {
            if (sessionType.swigValue == i) {
                return sessionType;
            }
        }
        throw new IllegalArgumentException("No enum " + SessionType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
