package com.salesforce.android.chat.ui.internal.filetransfer;

import android.content.Context;
import com.salesforce.android.chat.ui.internal.filetransfer.job.FinalImageJob;
import com.salesforce.android.chat.ui.internal.filetransfer.job.ThumbnailImageJob;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageFinal;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageMeta;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

class ImageProcessor {
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(ImageProcessor.class);
    private final Context mContext;
    /* access modifiers changed from: private */
    public final FileTransferCache mFileTransferCache;
    private Set<FinalImageListener> mFinalImageListeners;
    private final JobQueue mJobQueue;

    interface FinalImageListener {
        void onFinalImageRendered(ImageFinal imageFinal);
    }

    private ImageProcessor(Builder builder) {
        this.mFinalImageListeners = Collections.newSetFromMap(new ConcurrentHashMap());
        this.mContext = builder.mContext;
        this.mFileTransferCache = builder.mFileTransferCache;
        this.mJobQueue = builder.mJobQueue;
    }

    /* access modifiers changed from: package-private */
    public Async<ImageThumbnail> produceThumbnail(ImageMeta imageMeta) {
        log.info("Creating thumbnail image for {}", imageMeta);
        return this.mJobQueue.add(new ThumbnailImageJob.Builder().with(this.mContext).imageMeta(imageMeta).build()).onResult(new Async.ResultHandler<ImageThumbnail>() {
            public void handleResult(Async<?> async, ImageThumbnail imageThumbnail) {
                ImageProcessor.this.mFileTransferCache.put(imageThumbnail);
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                ImageProcessor.log.error("Error encountered while producing thumbnail image:\n{}", th);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Async<ImageFinal> produceFinalImage(ImageMeta imageMeta) {
        log.info("Creating final image for {}", imageMeta);
        return this.mJobQueue.add(new FinalImageJob.Builder().with(this.mContext).imageMeta(imageMeta).build()).onResult(new Async.ResultHandler<ImageFinal>() {
            public void handleResult(Async<?> async, ImageFinal imageFinal) {
                ImageProcessor.this.notifyListeners(imageFinal);
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                ImageProcessor.log.error("Error encountered while producing final image:\n{}", th);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void addFinalImageListener(FinalImageListener finalImageListener) {
        this.mFinalImageListeners.add(finalImageListener);
    }

    /* access modifiers changed from: private */
    public void notifyListeners(ImageFinal imageFinal) {
        for (FinalImageListener onFinalImageRendered : this.mFinalImageListeners) {
            onFinalImageRendered.onFinalImageRendered(imageFinal);
        }
    }

    static class Builder {
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public FileTransferCache mFileTransferCache;
        /* access modifiers changed from: private */
        public JobQueue mJobQueue;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileTransferCache(FileTransferCache fileTransferCache) {
            this.mFileTransferCache = fileTransferCache;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder jobQueue(JobQueue jobQueue) {
            this.mJobQueue = jobQueue;
            return this;
        }

        public ImageProcessor build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mFileTransferCache);
            if (this.mJobQueue == null) {
                this.mJobQueue = new JobQueue(Executors.newCachedThreadPool(PriorityThreadFactory.background()));
            }
            return new ImageProcessor(this);
        }
    }
}
