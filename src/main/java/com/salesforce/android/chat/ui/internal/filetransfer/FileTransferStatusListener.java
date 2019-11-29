package com.salesforce.android.chat.ui.internal.filetransfer;

import com.salesforce.android.chat.core.model.FileTransferStatus;

public interface FileTransferStatusListener {
    void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus);
}
