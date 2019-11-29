package com.tencent.cos.xml.model.tag;

public class CompleteMultipartUploadResult {
    public String bucket;
    public String eTag;
    public String key;
    public String location;

    public String toString() {
        return "{CompleteMultipartUploadResult:\n" + "Location:" + this.location + "\n" + "Bucket:" + this.bucket + "\n" + "Key:" + this.key + "\n" + "ETag:" + this.eTag + "\n" + "}";
    }
}
