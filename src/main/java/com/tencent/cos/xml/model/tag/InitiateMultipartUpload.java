package com.tencent.cos.xml.model.tag;

public class InitiateMultipartUpload {
    public String bucket;
    public String key;
    public String uploadId;

    public String toString() {
        return "{InitiateMultipartUpload:\n" + "Bucket:" + this.bucket + "\n" + "Key:" + this.key + "\n" + "UploadId:" + this.uploadId + "\n" + "}";
    }
}
