package com.tencent.cos.xml.transfer;

import android.content.Context;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.transfer.NetworkMonitor;
import com.tencent.cos.xml.transfer.UploadService;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Deprecated
public class TransferUtility {
    static final int DEFAULT_UPLOAD_PART_SIZE = 2097152;
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    static final int MB = 1048576;
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    static final String TRANSFER_UTILITY_TAG = "TransferUtility";
    private final Context appContext;
    private final CosXmlSimpleService cosService;
    private NetworkMonitor networkMonitor;
    private Map<String, TransferRunnable> tasks;
    private ThreadPoolExecutor transferExecutor;
    private TransferStatusManager transferStatusManager;

    private TransferUtility(Context context, CosXmlSimpleService cosXmlSimpleService) {
        this.appContext = context;
        this.cosService = cosXmlSimpleService;
        this.tasks = new HashMap();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        int i = NUMBER_OF_CORES;
        this.transferExecutor = new ThreadPoolExecutor(i, i, 1, KEEP_ALIVE_TIME_UNIT, linkedBlockingQueue);
        this.networkMonitor = new NetworkMonitor();
        this.networkMonitor.addNetworkListener(new NetworkMonitor.NetworkListener() {
            public void onReconnect() {
                TransferUtility.this.onNetworkReconnect();
            }

            public void onDisconnect() {
                TransferUtility.this.onNetworkDisconnect();
            }
        });
        this.networkMonitor.register(this.appContext);
        this.transferStatusManager = new TransferStatusManager(this);
    }

    /* access modifiers changed from: private */
    public void onNetworkReconnect() {
        String[] strArr = new String[this.tasks.size()];
        this.tasks.keySet().toArray(strArr);
        for (int i = 0; i < strArr.length; i++) {
            if (this.transferStatusManager.getState(strArr[i]) == TransferState.WAITING_FOR_NETWORK) {
                resume(strArr[i]);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onNetworkDisconnect() {
        String[] strArr = new String[this.tasks.size()];
        this.tasks.keySet().toArray(strArr);
        for (int i = 0; i < strArr.length; i++) {
            if (this.transferStatusManager.getState(strArr[i]) == TransferState.IN_PROGRESS) {
                pause(this.tasks.get(strArr[i]));
                this.transferStatusManager.updateState(strArr[i], TransferState.WAITING_FOR_NETWORK);
            }
        }
    }

    @Deprecated
    public TransferObserver upload(String str, String str2, String str3) {
        UploadService.ResumeData resumeData = new UploadService.ResumeData();
        resumeData.sliceSize = 2097152;
        resumeData.srcPath = str3;
        resumeData.cosPath = str2;
        resumeData.bucket = str;
        UploadService uploadService = new UploadService(this.cosService, resumeData);
        String uuid = getUUID();
        TransferRunnable transferRunnable = new TransferRunnable(uploadService, uuid, this.transferStatusManager);
        this.tasks.put(uuid, transferRunnable);
        QCloudLogger.i(TRANSFER_UTILITY_TAG, "add upload task(" + uuid + ").", new Object[0]);
        this.transferStatusManager.updateState(uuid, TransferState.IN_PROGRESS);
        this.transferExecutor.execute(transferRunnable);
        return transferRunnable.getTransferObserver();
    }

    @Deprecated
    public boolean pause(String str) {
        TransferRunnable transferRunnable = this.tasks.get(str);
        if (transferRunnable == null) {
            QCloudLogger.w(TRANSFER_UTILITY_TAG, "The task(" + str + ") you want to pause is not exist!", new Object[0]);
            return false;
        }
        QCloudLogger.i(TRANSFER_UTILITY_TAG, "Pause the task(" + str + SQLBuilder.PARENTHESES_RIGHT, new Object[0]);
        this.transferStatusManager.updateState(str, TransferState.PAUSED);
        return pause(transferRunnable);
    }

    private boolean pause(TransferRunnable transferRunnable) {
        transferRunnable.pause();
        return true;
    }

    @Deprecated
    public boolean resume(String str) {
        TransferRunnable transferRunnable = this.tasks.get(str);
        if (transferRunnable == null) {
            QCloudLogger.w(TRANSFER_UTILITY_TAG, "The task(" + str + ") you want to resume is not exist!", new Object[0]);
            return false;
        }
        QCloudLogger.i(TRANSFER_UTILITY_TAG, "Resume task(" + str + SQLBuilder.PARENTHESES_RIGHT, new Object[0]);
        return resume(transferRunnable);
    }

    private boolean resume(TransferRunnable transferRunnable) {
        this.transferStatusManager.updateState(transferRunnable.getTransferObserver().getTransferId(), TransferState.IN_PROGRESS);
        this.transferExecutor.execute(transferRunnable);
        return true;
    }

    @Deprecated
    public boolean cancel(String str) {
        TransferRunnable transferRunnable = this.tasks.get(str);
        if (transferRunnable == null) {
            QCloudLogger.w(TRANSFER_UTILITY_TAG, "The task(" + str + ") you want to cancel is not exist!", new Object[0]);
            return false;
        }
        QCloudLogger.i(TRANSFER_UTILITY_TAG, "Cancel the task(" + str + SQLBuilder.PARENTHESES_RIGHT, new Object[0]);
        return cancel(transferRunnable);
    }

    private boolean cancel(TransferRunnable transferRunnable) {
        this.transferStatusManager.updateState(transferRunnable.getTransferObserver().getTransferId(), TransferState.CANCELED);
        transferRunnable.cancel();
        this.tasks.remove(transferRunnable.getTransferObserver().getTransferId());
        return true;
    }

    @Deprecated
    public void cancelAll() {
        TransferRunnable[] transferRunnableArr = new TransferRunnable[this.tasks.size()];
        this.tasks.values().toArray(transferRunnableArr);
        for (TransferRunnable cancel : transferRunnableArr) {
            cancel(cancel);
        }
    }

    @Deprecated
    public void release() {
        cancelAll();
        this.networkMonitor.unregister(this.appContext);
        this.transferExecutor.shutdown();
    }

    /* access modifiers changed from: package-private */
    public TransferRunnable getTransferRunnable(String str) {
        return this.tasks.get(str);
    }

    @Deprecated
    public static class Builder {
        private Context appContext;
        private CosXmlSimpleService cosService;

        public Builder cosService(CosXmlSimpleService cosXmlSimpleService) {
            this.cosService = cosXmlSimpleService;
            return this;
        }

        public Builder context(Context context) {
            this.appContext = context.getApplicationContext();
            return this;
        }

        public TransferUtility build() {
            return new TransferUtility(this.appContext, this.cosService);
        }
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
