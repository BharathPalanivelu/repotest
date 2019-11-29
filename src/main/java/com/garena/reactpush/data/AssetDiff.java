package com.garena.reactpush.data;

import androidx.core.util.d;

public class AssetDiff {
    private final d<ReactAsset, ReactAsset> mAssetPair;
    private final String mKey;

    public AssetDiff(String str, ReactAsset reactAsset, ReactAsset reactAsset2) {
        if (reactAsset == null && reactAsset2 == null) {
            throw new IllegalArgumentException("Old and new asset must not be null at the same time!");
        }
        this.mKey = str;
        this.mAssetPair = new d<>(reactAsset, reactAsset2);
    }

    public boolean isAssetNew() {
        return this.mAssetPair.f1882a == null;
    }

    public boolean isAssetDeleted() {
        return this.mAssetPair.f1883b == null;
    }

    public d<ReactAsset, ReactAsset> getAsset() {
        return this.mAssetPair;
    }

    public String getKey() {
        return this.mKey;
    }
}
