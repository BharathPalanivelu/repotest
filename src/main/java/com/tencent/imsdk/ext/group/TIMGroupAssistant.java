package com.tencent.imsdk.ext.group;

import android.text.TextUtils;
import com.tencent.imcore.GroupCacheInfoVec;
import com.tencent.imcore.GroupManagerExt;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMCoreWrapper;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.List;

public class TIMGroupAssistant {
    private static TIMGroupAssistant inst = new TIMGroupAssistant();
    private static final String tag = "imsdk.TIMGroupAssistant";
    private String identifier = "";

    private TIMGroupAssistant() {
    }

    private TIMGroupAssistant(String str) {
        this.identifier = str;
    }

    private GroupManagerExt getGroupManager() {
        return TIMGroupManagerExt.getInstanceById(this.identifier).getGroupManager();
    }

    public static TIMGroupAssistant getInstance() {
        return getInstanceById(IMLiteBridge.getIdentifier(TIMManager.getInstance()));
    }

    public static TIMGroupAssistant getInstanceById(String str) {
        TIMGroupAssistant tIMGroupAssistant = inst;
        if (tIMGroupAssistant == null) {
            inst = new TIMGroupAssistant(str);
        } else {
            tIMGroupAssistant.identifier = str;
        }
        return inst;
    }

    public List<TIMGroupCacheInfo> getGroups(List<String> list) {
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            QLog.e(tag, 1, "sdk not initialized or not logged in.");
            return null;
        }
        StrVec strVec = new StrVec();
        if (!(list == null || list.size() == 0)) {
            for (String next : list) {
                if (TextUtils.isEmpty(next)) {
                    QLog.w(tag, 1, "groupIds contain null or empty object");
                } else {
                    strVec.add(next);
                }
            }
        }
        GroupCacheInfoVec groupCacheInfoVec = new GroupCacheInfoVec();
        if (getGroupManager().getGroups(strVec, groupCacheInfoVec) != 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long size = groupCacheInfoVec.size();
        if (size > 0) {
            for (int i = 0; ((long) i) < size; i++) {
                arrayList.add(new TIMGroupCacheInfo(groupCacheInfoVec.get(i)));
            }
        }
        QLog.d(tag, 1, "getGroupList size: " + size);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public String getIdentifier() {
        return this.identifier;
    }

    /* access modifiers changed from: package-private */
    public void setIdentifier(String str) {
        this.identifier = str;
    }
}
