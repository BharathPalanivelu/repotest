package com.salesforce.android.chat.ui.internal.filetransfer;

import android.content.Context;
import android.net.Uri;
import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.FileTransferRequestListener;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.chat.ui.internal.filetransfer.ImageContentResolver;
import com.salesforce.android.chat.ui.internal.filetransfer.ImageProcessor;
import com.salesforce.android.chat.ui.internal.filetransfer.ImageSender;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageMeta;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.FileNotFoundException;

public class FileTransferManager implements FileTransferRequestListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(FileTransferManager.class);
    private final FileTransferCache mFileTransferCache;
    private final ImageContentResolver mImageContentResolver;
    private final ImageProcessor mImageProcessor;
    private final ImageSender mImageSender;

    private FileTransferManager(Builder builder) {
        this.mFileTransferCache = builder.mFileTransferCache;
        this.mImageProcessor = builder.mImageProcessor;
        this.mImageContentResolver = builder.mImageContentResolver;
        this.mImageSender = builder.mImageSender;
    }

    public Uri createNewImage() {
        return this.mImageContentResolver.createNewImage();
    }

    public Uri getLastPhotoTaken() throws FileNotFoundException {
        return this.mImageContentResolver.getLastPhotoTaken();
    }

    public void transferImage(Uri uri) {
        ImageMeta createImageMeta = this.mImageContentResolver.createImageMeta(uri);
        this.mImageProcessor.produceThumbnail(createImageMeta);
        this.mImageProcessor.produceFinalImage(createImageMeta);
    }

    public Optional<FileTransferStatus> getStatus() {
        return this.mFileTransferCache.getFileTransferStatus();
    }

    public Optional<ImageThumbnail> getThumbnail(String str) {
        return this.mFileTransferCache.getThumbnail(str);
    }

    public void addThumbnailListener(FileTransferThumbnailListener fileTransferThumbnailListener) {
        this.mFileTransferCache.addThumbnailListener(fileTransferThumbnailListener);
    }

    public void addStatusListener(FileTransferStatusListener fileTransferStatusListener) {
        this.mFileTransferCache.addStatusListener(fileTransferStatusListener);
        this.mImageSender.addStatusListener(fileTransferStatusListener);
    }

    public void addProgressListener(FileTransferProgressListener fileTransferProgressListener) {
        this.mImageSender.addProgressListener(fileTransferProgressListener);
    }

    public void removeThumbnailListener(FileTransferThumbnailListener fileTransferThumbnailListener) {
        this.mFileTransferCache.removeThumbnailListener(fileTransferThumbnailListener);
    }

    public void removeStatusListener(FileTransferStatusListener fileTransferStatusListener) {
        this.mFileTransferCache.removeStatusListener(fileTransferStatusListener);
        this.mImageSender.removeStatusListener(fileTransferStatusListener);
    }

    public void removeProgressListener(FileTransferProgressListener fileTransferProgressListener) {
        this.mImageSender.removeProgressListener(fileTransferProgressListener);
    }

    public void onFileTransferRequest(FileTransferAssistant fileTransferAssistant) {
        log.trace("Received a FileTransferAssistant");
        this.mFileTransferCache.put(fileTransferAssistant);
    }

    public void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus) {
        log.trace("Received FileTransferStatus: {}", fileTransferStatus);
        this.mFileTransferCache.put(fileTransferStatus);
    }

    public static class Builder {
        private Context mContext;
        /* access modifiers changed from: private */
        public FileTransferCache mFileTransferCache;
        /* access modifiers changed from: private */
        public ImageContentResolver mImageContentResolver;
        /* access modifiers changed from: private */
        public ImageProcessor mImageProcessor;
        /* access modifiers changed from: private */
        public ImageSender mImageSender;
        private String mPhotoDirectoryName;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder photoDirectoryName(String str) {
            this.mPhotoDirectoryName = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileTransferCache(FileTransferCache fileTransferCache) {
            this.mFileTransferCache = fileTransferCache;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder imageProcessor(ImageProcessor imageProcessor) {
            this.mImageProcessor = imageProcessor;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder imageContentResolver(ImageContentResolver imageContentResolver) {
            this.mImageContentResolver = imageContentResolver;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder imageSender(ImageSender imageSender) {
            this.mImageSender = imageSender;
            return this;
        }

        public FileTransferManager build() {
            Arguments.checkNotNull(this.mContext);
            if (this.mFileTransferCache == null) {
                this.mFileTransferCache = new FileTransferCache();
            }
            if (this.mImageProcessor == null) {
                this.mImageProcessor = new ImageProcessor.Builder().with(this.mContext).fileTransferCache(this.mFileTransferCache).build();
            }
            if (this.mImageContentResolver == null) {
                this.mImageContentResolver = new ImageContentResolver.Builder().with(this.mContext).photoDirectoryName(this.mPhotoDirectoryName).build();
            }
            if (this.mImageSender == null) {
                this.mImageSender = new ImageSender.Builder().fileTransferCache(this.mFileTransferCache).imageProcessor(this.mImageProcessor).build();
            }
            return new FileTransferManager(this);
        }
    }
}
