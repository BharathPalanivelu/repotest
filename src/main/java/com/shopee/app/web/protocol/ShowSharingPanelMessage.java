package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.List;

public final class ShowSharingPanelMessage {
    private final Boolean autoDismissForUnavailablePlatform;
    private final List<String> sharingAppIDsBottom;
    private final List<String> sharingAppIDsTop;
    private final String subTitle;
    private final String title;

    public static /* synthetic */ ShowSharingPanelMessage copy$default(ShowSharingPanelMessage showSharingPanelMessage, String str, String str2, Boolean bool, List<String> list, List<String> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = showSharingPanelMessage.title;
        }
        if ((i & 2) != 0) {
            str2 = showSharingPanelMessage.subTitle;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            bool = showSharingPanelMessage.autoDismissForUnavailablePlatform;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            list = showSharingPanelMessage.sharingAppIDsTop;
        }
        List<String> list3 = list;
        if ((i & 16) != 0) {
            list2 = showSharingPanelMessage.sharingAppIDsBottom;
        }
        return showSharingPanelMessage.copy(str, str3, bool2, list3, list2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final Boolean component3() {
        return this.autoDismissForUnavailablePlatform;
    }

    public final List<String> component4() {
        return this.sharingAppIDsTop;
    }

    public final List<String> component5() {
        return this.sharingAppIDsBottom;
    }

    public final ShowSharingPanelMessage copy(String str, String str2, Boolean bool, List<String> list, List<String> list2) {
        return new ShowSharingPanelMessage(str, str2, bool, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowSharingPanelMessage)) {
            return false;
        }
        ShowSharingPanelMessage showSharingPanelMessage = (ShowSharingPanelMessage) obj;
        return j.a((Object) this.title, (Object) showSharingPanelMessage.title) && j.a((Object) this.subTitle, (Object) showSharingPanelMessage.subTitle) && j.a((Object) this.autoDismissForUnavailablePlatform, (Object) showSharingPanelMessage.autoDismissForUnavailablePlatform) && j.a((Object) this.sharingAppIDsTop, (Object) showSharingPanelMessage.sharingAppIDsTop) && j.a((Object) this.sharingAppIDsBottom, (Object) showSharingPanelMessage.sharingAppIDsBottom);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.autoDismissForUnavailablePlatform;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<String> list = this.sharingAppIDsTop;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.sharingAppIDsBottom;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ShowSharingPanelMessage(title=" + this.title + ", subTitle=" + this.subTitle + ", autoDismissForUnavailablePlatform=" + this.autoDismissForUnavailablePlatform + ", sharingAppIDsTop=" + this.sharingAppIDsTop + ", sharingAppIDsBottom=" + this.sharingAppIDsBottom + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ShowSharingPanelMessage(String str, String str2, Boolean bool, List<String> list, List<String> list2) {
        this.title = str;
        this.subTitle = str2;
        this.autoDismissForUnavailablePlatform = bool;
        this.sharingAppIDsTop = list;
        this.sharingAppIDsBottom = list2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final Boolean getAutoDismissForUnavailablePlatform() {
        return this.autoDismissForUnavailablePlatform;
    }

    public final List<String> getSharingAppIDsTop() {
        return this.sharingAppIDsTop;
    }

    public final List<String> getSharingAppIDsBottom() {
        return this.sharingAppIDsBottom;
    }
}
