package com.salesforce.android.chat.core.internal.model;

import com.salesforce.android.chat.core.internal.liveagent.request.SensitiveDataRuleTriggered;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatRequestSuccessMessage;
import com.salesforce.android.chat.core.model.SensitiveDataRule;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SensitiveDataRuleModel implements SensitiveDataRule {
    @SensitiveDataRule.Action
    private final String mAction;
    private final String mId;
    private final String mName;
    private final Pattern[] mPatterns;
    private final String mReplacement;

    private SensitiveDataRuleModel(String str, String str2, @SensitiveDataRule.Action String str3, String str4, Pattern... patternArr) {
        this.mId = str;
        this.mName = str2;
        this.mAction = str3;
        if (str4 == null) {
            this.mReplacement = "";
        } else {
            this.mReplacement = str4;
        }
        this.mPatterns = patternArr;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public Pattern[] getPatterns() {
        return this.mPatterns;
    }

    @SensitiveDataRule.Action
    public String getAction() {
        return this.mAction;
    }

    public String getReplacement() {
        return this.mReplacement;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r8 = this;
            java.lang.String r0 = r8.mAction
            int r1 = r0.hashCode()
            r2 = -1850743644(0xffffffff91afe4a4, float:-2.7751042E-28)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001d
            r2 = -1535817068(0xffffffffa4754a94, float:-5.3189077E-17)
            if (r1 == r2) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            java.lang.String r1 = "Replace"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 0
            goto L_0x0028
        L_0x001d:
            java.lang.String r1 = "Remove"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = -1
        L_0x0028:
            r1 = 5
            r2 = 3
            r5 = 2
            r6 = 4
            if (r0 == 0) goto L_0x0076
            if (r0 == r4) goto L_0x0051
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.Class<com.salesforce.android.chat.core.model.SensitiveDataRule> r1 = com.salesforce.android.chat.core.model.SensitiveDataRule.class
            java.lang.String r1 = r1.getSimpleName()
            r0[r3] = r1
            java.lang.String r1 = r8.mId
            r0[r4] = r1
            java.lang.String r1 = r8.mName
            r0[r5] = r1
            java.util.regex.Pattern[] r1 = r8.mPatterns
            java.lang.String r1 = java.util.Arrays.toString(r1)
            r0[r2] = r1
            java.lang.String r1 = "%s[id=%s, name=%s, action=UNKNOWN, pattern=%s]"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            return r0
        L_0x0051:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.Class<com.salesforce.android.chat.core.model.SensitiveDataRule> r1 = com.salesforce.android.chat.core.model.SensitiveDataRule.class
            java.lang.String r1 = r1.getSimpleName()
            r0[r3] = r1
            java.lang.String r1 = r8.mId
            r0[r4] = r1
            java.lang.String r1 = r8.mName
            r0[r5] = r1
            java.lang.String r1 = r8.mAction
            r0[r2] = r1
            java.util.regex.Pattern[] r1 = r8.mPatterns
            java.lang.String r1 = java.util.Arrays.toString(r1)
            r0[r6] = r1
            java.lang.String r1 = "%s[id=%s, name=%s, action=%s, pattern=%s]"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            return r0
        L_0x0076:
            r0 = 6
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Class<com.salesforce.android.chat.core.model.SensitiveDataRule> r7 = com.salesforce.android.chat.core.model.SensitiveDataRule.class
            java.lang.String r7 = r7.getSimpleName()
            r0[r3] = r7
            java.lang.String r3 = r8.mId
            r0[r4] = r3
            java.lang.String r3 = r8.mName
            r0[r5] = r3
            java.lang.String r3 = r8.mAction
            r0[r2] = r3
            java.lang.String r2 = r8.mReplacement
            r0[r6] = r2
            java.util.regex.Pattern[] r2 = r8.mPatterns
            java.lang.String r2 = java.util.Arrays.toString(r2)
            r0[r1] = r2
            java.lang.String r1 = "%s[id=%s, name=%s, action=%s, replacement=%s, patterns=%s]"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.model.SensitiveDataRuleModel.toString():java.lang.String");
    }

    public static SensitiveDataRuleTriggered.TriggeredSensitiveDataRule[] toTriggered(SensitiveDataRule... sensitiveDataRuleArr) {
        ArrayList arrayList = new ArrayList();
        for (SensitiveDataRule sensitiveDataRule : sensitiveDataRuleArr) {
            arrayList.add(new SensitiveDataRuleTriggered.TriggeredSensitiveDataRule(sensitiveDataRule.getId(), sensitiveDataRule.getName()));
        }
        return (SensitiveDataRuleTriggered.TriggeredSensitiveDataRule[]) arrayList.toArray(new SensitiveDataRuleTriggered.TriggeredSensitiveDataRule[0]);
    }

    static SensitiveDataRuleModel fromLiveAgentRule(ChatRequestSuccessMessage.SensitiveDataRule sensitiveDataRule) {
        ArrayList arrayList = new ArrayList();
        for (String compile : sensitiveDataRule.getPattern().split("\\n")) {
            arrayList.add(Pattern.compile(compile));
        }
        return new SensitiveDataRuleModel(sensitiveDataRule.getId(), sensitiveDataRule.getName(), sensitiveDataRule.getActionType(), sensitiveDataRule.getReplacement(), (Pattern[]) arrayList.toArray(new Pattern[0]));
    }
}
