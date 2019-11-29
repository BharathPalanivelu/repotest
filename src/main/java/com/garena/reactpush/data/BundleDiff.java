package com.garena.reactpush.data;

import androidx.core.util.d;
import java.util.List;

public class BundleDiff {
    private List<AssetDiff> assetList;
    private d<ReactBundle, ReactBundle> bundle;
    private boolean hasJSChanged;

    private BundleDiff(Builder builder) {
        this.bundle = builder.bundle;
        this.hasJSChanged = builder.hasJSChanged;
        this.assetList = builder.assetList;
    }

    public void setBundle(d<ReactBundle, ReactBundle> dVar) {
        this.bundle = dVar;
    }

    public d<ReactBundle, ReactBundle> getBundle() {
        return this.bundle;
    }

    public boolean hasJSChanged() {
        return this.hasJSChanged;
    }

    public boolean isBundleNew() {
        return this.bundle.f1882a == null;
    }

    public boolean isBundleDeleted() {
        return this.bundle.f1883b == null;
    }

    public List<AssetDiff> getAssetList() {
        return this.assetList;
    }

    public boolean isDownloadNeeded() {
        if (!this.hasJSChanged) {
            List<AssetDiff> list = this.assetList;
            if (list == null || list.size() <= 0) {
                return false;
            }
        }
        return true;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<AssetDiff> assetList;
        /* access modifiers changed from: private */
        public d<ReactBundle, ReactBundle> bundle;
        /* access modifiers changed from: private */
        public boolean hasJSChanged;

        public Builder bundle(d<ReactBundle, ReactBundle> dVar) {
            if (dVar.f1882a == null && dVar.f1883b == null) {
                throw new IllegalArgumentException("Old and new bundle must not be null at the same time");
            }
            this.bundle = dVar;
            return this;
        }

        public Builder hasJSChanged(boolean z) {
            this.hasJSChanged = z;
            return this;
        }

        public Builder assetList(List<AssetDiff> list) {
            this.assetList = list;
            return this;
        }

        public BundleDiff build() {
            return new BundleDiff(this);
        }
    }
}
