package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.BytesVec;
import com.tencent.imcore.GroupInfoOpt;
import com.tencent.imcore.GroupMemberInfoOpt;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TIMGroupSettings {
    Options groupInfoOptions = new Options(-32769);
    Options memberInfoOptions = new Options(-1);

    public static class Options {
        List<String> customTags = new ArrayList();
        long flags = -2147483648L;

        public Options() {
        }

        protected Options(long j) {
            this.flags = j;
        }

        public void addCustomTag(String str) {
            if (!TextUtils.isEmpty(str)) {
                List<String> list = this.customTags;
                if (list != null) {
                    list.add(str);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Object convertTo(Object obj) {
            BytesVec bytesVec = new BytesVec();
            List<String> list = this.customTags;
            if (list != null) {
                for (String bytes : list) {
                    try {
                        bytesVec.add(bytes.getBytes("utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (obj instanceof GroupInfoOpt) {
                if (this.flags == -2147483648L) {
                    this.flags = -32769;
                }
                GroupInfoOpt groupInfoOpt = (GroupInfoOpt) obj;
                groupInfoOpt.setFlags(this.flags);
                groupInfoOpt.setCustom(bytesVec);
            } else if (obj instanceof GroupMemberInfoOpt) {
                if (this.flags == -2147483648L) {
                    this.flags = -1;
                }
                GroupMemberInfoOpt groupMemberInfoOpt = (GroupMemberInfoOpt) obj;
                groupMemberInfoOpt.setFlags(this.flags);
                groupMemberInfoOpt.setCustom(bytesVec);
            }
            return obj;
        }

        public void setCustomTags(List<String> list) {
            this.customTags = list;
        }

        public void setFlags(long j) {
            this.flags = j;
        }
    }

    public void setGroupInfoOptions(Options options) {
        this.groupInfoOptions = options;
    }

    public void setMemberInfoOptions(Options options) {
        this.memberInfoOptions = options;
    }
}
