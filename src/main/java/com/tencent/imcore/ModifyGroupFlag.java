package com.tencent.imcore;

public enum ModifyGroupFlag {
    kModifyGroupNone((String) 0),
    kModifyGroupName((String) 1),
    kModifyGroupNotification((String) 2),
    kModifyGroupIntroduction((String) 4),
    kModifyGroupFaceUrl((String) 8),
    kModifyGroupAddOption((String) 16),
    kModifyGroupMaxMmeberNum((String) 32),
    kModifyGroupVisible((String) 64),
    kModifyGroupSearchable((String) 128),
    kModifyGroupAllShutup((String) 256);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30649a;

        static /* synthetic */ int a() {
            int i = f30649a;
            f30649a = i + 1;
            return i;
        }
    }

    private ModifyGroupFlag(int i) {
        this.swigValue = i;
        int unused = aa.f30649a = i + 1;
    }

    private ModifyGroupFlag(ModifyGroupFlag modifyGroupFlag) {
        this.swigValue = modifyGroupFlag.swigValue;
        int unused = aa.f30649a = this.swigValue + 1;
    }

    public static ModifyGroupFlag swigToEnum(int i) {
        ModifyGroupFlag[] modifyGroupFlagArr = (ModifyGroupFlag[]) ModifyGroupFlag.class.getEnumConstants();
        if (i < modifyGroupFlagArr.length && i >= 0 && modifyGroupFlagArr[i].swigValue == i) {
            return modifyGroupFlagArr[i];
        }
        for (ModifyGroupFlag modifyGroupFlag : modifyGroupFlagArr) {
            if (modifyGroupFlag.swigValue == i) {
                return modifyGroupFlag;
            }
        }
        throw new IllegalArgumentException("No enum " + ModifyGroupFlag.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
