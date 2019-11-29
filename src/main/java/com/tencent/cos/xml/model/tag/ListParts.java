package com.tencent.cos.xml.model.tag;

import java.util.List;

public class ListParts {
    public String bucket;
    public String encodingType;
    public Initiator initiator;
    public boolean isTruncated;
    public String key;
    public String maxParts;
    public String nextPartNumberMarker;
    public Owner owner;
    public String partNumberMarker;
    public List<Part> parts;
    public String storageClass;
    public String uploadId;

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListParts:\n");
        sb.append("Bucket:");
        sb.append(this.bucket);
        sb.append("\n");
        sb.append("Encoding-Type:");
        sb.append(this.encodingType);
        sb.append("\n");
        sb.append("Key:");
        sb.append(this.key);
        sb.append("\n");
        sb.append("UploadId:");
        sb.append(this.uploadId);
        sb.append("\n");
        Owner owner2 = this.owner;
        if (owner2 != null) {
            sb.append(owner2.toString());
            sb.append("\n");
        }
        sb.append("PartNumberMarker:");
        sb.append(this.partNumberMarker);
        sb.append("\n");
        Initiator initiator2 = this.initiator;
        if (initiator2 != null) {
            sb.append(initiator2.toString());
            sb.append("\n");
        }
        sb.append("StorageClass:");
        sb.append(this.storageClass);
        sb.append("\n");
        sb.append("NextPartNumberMarker:");
        sb.append(this.nextPartNumberMarker);
        sb.append("\n");
        sb.append("MaxParts:");
        sb.append(this.maxParts);
        sb.append("\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        List<Part> list = this.parts;
        if (list != null) {
            for (Part next : list) {
                if (next != null) {
                    sb.append(next.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static class Owner {
        public String disPlayName;
        public String id;

        public String toString() {
            return "{Owner:\n" + "Id:" + this.id + "\n" + "DisPlayName:" + this.disPlayName + "\n" + "}";
        }
    }

    public static class Initiator {
        public String disPlayName;
        public String id;

        public String toString() {
            return "{Initiator:\n" + "Id:" + this.id + "\n" + "DisPlayName:" + this.disPlayName + "\n" + "}";
        }
    }

    public static class Part {
        public String eTag;
        public String lastModified;
        public String partNumber;
        public String size;

        public String toString() {
            return "{Part:\n" + "PartNumber:" + this.partNumber + "\n" + "LastModified:" + this.lastModified + "\n" + "ETag:" + this.eTag + "\n" + "Size:" + this.size + "\n" + "}";
        }
    }
}
