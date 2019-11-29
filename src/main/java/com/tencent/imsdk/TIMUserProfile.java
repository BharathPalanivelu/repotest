package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.BytesCompatUintMap;
import com.tencent.imcore.BytesMap;
import com.tencent.imcore.FriendProfile;
import com.tencent.imcore.MapParserBB;
import com.tencent.imcore.MapParserBCompatUint;
import com.tencent.imcore.VecParserB;
import com.tencent.imsdk.log.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMUserProfile {
    private String allowType = "";
    private long birthday = 0;
    private Map<String, byte[]> customInfo = new HashMap();
    private Map<String, Long> customInfoUint = new HashMap();
    private String faceUrl = "";
    private long gender = 0;
    private List<String> groupNames = new ArrayList();
    private String identifier = "";
    private long language = 0;
    private long level = 0;
    private String location = "";
    private String nickName = "";
    private String remark = "";
    private long role = 0;
    private String selfSignature = "";

    protected TIMUserProfile() {
    }

    protected TIMUserProfile(FriendProfile friendProfile) {
        if (friendProfile != null) {
            this.identifier = friendProfile.getSIdentifier();
            this.allowType = friendProfile.getSAllowType();
            try {
                this.nickName = new String(friendProfile.getSNickname(), "utf-8");
                this.remark = new String(friendProfile.getSRemark(), "utf-8");
                this.faceUrl = new String(friendProfile.getSFaceURL(), "utf-8");
                this.selfSignature = new String(friendProfile.getSSelfSignature(), "utf-8");
                this.gender = (long) friendProfile.getEGender().swigValue();
                this.birthday = friendProfile.getUBirthDay();
                this.language = friendProfile.getULanguage();
                this.location = new String(friendProfile.getSLocation(), "utf-8");
                this.level = friendProfile.getULevel();
                this.role = friendProfile.getURole();
                int size = (int) friendProfile.getSGroupNames().size();
                if (size > 0) {
                    VecParserB vecParserB = new VecParserB(friendProfile.getSGroupNames());
                    this.groupNames.clear();
                    for (int i = 0; i < size; i++) {
                        this.groupNames.add(new String(vecParserB.get(i), "utf-8"));
                    }
                }
                BytesMap custom_info = friendProfile.getCustom_info();
                if (!custom_info.empty()) {
                    MapParserBB mapParserBB = new MapParserBB();
                    mapParserBB.fetchMapKeys(custom_info);
                    for (int i2 = 0; ((long) i2) < custom_info.size(); i2++) {
                        try {
                            getCustomInfo().put(new String(mapParserBB.getKey(i2), "utf-8"), mapParserBB.getValue(custom_info, i2));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                BytesCompatUintMap custom_info_uint = friendProfile.getCustom_info_uint();
                if (!custom_info_uint.empty()) {
                    MapParserBCompatUint mapParserBCompatUint = new MapParserBCompatUint();
                    mapParserBCompatUint.fetchMapKeys(custom_info_uint);
                    for (int i3 = 0; ((long) i3) < custom_info_uint.size(); i3++) {
                        try {
                            getCustomInfoUint().put(new String(mapParserBCompatUint.getKey(i3), "utf-8"), Long.valueOf(mapParserBCompatUint.getValue(custom_info_uint, i3).getValue()));
                        } catch (UnsupportedEncodingException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
    }

    public TIMFriendAllowType getAllowType() {
        QLog.e("TIMUserProfile", 1, "allowType " + this.allowType);
        return this.allowType.equals(TIMFriendAllowType.TIM_FRIEND_ALLOW_ANY.getType()) ? TIMFriendAllowType.TIM_FRIEND_ALLOW_ANY : this.allowType.equals(TIMFriendAllowType.TIM_FRIEND_DENY_ANY.getType()) ? TIMFriendAllowType.TIM_FRIEND_DENY_ANY : this.allowType.equals(TIMFriendAllowType.TIM_FRIEND_NEED_CONFIRM.getType()) ? TIMFriendAllowType.TIM_FRIEND_NEED_CONFIRM : TIMFriendAllowType.TIM_FRIEND_INVALID;
    }

    public long getBirthday() {
        return this.birthday;
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    public Map<String, Long> getCustomInfoUint() {
        return this.customInfoUint;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public List<String> getFriendGroups() {
        return this.groupNames;
    }

    public TIMFriendGenderType getGender() {
        for (TIMFriendGenderType tIMFriendGenderType : TIMFriendGenderType.values()) {
            if (tIMFriendGenderType.getValue() == this.gender) {
                return tIMFriendGenderType;
            }
        }
        return TIMFriendGenderType.Unknow;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public long getLanguage() {
        return this.language;
    }

    public long getLevel() {
        return this.level;
    }

    public String getLocation() {
        return this.location;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRemark() {
        return this.remark;
    }

    public long getRole() {
        return this.role;
    }

    public String getSelfSignature() {
        return this.selfSignature;
    }

    /* access modifiers changed from: package-private */
    public void setBirthday(long j) {
        this.birthday = j;
    }

    /* access modifiers changed from: package-private */
    public void setGender(long j) {
        this.gender = j;
    }

    /* access modifiers changed from: package-private */
    public void setLanguage(long j) {
        this.language = j;
    }

    public void setLevel(long j) {
        this.level = j;
    }

    /* access modifiers changed from: package-private */
    public void setLocation(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.location = str;
        }
    }

    public void setRole(long j) {
        this.role = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TIMUserProfile{\n\t\tidentifier='");
        sb.append(getIdentifier());
        sb.append("',\n\t\tnickName='");
        sb.append(getNickName());
        sb.append("',\n\t\tallowType='");
        sb.append(getAllowType());
        sb.append("',\n\t\tremark='");
        sb.append(getRemark());
        sb.append("',\n\t\tfaceUrl='");
        sb.append(getFaceUrl());
        sb.append("',\n\t\tselfSignature='");
        sb.append(getSelfSignature());
        sb.append("',\n\t\tnickName='");
        sb.append(getNickName());
        sb.append("',\n\t\tlevel='");
        sb.append(getLevel());
        sb.append("',\n\t\trole='");
        sb.append(getRole());
        sb.append("',\n");
        if (!getCustomInfo().isEmpty()) {
            for (Map.Entry next : getCustomInfo().entrySet()) {
                sb.append("\t\t");
                sb.append((String) next.getKey());
                sb.append("='");
                sb.append(new String((byte[]) next.getValue()));
                sb.append("',\n");
            }
        }
        if (!getCustomInfoUint().isEmpty()) {
            for (Map.Entry next2 : getCustomInfoUint().entrySet()) {
                sb.append("\t\t");
                sb.append((String) next2.getKey());
                sb.append("='");
                sb.append(next2.getValue());
                sb.append("',\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
