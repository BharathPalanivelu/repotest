package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.d;
import com.beetalklib.a.a.b;
import com.google.a.c.a;
import com.shopee.app.data.viewmodel.ServerData;
import com.shopee.app.util.ab;
import com.shopee.app.util.ad;
import com.shopee.app.util.bh;
import com.shopee.app.util.i;
import com.shopee.app.web.WebRegister;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class ServerConfigStore extends ay {
    private b downloadCallback = new ab() {
        /* access modifiers changed from: protected */
        public void onJSONArray(JSONArray jSONArray) throws JSONException {
            ServerConfigStore.this.mServerData.a((List) WebRegister.GSON.a(jSONArray.toString(), new a<List<ServerData>>() {
            }.getType()));
            ServerConfigStore.this.mLastUpdateTime.a(ServerConfigStore.this.mTimeUtil.a());
        }
    };
    private d mConnectionURL;
    private final com.shopee.app.h.a.a mDownloadManager;
    private d mFileServerURL;
    private d mImageSearchUploadServerURL;
    /* access modifiers changed from: private */
    public c.a.a.a.b mLastUpdateTime;
    private c.a.a.a.b mLastUsedTime;
    /* access modifiers changed from: private */
    public ad<List<ServerData>> mServerData;
    /* access modifiers changed from: private */
    public final bh mTimeUtil;

    public ServerConfigStore(SharedPreferences sharedPreferences, bh bhVar, com.shopee.app.h.a.a aVar) {
        super(sharedPreferences);
        this.mTimeUtil = bhVar;
        this.mDownloadManager = aVar;
        this.mServerData = new ad<>(sharedPreferences, "server_config", "[]", new a<List<ServerData>>() {
        });
        this.mFileServerURL = new d(sharedPreferences, "file_server_url", "f.shopee.co.id:18080");
        this.mImageSearchUploadServerURL = new d(sharedPreferences, "image_search_upload_server_url", "cf.imagesearch.shopee.co.id:18080");
        this.mConnectionURL = new d(sharedPreferences, "conn_server_url", i.f7039b);
        this.mLastUpdateTime = new c.a.a.a.b(sharedPreferences, "timestamp", 0);
        this.mLastUsedTime = new c.a.a.a.b(sharedPreferences, "last_used_timestamp", 0);
    }

    public void checkDownload() {
        int a2 = this.mTimeUtil.a() - getLastUpdateTime();
        if (a2 > 21600 || a2 < 0) {
            fetchServerConfig();
        }
    }

    private void fetchServerConfig() {
        com.garena.android.appkit.d.a.b("image-search config fetchServerConfig", new Object[0]);
        this.mDownloadManager.a("http://content.garena.com/shopee/conf_a/ip.json", "server_info", this.downloadCallback);
    }

    public List<ServerData> getServerData() {
        return this.mServerData.a();
    }

    public String getFileServerURL() {
        return this.mFileServerURL.a();
    }

    public void setFileServerURL(String str) {
        this.mFileServerURL.a(str);
    }

    public String getImageSearchUploadServerURL() {
        return this.mImageSearchUploadServerURL.a();
    }

    public void setImageSearchUploadServerURL(String str) {
        this.mImageSearchUploadServerURL.a(str);
    }

    public String getConnectionURL() {
        return this.mConnectionURL.a();
    }

    public void setConnectionURL(String str) {
        this.mConnectionURL.a(str);
    }

    public int getLastUpdateTime() {
        return this.mLastUpdateTime.a();
    }

    public void setLastUpdateTime(int i) {
        this.mLastUpdateTime.a(i);
    }

    public int getLastUsedTime() {
        return this.mLastUsedTime.a();
    }

    public void setLastUsedTime(int i) {
        this.mLastUsedTime.a(i);
    }
}
