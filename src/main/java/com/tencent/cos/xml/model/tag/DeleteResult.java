package com.tencent.cos.xml.model.tag;

import java.util.List;

public class DeleteResult {
    public List<Deleted> deletedList;
    public List<Error> errorList;

    public String toString() {
        StringBuilder sb = new StringBuilder("{DeleteResult:\n");
        List<Deleted> list = this.deletedList;
        if (list != null) {
            for (Deleted next : list) {
                if (next != null) {
                    sb.append(next.toString());
                    sb.append("\n");
                }
            }
        }
        List<Error> list2 = this.errorList;
        if (list2 != null) {
            for (Error next2 : list2) {
                if (next2 != null) {
                    sb.append(next2.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static class Deleted {
        public boolean deleteMarker;
        public String deleteMarkerVersionId;
        public String key;
        public String versionId;

        public String toString() {
            return "{Deleted:\n" + "Key:" + this.key + "\n" + "VersionId:" + this.versionId + "\n" + "DeleteMarker:" + this.deleteMarker + "\n" + "DeleteMarkerVersionId:" + this.deleteMarkerVersionId + "\n" + "}";
        }
    }

    public static class Error {
        public String code;
        public String key;
        public String message;
        public String versionId;

        public String toString() {
            return "{CosError:\n" + "Key:" + this.key + "\n" + "Code:" + this.code + "\n" + "Message:" + this.message + "\n" + "VersionId:" + this.versionId + "\n" + "}";
        }
    }
}
