package com.bca.xco.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.bca.xco.widget.h;
import com.litesuits.orm.db.assit.SQLStatement;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

class j {
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */
    public String B;
    /* access modifiers changed from: private */
    public String C;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public String E;
    /* access modifiers changed from: private */
    public String F;
    private String G;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.bca.xco.widget.c.a f5314a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f5315b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f5316c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f5317d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c f5318e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f5319f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f5320g;
    /* access modifiers changed from: private */
    public String h;
    /* access modifiers changed from: private */
    public final Integer i = 100;
    /* access modifiers changed from: private */
    public final Integer j = 11;
    private final Integer k = 13;
    /* access modifiers changed from: private */
    public final Integer l = 14;
    private final Integer m = 15;
    /* access modifiers changed from: private */
    public final Integer n = 101;
    private final Integer o = 102;
    /* access modifiers changed from: private */
    public final Integer p = 103;
    private final Integer q = 104;
    /* access modifiers changed from: private */
    public final Integer r = 711;
    private final Integer s = 712;
    /* access modifiers changed from: private */
    public final Integer t = 713;
    /* access modifiers changed from: private */
    public final Integer u = 714;
    /* access modifiers changed from: private */
    public final Integer v = Integer.valueOf(DanmaKuEntity.MESSAGE_PUBLIC);
    /* access modifiers changed from: private */
    public final Integer w = Integer.valueOf(SQLStatement.IN_TOP_LIMIT);
    /* access modifiers changed from: private */
    public final Integer x = 998;
    private String y;
    /* access modifiers changed from: private */
    public String z;

    public j(Context context, d dVar, String str) {
        this.f5316c = context;
        this.f5317d = dVar;
        this.f5314a = new com.bca.xco.widget.c.a(context, str);
        this.G = str;
        a();
    }

    private void a() {
        if (this.G.equals("DEV")) {
            this.y = "https://202.6.215.226:41401";
        } else if (this.G.equals("PRODUCTION")) {
            this.y = "https://oneklik.klikbca.com:41404";
        } else {
            this.y = "https://202.6.215.226:41401";
        }
        this.z = this.y + "/xco/widget/credentials";
        this.A = this.y + "/xco/widget/credentials";
        this.B = this.y + "/xco/otp";
        this.C = this.y + "/xco/merchants";
        this.D = this.y + "/xco/credentials/limits";
        this.E = this.y + "/xco/credentials/limits";
        this.F = this.y + "/xco/credentials/details";
    }

    public void a(c cVar) {
        this.f5318e = cVar;
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f5315b = new ProgressDialog(this.f5316c);
        this.f5315b.setMessage(this.f5316c.getString(h.f.xco_please_wait));
        this.f5315b.setCancelable(false);
        this.f5315b.show();
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.f5315b.isShowing()) {
            this.f5315b.dismiss();
        }
    }

    public class b extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5326b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5327c;

        /* renamed from: d  reason: collision with root package name */
        private String f5328d;

        /* renamed from: e  reason: collision with root package name */
        private String f5329e;

        /* renamed from: f  reason: collision with root package name */
        private String f5330f;

        public b(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5326b = aVar;
            this.f5327c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r4 = com.bca.xco.widget.j.a(r3.f5325a, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5325a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0088, code lost:
            if (isCancelled() == false) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x008b, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
            if (isCancelled() == false) goto L_0x00b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d1, code lost:
            if (isCancelled() == false) goto L_0x00d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r4 = com.bca.xco.widget.j.g(r3.f5325a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5325a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ef, code lost:
            if (isCancelled() == false) goto L_0x00f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            r4 = com.bca.xco.widget.j.f(r3.f5325a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5325a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x010e, code lost:
            if (isCancelled() == false) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0112, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r4 = com.bca.xco.widget.j.e(r3.f5325a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5325a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x012d, code lost:
            if (isCancelled() == false) goto L_0x0131;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0131, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0146, code lost:
            if (isCancelled() == false) goto L_0x014b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return com.bca.xco.widget.j.g(r3.f5325a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00d5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00f4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0113 */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00d5 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0113 A[SYNTHETIC] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x0113=Splitter:B:54:0x0113, B:46:0x00f4=Splitter:B:46:0x00f4, B:38:0x00d5=Splitter:B:38:0x00d5} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r4) {
            /*
                r3 = this;
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                com.bca.xco.widget.c.a r4 = r4.f5314a     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                r0.<init>()     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                com.bca.xco.widget.j r1 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.String r1 = r1.C     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                r0.append(r1)     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.String r1 = "/"
                r0.append(r1)     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                com.bca.xco.widget.a.b r1 = r3.f5327c     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.String r1 = r1.e()     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                r0.append(r1)     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.String r0 = r0.toString()     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                com.bca.xco.widget.a.a r1 = r3.f5326b     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                com.bca.xco.widget.a.b r2 = r3.f5327c     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.String r4 = r4.d(r0, r1, r2)     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                r0.<init>(r4)     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                java.lang.String r1 = "MerchantName"
                java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                r3.f5328d = r1     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                java.lang.String r1 = "ProductName"
                java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                r3.f5329e = r1     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                java.lang.String r1 = "MaxDailyLimit"
                java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                r3.f5330f = r0     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                java.lang.Integer r4 = r0.n     // Catch:{ Exception -> 0x006e, ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0060 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0060 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0060 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0060 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0060 }
                goto L_0x006d
            L_0x0060:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x006d
            L_0x0067:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this
                java.lang.Integer r4 = r4.r
            L_0x006d:
                return r4
            L_0x006e:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                java.lang.Integer r4 = r0.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x0113, UnknownHostException -> 0x00f4, SocketTimeoutException -> 0x00d5, Exception -> 0x008f }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0083 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0083 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0083 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0083 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0083 }
                goto L_0x008b
            L_0x0083:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x008b
                goto L_0x0067
            L_0x008b:
                return r4
            L_0x008c:
                r4 = move-exception
                goto L_0x0132
            L_0x008f:
                r4 = move-exception
                boolean r0 = r3.isCancelled()     // Catch:{ all -> 0x008c }
                if (r0 == 0) goto L_0x00b4
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x008c }
                java.lang.Integer r4 = r4.r     // Catch:{ all -> 0x008c }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00ab }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00ab }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00ab }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00ab }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00ab }
                goto L_0x00b3
            L_0x00ab:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00b3
                goto L_0x0067
            L_0x00b3:
                return r4
            L_0x00b4:
                r4.printStackTrace()     // Catch:{ all -> 0x008c }
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x008c }
                java.lang.Integer r4 = r4.w     // Catch:{ all -> 0x008c }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00cc }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00cc }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00cc }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00cc }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00cc }
                goto L_0x00d4
            L_0x00cc:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00d4
                goto L_0x0067
            L_0x00d4:
                return r4
            L_0x00d5:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x008c }
                java.lang.Integer r4 = r4.r     // Catch:{ all -> 0x008c }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00ea }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00ea }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00ea }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00ea }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00ea }
                goto L_0x00f3
            L_0x00ea:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00f3
                goto L_0x0067
            L_0x00f3:
                return r4
            L_0x00f4:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x008c }
                java.lang.Integer r4 = r4.p     // Catch:{ all -> 0x008c }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0109 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0109 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0109 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0109 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0109 }
                goto L_0x0112
            L_0x0109:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0112
                goto L_0x0067
            L_0x0112:
                return r4
            L_0x0113:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x008c }
                java.lang.Integer r4 = r4.x     // Catch:{ all -> 0x008c }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0128 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0128 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0128 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0128 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0128 }
                goto L_0x0131
            L_0x0128:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0131
                goto L_0x0067
            L_0x0131:
                return r4
            L_0x0132:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0141 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0141 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0141 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0141 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0141 }
                goto L_0x014a
            L_0x0141:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x014a
                goto L_0x0067
            L_0x014a:
                goto L_0x014c
            L_0x014b:
                throw r4
            L_0x014c:
                goto L_0x014b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.b.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (j.this.f5315b.isShowing()) {
                j.this.f5315b.dismiss();
            }
            if (num == j.this.n) {
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setGroupingSeparator('.');
                decimalFormatSymbols.setDecimalSeparator(',');
                DecimalFormat decimalFormat = new DecimalFormat("#,###.00", decimalFormatSymbols);
                try {
                    d k = j.this.f5317d;
                    k.b("Limit harian tidak dapat melebihi limit harian " + this.f5329e + " sebesar Rp <b>" + decimalFormat.format(Double.parseDouble(this.f5330f)) + "</b>");
                } catch (Exception unused) {
                    d k2 = j.this.f5317d;
                    k2.b("Limit harian tidak dapat melebihi limit harian " + this.f5329e + " sebesar Rp <b>" + this.f5330f + "</b>");
                }
            } else {
                j.this.a(num);
            }
        }
    }

    public class c extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5332b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5333c;

        /* renamed from: d  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5334d;

        public c(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5332b = aVar;
            this.f5333c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5334d = new com.bca.xco.widget.a.b();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|12|13|17) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r4 = com.bca.xco.widget.j.a(r3.f5331a, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5331a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
            if (isCancelled() == false) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0085, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0086, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
            if (isCancelled() != false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ac, code lost:
            return com.bca.xco.widget.j.g(r3.f5331a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r4 = com.bca.xco.widget.j.h(r3.f5331a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5331a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
            if (isCancelled() == false) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r4 = com.bca.xco.widget.j.g(r3.f5331a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5331a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e5, code lost:
            if (isCancelled() == false) goto L_0x00e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e9, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r4 = com.bca.xco.widget.j.f(r3.f5331a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5331a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0104, code lost:
            if (isCancelled() == false) goto L_0x0108;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0108, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r4 = com.bca.xco.widget.j.e(r3.f5331a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5331a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0123, code lost:
            if (isCancelled() == false) goto L_0x0127;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0127, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5331a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x013c, code lost:
            if (isCancelled() == false) goto L_0x0141;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0141, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return com.bca.xco.widget.j.g(r3.f5331a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x0089, B:37:0x00cb, B:45:0x00ea, B:53:0x0109] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ea */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0109 */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00cb A[SYNTHETIC, Splitter:B:37:0x00cb] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea A[SYNTHETIC, Splitter:B:45:0x00ea] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0109 A[SYNTHETIC, Splitter:B:53:0x0109] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0089=Splitter:B:19:0x0089, B:53:0x0109=Splitter:B:53:0x0109, B:45:0x00ea=Splitter:B:45:0x00ea, B:37:0x00cb=Splitter:B:37:0x00cb} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r4) {
            /*
                r3 = this;
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                com.bca.xco.widget.c.a r4 = r4.f5314a     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                java.lang.String r0 = r0.B     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                com.bca.xco.widget.a.a r1 = r3.f5332b     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                com.bca.xco.widget.a.b r2 = r3.f5333c     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                java.lang.String r4 = r4.a(r0, r1, r2)     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                r0.<init>(r4)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                com.bca.xco.widget.a.b r1 = r3.f5334d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                java.lang.String r2 = "TransactionType"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                r1.i(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                com.bca.xco.widget.a.b r1 = r3.f5334d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                java.lang.String r2 = "XCOID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                r1.h(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                com.bca.xco.widget.a.b r1 = r3.f5334d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                java.lang.String r2 = "MSISDNID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                r1.j(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                com.bca.xco.widget.a.b r1 = r3.f5334d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                java.lang.String r2 = "MerchantID"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                r1.f(r0)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                java.lang.Integer r4 = r0.n     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x005a }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x005a }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x005a }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x005a }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x005a }
                goto L_0x0067
            L_0x005a:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0067
            L_0x0061:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this
                java.lang.Integer r4 = r4.r
            L_0x0067:
                return r4
            L_0x0068:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                java.lang.Integer r4 = r0.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x0109, UnknownHostException -> 0x00ea, SocketTimeoutException -> 0x00cb, Exception -> 0x0089 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x007d }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x007d }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x007d }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x007d }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x007d }
                goto L_0x0085
            L_0x007d:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0085
                goto L_0x0061
            L_0x0085:
                return r4
            L_0x0086:
                r4 = move-exception
                goto L_0x0128
            L_0x0089:
                boolean r4 = r3.isCancelled()     // Catch:{ all -> 0x0086 }
                if (r4 == 0) goto L_0x00ad
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x0086 }
                java.lang.Integer r4 = r4.r     // Catch:{ all -> 0x0086 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00a4 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00a4 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00a4 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00a4 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00a4 }
                goto L_0x00ac
            L_0x00a4:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00ac
                goto L_0x0061
            L_0x00ac:
                return r4
            L_0x00ad:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x0086 }
                java.lang.Integer r4 = r4.w     // Catch:{ all -> 0x0086 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00c2 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00c2 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00c2 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00c2 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00c2 }
                goto L_0x00ca
            L_0x00c2:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00ca
                goto L_0x0061
            L_0x00ca:
                return r4
            L_0x00cb:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x0086 }
                java.lang.Integer r4 = r4.r     // Catch:{ all -> 0x0086 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00e0 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00e0 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00e0 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00e0 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00e0 }
                goto L_0x00e9
            L_0x00e0:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00e9
                goto L_0x0061
            L_0x00e9:
                return r4
            L_0x00ea:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x0086 }
                java.lang.Integer r4 = r4.p     // Catch:{ all -> 0x0086 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00ff }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00ff }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00ff }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00ff }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00ff }
                goto L_0x0108
            L_0x00ff:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0108
                goto L_0x0061
            L_0x0108:
                return r4
            L_0x0109:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x0086 }
                java.lang.Integer r4 = r4.x     // Catch:{ all -> 0x0086 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x011e }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x011e }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x011e }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x011e }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x011e }
                goto L_0x0127
            L_0x011e:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0127
                goto L_0x0061
            L_0x0127:
                return r4
            L_0x0128:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0137 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0137 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0137 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0137 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0137 }
                goto L_0x0140
            L_0x0137:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0140
                goto L_0x0061
            L_0x0140:
                goto L_0x0142
            L_0x0141:
                throw r4
            L_0x0142:
                goto L_0x0141
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.c.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num == j.this.n) {
                j.this.c();
                j.this.f5317d.setResponseCredentialOTPRegistration(this.f5334d);
                j.this.f5317d.setOTPFieldEnabled(true);
                j.this.f5317d.l();
                j.this.f5317d.a();
            } else if (num == j.this.v) {
                j.this.c();
                j.this.f5317d.setOTPFieldEnabled(true);
                j.this.f5317d.l();
                j.this.f5317d.a();
                j.this.a(num);
            } else if (num == j.this.r) {
                j.this.c();
                j.this.f5317d.setOTPFieldEnabled(true);
                j.this.f5317d.l();
                j.this.a(num);
            } else {
                j.this.a(num);
            }
        }
    }

    public class d extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5336b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5337c;

        /* renamed from: d  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5338d;

        public d(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5336b = aVar;
            this.f5337c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5338d = new com.bca.xco.widget.a.b();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|(2:20|21)|25) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8 = com.bca.xco.widget.j.a(r7.f5335a, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5335a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d9, code lost:
            if (isCancelled() == false) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00dc, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00dd, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e4, code lost:
            if (isCancelled() != false) goto L_0x00e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0103, code lost:
            return com.bca.xco.widget.j.g(r7.f5335a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r8 = com.bca.xco.widget.j.h(r7.f5335a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5335a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x011e, code lost:
            if (isCancelled() == false) goto L_0x0121;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0121, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r8 = com.bca.xco.widget.j.g(r7.f5335a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5335a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x013c, code lost:
            if (isCancelled() == false) goto L_0x0140;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0140, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r8 = com.bca.xco.widget.j.f(r7.f5335a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5335a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x015b, code lost:
            if (isCancelled() == false) goto L_0x015f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x015f, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x017a, code lost:
            if (isCancelled() == false) goto L_0x017e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5335a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0193, code lost:
            if (isCancelled() == false) goto L_0x0198;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0198, code lost:
            throw r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return com.bca.xco.widget.j.g(r7.f5335a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x00e0, B:45:0x0122, B:53:0x0141, B:61:0x0160] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00e0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0141 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0160 */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0122 A[EDGE_INSN: B:45:0x0122->B:46:? ?: BREAK  , SYNTHETIC, Splitter:B:45:0x0122] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0141 A[EDGE_INSN: B:53:0x0141->B:54:? ?: BREAK  , SYNTHETIC, Splitter:B:53:0x0141] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0160 A[EDGE_INSN: B:61:0x0160->B:62:? ?: BREAK  , SYNTHETIC, Splitter:B:61:0x0160] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x00e0=Splitter:B:27:0x00e0, B:61:0x0160=Splitter:B:61:0x0160, B:53:0x0141=Splitter:B:53:0x0141, B:45:0x0122=Splitter:B:45:0x0122} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                com.bca.xco.widget.c.a r8 = r8.f5314a     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                java.lang.String r0 = r0.A     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                com.bca.xco.widget.a.a r1 = r7.f5336b     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                com.bca.xco.widget.a.b r2 = r7.f5337c     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                java.lang.String r8 = r8.c(r0, r1, r2)     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r0.<init>(r8)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.b r1 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r2 = "XCOID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.h(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.b r1 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r2 = "MaxLimit"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.d(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.b r1 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r2 = "CredentialType"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.b(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.b r1 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r2 = "CredentialNumber"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.c(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.b r1 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r2 = "MerchantID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.f(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.b r1 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r2 = "CustomerIDMerchant"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.e(r2)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.<init>()     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r3 = "MSISDNList"
                java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r0 = 0
            L_0x0070:
                int r3 = r2.length()     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                if (r0 >= r3) goto L_0x0097
                org.json.JSONObject r3 = r2.getJSONObject(r0)     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r4 = "MSISDNData"
                org.json.JSONObject r3 = r3.getJSONObject(r4)     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.a.c r4 = new com.bca.xco.widget.a.c     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r5 = "MSISDNID"
                java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.String r6 = "MSISDN"
                java.lang.String r3 = r3.getString(r6)     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r4.<init>(r5, r3)     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r1.add(r4)     // Catch:{ Exception -> 0x0094, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
            L_0x0094:
                int r0 = r0 + 1
                goto L_0x0070
            L_0x0097:
                com.bca.xco.widget.a.b r0 = r7.f5338d     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                r0.a((java.util.List<com.bca.xco.widget.a.c>) r1)     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                java.lang.Integer r8 = r0.n     // Catch:{ Exception -> 0x00bf, ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00b1 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00b1 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00b1 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00b1 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00b1 }
                goto L_0x00be
            L_0x00b1:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x00be
            L_0x00b8:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this
                java.lang.Integer r8 = r8.r
            L_0x00be:
                return r8
            L_0x00bf:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                java.lang.Integer r8 = r0.b((java.lang.String) r8)     // Catch:{ ConnectException -> 0x0160, UnknownHostException -> 0x0141, SocketTimeoutException -> 0x0122, Exception -> 0x00e0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00d4 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00d4 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00d4 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d4 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d4 }
                goto L_0x00dc
            L_0x00d4:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x00dc
                goto L_0x00b8
            L_0x00dc:
                return r8
            L_0x00dd:
                r8 = move-exception
                goto L_0x017f
            L_0x00e0:
                boolean r8 = r7.isCancelled()     // Catch:{ all -> 0x00dd }
                if (r8 == 0) goto L_0x0104
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00dd }
                java.lang.Integer r8 = r8.r     // Catch:{ all -> 0x00dd }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00fb }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00fb }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00fb }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00fb }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00fb }
                goto L_0x0103
            L_0x00fb:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x0103
                goto L_0x00b8
            L_0x0103:
                return r8
            L_0x0104:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00dd }
                java.lang.Integer r8 = r8.w     // Catch:{ all -> 0x00dd }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0119 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0119 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0119 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0119 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0119 }
                goto L_0x0121
            L_0x0119:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x0121
                goto L_0x00b8
            L_0x0121:
                return r8
            L_0x0122:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00dd }
                java.lang.Integer r8 = r8.r     // Catch:{ all -> 0x00dd }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0137 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0137 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0137 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0137 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0137 }
                goto L_0x0140
            L_0x0137:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x0140
                goto L_0x00b8
            L_0x0140:
                return r8
            L_0x0141:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00dd }
                java.lang.Integer r8 = r8.p     // Catch:{ all -> 0x00dd }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0156 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0156 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0156 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0156 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0156 }
                goto L_0x015f
            L_0x0156:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x015f
                goto L_0x00b8
            L_0x015f:
                return r8
            L_0x0160:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00dd }
                java.lang.Integer r8 = r8.x     // Catch:{ all -> 0x00dd }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0175 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0175 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0175 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0175 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0175 }
                goto L_0x017e
            L_0x0175:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x017e
                goto L_0x00b8
            L_0x017e:
                return r8
            L_0x017f:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x018e }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x018e }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x018e }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x018e }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x018e }
                goto L_0x0197
            L_0x018e:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x0197
                goto L_0x00b8
            L_0x0197:
                goto L_0x0199
            L_0x0198:
                throw r8
            L_0x0199:
                goto L_0x0198
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.d.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num == j.this.n) {
                j.this.f5317d.setResponseCredentialRequestRegistration(this.f5338d);
                j.this.f5317d.b(3);
                j.this.f5317d.k();
                j.this.f5317d.a(1);
                new e(this.f5338d.h()).execute(new Void[0]);
            } else if (num == j.this.l) {
                j.this.c();
                j.this.f5317d.a(j.this.f5319f, j.this.f5320g, j.this.h, this.f5338d.g());
            } else {
                j.this.c();
                j.this.a(num);
            }
        }
    }

    public class a extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5322b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5323c;

        /* renamed from: d  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5324d;

        public a(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5322b = aVar;
            this.f5323c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5324d = new com.bca.xco.widget.a.b();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r4 = com.bca.xco.widget.j.a(r3.f5321a, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5321a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x009c, code lost:
            if (isCancelled() == false) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c7, code lost:
            if (isCancelled() == false) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e5, code lost:
            if (isCancelled() == false) goto L_0x00e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r4 = com.bca.xco.widget.j.g(r3.f5321a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5321a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0103, code lost:
            if (isCancelled() == false) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0107, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            r4 = com.bca.xco.widget.j.f(r3.f5321a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5321a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0122, code lost:
            if (isCancelled() == false) goto L_0x0126;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0126, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r4 = com.bca.xco.widget.j.e(r3.f5321a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5321a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0141, code lost:
            if (isCancelled() == false) goto L_0x0145;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x015a, code lost:
            if (isCancelled() == false) goto L_0x015f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return com.bca.xco.widget.j.g(r3.f5321a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0127 */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0108 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0127 A[SYNTHETIC] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x0127=Splitter:B:54:0x0127, B:46:0x0108=Splitter:B:46:0x0108, B:38:0x00e9=Splitter:B:38:0x00e9} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r4) {
            /*
                r3 = this;
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                com.bca.xco.widget.c.a r4 = r4.f5314a     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                r0.<init>()     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                com.bca.xco.widget.j r1 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.String r1 = r1.F     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                r0.append(r1)     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.String r1 = "/"
                r0.append(r1)     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                com.bca.xco.widget.a.b r1 = r3.f5323c     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.String r1 = r1.g()     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                r0.append(r1)     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.String r0 = r0.toString()     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                com.bca.xco.widget.a.a r1 = r3.f5322b     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                com.bca.xco.widget.a.b r2 = r3.f5323c     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.String r4 = r4.e(r0, r1, r2)     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                r0.<init>(r4)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                com.bca.xco.widget.a.b r1 = r3.f5324d     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                java.lang.String r2 = "XCOID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                r1.h(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                com.bca.xco.widget.a.b r1 = r3.f5324d     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                java.lang.String r2 = "MaxLimit"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                r1.d(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                com.bca.xco.widget.a.b r1 = r3.f5324d     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                java.lang.String r2 = "CredentialType"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                r1.b(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                com.bca.xco.widget.a.b r1 = r3.f5324d     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                java.lang.String r2 = "CredentialNumber"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                r1.c(r0)     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                java.lang.Integer r4 = r0.n     // Catch:{ Exception -> 0x0082, ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0074 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0074 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0074 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0074 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0074 }
                goto L_0x0081
            L_0x0074:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0081
            L_0x007b:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this
                java.lang.Integer r4 = r4.r
            L_0x0081:
                return r4
            L_0x0082:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                java.lang.Integer r4 = r0.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x0127, UnknownHostException -> 0x0108, SocketTimeoutException -> 0x00e9, Exception -> 0x00a3 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0097 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0097 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0097 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0097 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0097 }
                goto L_0x009f
            L_0x0097:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x009f
                goto L_0x007b
            L_0x009f:
                return r4
            L_0x00a0:
                r4 = move-exception
                goto L_0x0146
            L_0x00a3:
                r4 = move-exception
                r4.printStackTrace()     // Catch:{ all -> 0x00a0 }
                boolean r4 = r3.isCancelled()     // Catch:{ all -> 0x00a0 }
                if (r4 == 0) goto L_0x00cb
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a0 }
                java.lang.Integer r4 = r4.r     // Catch:{ all -> 0x00a0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00c2 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00c2 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00c2 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00c2 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00c2 }
                goto L_0x00ca
            L_0x00c2:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00ca
                goto L_0x007b
            L_0x00ca:
                return r4
            L_0x00cb:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a0 }
                java.lang.Integer r4 = r4.w     // Catch:{ all -> 0x00a0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00e0 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00e0 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00e0 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00e0 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00e0 }
                goto L_0x00e8
            L_0x00e0:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00e8
                goto L_0x007b
            L_0x00e8:
                return r4
            L_0x00e9:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a0 }
                java.lang.Integer r4 = r4.r     // Catch:{ all -> 0x00a0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00fe }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00fe }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00fe }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00fe }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00fe }
                goto L_0x0107
            L_0x00fe:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0107
                goto L_0x007b
            L_0x0107:
                return r4
            L_0x0108:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a0 }
                java.lang.Integer r4 = r4.p     // Catch:{ all -> 0x00a0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x011d }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x011d }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x011d }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x011d }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x011d }
                goto L_0x0126
            L_0x011d:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0126
                goto L_0x007b
            L_0x0126:
                return r4
            L_0x0127:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a0 }
                java.lang.Integer r4 = r4.x     // Catch:{ all -> 0x00a0 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x013c }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x013c }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x013c }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x013c }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x013c }
                goto L_0x0145
            L_0x013c:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0145
                goto L_0x007b
            L_0x0145:
                return r4
            L_0x0146:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0155 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0155 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0155 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0155 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0155 }
                goto L_0x015e
            L_0x0155:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x015e
                goto L_0x007b
            L_0x015e:
                goto L_0x0160
            L_0x015f:
                throw r4
            L_0x0160:
                goto L_0x015f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.a.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num == j.this.n) {
                j.this.c();
                j.this.f5317d.setResponseCredentialDetails(this.f5324d);
                j.this.f5317d.a(this.f5324d.b(), this.f5324d.c());
                return;
            }
            j.this.a(num);
        }
    }

    public class h extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5350b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5351c;

        /* renamed from: d  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5352d;

        public h(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5350b = aVar;
            this.f5351c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5352d = new com.bca.xco.widget.a.b();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|(2:20|21)|25) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8 = com.bca.xco.widget.j.a(r7.f5349a, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5349a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b8, code lost:
            if (isCancelled() == false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bb, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bc, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c3, code lost:
            if (isCancelled() != false) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e2, code lost:
            return com.bca.xco.widget.j.g(r7.f5349a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r8 = com.bca.xco.widget.j.h(r7.f5349a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5349a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fd, code lost:
            if (isCancelled() == false) goto L_0x0100;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0100, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r8 = com.bca.xco.widget.j.g(r7.f5349a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5349a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x011b, code lost:
            if (isCancelled() == false) goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x011f, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r8 = com.bca.xco.widget.j.f(r7.f5349a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5349a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
            if (isCancelled() == false) goto L_0x013e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x013e, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0159, code lost:
            if (isCancelled() == false) goto L_0x015d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r7.f5349a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0172, code lost:
            if (isCancelled() == false) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0177, code lost:
            throw r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return com.bca.xco.widget.j.g(r7.f5349a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x00bf, B:45:0x0101, B:53:0x0120, B:61:0x013f] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x013f */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0101 A[EDGE_INSN: B:45:0x0101->B:46:? ?: BREAK  , SYNTHETIC, Splitter:B:45:0x0101] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0120 A[EDGE_INSN: B:53:0x0120->B:54:? ?: BREAK  , SYNTHETIC, Splitter:B:53:0x0120] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x013f A[EDGE_INSN: B:61:0x013f->B:62:? ?: BREAK  , SYNTHETIC, Splitter:B:61:0x013f] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:53:0x0120=Splitter:B:53:0x0120, B:45:0x0101=Splitter:B:45:0x0101, B:27:0x00bf=Splitter:B:27:0x00bf, B:61:0x013f=Splitter:B:61:0x013f} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                com.bca.xco.widget.c.a r8 = r8.f5314a     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                java.lang.String r0 = r0.D     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                com.bca.xco.widget.a.a r1 = r7.f5350b     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                com.bca.xco.widget.a.b r2 = r7.f5351c     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                java.lang.String r8 = r8.f(r0, r1, r2)     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r0.<init>(r8)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                com.bca.xco.widget.a.b r1 = r7.f5352d     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r2 = "XCOID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r1.h(r2)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                com.bca.xco.widget.a.b r1 = r7.f5352d     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r2 = "MaxLimit"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r1.d(r2)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                com.bca.xco.widget.a.b r1 = r7.f5352d     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r2 = "MerchantID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r1.f(r2)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r1.<init>()     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r3 = "MSISDNList"
                java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r0 = 0
            L_0x004f:
                int r3 = r2.length()     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                if (r0 >= r3) goto L_0x0076
                org.json.JSONObject r3 = r2.getJSONObject(r0)     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r4 = "MSISDNData"
                org.json.JSONObject r3 = r3.getJSONObject(r4)     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                com.bca.xco.widget.a.c r4 = new com.bca.xco.widget.a.c     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r5 = "MSISDNID"
                java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.String r6 = "MSISDN"
                java.lang.String r3 = r3.getString(r6)     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r4.<init>(r5, r3)     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r1.add(r4)     // Catch:{ Exception -> 0x0073, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
            L_0x0073:
                int r0 = r0 + 1
                goto L_0x004f
            L_0x0076:
                com.bca.xco.widget.a.b r0 = r7.f5352d     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                r0.a((java.util.List<com.bca.xco.widget.a.c>) r1)     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                java.lang.Integer r8 = r0.n     // Catch:{ Exception -> 0x009e, ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0090 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0090 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0090 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0090 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0090 }
                goto L_0x009d
            L_0x0090:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x009d
            L_0x0097:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this
                java.lang.Integer r8 = r8.r
            L_0x009d:
                return r8
            L_0x009e:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                java.lang.Integer r8 = r0.b((java.lang.String) r8)     // Catch:{ ConnectException -> 0x013f, UnknownHostException -> 0x0120, SocketTimeoutException -> 0x0101, Exception -> 0x00bf }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00b3 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00b3 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00b3 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00b3 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00b3 }
                goto L_0x00bb
            L_0x00b3:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x00bb
                goto L_0x0097
            L_0x00bb:
                return r8
            L_0x00bc:
                r8 = move-exception
                goto L_0x015e
            L_0x00bf:
                boolean r8 = r7.isCancelled()     // Catch:{ all -> 0x00bc }
                if (r8 == 0) goto L_0x00e3
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00bc }
                java.lang.Integer r8 = r8.r     // Catch:{ all -> 0x00bc }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00da }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00da }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00da }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00da }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00da }
                goto L_0x00e2
            L_0x00da:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x00e2
                goto L_0x0097
            L_0x00e2:
                return r8
            L_0x00e3:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00bc }
                java.lang.Integer r8 = r8.w     // Catch:{ all -> 0x00bc }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00f8 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00f8 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00f8 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00f8 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00f8 }
                goto L_0x0100
            L_0x00f8:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x0100
                goto L_0x0097
            L_0x0100:
                return r8
            L_0x0101:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00bc }
                java.lang.Integer r8 = r8.r     // Catch:{ all -> 0x00bc }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0116 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0116 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0116 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0116 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0116 }
                goto L_0x011f
            L_0x0116:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x011f
                goto L_0x0097
            L_0x011f:
                return r8
            L_0x0120:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00bc }
                java.lang.Integer r8 = r8.p     // Catch:{ all -> 0x00bc }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0135 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0135 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0135 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0135 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0135 }
                goto L_0x013e
            L_0x0135:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x013e
                goto L_0x0097
            L_0x013e:
                return r8
            L_0x013f:
                com.bca.xco.widget.j r8 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00bc }
                java.lang.Integer r8 = r8.x     // Catch:{ all -> 0x00bc }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0154 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0154 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0154 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0154 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0154 }
                goto L_0x015d
            L_0x0154:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x015d
                goto L_0x0097
            L_0x015d:
                return r8
            L_0x015e:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x016d }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x016d }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x016d }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x016d }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x016d }
                goto L_0x0176
            L_0x016d:
                boolean r0 = r7.isCancelled()
                if (r0 == 0) goto L_0x0176
                goto L_0x0097
            L_0x0176:
                goto L_0x0178
            L_0x0177:
                throw r8
            L_0x0178:
                goto L_0x0177
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.h.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num == j.this.n) {
                j.this.f5317d.setResponseCredentialRequestRegistration(this.f5352d);
                j.this.f5317d.b(3);
                j.this.f5317d.k();
                j.this.f5317d.a(2);
                new e(this.f5352d.h()).execute(new Void[0]);
                return;
            }
            j.this.c();
            j.this.a(num);
        }
    }

    public class f extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5342b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5343c;

        /* renamed from: d  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5344d;

        public f(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5342b = aVar;
            this.f5343c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5344d = new com.bca.xco.widget.a.b();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|(4:13|14|15|19)(5:20|21|22|23|27)) */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0074, code lost:
            if (com.bca.xco.widget.j.g(r3.f5341a) == com.bca.xco.widget.j.a(r3.f5341a, r4)) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
            r4 = com.bca.xco.widget.j.x(r3.f5341a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
            if (isCancelled() == false) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0093, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4 = com.bca.xco.widget.j.a(r3.f5341a, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ae, code lost:
            if (isCancelled() == false) goto L_0x00b1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b1, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b9, code lost:
            if (isCancelled() != false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d8, code lost:
            return com.bca.xco.widget.j.x(r3.f5341a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r4 = com.bca.xco.widget.j.h(r3.f5341a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
            if (isCancelled() == false) goto L_0x00f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f7, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r4 = com.bca.xco.widget.j.x(r3.f5341a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0112, code lost:
            if (isCancelled() == false) goto L_0x0116;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0116, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r4 = com.bca.xco.widget.j.f(r3.f5341a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0131, code lost:
            if (isCancelled() == false) goto L_0x0135;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0135, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r4 = com.bca.xco.widget.j.e(r3.f5341a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0150, code lost:
            if (isCancelled() == false) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0154, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5341a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0169, code lost:
            if (isCancelled() == false) goto L_0x016e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x016e, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return com.bca.xco.widget.j.x(r3.f5341a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:29:0x00b5, B:47:0x00f8, B:55:0x0117, B:63:0x0136] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0117 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0136 */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8 A[SYNTHETIC, Splitter:B:47:0x00f8] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0117 A[SYNTHETIC, Splitter:B:55:0x0117] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0136 A[SYNTHETIC, Splitter:B:63:0x0136] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x00b5=Splitter:B:29:0x00b5, B:63:0x0136=Splitter:B:63:0x0136, B:55:0x0117=Splitter:B:55:0x0117, B:47:0x00f8=Splitter:B:47:0x00f8} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r4) {
            /*
                r3 = this;
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.c.a r4 = r4.f5314a     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                java.lang.String r0 = r0.z     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.a.a r1 = r3.f5342b     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.a.b r2 = r3.f5343c     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                java.lang.String r4 = r4.b(r0, r1, r2)     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                r0.<init>(r4)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                com.bca.xco.widget.a.b r1 = r3.f5344d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                java.lang.String r2 = "XCOID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                r1.h(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                com.bca.xco.widget.a.b r1 = r3.f5344d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                java.lang.String r2 = "CredentialType"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                r1.b(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                com.bca.xco.widget.a.b r1 = r3.f5344d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                java.lang.String r2 = "CredentialNumber"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                r1.c(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                com.bca.xco.widget.a.b r1 = r3.f5344d     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                java.lang.String r2 = "MaxLimit"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                r1.d(r0)     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                java.lang.Integer r4 = r0.j     // Catch:{ Exception -> 0x0068, ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x005a }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x005a }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x005a }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x005a }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x005a }
                goto L_0x0067
            L_0x005a:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0067
            L_0x0061:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this
                java.lang.Integer r4 = r4.t
            L_0x0067:
                return r4
            L_0x0068:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                java.lang.Integer r0 = r0.r     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.j r1 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                java.lang.Integer r1 = r1.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                if (r0 != r1) goto L_0x0094
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                java.lang.Integer r4 = r4.t     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x008b }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x008b }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x008b }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x008b }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x008b }
                goto L_0x0093
            L_0x008b:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0093
                goto L_0x0061
            L_0x0093:
                return r4
            L_0x0094:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                java.lang.Integer r4 = r0.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x0136, UnknownHostException -> 0x0117, SocketTimeoutException -> 0x00f8, Exception -> 0x00b5 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00a9 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00a9 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00a9 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00a9 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00a9 }
                goto L_0x00b1
            L_0x00a9:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00b1
                goto L_0x0061
            L_0x00b1:
                return r4
            L_0x00b2:
                r4 = move-exception
                goto L_0x0155
            L_0x00b5:
                boolean r4 = r3.isCancelled()     // Catch:{ all -> 0x00b2 }
                if (r4 == 0) goto L_0x00d9
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00b2 }
                java.lang.Integer r4 = r4.t     // Catch:{ all -> 0x00b2 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00d0 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00d0 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00d0 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d0 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d0 }
                goto L_0x00d8
            L_0x00d0:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00d8
                goto L_0x0061
            L_0x00d8:
                return r4
            L_0x00d9:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00b2 }
                java.lang.Integer r4 = r4.w     // Catch:{ all -> 0x00b2 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00ee }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00ee }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00ee }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00ee }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00ee }
                goto L_0x00f7
            L_0x00ee:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00f7
                goto L_0x0061
            L_0x00f7:
                return r4
            L_0x00f8:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00b2 }
                java.lang.Integer r4 = r4.t     // Catch:{ all -> 0x00b2 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x010d }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x010d }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x010d }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x010d }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x010d }
                goto L_0x0116
            L_0x010d:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0116
                goto L_0x0061
            L_0x0116:
                return r4
            L_0x0117:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00b2 }
                java.lang.Integer r4 = r4.p     // Catch:{ all -> 0x00b2 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x012c }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x012c }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x012c }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x012c }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x012c }
                goto L_0x0135
            L_0x012c:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0135
                goto L_0x0061
            L_0x0135:
                return r4
            L_0x0136:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00b2 }
                java.lang.Integer r4 = r4.x     // Catch:{ all -> 0x00b2 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x014b }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x014b }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x014b }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x014b }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x014b }
                goto L_0x0154
            L_0x014b:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0154
                goto L_0x0061
            L_0x0154:
                return r4
            L_0x0155:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0164 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0164 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0164 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0164 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0164 }
                goto L_0x016d
            L_0x0164:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x016d
                goto L_0x0061
            L_0x016d:
                goto L_0x016f
            L_0x016e:
                throw r4
            L_0x016f:
                goto L_0x016e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.f.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            j.this.c();
            if (num == j.this.j) {
                j.this.f5317d.d(j.this.f5316c.getString(h.f.xco_success_registration));
                j.this.f5318e.a(this.f5344d.g(), this.f5344d.a(), this.f5344d.b(), this.f5344d.c());
                return;
            }
            j.this.a(num);
        }
    }

    public class g extends AsyncTask<Void, Void, Integer> {

        /* renamed from: b  reason: collision with root package name */
        private com.bca.xco.widget.a.a f5346b;

        /* renamed from: c  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5347c;

        /* renamed from: d  reason: collision with root package name */
        private com.bca.xco.widget.a.b f5348d;

        public g(com.bca.xco.widget.a.a aVar, com.bca.xco.widget.a.b bVar) {
            this.f5346b = aVar;
            this.f5347c = bVar;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5348d = new com.bca.xco.widget.a.b();
            j.this.b();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|(4:13|14|15|19)(5:20|21|22|23|27)) */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
            if (com.bca.xco.widget.j.g(r3.f5345a) == com.bca.xco.widget.j.a(r3.f5345a, r4)) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x006b, code lost:
            r4 = com.bca.xco.widget.j.B(r3.f5345a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
            if (isCancelled() == false) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0088, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4 = com.bca.xco.widget.j.a(r3.f5345a, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
            if (isCancelled() == false) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
            if (isCancelled() != false) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cd, code lost:
            return com.bca.xco.widget.j.B(r3.f5345a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r4 = com.bca.xco.widget.j.h(r3.f5345a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e8, code lost:
            if (isCancelled() == false) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ec, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r4 = com.bca.xco.widget.j.B(r3.f5345a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0107, code lost:
            if (isCancelled() == false) goto L_0x010b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x010b, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r4 = com.bca.xco.widget.j.f(r3.f5345a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0126, code lost:
            if (isCancelled() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x012a, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r4 = com.bca.xco.widget.j.e(r3.f5345a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0145, code lost:
            if (isCancelled() == false) goto L_0x0149;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0149, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            java.lang.Thread.sleep((long) com.bca.xco.widget.j.i(r3.f5345a).intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x015e, code lost:
            if (isCancelled() == false) goto L_0x0163;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0163, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return com.bca.xco.widget.j.B(r3.f5345a);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:29:0x00aa, B:47:0x00ed, B:55:0x010c, B:63:0x012b] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x012b */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00ed A[SYNTHETIC, Splitter:B:47:0x00ed] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x010c A[SYNTHETIC, Splitter:B:55:0x010c] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x012b A[SYNTHETIC, Splitter:B:63:0x012b] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x00aa=Splitter:B:29:0x00aa, B:63:0x012b=Splitter:B:63:0x012b, B:55:0x010c=Splitter:B:55:0x010c, B:47:0x00ed=Splitter:B:47:0x00ed} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r4) {
            /*
                r3 = this;
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.c.a r4 = r4.f5314a     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                java.lang.String r0 = r0.E     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.a.a r1 = r3.f5346b     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.a.b r2 = r3.f5347c     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                java.lang.String r4 = r4.g(r0, r1, r2)     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                r0.<init>(r4)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                com.bca.xco.widget.a.b r1 = r3.f5348d     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                java.lang.String r2 = "XCOID"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                r1.h(r2)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                com.bca.xco.widget.a.b r1 = r3.f5348d     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                java.lang.String r2 = "MaxLimit"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                r1.d(r2)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                com.bca.xco.widget.a.b r1 = r3.f5348d     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                java.lang.String r2 = "MerchantID"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                r1.f(r0)     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                java.lang.Integer r4 = r0.j     // Catch:{ Exception -> 0x005d, ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x004f }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x004f }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x004f }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x004f }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x004f }
                goto L_0x005c
            L_0x004f:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x005c
            L_0x0056:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this
                java.lang.Integer r4 = r4.u
            L_0x005c:
                return r4
            L_0x005d:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                java.lang.Integer r0 = r0.r     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.j r1 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                java.lang.Integer r1 = r1.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                if (r0 != r1) goto L_0x0089
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                java.lang.Integer r4 = r4.u     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0080 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0080 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0080 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0080 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0080 }
                goto L_0x0088
            L_0x0080:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0088
                goto L_0x0056
            L_0x0088:
                return r4
            L_0x0089:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                java.lang.Integer r4 = r0.b((java.lang.String) r4)     // Catch:{ ConnectException -> 0x012b, UnknownHostException -> 0x010c, SocketTimeoutException -> 0x00ed, Exception -> 0x00aa }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x009e }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x009e }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x009e }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x009e }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x009e }
                goto L_0x00a6
            L_0x009e:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00a6
                goto L_0x0056
            L_0x00a6:
                return r4
            L_0x00a7:
                r4 = move-exception
                goto L_0x014a
            L_0x00aa:
                boolean r4 = r3.isCancelled()     // Catch:{ all -> 0x00a7 }
                if (r4 == 0) goto L_0x00ce
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a7 }
                java.lang.Integer r4 = r4.u     // Catch:{ all -> 0x00a7 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00c5 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00c5 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00c5 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00c5 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00c5 }
                goto L_0x00cd
            L_0x00c5:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00cd
                goto L_0x0056
            L_0x00cd:
                return r4
            L_0x00ce:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a7 }
                java.lang.Integer r4 = r4.w     // Catch:{ all -> 0x00a7 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x00e3 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x00e3 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x00e3 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00e3 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00e3 }
                goto L_0x00ec
            L_0x00e3:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x00ec
                goto L_0x0056
            L_0x00ec:
                return r4
            L_0x00ed:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a7 }
                java.lang.Integer r4 = r4.u     // Catch:{ all -> 0x00a7 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0102 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0102 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0102 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0102 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0102 }
                goto L_0x010b
            L_0x0102:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x010b
                goto L_0x0056
            L_0x010b:
                return r4
            L_0x010c:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a7 }
                java.lang.Integer r4 = r4.p     // Catch:{ all -> 0x00a7 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0121 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0121 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0121 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0121 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0121 }
                goto L_0x012a
            L_0x0121:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x012a
                goto L_0x0056
            L_0x012a:
                return r4
            L_0x012b:
                com.bca.xco.widget.j r4 = com.bca.xco.widget.j.this     // Catch:{ all -> 0x00a7 }
                java.lang.Integer r4 = r4.x     // Catch:{ all -> 0x00a7 }
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0140 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0140 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0140 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0140 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0140 }
                goto L_0x0149
            L_0x0140:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0149
                goto L_0x0056
            L_0x0149:
                return r4
            L_0x014a:
                com.bca.xco.widget.j r0 = com.bca.xco.widget.j.this     // Catch:{ InterruptedException -> 0x0159 }
                java.lang.Integer r0 = r0.i     // Catch:{ InterruptedException -> 0x0159 }
                int r0 = r0.intValue()     // Catch:{ InterruptedException -> 0x0159 }
                long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0159 }
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0159 }
                goto L_0x0162
            L_0x0159:
                boolean r0 = r3.isCancelled()
                if (r0 == 0) goto L_0x0162
                goto L_0x0056
            L_0x0162:
                goto L_0x0164
            L_0x0163:
                throw r4
            L_0x0164:
                goto L_0x0163
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.j.g.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Integer num) {
            super.onCancelled(num);
            if (isCancelled()) {
                j.this.a(num);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            j.this.c();
            if (num == j.this.j) {
                j.this.f5317d.d(j.this.f5316c.getString(h.f.xco_success_updatelimit));
                j.this.f5318e.a(this.f5348d.g(), this.f5348d.a(), this.f5348d.b(), this.f5348d.c());
                return;
            }
            j.this.a(num);
        }
    }

    private class e extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private List<com.bca.xco.widget.a.c> f5340b;

        public e(List<com.bca.xco.widget.a.c> list) {
            this.f5340b = list;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            j.this.f5317d.setListPhone(this.f5340b);
            j.this.c();
        }
    }

    /* access modifiers changed from: private */
    public void a(Integer num) {
        c();
        if (num == this.o) {
            d dVar = this.f5317d;
            String str = this.f5319f;
            String str2 = this.f5320g;
            dVar.a(str, str2, str2);
        } else if (num == this.p || num == this.x) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_network_failed));
        } else if (num == this.r) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_timeout));
        } else if (num == this.s) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_timeout_token));
        } else if (num == this.t) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_timeout_add));
        } else if (num == this.u) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_timeout_edit));
        } else if (num == this.w) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_unknown));
        } else if (num == this.v) {
            d dVar2 = this.f5317d;
            String str3 = this.f5319f;
            String str4 = this.f5320g;
            dVar2.a(str3, str4, str4);
        } else if (num == this.k) {
            this.f5317d.e(this.f5316c.getString(h.f.xco_error_token_expired));
        } else if (num == this.m) {
            d dVar3 = this.f5317d;
            String str5 = this.f5319f;
            String str6 = this.f5320g;
            dVar3.b(str5, str6, str6);
        } else if (num == this.q) {
            this.f5317d.c(this.f5316c.getString(h.f.xco_error_hmac_mismatch));
        }
    }

    private HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = new JSONObject(jSONObject.get("ErrorMessage").toString());
        hashMap.put("errorCode", jSONObject.get("ErrorCode") + "");
        hashMap.put("errorMessageID", jSONObject2.get(this.f5316c.getString(h.f.xco_error_message_ind)) + "");
        hashMap.put("errorMessageEng", jSONObject2.get(this.f5316c.getString(h.f.xco_error_message_eng)) + "");
        return hashMap;
    }

    /* access modifiers changed from: private */
    public Integer b(String str) {
        HashMap<String, String> a2 = a(str);
        this.f5319f = a2.get("errorCode");
        this.f5320g = a2.get("errorMessageID");
        this.h = a2.get("errorMessageEng");
        com.bca.xco.widget.e.c.b("ErrorCode", this.f5319f);
        com.bca.xco.widget.e.c.b("ErrorMsg", this.f5320g);
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_009))) {
            return this.k;
        }
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_001))) {
            return this.q;
        }
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_054))) {
            return this.l;
        }
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_007))) {
            return this.r;
        }
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_011))) {
            return this.r;
        }
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_072))) {
            return this.m;
        }
        if (this.f5319f.equals(this.f5316c.getString(h.f.xco_error_code_mapping_057))) {
            return this.v;
        }
        return this.o;
    }
}
