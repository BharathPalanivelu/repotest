package com.shopee.app.web.protocol;

import com.google.a.l;
import com.google.a.o;

public class NavigateMessage {
    String backUrl;
    l config;
    String method;
    l navbar;
    int pageType;
    int popSelf;
    l popUpForBackButton;
    String preloadKey;
    int presentModal;
    l tabRightButton;
    l tabs;
    l tabsConfig;
    String url;

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }

    public String getNavbarStr() {
        l lVar = this.navbar;
        return lVar == null ? "" : lVar.toString();
    }

    public String getTabsStr() {
        if (this.tabs == null) {
            return "";
        }
        o oVar = new o();
        oVar.a("tabs", this.tabs);
        oVar.a("tabsConfig", this.tabsConfig);
        return oVar.toString();
    }

    public String getTabRightButtonStr() {
        l lVar = this.tabRightButton;
        return lVar == null ? "" : lVar.toString();
    }

    public l getConfig() {
        return this.config;
    }

    public int getPresentModal() {
        return this.presentModal;
    }

    public String getBackUrl() {
        return this.backUrl;
    }

    public String getPreloadKey() {
        return this.preloadKey;
    }

    public String getTabsConfig() {
        l lVar = this.tabsConfig;
        return lVar == null ? "" : lVar.toString();
    }

    public int getPageType() {
        return this.pageType;
    }

    public boolean popSelf() {
        return this.popSelf == 1;
    }

    public String getPopUpForBackButtonStr() {
        l lVar = this.popUpForBackButton;
        return lVar == null ? "" : lVar.toString();
    }
}
