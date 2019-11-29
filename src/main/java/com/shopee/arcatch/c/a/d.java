package com.shopee.arcatch.c.a;

import android.text.TextUtils;
import com.shopee.arcatch.data.config_bean.AudioConfigBean;

public class d {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0353  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.shopee.arcatch.data.h5_bean.ArCatchH5BeginBean r9, com.shopee.arcatch.data.config_bean.ConfigBean r10) {
        /*
            com.shopee.arcatch.data.h5_bean.MetaBean r0 = r9.getMeta()
            r1 = 0
            if (r0 != 0) goto L_0x0012
            java.lang.String r9 = "arCatchH5StartBeanToConfigBean meta is null"
            com.shopee.e.a.a.a((java.lang.Object) r9)
            java.lang.String r9 = "meta is null"
            com.shopee.arcatch.c.b.c.b(r9)
            return r1
        L_0x0012:
            java.util.List r0 = r0.getSessionMetas()
            if (r0 == 0) goto L_0x03b8
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0020
            goto L_0x03b8
        L_0x0020:
            java.util.List r2 = r9.getProps()
            if (r2 == 0) goto L_0x03ad
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x002e
            goto L_0x03ad
        L_0x002e:
            com.shopee.arcatch.data.config_bean.ParamsConfigBean r3 = new com.shopee.arcatch.data.config_bean.ParamsConfigBean
            r3.<init>()
            java.lang.String r4 = r9.getEventId()
            r3.eventId = r4
            java.lang.String r4 = r9.getSessionId()
            r3.sessionId = r4
            java.lang.String r4 = r9.getInstanceId()
            r3.instanceId = r4
            int r4 = r9.getDuration()
            r3.duration = r4
            boolean r4 = r9.isMute()
            r3.mute = r4
            boolean r4 = r9.isSaveVideo()
            r3.saveVideo = r4
            r3.props = r2
            java.lang.String r4 = r9.getEndUrl()
            r3.endUrl = r4
            java.lang.String r4 = r9.getErrorUrl()
            r3.errorUrl = r4
            java.lang.String r4 = r9.getSource()
            r3.source = r4
            int r4 = r9.getPeakThrottleTime()
            if (r4 >= 0) goto L_0x0072
            r4 = 0
        L_0x0072:
            r3.peakThrottleTime = r4
            r10.paramsConfigBean = r3
            java.lang.String r4 = r3.eventId
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0089
            java.lang.String r9 = "arCatchH5StartBeanToConfigBean event_id is empty"
            com.shopee.e.a.a.a((java.lang.Object) r9)
            java.lang.String r9 = "event_id is empty"
            com.shopee.arcatch.c.b.c.b(r9)
            return r1
        L_0x0089:
            java.lang.String r4 = r3.sessionId
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x009c
            java.lang.String r9 = "arCatchH5StartBeanToConfigBean session_id is empty"
            com.shopee.e.a.a.a((java.lang.Object) r9)
            java.lang.String r9 = "session_id is empty"
            com.shopee.arcatch.c.b.c.b(r9)
            return r1
        L_0x009c:
            java.lang.String r4 = r3.instanceId
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x00af
            java.lang.String r9 = "arCatchH5StartBeanToConfigBean instance_id is empty"
            com.shopee.e.a.a.a((java.lang.Object) r9)
            java.lang.String r9 = "instance_id is empty"
            com.shopee.arcatch.c.b.c.b(r9)
            return r1
        L_0x00af:
            int r4 = r3.duration
            if (r4 > 0) goto L_0x00e3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "arCatchH5StartBeanToConfigBean duration is invalid "
            r4.append(r5)
            int r5 = r3.duration
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.shopee.e.a.a.a((java.lang.Object) r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "duration is invalid "
            r4.append(r5)
            int r5 = r3.duration
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.shopee.arcatch.c.b.c.b(r4)
            r4 = 60
            r3.duration = r4
        L_0x00e3:
            com.shopee.arcatch.data.config_bean.TextConfigBean r3 = new com.shopee.arcatch.data.config_bean.TextConfigBean
            r3.<init>()
            com.shopee.arcatch.data.config_bean.ImageConfigBean r4 = new com.shopee.arcatch.data.config_bean.ImageConfigBean
            r4.<init>()
            com.shopee.arcatch.data.config_bean.AudioConfigBean r5 = new com.shopee.arcatch.data.config_bean.AudioConfigBean
            r5.<init>()
            r10.textConfigBean = r3
            r10.imageConfigBean = r4
            r10.audioConfigBean = r5
            java.lang.String r9 = r9.getSessionName()
            r3.title = r9
            java.util.Iterator r9 = r0.iterator()
        L_0x0102:
            boolean r10 = r9.hasNext()
            r0 = 1
            if (r10 == 0) goto L_0x0341
            java.lang.Object r10 = r9.next()
            com.shopee.arcatch.data.h5_bean.SessionMetasBean r10 = (com.shopee.arcatch.data.h5_bean.SessionMetasBean) r10
            com.shopee.arcatch.data.h5_bean.MetaValue r6 = r10.getValue()
            if (r6 != 0) goto L_0x0117
            goto L_0x0341
        L_0x0117:
            java.lang.String r6 = r6.getValue()
            java.lang.String r10 = r10.getKey()
            r7 = -1
            int r8 = r10.hashCode()
            switch(r8) {
                case -2002360708: goto L_0x025c;
                case -1793451083: goto L_0x0252;
                case -1787980008: goto L_0x0247;
                case -1679916846: goto L_0x023c;
                case -1488918519: goto L_0x0231;
                case -1380417263: goto L_0x0226;
                case -1271487945: goto L_0x021c;
                case -901000257: goto L_0x0211;
                case -685479991: goto L_0x0207;
                case -469401712: goto L_0x01fc;
                case 195082643: goto L_0x01f0;
                case 202199535: goto L_0x01e4;
                case 299591257: goto L_0x01d8;
                case 417676237: goto L_0x01cc;
                case 417676361: goto L_0x01c0;
                case 433354964: goto L_0x01b4;
                case 529949821: goto L_0x01a8;
                case 553312292: goto L_0x019d;
                case 579947782: goto L_0x0192;
                case 815816178: goto L_0x0187;
                case 864127993: goto L_0x017c;
                case 1210691839: goto L_0x0170;
                case 1445763118: goto L_0x0164;
                case 1548832107: goto L_0x0158;
                case 1548986436: goto L_0x014c;
                case 1948208916: goto L_0x0140;
                case 2091710032: goto L_0x0135;
                case 2130201376: goto L_0x0129;
                default: goto L_0x0127;
            }
        L_0x0127:
            goto L_0x0267
        L_0x0129:
            java.lang.String r0 = "image_coins_core"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 18
            goto L_0x0268
        L_0x0135:
            java.lang.String r8 = "text_newbie_guide_start"
            boolean r10 = r10.equals(r8)
            if (r10 == 0) goto L_0x0267
            r10 = 1
            goto L_0x0268
        L_0x0140:
            java.lang.String r0 = "image_play_time"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 17
            goto L_0x0268
        L_0x014c:
            java.lang.String r0 = "image_bgm_mute_icon"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 20
            goto L_0x0268
        L_0x0158:
            java.lang.String r0 = "audio_bomb"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 26
            goto L_0x0268
        L_0x0164:
            java.lang.String r0 = "color_count_down"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 10
            goto L_0x0268
        L_0x0170:
            java.lang.String r0 = "color_coins_title"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 11
            goto L_0x0268
        L_0x017c:
            java.lang.String r0 = "text_newbie_guide_continue"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 0
            goto L_0x0268
        L_0x0187:
            java.lang.String r0 = "text_face_match_guide"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 2
            goto L_0x0268
        L_0x0192:
            java.lang.String r0 = "text_times_up"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 6
            goto L_0x0268
        L_0x019d:
            java.lang.String r0 = "text_count_down"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 4
            goto L_0x0268
        L_0x01a8:
            java.lang.String r0 = "audio_times_up"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 27
            goto L_0x0268
        L_0x01b4:
            java.lang.String r0 = "image_video_border"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 22
            goto L_0x0268
        L_0x01c0:
            java.lang.String r0 = "image_hat_fg"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 15
            goto L_0x0268
        L_0x01cc:
            java.lang.String r0 = "image_hat_bg"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 16
            goto L_0x0268
        L_0x01d8:
            java.lang.String r0 = "image_water_mark"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 21
            goto L_0x0268
        L_0x01e4:
            java.lang.String r0 = "image_cover_image"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 14
            goto L_0x0268
        L_0x01f0:
            java.lang.String r0 = "audio_game_page"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 23
            goto L_0x0268
        L_0x01fc:
            java.lang.String r0 = "color_times_up"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 12
            goto L_0x0268
        L_0x0207:
            java.lang.String r0 = "text_coins_title"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 5
            goto L_0x0268
        L_0x0211:
            java.lang.String r0 = "color_face_match"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 9
            goto L_0x0268
        L_0x021c:
            java.lang.String r0 = "color_newbie_guide"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 7
            goto L_0x0268
        L_0x0226:
            java.lang.String r0 = "audio_countdown_bgm"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 24
            goto L_0x0268
        L_0x0231:
            java.lang.String r0 = "image_bgm_play_icon"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 19
            goto L_0x0268
        L_0x023c:
            java.lang.String r0 = "audio_normal_prop"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 25
            goto L_0x0268
        L_0x0247:
            java.lang.String r0 = "image_guide"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 13
            goto L_0x0268
        L_0x0252:
            java.lang.String r0 = "text_face_match"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 3
            goto L_0x0268
        L_0x025c:
            java.lang.String r0 = "color_face_match_guide"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0267
            r10 = 8
            goto L_0x0268
        L_0x0267:
            r10 = -1
        L_0x0268:
            switch(r10) {
                case 0: goto L_0x0339;
                case 1: goto L_0x033b;
                case 2: goto L_0x033d;
                case 3: goto L_0x0335;
                case 4: goto L_0x0331;
                case 5: goto L_0x032d;
                case 6: goto L_0x0329;
                case 7: goto L_0x031d;
                case 8: goto L_0x0315;
                case 9: goto L_0x030d;
                case 10: goto L_0x0305;
                case 11: goto L_0x02fd;
                case 12: goto L_0x02f5;
                case 13: goto L_0x02dd;
                case 14: goto L_0x02d5;
                case 15: goto L_0x02cd;
                case 16: goto L_0x02c5;
                case 17: goto L_0x02bd;
                case 18: goto L_0x02b5;
                case 19: goto L_0x02ad;
                case 20: goto L_0x02a5;
                case 21: goto L_0x029d;
                case 22: goto L_0x0295;
                case 23: goto L_0x028d;
                case 24: goto L_0x0285;
                case 25: goto L_0x027d;
                case 26: goto L_0x0275;
                case 27: goto L_0x026d;
                default: goto L_0x026b;
            }
        L_0x026b:
            goto L_0x0102
        L_0x026d:
            java.lang.String r10 = a(r6)
            r5.timesUpVoice = r10
            goto L_0x0102
        L_0x0275:
            java.lang.String r10 = a(r6)
            r5.bombCaughtVoice = r10
            goto L_0x0102
        L_0x027d:
            java.lang.String r10 = a(r6)
            r5.normalPropCaughtVoice = r10
            goto L_0x0102
        L_0x0285:
            java.lang.String r10 = a(r6)
            r5.countDownVoice = r10
            goto L_0x0102
        L_0x028d:
            java.lang.String r10 = a(r6)
            r5.gamePageBGM = r10
            goto L_0x0102
        L_0x0295:
            java.lang.String r10 = b(r6)
            r4.imageVideoBorder = r10
            goto L_0x0102
        L_0x029d:
            java.lang.String r10 = b(r6)
            r4.imageWaterMark = r10
            goto L_0x0102
        L_0x02a5:
            java.lang.String r10 = b(r6)
            r4.bgmOffIcon = r10
            goto L_0x0102
        L_0x02ad:
            java.lang.String r10 = b(r6)
            r4.bgmOnIcon = r10
            goto L_0x0102
        L_0x02b5:
            java.lang.String r10 = b(r6)
            r4.coinsScoreBackground = r10
            goto L_0x0102
        L_0x02bd:
            java.lang.String r10 = b(r6)
            r4.playTimeCountDownBackground = r10
            goto L_0x0102
        L_0x02c5:
            java.lang.String r10 = b(r6)
            r4.hatBackground = r10
            goto L_0x0102
        L_0x02cd:
            java.lang.String r10 = b(r6)
            r4.hatForeground = r10
            goto L_0x0102
        L_0x02d5:
            java.lang.String r10 = b(r6)
            r4.imageCover = r10
            goto L_0x0102
        L_0x02dd:
            java.lang.String r10 = ","
            java.lang.String[] r10 = r6.split(r10)
            int r0 = r10.length
            r6 = 0
        L_0x02e5:
            if (r6 >= r0) goto L_0x0102
            r7 = r10[r6]
            java.lang.String r7 = b(r7)
            java.util.List<java.lang.String> r8 = r4.guideImageForNewUsers
            r8.add(r7)
            int r6 = r6 + 1
            goto L_0x02e5
        L_0x02f5:
            int r10 = com.shopee.arcatch.b.c.b.a((java.lang.String) r6)
            r3.timesUpColor = r10
            goto L_0x0102
        L_0x02fd:
            int r10 = com.shopee.arcatch.b.c.b.a((java.lang.String) r6)
            r3.coinsTitleColor = r10
            goto L_0x0102
        L_0x0305:
            int r10 = com.shopee.arcatch.b.c.b.a((java.lang.String) r6)
            r3.countdownTextColor = r10
            goto L_0x0102
        L_0x030d:
            int r10 = com.shopee.arcatch.b.c.b.a((java.lang.String) r6)
            r3.faceMatchTextColor = r10
            goto L_0x0102
        L_0x0315:
            int r10 = com.shopee.arcatch.b.c.b.a((java.lang.String) r6)
            r3.guideDescriptionColor = r10
            goto L_0x0102
        L_0x031d:
            int r10 = com.shopee.arcatch.b.c.b.a((java.lang.String) r6)
            r3.tabToContinueColor = r10
            int r10 = r3.tabToContinueColor
            r3.tabToStartColor = r10
            goto L_0x0102
        L_0x0329:
            r3.timesUp = r6
            goto L_0x0102
        L_0x032d:
            r3.coinsTitle = r6
            goto L_0x0102
        L_0x0331:
            r3.countdownText = r6
            goto L_0x0102
        L_0x0335:
            r3.faceMatchText = r6
            goto L_0x0102
        L_0x0339:
            r3.tabToContinue = r6
        L_0x033b:
            r3.tabToStart = r6
        L_0x033d:
            r3.guideDescription = r6
            goto L_0x0102
        L_0x0341:
            java.util.Map<java.lang.String, java.lang.String> r9 = r4.coinImages
            java.util.Map<java.lang.String, java.lang.String> r10 = r4.bombImages
            java.util.Map<java.lang.String, java.lang.String> r1 = r4.explosionImages
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.cryEyesImages
            java.util.Iterator r2 = r2.iterator()
        L_0x034d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x03ac
            java.lang.Object r4 = r2.next()
            com.shopee.arcatch.data.network_bean.game.PropsBean r4 = (com.shopee.arcatch.data.network_bean.game.PropsBean) r4
            java.lang.String r5 = r4.getId()
            java.lang.String r6 = r4.getPropIcon()
            int r7 = r4.getPropType()
            if (r7 == 0) goto L_0x0372
            if (r7 == r0) goto L_0x036a
            goto L_0x034d
        L_0x036a:
            java.lang.String r4 = b(r6)
            r9.put(r5, r4)
            goto L_0x034d
        L_0x0372:
            java.lang.String r6 = b(r6)
            r10.put(r5, r6)
            java.lang.String r6 = r4.getBombEyeLeft()
            java.lang.String r6 = b(r6)
            r3.put(r5, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r7 = "*"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r4.getBombEyeRight()
            java.lang.String r7 = b(r7)
            r3.put(r6, r7)
            java.lang.String r4 = r4.getBombIcon()
            java.lang.String r4 = b(r4)
            r1.put(r5, r4)
            goto L_0x034d
        L_0x03ac:
            return r0
        L_0x03ad:
            java.lang.String r9 = "arCatchH5StartBeanToConfigBean props is empty"
            com.shopee.e.a.a.a((java.lang.Object) r9)
            java.lang.String r9 = "props is empty"
            com.shopee.arcatch.c.b.c.b(r9)
            return r1
        L_0x03b8:
            java.lang.String r9 = "arCatchH5StartBeanToConfigBean session_metas is empty"
            com.shopee.e.a.a.a((java.lang.Object) r9)
            java.lang.String r9 = "session_metas is empty"
            com.shopee.arcatch.c.b.c.b(r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.a.d.a(com.shopee.arcatch.data.h5_bean.ArCatchH5BeginBean, com.shopee.arcatch.data.config_bean.ConfigBean):boolean");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        return AudioConfigBean.URL + str;
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        return a() + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ba A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c6 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a() {
        /*
            com.shopee.sdk.modules.a r0 = com.shopee.sdk.b.a()
            com.shopee.sdk.modules.app.a.b r0 = r0.a()
            com.shopee.sdk.modules.app.a.a r0 = r0.a()
            java.lang.String r0 = r0.d()
            int r1 = r0.hashCode()
            r2 = 2307(0x903, float:3.233E-42)
            if (r1 == r2) goto L_0x0099
            r2 = 2331(0x91b, float:3.266E-42)
            if (r1 == r2) goto L_0x008f
            r2 = 2345(0x929, float:3.286E-42)
            if (r1 == r2) goto L_0x0084
            r2 = 2464(0x9a0, float:3.453E-42)
            if (r1 == r2) goto L_0x007a
            r2 = 2476(0x9ac, float:3.47E-42)
            if (r1 == r2) goto L_0x0070
            r2 = 2552(0x9f8, float:3.576E-42)
            if (r1 == r2) goto L_0x0066
            r2 = 2644(0xa54, float:3.705E-42)
            if (r1 == r2) goto L_0x005c
            r2 = 2676(0xa74, float:3.75E-42)
            if (r1 == r2) goto L_0x0052
            r2 = 2691(0xa83, float:3.771E-42)
            if (r1 == r2) goto L_0x0048
            r2 = 2744(0xab8, float:3.845E-42)
            if (r1 == r2) goto L_0x003e
            goto L_0x00a4
        L_0x003e:
            java.lang.String r1 = "VN"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 5
            goto L_0x00a5
        L_0x0048:
            java.lang.String r1 = "TW"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 3
            goto L_0x00a5
        L_0x0052:
            java.lang.String r1 = "TH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 4
            goto L_0x00a5
        L_0x005c:
            java.lang.String r1 = "SG"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 0
            goto L_0x00a5
        L_0x0066:
            java.lang.String r1 = "PH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 6
            goto L_0x00a5
        L_0x0070:
            java.lang.String r1 = "MY"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 2
            goto L_0x00a5
        L_0x007a:
            java.lang.String r1 = "MM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 7
            goto L_0x00a5
        L_0x0084:
            java.lang.String r1 = "IR"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 8
            goto L_0x00a5
        L_0x008f:
            java.lang.String r1 = "ID"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 1
            goto L_0x00a5
        L_0x0099:
            java.lang.String r1 = "HK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a4
            r0 = 9
            goto L_0x00a5
        L_0x00a4:
            r0 = -1
        L_0x00a5:
            java.lang.String r1 = "https://cf.shopee.sg/file/"
            switch(r0) {
                case 0: goto L_0x00c6;
                case 1: goto L_0x00c3;
                case 2: goto L_0x00c0;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00b7;
                case 6: goto L_0x00b4;
                case 7: goto L_0x00b1;
                case 8: goto L_0x00ae;
                case 9: goto L_0x00ab;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            return r1
        L_0x00ab:
            java.lang.String r0 = "https://cf.shopee.com.mm/file/"
            return r0
        L_0x00ae:
            java.lang.String r0 = "https://cf.shopee.co.ir/file/"
            return r0
        L_0x00b1:
            java.lang.String r0 = "om.mm"
            return r0
        L_0x00b4:
            java.lang.String r0 = "https://cf.shopee.ph/file/"
            return r0
        L_0x00b7:
            java.lang.String r0 = "https://cf.shopee.vn/file/"
            return r0
        L_0x00ba:
            java.lang.String r0 = "https://cf.shopee.co.th/file/"
            return r0
        L_0x00bd:
            java.lang.String r0 = "https://cf.shopee.tw/file/"
            return r0
        L_0x00c0:
            java.lang.String r0 = "https://cf.shopee.com.my/file/"
            return r0
        L_0x00c3:
            java.lang.String r0 = "https://cf.shopee.co.id/file/"
            return r0
        L_0x00c6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.a.d.a():java.lang.String");
    }
}
