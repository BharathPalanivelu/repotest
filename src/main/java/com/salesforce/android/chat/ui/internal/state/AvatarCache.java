package com.salesforce.android.chat.ui.internal.state;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.a.a.a;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.util.AgentNameUtil;
import com.salesforce.android.service.common.ui.internal.utils.AvatarBranding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvatarCache {
    Map<String, String> mAgentAvatarColorMap = new HashMap();
    Map<String, Drawable> mAgentAvatarMap = new HashMap();
    Map<String, String> mAgentInitialAvatarMap = new HashMap();
    List<String> mAgentInitialColors;
    private final Context mContext;
    private Drawable mDefaultAvatar;

    @SuppressLint({"ResourceType"})
    public AvatarCache(Context context) {
        this.mContext = context;
        this.mDefaultAvatar = a.b(context, R.drawable.salesforce_agent_avatar);
        this.mAgentInitialColors = new AvatarBranding().getAccessibleShades(this.mContext.getResources().getColor(R.color.salesforce_brand_secondary), this.mContext.getResources().getColor(R.color.salesforce_brand_secondary_inverted));
    }

    @SuppressLint({"ResourceType"})
    public void addAvatar(String str, int i) {
        if (i > 0) {
            addAvatar(str, a.b(this.mContext, i));
        }
    }

    public void addAvatar(String str, Drawable drawable) {
        if (drawable != null) {
            this.mAgentAvatarMap.put(str, drawable);
        }
    }

    public Drawable getAvatar(String str) {
        Drawable drawable = this.mAgentAvatarMap.get(str);
        return drawable == null ? this.mDefaultAvatar : drawable;
    }

    public void addInitialAvatar(String str) {
        this.mAgentInitialAvatarMap.put(str, AgentNameUtil.getAgentInitial(str));
        if (this.mAgentInitialColors.size() >= this.mAgentInitialAvatarMap.size()) {
            this.mAgentAvatarColorMap.put(str, this.mAgentInitialColors.get(this.mAgentInitialAvatarMap.size() - 1));
        }
    }

    public void removeInitialAvatar(String str) {
        this.mAgentInitialAvatarMap.remove(str);
        this.mAgentAvatarColorMap.remove(str);
    }

    public Drawable getInitialDrawableFor(String str) {
        Drawable b2 = a.b(this.mContext, R.drawable.agent_initial_avatar);
        if (b2 != null) {
            b2.setColorFilter(getAvatarColor(str), PorterDuff.Mode.MULTIPLY);
        }
        return b2;
    }

    public String getInitialAvatar(String str) {
        return this.mAgentInitialAvatarMap.get(str);
    }

    private int getAvatarColor(String str) {
        if (this.mAgentAvatarColorMap.containsKey(str)) {
            return Color.parseColor(this.mAgentAvatarColorMap.get(str));
        }
        return this.mContext.getResources().getColor(R.color.salesforce_brand_secondary);
    }
}
