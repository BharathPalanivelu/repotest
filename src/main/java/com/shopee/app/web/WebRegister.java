package com.shopee.app.web;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.share.widget.ShareDialog;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.f.e;
import com.google.a.f;
import com.google.a.o;
import com.shopee.app.react.g;
import com.shopee.app.react.protocol.DataBridgeParams;
import com.shopee.app.web.bridge.modules.NfcCommandSendingModule;
import com.shopee.app.web.bridge.modules.NfcSupportDetectingModule;
import com.shopee.app.web.processor.WebBAStatusChangedProcessor;
import com.shopee.app.web.processor.WebCancelOrderProcessor;
import com.shopee.app.web.processor.WebCreateNewCheckoutProcessor;
import com.shopee.app.web.processor.WebFollowUserUpdateProcessor;
import com.shopee.app.web.processor.WebOnArchiveReturnProcessor;
import com.shopee.app.web.processor.WebProcessor;
import com.shopee.app.web.processor.WebRateOrderProcessor;
import com.shopee.app.web.processor.WebReturnUpdateProcessor;
import com.shopee.app.web.processor.WebSplitCheckoutProcessor;
import com.shopee.app.web.processor.WebUpdateMyShopInfoProcessor;
import com.shopee.app.web.processor.WebUpdateOrderProcessor;
import com.shopee.app.web.processor.WebUpdateUserInfoProcessor;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.AddReminderMessage;
import com.shopee.app.web.protocol.BridgeMessage;
import com.shopee.app.web.protocol.CancelReminderMessage;
import com.shopee.app.web.protocol.CheckPermissionMessage;
import com.shopee.app.web.protocol.CoinAnimationMessage;
import com.shopee.app.web.protocol.ConfigureButtonMessage;
import com.shopee.app.web.protocol.ConfigureNavBarMessage;
import com.shopee.app.web.protocol.ConfigurePageMessage;
import com.shopee.app.web.protocol.ConfigureParentTabsMessage;
import com.shopee.app.web.protocol.ConfigureRightDrawerMessage;
import com.shopee.app.web.protocol.CopyTextToClipboardMessage;
import com.shopee.app.web.protocol.DataPointBridgeMessage;
import com.shopee.app.web.protocol.DeviceAutoLockMessage;
import com.shopee.app.web.protocol.DimActionBarMessage;
import com.shopee.app.web.protocol.DoCyberSourceProfileMessage;
import com.shopee.app.web.protocol.EditProductMessage;
import com.shopee.app.web.protocol.FileDownloadMessage;
import com.shopee.app.web.protocol.FullImageMessage;
import com.shopee.app.web.protocol.HasHandlerMessage;
import com.shopee.app.web.protocol.JumpMessage;
import com.shopee.app.web.protocol.LoadMessage;
import com.shopee.app.web.protocol.NavigateAppPath;
import com.shopee.app.web.protocol.NavigateAppRL;
import com.shopee.app.web.protocol.NavigateMessage;
import com.shopee.app.web.protocol.OpenEmailComposer;
import com.shopee.app.web.protocol.OpenExternalLinkMessage;
import com.shopee.app.web.protocol.OpenICCamera3Message;
import com.shopee.app.web.protocol.OpenICCameraMessage;
import com.shopee.app.web.protocol.OpenRatingImagesMessage;
import com.shopee.app.web.protocol.OpenRouteMessage;
import com.shopee.app.web.protocol.OpenYoutubeVideoMessage;
import com.shopee.app.web.protocol.OrderChatMessage;
import com.shopee.app.web.protocol.PickImageMessage;
import com.shopee.app.web.protocol.PlaceOrderMessage;
import com.shopee.app.web.protocol.PopWebViewMessage;
import com.shopee.app.web.protocol.PreloadMessage;
import com.shopee.app.web.protocol.RequestAuthCodeFromCoreAuthMessage;
import com.shopee.app.web.protocol.RequestPermissionMessage;
import com.shopee.app.web.protocol.SaveImageMessage;
import com.shopee.app.web.protocol.SaveMediaToDeviceAlbumMessage;
import com.shopee.app.web.protocol.SaveMessage;
import com.shopee.app.web.protocol.SearchConfigMessage;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.app.web.protocol.SharingDataMessage;
import com.shopee.app.web.protocol.ShowCommentMessage;
import com.shopee.app.web.protocol.ShowDropDownMessage;
import com.shopee.app.web.protocol.ShowEditProductMessage;
import com.shopee.app.web.protocol.ShowMapMessage;
import com.shopee.app.web.protocol.ShowPinPopupMessage;
import com.shopee.app.web.protocol.ShowPopUpMessage;
import com.shopee.app.web.protocol.ShowSharingPanelMessage;
import com.shopee.app.web.protocol.ShowToastMessage;
import com.shopee.app.web.protocol.ShowUserSearchMessage;
import com.shopee.app.web.protocol.StartChatMessage;
import com.shopee.app.web.protocol.StartShakeDetectionMessage;
import com.shopee.app.web.protocol.StartTraceInfo;
import com.shopee.app.web.protocol.TraceDataInfo;
import com.shopee.app.web.protocol.TraceInfo;
import com.shopee.app.web.protocol.TrackBIEventMessage;
import com.shopee.app.web.protocol.TrackEventMessage;
import com.shopee.app.web.protocol.ViewOfferMessage;
import com.shopee.app.web.protocol.notification.LoginMessage;
import com.shopee.app.web.protocol.notification.ShowActionsMessage;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;
import com.shopee.app.web.protocol.notification.UserLocationChangeMessage;
import com.shopee.app.web.protocol.notification.WebNotifyMessage;
import java.util.HashMap;

public class WebRegister {
    public static f GSON = new f();
    static HashMap<String, Class> mCommandMap = new HashMap<>();
    static HashMap<String, String> mInternalHandlerMap = new HashMap<>();
    static HashMap<String, Class> mPassMap = new HashMap<>();
    static HashMap<String, WebProcessor> mProcessorMap = new HashMap<>();

    public static void init() {
        mCommandMap.put("navigate", NavigateMessage.class);
        mCommandMap.put("startChat", StartChatMessage.class);
        mCommandMap.put("fullScreenImage", FullImageMessage.class);
        mCommandMap.put("showActionSheet", ShowActionsMessage.class);
        mCommandMap.put("login", LoginMessage.class);
        mCommandMap.put("presentAddCart", AddCartMessage.class);
        mCommandMap.put(ShareDialog.WEB_SHARE_DIALOG, ShareMessage.class);
        mCommandMap.put("jump", JumpMessage.class);
        mCommandMap.put("showItemComments", ShowCommentMessage.class);
        mCommandMap.put("popWebView", PopWebViewMessage.class);
        mCommandMap.put("configureNavBarTitle", ConfigureNavBarMessage.class);
        mCommandMap.put("viewOffer", ViewOfferMessage.class);
        mCommandMap.put("trackEvent", TrackEventMessage.class);
        mCommandMap.put("trackBIEvent", TrackBIEventMessage.class);
        mCommandMap.put("didPlaceNewOrder", PlaceOrderMessage.class);
        mCommandMap.put("getLocation", (Object) null);
        mCommandMap.put("showEditProduct", ShowEditProductMessage.class);
        mCommandMap.put("editProduct", EditProductMessage.class);
        mCommandMap.put("getNetworkInfo", (Object) null);
        mCommandMap.put("showVerifyPhone", (Object) null);
        mCommandMap.put("checkVersion", (Object) null);
        mCommandMap.put("scanBarcode", (Object) null);
        mCommandMap.put("getAppInfo", (Object) null);
        mCommandMap.put("showPopUp", ShowPopUpMessage.class);
        mCommandMap.put("showDropdownMenu", ShowDropDownMessage.class);
        mCommandMap.put("showMapPage", ShowMapMessage.class);
        mCommandMap.put("save", SaveMessage.class);
        mCommandMap.put("load", LoadMessage.class);
        mCommandMap.put("canOpenRoute", OpenRouteMessage.class);
        mCommandMap.put("hasHandler", HasHandlerMessage.class);
        mCommandMap.put("copyTextToClipboard", CopyTextToClipboardMessage.class);
        mCommandMap.put("configureButton", ConfigureButtonMessage.class);
        mCommandMap.put("configurePage", ConfigurePageMessage.class);
        mCommandMap.put("showToast", ShowToastMessage.class);
        mCommandMap.put("startOrderChat", OrderChatMessage.class);
        mCommandMap.put("pickImage", PickImageMessage.class);
        mCommandMap.put("showUserSearch", ShowUserSearchMessage.class);
        mCommandMap.put("saveImage", SaveImageMessage.class);
        mCommandMap.put("openEmailComposer", OpenEmailComposer.class);
        mCommandMap.put("navigateAppPath", NavigateAppPath.class);
        mCommandMap.put("openExternalLink", OpenExternalLinkMessage.class);
        mCommandMap.put("doCyberSourceProfile", DoCyberSourceProfileMessage.class);
        mCommandMap.put("openYoutubeVideo", OpenYoutubeVideoMessage.class);
        mCommandMap.put("configureRightDrawer", ConfigureRightDrawerMessage.class);
        mCommandMap.put("hideRightDrawer", PopWebViewMessage.class);
        mCommandMap.put("didChangeWebviewHeight", (Object) null);
        mCommandMap.put("configureSearch", SearchConfigMessage.class);
        mCommandMap.put("preload", PreloadMessage.class);
        mCommandMap.put("preload_v2", PreloadMessage.class);
        mCommandMap.put("showCoinCollectAnimation", CoinAnimationMessage.class);
        mCommandMap.put("dimNavbar", DimActionBarMessage.class);
        mCommandMap.put("showMissingBankScamPopup", MissingBankScamPopupMessage.class);
        mCommandMap.put("openRatingImages", OpenRatingImagesMessage.class);
        mCommandMap.put("isMapAvailable", (Object) null);
        mCommandMap.put("showPinPopUp", ShowPinPopupMessage.class);
        mCommandMap.put("configureParentTabs", ConfigureParentTabsMessage.class);
        mCommandMap.put("pickSystemContact", (Object) null);
        mCommandMap.put("openICCamera", OpenICCameraMessage1.class);
        mCommandMap.put("openICCamera2", OpenICCameraMessage.class);
        mCommandMap.put("openICCamera3", OpenICCamera3Message.class);
        mCommandMap.put("checkAppPermission", CheckPermissionMessage.class);
        mCommandMap.put("requestAppPermission", RequestPermissionMessage.class);
        mCommandMap.put("checkFacebookConnectionStatus", (Object) null);
        mCommandMap.put("connectAccountWithFacebook", (Object) null);
        mCommandMap.put("showSharingPanel", ShowSharingPanelMessage.class);
        mCommandMap.put("shareData", SharingDataMessage.class);
        mCommandMap.put("startDataCollection", DataPointBridgeMessage.class);
        mCommandMap.put("startShakeDetection", StartShakeDetectionMessage.class);
        mCommandMap.put("stopShakeDetection", (Object) null);
        mCommandMap.put("requestAuthCodeFromCoreAuth", RequestAuthCodeFromCoreAuthMessage.class);
        mCommandMap.put("downloadFile", FileDownloadMessage.class);
        mCommandMap.put("addReminder", AddReminderMessage.class);
        mCommandMap.put("deleteReminder", CancelReminderMessage.class);
        mCommandMap.put("getTongdunBlackbox", (Object) null);
        mCommandMap.put("putFirebaseTraceMetric", TraceDataInfo.class);
        mCommandMap.put("startFirebaseTrace", StartTraceInfo.class);
        mCommandMap.put("stopFirebaseTrace", TraceInfo.class);
        mCommandMap.put(NfcSupportDetectingModule.NAME, NfcSupportDetectingModule.Params.class);
        mCommandMap.put(NfcCommandSendingModule.NAME, NfcCommandSendingModule.Params.class);
        mCommandMap.put("getData", DataBridgeParams.class);
        mCommandMap.put("postData", DataBridgeParams.class);
        mCommandMap.put("deviceScreenAutoLock", DeviceAutoLockMessage.class);
        mCommandMap.put("saveMediaToDeviceAlbum", SaveMediaToDeviceAlbumMessage.class);
        mCommandMap.put("getDeviceInfo", (Object) null);
        mCommandMap.put("navigateAppRL", NavigateAppRL.class);
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
        mPassMap.put("notifyDidUpdateUserAddress", UserLocationChangeMessage.class);
        mPassMap.put("passDataItemShipping", UpdateItemShippingMessage.class);
        mInternalHandlerMap.put("preload_v2", "preload");
    }

    private static String getInternalHandlerName(String str) {
        return mInternalHandlerMap.containsKey(str) ? mInternalHandlerMap.get(str) : str;
    }

    public static boolean hasHandler(String str) {
        return mCommandMap.containsKey(str) || mProcessorMap.containsKey(str);
    }

    public static void routeWebCommand(String str, BridgeMessage bridgeMessage) {
        Class cls = mCommandMap.get(bridgeMessage.getHandlerName());
        WebEvent webEvent = new WebEvent();
        if (cls != null) {
            webEvent.data = GSON.a(bridgeMessage.getData(), cls);
        }
        webEvent.webPageViewId = str;
        webEvent.callbackId = bridgeMessage.getCallbackId();
        b.a(getInternalHandlerName(bridgeMessage.getHandlerName()), (a) webEvent, b.a.UI_BUS);
    }

    private static void routePassCommand(String str, BridgeMessage bridgeMessage) {
        WebNotifyMessage webNotifyMessage = (WebNotifyMessage) GSON.a(bridgeMessage.getData(), WebNotifyMessage.class);
        Class cls = mPassMap.get(webNotifyMessage.getNotifyType());
        WebEvent webEvent = new WebEvent();
        if (cls != null) {
            webEvent.data = GSON.a(bridgeMessage.getData(), cls);
        }
        webEvent.webPageViewId = str;
        webEvent.callbackId = bridgeMessage.getCallbackId();
        b.a(webNotifyMessage.getNotifyType(), (a) webEvent, b.a.UI_BUS);
    }

    public static void routeWebEvent(String str, final BridgeMessage bridgeMessage) {
        WebNotifyMessage webNotifyMessage = (WebNotifyMessage) GSON.a(bridgeMessage.getData(), WebNotifyMessage.class);
        if (mPassMap.containsKey(webNotifyMessage.getNotifyType())) {
            routePassCommand(str, bridgeMessage);
        } else {
            final WebProcessor webProcessor = mProcessorMap.get(webNotifyMessage.getNotifyType());
            if (webProcessor != null) {
                e.a().a(new Runnable() {
                    public void run() {
                        webProcessor.onProcess(bridgeMessage.getData());
                    }
                });
            }
        }
        g a2 = g.a();
        if (a2.b()) {
            ReactInstanceManager b2 = a2.e().b();
            if (b2 != null) {
                ReactContext currentReactContext = b2.getCurrentReactContext();
                if (currentReactContext != null) {
                    o oVar = new o();
                    oVar.a("type", webNotifyMessage.getNotifyType());
                    oVar.a("data", bridgeMessage.getData().toString());
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didReceiveWebEvent", oVar.toString());
                }
            }
        }
    }

    public static void notifyRNAppEvent(String str, String str2) {
        g a2 = g.a();
        if (a2.b()) {
            ReactInstanceManager b2 = a2.e().b();
            if (b2 != null) {
                ReactContext currentReactContext = b2.getCurrentReactContext();
                if (currentReactContext != null) {
                    o oVar = new o();
                    oVar.a("type", str);
                    oVar.a("data", str2);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didReceiveAppEvent", oVar.toString());
                }
            }
        }
    }
}
