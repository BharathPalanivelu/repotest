package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTGroupShadowNode extends ARTVirtualNode {
    protected RectF mClipping;

    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "clipping")
    public void setClipping(ReadableArray readableArray) {
        float[] floatArray = PropHelper.toFloatArray(readableArray);
        if (floatArray != null) {
            this.mClipping = createClipping(floatArray);
            markUpdated();
        }
    }

    public void draw(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.mOpacity;
        if (f3 > 0.01f) {
            saveAndSetupCanvas(canvas);
            RectF rectF = this.mClipping;
            if (rectF != null) {
                canvas.clipRect(rectF.left * this.mScale, this.mClipping.top * this.mScale, this.mClipping.right * this.mScale, this.mClipping.bottom * this.mScale, Region.Op.REPLACE);
            }
            for (int i = 0; i < getChildCount(); i++) {
                ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) getChildAt(i);
                aRTVirtualNode.draw(canvas, paint, f3);
                aRTVirtualNode.markUpdateSeen();
            }
            restoreCanvas(canvas);
        }
    }

    private static RectF createClipping(float[] fArr) {
        if (fArr.length == 4) {
            return new RectF(fArr[0], fArr[1], fArr[0] + fArr[2], fArr[1] + fArr[3]);
        }
        throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    }
}
