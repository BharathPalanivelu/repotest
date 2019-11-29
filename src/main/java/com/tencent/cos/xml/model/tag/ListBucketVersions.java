package com.tencent.cos.xml.model.tag;

import java.util.List;

public class ListBucketVersions {
    public boolean isTruncated;
    public String keyMarker;
    public long maxKeys;
    public String name;
    public String nextKeyMarker;
    public String nextVersionIdMarker;
    public List<ObjectVersion> objectVersionList;
    public String prefix;
    public String versionIdMarker;

    public static class ObjectVersion {
        public boolean isLatest;
        public String key;
        public String lastModified;
        public Owner owner;
        public String versionId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListVersionsResult:\n");
        sb.append("Name:");
        sb.append(this.name);
        sb.append("\n");
        sb.append("Prefix:");
        sb.append(this.prefix);
        sb.append("\n");
        sb.append("KeyMarker:");
        sb.append(this.keyMarker);
        sb.append("\n");
        sb.append("VersionIdMarker:");
        sb.append(this.versionIdMarker);
        sb.append("\n");
        sb.append("MaxKeys:");
        sb.append(this.maxKeys);
        sb.append("\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        sb.append("NextKeyMarker:");
        sb.append(this.nextKeyMarker);
        sb.append("\n");
        sb.append("NextVersionIdMarker:");
        sb.append(this.nextVersionIdMarker);
        sb.append("\n");
        List<ObjectVersion> list = this.objectVersionList;
        if (list != null) {
            for (ObjectVersion obj : list) {
                sb.append(obj.toString());
                sb.append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static class DeleteMarker extends ObjectVersion {
        public String toString() {
            StringBuilder sb = new StringBuilder("{DeleteMarker:\n");
            sb.append("Key:");
            sb.append(this.key);
            sb.append("\n");
            sb.append("VersionId:");
            sb.append(this.versionId);
            sb.append("\n");
            sb.append("IsLatest:");
            sb.append(this.isLatest);
            sb.append("\n");
            sb.append("LastModified:");
            sb.append(this.lastModified);
            sb.append("\n");
            if (this.owner != null) {
                sb.append(this.owner.toString());
                sb.append("\n");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Owner {
        public String uid;

        public String toString() {
            return "{Owner:\n" + "Uid:" + this.uid + "\n" + "}";
        }
    }

    public static class Version extends ObjectVersion {
        public String eTag;
        public long size;
        public String storageClass;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Version:\n");
            sb.append("Key:");
            sb.append(this.key);
            sb.append("\n");
            sb.append("VersionId:");
            sb.append(this.versionId);
            sb.append("\n");
            sb.append("IsLatest:");
            sb.append(this.isLatest);
            sb.append("\n");
            sb.append("LastModified:");
            sb.append(this.lastModified);
            sb.append("\n");
            sb.append("ETag:");
            sb.append(this.eTag);
            sb.append("\n");
            sb.append("Size:");
            sb.append(this.size);
            sb.append("\n");
            sb.append("StorageClass:");
            sb.append(this.storageClass);
            sb.append("\n");
            if (this.owner != null) {
                sb.append(this.owner.toString());
                sb.append("\n");
            }
            sb.append("}");
            return sb.toString();
        }
    }
}
