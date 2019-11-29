package com.shopee.app.data.store.setting;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class SalesforceConfigs {
    private final String LiveAgentPod;
    private final String buttonId;
    private final String deploymentId;
    private final String orgId;

    public static /* synthetic */ SalesforceConfigs copy$default(SalesforceConfigs salesforceConfigs, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = salesforceConfigs.orgId;
        }
        if ((i & 2) != 0) {
            str2 = salesforceConfigs.deploymentId;
        }
        if ((i & 4) != 0) {
            str3 = salesforceConfigs.buttonId;
        }
        if ((i & 8) != 0) {
            str4 = salesforceConfigs.LiveAgentPod;
        }
        return salesforceConfigs.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.orgId;
    }

    public final String component2() {
        return this.deploymentId;
    }

    public final String component3() {
        return this.buttonId;
    }

    public final String component4() {
        return this.LiveAgentPod;
    }

    public final SalesforceConfigs copy(String str, String str2, String str3, String str4) {
        return new SalesforceConfigs(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SalesforceConfigs)) {
            return false;
        }
        SalesforceConfigs salesforceConfigs = (SalesforceConfigs) obj;
        return j.a((Object) this.orgId, (Object) salesforceConfigs.orgId) && j.a((Object) this.deploymentId, (Object) salesforceConfigs.deploymentId) && j.a((Object) this.buttonId, (Object) salesforceConfigs.buttonId) && j.a((Object) this.LiveAgentPod, (Object) salesforceConfigs.LiveAgentPod);
    }

    public int hashCode() {
        String str = this.orgId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deploymentId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.buttonId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.LiveAgentPod;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SalesforceConfigs(orgId=" + this.orgId + ", deploymentId=" + this.deploymentId + ", buttonId=" + this.buttonId + ", LiveAgentPod=" + this.LiveAgentPod + SQLBuilder.PARENTHESES_RIGHT;
    }

    public SalesforceConfigs(String str, String str2, String str3, String str4) {
        this.orgId = str;
        this.deploymentId = str2;
        this.buttonId = str3;
        this.LiveAgentPod = str4;
    }

    public final String getOrgId() {
        return this.orgId;
    }

    public final String getDeploymentId() {
        return this.deploymentId;
    }

    public final String getButtonId() {
        return this.buttonId;
    }

    public final String getLiveAgentPod() {
        return this.LiveAgentPod;
    }
}
