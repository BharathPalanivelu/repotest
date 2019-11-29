package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.transfer.UploadService;
import com.tencent.qcloud.core.logger.QCloudLogger;

public class UploadRunnable implements Runnable {
    private CosXmlClientException clientException;
    /* access modifiers changed from: private */
    public String id;
    private CosXmlProgressListener progressListener = new CosXmlProgressListener() {
        public void onProgress(long j, long j2) {
            UploadRunnable.this.notifyTransferProgress(j, j2);
        }
    };
    private UploadService.ResumeData resumeData;
    private CosXmlServiceException serviceException;
    private TransferObserver transferObserver;
    private TransferStatusManager transferStatusManager;
    private UploadService uploadService;

    UploadRunnable(UploadService uploadService2, String str, TransferStatusManager transferStatusManager2) {
        this.uploadService = uploadService2;
        this.id = str;
        this.transferObserver = new TransferObserver(str);
        uploadService2.setProgressListener(this.progressListener);
        this.transferStatusManager = transferStatusManager2;
    }

    public void run() {
        if (!Thread.interrupted()) {
            this.clientException = null;
            this.serviceException = null;
            try {
                if (this.resumeData != null) {
                    this.uploadService.init(this.resumeData);
                }
                this.uploadService.upload();
            } catch (CosXmlClientException e2) {
                this.clientException = e2;
                if (!isDetectNetworkDisconnectCauseClientException(e2) && !isInitiativePauseCauseClientException(e2) && !isInitiativeCancelCauseClientException(e2)) {
                    notifyTransferFailed();
                    this.transferStatusManager.updateState(this.id, TransferState.FAILED);
                }
            } catch (CosXmlServiceException e3) {
                this.serviceException = e3;
                notifyTransferFailed();
                this.transferStatusManager.updateState(this.id, TransferState.FAILED);
            }
            if (this.serviceException == null && this.clientException == null) {
                this.transferStatusManager.updateState(this.id, TransferState.COMPLETED);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        this.resumeData = this.uploadService.pause();
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.uploadService.abort(new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                QCloudLogger.i("TransferUtility", "cancel task(" + UploadRunnable.this.id + ") success", new Object[0]);
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                QCloudLogger.w("TransferUtility", "cancel task(" + UploadRunnable.this.id + ") failed", new Object[0]);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public TransferObserver getTransferObserver() {
        return this.transferObserver;
    }

    private void notifyTransferFailed() {
        TransferObserver transferObserver2 = this.transferObserver;
        if (transferObserver2 != null && transferObserver2.getTransferListener() != null) {
            this.transferObserver.getTransferListener().onError(this.id, this.clientException, this.serviceException);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyTransferStateChange(TransferState transferState) {
        TransferObserver transferObserver2 = this.transferObserver;
        if (transferObserver2 != null && transferObserver2.getTransferListener() != null) {
            this.transferObserver.getTransferListener().onStateChanged(this.id, transferState);
        }
    }

    /* access modifiers changed from: private */
    public void notifyTransferProgress(long j, long j2) {
        TransferObserver transferObserver2 = this.transferObserver;
        if (transferObserver2 != null && transferObserver2.getTransferListener() != null) {
            this.transferObserver.getTransferListener().onProgressChanged(this.id, j, j2);
        }
    }

    private boolean isDetectNetworkDisconnectCauseClientException(CosXmlClientException cosXmlClientException) {
        return this.transferObserver.getTransferState() == TransferState.WAITING_FOR_NETWORK && cosXmlClientException != null && cosXmlClientException.getMessage().toLowerCase().contains("request is cancelled by manual pause");
    }

    private boolean isInitiativePauseCauseClientException(CosXmlClientException cosXmlClientException) {
        return this.transferObserver.getTransferState() == TransferState.PAUSED && cosXmlClientException != null && cosXmlClientException.getMessage().toLowerCase().contains("request is cancelled by manual pause");
    }

    private boolean isInitiativeCancelCauseClientException(CosXmlClientException cosXmlClientException) {
        return this.transferObserver.getTransferState() == TransferState.CANCELED && cosXmlClientException != null && cosXmlClientException.getMessage().toLowerCase().contains("request is cancelled by abort request");
    }
}
