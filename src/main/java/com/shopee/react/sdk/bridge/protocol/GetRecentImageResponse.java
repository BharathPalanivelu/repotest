package com.shopee.react.sdk.bridge.protocol;

import com.shopee.navigator.b;

public class GetRecentImageResponse extends b {
    private final ImageData image;
    private final ImageData tnImage;

    public GetRecentImageResponse(ImageData imageData, ImageData imageData2) {
        this.image = imageData;
        this.tnImage = imageData2;
    }
}
