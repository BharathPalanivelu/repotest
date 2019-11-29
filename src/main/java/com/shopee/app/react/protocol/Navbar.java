package com.shopee.app.react.protocol;

import java.util.List;

public class Navbar {
    private boolean hideShadow;
    private boolean isTransparent;
    private NavbarItem leftItem;
    private List<NavbarItem> rightItems;
    private SearchBar searchBar;
    private String title;
    private String titleColor;

    private Navbar(Builder builder) {
        this.hideShadow = false;
        this.title = builder.title;
        this.titleColor = builder.titleColor;
        this.isTransparent = builder.isTransparent;
        this.leftItem = builder.leftItem;
        this.rightItems = builder.rightItems;
        this.searchBar = builder.searchBar;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isTransparent() {
        return this.isTransparent;
    }

    public NavbarItem getLeftItem() {
        return this.leftItem;
    }

    public List<NavbarItem> getRightItems() {
        return this.rightItems;
    }

    public SearchBar getSearchBar() {
        return this.searchBar;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public boolean isHideShadow() {
        return this.hideShadow;
    }

    public void setHideShadow(boolean z) {
        this.hideShadow = z;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean isTransparent;
        /* access modifiers changed from: private */
        public NavbarItem leftItem;
        /* access modifiers changed from: private */
        public List<NavbarItem> rightItems;
        /* access modifiers changed from: private */
        public SearchBar searchBar;
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

        public Builder isTransparent(boolean z) {
            this.isTransparent = z;
            return this;
        }

        public Builder leftItem(NavbarItem navbarItem) {
            this.leftItem = navbarItem;
            return this;
        }

        public Builder rightItems(List<NavbarItem> list) {
            this.rightItems = list;
            return this;
        }

        public Builder searchBar(SearchBar searchBar2) {
            this.searchBar = searchBar2;
            return this;
        }

        public Navbar build() {
            return new Navbar(this);
        }
    }
}
