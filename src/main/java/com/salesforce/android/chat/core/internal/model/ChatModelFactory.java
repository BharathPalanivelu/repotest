package com.salesforce.android.chat.core.internal.model;

import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatRequestSuccessMessage;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.SensitiveDataRule;
import java.util.ArrayList;
import java.util.Date;

public class ChatModelFactory {
    public ChatMessage createChatMessage(String str, String str2, String str3, Date date) {
        return new ChatMessageModel(str, str2, str3, date);
    }

    public AgentInformation createAgentInformation(String str, String str2, boolean z) {
        return new AgentInformationModel(str, str2, z, false);
    }

    public AgentInformation createChatBotInformation(String str, String str2, boolean z) {
        return new AgentInformationModel(str, str2, z, true);
    }

    public ChatSessionInfo createChatSessionInfo(String str, SensitiveDataRule... sensitiveDataRuleArr) {
        return new ChatSessionInfoModel(str, sensitiveDataRuleArr);
    }

    public SensitiveDataRule[] createSensitiveDataRules(ChatRequestSuccessMessage.SensitiveDataRule... sensitiveDataRuleArr) {
        ArrayList arrayList = new ArrayList();
        for (ChatRequestSuccessMessage.SensitiveDataRule fromLiveAgentRule : sensitiveDataRuleArr) {
            arrayList.add(SensitiveDataRuleModel.fromLiveAgentRule(fromLiveAgentRule));
        }
        return (SensitiveDataRule[]) arrayList.toArray(new SensitiveDataRule[0]);
    }

    public ChatSentMessageReceipt createChatSentMessageReceipt(String str, String str2, SensitiveDataRule[] sensitiveDataRuleArr) {
        return new ChatSentMessageReceiptModel(str, str2, sensitiveDataRuleArr);
    }
}
