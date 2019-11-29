package com.google.android.exoplayer2.s;

import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11390a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11391b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11392c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f11393d = new HashMap();

    private static int a(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    static {
        f11393d.put("aliceblue", -984833);
        f11393d.put("antiquewhite", -332841);
        f11393d.put("aqua", -16711681);
        f11393d.put("aquamarine", -8388652);
        f11393d.put("azure", -983041);
        f11393d.put("beige", -657956);
        f11393d.put("bisque", -6972);
        f11393d.put("black", -16777216);
        f11393d.put("blanchedalmond", -5171);
        f11393d.put("blue", -16776961);
        f11393d.put("blueviolet", -7722014);
        f11393d.put("brown", -5952982);
        f11393d.put("burlywood", -2180985);
        f11393d.put("cadetblue", -10510688);
        f11393d.put("chartreuse", -8388864);
        f11393d.put("chocolate", -2987746);
        f11393d.put("coral", -32944);
        f11393d.put("cornflowerblue", -10185235);
        f11393d.put("cornsilk", -1828);
        f11393d.put("crimson", -2354116);
        f11393d.put("cyan", -16711681);
        f11393d.put("darkblue", -16777077);
        f11393d.put("darkcyan", -16741493);
        f11393d.put("darkgoldenrod", -4684277);
        f11393d.put("darkgray", -5658199);
        f11393d.put("darkgreen", -16751616);
        f11393d.put("darkgrey", -5658199);
        f11393d.put("darkkhaki", -4343957);
        f11393d.put("darkmagenta", -7667573);
        f11393d.put("darkolivegreen", -11179217);
        f11393d.put("darkorange", -29696);
        f11393d.put("darkorchid", -6737204);
        f11393d.put("darkred", -7667712);
        f11393d.put("darksalmon", -1468806);
        f11393d.put("darkseagreen", -7357297);
        f11393d.put("darkslateblue", -12042869);
        f11393d.put("darkslategray", -13676721);
        f11393d.put("darkslategrey", -13676721);
        f11393d.put("darkturquoise", -16724271);
        f11393d.put("darkviolet", -7077677);
        f11393d.put("deeppink", -60269);
        f11393d.put("deepskyblue", -16728065);
        f11393d.put("dimgray", -9868951);
        f11393d.put("dimgrey", -9868951);
        f11393d.put("dodgerblue", -14774017);
        f11393d.put("firebrick", -5103070);
        f11393d.put("floralwhite", -1296);
        f11393d.put("forestgreen", -14513374);
        f11393d.put("fuchsia", -65281);
        f11393d.put("gainsboro", -2302756);
        f11393d.put("ghostwhite", -460545);
        f11393d.put("gold", -10496);
        f11393d.put("goldenrod", -2448096);
        f11393d.put("gray", -8355712);
        f11393d.put("green", -16744448);
        f11393d.put("greenyellow", -5374161);
        f11393d.put("grey", -8355712);
        f11393d.put("honeydew", -983056);
        f11393d.put("hotpink", -38476);
        f11393d.put("indianred", -3318692);
        f11393d.put("indigo", -11861886);
        f11393d.put("ivory", -16);
        f11393d.put("khaki", -989556);
        f11393d.put("lavender", -1644806);
        f11393d.put("lavenderblush", -3851);
        f11393d.put("lawngreen", -8586240);
        f11393d.put("lemonchiffon", -1331);
        f11393d.put("lightblue", -5383962);
        f11393d.put("lightcoral", -1015680);
        f11393d.put("lightcyan", -2031617);
        f11393d.put("lightgoldenrodyellow", -329006);
        f11393d.put("lightgray", -2894893);
        f11393d.put("lightgreen", -7278960);
        f11393d.put("lightgrey", -2894893);
        f11393d.put("lightpink", -18751);
        f11393d.put("lightsalmon", -24454);
        f11393d.put("lightseagreen", -14634326);
        f11393d.put("lightskyblue", -7876870);
        f11393d.put("lightslategray", -8943463);
        f11393d.put("lightslategrey", -8943463);
        f11393d.put("lightsteelblue", -5192482);
        f11393d.put("lightyellow", -32);
        f11393d.put("lime", -16711936);
        f11393d.put("limegreen", -13447886);
        f11393d.put("linen", -331546);
        f11393d.put("magenta", -65281);
        f11393d.put("maroon", -8388608);
        f11393d.put("mediumaquamarine", -10039894);
        f11393d.put("mediumblue", -16777011);
        f11393d.put("mediumorchid", -4565549);
        f11393d.put("mediumpurple", -7114533);
        f11393d.put("mediumseagreen", -12799119);
        f11393d.put("mediumslateblue", -8689426);
        f11393d.put("mediumspringgreen", -16713062);
        f11393d.put("mediumturquoise", -12004916);
        f11393d.put("mediumvioletred", -3730043);
        f11393d.put("midnightblue", -15132304);
        f11393d.put("mintcream", -655366);
        f11393d.put("mistyrose", -6943);
        f11393d.put("moccasin", -6987);
        f11393d.put("navajowhite", -8531);
        f11393d.put("navy", -16777088);
        f11393d.put("oldlace", -133658);
        f11393d.put("olive", -8355840);
        f11393d.put("olivedrab", -9728477);
        f11393d.put("orange", -23296);
        f11393d.put("orangered", -47872);
        f11393d.put("orchid", -2461482);
        f11393d.put("palegoldenrod", -1120086);
        f11393d.put("palegreen", -6751336);
        f11393d.put("paleturquoise", -5247250);
        f11393d.put("palevioletred", -2396013);
        f11393d.put("papayawhip", -4139);
        f11393d.put("peachpuff", -9543);
        f11393d.put("peru", -3308225);
        f11393d.put("pink", -16181);
        f11393d.put("plum", -2252579);
        f11393d.put("powderblue", -5185306);
        f11393d.put("purple", -8388480);
        f11393d.put("rebeccapurple", -10079335);
        f11393d.put("red", -65536);
        f11393d.put("rosybrown", -4419697);
        f11393d.put("royalblue", -12490271);
        f11393d.put("saddlebrown", -7650029);
        f11393d.put("salmon", -360334);
        f11393d.put("sandybrown", -744352);
        f11393d.put("seagreen", -13726889);
        f11393d.put("seashell", -2578);
        f11393d.put("sienna", -6270419);
        f11393d.put("silver", -4144960);
        f11393d.put("skyblue", -7876885);
        f11393d.put("slateblue", -9807155);
        f11393d.put("slategray", -9404272);
        f11393d.put("slategrey", -9404272);
        f11393d.put("snow", -1286);
        f11393d.put("springgreen", -16711809);
        f11393d.put("steelblue", -12156236);
        f11393d.put("tan", -2968436);
        f11393d.put("teal", -16744320);
        f11393d.put("thistle", -2572328);
        f11393d.put("tomato", -40121);
        f11393d.put("transparent", 0);
        f11393d.put("turquoise", -12525360);
        f11393d.put("violet", -1146130);
        f11393d.put("wheat", -663885);
        f11393d.put("white", -1);
        f11393d.put("whitesmoke", -657931);
        f11393d.put("yellow", -256);
        f11393d.put("yellowgreen", -6632142);
    }

    public static int a(String str) {
        return a(str, false);
    }

    public static int b(String str) {
        return a(str, true);
    }

    private static int a(String str, boolean z) {
        int i;
        a.a(!TextUtils.isEmpty(str));
        String replace = str.replace(SQLBuilder.BLANK, "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return -16777216 | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? f11392c : f11391b).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    i = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                } else {
                    i = Integer.parseInt(matcher.group(4), 10);
                }
                return a(i, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f11390a.matcher(replace);
            if (matcher2.matches()) {
                return a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = f11393d.get(v.d(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int a(int i, int i2, int i3) {
        return a(255, i, i2, i3);
    }
}
