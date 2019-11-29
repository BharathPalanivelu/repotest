package com.garena.reactpush.f.a;

import androidx.core.util.d;
import com.garena.reactpush.b;
import com.garena.reactpush.data.AssetDiff;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ManifestDiff;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f8468a;

    public a(List<String> list) {
        this.f8468a = list;
    }

    public ManifestDiff a(Manifest manifest, Manifest manifest2) {
        ArrayList arrayList = new ArrayList();
        if (b.f6699b && manifest.isNewer(manifest2)) {
            return new ManifestDiff.Builder().assetBaseURL(manifest2.getAssetsBaseURL()).assetDiffList(Collections.emptyList()).bundleDiffList(Collections.emptyList()).build();
        }
        List<ReactBundle> bundles = manifest.getBundles();
        List<ReactBundle> bundles2 = manifest2.getBundles();
        for (ReactBundle next : bundles2) {
            boolean z = false;
            for (ReactBundle next2 : bundles) {
                if (next.getName().equals(next2.getName())) {
                    if (!next.getMd5().equals(next2.getMd5())) {
                        arrayList.add(new BundleDiff.Builder().hasJSChanged(true).bundle(new d(next2, next)).build());
                    }
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(new BundleDiff.Builder().bundle(new d(null, next)).hasJSChanged(true).build());
            }
        }
        for (ReactBundle next3 : bundles) {
            boolean z2 = false;
            for (ReactBundle name : bundles2) {
                if (next3.getName().equals(name.getName())) {
                    z2 = true;
                }
            }
            if (!z2) {
                arrayList.add(new BundleDiff.Builder().bundle(new d(next3, null)).hasJSChanged(true).build());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String next4 : this.f8468a) {
            List<ReactAsset> assetList = manifest.getAssetList(next4);
            List<ReactAsset> assetList2 = manifest2.getAssetList(next4);
            for (ReactAsset next5 : assetList2) {
                boolean z3 = false;
                for (ReactAsset next6 : assetList) {
                    if (next5.getPath().equals(next6.getPath())) {
                        if (!next5.getMd5().equals(next6.getMd5())) {
                            arrayList2.add(new AssetDiff(next4, next6, next5));
                        }
                        z3 = true;
                    }
                }
                if (!z3) {
                    arrayList2.add(new AssetDiff(next4, (ReactAsset) null, next5));
                }
            }
            for (ReactAsset next7 : assetList) {
                boolean z4 = false;
                for (ReactAsset path : assetList2) {
                    if (next7.getPath().equals(path.getPath())) {
                        z4 = true;
                    }
                }
                if (!z4) {
                    arrayList2.add(new AssetDiff(next4, next7, (ReactAsset) null));
                }
            }
        }
        Manifest manifest3 = manifest2;
        ManifestDiff build = new ManifestDiff.Builder().bundleDiffList(arrayList).assetDiffList(arrayList2).assetBaseURL(manifest2.getAssetsBaseURL()).build();
        a(build);
        return build;
    }

    private void a(ManifestDiff manifestDiff) {
        if (!b.f6699b) {
            com.garena.reactpush.c.d dVar = b.f6701d;
            dVar.a("Diff Detected. [Bundles Changed=" + manifestDiff.getBundleDiffList().size() + ", Assets Changed=" + manifestDiff.getAssetDiffList().size() + "]");
        }
    }
}
