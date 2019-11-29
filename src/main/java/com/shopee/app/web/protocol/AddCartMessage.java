package com.shopee.app.web.protocol;

import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.ui.product.add.wholesale.h;
import com.shopee.app.util.af;
import com.shopee.app.util.au;
import com.shopee.protocol.shop.TierVariation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddCartMessage {
    private float addCartEndPercent;
    private float addCartStartPercent;
    private final boolean addOnly;
    private String buttonText;
    private boolean canPickQuantity;
    private boolean canUseWholesale;
    private String categoryIDs;
    public final String currency;
    private boolean hideStock;
    private boolean isOfficialShop;
    public final long itemID;
    public final String itemImage;
    public final int keepUserChoice;
    private String passBackString;
    public final long price;
    public final long priceBeforeDiscount;
    private int quantity = 1;
    private long selectedModelId;
    public final int shopID;
    private String sizeChartImage;
    private boolean skipPanel;
    private boolean skipServerRequest;
    private String source;
    private final int status;
    public final int stock;
    private List<TierVariation> tierVariations;
    public final int userID;
    public final List<Variant> variations;
    public final boolean viewOnly;
    private List<WholesaleTier> wholesaleTiers;

    public void test() {
    }

    private AddCartMessage(String str, long j, String str2, int i, long j2, long j3, int i2, int i3, int i4, List<Variant> list, boolean z, int i5, boolean z2, List<WholesaleTier> list2, List<TierVariation> list3, String str3) {
        this.currency = str;
        this.itemID = j;
        this.itemImage = str2;
        this.keepUserChoice = i;
        this.price = j2;
        this.priceBeforeDiscount = j3;
        this.shopID = i2;
        this.stock = i3;
        this.userID = i4;
        this.variations = list;
        this.viewOnly = z;
        this.status = i5;
        this.canUseWholesale = z2;
        this.wholesaleTiers = list2;
        this.tierVariations = list3;
        this.sizeChartImage = str3;
        this.addOnly = false;
        this.source = "";
        this.skipPanel = true;
        this.skipServerRequest = false;
        this.canPickQuantity = false;
        this.buttonText = "";
        this.categoryIDs = "";
    }

    public static AddCartMessage from(ItemDetail itemDetail, int i) {
        String str;
        List<T> a2 = af.a(itemDetail.getModelDetails(), new af.b<Variant, ModelDetail>() {
            public Variant map(ModelDetail modelDetail) {
                return new Variant(modelDetail.getModelId(), modelDetail.getName(), modelDetail.getPrice(), modelDetail.getStock(), modelDetail.getPriceBeforeDiscount(), modelDetail.getTierIndexes());
            }
        });
        if (itemDetail.getSizeChart() == null || itemDetail.getSizeChart().isEmpty()) {
            str = "";
        } else {
            str = "http://cf.shopee.co.id/file/" + itemDetail.getSizeChart();
        }
        return new AddCartMessage("IDR", itemDetail.getId(), itemDetail.getImages(), i, itemDetail.getPrice(), itemDetail.getPriceBeforeDiscount(), itemDetail.getShopId(), itemDetail.getStock(), i, a2, false, itemDetail.getStatus(), itemDetail.isCanUseWholesale(), new h().a(itemDetail.getWholesaleTiers()), itemDetail.getTierVariations(), str);
    }

    public boolean isOfficialShop() {
        return this.isOfficialShop;
    }

    public void setOfficialShop(boolean z) {
        this.isOfficialShop = z;
    }

    public long getSelectedModelId() {
        return this.selectedModelId;
    }

    public void setSelectedModelId(long j) {
        this.selectedModelId = j;
    }

    public boolean isCanUseWholesale() {
        return this.canUseWholesale;
    }

    public List<WholesaleTier> getWholesaleTiers() {
        return this.wholesaleTiers;
    }

    public void setWholesaleTiers(List<WholesaleTier> list) {
        this.wholesaleTiers = list;
    }

    public String getPassBackString() {
        return this.passBackString;
    }

    public boolean hasVariations() {
        return !af.a(this.variations);
    }

    public boolean hasTwoTierVariations() {
        return !af.a(this.tierVariations);
    }

    public boolean hasStock() {
        return getStock() > 0;
    }

    public int getStock() {
        if (!hasVariations()) {
            return this.stock;
        }
        int i = 0;
        for (Variant variant : this.variations) {
            i += variant.modelStock;
        }
        return i;
    }

    public boolean isAddOnly() {
        return this.addOnly;
    }

    public String getPriceStr() {
        if (!hasVariations()) {
            return au.b(this.price);
        }
        long j = this.variations.get(0).modelPrice;
        List<T> a2 = af.a(this.variations, new af.a<Variant>() {
            public boolean shouldInclude(Variant variant) {
                return variant.modelStock > 0;
            }
        });
        if (a2.size() <= 0) {
            return au.b(j);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(af.a(a2, new af.b<Long, Variant>() {
            public Long map(Variant variant) {
                long j;
                if (variant.modelPriceBeforeDiscount <= 0) {
                    j = variant.modelPrice;
                } else {
                    j = Math.min(variant.modelPriceBeforeDiscount, variant.modelPrice);
                }
                return Long.valueOf(j);
            }
        }));
        Collections.sort(arrayList, new Comparator<Long>() {
            public int compare(Long l, Long l2) {
                if (l.longValue() > l2.longValue()) {
                    return 1;
                }
                return l.longValue() < l2.longValue() ? -1 : 0;
            }
        });
        long longValue = ((Long) arrayList.get(0)).longValue();
        long longValue2 = ((Long) arrayList.get(arrayList.size() - 1)).longValue();
        if (longValue == longValue2) {
            return au.b(longValue);
        }
        return au.b(longValue) + " ~ " + au.b(longValue2);
    }

    public boolean isStatusBannedOrDeleted() {
        int i = this.status;
        return i == 0 || i == 3 || i == 4 || i == 5;
    }

    public float getAddCartStartPercent() {
        return this.addCartStartPercent;
    }

    public float getAddCartEndPercent() {
        return this.addCartEndPercent;
    }

    public String getNewPrice() {
        return getPriceStr();
    }

    public String getOldPrice() {
        if (!hasVariations()) {
            return au.b(this.price);
        }
        Variant variant = this.variations.get(0);
        long j = variant.modelPriceBeforeDiscount <= 0 ? variant.modelPrice : variant.modelPriceBeforeDiscount;
        List<T> a2 = af.a(this.variations, new af.a<Variant>() {
            public boolean shouldInclude(Variant variant) {
                return variant.modelStock > 0;
            }
        });
        if (a2.size() <= 0) {
            return au.b(j);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(af.a(a2, new af.b<Long, Variant>() {
            public Long map(Variant variant) {
                return Long.valueOf(variant.modelPriceBeforeDiscount <= 0 ? variant.modelPrice : variant.modelPriceBeforeDiscount);
            }
        }));
        Collections.sort(arrayList, new Comparator<Long>() {
            public int compare(Long l, Long l2) {
                return (int) (l.longValue() - l2.longValue());
            }
        });
        long longValue = ((Long) arrayList.get(0)).longValue();
        long longValue2 = ((Long) arrayList.get(arrayList.size() - 1)).longValue();
        if (longValue == longValue2) {
            return au.b(longValue);
        }
        return au.b(longValue) + " ~ " + au.b(longValue2);
    }

    public String getSource() {
        return this.source;
    }

    public boolean skipPanel() {
        return this.skipPanel;
    }

    public boolean skipServerRequest() {
        return this.skipServerRequest;
    }

    public boolean canPickQuantity() {
        return this.canPickQuantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public List<TierVariation> getTierVariations() {
        return this.tierVariations;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public Variant getVariant(List<Integer> list) {
        List<Variant> list2 = this.variations;
        if (list2 == null || list == null) {
            return null;
        }
        for (Variant next : list2) {
            if (next.tierIndexes != null && next.tierIndexes.equals(list)) {
                return next;
            }
        }
        return null;
    }

    public String getSizeChartImage() {
        return this.sizeChartImage;
    }

    public boolean isHideStock() {
        return this.hideStock;
    }

    public String getCategoryIDs() {
        return this.categoryIDs;
    }

    public void setHideStock(boolean z) {
        this.hideStock = z;
    }
}
