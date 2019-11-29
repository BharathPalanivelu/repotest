package com.shopee.arcatch.c.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.shopee.arcatch.c.f.d;
import com.shopee.arcatch.data.config_bean.AudioConfigBean;
import com.shopee.arcatch.data.config_bean.AudioPathBean;
import com.shopee.arcatch.data.config_bean.BitmapConfigBean;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.data.config_bean.ImageConfigBean;
import com.shopee.arcatch.data.data_tracking.TrackingProp;
import com.shopee.arcatch.data.network_bean.CommonBean;
import com.shopee.arcatch.data.network_bean.CommonCallback;
import com.shopee.arcatch.data.network_bean.game.EndBody;
import com.shopee.arcatch.data.network_bean.game.EndGameData;
import com.shopee.e.a.a;
import io.b.d.h;
import io.b.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f26710a;

    /* renamed from: b  reason: collision with root package name */
    private a f26711b = a.a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ConfigBean f26712c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AudioPathBean f26713d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BitmapConfigBean f26714e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f26715f = new Handler(Looper.getMainLooper());

    private b() {
    }

    public static b a() {
        if (f26710a == null) {
            synchronized (b.class) {
                if (f26710a == null) {
                    f26710a = new b();
                }
            }
        }
        return f26710a;
    }

    public void a(ConfigBean configBean) {
        this.f26712c = configBean;
        com.shopee.arcatch.c.b.b.a().a(configBean.paramsConfigBean.eventId, configBean.paramsConfigBean.sessionId, configBean.paramsConfigBean.source);
    }

    public j<c> a(boolean z) {
        j<Boolean> jVar;
        j<Map<String, Bitmap>> jVar2;
        List<Pair> list;
        a.a((Object) "---------start loading config (needNewbieShow " + z + ")---------");
        c cVar = new c();
        ConfigBean configBean = this.f26712c;
        if (configBean == null) {
            return j.b(cVar);
        }
        ImageConfigBean imageConfigBean = configBean.imageConfigBean;
        if (!z || imageConfigBean == null) {
            jVar = j.b(true);
        } else {
            jVar = this.f26711b.a((List<String>) new ArrayList(imageConfigBean.guideImageForNewUsers));
        }
        this.f26714e = new BitmapConfigBean();
        if (imageConfigBean != null) {
            list = a(imageConfigBean);
            jVar2 = this.f26711b.b((List<Pair<String, String>>) list);
        } else {
            list = new ArrayList<>();
            jVar2 = j.b(new HashMap());
        }
        AudioConfigBean audioConfigBean = this.f26712c.audioConfigBean;
        this.f26713d = new AudioPathBean();
        List<Pair<String, String>> a2 = a(audioConfigBean);
        final HashMap hashMap = new HashMap();
        for (Pair pair : list) {
            hashMap.put(pair.first, pair.second);
        }
        for (Pair next : a2) {
            hashMap.put(next.first, next.second);
        }
        return j.a(jVar, jVar2, this.f26711b.c(a2), new h<Boolean, Map<String, Bitmap>, Map<String, String>, c>() {
            public c a(Boolean bool, Map<String, Bitmap> map, Map<String, String> map2) {
                return b.this.a(bool, map, map2, hashMap);
            }
        });
    }

    private List<Pair<String, String>> a(ImageConfigBean imageConfigBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("imageCover", imageConfigBean.imageCover));
        arrayList.add(new Pair("hatForeground", imageConfigBean.hatForeground));
        arrayList.add(new Pair("hatBackground", imageConfigBean.hatBackground));
        arrayList.add(new Pair("playTimeCountDownBackground", imageConfigBean.playTimeCountDownBackground));
        arrayList.add(new Pair("coinsScoreBackground", imageConfigBean.coinsScoreBackground));
        arrayList.add(new Pair("bgmOnIcon", imageConfigBean.bgmOnIcon));
        arrayList.add(new Pair("bgmOffIcon", imageConfigBean.bgmOffIcon));
        arrayList.add(new Pair("waterMark", imageConfigBean.imageWaterMark));
        arrayList.add(new Pair("videoBorder", imageConfigBean.imageVideoBorder));
        for (String next : imageConfigBean.coinImages.keySet()) {
            arrayList.add(new Pair("coinImages_" + next, imageConfigBean.coinImages.get(next)));
        }
        for (String next2 : imageConfigBean.bombImages.keySet()) {
            arrayList.add(new Pair("bombImages_" + next2, imageConfigBean.bombImages.get(next2)));
        }
        for (String next3 : imageConfigBean.cryEyesImages.keySet()) {
            arrayList.add(new Pair("cryEyesImages_" + next3, imageConfigBean.cryEyesImages.get(next3)));
        }
        for (String next4 : imageConfigBean.explosionImages.keySet()) {
            arrayList.add(new Pair("explosionImages_" + next4, imageConfigBean.explosionImages.get(next4)));
        }
        return arrayList;
    }

    private List<Pair<String, String>> a(AudioConfigBean audioConfigBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("gamePageBGM", audioConfigBean.gamePageBGM));
        arrayList.add(new Pair("countDownVoice", audioConfigBean.countDownVoice));
        arrayList.add(new Pair("normalPropCaughtVoice", audioConfigBean.normalPropCaughtVoice));
        arrayList.add(new Pair("bombCaughtVoice", audioConfigBean.bombCaughtVoice));
        arrayList.add(new Pair("timesUpVoice", audioConfigBean.timesUpVoice));
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.shopee.arcatch.c.a.c a(java.lang.Boolean r18, java.util.Map<java.lang.String, android.graphics.Bitmap> r19, java.util.Map<java.lang.String, java.lang.String> r20, java.util.Map<java.lang.String, java.lang.String> r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r21
            com.shopee.arcatch.c.a.c r2 = new com.shopee.arcatch.c.a.c
            r2.<init>()
            boolean r3 = r18.booleanValue()
            r2.f26726a = r3
            r3 = 1
            r2.f26728c = r3
            r2.f26727b = r3
            r2.f26729d = r3
            java.util.Set r4 = r19.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x001e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01a9
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            r11 = r19
            java.lang.Object r12 = r11.get(r5)
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12
            java.lang.Object r13 = r1.get(r5)
            java.lang.String r13 = (java.lang.String) r13
            if (r12 != 0) goto L_0x004e
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "url download bitmap fail "
            r14.append(r15)
            r14.append(r13)
            java.lang.String r14 = r14.toString()
            com.shopee.e.a.a.a((java.lang.Object) r14)
        L_0x004e:
            int r14 = r5.hashCode()
            r16 = 5
            java.lang.String r7 = "bgmOffIcon"
            java.lang.String r15 = "videoBorder"
            java.lang.String r6 = "playTimeCountDownBackground"
            java.lang.String r8 = "waterMark"
            java.lang.String r3 = "imageCover"
            java.lang.String r9 = "bgmOnIcon"
            java.lang.String r10 = "coinsScoreBackground"
            switch(r14) {
                case -1773620994: goto L_0x0096;
                case -1596823072: goto L_0x008e;
                case -1468769508: goto L_0x0086;
                case -214377340: goto L_0x007e;
                case 47897726: goto L_0x0076;
                case 551611527: goto L_0x006e;
                case 1835055264: goto L_0x0066;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x009e
        L_0x0066:
            boolean r14 = r5.equals(r7)
            if (r14 == 0) goto L_0x009e
            r14 = 4
            goto L_0x009f
        L_0x006e:
            boolean r14 = r5.equals(r15)
            if (r14 == 0) goto L_0x009e
            r14 = 6
            goto L_0x009f
        L_0x0076:
            boolean r14 = r5.equals(r6)
            if (r14 == 0) goto L_0x009e
            r14 = 1
            goto L_0x009f
        L_0x007e:
            boolean r14 = r5.equals(r8)
            if (r14 == 0) goto L_0x009e
            r14 = 5
            goto L_0x009f
        L_0x0086:
            boolean r14 = r5.equals(r3)
            if (r14 == 0) goto L_0x009e
            r14 = 0
            goto L_0x009f
        L_0x008e:
            boolean r14 = r5.equals(r9)
            if (r14 == 0) goto L_0x009e
            r14 = 3
            goto L_0x009f
        L_0x0096:
            boolean r14 = r5.equals(r10)
            if (r14 == 0) goto L_0x009e
            r14 = 2
            goto L_0x009f
        L_0x009e:
            r14 = -1
        L_0x009f:
            switch(r14) {
                case 0: goto L_0x00ab;
                case 1: goto L_0x00ab;
                case 2: goto L_0x00ab;
                case 3: goto L_0x00ab;
                case 4: goto L_0x00ab;
                case 5: goto L_0x00ab;
                case 6: goto L_0x00ab;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            r14 = 0
            if (r12 != 0) goto L_0x00b0
            r2.f26728c = r14
            com.shopee.arcatch.c.b.c.a((java.lang.String) r13)
            goto L_0x00b0
        L_0x00ab:
            if (r12 != 0) goto L_0x00b0
            r14 = 0
            r2.f26727b = r14
        L_0x00b0:
            int r13 = r5.hashCode()
            switch(r13) {
                case -1773620994: goto L_0x00fd;
                case -1596823072: goto L_0x00f5;
                case -1468769508: goto L_0x00ed;
                case -214377340: goto L_0x00e5;
                case 47897726: goto L_0x00dd;
                case 551611527: goto L_0x00d5;
                case 876974654: goto L_0x00cb;
                case 1835055264: goto L_0x00c3;
                case 1855290921: goto L_0x00b8;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            goto L_0x0105
        L_0x00b8:
            java.lang.String r3 = "hatBackground"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 8
            goto L_0x0106
        L_0x00c3:
            boolean r3 = r5.equals(r7)
            if (r3 == 0) goto L_0x0105
            r3 = 4
            goto L_0x0106
        L_0x00cb:
            java.lang.String r3 = "hatForeground"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 7
            goto L_0x0106
        L_0x00d5:
            boolean r3 = r5.equals(r15)
            if (r3 == 0) goto L_0x0105
            r3 = 6
            goto L_0x0106
        L_0x00dd:
            boolean r3 = r5.equals(r6)
            if (r3 == 0) goto L_0x0105
            r3 = 1
            goto L_0x0106
        L_0x00e5:
            boolean r3 = r5.equals(r8)
            if (r3 == 0) goto L_0x0105
            r3 = 5
            goto L_0x0106
        L_0x00ed:
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 0
            goto L_0x0106
        L_0x00f5:
            boolean r3 = r5.equals(r9)
            if (r3 == 0) goto L_0x0105
            r3 = 3
            goto L_0x0106
        L_0x00fd:
            boolean r3 = r5.equals(r10)
            if (r3 == 0) goto L_0x0105
            r3 = 2
            goto L_0x0106
        L_0x0105:
            r3 = -1
        L_0x0106:
            switch(r3) {
                case 0: goto L_0x013e;
                case 1: goto L_0x0139;
                case 2: goto L_0x0134;
                case 3: goto L_0x012f;
                case 4: goto L_0x012a;
                case 5: goto L_0x0125;
                case 6: goto L_0x0120;
                case 7: goto L_0x011b;
                case 8: goto L_0x0116;
                default: goto L_0x0109;
            }
        L_0x0109:
            java.lang.String r3 = "_"
            java.lang.String[] r3 = r5.split(r3)
            int r5 = r3.length
            r6 = 2
            if (r5 == r6) goto L_0x0143
        L_0x0113:
            r3 = 1
            goto L_0x001e
        L_0x0116:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.hatBackground = r12
            goto L_0x0113
        L_0x011b:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.hatForeground = r12
            goto L_0x0113
        L_0x0120:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.videoBorder = r12
            goto L_0x0113
        L_0x0125:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.waterMark = r12
            goto L_0x0113
        L_0x012a:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.bgmOffIcon = r12
            goto L_0x0113
        L_0x012f:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.bgmOnIcon = r12
            goto L_0x0113
        L_0x0134:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.coinsScoreBackground = r12
            goto L_0x0113
        L_0x0139:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.playTimeCountDownBackground = r12
            goto L_0x0113
        L_0x013e:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r3 = r0.f26714e
            r3.imageCover = r12
            goto L_0x0113
        L_0x0143:
            r5 = 0
            r6 = r3[r5]
            r5 = 1
            r3 = r3[r5]
            int r5 = r6.hashCode()
            switch(r5) {
                case -1692717975: goto L_0x016f;
                case -880040006: goto L_0x0165;
                case 939940612: goto L_0x015b;
                case 1347698157: goto L_0x0151;
                default: goto L_0x0150;
            }
        L_0x0150:
            goto L_0x0179
        L_0x0151:
            java.lang.String r5 = "explosionImages"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0179
            r5 = 3
            goto L_0x017a
        L_0x015b:
            java.lang.String r5 = "cryEyesImages"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0179
            r5 = 2
            goto L_0x017a
        L_0x0165:
            java.lang.String r5 = "bombImages"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0179
            r5 = 1
            goto L_0x017a
        L_0x016f:
            java.lang.String r5 = "coinImages"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0179
            r5 = 0
            goto L_0x017a
        L_0x0179:
            r5 = -1
        L_0x017a:
            if (r5 == 0) goto L_0x01a0
            r6 = 1
            if (r5 == r6) goto L_0x0197
            r6 = 2
            if (r5 == r6) goto L_0x018e
            r6 = 3
            if (r5 == r6) goto L_0x0186
            goto L_0x0113
        L_0x0186:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r5 = r0.f26714e
            java.util.Map<java.lang.String, android.graphics.Bitmap> r5 = r5.explosionImages
            r5.put(r3, r12)
            goto L_0x0113
        L_0x018e:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r5 = r0.f26714e
            java.util.Map<java.lang.String, android.graphics.Bitmap> r5 = r5.cryEyesImages
            r5.put(r3, r12)
            goto L_0x0113
        L_0x0197:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r5 = r0.f26714e
            java.util.Map<java.lang.String, android.graphics.Bitmap> r5 = r5.bombImages
            r5.put(r3, r12)
            goto L_0x0113
        L_0x01a0:
            com.shopee.arcatch.data.config_bean.BitmapConfigBean r5 = r0.f26714e
            java.util.Map<java.lang.String, android.graphics.Bitmap> r5 = r5.coinImages
            r5.put(r3, r12)
            goto L_0x0113
        L_0x01a9:
            java.util.Set r3 = r20.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x01b1:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x025d
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = r20
            java.lang.Object r6 = r5.get(r4)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r1.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x01e9
            r14 = 0
            r2.f26729d = r14
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "url download audio fail "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.shopee.e.a.a.a((java.lang.Object) r7)
            goto L_0x01ea
        L_0x01e9:
            r14 = 0
        L_0x01ea:
            int r7 = r4.hashCode()
            switch(r7) {
                case -1415660852: goto L_0x021a;
                case -1211371167: goto L_0x0210;
                case -937117849: goto L_0x0206;
                case 255377713: goto L_0x01fc;
                case 871155220: goto L_0x01f2;
                default: goto L_0x01f1;
            }
        L_0x01f1:
            goto L_0x0224
        L_0x01f2:
            java.lang.String r7 = "bombCaughtVoice"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0224
            r4 = 3
            goto L_0x0225
        L_0x01fc:
            java.lang.String r7 = "timesUpVoice"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0224
            r4 = 4
            goto L_0x0225
        L_0x0206:
            java.lang.String r7 = "gamePageBGM"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0224
            r4 = 0
            goto L_0x0225
        L_0x0210:
            java.lang.String r7 = "countDownVoice"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0224
            r4 = 1
            goto L_0x0225
        L_0x021a:
            java.lang.String r7 = "normalPropCaughtVoice"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0224
            r4 = 2
            goto L_0x0225
        L_0x0224:
            r4 = -1
        L_0x0225:
            if (r4 == 0) goto L_0x0253
            r7 = 1
            if (r4 == r7) goto L_0x024a
            r8 = 2
            if (r4 == r8) goto L_0x0242
            r9 = 3
            if (r4 == r9) goto L_0x023b
            r10 = 4
            if (r4 == r10) goto L_0x0235
            goto L_0x01b1
        L_0x0235:
            com.shopee.arcatch.data.config_bean.AudioPathBean r4 = r0.f26713d
            r4.timesUpVoice = r6
            goto L_0x01b1
        L_0x023b:
            r10 = 4
            com.shopee.arcatch.data.config_bean.AudioPathBean r4 = r0.f26713d
            r4.bombCaughtVoice = r6
            goto L_0x01b1
        L_0x0242:
            r9 = 3
            r10 = 4
            com.shopee.arcatch.data.config_bean.AudioPathBean r4 = r0.f26713d
            r4.normalPropCaughtVoice = r6
            goto L_0x01b1
        L_0x024a:
            r8 = 2
            r9 = 3
            r10 = 4
            com.shopee.arcatch.data.config_bean.AudioPathBean r4 = r0.f26713d
            r4.countDownVoice = r6
            goto L_0x01b1
        L_0x0253:
            r7 = 1
            r8 = 2
            r9 = 3
            r10 = 4
            com.shopee.arcatch.data.config_bean.AudioPathBean r4 = r0.f26713d
            r4.gamePageBGM = r6
            goto L_0x01b1
        L_0x025d:
            java.lang.String r1 = "---------end loading config---------"
            com.shopee.e.a.a.a((java.lang.Object) r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.a.b.a(java.lang.Boolean, java.util.Map, java.util.Map, java.util.Map):com.shopee.arcatch.c.a.c");
    }

    public void a(Activity activity, String str, String str2, long j, List<TrackingProp> list, float f2, CommonCallback<EndGameData> commonCallback) {
        a.a((Object) "---------start finish game---------");
        Activity activity2 = activity;
        final WeakReference weakReference = new WeakReference(activity);
        final String str3 = this.f26712c.paramsConfigBean.eventId;
        final String str4 = this.f26712c.paramsConfigBean.sessionId;
        final EndBody endBody = new EndBody();
        endBody.setInstanceId(this.f26712c.paramsConfigBean.instanceId);
        endBody.setCatchToken(str2);
        endBody.setFinishTime(j);
        final CommonCallback<EndGameData> commonCallback2 = commonCallback;
        final List<TrackingProp> list2 = list;
        final float f3 = f2;
        final String str5 = str;
        this.f26715f.postDelayed(new Runnable() {
            public void run() {
                com.shopee.arcatch.a.a.a().a(str3, str4, endBody, new CommonCallback<EndGameData>() {
                    public void onSuccess(CommonBean<EndGameData> commonBean) {
                        if (!a()) {
                            a.b("finish game not one session! old eventId is " + str3 + " sessionId : " + str4 + " new eventId is " + str3 + " sessionId : " + str4, new Object[0]);
                        } else if (commonBean == null || commonBean.getData() == null) {
                            onFail(-1, "data is null");
                        } else {
                            EndGameData data = commonBean.getData();
                            commonCallback2.onSuccess(commonBean);
                            com.shopee.arcatch.c.b.a.a((List<TrackingProp>) list2, f3);
                            Activity activity = (Activity) weakReference.get();
                            if (activity != null) {
                                d.a(activity, str5, data);
                            }
                            a(true, 0, "");
                        }
                    }

                    public void onFail(int i, String str) {
                        if (!a()) {
                            a.b("finish game not one session! old eventId is " + str3 + " sessionId : " + str4 + " new eventId is " + str3 + " sessionId : " + str4, new Object[0]);
                            return;
                        }
                        commonCallback2.onFail(i, str);
                        com.shopee.arcatch.c.b.a.a(list2, f3, i, str, 0);
                        Activity activity = (Activity) weakReference.get();
                        if (activity != null) {
                            d.a(activity, str5, (EndGameData) null);
                        }
                        a(false, i, str);
                    }

                    private boolean a() {
                        String str = null;
                        String str2 = (b.this.f26712c == null || b.this.f26712c.paramsConfigBean == null) ? null : b.this.f26712c.paramsConfigBean.eventId;
                        if (!(b.this.f26712c == null || b.this.f26712c.paramsConfigBean == null)) {
                            str = b.this.f26712c.paramsConfigBean.sessionId;
                        }
                        return str3.equals(str2) && str4.equals(str);
                    }

                    private void a(boolean z, int i, String str) {
                        ConfigBean unused = b.this.f26712c = null;
                        AudioPathBean unused2 = b.this.f26713d = null;
                        BitmapConfigBean unused3 = b.this.f26714e = null;
                        com.shopee.arcatch.c.b.b.a().b();
                        a.a((Object) "---------end finish game(success " + z + ")---------");
                    }
                });
            }
        }, (long) this.f26712c.paramsConfigBean.peakThrottleTime);
    }

    public ConfigBean b() {
        return this.f26712c;
    }

    public AudioPathBean c() {
        return this.f26713d;
    }

    public BitmapConfigBean d() {
        return this.f26714e;
    }

    public void b(boolean z) {
        ConfigBean configBean = this.f26712c;
        if (configBean != null && configBean.paramsConfigBean != null) {
            this.f26712c.paramsConfigBean.mute = z;
        }
    }

    public void c(boolean z) {
        ConfigBean configBean = this.f26712c;
        if (configBean != null && configBean.paramsConfigBean != null) {
            this.f26712c.paramsConfigBean.saveVideo = z;
        }
    }
}
