package com.shopee.app.upload;

import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.be;
import com.shopee.app.h.f;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.f.a;
import com.shopee.app.util.i;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UploadRunnable implements Runnable {
    private static final int MAX_RETRY = 5;
    public static final int NO_IMAGES = -909;
    public static final double PROGRESS_INTERMEDIATE = 1.2d;
    private static final long RETRY_SLEEP_TIME = 8000;
    /* access modifiers changed from: private */
    public long mCurrentProgress = 0;
    private final n mEventBus;
    private final q mFabricClient;
    private final a mFileUploader;
    private final PauseHelper mPauseHelper;
    private final UploadGroup mProduct;
    private final be mUIStore;
    private final UploadStore mUploadStore;
    private final UploadManager mUploader;
    private final UserInfo mUser;
    private ResponseCommon responseCommon;
    private int retry = 0;

    public UploadRunnable(n nVar, a aVar, UploadManager uploadManager, be beVar, UploadStore uploadStore, UserInfo userInfo, q qVar, UploadGroup uploadGroup) {
        this.mEventBus = nVar;
        this.mFileUploader = aVar;
        this.mProduct = uploadGroup;
        this.mFabricClient = qVar;
        this.mUploader = uploadManager;
        this.mUIStore = beVar;
        this.mUser = userInfo;
        this.mUploadStore = uploadStore;
        this.mPauseHelper = new PauseHelper(Thread.currentThread());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r23 = this;
            r6 = r23
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            boolean r0 = r0.isEdit()
            if (r0 == 0) goto L_0x000d
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            goto L_0x0013
        L_0x000d:
            com.shopee.app.upload.UploadManager r0 = r6.mUploader
            com.shopee.app.upload.data.UploadGroup r0 = r0.getUploading()
        L_0x0013:
            if (r0 == 0) goto L_0x04ab
            java.lang.String r0 = r0.getRequestId()
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            java.lang.String r1 = r1.getRequestId()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0027
            goto L_0x04ab
        L_0x0027:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "PRODUCT_UPLOAD: "
            r0.append(r7)
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            com.shopee.app.upload.data.UploadItem r1 = r1.getItem()
            com.shopee.protocol.shop.Item r1 = r1.getItem()
            java.lang.String r1 = r1.name
            r0.append(r1)
            java.lang.String r1 = " RETRY: "
            r0.append(r1)
            int r1 = r6.retry
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8 = 0
            java.lang.Object[] r1 = new java.lang.Object[r8]
            com.garena.android.appkit.d.a.b(r0, r1)
            com.shopee.app.upload.UploadRunnable$PauseHelper r0 = r6.mPauseHelper
            r0.refill(r8)
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            com.shopee.app.upload.data.UploadItem r0 = r0.getItem()
            com.shopee.protocol.shop.Item r9 = r0.getItem()
            java.lang.String r0 = r9.images
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            int r2 = r0.length
            r11 = 0
            r4 = r11
            r3 = 0
        L_0x007a:
            if (r3 >= r2) goto L_0x00c0
            r13 = r0[r3]
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            java.lang.String r15 = "_tn"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            long r16 = r6.getFileSize(r14)
            long r18 = r6.getFileSize(r13)
            r20 = -1
            int r14 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r14 == 0) goto L_0x00bd
            int r14 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r14 == 0) goto L_0x00bd
            long r4 = r4 + r16
            long r4 = r4 + r18
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r1.add(r14)
            r1.add(r13)
            r10.add(r13)
        L_0x00bd:
            int r3 = r3 + 1
            goto L_0x007a
        L_0x00c0:
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r0 = r0.getVideo()
            if (r0 == 0) goto L_0x011d
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r0 = r0.getVideo()
            java.lang.String r0 = r0.getPath()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x011d
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r0 = r0.getVideo()
            java.lang.String r0 = r0.getThumb()
            com.shopee.app.upload.data.UploadGroup r2 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r2 = r2.getVideo()
            java.lang.String r2 = r2.getPath()
            com.shopee.app.upload.data.UploadGroup r3 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r3 = r3.getVideo()
            int r3 = r3.getDuration()
            com.shopee.app.ui.image.MediaData r0 = com.shopee.app.ui.image.MediaData.newVideoData(r0, r2, r3)
            com.shopee.app.ui.video.c r0 = com.shopee.app.ui.video.c.a((com.shopee.app.ui.image.MediaData) r0)
            if (r0 == 0) goto L_0x011d
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x011d
            java.io.File r0 = new java.io.File
            com.shopee.app.upload.data.UploadGroup r2 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r2 = r2.getVideo()
            java.lang.String r2 = r2.getPath()
            r0.<init>(r2)
            long r2 = r0.length()
            long r4 = r4 + r2
            r13 = r2
            r2 = r4
            goto L_0x011f
        L_0x011d:
            r2 = r4
            r13 = r11
        L_0x011f:
            r23.notifyStart()
            r6.mCurrentProgress = r11
            java.util.Iterator r0 = r1.iterator()
            r1 = 0
            r4 = 0
        L_0x012a:
            boolean r5 = r0.hasNext()
            java.lang.String r11 = " DISCARDED: "
            r12 = 1
            if (r5 == 0) goto L_0x01ea
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            com.shopee.app.util.f.a r5 = r6.mFileUploader
            com.shopee.app.upload.UploadRunnable$1 r15 = new com.shopee.app.upload.UploadRunnable$1
            r15.<init>(r2)
            int r5 = r5.a((java.lang.String) r4, (com.shopee.app.util.f.a.C0402a) r15)
            java.lang.String r15 = " - "
            if (r5 == r12) goto L_0x016d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r12 = r9.name
            r1.append(r12)
            r1.append(r15)
            r1.append(r4)
            java.lang.String r4 = " FAILED: "
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r4 = new java.lang.Object[r8]
            com.garena.android.appkit.d.a.b(r1, r4)
            r21 = r13
            r1 = 1
            goto L_0x019f
        L_0x016d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r7)
            java.lang.String r8 = r9.name
            r12.append(r8)
            r12.append(r15)
            r12.append(r4)
            java.lang.String r8 = " PASSED: "
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            r12 = 0
            java.lang.Object[] r15 = new java.lang.Object[r12]
            com.garena.android.appkit.d.a.b(r8, r15)
            r21 = r13
            long r12 = r6.mCurrentProgress
            long r14 = r6.getFileSize(r4)
            long r12 = r12 + r14
            r6.mCurrentProgress = r12
            long r12 = r6.mCurrentProgress
            r6.notifyUpdate(r2, r12)
        L_0x019f:
            r4 = 2
            if (r5 != r4) goto L_0x01bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            return
        L_0x01bd:
            com.shopee.app.upload.UploadRunnable$PauseHelper r4 = r6.mPauseHelper
            int r4 = r4.canContinue()
            r8 = -99
            if (r4 != r8) goto L_0x01e2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            return
        L_0x01e2:
            r4 = r5
            r13 = r21
            r8 = 0
            r11 = 0
            goto L_0x012a
        L_0x01ea:
            r21 = r13
            if (r1 == 0) goto L_0x020e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            java.lang.String r1 = " FAILED: image"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            r6.notifyRetry(r4)
            return
        L_0x020e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            java.lang.String r1 = " PASSED: image"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r4 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r4)
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r0 = r0.getVideo()
            if (r0 == 0) goto L_0x0376
            com.shopee.app.upload.data.UploadGroup r0 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r0 = r0.getVideo()
            java.lang.String r0 = r0.getPath()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0376
            java.io.File r0 = new java.io.File
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r1 = r1.getVideo()
            java.lang.String r1 = r1.getPath()
            r0.<init>(r1)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0376
            com.shopee.app.upload.UploadManager r0 = r6.mUploader
            com.shopee.app.upload.VideoRunnable r8 = r0.getCachedJob()
            r12 = 0
            if (r8 == 0) goto L_0x028a
            com.shopee.app.upload.VideoRunnable$Result r0 = r8.getResult()
            if (r0 == 0) goto L_0x028a
            com.shopee.app.upload.VideoRunnable$Result r0 = r8.getResult()
            int r0 = r0.status
            r1 = 1
            if (r0 == r1) goto L_0x028a
            com.shopee.app.upload.UploadRunnable$2 r13 = new com.shopee.app.upload.UploadRunnable$2
            r0 = r13
            r1 = r23
            r4 = r21
            r0.<init>(r2, r4)
            r8.setProgressListener(r13)
            com.shopee.app.upload.UploadRunnable$PauseHelper r0 = r6.mPauseHelper
            r8.setPauseHelper(r0)
            r8.untilFinished()
            com.shopee.app.upload.UploadManager r0 = r6.mUploader
            r0.cacheJob(r12)
            goto L_0x02b8
        L_0x028a:
            com.shopee.app.upload.VideoRunnable r8 = new com.shopee.app.upload.VideoRunnable
            com.shopee.app.util.n r0 = r6.mEventBus
            com.shopee.app.appuser.UserInfo r1 = r6.mUser
            com.shopee.app.upload.data.UploadGroup r4 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r4 = r4.getVideo()
            r8.<init>(r0, r1, r4)
            com.shopee.app.upload.UploadRunnable$3 r13 = new com.shopee.app.upload.UploadRunnable$3
            r0 = r13
            r1 = r23
            r4 = r21
            r0.<init>(r2, r4)
            r8.setProgressListener(r13)
            com.shopee.app.upload.UploadRunnable$PauseHelper r0 = r6.mPauseHelper
            r8.setPauseHelper(r0)
            com.shopee.app.upload.UploadManager r0 = r6.mUploader
            r0.cacheJob(r8)
            r8.run()
            com.shopee.app.upload.UploadManager r0 = r6.mUploader
            r0.cacheJob(r12)
        L_0x02b8:
            com.shopee.app.upload.VideoRunnable$Result r0 = r8.getResult()
            com.shopee.app.upload.UploadStore r1 = r6.mUploadStore
            com.shopee.app.upload.data.UploadGroup r2 = r6.mProduct
            r1.update(r2)
            int r1 = r0.status
            r2 = 1
            if (r1 != r2) goto L_0x02ea
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r2 = r9.name
            r1.append(r2)
            java.lang.String r2 = "VIDEO FAILED: video"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.garena.android.appkit.d.a.b(r1, r2)
            int r0 = r0.status
            r6.notifyRetry(r0)
            return
        L_0x02ea:
            java.lang.String r1 = r0.videoId
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0370
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            com.shopee.app.upload.data.UploadVideo r1 = r1.getVideo()
            java.lang.String r0 = r0.videoId
            r1.setVideoId(r0)
            com.shopee.app.upload.UploadStore r0 = r6.mUploadStore
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            r0.update(r1)
            com.shopee.protocol.shop.Item$Builder r0 = new com.shopee.protocol.shop.Item$Builder     // Catch:{ Exception -> 0x0370 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0370 }
            com.squareup.wire.Wire r1 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x0370 }
            e.f r2 = r9.extinfo     // Catch:{ Exception -> 0x0370 }
            byte[] r2 = r2.i()     // Catch:{ Exception -> 0x0370 }
            java.lang.Class<com.shopee.protocol.shop.ItemExtInfo> r3 = com.shopee.protocol.shop.ItemExtInfo.class
            com.squareup.wire.Message r1 = r1.parseFrom((byte[]) r2, r3)     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.ItemExtInfo r1 = (com.shopee.protocol.shop.ItemExtInfo) r1     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.ItemExtInfo$Builder r2 = new com.shopee.protocol.shop.ItemExtInfo$Builder     // Catch:{ Exception -> 0x0370 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.VideoInfo$Builder r1 = new com.shopee.protocol.shop.VideoInfo$Builder     // Catch:{ Exception -> 0x0370 }
            r1.<init>()     // Catch:{ Exception -> 0x0370 }
            com.shopee.app.upload.data.UploadGroup r3 = r6.mProduct     // Catch:{ Exception -> 0x0370 }
            com.shopee.app.upload.data.UploadVideo r3 = r3.getVideo()     // Catch:{ Exception -> 0x0370 }
            java.lang.String r3 = r3.getVideoId()     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.VideoInfo$Builder r1 = r1.video_id(r3)     // Catch:{ Exception -> 0x0370 }
            com.shopee.app.upload.data.UploadGroup r3 = r6.mProduct     // Catch:{ Exception -> 0x0370 }
            com.shopee.app.upload.data.UploadVideo r3 = r3.getVideo()     // Catch:{ Exception -> 0x0370 }
            int r3 = r3.getDuration()     // Catch:{ Exception -> 0x0370 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.VideoInfo$Builder r1 = r1.duration(r3)     // Catch:{ Exception -> 0x0370 }
            com.shopee.app.upload.data.UploadGroup r3 = r6.mProduct     // Catch:{ Exception -> 0x0370 }
            com.shopee.app.upload.data.UploadVideo r3 = r3.getVideo()     // Catch:{ Exception -> 0x0370 }
            java.lang.String r3 = r3.getThumb()     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.VideoInfo$Builder r1 = r1.thumb_url(r3)     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.VideoInfo r1 = r1.build()     // Catch:{ Exception -> 0x0370 }
            java.util.List r1 = java.util.Collections.singletonList(r1)     // Catch:{ Exception -> 0x0370 }
            r2.video_info_list(r1)     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.ItemExtInfo r1 = r2.build()     // Catch:{ Exception -> 0x0370 }
            byte[] r1 = r1.toByteArray()     // Catch:{ Exception -> 0x0370 }
            e.f r1 = e.f.a((byte[]) r1)     // Catch:{ Exception -> 0x0370 }
            r0.extinfo(r1)     // Catch:{ Exception -> 0x0370 }
            com.shopee.protocol.shop.Item r0 = r0.build()     // Catch:{ Exception -> 0x0370 }
            r9 = r0
        L_0x0370:
            long r0 = r6.mCurrentProgress
            long r0 = r0 + r21
            r6.mCurrentProgress = r0
        L_0x0376:
            r23.notifyIntermediate()
            com.shopee.app.upload.UploadRunnable$PauseHelper r0 = r6.mPauseHelper
            int r0 = r0.canContinue()
            r1 = -99
            if (r0 != r1) goto L_0x039e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            return
        L_0x039e:
            com.shopee.protocol.shop.Item$Builder r0 = new com.shopee.protocol.shop.Item$Builder
            r0.<init>(r9)
            java.lang.Long r1 = r9.itemid
            long r1 = r1.longValue()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x03b6
            java.lang.String r1 = com.shopee.app.g.d.a((java.util.List<java.lang.String>) r10)
            r0.images(r1)
        L_0x03b6:
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            com.shopee.app.upload.data.UploadItem r2 = new com.shopee.app.upload.data.UploadItem
            com.shopee.protocol.shop.Item r0 = r0.build()
            r2.<init>(r0)
            r1.setItem(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            java.lang.String r1 = " SERVER: request"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r2)
            com.shopee.app.upload.UploadRequest r0 = new com.shopee.app.upload.UploadRequest
            com.shopee.app.upload.data.UploadGroup r1 = r6.mProduct
            r0.<init>(r1)
            com.shopee.protocol.action.ResponseCommon r1 = r0.startSync()
            r6.responseCommon = r1
            com.shopee.protocol.action.ResponseCommon r1 = r6.responseCommon
            java.lang.Integer r1 = r1.errcode
            int r1 = r1.intValue()
            if (r1 != 0) goto L_0x041c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r2 = r9.name
            r1.append(r2)
            java.lang.String r2 = " SUCCESS: "
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.garena.android.appkit.d.a.b(r1, r2)
            com.shopee.app.ui.product.add.a r0 = r0.getSuccessEvent()
            r6.notifySuccess(r0)
            goto L_0x04aa
        L_0x041c:
            com.shopee.protocol.action.ResponseCommon r0 = r6.responseCommon
            java.lang.Integer r0 = r0.errcode
            int r0 = r0.intValue()
            r1 = -100
            if (r0 != r1) goto L_0x0457
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            java.lang.String r1 = " FAILED: ErrorCode "
            r0.append(r1)
            com.shopee.protocol.action.ResponseCommon r1 = r6.responseCommon
            java.lang.Integer r1 = r1.errcode
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            com.shopee.protocol.action.ResponseCommon r0 = r6.responseCommon
            java.lang.Integer r0 = r0.errcode
            int r0 = r0.intValue()
            r6.notifyRetry(r0)
            goto L_0x04aa
        L_0x0457:
            com.shopee.protocol.action.ResponseCommon r0 = r6.responseCommon
            java.lang.Integer r0 = r0.errcode
            int r0 = r0.intValue()
            r1 = 11
            if (r0 != r1) goto L_0x0483
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            java.lang.String r1 = " FAILED: duplicate"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            r23.notifyEnd()
            goto L_0x04aa
        L_0x0483:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = r9.name
            r0.append(r1)
            java.lang.String r1 = " FAILED: server rejected us"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            com.shopee.protocol.action.ResponseCommon r0 = r6.responseCommon
            java.lang.Integer r0 = r0.errcode
            int r0 = r0.intValue()
            r6.notifyFailed(r0)
        L_0x04aa:
            return
        L_0x04ab:
            r23.notifyEnd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.upload.UploadRunnable.run():void");
    }

    public ResponseCommon getResponse() {
        return this.responseCommon;
    }

    private void notifyStart() {
        this.mEventBus.a().ct.a(data()).a();
    }

    private void notifyIntermediate() {
        if (!this.mPauseHelper.isDiscarded()) {
            UploadState data = data();
            data.progress = 1.2d;
            this.mEventBus.a().bo.a(data).a();
        }
    }

    /* access modifiers changed from: private */
    public void notifyUpdate(long j, long j2) {
        if (!this.mPauseHelper.isDiscarded()) {
            UploadState data = data();
            data.progress = (double) (((float) j2) / (((float) j) * 1.0f));
            this.mEventBus.a().bo.a(data).a();
        }
    }

    private void notifySuccess(com.shopee.app.ui.product.add.a aVar) {
        UploadState data = data();
        data.event = aVar;
        ShareMessage o = this.mUIStore.o();
        o.setItemID(data.event.f23949b);
        o.setUrl(i.f7041d + o.getUsername() + Constants.URL_PATH_DELIMITER + o.getItemID());
        StringBuilder sb = new StringBuilder();
        sb.append("<style color='#F5FFFFFF'>");
        sb.append((i.f7041d + o.getUsername() + Constants.URL_PATH_DELIMITER + data.event.f23949b).replace("http://", ""));
        sb.append("</style>");
        o.setWatermarkProductDesc(sb.toString());
        this.mUIStore.a(o);
        this.mEventBus.a().f7290a.a(data).a();
    }

    private void notifyRetry(int i) {
        int i2 = this.retry;
        if (i2 < 5) {
            this.retry = i2 + 1;
            notifyIntermediate();
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.mProduct.getItem().getItem().name + " SLEEP: 8 sec", new Object[0]);
            try {
                Thread.sleep(RETRY_SLEEP_TIME);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            run();
            return;
        }
        notifyFailed(-100);
    }

    private void notifyFailed(int i) {
        UploadState data = data();
        data.errorCode = i;
        this.mProduct.setStatus(2);
        this.mProduct.setErrorMessage(getErrorMessage(i));
        this.mUploadStore.update(this.mProduct);
        this.mEventBus.a().cf.a(data).a();
        throw new RuntimeException(String.valueOf(i));
    }

    public void notifyEnd() {
        this.mEventBus.a().cd.a(data()).a();
    }

    private UploadState data() {
        UploadState uploadState = new UploadState();
        uploadState.product = this.mProduct;
        uploadState.runnable = this;
        return uploadState;
    }

    private long getFileSize(String str) {
        File file = new File(f.a().b(str));
        if (file.exists()) {
            return file.length();
        }
        return -1;
    }

    public void pause() {
        this.mPauseHelper.pause();
    }

    public void resume() {
        this.mPauseHelper.resume();
    }

    public void discard() {
        this.mPauseHelper.discard();
    }

    private String getErrorMessage(int i) {
        String str = b.e(R.string.sp_product_failed_noti_message_general) + "\t";
        if (i == -100) {
            return str + b.e(R.string.sp_network_error);
        }
        ResponseCommon responseCommon2 = this.responseCommon;
        if (responseCommon2 == null) {
            return str + b.e(R.string.sp_unknown_error);
        } else if (TextUtils.isEmpty(responseCommon2.err_message)) {
            int intValue = this.responseCommon.errcode.intValue();
            if (intValue == -100) {
                return str + b.e(R.string.sp_network_error);
            } else if (intValue == 17) {
                return str + b.e(R.string.sp_server_price_limit_error);
            } else if (intValue == 1) {
                return str + b.e(R.string.sp_server_parameter_error);
            } else if (intValue == 2) {
                return str + b.e(R.string.sp_server_permission_error);
            } else if (intValue != 3) {
                return str + b.e(R.string.sp_unknown_error);
            } else {
                return str + b.e(R.string.sp_max_product_limit_reached);
            }
        } else {
            return str + this.responseCommon.err_message;
        }
    }

    public static class PauseHelper {
        private boolean isDiscarded = false;
        private BlockingQueue<Integer> mPauseQueue = new ArrayBlockingQueue(40);
        private final Thread mThread;

        public PauseHelper(Thread thread) {
            this.mThread = thread;
            refill(0);
        }

        public int canContinue() {
            if (this.isDiscarded) {
                return -99;
            }
            try {
                return this.mPauseQueue.take().intValue();
            } catch (InterruptedException unused) {
                return -99;
            }
        }

        public void pause() {
            this.mPauseQueue.clear();
        }

        public void resume() {
            refill(0);
        }

        public boolean isDiscarded() {
            return this.isDiscarded;
        }

        public void refill(int i) {
            this.mPauseQueue.clear();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 40; i2++) {
                arrayList.add(Integer.valueOf(i));
            }
            this.mPauseQueue.addAll(arrayList);
        }

        public void discard() {
            this.isDiscarded = true;
            this.mThread.interrupt();
        }
    }
}
