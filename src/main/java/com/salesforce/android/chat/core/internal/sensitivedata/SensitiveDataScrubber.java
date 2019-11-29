package com.salesforce.android.chat.core.internal.sensitivedata;

import com.salesforce.android.chat.core.internal.model.ChatModelFactory;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.SensitiveDataRule;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveDataScrubber {
    private static final ServiceLogger log = ServiceLogging.getLogger(SensitiveDataScrubber.class);
    private final ChatModelFactory mChatModelFactory;
    private SensitiveDataRule[] mSensitiveDataRules;

    private SensitiveDataScrubber(Builder builder) {
        this.mSensitiveDataRules = new SensitiveDataRule[0];
        this.mChatModelFactory = builder.mChatModelFactory;
    }

    public void setSensitiveDataRules(SensitiveDataRule... sensitiveDataRuleArr) {
        this.mSensitiveDataRules = sensitiveDataRuleArr;
    }

    public ChatSentMessageReceipt scrubMessage(String str) {
        ArrayList arrayList = new ArrayList();
        SensitiveDataRule[] sensitiveDataRuleArr = this.mSensitiveDataRules;
        int length = sensitiveDataRuleArr.length;
        String str2 = str;
        int i = 0;
        while (i < length) {
            SensitiveDataRule sensitiveDataRule = sensitiveDataRuleArr[i];
            String applySensitiveDataRule = applySensitiveDataRule(sensitiveDataRule, str2);
            if (!applySensitiveDataRule.equals(str2)) {
                arrayList.add(sensitiveDataRule);
            }
            i++;
            str2 = applySensitiveDataRule;
        }
        return this.mChatModelFactory.createChatSentMessageReceipt(str, str2, (SensitiveDataRule[]) arrayList.toArray(new SensitiveDataRule[0]));
    }

    /* access modifiers changed from: package-private */
    public String applySensitiveDataRule(SensitiveDataRule sensitiveDataRule, String str) {
        for (Pattern matcher : sensitiveDataRule.getPatterns()) {
            Matcher matcher2 = matcher.matcher(str);
            if (sensitiveDataRule.getAction().equals(SensitiveDataRule.ACTION_REPLACE)) {
                str = applyReplacement(sensitiveDataRule, matcher2);
            } else if (sensitiveDataRule.getAction().equals(SensitiveDataRule.ACTION_REMOVE)) {
                str = matcher2.replaceAll("");
            }
        }
        return str;
    }

    private String applyReplacement(SensitiveDataRule sensitiveDataRule, Matcher matcher) {
        try {
            return matcher.replaceAll(sensitiveDataRule.getReplacement());
        } catch (Exception e2) {
            log.warn(String.format("Replacement string is not a valid Regular Expression replacement.\n%s\n%s", new Object[]{sensitiveDataRule, e2}));
            return matcher.replaceAll(escapeReplacement(sensitiveDataRule.getReplacement()));
        }
    }

    private String escapeReplacement(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\\$", "\\\\\\$");
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatModelFactory mChatModelFactory;

        public Builder chatModelFactory(ChatModelFactory chatModelFactory) {
            this.mChatModelFactory = chatModelFactory;
            return this;
        }

        public SensitiveDataScrubber build() {
            if (this.mChatModelFactory == null) {
                this.mChatModelFactory = new ChatModelFactory();
            }
            return new SensitiveDataScrubber(this);
        }
    }
}
