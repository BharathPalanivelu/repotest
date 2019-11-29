package com.garena.reactpush.e.a;

import androidx.core.util.d;
import com.garena.reactpush.b;
import com.garena.reactpush.data.AssetDiff;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f8370a;

    public a(List<String> list) {
        this.f8370a = list;
    }

    public List<BundleDiff> a(Manifest manifest, Manifest manifest2) {
        ArrayList arrayList = new ArrayList();
        if (b.f6699b && manifest.isNewer(manifest2)) {
            return arrayList;
        }
        List<ReactBundle> bundles = manifest.getBundles();
        for (ReactBundle next : manifest2.getBundles()) {
            boolean z = false;
            for (ReactBundle next2 : bundles) {
                if (next.getName().equals(next2.getName())) {
                    BundleDiff a2 = a(next2, next);
                    if (a2.isDownloadNeeded()) {
                        arrayList.add(a2);
                    }
                    z = true;
                }
            }
            if (!z) {
                ArrayList arrayList2 = new ArrayList();
                for (String next3 : this.f8370a) {
                    for (ReactAsset assetDiff : next.getAssetList(next3)) {
                        arrayList2.add(new AssetDiff(next3, (ReactAsset) null, assetDiff));
                    }
                }
                arrayList.add(new BundleDiff.Builder().bundle(new d(null, next)).hasJSChanged(true).assetList(arrayList2).build());
            }
        }
        a(arrayList);
        return arrayList;
    }

    private BundleDiff a(ReactBundle reactBundle, ReactBundle reactBundle2) {
        boolean z = !reactBundle.getMd5().equals(reactBundle2.getMd5());
        ArrayList arrayList = new ArrayList();
        for (String next : this.f8370a) {
            List<ReactAsset> assetList = reactBundle.getAssetList(next);
            for (ReactAsset next2 : reactBundle2.getAssetList(next)) {
                boolean z2 = false;
                for (ReactAsset next3 : assetList) {
                    if (next2.getPath().equals(next3.getPath())) {
                        if (!next2.getMd5().equals(next3.getMd5())) {
                            arrayList.add(new AssetDiff(next, next3, next2));
                        }
                        z2 = true;
                    }
                }
                if (!z2) {
                    arrayList.add(new AssetDiff(next, (ReactAsset) null, next2));
                }
            }
        }
        return new BundleDiff.Builder().bundle(new d(reactBundle, reactBundle2)).hasJSChanged(z).assetList(arrayList).build();
    }

    private void a(List<BundleDiff> list) {
        if (!b.f6699b) {
            com.garena.reactpush.c.d dVar = b.f6701d;
            dVar.a("Diff Detected. [count=" + list.size() + "]");
            for (BundleDiff next : list) {
                com.garena.reactpush.c.d dVar2 = b.f6701d;
                dVar2.a("Diff Detected. [Bundle Changed=" + next.hasJSChanged() + ", Assets Changed=" + next.getAssetList().size() + "]");
            }
        }
    }
}
