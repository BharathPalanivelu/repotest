package com.tencent.imsdk;

import com.tencent.imcore.SessionType;

public enum TIMConversationType {
    Invalid,
    C2C,
    Group,
    System;

    public static SessionType getType(TIMConversationType tIMConversationType) {
        SessionType sessionType = SessionType.kNull;
        int i = cu.f30847a[tIMConversationType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? sessionType : SessionType.kSystemSessionType : SessionType.kGroup : SessionType.kC2C : SessionType.kNull;
    }

    public static TIMConversationType getType(SessionType sessionType) {
        if (sessionType != SessionType.kNull) {
            if (sessionType == SessionType.kC2C) {
                return C2C;
            }
            if (sessionType == SessionType.kGroup) {
                return Group;
            }
            if (sessionType == SessionType.kSystemSessionType) {
                return System;
            }
        }
        return Invalid;
    }
}
