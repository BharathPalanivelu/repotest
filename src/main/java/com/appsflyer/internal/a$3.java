package com.appsflyer.internal;

import com.facebook.appevents.AppEventsConstants;
import com.shopee.feeds.feedlibrary.data.entity.BaseUploadEntity;
import java.util.HashMap;

class a$3 extends HashMap<String, String> {

    /* renamed from: ˏ$5b41b7af  reason: contains not printable characters */
    private /* synthetic */ Object f116$5b41b7af;

    public a$3(Object obj) {
        this.f116$5b41b7af = obj;
        put(AppEventsConstants.EVENT_PARAM_VALUE_NO, "ro.arch");
        put("1", "ro.chipname");
        put("2", "ro.dalvik.vm.native.bridge");
        put("3", "persist.sys.nativebridge");
        put("4", "ro.enable.native.bridge.exec");
        put(BaseUploadEntity.TYPE_COMMENT_STICKER, "dalvik.vm.isa.x86.features");
        put(BaseUploadEntity.TYPE_VOUCHER_STICKER, "dalvik.vm.isa.x86.variant");
        put(BaseUploadEntity.TYPE_INPUT_TEXT, "ro.zygote");
        put(BaseUploadEntity.TYPE_RATE_STICKER, "ro.allow.mock.location");
        put("9", "ro.dalvik.vm.isa.arm");
        put("10", "dalvik.vm.isa.arm.features");
        put("11", "dalvik.vm.isa.arm.variant");
        put("12", "dalvik.vm.isa.arm64.features");
        put("13", "dalvik.vm.isa.arm64.variant");
        put("14", "vzw.os.rooted");
        put("15", "ro.build.user");
        put("16", "ro.kernel.qemu");
        put("17", "ro.hardware");
        put("18", "ro.product.cpu.abi");
        put("19", "ro.product.cpu.abilist");
        put("20", "ro.product.cpu.abilist32");
        put("21", "ro.product.cpu.abilist64");
    }
}
