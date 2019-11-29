package com.shopee.app.tracking.trackingv3;

import com.google.a.o;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import d.d.b.j;
import java.util.List;

public final class c extends b {
    public void a(ViewCommon viewCommon, o oVar) {
        j.b(viewCommon, "viewCommon");
    }

    public void a(String str, o oVar) {
        j.b(str, "targetType");
        j.b(oVar, "targetData");
    }

    public void a(String str, ViewCommon viewCommon, o oVar) {
        j.b(str, "pageType");
        j.b(viewCommon, "viewCommon");
    }

    public void a(String str, String str2) {
        j.b(str, "pageType");
        j.b(str2, "targetType");
    }

    public void a(String str, String str2, o oVar, String str3) {
        j.b(str, "targetType");
        j.b(str2, "pageSection");
        j.b(oVar, "targetData");
        j.b(str3, "pageType");
    }

    public void a(String str, String str2, String str3, o oVar) {
        j.b(str, "actionName");
        j.b(str2, "targetType");
        j.b(str3, "pageSection");
        j.b(oVar, "targetData");
    }

    public void a(String str, String str2, List<o> list) {
        j.b(str, "targetType");
        j.b(str2, "pageSection");
    }

    public void b(String str, o oVar) {
        j.b(str, "actionName");
        j.b(oVar, "targetData");
    }

    public c() {
        super("", "");
    }
}
