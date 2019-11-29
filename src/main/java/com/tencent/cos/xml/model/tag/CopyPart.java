package com.tencent.cos.xml.model.tag;

public class CopyPart {
    public String eTag;
    public String lastModified;

    public String toString() {
        return "{CopyPart:\n" + "ETag:" + this.eTag + "\n" + "LastModified:" + this.lastModified + "\n" + "}";
    }
}
