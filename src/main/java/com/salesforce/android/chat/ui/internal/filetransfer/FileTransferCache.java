package com.salesforce.android.chat.ui.internal.filetransfer;

import androidx.b.a;
import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class FileTransferCache {
    private static final ServiceLogger log = ServiceLogging.getLogger(FileTransferCache.class);
    private Optional<FileTransferAssistant> mFileTransferAssistant = Optional.empty();
    private Optional<FileTransferStatus> mFileTransferStatus = Optional.empty();
    private a<String, ImageThumbnail> mImageThumbnails = new a<>();
    private Set<RequestListener> mRequestListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<FileTransferStatusListener> mStatusListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<FileTransferThumbnailListener> mThumbnailListeners = Collections.newSetFromMap(new ConcurrentHashMap());

    interface RequestListener {
        void onFileTransferRequested(FileTransferAssistant fileTransferAssistant);
    }

    FileTransferCache() {
    }

    /* access modifiers changed from: package-private */
    public void put(ImageThumbnail imageThumbnail) {
        log.trace("Caching thumbnail {} - {}", imageThumbnail.getId(), imageThumbnail.getMeta());
        this.mImageThumbnails.put(imageThumbnail.getId(), imageThumbnail);
        notifyListeners(imageThumbnail);
    }

    /* access modifiers changed from: package-private */
    public void put(FileTransferAssistant fileTransferAssistant) {
        log.trace("Caching FileTransferAssistant");
        this.mFileTransferAssistant = Optional.of(fileTransferAssistant);
        notifyListeners(fileTransferAssistant);
    }

    /* access modifiers changed from: package-private */
    public void put(FileTransferStatus fileTransferStatus) {
        log.trace("Caching FileTransferStatus: {}", fileTransferStatus);
        this.mFileTransferStatus = Optional.of(fileTransferStatus);
        notifyListeners(fileTransferStatus);
    }

    /* access modifiers changed from: package-private */
    public Optional<ImageThumbnail> getThumbnail(String str) {
        return Optional.of(this.mImageThumbnails.get(str));
    }

    /* access modifiers changed from: package-private */
    public Optional<FileTransferAssistant> getFileTransferAssistant() {
        return this.mFileTransferAssistant;
    }

    /* access modifiers changed from: package-private */
    public Optional<FileTransferStatus> getFileTransferStatus() {
        return this.mFileTransferStatus;
    }

    /* access modifiers changed from: package-private */
    public void clearFileTransfer() {
        log.info("Clearing file transfer state from cache.");
        this.mFileTransferAssistant = Optional.empty();
        this.mFileTransferStatus = Optional.empty();
    }

    /* access modifiers changed from: package-private */
    public void addThumbnailListener(FileTransferThumbnailListener fileTransferThumbnailListener) {
        this.mThumbnailListeners.add(fileTransferThumbnailListener);
    }

    /* access modifiers changed from: package-private */
    public void addRequestListener(RequestListener requestListener) {
        this.mRequestListeners.add(requestListener);
    }

    /* access modifiers changed from: package-private */
    public void addStatusListener(FileTransferStatusListener fileTransferStatusListener) {
        this.mStatusListeners.add(fileTransferStatusListener);
    }

    /* access modifiers changed from: package-private */
    public void removeThumbnailListener(FileTransferThumbnailListener fileTransferThumbnailListener) {
        this.mThumbnailListeners.remove(fileTransferThumbnailListener);
    }

    /* access modifiers changed from: package-private */
    public void removeStatusListener(FileTransferStatusListener fileTransferStatusListener) {
        this.mStatusListeners.remove(fileTransferStatusListener);
    }

    private void notifyListeners(ImageThumbnail imageThumbnail) {
        for (FileTransferThumbnailListener onThumbnailCached : this.mThumbnailListeners) {
            onThumbnailCached.onThumbnailCached(imageThumbnail);
        }
    }

    private void notifyListeners(FileTransferAssistant fileTransferAssistant) {
        for (RequestListener onFileTransferRequested : this.mRequestListeners) {
            onFileTransferRequested.onFileTransferRequested(fileTransferAssistant);
        }
    }

    private void notifyListeners(FileTransferStatus fileTransferStatus) {
        for (FileTransferStatusListener onFileTransferStatusChanged : this.mStatusListeners) {
            onFileTransferStatusChanged.onFileTransferStatusChanged(fileTransferStatus);
        }
    }
}
