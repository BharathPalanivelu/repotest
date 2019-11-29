package com.shopee.app.web.protocol;

import java.util.ArrayList;
import java.util.List;

public class ShowDropDownMessage {
    private List<DropDownItem> items = new ArrayList();
    private float xPosition;
    private float yPosition;

    public static class DropDownItem {
        public String icon;
        public int state;
        public String subTitle;
        public String title;
    }

    public List<DropDownItem> getItems() {
        return this.items;
    }

    public float getxPosition() {
        return this.xPosition;
    }

    public float getyPosition() {
        return this.yPosition;
    }
}
