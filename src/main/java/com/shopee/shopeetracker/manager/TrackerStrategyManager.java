package com.shopee.shopeetracker.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.a.f;
import com.shopee.shopeetracker.api.SendEventAPI;
import com.shopee.shopeetracker.model.Config;
import com.shopee.shopeetracker.model.SettingModel;
import com.shopee.shopeetracker.utils.GsonUtils;
import com.shopee.shopeetracker.utils.Logger;
import f.b;
import f.b.a.a;
import f.d;
import f.e;
import f.m;
import f.n;
import java.util.HashMap;
import okhttp3.ResponseBody;

public class TrackerStrategyManager {
    private static final String CONFIG_KEY = "TRACKER_CONFIG_KEY";
    private static final String CONFIG_TIME_KEY = "TRACKER_CONFIG_TIME_KEY";
    private static final String SP_NAME = "TRACKER_CONFIG";
    private static final String TAG = "TrackerStrategyManager";
    private static TrackerStrategyManager instance;
    private SendEventAPI api;
    private HashMap<String, String> config = new HashMap<>();
    private Context context;
    /* access modifiers changed from: private */
    public SharedPreferences sp;

    private TrackerStrategyManager(Context context2) {
        this.context = context2;
        this.sp = context2.getSharedPreferences(SP_NAME, 0);
    }

    public static void createManager(Context context2) {
        if (instance == null) {
            instance = new TrackerStrategyManager(context2);
        }
    }

    public static TrackerStrategyManager getInstance() {
        TrackerStrategyManager trackerStrategyManager = instance;
        if (trackerStrategyManager != null) {
            return trackerStrategyManager;
        }
        throw new IllegalStateException("createManager before you getInstance");
    }

    private boolean calculateTimeDiff() {
        long currentTimeMillis = System.currentTimeMillis() - this.sp.getLong(CONFIG_TIME_KEY, 0);
        boolean z = currentTimeMillis > 3600000 || currentTimeMillis <= 0;
        Logger.debug(TAG, "result = " + z);
        return z;
    }

    public void asyncRequestTrackerConfig(String str) {
        if (this.api == null) {
            this.api = (SendEventAPI) new n.a().a((e.a) a.a(GsonUtils.serializeNullsGson)).a("http://content.garena.com/").a().a(SendEventAPI.class);
        }
        if (calculateTimeDiff()) {
            try {
                this.api.sendGet(str).a(new d<ResponseBody>() {
                    public void onFailure(b<ResponseBody> bVar, Throwable th) {
                    }

                    public void onResponse(b<ResponseBody> bVar, m<ResponseBody> mVar) {
                        try {
                            String string = mVar.e().string();
                            if (!TextUtils.isEmpty(string)) {
                                SharedPreferences.Editor edit = TrackerStrategyManager.this.sp.edit();
                                edit.putString(TrackerStrategyManager.CONFIG_KEY, string);
                                edit.putLong(TrackerStrategyManager.CONFIG_TIME_KEY, System.currentTimeMillis());
                                edit.apply();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                Logger.debug(e2.toString());
            }
        }
    }

    public Config parseConfig() {
        Config config2 = new Config(true, 14400, 200, 20);
        String string = this.sp.getString(CONFIG_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return config2;
        }
        try {
            HashMap<String, Config> hashMap = ((SettingModel) new f().a(string, new com.google.a.c.a<SettingModel>() {
            }.getType())).trackerConfig;
            if (!hashMap.containsKey("default")) {
                return config2;
            }
            Config config3 = hashMap.get("default");
            if (config3 != null) {
                return config3;
            }
            return config2;
        } catch (Exception e2) {
            Logger.debug(e2.getMessage());
            return config2;
        }
    }
}
