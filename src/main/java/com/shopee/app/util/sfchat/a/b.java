package com.shopee.app.util.sfchat.a;

import android.app.Activity;
import android.text.TextUtils;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.shopee.app.data.store.setting.SalesforceConfigs;
import com.shopee.app.ui.common.au;
import com.shopee.app.ui.webview.c;
import com.shopee.app.ui.webview.g;
import d.d.b.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f26506a = new b();

    private b() {
    }

    public final ChatConfiguration.Builder a(SalesforceConfigs salesforceConfigs) {
        if (salesforceConfigs != null && !TextUtils.isEmpty(salesforceConfigs.getOrgId()) && !TextUtils.isEmpty(salesforceConfigs.getButtonId()) && !TextUtils.isEmpty(salesforceConfigs.getDeploymentId()) && !TextUtils.isEmpty(salesforceConfigs.getLiveAgentPod())) {
            return new ChatConfiguration.Builder(salesforceConfigs.getOrgId(), salesforceConfigs.getButtonId(), salesforceConfigs.getDeploymentId(), salesforceConfigs.getLiveAgentPod());
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r6 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r7 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r2 != null) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.salesforce.android.chat.core.ChatConfiguration.Builder r20, com.shopee.app.appuser.UserInfo r21, com.shopee.app.web.protocol.SalesforceChatData r22, java.lang.String r23) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "configurationBuilder"
            d.d.b.j.b(r0, r1)
            java.lang.String r1 = "-"
            if (r21 == 0) goto L_0x0012
            java.lang.String r2 = r21.getUsername()
            if (r2 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            if (r21 == 0) goto L_0x001a
            int r3 = r21.getUserId()
            goto L_0x001b
        L_0x001a:
            r3 = -1
        L_0x001b:
            r4 = 0
            r5 = 1
            if (r21 == 0) goto L_0x004d
            java.lang.String r6 = r21.getPhone()
            if (r6 == 0) goto L_0x004d
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x0030
            r7 = 1
            goto L_0x0031
        L_0x0030:
            r7 = 0
        L_0x0031:
            if (r7 == 0) goto L_0x004a
            char r7 = r6.charAt(r4)
            r8 = 43
            if (r7 == r8) goto L_0x004a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
        L_0x004a:
            if (r6 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r6 = r1
        L_0x004e:
            if (r21 == 0) goto L_0x0057
            java.lang.String r7 = r21.getEmail()
            if (r7 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r7 = r1
        L_0x0058:
            if (r22 == 0) goto L_0x0061
            java.lang.String r8 = r22.getFromPage()
            if (r8 == 0) goto L_0x0061
            r1 = r8
        L_0x0061:
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r8 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r8.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r8 = r8.readOnly(r5)
            r9 = r2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r8 = r8.initialValue(r9)
            java.lang.String r10 = "Requestor Name"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r8 = r8.build(r10, r10)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r10.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = r10.readOnly(r5)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r6 = r10.initialValue(r6)
            java.lang.String r10 = "Requestor Phone"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r6 = r6.build(r10, r10)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r10.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = r10.readOnly(r5)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r7 = r10.initialValue(r7)
            java.lang.String r10 = "Requestor Email"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r7 = r7.build(r10, r10)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r10.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = r10.readOnly(r5)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r9 = r10.initialValue(r9)
            java.lang.String r10 = "Shopee User Name"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r9 = r9.build(r10, r10)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r10.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = r10.readOnly(r5)
            java.lang.String r11 = java.lang.String.valueOf(r3)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r10 = r10.initialValue(r11)
            java.lang.String r11 = "Shopee User Id"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r10 = r10.build(r11, r11)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r11 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r11.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r11 = r11.readOnly(r5)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Chat with "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r2 = r12.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r2 = r11.initialValue(r2)
            java.lang.String r11 = "Subject"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r2 = r2.build(r11, r11)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r12 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r12.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r12 = r12.readOnly(r5)
            java.lang.String r13 = "ID"
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r12 = r12.initialValue(r13)
            java.lang.String r13 = "Case Country"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r12 = r12.build(r13, r13)
            com.salesforce.android.chat.ui.model.PreChatPickListField$Builder r13 = new com.salesforce.android.chat.ui.model.PreChatPickListField$Builder
            r13.<init>()
            com.salesforce.android.chat.ui.model.PreChatPickListField$Builder r13 = r13.required(r5)
            com.salesforce.android.chat.ui.model.PreChatPickListField$Option r14 = new com.salesforce.android.chat.ui.model.PreChatPickListField$Option
            java.lang.String r15 = "Chat"
            r14.<init>(r15, r15)
            com.salesforce.android.chat.ui.model.PreChatPickListField$Builder r13 = r13.addOption(r14)
            com.salesforce.android.chat.ui.model.PreChatPickListField$Option r14 = new com.salesforce.android.chat.ui.model.PreChatPickListField$Option
            r14.<init>(r15, r15)
            com.salesforce.android.chat.ui.model.PreChatPickListField$Builder r13 = r13.initialValue(r14)
            java.lang.String r14 = "Contact Type"
            com.salesforce.android.chat.ui.model.PreChatPickListField r13 = r13.build(r14, r14)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r14 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r14.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r14 = r14.readOnly(r5)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r3)
            r3 = 45
            r15.append(r3)
            long r4 = java.lang.System.currentTimeMillis()
            r15.append(r4)
            java.lang.String r4 = "-android"
            r15.append(r4)
            java.lang.String r4 = r15.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r4 = r14.initialValue(r4)
            java.lang.String r5 = "Shopee Chat Key"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r4 = r4.build(r5, r5)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r5 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r5.<init>()
            r14 = 1
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r5 = r5.readOnly(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Android "
            r14.append(r15)
            java.lang.String r15 = android.os.Build.VERSION.RELEASE
            r14.append(r15)
            java.lang.String r15 = ", "
            r14.append(r15)
            java.lang.String r15 = com.shopee.app.react.modules.app.appmanager.a.c()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r5 = r5.initialValue(r14)
            java.lang.String r14 = "Shopee App Version"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r5 = r5.build(r14, r14)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r14 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r14.<init>()
            r15 = 1
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r14 = r14.readOnly(r15)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r1 = r14.initialValue(r1)
            java.lang.String r14 = "Last Article URL"
            java.lang.String r3 = "Last Article URL"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r1 = r1.build(r14, r3)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r3.<init>()
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = r3.readOnly(r15)
            if (r22 == 0) goto L_0x01bc
            java.lang.String r14 = r22.getChatbotArticle()
            goto L_0x01bd
        L_0x01bc:
            r14 = 0
        L_0x01bd:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = r3.initialValue(r14)
            java.lang.String r14 = "Chatbot article"
            java.lang.String r15 = "Chatbot article"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r14 = r3.build(r14, r15)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r3.<init>()
            r15 = 1
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = r3.readOnly(r15)
            if (r22 == 0) goto L_0x01dc
            java.lang.String r15 = r22.getChatbotTask()
            goto L_0x01dd
        L_0x01dc:
            r15 = 0
        L_0x01dd:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = r3.initialValue(r15)
            java.lang.String r15 = "Chatbot taskbot"
            r17 = r11
            java.lang.String r11 = "Chatbot taskbot"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r11 = r3.build(r15, r11)
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = new com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder
            r3.<init>()
            r15 = 1
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = r3.readOnly(r15)
            r15 = r23
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            com.salesforce.android.chat.ui.model.PreChatTextInputField$Builder r3 = r3.initialValue(r15)
            java.lang.String r15 = "Chatbot history"
            java.lang.String r0 = "Chatbot history"
            com.salesforce.android.chat.ui.model.PreChatTextInputField r0 = r3.build(r15, r0)
            r3 = 14
            com.salesforce.android.chat.core.model.ChatUserData[] r15 = new com.salesforce.android.chat.core.model.ChatUserData[r3]
            com.salesforce.android.chat.core.model.ChatUserData r8 = (com.salesforce.android.chat.core.model.ChatUserData) r8
            r3 = 0
            r15[r3] = r8
            com.salesforce.android.chat.core.model.ChatUserData r6 = (com.salesforce.android.chat.core.model.ChatUserData) r6
            r16 = 1
            r15[r16] = r6
            r18 = 2
            com.salesforce.android.chat.core.model.ChatUserData r7 = (com.salesforce.android.chat.core.model.ChatUserData) r7
            r15[r18] = r7
            r18 = 3
            com.salesforce.android.chat.core.model.ChatUserData r10 = (com.salesforce.android.chat.core.model.ChatUserData) r10
            r15[r18] = r10
            r18 = 4
            com.salesforce.android.chat.core.model.ChatUserData r9 = (com.salesforce.android.chat.core.model.ChatUserData) r9
            r15[r18] = r9
            r18 = 5
            com.salesforce.android.chat.core.model.ChatUserData r2 = (com.salesforce.android.chat.core.model.ChatUserData) r2
            r15[r18] = r2
            r18 = 6
            com.salesforce.android.chat.core.model.ChatUserData r12 = (com.salesforce.android.chat.core.model.ChatUserData) r12
            r15[r18] = r12
            r18 = 7
            com.salesforce.android.chat.core.model.ChatUserData r13 = (com.salesforce.android.chat.core.model.ChatUserData) r13
            r15[r18] = r13
            r18 = 8
            com.salesforce.android.chat.core.model.ChatUserData r4 = (com.salesforce.android.chat.core.model.ChatUserData) r4
            r15[r18] = r4
            r18 = 9
            com.salesforce.android.chat.core.model.ChatUserData r5 = (com.salesforce.android.chat.core.model.ChatUserData) r5
            r15[r18] = r5
            r18 = 10
            com.salesforce.android.chat.core.model.ChatUserData r1 = (com.salesforce.android.chat.core.model.ChatUserData) r1
            r15[r18] = r1
            r18 = 11
            com.salesforce.android.chat.core.model.ChatUserData r14 = (com.salesforce.android.chat.core.model.ChatUserData) r14
            r15[r18] = r14
            r18 = 12
            com.salesforce.android.chat.core.model.ChatUserData r11 = (com.salesforce.android.chat.core.model.ChatUserData) r11
            r15[r18] = r11
            r18 = 13
            com.salesforce.android.chat.core.model.ChatUserData r0 = (com.salesforce.android.chat.core.model.ChatUserData) r0
            r15[r18] = r0
            r3 = r20
            r3.chatUserData((com.salesforce.android.chat.core.model.ChatUserData[]) r15)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r15 = new com.salesforce.android.chat.core.model.ChatEntity$Builder
            r15.<init>()
            r3 = 1
            com.salesforce.android.chat.core.model.ChatEntity$Builder r15 = r15.showOnCreate(r3)
            java.lang.String r3 = "Case"
            com.salesforce.android.chat.core.model.ChatEntity$Builder r3 = r15.linkToTranscriptField(r3)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r15 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r15.<init>()
            r22 = r0
            r0 = 1
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r15 = r15.doCreate(r0)
            java.lang.String r0 = "Shopee_ID_Requestor_Name__c"
            com.salesforce.android.chat.core.model.ChatEntityField r0 = r15.build(r0, r8)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r3.addChatEntityField(r0)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r3.<init>()
            r8 = 1
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = r3.doCreate(r8)
            java.lang.String r15 = "Shopee_ID_Requestor_Phone__c"
            com.salesforce.android.chat.core.model.ChatEntityField r3 = r3.build(r15, r6)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r3)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r3.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = r3.doCreate(r8)
            java.lang.String r6 = "Shopee_ID_Requestor_Email__c"
            com.salesforce.android.chat.core.model.ChatEntityField r3 = r3.build(r6, r7)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r3)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r3.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = r3.doCreate(r8)
            java.lang.String r6 = "Shopee_ID_User_Id__c"
            com.salesforce.android.chat.core.model.ChatEntityField r3 = r3.build(r6, r10)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r3)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r3.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = r3.doCreate(r8)
            java.lang.String r6 = "Shopee_ID_User_Name__c"
            com.salesforce.android.chat.core.model.ChatEntityField r3 = r3.build(r6, r9)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r3)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r3.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r3 = r3.doCreate(r8)
            r6 = r17
            com.salesforce.android.chat.core.model.ChatEntityField r2 = r3.build(r6, r2)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r2)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r2.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = r2.doCreate(r8)
            java.lang.String r3 = "Shopee_ID_Case_Country__c"
            com.salesforce.android.chat.core.model.ChatEntityField r2 = r2.build(r3, r12)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r2)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r2.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = r2.doCreate(r8)
            java.lang.String r3 = "Origin"
            com.salesforce.android.chat.core.model.ChatEntityField r2 = r2.build(r3, r13)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r2)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r2.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = r2.doCreate(r8)
            java.lang.String r3 = "Shopee_Chat_Key__c"
            com.salesforce.android.chat.core.model.ChatEntityField r2 = r2.build(r3, r4)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r2)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r2.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = r2.doCreate(r8)
            java.lang.String r3 = "Shopee_App_Version__c"
            com.salesforce.android.chat.core.model.ChatEntityField r2 = r2.build(r3, r5)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r2)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r2.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r2 = r2.doCreate(r8)
            java.lang.String r3 = "Shopee_ID_Last_Article_URL__c"
            com.salesforce.android.chat.core.model.ChatEntityField r1 = r2.build(r3, r1)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r1)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r1 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r1.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r1 = r1.doCreate(r8)
            java.lang.String r2 = "Shopee_Chatbot_Article__c"
            com.salesforce.android.chat.core.model.ChatEntityField r1 = r1.build(r2, r14)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r1)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r1 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r1.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r1 = r1.doCreate(r8)
            java.lang.String r2 = "Shopee_Chatbot_Taskbot__c"
            com.salesforce.android.chat.core.model.ChatEntityField r1 = r1.build(r2, r11)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r1)
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r1 = new com.salesforce.android.chat.core.model.ChatEntityField$Builder
            r1.<init>()
            com.salesforce.android.chat.core.model.ChatEntityField$Builder r1 = r1.doCreate(r8)
            java.lang.String r2 = "Shopee_Chatbot_History__c"
            r3 = r22
            com.salesforce.android.chat.core.model.ChatEntityField r1 = r1.build(r2, r3)
            com.salesforce.android.chat.core.model.ChatEntity$Builder r0 = r0.addChatEntityField(r1)
            java.lang.String r1 = "Case"
            com.salesforce.android.chat.core.model.ChatEntity r0 = r0.build(r1)
            com.salesforce.android.chat.core.model.ChatEntity[] r1 = new com.salesforce.android.chat.core.model.ChatEntity[r8]
            r2 = 0
            r1[r2] = r0
            r0 = r20
            r0.chatEntities((com.salesforce.android.chat.core.model.ChatEntity[]) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.sfchat.a.b.a(com.salesforce.android.chat.core.ChatConfiguration$Builder, com.shopee.app.appuser.UserInfo, com.shopee.app.web.protocol.SalesforceChatData, java.lang.String):void");
    }

    public final void a(Activity activity) {
        j.b(activity, "activity");
        if (activity instanceof c) {
            au F = ((c) activity).F();
            if (F instanceof g) {
                ((g) F).setDetachable(false);
            }
        }
    }
}
