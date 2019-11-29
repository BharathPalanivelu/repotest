package com.shopee.app.react.protocol;

import android.text.TextUtils;
import com.shopee.app.util.af;
import java.util.List;

public class NavbarItem {
    private List<NavMenuItem> dropdownMenu;
    private String eventID;
    private String icon;
    private String title;
    private String titleColor;

    private NavbarItem(Builder builder) {
        this.eventID = builder.eventID;
        this.title = builder.title;
        this.titleColor = builder.titleColor;
        setIcon(builder.icon);
        this.dropdownMenu = builder.dropdownMenu;
    }

    public String getEventID() {
        return this.eventID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String getIcon() {
        return this.icon;
    }

    public List<NavMenuItem> getDropdownMenu() {
        return this.dropdownMenu;
    }

    public boolean hasIcon() {
        return !TextUtils.isEmpty(this.icon);
    }

    public boolean isRemoteIcon() {
        return hasIcon() && this.icon.startsWith("http");
    }

    public boolean hasTitle() {
        return !TextUtils.isEmpty(this.title);
    }

    public boolean hasMenu() {
        return !af.a(this.dropdownMenu);
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setEventID(String str) {
        this.eventID = str;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<NavMenuItem> dropdownMenu;
        /* access modifiers changed from: private */
        public String eventID;
        /* access modifiers changed from: private */
        public String icon;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public String titleColor;

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder titleColor(String str) {
            this.titleColor = str;
            return this;
        }

        public Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public Builder dropdownMenu(List<NavMenuItem> list) {
            this.dropdownMenu = list;
            return this;
        }

        public NavbarItem build() {
            return new NavbarItem(this);
        }

        public Builder eventID(String str) {
            this.eventID = str;
            return this;
        }
    }
}
