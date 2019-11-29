package com.garena.pay.android.d;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage;
import com.tencent.ijk.media.player.IMediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import tencent.tls.platform.TLSErrInfo;

public class b {

    /* renamed from: a  reason: collision with root package name */
    boolean f8183a = false;

    /* renamed from: b  reason: collision with root package name */
    String f8184b = (com.beetalk.sdk.e.a.f5401a + " IabHelper");

    /* renamed from: c  reason: collision with root package name */
    boolean f8185c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f8186d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f8187e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f8188f = false;

    /* renamed from: g  reason: collision with root package name */
    String f8189g = "";
    Context h;
    IInAppBillingService i;
    ServiceConnection j;
    int k;
    String l;
    String m = null;
    c n;

    public interface a {
        void a(e eVar, c cVar);
    }

    /* renamed from: com.garena.pay.android.d.b$b  reason: collision with other inner class name */
    public interface C0140b {
        void a(List<e> list, List<c> list2);
    }

    public interface c {
        void a(c cVar, e eVar);
    }

    public interface d {
        void a(c cVar);
    }

    public interface e {
        void a(c cVar, d dVar);
    }

    public b(Context context) {
        this.h = context.getApplicationContext();
        c("IAB helper created.");
    }

    public static String a(int i2) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split(Constants.URL_PATH_DELIMITER);
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split(Constants.URL_PATH_DELIMITER);
        if (i2 <= -1000) {
            int i3 = TLSErrInfo.TIMEOUT - i2;
            if (i3 >= 0 && i3 < split2.length) {
                return split2[i3];
            }
            return String.valueOf(i2) + ":Unknown IAB Helper Error";
        } else if (i2 >= 0 && i2 < split.length) {
            return split[i2];
        } else {
            return String.valueOf(i2) + ":Unknown";
        }
    }

    public void a(boolean z) {
        c();
        this.f8183a = z;
    }

    public void a(final d dVar) {
        c();
        if (!this.f8185c) {
            c("Starting in-app billing setup.");
            this.j = new ServiceConnection() {
                public void onServiceDisconnected(ComponentName componentName) {
                    b.this.c("Billing service disconnected.");
                    b.this.i = null;
                }

                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    if (!b.this.f8186d) {
                        b.this.c("Billing service connected.");
                        b.this.i = IInAppBillingService.a.a(iBinder);
                        String packageName = b.this.h.getPackageName();
                        try {
                            b.this.c("Checking for in-app billing 3 support.");
                            int a2 = b.this.i.a(3, packageName, "inapp");
                            if (a2 != 0) {
                                if (dVar != null) {
                                    dVar.a(new c(a2, "Error checking for billing v3 support."));
                                }
                                b.this.f8187e = false;
                                return;
                            }
                            b bVar = b.this;
                            bVar.c("In-app billing version 3 supported for " + packageName);
                            int a3 = b.this.i.a(3, packageName, "subs");
                            if (a3 == 0) {
                                b.this.c("Subscriptions AVAILABLE.");
                                b.this.f8187e = true;
                            } else {
                                b bVar2 = b.this;
                                bVar2.c("Subscriptions NOT AVAILABLE. Response: " + a3);
                            }
                            b.this.f8185c = true;
                            d dVar = dVar;
                            if (dVar != null) {
                                dVar.a(new c(0, "Setup successful."));
                            }
                        } catch (RemoteException e2) {
                            d dVar2 = dVar;
                            if (dVar2 != null) {
                                dVar2.a(new c(TLSErrInfo.PENDING, "RemoteException while setting up in-app billing."));
                            }
                            e2.printStackTrace();
                        }
                    }
                }
            };
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            if (!this.h.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
                this.h.bindService(intent, this.j, 1);
            } else if (dVar != null) {
                dVar.a(new c(3, "Billing service unavailable on device."));
            }
        } else {
            throw new IllegalStateException("IAB helper is already set up.");
        }
    }

    public void a() {
        c("Disposing.");
        this.f8185c = false;
        if (this.j != null) {
            c("Unbinding from service.");
            Context context = this.h;
            if (context != null) {
                context.unbindService(this.j);
            }
        }
        this.f8186d = true;
        this.h = null;
        this.j = null;
        this.i = null;
        this.n = null;
    }

    private void c() {
        if (this.f8186d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public void a(Activity activity, String str, int i2, c cVar, String str2) {
        a(activity, str, "inapp", i2, cVar, str2);
    }

    public void a(Activity activity, String str, String str2, int i2, c cVar, String str3) {
        c();
        a("launchPurchaseFlow");
        b("launchPurchaseFlow");
        if (!str2.equals("subs") || this.f8187e) {
            try {
                c("Constructing buy intent for " + str + ", item type: " + str2);
                Bundle a2 = this.i.a(3, this.h.getPackageName(), str, str2, str3);
                int a3 = a(a2);
                if (a3 != 0) {
                    d("Unable to buy item, Error response: " + a(a3));
                    b();
                    c cVar2 = new c(a3, "Unable to buy item");
                    if (cVar != null) {
                        cVar.a(cVar2, (e) null);
                        return;
                    }
                    return;
                }
                c("Launching buy intent for " + str + ". Request code: " + i2);
                this.k = i2;
                this.n = cVar;
                this.l = str2;
                IntentSender intentSender = ((PendingIntent) a2.getParcelable("BUY_INTENT")).getIntentSender();
                Intent intent = new Intent();
                Integer num = 0;
                int intValue = num.intValue();
                Integer num2 = 0;
                Integer num3 = 0;
                activity.startIntentSenderForResult(intentSender, i2, intent, intValue, num2.intValue(), num3.intValue());
            } catch (IntentSender.SendIntentException e2) {
                d("SendIntentException while launching purchase flow for sku " + str);
                e2.printStackTrace();
                b();
                c cVar3 = new c(-1004, "Failed to send intent.");
                if (cVar != null) {
                    cVar.a(cVar3, (e) null);
                }
            } catch (RemoteException e3) {
                d("RemoteException while launching purchase flow for sku " + str);
                e3.printStackTrace();
                b();
                c cVar4 = new c(TLSErrInfo.PENDING, "Remote exception while starting purchase flow");
                if (cVar != null) {
                    cVar.a(cVar4, (e) null);
                }
            }
        } else {
            c cVar5 = new c(TLSErrInfo.PK_LEN, "Subscriptions are not available.");
            b();
            if (cVar != null) {
                cVar.a(cVar5, (e) null);
            }
        }
    }

    public boolean a(int i2, int i3, Intent intent) {
        if (i2 != this.k) {
            return false;
        }
        c();
        a("handleActivityResult");
        b();
        if (intent == null) {
            d("Null data in IAB activity result.");
            c cVar = new c(TLSErrInfo.DECRYPT_FAILED, "Null data in IAB result");
            c cVar2 = this.n;
            if (cVar2 != null) {
                cVar2.a(cVar, (e) null);
            }
            return true;
        }
        int a2 = a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i3 == -1 && a2 == 0) {
            c("Successful resultcode from purchase activity.");
            c("Purchase data: " + stringExtra);
            c("Data signature: " + stringExtra2);
            c("Extras: " + intent.getExtras());
            c("Expected item type: " + this.l);
            if (stringExtra == null || stringExtra2 == null) {
                d("BUG: either purchaseData or dataSignature is null.");
                c("Extras: " + intent.getExtras().toString());
                c cVar3 = new c(TLSErrInfo.LOGIN_ID_INVALID, "IAB returned null purchaseData or dataSignature");
                c cVar4 = this.n;
                if (cVar4 != null) {
                    cVar4.a(cVar3, (e) null);
                }
                return true;
            }
            try {
                e eVar = new e(this.l, stringExtra, stringExtra2);
                String c2 = eVar.c();
                if (!f.a(this.m, stringExtra, stringExtra2)) {
                    d("Purchase signature verification FAILED for sku " + c2);
                    c cVar5 = new c(TLSErrInfo.LOGIN_NO_ID, "Signature verification failed for sku " + c2);
                    if (this.n != null) {
                        this.n.a(cVar5, eVar);
                    }
                    return true;
                }
                c("Purchase signature successfully verified.");
                c cVar6 = this.n;
                if (cVar6 != null) {
                    cVar6.a(new c(0, FileTransferMessage.EVENT_TYPE_SUCCESS), eVar);
                }
            } catch (JSONException e2) {
                d("Failed to parse purchase data.");
                e2.printStackTrace();
                c cVar7 = new c(TLSErrInfo.DECRYPT_FAILED, "Failed to parse purchase data.");
                c cVar8 = this.n;
                if (cVar8 != null) {
                    cVar8.a(cVar7, (e) null);
                }
                return true;
            }
        } else if (i3 == -1) {
            c("Result code was OK but in-app billing response was not OK: " + a(a2));
            if (this.n != null) {
                this.n.a(new c(a2, "Problem purchashing item."), (e) null);
            }
        } else if (i3 == 0) {
            c("Purchase canceled - Response: " + a(a2));
            c cVar9 = new c(TLSErrInfo.LOGIN_TLV_INVALID, "User canceled.");
            c cVar10 = this.n;
            if (cVar10 != null) {
                cVar10.a(cVar9, (e) null);
            }
        } else {
            d("Purchase failed. Result code: " + Integer.toString(i3) + ". Response: " + a(a2));
            c cVar11 = new c(-1006, "Unknown purchase response.");
            c cVar12 = this.n;
            if (cVar12 != null) {
                cVar12.a(cVar11, (e) null);
            }
        }
        return true;
    }

    public d a(boolean z, List<String> list) throws a {
        return a(z, list, (List<String>) null);
    }

    public d a(boolean z, List<String> list, List<String> list2) throws a {
        c();
        a("queryInventory");
        try {
            d dVar = new d();
            int a2 = a(dVar, "inapp");
            if (a2 == 0) {
                if (z) {
                    int a3 = a("inapp", dVar, list);
                    if (a3 != 0) {
                        throw new a(a3, "Error refreshing inventory (querying prices of items).");
                    }
                }
                if (this.f8187e) {
                    int a4 = a(dVar, "subs");
                    if (a4 != 0) {
                        throw new a(a4, "Error refreshing inventory (querying owned subscriptions).");
                    } else if (z) {
                        int a5 = a("subs", dVar, list);
                        if (a5 != 0) {
                            throw new a(a5, "Error refreshing inventory (querying prices of subscriptions).");
                        }
                    }
                }
                return dVar;
            }
            throw new a(a2, "Error refreshing inventory (querying owned items).");
        } catch (RemoteException e2) {
            throw new a(TLSErrInfo.PENDING, "Remote exception while refreshing inventory.", e2);
        } catch (JSONException e3) {
            throw new a(TLSErrInfo.DECRYPT_FAILED, "Error parsing JSON response while refreshing inventory.", e3);
        }
    }

    public void a(boolean z, List<String> list, e eVar) {
        final Handler handler = new Handler();
        c();
        a("queryInventory");
        b("refresh inventory");
        final boolean z2 = z;
        final List<String> list2 = list;
        final e eVar2 = eVar;
        new Thread(new Runnable() {
            public void run() {
                final d dVar;
                final c cVar = new c(0, "Inventory refresh successful.");
                try {
                    dVar = b.this.a(z2, (List<String>) list2);
                } catch (a e2) {
                    cVar = e2.a();
                    dVar = null;
                }
                b.this.b();
                if (!b.this.f8186d && eVar2 != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            eVar2.a(cVar, dVar);
                        }
                    });
                }
            }
        }).start();
    }

    public void a(e eVar) {
        a(true, (List<String>) null, eVar);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) throws a {
        c();
        a("consume");
        if (eVar.f8213a.equals("inapp")) {
            try {
                String e2 = eVar.e();
                String c2 = eVar.c();
                if (e2 == null || e2.equals("")) {
                    d("Can't consume " + c2 + ". No token.");
                    throw new a((int) IMediaPlayer.MEDIA_ERROR_MALFORMED, "PurchaseInfo is missing token for sku: " + c2 + SQLBuilder.BLANK + eVar);
                }
                c("Consuming sku: " + c2 + ", token: " + e2);
                int b2 = this.i.b(3, this.h.getPackageName(), e2);
                if (b2 == 0) {
                    c("Successfully consumed sku: " + c2);
                    return;
                }
                c("Error consuming consuming sku " + c2 + ". " + a(b2));
                throw new a(b2, "Error consuming sku " + c2);
            } catch (RemoteException e3) {
                throw new a(TLSErrInfo.PENDING, "Remote exception while consuming. PurchaseInfo: " + eVar, e3);
            }
        } else {
            throw new a((int) IMediaPlayer.MEDIA_ERROR_UNSUPPORTED, "Items of type '" + eVar.f8213a + "' can't be consumed.");
        }
    }

    public void a(e eVar, a aVar) {
        c();
        a("consume");
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        a((List<e>) arrayList, aVar, (C0140b) null);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (!this.f8185c) {
            d("Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            d("Unexpected type for bundle response code.");
            d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    public int a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            d("Unexpected type for intent response code.");
            d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        if (!this.f8188f) {
            this.f8189g = str;
            this.f8188f = true;
            c("Starting async operation: " + str);
            return;
        }
        throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.f8189g + ") is in progress.");
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c("Ending async operation: " + this.f8189g);
        this.f8189g = "";
        this.f8188f = false;
    }

    /* access modifiers changed from: package-private */
    public int a(d dVar, String str) throws JSONException, RemoteException {
        c("Querying owned items, item type: " + str);
        c("Package name: " + this.h.getPackageName());
        String str2 = null;
        boolean z = false;
        while (true) {
            c("Calling getPurchases with continuation token: " + str2);
            Bundle a2 = this.i.a(3, this.h.getPackageName(), str, str2);
            int a3 = a(a2);
            c("Owned items response: " + String.valueOf(a3));
            if (a3 != 0) {
                c("getPurchases() failed: " + a(a3));
                return a3;
            } else if (!a2.containsKey("INAPP_PURCHASE_ITEM_LIST") || !a2.containsKey("INAPP_PURCHASE_DATA_LIST") || !a2.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                d("Bundle returned from getPurchases() doesn't contain required fields.");
            } else {
                ArrayList<String> stringArrayList = a2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = a2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = a2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z2 = z;
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    String str5 = stringArrayList.get(i2);
                    if (f.a(this.m, str3, str4)) {
                        c("Sku is owned: " + str5);
                        e eVar = new e(str, str3, str4);
                        if (TextUtils.isEmpty(eVar.e())) {
                            e("BUG: empty/null token!");
                            c("Purchase data: " + str3);
                        }
                        dVar.a(eVar);
                    } else {
                        e("Purchase signature verification **FAILED**. Not adding item.");
                        c("   Purchase data: " + str3);
                        c("   Signature: " + str4);
                        z2 = true;
                    }
                }
                str2 = a2.getString("INAPP_CONTINUATION_TOKEN");
                c("Continuation token: " + str2);
                if (!TextUtils.isEmpty(str2)) {
                    z = z2;
                } else if (z2) {
                    return TLSErrInfo.LOGIN_NO_ID;
                } else {
                    return 0;
                }
            }
        }
        d("Bundle returned from getPurchases() doesn't contain required fields.");
        return TLSErrInfo.DECRYPT_FAILED;
    }

    /* access modifiers changed from: package-private */
    public int a(String str, d dVar, List<String> list) throws RemoteException, JSONException {
        c("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dVar.b(str));
        if (list != null) {
            for (String next : list) {
                if (!arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() == 0) {
            c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Bundle skuDetails = this.i.getSkuDetails(3, this.h.getPackageName(), str, bundle);
        if (!skuDetails.containsKey("DETAILS_LIST")) {
            int a2 = a(skuDetails);
            if (a2 != 0) {
                c("getSkuDetails() failed: " + a(a2));
                return a2;
            }
            d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
            return TLSErrInfo.DECRYPT_FAILED;
        }
        Iterator<String> it = skuDetails.getStringArrayList("DETAILS_LIST").iterator();
        while (it.hasNext()) {
            g gVar = new g(str, it.next());
            c("Got sku details: " + gVar);
            dVar.a(gVar);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void a(List<e> list, a aVar, C0140b bVar) {
        final Handler handler = new Handler();
        b("consume");
        final List<e> list2 = list;
        final a aVar2 = aVar;
        final C0140b bVar2 = bVar;
        new Thread(new Runnable() {
            public void run() {
                final ArrayList arrayList = new ArrayList();
                for (e eVar : list2) {
                    try {
                        b.this.a(eVar);
                        arrayList.add(new c(0, "Successful consume of sku " + eVar.c()));
                    } catch (a e2) {
                        arrayList.add(e2.a());
                    }
                }
                b.this.b();
                if (!b.this.f8186d && aVar2 != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            aVar2.a((e) list2.get(0), (c) arrayList.get(0));
                        }
                    });
                }
                if (!b.this.f8186d && bVar2 != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            bVar2.a(list2, arrayList);
                        }
                    });
                }
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        if (this.f8183a) {
            Log.d(this.f8184b, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        String str2 = this.f8184b;
        Log.e(str2, "In-app billing error: " + str);
    }

    /* access modifiers changed from: package-private */
    public void e(String str) {
        String str2 = this.f8184b;
        Log.w(str2, "In-app billing warning: " + str);
    }
}
