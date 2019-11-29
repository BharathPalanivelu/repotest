package com.shopee.app.web.protocol;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class SalesforceChatData {
    @c(a = "chatbotArticle")
    private final String chatbotArticle;
    @c(a = "chatbotTask")
    private final String chatbotTask;
    @c(a = "fromPage")
    private final String fromPage;
    @c(a = "offlineFormUrl")
    private final String offlineFormUrl;

    public static /* synthetic */ SalesforceChatData copy$default(SalesforceChatData salesforceChatData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = salesforceChatData.offlineFormUrl;
        }
        if ((i & 2) != 0) {
            str2 = salesforceChatData.fromPage;
        }
        if ((i & 4) != 0) {
            str3 = salesforceChatData.chatbotArticle;
        }
        if ((i & 8) != 0) {
            str4 = salesforceChatData.chatbotTask;
        }
        return salesforceChatData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.offlineFormUrl;
    }

    public final String component2() {
        return this.fromPage;
    }

    public final String component3() {
        return this.chatbotArticle;
    }

    public final String component4() {
        return this.chatbotTask;
    }

    public final SalesforceChatData copy(String str, String str2, String str3, String str4) {
        j.b(str, "offlineFormUrl");
        return new SalesforceChatData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SalesforceChatData)) {
            return false;
        }
        SalesforceChatData salesforceChatData = (SalesforceChatData) obj;
        return j.a((Object) this.offlineFormUrl, (Object) salesforceChatData.offlineFormUrl) && j.a((Object) this.fromPage, (Object) salesforceChatData.fromPage) && j.a((Object) this.chatbotArticle, (Object) salesforceChatData.chatbotArticle) && j.a((Object) this.chatbotTask, (Object) salesforceChatData.chatbotTask);
    }

    public int hashCode() {
        String str = this.offlineFormUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fromPage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.chatbotArticle;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.chatbotTask;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SalesforceChatData(offlineFormUrl=" + this.offlineFormUrl + ", fromPage=" + this.fromPage + ", chatbotArticle=" + this.chatbotArticle + ", chatbotTask=" + this.chatbotTask + SQLBuilder.PARENTHESES_RIGHT;
    }

    public SalesforceChatData(String str, String str2, String str3, String str4) {
        j.b(str, "offlineFormUrl");
        this.offlineFormUrl = str;
        this.fromPage = str2;
        this.chatbotArticle = str3;
        this.chatbotTask = str4;
    }

    public final String getOfflineFormUrl() {
        return this.offlineFormUrl;
    }

    public final String getFromPage() {
        return this.fromPage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SalesforceChatData(String str, String str2, String str3, String str4, int i, g gVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getChatbotArticle() {
        return this.chatbotArticle;
    }

    public final String getChatbotTask() {
        return this.chatbotTask;
    }
}
