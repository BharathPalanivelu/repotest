package com.tencent.imcore;

public enum FriendDeleteType {
    FriendDeleteSingleType((String) 1),
    FirendDeleteBothType((String) 2);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30640a;

        static /* synthetic */ int a() {
            int i = f30640a;
            f30640a = i + 1;
            return i;
        }
    }

    private FriendDeleteType(int i) {
        this.swigValue = i;
        int unused = aa.f30640a = i + 1;
    }

    private FriendDeleteType(FriendDeleteType friendDeleteType) {
        this.swigValue = friendDeleteType.swigValue;
        int unused = aa.f30640a = this.swigValue + 1;
    }

    public static FriendDeleteType swigToEnum(int i) {
        FriendDeleteType[] friendDeleteTypeArr = (FriendDeleteType[]) FriendDeleteType.class.getEnumConstants();
        if (i < friendDeleteTypeArr.length && i >= 0 && friendDeleteTypeArr[i].swigValue == i) {
            return friendDeleteTypeArr[i];
        }
        for (FriendDeleteType friendDeleteType : friendDeleteTypeArr) {
            if (friendDeleteType.swigValue == i) {
                return friendDeleteType;
            }
        }
        throw new IllegalArgumentException("No enum " + FriendDeleteType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
