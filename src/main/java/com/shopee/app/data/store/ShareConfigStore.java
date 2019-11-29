package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.beetalklib.a.a.b;
import com.google.a.c.a;
import com.shopee.app.data.store.SharingConfigInfo;
import com.shopee.app.h.a.e;
import com.shopee.app.h.d;
import com.shopee.app.util.ad;
import com.shopee.app.util.i;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareConfigStore extends ay {
    private b downloadCallback = new e() {
        /* access modifiers changed from: protected */
        public void onJSonObject(JSONObject jSONObject) throws JSONException {
            SharingConfigInfo unused = ShareConfigStore.this.sharingConfigInfo = new SharingConfigInfo();
            ShareConfigStore.this.sharingConfigInfo.setSharingInfo((Map) WebRegister.GSON.a(jSONObject.toString(), new a<Map<String, List<SharingConfigInfo.SharingDetailInfo>>>() {
            }.getType()));
            ShareConfigStore shareConfigStore = ShareConfigStore.this;
            shareConfigStore.setSharingData(shareConfigStore.sharingConfigInfo);
            ShareConfigStore shareConfigStore2 = ShareConfigStore.this;
            shareConfigStore2.setShareList(shareConfigStore2.sharingConfigInfo.getAppList(ShareConfigStore.this.locale));
            ShareConfigStore.this.setTimestamp(com.garena.android.appkit.tools.a.a.a());
        }
    };
    /* access modifiers changed from: private */
    public String locale;
    private ad<List<String>> mShareData;
    private List<String> memoryShareData;
    /* access modifiers changed from: private */
    public SharingConfigInfo sharingConfigInfo;
    private ad<SharingConfigInfo> sharingInfo;
    private c.a.a.a.b timestamp;

    public ShareConfigStore(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences);
        this.mShareData = new ad<>(sharedPreferences, "share_config", "[]", new a<List<String>>() {
        });
        this.sharingInfo = new ad<>(sharedPreferences, "sharingInfo", (String) null, new a<SharingConfigInfo>() {
        });
        this.timestamp = new c.a.a.a.b(sharedPreferences, "timestamp", 0);
        this.locale = str;
        checkDownload();
    }

    public List<String> getShareOptions() {
        List<String> list = this.memoryShareData;
        if (list != null && !list.isEmpty()) {
            return this.memoryShareData;
        }
        List<String> a2 = this.mShareData.a();
        if (a2.isEmpty()) {
            JSONObject a3 = d.a(R.raw.sharinginfo_v2);
            SharingConfigInfo sharingConfigInfo2 = new SharingConfigInfo();
            sharingConfigInfo2.setSharingInfo((Map) WebRegister.GSON.a(a3.toString(), new a<Map<String, List<SharingConfigInfo.SharingDetailInfo>>>() {
            }.getType()));
            List<String> appList = sharingConfigInfo2.getAppList(this.locale);
            fetchShareConfig();
            return appList;
        }
        this.memoryShareData = a2;
        return a2;
    }

    public SharingConfigInfo.AppDetailInfo getShareText(String str, boolean z, boolean z2) {
        SharingConfigInfo.AppDetailInfo appDetailInfo;
        SharingConfigInfo sharingConfigInfo2 = this.sharingConfigInfo;
        if (sharingConfigInfo2 != null) {
            appDetailInfo = sharingConfigInfo2.getAppDetail(this.locale, str, z, z2);
        } else {
            this.sharingConfigInfo = this.sharingInfo.a();
            SharingConfigInfo sharingConfigInfo3 = this.sharingConfigInfo;
            if (sharingConfigInfo3 == null) {
                fetchShareConfig();
                appDetailInfo = null;
            } else {
                appDetailInfo = sharingConfigInfo3.getAppDetail(this.locale, str, z, z2);
            }
        }
        if (appDetailInfo != null) {
            return appDetailInfo;
        }
        JSONObject a2 = d.a(R.raw.sharinginfo_v2);
        SharingConfigInfo sharingConfigInfo4 = new SharingConfigInfo();
        sharingConfigInfo4.setSharingInfo((Map) WebRegister.GSON.a(a2.toString(), new a<Map<String, List<SharingConfigInfo.SharingDetailInfo>>>() {
        }.getType()));
        return sharingConfigInfo4.getAppDetail(this.locale, str, z, z2);
    }

    private void checkDownload() {
        int a2 = com.garena.android.appkit.tools.a.a.a() - getTimestamp();
        if (a2 > 3600 || a2 < 0) {
            fetchShareConfig();
        }
    }

    private void fetchShareConfig() {
        com.shopee.app.h.a.a a2 = com.shopee.app.h.a.a.a();
        a2.a(i.f7040c + "backend/CMS/sharingv2.json", "ShareConfigStore", this.downloadCallback);
    }

    public int getTimestamp() {
        return this.timestamp.a();
    }

    public void setShareList(List<String> list) {
        this.mShareData.a(list);
        this.memoryShareData = list;
    }

    public void setSharingData(SharingConfigInfo sharingConfigInfo2) {
        this.sharingInfo.a(sharingConfigInfo2);
    }

    public void setTimestamp(int i) {
        this.timestamp.a(i);
    }
}
