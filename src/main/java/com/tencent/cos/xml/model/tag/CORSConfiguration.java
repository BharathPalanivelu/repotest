package com.tencent.cos.xml.model.tag;

import java.util.List;

public class CORSConfiguration {
    public List<CORSRule> corsRules;

    public String toString() {
        StringBuilder sb = new StringBuilder("{CORSConfiguration:\n");
        List<CORSRule> list = this.corsRules;
        if (list != null) {
            for (CORSRule next : list) {
                if (next != null) {
                    sb.append(next.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static class CORSRule {
        public List<String> allowedHeader;
        public List<String> allowedMethod;
        public String allowedOrigin;
        public List<String> exposeHeader;
        public String id;
        public int maxAgeSeconds;

        public String toString() {
            StringBuilder sb = new StringBuilder("{CORSRule:\n");
            sb.append("ID:");
            sb.append(this.id);
            sb.append("\n");
            sb.append("AllowedOrigin:");
            sb.append(this.allowedOrigin);
            sb.append("\n");
            List<String> list = this.allowedMethod;
            if (list != null) {
                for (String next : list) {
                    if (next != null) {
                        sb.append("AllowedMethod:");
                        sb.append(next);
                        sb.append("\n");
                    }
                }
            }
            List<String> list2 = this.allowedHeader;
            if (list2 != null) {
                for (String next2 : list2) {
                    if (next2 != null) {
                        sb.append("AllowedHeader:");
                        sb.append(next2);
                        sb.append("\n");
                    }
                }
            }
            List<String> list3 = this.exposeHeader;
            if (list3 != null) {
                for (String next3 : list3) {
                    if (next3 != null) {
                        sb.append("ExposeHeader:");
                        sb.append(next3);
                        sb.append("\n");
                    }
                }
            }
            sb.append("MaxAgeSeconds:");
            sb.append(this.maxAgeSeconds);
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }
    }
}
