package com.salesforce.android.chat.ui.internal.filetransfer;

import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.chat.ui.internal.filetransfer.FileTransferCache;
import com.salesforce.android.chat.ui.internal.filetransfer.ImageProcessor;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageFinal;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ImageSender implements FileTransferCache.RequestListener, ImageProcessor.FinalImageListener {
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(ImageProcessor.class);
    /* access modifiers changed from: private */
    public Optional<FileTransferAssistant> mFileTransferAssistant;
    /* access modifiers changed from: private */
    public final FileTransferCache mFileTransferCache;
    private Set<FileTransferProgressListener> mProgressListeners;
    private Set<FileTransferStatusListener> mStatusListeners;

    private ImageSender(Builder builder) {
        this.mProgressListeners = Collections.newSetFromMap(new ConcurrentHashMap());
        this.mStatusListeners = Collections.newSetFromMap(new ConcurrentHashMap());
        this.mFileTransferAssistant = Optional.empty();
        this.mFileTransferCache = builder.mFileTransferCache;
        this.mFileTransferCache.addRequestListener(this);
        builder.mImageProcessor.addFinalImageListener(this);
    }

    public void onFinalImageRendered(final ImageFinal imageFinal) {
        this.mFileTransferAssistant.ifPresent(new Consumer<FileTransferAssistant>() {
            public void consume(FileTransferAssistant fileTransferAssistant) {
                fileTransferAssistant.uploadFile(imageFinal.getImageBytes(), imageFinal.getMimeType()).onResult(new Async.ResultHandler<Float>() {
                    public void handleResult(Async<?> async, Float f2) {
                        ImageSender.this.notifyProgressListeners(f2.floatValue());
                    }
                }).onComplete(new Async.CompletionHandler() {
                    public void handleComplete(Async<?> async) {
                        ImageSender.log.debug("File transfer complete");
                        Optional unused = ImageSender.this.mFileTransferAssistant = Optional.empty();
                        ImageSender.this.mFileTransferCache.clearFileTransfer();
                    }
                }).onError(new Async.ErrorHandler() {
                    public void handleError(Async<?> async, Throwable th) {
                        ImageSender.this.notifyStatusListeners(FileTransferStatus.Failed);
                    }
                });
            }
        });
    }

    public void onFileTransferRequested(FileTransferAssistant fileTransferAssistant) {
        this.mFileTransferAssistant = Optional.of(fileTransferAssistant);
    }

    /* access modifiers changed from: package-private */
    public void addProgressListener(FileTransferProgressListener fileTransferProgressListener) {
        this.mProgressListeners.add(fileTransferProgressListener);
    }

    /* access modifiers changed from: package-private */
    public void removeProgressListener(FileTransferProgressListener fileTransferProgressListener) {
        this.mProgressListeners.remove(fileTransferProgressListener);
    }

    /* access modifiers changed from: package-private */
    public void addStatusListener(FileTransferStatusListener fileTransferStatusListener) {
        this.mStatusListeners.add(fileTransferStatusListener);
    }

    /* access modifiers changed from: package-private */
    public void removeStatusListener(FileTransferStatusListener fileTransferStatusListener) {
        this.mStatusListeners.remove(fileTransferStatusListener);
    }

    /* access modifiers changed from: private */
    public void notifyProgressListeners(float f2) {
        for (FileTransferProgressListener onFileTransferProgressUpdate : this.mProgressListeners) {
            onFileTransferProgressUpdate.onFileTransferProgressUpdate(f2);
        }
    }

    /* access modifiers changed from: private */
    public void notifyStatusListeners(FileTransferStatus fileTransferStatus) {
        for (FileTransferStatusListener onFileTransferStatusChanged : this.mStatusListeners) {
            onFileTransferStatusChanged.onFileTransferStatusChanged(fileTransferStatus);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public FileTransferCache mFileTransferCache;
        /* access modifiers changed from: private */
        public ImageProcessor mImageProcessor;

        /* access modifiers changed from: package-private */
        public Builder imageProcessor(ImageProcessor imageProcessor) {
            this.mImageProcessor = imageProcessor;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileTransferCache(FileTransferCache fileTransferCache) {
            this.mFileTransferCache = fileTransferCache;
            return this;
        }

        public ImageSender build() {
            Arguments.checkNotNull(this.mImageProcessor);
            Arguments.checkNotNull(this.mFileTransferCache);
            return new ImageSender(this);
        }
    }
}
