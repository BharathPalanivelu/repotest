package com.tencent.imcore;

public enum GroupMemRoleFilter {
    kGroupMemberAll((String) 0),
    kGroupMemRoleOwner((String) 1),
    kGroupMemRoleAdmin((String) 2),
    kGroupMemRoleCommon_member((String) 4);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30646a;

        static /* synthetic */ int a() {
            int i = f30646a;
            f30646a = i + 1;
            return i;
        }
    }

    private GroupMemRoleFilter(int i) {
        this.swigValue = i;
        int unused = aa.f30646a = i + 1;
    }

    private GroupMemRoleFilter(GroupMemRoleFilter groupMemRoleFilter) {
        this.swigValue = groupMemRoleFilter.swigValue;
        int unused = aa.f30646a = this.swigValue + 1;
    }

    public static GroupMemRoleFilter swigToEnum(int i) {
        GroupMemRoleFilter[] groupMemRoleFilterArr = (GroupMemRoleFilter[]) GroupMemRoleFilter.class.getEnumConstants();
        if (i < groupMemRoleFilterArr.length && i >= 0 && groupMemRoleFilterArr[i].swigValue == i) {
            return groupMemRoleFilterArr[i];
        }
        for (GroupMemRoleFilter groupMemRoleFilter : groupMemRoleFilterArr) {
            if (groupMemRoleFilter.swigValue == i) {
                return groupMemRoleFilter;
            }
        }
        throw new IllegalArgumentException("No enum " + GroupMemRoleFilter.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
