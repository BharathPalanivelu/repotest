package com.tencent.cos.xml.model.tag;

public class RestoreConfigure {
    public CASJobParameters casJobParameters;
    public int days;

    public String toString() {
        StringBuilder sb = new StringBuilder("{RestoreRequest:\n");
        sb.append("Days:");
        sb.append(this.days);
        sb.append("\n");
        CASJobParameters cASJobParameters = this.casJobParameters;
        if (cASJobParameters != null) {
            sb.append(cASJobParameters.toString());
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public static class CASJobParameters {
        public String tier = Tier.Standard.getTier();

        public String toString() {
            return "{CASJobParameters:\n" + "Tier:" + this.tier + "\n" + "}";
        }
    }

    public enum Tier {
        Expedited("Expedited"),
        Standard("Standard"),
        Bulk("Bulk");
        
        private String tier;

        private Tier(String str) {
            this.tier = str;
        }

        public String getTier() {
            return this.tier;
        }
    }
}
