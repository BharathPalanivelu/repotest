package com.google.android.exoplayer2.n;

import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10916a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f10917b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f10918c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f10919d = new HashMap();

    private static int a(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    static {
        f10919d.put("aliceblue", -984833);
        f10919d.put("antiquewhite", -332841);
        f10919d.put("aqua", -16711681);
        f10919d.put("aquamarine", -8388652);
        f10919d.put("azure", -983041);
        f10919d.put("beige", -657956);
        f10919d.put("bisque", -6972);
        f10919d.put("black", -16777216);
        f10919d.put("blanchedalmond", -5171);
        f10919d.put("blue", -16776961);
        f10919d.put("blueviolet", -7722014);
        f10919d.put("brown", -5952982);
        f10919d.put("burlywood", -2180985);
        f10919d.put("cadetblue", -10510688);
        f10919d.put("chartreuse", -8388864);
        f10919d.put("chocolate", -2987746);
        f10919d.put("coral", -32944);
        f10919d.put("cornflowerblue", -10185235);
        f10919d.put("cornsilk", -1828);
        f10919d.put("crimson", -2354116);
        f10919d.put("cyan", -16711681);
        f10919d.put("darkblue", -16777077);
        f10919d.put("darkcyan", -16741493);
        f10919d.put("darkgoldenrod", -4684277);
        f10919d.put("darkgray", -5658199);
        f10919d.put("darkgreen", -16751616);
        f10919d.put("darkgrey", -5658199);
        f10919d.put("darkkhaki", -4343957);
        f10919d.put("darkmagenta", -7667573);
        f10919d.put("darkolivegreen", -11179217);
        f10919d.put("darkorange", -29696);
        f10919d.put("darkorchid", -6737204);
        f10919d.put("darkred", -7667712);
        f10919d.put("darksalmon", -1468806);
        f10919d.put("darkseagreen", -7357297);
        f10919d.put("darkslateblue", -12042869);
        f10919d.put("darkslategray", -13676721);
        f10919d.put("darkslategrey", -13676721);
        f10919d.put("darkturquoise", -16724271);
        f10919d.put("darkviolet", -7077677);
        f10919d.put("deeppink", -60269);
        f10919d.put("deepskyblue", -16728065);
        f10919d.put("dimgray", -9868951);
        f10919d.put("dimgrey", -9868951);
        f10919d.put("dodgerblue", -14774017);
        f10919d.put("firebrick", -5103070);
        f10919d.put("floralwhite", -1296);
        f10919d.put("forestgreen", -14513374);
        f10919d.put("fuchsia", -65281);
        f10919d.put("gainsboro", -2302756);
        f10919d.put("ghostwhite", -460545);
        f10919d.put("gold", -10496);
        f10919d.put("goldenrod", -2448096);
        f10919d.put("gray", -8355712);
        f10919d.put("green", -16744448);
        f10919d.put("greenyellow", -5374161);
        f10919d.put("grey", -8355712);
        f10919d.put("honeydew", -983056);
        f10919d.put("hotpink", -38476);
        f10919d.put("indianred", -3318692);
        f10919d.put("indigo", -11861886);
        f10919d.put("ivory", -16);
        f10919d.put("khaki", -989556);
        f10919d.put("lavender", -1644806);
        f10919d.put("lavenderblush", -3851);
        f10919d.put("lawngreen", -8586240);
        f10919d.put("lemonchiffon", -1331);
        f10919d.put("lightblue", -5383962);
        f10919d.put("lightcoral", -1015680);
        f10919d.put("lightcyan", -2031617);
        f10919d.put("lightgoldenrodyellow", -329006);
        f10919d.put("lightgray", -2894893);
        f10919d.put("lightgreen", -7278960);
        f10919d.put("lightgrey", -2894893);
        f10919d.put("lightpink", -18751);
        f10919d.put("lightsalmon", -24454);
        f10919d.put("lightseagreen", -14634326);
        f10919d.put("lightskyblue", -7876870);
        f10919d.put("lightslategray", -8943463);
        f10919d.put("lightslategrey", -8943463);
        f10919d.put("lightsteelblue", -5192482);
        f10919d.put("lightyellow", -32);
        f10919d.put("lime", -16711936);
        f10919d.put("limegreen", -13447886);
        f10919d.put("linen", -331546);
        f10919d.put("magenta", -65281);
        f10919d.put("maroon", -8388608);
        f10919d.put("mediumaquamarine", -10039894);
        f10919d.put("mediumblue", -16777011);
        f10919d.put("mediumorchid", -4565549);
        f10919d.put("mediumpurple", -7114533);
        f10919d.put("mediumseagreen", -12799119);
        f10919d.put("mediumslateblue", -8689426);
        f10919d.put("mediumspringgreen", -16713062);
        f10919d.put("mediumturquoise", -12004916);
        f10919d.put("mediumvioletred", -3730043);
        f10919d.put("midnightblue", -15132304);
        f10919d.put("mintcream", -655366);
        f10919d.put("mistyrose", -6943);
        f10919d.put("moccasin", -6987);
        f10919d.put("navajowhite", -8531);
        f10919d.put("navy", -16777088);
        f10919d.put("oldlace", -133658);
        f10919d.put("olive", -8355840);
        f10919d.put("olivedrab", -9728477);
        f10919d.put("orange", -23296);
        f10919d.put("orangered", -47872);
        f10919d.put("orchid", -2461482);
        f10919d.put("palegoldenrod", -1120086);
        f10919d.put("palegreen", -6751336);
        f10919d.put("paleturquoise", -5247250);
        f10919d.put("palevioletred", -2396013);
        f10919d.put("papayawhip", -4139);
        f10919d.put("peachpuff", -9543);
        f10919d.put("peru", -3308225);
        f10919d.put("pink", -16181);
        f10919d.put("plum", -2252579);
        f10919d.put("powderblue", -5185306);
        f10919d.put("purple", -8388480);
        f10919d.put("rebeccapurple", -10079335);
        f10919d.put("red", -65536);
        f10919d.put("rosybrown", -4419697);
        f10919d.put("royalblue", -12490271);
        f10919d.put("saddlebrown", -7650029);
        f10919d.put("salmon", -360334);
        f10919d.put("sandybrown", -744352);
        f10919d.put("seagreen", -13726889);
        f10919d.put("seashell", -2578);
        f10919d.put("sienna", -6270419);
        f10919d.put("silver", -4144960);
        f10919d.put("skyblue", -7876885);
        f10919d.put("slateblue", -9807155);
        f10919d.put("slategray", -9404272);
        f10919d.put("slategrey", -9404272);
        f10919d.put("snow", -1286);
        f10919d.put("springgreen", -16711809);
        f10919d.put("steelblue", -12156236);
        f10919d.put("tan", -2968436);
        f10919d.put("teal", -16744320);
        f10919d.put("thistle", -2572328);
        f10919d.put("tomato", -40121);
        f10919d.put("transparent", 0);
        f10919d.put("turquoise", -12525360);
        f10919d.put("violet", -1146130);
        f10919d.put("wheat", -663885);
        f10919d.put("white", -1);
        f10919d.put("whitesmoke", -657931);
        f10919d.put("yellow", -256);
        f10919d.put("yellowgreen", -6632142);
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
            Matcher matcher = (z ? f10918c : f10917b).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    i = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                } else {
                    i = Integer.parseInt(matcher.group(4), 10);
                }
                return a(i, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f10916a.matcher(replace);
            if (matcher2.matches()) {
                return a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = f10919d.get(t.d(replace));
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
