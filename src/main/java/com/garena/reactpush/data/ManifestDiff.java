package com.garena.reactpush.data;

import java.util.List;

public class ManifestDiff {
    private String assetBaseURL;
    private List<AssetDiff> assetDiffList;
    private List<BundleDiff> bundleDiffList;

    private ManifestDiff(Builder builder) {
        this.bundleDiffList = builder.bundleDiffList;
        this.assetDiffList = builder.assetDiffList;
        this.assetBaseURL = builder.assetBaseURL;
    }

    public List<BundleDiff> getBundleDiffList() {
        return this.bundleDiffList;
    }

    public List<AssetDiff> getAssetDiffList() {
        return this.assetDiffList;
    }

    public String getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public boolean isEmpty() {
        List<AssetDiff> list = this.assetDiffList;
        if (list == null || list.isEmpty()) {
            List<BundleDiff> list2 = this.bundleDiffList;
            if (list2 == null || list2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String assetBaseURL;
        /* access modifiers changed from: private */
        public List<AssetDiff> assetDiffList;
        /* access modifiers changed from: private */
        public List<BundleDiff> bundleDiffList;

        public Builder bundleDiffList(List<BundleDiff> list) {
            this.bundleDiffList = list;
            return this;
        }

        public Builder assetDiffList(List<AssetDiff> list) {
            this.assetDiffList = list;
            return this;
        }

        public Builder assetBaseURL(String str) {
            this.assetBaseURL = str;
            return this;
        }

        public ManifestDiff build() {
            return new ManifestDiff(this);
        }
    }
}
