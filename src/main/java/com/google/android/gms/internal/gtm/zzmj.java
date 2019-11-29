package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public final class zzmj extends zzhb {
    private static final String ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final List<String> zzamg = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
    private static final Pattern zzamh = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzami = Pattern.compile("metric(\\d+)");
    private static final Set<String> zzasb = CollectionUtils.setOf("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "false");
    private static final Map<String, String> zzasc = CollectionUtils.mapOf("transactionId", "&ti", "transactionAffiliation", "&ta", "transactionTax", "&tt", "transactionShipping", "&ts", "transactionTotal", "&tr", "transactionCurrency", "&cu");
    private static final Map<String, String> zzasd = CollectionUtils.mapOf("name", "&in", "sku", "&ic", "category", "&iv", "price", "&ip", "quantity", "&iq", "currency", "&cu");
    private final zzfj zzapc;
    private final zzgu zzase;
    private Map<String, Object> zzasf;

    public zzmj(Context context, zzfj zzfj) {
        this(new zzgu(context), zzfj);
    }

    @VisibleForTesting
    private zzmj(zzgu zzgu, zzfj zzfj) {
        this.zzapc = zzfj;
        this.zzase = zzgu;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0237, code lost:
        r4 = (java.util.Map) r7.get(r2);
        r0 = (java.util.List) r4.get("products");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0246, code lost:
        if (r0 == null) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0248, code lost:
        r5 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0250, code lost:
        if (r5.hasNext() == false) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        r6.addProduct(zzj((java.util.Map) r5.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0260, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        r0 = java.lang.String.valueOf(r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x026f, code lost:
        if (r0.length() != 0) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0271, code lost:
        r0 = "Failed to extract a product from event data. ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0276, code lost:
        r0 = new java.lang.String("Failed to extract a product from event data. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x027b, code lost:
        com.google.android.gms.internal.gtm.zzev.zzav(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0285, code lost:
        if (r4.containsKey("actionField") == false) goto L_0x032c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0287, code lost:
        r0 = (java.util.Map) r4.get("actionField");
        r4 = new com.google.android.gms.analytics.ecommerce.ProductAction(r2);
        r2 = r0.get("id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x029a, code lost:
        if (r2 == null) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x029c, code lost:
        r4.setTransactionId(java.lang.String.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02a3, code lost:
        r2 = r0.get("affiliation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02a9, code lost:
        if (r2 == null) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02ab, code lost:
        r4.setTransactionAffiliation(java.lang.String.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02b2, code lost:
        r2 = r0.get("coupon");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02b8, code lost:
        if (r2 == null) goto L_0x02c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02ba, code lost:
        r4.setTransactionCouponCode(java.lang.String.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02c1, code lost:
        r2 = r0.get("list");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02c7, code lost:
        if (r2 == null) goto L_0x02d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02c9, code lost:
        r4.setProductActionList(java.lang.String.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02d0, code lost:
        r2 = r0.get("option");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d6, code lost:
        if (r2 == null) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02d8, code lost:
        r4.setCheckoutOptions(java.lang.String.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02df, code lost:
        r2 = r0.get("revenue");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02e5, code lost:
        if (r2 == null) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02e7, code lost:
        r4.setTransactionRevenue(zzm(r2).doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02f2, code lost:
        r2 = r0.get("tax");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02f8, code lost:
        if (r2 == null) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02fa, code lost:
        r4.setTransactionTax(zzm(r2).doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0305, code lost:
        r2 = r0.get("shipping");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x030b, code lost:
        if (r2 == null) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x030d, code lost:
        r4.setTransactionShipping(zzm(r2).doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0318, code lost:
        r0 = r0.get("step");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x031e, code lost:
        if (r0 == null) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0320, code lost:
        r4.setCheckoutStep(zzn(r0).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x032c, code lost:
        r4 = new com.google.android.gms.analytics.ecommerce.ProductAction(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0331, code lost:
        r6.setProductAction(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0335, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        r0 = java.lang.String.valueOf(r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0344, code lost:
        if (r0.length() != 0) goto L_0x0346;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0346, code lost:
        r0 = "Failed to extract a product action from event data. ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x034b, code lost:
        r0 = new java.lang.String("Failed to extract a product action from event data. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0350, code lost:
        com.google.android.gms.internal.gtm.zzev.zzav(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x021f A[Catch:{ RuntimeException -> 0x013e, all -> 0x0496 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x035b A[Catch:{ RuntimeException -> 0x013e, all -> 0x0496 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5 A[Catch:{ RuntimeException -> 0x013e, all -> 0x0496 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4 A[Catch:{ RuntimeException -> 0x013e, all -> 0x0496 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d4 A[Catch:{ RuntimeException -> 0x013e, all -> 0x0496 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.gtm.zzoa<?> zza(com.google.android.gms.internal.gtm.zzfl r19, com.google.android.gms.internal.gtm.zzoa<?>... r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            java.lang.String r2 = "promoView"
            java.lang.String r3 = "&t"
            java.lang.String r4 = "&cu"
            java.lang.String r5 = "promoClick"
            r6 = 1
            com.google.android.gms.common.internal.Preconditions.checkArgument(r6)
            int r7 = r0.length
            r8 = 0
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            if (r7 <= 0) goto L_0x001a
            r7 = 1
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)
            com.google.android.gms.internal.gtm.zzfj r10 = r1.zzapc     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.gtm.zzee r10 = r10.zzkt()     // Catch:{ all -> 0x0496 }
            android.os.Bundle r10 = r10.zzkg()     // Catch:{ all -> 0x0496 }
            java.util.Map r10 = com.google.android.gms.internal.gtm.zzoo.zza(r10)     // Catch:{ all -> 0x0496 }
            r1.zzasf = r10     // Catch:{ all -> 0x0496 }
            r10 = r0[r8]     // Catch:{ all -> 0x0496 }
            int r11 = r0.length     // Catch:{ all -> 0x0496 }
            if (r11 <= r6) goto L_0x0036
            r11 = r0[r6]     // Catch:{ all -> 0x0496 }
            goto L_0x003f
        L_0x0036:
            com.google.android.gms.internal.gtm.zzod r11 = new com.google.android.gms.internal.gtm.zzod     // Catch:{ all -> 0x0496 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0496 }
            r11.<init>(r12)     // Catch:{ all -> 0x0496 }
        L_0x003f:
            int r12 = r0.length     // Catch:{ all -> 0x0496 }
            r13 = 2
            if (r12 <= r13) goto L_0x0046
            r12 = r0[r13]     // Catch:{ all -> 0x0496 }
            goto L_0x004b
        L_0x0046:
            com.google.android.gms.internal.gtm.zzod r12 = new com.google.android.gms.internal.gtm.zzod     // Catch:{ all -> 0x0496 }
            r12.<init>(r9)     // Catch:{ all -> 0x0496 }
        L_0x004b:
            int r13 = r0.length     // Catch:{ all -> 0x0496 }
            r14 = 3
            if (r13 <= r14) goto L_0x0052
            r13 = r0[r14]     // Catch:{ all -> 0x0496 }
            goto L_0x0054
        L_0x0052:
            com.google.android.gms.internal.gtm.zzog r13 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ all -> 0x0496 }
        L_0x0054:
            int r14 = r0.length     // Catch:{ all -> 0x0496 }
            r15 = 4
            if (r14 <= r15) goto L_0x005b
            r14 = r0[r15]     // Catch:{ all -> 0x0496 }
            goto L_0x005d
        L_0x005b:
            com.google.android.gms.internal.gtm.zzog r14 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ all -> 0x0496 }
        L_0x005d:
            int r15 = r0.length     // Catch:{ all -> 0x0496 }
            r6 = 5
            if (r15 <= r6) goto L_0x0064
            r6 = r0[r6]     // Catch:{ all -> 0x0496 }
            goto L_0x0069
        L_0x0064:
            com.google.android.gms.internal.gtm.zzod r6 = new com.google.android.gms.internal.gtm.zzod     // Catch:{ all -> 0x0496 }
            r6.<init>(r9)     // Catch:{ all -> 0x0496 }
        L_0x0069:
            int r15 = r0.length     // Catch:{ all -> 0x0496 }
            r8 = 6
            if (r15 <= r8) goto L_0x0070
            r8 = r0[r8]     // Catch:{ all -> 0x0496 }
            goto L_0x0075
        L_0x0070:
            com.google.android.gms.internal.gtm.zzod r8 = new com.google.android.gms.internal.gtm.zzod     // Catch:{ all -> 0x0496 }
            r8.<init>(r9)     // Catch:{ all -> 0x0496 }
        L_0x0075:
            int r15 = r0.length     // Catch:{ all -> 0x0496 }
            r7 = 7
            if (r15 <= r7) goto L_0x007c
            r7 = r0[r7]     // Catch:{ all -> 0x0496 }
            goto L_0x007e
        L_0x007c:
            com.google.android.gms.internal.gtm.zzog r7 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ all -> 0x0496 }
        L_0x007e:
            int r15 = r0.length     // Catch:{ all -> 0x0496 }
            r17 = r3
            r3 = 8
            if (r15 <= r3) goto L_0x0088
            r0 = r0[r3]     // Catch:{ all -> 0x0496 }
            goto L_0x008d
        L_0x0088:
            com.google.android.gms.internal.gtm.zzod r0 = new com.google.android.gms.internal.gtm.zzod     // Catch:{ all -> 0x0496 }
            r0.<init>(r9)     // Catch:{ all -> 0x0496 }
        L_0x008d:
            boolean r3 = r10 instanceof com.google.android.gms.internal.gtm.zzok     // Catch:{ all -> 0x0496 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r3)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.gtm.zzog r3 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ all -> 0x0496 }
            if (r13 == r3) goto L_0x009d
            boolean r3 = r13 instanceof com.google.android.gms.internal.gtm.zzok     // Catch:{ all -> 0x0496 }
            if (r3 == 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r3 = 0
            goto L_0x009e
        L_0x009d:
            r3 = 1
        L_0x009e:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r3)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.gtm.zzog r3 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ all -> 0x0496 }
            if (r14 == r3) goto L_0x00ac
            boolean r3 = r14 instanceof com.google.android.gms.internal.gtm.zzok     // Catch:{ all -> 0x0496 }
            if (r3 == 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r3 = 0
            goto L_0x00ad
        L_0x00ac:
            r3 = 1
        L_0x00ad:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r3)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.gtm.zzog r3 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ all -> 0x0496 }
            if (r7 == r3) goto L_0x00bb
            boolean r3 = r7 instanceof com.google.android.gms.internal.gtm.zzok     // Catch:{ all -> 0x0496 }
            if (r3 == 0) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            r3 = 0
            goto L_0x00bc
        L_0x00bb:
            r3 = 1
        L_0x00bc:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r3)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.gtm.zzgu r3 = r1.zzase     // Catch:{ all -> 0x0496 }
            java.lang.String r9 = "_GTM_DEFAULT_TRACKER_"
            com.google.android.gms.analytics.Tracker r3 = r3.zzbm(r9)     // Catch:{ all -> 0x0496 }
            boolean r0 = com.google.android.gms.internal.gtm.zzha.zza(r0)     // Catch:{ all -> 0x0496 }
            r3.enableAdvertisingIdCollection(r0)     // Catch:{ all -> 0x0496 }
            boolean r0 = com.google.android.gms.internal.gtm.zzha.zza(r6)     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x035b
            com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder r6 = new com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder     // Catch:{ all -> 0x0496 }
            r6.<init>()     // Catch:{ all -> 0x0496 }
            java.util.Map r0 = zzi(r10)     // Catch:{ all -> 0x0496 }
            r6.setAll(r0)     // Catch:{ all -> 0x0496 }
            boolean r8 = com.google.android.gms.internal.gtm.zzha.zza(r8)     // Catch:{ all -> 0x0496 }
            if (r8 == 0) goto L_0x00ef
            java.util.Map<java.lang.String, java.lang.Object> r7 = r1.zzasf     // Catch:{ all -> 0x0496 }
            java.lang.String r8 = "ecommerce"
            java.lang.Object r7 = r7.get(r8)     // Catch:{ all -> 0x0496 }
            goto L_0x00f7
        L_0x00ef:
            com.google.android.gms.internal.gtm.zzoa r7 = com.google.android.gms.internal.gtm.zzoo.zzk((com.google.android.gms.internal.gtm.zzoa<?>) r7)     // Catch:{ all -> 0x0496 }
            java.lang.Object r7 = com.google.android.gms.internal.gtm.zzoo.zzj(r7)     // Catch:{ all -> 0x0496 }
        L_0x00f7:
            boolean r8 = r7 instanceof java.util.Map     // Catch:{ all -> 0x0496 }
            if (r8 == 0) goto L_0x0353
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x0496 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0496 }
            if (r0 != 0) goto L_0x010d
            java.lang.String r0 = "currencyCode"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0496 }
        L_0x010d:
            if (r0 == 0) goto L_0x0112
            r6.set(r4, r0)     // Catch:{ all -> 0x0496 }
        L_0x0112:
            java.lang.String r0 = "impressions"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ all -> 0x0496 }
            boolean r4 = r0 instanceof java.util.List     // Catch:{ all -> 0x0496 }
            if (r4 == 0) goto L_0x015d
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0496 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0496 }
        L_0x0122:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x015d
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0496 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0496 }
            com.google.android.gms.analytics.ecommerce.Product r8 = zzj(r0)     // Catch:{ RuntimeException -> 0x013e }
            java.lang.String r9 = "list"
            java.lang.Object r0 = r0.get(r9)     // Catch:{ RuntimeException -> 0x013e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ RuntimeException -> 0x013e }
            r6.addImpression(r8, r0)     // Catch:{ RuntimeException -> 0x013e }
            goto L_0x0122
        L_0x013e:
            r0 = move-exception
            java.lang.String r8 = "Failed to extract a product from event data. "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0496 }
            int r9 = r0.length()     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x0154
            java.lang.String r0 = r8.concat(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0159
        L_0x0154:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0496 }
            r0.<init>(r8)     // Catch:{ all -> 0x0496 }
        L_0x0159:
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0122
        L_0x015d:
            boolean r0 = r7.containsKey(r5)     // Catch:{ all -> 0x0496 }
            java.lang.String r4 = "promotions"
            if (r0 == 0) goto L_0x0172
            java.lang.Object r0 = r7.get(r5)     // Catch:{ all -> 0x0496 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0496 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0496 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0496 }
            goto L_0x0186
        L_0x0172:
            boolean r0 = r7.containsKey(r2)     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x0185
            java.lang.Object r0 = r7.get(r2)     // Catch:{ all -> 0x0496 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0496 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0496 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0496 }
            goto L_0x0186
        L_0x0185:
            r0 = 0
        L_0x0186:
            if (r0 == 0) goto L_0x021b
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0496 }
        L_0x018c:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x0204
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0496 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0496 }
            com.google.android.gms.analytics.ecommerce.Promotion r4 = new com.google.android.gms.analytics.ecommerce.Promotion     // Catch:{ RuntimeException -> 0x01e5 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x01e5 }
            java.lang.String r8 = "id"
            java.lang.Object r8 = r0.get(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ RuntimeException -> 0x01e5 }
            if (r8 == 0) goto L_0x01ae
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            r4.setId(r8)     // Catch:{ RuntimeException -> 0x01e5 }
        L_0x01ae:
            java.lang.String r8 = "name"
            java.lang.Object r8 = r0.get(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ RuntimeException -> 0x01e5 }
            if (r8 == 0) goto L_0x01bf
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            r4.setName(r8)     // Catch:{ RuntimeException -> 0x01e5 }
        L_0x01bf:
            java.lang.String r8 = "creative"
            java.lang.Object r8 = r0.get(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ RuntimeException -> 0x01e5 }
            if (r8 == 0) goto L_0x01d0
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            r4.setCreative(r8)     // Catch:{ RuntimeException -> 0x01e5 }
        L_0x01d0:
            java.lang.String r8 = "position"
            java.lang.Object r0 = r0.get(r8)     // Catch:{ RuntimeException -> 0x01e5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ RuntimeException -> 0x01e5 }
            if (r0 == 0) goto L_0x01e1
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ RuntimeException -> 0x01e5 }
            r4.setPosition(r0)     // Catch:{ RuntimeException -> 0x01e5 }
        L_0x01e1:
            r6.addPromotion(r4)     // Catch:{ RuntimeException -> 0x01e5 }
            goto L_0x018c
        L_0x01e5:
            r0 = move-exception
            java.lang.String r4 = "Failed to extract a promotion from event data. "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0496 }
            int r8 = r0.length()     // Catch:{ all -> 0x0496 }
            if (r8 == 0) goto L_0x01fb
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0200
        L_0x01fb:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0496 }
            r0.<init>(r4)     // Catch:{ all -> 0x0496 }
        L_0x0200:
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x018c
        L_0x0204:
            boolean r0 = r7.containsKey(r5)     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x0214
            java.lang.String r0 = "&promoa"
            java.lang.String r2 = "click"
            r6.set(r0, r2)     // Catch:{ all -> 0x0496 }
            r16 = 0
            goto L_0x021d
        L_0x0214:
            java.lang.String r0 = "&promoa"
            java.lang.String r2 = "view"
            r6.set(r0, r2)     // Catch:{ all -> 0x0496 }
        L_0x021b:
            r16 = 1
        L_0x021d:
            if (r16 == 0) goto L_0x0353
            java.util.List<java.lang.String> r0 = zzamg     // Catch:{ all -> 0x0496 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0496 }
        L_0x0225:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0496 }
            if (r2 == 0) goto L_0x0353
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0496 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0496 }
            boolean r4 = r7.containsKey(r2)     // Catch:{ all -> 0x0496 }
            if (r4 == 0) goto L_0x0225
            java.lang.Object r0 = r7.get(r2)     // Catch:{ all -> 0x0496 }
            r4 = r0
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = "products"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ all -> 0x0496 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x027f
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0496 }
        L_0x024c:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x027f
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0496 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0496 }
            com.google.android.gms.analytics.ecommerce.Product r0 = zzj(r0)     // Catch:{ RuntimeException -> 0x0260 }
            r6.addProduct(r0)     // Catch:{ RuntimeException -> 0x0260 }
            goto L_0x024c
        L_0x0260:
            r0 = move-exception
            java.lang.String r7 = "Failed to extract a product from event data. "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0496 }
            int r8 = r0.length()     // Catch:{ all -> 0x0496 }
            if (r8 == 0) goto L_0x0276
            java.lang.String r0 = r7.concat(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x027b
        L_0x0276:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0496 }
            r0.<init>(r7)     // Catch:{ all -> 0x0496 }
        L_0x027b:
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x024c
        L_0x027f:
            java.lang.String r0 = "actionField"
            boolean r0 = r4.containsKey(r0)     // Catch:{ RuntimeException -> 0x0335 }
            if (r0 == 0) goto L_0x032c
            java.lang.String r0 = "actionField"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ RuntimeException -> 0x0335 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ RuntimeException -> 0x0335 }
            com.google.android.gms.analytics.ecommerce.ProductAction r4 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x0335 }
            r4.<init>(r2)     // Catch:{ RuntimeException -> 0x0335 }
            java.lang.String r2 = "id"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x02a3
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ RuntimeException -> 0x0335 }
            r4.setTransactionId(r2)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x02a3:
            java.lang.String r2 = "affiliation"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x02b2
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ RuntimeException -> 0x0335 }
            r4.setTransactionAffiliation(r2)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x02b2:
            java.lang.String r2 = "coupon"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x02c1
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ RuntimeException -> 0x0335 }
            r4.setTransactionCouponCode(r2)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x02c1:
            java.lang.String r2 = "list"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x02d0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ RuntimeException -> 0x0335 }
            r4.setProductActionList(r2)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x02d0:
            java.lang.String r2 = "option"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x02df
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ RuntimeException -> 0x0335 }
            r4.setCheckoutOptions(r2)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x02df:
            java.lang.String r2 = "revenue"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x02f2
            java.lang.Double r2 = zzm(r2)     // Catch:{ RuntimeException -> 0x0335 }
            double r7 = r2.doubleValue()     // Catch:{ RuntimeException -> 0x0335 }
            r4.setTransactionRevenue(r7)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x02f2:
            java.lang.String r2 = "tax"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x0305
            java.lang.Double r2 = zzm(r2)     // Catch:{ RuntimeException -> 0x0335 }
            double r7 = r2.doubleValue()     // Catch:{ RuntimeException -> 0x0335 }
            r4.setTransactionTax(r7)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x0305:
            java.lang.String r2 = "shipping"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r2 == 0) goto L_0x0318
            java.lang.Double r2 = zzm(r2)     // Catch:{ RuntimeException -> 0x0335 }
            double r7 = r2.doubleValue()     // Catch:{ RuntimeException -> 0x0335 }
            r4.setTransactionShipping(r7)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x0318:
            java.lang.String r2 = "step"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ RuntimeException -> 0x0335 }
            if (r0 == 0) goto L_0x0331
            java.lang.Integer r0 = zzn(r0)     // Catch:{ RuntimeException -> 0x0335 }
            int r0 = r0.intValue()     // Catch:{ RuntimeException -> 0x0335 }
            r4.setCheckoutStep(r0)     // Catch:{ RuntimeException -> 0x0335 }
            goto L_0x0331
        L_0x032c:
            com.google.android.gms.analytics.ecommerce.ProductAction r4 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x0335 }
            r4.<init>(r2)     // Catch:{ RuntimeException -> 0x0335 }
        L_0x0331:
            r6.setProductAction(r4)     // Catch:{ RuntimeException -> 0x0335 }
            goto L_0x0353
        L_0x0335:
            r0 = move-exception
            java.lang.String r2 = "Failed to extract a product action from event data. "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0496 }
            int r4 = r0.length()     // Catch:{ all -> 0x0496 }
            if (r4 == 0) goto L_0x034b
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0350
        L_0x034b:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0496 }
            r0.<init>(r2)     // Catch:{ all -> 0x0496 }
        L_0x0350:
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ all -> 0x0496 }
        L_0x0353:
            java.util.Map r0 = r6.build()     // Catch:{ all -> 0x0496 }
            r3.send(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0368
        L_0x035b:
            boolean r0 = com.google.android.gms.internal.gtm.zzha.zza(r11)     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x036b
            java.util.Map r0 = zzi(r10)     // Catch:{ all -> 0x0496 }
            r3.send(r0)     // Catch:{ all -> 0x0496 }
        L_0x0368:
            r2 = 0
            goto L_0x0491
        L_0x036b:
            boolean r0 = com.google.android.gms.internal.gtm.zzha.zza(r12)     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x048a
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.zzasf     // Catch:{ all -> 0x0496 }
            java.lang.String r2 = "transactionId"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0496 }
            if (r0 != 0) goto L_0x0383
            java.lang.String r0 = "Cannot find transactionId in data layer."
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0368
        L_0x0383:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0496 }
            r2.<init>()     // Catch:{ all -> 0x0496 }
            java.util.Map r4 = zzi(r10)     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r5 = "transaction"
            r6 = r17
            r4.put(r6, r5)     // Catch:{ IllegalArgumentException -> 0x0482 }
            com.google.android.gms.internal.gtm.zzog r5 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r13 != r5) goto L_0x039a
            java.util.Map<java.lang.String, java.lang.String> r5 = zzasc     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x039e
        L_0x039a:
            java.util.Map r5 = zzh(r13)     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x039e:
            java.util.Set r5 = r5.entrySet()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x03a6:
            boolean r7 = r5.hasNext()     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r7 == 0) goto L_0x03ca
            java.lang.Object r7 = r5.next()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r1.zzasf     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.Object r9 = r7.getKey()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r8 == 0) goto L_0x03a6
            java.lang.Object r7 = r7.getValue()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IllegalArgumentException -> 0x0482 }
            r4.put(r7, r8)     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x03a6
        L_0x03ca:
            r2.add(r4)     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r4 = "transactionProducts"
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.zzasf     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r4 != 0) goto L_0x03d9
            r7 = 0
            goto L_0x03fb
        L_0x03d9:
            boolean r5 = r4 instanceof java.util.List     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r5 == 0) goto L_0x047a
            r7 = r4
            java.util.List r7 = (java.util.List) r7     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Iterator r4 = r7.iterator()     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x03e4:
            boolean r5 = r4.hasNext()     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r5 == 0) goto L_0x03fb
            java.lang.Object r5 = r4.next()     // Catch:{ IllegalArgumentException -> 0x0482 }
            boolean r5 = r5 instanceof java.util.Map     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r5 == 0) goto L_0x03f3
            goto L_0x03e4
        L_0x03f3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r2 = "Each element of transactionProducts should be of type Map."
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0482 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x03fb:
            if (r7 == 0) goto L_0x0465
            java.util.Iterator r4 = r7.iterator()     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x0401:
            boolean r5 = r4.hasNext()     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r5 == 0) goto L_0x0465
            java.lang.Object r5 = r4.next()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r7 = "name"
            java.lang.Object r7 = r5.get(r7)     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r7 != 0) goto L_0x041c
            java.lang.String r0 = "Unable to send transaction item hit due to missing 'name' field."
            com.google.android.gms.internal.gtm.zzev.zzav(r0)     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x0368
        L_0x041c:
            java.util.Map r7 = zzi(r10)     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r8 = "item"
            r7.put(r6, r8)     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r8 = "&ti"
            r7.put(r8, r0)     // Catch:{ IllegalArgumentException -> 0x0482 }
            com.google.android.gms.internal.gtm.zzog r8 = com.google.android.gms.internal.gtm.zzog.zzaum     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r14 != r8) goto L_0x0431
            java.util.Map<java.lang.String, java.lang.String> r8 = zzasd     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x0435
        L_0x0431:
            java.util.Map r8 = zzh(r14)     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x0435:
            java.util.Set r8 = r8.entrySet()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x043d:
            boolean r9 = r8.hasNext()     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r9 == 0) goto L_0x0461
            java.lang.Object r9 = r8.next()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.Object r11 = r9.getKey()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.Object r11 = r5.get(r11)     // Catch:{ IllegalArgumentException -> 0x0482 }
            if (r11 == 0) goto L_0x043d
            java.lang.Object r9 = r9.getValue()     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r11 = r11.toString()     // Catch:{ IllegalArgumentException -> 0x0482 }
            r7.put(r9, r11)     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x043d
        L_0x0461:
            r2.add(r7)     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x0401
        L_0x0465:
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ IllegalArgumentException -> 0x0482 }
            int r0 = r2.size()     // Catch:{ IllegalArgumentException -> 0x0482 }
            r4 = 0
        L_0x046c:
            if (r4 >= r0) goto L_0x0368
            java.lang.Object r5 = r2.get(r4)     // Catch:{ IllegalArgumentException -> 0x0482 }
            int r4 = r4 + 1
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ IllegalArgumentException -> 0x0482 }
            r3.send(r5)     // Catch:{ IllegalArgumentException -> 0x0482 }
            goto L_0x046c
        L_0x047a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0482 }
            java.lang.String r2 = "transactionProducts should be of type List."
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0482 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0482 }
        L_0x0482:
            r0 = move-exception
            java.lang.String r2 = "Unable to send transaction"
            com.google.android.gms.internal.gtm.zzev.zza(r2, r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0368
        L_0x048a:
            java.lang.String r0 = "Ignoring unknown tag."
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x0368
        L_0x0491:
            r1.zzasf = r2
            com.google.android.gms.internal.gtm.zzog r0 = com.google.android.gms.internal.gtm.zzog.zzaum
            return r0
        L_0x0496:
            r0 = move-exception
            r2 = 0
            r1.zzasf = r2
            goto L_0x049c
        L_0x049b:
            throw r0
        L_0x049c:
            goto L_0x049b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzmj.zza(com.google.android.gms.internal.gtm.zzfl, com.google.android.gms.internal.gtm.zzoa[]):com.google.android.gms.internal.gtm.zzoa");
    }

    private static Product zzj(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get(ViewProps.POSITION);
        if (obj7 != null) {
            product.setPosition(zzn(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.setPrice(zzm(obj8).doubleValue());
        }
        Object obj9 = map.get("quantity");
        if (obj9 != null) {
            product.setQuantity(zzn(obj9).intValue());
        }
        for (String next : map.keySet()) {
            Matcher matcher = zzamh.matcher(next);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(next)));
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(next);
                    zzev.zzac(valueOf.length() != 0 ? "illegal number in custom dimension value: ".concat(valueOf) : new String("illegal number in custom dimension value: "));
                }
            } else {
                Matcher matcher2 = zzami.matcher(next);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzn(map.get(next)).intValue());
                    } catch (NumberFormatException unused2) {
                        String valueOf2 = String.valueOf(next);
                        zzev.zzac(valueOf2.length() != 0 ? "illegal number in custom metric value: ".concat(valueOf2) : new String("illegal number in custom metric value: "));
                    }
                }
            }
        }
        return product;
    }

    private static Map<String, String> zzh(zzoa<?> zzoa) {
        Preconditions.checkNotNull(zzoa);
        Preconditions.checkArgument(zzoa instanceof zzok);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object zzj = zzoo.zzj(zzoo.zzk(zzoa));
        Preconditions.checkState(zzj instanceof Map);
        for (Map.Entry entry : ((Map) zzj).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static Map<String, String> zzi(zzoa<?> zzoa) {
        Map<String, String> zzh = zzh(zzoa);
        String str = zzh.get("&aip");
        if (str != null && zzasb.contains(str.toLowerCase())) {
            zzh.remove("&aip");
        }
        return zzh;
    }

    private static Double zzm(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf) : new String("Cannot convert the object to Double: "));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf2) : new String("Cannot convert the object to Double: "));
        }
    }

    private static Integer zzn(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf) : new String("Cannot convert the object to Integer: "));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf2) : new String("Cannot convert the object to Integer: "));
        }
    }
}
