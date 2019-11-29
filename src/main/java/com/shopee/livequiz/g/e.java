package com.shopee.livequiz.g;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.livequiz.data.a.b;
import com.shopee.livequiz.data.bean.LiveParams;
import com.shopee.livequiz.data.bean.MD5Bean;
import com.shopee.livequiz.data.bean.MetaColorBean;
import com.shopee.livequiz.data.bean.MetaTextBean;
import com.shopee.sdk.f.a;
import java.util.HashMap;
import java.util.List;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f29855b;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f29856a;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f29855b == null) {
                f29855b = new e();
            }
            eVar = f29855b;
        }
        return eVar;
    }

    public void a(LiveParams liveParams) {
        this.f29856a = new HashMap<>();
        List<LiveParams.MetaBean> list = liveParams.metas;
        if (list != null) {
            for (LiveParams.MetaBean next : list) {
                try {
                    String str = next.meta_type;
                    if ("bgm#audio".equals(str)) {
                        this.f29856a.put(next.meta_key, ((MD5Bean) a.f30357a.a(next.meta_value, MD5Bean.class)).md5);
                    } else {
                        if (!"liveStream#image".equals(str)) {
                            if (!"share#image".equals(str)) {
                                if (!"transifykey#fetext".equals(str) && !"share#text".equals(str)) {
                                    if (!"transifykey#fetext".equals(str)) {
                                        if ("other#color".equals(str)) {
                                            if (!"color_text_B".equals(next.meta_key)) {
                                                this.f29856a.put(next.meta_key, ((MetaColorBean) a.f30357a.a(next.meta_value, MetaColorBean.class)).color);
                                            }
                                        }
                                    }
                                }
                                this.f29856a.put(next.meta_key, ((MetaTextBean) a.f30357a.a(next.meta_value, MetaTextBean.class)).content);
                            }
                        }
                        this.f29856a.put(next.meta_key, ((MD5Bean) a.f30357a.a(next.meta_value, MD5Bean.class)).md5);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b() {
        e eVar = f29855b;
        if (eVar != null) {
            HashMap<String, String> hashMap = eVar.f29856a;
            if (hashMap != null) {
                hashMap.clear();
                f29855b.f29856a = null;
            }
        }
        f29855b = null;
    }

    public String a(String str) {
        HashMap<String, String> hashMap = this.f29856a;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public String b(String str) {
        if (this.f29856a == null) {
            return null;
        }
        return b.b() + a(str);
    }

    public String c(String str) {
        if (this.f29856a == null) {
            return null;
        }
        return b.a() + a(str);
    }

    public int d(String str) {
        HashMap<String, String> hashMap = this.f29856a;
        if (hashMap == null) {
            return 0;
        }
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String[] split = str2.replace("rgba(", "").replace(SQLBuilder.PARENTHESES_RIGHT, "").replace(SQLBuilder.BLANK, "").split(",");
            if (split.length == 4) {
                try {
                    return Color.argb(255 - Integer.parseInt(split[3]), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                } catch (Exception unused) {
                    com.garena.android.appkit.d.a.a("MetaHelper: getColor exception, " + str, new Object[0]);
                }
            }
        }
        return 0;
    }

    public int a(String str, int i) {
        HashMap<String, String> hashMap = this.f29856a;
        if (hashMap == null) {
            return 0;
        }
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String[] split = str2.replace("rgba(", "").replace(SQLBuilder.PARENTHESES_RIGHT, "").replace(SQLBuilder.BLANK, "").split(",");
            if (split.length == 4) {
                try {
                    return Color.argb(Math.min(Math.max(0, i), 255), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                } catch (Exception unused) {
                    com.garena.android.appkit.d.a.a("MetaHelper: getColor exception, " + str, new Object[0]);
                }
            }
        }
        return 0;
    }

    public static void a(ImageView imageView, String str, int i) {
        String c2 = a().c(str);
        if (imageView != null && c2 != null) {
            b.a(c2, imageView, i);
        }
    }

    public static void a(ImageView imageView, String str, int i, int i2, int i3) {
        String c2 = a().c(str);
        if (imageView != null && c2 != null) {
            b.a(c2, imageView, i, i2, i3);
        }
    }

    public static void b(ImageView imageView, String str, int i) {
        String c2 = a().c(str);
        if (imageView != null && c2 != null) {
            b.b(c2, imageView, i);
        }
    }

    public static void a(TextView textView, String str) {
        String a2 = a().a(str);
        if (textView != null && a2 != null) {
            textView.setText(a2);
        }
    }
}
