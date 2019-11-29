package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.BytesCompatUintMap;
import com.tencent.imcore.BytesMap;
import com.tencent.imcore.CompatUint64;
import com.tencent.imcore.FriendGenderType;
import com.tencent.imcore.FriendProfileVec;
import com.tencent.imcore.FriendshipManager;
import com.tencent.imcore.ICallbackWithProfileVec;
import com.tencent.imcore.QrEventType;
import com.tencent.imcore.SetProfileOption;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMFriendshipManager {
    public static final int TIM_PROFILE_FLAG_ALLOW_TYPE = 2;
    public static final int TIM_PROFILE_FLAG_BIRTHDAY = 128;
    public static final int TIM_PROFILE_FLAG_FACE_URL = 4;
    public static final int TIM_PROFILE_FLAG_GENDER = 64;
    public static final int TIM_PROFILE_FLAG_GROUP = 16;
    public static final int TIM_PROFILE_FLAG_LANGUAGE = 512;
    public static final int TIM_PROFILE_FLAG_LEVEL = 1024;
    public static final int TIM_PROFILE_FLAG_LOCATION = 256;
    public static final int TIM_PROFILE_FLAG_NICK = 1;
    public static final int TIM_PROFILE_FLAG_REMARK = 8;
    public static final int TIM_PROFILE_FLAG_ROLE = 2048;
    public static final int TIM_PROFILE_FLAG_SELF_SIGNATURE = 32;
    private static final String tag = "TIMFriendshipManager";
    private String identifier = "";

    public static class ModifyUserProfileParam {
        private TIMFriendAllowType allowType = TIMFriendAllowType.TIM_FRIEND_ALLOW_ANY;
        private long birthday;
        private Map<String, byte[]> customInfo = new HashMap();
        private Map<String, Long> customInfoUint = new HashMap();
        private String faceUrl = "";
        private long flags;
        private TIMFriendGenderType gender = TIMFriendGenderType.Unknow;
        private long language;
        private String location = "";
        private String nickname = "";
        private String selfSignature = "";

        /* access modifiers changed from: protected */
        public SetProfileOption convertTo() {
            SetProfileOption setProfileOption = new SetProfileOption();
            try {
                setProfileOption.setFlag(this.flags);
                setProfileOption.setNick(this.nickname.getBytes("utf-8"));
                setProfileOption.setAdd_option(this.allowType.getType());
                setProfileOption.setFace_url(this.faceUrl.getBytes("utf-8"));
                setProfileOption.setLocation(this.location.getBytes("utf-8"));
                setProfileOption.setSelf_signature(this.selfSignature.getBytes("utf-8"));
                setProfileOption.setBirthday(this.birthday);
                setProfileOption.setLanguage(this.language);
                setProfileOption.setGender(FriendGenderType.swigToEnum((int) this.gender.getValue()));
                BytesMap bytesMap = new BytesMap();
                for (Map.Entry next : this.customInfo.entrySet()) {
                    bytesMap.set(((String) next.getKey()).getBytes("utf-8"), (byte[]) next.getValue());
                }
                setProfileOption.setCustom_info(bytesMap);
                BytesCompatUintMap bytesCompatUintMap = new BytesCompatUintMap();
                for (Map.Entry next2 : this.customInfoUint.entrySet()) {
                    CompatUint64 compatUint64 = new CompatUint64();
                    compatUint64.setValue(((Long) next2.getValue()).longValue());
                    bytesCompatUintMap.set(((String) next2.getKey()).getBytes("utf-8"), compatUint64);
                }
                setProfileOption.setCustom_info_uint(bytesCompatUintMap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return setProfileOption;
        }

        /* access modifiers changed from: package-private */
        public TIMFriendAllowType getAllowType() {
            return this.allowType;
        }

        /* access modifiers changed from: package-private */
        public long getBirthday() {
            return this.birthday;
        }

        /* access modifiers changed from: package-private */
        public Map<String, byte[]> getCustomInfo() {
            return this.customInfo;
        }

        /* access modifiers changed from: package-private */
        public String getFaceUrl() {
            return this.faceUrl;
        }

        /* access modifiers changed from: package-private */
        public TIMFriendGenderType getGender() {
            return this.gender;
        }

        /* access modifiers changed from: package-private */
        public long getLanguage() {
            return this.language;
        }

        /* access modifiers changed from: package-private */
        public String getLocation() {
            return this.location;
        }

        /* access modifiers changed from: package-private */
        public String getNickname() {
            return this.nickname;
        }

        /* access modifiers changed from: package-private */
        public String getSelfSignature() {
            return this.selfSignature;
        }

        public ModifyUserProfileParam setAllowType(TIMFriendAllowType tIMFriendAllowType) {
            if (tIMFriendAllowType == null) {
                return this;
            }
            this.allowType = tIMFriendAllowType;
            this.flags |= 2;
            return this;
        }

        public ModifyUserProfileParam setBirthday(long j) {
            this.birthday = j;
            this.flags |= 128;
            return this;
        }

        public ModifyUserProfileParam setCustomInfo(Map<String, byte[]> map) {
            if (map != null) {
                this.customInfo = map;
            }
            return this;
        }

        public void setCustomInfoUint(Map<String, Long> map) {
            this.customInfoUint = map;
        }

        public ModifyUserProfileParam setFaceUrl(String str) {
            if (str == null) {
                return this;
            }
            this.faceUrl = str;
            this.flags |= 4;
            return this;
        }

        public ModifyUserProfileParam setGender(TIMFriendGenderType tIMFriendGenderType) {
            if (tIMFriendGenderType == null) {
                return this;
            }
            this.gender = tIMFriendGenderType;
            this.flags |= 64;
            return this;
        }

        public ModifyUserProfileParam setLanguage(long j) {
            this.language = j;
            this.flags |= 512;
            return this;
        }

        public ModifyUserProfileParam setLocation(String str) {
            if (str == null) {
                return this;
            }
            this.location = str;
            this.flags |= 256;
            return this;
        }

        public ModifyUserProfileParam setNickname(String str) {
            if (str == null) {
                return this;
            }
            this.nickname = str;
            this.flags |= 1;
            return this;
        }

        public ModifyUserProfileParam setSelfSignature(String str) {
            if (str == null) {
                return this;
            }
            this.selfSignature = str;
            this.flags |= 32;
            return this;
        }
    }

    abstract class aa<T> extends ICallbackWithProfileVec {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<T> f30671a;

        public aa(TIMValueCallBack<T> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30671a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(List<TIMUserProfile> list);

        public void done(FriendProfileVec friendProfileVec) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < friendProfileVec.size(); i++) {
                arrayList.add(new TIMUserProfile(friendProfileVec.get(i)));
            }
            IMMsfCoreProxy.mainHandler.post(new da(this, arrayList));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new db(this, i, str));
            swigTakeOwnership();
        }
    }

    private TIMFriendshipManager(String str) {
        this.identifier = str;
    }

    private FriendshipManager getFriendShipMgr() {
        TIMManager instanceById;
        if (TextUtils.isEmpty(this.identifier)) {
            QLog.w(tag, 1, "TIMFriendshipManager|getFriendShipMgr id is empty");
            instanceById = TIMManager.getInstance();
        } else {
            instanceById = TIMManager.getInstanceById(this.identifier);
        }
        return instanceById.getCoreUser().getFriendshipMgr();
    }

    private String getIdentifier() {
        return this.identifier;
    }

    public static TIMFriendshipManager getInstance() {
        return getInstanceById(TIMManager.getInstance().getIdentifier());
    }

    public static TIMFriendshipManager getInstanceById(String str) {
        return new TIMFriendshipManager(str);
    }

    public void getSelfProfile(TIMValueCallBack<TIMUserProfile> tIMValueCallBack) {
        if (tIMValueCallBack != null && IMFunc.preCheck(false, tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
            getUsersProfile(Collections.singletonList(this.identifier), new cy(this, tIMValueCallBack));
        }
    }

    public void getUsersProfile(List<String> list, TIMValueCallBack<List<TIMUserProfile>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                cz czVar = new cz(this, tIMValueCallBack);
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                getFriendShipMgr().getProfile(strVec, czVar);
            }
        }
    }

    public void modifyProfile(ModifyUserProfileParam modifyUserProfileParam, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(modifyUserProfileParam == null, tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getFriendShipMgr().setProfile(modifyUserProfileParam.convertTo(), new cx(this, tIMCallBack));
            }
        }
    }
}
