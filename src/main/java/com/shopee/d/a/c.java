package com.shopee.d.a;

import android.text.TextUtils;
import com.shopee.d.a.a.a;
import com.shopee.d.a.c.b;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.bimodel.TrackingMeta;
import com.shopee.shopeetracker.model.Config;
import com.shopee.shopeetracker.utils.Logger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class c extends EventListener {

    /* renamed from: a  reason: collision with root package name */
    public static final EventListener.Factory f27127a = new EventListener.Factory() {
        public EventListener create(Call call) {
            if (a()) {
                return EventListener.NONE;
            }
            double samplingRate = ShopeeTracker.getInstance().getConfig().getSamplingRate();
            Logger.debug("TrackEventListener", "sampling rate = " + samplingRate + "%");
            if (Math.random() >= samplingRate / 100.0d) {
                return EventListener.NONE;
            }
            try {
                if (TextUtils.isEmpty(c.f27128c)) {
                    String unused = c.f27128c = c.d();
                }
                if (Pattern.matches(c.f27128c, call.request().url().toString())) {
                    return new c();
                }
                return EventListener.NONE;
            } catch (Exception unused2) {
                return EventListener.NONE;
            }
        }

        private boolean a() {
            if (!ShopeeTracker.isInitialized() || ShopeeTracker.getInstance().getConfig() == null || b.a(ShopeeTracker.getInstance().getContext()) || !ShopeeTracker.getInstance().getConfig().isHttpMetricsEnable()) {
                return true;
            }
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f27128c;

    /* renamed from: b  reason: collision with root package name */
    private a f27129b;

    /* renamed from: d  reason: collision with root package name */
    private String f27130d = UUID.randomUUID().toString();

    private static List<String> c() {
        ArrayList arrayList = new ArrayList();
        Config config = ShopeeTracker.getInstance().getConfig();
        TrackingMeta trackingMeta = ShopeeTracker.getInstance().getTrackingMeta();
        String lowerCase = trackingMeta != null ? trackingMeta.locale.toLowerCase() : "";
        if (config != null) {
            List<String> whiteUrlList = config.getWhiteUrlList();
            if (whiteUrlList != null && whiteUrlList.size() > 0) {
                for (String replace : whiteUrlList) {
                    arrayList.add(replace.replace("${domain_root}", lowerCase));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String d() {
        StringBuilder sb = new StringBuilder();
        for (String next : c()) {
            if (sb.length() > 0) {
                sb.append("|" + next);
            } else {
                sb.append(next);
            }
        }
        sb.insert(0, ".*(");
        sb.append(").*");
        return sb.toString();
    }

    public void callStart(Call call) {
        super.callStart(call);
        this.f27129b = new a();
        if (call != null && call.request() != null && call.request().url() != null) {
            a aVar = this.f27129b;
            aVar.endpoint = call.request().url().host() + call.request().url().encodedPath();
            this.f27129b.uuid = this.f27130d;
        }
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        this.f27129b.dnsLookupStart = Long.valueOf(System.currentTimeMillis());
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        this.f27129b.dnsLookupEnd = Long.valueOf(System.currentTimeMillis());
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        this.f27129b.connectStart = Long.valueOf(System.currentTimeMillis());
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.f27129b.connectEnd = Long.valueOf(System.currentTimeMillis());
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        this.f27129b.secureConnectStart = Long.valueOf(System.currentTimeMillis());
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        this.f27129b.secureConnectEnd = Long.valueOf(System.currentTimeMillis());
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        this.f27129b.requestStart = Long.valueOf(System.currentTimeMillis());
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        this.f27129b.requestEnd = Long.valueOf(System.currentTimeMillis());
    }

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        this.f27129b.requestEnd = Long.valueOf(System.currentTimeMillis());
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        this.f27129b.responseStart = Long.valueOf(System.currentTimeMillis());
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        this.f27129b.responseEnd = Long.valueOf(System.currentTimeMillis());
        if (response != null) {
            this.f27129b.statusCode = Integer.valueOf(response.code());
        }
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        this.f27129b.responseEnd = Long.valueOf(System.currentTimeMillis());
        this.f27129b.dataSize = Long.valueOf(j);
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        a aVar = this.f27129b;
        aVar.success = true;
        a(aVar);
        this.f27129b = new a();
        this.f27129b.uuid = this.f27130d;
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        a aVar = this.f27129b;
        aVar.success = false;
        a(aVar);
    }

    private void a(a aVar) {
        a.a(aVar);
    }
}
