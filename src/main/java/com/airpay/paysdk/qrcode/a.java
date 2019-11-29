package com.airpay.paysdk.qrcode;

import android.util.SparseArray;
import com.airpay.paysdk.common.net.a.a.b;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.core.bean.ChannelListInfo;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;
import com.airpay.paysdk.qrcode.model.BankAccountInfo;
import com.airpay.paysdk.qrcode.model.BankAccountListInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer[] f4317a = {1, 2, 3, 4, 101};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final List<ChannelInfo> f4318b;

    /* renamed from: com.airpay.paysdk.qrcode.a$a  reason: collision with other inner class name */
    private static final class C0084a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f4332a = new a();
    }

    private a() {
        this.f4318b = new ArrayList();
    }

    public ChannelInfo a(Integer num) {
        if (num == null) {
            return null;
        }
        for (ChannelInfo next : this.f4318b) {
            if (next.a() == num.intValue()) {
                return next;
            }
        }
        return null;
    }

    public static a a() {
        return C0084a.f4332a;
    }

    public void b() {
        com.airpay.paysdk.core.a.a().b((List<Integer>) new ArrayList(Arrays.asList(f4317a)), (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) new com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>() {
            public void a(int i, String str) {
            }

            public void a(ChannelListInfo channelListInfo) {
                a.this.f4318b.clear();
                a.this.f4318b.addAll(channelListInfo.f4110a);
            }
        });
    }

    public void c() {
        this.f4318b.clear();
    }

    public void a(List<Integer> list, final com.airpay.paysdk.common.net.a.a.a<ChannelListInfo> aVar) {
        com.airpay.paysdk.core.a.a().a(list, (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) new com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>() {
            public void a(ChannelListInfo channelListInfo) {
                a.this.f4318b.addAll(channelListInfo.f4110a);
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(channelListInfo);
                }
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public b a(final com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> aVar) {
        com.airpay.paysdk.common.b.a.d("get bank account info", new Object[0]);
        return com.airpay.paysdk.core.a.a().b(new com.airpay.paysdk.common.net.a.a.a<BankAccountListInfo>() {
            public void a(BankAccountListInfo bankAccountListInfo) {
                a.this.b(bankAccountListInfo.f4362a, aVar);
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    private void a(final List<BankAccountInfo> list, List<Integer> list2, final com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> aVar) {
        com.airpay.paysdk.core.a.a().a(list2, (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) new com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>() {
            public void a(ChannelListInfo channelListInfo) {
                a.this.f4318b.addAll(channelListInfo.f4110a);
                a.this.b(list, aVar);
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(List<BankAccountInfo> list, com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        if (this.f4318b.size() > 0) {
            for (ChannelInfo next : this.f4318b) {
                sparseArray.put(next.a(), next);
            }
        }
        if (list != null && list.size() > 0) {
            for (BankAccountInfo next2 : list) {
                if (sparseArray.indexOfKey(next2.f4357c) >= 0) {
                    arrayList.add(new BankAccountFullInfo(next2, (ChannelInfo) sparseArray.get(next2.f4357c)));
                } else {
                    arrayList2.add(Integer.valueOf(next2.f4357c));
                }
            }
        }
        if (arrayList2.size() != 0) {
            a(list, (List<Integer>) arrayList2, aVar);
        } else if (aVar != null) {
            aVar.a(arrayList);
        }
    }

    public b b(final com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> aVar) {
        com.airpay.paysdk.common.b.a.b("get payment option info", new Object[0]);
        return com.airpay.paysdk.core.a.a().b(new com.airpay.paysdk.common.net.a.a.a<BankAccountListInfo>() {
            public void a(BankAccountListInfo bankAccountListInfo) {
                boolean unused = a.this.a((Collection<BankAccountInfo>) bankAccountListInfo.f4362a, (com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>>) aVar);
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(Collection<BankAccountInfo> collection, com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        if (this.f4318b.size() > 0) {
            for (ChannelInfo next : this.f4318b) {
                sparseArray.put(next.a(), next);
            }
        }
        if (collection != null && collection.size() > 0) {
            for (BankAccountInfo next2 : collection) {
                if (sparseArray.indexOfKey(next2.f4357c) >= 0) {
                    arrayList.add(new BankAccountFullInfo(next2, (ChannelInfo) sparseArray.get(next2.f4357c)));
                } else {
                    arrayList2.add(Integer.valueOf(next2.f4357c));
                }
            }
        }
        if (arrayList2.size() > 0) {
            a(collection, (List<Integer>) arrayList2, aVar);
            return false;
        } else if (aVar == null) {
            return true;
        } else {
            aVar.a(arrayList);
            return true;
        }
    }

    private void a(final Collection<BankAccountInfo> collection, List<Integer> list, final com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> aVar) {
        com.airpay.paysdk.core.a.a().a(list, (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) new com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>() {
            public void a(ChannelListInfo channelListInfo) {
                a.this.f4318b.addAll(channelListInfo.f4110a);
                boolean unused = a.this.a((Collection<BankAccountInfo>) collection, (com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>>) aVar);
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.net.a.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }
        });
    }

    public void a(List<Integer> list) {
        a(list, (com.airpay.paysdk.common.net.a.a.a<ChannelListInfo>) null);
    }
}
