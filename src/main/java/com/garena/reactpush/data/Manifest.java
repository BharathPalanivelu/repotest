package com.garena.reactpush.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manifest {
    private Map<String, List<ReactAsset>> assets;
    private String assets_base_url;
    private List<ReactBundle> bundles;
    private Map<String, ReactPack> packs;
    private String updated_at;
    private long updated_ts;
    private String version;

    public List<ReactBundle> getBundles() {
        if (this.bundles == null) {
            this.bundles = new ArrayList();
        }
        return this.bundles;
    }

    public boolean isEmpty() {
        if (this.updated_ts > 0) {
            List<ReactBundle> list = this.bundles;
            return list == null || list.size() == 0;
        }
    }

    public boolean isNewer(Manifest manifest) {
        return this.updated_ts > manifest.updated_ts;
    }

    public void setUpdatedTime(long j) {
        this.updated_ts = j;
    }

    public long getManifestVersion() {
        return this.updated_ts;
    }

    public String getVersion() {
        return this.version;
    }

    public String getAssetsBaseURL() {
        return this.assets_base_url;
    }

    public List<ReactAsset> getAssetList(String str) {
        if (this.assets == null) {
            this.assets = new HashMap();
        }
        if (!this.assets.containsKey(str)) {
            this.assets.put(str, new ArrayList());
        }
        return this.assets.get(str);
    }

    public Map<String, ReactPack> getPacks() {
        if (this.packs == null) {
            this.packs = new HashMap();
        }
        return this.packs;
    }

    public void update(Manifest manifest) {
        this.updated_at = manifest.updated_at;
        this.packs = manifest.packs;
        this.assets_base_url = manifest.assets_base_url;
    }
}
