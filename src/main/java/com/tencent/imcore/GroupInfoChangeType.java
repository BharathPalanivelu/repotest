package com.tencent.imcore;

public enum GroupInfoChangeType {
    IMCORE_GROUP_INFO_CHAGE_TYPE_GROUP_NAME((String) 1),
    IMCORE_GROUP_INFO_CHAGE_TYPE_INTRODUCTION((String) 2),
    IMCORE_GROUP_INFO_CHAGE_TYPE_NOTIFACTION((String) 3),
    IMCORE_GROUP_INFO_CHAGE_TYPE_FACE_URL((String) 4),
    IMCORE_GROUP_INFO_CHAGE_TYPE_OWNER((String) 5);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30645a;

        static /* synthetic */ int a() {
            int i = f30645a;
            f30645a = i + 1;
            return i;
        }
    }

    private GroupInfoChangeType(int i) {
        this.swigValue = i;
        int unused = aa.f30645a = i + 1;
    }

    private GroupInfoChangeType(GroupInfoChangeType groupInfoChangeType) {
        this.swigValue = groupInfoChangeType.swigValue;
        int unused = aa.f30645a = this.swigValue + 1;
    }

    public static GroupInfoChangeType swigToEnum(int i) {
        GroupInfoChangeType[] groupInfoChangeTypeArr = (GroupInfoChangeType[]) GroupInfoChangeType.class.getEnumConstants();
        if (i < groupInfoChangeTypeArr.length && i >= 0 && groupInfoChangeTypeArr[i].swigValue == i) {
            return groupInfoChangeTypeArr[i];
        }
        for (GroupInfoChangeType groupInfoChangeType : groupInfoChangeTypeArr) {
            if (groupInfoChangeType.swigValue == i) {
                return groupInfoChangeType;
            }
        }
        throw new IllegalArgumentException("No enum " + GroupInfoChangeType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
