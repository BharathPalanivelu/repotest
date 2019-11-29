package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupCacheInfo;
import com.tencent.imcore.IGroupNotify;
import com.tencent.imcore.MemberInfoVec;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMManager;
import java.util.ArrayList;

public class IMCoreGroupAssistantCallback extends IGroupNotify {
    private String identifier;

    public IMCoreGroupAssistantCallback(String str) {
        this.identifier = str;
        swigReleaseOwnership();
    }

    public void onGroupAdd(GroupCacheInfo groupCacheInfo) {
        if (groupCacheInfo != null) {
            TIMGroupAssistantListener groupAssistantListener = new TIMUserConfigGroupExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getGroupAssistantListener();
            if (groupAssistantListener != null) {
                IMMsfCoreProxy.mainHandler.post(new ad(this, groupAssistantListener, new TIMGroupCacheInfo(groupCacheInfo)));
            }
        }
    }

    public void onGroupDelete(String str) {
        if (str != null) {
            TIMGroupAssistantListener groupAssistantListener = new TIMUserConfigGroupExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getGroupAssistantListener();
            if (groupAssistantListener != null) {
                IMMsfCoreProxy.mainHandler.post(new ae(this, groupAssistantListener, str));
            }
        }
    }

    public void onGroupUpdate(GroupCacheInfo groupCacheInfo) {
        if (groupCacheInfo != null) {
            TIMGroupAssistantListener groupAssistantListener = new TIMUserConfigGroupExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getGroupAssistantListener();
            if (groupAssistantListener != null) {
                IMMsfCoreProxy.mainHandler.post(new af(this, groupAssistantListener, new TIMGroupCacheInfo(groupCacheInfo)));
            }
        }
    }

    public void onMemberJoin(String str, MemberInfoVec memberInfoVec) {
        if (str != null && memberInfoVec != null) {
            long size = memberInfoVec.size();
            if (size > 0) {
                TIMGroupAssistantListener groupAssistantListener = new TIMUserConfigGroupExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getGroupAssistantListener();
                if (groupAssistantListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        arrayList.add(IMGroupExtBridge.memberInfoFromInternal(memberInfoVec.get(i)));
                    }
                    IMMsfCoreProxy.mainHandler.post(new aa(this, groupAssistantListener, str, arrayList));
                }
            }
        }
    }

    public void onMemberQuit(String str, StrVec strVec) {
        if (str != null && strVec != null) {
            long size = strVec.size();
            if (size > 0) {
                TIMGroupAssistantListener groupAssistantListener = new TIMUserConfigGroupExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getGroupAssistantListener();
                if (groupAssistantListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        arrayList.add(strVec.get(i));
                    }
                    IMMsfCoreProxy.mainHandler.post(new ab(this, groupAssistantListener, str, arrayList));
                }
            }
        }
    }

    public void onMemberUpdate(String str, MemberInfoVec memberInfoVec) {
        if (str != null && memberInfoVec != null) {
            long size = memberInfoVec.size();
            if (size > 0) {
                TIMGroupAssistantListener groupAssistantListener = new TIMUserConfigGroupExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getGroupAssistantListener();
                if (groupAssistantListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        arrayList.add(IMGroupExtBridge.memberInfoFromInternal(memberInfoVec.get(i)));
                    }
                    IMMsfCoreProxy.mainHandler.post(new ac(this, groupAssistantListener, str, arrayList));
                }
            }
        }
    }
}
