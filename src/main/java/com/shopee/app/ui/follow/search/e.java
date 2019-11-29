package com.shopee.app.ui.follow.search;

import android.graphics.Rect;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.google.a.i;
import com.google.a.o;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.viewmodel.HotWordData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f21785a = new ArrayList();

    public interface a {
        void a(String str, String str2);
    }

    static {
        f21785a.add("b");
        f21785a.add("b2");
        f21785a.add("y2");
    }

    private static SearchProductItem a(String str, String str2, int i, int i2) {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setKeyword(str);
        searchProductItem.setCategoryName(str2);
        searchProductItem.setType(i2);
        searchProductItem.setCateId(i);
        return searchProductItem;
    }

    private static SearchProductItem a(String str, int i) {
        return a(str, (String) null, 0, i);
    }

    public static List<SearchProductItem> a(List<SearchHistoryData> list, int i) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (i >= 0) {
            boolean z2 = list.size() > i;
            list = list.subList(0, Math.min(i, list.size()));
            z = z2;
        }
        for (SearchHistoryData next : list) {
            SearchProductItem a2 = a(next.getKeywordDisplay(), next.getCategoryName(), next.getCateId(), 4);
            a2.setExtra(next);
            a2.setHashTagHint(next.isHashTagHint());
            arrayList.add(a2);
        }
        if (z) {
            arrayList.add(a(b.e(R.string.sp_label_show_more), 3));
        } else if (list.size() > 0) {
            arrayList.add(a(b.e(R.string.sp_label_clear_search_history), 5));
        }
        return arrayList;
    }

    public static SearchProductItem a(List<String> list, String str) {
        return a(list, str, 0);
    }

    public static SearchProductItem a(List<String> list, String str, List<HotWordData> list2) {
        return a(list, str, 0, list2);
    }

    public static SearchProductItem a(List<String> list, String str, int i) {
        return a(list, str, i, (List<HotWordData>) Collections.emptyList());
    }

    public static SearchProductItem a(List<String> list, String str, int i, List<HotWordData> list2) {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setKeywords(list);
        searchProductItem.setKeywordsTrackingData(list2);
        searchProductItem.setKeyword(str);
        searchProductItem.setType(1);
        searchProductItem.setExtra(Integer.valueOf(i));
        searchProductItem.setCount(list.size());
        return searchProductItem;
    }

    public static SearchProductItem a(String str, List<HotWordData> list) {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setKeywords((List<String>) null);
        searchProductItem.setKeywordsTrackingData(list);
        searchProductItem.setKeyword(str);
        searchProductItem.setType(13);
        searchProductItem.setCount(list.size());
        return searchProductItem;
    }

    public static SearchProductItem a() {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setType(7);
        return searchProductItem;
    }

    public static SearchProductItem a(String str, boolean z) {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setType(2);
        searchProductItem.setKeyword(str);
        searchProductItem.setExtra(Boolean.valueOf(z));
        return searchProductItem;
    }

    public static String a(String str) {
        for (String next : f21785a) {
            String replace = str.replace(SimpleComparison.LESS_THAN_OPERATION + next + SimpleComparison.GREATER_THAN_OPERATION, "");
            str = replace.replace("</" + next + SimpleComparison.GREATER_THAN_OPERATION, "");
        }
        return str;
    }

    public static void a(List<SearchProductItem> list, o oVar, int i, String str, TextView textView) {
        String str2;
        String valueOf = String.valueOf(i);
        if (oVar != null && oVar.b(valueOf)) {
            i d2 = oVar.d(valueOf);
            int i2 = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < d2.a(); i4++) {
                int a2 = a(textView, a(d2.a(i4).m().c("text").c()).replace("#{searchText}", str.replace("\"", "")));
                if (a2 > i2) {
                    i3 = i4;
                    i2 = a2;
                }
            }
            int b2 = b.b() - b.a.n;
            if (i2 > b2) {
                String a3 = a(d2.a(i3).m().c("text").c());
                String replace = str.replace("\"", "");
                boolean z = false;
                while (!z) {
                    if (replace.length() > 1) {
                        replace = replace.substring(0, replace.length() - 1);
                    } else {
                        z = true;
                    }
                    if (a(textView, a3.replace("#{searchText}", replace + "...")) < b2) {
                        z = true;
                    }
                }
                str2 = replace + "...";
            } else {
                str2 = str;
            }
            for (int i5 = 0; i5 < d2.a(); i5++) {
                String c2 = d2.a(i5).m().c("text").c();
                SearchProductItem searchProductItem = new SearchProductItem();
                searchProductItem.setKeywords(Arrays.asList(new String[]{str.replace("\"", "")}));
                searchProductItem.setKeyword(c2.replace("#{searchText}", str2.replace("\"", "")));
                searchProductItem.setType(6);
                searchProductItem.setCount(i5);
                list.add(i5, searchProductItem);
            }
            if (d2.a() > 0 && list.size() > d2.a()) {
                list.add(d2.a(), a());
            }
        }
    }

    private static int a(TextView textView, String str) {
        Rect rect = new Rect();
        textView.getPaint().getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }
}
