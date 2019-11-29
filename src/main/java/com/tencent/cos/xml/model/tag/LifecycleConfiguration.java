package com.tencent.cos.xml.model.tag;

import java.util.List;

public class LifecycleConfiguration {
    public List<Rule> rules;

    public String toString() {
        StringBuilder sb = new StringBuilder("{LifecycleConfiguration:\n");
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
        public AbortIncompleteMultiUpload abortIncompleteMultiUpload;
        public Expiration expiration;
        public Filter filter;
        public String id;
        public NoncurrentVersionExpiration noncurrentVersionExpiration;
        public NoncurrentVersionTransition noncurrentVersionTransition;
        public String status;
        public Transition transition;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Rule:\n");
            sb.append("Id:");
            sb.append(this.id);
            sb.append("\n");
            Filter filter2 = this.filter;
            if (filter2 != null) {
                sb.append(filter2.toString());
                sb.append("\n");
            }
            sb.append("Status:");
            sb.append(this.status);
            sb.append("\n");
            Transition transition2 = this.transition;
            if (transition2 != null) {
                sb.append(transition2.toString());
                sb.append("\n");
            }
            Expiration expiration2 = this.expiration;
            if (expiration2 != null) {
                sb.append(expiration2.toString());
                sb.append("\n");
            }
            NoncurrentVersionExpiration noncurrentVersionExpiration2 = this.noncurrentVersionExpiration;
            if (noncurrentVersionExpiration2 != null) {
                sb.append(noncurrentVersionExpiration2.toString());
                sb.append("\n");
            }
            NoncurrentVersionTransition noncurrentVersionTransition2 = this.noncurrentVersionTransition;
            if (noncurrentVersionTransition2 != null) {
                sb.append(noncurrentVersionTransition2.toString());
                sb.append("\n");
            }
            AbortIncompleteMultiUpload abortIncompleteMultiUpload2 = this.abortIncompleteMultiUpload;
            if (abortIncompleteMultiUpload2 != null) {
                sb.append(abortIncompleteMultiUpload2.toString());
                sb.append("\n");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Filter {
        public String prefix;

        public String toString() {
            return "{Filter:\n" + "Prefix:" + this.prefix + "\n" + "}";
        }
    }

    public static class Transition {
        public String date;
        public int days;
        public String storageClass;

        public String toString() {
            return "{Transition:\n" + "Days:" + this.days + "\n" + "Date:" + this.date + "\n" + "StorageClass:" + this.storageClass + "\n" + "}";
        }
    }

    public static class Expiration {
        public String date;
        public int days;
        public String expiredObjectDeleteMarker;

        public String toString() {
            return "{Expiration:\n" + "Days:" + this.days + "\n" + "Date:" + this.date + "\n" + "ExpiredObjectDeleteMarker:" + this.expiredObjectDeleteMarker + "\n" + "}";
        }
    }

    public static class NoncurrentVersionExpiration {
        public int noncurrentDays;

        public String toString() {
            return "{NoncurrentVersionExpiration:\n" + "NoncurrentDays:" + this.noncurrentDays + "\n" + "}";
        }
    }

    public static class NoncurrentVersionTransition {
        public int noncurrentDays;
        public String storageClass;

        public String toString() {
            return "{NoncurrentVersionTransition:\n" + "NoncurrentDays:" + this.noncurrentDays + "\n" + "StorageClass:" + this.storageClass + "\n" + "}";
        }
    }

    public static class AbortIncompleteMultiUpload {
        public int daysAfterInitiation;

        public String toString() {
            return "{AbortIncompleteMultiUpload:\n" + "DaysAfterInitiation:" + this.daysAfterInitiation + "\n" + "}";
        }
    }
}
