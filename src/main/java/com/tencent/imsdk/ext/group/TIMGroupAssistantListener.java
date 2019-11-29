package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.IMBaseListener;
import com.tencent.imsdk.TIMGroupMemberInfo;
import java.util.List;

public interface TIMGroupAssistantListener extends IMBaseListener {
    void onGroupAdd(TIMGroupCacheInfo tIMGroupCacheInfo);

    void onGroupDelete(String str);

    void onGroupUpdate(TIMGroupCacheInfo tIMGroupCacheInfo);

    void onMemberJoin(String str, List<TIMGroupMemberInfo> list);

    void onMemberQuit(String str, List<String> list);

    void onMemberUpdate(String str, List<TIMGroupMemberInfo> list);
}
