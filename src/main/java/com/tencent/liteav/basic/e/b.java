package com.tencent.liteav.basic.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.ByteConstants;
import com.google.android.gms.common.Scopes;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f31361a = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/");

    /* renamed from: f  reason: collision with root package name */
    protected static b f31362f;

    /* renamed from: g  reason: collision with root package name */
    private static Context f31363g = null;

    /* renamed from: b  reason: collision with root package name */
    SharedPreferences f31364b;

    /* renamed from: c  reason: collision with root package name */
    SharedPreferences.Editor f31365c;

    /* renamed from: d  reason: collision with root package name */
    String f31366d = "";

    /* renamed from: e  reason: collision with root package name */
    long f31367e = 0;
    private boolean h = false;
    private boolean i = false;
    private a j = new a();

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f31369a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f31370b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f31371c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f31372d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f31373e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int[] f31374f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f31375g;
        /* access modifiers changed from: private */
        public String h;
        /* access modifiers changed from: private */
        public int i;
        /* access modifiers changed from: private */
        public int j;
        /* access modifiers changed from: private */
        public int k;
        /* access modifiers changed from: private */
        public int l;
        /* access modifiers changed from: private */
        public int m;
        /* access modifiers changed from: private */
        public int n;
        /* access modifiers changed from: private */
        public JSONObject o;
        /* access modifiers changed from: private */
        public int p;

        private a() {
            this.f31369a = 2;
            this.f31370b = "";
            this.f31371c = 0;
            this.f31372d = 0;
            this.f31373e = 0;
            this.f31374f = null;
            this.f31375g = 0;
            this.h = "";
            this.i = 60;
            this.j = 70;
            this.k = 80;
            this.l = 50;
            this.m = 10;
            this.n = 0;
            this.o = new JSONObject();
            this.p = -1;
        }
    }

    public static b a() {
        if (f31362f == null) {
            synchronized (b.class) {
                if (f31362f == null) {
                    f31362f = new b();
                }
            }
        }
        return f31362f;
    }

    public void a(Context context) {
        if (f31363g == null) {
            f31363g = context.getApplicationContext();
        }
    }

    public String b() {
        k();
        if (this.j.f31370b.isEmpty()) {
            a("{\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\",\n            \"md5_key\": \"e43363560876ce9ba9c7d8d1c5473668\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\",\n            \"md5_key\": \"57decee684de4f0ac337360b52c47655\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\",\n            \"md5_key\": \"c4ae280bc5d5d3a1be3196292e96e328\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\",\n            \"md5_key\": \"3dc192f7e46e8ccc45e971047961c1fd\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\",\n            \"md5_key\": \"c23b08889a7ad00afab83c260f7903b6\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\",\n            \"md5_key\": \"55451ea2d068723f3ba30d02428e69e5\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\",\n            \"md5_key\": \"c58632578fc64d083ba71b3f883146bb\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\",\n            \"md5_key\": \"70c243658d28a97654b9a407e4403180\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\",\n            \"md5_key\": \"698d31d03e6acfe579032a12666a1458\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\",\n            \"md5_key\": \"466f3005f8b4f255939599dafbefba09\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\",\n            \"md5_key\": \"0530eae7d07dc856d5972638467f37ba\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\",\n            \"md5_key\": \"b5d823597aa082daae5b1cf0184dca06\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\",\n            \"md5_key\": \"3e8a43390c1841605c7e587c9fa0f1e1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\",\n            \"md5_key\": \"568018be9bd51f0f537e6f0e989d67b6\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\",\n            \"md5_key\": \"a3b82f4384857dad8dfe4be1a71a3a31\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\",\n            \"md5_key\": \"8aa4062a630189844d7daa8be8a1644a\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\",\n            \"md5_key\": \"576fe7aa4930dac2425ad47a82a9c883\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\",\n            \"md5_key\": \"f63015e8faa7a8b8499ae8f51e187768\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\",\n            \"md5_key\": \"c1ae1134125099a417313f349481e694\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\",\n            \"md5_key\": \"2bf7165fa173fa12466c1c70160bc18a\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\",\n            \"md5_key\": \"863aaa3e10c4e1897969950f728c9bbc\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\",\n            \"md5_key\": \"23ff66146b45b78ae6578c0968508710\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\",\n            \"md5_key\": \"0604dd00fc144e313cb2cc94b48722bb\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\",\n            \"md5_key\": \"e06bf201ec1f11e149686ad0540a3460\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\",\n            \"md5_key\": \"2a0411d3c106c6169542f55287a3ca9d\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\",\n            \"md5_key\": \"6a5b2be93fd857d0472182066a0ef087\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\",\n            \"md5_key\": \"781dc5b4b13ef84f8ac33396809c1d9d\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\",\n            \"md5_key\": \"41eb9058d2367904900278a3b77f5395\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\",\n            \"md5_key\": \"e75375384498a9b333851732ef4d7035\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\",\n            \"md5_key\": \"a8c21bfa2a81c196bcaa5b83855bfcfa\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\",\n            \"md5_key\": \"d31204d78652f954e55ffee292279583\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\",\n            \"md5_key\": \"e62c462c90b0e426b5f4be16d6c21d4b\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\",\n            \"md5_key\": \"581952ddbe916b4726d03df052552459\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\",\n            \"md5_key\": \"04e5d391666a13befed38dcd4573e350\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\",\n            \"md5_key\": \"5b7bf4b1a97b8a6ff87c7725de30e462\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\",\n            \"md5_key\": \"c59fc0c02f647bf80b7f91c872fbbb4d\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\",\n            \"md5_key\": \"978d7f3ada45996f493764a77f803898\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\",\n            \"md5_key\": \"caca14d06ac9598d20dc8af9e4af8911\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\",\n            \"md5_key\": \"f0660a29ebbb6640ddd4ce4bba707c37\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\",\n            \"md5_key\": \"8fb34c90f2e3c03e7ed68720e0d7610b\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\",\n            \"md5_key\": \"9bffd716a48917dd4ced4860d2133d4b\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\",\n            \"md5_key\": \"1fb4400a5ce9568c55c6ebf119b78d1c\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\",\n            \"md5_key\": \"ae1206b419afa5cf3e1a025db57ef7e7\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\",\n            \"md5_key\": \"d2dc48d21f2fc41b07475f122d2e39c5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\",\n            \"md5_key\": \"bf4b8158c3f22d28828bb395fba49c0a\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\",\n            \"md5_key\": \"65c289177604574aa7a217010fb04f9b\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\",\n            \"md5_key\": \"8197afa18c5cd0d89646e4c5ac739654\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\",\n            \"md5_key\": \"aedf50d4241527d69f41ae34a330c0a8\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\",\n            \"md5_key\": \"7cd73ff7316fdacac6b7389bef283b6f\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\",\n            \"md5_key\": \"ce46718589f015d1a292f3fbcec9360f\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\",\n            \"md5_key\": \"d68d63b1e1efec657993818211c03467\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\",\n            \"md5_key\": \"c892a2543c6b23a2aaab723d285732e2\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\",\n            \"md5_key\": \"dba18ff0b8d708a68e7ada721d721807\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\",\n            \"md5_key\": \"15fa08fbbdb67c5fd9276c861a778b39\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\",\n            \"md5_key\": \"3c0884f02ff862a7805474bb7e0bd3bb\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\",\n            \"md5_key\": \"556aea5b19ac3c0c5a4c87ada0540388\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\",\n            \"md5_key\": \"d4fab47612ffb1fd34f89133ffe7794f\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\",\n            \"md5_key\": \"486041f66af4d08cc2e8df99da0f8158\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\",\n            \"md5_key\": \"d07e3f0674c92110b81b814f373289ed\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\",\n            \"md5_key\": \"8c669095b373fd395259dee82f530a26\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\",\n            \"md5_key\": \"8b991b849cd2596caf89d4305c4a824b\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\",\n            \"md5_key\": \"f3126b20df3ff988139c1155a4907df5\"\n          }        ]\n    }", this.j);
        }
        return this.j.f31370b;
    }

    public int c() {
        k();
        return this.j.f31369a;
    }

    public int d() {
        k();
        return this.j.f31371c;
    }

    public int e() {
        k();
        return this.j.n;
    }

    public int f() {
        k();
        return this.j.m;
    }

    public boolean a(float f2, float f3, float f4) {
        k();
        return f3 >= ((float) this.j.k) || f4 <= ((float) this.j.l) || (f2 >= ((float) this.j.i) && f4 <= ((float) this.j.j));
    }

    public boolean g() {
        k();
        return this.j.f31372d == 1;
    }

    public int h() {
        k();
        if (this.j.f31374f == null) {
            return 0;
        }
        int i2 = this.j.f31374f[0];
        for (int i3 : this.j.f31374f) {
            if (i2 > i3) {
                i2 = i3;
            }
        }
        return i2;
    }

    public int i() {
        k();
        if (this.j.f31374f == null) {
            return 0;
        }
        int i2 = this.j.f31374f[0];
        for (int i3 : this.j.f31374f) {
            if (i2 < i3) {
                i2 = i3;
            }
        }
        return i2;
    }

    public long a(String str, String str2) {
        k();
        long a2 = a(TXCCommonUtil.getAppID(), str, str2);
        return a2 == -1 ? a("Global", str, str2) : a2;
    }

    public float b(String str, String str2) {
        k();
        float b2 = b(TXCCommonUtil.getAppID(), str, str2);
        return ((double) b2) == -1.0d ? b("Global", str, str2) : b2;
    }

    private long a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || this.j.o == null) {
            return -1;
        }
        JSONObject optJSONObject = this.j.o.optJSONObject(str);
        if (optJSONObject == null) {
            return -1;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
        if (optJSONObject2 != null) {
            return optJSONObject2.optLong(str3, -1);
        }
        return -1;
    }

    private float b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && this.j.o != null) {
            JSONObject optJSONObject = this.j.o.optJSONObject(str);
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
                if (optJSONObject2 != null) {
                    return (float) optJSONObject2.optDouble(str3, -1.0d);
                }
            }
        }
        return -1.0f;
    }

    public boolean a(String str) {
        k();
        if (this.j.o != null) {
            JSONObject optJSONObject = this.j.o.optJSONObject("Global");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("DNSWhiteList");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("InfoList");
                    if (optJSONArray != null) {
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            try {
                                if (str.contains(optJSONArray.getString(i2))) {
                                    return true;
                                }
                                i2++;
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void k() {
        l();
        j();
    }

    private synchronized void l() {
        if (n()) {
            b(true);
            if (!p()) {
                q();
            }
            TXCLog.i("CloudConfig", "load config(system aec):" + this.j.f31372d + "," + this.j.f31373e + "," + this.j.f31375g + "," + this.j.h + ", model = " + Build.MODEL + ", manufacturer = " + Build.MANUFACTURER + "， board = " + Build.BOARD);
        }
    }

    private void a(a aVar) {
        String str;
        if (this.f31365c == null) {
            Context context = f31363g;
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("cloud_config", 0);
                if (sharedPreferences != null) {
                    this.f31365c = sharedPreferences.edit();
                }
            }
        }
        SharedPreferences.Editor editor = this.f31365c;
        if (editor != null) {
            editor.putLong(BPOrderInfo.FIELD_EXPIRED_TIME, this.f31367e);
            this.f31365c.putInt("hw_config", aVar.f31369a);
            this.f31365c.putInt("ExposureCompensation", aVar.f31371c);
            this.f31365c.putInt("UGCSWMuxerConfig", aVar.n);
            this.f31365c.putInt("CPU", aVar.i);
            this.f31365c.putInt("FPS", aVar.j);
            this.f31365c.putInt("CPU_MAX", aVar.k);
            this.f31365c.putInt("FPS_MIN", aVar.l);
            this.f31365c.putInt("CheckCount", aVar.m);
            this.f31365c.putString("trae_config", aVar.f31370b);
            if (aVar.o != null) {
                this.f31365c.putString("AppIDConfig", aVar.o.toString());
            }
            if (aVar.f31374f != null) {
                str = "" + aVar.f31374f[0];
                for (int i2 = 1; i2 < aVar.f31374f.length; i2++) {
                    str = (str + "|") + aVar.f31374f[i2];
                }
            } else {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (aVar.h == null) {
                String unused = aVar.h = "";
            }
            this.f31365c.putString("system_aec_config", aVar.f31372d + "," + aVar.f31373e + "," + str + "," + aVar.f31375g + "," + aVar.h);
            this.f31365c.commit();
        }
    }

    public void j() {
        if (m()) {
            a(true);
            new Thread() {
                public void run() {
                    b.this.o();
                }
            }.start();
        }
    }

    private synchronized boolean m() {
        if (this.h || this.f31367e > System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    private synchronized boolean n() {
        if (this.i) {
            return false;
        }
        return true;
    }

    private synchronized void a(boolean z) {
        this.h = z;
    }

    private synchronized void b(boolean z) {
        this.i = z;
    }

    private synchronized void a(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        this.f31367e = System.currentTimeMillis() + ((long) (i2 * 24 * 60 * 60 * 1000));
    }

    /* access modifiers changed from: private */
    public void o() {
        File file;
        try {
            TXCLog.w("CloudConfig", "update server config ");
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("http://dldir1.qq.com/hudongzhibo/liteavsvrcfg/serverconfig_en.zip").openConnection()));
            if (!this.f31366d.isEmpty()) {
                httpURLConnection.addRequestProperty(COSRequestHeaderKey.IF_MODIFIED_SINCE, this.f31366d);
            }
            String headerField = httpURLConnection.getHeaderField("Last-Modified");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                if (headerField != null && !headerField.isEmpty()) {
                    this.f31366d = headerField;
                    if (this.f31365c != null) {
                        this.f31365c.putString("last_modify", this.f31366d);
                    }
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] a2 = a.a(byteArrayOutputStream.toByteArray(), a.a(Base64.decode("MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAOnmX5h7KCQsoIQ+2ot1dIayWsmA3LU7p0kl1t5T2cbosedcsSGT+YM5bFiVBeAYbAM10WSvzZ2+oexMW7B2RcYZ1qulSR4eNXk74biDy2DmQqXK3qt1ZP4DnpiR+UXVKt6rqdtpDqRk4VGUw33/w3mMOyzkSjueewYB32n/l2JPAgMBAAECgYEA5rzfcyGTQNRRaQREPa0ZzcLmcr/Pem2lojBU3jBjtqhYz/8Nsi0yyHP+YQhpql8NNsGBlk0jjsi/HcdZ8CNMwbRfPYoe9mICe/iKMJ5P3+DtcH7AtE0ckHg01rY8pbqV9EAICijU1BwgbZh9M715HLSCeKwSWBWmpq1aQ/8l7PkCQQD5GFqrmGtMJOfTxaqS5hCHg+VsYpPsb566DEZQIJBWMP7eE58H1rphWMMSQ36c1V/iZuauYO0gYC1UlMfYHsRVAkEA8GIwlFXPG+LnkPENHo2pKORCnY7wo63hjyeQRipHhY7yUJjaPA50wDI7XCGOrJryBCVTOVszEUz4ocHQ0mOQEwJBAOnCPySVTuwQHjaQYzikCpMB5gVGpUbWoQA7kKiVRp58MFG73BwBGLtODxJOoL0RSIAwzP6MGzusxh1/2eMpTFkCQQCk5tboi0z+llPArHwRf6CRurSwHUSbJEddywg/+fUCfCNigtkC5e/VgSATfbnAUrK/gVNsP1HzBlhxruGv0jkdAkEAjNSVhjcoLg1JodbhBmD16vsAUzJpDR6EZIeiXj4pN+hKiDq9+aHEtMxtjFXiqbdKkrUjrzfZKrzQm0wy950BUw==".getBytes("UTF-8"), 2)));
                        synchronized (b.class) {
                            file = new File(f31361a, "serverconfig_dec.zip");
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(a2);
                            fileOutputStream.close();
                        }
                        b(a(file));
                        return;
                    }
                }
            } else if (responseCode == 304) {
                a(false);
                StringBuilder sb = new StringBuilder();
                sb.append("fetch config Not-Modified-Since ");
                sb.append(this.f31366d);
                TXCLog.d("CloudConfig", sb.toString() == null ? "" : this.f31366d);
            }
        } catch (Exception e2) {
            TXCLog.e("CloudConfig", "fetch config catch exception " + e2);
            a(false);
        }
    }

    private static String a(File file) throws IOException {
        synchronized (b.class) {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.isDirectory()) {
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    byte[] bArr = new byte[ByteConstants.MB];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            inputStream.close();
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                            return byteArrayOutputStream2;
                        }
                    }
                }
            }
            return "";
        }
    }

    private void b(String str) {
        a(false);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = 1;
            if (jSONObject.has("UpdateFrequency")) {
                i2 = jSONObject.getInt("UpdateFrequency");
            }
            a(i2);
            a a2 = a(jSONObject);
            if (a2 != null) {
                this.j = a2;
                a(a2);
            }
        } catch (JSONException e2) {
            TXCLog.w("CloudConfig", "parseRespon catch ecxeption" + e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0128 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r17, com.tencent.liteav.basic.e.b.a r18) throws org.json.JSONException {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            int unused = r1.f31372d = r2
            int unused = r1.f31373e = r2
            r3 = 0
            int[] unused = r1.f31374f = r3
            int unused = r1.f31375g = r2
            java.lang.String r4 = ""
            java.lang.String unused = r1.h = r4
            java.lang.String r5 = "SystemAECConfig"
            boolean r6 = r0.has(r5)
            java.lang.String r7 = "CloudConfig"
            if (r6 == 0) goto L_0x012d
            org.json.JSONObject r0 = r0.getJSONObject(r5)
            java.lang.String r5 = "InfoList"
            boolean r6 = r0.has(r5)
            if (r6 == 0) goto L_0x012d
            org.json.JSONArray r5 = r0.getJSONArray(r5)
            r8 = r3
            r6 = 0
        L_0x0033:
            int r0 = r5.length()
            if (r6 >= r0) goto L_0x012c
            org.json.JSONObject r0 = r5.getJSONObject(r6)
            if (r0 == 0) goto L_0x0128
            java.lang.String r9 = "Manufacture"
            java.lang.String r9 = r0.getString(r9)
            java.lang.String r10 = android.os.Build.MANUFACTURER
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x0128
            java.lang.String r9 = "WhiteList"
            org.json.JSONArray r9 = r0.optJSONArray(r9)
            java.lang.String r10 = "Model"
            r11 = 1
            if (r9 == 0) goto L_0x0078
            r12 = 0
        L_0x0059:
            int r13 = r9.length()
            if (r12 >= r13) goto L_0x0078
            org.json.JSONObject r13 = r9.optJSONObject(r12)
            if (r13 == 0) goto L_0x0075
            java.lang.String r13 = r13.optString(r10)
            if (r13 == 0) goto L_0x0075
            java.lang.String r14 = android.os.Build.MODEL
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x0075
            r9 = 1
            goto L_0x0079
        L_0x0075:
            int r12 = r12 + 1
            goto L_0x0059
        L_0x0078:
            r9 = 0
        L_0x0079:
            java.lang.String r12 = "BlackList"
            org.json.JSONArray r12 = r0.optJSONArray(r12)
            if (r12 == 0) goto L_0x00a0
            r13 = 0
        L_0x0082:
            int r14 = r12.length()
            if (r13 >= r14) goto L_0x00a0
            org.json.JSONObject r14 = r12.optJSONObject(r13)
            if (r14 == 0) goto L_0x009d
            java.lang.String r14 = r14.optString(r10)
            if (r14 == 0) goto L_0x009d
            java.lang.String r15 = android.os.Build.MODEL
            boolean r14 = r15.equals(r14)
            if (r14 == 0) goto L_0x009d
            goto L_0x00a1
        L_0x009d:
            int r13 = r13 + 1
            goto L_0x0082
        L_0x00a0:
            r11 = 0
        L_0x00a1:
            if (r9 == 0) goto L_0x0117
            java.lang.String r9 = "SystemAEC"
            int r9 = r0.optInt(r9, r2)     // Catch:{ Exception -> 0x00fb }
            int unused = r1.f31372d = r9     // Catch:{ Exception -> 0x00fb }
            java.lang.String r9 = "AGC"
            int r9 = r0.optInt(r9, r2)     // Catch:{ Exception -> 0x00fb }
            int unused = r1.f31373e = r9     // Catch:{ Exception -> 0x00fb }
            java.lang.String r9 = "SampleRate"
            java.lang.String r8 = r0.optString(r9, r4)     // Catch:{ Exception -> 0x00fb }
            boolean r9 = r8.isEmpty()     // Catch:{ Exception -> 0x00fb }
            if (r9 != 0) goto L_0x00e8
            java.lang.String r9 = "\\|"
            java.lang.String[] r9 = r8.split(r9)     // Catch:{ Exception -> 0x00fb }
            int r10 = r9.length     // Catch:{ Exception -> 0x00fb }
            int[] r10 = new int[r10]     // Catch:{ Exception -> 0x00fb }
            int[] unused = r1.f31374f = r10     // Catch:{ Exception -> 0x00fb }
            r10 = 0
        L_0x00ce:
            int r12 = r9.length     // Catch:{ Exception -> 0x00fb }
            if (r10 >= r12) goto L_0x00e8
            int[] r12 = r18.f31374f     // Catch:{ Exception -> 0x00fb }
            r13 = r9[r10]     // Catch:{ Exception -> 0x00fb }
            java.lang.String r13 = r13.trim()     // Catch:{ Exception -> 0x00fb }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x00fb }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x00fb }
            r12[r10] = r13     // Catch:{ Exception -> 0x00fb }
            int r10 = r10 + 1
            goto L_0x00ce
        L_0x00e8:
            java.lang.String r9 = "HWAACCodec"
            int r9 = r0.optInt(r9, r2)     // Catch:{ Exception -> 0x00fb }
            int unused = r1.f31375g = r9     // Catch:{ Exception -> 0x00fb }
            java.lang.String r9 = "SceneType"
            java.lang.String r0 = r0.optString(r9, r4)     // Catch:{ Exception -> 0x00fb }
            java.lang.String unused = r1.h = r0     // Catch:{ Exception -> 0x00fb }
            goto L_0x0117
        L_0x00fb:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "parseSysAECConfig Exception: "
            r9.append(r10)
            java.lang.String r0 = r0.getMessage()
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r7, r0)
        L_0x0117:
            if (r11 == 0) goto L_0x0128
            int unused = r1.f31372d = r2
            int unused = r1.f31373e = r2
            int[] unused = r1.f31374f = r3
            int unused = r1.f31375g = r2
            java.lang.String unused = r1.h = r4
        L_0x0128:
            int r6 = r6 + 1
            goto L_0x0033
        L_0x012c:
            r3 = r8
        L_0x012d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "system aec config1:"
            r0.append(r2)
            int r2 = r18.f31372d
            r0.append(r2)
            java.lang.String r2 = ","
            r0.append(r2)
            int r4 = r18.f31373e
            r0.append(r4)
            r0.append(r2)
            r0.append(r3)
            r0.append(r2)
            int r3 = r18.f31375g
            r0.append(r3)
            r0.append(r2)
            java.lang.String r1 = r18.h
            r0.append(r1)
            java.lang.String r1 = ", model = "
            r0.append(r1)
            java.lang.String r1 = android.os.Build.MODEL
            r0.append(r1)
            java.lang.String r1 = ", manufacturer = "
            r0.append(r1)
            java.lang.String r1 = android.os.Build.MANUFACTURER
            r0.append(r1)
            java.lang.String r1 = "， board = "
            r0.append(r1)
            java.lang.String r1 = android.os.Build.BOARD
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tencent.liteav.basic.log.TXCLog.i(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.e.b.a(org.json.JSONObject, com.tencent.liteav.basic.e.b$a):void");
    }

    private void b(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject.has("TraeConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("TraeConfig");
            if (jSONObject2.has("InfoList")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    if (jSONObject3 == null || !jSONObject3.getString("MachineType").equals(Build.MODEL)) {
                        i2++;
                    } else {
                        String unused = aVar.f31370b = jSONObject3.getString("ConfigValue");
                        TXCLog.d("CloudConfig", "parseTRAEConfig get TRAE config: " + aVar.f31370b);
                        return;
                    }
                }
            }
        }
    }

    private void c(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject.has("WeiXinConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("WeiXinConfig");
            if (jSONObject2.has("InfoList")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        String string = jSONObject3.getString("Manufacture");
                        String string2 = jSONObject3.getString("Model");
                        if (string.equals(Build.MANUFACTURER) && string2.equals(Build.MODEL)) {
                            int unused = aVar.p = Integer.parseInt(jSONObject3.getString("SampleRate"));
                            TXCLog.d("CloudConfig", "parseWeiXinConfig get WeiXin config: record sample rate = " + aVar.p);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void d(JSONObject jSONObject, a aVar) throws JSONException {
        int unused = aVar.i = 60;
        int unused2 = aVar.j = 70;
        int unused3 = aVar.k = 80;
        int unused4 = aVar.l = 50;
        int unused5 = aVar.m = 10;
        if (jSONObject.has("HWWhiteList")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("HWWhiteList");
            if (jSONObject2.has("SWToHWThreshold")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("SWToHWThreshold");
                if (jSONObject3.has("CPU")) {
                    int unused6 = aVar.i = jSONObject3.getInt("CPU");
                    TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CPU:" + aVar.i);
                }
                if (jSONObject3.has("FPS")) {
                    int unused7 = aVar.j = jSONObject3.getInt("FPS");
                    TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.FPS:" + aVar.j);
                }
                if (jSONObject3.has("CPU_MAX")) {
                    int unused8 = aVar.k = jSONObject3.getInt("CPU_MAX");
                    TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CPU:" + aVar.k);
                }
                if (jSONObject3.has("FPS_MIN")) {
                    int unused9 = aVar.l = jSONObject3.getInt("FPS_MIN");
                    TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.FPS:" + aVar.l);
                }
                if (jSONObject3.has("CheckCount")) {
                    int unused10 = aVar.m = jSONObject3.getInt("CheckCount");
                    TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CheckCount:" + aVar.m);
                }
            }
        }
    }

    private void e(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject.has("ExposureWhiteConfig")) {
            JSONArray jSONArray = jSONObject.getJSONObject("ExposureWhiteConfig").getJSONArray("InfoList");
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER) && jSONObject2.getString("Model").equalsIgnoreCase(Build.MODEL)) {
                    int unused = aVar.f31371c = jSONObject2.getInt("ExposureCompensation");
                    TXCLog.d("CloudConfig", "parseExposureConfig get exposure config: " + aVar.f31371c);
                    break;
                }
                i2++;
            }
            if (f31363g != null) {
                f31363g.sendBroadcast(new Intent("com.tencent.liteav.basic.serverconfig.get"));
            }
        }
    }

    private void f(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject.has("HWBlackConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("HWBlackConfig");
            int i2 = 16;
            if (jSONObject2.has("HWMiniSupportAPI")) {
                i2 = jSONObject2.getInt("HWMiniSupportAPI");
            }
            if (Build.VERSION.SDK_INT < i2) {
                int unused = aVar.f31369a = 0;
                return;
            }
            JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                if (!jSONObject3.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER) || !jSONObject3.getString("Model").equalsIgnoreCase(Build.MODEL)) {
                    i3++;
                } else if (jSONObject3.has(Scopes.PROFILE)) {
                    int unused2 = aVar.f31369a = 1;
                    TXCLog.d("CloudConfig", "parseHWBlackConfig get HWBlack config: " + aVar.f31369a);
                    return;
                } else {
                    int unused3 = aVar.f31369a = 0;
                    TXCLog.d("CloudConfig", "parseHWBlackConfig get HWBlack config: " + aVar.f31369a);
                    return;
                }
            }
        }
    }

    private void a(String str, a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("InfoList")) {
                JSONArray jSONArray = jSONObject.getJSONArray("InfoList");
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 == null || !jSONObject2.getString("MachineType").equals(Build.MODEL)) {
                        i2++;
                    } else {
                        String unused = aVar.f31370b = jSONObject2.getString("ConfigValue");
                        return;
                    }
                }
            }
        } catch (JSONException e2) {
            TXCLog.w("CloudConfig", "parseTraeLocalConfig catch ecxeption" + e2);
        }
    }

    private void g(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject.has("UGCSWMuxerConfig")) {
            JSONArray jSONArray = jSONObject.getJSONObject("UGCSWMuxerConfig").getJSONArray("InfoList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.getJSONObject(i2).getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) {
                    int unused = aVar.n = 1;
                    return;
                }
            }
        }
    }

    private void h(JSONObject jSONObject, a aVar) throws JSONException {
        if (jSONObject.has("AppIDConfig")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("AppIDConfig");
            if (optJSONObject != null) {
                JSONObject unused = aVar.o = optJSONObject;
                TXCLog.w("CloudConfig", "parse global config : " + aVar.o);
            }
        }
    }

    private boolean p() {
        Context context = f31363g;
        if (context == null) {
            return false;
        }
        this.f31364b = context.getSharedPreferences("cloud_config", 0);
        SharedPreferences sharedPreferences = this.f31364b;
        if (sharedPreferences != null && sharedPreferences.contains(BPOrderInfo.FIELD_EXPIRED_TIME)) {
            TXCLog.w("CloudConfig", "loadLocalFileConfig ");
            this.f31365c = this.f31364b.edit();
            try {
                this.f31366d = this.f31364b.getString("last_modify", "");
                this.f31367e = this.f31364b.getLong(BPOrderInfo.FIELD_EXPIRED_TIME, System.currentTimeMillis());
                int unused = this.j.f31369a = this.f31364b.getInt("hw_config", 2);
                int unused2 = this.j.f31371c = this.f31364b.getInt("ExposureCompensation", 0);
                int unused3 = this.j.n = this.f31364b.getInt("UGCSWMuxerConfig", 0);
                int unused4 = this.j.i = this.f31364b.getInt("CPU", 60);
                int unused5 = this.j.j = this.f31364b.getInt("FPS", 70);
                int unused6 = this.j.k = this.f31364b.getInt("CPU_MAX", 80);
                int unused7 = this.j.l = this.f31364b.getInt("FPS_MIN", 50);
                int unused8 = this.j.m = this.f31364b.getInt("CheckCount", 10);
                String unused9 = this.j.f31370b = this.f31364b.getString("trae_config", "");
                String string = this.f31364b.getString("system_aec_config", "");
                String string2 = this.f31364b.getString("AppIDConfig", "");
                if (!TextUtils.isEmpty(string2)) {
                    JSONObject unused10 = this.j.o = new JSONObject(string2);
                }
                TXCLog.i("CloudConfig", "system aec config:" + string);
                if (!string.isEmpty()) {
                    String[] split = string.split(",");
                    if (split != null && split.length >= 5) {
                        int unused11 = this.j.f31372d = Integer.valueOf(split[0]).intValue();
                        int unused12 = this.j.f31373e = Integer.valueOf(split[1]).intValue();
                        String[] split2 = split[2].split("\\|");
                        if (split2 != null) {
                            int[] unused13 = this.j.f31374f = new int[split2.length];
                            for (int i2 = 0; i2 < split2.length; i2++) {
                                this.j.f31374f[i2] = Integer.valueOf(split2[i2].trim()).intValue();
                            }
                        }
                        int unused14 = this.j.f31375g = Integer.valueOf(split[3]).intValue();
                        String unused15 = this.j.h = split[4];
                    }
                }
                return true;
            } catch (Exception e2) {
                this.f31365c.clear();
                this.f31365c.commit();
                TXCLog.d("CloudConfig", "loadLocalFileConfig catch exception " + e2);
            }
        }
        return false;
    }

    private void q() {
        try {
            TXCLog.w("CloudConfig", "loadDefaultConfig ");
            a a2 = a(new JSONObject("{\n    \"version\": 3,\n    \"UpdateFrequency\": 1,\n    \"AppIDConfig\": {\n        \"Global\": {\n           \"DataReport\": {\n               \"UserPortrait\": 0\n           },\n            \"DNSWhiteList\": {\n              \"InfoList\": [\n                \"qq\",\n                \"tencent\"\n              ]\n            },           \"Audio\": {\n               \"RTC_JitterCycle\" : 240,\n               \"LIVE_JitterCycle\": 500,\n               \"LoadingThreshold\": 800,\n               \"SmoothModeAdjust\": 300,\n               \"SmoothAdjust\": 10,\n               \"RtcPlayHungryTimeThreshold\": 60,\n               \"BlockThreshold\": 100,\n               \"SmoothSpeed\": 1.2\n           },\n           \"Network\": {\n               \"EnableRouteOptimize\": 0,\n               \"RouteSamplingMaxCount\": 0,\n               \"QualityDataCacheCount\": 0,\n               \"NACKRetryCnt\": 8,\n               \"AccRetryCountWithoutSecret\": 0\n           },\n           \"QUICMode\": {\n               \"Live\": 2,\n               \"LinkMain\": 2,\n               \"LinkSub\": 2,\n               \"RTC\": 2,\n               \"AVRoom\": 0\n           }\n       }\n    },\n    \"PlayModeConfig\": {\n        \"SmoothModeOffset\": 0\n    },\n    \"UGCSWMuxerConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\"\n            }\n        ]\n    },\n    \"HWBlackConfig\": {\n        \"HWMiniSupportAPI\": 17,\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"P6-U06\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"SCH-I939(S3)\"\n            },\n            {\n                \"Manufacture\": \"VIVO\",\n                \"Model\": \"vivo X5Pro D\"\n            },\n            {\n                \"Manufacture\": \"金立\",\n                \"Model\": \"GN9006\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"A7000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI NXT-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI MHA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L29\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-TL00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n             {\n                 \"Manufacture\": \"HUAWEI\",\n                 \"Model\": \"HUAWEI GRA-UL00\"\n             }\n        ]\n    },\n    \"ExposureWhiteConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"Meizu\",\n                \"Model\": \"MX4 Pro\",\n                \"ExposureCompensation\": 1\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3\",\n                \"ExposureCompensation\": 30\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3C\",\n                \"ExposureCompensation\": 30\n            }\n        ]\n    },\n    \"SystemAECConfig\": {\n        \"__comment__\":\"SceneType(开启系统aec的场景，1为连麦，2为通话)\",\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9\"}],\n                \"BlackList\": [],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9Plus\"},{\"Model\":\"vivo X7Plus\"},{\"Model\":\"vivo X7\"}],\n                \"BlackList\": [{\"Model\":\"vivo Y51A\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"WhiteList\": [{\"Model\":\"VTR-TL00\"},{\"Model\":\"HUAWEI GRA-UL00\"},{\"Model\":\"HUAWEI NXT-AL10\"},{\"Model\":\"PLK-AL10\"},{\"Model\":\"PLK-UL00\"},{\"Model\":\"EVA-AL10\"},{\"Model\":\"HUAWEI MT7-TL10\"}],\n                \"BlackList\": [{\"Model\":\"MHA-AL00\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 2\"},{\"Model\":\"Redmi Note 4\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 3\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"MI 4\"},{\"Model\":\"MI 3C\"},{\"Model\":\"Mi-4c\"}],\n                \"BlackList\": [{\"Model\":\"MI 6\"},{\"Model\":\"Redmi 4A\"},{\"Model\":\"MI 5X\"},{\"Model\":\"MI 5\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Google\",\n                \"WhiteList\": [{\"Model\":\"Pixel XL\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"samsung\",\n                \"WhiteList\": [{\"Model\":\"SM-G9350\"},{\"Model\":\"SM-G9500\"},{\"Model\":\"SM-G950U\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                 \"Manufacture\": \"LeMobile\",\n                 \"WhiteList\": [{\"Model\":\"X620\"}],\n                 \"SystemAEC\": 1,\n                 \"AGC\": 0,\n                 \"SampleRate\": \"48000|16000\",\n                 \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n             {\n                  \"Manufacture\": \"asus\",\n                  \"WhiteList\": [{\"Model\":\"ASUS_Z00ADB\"}],\n                  \"SystemAEC\": 1,\n                  \"AGC\": 0,\n                  \"SampleRate\": \"48000|16000\",\n                  \"HWAACCodec\": 1,\n                 \"SceneType\": \"1|2\"\n             }\n        ]\n    },\n    \"HWWhiteList\": {\n        \"SWToHWThreshold\": {\n            \"CPU_MAX\": 80,\n            \"FPS_MIN\": 50,\n            \"CPU\": 20,\n            \"FPS\": 70,\n            \"CheckCount\": 10,\n            \"__comment__\": \"软编根据性能切硬编的阈值，avgTotalCPU >= CPU_MAX || avgFPS <= FPS_MIN || (avgAppCPU >= CPU && avgFPS <= FPS) 性能指标满足上述条件则切硬编。CheckCount表示需要做X次有效性能数据采集。\"\n\t\t}\n    },\n    \"TraeConfig\": {\n        \"InfoList\": [\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-AL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-AL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-CL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-DL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-TL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI MT7-CL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI MT7-TL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI MT7-TL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI NXT-AL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"PLK-AL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"MachineType\": \"KT096H\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"MachineType\": \"Lenovo K900\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"MachineType\": \"Nexus 5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"MachineType\": \"Nexus 5X\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"MachineType\": \"X5 R1\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"MachineType\": \"MX4 Pro\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"A31\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO A33\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO A59s\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R7\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9km\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9m\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9s\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\naec {\\r\\nUseHQAEC y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9tm\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"MachineType\": \"SM-G9350\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\nvolume 2.0\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"MachineType\": \"SM-N9108V\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"MachineType\": \"SM-N9200\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"MachineType\": \"TCL P501M\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 4LTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 4W\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\nvolume 0.25\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 5s\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\n}\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 5s Plus\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI NOTE LTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"Redmi Note 3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"MachineType\": \"ZTE N928Dt\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\"\n          }\n        ]\n    }\n}"));
            if (a2 != null) {
                this.j = a2;
            }
        } catch (JSONException e2) {
            TXCLog.w("CloudConfig", "loadDefaultConfig catch exception " + e2);
            this.j = new a();
        }
    }

    private a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            f(jSONObject, aVar);
            e(jSONObject, aVar);
            d(jSONObject, aVar);
            a(jSONObject, aVar);
            b(jSONObject, aVar);
            c(jSONObject, aVar);
            g(jSONObject, aVar);
            h(jSONObject, aVar);
            return aVar;
        } catch (JSONException e2) {
            TXCLog.w("CloudConfig", "parse config catch exception " + e2.toString());
            return null;
        }
    }
}
