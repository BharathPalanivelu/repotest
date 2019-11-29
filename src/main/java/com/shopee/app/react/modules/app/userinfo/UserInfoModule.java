package com.shopee.app.react.modules.app.userinfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;

@ReactModule(name = "GAUserInfo")
public class UserInfoModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GAUserInfo";
    private UserInfo mUserInfo = ar.f().e().loggedInUser();

    public String getName() {
        return "GAUserInfo";
    }

    @ReactMethod
    public void getUserLocation(Promise promise) {
    }

    public UserInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getUserSession(Promise promise) {
        o oVar = new o();
        oVar.a("shopee_token", this.mUserInfo.getToken());
        oVar.a("userid", String.valueOf(this.mUserInfo.getUserId()));
        oVar.a("username", this.mUserInfo.getUsername());
        oVar.a("shopid", String.valueOf(this.mUserInfo.getShopId()));
        promise.resolve(oVar.toString());
    }

    @ReactMethod
    public void isLoggedIn(Promise promise) {
        o oVar = new o();
        oVar.a("status", (Number) Integer.valueOf(this.mUserInfo.isLoggedIn() ? 1 : 0));
        promise.resolve(oVar.toString());
    }

    @ReactMethod
    public void hasPassword(Promise promise) {
        o oVar = new o();
        oVar.a("status", (Number) Integer.valueOf(this.mUserInfo.hasPassword() ? 1 : 0));
        promise.resolve(oVar.toString());
    }
}
