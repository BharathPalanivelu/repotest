package com.tencent.cos.xml.model.tag;

import java.util.List;

public class ListAllMyBuckets {
    public List<Bucket> buckets;
    public Owner owner;

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListAllMyBuckets:\n");
        Owner owner2 = this.owner;
        if (owner2 != null) {
            sb.append(owner2.toString());
            sb.append("\n");
        }
        sb.append("Buckets:\n");
        for (Bucket next : this.buckets) {
            if (next != null) {
                sb.append(next.toString());
                sb.append("\n");
            }
        }
        sb.append("}");
        sb.append("\n");
        sb.append("}");
        return sb.toString();
    }

    public static class Owner {
        public String disPlayName;
        public String id;

        public String toString() {
            return "{Owner:\n" + "ID:" + this.id + "\n" + "DisPlayName:" + this.disPlayName + "\n" + "}";
        }
    }

    public static class Bucket {
        public String createDate;
        public String location;
        public String name;

        public String toString() {
            return "{Bucket:\n" + "Name:" + this.name + "\n" + "Location:" + this.location + "\n" + "CreateDate:" + this.createDate + "\n" + "}";
        }
    }
}
