package com.shopee.feeds.feedlibrary.util;

import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.d.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.feeds.feedlibrary.data.c.b;
import com.shopee.feeds.feedlibrary.data.c.c;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class v {
    private static String a(long j, String str, String str2, String str3) {
        return (j < 0 || j >= 1000) ? (j < 1000 || j >= JobManager.NS_PER_MS) ? (j < JobManager.NS_PER_MS || j >= 1000000000) ? j > 1000000000 ? str3 : "" : str2 : str : "";
    }

    public static String d(String str) {
        return str;
    }

    public static String a() {
        String b2 = b();
        if (Country.COUNTRY_SG.equals(b2)) {
            return "$";
        }
        if ("ID".equals(b2)) {
            return "Rp";
        }
        if (Country.COUNTRY_MY.equals(b2)) {
            return "RM";
        }
        if (Country.COUNTRY_TW.equals(b2)) {
            return "$";
        }
        if (Country.COUNTRY_TH.equals(b2)) {
            return "฿";
        }
        if (Country.COUNTRY_VN.equals(b2)) {
            return "₫";
        }
        if (Country.COUNTRY_PH.equals(b2)) {
            return "₱";
        }
        if (Country.COUNTRY_IR.equals(b2)) {
            return "تومان";
        }
        if (Country.COUNTRY_MM.equals(b2)) {
            return "Ks";
        }
        if (Country.COUNTRY_HK.equals(b2)) {
            return "$";
        }
        return "";
    }

    public static String a(String str) {
        String b2 = b();
        try {
            double parseDouble = Double.parseDouble(str);
            if (!Country.COUNTRY_VN.equals(b2)) {
                if (!"ID".equals(b2)) {
                    str = NumberFormat.getInstance(Locale.CHINA).format(parseDouble);
                    return c(str);
                }
            }
            str = NumberFormat.getInstance(Locale.GERMAN).format(parseDouble);
        } catch (NumberFormatException unused) {
            a.a("StringUtil: formatNumber error: " + str, new Object[0]);
        }
        return c(str);
    }

    public static String b(String str) {
        String b2 = b();
        try {
            if (!Country.COUNTRY_PH.equals(b2) && !Country.COUNTRY_TH.equals(b2)) {
                if (!Country.COUNTRY_TW.equals(b2)) {
                    if (!Country.COUNTRY_VN.equals(b2)) {
                        if (!"ID".equals(b2)) {
                            str = NumberFormat.getInstance(Locale.CHINA).format((long) Double.parseDouble(str));
                            return c(str);
                        }
                    }
                    str = NumberFormat.getInstance(Locale.GERMAN).format((long) Double.parseDouble(str));
                    return c(str);
                }
            }
            str = NumberFormat.getInstance(Locale.CHINA).format(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            a.a("StringUtil: formatNumberWithDecimal error: " + str, new Object[0]);
        }
        return c(str);
    }

    public static String c(String str) {
        String b2 = b();
        if (Country.COUNTRY_VN.equals(b2) || "ID".equals(b2)) {
            return str.indexOf(",") > 0 ? str.replaceAll("0+?$", "").replaceAll("[,]$", "") : str;
        }
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public static String a(String str, int i) {
        String str2;
        if (d.a(str) || !d.b(str)) {
            str2 = "";
        } else {
            String f2 = b.f();
            if ("id".equals(f2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "rb", "juta", "miliar");
            } else if ("th".equals(f2)) {
                str2 = Long.valueOf(str).longValue() < 1000000000 ? a(Long.valueOf(str).longValue(), i, "พัน", "ล้าน", "b") : b(str);
            } else {
                str2 = "vi".equals(f2) ? Long.valueOf(str).longValue() < 1000000000 ? a(Long.valueOf(str).longValue(), i, "k", "tr", "b") : b(str) : a(Long.valueOf(str).longValue(), i, "k", "m", "b");
            }
        }
        return g(str2);
    }

    public static String b(String str, int i) {
        String str2;
        if (!d.a(str)) {
            String b2 = b();
            if (Country.COUNTRY_SG.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "k", "m", "b");
            } else if ("ID".equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "rb", "juta", "miliar");
            } else if (Country.COUNTRY_MY.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "k", "m", "b");
            } else if (Country.COUNTRY_TW.equals(b2)) {
                str2 = b(str);
            } else if (Country.COUNTRY_TH.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "พัน", "ล้าน", "");
            } else if (Country.COUNTRY_VN.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "k", "tr", "");
            } else if (Country.COUNTRY_PH.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i, "k", "mil", "b");
            } else if (Country.COUNTRY_IR.equals(b2)) {
                str2 = b(str);
            } else if (Country.COUNTRY_MM.equals(b2)) {
                str2 = b(str);
            }
            return g(str2);
        }
        str2 = "";
        return g(str2);
    }

    private static String a(long j, int i, String str, String str2, String str3) {
        if (j >= 0 && j < 1000) {
            return String.valueOf(j);
        }
        if (j >= 1000 && j < JobManager.NS_PER_MS) {
            String a2 = a(j / 1000, (j % 1000) / ((long) ((int) Math.pow(10.0d, (double) ((3 - i) - 1)))));
            if (a2.equals("1000")) {
                return "1" + str2;
            }
            return a2 + str;
        } else if (j >= JobManager.NS_PER_MS && j < 1000000000) {
            String a3 = a(j / JobManager.NS_PER_MS, (j % JobManager.NS_PER_MS) / ((long) ((int) Math.pow(10.0d, (double) ((6 - i) - 1)))));
            if (!a3.equals("1000") || d.a(str3)) {
                return a3 + str2;
            }
            return "1" + str3;
        } else if (j < 1000000000) {
            return "";
        } else {
            if (!d.a(str3)) {
                return a(j / 1000000000, (j % 1000000000) / ((long) ((int) Math.pow(10.0d, (double) ((9 - i) - 1))))) + str3;
            }
            String a4 = a(j / JobManager.NS_PER_MS, (j % JobManager.NS_PER_MS) / ((long) ((int) Math.pow(10.0d, (double) ((6 - i) - 1)))));
            return a4 + str2;
        }
    }

    public static String c(String str, int i) {
        String str2;
        if (!d.a(str)) {
            String b2 = b();
            if (Country.COUNTRY_SG.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i);
            } else if ("ID".equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i);
            } else if (Country.COUNTRY_MY.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i);
            } else if (Country.COUNTRY_TW.equals(b2)) {
                str2 = b(str);
            } else if (Country.COUNTRY_TH.equals(b2)) {
                str2 = Long.valueOf(str).longValue() < 1000000000 ? a(Long.valueOf(str).longValue(), i) : a(Long.valueOf(str).longValue() / JobManager.NS_PER_MS, (Long.valueOf(str).longValue() % JobManager.NS_PER_MS) / ((long) ((int) Math.pow(10.0d, (double) ((6 - i) - 1)))));
            } else if (Country.COUNTRY_VN.equals(b2)) {
                str2 = Long.valueOf(str).longValue() < 1000000000 ? a(Long.valueOf(str).longValue(), i) : a(Long.valueOf(str).longValue() / JobManager.NS_PER_MS, (Long.valueOf(str).longValue() % JobManager.NS_PER_MS) / ((long) ((int) Math.pow(10.0d, (double) ((6 - i) - 1)))));
            } else if (Country.COUNTRY_PH.equals(b2)) {
                str2 = a(Long.valueOf(str).longValue(), i);
            } else if (Country.COUNTRY_IR.equals(b2)) {
                str2 = b(str);
            } else if (Country.COUNTRY_MM.equals(b2)) {
                str2 = b(str);
            }
            return g(str2);
        }
        str2 = "";
        return g(str2);
    }

    private static String a(long j, int i) {
        if (j >= 0 && j < 1000) {
            return String.valueOf(j);
        }
        if (j >= 1000 && j < JobManager.NS_PER_MS) {
            return a(j / 1000, (j % 1000) / ((long) ((int) Math.pow(10.0d, (double) ((3 - i) - 1)))));
        }
        if (j < JobManager.NS_PER_MS || j >= 1000000000) {
            return j > 1000000000 ? a(j / 1000000000, (j % 1000000000) / ((long) ((int) Math.pow(10.0d, (double) ((9 - i) - 1))))) : "";
        }
        return a(j / JobManager.NS_PER_MS, (j % JobManager.NS_PER_MS) / ((long) ((int) Math.pow(10.0d, (double) ((6 - i) - 1)))));
    }

    public static String e(String str) {
        if (!d.a(str) && d.b(str)) {
            String b2 = b();
            if (Country.COUNTRY_SG.equals(b2)) {
                return a(Long.valueOf(str).longValue(), "k", "m", "b");
            }
            if ("ID".equals(b2)) {
                return a(Long.valueOf(str).longValue(), "rb", "juta", "miliar");
            }
            if (Country.COUNTRY_MY.equals(b2)) {
                return a(Long.valueOf(str).longValue(), "k", "m", "b");
            }
            if (!Country.COUNTRY_TW.equals(b2)) {
                if (Country.COUNTRY_TH.equals(b2)) {
                    if (Long.valueOf(str).longValue() < 1000000000) {
                        return a(Long.valueOf(str).longValue(), "พัน", "ล้าน", "b");
                    }
                    return "ล้าน";
                } else if (Country.COUNTRY_VN.equals(b2)) {
                    if (Long.valueOf(str).longValue() < 1000000000) {
                        return a(Long.valueOf(str).longValue(), "k", "tr", "b");
                    }
                    return "tr";
                } else if (Country.COUNTRY_PH.equals(b2)) {
                    return a(Long.valueOf(str).longValue(), "k", "mil", "b");
                } else {
                    if (!Country.COUNTRY_IR.equals(b2) && Country.COUNTRY_MM.equals(b2)) {
                    }
                }
            }
        }
        return "";
    }

    private static String a(long j, long j2) {
        String valueOf = String.valueOf(j2);
        if (j2 < 10) {
            valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + valueOf;
        }
        String str = String.valueOf(j) + "." + valueOf + "1";
        return c(g(String.valueOf((d.a(str) || (!d.b(str) && str.indexOf(46) == -1)) ? 0.0d : new BigDecimal(Double.valueOf(str).doubleValue()).setScale(1, 4).doubleValue())));
    }

    private static String g(String str) {
        if (d.a(str) || str.indexOf(".") == -1) {
            return str;
        }
        String b2 = b();
        return ("ID".equals(b2) || Country.COUNTRY_VN.equals(b2)) ? str.replace(".", ",") : str;
    }

    public static String b() {
        if (c.f27687a == 0) {
            return "ID";
        }
        return com.shopee.sdk.b.a().a().a().d();
    }

    public static double a(long j) {
        if (j <= 0) {
            return 0.0d;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        double doubleValue = Double.valueOf(decimalFormat.format((double) (((float) j) / ((float) 1000)))).doubleValue();
        if (Math.signum(doubleValue) >= 0.0d) {
            return (double) Math.round(doubleValue);
        }
        double round = (double) Math.round(Math.abs(doubleValue));
        Double.isNaN(round);
        return 0.0d - round;
    }

    public static String f(String str) {
        SimpleDateFormat simpleDateFormat;
        if (d.a(str)) {
            return "";
        }
        String b2 = b();
        if (Country.COUNTRY_PH.equals(b2)) {
            simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy");
        } else if (Country.COUNTRY_TW.equals(b2)) {
            simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        } else {
            simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        }
        return simpleDateFormat.format(new Date(Long.valueOf(str).longValue() * 1000));
    }

    public static final String a(int i) {
        try {
            return new DecimalFormat("#.#").format((double) (((float) (100 - i)) / 10.0f));
        } catch (Exception unused) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }
}
