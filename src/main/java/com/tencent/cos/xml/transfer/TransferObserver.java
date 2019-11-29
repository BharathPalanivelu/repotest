package com.tencent.cos.xml.transfer;

public class TransferObserver {
    private final String transferId;
    private TransferListener transferListener;
    private TransferState transferState;

    public TransferObserver(String str) {
        this.transferId = str;
    }

    public TransferListener getTransferListener() {
        return this.transferListener;
    }

    public void setTransferListener(TransferListener transferListener2) {
        this.transferListener = transferListener2;
    }

    public String getTransferId() {
        return this.transferId;
    }

    public void setTransferState(TransferState transferState2) {
        this.transferState = transferState2;
    }

    public TransferState getTransferState() {
        return this.transferState;
    }
}
