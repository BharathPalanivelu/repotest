package com.shopee.web.sdk.bridge.protocol.configurepage;

import java.util.List;

public class ConfigurePageRequest {
    private ConfigMessage config;
    private NavbarMessage navbar;

    public ConfigMessage getConfig() {
        return this.config;
    }

    public void setConfig(ConfigMessage configMessage) {
        this.config = configMessage;
    }

    public NavbarMessage getNavbar() {
        return this.navbar;
    }

    public void setNavbar(NavbarMessage navbarMessage) {
        this.navbar = navbarMessage;
    }

    public static class ConfigMessage {
        public static final int WEB_VIEW_TYPE_NEW = 1;
        public static final int WEB_VIEW_TYPE_NEW_WITH_WHITELIST = 2;
        public static final int WEB_VIEW_TYPE_OLD = 0;
        private List<String> bridgeWhitelist;
        private int disableReload;
        private int enableKeyboardFocus;
        private int enableRotation;
        private int webviewType;

        public int getDisableReload() {
            return this.disableReload;
        }

        public void setDisableReload(int i) {
            this.disableReload = i;
        }

        public int getEnableKeyboardFocus() {
            return this.enableKeyboardFocus;
        }

        public void setEnableKeyboardFocus(int i) {
            this.enableKeyboardFocus = i;
        }

        public int getEnableRotation() {
            return this.enableRotation;
        }

        public void setEnableRotation(int i) {
            this.enableRotation = i;
        }

        public int getWebviewType() {
            return this.webviewType;
        }

        public void setWebviewType(int i) {
            this.webviewType = i;
        }

        public List<String> getBridgeWhitelist() {
            return this.bridgeWhitelist;
        }

        public void setBridgeWhitelist(List<String> list) {
            this.bridgeWhitelist = list;
        }
    }

    public static class NavbarMessage {
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }
}
