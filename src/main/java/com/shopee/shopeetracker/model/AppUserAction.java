package com.shopee.shopeetracker.model;

import com.google.a.o;

public class AppUserAction extends UserAction {
    private final o jsonObject;

    public int getType() {
        return 0;
    }

    private AppUserAction() {
        super(0);
        this.jsonObject = new o();
    }

    AppUserAction(long j, o oVar) {
        super(j);
        this.jsonObject = oVar;
    }

    public static AppUserAction create() {
        return new AppUserAction();
    }

    public AppUserAction add(String str, int i) {
        this.jsonObject.a(str, (Number) Integer.valueOf(i));
        return this;
    }

    public AppUserAction add(String str, String str2) {
        this.jsonObject.a(str, str2);
        return this;
    }

    public AppUserAction add(String str, Boolean bool) {
        this.jsonObject.a(str, bool);
        return this;
    }

    public o getJsonObject() {
        return this.jsonObject;
    }

    public String getActionData() {
        return this.jsonObject.toString();
    }
}
