package com.tencent.imsdk.ext.group;

import com.tencent.imcore.BytesMap;
import com.tencent.imcore.MapParserBB;
import com.tencent.imcore.MemberInfo;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class TIMGroupSelfInfo extends TIMGroupMemberInfo {
    private long recvOpt;

    TIMGroupSelfInfo(MemberInfo memberInfo) {
        super(memberInfo.getMember());
        setJoinTime(memberInfo.getJoin_time());
        setRole(memberInfo.getRole());
        setSilenceSeconds(memberInfo.getShutup_time());
        try {
            setNameCard(new String(memberInfo.getName_card(), "utf-8"));
            HashMap hashMap = new HashMap();
            MapParserBB mapParserBB = new MapParserBB();
            BytesMap custom_info = memberInfo.getCustom_info();
            mapParserBB.fetchMapKeys(custom_info);
            for (int i = 0; ((long) i) < custom_info.size(); i++) {
                hashMap.put(new String(mapParserBB.getKey(i), "utf-8"), mapParserBB.getValue(custom_info, i));
            }
            setCustomInfo(hashMap);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        setRecvOpt(memberInfo.getMsg_flag());
    }

    public TIMGroupReceiveMessageOpt getRecvOpt() {
        if (this.recvOpt == TIMGroupReceiveMessageOpt.ReceiveAndNotify.getValue()) {
            return TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        }
        if (this.recvOpt == TIMGroupReceiveMessageOpt.NotReceive.getValue()) {
            return TIMGroupReceiveMessageOpt.NotReceive;
        }
        if (this.recvOpt == TIMGroupReceiveMessageOpt.ReceiveNotNotify.getValue()) {
            return TIMGroupReceiveMessageOpt.ReceiveNotNotify;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setRecvOpt(long j) {
        this.recvOpt = j;
    }
}
