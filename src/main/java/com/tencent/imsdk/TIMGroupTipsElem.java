package com.tencent.imsdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMGroupTipsElem extends TIMElem {
    private static final String TAG = "TIMGroupTipsElem";
    private Map<String, TIMGroupMemberInfo> changedGroupMemberInfo;
    private Map<String, TIMUserProfile> changedUserInfo;
    private String groupId;
    private List<TIMGroupTipsElemGroupInfo> groupInfoList;
    private String groupName;
    private List<TIMGroupTipsElemMemberInfo> memberInfoList;
    private long memberNum;
    private TIMGroupMemberInfo opGroupMemberInfo;
    private String opUser;
    private TIMUserProfile opUserInfo;
    private String platform;
    private TIMGroupTipsType tipsType;
    private List<String> userList;

    public TIMGroupTipsElem() {
        this.opUser = "";
        this.userList = new ArrayList();
        this.groupName = "";
        this.groupId = "";
        this.memberNum = 0;
        this.groupInfoList = new ArrayList();
        this.memberInfoList = new ArrayList();
        this.changedUserInfo = new HashMap();
        this.changedGroupMemberInfo = new HashMap();
        this.platform = "";
        this.type = TIMElemType.GroupTips;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0144 A[LOOP:2: B:36:0x0137->B:38:0x0144, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0188 A[LOOP:3: B:40:0x017b->B:42:0x0188, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01bc A[LOOP:4: B:44:0x01af->B:46:0x01bc, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    TIMGroupTipsElem(com.tencent.imcore.GroupTipsElem r13) {
        /*
            r12 = this;
            r12.<init>()
            java.lang.String r0 = ""
            r12.opUser = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r12.userList = r1
            r12.groupName = r0
            r12.groupId = r0
            r1 = 0
            r12.memberNum = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r12.groupInfoList = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r12.memberInfoList = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r12.changedUserInfo = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r12.changedGroupMemberInfo = r1
            r12.platform = r0
            com.tencent.imsdk.TIMElemType r1 = com.tencent.imsdk.TIMElemType.GroupTips
            r12.type = r1
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.Join
            int r2 = r13.getType()
            java.lang.String r3 = "utf-8"
            r4 = 0
            r5 = 1
            switch(r2) {
                case 1: goto L_0x00df;
                case 2: goto L_0x00dc;
                case 3: goto L_0x00d9;
                case 4: goto L_0x00d6;
                case 5: goto L_0x00d3;
                case 6: goto L_0x007c;
                case 7: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x00e7
        L_0x0047:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.ModifyMemberInfo
            com.tencent.imcore.GroupTipsElem_MemberInfoVec r2 = r13.getMember_change_list()
            r6 = 0
        L_0x004e:
            long r7 = (long) r6
            long r9 = r2.size()
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x00e7
            com.tencent.imsdk.TIMGroupTipsElemMemberInfo r7 = new com.tencent.imsdk.TIMGroupTipsElemMemberInfo
            r7.<init>()
            com.tencent.imcore.GroupTipsElem_MemberInfo r8 = r2.get(r6)
            java.lang.String r8 = r8.getIdentifier()
            r7.setIdentifier(r8)
            com.tencent.imcore.GroupTipsElem_MemberInfo r8 = r2.get(r6)
            long r8 = r8.getShutup_time()
            r7.setShutupTime(r8)
            java.util.List r8 = r12.getMemberInfoList()
            r8.add(r7)
            int r6 = r6 + 1
            goto L_0x004e
        L_0x007c:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.ModifyGroupInfo
            com.tencent.imcore.GroupTipsElem_GroupInfoVec r2 = r13.getGroup_change_list()
            r6 = 0
        L_0x0083:
            long r7 = (long) r6
            long r9 = r2.size()
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x00e7
            com.tencent.imsdk.TIMGroupTipsElemGroupInfo r7 = new com.tencent.imsdk.TIMGroupTipsElemGroupInfo
            r7.<init>()
            com.tencent.imcore.GroupTipsElem_GroupInfo r8 = r2.get(r6)
            com.tencent.imcore.GroupInfoChangeType r8 = r8.getType()
            int r8 = r8.swigValue()
            r7.setType(r8)
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x00b1 }
            com.tencent.imcore.GroupTipsElem_GroupInfo r9 = r2.get(r6)     // Catch:{ Throwable -> 0x00b1 }
            byte[] r9 = r9.getValue()     // Catch:{ Throwable -> 0x00b1 }
            r8.<init>(r9, r3)     // Catch:{ Throwable -> 0x00b1 }
            r7.setContent(r8)     // Catch:{ Throwable -> 0x00b1 }
            goto L_0x00c9
        L_0x00b1:
            r8 = move-exception
            java.lang.String r9 = TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "content error, "
            r10.<init>(r11)
            java.lang.String r8 = com.tencent.imsdk.log.QLog.getStackTraceString(r8)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.tencent.imsdk.log.QLog.e(r9, r5, r8)
        L_0x00c9:
            java.util.List r8 = r12.getGroupInfoList()
            r8.add(r7)
            int r6 = r6 + 1
            goto L_0x0083
        L_0x00d3:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.CancelAdmin
            goto L_0x00e7
        L_0x00d6:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.SetAdmin
            goto L_0x00e7
        L_0x00d9:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.Kick
            goto L_0x00e1
        L_0x00dc:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.Quit
            goto L_0x00e1
        L_0x00df:
            com.tencent.imsdk.TIMGroupTipsType r1 = com.tencent.imsdk.TIMGroupTipsType.Join
        L_0x00e1:
            long r6 = r13.getMember_num()
            r12.memberNum = r6
        L_0x00e7:
            java.lang.String r2 = r13.getOp_user()
            r12.setOpUser(r2)
            r12.setTipsType(r1)
            java.lang.String r1 = new java.lang.String     // Catch:{ Throwable -> 0x0113 }
            byte[] r2 = r13.getGroup_name()     // Catch:{ Throwable -> 0x0113 }
            r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x0113 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0110 }
            byte[] r6 = r13.getGroup_id()     // Catch:{ Throwable -> 0x0110 }
            r2.<init>(r6, r3)     // Catch:{ Throwable -> 0x0110 }
            java.lang.String r6 = new java.lang.String     // Catch:{ Throwable -> 0x010e }
            byte[] r7 = r13.getPlatform()     // Catch:{ Throwable -> 0x010e }
            r6.<init>(r7, r3)     // Catch:{ Throwable -> 0x010e }
            r0 = r6
            goto L_0x012d
        L_0x010e:
            r3 = move-exception
            goto L_0x0116
        L_0x0110:
            r3 = move-exception
            r2 = r0
            goto L_0x0116
        L_0x0113:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x0116:
            java.lang.String r6 = TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "name, id, or platform error, "
            r7.<init>(r8)
            java.lang.String r3 = com.tencent.imsdk.log.QLog.getStackTraceString(r3)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            com.tencent.imsdk.log.QLog.e(r6, r5, r3)
        L_0x012d:
            r12.setGroupName(r1)
            r12.setGroupId(r2)
            r12.setPlatform(r0)
            r0 = 0
        L_0x0137:
            long r1 = (long) r0
            com.tencent.imcore.StrVec r3 = r13.getUser_list()
            long r5 = r3.size()
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0156
            java.util.List r1 = r12.getUserList()
            com.tencent.imcore.StrVec r2 = r13.getUser_list()
            java.lang.String r2 = r2.get(r0)
            r1.add(r2)
            int r0 = r0 + 1
            goto L_0x0137
        L_0x0156:
            com.tencent.imsdk.TIMUserProfile r0 = new com.tencent.imsdk.TIMUserProfile
            com.tencent.imcore.FriendProfile r1 = r13.getOp_user_info()
            r0.<init>(r1)
            r12.setOpUserInfo(r0)
            com.tencent.imsdk.TIMGroupMemberInfo r0 = new com.tencent.imsdk.TIMGroupMemberInfo
            com.tencent.imcore.GroupTipsMemberInfo r1 = r13.getOp_group_member_info()
            r0.<init>((com.tencent.imcore.GroupTipsMemberInfo) r1)
            r12.setOpGroupMemberInfo(r0)
            com.tencent.imcore.MapParserStringProfile r0 = new com.tencent.imcore.MapParserStringProfile
            r0.<init>()
            com.tencent.imcore.StringProfileMap r1 = r13.getChanged_user_info()
            r0.fetchMapKeys(r1)
            r1 = 0
        L_0x017b:
            long r2 = (long) r1
            com.tencent.imcore.StrVec r5 = r0.getKeys()
            long r5 = r5.size()
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x01a3
            com.tencent.imsdk.TIMUserProfile r2 = new com.tencent.imsdk.TIMUserProfile
            com.tencent.imcore.StringProfileMap r3 = r13.getChanged_user_info()
            com.tencent.imcore.FriendProfile r3 = r0.getValue(r3, r1)
            r2.<init>(r3)
            java.util.Map r3 = r12.getChangedUserInfo()
            java.lang.String r5 = r2.getIdentifier()
            r3.put(r5, r2)
            int r1 = r1 + 1
            goto L_0x017b
        L_0x01a3:
            com.tencent.imcore.MapParserStringMemberInfo r0 = new com.tencent.imcore.MapParserStringMemberInfo
            r0.<init>()
            com.tencent.imcore.StringGroupTipsMemberInfoMap r1 = r13.getChanged_group_member_info()
            r0.fetchMapKeys(r1)
        L_0x01af:
            long r1 = (long) r4
            com.tencent.imcore.StrVec r3 = r0.getKeys()
            long r5 = r3.size()
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x01d7
            com.tencent.imsdk.TIMGroupMemberInfo r1 = new com.tencent.imsdk.TIMGroupMemberInfo
            com.tencent.imcore.StringGroupTipsMemberInfoMap r2 = r13.getChanged_group_member_info()
            com.tencent.imcore.GroupTipsMemberInfo r2 = r0.getValue(r2, r4)
            r1.<init>((com.tencent.imcore.GroupTipsMemberInfo) r2)
            java.util.Map r2 = r12.getChangedGroupMemberInfo()
            java.lang.String r3 = r1.getUser()
            r2.put(r3, r1)
            int r4 = r4 + 1
            goto L_0x01af
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.TIMGroupTipsElem.<init>(com.tencent.imcore.GroupTipsElem):void");
    }

    public Map<String, TIMGroupMemberInfo> getChangedGroupMemberInfo() {
        return this.changedGroupMemberInfo;
    }

    public Map<String, TIMUserProfile> getChangedUserInfo() {
        return this.changedUserInfo;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public List<TIMGroupTipsElemGroupInfo> getGroupInfoList() {
        return this.groupInfoList;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<TIMGroupTipsElemMemberInfo> getMemberInfoList() {
        return this.memberInfoList;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    public TIMGroupMemberInfo getOpGroupMemberInfo() {
        return this.opGroupMemberInfo;
    }

    public String getOpUser() {
        return this.opUser;
    }

    public TIMUserProfile getOpUserInfo() {
        return this.opUserInfo;
    }

    public String getPlatform() {
        return this.platform;
    }

    public TIMGroupTipsType getTipsType() {
        return this.tipsType;
    }

    public List<String> getUserList() {
        return this.userList;
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
    public void setMemberNum(long j) {
        this.memberNum = j;
    }

    /* access modifiers changed from: package-private */
    public void setOpGroupMemberInfo(TIMGroupMemberInfo tIMGroupMemberInfo) {
        this.opGroupMemberInfo = tIMGroupMemberInfo;
    }

    /* access modifiers changed from: package-private */
    public void setOpUser(String str) {
        this.opUser = str;
    }

    /* access modifiers changed from: package-private */
    public void setOpUserInfo(TIMUserProfile tIMUserProfile) {
        this.opUserInfo = tIMUserProfile;
    }

    /* access modifiers changed from: package-private */
    public void setPlatform(String str) {
        this.platform = str;
    }

    /* access modifiers changed from: package-private */
    public void setTipsType(TIMGroupTipsType tIMGroupTipsType) {
        this.tipsType = tIMGroupTipsType;
    }
}
