package com.salesforce.android.chat.core.internal.liveagent.request;

import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.liveagent.request.SensitiveDataRuleTriggered;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public class ChatRequestFactory {
    public ChasitorInitRequest createInitRequest(ChatConfiguration chatConfiguration, SessionInfo sessionInfo) {
        return new ChasitorInitRequest(chatConfiguration, sessionInfo.getSessionId(), sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ChatMessageRequest createMessageRequest(String str, SessionInfo sessionInfo) {
        return new ChatMessageRequest(str, sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ChasitorTypingRequest createTypingRequest(SessionInfo sessionInfo) {
        return new ChasitorTypingRequest(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ChasitorSneakPeekRequest createSneakPeekRequest(CharSequence charSequence, SessionInfo sessionInfo) {
        return new ChasitorSneakPeekRequest(charSequence, sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ChasitorNotTypingRequest createNotTypingRequest(SessionInfo sessionInfo) {
        return new ChasitorNotTypingRequest(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public SensitiveDataRuleTriggered createSensitiveDataRuleTriggered(SessionInfo sessionInfo, SensitiveDataRuleTriggered.TriggeredSensitiveDataRule... triggeredSensitiveDataRuleArr) {
        return new SensitiveDataRuleTriggered(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken(), triggeredSensitiveDataRuleArr);
    }

    public ChatEndRequest createEndRequest(SessionInfo sessionInfo) {
        return new ChatEndRequest(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public AgentAvailabilityRequest createAgentAvailabilityRequest(String str, String str2, String str3) {
        return new AgentAvailabilityRequest(str, str2, str3);
    }
}
