package com.shopee.app.web.protocol;

import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.google.a.o;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;

public class SearchConfig {
    private int currentSearchType;
    private String emptyViewText;
    private SearchConfigExtInfo extInfo;
    private boolean hideSearchHints;
    private boolean isGlobalSearch;
    private boolean isOfficialShopOnly;
    private o searchDefaultSuggestions;
    private o searchFirstPrefillItem;
    private o searchHotwords;
    private int searchMatchType;
    private String searchMatchValue;
    private int searchParam;
    private String searchPlaceholder;
    private String searchPlaceholderActive;
    private String searchPlaceholderColor;
    private o searchScope;
    private String searchText;
    private int searchType = 1;

    public SearchConfig() {
    }

    public SearchConfig(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, String str5, o oVar, o oVar2, o oVar3, String str6) {
        this.searchText = str;
        this.searchPlaceholder = str2;
        this.searchPlaceholderActive = str3;
        this.searchPlaceholderColor = str4;
        this.searchType = i;
        this.currentSearchType = i2;
        this.searchParam = i3;
        this.searchMatchType = i4;
        this.searchMatchValue = str5;
        this.searchHotwords = oVar;
        this.searchDefaultSuggestions = oVar2;
        this.searchScope = oVar3;
        this.emptyViewText = str6;
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

    public String getEmptyViewText() {
        return TextUtils.isEmpty(this.emptyViewText) ? getSearchPlaceholder() : this.emptyViewText;
    }

    public void setEmptyViewText(String str) {
        this.emptyViewText = str;
    }

    public String getSearchPlaceholderColor() {
        return this.searchPlaceholderColor;
    }

    public boolean isGlobalSearch() {
        return this.searchType == 0 || this.isGlobalSearch;
    }

    public boolean isOfficialShopOnly() {
        return this.isOfficialShopOnly;
    }

    public void setOfficialShopOnly(boolean z) {
        this.isOfficialShopOnly = z;
    }

    public o getSearchFirstPrefillItem() {
        return this.searchFirstPrefillItem;
    }

    public boolean isHideSearchHints() {
        return this.hideSearchHints;
    }

    public SearchConfigExtInfo getExtInfo() {
        return this.extInfo;
    }

    public static String defaultConfig() {
        return WebRegister.GSON.b(new SearchConfig("", "", "", "", 0, 0, 0, 0, "", (o) null, (o) null, (o) null, ""), SearchConfig.class);
    }

    public static SearchConfig defaultShopConfig() {
        return new SearchConfig("", b.e(R.string.sp_search_in_shop_placeholder), "", "", 8, 3, 0, 0, "", (o) null, (o) null, (o) null, b.e(R.string.sp_search_in_shop_empty_view_text));
    }

    public static SearchConfig defaultUserConfig() {
        return new SearchConfig("", "", "", "", 2, 1, 0, 0, "", (o) null, (o) null, (o) null, "");
    }
}
