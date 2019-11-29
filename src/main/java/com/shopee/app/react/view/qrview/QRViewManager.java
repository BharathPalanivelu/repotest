package com.shopee.app.react.view.qrview;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class QRViewManager extends ViewGroupManager<a> {
    private static final int SCAN_AGAIN = 0;
    private static final int TORCH = 1;

    public String getName() {
        return "ReactQRView";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public a createViewInstance(ThemedReactContext themedReactContext) {
        a aVar = new a(themedReactContext.getCurrentActivity(), themedReactContext);
        themedReactContext.addLifecycleEventListener(aVar);
        return aVar;
    }

    @ReactProp(name = "debug")
    public void setDebug(a aVar, boolean z) {
        aVar.setDebug(z);
    }

    @ReactProp(name = "codeType")
    public void setCodeType(a aVar, int i) {
        aVar.setCodeType(i);
    }

    @ReactProp(name = "show")
    public void setShow(a aVar, ReadableMap readableMap) {
        if (readableMap != null) {
            double d2 = -1.0d;
            double d3 = readableMap.hasKey("width") ? readableMap.getDouble("width") : -1.0d;
            if (readableMap.hasKey("height")) {
                d2 = readableMap.getDouble("height");
            }
            if (d3 > 0.0d && d2 > 0.0d) {
                aVar.a((int) ((double) PixelUtil.toPixelFromDIP(d3)), (int) ((double) PixelUtil.toPixelFromDIP(d2)));
            }
            if (readableMap.hasKey("bottomMargin")) {
                double d4 = readableMap.getDouble("bottomMargin");
                if (d4 > 0.0d) {
                    aVar.setScanningAreaBottomMargin((int) PixelUtil.toPixelFromDIP(d4));
                }
            }
            aVar.b();
        }
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onScanComplete", MapBuilder.of("registrationName", "onScanComplete")).put("onScanPaused", MapBuilder.of("registrationName", "onScanPaused")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scanAgain", 0, "torch", 1);
    }

    public void receiveCommand(a aVar, int i, ReadableArray readableArray) {
        if (i == 0) {
            aVar.a();
        } else if (i == 1 && readableArray != null) {
            aVar.setTorchOn(readableArray.getBoolean(0));
        }
    }

    public void onDropViewInstance(a aVar) {
        super.onDropViewInstance(aVar);
        aVar.d();
        aVar.getReactContext().removeLifecycleEventListener(aVar);
    }
}
