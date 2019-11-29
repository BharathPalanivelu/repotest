package com.tencent.cos.xml.model.tag;

public class CopyObject {
    public String eTag;
    public String lastModified;

    public String toString() {
        return "{CopyObject:\n" + "ETag:" + this.eTag + "\n" + "LastModified:" + this.lastModified + "\n" + "}";
    }
}
