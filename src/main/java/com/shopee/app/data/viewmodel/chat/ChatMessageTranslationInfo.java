package com.shopee.app.data.viewmodel.chat;

import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.protocol.shop.ChatTextInfo;
import com.shopee.protocol.shop.ChatTextTranslated;
import d.d.b.j;

public final class ChatMessageTranslationInfo {
    public static final Companion Companion = new Companion((g) null);
    private final String translatedLanguage;
    private final String translatedSource;
    private final String translatedText;

    public static /* synthetic */ ChatMessageTranslationInfo copy$default(ChatMessageTranslationInfo chatMessageTranslationInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatMessageTranslationInfo.translatedText;
        }
        if ((i & 2) != 0) {
            str2 = chatMessageTranslationInfo.translatedLanguage;
        }
        if ((i & 4) != 0) {
            str3 = chatMessageTranslationInfo.translatedSource;
        }
        return chatMessageTranslationInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.translatedText;
    }

    public final String component2() {
        return this.translatedLanguage;
    }

    public final String component3() {
        return this.translatedSource;
    }

    public final ChatMessageTranslationInfo copy(String str, String str2, String str3) {
        return new ChatMessageTranslationInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessageTranslationInfo)) {
            return false;
        }
        ChatMessageTranslationInfo chatMessageTranslationInfo = (ChatMessageTranslationInfo) obj;
        return j.a((Object) this.translatedText, (Object) chatMessageTranslationInfo.translatedText) && j.a((Object) this.translatedLanguage, (Object) chatMessageTranslationInfo.translatedLanguage) && j.a((Object) this.translatedSource, (Object) chatMessageTranslationInfo.translatedSource);
    }

    public int hashCode() {
        String str = this.translatedText;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.translatedLanguage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.translatedSource;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ChatMessageTranslationInfo(translatedText=" + this.translatedText + ", translatedLanguage=" + this.translatedLanguage + ", translatedSource=" + this.translatedSource + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ChatMessageTranslationInfo(String str, String str2, String str3) {
        this.translatedText = str;
        this.translatedLanguage = str2;
        this.translatedSource = str3;
    }

    public final String getTranslatedText() {
        return this.translatedText;
    }

    public final String getTranslatedLanguage() {
        return this.translatedLanguage;
    }

    public final String getTranslatedSource() {
        return this.translatedSource;
    }

    public final boolean isTranslationAvailable() {
        return !TextUtils.isEmpty(this.translatedText);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ChatMessageTranslationInfo from(ChatTextInfo chatTextInfo) {
            j.b(chatTextInfo, "textInfo");
            ChatTextTranslated chatTextTranslated = chatTextInfo.translated_text;
            if (chatTextTranslated != null) {
                return new ChatMessageTranslationInfo(chatTextTranslated.translated_text, chatTextTranslated.translated_language, chatTextTranslated.source);
            }
            return null;
        }
    }
}
