package com.tencent.imsdk.ext.group;

import android.text.TextUtils;
import com.tencent.imcore.BytesMap;
import com.tencent.imcore.BytesVec;
import com.tencent.imcore.CommStatus;
import com.tencent.imcore.GroupBaseInfoVec;
import com.tencent.imcore.GroupDetailInfoVec;
import com.tencent.imcore.GroupExtHelper;
import com.tencent.imcore.GroupManagerExt;
import com.tencent.imcore.GroupMemRoleFilter;
import com.tencent.imcore.GroupPendencyResult;
import com.tencent.imcore.ICallbackWithGroupBaseInfoVec;
import com.tencent.imcore.ICallbackWithGroupDetailInfoVec;
import com.tencent.imcore.ICallbackWithGroupPendencyResult;
import com.tencent.imcore.ICallbackWithMemberInfoVec;
import com.tencent.imcore.ICallbackWithMemberResultVec;
import com.tencent.imcore.ICallbackWithNumberGroupsDetail;
import com.tencent.imcore.ICallbackWithSeqMemberInfo;
import com.tencent.imcore.MemberInfoVec;
import com.tencent.imcore.MemberResult;
import com.tencent.imcore.MemberResultVec;
import com.tencent.imcore.ModifyGroupBaseInfoOption;
import com.tencent.imcore.ModifyGroupFlag;
import com.tencent.imcore.ModifyGroupMemberFlag;
import com.tencent.imcore.ModifyGroupMemberInfoOption;
import com.tencent.imcore.NumberGroupsDetail;
import com.tencent.imcore.QrEventType;
import com.tencent.imcore.SeqMemberInfo;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMGroupAddOpt;
import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupMemberRoleType;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMGroupManagerExt {
    private static final String tag = "MSF.C.TIMGroupManager";
    /* access modifiers changed from: private */
    public String identifier = "";

    public static class DeleteMemberParam {
        private String groupId = "";
        private List<String> members = new ArrayList();
        private String reason = "";

        public DeleteMemberParam(String str, List<String> list) {
            this.groupId = str;
            this.members = list;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public List<String> getMembers() {
            return this.members;
        }

        public String getReason() {
            return this.reason;
        }

        /* access modifiers changed from: protected */
        public boolean isValid() {
            if (TextUtils.isEmpty(this.groupId)) {
                return false;
            }
            List<String> list = this.members;
            return list != null && !list.isEmpty();
        }

        public DeleteMemberParam setReason(String str) {
            if (str == null) {
                return this;
            }
            this.reason = str;
            return this;
        }
    }

    public static class ModifyGroupInfoParam {
        private TIMGroupAddOpt addOption = TIMGroupAddOpt.TIM_GROUP_ADD_ANY;
        Map<String, byte[]> customInfo = new HashMap();
        private String faceUrl = "";
        private long flags = 0;
        private String groupId = "";
        private String groupName = "";
        private String introduction = "";
        private boolean isSearchable = true;
        private boolean isSilenceAll = false;
        private boolean isVisable = true;
        private long maxMemberNum = 0;
        private String notification = "";

        public ModifyGroupInfoParam(String str) {
            this.groupId = str;
        }

        /* access modifiers changed from: package-private */
        public ModifyGroupBaseInfoOption convertTo() {
            ModifyGroupBaseInfoOption modifyGroupBaseInfoOption = new ModifyGroupBaseInfoOption();
            try {
                modifyGroupBaseInfoOption.setGroup_id(this.groupId);
                modifyGroupBaseInfoOption.setGroup_name(this.groupName.getBytes("utf-8"));
                modifyGroupBaseInfoOption.setIntroduction(this.introduction.getBytes("utf-8"));
                modifyGroupBaseInfoOption.setNotification(this.notification.getBytes("utf-8"));
                modifyGroupBaseInfoOption.setFace_url(this.faceUrl.getBytes("utf-8"));
                BytesMap bytesMap = new BytesMap();
                for (Map.Entry next : this.customInfo.entrySet()) {
                    bytesMap.set(((String) next.getKey()).getBytes("utf-8"), (byte[]) next.getValue());
                }
                modifyGroupBaseInfoOption.setCustom_info(bytesMap);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            modifyGroupBaseInfoOption.setAdd_option(this.addOption.getValue());
            modifyGroupBaseInfoOption.setMax_member_num(this.maxMemberNum);
            modifyGroupBaseInfoOption.setSearchable(this.isSearchable ? CommStatus.kOpen : CommStatus.kClose);
            modifyGroupBaseInfoOption.setVisible(this.isVisable ? CommStatus.kOpen : CommStatus.kClose);
            modifyGroupBaseInfoOption.setAll_shutup(this.isSilenceAll);
            modifyGroupBaseInfoOption.setFlag(this.flags);
            return modifyGroupBaseInfoOption;
        }

        public TIMGroupAddOpt getAddOption() {
            return this.addOption;
        }

        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        public String getFaceUrl() {
            return this.faceUrl;
        }

        /* access modifiers changed from: package-private */
        public long getFlags() {
            return this.flags;
        }

        public String getGroupName() {
            return this.groupName;
        }

        public String getIntroduction() {
            return this.introduction;
        }

        public long getMaxMemberNum() {
            return this.maxMemberNum;
        }

        public String getNotification() {
            return this.notification;
        }

        public boolean isSearchable() {
            return this.isSearchable;
        }

        public boolean isSilenceAll() {
            return this.isSilenceAll;
        }

        /* access modifiers changed from: package-private */
        public boolean isValid() {
            if (!TextUtils.isEmpty(this.groupId)) {
                return (this.flags & ((long) ModifyGroupFlag.kModifyGroupName.swigValue())) == 0 || !TextUtils.isEmpty(this.groupName);
            }
            return false;
        }

        public boolean isVisable() {
            return this.isVisable;
        }

        public ModifyGroupInfoParam setAddOption(TIMGroupAddOpt tIMGroupAddOpt) {
            if (tIMGroupAddOpt == null) {
                return this;
            }
            this.addOption = tIMGroupAddOpt;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupAddOption.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setCustomInfo(Map<String, byte[]> map) {
            if (map != null && !map.isEmpty()) {
                this.customInfo = map;
            }
            return this;
        }

        public ModifyGroupInfoParam setFaceUrl(String str) {
            if (str == null) {
                return this;
            }
            this.faceUrl = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupFaceUrl.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setGroupName(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.groupName = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupName.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setIntroduction(String str) {
            if (str == null) {
                return this;
            }
            this.introduction = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupIntroduction.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setMaxMemberNum(long j) {
            if (j <= 0) {
                return this;
            }
            this.maxMemberNum = j;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupMaxMmeberNum.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setNotification(String str) {
            if (str == null) {
                return this;
            }
            this.notification = str;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupNotification.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setSearchable(boolean z) {
            this.isSearchable = z;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupSearchable.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setSilenceAll(boolean z) {
            this.isSilenceAll = z;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupAllShutup.swigValue();
            return this;
        }

        public ModifyGroupInfoParam setVisable(boolean z) {
            this.isVisable = z;
            this.flags |= (long) ModifyGroupFlag.kModifyGroupVisible.swigValue();
            return this;
        }
    }

    public static class ModifyMemberInfoParam {
        Map<String, byte[]> customInfo = new HashMap();
        private long flags;
        private String groupId = "";
        private String identifier = "";
        private String nameCard = "";
        private TIMGroupReceiveMessageOpt receiveMessageOpt = TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        private TIMGroupMemberRoleType roleType = TIMGroupMemberRoleType.NotMember;
        private long silence;

        public ModifyMemberInfoParam(String str, String str2) {
            this.groupId = str;
            this.identifier = str2;
        }

        /* access modifiers changed from: package-private */
        public ModifyGroupMemberInfoOption convertTo() {
            ModifyGroupMemberInfoOption modifyGroupMemberInfoOption = new ModifyGroupMemberInfoOption();
            modifyGroupMemberInfoOption.setGroup_id(this.groupId);
            modifyGroupMemberInfoOption.setMember(this.identifier);
            try {
                modifyGroupMemberInfoOption.setName_card(this.nameCard.getBytes("utf-8"));
                BytesMap bytesMap = new BytesMap();
                for (Map.Entry next : this.customInfo.entrySet()) {
                    bytesMap.set(((String) next.getKey()).getBytes("utf-8"), (byte[]) next.getValue());
                }
                modifyGroupMemberInfoOption.setCustom_info(bytesMap);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            modifyGroupMemberInfoOption.setMsg_flag(this.receiveMessageOpt.getValue());
            modifyGroupMemberInfoOption.setRole(this.roleType.getValue());
            modifyGroupMemberInfoOption.setShutup_time(this.silence);
            modifyGroupMemberInfoOption.setFlag(this.flags);
            return modifyGroupMemberInfoOption;
        }

        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        /* access modifiers changed from: package-private */
        public long getFlags() {
            return this.flags;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getIdentifier() {
            return this.identifier;
        }

        public String getNameCard() {
            return this.nameCard;
        }

        public TIMGroupReceiveMessageOpt getReceiveMessageOpt() {
            return this.receiveMessageOpt;
        }

        public TIMGroupMemberRoleType getRoleType() {
            return this.roleType;
        }

        public long getSilence() {
            return this.silence;
        }

        /* access modifiers changed from: package-private */
        public boolean isValid() {
            return !TextUtils.isEmpty(this.groupId) && !TextUtils.isEmpty(this.identifier);
        }

        public ModifyMemberInfoParam setCustomInfo(Map<String, byte[]> map) {
            if (map != null && !map.isEmpty()) {
                this.customInfo = map;
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void setFlags(long j) {
            this.flags = j;
        }

        public ModifyMemberInfoParam setNameCard(String str) {
            if (str == null) {
                return this;
            }
            this.nameCard = str;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberNameCard.swigValue();
            return this;
        }

        public ModifyMemberInfoParam setReceiveMessageOpt(TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt) {
            if (tIMGroupReceiveMessageOpt == null) {
                return this;
            }
            this.receiveMessageOpt = tIMGroupReceiveMessageOpt;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberMsgFlag.swigValue();
            return this;
        }

        public ModifyMemberInfoParam setRoleType(TIMGroupMemberRoleType tIMGroupMemberRoleType) {
            if (!(tIMGroupMemberRoleType == null || tIMGroupMemberRoleType == TIMGroupMemberRoleType.Owner)) {
                this.roleType = tIMGroupMemberRoleType;
                this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberRole.swigValue();
            }
            return this;
        }

        public ModifyMemberInfoParam setSilence(long j) {
            if (j < 0) {
                j = 0;
            }
            this.silence = j;
            this.flags |= (long) ModifyGroupMemberFlag.kModifyGroupMemberShutupTime.swigValue();
            return this;
        }
    }

    abstract class aa extends ICallbackWithGroupDetailInfoVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<List<TIMGroupDetailInfo>> f30883a;

        public aa(TIMValueCallBack<List<TIMGroupDetailInfo>> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30883a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMGroupDetailInfo> list);

        public void done(GroupDetailInfoVec groupDetailInfoVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < groupDetailInfoVec.size(); i++) {
                arrayList.add(new TIMGroupDetailInfo(groupDetailInfoVec.get(i)));
            }
            IMMsfCoreProxy.mainHandler.post(new ax(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new ay(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ab extends ICallbackWithGroupBaseInfoVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<List<TIMGroupBaseInfo>> f30885a;

        public ab(TIMValueCallBack<List<TIMGroupBaseInfo>> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30885a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMGroupBaseInfo> list);

        public final void done(GroupBaseInfoVec groupBaseInfoVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < groupBaseInfoVec.size(); i++) {
                arrayList.add(new TIMGroupBaseInfo(groupBaseInfoVec.get(i)));
            }
            IMMsfCoreProxy.mainHandler.post(new az(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new ba(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ac extends ICallbackWithMemberInfoVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<List<TIMGroupMemberInfo>> f30887a;

        public ac(TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30887a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMGroupMemberInfo> list);

        public void done(MemberInfoVec memberInfoVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < memberInfoVec.size(); i++) {
                TIMGroupMemberInfo memberInfoFromInternal = IMGroupExtBridge.memberInfoFromInternal(memberInfoVec.get(i));
                if (memberInfoFromInternal != null) {
                    arrayList.add(memberInfoFromInternal);
                }
            }
            IMMsfCoreProxy.mainHandler.post(new bb(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bc(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ad extends ICallbackWithMemberResultVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<List<TIMGroupMemberResult>> f30889a;

        public ad(TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30889a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMGroupMemberResult> list);

        public void done(MemberResultVec memberResultVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < memberResultVec.size(); i++) {
                MemberResult memberResult = memberResultVec.get(i);
                TIMGroupMemberResult tIMGroupMemberResult = new TIMGroupMemberResult();
                tIMGroupMemberResult.setUser(memberResult.getUser());
                tIMGroupMemberResult.setResult(memberResult.getStatus());
                arrayList.add(tIMGroupMemberResult);
            }
            IMMsfCoreProxy.mainHandler.post(new bd(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new be(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ae extends ICallbackWithSeqMemberInfo {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMGroupMemberSucc> f30891a;

        public ae(TIMValueCallBack<TIMGroupMemberSucc> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30891a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(TIMGroupMemberSucc tIMGroupMemberSucc);

        public void done(SeqMemberInfo seqMemberInfo) {
            ArrayList arrayList = new ArrayList();
            MemberInfoVec members = seqMemberInfo.getMembers();
            for (int i = 0; ((long) i) < members.size(); i++) {
                TIMGroupMemberInfo memberInfoFromInternal = IMGroupExtBridge.memberInfoFromInternal(members.get(i));
                if (memberInfoFromInternal != null) {
                    arrayList.add(memberInfoFromInternal);
                }
            }
            TIMGroupMemberSucc tIMGroupMemberSucc = new TIMGroupMemberSucc();
            tIMGroupMemberSucc.setNextSeq(seqMemberInfo.getSeq());
            tIMGroupMemberSucc.setMemberInfoList(arrayList);
            IMMsfCoreProxy.mainHandler.post(new bf(this, tIMGroupMemberSucc));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bg(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class af extends ICallbackWithGroupPendencyResult {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMGroupPendencyListGetSucc> f30893a;

        public af(TIMValueCallBack<TIMGroupPendencyListGetSucc> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30893a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(TIMGroupPendencyListGetSucc tIMGroupPendencyListGetSucc);

        public void done(GroupPendencyResult groupPendencyResult) {
            IMMsfCoreProxy.mainHandler.post(new bh(this, new TIMGroupPendencyListGetSucc(TIMGroupManagerExt.this.identifier, groupPendencyResult)));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bi(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ag extends ICallbackWithNumberGroupsDetail {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMGroupSearchSucc> f30895a;

        public ag(TIMValueCallBack<TIMGroupSearchSucc> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30895a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(TIMGroupSearchSucc tIMGroupSearchSucc);

        public void done(NumberGroupsDetail numberGroupsDetail) {
            TIMGroupSearchSucc tIMGroupSearchSucc = new TIMGroupSearchSucc();
            if (numberGroupsDetail != null) {
                tIMGroupSearchSucc.totalNum = numberGroupsDetail.getNum();
                tIMGroupSearchSucc.infoList = new ArrayList();
                for (int i = 0; ((long) i) < numberGroupsDetail.getInfos().size(); i++) {
                    tIMGroupSearchSucc.infoList.add(new TIMGroupDetailInfo(numberGroupsDetail.getInfos().get(i)));
                }
            }
            IMMsfCoreProxy.mainHandler.post(new bj(this, tIMGroupSearchSucc));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bk(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ah<T> extends ICallbackWithMemberInfoVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<T> f30897a;

        public ah(TIMValueCallBack<T> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30897a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMGroupSelfInfo> list);

        public void done(MemberInfoVec memberInfoVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < memberInfoVec.size(); i++) {
                arrayList.add(new TIMGroupSelfInfo(memberInfoVec.get(i)));
            }
            IMMsfCoreProxy.mainHandler.post(new bl(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bm(this, i, str));
            swigTakeOwnership();
        }
    }

    private TIMGroupManagerExt(String str) {
        this.identifier = str;
    }

    public static TIMGroupManagerExt getInstance() {
        return getInstanceById(IMLiteBridge.getIdentifier(TIMManager.getInstance()));
    }

    public static TIMGroupManagerExt getInstanceById(String str) {
        return new TIMGroupManagerExt(str);
    }

    public void deleteGroup(String str, TIMCallBack tIMCallBack) {
        if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
            getGroupManager().deleteGroup(str, new ag(this, tIMCallBack));
        }
    }

    public void deleteGroupMember(DeleteMemberParam deleteMemberParam, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(deleteMemberParam == null || !deleteMemberParam.isValid(), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                ao aoVar = new ao(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : deleteMemberParam.getMembers()) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                byte[] bArr = null;
                try {
                    bArr = deleteMemberParam.getReason().getBytes("utf-8");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                getGroupManager().deleteGroupMember(deleteMemberParam.getGroupId(), strVec, aoVar, bArr);
            }
        }
    }

    public void getGroupDetailInfo(List<String> list, TIMValueCallBack<List<TIMGroupDetailInfo>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                at atVar = new at(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getGroupManager().getGroupBaseInfo(strVec, atVar);
            }
        }
    }

    public void getGroupList(TIMValueCallBack<List<TIMGroupBaseInfo>> tIMValueCallBack) {
        if (tIMValueCallBack != null && IMFunc.preCheck(false, tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
            getGroupManager().getGroupList(false, new aq(this, tIMValueCallBack));
        }
    }

    /* access modifiers changed from: protected */
    public GroupManagerExt getGroupManager() {
        if (TextUtils.isEmpty(this.identifier)) {
            this.identifier = IMLiteBridge.getIdentifier(TIMManager.getInstance());
        }
        return GroupExtHelper.getGroupManagerExt(this.identifier);
    }

    public void getGroupMembers(String str, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getGroupManager().getGroupMembers(str, new ai(this, tIMValueCallBack));
            }
        }
    }

    public void getGroupMembersByFilter(String str, long j, TIMGroupMemberRoleFilter tIMGroupMemberRoleFilter, List<String> list, long j2, TIMValueCallBack<TIMGroupMemberSucc> tIMValueCallBack) {
        TIMGroupMemberRoleFilter tIMGroupMemberRoleFilter2 = tIMGroupMemberRoleFilter;
        TIMValueCallBack<TIMGroupMemberSucc> tIMValueCallBack2 = tIMValueCallBack;
        if (tIMValueCallBack2 != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str) || tIMGroupMemberRoleFilter2 == null, tIMValueCallBack2, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                ak akVar = new ak(this, tIMValueCallBack2);
                BytesVec bytesVec = new BytesVec();
                if (list != null) {
                    for (String bytes : list) {
                        try {
                            bytesVec.add(bytes.getBytes("utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                GroupMemRoleFilter groupMemRoleFilter = GroupMemRoleFilter.kGroupMemberAll;
                if (tIMGroupMemberRoleFilter2 == TIMGroupMemberRoleFilter.Owner) {
                    groupMemRoleFilter = GroupMemRoleFilter.kGroupMemRoleOwner;
                } else if (tIMGroupMemberRoleFilter2 == TIMGroupMemberRoleFilter.Admin) {
                    groupMemRoleFilter = GroupMemRoleFilter.kGroupMemRoleAdmin;
                } else if (tIMGroupMemberRoleFilter2 == TIMGroupMemberRoleFilter.Normal) {
                    groupMemRoleFilter = GroupMemRoleFilter.kGroupMemRoleCommon_member;
                }
                getGroupManager().getGroupMembersByFilter(str, j, groupMemRoleFilter, bytesVec, j2, akVar);
            }
        }
    }

    public void getGroupMembersInfo(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberInfo>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str) || list == null || list.isEmpty(), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                aj ajVar = new aj(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getGroupManager().getGroupMembersInfo(str, strVec, ajVar);
            }
        }
    }

    public void getGroupPendencyList(TIMGroupPendencyGetParam tIMGroupPendencyGetParam, TIMValueCallBack<TIMGroupPendencyListGetSucc> tIMValueCallBack) {
        if (IMFunc.preCheck(tIMGroupPendencyGetParam == null, tIMValueCallBack, new QualityReportHelper()) == 0) {
            getGroupManager().getPendency(tIMGroupPendencyGetParam.convertTo(), new am(this, tIMValueCallBack));
        }
    }

    public void getGroupPublicInfo(List<String> list, TIMValueCallBack<List<TIMGroupDetailInfo>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                aw awVar = new aw(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getGroupManager().getGroupPublicInfo(strVec, awVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getIdentifier() {
        return this.identifier;
    }

    public void getSelfInfo(String str, TIMValueCallBack<TIMGroupSelfInfo> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMValueCallBack, new QualityReportHelper()) == 0) {
                getGroupManager().getSelfInfo(str, new al(this, tIMValueCallBack));
            }
        }
    }

    public void inviteGroupMember(String str, List<String> list, TIMValueCallBack<List<TIMGroupMemberResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str) || list == null || list.isEmpty(), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                ap apVar = new ap(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getGroupManager().inviteGroupMember(str, strVec, apVar);
            }
        }
    }

    public void modifyGroupInfo(ModifyGroupInfoParam modifyGroupInfoParam, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(modifyGroupInfoParam == null || !modifyGroupInfoParam.isValid(), tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getGroupManager().modifyGroupBaseInfo(modifyGroupInfoParam.convertTo(), new ar(this, tIMCallBack));
            }
        }
    }

    public void modifyGroupOwner(String str, String str2, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2), tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getGroupManager().modifyGroupOwner(str, str2, new as(this, tIMCallBack));
            }
        }
    }

    public void modifyMemberInfo(ModifyMemberInfoParam modifyMemberInfoParam, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(!modifyMemberInfoParam.isValid(), tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getGroupManager().modifyGroupMemberInfo(modifyMemberInfoParam.convertTo(), new ah(this, tIMCallBack));
            }
        }
    }

    public void reportGroupPendency(long j, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null && IMFunc.preCheck(false, tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
            getGroupManager().pendencyReport(j, new an(this, tIMCallBack));
        }
    }

    public void searchGroup(String str, long j, List<String> list, int i, int i2, TIMValueCallBack<TIMGroupSearchSucc> tIMValueCallBack) {
        TIMValueCallBack<TIMGroupSearchSucc> tIMValueCallBack2 = tIMValueCallBack;
        if (tIMValueCallBack2 != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMValueCallBack2, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                au auVar = new au(this, tIMValueCallBack2);
                BytesVec bytesVec = new BytesVec();
                if (list != null) {
                    for (String bytes : list) {
                        try {
                            bytesVec.add(bytes.getBytes("utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                getGroupManager().searchGroupByName(str, j, bytesVec, (long) i, (long) i2, auVar);
            }
        }
    }
}
