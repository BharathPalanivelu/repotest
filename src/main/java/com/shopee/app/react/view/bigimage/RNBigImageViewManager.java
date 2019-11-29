package com.shopee.app.react.view.bigimage;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.internal.ShareConstants;

public class RNBigImageViewManager extends SimpleViewManager<a> {
    public String getName() {
        return "RNBigImageView";
    }

    public a createViewInstance(ThemedReactContext themedReactContext) {
        return new a(themedReactContext);
    }

    @ReactProp(name = "src")
    public void setSource(a aVar, String str) {
        aVar.setSource(str);
    }

    @ReactProp(name = "source")
    public void setSource(a aVar, ReadableMap readableMap) {
        if (readableMap != null) {
            aVar.setSource(new a(readableMap));
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f19024a;

        /* renamed from: b  reason: collision with root package name */
        private int f19025b;

        /* renamed from: c  reason: collision with root package name */
        private int f19026c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19027d;

        /* renamed from: e  reason: collision with root package name */
        private String f19028e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f19029f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f19030g = false;

        public a(ReadableMap readableMap) {
            if (readableMap.hasKey(ShareConstants.MEDIA_URI)) {
                this.f19024a = readableMap.getString(ShareConstants.MEDIA_URI);
            }
            if (readableMap.hasKey("width")) {
                this.f19025b = (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height")) {
                this.f19026c = (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("height"));
            }
            if (readableMap.hasKey("skipCache")) {
                this.f19027d = readableMap.getBoolean("skipCache");
            }
            if (readableMap.hasKey(ViewProps.RESIZE_MODE)) {
                this.f19028e = readableMap.getString(ViewProps.RESIZE_MODE);
            }
            if (readableMap.hasKey("noFade")) {
                this.f19029f = readableMap.getBoolean("noFade");
            }
            if (readableMap.hasKey("isJpeg")) {
                this.f19030g = readableMap.getBoolean("isJpeg");
            }
        }

        public String a() {
            return this.f19024a;
        }

        public int b() {
            return this.f19025b;
        }

        public int c() {
            return this.f19026c;
        }

        public boolean d() {
            return this.f19027d;
        }

        public String e() {
            return this.f19028e;
        }

        public boolean f() {
            return this.f19029f;
        }

        public boolean g() {
            return this.f19030g;
        }
    }
}
