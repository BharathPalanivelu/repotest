package com.salesforce.android.chat.core.internal.liveagent;

public class EndReasonUtil {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.salesforce.android.chat.core.model.ChatEndReason fromChatEndedReason(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1956889055: goto L_0x0049;
                case -1764315806: goto L_0x003f;
                case -1357712437: goto L_0x0035;
                case -989748062: goto L_0x002b;
                case -888543710: goto L_0x0021;
                case -284840886: goto L_0x0017;
                case 92750597: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0053
        L_0x000d:
            java.lang.String r0 = "agent"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 0
            goto L_0x0054
        L_0x0017:
            java.lang.String r0 = "unknown"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 6
            goto L_0x0054
        L_0x0021:
            java.lang.String r0 = "clientIdleTimeout"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 4
            goto L_0x0054
        L_0x002b:
            java.lang.String r0 = "agentPushTimeout"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 3
            goto L_0x0054
        L_0x0035:
            java.lang.String r0 = "client"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 1
            goto L_0x0054
        L_0x003f:
            java.lang.String r0 = "agentsUnavailable"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 2
            goto L_0x0054
        L_0x0049:
            java.lang.String r0 = "NoPost"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0053
            r6 = 5
            goto L_0x0054
        L_0x0053:
            r6 = -1
        L_0x0054:
            if (r6 == 0) goto L_0x006f
            if (r6 == r5) goto L_0x006c
            if (r6 == r4) goto L_0x0069
            if (r6 == r3) goto L_0x0066
            if (r6 == r2) goto L_0x0066
            if (r6 == r1) goto L_0x0063
            com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.Unknown
            return r6
        L_0x0063:
            com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.NetworkError
            return r6
        L_0x0066:
            com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.LiveAgentTimeout
            return r6
        L_0x0069:
            com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.NoAgentsAvailable
            return r6
        L_0x006c:
            com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.EndedByClient
            return r6
        L_0x006f:
            com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.EndedByAgent
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.liveagent.EndReasonUtil.fromChatEndedReason(java.lang.String):com.salesforce.android.chat.core.model.ChatEndReason");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.salesforce.android.chat.core.model.ChatEndReason fromChatFailureReason(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1956889055: goto L_0x0033;
                case 840637421: goto L_0x0029;
                case 1002405936: goto L_0x001f;
                case 1379812394: goto L_0x0015;
                case 1643215308: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x003d
        L_0x000b:
            java.lang.String r0 = "Blocked"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x003d
            r4 = 3
            goto L_0x003e
        L_0x0015:
            java.lang.String r0 = "Unknown"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x003d
            r4 = 4
            goto L_0x003e
        L_0x001f:
            java.lang.String r0 = "Unavailable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x003d
            r4 = 0
            goto L_0x003e
        L_0x0029:
            java.lang.String r0 = "InternalFailure"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x003d
            r4 = 1
            goto L_0x003e
        L_0x0033:
            java.lang.String r0 = "NoPost"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x003d
            r4 = 2
            goto L_0x003e
        L_0x003d:
            r4 = -1
        L_0x003e:
            if (r4 == 0) goto L_0x004c
            if (r4 == r3) goto L_0x0049
            if (r4 == r2) goto L_0x0049
            if (r4 == r1) goto L_0x0049
            com.salesforce.android.chat.core.model.ChatEndReason r4 = com.salesforce.android.chat.core.model.ChatEndReason.Unknown
            return r4
        L_0x0049:
            com.salesforce.android.chat.core.model.ChatEndReason r4 = com.salesforce.android.chat.core.model.ChatEndReason.NetworkError
            return r4
        L_0x004c:
            com.salesforce.android.chat.core.model.ChatEndReason r4 = com.salesforce.android.chat.core.model.ChatEndReason.NoAgentsAvailable
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.liveagent.EndReasonUtil.fromChatFailureReason(java.lang.String):com.salesforce.android.chat.core.model.ChatEndReason");
    }
}
