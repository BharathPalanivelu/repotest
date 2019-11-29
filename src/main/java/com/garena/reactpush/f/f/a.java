package com.garena.reactpush.f.f;

import com.garena.reactpush.b.b;
import com.garena.reactpush.data.AssetDiff;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactAsset;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Manifest f8531a;

    /* renamed from: b  reason: collision with root package name */
    private b f8532b;

    public a(Manifest manifest, b bVar) {
        this.f8531a = manifest;
        this.f8532b = bVar;
    }

    public synchronized boolean a(AssetDiff assetDiff) {
        String key = assetDiff.getKey();
        ReactAsset reactAsset = (ReactAsset) assetDiff.getAsset().f1882a;
        ReactAsset reactAsset2 = (ReactAsset) assetDiff.getAsset().f1883b;
        if (assetDiff.isAssetNew()) {
            this.f8531a.getAssetList(key).add(reactAsset2);
        } else if (assetDiff.isAssetDeleted()) {
            this.f8531a.getAssetList(key).remove(reactAsset);
        } else {
            reactAsset.update(reactAsset2);
        }
        this.f8532b.a(this.f8531a);
        return true;
    }
}
