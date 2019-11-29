package com.airpay.paysdk.base.d;

import com.airpay.paysdk.base.bean.BPEvent;
import com.airpay.paysdk.base.bean.BPEventRuleInfo;
import com.airpay.paysdk.base.bean.BPRuleOp;
import com.airpay.paysdk.base.bean.BPTopupAmountInfo;
import com.path.android.jobqueue.JobManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    public static int a(long j) {
        return (int) ((j * com.airpay.paysdk.base.different.a.a().h()) / JobManager.NS_PER_MS);
    }

    public static long b(long j) {
        com.airpay.paysdk.base.different.a a2 = com.airpay.paysdk.base.different.a.a();
        double d2 = (double) j;
        double i = a2.i();
        Double.isNaN(d2);
        return ((long) Math.ceil(d2 / i)) * a2.j();
    }

    public static long c(long j) {
        com.airpay.paysdk.base.different.a a2 = com.airpay.paysdk.base.different.a.a();
        double d2 = (double) j;
        double i = a2.i();
        Double.isNaN(d2);
        return ((long) Math.floor(d2 / i)) * a2.j();
    }

    public static BPTopupAmountInfo a(BPEvent bPEvent, long j) {
        long j2;
        long j3;
        BPTopupAmountInfo bPTopupAmountInfo = new BPTopupAmountInfo();
        bPTopupAmountInfo.paymentPayable = j;
        bPTopupAmountInfo.topupPayment = j;
        bPTopupAmountInfo.currencyAmount = j;
        bPTopupAmountInfo.discount = 0;
        bPTopupAmountInfo.fee = 0;
        if (bPEvent != null && (bPEvent.getType() == 1 || bPEvent.getType() == 2)) {
            try {
                List<BPEventRuleInfo> a2 = a(bPEvent.getRule());
                if (a2 != null) {
                    if (a2.size() != 0) {
                        Collections.sort(a2);
                        for (BPEventRuleInfo next : a2) {
                            if (j >= next.lowerBound) {
                                ArrayList arrayList = new ArrayList();
                                for (BPRuleOp next2 : next.ops) {
                                    long b2 = b(next2.applyRule(j));
                                    arrayList.add(new a(next2.source, b2 - j));
                                    j = b2;
                                }
                                int type = bPEvent.getType();
                                if (type == 1) {
                                    long a3 = a(arrayList, 0, true, false);
                                    a(arrayList, 0, false, false);
                                    a(arrayList, 1, true, false);
                                    a(arrayList, 1, false, false);
                                    j2 = a(arrayList, 0, true, true);
                                    j3 = a(arrayList, 1, true, true);
                                    bPTopupAmountInfo.newFee = j2;
                                    bPTopupAmountInfo.topupPayment = j;
                                    bPTopupAmountInfo.currencyAmount = bPTopupAmountInfo.paymentPayable + j3;
                                    bPTopupAmountInfo.fee = a3;
                                } else if (type != 2) {
                                    j3 = 0;
                                    j2 = 0;
                                } else {
                                    a(arrayList, 0, false, false);
                                    a(arrayList, 1, true, false);
                                    a(arrayList, 1, false, false);
                                    long a4 = a(arrayList, 0, true, true) * -1;
                                    j3 = a(arrayList, 1, true, true) * -1;
                                    bPTopupAmountInfo.newFee = a4;
                                    bPTopupAmountInfo.paymentPayable = j;
                                    bPTopupAmountInfo.currencyAmount = bPTopupAmountInfo.paymentPayable + j3;
                                    bPTopupAmountInfo.fee = a(arrayList, 0, true, false) * -1;
                                    j2 = a4;
                                }
                                if (j2 >= 0) {
                                    if (j3 <= 0) {
                                        bPTopupAmountInfo.discount = j3;
                                    }
                                }
                                bPTopupAmountInfo.discount = Math.min(0, j2) + Math.min(0, j3);
                                bPTopupAmountInfo.newFee = Math.max(0, j2) + Math.max(0, j3);
                            }
                        }
                    }
                }
                return bPTopupAmountInfo;
            } catch (JSONException e2) {
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
            }
        }
        return bPTopupAmountInfo;
    }

    public static List<BPEventRuleInfo> a(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            BPEventRuleInfo bPEventRuleInfo = new BPEventRuleInfo(jSONObject.getLong("lb"));
            JSONArray jSONArray2 = jSONObject.getJSONArray("ops");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                bPEventRuleInfo.addOp(jSONArray3.getInt(0), jSONArray3.getInt(1), jSONArray3.getLong(2));
            }
            arrayList.add(bPEventRuleInfo);
        }
        return arrayList;
    }

    private static long a(List<a> list, int i, boolean z, boolean z2) {
        long j = 0;
        for (a next : list) {
            if (next.f3806a == i) {
                if ((next.f3807b > 0) == z || z2) {
                    j += next.f3807b;
                }
            }
        }
        return j;
    }

    public static long a(double d2) {
        com.airpay.paysdk.base.different.a a2 = com.airpay.paysdk.base.different.a.a();
        return Math.round((d2 * 1000000.0d) / a2.i()) * a2.j();
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3806a;

        /* renamed from: b  reason: collision with root package name */
        public long f3807b;

        public a(int i, long j) {
            this.f3806a = i;
            this.f3807b = j;
        }
    }
}
