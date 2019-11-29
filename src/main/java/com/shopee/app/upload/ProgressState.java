package com.shopee.app.upload;

public abstract class ProgressState {
    public abstract String getErrorMessage();

    public abstract String getImageId();

    public abstract String getKey();

    public abstract String getLabel();

    public abstract double getProgress();

    public abstract AbstractRunnable getRunnable();

    public abstract boolean hasVideo();

    public abstract class AbstractRunnable {
        public abstract void discard();

        public abstract void pause();

        public abstract void resume();

        public AbstractRunnable() {
        }
    }
}
