package com.facebook.react.packagerconnection;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.livequiz.data.bean.LiveParams;
import e.f;
import java.util.Map;
import org.json.JSONObject;

public final class JSPackagerClient implements ReconnectingWebSocket.MessageCallback {
    private static final String PACKAGER_CONNECTION_URL_FORMAT = "ws://%s/message?device=%s&app=%s&context=%s";
    private static final int PROTOCOL_VERSION = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "JSPackagerClient";
    private Map<String, RequestHandler> mRequestHandlers;
    /* access modifiers changed from: private */
    public ReconnectingWebSocket mWebSocket;

    private class ResponderImpl implements Responder {
        private Object mId;

        public ResponderImpl(Object obj) {
            this.mId = obj;
        }

        public void respond(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, 2);
                jSONObject.put("id", this.mId);
                jSONObject.put(AbTestingModule.KEY_RESULT, obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e2) {
                FLog.e(JSPackagerClient.TAG, "Responding failed", (Throwable) e2);
            }
        }

        public void error(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("error", obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e2) {
                FLog.e(JSPackagerClient.TAG, "Responding with error failed", (Throwable) e2);
            }
        }
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map) {
        this(str, packagerConnectionSettings, map, (ReconnectingWebSocket.ConnectionCallback) null);
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map, ReconnectingWebSocket.ConnectionCallback connectionCallback) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("ws").encodedAuthority(packagerConnectionSettings.getDebugServerHost()).appendPath(ShareConstants.WEB_DIALOG_PARAM_MESSAGE).appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter(LiveParams.SYNC_TYPE_APP, packagerConnectionSettings.getPackageName()).appendQueryParameter("clientid", str);
        this.mWebSocket = new ReconnectingWebSocket(builder.build().toString(), this, connectionCallback);
        this.mRequestHandlers = map;
    }

    public void init() {
        this.mWebSocket.connect();
    }

    public void close() {
        this.mWebSocket.closeQuietly();
    }

    public void onMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            String optString = jSONObject.optString("method");
            Object opt = jSONObject.opt("id");
            Object opt2 = jSONObject.opt(NativeProtocol.WEB_DIALOG_PARAMS);
            if (optInt != 2) {
                String str2 = TAG;
                FLog.e(str2, "Message with incompatible or missing version of protocol received: " + optInt);
            } else if (optString == null) {
                abortOnMessage(opt, "No method provided");
            } else {
                RequestHandler requestHandler = this.mRequestHandlers.get(optString);
                if (requestHandler == null) {
                    abortOnMessage(opt, "No request handler for method: " + optString);
                } else if (opt == null) {
                    requestHandler.onNotification(opt2);
                } else {
                    requestHandler.onRequest(opt2, new ResponderImpl(opt));
                }
            }
        } catch (Exception e2) {
            FLog.e(TAG, "Handling the message failed", (Throwable) e2);
        }
    }

    public void onMessage(f fVar) {
        FLog.w(TAG, "Websocket received message with payload of unexpected type binary");
    }

    private void abortOnMessage(Object obj, String str) {
        if (obj != null) {
            new ResponderImpl(obj).error(str);
        }
        String str2 = TAG;
        FLog.e(str2, "Handling the message failed with reason: " + str);
    }
}
