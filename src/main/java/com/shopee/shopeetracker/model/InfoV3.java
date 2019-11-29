package com.shopee.shopeetracker.model;

import com.google.a.a.c;
import com.google.a.o;
import java.util.List;

public class InfoV3 {
    @c(a = "data")
    public Object data;
    @c(a = "operation")
    public String operation;
    @c(a = "page_section")
    public String pageSection;
    @c(a = "page_type")
    public String pageType;
    @c(a = "target_type")
    public String targetType;
    @c(a = "usage_id")
    public int usageId;

    public InfoV3(String str, String str2, String str3, String str4, int i, Object obj) {
        this.pageType = str;
        this.pageSection = str2;
        this.targetType = str3;
        this.operation = str4;
        this.usageId = i;
        this.data = obj;
    }

    public static InfoV3 click(InfoBuilder infoBuilder, o oVar) {
        return infoBuilder.build("click", oVar);
    }

    public static InfoV3 action(String str, InfoBuilder infoBuilder, o oVar) {
        return infoBuilder.build(str, oVar);
    }

    public static InfoV3 impression(InfoBuilder infoBuilder, List list) {
        return infoBuilder.build("impression", new ImpressionData(list));
    }

    public static InfoV3 view(InfoBuilder infoBuilder, ViewCommon viewCommon, o oVar) {
        return infoBuilder.build("view", oVar);
    }

    public static final class InfoBuilder {
        private Object data;
        private String operation;
        private String pageSection;
        private String pageType;
        private String targetType;
        private int usageId;

        public final InfoBuilder withPageType(String str) {
            this.pageType = str;
            return this;
        }

        public final InfoBuilder withPageSection(String str) {
            this.pageSection = str;
            return this;
        }

        public final InfoBuilder withTargetType(String str) {
            this.targetType = str;
            return this;
        }

        public final InfoBuilder withUsageId(int i) {
            this.usageId = i;
            return this;
        }

        public final InfoBuilder withOperation(String str) {
            this.operation = str;
            return this;
        }

        public final InfoBuilder withData(Object obj) {
            this.data = obj;
            return this;
        }

        public final InfoV3 build(String str, Object obj) {
            return new InfoV3(this.pageType, this.pageSection, this.targetType, str, this.usageId, obj);
        }

        public final InfoV3 build() {
            return new InfoV3(this.pageType, this.pageSection, this.targetType, this.operation, this.usageId, this.data);
        }

        private InfoBuilder() {
            this.usageId = 0;
            this.pageType = "";
            this.pageSection = "";
            this.targetType = "";
            this.operation = "";
            this.data = "";
            this.usageId = 0;
        }

        public static InfoBuilder getInstance() {
            return new InfoBuilder();
        }
    }
}
