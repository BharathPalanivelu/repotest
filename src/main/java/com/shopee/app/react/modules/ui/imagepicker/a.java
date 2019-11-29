package com.shopee.app.react.modules.ui.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.app.react.util.image.ReactPhotoProxyActivity_;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse;
import com.shopee.react.sdk.bridge.protocol.ImageData;
import com.shopee.react.sdk.bridge.protocol.ImagePickerData;
import com.shopee.react.sdk.bridge.protocol.ImagePickerResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class a extends com.shopee.react.sdk.bridge.modules.ui.imagepicker.a {

    /* renamed from: a  reason: collision with root package name */
    private c<ImagePickerResult> f18856a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18857b;

    public a(Context context) {
        this.f18857b = context;
    }

    public void a(Activity activity, boolean z, ImagePickerData imagePickerData, c<ImagePickerResult> cVar) {
        boolean z2 = true;
        PhotoProxyActivity_.a b2 = PhotoProxyActivity_.a(activity).d(!z && !imagePickerData.isSelectFromInstagram()).e(!z && imagePickerData.isSelectFromInstagram()).a(z).b(imagePickerData.isAllowPreview());
        if (!z || !imagePickerData.isAllowCrop()) {
            z2 = false;
        }
        PhotoProxyActivity_.a h = b2.f(z2).f(imagePickerData.getMaxCount()).c(imagePickerData.isAllowCrop()).h(imagePickerData.isAllowEdit());
        if (imagePickerData.getCropData() != null) {
            ImagePickerData.CropData cropData = imagePickerData.getCropData();
            h.d(cropData.getWidthRatio()).e(cropData.getHeightRatio());
        }
        ReactPhotoProxyActivity_.a a2 = ReactPhotoProxyActivity_.a(activity);
        if (imagePickerData.getImageOption() != null) {
            ImagePickerData.ImageOption imageOption = imagePickerData.getImageOption();
            a2.b(imageOption.getWidth()).c(imageOption.getHeight()).d(imageOption.getQuality());
        }
        Intent b3 = a2.b();
        b3.putExtras(h.b());
        activity.startActivityForResult(b3, 75);
        this.f18856a = cVar;
    }

    private void a(List<String> list, List<ImageData> list2) {
        ArrayList arrayList = new ArrayList();
        for (String file : list) {
            arrayList.add(Uri.fromFile(new File(file)).toString());
        }
        this.f18856a.a(new ImagePickerResult(arrayList, list2, 1));
    }

    public void a(int i, int i2, Intent intent) {
        if (i != 75) {
            return;
        }
        if (i2 == -1) {
            a((List<String>) intent.getStringArrayListExtra("add_product_image_uri_list"), (List<ImageData>) intent.getParcelableArrayListExtra("IMAGE_DIMENSION_DATA"));
        } else {
            this.f18856a.a(new ImagePickerResult(0));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|23|39|40) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00d8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.app.Activity r17, com.shopee.react.sdk.bridge.protocol.GetRecentImageRequest r18, com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>> r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r19
            r0 = 4
            java.lang.String[] r5 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r9 = "_id"
            r5[r0] = r9
            r10 = 1
            java.lang.String r11 = "width"
            r5[r10] = r11
            r3 = 2
            java.lang.String r12 = "height"
            r5[r3] = r12
            r4 = 3
            java.lang.String r6 = "date_modified"
            r5[r4] = r6
            java.lang.String[] r13 = new java.lang.String[r4]
            r13[r0] = r9
            r13[r10] = r11
            r13[r3] = r12
            android.content.ContentResolver r3 = r17.getContentResolver()     // Catch:{ Exception -> 0x00f2 }
            android.net.Uri r4 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x00f2 }
            r6 = 0
            r7 = 0
            java.lang.String r8 = "date_modified DESC"
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00f2 }
            r4 = 0
            if (r3 != 0) goto L_0x003b
            java.lang.String r0 = "Failed to query images"
            r1.a((java.lang.String) r0, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)     // Catch:{ Throwable -> 0x00e3 }
            goto L_0x00db
        L_0x003b:
            int r0 = r3.getCount()     // Catch:{ Throwable -> 0x00e3 }
            if (r0 != 0) goto L_0x004b
            java.lang.String r0 = "No images in Gallery"
            r1.a((java.lang.String) r0, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)     // Catch:{ Throwable -> 0x00e3 }
            r3.close()     // Catch:{ Throwable -> 0x00e3 }
            goto L_0x00db
        L_0x004b:
            r3.moveToFirst()     // Catch:{ Throwable -> 0x00e3 }
            int r0 = r3.getColumnIndex(r9)     // Catch:{ Throwable -> 0x00e3 }
            int r0 = r3.getInt(r0)     // Catch:{ Throwable -> 0x00e3 }
            int r5 = r3.getColumnIndex(r11)     // Catch:{ Throwable -> 0x00e3 }
            int r5 = r3.getInt(r5)     // Catch:{ Throwable -> 0x00e3 }
            int r6 = r3.getColumnIndex(r12)     // Catch:{ Throwable -> 0x00e3 }
            int r6 = r3.getInt(r6)     // Catch:{ Throwable -> 0x00e3 }
            android.net.Uri r7 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Throwable -> 0x00e3 }
            long r14 = (long) r0     // Catch:{ Throwable -> 0x00e3 }
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r7, r14)     // Catch:{ Throwable -> 0x00e3 }
            com.shopee.react.sdk.bridge.protocol.ImageData r7 = new com.shopee.react.sdk.bridge.protocol.ImageData     // Catch:{ Throwable -> 0x00e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00e3 }
            r7.<init>(r0, r5, r6)     // Catch:{ Throwable -> 0x00e3 }
            r3.close()     // Catch:{ Throwable -> 0x00e3 }
            android.content.ContentResolver r0 = r17.getContentResolver()     // Catch:{ Exception -> 0x00d8 }
            android.database.Cursor r5 = android.provider.MediaStore.Images.Thumbnails.queryMiniThumbnail(r0, r14, r10, r13)     // Catch:{ Exception -> 0x00d8 }
            if (r5 != 0) goto L_0x0087
            r1.a((com.shopee.react.sdk.bridge.protocol.ImageData) r7, (com.shopee.react.sdk.bridge.protocol.ImageData) r4, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            goto L_0x00bf
        L_0x0087:
            int r0 = r5.getCount()     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            if (r0 != 0) goto L_0x0091
            r1.a((com.shopee.react.sdk.bridge.protocol.ImageData) r7, (com.shopee.react.sdk.bridge.protocol.ImageData) r4, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            goto L_0x00bf
        L_0x0091:
            r5.moveToFirst()     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            int r0 = r5.getColumnIndex(r9)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            int r0 = r5.getInt(r0)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            int r6 = r5.getColumnIndex(r11)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            int r6 = r5.getInt(r6)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            int r8 = r5.getColumnIndex(r12)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            int r8 = r5.getInt(r8)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            android.net.Uri r9 = android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            long r10 = (long) r0     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r9, r10)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            com.shopee.react.sdk.bridge.protocol.ImageData r9 = new com.shopee.react.sdk.bridge.protocol.ImageData     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            r9.<init>(r0, r6, r8)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
            r1.a((com.shopee.react.sdk.bridge.protocol.ImageData) r7, (com.shopee.react.sdk.bridge.protocol.ImageData) r9, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)     // Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
        L_0x00bf:
            if (r5 == 0) goto L_0x00db
            r5.close()     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00db
        L_0x00c5:
            r0 = move-exception
            r6 = r4
            goto L_0x00cc
        L_0x00c8:
            r0 = move-exception
            r6 = r0
            throw r6     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r0 = move-exception
        L_0x00cc:
            if (r5 == 0) goto L_0x00d7
            if (r6 == 0) goto L_0x00d4
            r5.close()     // Catch:{ Throwable -> 0x00d7 }
            goto L_0x00d7
        L_0x00d4:
            r5.close()     // Catch:{ Exception -> 0x00d8 }
        L_0x00d7:
            throw r0     // Catch:{ Exception -> 0x00d8 }
        L_0x00d8:
            r1.a((com.shopee.react.sdk.bridge.protocol.ImageData) r7, (com.shopee.react.sdk.bridge.protocol.ImageData) r4, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)     // Catch:{ Throwable -> 0x00e3 }
        L_0x00db:
            if (r3 == 0) goto L_0x010b
            r3.close()     // Catch:{ Exception -> 0x00f2 }
            goto L_0x010b
        L_0x00e1:
            r0 = move-exception
            goto L_0x00e6
        L_0x00e3:
            r0 = move-exception
            r4 = r0
            throw r4     // Catch:{ all -> 0x00e1 }
        L_0x00e6:
            if (r3 == 0) goto L_0x00f1
            if (r4 == 0) goto L_0x00ee
            r3.close()     // Catch:{ Throwable -> 0x00f1 }
            goto L_0x00f1
        L_0x00ee:
            r3.close()     // Catch:{ Exception -> 0x00f2 }
        L_0x00f1:
            throw r0     // Catch:{ Exception -> 0x00f2 }
        L_0x00f2:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to get image: "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.a((java.lang.String) r0, (com.shopee.react.sdk.bridge.modules.base.c<com.shopee.react.sdk.bridge.protocol.DataResponse<com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse>>) r2)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.modules.ui.imagepicker.a.a(android.app.Activity, com.shopee.react.sdk.bridge.protocol.GetRecentImageRequest, com.shopee.react.sdk.bridge.modules.base.c):void");
    }

    private void a(ImageData imageData, ImageData imageData2, c<DataResponse<GetRecentImageResponse>> cVar) {
        UiThreadUtil.runOnUiThread(new Runnable(imageData, imageData2) {
            private final /* synthetic */ ImageData f$1;
            private final /* synthetic */ ImageData f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                c.this.a(DataResponse.success(new GetRecentImageResponse(this.f$1, this.f$2)));
            }
        });
    }

    private void a(String str, c<DataResponse<GetRecentImageResponse>> cVar) {
        UiThreadUtil.runOnUiThread(new Runnable(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                c.this.a(DataResponse.error(1, this.f$1));
            }
        });
    }
}
