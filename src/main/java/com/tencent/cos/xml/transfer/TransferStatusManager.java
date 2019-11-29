package com.tencent.cos.xml.transfer;

import java.util.HashMap;
import java.util.Map;

public class TransferStatusManager {
    private Map<String, TransferState> transferStatus = new HashMap();
    private TransferUtility transferUtility;

    TransferStatusManager(TransferUtility transferUtility2) {
        this.transferUtility = transferUtility2;
    }

    /* access modifiers changed from: package-private */
    public void updateState(String str, TransferState transferState) {
        this.transferStatus.put(str, transferState);
        TransferRunnable transferRunnable = this.transferUtility.getTransferRunnable(str);
        if (transferRunnable != null) {
            transferRunnable.notifyTransferStateChange(transferState);
            transferRunnable.getTransferObserver().setTransferState(transferState);
        }
        if (transferState == TransferState.CANCELED || transferState == TransferState.COMPLETED) {
            removeState(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeState(String str) {
        this.transferStatus.remove(str);
    }

    /* access modifiers changed from: package-private */
    public TransferState getState(String str) {
        return this.transferStatus.get(str);
    }
}
