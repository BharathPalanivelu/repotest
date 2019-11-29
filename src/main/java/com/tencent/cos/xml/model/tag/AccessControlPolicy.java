package com.tencent.cos.xml.model.tag;

import java.util.List;

public class AccessControlPolicy {
    public AccessControlList accessControlList;
    public Owner owner;

    public String toString() {
        StringBuilder sb = new StringBuilder("{AccessControlPolicy:\n");
        Owner owner2 = this.owner;
        if (owner2 != null) {
            sb.append(owner2.toString());
            sb.append("\n");
        }
        AccessControlList accessControlList2 = this.accessControlList;
        if (accessControlList2 != null) {
            sb.append(accessControlList2.toString());
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public static class Owner {
        public String displayName;
        public String id;

        public String toString() {
            return "{Owner:\n" + "Id:" + this.id + "\n" + "DisplayName:" + this.displayName + "\n" + "}";
        }
    }

    public static class AccessControlList {
        public List<Grant> grants;

        public String toString() {
            StringBuilder sb = new StringBuilder("{AccessControlList:\n");
            List<Grant> list = this.grants;
            if (list != null) {
                for (Grant next : list) {
                    if (next != null) {
                        sb.append(next.toString());
                        sb.append("\n");
                    }
                }
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Grant {
        public Grantee grantee;
        public String permission;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Grant:\n");
            Grantee grantee2 = this.grantee;
            if (grantee2 != null) {
                sb.append(grantee2.toString());
                sb.append("\n");
            }
            sb.append("Permission:");
            sb.append(this.permission);
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Grantee {
        public String displayName;
        public String id;

        public String toString() {
            return "{Grantee:\n" + "Id:" + this.id + "\n" + "DisplayName:" + this.displayName + "\n" + "}";
        }
    }
}
