package com.shopee.app.tracking.trackingv3.model;

import com.google.a.a.c;
import com.google.a.o;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.web.WebRegister;
import d.d.b.j;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public final class Info {
    public static final String CLICK = "click";
    public static final Companion Companion = new Companion((g) null);
    public static final String IMPRESSION = "impression";
    public static final String VIEW = "view";
    @c(a = "data")
    private final Object data;
    @c(a = "operation")
    private final String operation;
    @c(a = "page_section")
    private final String pageSection;
    @c(a = "page_type")
    private final String pageType;
    @c(a = "target_type")
    private final String targetType;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Operation {
    }

    private Info(String str, String str2, String str3, String str4, Object obj) {
        this.pageType = str;
        this.pageSection = str2;
        this.targetType = str3;
        this.operation = str4;
        this.data = obj;
    }

    public /* synthetic */ Info(String str, String str2, String str3, String str4, Object obj, g gVar) {
        this(str, str2, str3, str4, obj);
    }

    public static final class InfoBuilder {
        public static final Companion Companion = new Companion((g) null);
        private Object data;
        private String operation;
        private String pageSection;
        private String pageType;
        private String targetType;

        public static final InfoBuilder builder() {
            return Companion.builder();
        }

        private InfoBuilder() {
            this.pageType = "";
            this.pageSection = "";
            this.targetType = "";
            this.data = "";
            this.operation = "";
        }

        public /* synthetic */ InfoBuilder(g gVar) {
            this();
        }

        public final String getPageType() {
            return this.pageType;
        }

        public final void setPageType(String str) {
            this.pageType = str;
        }

        public final String getPageSection() {
            return this.pageSection;
        }

        public final void setPageSection(String str) {
            this.pageSection = str;
        }

        public final String getTargetType() {
            return this.targetType;
        }

        public final void setTargetType(String str) {
            this.targetType = str;
        }

        public final Object getData() {
            return this.data;
        }

        public final void setData(Object obj) {
            this.data = obj;
        }

        public final String getOperation() {
            return this.operation;
        }

        public final void setOperation(String str) {
            j.b(str, "<set-?>");
            this.operation = str;
        }

        public final InfoBuilder withPageType(String str) {
            j.b(str, "pageType");
            this.pageType = str;
            return this;
        }

        public final InfoBuilder withPageSection(String str) {
            j.b(str, "pageSection");
            this.pageSection = str;
            return this;
        }

        public final InfoBuilder withTargetType(String str) {
            j.b(str, "targetType");
            this.targetType = str;
            return this;
        }

        public final InfoBuilder withOperation(String str) {
            j.b(str, "operation");
            this.operation = str;
            return this;
        }

        public final InfoBuilder withData(Object obj) {
            this.data = obj;
            return this;
        }

        public final Info build() {
            return new Info(this.pageType, this.pageSection, this.targetType, this.operation, this.data, (g) null);
        }

        public final Info build$app_indonesiaRelease(String str, Object obj) {
            j.b(str, "operation");
            return new Info(this.pageType, this.pageSection, this.targetType, str, obj, (g) null);
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final InfoBuilder builder() {
                return new InfoBuilder((g) null);
            }
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Info click(InfoBuilder infoBuilder, o oVar) {
            j.b(infoBuilder, "builder");
            return infoBuilder.build$app_indonesiaRelease("click", oVar);
        }

        public final Info action(String str, InfoBuilder infoBuilder, o oVar) {
            j.b(str, "actionName");
            j.b(infoBuilder, "builder");
            j.b(oVar, "data");
            return infoBuilder.build$app_indonesiaRelease(str, oVar);
        }

        public final Info impression(InfoBuilder infoBuilder, List<o> list) {
            j.b(infoBuilder, "builder");
            j.b(list, "viewedObjects");
            return infoBuilder.build$app_indonesiaRelease("impression", new ImpressionData(list));
        }

        public final Info view(InfoBuilder infoBuilder, ViewCommon viewCommon, o oVar) {
            j.b(infoBuilder, "builder");
            j.b(viewCommon, "viewCommon");
            if (oVar == null || j.a((Object) oVar, (Object) b.f19172a)) {
                oVar = new o();
            }
            oVar.a("view_common", WebRegister.GSON.a((Object) viewCommon));
            return infoBuilder.build$app_indonesiaRelease("view", oVar);
        }
    }
}
