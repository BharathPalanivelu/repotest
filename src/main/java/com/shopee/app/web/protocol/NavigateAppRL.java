package com.shopee.app.web.protocol;

import com.google.a.o;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;

public class NavigateAppRL {
    private String apprl;
    private o params;

    public String getAppRL() {
        return this.apprl;
    }

    public o getParams() {
        return this.params;
    }

    public String getParamAsString() {
        o oVar = this.params;
        return oVar != null ? oVar.toString() : ServiceLogger.PLACEHOLDER;
    }
}
