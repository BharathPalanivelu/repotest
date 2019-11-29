package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.BytesVec;
import com.tencent.imcore.FriendProfileInfoOpt;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TIMFriendshipSettings {
    private List<String> customTags = new ArrayList();
    private long flags = 65535;

    public void addCustomTag(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<String> list = this.customTags;
            if (list != null) {
                list.add(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void convertTo(FriendProfileInfoOpt friendProfileInfoOpt) {
        friendProfileInfoOpt.setFlags(this.flags);
        BytesVec bytesVec = new BytesVec();
        List<String> list = this.customTags;
        if (list != null) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    try {
                        bytesVec.add(next.getBytes("utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        friendProfileInfoOpt.setUser_custom(bytesVec);
    }

    public void setCustomTags(List<String> list) {
        this.customTags = list;
    }

    public void setFlags(long j) {
        this.flags = j;
    }
}
