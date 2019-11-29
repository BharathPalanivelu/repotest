package com.shopee.app.data.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharingConfigInfo {
    private static final String COPY_INFO = "copy_info";
    private static final String COPY_LINK = "copy_link";
    private static final String EMAIL = "email";
    private static final String SMS = "sms";
    private Map<String, List<SharingDetailInfo>> sharingInfo;

    public void setSharingInfo(Map<String, List<SharingDetailInfo>> map) {
        this.sharingInfo = map;
    }

    private List<SharingDetailInfo> getList(String str) {
        List<SharingDetailInfo> list = this.sharingInfo.get(str);
        return list == null ? this.sharingInfo.get("id") : list;
    }

    private boolean isSystemApp(String str) {
        return str.equals(SMS) || str.equals(COPY_LINK) || str.equals(COPY_INFO) || str.equals("email");
    }

    public AppDetailInfo getAppDetail(String str, String str2, boolean z, boolean z2) {
        for (SharingDetailInfo next : getList(str)) {
            if (str2.equals(next.getId())) {
                return z2 ? z ? next.getShopDetail() : next.getProductDetail() : z ? next.getOtherShopDetail() : next.getOtherProductDetail();
            }
        }
        for (SharingDetailInfo next2 : getList("id")) {
            if (str2.equals(next2.getId())) {
                return z2 ? z ? next2.getShopDetail() : next2.getProductDetail() : z ? next2.getOtherShopDetail() : next2.getOtherProductDetail();
            }
        }
        return null;
    }

    public List<String> getAppList(String str) {
        List<SharingDetailInfo> list = getList(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.isEmpty()) {
            List<SharingDetailInfo> list2 = getList("id");
            if (list2 != null && !list2.isEmpty()) {
                for (SharingDetailInfo next : list2) {
                    if (isSystemApp(next.getId())) {
                        arrayList2.add(next.getId());
                    } else {
                        arrayList.add(next.getId());
                    }
                }
                arrayList.addAll(arrayList2);
            }
        } else {
            for (SharingDetailInfo next2 : list) {
                if (isSystemApp(next2.getId())) {
                    arrayList2.add(next2.getId());
                } else {
                    arrayList.add(next2.getId());
                }
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public class SharingDetailInfo {
        private String id;
        private AppDetailInfo product;
        private AppDetailInfo product_other;
        private AppDetailInfo shop;
        private AppDetailInfo shop_other;

        public SharingDetailInfo() {
        }

        public AppDetailInfo getShopDetail() {
            return this.shop;
        }

        public AppDetailInfo getOtherShopDetail() {
            return this.shop_other;
        }

        public AppDetailInfo getOtherProductDetail() {
            return this.product_other;
        }

        public AppDetailInfo getProductDetail() {
            return this.product;
        }

        public String getId() {
            return this.id;
        }
    }

    public class AppDetailInfo {
        private String body;
        private String share_text;
        private String subject;

        public AppDetailInfo() {
        }

        public String getShareText() {
            return this.share_text;
        }

        public String getBody() {
            return this.body;
        }

        public String getSubject() {
            return this.subject;
        }
    }
}
