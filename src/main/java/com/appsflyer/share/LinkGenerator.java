package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LinkGenerator {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f306;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f307;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f308;

    /* renamed from: ˊ  reason: contains not printable characters */
    String f309;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f310;

    /* renamed from: ˋ  reason: contains not printable characters */
    String f311;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f312;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f313;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Map<String, String> f314 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f315;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Map<String, String> f316 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f317;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f318;

    public LinkGenerator(String str) {
        this.f313 = str;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.f318 = str;
        return this;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.f310 = str;
        return this;
    }

    public String getChannel() {
        return this.f315;
    }

    public LinkGenerator setChannel(String str) {
        this.f315 = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.f307 = str;
        return this;
    }

    public String getMediaSource() {
        return this.f313;
    }

    public Map<String, String> getParameters() {
        return this.f314;
    }

    public String getCampaign() {
        return this.f312;
    }

    public LinkGenerator setCampaign(String str) {
        this.f312 = str;
        return this;
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.f314.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.f314.putAll(map);
        }
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.f308 = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.f306 = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.f317 = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.f309 = String.format(Constants.AF_BASE_URL_FORMAT, new Object[]{ServerConfigHandler.getUrl(Constants.APPSFLYER_DEFAULT_APP_DOMAIN), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = Constants.ONELINK_DEFAULT_DOMAIN;
            }
            this.f309 = String.format(Constants.AF_BASE_URL_FORMAT, new Object[]{str2, str});
        }
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private StringBuilder m218() {
        StringBuilder sb = new StringBuilder();
        String str = this.f309;
        if (str == null || !str.startsWith("http")) {
            sb.append(ServerConfigHandler.getUrl(Constants.BASE_URL_APP_APPSFLYER_COM));
        } else {
            sb.append(this.f309);
        }
        if (this.f311 != null) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(this.f311);
        }
        this.f316.put(Constants.URL_MEDIA_SOURCE, this.f313);
        sb.append('?');
        sb.append("pid=");
        sb.append(m217(this.f313, "media source"));
        String str2 = this.f308;
        if (str2 != null) {
            this.f316.put(Constants.URL_REFERRER_UID, str2);
            sb.append('&');
            sb.append("af_referrer_uid=");
            sb.append(m217(this.f308, "referrerUID"));
        }
        String str3 = this.f315;
        if (str3 != null) {
            this.f316.put("af_channel", str3);
            sb.append('&');
            sb.append("af_channel=");
            sb.append(m217(this.f315, AppsFlyerProperties.CHANNEL));
        }
        String str4 = this.f307;
        if (str4 != null) {
            this.f316.put(Constants.URL_REFERRER_CUSTOMER_ID, str4);
            sb.append('&');
            sb.append("af_referrer_customer_id=");
            sb.append(m217(this.f307, "referrerCustomerId"));
        }
        String str5 = this.f312;
        if (str5 != null) {
            this.f316.put(Constants.URL_CAMPAIGN, str5);
            sb.append('&');
            sb.append("c=");
            sb.append(m217(this.f312, "campaign"));
        }
        String str6 = this.f306;
        if (str6 != null) {
            this.f316.put(Constants.URL_REFERRER_NAME, str6);
            sb.append('&');
            sb.append("af_referrer_name=");
            sb.append(m217(this.f306, "referrerName"));
        }
        String str7 = this.f317;
        if (str7 != null) {
            this.f316.put(Constants.URL_REFERRER_IMAGE_URL, str7);
            sb.append('&');
            sb.append("af_referrer_image_url=");
            sb.append(m217(this.f317, "referrerImageURL"));
        }
        if (this.f310 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f310);
            String str8 = "";
            sb2.append(this.f310.endsWith(Constants.URL_PATH_DELIMITER) ? str8 : Constants.URL_PATH_DELIMITER);
            String str9 = this.f318;
            if (str9 != null) {
                sb2.append(str9);
            }
            this.f316.put(Constants.URL_BASE_DEEPLINK, sb2.toString());
            sb.append('&');
            sb.append("af_dp=");
            sb.append(m217(this.f310, "baseDeeplink"));
            if (this.f318 != null) {
                if (!this.f310.endsWith(Constants.URL_PATH_DELIMITER)) {
                    str8 = "%2F";
                }
                sb.append(str8);
                sb.append(m217(this.f318, "deeplinkPath"));
            }
        }
        for (String next : this.f314.keySet()) {
            String obj = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(next);
            sb3.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb3.append(m217(this.f314.get(next), next));
            if (!obj.contains(sb3.toString())) {
                sb.append('&');
                sb.append(next);
                sb.append('=');
                sb.append(m217(this.f314.get(next), next));
            }
        }
        return sb;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m217(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException unused) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.afInfoLog(sb.toString());
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public String generateLink() {
        return m218().toString();
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.f314.isEmpty()) {
            for (Map.Entry next : this.f314.entrySet()) {
                this.f316.put(next.getKey(), next.getValue());
            }
        }
        m218();
        ShareInviteHelper.generateUserInviteLink(context, string, this.f316, responseListener);
    }
}
