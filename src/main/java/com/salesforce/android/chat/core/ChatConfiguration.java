package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.ChatEntity;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.core.model.PreChatEntity;
import com.salesforce.android.chat.core.model.PreChatField;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatConfiguration implements Serializable {
    private final String mButtonId;
    private final List<? extends ChatEntity> mChatEntities;
    private final List<? extends ChatUserData> mChatUserData;
    private final String mDeploymentId;
    private final String mLiveAgentPod;
    private final String mOrganizationId;
    private final String mVisitorName;

    private ChatConfiguration(Builder builder) {
        this.mOrganizationId = builder.mOrganizationId;
        this.mButtonId = builder.mButtonId;
        this.mDeploymentId = builder.mDeploymentId;
        this.mLiveAgentPod = builder.mLiveAgentPod;
        this.mVisitorName = builder.mVisitorName;
        this.mChatUserData = builder.mChatUserData;
        this.mChatEntities = builder.mChatEntities;
    }

    public String getButtonId() {
        return this.mButtonId;
    }

    public String getDeploymentId() {
        return this.mDeploymentId;
    }

    public String getLiveAgentPod() {
        return this.mLiveAgentPod;
    }

    public String getOrganizationId() {
        return this.mOrganizationId;
    }

    public String getVisitorName() {
        return this.mVisitorName;
    }

    public List<ChatUserData> getChatUserData() {
        return this.mChatUserData;
    }

    public List<ChatEntity> getChatEntities() {
        return this.mChatEntities;
    }

    @Deprecated
    public List<PreChatField> getPreChatFields() {
        for (ChatUserData chatUserData : this.mChatUserData) {
            if (!(chatUserData instanceof PreChatField)) {
                return new ArrayList();
            }
        }
        return this.mChatUserData;
    }

    @Deprecated
    public List<PreChatEntity> getPreChatEntities() {
        for (ChatEntity chatEntity : this.mChatEntities) {
            if (!(chatEntity instanceof PreChatEntity)) {
                return new ArrayList();
            }
        }
        return this.mChatEntities;
    }

    public static class Builder {
        final String mButtonId;
        List<ChatEntity> mChatEntities = new ArrayList();
        List<ChatUserData> mChatUserData = new ArrayList();
        final String mDeploymentId;
        String mLiveAgentPod;
        final String mOrganizationId;
        String mVisitorName = "Visitor";

        public Builder(String str, String str2, String str3, String str4) {
            this.mButtonId = str2;
            this.mLiveAgentPod = str4;
            this.mOrganizationId = str;
            this.mDeploymentId = str3;
        }

        public Builder(ChatConfiguration chatConfiguration) {
            this.mOrganizationId = chatConfiguration.getOrganizationId();
            this.mButtonId = chatConfiguration.getButtonId();
            this.mDeploymentId = chatConfiguration.getDeploymentId();
            this.mLiveAgentPod = chatConfiguration.getLiveAgentPod();
            this.mVisitorName = chatConfiguration.getVisitorName();
            this.mChatUserData = chatConfiguration.getChatUserData();
            this.mChatEntities = chatConfiguration.getChatEntities();
        }

        public Builder liveAgentPod(String str) {
            this.mLiveAgentPod = str;
            return this;
        }

        public Builder visitorName(String str) {
            this.mVisitorName = str;
            return this;
        }

        public Builder chatUserData(List<ChatUserData> list) {
            this.mChatUserData = list;
            return this;
        }

        public Builder chatUserData(ChatUserData... chatUserDataArr) {
            this.mChatUserData = Arrays.asList(chatUserDataArr);
            return this;
        }

        public Builder chatEntities(List<ChatEntity> list) {
            this.mChatEntities = list;
            return this;
        }

        public Builder chatEntities(ChatEntity... chatEntityArr) {
            this.mChatEntities = Arrays.asList(chatEntityArr);
            return this;
        }

        @Deprecated
        public <T extends ChatUserData> Builder preChatFields(List<T> list) {
            return list == null ? this : chatUserData((List<ChatUserData>) list);
        }

        @Deprecated
        public <T extends ChatEntity> Builder preChatEntities(List<T> list) {
            return list == null ? this : chatEntities((List<ChatEntity>) list);
        }

        public ChatConfiguration build() {
            Arguments.checkValidSalesforceId(this.mOrganizationId, "Organization ID");
            Arguments.checkValidSalesforceId(this.mButtonId, "Button ID");
            Arguments.checkValidSalesforceId(this.mDeploymentId, "Deployment ID");
            Arguments.checkValidLiveAgentPod(this.mLiveAgentPod);
            return new ChatConfiguration(this);
        }
    }
}
