package com.tencent.imsdk.ext.group;

import com.tencent.imcore.CommStatus;
import com.tencent.imcore.GroupDetailInfo;
import com.tencent.imcore.MapParserBB;
import com.tencent.imsdk.TIMGroupAddOpt;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.log.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TIMGroupDetailInfo {
    private static final String tag = "TIMGroupDetailInfo";
    private long createTime;
    private Map<String, byte[]> custom;
    TIMGroupAddOpt groupAddOpt;
    private String groupFaceUrl = "";
    private String groupId = "";
    private String groupIntroduction = "";
    private String groupName = "";
    private String groupNotice = "";
    private String groupOwner = "";
    private String groupType = "";
    private boolean isSilenceAll;
    private long lastInfoTime;
    private TIMMessage lastMsg;
    private long lastMsgTime;
    private long maxMemberNum;
    private long memberNum;
    private long onlineMemberNum;
    private CommStatus searchable = CommStatus.kNotSet;
    private CommStatus visible = CommStatus.kNotSet;

    TIMGroupDetailInfo(GroupDetailInfo groupDetailInfo) {
        this.isSilenceAll = false;
        this.groupAddOpt = TIMGroupAddOpt.TIM_GROUP_ADD_AUTH;
        this.lastMsg = null;
        this.custom = new HashMap();
        if (groupDetailInfo != null) {
            setGroupId(groupDetailInfo.getSGroupId());
            try {
                String str = new String(groupDetailInfo.getSGroupName(), "UTF-8");
                String str2 = new String(groupDetailInfo.getSIntroduction(), "UTF-8");
                String str3 = new String(groupDetailInfo.getSNotification(), "UTF-8");
                setIntroduction(str2);
                setNotice(str3);
                setGroupName(str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            setGroupOwner(groupDetailInfo.getSOwner());
            setFaceUrl(groupDetailInfo.getSFaceUrl());
            setGroupType(groupDetailInfo.getSGroupType());
            setAddOption(groupDetailInfo.getDwAddOption());
            setCreateTime(groupDetailInfo.getDwCreateTime());
            setLastInfoTime(groupDetailInfo.getDwLastInfoTime());
            setLastMsgTime(groupDetailInfo.getDwLastMsgTime());
            setMemberNum(groupDetailInfo.getDwMemberNum());
            setMaxMemberNum(groupDetailInfo.getDwMaxMemberNum());
            setOnlineMemberNum(groupDetailInfo.getDwOnlineMemberNum());
            setLastMsg(new TIMMessage(groupDetailInfo.getLastMsg()));
            setVisible(groupDetailInfo.getEVisible());
            setSearchable(groupDetailInfo.getESearchable());
            setSilenceAll(groupDetailInfo.getBAllShutup());
            int size = (int) groupDetailInfo.getCustom_info().size();
            MapParserBB mapParserBB = new MapParserBB();
            mapParserBB.fetchMapKeys(groupDetailInfo.getCustom_info());
            getCustom().clear();
            for (int i = 0; i < size; i++) {
                try {
                    String str4 = new String(mapParserBB.getKey(i), "utf-8");
                    byte[] value = mapParserBB.getValue(groupDetailInfo.getCustom_info(), i);
                    QLog.i(tag, 1, "custom|" + str4 + "|" + new String(value, "utf-8"));
                    getCustom().put(str4, value);
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public Map<String, byte[]> getCustom() {
        return this.custom;
    }

    public String getFaceUrl() {
        return this.groupFaceUrl;
    }

    public TIMGroupAddOpt getGroupAddOpt() {
        return this.groupAddOpt;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupIntroduction() {
        return this.groupIntroduction;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupNotification() {
        return this.groupNotice;
    }

    public String getGroupOwner() {
        return this.groupOwner;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public long getLastInfoTime() {
        return this.lastInfoTime;
    }

    public TIMMessage getLastMsg() {
        return this.lastMsg;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public long getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    public long getOnlineMemberNum() {
        return this.onlineMemberNum;
    }

    public CommStatus getSearchable() {
        return this.searchable;
    }

    public CommStatus getVisible() {
        return this.visible;
    }

    public boolean isSilenceAll() {
        return this.isSilenceAll;
    }

    /* access modifiers changed from: package-private */
    public void setAddOption(long j) {
        for (TIMGroupAddOpt tIMGroupAddOpt : TIMGroupAddOpt.values()) {
            if (tIMGroupAddOpt.getValue() == j) {
                this.groupAddOpt = tIMGroupAddOpt;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setCreateTime(long j) {
        this.createTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setFaceUrl(String str) {
        this.groupFaceUrl = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupId(String str) {
        this.groupId = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupName(String str) {
        this.groupName = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupOwner(String str) {
        this.groupOwner = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupType(String str) {
        this.groupType = str;
    }

    /* access modifiers changed from: package-private */
    public void setIntroduction(String str) {
        this.groupIntroduction = str;
    }

    /* access modifiers changed from: package-private */
    public void setLastInfoTime(long j) {
        this.lastInfoTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setLastMsg(TIMMessage tIMMessage) {
        this.lastMsg = tIMMessage;
    }

    /* access modifiers changed from: package-private */
    public void setLastMsgTime(long j) {
        this.lastMsgTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setMaxMemberNum(long j) {
        this.maxMemberNum = j;
    }

    /* access modifiers changed from: package-private */
    public void setMemberNum(long j) {
        this.memberNum = j;
    }

    /* access modifiers changed from: package-private */
    public void setNotice(String str) {
        this.groupNotice = str;
    }

    /* access modifiers changed from: package-private */
    public void setOnlineMemberNum(long j) {
        this.onlineMemberNum = j;
    }

    public void setSearchable(CommStatus commStatus) {
        this.searchable = commStatus;
    }

    /* access modifiers changed from: package-private */
    public void setSilenceAll(boolean z) {
        this.isSilenceAll = z;
    }

    /* access modifiers changed from: protected */
    public void setVisible(CommStatus commStatus) {
        this.visible = commStatus;
    }
}
