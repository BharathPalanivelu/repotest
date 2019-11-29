package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.data.c.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RatingsEntity implements Serializable {
    private String buyerName;
    private String comments;
    private List<String> imageUrl = null;
    private String itemIds;
    private String ratingId;
    private int ratings;
    private int shopId;

    public void test() {
        this.imageUrl = new ArrayList();
        this.imageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562832197&di=f312ee63ef32427997a106ca74b09789&imgtype=jpg&er=1&src=http%3A%2F%2Fwx2.sinaimg.cn%2Forj360%2F005O2tSily1g3u26cp22aj30k01o0443.jpg");
        this.imageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562237535103&di=fe239ad7c72976b3c5d9b926f3858e5d&imgtype=0&src=http%3A%2F%2Fattachments.gfan.net.cn%2Fforum%2Fattachments2%2F201305%2F18%2F234410bua3r3t3ihu3b5ir.jpg");
        this.buyerName = "normal_user1";
        this.comments = "Kualitas produk sangat baik Harga produk sangat baik Kecepatan pengiriman sangat baik  Excellent product value Excellent product value Excellent product value Excellent product value Excellent product value Excellent product value Excellent product value Excellent product value\\n";
        this.ratings = 5;
        this.itemIds = "1686838";
        this.shopId = 511046;
        this.ratingId = "151798644";
    }

    public void resetImageUrl() {
        List<String> list = this.imageUrl;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (String b2 : this.imageUrl) {
                arrayList.add(b.b(b2));
                i++;
                if (i >= 5) {
                    break;
                }
            }
            this.imageUrl.clear();
            this.imageUrl.addAll(arrayList);
        }
    }

    public void setImageUrl(List<String> list) {
        this.imageUrl = list;
    }

    public List<String> getImageUrl() {
        return this.imageUrl;
    }

    public void setBuyerName(String str) {
        this.buyerName = str;
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public void setRatings(int i) {
        this.ratings = i;
    }

    public int getRatings() {
        return this.ratings;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public String getComments() {
        return this.comments;
    }

    public void setRatingId(String str) {
        this.ratingId = str;
    }

    public String getRatingId() {
        return this.ratingId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setItemIds(String str) {
        this.itemIds = str;
    }

    public String getItemIds() {
        return this.itemIds;
    }
}
