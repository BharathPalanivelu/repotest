package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class m implements ValueCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    CountDownLatch f32595a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f32596b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f32597c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final String f32598d = m.class.getName();

    m(CountDownLatch countDownLatch) {
        a(countDownLatch);
    }

    public void a(CountDownLatch countDownLatch) {
        if (this.f32595a != null) {
            String str = this.f32598d;
            Log.d(str, "existing latch: " + this.f32595a.hashCode() + " with count: " + this.f32595a.getCount());
            Log.d(this.f32598d, "Setting latch when latch already has non-null value");
        }
        this.f32595a = countDownLatch;
        if (this.f32595a != null) {
            String str2 = this.f32598d;
            Log.d(str2, "new latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
        }
    }

    private void a(String str, String str2) {
        try {
            CountDownLatch countDownLatch = this.f32595a;
            String str3 = str == null ? "null" : str;
            long j = 0;
            if (countDownLatch != null) {
                j = countDownLatch.getCount();
            }
            String str4 = this.f32598d;
            Log.d(str4, "in " + str2 + SQLBuilder.PARENTHESES_LEFT + str3 + ") count = " + j);
            this.f32596b = str;
            if (str == null) {
                this.f32597c.add("");
            } else {
                this.f32597c.add(str);
            }
            if (countDownLatch != null) {
                String str5 = this.f32598d;
                Log.d(str5, "countdown latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
                countDownLatch.countDown();
                if (str2 == null) {
                    str2 = "null";
                }
                if (countDownLatch == null) {
                    String str6 = this.f32598d;
                    Log.d(str6, "in " + str2 + "() with null latch");
                    return;
                }
                String str7 = this.f32598d;
                StringBuilder sb = new StringBuilder();
                sb.append("in ");
                sb.append(str2);
                sb.append("() count = ");
                sb.append(countDownLatch.getCount());
                sb.append(" and ");
                sb.append(countDownLatch == this.f32595a ? "latch constant" : "latch changed");
                Log.d(str7, sb.toString());
                return;
            }
            String str8 = this.f32598d;
            Log.e(str8, "in " + str2 + "() latch == null");
        } catch (Exception e2) {
            Log.d(this.f32598d, "Swallowing: ", e2);
        }
    }

    @JavascriptInterface
    public void getString(String str) {
        a(str, "getString");
    }

    /* renamed from: a */
    public void onReceiveValue(String str) {
        if (str != null) {
            if (str.length() == 2 && str.equals("\"\"")) {
                str = "";
            } else if (str.length() > 1) {
                str = str.substring(1, str.length() - 1);
            }
        }
        a(str, "onReceiveValue");
    }
}
