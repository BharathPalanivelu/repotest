package com.dieam.reactnativepushnotification.modules;

import android.os.Bundle;
import android.util.Log;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6639a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6640b;

    /* renamed from: c  reason: collision with root package name */
    private final double f6641c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6642d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6643e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6644f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6645g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final double r;
    private final String s;
    private final String t;
    private final String u;
    private final double v;
    private final boolean w;

    public a(Bundle bundle) {
        this.f6639a = bundle.getString("id");
        this.f6640b = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.f6641c = bundle.getDouble("fireDate");
        this.f6642d = bundle.getString("title");
        this.f6643e = bundle.getString("ticker");
        this.f6644f = bundle.getBoolean("autoCancel");
        this.f6645g = bundle.getString("largeIcon");
        this.h = bundle.getString("smallIcon");
        this.i = bundle.getString("bigText");
        this.j = bundle.getString("subText");
        this.k = bundle.getString("number");
        this.l = bundle.getString("sound");
        this.m = bundle.getString(ViewProps.COLOR);
        this.n = bundle.getString("group");
        this.o = bundle.getBoolean("userInteraction");
        this.p = bundle.getBoolean("playSound");
        this.q = bundle.getBoolean("vibrate");
        this.r = bundle.getDouble("vibration");
        this.s = bundle.getString("actions");
        this.t = bundle.getString("tag");
        this.u = bundle.getString("repeatType");
        this.v = bundle.getDouble("repeatTime");
        this.w = bundle.getBoolean("ongoing");
    }

    private a(JSONObject jSONObject) {
        try {
            String str = null;
            this.f6639a = jSONObject.has("id") ? jSONObject.getString("id") : null;
            this.f6640b = jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_MESSAGE) ? jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE) : null;
            double d2 = 0.0d;
            this.f6641c = jSONObject.has("fireDate") ? jSONObject.getDouble("fireDate") : 0.0d;
            this.f6642d = jSONObject.has("title") ? jSONObject.getString("title") : null;
            this.f6643e = jSONObject.has("ticker") ? jSONObject.getString("ticker") : null;
            boolean z = true;
            this.f6644f = jSONObject.has("autoCancel") ? jSONObject.getBoolean("autoCancel") : true;
            this.f6645g = jSONObject.has("largeIcon") ? jSONObject.getString("largeIcon") : null;
            this.h = jSONObject.has("smallIcon") ? jSONObject.getString("smallIcon") : null;
            this.i = jSONObject.has("bigText") ? jSONObject.getString("bigText") : null;
            this.j = jSONObject.has("subText") ? jSONObject.getString("subText") : null;
            this.k = jSONObject.has("number") ? jSONObject.getString("number") : null;
            this.l = jSONObject.has("sound") ? jSONObject.getString("sound") : null;
            this.m = jSONObject.has(ViewProps.COLOR) ? jSONObject.getString(ViewProps.COLOR) : null;
            this.n = jSONObject.has("group") ? jSONObject.getString("group") : null;
            this.o = jSONObject.has("userInteraction") ? jSONObject.getBoolean("userInteraction") : false;
            this.p = jSONObject.has("playSound") ? jSONObject.getBoolean("playSound") : true;
            this.q = jSONObject.has("vibrate") ? jSONObject.getBoolean("vibrate") : z;
            this.r = jSONObject.has("vibration") ? jSONObject.getDouble("vibration") : 1000.0d;
            this.s = jSONObject.has("actions") ? jSONObject.getString("actions") : null;
            this.t = jSONObject.has("tag") ? jSONObject.getString("tag") : null;
            this.u = jSONObject.has("repeatType") ? jSONObject.getString("repeatType") : str;
            this.v = jSONObject.has("repeatTime") ? jSONObject.getDouble("repeatTime") : d2;
            this.w = jSONObject.has("ongoing") ? jSONObject.getBoolean("ongoing") : false;
        } catch (JSONException e2) {
            throw new IllegalStateException("Exception while initializing RNPushNotificationAttributes from JSON", e2);
        }
    }

    public static a a(String str) throws JSONException {
        return new a(new JSONObject(str));
    }

    public boolean a(ReadableMap readableMap) {
        Bundle a2 = a();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (!a2.containsKey(nextKey)) {
                return false;
            }
            switch (readableMap.getType(nextKey)) {
                case Null:
                    if (a2.get(nextKey) == null) {
                        break;
                    } else {
                        return false;
                    }
                case Boolean:
                    if (readableMap.getBoolean(nextKey) == a2.getBoolean(nextKey)) {
                        break;
                    } else {
                        return false;
                    }
                case Number:
                    if (!(readableMap.getDouble(nextKey) == a2.getDouble(nextKey) || readableMap.getInt(nextKey) == a2.getInt(nextKey))) {
                        return false;
                    }
                case String:
                    if (readableMap.getString(nextKey).equals(a2.getString(nextKey))) {
                        break;
                    } else {
                        return false;
                    }
                case Map:
                case Array:
                    return false;
            }
        }
        return true;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f6639a);
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f6640b);
        bundle.putDouble("fireDate", this.f6641c);
        bundle.putString("title", this.f6642d);
        bundle.putString("ticker", this.f6643e);
        bundle.putBoolean("autoCancel", this.f6644f);
        bundle.putString("largeIcon", this.f6645g);
        bundle.putString("smallIcon", this.h);
        bundle.putString("bigText", this.i);
        bundle.putString("subText", this.j);
        bundle.putString("number", this.k);
        bundle.putString("sound", this.l);
        bundle.putString(ViewProps.COLOR, this.m);
        bundle.putString("group", this.n);
        bundle.putBoolean("userInteraction", this.o);
        bundle.putBoolean("playSound", this.p);
        bundle.putBoolean("vibrate", this.q);
        bundle.putDouble("vibration", this.r);
        bundle.putString("actions", this.s);
        bundle.putString("tag", this.t);
        bundle.putString("repeatType", this.u);
        bundle.putDouble("repeatTime", this.v);
        bundle.putBoolean("ongoing", this.w);
        return bundle;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f6639a);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f6640b);
            jSONObject.put("fireDate", this.f6641c);
            jSONObject.put("title", this.f6642d);
            jSONObject.put("ticker", this.f6643e);
            jSONObject.put("autoCancel", this.f6644f);
            jSONObject.put("largeIcon", this.f6645g);
            jSONObject.put("smallIcon", this.h);
            jSONObject.put("bigText", this.i);
            jSONObject.put("subText", this.j);
            jSONObject.put("number", this.k);
            jSONObject.put("sound", this.l);
            jSONObject.put(ViewProps.COLOR, this.m);
            jSONObject.put("group", this.n);
            jSONObject.put("userInteraction", this.o);
            jSONObject.put("playSound", this.p);
            jSONObject.put("vibrate", this.q);
            jSONObject.put("vibration", this.r);
            jSONObject.put("actions", this.s);
            jSONObject.put("tag", this.t);
            jSONObject.put("repeatType", this.u);
            jSONObject.put("repeatTime", this.v);
            jSONObject.put("ongoing", this.w);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e(RNPushNotification.LOG_TAG, "Exception while converting RNPushNotificationAttributes to JSON. Returning an empty object", e2);
            return new JSONObject();
        }
    }

    public String toString() {
        return "RNPushNotificationAttributes{id='" + this.f6639a + '\'' + ", message='" + this.f6640b + '\'' + ", fireDate=" + this.f6641c + ", title='" + this.f6642d + '\'' + ", ticker='" + this.f6643e + '\'' + ", autoCancel=" + this.f6644f + ", largeIcon='" + this.f6645g + '\'' + ", smallIcon='" + this.h + '\'' + ", bigText='" + this.i + '\'' + ", subText='" + this.j + '\'' + ", number='" + this.k + '\'' + ", sound='" + this.l + '\'' + ", color='" + this.m + '\'' + ", group='" + this.n + '\'' + ", userInteraction=" + this.o + ", playSound=" + this.p + ", vibrate=" + this.q + ", vibration=" + this.r + ", actions='" + this.s + '\'' + ", tag='" + this.t + '\'' + ", repeatType='" + this.u + '\'' + ", repeatTime=" + this.v + ", ongoing=" + this.w + '}';
    }

    public String c() {
        return this.f6639a;
    }

    public double d() {
        return this.f6641c;
    }
}
