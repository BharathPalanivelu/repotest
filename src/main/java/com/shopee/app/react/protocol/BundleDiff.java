package com.shopee.app.react.protocol;

import com.shopee.app.util.af;
import java.util.List;

public class BundleDiff {
    private List<ReactAsset> assetList;
    private ReactBundle bundle;
    private boolean hasJSChanged;

    private BundleDiff(Builder builder) {
        this.bundle = builder.bundle;
        this.hasJSChanged = builder.hasBundleChanged;
        this.assetList = builder.assetList;
    }

    public boolean hasJSChanged() {
        return this.hasJSChanged;
    }

    public boolean isDownloadNeeded() {
        return this.hasJSChanged || !af.a(this.assetList);
    }

    public ReactBundle getBundle() {
        return this.bundle;
    }

    public List<ReactAsset> getAssetList() {
        return this.assetList;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<ReactAsset> assetList;
        /* access modifiers changed from: private */
        public ReactBundle bundle;
        /* access modifiers changed from: private */
        public boolean hasBundleChanged;

        public Builder bundle(ReactBundle reactBundle) {
            this.bundle = reactBundle;
            return this;
        }

        public Builder hasBundleChanged(boolean z) {
            this.hasBundleChanged = z;
            return this;
        }

        public Builder assetList(List<ReactAsset> list) {
            this.assetList = list;
            return this;
        }

        public BundleDiff build() {
            return new BundleDiff(this);
        }
    }
}
