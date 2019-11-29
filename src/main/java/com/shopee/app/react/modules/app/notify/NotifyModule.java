package com.shopee.app.react.modules.app.notify;

import android.text.TextUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.l;
import com.shopee.app.react.f.a;
import com.shopee.app.react.f.b;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.processor.WebBAStatusChangedProcessor;
import com.shopee.app.web.processor.WebCancelOrderProcessor;
import com.shopee.app.web.processor.WebCreateNewCheckoutProcessor;
import com.shopee.app.web.processor.WebFollowUserUpdateProcessor;
import com.shopee.app.web.processor.WebOnArchiveReturnProcessor;
import com.shopee.app.web.processor.WebPassDataItemShippingProcessor;
import com.shopee.app.web.processor.WebProcessor;
import com.shopee.app.web.processor.WebRateOrderProcessor;
import com.shopee.app.web.processor.WebReturnUpdateProcessor;
import com.shopee.app.web.processor.WebSplitCheckoutProcessor;
import com.shopee.app.web.processor.WebUpdateMyShopInfoProcessor;
import com.shopee.app.web.processor.WebUpdateOrderProcessor;
import com.shopee.app.web.processor.WebUpdateUserAddressProcessor;
import com.shopee.app.web.processor.WebUpdateUserInfoProcessor;
import com.shopee.app.web.protocol.notification.WebNotifyMessage;
import java.util.HashMap;

@ReactModule(name = "GANotify")
public class NotifyModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GANotify";
    private static HashMap<String, WebProcessor> mProcessorMap = new HashMap<>();

    public String getName() {
        return "GANotify";
    }

    public NotifyModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        mProcessorMap.put("notifyReturnUpdate", new WebReturnUpdateProcessor());
        mProcessorMap.put("notifyFollowUserUpdate", new WebFollowUserUpdateProcessor());
        mProcessorMap.put("notifyDidCancelOrder", new WebCancelOrderProcessor());
        mProcessorMap.put("notifyDidUpdateOrder", new WebUpdateOrderProcessor());
        mProcessorMap.put("notifyDidRateOrder", new WebRateOrderProcessor());
        mProcessorMap.put("notifyDidArchiveReturn", new WebOnArchiveReturnProcessor());
        mProcessorMap.put("notifyDidSplitCheckout", new WebSplitCheckoutProcessor());
        mProcessorMap.put("notifyDidUpdateUserInfo", new WebUpdateUserInfoProcessor());
        mProcessorMap.put("notifyDidUpdateShopInfo", new WebUpdateMyShopInfoProcessor());
        mProcessorMap.put("notifyDidCreateNewCheckout", new WebCreateNewCheckoutProcessor());
        mProcessorMap.put("notifyUserBAStatusChanged", new WebBAStatusChangedProcessor());
        mProcessorMap.put("notifyDidUpdateUserAddress", new WebUpdateUserAddressProcessor());
        mProcessorMap.put("passDataItemShipping", new WebPassDataItemShippingProcessor());
        mProcessorMap.put("notifyPageDidMount", new b());
        mProcessorMap.put("notifyDidUpdateMeFeedsPage", new a());
    }

    @ReactMethod
    public void notifyAppEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.garena.android.appkit.d.a.b("[GANotify]" + str, new Object[0]);
            try {
                WebNotifyMessage webNotifyMessage = (WebNotifyMessage) WebRegister.GSON.a(str, WebNotifyMessage.class);
                if (webNotifyMessage != null) {
                    WebProcessor webProcessor = mProcessorMap.get(webNotifyMessage.getNotifyType());
                    if (webProcessor != null) {
                        webProcessor.process((l) WebRegister.GSON.a(str, l.class));
                    }
                }
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }
}
