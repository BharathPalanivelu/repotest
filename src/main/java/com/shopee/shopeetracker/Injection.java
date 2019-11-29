package com.shopee.shopeetracker;

import android.database.sqlite.SQLiteOpenHelper;
import com.shopee.shopeetracker.api.SendEventAPI;
import com.shopee.shopeetracker.data.SQLiteHelper;
import com.shopee.shopeetracker.interceptors.GzipRequestInterceptor;
import com.shopee.shopeetracker.utils.GsonUtils;
import f.b.a.a;
import f.e;
import f.n;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class Injection {
    private static OkHttpClient client = new OkHttpClient.Builder().build();
    private static EventSender eventSender;
    private static n gzipRetrofit;
    private static n retrofit;
    private static ScheduledExecutorService service;
    private static SQLiteHelper sqLiteHelper;

    public static EventRepository provideEventRepository() {
        return new EventRepository(provideSQLiteOpenHelper());
    }

    public static SQLiteOpenHelper provideSQLiteOpenHelper() {
        if (sqLiteHelper == null) {
            sqLiteHelper = new SQLiteHelper(provideTracker().getContext());
        }
        return sqLiteHelper;
    }

    public static ScheduledExecutorService provideScheduleService() {
        if (service == null) {
            service = new ScheduledThreadPoolExecutor(2);
        }
        return service;
    }

    static ShopeeTracker provideTracker() {
        return ShopeeTracker.getInstance();
    }

    public static synchronized EventSender provideEventSender() {
        EventSender eventSender2;
        synchronized (Injection.class) {
            if (eventSender == null) {
                eventSender = new EventSender(provideEventRepository(), provideSendEventAPI(), provideTracker().getConfig().getBatchSize(), provideTracker().getExtras(), provideTracker().getHandler(), provideTracker().getTrackLogger());
            }
            eventSender2 = eventSender;
        }
        return eventSender2;
    }

    public static SendEventAPI provideSendEventAPI() {
        return provideSendEventAPI(false);
    }

    public static SendEventAPI provideSendEventAPI(boolean z) {
        return (SendEventAPI) provideRetrofit(z).a(SendEventAPI.class);
    }

    private static synchronized n provideRetrofit() {
        n provideRetrofit;
        synchronized (Injection.class) {
            provideRetrofit = provideRetrofit(false);
        }
        return provideRetrofit;
    }

    private static synchronized n provideRetrofit(boolean z) {
        n nVar;
        synchronized (Injection.class) {
            if (z) {
                if (gzipRetrofit == null) {
                    gzipRetrofit = new n.a().a(provideOkHttpClient(true)).a(provideTracker().getBaseUrl()).a();
                }
                nVar = gzipRetrofit;
            } else {
                if (retrofit == null) {
                    retrofit = new n.a().a((e.a) a.a(GsonUtils.serializeNullsGson)).a(provideOkHttpClient()).a(provideTracker().getBaseUrl()).a();
                }
                nVar = retrofit;
            }
        }
        return nVar;
    }

    private static OkHttpClient provideOkHttpClient(boolean z) {
        OkHttpClient.Builder newBuilder = client.newBuilder();
        for (Interceptor addNetworkInterceptor : provideTracker().getInterceptors()) {
            newBuilder = newBuilder.addNetworkInterceptor(addNetworkInterceptor);
        }
        if (z) {
            newBuilder.addInterceptor(new GzipRequestInterceptor());
        }
        return newBuilder.build();
    }

    private static OkHttpClient provideOkHttpClient() {
        return provideOkHttpClient(false);
    }
}
