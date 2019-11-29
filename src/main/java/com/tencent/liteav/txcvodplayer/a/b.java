package com.tencent.liteav.txcvodplayer.a;

import android.net.Uri;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32056a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static b f32057b = new b();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f32058c;

    /* renamed from: d  reason: collision with root package name */
    private HashSet<a> f32059d;

    /* renamed from: e  reason: collision with root package name */
    private String f32060e;

    /* renamed from: f  reason: collision with root package name */
    private int f32061f;

    /* renamed from: g  reason: collision with root package name */
    private String f32062g;

    static class a implements Serializable {
        String fileType;
        String path;
        Long time;
        String url;

        a() {
        }

        public String a() {
            return this.url;
        }

        public void a(String str) {
            this.url = str;
        }

        public String b() {
            return this.path;
        }

        public void b(String str) {
            this.path = str;
        }

        public Long c() {
            return this.time;
        }

        public void a(Long l) {
            this.time = l;
        }

        public void c(String str) {
            this.fileType = str;
        }

        public String d() {
            if (this.fileType == null) {
                String str = this.path;
                if (str != null) {
                    if (str.endsWith("mp4")) {
                        return "mp4";
                    }
                    if (this.path.endsWith("m3u8.sqlite")) {
                        return IjkMediaMeta.IJKM_KEY_M3U8;
                    }
                }
            }
            return this.fileType;
        }
    }

    public static b a() {
        return f32057b;
    }

    public void a(int i) {
        this.f32061f = i;
    }

    public void a(String str) {
        this.f32062g = str;
    }

    public void b(String str) {
        String str2;
        if (str.endsWith(Constants.URL_PATH_DELIMITER)) {
            str2 = str.concat("txvodcache");
        } else {
            str2 = str.concat("/txvodcache");
        }
        String str3 = this.f32060e;
        if (str3 == null || !str3.equals(str2)) {
            this.f32060e = str2;
            String str4 = this.f32060e;
            if (str4 != null) {
                new File(str4).mkdirs();
                if (!b()) {
                    d();
                }
            }
        }
    }

    public a c(String str) {
        String str2 = this.f32060e;
        if (!(str2 == null || str == null)) {
            File file = new File(str2);
            if (!file.mkdirs() && !file.isDirectory()) {
                return null;
            }
            Iterator<a> it = this.f32058c.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.url.equals(str)) {
                    a(next);
                    this.f32059d.add(next);
                    return new a(next.path, this.f32060e, next.fileType);
                }
            }
            Iterator<a> it2 = this.f32058c.iterator();
            while (it2.hasNext() && this.f32058c.size() > this.f32061f) {
                a next2 = it2.next();
                if (!this.f32059d.contains(next2)) {
                    b(next2);
                    it2.remove();
                }
            }
            a e2 = e(str);
            if (e2 != null) {
                this.f32059d.add(e2);
                return new a(e2.path, this.f32060e, e2.fileType);
            }
        }
        return null;
    }

    public boolean d(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getPath() == null || parse.getScheme() == null || !parse.getScheme().startsWith("http")) {
            return false;
        }
        if (parse.getPath().endsWith(".mp4") || parse.getPath().endsWith(IjkMediaMeta.IJKM_KEY_M3U8) || parse.getPath().endsWith(".MP4") || parse.getPath().endsWith("M3U8")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        this.f32058c = new ArrayList<>();
        this.f32059d = new HashSet<>();
        try {
            for (Node firstChild = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(this.f32060e + Constants.URL_PATH_DELIMITER + "tx_cache.xml")).getElementsByTagName("caches").item(0).getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                a aVar = new a();
                for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                    if (firstChild2.getNodeName().equals("path")) {
                        aVar.b(firstChild2.getFirstChild().getNodeValue());
                    } else if (firstChild2.getNodeName().equals("time")) {
                        aVar.a(Long.valueOf(Long.parseLong(firstChild2.getFirstChild().getNodeValue())));
                    } else if (firstChild2.getNodeName().equals("url")) {
                        aVar.a(firstChild2.getFirstChild().getNodeValue());
                    } else if (firstChild2.getNodeName().equals("fileType")) {
                        aVar.c(firstChild2.getFirstChild().getNodeValue());
                    }
                }
                this.f32058c.add(aVar);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        try {
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element createElement = newDocument.createElement("caches");
            newDocument.appendChild(createElement);
            Iterator<a> it = this.f32058c.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Element createElement2 = newDocument.createElement("cache");
                createElement.appendChild(createElement2);
                Element createElement3 = newDocument.createElement("path");
                createElement3.appendChild(newDocument.createTextNode(next.b()));
                createElement2.appendChild(createElement3);
                Element createElement4 = newDocument.createElement("time");
                createElement4.appendChild(newDocument.createTextNode(next.c().toString()));
                createElement2.appendChild(createElement4);
                Element createElement5 = newDocument.createElement("url");
                createElement5.appendChild(newDocument.createTextNode(next.a()));
                createElement2.appendChild(createElement5);
                Element createElement6 = newDocument.createElement("fileType");
                createElement6.appendChild(newDocument.createTextNode(next.d()));
                createElement2.appendChild(createElement6);
            }
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            DOMSource dOMSource = new DOMSource(newDocument);
            StreamResult streamResult = new StreamResult();
            streamResult.setSystemId(new File(this.f32060e, "tx_cache.xml").getAbsolutePath());
            newTransformer.transform(dOMSource, streamResult);
            System.out.println("File saved!");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        aVar.time = Long.valueOf(System.currentTimeMillis());
        this.f32058c.remove(aVar);
        this.f32058c.add(aVar);
        c();
    }

    /* access modifiers changed from: package-private */
    public a e(String str) {
        a aVar = new a();
        aVar.url = str;
        aVar.time = Long.valueOf(System.currentTimeMillis());
        String f2 = f(str);
        Uri parse = Uri.parse(str);
        if (parse.getPath().endsWith(".mp4") || parse.getPath().endsWith(".MP4")) {
            if (this.f32062g != null) {
                aVar.b(f2 + "." + this.f32062g);
            } else {
                aVar.b(f2 + ".mp4");
            }
            aVar.c("mp4");
        } else if (!parse.getPath().endsWith(".m3u8") && !parse.getPath().endsWith(".M3U8")) {
            return null;
        } else {
            aVar.b(f2 + ".m3u8.sqlite");
            aVar.c(IjkMediaMeta.IJKM_KEY_M3U8);
        }
        this.f32058c.add(aVar);
        c();
        return aVar;
    }

    public static String f(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                byte b3 = b2 & 255;
                if (b3 < 16) {
                    sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                sb.append(Integer.toHexString(b3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void d() {
        if (new File(this.f32060e).listFiles().length > 0) {
            String str = f32056a;
            Log.w(str, "!!!警告：TXVodPlayer缓存目录不为空 " + this.f32060e + "!!!");
        }
    }

    private void a(String str, String str2) {
        String str3 = this.f32060e + Constants.URL_PATH_DELIMITER + str;
        new File(str3).delete();
        if (str2.equals("mp4")) {
            new File(str3.concat(".info")).delete();
        }
        Log.w(f32056a, "delete " + str3);
    }

    private void b(a aVar) {
        a(aVar.b(), aVar.d());
    }

    public void a(String str, boolean z) {
        Iterator<a> it = this.f32059d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b().equals(str)) {
                it.remove();
                if (z) {
                    b(next);
                    this.f32058c.remove(next);
                    c();
                }
            }
        }
    }
}
