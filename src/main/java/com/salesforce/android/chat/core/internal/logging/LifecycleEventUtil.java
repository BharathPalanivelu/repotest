package com.salesforce.android.chat.core.internal.logging;

import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;

class LifecycleEventUtil {
    static final String END_REASON_AGENT = "SCSChatEndReasonAgent";
    static final String END_REASON_NETWORK_ERROR = "SCSChatEndReasonNetworkError";
    static final String END_REASON_NO_AGENTS = "SCSChatEndReasonNoAgents";
    static final String END_REASON_TIMEOUT = "SCSChatEndReasonTimeout";
    static final String END_REASON_UNKNOWN = "SCSChatEndReasonUnknown";
    static final String END_REASON_USER = "SCSChatEndReasonUser";
    static final String LIFECYCLE_ENDED = "Ended";
    static final String LIFECYCLE_INITIALIZATION = "Initialization";
    static final String LIFECYCLE_LONG_POLLING = "Long Polling";
    static final String LIFECYCLE_READY = "Ready";
    static final String LIFECYCLE_SESSION_CLEANUP = "Session Cleanup";
    static final String LIFECYCLE_SESSION_CONNECTED = "Session Connected";
    static final String LIFECYCLE_UNKNOWN = "Unknown";
    static final String LIFECYCLE_VERIFICATION = "Verification";
    static final String LIFECYCLE_WAITING_FOR_AGENT = "Waiting For Agent";

    LifecycleEventUtil() {
    }

    static String convert(ChatSessionState chatSessionState) {
        switch (chatSessionState) {
            case Ready:
                return LIFECYCLE_READY;
            case Verification:
                return LIFECYCLE_VERIFICATION;
            case Initializing:
                return LIFECYCLE_INITIALIZATION;
            case Connecting:
                return LIFECYCLE_LONG_POLLING;
            case InQueue:
                return LIFECYCLE_WAITING_FOR_AGENT;
            case Connected:
                return LIFECYCLE_SESSION_CONNECTED;
            case Ending:
                return LIFECYCLE_SESSION_CLEANUP;
            case Disconnected:
                return LIFECYCLE_ENDED;
            default:
                return "Unknown";
        }
    }

    /* renamed from: com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason = new int[ChatEndReason.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(3:39|40|42)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009b */
        static {
            /*
                com.salesforce.android.chat.core.model.ChatEndReason[] r0 = com.salesforce.android.chat.core.model.ChatEndReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.android.chat.core.model.ChatEndReason r2 = com.salesforce.android.chat.core.model.ChatEndReason.EndedByClient     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.android.chat.core.model.ChatEndReason r3 = com.salesforce.android.chat.core.model.ChatEndReason.EndedByAgent     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.android.chat.core.model.ChatEndReason r4 = com.salesforce.android.chat.core.model.ChatEndReason.NoAgentsAvailable     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.salesforce.android.chat.core.model.ChatEndReason r5 = com.salesforce.android.chat.core.model.ChatEndReason.LiveAgentTimeout     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.salesforce.android.chat.core.model.ChatEndReason r6 = com.salesforce.android.chat.core.model.ChatEndReason.NetworkError     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                r5 = 6
                int[] r6 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x004b }
                com.salesforce.android.chat.core.model.ChatEndReason r7 = com.salesforce.android.chat.core.model.ChatEndReason.Unknown     // Catch:{ NoSuchFieldError -> 0x004b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                com.salesforce.android.chat.core.model.ChatSessionState[] r6 = com.salesforce.android.chat.core.model.ChatSessionState.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState = r6
                int[] r6 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x005e }
                com.salesforce.android.chat.core.model.ChatSessionState r7 = com.salesforce.android.chat.core.model.ChatSessionState.Ready     // Catch:{ NoSuchFieldError -> 0x005e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.salesforce.android.chat.core.model.ChatSessionState r6 = com.salesforce.android.chat.core.model.ChatSessionState.Verification     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.salesforce.android.chat.core.model.ChatSessionState r1 = com.salesforce.android.chat.core.model.ChatSessionState.Initializing     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x007c }
                com.salesforce.android.chat.core.model.ChatSessionState r1 = com.salesforce.android.chat.core.model.ChatSessionState.Connecting     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.salesforce.android.chat.core.model.ChatSessionState r1 = com.salesforce.android.chat.core.model.ChatSessionState.InQueue     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.salesforce.android.chat.core.model.ChatSessionState r1 = com.salesforce.android.chat.core.model.ChatSessionState.Connected     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x009b }
                com.salesforce.android.chat.core.model.ChatSessionState r1 = com.salesforce.android.chat.core.model.ChatSessionState.Ending     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatSessionState     // Catch:{ NoSuchFieldError -> 0x00a7 }
                com.salesforce.android.chat.core.model.ChatSessionState r1 = com.salesforce.android.chat.core.model.ChatSessionState.Disconnected     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil.AnonymousClass1.<clinit>():void");
        }
    }

    static String convert(ChatEndReason chatEndReason) {
        int i = AnonymousClass1.$SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason[chatEndReason.ordinal()];
        if (i == 1) {
            return END_REASON_USER;
        }
        if (i == 2) {
            return END_REASON_AGENT;
        }
        if (i == 3) {
            return END_REASON_NO_AGENTS;
        }
        if (i != 4) {
            return i != 5 ? END_REASON_UNKNOWN : END_REASON_NETWORK_ERROR;
        }
        return END_REASON_TIMEOUT;
    }
}
