package com.tencent.imsdk;

import com.tencent.imcore.BytesMap;
import com.tencent.imcore.Elem;
import com.tencent.imcore.FriendProfile;
import com.tencent.imcore.IMCoreUser;
import com.tencent.imcore.MapParserBB;
import com.tencent.imcore.Session;
import com.tencent.imcore.SessionType;
import com.tencent.imcore.UserConfig;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class IMLiteBridge {
    private static final String TAG = ("imsdk." + IMLiteBridge.class.getSimpleName());

    public static UserConfig UserConfig2Internal(TIMUserConfig tIMUserConfig) {
        return tIMUserConfig.convertTo();
    }

    public static TIMConversation buildConversation(String str) {
        return new TIMConversation(str);
    }

    public static SessionType conversationType2Internal(TIMConversationType tIMConversationType) {
        return TIMConversationType.getType(tIMConversationType);
    }

    public static TIMConversationType conversationTypeFromInternal(SessionType sessionType) {
        return TIMConversationType.getType(sessionType);
    }

    public static Elem elem2Internal(TIMElem tIMElem) {
        return tIMElem.convertTo();
    }

    public static TIMElem elemFromInternal(Elem elem) {
        return TIMElem.convertFrom(elem);
    }

    public static IMCoreUser getCoreUser(TIMManager tIMManager) {
        return tIMManager.getCoreUser();
    }

    public static String getIdentifier(TIMManager tIMManager) {
        return tIMManager.getIdentifier();
    }

    public static Session getSession(TIMConversation tIMConversation) {
        return tIMConversation.getSession();
    }

    public static TIMGroupMemberInfo memberInfoFromInternal(String str, String str2, long j, long j2, long j3, BytesMap bytesMap) {
        TIMGroupMemberInfo tIMGroupMemberInfo = new TIMGroupMemberInfo(str);
        tIMGroupMemberInfo.setNameCard(str2);
        tIMGroupMemberInfo.setRole(j3);
        tIMGroupMemberInfo.setJoinTime(j);
        tIMGroupMemberInfo.setSilenceSeconds(j2);
        HashMap hashMap = new HashMap();
        MapParserBB mapParserBB = new MapParserBB();
        mapParserBB.fetchMapKeys(bytesMap);
        for (int i = 0; ((long) i) < bytesMap.size(); i++) {
            try {
                hashMap.put(new String(mapParserBB.getKey(i), "utf-8"), mapParserBB.getValue(bytesMap, i));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        tIMGroupMemberInfo.setCustomInfo(hashMap);
        return tIMGroupMemberInfo;
    }

    public static void setConversationPeer(TIMConversation tIMConversation, String str) {
        tIMConversation.setPeer(str);
    }

    public static void setConversationType(TIMConversation tIMConversation, TIMConversationType tIMConversationType) {
        tIMConversation.setType(tIMConversationType);
    }

    public static void setCoreUser2Manager(TIMManager tIMManager, IMCoreUser iMCoreUser) {
        tIMManager.setCoreUser(iMCoreUser);
    }

    public static void setIdentifier2TIMManager(TIMManager tIMManager, String str) {
        tIMManager.setIdentifier(str, true);
    }

    public static void setUser2UserConfig(TIMUserConfig tIMUserConfig, TIMUser tIMUser) {
        tIMUserConfig.setUser(tIMUser);
    }

    public static TIMSNSChangeInfo snsChangeInfoFromInternal(String str, String str2, String str3, String str4) {
        TIMSNSChangeInfo tIMSNSChangeInfo = new TIMSNSChangeInfo();
        tIMSNSChangeInfo.setIdentifier(str);
        tIMSNSChangeInfo.setSource(str2);
        tIMSNSChangeInfo.setWording(str3);
        tIMSNSChangeInfo.setNickName(str4);
        return tIMSNSChangeInfo;
    }

    public static TIMUserProfile userProfileFromInternal(FriendProfile friendProfile) {
        return new TIMUserProfile(friendProfile);
    }
}
