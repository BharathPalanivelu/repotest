package com.tencent.imsdk;

import com.tencent.imcore.BytesMap;
import com.tencent.imcore.GroupTipsMemberInfo;
import com.tencent.imcore.MapParserBB;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TIMGroupMemberInfo {
    private Map<String, byte[]> custom = new HashMap();
    private long joinTime;
    private String nameCard = "";
    private TIMGroupMemberRoleType role = TIMGroupMemberRoleType.NotMember;
    private long silenceSeconds;
    private String user = "";

    protected TIMGroupMemberInfo(GroupTipsMemberInfo groupTipsMemberInfo) {
        if (groupTipsMemberInfo != null) {
            this.user = groupTipsMemberInfo.getIdentifier();
            setRole((long) groupTipsMemberInfo.getMember_role());
            try {
                setNameCard(new String(groupTipsMemberInfo.getName_card(), "utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            BytesMap custom_info = groupTipsMemberInfo.getCustom_info();
            MapParserBB mapParserBB = new MapParserBB();
            mapParserBB.fetchMapKeys(custom_info);
            for (int i = 0; ((long) i) < custom_info.size(); i++) {
                try {
                    getCustomInfo().put(new String(mapParserBB.getKey(i), "utf-8"), mapParserBB.getValue(custom_info, i));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public TIMGroupMemberInfo(String str) {
        if (str != null) {
            this.user = str;
        }
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.custom;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public TIMGroupMemberRoleType getRole() {
        return this.role;
    }

    public long getSilenceSeconds() {
        return this.silenceSeconds;
    }

    public String getUser() {
        return this.user;
    }

    public TIMGroupMemberInfo setCustomInfo(Map<String, byte[]> map) {
        if (map != null && !map.isEmpty()) {
            this.custom = map;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public TIMGroupMemberInfo setJoinTime(long j) {
        this.joinTime = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public TIMGroupMemberInfo setNameCard(String str) {
        if (str == null) {
            return this;
        }
        this.nameCard = str;
        return this;
    }

    /* access modifiers changed from: protected */
    public TIMGroupMemberInfo setRole(long j) {
        for (TIMGroupMemberRoleType tIMGroupMemberRoleType : TIMGroupMemberRoleType.values()) {
            if (j == tIMGroupMemberRoleType.getValue()) {
                this.role = tIMGroupMemberRoleType;
                return this;
            }
        }
        this.role = TIMGroupMemberRoleType.NotMember;
        return this;
    }

    public TIMGroupMemberInfo setRoleType(TIMGroupMemberRoleType tIMGroupMemberRoleType) {
        if (tIMGroupMemberRoleType != TIMGroupMemberRoleType.Admin) {
            tIMGroupMemberRoleType = TIMGroupMemberRoleType.NotMember;
        }
        this.role = tIMGroupMemberRoleType;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setSilenceSeconds(long j) {
        this.silenceSeconds = j;
    }
}
