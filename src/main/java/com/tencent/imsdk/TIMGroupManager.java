package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.BytesMap;
import com.tencent.imcore.CreateGroupParams;
import com.tencent.imcore.GroupManager;
import com.tencent.imcore.GroupTipsMemberInfo;
import com.tencent.imcore.GroupTipsMemberInfoVec;
import com.tencent.imcore.ICallbackWithString;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMGroupManager {
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_ADD_OPTION = 8192;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_APP_ID = 128;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_CREATE_TIME = 2;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_FACE_URL = 4096;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE = 16384;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_INTRODUCTION = 2048;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG = 32768;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG_TIME = 64;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_MAX_MEMBER_NUM = 512;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_MEMBER_NUM = 256;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_NAME = 1;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_NEXT_MSG_SEQ = 32;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_NOTIFICATION = 1024;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_OWNER_UIN = 4;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_SEQ = 8;
    public static final int TIM_GET_GROUP_BASE_INFO_FLAG_TIME = 16;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_JOIN_TIME = 1;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_MSG_FLAG = 2;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_NAME_CARD = 32;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_ROLE_INFO = 8;
    public static final int TIM_GET_GROUP_MEM_INFO_FLAG_SHUTUP_TIME = 16;
    private static final String tag = "MSF.C.TIMGroupManager";
    private String identifier = "";

    public static class CreateGroupParam {
        TIMGroupAddOpt addOption;
        Map<String, byte[]> customInfo = new HashMap();
        String faceUrl;
        String groupId;
        String groupName;
        String groupType;
        String introduction;
        long maxMemberNum = 0;
        List<TIMGroupMemberInfo> members;
        String notification;

        public CreateGroupParam(String str, String str2) {
            this.groupType = str;
            this.groupName = str2;
        }

        public CreateGroupParam setAddOption(TIMGroupAddOpt tIMGroupAddOpt) {
            this.addOption = tIMGroupAddOpt;
            return this;
        }

        public CreateGroupParam setCustomInfo(String str, byte[] bArr) {
            this.customInfo.put(str, bArr);
            return this;
        }

        public CreateGroupParam setFaceUrl(String str) {
            this.faceUrl = str;
            return this;
        }

        public CreateGroupParam setGroupId(String str) {
            this.groupId = str;
            return this;
        }

        public CreateGroupParam setIntroduction(String str) {
            this.introduction = str;
            return this;
        }

        public CreateGroupParam setMaxMemberNum(long j) {
            this.maxMemberNum = j;
            return this;
        }

        public CreateGroupParam setMembers(List<TIMGroupMemberInfo> list) {
            this.members = list;
            return this;
        }

        public CreateGroupParam setNotification(String str) {
            this.notification = str;
            return this;
        }
    }

    abstract class aa extends ICallbackWithString {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<String> f30673a;

        public aa(TIMValueCallBack<String> tIMValueCallBack) {
            swigReleaseOwnership();
            this.f30673a = tIMValueCallBack;
        }

        public abstract void a(int i, String str);

        public abstract void a(String str);

        public void done(String str) {
            IMMsfCoreProxy.mainHandler.post(new dg(this, str));
            swigTakeOwnership();
        }

        public void fail(int i, String str) {
            IMMsfCoreProxy.mainHandler.post(new dh(this, i, str));
            swigTakeOwnership();
        }
    }

    private TIMGroupManager(String str) {
        this.identifier = str;
    }

    private GroupManager getGroupManager() {
        return (TextUtils.isEmpty(this.identifier) ? TIMManager.getInstance() : TIMManager.getInstanceById(this.identifier)).getCoreUser().getGroupMgr();
    }

    private String getIdentifier() {
        return this.identifier;
    }

    public static TIMGroupManager getInstance() {
        return getInstanceById(TIMManager.getInstance().getIdentifier());
    }

    public static TIMGroupManager getInstanceById(String str) {
        return new TIMGroupManager(str);
    }

    public void applyJoinGroup(String str, String str2, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventJoinGroup.swigValue());
            if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMCallBack, qualityReportHelper) == 0) {
                if (str2 == null) {
                    str2 = "";
                }
                de deVar = new de(this, tIMCallBack, qualityReportHelper);
                QLog.i(tag, 1, "JoinGroup|1-Begin|Succ|group id=" + str);
                getGroupManager().applyJoinGroup(str, str2, deVar);
            }
        }
    }

    public void createGroup(CreateGroupParam createGroupParam, TIMValueCallBack<String> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventCreateGroup.swigValue());
            if (IMFunc.preCheck(createGroupParam == null || TextUtils.isEmpty(createGroupParam.groupType) || TextUtils.isEmpty(createGroupParam.groupName), tIMValueCallBack, qualityReportHelper) == 0) {
                CreateGroupParams createGroupParams = new CreateGroupParams();
                createGroupParams.setGroup_type(createGroupParam.groupType);
                try {
                    createGroupParams.setGroup_name(createGroupParam.groupName.getBytes("utf-8"));
                    if (createGroupParam.groupId != null) {
                        createGroupParams.setGroup_id(createGroupParam.groupId.getBytes("utf-8"));
                    }
                    if (createGroupParam.notification != null) {
                        createGroupParams.setNotification(createGroupParam.notification.getBytes("utf-8"));
                    }
                    if (createGroupParam.introduction != null) {
                        createGroupParams.setIntroduction(createGroupParam.introduction.getBytes("utf-8"));
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (createGroupParam.faceUrl != null) {
                    createGroupParams.setFace_url(createGroupParam.faceUrl);
                }
                if (createGroupParam.addOption != null) {
                    createGroupParams.setSet_add_option(true);
                    createGroupParams.setAdd_option((long) createGroupParam.addOption.ordinal());
                }
                if (createGroupParam.maxMemberNum != 0) {
                    createGroupParams.setMax_member_num(createGroupParam.maxMemberNum);
                }
                if (createGroupParam.customInfo.size() > 0) {
                    BytesMap bytesMap = new BytesMap();
                    for (Map.Entry next : createGroupParam.customInfo.entrySet()) {
                        try {
                            bytesMap.set(((String) next.getKey()).getBytes("utf-8"), (byte[]) next.getValue());
                        } catch (UnsupportedEncodingException e3) {
                            e3.printStackTrace();
                        }
                    }
                    createGroupParams.setCustom_info(bytesMap);
                }
                if (createGroupParam.members != null) {
                    GroupTipsMemberInfoVec groupTipsMemberInfoVec = new GroupTipsMemberInfoVec();
                    for (TIMGroupMemberInfo next2 : createGroupParam.members) {
                        GroupTipsMemberInfo groupTipsMemberInfo = new GroupTipsMemberInfo();
                        groupTipsMemberInfo.setIdentifier(next2.getUser());
                        groupTipsMemberInfo.setMember_role((int) next2.getRole().getValue());
                        if (next2.getCustomInfo().size() > 0) {
                            BytesMap bytesMap2 = new BytesMap();
                            for (Map.Entry next3 : next2.getCustomInfo().entrySet()) {
                                try {
                                    bytesMap2.set(((String) next3.getKey()).getBytes("utf-8"), (byte[]) next3.getValue());
                                } catch (UnsupportedEncodingException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            groupTipsMemberInfo.setCustom_info(bytesMap2);
                        }
                        groupTipsMemberInfoVec.add(groupTipsMemberInfo);
                    }
                    createGroupParams.setGroup_members(groupTipsMemberInfoVec);
                }
                getGroupManager().createGroup(createGroupParams, new dc(this, tIMValueCallBack, qualityReportHelper));
            }
        }
    }

    public void deleteGroup(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getGroupManager().deleteGroup(str, new dd(this, tIMCallBack));
            }
        }
    }

    public void quitGroup(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(TextUtils.isEmpty(str), tIMCallBack, new QualityReportHelper(QrEventType.kEventMax.swigValue())) == 0) {
                getGroupManager().quitGroup(str, new df(this, tIMCallBack));
            }
        }
    }
}
