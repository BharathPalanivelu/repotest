package com.shopee.app.util;

import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.gallery.GalleryData;
import com.shopee.app.util.af;
import com.shopee.id.R;
import java.util.HashMap;
import java.util.List;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static a f26533a = new a() {

        /* renamed from: a  reason: collision with root package name */
        String f26536a = "";

        public boolean a(GalleryItemInfo galleryItemInfo) {
            SettingConfigStore settingConfigStore = ar.f().e().settingConfigStore();
            int imageSearchPhotoLibMinSize = settingConfigStore.imageSearchPhotoLibMinSize();
            int imageSearchPhotoLibRatio = settingConfigStore.imageSearchPhotoLibRatio();
            int width = galleryItemInfo.getWidth();
            int height = galleryItemInfo.getHeight();
            if (width == 0 && height == 0) {
                return true;
            }
            if (width < imageSearchPhotoLibMinSize || height < imageSearchPhotoLibMinSize) {
                this.f26536a = b.a(R.string.error_image_too_small, Integer.valueOf(imageSearchPhotoLibMinSize), Integer.valueOf(imageSearchPhotoLibMinSize));
                com.garena.android.appkit.d.a.a(this.f26536a, new Object[0]);
                return false;
            }
            if ((width > height ? ((float) width) / ((float) height) : ((float) height) / ((float) width)) <= ((float) imageSearchPhotoLibRatio)) {
                return true;
            }
            this.f26536a = b.a(R.string.error_image_too_long, Integer.valueOf(imageSearchPhotoLibRatio));
            com.garena.android.appkit.d.a.a(this.f26536a, new Object[0]);
            return false;
        }

        public String a() {
            return this.f26536a;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, a> f26534b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static a f26535c = new a() {
        public boolean a(GalleryItemInfo galleryItemInfo) {
            return (galleryItemInfo.getWidth() >= SettingConfigStore.getInstance().getMallImageMinWidth() && galleryItemInfo.getHeight() >= SettingConfigStore.getInstance().getMallImageMinHeight()) || (galleryItemInfo.getWidth() == 0 && galleryItemInfo.getHeight() == 0) || galleryItemInfo.getVideoTime() != 0;
        }

        public String a() {
            return b.a(R.string.error_image_resolution, Integer.valueOf(SettingConfigStore.getInstance().getMallImageMinWidth()), Integer.valueOf(SettingConfigStore.getInstance().getMallImageMinHeight()));
        }
    };

    public interface a {
        String a();

        boolean a(GalleryItemInfo galleryItemInfo);
    }

    static {
        f26534b.put("FILTER_MALL", f26535c);
        f26534b.put("FILTER_IMAGE_SEARCH", f26533a);
    }

    public static List<GalleryData> a(List<GalleryData> list) {
        return af.a(list, new af.a<GalleryData>() {
            /* renamed from: a */
            public boolean shouldInclude(GalleryData galleryData) {
                return !galleryData.a();
            }
        });
    }

    public static boolean a(GalleryItemInfo galleryItemInfo, String str) {
        return !f26534b.containsKey(str) || f26534b.get(str).a(galleryItemInfo);
    }

    public static String a(String str) {
        if (f26534b.containsKey(str)) {
            return f26534b.get(str).a();
        }
        return b.e(R.string.sp_unable_to_load_image);
    }

    public static void a(String str, a aVar) {
        f26534b.put(str, aVar);
    }

    public static void b(String str) {
        f26534b.remove(str);
    }
}
