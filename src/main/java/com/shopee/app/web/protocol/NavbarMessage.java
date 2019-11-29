package com.shopee.app.web.protocol;

import com.google.a.o;
import com.shopee.app.ui.actionbar.e;
import com.shopee.id.R;
import java.util.HashMap;

public class NavbarMessage {
    public static final HashMap<String, e.b> mMap = new HashMap<>();
    private int currentSearchType = 0;
    private int hideBackButton = 0;
    private int isTransparent = 0;
    private String navbarBackgroundColor;
    private int navbarStyle = 0;
    private RightItemMessage rightItemsConfig;
    private o searchDefaultSuggestions;
    private o searchHotwords;
    private int searchMatchType;
    private String searchMatchValue;
    private int searchParam;
    private String searchPlaceholder;
    private String searchPlaceholderActive;
    private String searchPlaceholderColor;
    private o searchScope;
    private String searchText;
    private int searchType = 7;
    private int showCloseIcon = 0;
    private int showSearch;
    private String title;

    public String getNavbarBackgroundColor() {
        return this.navbarBackgroundColor;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getShowSearch() {
        return this.showSearch;
    }

    public void setShowSearch(int i) {
        this.showSearch = i;
    }

    public String getSearchText() {
        return this.searchText;
    }

    public String getSearchPlaceholder() {
        return this.searchPlaceholder;
    }

    public String getSearchPlaceholderActive() {
        return this.searchPlaceholderActive;
    }

    public int getSearchType() {
        return this.searchType;
    }

    public void setSearchType(int i) {
        this.searchType = i;
    }

    public RightItemMessage getRightItemsConfig() {
        return this.rightItemsConfig;
    }

    public void setRightItemsConfig(RightItemMessage rightItemMessage) {
        this.rightItemsConfig = rightItemMessage;
    }

    public SearchConfig getSearchConfig() {
        String str = this.searchText;
        String str2 = this.searchPlaceholder;
        return new SearchConfig(str, str2, this.searchPlaceholderActive, this.searchPlaceholderColor, this.searchType, this.currentSearchType, this.searchParam, this.searchMatchType, this.searchMatchValue, this.searchHotwords, this.searchDefaultSuggestions, this.searchScope, str2);
    }

    public int getIsTransparent() {
        return this.isTransparent;
    }

    public boolean showCloseIcon() {
        return this.showCloseIcon == 1;
    }

    public boolean hideBackButton() {
        return this.hideBackButton == 1;
    }

    public int getNavbarStyle() {
        return this.navbarStyle;
    }

    public int getCurrentSearchType() {
        return this.currentSearchType;
    }

    public int getSearchParam() {
        return this.searchParam;
    }

    public int getSearchMatchType() {
        return this.searchMatchType;
    }

    public String getSearchMatchValue() {
        return this.searchMatchValue;
    }

    public o getSearchHotwords() {
        return this.searchHotwords;
    }

    public o getSearchDefaultSuggestions() {
        return this.searchDefaultSuggestions;
    }

    public o getSearchScope() {
        return this.searchScope;
    }

    public String getSearchPlaceholderColor() {
        return this.searchPlaceholderColor;
    }

    static {
        mMap.put("home", new e.b(1, (int) R.string.sp_label_back_to_home, (Object) null, (int) R.drawable.ic_backtohomepage));
        mMap.put("reportitem", new e.b(3, (int) R.string.sp_report_product, (Object) null, (int) R.drawable.ic_reportthisuser));
        mMap.put("reportuser", new e.b(2, (int) R.string.sp_report_user, (Object) null, (int) R.drawable.ic_reportthisuser));
    }
}
