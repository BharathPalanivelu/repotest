package com.tencent.imcore;

public enum ModifyGroupMemberFlag {
    kModifyGroupMemberNone((String) 0),
    kModifyGroupMemberMsgFlag((String) 1),
    kModifyGroupMemberRole((String) 2),
    kModifyGroupMemberShutupTime((String) 4),
    kModifyGroupMemberNameCard((String) 8);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30650a;

        static /* synthetic */ int a() {
            int i = f30650a;
            f30650a = i + 1;
            return i;
        }
    }

    private ModifyGroupMemberFlag(int i) {
        this.swigValue = i;
        int unused = aa.f30650a = i + 1;
    }

    private ModifyGroupMemberFlag(ModifyGroupMemberFlag modifyGroupMemberFlag) {
        this.swigValue = modifyGroupMemberFlag.swigValue;
        int unused = aa.f30650a = this.swigValue + 1;
    }

    public static ModifyGroupMemberFlag swigToEnum(int i) {
        ModifyGroupMemberFlag[] modifyGroupMemberFlagArr = (ModifyGroupMemberFlag[]) ModifyGroupMemberFlag.class.getEnumConstants();
        if (i < modifyGroupMemberFlagArr.length && i >= 0 && modifyGroupMemberFlagArr[i].swigValue == i) {
            return modifyGroupMemberFlagArr[i];
        }
        for (ModifyGroupMemberFlag modifyGroupMemberFlag : modifyGroupMemberFlagArr) {
            if (modifyGroupMemberFlag.swigValue == i) {
                return modifyGroupMemberFlag;
            }
        }
        throw new IllegalArgumentException("No enum " + ModifyGroupMemberFlag.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
