package com.shopee.app.util.sfchat.a;

import android.app.Activity;
import com.garena.android.appkit.d.a;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.model.ChatEntity;
import com.salesforce.android.chat.core.model.ChatEntityField;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.ui.ChatUIClient;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import d.d.b.j;
import d.m;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class c {
    public static final ActivityTracker a(InternalChatUIClient internalChatUIClient) {
        j.b(internalChatUIClient, "$this$getActivityTracker");
        Field declaredField = internalChatUIClient.getClass().getDeclaredField("mActivityTracker");
        j.a((Object) declaredField, "it");
        declaredField.setAccessible(true);
        try {
            Object obj = declaredField.get(internalChatUIClient);
            if (obj != null) {
                return (ActivityTracker) obj;
            }
            throw new m("null cannot be cast to non-null type com.salesforce.android.service.common.utilities.activity.ActivityTracker");
        } catch (Exception e2) {
            a.a(e2);
            return null;
        }
    }

    public static final Activity a(ChatUIClient chatUIClient) {
        if (!(chatUIClient instanceof InternalChatUIClient)) {
            return null;
        }
        ActivityTracker a2 = a((InternalChatUIClient) chatUIClient);
        if (a2 != null) {
            return a2.getForegroundActivity();
        }
        return null;
    }

    public static final ChatEntityField a(ChatUIConfiguration chatUIConfiguration, String str) {
        j.b(chatUIConfiguration, "$this$getField");
        j.b(str, "objectFieldName");
        ChatConfiguration chatCoreConfiguration = chatUIConfiguration.getChatCoreConfiguration();
        j.a((Object) chatCoreConfiguration, "chatCoreConfiguration");
        List<ChatEntity> chatEntities = chatCoreConfiguration.getChatEntities();
        j.a((Object) chatEntities, "chatCoreConfiguration.chatEntities");
        for (ChatEntity chatEntity : chatEntities) {
            j.a((Object) chatEntity, "entity");
            List<ChatEntityField> chatEntityFields = chatEntity.getChatEntityFields();
            j.a((Object) chatEntityFields, "entity.chatEntityFields");
            Iterator it = chatEntityFields.iterator();
            while (true) {
                if (it.hasNext()) {
                    ChatEntityField chatEntityField = (ChatEntityField) it.next();
                    j.a((Object) chatEntityField, "field");
                    if (j.a((Object) chatEntityField.getSalesforceObjectFieldName(), (Object) str)) {
                        return chatEntityField;
                    }
                }
            }
        }
        return null;
    }

    public static final String a(ChatUIConfiguration chatUIConfiguration) {
        j.b(chatUIConfiguration, "$this$getShopeeChatKey");
        ChatEntityField a2 = a(chatUIConfiguration, "Shopee_Chat_Key__c");
        if (a2 == null) {
            return null;
        }
        ChatUserData mappedChatUserData = a2.getMappedChatUserData();
        j.a((Object) mappedChatUserData, "mappedChatUserData");
        return String.valueOf(mappedChatUserData.getValue());
    }
}
