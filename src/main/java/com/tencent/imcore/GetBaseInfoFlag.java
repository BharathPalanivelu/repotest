package com.tencent.imcore;

import com.facebook.internal.NativeProtocol;
import com.tencent.imsdk.TIMGroupManager;
import tencent.tls.platform.SigType;

public enum GetBaseInfoFlag {
    kGetGroupBaseInfoNone((String) 0),
    kGetGroupBaseInfoName((String) 1),
    kGetGroupBaseInfoCreateTime((String) 2),
    kGetGroupBaseInfoOwnerUin((String) 4),
    kGetGroupBaseInfoSeq((String) 8),
    kGetGroupBaseInfoTime((String) 16),
    kGetGroupBaseInfoNextMsgSeq((String) 32),
    kGetGroupBaseInfoLastMsgTime((String) 64),
    kGetGroupBaseInfoAppId((String) 128),
    kGetGroupBaseInfoMemberNum((String) 256),
    kGetGroupBaseInfoMaxMemberNum((String) 512),
    kGetGroupBaseInfoNotification((String) 1024),
    kGetGroupBaseInfoIntroduction((String) 2048),
    kGetGroupBaseInfoFaceUrl((String) 4096),
    kGetGroupBaseInfoAddOpton((String) 8192),
    kGetGroupBaseInfoGroupType((String) TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE),
    kGetGroupBaseInfoLastMsg((String) TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG),
    kGetGroupBaseInfoOnlineNum((String) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST),
    kGetGroupBaseInfoVisible((String) 131072),
    kGetGroupBaseInfoSearchable((String) SigType.D2),
    kGetGroupBaseInfoAllShupTime((String) 524288);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30643a;

        static /* synthetic */ int a() {
            int i = f30643a;
            f30643a = i + 1;
            return i;
        }
    }

    private GetBaseInfoFlag(int i) {
        this.swigValue = i;
        int unused = aa.f30643a = i + 1;
    }

    private GetBaseInfoFlag(GetBaseInfoFlag getBaseInfoFlag) {
        this.swigValue = getBaseInfoFlag.swigValue;
        int unused = aa.f30643a = this.swigValue + 1;
    }

    public static GetBaseInfoFlag swigToEnum(int i) {
        GetBaseInfoFlag[] getBaseInfoFlagArr = (GetBaseInfoFlag[]) GetBaseInfoFlag.class.getEnumConstants();
        if (i < getBaseInfoFlagArr.length && i >= 0 && getBaseInfoFlagArr[i].swigValue == i) {
            return getBaseInfoFlagArr[i];
        }
        for (GetBaseInfoFlag getBaseInfoFlag : getBaseInfoFlagArr) {
            if (getBaseInfoFlag.swigValue == i) {
                return getBaseInfoFlag;
            }
        }
        throw new IllegalArgumentException("No enum " + GetBaseInfoFlag.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
