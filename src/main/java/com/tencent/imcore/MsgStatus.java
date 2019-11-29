package com.tencent.imcore;

public enum MsgStatus {
    kSending((String) 1),
    kSendSucc((String) 2),
    kSendFail((String) 3),
    kHasDeleted((String) 4),
    kLocalImported((String) 5),
    kHasRevoked((String) 6);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30653a;

        static /* synthetic */ int a() {
            int i = f30653a;
            f30653a = i + 1;
            return i;
        }
    }

    private MsgStatus(int i) {
        this.swigValue = i;
        int unused = aa.f30653a = i + 1;
    }

    private MsgStatus(MsgStatus msgStatus) {
        this.swigValue = msgStatus.swigValue;
        int unused = aa.f30653a = this.swigValue + 1;
    }

    public static MsgStatus swigToEnum(int i) {
        MsgStatus[] msgStatusArr = (MsgStatus[]) MsgStatus.class.getEnumConstants();
        if (i < msgStatusArr.length && i >= 0 && msgStatusArr[i].swigValue == i) {
            return msgStatusArr[i];
        }
        for (MsgStatus msgStatus : msgStatusArr) {
            if (msgStatus.swigValue == i) {
                return msgStatus;
            }
        }
        throw new IllegalArgumentException("No enum " + MsgStatus.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
