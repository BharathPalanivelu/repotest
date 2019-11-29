package com.shopee.app.web;

import android.graphics.Rect;
import android.webkit.JavascriptInterface;
import com.facebook.internal.ServerProtocol;
import com.garena.android.appkit.d.a;
import com.shopee.app.web.protocol.BridgeMessage;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class JavascriptHandler {
    private boolean enabled = true;
    private boolean hasInput = false;
    private HashSet<String> mExistingHandlers = new HashSet<>();
    private String mWebPageViewId;
    private ConcurrentLinkedQueue<Rect> swipeableRects = new ConcurrentLinkedQueue<>();

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public JavascriptHandler(String str) {
        this.mWebPageViewId = str;
    }

    @JavascriptInterface
    public void sendMsg(String str) {
        try {
            BridgeMessage bridgeMessage = (BridgeMessage) WebRegister.GSON.a(str, BridgeMessage.class);
            a.b("BRIDGE_CMD: %s", bridgeMessage.getHandlerName());
            if (bridgeMessage.getHandlerName().equals("webNotify")) {
                WebRegister.routeWebEvent(this.mWebPageViewId, bridgeMessage);
                return;
            }
            com.shopee.app.util.h.a.b(str);
            WebRegister.routeWebCommand(this.mWebPageViewId, bridgeMessage);
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void onHasHandler(String str, String str2) {
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str2)) {
            this.mExistingHandlers.add(str);
        } else {
            this.mExistingHandlers.remove(str);
        }
    }

    @JavascriptInterface
    public void onHasInput(String str) {
        this.hasInput = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str);
    }

    @JavascriptInterface
    public void onAddSwipeableRect(int i, int i2, int i3, int i4) {
        this.swipeableRects.add(new Rect(i, i2, i3, i4));
    }

    public boolean supportsSearch() {
        return this.enabled && this.mExistingHandlers.contains("search");
    }

    public boolean hasDidTapBackHandler() {
        return this.enabled && this.mExistingHandlers.contains("didTapBack");
    }

    public boolean hasGaTap() {
        return this.enabled && this.mExistingHandlers.contains("_gatap_");
    }

    public boolean hasInput() {
        return this.enabled && this.hasInput;
    }

    public ConcurrentLinkedQueue<Rect> getSwipeableRects() {
        return this.swipeableRects;
    }
}
