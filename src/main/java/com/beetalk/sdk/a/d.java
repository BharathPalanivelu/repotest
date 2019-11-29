package com.beetalk.sdk.a;

import android.os.Environment;
import com.beetalk.sdk.e.a;
import com.beetalk.sdk.e.b;
import com.beetalk.sdk.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f5377a;

    private d() {
    }

    public static d a() {
        synchronized (d.class) {
            if (f5377a == null) {
                synchronized (d.class) {
                    f5377a = new d();
                }
            }
        }
        return f5377a;
    }

    public void a(Map<String, String> map) {
        HashMap hashMap = (HashMap) b();
        for (String next : map.keySet()) {
            hashMap.put(next, map.get(next));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("guest_account_info", new JSONObject(hashMap));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(jSONObject.toString());
    }

    private void b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("guest_account_info", new JSONObject(map));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(jSONObject.toString());
    }

    private void c(String str) {
        File file = new File(f());
        file.mkdirs();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, g()));
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.write(str);
            printWriter.flush();
            printWriter.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            a.a("******* File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the   manifest?", new Object[0]);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private String f() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/com.garena.msdk";
    }

    private String g() {
        Integer a2 = b.a(f.a());
        if (a2.intValue() == -1 || a2.intValue() == 100006) {
            return "guest.dat";
        }
        return "guest" + b.a(f.a()) + ".dat";
    }

    public Map b() {
        HashMap hashMap = new HashMap();
        File file = new File(new File(f()), g());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                try {
                    JSONObject jSONObject = new JSONObject(sb.toString()).getJSONObject("guest_account_info");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                } catch (JSONException e2) {
                    a.a("parse json fail", new Object[0]);
                    e2.printStackTrace();
                    return null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                a.a("read failed from file: " + file.getAbsolutePath(), new Object[0]);
                return null;
            }
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            a.a("fail to read from file: " + file.getAbsolutePath(), new Object[0]);
        }
        return hashMap;
    }

    public void a(String str) {
        HashMap hashMap = (HashMap) b();
        hashMap.remove(str);
        b(hashMap);
    }
}
