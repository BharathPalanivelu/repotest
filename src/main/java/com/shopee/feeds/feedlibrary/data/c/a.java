package com.shopee.feeds.feedlibrary.data.c;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.garena.android.appkit.tools.b;
import com.google.a.f;
import com.shopee.feeds.feedlibrary.a.a.c;
import com.shopee.feeds.feedlibrary.a.a.d;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.BaseUploadEntity;
import com.shopee.feeds.feedlibrary.data.entity.ImageEntity;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.SignatureEntity;
import com.shopee.feeds.feedlibrary.data.entity.UpLoadImageEntity;
import com.shopee.feeds.feedlibrary.data.entity.UpLoadVideoEntity;
import com.shopee.feeds.feedlibrary.data.entity.UserEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.editor.sticker.a.e;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27661a;

    /* renamed from: com.shopee.feeds.feedlibrary.data.c.a$a  reason: collision with other inner class name */
    public interface C0425a {
        void a(int i);
    }

    public a(Context context) {
        this.f27661a = context;
    }

    public void a(ArrayList<String> arrayList, int i, boolean z, final com.shopee.feeds.feedlibrary.a.a aVar) {
        d.a aVar2 = new d.a(this.f27661a);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hashMap.put(UriUtil.LOCAL_FILE_SCHEME + i2, arrayList.get(i2));
        }
        aVar2.a(b.o).a((HashMap<String, String>) hashMap).a().a(i);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        ArrayList arrayList = (ArrayList) new f().a(new JSONArray(cVar.a()).toString(), new com.google.a.c.a<ArrayList<ImageEntity>>() {
                        }.getType());
                        if (arrayList != null && arrayList.size() > 0 && aVar != null) {
                            aVar.a(arrayList, "from_network");
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void a(int i, String str) {
                if (aVar != null) {
                    aVar.a(b.e(c.g.feeds_network_error_toast));
                }
            }
        });
        aVar2.f().a();
    }

    public void a(UpLoadImageEntity upLoadImageEntity, int i, boolean z, final com.shopee.feeds.feedlibrary.a.a aVar, PhotoEditEntity photoEditEntity) {
        String str;
        d.a aVar2 = new d.a(this.f27661a);
        if (photoEditEntity.isFromBuyerReview()) {
            str = b.i;
        } else {
            str = b.f27686g;
        }
        aVar2.a(str).a().d().a((Object) upLoadImageEntity).a(i);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a("", "");
                    }
                }
            }

            public void a(int i, String str) {
                String str2;
                if (i == 1510005) {
                    h.a("", "PostStatusTask feed already exists");
                    aVar.a("", "");
                    return;
                }
                switch (i) {
                    case 1100101:
                    case 1100305:
                    case 1100700:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100101);
                        break;
                    case 1100400:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100400);
                        break;
                    case 1100500:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100500);
                        break;
                    case 1100503:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100503);
                        break;
                    default:
                        str2 = b.e(c.g.feeds_network_error_toast);
                        break;
                }
                com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str2);
                }
            }
        });
        aVar2.f().a();
    }

    public void a(UpLoadImageEntity upLoadImageEntity, int i, final com.shopee.feeds.feedlibrary.a.a aVar) {
        String str;
        d.a aVar2 = new d.a(this.f27661a);
        if (j.a().w()) {
            str = b.u;
        } else {
            str = b.t;
        }
        aVar2.a(str).a().d().a((Object) upLoadImageEntity).a(i);
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a("", "");
                    }
                }
            }

            public void a(int i, String str) {
                String str2;
                switch (i) {
                    case 1100101:
                    case 1100305:
                    case 1100700:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100101);
                        break;
                    case 1100400:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100400);
                        break;
                    case 1100500:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100500);
                        break;
                    case 1100503:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100503);
                        break;
                    default:
                        str2 = b.e(c.g.feeds_network_error_toast);
                        break;
                }
                com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str2);
                }
            }
        });
        aVar2.f().a();
    }

    public void a(UpLoadVideoEntity upLoadVideoEntity, int i, final com.shopee.feeds.feedlibrary.a.a aVar) {
        d.a aVar2 = new d.a(this.f27661a);
        aVar2.a(b.v).a().d().a((Object) upLoadVideoEntity).a(i);
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a("", "");
                    }
                }
            }

            public void a(int i, String str) {
                String str2;
                switch (i) {
                    case 1100101:
                    case 1100305:
                    case 1100700:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100101);
                        break;
                    case 1100400:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100400);
                        break;
                    case 1100500:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100500);
                        break;
                    case 1100503:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100503);
                        break;
                    default:
                        str2 = b.e(c.g.feeds_network_error_toast);
                        break;
                }
                com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str2);
                }
            }
        });
        aVar2.f().a();
    }

    public void a(final VideoEditEntity videoEditEntity, final C0425a aVar) {
        d.a aVar2 = new d.a(this.f27661a);
        aVar2.a(b.p).b().a(3);
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar == null) {
                    aVar.a(-1);
                    return;
                }
                try {
                    SignatureEntity signatureEntity = (SignatureEntity) new f().a(new JSONObject(cVar.a()).toString(), SignatureEntity.class);
                    if (signatureEntity != null) {
                        videoEditEntity.setSignature(signatureEntity.getSign());
                        aVar.a(0);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    aVar.a(-1);
                }
            }

            public void a(int i, String str) {
                aVar.a(-1);
                h.b("", "");
            }
        });
        aVar2.f().a();
    }

    public void a(UpLoadVideoEntity upLoadVideoEntity, int i, boolean z, final com.shopee.feeds.feedlibrary.a.a aVar) {
        d.a aVar2 = new d.a(this.f27661a);
        aVar2.a(b.h).a().d().a((Object) upLoadVideoEntity).a(i);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a("", "");
                    }
                }
            }

            public void a(int i, String str) {
                String str2;
                if (i == 1510005) {
                    h.a("", "PostStatusTask feeds already exits ");
                    aVar.a("", "");
                    return;
                }
                switch (i) {
                    case 1100101:
                    case 1100305:
                    case 1100700:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100101);
                        break;
                    case 1100400:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100400);
                        break;
                    case 1100500:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100500);
                        break;
                    case 1100503:
                        str2 = b.e(c.g.feeds_create_post_server_error_1100503);
                        break;
                    default:
                        str2 = b.e(c.g.feeds_network_error_toast);
                        break;
                }
                com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str2);
                }
            }
        });
        aVar2.f().a();
    }

    public void a(int i, boolean z, final com.shopee.feeds.feedlibrary.a.a aVar) {
        d.a aVar2 = new d.a(this.f27661a);
        aVar2.a(b.j).b().a(i);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    String a2 = cVar.a();
                    if (!com.shopee.feeds.feedlibrary.util.d.a(a2)) {
                        aVar.a(a2, "net");
                    }
                }
            }

            public void a(int i, String str) {
                if (aVar != null) {
                    aVar.a(b.e(c.g.feeds_network_error_toast));
                }
            }
        });
        aVar2.f().a();
    }

    public void b(int i, boolean z, final com.shopee.feeds.feedlibrary.a.a aVar) {
        d.a aVar2 = new d.a(this.f27661a);
        aVar2.a(b.q).b().e().a(i);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>) new com.shopee.feeds.feedlibrary.a.a.a<com.shopee.feeds.feedlibrary.a.a.c>() {
            public void a(com.shopee.feeds.feedlibrary.a.a.c cVar, String str) {
                if (cVar != null) {
                    try {
                        UserEntity userEntity = (UserEntity) new f().a(new JSONObject(cVar.a()).toString(), UserEntity.class);
                        if (userEntity != null && aVar != null) {
                            aVar.a(userEntity, "from_network");
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void a(int i, String str) {
                com.shopee.feeds.feedlibrary.a.a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str);
                }
            }
        });
        aVar2.f().a();
    }

    private void a(HashMap<String, String> hashMap, ArrayList<String> arrayList) {
        if (hashMap == null || hashMap.size() <= 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                hashMap.put(arrayList.get(i), (Object) null);
            }
        }
    }

    private void b(HashMap<String, Integer[]> hashMap, ArrayList<String> arrayList) {
        if (hashMap == null || hashMap.size() <= 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                hashMap.put(arrayList.get(i), (Object) null);
            }
        }
    }

    private void a(LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> linkedHashMap, ArrayList<String> arrayList) {
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                linkedHashMap.put(arrayList.get(i), (Object) null);
            }
        }
    }

    private void b(LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.text.b>> linkedHashMap, ArrayList<String> arrayList) {
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                linkedHashMap.put(arrayList.get(i), (Object) null);
            }
        }
    }

    private void c(LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>> linkedHashMap, ArrayList<String> arrayList) {
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                linkedHashMap.put(arrayList.get(i), (Object) null);
            }
        }
    }

    private void a(String str, StringBuilder sb, int i) {
        sb.append(str);
        sb.append(":");
        sb.append(String.valueOf(i));
        sb.append(";");
    }

    private void a(StringBuilder sb, StringBuilder sb2) {
        if (!com.shopee.feeds.feedlibrary.util.d.a(sb2.toString())) {
            sb.append(sb2.toString());
        }
    }

    private String a(String str) {
        return (com.shopee.feeds.feedlibrary.util.d.a(str) || !";".equals(String.valueOf(str.charAt(str.length() + -1)))) ? "" : str.substring(0, str.length() - 1);
    }

    public UpLoadImageEntity a(String str, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, String str2, HashMap<String, String> hashMap, PhotoEditEntity photoEditEntity, ArrayList<String> arrayList3, ArrayList<String> arrayList4) {
        UpLoadImageEntity upLoadImageEntity = new UpLoadImageEntity();
        UpLoadImageEntity upLoadImageEntity2 = new UpLoadImageEntity();
        upLoadImageEntity2.getClass();
        UpLoadImageEntity.PostContent postContent = new UpLoadImageEntity.PostContent();
        postContent.setCaption(str);
        postContent.setHashtags(arrayList);
        postContent.setMentions(arrayList2);
        postContent.setImages(a(hashMap, photoEditEntity, arrayList3));
        postContent.setIns_urls(arrayList4);
        upLoadImageEntity.setContent(postContent);
        upLoadImageEntity.setFeed_id(str2);
        if (c.f27687a == 1) {
            com.shopee.sdk.modules.app.a.a a2 = com.shopee.sdk.b.a().a().a();
            upLoadImageEntity.setApp_version(a2.a());
            upLoadImageEntity.setDevice_model(a2.g());
            upLoadImageEntity.setSystem_os("Android");
            upLoadImageEntity.setSystem_version(a2.f());
        }
        return upLoadImageEntity;
    }

    private ArrayList<UpLoadImageEntity.Image> a(HashMap<String, String> hashMap, PhotoEditEntity photoEditEntity, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = arrayList;
        ArrayList<UpLoadImageEntity.Image> arrayList3 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            UpLoadImageEntity upLoadImageEntity = new UpLoadImageEntity();
            upLoadImageEntity.getClass();
            UpLoadImageEntity.Image image = new UpLoadImageEntity.Image();
            b(arrayList2.get(i), arrayList2, photoEditEntity.getCleanEditImageSizeMap(), image);
            a(arrayList2.get(i), arrayList2, photoEditEntity.getMainColorMap(), image);
            a(arrayList2.get(i), hashMap, photoEditEntity.getTagInfoMap(), image, arrayList, sb3);
            UpLoadImageEntity.Image image2 = image;
            ArrayList<String> arrayList4 = arrayList;
            a(arrayList2.get(i), photoEditEntity.getTextInfoMap(), image2, arrayList4, sb2);
            b(arrayList2.get(i), photoEditEntity.getStickerInfoMap(), image2, arrayList4, sb4);
            a(sb, sb4);
            a(sb, sb3);
            image.setSource(photoEditEntity.getSource());
            image.setDisplay_hierarchy(a(sb.toString()));
            arrayList3.add(image);
        }
        return arrayList3;
    }

    private void a(String str, ArrayList<String> arrayList, HashMap<String, String> hashMap, UpLoadImageEntity.Image image) {
        a(hashMap, arrayList);
        for (Map.Entry next : hashMap.entrySet()) {
            String str2 = (String) next.getKey();
            if (!com.shopee.feeds.feedlibrary.util.d.a(str2) && str.equals(str2)) {
                String str3 = (String) next.getValue();
                if (!com.shopee.feeds.feedlibrary.util.d.a(str3)) {
                    image.setMain_color(str3);
                }
            }
        }
    }

    private void b(String str, ArrayList<String> arrayList, HashMap<String, Integer[]> hashMap, UpLoadImageEntity.Image image) {
        b(hashMap, arrayList);
        for (Map.Entry next : hashMap.entrySet()) {
            String str2 = (String) next.getKey();
            if (!com.shopee.feeds.feedlibrary.util.d.a(str2) && str.equals(str2)) {
                Integer[] numArr = (Integer[]) next.getValue();
                if (numArr != null && numArr.length > 0) {
                    image.setWidth(numArr[0].intValue());
                    image.setHeight(numArr[1].intValue());
                }
            }
        }
    }

    private void a(String str, HashMap<String, String> hashMap, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> linkedHashMap, UpLoadImageEntity.Image image, ArrayList<String> arrayList, StringBuilder sb) {
        a(linkedHashMap, arrayList);
        for (Map.Entry next : linkedHashMap.entrySet()) {
            if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey()) && str.equals(next.getKey())) {
                image.setUrl(a(new File((String) next.getKey()).getName(), hashMap));
                ArrayList arrayList2 = (ArrayList) next.getValue();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                StringBuilder sb2 = new StringBuilder();
                int i = -1;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        if (((com.shopee.feeds.feedlibrary.editor.tag.a) arrayList2.get(i2)).m() == 1) {
                            com.shopee.feeds.feedlibrary.editor.tag.b bVar = (com.shopee.feeds.feedlibrary.editor.tag.b) arrayList2.get(i2);
                            BaseUploadEntity baseUploadEntity = new BaseUploadEntity();
                            baseUploadEntity.getClass();
                            BaseUploadEntity.ImageTag imageTag = new BaseUploadEntity.ImageTag();
                            imageTag.setPos_x(bVar.c());
                            imageTag.setPos_y(bVar.d());
                            imageTag.setShop_id(bVar.p());
                            imageTag.setItem_id(bVar.o());
                            arrayList4.add(imageTag);
                            i++;
                            a("1", sb2, i);
                        }
                    }
                }
                image.setItem_tags(arrayList4);
                image.setUser_tags(arrayList3);
                a(sb, sb2);
            }
        }
    }

    private void a(String str, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.text.b>> linkedHashMap, UpLoadImageEntity.Image image, ArrayList<String> arrayList, StringBuilder sb) {
        b(linkedHashMap, arrayList);
        for (Map.Entry next : linkedHashMap.entrySet()) {
            if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey()) && str.equals(next.getKey())) {
                ArrayList arrayList2 = (ArrayList) next.getValue();
                ArrayList arrayList3 = new ArrayList();
                StringBuilder sb2 = new StringBuilder();
                int i = -1;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        com.shopee.feeds.feedlibrary.editor.text.b bVar = (com.shopee.feeds.feedlibrary.editor.text.b) arrayList2.get(i2);
                        BaseUploadEntity baseUploadEntity = new BaseUploadEntity();
                        baseUploadEntity.getClass();
                        BaseUploadEntity.Text text = new BaseUploadEntity.Text();
                        text.setPos_x(bVar.h());
                        text.setPos_y(bVar.i());
                        text.setFont_size(28);
                        text.setContent(bVar.m());
                        if (bVar.n() > 0) {
                            text.setFont_color(w.a(b.e(bVar.n())));
                        }
                        if (bVar.o() > 0) {
                            text.setBackground_color(w.a(b.e(bVar.o())));
                        }
                        text.setRotate(bVar.l());
                        text.setScale(bVar.j());
                        text.setFix_scale(bVar.k());
                        arrayList3.add(text);
                        i++;
                        a(BaseUploadEntity.TYPE_INPUT_TEXT, sb2, i);
                    }
                }
                image.setTexts(arrayList3);
                a(sb, sb2);
            }
        }
    }

    private void b(String str, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>> linkedHashMap, UpLoadImageEntity.Image image, ArrayList<String> arrayList, StringBuilder sb) {
        Iterator<Map.Entry<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>>> it;
        StringBuilder sb2;
        StringBuilder sb3;
        UpLoadImageEntity.Image image2 = image;
        StringBuilder sb4 = sb;
        c(linkedHashMap, arrayList);
        Iterator<Map.Entry<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>>> it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey())) {
                if (str.equals(next.getKey())) {
                    ArrayList arrayList2 = (ArrayList) next.getValue();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    StringBuilder sb7 = new StringBuilder();
                    StringBuilder sb8 = new StringBuilder();
                    if (arrayList2 == null || arrayList2.size() <= 0) {
                        it = it2;
                    } else {
                        int i = 0;
                        int i2 = -1;
                        it = it2;
                        int i3 = -1;
                        int i4 = -1;
                        int i5 = -1;
                        while (i < arrayList2.size()) {
                            BaseUploadEntity baseUploadEntity = new BaseUploadEntity();
                            baseUploadEntity.getClass();
                            BaseUploadEntity.Sticker sticker = new BaseUploadEntity.Sticker();
                            com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) arrayList2.get(i);
                            ArrayList arrayList8 = arrayList2;
                            sticker.setPos_x(dVar.h());
                            sticker.setPos_y(dVar.i());
                            sticker.setScale(dVar.j());
                            sticker.setFix_scale(dVar.k());
                            sticker.setRotate(dVar.l());
                            int q = dVar.q();
                            if (q == 1) {
                                sb3 = sb6;
                                sticker.setId(((com.shopee.feeds.feedlibrary.editor.sticker.a.c) dVar).s());
                                arrayList4.add(sticker);
                            } else if (q != 2) {
                                sb3 = sb6;
                                if (q == 3) {
                                    com.shopee.feeds.feedlibrary.editor.sticker.a.f fVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.f) dVar;
                                    sticker.setVoucher_code(fVar.w());
                                    sticker.setVoucher_count(5);
                                    sticker.setSignature(fVar.v());
                                    sticker.setPromotion_id(fVar.u());
                                    arrayList3.add(sticker);
                                    int i6 = i3 + 1;
                                    a(BaseUploadEntity.TYPE_VOUCHER_STICKER, sb5, i6);
                                    i3 = i6;
                                } else if (q == 4) {
                                    com.shopee.feeds.feedlibrary.editor.sticker.a.b bVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.b) dVar;
                                    sticker.setQuestion(bVar.x());
                                    if (!com.shopee.feeds.feedlibrary.util.d.a(bVar.u())) {
                                        sticker.setPromotion_id(bVar.u());
                                        sticker.setSignature(bVar.v());
                                        sticker.setVoucher_code(bVar.w());
                                        sticker.setVoucher_count(5);
                                    }
                                    arrayList6.add(sticker);
                                    int i7 = i5 + 1;
                                    a(BaseUploadEntity.TYPE_COMMENT_STICKER, sb5, i7);
                                    i5 = i7;
                                } else if (q == 5) {
                                    com.shopee.feeds.feedlibrary.editor.sticker.a.a aVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.a) dVar;
                                    sticker.setCmt_id(aVar.m());
                                    sticker.setComment(aVar.p());
                                    arrayList7.add(sticker);
                                    int i8 = i4 + 1;
                                    a(BaseUploadEntity.TYPE_RATE_STICKER, sb8, i8);
                                    i4 = i8;
                                }
                            } else {
                                sb3 = sb6;
                                sticker.setUser_id(((e) dVar).t());
                                arrayList5.add(sticker);
                                int i9 = i2 + 1;
                                a("3", sb7, i9);
                                i2 = i9;
                            }
                            i++;
                            String str2 = str;
                            arrayList2 = arrayList8;
                            StringBuilder sb9 = sb;
                            sb6 = sb3;
                        }
                    }
                    image2.setVoucher_stickers(arrayList3);
                    image2.setSubscript_stickers(arrayList4);
                    image2.setMention_stickers(arrayList5);
                    image2.setComment_stickers(arrayList6);
                    image2.setRating_stickers(arrayList7);
                    sb2 = sb;
                    a(sb2, sb6);
                    a(sb2, sb7);
                    a(sb2, sb5);
                    a(sb2, sb8);
                    sb4 = sb2;
                    it2 = it;
                }
            }
            it = it2;
            sb2 = sb4;
            sb4 = sb2;
            it2 = it;
        }
    }

    private String a(String str, HashMap<String, String> hashMap) {
        return (com.shopee.feeds.feedlibrary.util.d.a(str) || hashMap.size() <= 0) ? "" : hashMap.get(str);
    }

    public UpLoadVideoEntity a(String str, String str2, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, String str3, VideoEditEntity videoEditEntity, ArrayList<String> arrayList3) {
        UpLoadVideoEntity upLoadVideoEntity = new UpLoadVideoEntity();
        upLoadVideoEntity.setFeed_id(str3);
        UpLoadVideoEntity upLoadVideoEntity2 = new UpLoadVideoEntity();
        upLoadVideoEntity2.getClass();
        UpLoadVideoEntity.Content content = new UpLoadVideoEntity.Content();
        content.setCaption(str2);
        content.setHashtags(arrayList);
        content.setMentions(arrayList2);
        content.setVideo_url(str);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(videoEditEntity.getImageWaterMarkUploadUrl());
        arrayList4.add(videoEditEntity.getVideoWaterMarkUploadUrl());
        content.setIns_urls(arrayList4);
        content.setCover(videoEditEntity.getCoverUploadUrl());
        content.setDuration(videoEditEntity.getDuration());
        content.setVideo(a(videoEditEntity, arrayList3));
        upLoadVideoEntity.setContent(content);
        if (c.f27687a == 1) {
            com.shopee.sdk.modules.app.a.a a2 = com.shopee.sdk.b.a().a().a();
            upLoadVideoEntity.setApp_version(a2.a());
            upLoadVideoEntity.setDevice_model(a2.g());
            upLoadVideoEntity.setSystem_os("Android");
            upLoadVideoEntity.setSystem_version(a2.f());
        }
        return upLoadVideoEntity;
    }

    private UpLoadVideoEntity.Video a(VideoEditEntity videoEditEntity, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = arrayList;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        UpLoadVideoEntity upLoadVideoEntity = new UpLoadVideoEntity();
        upLoadVideoEntity.getClass();
        UpLoadVideoEntity.Video video = new UpLoadVideoEntity.Video();
        a(arrayList2.get(0), videoEditEntity.getCleanEditImageSizeMap(), video);
        UpLoadVideoEntity.Video video2 = video;
        ArrayList<String> arrayList3 = arrayList;
        a(arrayList2.get(0), videoEditEntity.getTagInfoMap(), video2, arrayList3, sb3);
        b(arrayList2.get(0), videoEditEntity.getTextInfoMap(), video2, arrayList3, sb2);
        c(arrayList2.get(0), videoEditEntity.getStickerInfoMap(), video2, arrayList3, sb4);
        a(sb, sb4);
        a(sb, sb3);
        video.setDisplay_hierarchy(a(sb.toString()));
        return video;
    }

    private void a(String str, HashMap<String, Integer[]> hashMap, UpLoadVideoEntity.Video video) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry next : hashMap.entrySet()) {
                if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey()) && ((String) next.getKey()).equals(str)) {
                    Integer[] numArr = (Integer[]) next.getValue();
                    video.setWidth(numArr[0].intValue());
                    video.setHeight(numArr[1].intValue());
                }
            }
        }
    }

    private void a(String str, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> linkedHashMap, UpLoadVideoEntity.Video video, ArrayList<String> arrayList, StringBuilder sb) {
        a(linkedHashMap, arrayList);
        for (Map.Entry next : linkedHashMap.entrySet()) {
            if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey()) && str.equals(next.getKey())) {
                ArrayList arrayList2 = (ArrayList) next.getValue();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                StringBuilder sb2 = new StringBuilder();
                int i = -1;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        if (((com.shopee.feeds.feedlibrary.editor.tag.a) arrayList2.get(i2)).m() == 1) {
                            com.shopee.feeds.feedlibrary.editor.tag.b bVar = (com.shopee.feeds.feedlibrary.editor.tag.b) arrayList2.get(i2);
                            BaseUploadEntity baseUploadEntity = new BaseUploadEntity();
                            baseUploadEntity.getClass();
                            BaseUploadEntity.ImageTag imageTag = new BaseUploadEntity.ImageTag();
                            imageTag.setPos_x(bVar.c());
                            imageTag.setPos_y(bVar.d());
                            imageTag.setShop_id(bVar.p());
                            imageTag.setItem_id(bVar.o());
                            arrayList4.add(imageTag);
                            i++;
                            a("1", sb2, i);
                        }
                    }
                }
                video.setItem_tags(arrayList4);
                video.setUser_tags(arrayList3);
                a(sb, sb2);
            }
        }
    }

    private void b(String str, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.text.b>> linkedHashMap, UpLoadVideoEntity.Video video, ArrayList<String> arrayList, StringBuilder sb) {
        b(linkedHashMap, arrayList);
        for (Map.Entry next : linkedHashMap.entrySet()) {
            if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey()) && str.equals(next.getKey())) {
                ArrayList arrayList2 = (ArrayList) next.getValue();
                ArrayList arrayList3 = new ArrayList();
                StringBuilder sb2 = new StringBuilder();
                int i = -1;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        com.shopee.feeds.feedlibrary.editor.text.b bVar = (com.shopee.feeds.feedlibrary.editor.text.b) arrayList2.get(i2);
                        BaseUploadEntity baseUploadEntity = new BaseUploadEntity();
                        baseUploadEntity.getClass();
                        BaseUploadEntity.Text text = new BaseUploadEntity.Text();
                        text.setPos_x(bVar.h());
                        text.setPos_y(bVar.i());
                        text.setFont_size(28);
                        text.setContent(bVar.m());
                        if (bVar.n() > 0) {
                            text.setFont_color(w.a(b.e(bVar.n())));
                        }
                        if (bVar.o() > 0) {
                            text.setBackground_color(w.a(b.e(bVar.o())));
                        }
                        text.setRotate(bVar.l());
                        text.setScale(bVar.j());
                        text.setFix_scale(bVar.k());
                        arrayList3.add(text);
                        i++;
                        a(BaseUploadEntity.TYPE_INPUT_TEXT, sb2, i);
                    }
                }
                video.setTexts(arrayList3);
                a(sb, sb2);
            }
        }
    }

    private void c(String str, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>> linkedHashMap, UpLoadVideoEntity.Video video, ArrayList<String> arrayList, StringBuilder sb) {
        Iterator<Map.Entry<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>>> it;
        StringBuilder sb2;
        StringBuilder sb3;
        UpLoadVideoEntity.Video video2 = video;
        StringBuilder sb4 = sb;
        c(linkedHashMap, arrayList);
        Iterator<Map.Entry<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>>> it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getKey())) {
                if (str.equals(next.getKey())) {
                    ArrayList arrayList2 = (ArrayList) next.getValue();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    StringBuilder sb7 = new StringBuilder();
                    if (arrayList2 == null || arrayList2.size() <= 0) {
                        it = it2;
                    } else {
                        int i = 0;
                        int i2 = -1;
                        it = it2;
                        int i3 = -1;
                        int i4 = -1;
                        while (i < arrayList2.size()) {
                            BaseUploadEntity baseUploadEntity = new BaseUploadEntity();
                            baseUploadEntity.getClass();
                            BaseUploadEntity.Sticker sticker = new BaseUploadEntity.Sticker();
                            com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) arrayList2.get(i);
                            ArrayList arrayList7 = arrayList2;
                            sticker.setPos_x(dVar.h());
                            sticker.setPos_y(dVar.i());
                            sticker.setScale(dVar.j());
                            sticker.setFix_scale(dVar.k());
                            sticker.setRotate(dVar.l());
                            int q = dVar.q();
                            if (q == 1) {
                                sb3 = sb6;
                                sticker.setId(((com.shopee.feeds.feedlibrary.editor.sticker.a.c) dVar).s());
                                arrayList4.add(sticker);
                            } else if (q != 2) {
                                sb3 = sb6;
                                if (q == 3) {
                                    com.shopee.feeds.feedlibrary.editor.sticker.a.f fVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.f) dVar;
                                    sticker.setVoucher_code(fVar.w());
                                    sticker.setVoucher_count(5);
                                    sticker.setSignature(fVar.v());
                                    sticker.setPromotion_id(fVar.u());
                                    arrayList3.add(sticker);
                                    int i5 = i3 + 1;
                                    a(BaseUploadEntity.TYPE_VOUCHER_STICKER, sb5, i5);
                                    i3 = i5 + 1;
                                } else if (q == 4) {
                                    com.shopee.feeds.feedlibrary.editor.sticker.a.b bVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.b) dVar;
                                    sticker.setQuestion(bVar.x());
                                    if (!com.shopee.feeds.feedlibrary.util.d.a(bVar.u())) {
                                        sticker.setPromotion_id(bVar.u());
                                        sticker.setSignature(bVar.v());
                                        sticker.setVoucher_code(bVar.w());
                                        sticker.setVoucher_count(5);
                                    }
                                    arrayList6.add(sticker);
                                    int i6 = i4 + 1;
                                    a(BaseUploadEntity.TYPE_COMMENT_STICKER, sb5, i6);
                                    i4 = i6;
                                }
                            } else {
                                sb3 = sb6;
                                sticker.setUser_id(((e) dVar).t());
                                arrayList5.add(sticker);
                                i2++;
                                a("3", sb7, i2);
                            }
                            i++;
                            String str2 = str;
                            arrayList2 = arrayList7;
                            StringBuilder sb8 = sb;
                            sb6 = sb3;
                        }
                    }
                    video2.setVoucher_stickers(arrayList3);
                    video2.setSubscript_stickers(arrayList4);
                    video2.setMention_stickers(arrayList5);
                    video2.setComment_stickers(arrayList6);
                    sb2 = sb;
                    a(sb2, sb6);
                    a(sb2, sb7);
                    a(sb2, sb5);
                    sb4 = sb2;
                    it2 = it;
                }
            }
            it = it2;
            sb2 = sb4;
            sb4 = sb2;
            it2 = it;
        }
    }
}
