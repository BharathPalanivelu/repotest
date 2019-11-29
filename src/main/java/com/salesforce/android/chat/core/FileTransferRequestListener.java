package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.FileTransferStatus;

public interface FileTransferRequestListener {
    void onFileTransferRequest(FileTransferAssistant fileTransferAssistant);

    void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus);
}
