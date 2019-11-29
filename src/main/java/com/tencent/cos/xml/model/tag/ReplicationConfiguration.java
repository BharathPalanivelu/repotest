package com.tencent.cos.xml.model.tag;

import java.util.List;

public class ReplicationConfiguration {
    public String role;
    public List<Rule> rules;

    public String toString() {
        StringBuilder sb = new StringBuilder("{ReplicationConfiguration:\n");
        sb.append("Role:");
        sb.append(this.role);
        sb.append("\n");
        List<Rule> list = this.rules;
        if (list != null) {
            for (Rule next : list) {
                if (next != null) {
                    sb.append(next.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static class Rule {
        public Destination destination;
        public String id;
        public String prefix;
        public String status;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Rule:\n");
            sb.append("Id:");
            sb.append(this.id);
            sb.append("\n");
            sb.append("Status:");
            sb.append(this.status);
            sb.append("\n");
            sb.append("Prefix:");
            sb.append(this.prefix);
            sb.append("\n");
            Destination destination2 = this.destination;
            if (destination2 != null) {
                sb.append(destination2.toString());
                sb.append("\n");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Destination {
        public String bucket;
        public String storageClass;

        public String toString() {
            return "{Destination:\n" + "Bucket:" + this.bucket + "\n" + "StorageClass:" + this.storageClass + "\n" + "}";
        }
    }
}
