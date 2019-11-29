package com.facebook.react.uimanager;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import androidx.core.g.a;
import androidx.core.g.a.d;
import androidx.core.g.w;
import com.facebook.react.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.HashMap;

public class ReactAccessibilityDelegate extends a {
    public static final HashMap<String, Integer> sActionIdMap = new HashMap<>();
    private static int sCounter = 1056964608;
    private final HashMap<Integer, String> mAccessibilityActionsMap = new HashMap<>();

    static {
        sActionIdMap.put("activate", Integer.valueOf(d.a.f1747e.a()));
        sActionIdMap.put("longpress", Integer.valueOf(d.a.f1748f.a()));
        sActionIdMap.put("increment", Integer.valueOf(d.a.m.a()));
        sActionIdMap.put("decrement", Integer.valueOf(d.a.n.a()));
    }

    public enum AccessibilityRole {
        NONE,
        BUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        TOOLBAR;

        public static String getValue(AccessibilityRole accessibilityRole) {
            switch (accessibilityRole) {
                case BUTTON:
                    return "android.widget.Button";
                case SEARCH:
                    return "android.widget.EditText";
                case IMAGE:
                    return "android.widget.ImageView";
                case IMAGEBUTTON:
                    return "android.widget.ImageButon";
                case KEYBOARDKEY:
                    return "android.inputmethodservice.Keyboard$Key";
                case TEXT:
                    return "android.widget.TextView";
                case ADJUSTABLE:
                    return "android.widget.SeekBar";
                case CHECKBOX:
                    return "android.widget.CheckBox";
                case RADIO:
                    return "android.widget.RadioButton";
                case SPINBUTTON:
                    return "android.widget.SpinButton";
                case SWITCH:
                    return "android.widget.Switch";
                case NONE:
                case LINK:
                case SUMMARY:
                case HEADER:
                case ALERT:
                case COMBOBOX:
                case MENU:
                case MENUBAR:
                case MENUITEM:
                case PROGRESSBAR:
                case RADIOGROUP:
                case SCROLLBAR:
                case TAB:
                case TABLIST:
                case TIMER:
                case TOOLBAR:
                    return "android.view.View";
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: " + accessibilityRole);
            }
        }

        public static AccessibilityRole fromValue(String str) {
            for (AccessibilityRole accessibilityRole : values()) {
                if (accessibilityRole.name().equalsIgnoreCase(str)) {
                    return accessibilityRole;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: " + str);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        AccessibilityRole accessibilityRole = (AccessibilityRole) view.getTag(R.id.accessibility_role);
        if (accessibilityRole != null) {
            setRole(dVar, accessibilityRole, view.getContext());
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R.id.accessibility_states);
        if (readableArray != null) {
            setState(dVar, readableArray, view.getContext());
        }
        ReadableArray readableArray2 = (ReadableArray) view.getTag(R.id.accessibility_actions);
        if (readableArray2 != null) {
            int i = 0;
            while (i < readableArray2.size()) {
                ReadableMap map = readableArray2.getMap(i);
                if (map.hasKey("name")) {
                    int i2 = sCounter;
                    String string = map.hasKey("label") ? map.getString("label") : null;
                    if (sActionIdMap.containsKey(map.getString("name"))) {
                        i2 = sActionIdMap.get(map.getString("name")).intValue();
                    } else {
                        sCounter++;
                    }
                    this.mAccessibilityActionsMap.put(Integer.valueOf(i2), map.getString("name"));
                    dVar.a(new d.a(i2, string));
                    i++;
                } else {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
            }
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (!this.mAccessibilityActionsMap.containsKey(Integer.valueOf(i))) {
            return super.performAccessibilityAction(view, i, bundle);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("actionName", this.mAccessibilityActionsMap.get(Integer.valueOf(i)));
        ((RCTEventEmitter) ((ReactContext) view.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), "performAction", createMap);
        return true;
    }

    public static void setState(d dVar, ReadableArray readableArray, Context context) {
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            char c2 = 65535;
            switch (string.hashCode()) {
                case -1840852242:
                    if (string.equals("unchecked")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 126844466:
                    if (string.equals("hasPopup")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 270940796:
                    if (string.equals("disabled")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 742313895:
                    if (string.equals("checked")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1191572123:
                    if (string.equals("selected")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                dVar.g(true);
            } else if (c2 == 1) {
                dVar.j(false);
            } else if (c2 == 2) {
                dVar.a(true);
                dVar.b(true);
                if (dVar.p().equals("android.widget.Switch")) {
                    dVar.c((CharSequence) context.getString(R.string.state_on_description));
                }
            } else if (c2 == 3) {
                dVar.a(true);
                dVar.b(false);
                if (dVar.p().equals("android.widget.Switch")) {
                    dVar.c((CharSequence) context.getString(R.string.state_off_description));
                }
            } else if (c2 == 4) {
                dVar.m(true);
            }
        }
    }

    public static void setRole(d dVar, AccessibilityRole accessibilityRole, Context context) {
        if (accessibilityRole == null) {
            accessibilityRole = AccessibilityRole.NONE;
        }
        dVar.b((CharSequence) AccessibilityRole.getValue(accessibilityRole));
        if (accessibilityRole.equals(AccessibilityRole.LINK)) {
            dVar.i((CharSequence) context.getString(R.string.link_description));
            if (dVar.r() != null) {
                SpannableString spannableString = new SpannableString(dVar.r());
                spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), 0);
                dVar.e((CharSequence) spannableString);
            }
            if (dVar.q() != null) {
                SpannableString spannableString2 = new SpannableString(dVar.q());
                spannableString2.setSpan(new URLSpan(""), 0, spannableString2.length(), 0);
                dVar.c((CharSequence) spannableString2);
            }
        } else if (accessibilityRole.equals(AccessibilityRole.SEARCH)) {
            dVar.i((CharSequence) context.getString(R.string.search_description));
        } else if (accessibilityRole.equals(AccessibilityRole.IMAGE)) {
            dVar.i((CharSequence) context.getString(R.string.image_description));
        } else if (accessibilityRole.equals(AccessibilityRole.IMAGEBUTTON)) {
            dVar.i((CharSequence) context.getString(R.string.imagebutton_description));
            dVar.h(true);
        } else if (accessibilityRole.equals(AccessibilityRole.SUMMARY)) {
            dVar.i((CharSequence) context.getString(R.string.summary_description));
        } else if (accessibilityRole.equals(AccessibilityRole.HEADER)) {
            dVar.i((CharSequence) context.getString(R.string.header_description));
            dVar.b((Object) d.c.a(0, 1, 0, 1, true));
        } else if (accessibilityRole.equals(AccessibilityRole.ALERT)) {
            dVar.i((CharSequence) context.getString(R.string.alert_description));
        } else if (accessibilityRole.equals(AccessibilityRole.COMBOBOX)) {
            dVar.i((CharSequence) context.getString(R.string.combobox_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENU)) {
            dVar.i((CharSequence) context.getString(R.string.menu_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENUBAR)) {
            dVar.i((CharSequence) context.getString(R.string.menubar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENUITEM)) {
            dVar.i((CharSequence) context.getString(R.string.menuitem_description));
        } else if (accessibilityRole.equals(AccessibilityRole.PROGRESSBAR)) {
            dVar.i((CharSequence) context.getString(R.string.progressbar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.RADIOGROUP)) {
            dVar.i((CharSequence) context.getString(R.string.radiogroup_description));
        } else if (accessibilityRole.equals(AccessibilityRole.SCROLLBAR)) {
            dVar.i((CharSequence) context.getString(R.string.scrollbar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.SPINBUTTON)) {
            dVar.i((CharSequence) context.getString(R.string.spinbutton_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TAB)) {
            dVar.i((CharSequence) context.getString(R.string.rn_tab_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TABLIST)) {
            dVar.i((CharSequence) context.getString(R.string.tablist_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TIMER)) {
            dVar.i((CharSequence) context.getString(R.string.timer_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TOOLBAR)) {
            dVar.i((CharSequence) context.getString(R.string.toolbar_description));
        }
    }

    public static void setDelegate(View view) {
        if (w.c(view)) {
            return;
        }
        if (view.getTag(R.id.accessibility_role) != null || view.getTag(R.id.accessibility_states) != null || view.getTag(R.id.accessibility_actions) != null) {
            w.a(view, (a) new ReactAccessibilityDelegate());
        }
    }
}
