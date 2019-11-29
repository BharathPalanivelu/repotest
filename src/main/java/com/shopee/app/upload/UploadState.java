package com.shopee.app.upload;

import com.shopee.app.ui.product.add.a;
import com.shopee.app.upload.ProgressState;
import com.shopee.app.upload.data.UploadGroup;

public class UploadState extends ProgressState {
    public int errorCode;
    public a event;
    public UploadGroup product;
    public double progress;
    public UploadRunnable runnable;

    public String getKey() {
        return null;
    }

    public String getLabel() {
        return this.product.getItem().getItem().name;
    }

    public double getProgress() {
        return this.progress;
    }

    public String getErrorMessage() {
        return this.product.getErrorMessage();
    }

    public boolean hasVideo() {
        return this.product.getVideo() != null;
    }

    public ProgressState.AbstractRunnable getRunnable() {
        return new ProgressState.AbstractRunnable() {
            public void discard() {
                if (UploadState.this.runnable != null) {
                    UploadState.this.runnable.discard();
                }
            }

            public void pause() {
                if (UploadState.this.runnable != null) {
                    UploadState.this.runnable.pause();
                }
            }

            public void resume() {
                if (UploadState.this.runnable != null) {
                    UploadState.this.runnable.resume();
                }
            }
        };
    }

    public String getImageId() {
        return this.product.getItem().getItem().images;
    }
}
