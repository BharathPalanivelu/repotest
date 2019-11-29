package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupExtHelper;
import com.tencent.imcore.MemberInfo;
import com.tencent.imcore.SWIGTYPE_p_void;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMGroupMemberInfo;
import java.io.UnsupportedEncodingException;

public class IMGroupExtBridge {
    public static SWIGTYPE_p_void getGrpManagerExt(String str) {
        return GroupExtHelper.getGroupManagerExt(str, new IMCoreGroupAssistantCallback(str));
    }

    public static TIMGroupMemberInfo memberInfoFromInternal(MemberInfo memberInfo) {
        if (memberInfo == null) {
            return null;
        }
        try {
            return IMLiteBridge.memberInfoFromInternal(memberInfo.getMember(), new String(memberInfo.getName_card(), "utf-8"), memberInfo.getJoin_time(), memberInfo.getShutup_time(), memberInfo.getRole(), memberInfo.getCustom_info());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
