package com.salesforce.android.chat.ui.internal.filetransfer;

import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;

public interface FileTransferThumbnailListener {
    void onThumbnailCached(ImageThumbnail imageThumbnail);
}
