package com.shopee.app.data.viewmodel;

public class RedirectParameters {
    private int actionBoxCategory = 4;
    private long actionId = 0;
    private int catId = 0;
    private int collectionId = 0;
    private int freeRedirect = 0;
    private String homeTab = "me";
    private long itemId = 0;
    private int offerStatus = 0;
    private long orderId = 0;
    private String path = "";
    private int rnUpdateVersion;
    private int shopId = 0;
    private String sns = "";
    private int taskId = 0;
    private int userId = 0;

    public int getActionBoxCategory() {
        return this.actionBoxCategory;
    }

    public RedirectParameters(String[] strArr) {
        parse(strArr);
    }

    private void parse(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("s/")) {
                this.shopId = Integer.parseInt(str.substring(2));
            } else if (str.startsWith("m/")) {
                this.userId = Integer.parseInt(str.substring(2));
            } else if (str.startsWith("o/")) {
                this.orderId = Long.parseLong(str.substring(2));
            } else if (str.startsWith("i/")) {
                this.itemId = Long.parseLong(str.substring(2));
            } else if (str.startsWith("a/")) {
                this.actionId = Long.parseLong(str.substring(2));
            } else if (str.startsWith("of/")) {
                this.offerStatus = Integer.parseInt(str.substring(3));
            } else if (str.startsWith("nlp/")) {
                this.freeRedirect = Integer.parseInt(str.substring(4));
            } else if (str.startsWith("ca/")) {
                this.catId = Integer.parseInt(str.substring(3));
            } else if (str.startsWith("co/")) {
                this.collectionId = Integer.parseInt(str.substring(3));
            } else if (str.startsWith("sns/")) {
                this.sns = str.substring(4);
            } else if (str.startsWith("ti/")) {
                this.taskId = Integer.parseInt(str.substring(3));
            } else if (str.startsWith("c/")) {
                this.actionBoxCategory = Integer.parseInt(str.substring(2));
            } else if (str.startsWith("rn/")) {
                try {
                    this.rnUpdateVersion = Integer.parseInt(str.substring(3).trim());
                } catch (Exception unused) {
                }
            } else if (str.startsWith("p/")) {
                this.path = str.substring(2);
            } else if (str.startsWith("t/")) {
                this.homeTab = str.substring(2);
            }
        }
    }

    public long getItemId() {
        return this.itemId;
    }

    public int getShopId() {
        return this.shopId;
    }

    public int getUserId() {
        return this.userId;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public long getActionId() {
        return this.actionId;
    }

    public int getOfferStatus() {
        return this.offerStatus;
    }

    public int getFreeRedirect() {
        return this.freeRedirect;
    }

    public int getCatId() {
        return this.catId;
    }

    public String getSns() {
        return this.sns;
    }

    public void setSns(String str) {
        this.sns = str;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public boolean needsRNUpdate() {
        return this.rnUpdateVersion > 0;
    }

    public int getRNUpdateVersion() {
        return this.rnUpdateVersion;
    }

    public int getCollectionId() {
        return this.collectionId;
    }

    public String getPath() {
        return this.path;
    }

    public String getHomeTab() {
        return this.homeTab;
    }
}
