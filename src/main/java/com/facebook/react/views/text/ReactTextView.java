package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ao;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewBackgroundManager;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mContainsImages;
    private int mDefaultGravityHorizontal = (getGravity() & 8388615);
    private int mDefaultGravityVertical = (getGravity() & 112);
    private TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
    private int mLinkifyMaskType = 0;
    private boolean mNotifyOnInlineViewLayout;
    private int mNumberOfLines = Integer.MAX_VALUE;
    private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    private Spannable mSpanned;
    private int mTextAlign = 0;

    public boolean hasOverlappingRendering() {
        return false;
    }

    public ReactTextView(Context context) {
        super(context);
    }

    private WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap createMap = Arguments.createMap();
        if (i == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i2);
        } else if (i == 0) {
            createMap.putString("visibility", ViewProps.VISIBLE);
            createMap.putInt("index", i2);
            createMap.putDouble(ViewProps.LEFT, (double) PixelUtil.toDIPFromPixel((float) i3));
            createMap.putDouble(ViewProps.TOP, (double) PixelUtil.toDIPFromPixel((float) i4));
            createMap.putDouble(ViewProps.RIGHT, (double) PixelUtil.toDIPFromPixel((float) i5));
            createMap.putDouble(ViewProps.BOTTOM, (double) PixelUtil.toDIPFromPixel((float) i6));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt("index", i2);
        }
        return createMap;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof ao) {
            context = ((ao) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        if (r11 != false) goto L_0x00ce;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r7 = r18
            java.lang.CharSequence r0 = r18.getText()
            boolean r0 = r0 instanceof android.text.Spanned
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            com.facebook.react.bridge.ReactContext r0 = r18.getReactContext()
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r1 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r0 = r0.getNativeModule(r1)
            r8 = r0
            com.facebook.react.uimanager.UIManagerModule r8 = (com.facebook.react.uimanager.UIManagerModule) r8
            java.lang.CharSequence r0 = r18.getText()
            r9 = r0
            android.text.Spanned r9 = (android.text.Spanned) r9
            android.text.Layout r10 = r18.getLayout()
            int r0 = r9.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r1 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            r11 = 0
            java.lang.Object[] r0 = r9.getSpans(r11, r0, r1)
            r12 = r0
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r12 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r12
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x003c
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.length
            r0.<init>(r1)
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            r13 = r0
            int r14 = r22 - r20
            int r15 = r23 - r21
            int r6 = r12.length
            r5 = 0
        L_0x0044:
            if (r5 >= r6) goto L_0x013e
            r0 = r12[r5]
            int r1 = r0.getReactTag()
            android.view.View r1 = r8.resolveView(r1)
            int r2 = r9.getSpanStart(r0)
            int r3 = r10.getLineForOffset(r2)
            int r4 = r10.getEllipsisCount(r3)
            r16 = 1
            if (r4 <= 0) goto L_0x0062
            r4 = 1
            goto L_0x0063
        L_0x0062:
            r4 = 0
        L_0x0063:
            if (r4 == 0) goto L_0x0071
            int r4 = r10.getLineStart(r3)
            int r17 = r10.getEllipsisStart(r3)
            int r4 = r4 + r17
            if (r2 >= r4) goto L_0x011d
        L_0x0071:
            int r4 = r7.mNumberOfLines
            if (r3 >= r4) goto L_0x011d
            int r4 = r10.getLineEnd(r3)
            if (r2 < r4) goto L_0x007d
            goto L_0x011d
        L_0x007d:
            int r4 = r0.getWidth()
            int r0 = r0.getHeight()
            boolean r11 = r10.isRtlCharAt(r2)
            r17 = r5
            int r5 = r10.getParagraphDirection(r3)
            r23 = r6
            r6 = -1
            if (r5 != r6) goto L_0x0096
            r5 = 1
            goto L_0x0097
        L_0x0096:
            r5 = 0
        L_0x0097:
            int r6 = r9.length()
            int r6 = r6 + -1
            if (r2 != r6) goto L_0x00af
            if (r5 == 0) goto L_0x00a9
            float r5 = r10.getLineWidth(r3)
            int r5 = (int) r5
            int r5 = r14 - r5
            goto L_0x00cf
        L_0x00a9:
            float r5 = r10.getLineRight(r3)
            int r5 = (int) r5
            goto L_0x00ce
        L_0x00af:
            if (r5 != r11) goto L_0x00b3
            r6 = 1
            goto L_0x00b4
        L_0x00b3:
            r6 = 0
        L_0x00b4:
            if (r6 == 0) goto L_0x00bb
            float r6 = r10.getPrimaryHorizontal(r2)
            goto L_0x00bf
        L_0x00bb:
            float r6 = r10.getSecondaryHorizontal(r2)
        L_0x00bf:
            int r6 = (int) r6
            if (r5 == 0) goto L_0x00cb
            float r5 = r10.getLineRight(r3)
            int r5 = (int) r5
            int r5 = r5 - r6
            int r5 = r14 - r5
            goto L_0x00cc
        L_0x00cb:
            r5 = r6
        L_0x00cc:
            if (r11 == 0) goto L_0x00cf
        L_0x00ce:
            int r5 = r5 - r4
        L_0x00cf:
            if (r11 == 0) goto L_0x00d6
            int r6 = r18.getTotalPaddingRight()
            goto L_0x00da
        L_0x00d6:
            int r6 = r18.getTotalPaddingLeft()
        L_0x00da:
            int r5 = r5 + r6
            int r6 = r20 + r5
            int r11 = r18.getTotalPaddingTop()
            int r3 = r10.getLineBaseline(r3)
            int r11 = r11 + r3
            int r11 = r11 - r0
            int r3 = r21 + r11
            if (r14 <= r5) goto L_0x00f0
            if (r15 > r11) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r16 = 0
        L_0x00f0:
            if (r16 == 0) goto L_0x00f5
            r5 = 8
            goto L_0x00f6
        L_0x00f5:
            r5 = 0
        L_0x00f6:
            int r11 = r6 + r4
            int r4 = r3 + r0
            r1.setVisibility(r5)
            r1.layout(r6, r3, r11, r4)
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x0118
            r0 = r18
            r1 = r5
            r5 = r3
            r3 = r6
            r6 = r4
            r4 = r5
            r16 = r17
            r5 = r11
            r11 = r23
            com.facebook.react.bridge.WritableMap r0 = r0.inlineViewJson(r1, r2, r3, r4, r5, r6)
            r13.add(r0)
            goto L_0x0138
        L_0x0118:
            r11 = r23
            r16 = r17
            goto L_0x0138
        L_0x011d:
            r16 = r5
            r11 = r6
            r0 = 8
            r1.setVisibility(r0)
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x0138
            r1 = 8
            r3 = -1
            r4 = -1
            r5 = -1
            r6 = -1
            r0 = r18
            com.facebook.react.bridge.WritableMap r0 = r0.inlineViewJson(r1, r2, r3, r4, r5, r6)
            r13.add(r0)
        L_0x0138:
            int r5 = r16 + 1
            r6 = r11
            r11 = 0
            goto L_0x0044
        L_0x013e:
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x0180
            com.facebook.react.views.text.ReactTextView$1 r0 = new com.facebook.react.views.text.ReactTextView$1
            r0.<init>()
            java.util.Collections.sort(r13, r0)
            com.facebook.react.bridge.WritableArray r0 = com.facebook.react.bridge.Arguments.createArray()
            java.util.Iterator r1 = r13.iterator()
        L_0x0152:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0162
            java.lang.Object r2 = r1.next()
            com.facebook.react.bridge.WritableMap r2 = (com.facebook.react.bridge.WritableMap) r2
            r0.pushMap(r2)
            goto L_0x0152
        L_0x0162:
            com.facebook.react.bridge.WritableMap r1 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r2 = "inlineViews"
            r1.putArray(r2, r0)
            com.facebook.react.bridge.ReactContext r0 = r18.getReactContext()
            java.lang.Class<com.facebook.react.uimanager.events.RCTEventEmitter> r2 = com.facebook.react.uimanager.events.RCTEventEmitter.class
            com.facebook.react.bridge.JavaScriptModule r0 = r0.getJSModule(r2)
            com.facebook.react.uimanager.events.RCTEventEmitter r0 = (com.facebook.react.uimanager.events.RCTEventEmitter) r0
            int r2 = r18.getId()
            java.lang.String r3 = "topInlineViewLayout"
            r0.receiveEvent(r2, r3, r1)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        this.mContainsImages = reactTextUpdate.containsImages();
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable text = reactTextUpdate.getText();
        int i = this.mLinkifyMaskType;
        if (i > 0) {
            Linkify.addLinks(text, i);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(text);
        setPadding((int) Math.floor((double) reactTextUpdate.getPaddingLeft()), (int) Math.floor((double) reactTextUpdate.getPaddingTop()), (int) Math.floor((double) reactTextUpdate.getPaddingRight()), (int) Math.floor((double) reactTextUpdate.getPaddingBottom()));
        int textAlign = reactTextUpdate.getTextAlign();
        if (this.mTextAlign != textAlign) {
            this.mTextAlign = textAlign;
        }
        setGravityHorizontal(this.mTextAlign);
        if (Build.VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
            setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
        }
        if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
            setJustificationMode(reactTextUpdate.getJustificationMode());
        }
        requestLayout();
    }

    public int reactTagForTouch(float f2, float f3) {
        CharSequence text = getText();
        int id = getId();
        int i = (int) f2;
        int i2 = (int) f3;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i2);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i >= lineLeft && i <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i3 = 0; i3 < reactTagSpanArr.length; i3++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i3]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i3]);
                        if (spanEnd > offsetForHorizontal) {
                            int i4 = spanEnd - spanStart;
                            if (i4 <= length) {
                                id = reactTagSpanArr[i3].getReactTag();
                                length = i4;
                            }
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                FLog.e(ReactConstants.TAG, "Crash in HorizontalMeasurementProvider: " + e2.getMessage());
            }
        }
        return id;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (this.mNumberOfLines != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void updateView() {
        setEllipsize(this.mNumberOfLines == Integer.MAX_VALUE ? null : this.mEllipsizeLocation);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f2) {
        this.mReactBackgroundManager.setBorderWidth(i, f2);
    }

    public void setBorderColor(int i, float f2, float f3) {
        this.mReactBackgroundManager.setBorderColor(i, f2, f3);
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderRadius(float f2, int i) {
        this.mReactBackgroundManager.setBorderRadius(f2, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }
}
