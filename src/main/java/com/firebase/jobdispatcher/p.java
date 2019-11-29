package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.firebase.jobdispatcher.q;
import com.firebase.jobdispatcher.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class p {

    /* renamed from: a  reason: collision with root package name */
    private final String f7222a;

    p(String str) {
        this.f7222a = str;
    }

    /* access modifiers changed from: package-private */
    public Bundle a(r rVar, Bundle bundle) {
        if (bundle != null) {
            Bundle b2 = rVar.b();
            if (b2 != null) {
                bundle.putAll(b2);
            }
            bundle.putInt(this.f7222a + "persistent", rVar.g());
            bundle.putBoolean(this.f7222a + "recurring", rVar.h());
            bundle.putBoolean(this.f7222a + "replace_current", rVar.d());
            bundle.putString(this.f7222a + "tag", rVar.e());
            bundle.putString(this.f7222a + "service", rVar.i());
            bundle.putInt(this.f7222a + "constraints", a.a(rVar.a()));
            a(rVar.f(), bundle);
            a(rVar.c(), bundle);
            return bundle;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }

    /* access modifiers changed from: package-private */
    public q a(Bundle bundle) {
        if (bundle == null) {
            Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
            return null;
        }
        Bundle bundle2 = bundle.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
        if (bundle2 == null) {
            return null;
        }
        q.a b2 = b(bundle2);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("triggered_uris");
        if (parcelableArrayList != null) {
            b2.a(new z(parcelableArrayList));
        }
        return b2.a();
    }

    public q.a b(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            boolean z = bundle2.getBoolean(this.f7222a + "recurring");
            boolean z2 = bundle2.getBoolean(this.f7222a + "replace_current");
            int i = bundle2.getInt(this.f7222a + "persistent");
            int[] a2 = a.a(bundle2.getInt(this.f7222a + "constraints"));
            u c2 = c(bundle2);
            x d2 = d(bundle2);
            String string = bundle2.getString(this.f7222a + "tag");
            String string2 = bundle2.getString(this.f7222a + "service");
            if (string == null || string2 == null || c2 == null || d2 == null) {
                return null;
            }
            q.a aVar = new q.a();
            aVar.a(string);
            aVar.b(string2);
            aVar.a(c2);
            aVar.a(d2);
            aVar.a(z);
            aVar.a(i);
            aVar.a(a2);
            aVar.b(z2);
            if (!TextUtils.isEmpty(this.f7222a)) {
                Iterator it = bundle2.keySet().iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).startsWith(this.f7222a)) {
                        it.remove();
                    }
                }
            }
            aVar.a(bundle2);
            return aVar;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }

    private u c(Bundle bundle) {
        int i = bundle.getInt(this.f7222a + "trigger_type");
        if (i == 1) {
            int i2 = bundle.getInt(this.f7222a + "window_start");
            return y.a(i2, bundle.getInt(this.f7222a + "window_end"));
        } else if (i == 2) {
            return y.f7265a;
        } else {
            if (i == 3) {
                return y.a(Collections.unmodifiableList(a(bundle.getString(this.f7222a + "observed_uris"))));
            } else if (!Log.isLoggable("FJD.ExternalReceiver", 3)) {
                return null;
            } else {
                Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
                return null;
            }
        }
    }

    private void a(u uVar, Bundle bundle) {
        if (uVar == y.f7265a) {
            bundle.putInt(this.f7222a + "trigger_type", 2);
        } else if (uVar instanceof u.b) {
            u.b bVar = (u.b) uVar;
            bundle.putInt(this.f7222a + "trigger_type", 1);
            bundle.putInt(this.f7222a + "window_start", bVar.a());
            bundle.putInt(this.f7222a + "window_end", bVar.b());
        } else if (uVar instanceof u.a) {
            bundle.putInt(this.f7222a + "trigger_type", 3);
            String a2 = a(((u.a) uVar).a());
            bundle.putString(this.f7222a + "observed_uris", a2);
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
    }

    private x d(Bundle bundle) {
        int i = bundle.getInt(this.f7222a + "retry_policy");
        if (i != 1 && i != 2) {
            return x.f7259a;
        }
        int i2 = bundle.getInt(this.f7222a + "initial_backoff_seconds");
        return new x(i, i2, bundle.getInt(this.f7222a + "maximum_backoff_seconds"));
    }

    private void a(x xVar, Bundle bundle) {
        if (xVar == null) {
            xVar = x.f7259a;
        }
        bundle.putInt(this.f7222a + "retry_policy", xVar.a());
        bundle.putInt(this.f7222a + "initial_backoff_seconds", xVar.b());
        bundle.putInt(this.f7222a + "maximum_backoff_seconds", xVar.c());
    }

    private static String a(List<w> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (w next : list) {
            jSONArray.put(next.b());
            jSONArray2.put(next.a());
        }
        try {
            jSONObject.put("uri_flags", jSONArray);
            jSONObject.put("uris", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static List<w> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("uri_flags");
            JSONArray jSONArray2 = jSONObject.getJSONArray("uris");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(new w(Uri.parse(jSONArray2.getString(i)), jSONArray.getInt(i)));
            }
            return arrayList;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }
}
