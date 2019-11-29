package com.shopee.feeds.feedlibrary.util.b;

import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.garena.android.appkit.d.a;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.data.entity.ImageCompressUploadParams;
import com.shopee.feeds.feedlibrary.data.entity.VideoCompressUploadEntity;
import com.shopee.feeds.feedlibrary.util.d;
import java.util.HashSet;

public class e {
    public static void a(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("select_product_show", oVar);
        a.b("FeedsUploadDataHelper %s", "select_product_my_product_item_click");
    }

    public static void a(int i, String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            a.a("select_product_my_product_item_click", oVar);
            a.b("FeedsUploadDataHelper %s", "select_product_my_product_item_click: " + i + "," + str);
        }
    }

    public static void b(int i, String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar2 = new o();
            oVar2.a("viewed_objects", (l) iVar);
            a.a("select_product_my_product_item_impression", oVar2);
            a.b("FeedsUploadDataHelper %s", "select_product_my_product_item_impression: " + i + "," + str);
        }
    }

    public static void c(int i, String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            a.a("select_product_my_fav_item_click", oVar);
            a.b("FeedsUploadDataHelper %s", "select_product_my_fav_item_click: " + i + "," + str);
        }
    }

    public static void d(int i, String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar2 = new o();
            oVar2.a("viewed_objects", (l) iVar);
            a.a("select_product_my_fav_item_impression", oVar2);
            a.b("FeedsUploadDataHelper %s", "select_product_my_fav_item_impression: " + i + "," + str);
        }
    }

    public static void a() {
        a.a("select_product_multi_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_product_multi_click");
    }

    public static void a(int i) {
        o oVar = new o();
        oVar.a("tabid", (Number) Integer.valueOf(i));
        a.a("select_product_product_tab_click", oVar);
        a.b("FeedsUploadDataHelper %s", "select_product_product_tab_click: " + i);
    }

    public static void b(int i) {
        o oVar = new o();
        oVar.a("tabid", (Number) Integer.valueOf(i));
        a.a("select_product_main_tab_click", oVar);
        a.b("FeedsUploadDataHelper %s", "select_product_main_tab_click: " + i);
    }

    public static void b() {
        a.a("select_product_close_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_product_close_button_click");
    }

    public static void c() {
        a.a("select_product_next_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_product_next_button_click");
    }

    public static void b(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("select_photo_show", oVar);
        a.b("FeedsUploadDataHelper %s", "select_photo_show");
    }

    public static void d() {
        a.a("select_photo_resize_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_photo_resize_button_click");
    }

    public static void e() {
        a.a("select_photo_multi_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_photo_multi_button_click");
    }

    public static void f() {
        a.a("select_photo_item_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_photo_item_click");
    }

    public static void c(int i) {
        o oVar = new o();
        oVar.a("tabid", (Number) Integer.valueOf(i));
        a.a("select_photo_main_tab_click", oVar);
        a.b("FeedsUploadDataHelper %s", "select_photo_main_tab_click: " + i);
    }

    public static void g() {
        a.a("select_photo_next_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_photo_next_button_click");
    }

    public static void h() {
        a.a("select_photo_close_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "select_photo_close_button_click");
    }

    public static void c(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("take_photo_page_show", oVar);
        a.b("FeedsUploadDataHelper %s", "take_photo_page_show");
    }

    public static void d(int i) {
        o oVar = new o();
        oVar.a("tabid", (Number) Integer.valueOf(i));
        a.a("take_photo_tab_click", oVar);
        a.b("FeedsUploadDataHelper %s", "take_photo_tab_click: " + i);
    }

    public static void i() {
        a.a("take_photo_close_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "take_photo_close_button_click");
    }

    public static void d(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("edit_photo_image_show", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_image_showfirstShow=" + z);
    }

    public static void j() {
        a.a("edit_photo_image_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_image_click");
    }

    public static void k() {
        a.a("edit_photo_bottom_add_tag_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_bottom_add_tag_click");
    }

    public static void l() {
        a.a("edit_photo_bottom_add_text_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_bottom_add_text_click");
    }

    public static void m() {
        a.a("edit_photo_bottom_add_sticker_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_bottom_add_sticker_click");
    }

    public static void n() {
        a.a("edit_photo_item_tag_impression", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_item_tag_impression");
    }

    public static void o() {
        a.a("edit_photo_item_tag_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_item_tag_click");
    }

    public static void p() {
        a.a("edit_photo_input_text_impression", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_input_text_impression");
    }

    public static void q() {
        a.a("edit_photo_input_text_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_input_text_click");
    }

    public static void a(String str) {
        o oVar = new o();
        oVar.a("sticker_type", str);
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        a.a("edit_photo_sticker_impression", oVar2);
        a.b("FeedsUploadDataHelper %s", "edit_photo_sticker_impression");
    }

    public static void b(String str) {
        o oVar = new o();
        oVar.a("sticker_type", str);
        a.a("edit_photo_sticker_click", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_sticker_click");
    }

    public static void r() {
        a.a("edit_photo_input_text_done_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_input_text_done_button_click");
    }

    public static void s() {
        a.a("edit_photo_next_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "edit_photo_next_button_click");
    }

    public static void e(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("edit_photo_select_product_page_show", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_select_product_page_show");
    }

    public static void e(int i) {
        o oVar = new o();
        oVar.a("tabid", (Number) Integer.valueOf(i));
        a.a("edit_photo_select_product_tab_click", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_select_product_tab_click: " + i);
    }

    public static void e(int i, String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar2 = new o();
            oVar2.a("viewed_objects", (l) iVar);
            a.a("edit_photo_select_product_my_product_item_impression", oVar2);
            a.b("FeedsUploadDataHelper %s", "edit_photo_select_product_my_product_item_impression: " + i + "," + str);
        }
    }

    public static void f(int i, String str) {
        if (d.a(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            a.a("edit_photo_select_product_my_product_item_click", oVar);
            a.b("FeedsUploadDataHelper %s", "edit_photo_select_product_my_product_item_click: " + i + "," + str);
        }
    }

    public static void g(int i, String str) {
        if (d.a(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar2 = new o();
            oVar2.a("viewed_objects", (l) iVar);
            a.a("edit_photo_select_product_my_fav_item_impression", oVar2);
            a.b("FeedsUploadDataHelper %s", "edit_photo_select_product_my_fav_item_impression: " + i + "," + str);
        }
    }

    public static void h(int i, String str) {
        if (d.a(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a("itemid", (Number) Long.valueOf(longValue));
            a.a("edit_photo_select_product_my_fav_item_click", oVar);
            a.b("FeedsUploadDataHelper %s", "edit_photo_select_product_my_fav_item_click: " + i + "," + str);
        }
    }

    public static void a(boolean z, boolean z2) {
        o oVar = new o();
        o oVar2 = new o();
        if (z2) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        oVar.a("is_empty", Boolean.valueOf(z));
        a.a("edit_photo_select_voucher_page_show", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_select_voucher_page_show: " + z);
    }

    public static void c(String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("promotion_id", (Number) Long.valueOf(longValue));
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar2 = new o();
            oVar2.a("viewed_objects", (l) iVar);
            a.a("edit_photo_select_voucher_item_impression", oVar2);
            a.b("FeedsUploadDataHelper %s", "edit_photo_select_voucher_item_impression: " + str);
        }
    }

    public static void d(String str) {
        if (d.b(str)) {
            long longValue = Long.valueOf(str).longValue();
            o oVar = new o();
            oVar.a("promotion_id", (Number) Long.valueOf(longValue));
            a.a("edit_photo_select_voucher_item_click", oVar);
            a.b("FeedsUploadDataHelper %s", "edit_photo_select_voucher_item_click: " + str);
        }
    }

    public static void f(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("edit_photo_my_following_page_show", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_my_following_page_show");
    }

    public static void f(int i) {
        o oVar = new o();
        oVar.a("userid", (Number) Integer.valueOf(i));
        a.a("edit_photo_my_following_item_click", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_my_following_item_click: " + i);
    }

    public static void g(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("new_post_page_show", oVar);
        a.b("FeedsUploadDataHelper %s", "new_post_page_show");
    }

    public static void h(boolean z) {
        o oVar = new o();
        oVar.a("turn_on", Boolean.valueOf(z));
        a.a("new_post_share_ins_button_click", oVar);
        a.b("FeedsUploadDataHelper %s", "new_post_share_ins_button_click: " + z);
    }

    public static void i(boolean z) {
        o oVar = new o();
        oVar.a("turn_on", Boolean.valueOf(z));
        a.a("new_post_save_album_button_click", oVar);
        a.b("FeedsUploadDataHelper %s", "new_post_save_album_button_click: " + z);
    }

    public static void t() {
        a.a("new_post_post_button_click", new o());
        a.b("FeedsUploadDataHelper %s", "new_post_post_button_click");
    }

    public static void a(ImageCompressUploadParams imageCompressUploadParams) {
        o oVar = new o();
        oVar.a("feed_id", imageCompressUploadParams.getFeed_id());
        oVar.a("original_resolution", imageCompressUploadParams.getOriginal_resolution());
        oVar.a("original_file_size", (Number) Integer.valueOf(imageCompressUploadParams.getOriginal_file_size()));
        oVar.a("crop_screen_resolution", imageCompressUploadParams.getCrop_screen_resolution());
        oVar.a("crop_file_size", (Number) Integer.valueOf(imageCompressUploadParams.getCrop_file_size()));
        oVar.a("default_screen_resolution", imageCompressUploadParams.getDefault_screen_resolution());
        oVar.a("default_file_size", (Number) Integer.valueOf(imageCompressUploadParams.getDefault_file_size()));
        oVar.a("default_compress_quality", (Number) Integer.valueOf(imageCompressUploadParams.getDefault_compress_quality()));
        oVar.a("final_resolution", imageCompressUploadParams.getFinal_resolution());
        oVar.a("final_file_size", (Number) Integer.valueOf(imageCompressUploadParams.getFinal_file_size()));
        oVar.a("final_compress_quality", (Number) Integer.valueOf(imageCompressUploadParams.getFinal_compress_quality()));
        oVar.a(MessengerShareContentUtility.IMAGE_URL, imageCompressUploadParams.getImage_url());
        oVar.a("hit_size", (Number) Integer.valueOf(imageCompressUploadParams.getHit_size()));
        oVar.a("hit_quality", (Number) Integer.valueOf(imageCompressUploadParams.getHit_quality()));
        oVar.a("from", (Number) Integer.valueOf(imageCompressUploadParams.getFrom()));
        a.a("edit_photo_image_compress_upload", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_photo_image_compress_upload");
    }

    public static void a(VideoCompressUploadEntity videoCompressUploadEntity) {
        if (!d.a(videoCompressUploadEntity.getVideo_url())) {
            o oVar = new o();
            oVar.a("feed_id", videoCompressUploadEntity.getFeed_id());
            oVar.a("video_original_resolution", videoCompressUploadEntity.getVideo_original_resolution());
            oVar.a("video_duration", (Number) Integer.valueOf(videoCompressUploadEntity.getVideo_duration()));
            oVar.a("video_original_file_size", (Number) Integer.valueOf(videoCompressUploadEntity.getVideo_original_file_size()));
            oVar.a("video_max_width", (Number) Integer.valueOf(videoCompressUploadEntity.getVideo_max_width()));
            oVar.a("hit_duration", (Number) Integer.valueOf(videoCompressUploadEntity.getHit_duration()));
            oVar.a("hit_bitrate", (Number) Integer.valueOf(videoCompressUploadEntity.getHit_bitrate()));
            oVar.a("compression_cost_time", (Number) Float.valueOf(videoCompressUploadEntity.getCompression_cost_time()));
            oVar.a("video_output_resolution", videoCompressUploadEntity.getVideo_output_resolution());
            oVar.a("video_output_file_size", (Number) Integer.valueOf(videoCompressUploadEntity.getVideo_output_file_size()));
            oVar.a("video_url", videoCompressUploadEntity.getVideo_url());
            a.a("edit_video_compress_upload", oVar);
            a.b("FeedsUploadDataHelper %s", "edit_video_compress_upload");
        }
    }

    public static void j(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("prodcut_tag_search_view", oVar);
        a.b("FeedsUploadDataHelper %s", "prodcut_tag_search_view");
    }

    public static void a(String str, int i) {
        o oVar = new o();
        oVar.a("user_input", str);
        oVar.a("browse_location", (Number) Integer.valueOf(i));
        a.a("prodcut_tag_search_click_cancel", oVar);
        a.b("FeedsUploadDataHelper %s", "prodcut_tag_search_click_cancel: " + str + "," + i);
    }

    private static String b(com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar.f27738a == 0) {
            if (aVar.f27739b == 1) {
                return "nearby";
            }
            return "relevance";
        } else if (aVar.f27738a == 1) {
            return "latest";
        } else {
            if (aVar.f27738a == 2) {
                return "top_sales";
            }
            if (aVar.f27738a == 3) {
                return "price";
            }
            return "relevance";
        }
    }

    private static boolean a(HashSet<String> hashSet, String str) {
        if (hashSet == null || hashSet.size() <= 0 || !hashSet.contains(str)) {
            return false;
        }
        return true;
    }

    public static void a(String str, com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar != null) {
            o oVar = new o();
            oVar.a("user_input", str);
            o oVar2 = new o();
            oVar2.a("sortBy", b(aVar));
            if (aVar.f27738a == 3) {
                if (aVar.f27740c == 1) {
                    oVar2.a("order", "desc");
                } else {
                    oVar2.a("order", "asc");
                }
            }
            HashSet<String> hashSet = aVar.f27741d;
            oVar2.a("mall", Boolean.valueOf(a(hashSet, "mall")));
            oVar2.a("preferred", Boolean.valueOf(a(hashSet, "preferred")));
            oVar2.a("servicebyshopee_24h", Boolean.valueOf(a(hashSet, "24H")));
            oVar.a("search_params", (l) oVar2);
            a.a("action_search_in_product_tag_search_bar", oVar);
            a.b("FeedsUploadDataHelper %s", "action_search_in_product_tag_search_bar: " + oVar.toString());
        }
    }

    public static void a(String str, int i, int i2, String str2, com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar != null) {
            o oVar = new o();
            oVar.a("itemid", str);
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
            oVar.a("user_input", str2);
            o oVar2 = new o();
            oVar2.a("sortBy", b(aVar));
            if (aVar.f27738a == 3) {
                if (aVar.f27740c == 1) {
                    oVar2.a("order", "desc");
                } else {
                    oVar2.a("order", "asc");
                }
            }
            HashSet<String> hashSet = aVar.f27741d;
            oVar2.a("mall", Boolean.valueOf(a(hashSet, "mall")));
            oVar2.a("preferred", Boolean.valueOf(a(hashSet, "preferred")));
            oVar2.a("servicebyshopee_24h", Boolean.valueOf(a(hashSet, "24H")));
            oVar.a("search_params", (l) oVar2);
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar3 = new o();
            oVar3.a("viewed_objects", (l) iVar);
            a.a("prodcut_tag_search_impression", oVar3);
            a.b("FeedsUploadDataHelper %s", "prodcut_tag_search_impression: " + oVar3.toString());
        }
    }

    public static void b(String str, int i, int i2, String str2, com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar != null) {
            o oVar = new o();
            oVar.a("itemid", str);
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
            oVar.a("user_input", str2);
            o oVar2 = new o();
            oVar2.a("sortBy", b(aVar));
            if (aVar.f27738a == 3) {
                if (aVar.f27740c == 1) {
                    oVar2.a("order", "desc");
                } else {
                    oVar2.a("order", "asc");
                }
            }
            HashSet<String> hashSet = aVar.f27741d;
            oVar2.a("mall", Boolean.valueOf(a(hashSet, "mall")));
            oVar2.a("preferred", Boolean.valueOf(a(hashSet, "preferred")));
            oVar2.a("servicebyshopee_24h", Boolean.valueOf(a(hashSet, "24H")));
            oVar.a("search_params", (l) oVar2);
            a.a("prodcut_tag_search_click_item", oVar);
        }
    }

    public static void a(com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar != null) {
            o oVar = new o();
            oVar.a("sortBy", b(aVar));
            if (aVar.f27738a == 3) {
                if (aVar.f27740c == 1) {
                    oVar.a("order", "desc");
                } else {
                    oVar.a("order", "asc");
                }
            }
            HashSet<String> hashSet = aVar.f27741d;
            oVar.a("mall", Boolean.valueOf(a(hashSet, "mall")));
            oVar.a("preferred", Boolean.valueOf(a(hashSet, "preferred")));
            oVar.a("servicebyshopee_24h", Boolean.valueOf(a(hashSet, "24H")));
            o oVar2 = new o();
            oVar2.a("search_params", (l) oVar);
            a.a("action_product_tag_filter", oVar2);
            a.b("FeedsUploadDataHelper %s", "action_product_tag_filter: " + oVar2.toString());
        }
    }

    public static void a(String str, boolean z, com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar != null) {
            o oVar = new o();
            oVar.a("filter_name", str);
            oVar.a("selected", Boolean.valueOf(z));
            o oVar2 = new o();
            oVar2.a("sortBy", b(aVar));
            if (aVar.f27738a == 3) {
                if (aVar.f27740c == 1) {
                    oVar2.a("order", "desc");
                } else {
                    oVar2.a("order", "asc");
                }
            }
            HashSet<String> hashSet = aVar.f27741d;
            oVar2.a("mall", Boolean.valueOf(a(hashSet, "mall")));
            oVar2.a("preferred", Boolean.valueOf(a(hashSet, "preferred")));
            oVar2.a("servicebyshopee_24h", Boolean.valueOf(a(hashSet, "24H")));
            oVar.a("search_params", (l) oVar2);
            a.a("prodcut_tag_search_click_filter_button", oVar);
            a.b("FeedsUploadDataHelper %s", "prodcut_tag_search_click_filter_button: " + oVar.toString());
        }
    }

    public static void b(String str, com.shopee.feeds.feedlibrary.data.e.a aVar) {
        if (aVar != null) {
            o oVar = new o();
            oVar.a("user_input", str);
            o oVar2 = new o();
            oVar2.a("sortBy", b(aVar));
            if (aVar.f27738a == 3) {
                if (aVar.f27740c == 1) {
                    oVar2.a("order", "desc");
                } else {
                    oVar2.a("order", "asc");
                }
            }
            HashSet<String> hashSet = aVar.f27741d;
            oVar2.a("mall", Boolean.valueOf(a(hashSet, "mall")));
            oVar2.a("preferred", Boolean.valueOf(a(hashSet, "preferred")));
            oVar2.a("servicebyshopee_24h", Boolean.valueOf(a(hashSet, "24H")));
            oVar.a("search_params", (l) oVar2);
            i iVar = new i();
            iVar.a((l) oVar);
            o oVar3 = new o();
            oVar3.a("viewed_objects", (l) iVar);
            a.a("prodcut_tag_search_impression_try_to_search_others", oVar3);
            a.b("FeedsUploadDataHelper %s", "prodcut_tag_search_impression_try_to_search_others: " + oVar3.toString());
        }
    }

    public static void k(boolean z) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        a.a("edit_video_view", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_video_view");
    }

    public static void l(boolean z) {
        o oVar = new o();
        oVar.a("tap_to_play", Boolean.valueOf(z));
        a.a("edit_video_click_video", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_video_click_video");
    }

    public static void u() {
        a.a("edit_video_click_add_tag", new o());
        a.b("FeedsUploadDataHelper %s", "edit_video_click_add_tag");
    }

    public static void v() {
        a.a("edit_video_click_add_text", new o());
        a.b("FeedsUploadDataHelper %s", "edit_video_click_add_text");
    }

    public static void w() {
        a.a("edit_video_click_add_sticker", new o());
        a.b("FeedsUploadDataHelper %s", "edit_video_click_add_sticker");
    }

    public static void m(boolean z) {
        o oVar = new o();
        oVar.a("open_sound", Boolean.valueOf(z));
        a.a("edit_video_click_video_sound", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_video_click_video_sound");
    }

    public static void a(String str, int i, int i2) {
        o oVar = new o();
        oVar.a("itemid", str);
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        a.a("edit_video_impression", oVar2);
        a.b("FeedsUploadDataHelper %s", "edit_video_impression");
    }

    public static void b(String str, int i, int i2) {
        o oVar = new o();
        oVar.a("itemid", str);
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        a.a("edit_video_click_delete_item_tag", oVar);
        a.b("FeedsUploadDataHelper %s", "edit_video_click_delete_item_tag");
    }

    public static void x() {
        a.a("edit_video_click_next_button", new o());
        a.b("FeedsUploadDataHelper %s", "edit_video_click_next_button");
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        o oVar = new o();
        o oVar2 = new o();
        if (z) {
            oVar2.a("is_back", (Boolean) false);
            oVar2.a("is_initial", (Boolean) true);
        } else {
            oVar2.a("is_back", (Boolean) true);
            oVar2.a("is_initial", (Boolean) false);
        }
        oVar.a("view_common", (l) oVar2);
        oVar.a("is_empty", Boolean.valueOf(z2));
        oVar.a("start_connect", Boolean.valueOf(z3));
        a.a("select_instagram_page_view", oVar);
        a.b("FeedsUploadDataHelper %s", "select_photo_show");
    }

    public static void g(int i) {
        o oVar = new o();
        oVar.a("tabid", (Number) Integer.valueOf(i));
        a.a("select_instagram_click_tab", oVar);
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_tab");
    }

    public static void y() {
        a.a("select_instagram_click_connect", new o());
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_connect");
    }

    public static void z() {
        o oVar = new o();
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        a.a("select_instagram_impression_connect", oVar2);
        a.b("FeedsUploadDataHelper %s", "select_instagram_impression_connect");
    }

    public static void A() {
        a.a("select_instagram_click_resize_button", new o());
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_resize_button");
    }

    public static void B() {
        a.a("select_instagram_click_switch_button", new o());
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_switch_button");
    }

    public static void b(boolean z, boolean z2) {
        o oVar = new o();
        oVar.a("is_empty", Boolean.valueOf(z));
        oVar.a("start_connect", Boolean.valueOf(z2));
        a.a("select_instagram_click_close_button", oVar);
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_close_button");
    }

    public static void C() {
        a.a("select_instagram_click_next_button", new o());
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_next_button");
    }

    public static void D() {
        o oVar = new o();
        i iVar = new i();
        iVar.a((l) oVar);
        o oVar2 = new o();
        oVar2.a("viewed_objects", (l) iVar);
        a.a("select_instagram_impression_fail_load", oVar2);
        a.b("FeedsUploadDataHelper %s", "select_instagram_impression_fail_load");
    }

    public static void E() {
        a.a("select_instagram_click_retry_button", new o());
        a.b("FeedsUploadDataHelper %s", "select_instagram_click_retry_button");
    }
}
