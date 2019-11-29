package com.garena.reactpush.data;

public class ReactAsset {
    private String file;
    private String md5;

    public String getPath() {
        return this.file;
    }

    public String getMd5() {
        return this.md5;
    }

    public void update(ReactAsset reactAsset) {
        this.file = reactAsset.file;
        this.md5 = reactAsset.md5;
    }

    public String getDownloadPath(String str) {
        if ("strings".equals(str)) {
            return this.md5;
        }
        return this.file;
    }
}
