package com.shopee.app.data.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.beetalklib.a.a.b;
import com.garena.android.appkit.b.b;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.h.a.e;
import com.shopee.app.util.ad;
import com.shopee.app.util.af;
import com.shopee.app.util.l;
import com.shopee.app.web.WebRegister;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchKeywordsStore extends ay {
    private static final int MAX_HASH_TAG_HISTORY_LENGTH = 20;
    private static final int MAX_SEARCH_HISTORY_LENGTH = 10;
    private static final int MAX_SUB_CAT_HISTORY_LENGTH = 5;
    private b hashTagDownloadCallback = new e() {
        /* access modifiers changed from: protected */
        public void onJSonObject(JSONObject jSONObject) throws JSONException {
            SearchKeywordsStore.this.setEditHotHashTag((HotHashTag) WebRegister.GSON.a(jSONObject.toString(), new a<HotHashTag>() {
            }.getType()));
            SearchKeywordsStore.this.setTimestamp(com.garena.android.appkit.tools.a.a.a());
            com.garena.android.appkit.b.b.a("HOT_HASH_TAG_DOWNLOAD", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    private ad<List<String>> mHashTagEditHistory;
    private ad<List<String>> mHashTagSearchHistory;
    private ad<HotHashTag> mHotHashTag;
    private KeywordObject mKeyWordObject;
    private ad<List<String>> mPrevSearchHistory;
    private ad<List<SearchHistoryData>> mProductHistory;
    private ad<KeywordObject> mSearchKeywords;
    private ad<List<SearchHistoryData>> mShopHintHistory;
    private ad<List<Integer>> mSubCategorySelectHistory;
    private ad<List<SearchHistoryData>> mUserSearchHistory;
    private com.beetalklib.a.a.b searchDownloadCallback = new e() {
        /* access modifiers changed from: protected */
        public void onJSonObject(JSONObject jSONObject) throws JSONException {
            SearchKeywordsStore.this.setSearchKeywords((KeywordObject) WebRegister.GSON.a(jSONObject.toString(), new a<KeywordObject>() {
            }.getType()));
            SearchKeywordsStore.this.setTimestamp(com.garena.android.appkit.tools.a.a.a());
            com.garena.android.appkit.b.b.a("LOAD_SEARCH_HIT", new com.garena.android.appkit.b.a(), b.a.UI_BUS);
        }
    };
    private c.a.a.a.b timestamp;

    public SearchKeywordsStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.mSearchKeywords = new ad<>(sharedPreferences, "search_keyword", ServiceLogger.PLACEHOLDER, new a<KeywordObject>() {
        });
        this.mPrevSearchHistory = new ad<>(sharedPreferences, "search_history", "[]", new a<List<String>>() {
        });
        this.mProductHistory = new ad<>(sharedPreferences, "search_history_v1", "[]", new a<List<SearchHistoryData>>() {
        });
        this.mShopHintHistory = new ad<>(sharedPreferences, "shop_hint_history_v1", "[]", new a<List<SearchHistoryData>>() {
        });
        this.mUserSearchHistory = new ad<>(sharedPreferences, "search_user_history_v1", "[]", new a<List<SearchHistoryData>>() {
        });
        this.mHashTagSearchHistory = new ad<>(sharedPreferences, "hash_tag_history", "[]", new a<List<String>>() {
        });
        this.mHashTagEditHistory = new ad<>(sharedPreferences, "hash_tag_edit_history", "[]", new a<List<String>>() {
        });
        this.mSubCategorySelectHistory = new ad<>(sharedPreferences, "subcategory_select_history", "[]", new a<List<Integer>>() {
        });
        this.mHotHashTag = new ad<>(sharedPreferences, "hash_tag_edit_hot", ServiceLogger.PLACEHOLDER, new a<HotHashTag>() {
        });
        this.timestamp = new c.a.a.a.b(sharedPreferences, "timestamp", 0);
        checkDownload();
    }

    private void checkDownload() {
        int a2 = com.garena.android.appkit.tools.a.a.a() - getTimestamp();
        if (a2 > 3600 || a2 < 0) {
            fetchSearchKeywords();
        }
    }

    private void fetchSearchKeywords() {
        com.shopee.app.h.a.a.a().a(l.f7051g, "SearchKeywordsStore", this.searchDownloadCallback);
        com.shopee.app.h.a.a.a().a(l.i, "RecommendedEditHashTags", this.hashTagDownloadCallback);
    }

    public int getTimestamp() {
        return this.timestamp.a();
    }

    /* access modifiers changed from: private */
    public void setSearchKeywords(KeywordObject keywordObject) {
        this.mSearchKeywords.a(keywordObject);
    }

    public List<String> getSearchKeywords() {
        this.mKeyWordObject = this.mSearchKeywords.a();
        return this.mKeyWordObject.all;
    }

    /* access modifiers changed from: private */
    public void setEditHotHashTag(HotHashTag hotHashTag) {
        this.mHotHashTag.a(hotHashTag);
    }

    public List<String> getEditHotHashTags() {
        return this.mHotHashTag.a().hot_hashtags;
    }

    public List<String> getSearchKeywords(int i) {
        if (i == 0) {
            return getSearchKeywords();
        }
        this.mKeyWordObject = this.mSearchKeywords.a();
        ArrayList arrayList = new ArrayList();
        if (this.mKeyWordObject.cat.get(Integer.valueOf(i)) != null) {
            arrayList.addAll((Collection) this.mKeyWordObject.cat.get(Integer.valueOf(i)));
        }
        return arrayList;
    }

    public List<SearchHistoryData> getProductHistoryWithNoCategory() {
        return af.a(this.mProductHistory.a(), new af.a<SearchHistoryData>() {
            public boolean shouldInclude(SearchHistoryData searchHistoryData) {
                return searchHistoryData.getCateId() <= 0;
            }
        });
    }

    public List<SearchHistoryData> getProductHistory() {
        return this.mProductHistory.a();
    }

    public List<SearchHistoryData> getProductHistoryWithShopHintAndCategory() {
        ArrayList arrayList = new ArrayList(this.mProductHistory.a());
        arrayList.addAll(af.a(this.mUserSearchHistory.a(), new af.b<SearchHistoryData, SearchHistoryData>() {
            public SearchHistoryData map(SearchHistoryData searchHistoryData) {
                searchHistoryData.setShowType(true);
                return searchHistoryData;
            }
        }));
        Collections.sort(arrayList, new Comparator<SearchHistoryData>() {
            public int compare(SearchHistoryData searchHistoryData, SearchHistoryData searchHistoryData2) {
                return (((int) (searchHistoryData.getTimestamp() / 1000)) - ((int) (searchHistoryData2.getTimestamp() / 1000))) * -1;
            }
        });
        return arrayList;
    }

    public void addShopHistory(String str) {
        addProductHistory(str, "", 0, 1, false, (String) null, -1);
    }

    public void addProductHistory(SearchProductItem searchProductItem, int i) {
        addProductHistory(searchProductItem.getKeyword(), searchProductItem.getCategoryName(), searchProductItem.getCateId(), i, searchProductItem.isHashTagHint(), searchProductItem.getTrackingId(), searchProductItem.getHintSourceType());
    }

    private void addProductHistory(String str, String str2, int i, int i2, boolean z, String str3, int i3) {
        List list;
        String trim = str.trim();
        if (!TextUtils.isEmpty(trim)) {
            String replaceAll = trim.replaceAll("\"", "");
            if (i2 != 0) {
                list = this.mShopHintHistory.a();
            } else {
                list = this.mProductHistory.a();
            }
            SearchHistoryData build = new SearchHistoryData.Builder().keyword(replaceAll).type(i2).categoryName(str2).cateId(i).hashTagHint(z).trackingId(str3).hintSourceType(i3).build();
            if (list.contains(build)) {
                list.remove(build);
            }
            list.add(0, build);
            if (list.size() > 10) {
                list.remove(list.size() - 1);
            }
            if (i2 != 0) {
                this.mShopHintHistory.a(list);
            } else {
                this.mProductHistory.a(list);
            }
        }
    }

    public void clearProductHistory() {
        ArrayList arrayList = new ArrayList();
        this.mProductHistory.a(arrayList);
        this.mShopHintHistory.a(arrayList);
    }

    public List<SearchHistoryData> getUserHistory() {
        return this.mUserSearchHistory.a();
    }

    public void addUserHistory(String str, int i) {
        addUserHistory(str, i, 0);
    }

    public void addUserHistory(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            SearchHistoryData build = new SearchHistoryData.Builder().type(2).userId(i).shopId(i2).keyword(str).build();
            List a2 = this.mUserSearchHistory.a();
            if (a2.contains(build)) {
                a2.remove(build);
            }
            a2.add(0, build);
            if (a2.size() > 10) {
                a2.remove(a2.size() - 1);
            }
            this.mUserSearchHistory.a(a2);
        }
    }

    public void clearUserHistory() {
        this.mUserSearchHistory.a(new ArrayList());
    }

    public List<String> getHashTagSearchHistory() {
        return this.mHashTagSearchHistory.a();
    }

    public void addHashTagSearchHistory(String str) {
        String lowerCase = str.toLowerCase();
        List a2 = this.mHashTagSearchHistory.a();
        if (!TextUtils.isEmpty(lowerCase)) {
            if (a2.contains(lowerCase)) {
                a2.remove(lowerCase);
            }
            a2.add(0, lowerCase);
            if (a2.size() > 10) {
                a2.remove(a2.size() - 1);
            }
            this.mHashTagSearchHistory.a(a2);
        }
    }

    public void clearHashTagSearchHistory() {
        this.mHashTagSearchHistory.a(new ArrayList());
    }

    public List<String> getHashTagEditHistory() {
        return this.mHashTagEditHistory.a();
    }

    public void addHashTagEditHistory(String str) {
        String lowerCase = str.toLowerCase();
        List a2 = this.mHashTagEditHistory.a();
        if (!TextUtils.isEmpty(lowerCase)) {
            if (a2.contains(lowerCase)) {
                a2.remove(lowerCase);
            }
            a2.add(0, lowerCase);
            if (a2.size() > 20) {
                a2.remove(a2.size() - 1);
            }
            this.mHashTagEditHistory.a(a2);
        }
    }

    public void clearHashTagEditHistory() {
        this.mHashTagEditHistory.a(new ArrayList());
    }

    public List<Integer> getSubCategorySelectHistory() {
        return this.mSubCategorySelectHistory.a();
    }

    public List<String> getPrevSearchHistory() {
        return this.mPrevSearchHistory.a();
    }

    public void addSubCategorySelectHistory(Integer num) {
        List a2 = this.mSubCategorySelectHistory.a();
        if (a2.contains(num)) {
            a2.remove(num);
        }
        a2.add(0, num);
        if (a2.size() > 5) {
            a2.remove(a2.size() - 1);
        }
        this.mSubCategorySelectHistory.a(a2);
    }

    public void setTimestamp(int i) {
        this.timestamp.a(i);
    }

    private static class KeywordObject {
        /* access modifiers changed from: private */
        public List<String> all = new ArrayList();
        /* access modifiers changed from: private */
        public HashMap<Integer, List<String>> cat = new HashMap<>();

        private KeywordObject() {
        }
    }

    private static class HotHashTag {
        /* access modifiers changed from: private */
        public List<String> hot_hashtags = new ArrayList();

        private HotHashTag() {
        }
    }
}
