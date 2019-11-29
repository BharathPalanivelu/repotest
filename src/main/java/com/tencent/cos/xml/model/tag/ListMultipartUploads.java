package com.tencent.cos.xml.model.tag;

import java.util.List;

public class ListMultipartUploads {
    public String bucket;
    public List<CommonPrefixes> commonPrefixes;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String keyMarker;
    public String maxUploads;
    public String nextKeyMarker;
    public String nextUploadIdMarker;
    public String prefix;
    public String uploadIdMarker;
    public List<Upload> uploads;

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListMultipartUploads:\n");
        sb.append("Bucket:");
        sb.append(this.bucket);
        sb.append("\n");
        sb.append("Encoding-Type:");
        sb.append(this.encodingType);
        sb.append("\n");
        sb.append("KeyMarker:");
        sb.append(this.keyMarker);
        sb.append("\n");
        sb.append("UploadIdMarker:");
        sb.append(this.uploadIdMarker);
        sb.append("\n");
        sb.append("NextKeyMarker:");
        sb.append(this.nextKeyMarker);
        sb.append("\n");
        sb.append("NextUploadIdMarker:");
        sb.append(this.nextUploadIdMarker);
        sb.append("\n");
        sb.append("MaxUploads:");
        sb.append(this.maxUploads);
        sb.append("\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        sb.append("Prefix:");
        sb.append(this.prefix);
        sb.append("\n");
        sb.append("Delimiter:");
        sb.append(this.delimiter);
        sb.append("\n");
        List<Upload> list = this.uploads;
        if (list != null) {
            for (Upload next : list) {
                if (next != null) {
                    sb.append(next.toString());
                    sb.append("\n");
                }
            }
        }
        List<CommonPrefixes> list2 = this.commonPrefixes;
        if (list2 != null) {
            for (CommonPrefixes next2 : list2) {
                if (next2 != null) {
                    sb.append(next2.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static class Upload {
        public String initiated;
        public Initiator initiator;
        public String key;
        public Owner owner;
        public String storageClass;
        public String uploadID;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Upload:\n");
            sb.append("Key:");
            sb.append(this.key);
            sb.append("\n");
            sb.append("UploadID:");
            sb.append(this.uploadID);
            sb.append("\n");
            sb.append("StorageClass:");
            sb.append(this.storageClass);
            sb.append("\n");
            Initiator initiator2 = this.initiator;
            if (initiator2 != null) {
                sb.append(initiator2.toString());
                sb.append("\n");
            }
            Owner owner2 = this.owner;
            if (owner2 != null) {
                sb.append(owner2.toString());
                sb.append("\n");
            }
            sb.append("Initiated:");
            sb.append(this.initiated);
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public static class CommonPrefixes {
        public String prefix;

        public String toString() {
            return "{CommonPrefixes:\n" + "Prefix:" + this.prefix + "\n" + "}";
        }
    }

    public static class Initiator {
        public String displayName;
        public String id;
        public String uin;

        public String toString() {
            return "{Initiator:\n" + "Uin:" + this.uin + "\n" + "Id:" + this.id + "\n" + "DisplayName:" + this.displayName + "\n" + "}";
        }
    }

    public static class Owner {
        public String displayName;
        public String id;
        public String uid;

        public String toString() {
            return "{Owner:\n" + "Uid:" + this.uid + "\n" + "Id:" + this.id + "\n" + "DisplayName:" + this.displayName + "\n" + "}";
        }
    }
}
