package com.shopee.app.util;

import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.google.a.o;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.application.ar;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.ui.webview.simpleweb.SimpleWebPageActivity_;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.id.R;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

public class bm {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f26262a = Pattern.compile("--\\{(.*?)\\}--");

    public static String a(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            str2 = URLEncoder.encode(str);
        }
        return str2.replace(Marker.ANY_NON_NULL_MARKER, "%20");
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return URLDecoder.decode(str);
        }
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s", new Object[]{a(next.getKey().toString()), a(next.getValue().toString())}));
        }
        return sb.toString();
    }

    public static void a(String str, Map<String, String> map) throws Exception {
        for (String split : str.split("&")) {
            String[] split2 = split.split(SimpleComparison.EQUAL_TO_OPERATION);
            map.put(b(split2[0]), split2.length < 2 ? "" : b(split2[1]));
        }
    }

    public static o c(String str) {
        try {
            HashMap hashMap = new HashMap();
            a(str, (Map<String, String>) hashMap);
            return WebRegister.GSON.a((Object) hashMap).m();
        } catch (Exception e2) {
            a.a(e2);
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(63);
            if (indexOf < 0) {
                return str + "?" + str2;
            } else if (indexOf == str.length() - 1) {
                return str + str2;
            } else {
                try {
                    Hashtable hashtable = new Hashtable();
                    a(str.substring(indexOf + 1), (Map<String, String>) hashtable);
                    a(str2, (Map<String, String>) hashtable);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str.substring(0, indexOf));
                    stringBuffer.append('?');
                    Enumeration keys = hashtable.keys();
                    while (keys.hasMoreElements()) {
                        String str3 = (String) keys.nextElement();
                        stringBuffer.append('&');
                        stringBuffer.append(a(str3));
                        stringBuffer.append(SimpleComparison.EQUAL_TO_OPERATION);
                        stringBuffer.append(a((String) hashtable.get(str3)));
                    }
                    return stringBuffer.toString();
                } catch (Exception unused) {
                    return str;
                }
            }
        } else if (str2.startsWith("?")) {
            return str2;
        } else {
            return "?" + str2;
        }
    }

    public static String b(String str, String str2) {
        Matcher matcher = Pattern.compile("(?i)" + Pattern.quote(str2)).matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "<font color=#00BFA5>" + matcher.group() + "</font>");
        }
        return matcher.appendTail(stringBuffer).toString();
    }

    public static Spannable d(String str) {
        if (str == null) {
            return new SpannableString("");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(str.replace("<b>", "<font color=\"#00BFA5\">").replace("</b>", "</font>").replace("<s1>", "--{").replace("</s1>", "}--")));
        boolean z = true;
        while (z) {
            Matcher matcher = f26262a.matcher(spannableStringBuilder);
            if (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int end = matcher.end();
                spannableStringBuilder.replace(start, end, group.substring(3, group.length() - 3));
                com.devspark.robototextview.a.a aVar = new com.devspark.robototextview.a.a(ar.f().getApplicationContext(), 4);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-16777216);
                int i = end - 6;
                spannableStringBuilder.setSpan(aVar, start, i, 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, start, i, 33);
            } else {
                z = false;
            }
        }
        return spannableStringBuilder;
    }

    public static String a(TextView textView, int i, final Boolean bool) {
        boolean z;
        int start;
        int end;
        final String group;
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        Matcher matcher = Patterns.WEB_URL.matcher(valueOf);
        String str = null;
        while (true) {
            if (!matcher.find()) {
                z = false;
                break;
            }
            start = matcher.start();
            end = matcher.end();
            group = matcher.group(0);
            if (group.startsWith("http://") || group.startsWith("https://")) {
                valueOf.setSpan(new bk(i) {
                    public void onClick(View view) {
                        Context context = view.getContext();
                        NavbarMessage navbarMessage = new NavbarMessage();
                        navbarMessage.setTitle(group);
                        if (bool.booleanValue()) {
                            bm.a(view.getContext(), group);
                            return;
                        }
                        boolean z = false;
                        try {
                            Uri parse = Uri.parse(group);
                            if (parse.getHost().endsWith(i.f7042e) || i.f7042e.endsWith(parse.getHost())) {
                                try {
                                    WebPageActivity_.a(context).a(WebRegister.GSON.b((Object) navbarMessage)).b(group).a();
                                } catch (Exception unused) {
                                }
                                z = true;
                            }
                        } catch (Exception unused2) {
                        }
                        if (!z) {
                            SimpleWebPageActivity_.a(view.getContext()).a(WebRegister.GSON.b((Object) navbarMessage)).b(group).a(true).a();
                        }
                    }
                }, start, end, 33);
                z = true;
                str = group;
            } else {
                str = group;
            }
        }
        valueOf.setSpan(new bk(i) {
            public void onClick(View view) {
                Context context = view.getContext();
                NavbarMessage navbarMessage = new NavbarMessage();
                navbarMessage.setTitle(group);
                if (bool.booleanValue()) {
                    bm.a(view.getContext(), group);
                    return;
                }
                boolean z = false;
                try {
                    Uri parse = Uri.parse(group);
                    if (parse.getHost().endsWith(i.f7042e) || i.f7042e.endsWith(parse.getHost())) {
                        try {
                            WebPageActivity_.a(context).a(WebRegister.GSON.b((Object) navbarMessage)).b(group).a();
                        } catch (Exception unused) {
                        }
                        z = true;
                    }
                } catch (Exception unused2) {
                }
                if (!z) {
                    SimpleWebPageActivity_.a(view.getContext()).a(WebRegister.GSON.b((Object) navbarMessage)).b(group).a(true).a();
                }
            }
        }, start, end, 33);
        z = true;
        str = group;
        if (z) {
            textView.setText(valueOf);
            MovementMethod movementMethod = textView.getMovementMethod();
            if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        if (z) {
            return str;
        }
        return null;
    }

    public static void a(final Context context, final String str) {
        com.shopee.app.ui.dialog.a.a(context, b.e(R.string.sp_title_confirm_navigation), b.e(R.string.sp_label_link_alert_message), b.e(R.string.sp_label_cancel), b.e(R.string.sp_label_yes_i_am_sure), (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                NavbarMessage navbarMessage = new NavbarMessage();
                navbarMessage.setTitle(str);
                SimpleWebPageActivity_.a(context).a(WebRegister.GSON.b((Object) navbarMessage)).b(str).a(true).a();
            }
        });
    }

    public static void b(final Context context, String str) {
        com.shopee.app.ui.dialog.a.a(context, str, b.e(R.string.sp_label_learn_more), b.e(R.string.sp_label_ok), (a.C0318a) new a.C0318a() {
            public void onPositive() {
            }

            public void onNegative() {
                NavbarMessage navbarMessage = new NavbarMessage();
                navbarMessage.setTitle(b.e(R.string.sp_community_rule));
                SimpleWebPageActivity_.a(context).b(l.j).a(WebRegister.GSON.b((Object) navbarMessage)).a();
            }
        });
    }

    public static boolean c(Context context, String str) throws Exception {
        context.getPackageManager().getPackageInfo(str, 0);
        return true;
    }
}
