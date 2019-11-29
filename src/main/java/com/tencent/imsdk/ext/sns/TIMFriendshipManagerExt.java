package com.tencent.imsdk.ext.sns;

import android.text.TextUtils;
import com.tencent.imcore.BytesCompatUintMap;
import com.tencent.imcore.BytesMap;
import com.tencent.imcore.BytesVec;
import com.tencent.imcore.CompatUint64;
import com.tencent.imcore.FriendDeleteType;
import com.tencent.imcore.FriendExtHelper;
import com.tencent.imcore.FriendFutureResult;
import com.tencent.imcore.FriendGroupVec;
import com.tencent.imcore.FriendPendencyResult;
import com.tencent.imcore.FriendProfile;
import com.tencent.imcore.FriendProfileVec;
import com.tencent.imcore.FriendshipManagerExt;
import com.tencent.imcore.ICallbackWithFriendGroupVec;
import com.tencent.imcore.ICallbackWithFutureResult;
import com.tencent.imcore.ICallbackWithPendencyResult;
import com.tencent.imcore.ICallbackWithProfileVec;
import com.tencent.imcore.ICallbackWithSearchResult;
import com.tencent.imcore.SNSProfileItem;
import com.tencent.imcore.SNSProfileItemVec;
import com.tencent.imcore.SearchUserResult;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMFriendshipManagerExt {
    public static final int TIM_FUTURE_FRIEND_DECIDE_TYPE = 8;
    public static final int TIM_FUTURE_FRIEND_PENDENCY_IN_TYPE = 1;
    public static final int TIM_FUTURE_FRIEND_PENDENCY_OUT_TYPE = 2;
    public static final int TIM_FUTURE_FRIEND_RECOMMEND_TYPE = 4;
    private static final String tag = "TIMFriendshipManager";
    private String identifier = "";

    public static class DeleteFriendParam {
        private TIMDelFriendType type = TIMDelFriendType.TIM_FRIEND_DEL_BOTH;
        private List<String> users = new ArrayList();

        /* access modifiers changed from: protected */
        public TIMDelFriendType getType() {
            return this.type;
        }

        /* access modifiers changed from: protected */
        public List<String> getUsers() {
            return this.users;
        }

        /* access modifiers changed from: protected */
        public boolean isValid() {
            if (this.type == null) {
                return false;
            }
            List<String> list = this.users;
            return list != null && !list.isEmpty();
        }

        public DeleteFriendParam setType(TIMDelFriendType tIMDelFriendType) {
            if (tIMDelFriendType == null) {
                return this;
            }
            this.type = tIMDelFriendType;
            return this;
        }

        public DeleteFriendParam setUsers(List<String> list) {
            if (list != null && !list.isEmpty()) {
                this.users = list;
            }
            return this;
        }
    }

    public static class ModifySnsProfileParam {
        private Map<String, byte[]> customInfo = new HashMap();
        private Map<String, Long> customInfoUint = new HashMap();
        private String identifier = "";
        private String remark = "";

        public ModifySnsProfileParam(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.identifier = str;
            }
        }

        /* access modifiers changed from: protected */
        public SNSProfileItem convertTo() {
            SNSProfileItem sNSProfileItem = new SNSProfileItem();
            sNSProfileItem.setSIdentifier(this.identifier);
            try {
                BytesMap bytesMap = new BytesMap();
                bytesMap.set("Tag_SNS_IM_Remark".getBytes("utf-8"), this.remark.getBytes("utf-8"));
                for (Map.Entry next : this.customInfo.entrySet()) {
                    bytesMap.set(((String) next.getKey()).getBytes("utf-8"), (byte[]) next.getValue());
                }
                sNSProfileItem.setMpCustom(bytesMap);
                BytesCompatUintMap bytesCompatUintMap = new BytesCompatUintMap();
                for (Map.Entry next2 : this.customInfoUint.entrySet()) {
                    byte[] bytes = ((String) next2.getKey()).getBytes("utf-8");
                    CompatUint64 compatUint64 = new CompatUint64();
                    compatUint64.setValue(((Long) next2.getValue()).longValue());
                    bytesCompatUintMap.set(bytes, compatUint64);
                }
                sNSProfileItem.setMpCustomUint(bytesCompatUintMap);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            return sNSProfileItem;
        }

        /* access modifiers changed from: package-private */
        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        /* access modifiers changed from: package-private */
        public Map<String, Long> getCustomInfoUint() {
            return this.customInfoUint;
        }

        /* access modifiers changed from: package-private */
        public String getIdentifier() {
            return this.identifier;
        }

        /* access modifiers changed from: package-private */
        public String getRemark() {
            return this.remark;
        }

        /* access modifiers changed from: package-private */
        public boolean isValid() {
            return !TextUtils.isEmpty(this.identifier);
        }

        public ModifySnsProfileParam setCustomInfo(Map<String, byte[]> map) {
            if (map != null) {
                this.customInfo = map;
            }
            return this;
        }

        public void setCustomInfoUint(Map<String, Long> map) {
            this.customInfoUint = map;
        }

        public ModifySnsProfileParam setRemark(String str) {
            this.remark = str;
            return this;
        }
    }

    abstract class aa extends ICallbackWithFutureResult {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMGetFriendFutureListSucc> f30999a;

        public aa(TIMValueCallBack<TIMGetFriendFutureListSucc> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30999a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(TIMGetFriendFutureListSucc tIMGetFriendFutureListSucc);

        public void done(FriendFutureResult friendFutureResult) {
            IMMsfCoreProxy.mainHandler.post(new be(this, new TIMGetFriendFutureListSucc(friendFutureResult)));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bf(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ab extends ICallbackWithFriendGroupVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<List<TIMFriendGroup>> f31001a;

        public ab(TIMValueCallBack<List<TIMFriendGroup>> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f31001a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMFriendGroup> list);

        public void done(FriendGroupVec friendGroupVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < friendGroupVec.size(); i++) {
                arrayList.add(new TIMFriendGroup(friendGroupVec.get(i)));
            }
            IMMsfCoreProxy.mainHandler.post(new bg(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bh(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ac extends ICallbackWithPendencyResult {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMGetFriendPendencyListSucc> f31003a;

        public ac(TIMValueCallBack<TIMGetFriendPendencyListSucc> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f31003a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(TIMGetFriendPendencyListSucc tIMGetFriendPendencyListSucc);

        public void done(FriendPendencyResult friendPendencyResult) {
            IMMsfCoreProxy.mainHandler.post(new bi(this, new TIMGetFriendPendencyListSucc(friendPendencyResult)));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bj(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ad<T> extends ICallbackWithProfileVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<T> f31005a;

        public ad(TIMValueCallBack<T> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f31005a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMUserProfile> list);

        public void done(FriendProfileVec friendProfileVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < friendProfileVec.size(); i++) {
                arrayList.add(IMLiteBridge.userProfileFromInternal(friendProfileVec.get(i)));
            }
            IMMsfCoreProxy.mainHandler.post(new bk(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bl(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ae<T> extends ICallbackWithProfileVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<T> f31007a;

        public ae(TIMValueCallBack<T> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f31007a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMFriendResult> list);

        public void done(FriendProfileVec friendProfileVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < friendProfileVec.size(); i++) {
                FriendProfile friendProfile = friendProfileVec.get(i);
                arrayList.add(new TIMFriendResult(friendProfile));
                QLog.d(TIMFriendshipManagerExt.tag, 1, "identifier: " + friendProfile.getSIdentifier() + " status: " + friendProfile.getResult());
            }
            IMMsfCoreProxy.mainHandler.post(new bm(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bn(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class af extends ICallbackWithSearchResult {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMUserSearchSucc> f31009a;

        public af(TIMValueCallBack<TIMUserSearchSucc> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f31009a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(TIMUserSearchSucc tIMUserSearchSucc);

        public void done(SearchUserResult searchUserResult) {
            TIMUserSearchSucc tIMUserSearchSucc = new TIMUserSearchSucc();
            if (searchUserResult != null) {
                QLog.d(TIMFriendshipManagerExt.tag, 1, "totalNum:" + searchUserResult.getTotalNum() + "|vecSize:" + searchUserResult.getFriends().size());
                tIMUserSearchSucc.totalNum = searchUserResult.getTotalNum();
                tIMUserSearchSucc.infoList = new ArrayList();
                FriendProfileVec friends = searchUserResult.getFriends();
                for (int i = 0; ((long) i) < friends.size(); i++) {
                    tIMUserSearchSucc.infoList.add(IMLiteBridge.userProfileFromInternal(friends.get(i)));
                }
            }
            IMMsfCoreProxy.mainHandler.post(new bo(this, tIMUserSearchSucc));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new bp(this, i, str));
            swigTakeOwnership();
        }
    }

    abstract class ag extends ICallbackWithProfileVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMCallBack f31011a;

        public ag(TIMCallBack tIMCallBack) {
            swigReleaseOwnership();
            this.f31011a = tIMCallBack;
        }

        public abstract void a();

        public abstract void a(int i, String str);

        public void done(FriendProfileVec friendProfileVec) {
            IMMsfCoreProxy.mainHandler.post(new bq(this));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new br(this, i, str));
            swigTakeOwnership();
        }
    }

    private TIMFriendshipManagerExt(String str) {
        this.identifier = str;
    }

    private String getIdentifier() {
        return this.identifier;
    }

    public static TIMFriendshipManagerExt getInstance() {
        return getInstanceById(IMLiteBridge.getIdentifier(TIMManager.getInstance()));
    }

    public static TIMFriendshipManagerExt getInstanceById(String str) {
        return new TIMFriendshipManagerExt(str);
    }

    public void addBlackList(List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                bc bcVar = new bc(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().addBlackList(strVec, bcVar);
            }
        }
    }

    public void addFriend(List<TIMAddFriendRequest> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                ay ayVar = new ay(this, tIMValueCallBack);
                FriendProfileVec friendProfileVec = new FriendProfileVec();
                for (TIMAddFriendRequest next : list) {
                    FriendProfile friendProfile = new FriendProfile();
                    friendProfile.setSIdentifier(next.getIdentifier());
                    try {
                        friendProfile.setSRemark(next.getRemark().getBytes("utf-8"));
                        friendProfile.setSAddSource(next.getAddSource().getBytes("utf-8"));
                        friendProfile.setSAddWording(next.getAddWording().getBytes("utf-8"));
                        BytesVec bytesVec = new BytesVec();
                        bytesVec.add(next.getFriendGroup().getBytes("utf-8"));
                        friendProfile.setSGroupNames(bytesVec);
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    friendProfileVec.add(friendProfile);
                }
                getFriendshipMgrExt().addFriend(friendProfileVec, ayVar);
            }
        }
    }

    public void addFriendResponse(TIMFriendAddResponse tIMFriendAddResponse, TIMValueCallBack<TIMFriendResult> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(tIMFriendAddResponse == null, tIMValueCallBack, (QualityReportHelper) null) == 0) {
                az azVar = new az(this, tIMValueCallBack);
                FriendProfileVec friendProfileVec = new FriendProfileVec();
                FriendProfile friendProfile = new FriendProfile();
                friendProfile.setSIdentifier(tIMFriendAddResponse.getIdentifier());
                try {
                    friendProfile.setSRemark(tIMFriendAddResponse.getRemark().getBytes("utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                friendProfile.setSResponseAction(tIMFriendAddResponse.getType().getAction());
                friendProfileVec.add(friendProfile);
                getFriendshipMgrExt().doResponse(friendProfileVec, azVar);
            }
        }
    }

    public void addFriendsToFriendGroup(String str, List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            byte[] bArr = null;
            if (IMFunc.preCheck(str == null || list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        strVec.add(next);
                    }
                }
                try {
                    bArr = str.getBytes("utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                getFriendshipMgrExt().addFriends2Group(bArr, strVec, new aq(this, tIMValueCallBack));
            }
        }
    }

    public void checkFriends(TIMFriendCheckParam tIMFriendCheckParam, TIMValueCallBack<List<TIMFriendCheckResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(tIMFriendCheckParam == null || tIMFriendCheckParam.identifiers == null || tIMFriendCheckParam.identifiers.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : tIMFriendCheckParam.identifiers) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().checkFriend(strVec, tIMFriendCheckParam.isBidirection() ? "CheckResult_Type_Both" : "CheckResult_Type_Singal", new aw(this, tIMValueCallBack));
            }
        }
    }

    public void createFriendGroup(List<String> list, List<String> list2, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list2 == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                BytesVec bytesVec = new BytesVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        try {
                            bytesVec.add(next.getBytes("utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                StrVec strVec = new StrVec();
                for (String next2 : list2) {
                    if (!(next2 == null || next2.length() == 0)) {
                        strVec.add(next2);
                    }
                }
                getFriendshipMgrExt().createFriendGroup(bytesVec, strVec, new an(this, tIMValueCallBack));
            }
        }
    }

    public void delBlackList(List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                bd bdVar = new bd(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().delBlackList(strVec, bdVar);
            }
        }
    }

    public void delFriend(DeleteFriendParam deleteFriendParam, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null && IMFunc.preCheck(!deleteFriendParam.isValid(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
            ba baVar = new ba(this, tIMValueCallBack);
            FriendProfileVec friendProfileVec = new FriendProfileVec();
            for (String next : deleteFriendParam.getUsers()) {
                if (!TextUtils.isEmpty(next)) {
                    FriendProfile friendProfile = new FriendProfile();
                    friendProfile.setSIdentifier(next);
                    friendProfileVec.add(friendProfile);
                }
            }
            getFriendshipMgrExt().delFriend(FriendDeleteType.swigToEnum(deleteFriendParam.getType().ordinal()), friendProfileVec, baVar);
        }
    }

    public void delFriendsFromFriendGroup(String str, List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            byte[] bArr = null;
            if (IMFunc.preCheck(str == null || list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        strVec.add(next);
                    }
                }
                try {
                    bArr = str.getBytes("utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                getFriendshipMgrExt().delFriendsFromGroup(bArr, strVec, new ar(this, tIMValueCallBack));
            }
        }
    }

    public void deleteDecide(List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().deleteDecide(strVec, new am(this, tIMValueCallBack));
            }
        }
    }

    public void deleteFriendGroup(List<String> list, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMCallBack, (QualityReportHelper) null) == 0) {
                BytesVec bytesVec = new BytesVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        try {
                            bytesVec.add(next.getBytes("utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                getFriendshipMgrExt().deleteFriendGroup(bytesVec, new ao(this, tIMCallBack));
            }
        }
    }

    public void deletePendency(TIMPendencyGetType tIMPendencyGetType, List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(tIMPendencyGetType == null || list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().deletePendency(TIMPendencyGetType.getType(tIMPendencyGetType), strVec, new al(this, tIMValueCallBack));
            }
        }
    }

    public void deleteRecommend(List<String> list, TIMValueCallBack<List<TIMFriendResult>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().deleteRecommend(strVec, new ak(this, tIMValueCallBack));
            }
        }
    }

    public void getBlackList(TIMValueCallBack<List<String>> tIMValueCallBack) {
        if (tIMValueCallBack != null && IMFunc.preCheck(false, tIMValueCallBack, (QualityReportHelper) null) == 0) {
            getFriendshipMgrExt().getBlackList(new af(this, tIMValueCallBack));
        }
    }

    public void getFriendGroups(List<String> list, TIMValueCallBack<List<TIMFriendGroup>> tIMValueCallBack) {
        if (tIMValueCallBack != null && IMFunc.preCheck(false, tIMValueCallBack, (QualityReportHelper) null) == 0) {
            BytesVec bytesVec = new BytesVec();
            if (list != null) {
                for (String next : list) {
                    if (!(next == null || next.length() == 0)) {
                        try {
                            bytesVec.add(next.getBytes("utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            getFriendshipMgrExt().getFriendGroup(bytesVec, true, new au(this, tIMValueCallBack));
        }
    }

    public void getFriendList(TIMValueCallBack<List<TIMUserProfile>> tIMValueCallBack) {
        if (tIMValueCallBack != null && IMFunc.preCheck(false, tIMValueCallBack, (QualityReportHelper) null) == 0) {
            getFriendshipMgrExt().getFriendList((ICallbackWithProfileVec) new bb(this, tIMValueCallBack));
        }
    }

    public void getFriendsProfile(List<String> list, TIMValueCallBack<List<TIMUserProfile>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                ax axVar = new ax(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getFriendshipMgrExt().getFriendProfile(strVec, (ICallbackWithProfileVec) axVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public FriendshipManagerExt getFriendshipMgrExt() {
        if (TextUtils.isEmpty(this.identifier)) {
            QLog.w(tag, 1, "TIMFriendshipManager|getFriendshipMgrExt id is empty");
            this.identifier = IMLiteBridge.getIdentifier(TIMManager.getInstance());
        }
        return FriendExtHelper.getFriendshipManagerExt(this.identifier);
    }

    public void getFutureFriends(long j, long j2, List<String> list, TIMFriendFutureMeta tIMFriendFutureMeta, TIMValueCallBack<TIMGetFriendFutureListSucc> tIMValueCallBack) {
        TIMValueCallBack<TIMGetFriendFutureListSucc> tIMValueCallBack2 = tIMValueCallBack;
        if (tIMValueCallBack2 != null) {
            if (IMFunc.preCheck(tIMFriendFutureMeta == null, tIMValueCallBack2, (QualityReportHelper) null) == 0) {
                aj ajVar = new aj(this, tIMValueCallBack2);
                StrVec strVec = new StrVec();
                if (list != null) {
                    for (String next : list) {
                        if (!TextUtils.isEmpty(next)) {
                            strVec.add(next);
                        }
                    }
                }
                getFriendshipMgrExt().getFutureFriends(j, j2, strVec, tIMFriendFutureMeta.getFutureFriendMeta(), ajVar);
            }
        }
    }

    public void getPendencyFromServer(TIMFriendPendencyMeta tIMFriendPendencyMeta, TIMPendencyGetType tIMPendencyGetType, TIMValueCallBack<TIMGetFriendPendencyListSucc> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(tIMFriendPendencyMeta == null || tIMPendencyGetType == null, tIMValueCallBack, (QualityReportHelper) null) == 0) {
                getFriendshipMgrExt().getPendencyFromServer(tIMFriendPendencyMeta.toFriendPendencyMeta(), TIMPendencyGetType.getType(tIMPendencyGetType), new ai(this, tIMValueCallBack));
            }
        }
    }

    public void modifySnsProfile(ModifySnsProfileParam modifySnsProfileParam, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(modifySnsProfileParam == null || !modifySnsProfileParam.isValid(), tIMCallBack, (QualityReportHelper) null) == 0) {
                SNSProfileItemVec sNSProfileItemVec = new SNSProfileItemVec();
                sNSProfileItemVec.add(modifySnsProfileParam.convertTo());
                getFriendshipMgrExt().setSnsProfile(sNSProfileItemVec, new ae(this, tIMCallBack));
            }
        }
    }

    public void pendencyReport(long j, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(j < 0, tIMCallBack, (QualityReportHelper) null) == 0) {
                getFriendshipMgrExt().pendencyReport(j, new ag(this, tIMCallBack));
            }
        }
    }

    public void recommendReport(long j, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(j < 0, tIMCallBack, (QualityReportHelper) null) == 0) {
                getFriendshipMgrExt().recommendReport(j, new ah(this, tIMCallBack));
            }
        }
    }

    public void renameFriendGroupName(String str, String str2, TIMCallBack tIMCallBack) {
        byte[] bArr;
        if (tIMCallBack != null) {
            byte[] bArr2 = null;
            if (IMFunc.preCheck(str == null || str2 == null, tIMCallBack, (QualityReportHelper) null) == 0) {
                at atVar = new at(this, new as(this, tIMCallBack));
                try {
                    bArr = str.getBytes("utf-8");
                    try {
                        bArr2 = str2.getBytes("utf-8");
                    } catch (UnsupportedEncodingException e2) {
                        e = e2;
                        e.printStackTrace();
                        getFriendshipMgrExt().modifyFriendGroupName(bArr, bArr2, atVar);
                    }
                } catch (UnsupportedEncodingException e3) {
                    e = e3;
                    bArr = null;
                    e.printStackTrace();
                    getFriendshipMgrExt().modifyFriendGroupName(bArr, bArr2, atVar);
                }
                getFriendshipMgrExt().modifyFriendGroupName(bArr, bArr2, atVar);
            }
        }
    }

    @Deprecated
    public void searchUserByNickname(String str, long j, long j2, TIMValueCallBack<TIMUserSearchSucc> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(str == null, tIMValueCallBack, (QualityReportHelper) null) == 0) {
                getFriendshipMgrExt().searchFriendsUseNickName(str, j, j2, new ap(this, tIMValueCallBack));
            }
        }
    }
}
