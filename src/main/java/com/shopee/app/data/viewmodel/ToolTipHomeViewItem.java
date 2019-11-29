package com.shopee.app.data.viewmodel;

import com.shopee.id.R;

public class ToolTipHomeViewItem {
    private boolean mShowMallTabPopup;
    private boolean mShowMeTabBadge;
    private ToolTipStyle mStyle;
    private String mText;

    public ToolTipHomeViewItem(boolean z, boolean z2, String str, ToolTipStyle toolTipStyle) {
        this.mShowMallTabPopup = z;
        this.mShowMeTabBadge = z2;
        this.mText = str;
        this.mStyle = toolTipStyle;
    }

    public boolean isShowMallTabPopup() {
        return this.mShowMallTabPopup;
    }

    public boolean isShowMeTabBadge() {
        return this.mShowMeTabBadge;
    }

    public String getText() {
        return this.mText;
    }

    public ToolTipStyle getStyle() {
        return this.mStyle;
    }

    public enum ToolTipStyle {
        ORANGE(R.drawable.prompt_orange, R.drawable.ic_guide_corner_orange),
        RED(R.drawable.prompt_red, R.drawable.ic_guide_corner_red);
        
        public int backgroundResId;
        public int triangleResId;

        private ToolTipStyle(int i, int i2) {
            this.backgroundResId = i;
            this.triangleResId = i2;
        }
    }
}
