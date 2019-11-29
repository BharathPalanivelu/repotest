package com.tencent.liteav.network;

import com.facebook.common.util.UriUtil;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c {

    /* renamed from: a  reason: collision with root package name */
    public b f31748a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f31749b = 5;

    /* renamed from: c  reason: collision with root package name */
    private final String f31750c = "http://tcdns.myqcloud.com/queryip";

    /* renamed from: d  reason: collision with root package name */
    private final String f31751d = "forward_stream";

    /* renamed from: e  reason: collision with root package name */
    private final String f31752e = "forward_num";

    /* renamed from: f  reason: collision with root package name */
    private final String f31753f = "request_type";

    /* renamed from: g  reason: collision with root package name */
    private final String f31754g = "sdk_version";
    private final String h = "51451748-d8f2-4629-9071-db2983aa7251";
    private Thread i = null;

    c() {
    }

    public void a(final String str, final int i2) {
        this.i = new Thread("TXCPushRoute") {
            public void run() {
                if (c.this.f31748a != null) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        if (i >= 5) {
                            break;
                        }
                        try {
                            String a2 = c.this.b(str, i2);
                            try {
                                JSONObject jSONObject = new JSONObject(a2);
                                if (jSONObject.has("use") && jSONObject.getInt("use") == 0) {
                                    break;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            arrayList = c.this.a(a2);
                            if (arrayList != null && arrayList.size() > 0) {
                                break;
                            }
                            sleep(1000, 0);
                            i++;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.this.f31748a.onFetchDone(0, arrayList);
                }
            }
        };
        this.i.start();
    }

    /* access modifiers changed from: private */
    public String b(String str, int i2) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            InputStream c2 = c(str, i2);
            if (c2 == null) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(c2));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            return stringBuffer.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private InputStream c(String str, int i2) throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("http://tcdns.myqcloud.com/queryip").openConnection()));
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("forward_stream", str);
            httpURLConnection.setRequestProperty("forward_num", "2");
            httpURLConnection.setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
            if (i2 == 1) {
                httpURLConnection.setRequestProperty("request_type", "1");
            } else if (i2 == 2) {
                httpURLConnection.setRequestProperty("request_type", "2");
            } else {
                httpURLConnection.setRequestProperty("request_type", "3");
            }
            if (this.f31749b > 0) {
                httpURLConnection.setConnectTimeout(this.f31749b * 1000);
                httpURLConnection.setReadTimeout(this.f31749b * 1000);
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection.getInputStream();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<a> a(String str) {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(ServerProtocol.DIALOG_PARAM_STATE) != 0) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONObject(UriUtil.LOCAL_CONTENT_SCHEME).getJSONArray("list");
            if (jSONArray == null) {
                return null;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                a a2 = a((JSONObject) jSONArray.opt(i2));
                if (a2 != null && a2.f31725c) {
                    arrayList.add(a2);
                }
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                a a3 = a((JSONObject) jSONArray.opt(i3));
                if (a3 != null && !a3.f31725c) {
                    arrayList.add(a3);
                }
            }
            if (b.a().a("Network", "EnableRouteOptimize") != 1 || !m.a().c()) {
                long a4 = b.a().a("Network", "RouteSamplingMaxCount");
                if (a4 >= 1) {
                    long a5 = m.a().a("51451748-d8f2-4629-9071-db2983aa7251");
                    if (a5 <= a4) {
                        arrayList = a(arrayList, false);
                        m.a().a("51451748-d8f2-4629-9071-db2983aa7251", a5 + 1);
                    }
                }
                a(arrayList);
                return arrayList;
            }
            ArrayList<a> a6 = a(arrayList, true);
            a(a6);
            return a6;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    private a a(JSONObject jSONObject) {
        a aVar = new a();
        try {
            aVar.f31723a = jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            aVar.f31724b = jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
            aVar.f31727e = 0;
            aVar.f31725c = false;
            aVar.f31726d = b(aVar.f31723a);
            if (jSONObject.has("type") && jSONObject.getInt("type") == 2) {
                aVar.f31725c = true;
            }
            return aVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean b(String str) {
        if (str != null) {
            for (String c2 : str.split("[.]")) {
                if (!c(c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean c(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private ArrayList<a> a(ArrayList<a> arrayList, boolean z) {
        a aVar;
        a aVar2 = null;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<a> it = arrayList.iterator();
        loop0:
        while (true) {
            aVar = aVar2;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                aVar2 = it.next();
                if (aVar2.f31725c) {
                    arrayList2.add(aVar2);
                } else if (!aVar2.f31726d) {
                    arrayList3.add(aVar2);
                }
            }
        }
        ArrayList<a> arrayList4 = new ArrayList<>();
        while (true) {
            if (arrayList2.size() <= 0 && arrayList3.size() <= 0) {
                break;
            }
            if (z) {
                if (aVar != null) {
                    arrayList4.add(aVar);
                }
                if (arrayList2.size() > 0) {
                    arrayList4.add(arrayList2.get(0));
                    arrayList2.remove(0);
                }
            } else {
                if (arrayList2.size() > 0) {
                    arrayList4.add(arrayList2.get(0));
                    arrayList2.remove(0);
                }
                if (aVar != null) {
                    arrayList4.add(aVar);
                }
            }
            if (arrayList3.size() > 0) {
                arrayList4.add(arrayList3.get(0));
                arrayList3.remove(0);
            }
        }
        int size = arrayList4.size();
        if (size > 0) {
            a aVar3 = arrayList4.get(size - 1);
            if (!(aVar3 == null || b(aVar3.f31723a) || aVar == null)) {
                arrayList4.add(aVar);
            }
        }
        return arrayList4;
    }

    private void a(ArrayList<a> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<a> it = arrayList.iterator();
            String str = "";
            while (it.hasNext()) {
                a next = it.next();
                str = str + " \n Nearest IP: " + next.f31723a + " Port: " + next.f31724b + " Q Channel: " + next.f31725c;
            }
            TXCLog.e("TXCIntelligentRoute", str);
        }
    }
}
