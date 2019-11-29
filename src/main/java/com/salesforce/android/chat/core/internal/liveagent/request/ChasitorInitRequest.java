package com.salesforce.android.chat.core.internal.liveagent.request;

import android.os.Build;
import com.google.a.a.c;
import com.google.a.f;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.model.ChatEntity;
import com.salesforce.android.chat.core.model.ChatEntityField;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentSessionRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;
import okhttp3.RequestBody;

public class ChasitorInitRequest implements LiveAgentSessionRequest {
    private static final String REQUEST_PATH = "Chasitor/ChasitorInit";
    private static final String USER_AGENT = String.format("Android %s %s", new Object[]{Build.MANUFACTURER, Build.MODEL});
    private static final String VALUE_NOT_APPLICABLE = "n/a";
    private final transient String mAffinityToken;
    @c(a = "buttonId")
    private String mButtonId;
    @c(a = "deploymentId")
    private String mDeploymentId;
    @c(a = "isPost")
    private boolean mIsPost = true;
    @c(a = "language")
    private String mLanguage = VALUE_NOT_APPLICABLE;
    @c(a = "organizationId")
    private String mOrganizationId;
    @c(a = "prechatDetails")
    private List<PreChatDetail> mPreChatDetails;
    @c(a = "prechatEntities")
    private List<PreChatEntity> mPreChatEntities;
    @c(a = "receiveQueueUpdates")
    private boolean mReceiveQueueUpdates = true;
    @c(a = "screenResolution")
    private String mScreenResolution = VALUE_NOT_APPLICABLE;
    @c(a = "sessionId")
    private String mSessionId;
    private final transient String mSessionKey;
    @c(a = "userAgent")
    private String mUserAgent = USER_AGENT;
    @c(a = "visitorName")
    private String mVisitorName;

    ChasitorInitRequest(ChatConfiguration chatConfiguration, String str, String str2, String str3) {
        this.mSessionKey = str2;
        this.mAffinityToken = str3;
        this.mVisitorName = chatConfiguration.getVisitorName();
        this.mOrganizationId = chatConfiguration.getOrganizationId();
        this.mDeploymentId = chatConfiguration.getDeploymentId();
        this.mButtonId = chatConfiguration.getButtonId();
        this.mSessionId = str;
        this.mPreChatDetails = PreChatDetail.create(chatConfiguration.getChatUserData());
        this.mPreChatEntities = PreChatEntity.create(chatConfiguration.getChatEntities());
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public String getAffinityToken() {
        return this.mAffinityToken;
    }

    public String getUrl(String str) {
        return String.format(LiveAgentRequest.LIVE_AGENT_ENDPOINT_FORMAT, new Object[]{Arguments.checkNotNull(str, LiveAgentRequest.ERROR_MESSAGE_POD_IS_NULL), REQUEST_PATH});
    }

    public String toJson(f fVar) {
        return fVar.b((Object) this);
    }

    public HttpRequest build(String str, f fVar, int i) {
        return HttpFactory.request().url(getUrl(str)).addHeader(LiveAgentRequest.HEADER_ACCEPT, LiveAgentRequest.HEADER_ACCEPT_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION, LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_SESSION_KEY, this.mSessionKey).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY, this.mAffinityToken).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_SEQUENCE, Integer.toString(i)).post(RequestBody.create(MEDIA_TYPE, toJson(fVar))).build();
    }

    private static class PreChatDetail {
        @c(a = "entityMaps")
        private Object[] mEntityMaps = new Object[0];
        @c(a = "displayToAgent")
        private final boolean mIsDisplayedToAgent;
        @c(a = "label")
        private final String mLabel;
        @c(a = "transcriptFields")
        private final String[] mTranscriptFields;
        @c(a = "value")
        private Object mValue;

        private PreChatDetail(String str, String str2, boolean z, String... strArr) {
            this.mLabel = str;
            this.mValue = str2 == null ? "" : str2;
            this.mIsDisplayedToAgent = z;
            this.mTranscriptFields = strArr == null ? new String[0] : strArr;
        }

        static List<PreChatDetail> create(List<ChatUserData> list) {
            ArrayList arrayList = new ArrayList();
            for (ChatUserData create : list) {
                arrayList.add(create(create));
            }
            return arrayList;
        }

        static PreChatDetail create(ChatUserData chatUserData) {
            return new PreChatDetail(chatUserData.getAgentLabel(), chatUserData.getValue(), chatUserData.isDisplayedToAgent(), chatUserData.getTranscriptFieldNames());
        }
    }

    private static class PreChatEntity {
        @c(a = "linkToEntityField")
        private final String mLinkToEntityField;
        @c(a = "linkToEntityName")
        private final String mLinkToEntityName;
        @c(a = "entityName")
        private final String mName;
        @c(a = "entityFieldsMaps")
        private final List<PreChatEntityField> mPreChatEntityFields;
        @c(a = "saveToTranscript")
        private final String mSaveToTranscript;
        @c(a = "showOnCreate")
        private final boolean mShowOnCreate;

        private PreChatEntity(String str, boolean z, String str2, String str3, String str4, List<PreChatEntityField> list) {
            this.mName = str;
            this.mPreChatEntityFields = list;
            this.mShowOnCreate = z;
            this.mSaveToTranscript = str2;
            this.mLinkToEntityName = str3;
            this.mLinkToEntityField = str4;
        }

        static List<PreChatEntity> create(List<ChatEntity> list) {
            ArrayList arrayList = new ArrayList();
            for (ChatEntity create : list) {
                arrayList.add(create(create));
            }
            return arrayList;
        }

        static PreChatEntity create(ChatEntity chatEntity) {
            ArrayList arrayList = new ArrayList();
            for (ChatEntityField create : chatEntity.getChatEntityFields()) {
                arrayList.add(PreChatEntityField.create(create));
            }
            return new PreChatEntity(chatEntity.getSalesforceObjectType(), chatEntity.getShowOnCreate(), chatEntity.getLinkedTranscriptFieldName(), chatEntity.getLinkedSalesforceObjectType(), chatEntity.getLinkedSalesforceObjectFieldName(), arrayList);
        }
    }

    private static class PreChatEntityField {
        @c(a = "doCreate")
        private final boolean mDoCreate;
        @c(a = "doFind")
        private final boolean mDoFind;
        @c(a = "fieldName")
        private final String mFieldName;
        @c(a = "isExactMatch")
        private final boolean mIsExactMatch;
        @c(a = "label")
        private final String mLabel;

        private PreChatEntityField(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.mFieldName = str;
            this.mLabel = str2;
            this.mDoFind = z;
            this.mIsExactMatch = z2;
            this.mDoCreate = z3;
        }

        static PreChatEntityField create(ChatEntityField chatEntityField) {
            return new PreChatEntityField(chatEntityField.getSalesforceObjectFieldName(), chatEntityField.getMappedChatUserData().getAgentLabel(), chatEntityField.doFind(), chatEntityField.isExactMatch(), chatEntityField.doCreate());
        }
    }
}
