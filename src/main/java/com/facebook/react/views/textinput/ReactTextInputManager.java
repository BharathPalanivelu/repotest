package com.facebook.react.views.textinput;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.b;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactFontManager;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.yoga.YogaConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.cos.xml.BuildConfig;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.TIMGroupManager;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

@ReactModule(name = "AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final int BLUR_TEXT_INPUT = 2;
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final int KEYBOARD_TYPE_FLAGS = 12339;
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    protected static final String REACT_CLASS = "AndroidTextInput";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    private static final int UNSET = -1;

    public String getName() {
        return REACT_CLASS;
    }

    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        return reactEditText;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topSubmitEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put(ReactTextInputEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).put(ReactTextInputKeyPressEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).build();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("focusTextInput", 1, "blurTextInput", 2);
    }

    public void receiveCommand(ReactEditText reactEditText, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactEditText.requestFocusFromJS();
        } else if (i == 2) {
            reactEditText.clearFocusFromJS();
        }
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            reactEditText.setPadding((int) reactTextUpdate.getPaddingLeft(), (int) reactTextUpdate.getPaddingTop(), (int) reactTextUpdate.getPaddingRight(), (int) reactTextUpdate.getPaddingBottom());
            if (reactTextUpdate.containsImages()) {
                TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.getText(), reactEditText);
            }
            reactEditText.maybeSetText(reactTextUpdate);
            if (reactTextUpdate.getSelectionStart() != -1 && reactTextUpdate.getSelectionEnd() != -1) {
                reactEditText.setSelection(reactTextUpdate.getSelectionStart(), reactTextUpdate.getSelectionEnd());
            }
        }
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f2) {
        reactEditText.setFontSize(f2);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setTypeface(ReactFontManager.getInstance().getTypeface(str, reactEditText.getTypeface() != null ? reactEditText.getTypeface().getStyle() : 0, reactEditText.getContext().getAssets()));
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f2) {
        reactEditText.setMaxFontSizeMultiplier(f2);
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, String str) {
        int i = -1;
        int parseNumericFontWeight = str != null ? parseNumericFontWeight(str) : -1;
        if (parseNumericFontWeight >= 500 || "bold".equals(str)) {
            i = 1;
        } else if (BuildConfig.FLAVOR.equals(str) || (parseNumericFontWeight != -1 && parseNumericFontWeight < 500)) {
            i = 0;
        }
        Typeface typeface = reactEditText.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (i != typeface.getStyle()) {
            reactEditText.setTypeface(typeface, i);
        }
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, String str) {
        int i;
        if ("italic".equals(str)) {
            i = 2;
        } else {
            i = BuildConfig.FLAVOR.equals(str) ? 0 : -1;
        }
        Typeface typeface = reactEditText.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (i != typeface.getStyle()) {
            reactEditText.setTypeface(typeface, i);
        }
    }

    @ReactProp(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, String str) {
        int i;
        if ("no".equals(str)) {
            i = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i = 8;
        } else if ("yes".equals(str)) {
            i = 1;
        } else {
            i = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(reactEditText, i);
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setImportantForAutofill(i);
        }
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setAutofillHints(strArr);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(reactEditText));
        } else {
            reactEditText.setSelectionWatcher((SelectionWatcher) null);
        }
    }

    @ReactProp(name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, Boolean bool) {
        reactEditText.setBlurOnSubmit(bool);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(reactEditText));
        } else {
            reactEditText.setContentSizeWatcher((ContentSizeWatcher) null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(reactEditText));
        } else {
            reactEditText.setScrollWatcher((ScrollWatcher) null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z) {
        reactEditText.setOnKeyPress(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f2) {
        reactEditText.setLetterSpacingPt(f2);
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z) {
        reactEditText.setAllowFontScaling(z);
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
        setCursorColor(reactEditText, num);
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, Integer num) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(reactEditText);
            if (i != 0) {
                Drawable a2 = b.a(reactEditText.getContext(), i);
                if (num != null) {
                    a2.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                }
                Drawable[] drawableArr = {a2, a2};
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(reactEditText);
                Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                declaredField3.setAccessible(true);
                declaredField3.set(obj, drawableArr);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    @ReactProp(defaultInt = 0, name = "mostRecentEventCount")
    public void setMostRecentEventCount(ReactEditText reactEditText, int i) {
        reactEditText.setMostRecentEventCount(i);
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z) {
        reactEditText.setCursorVisible(!z);
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, final boolean z) {
        reactEditText.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return z;
            }
        });
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectAllOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setTextColor(DefaultStyleValuesUtil.getDefaultTextColor(reactEditText.getContext()));
        } else {
            reactEditText.setTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e2) {
                FLog.e(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", (Throwable) e2);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if (ViewProps.LEFT.equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if (ViewProps.RIGHT.equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if (ViewProps.TOP.equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if (ViewProps.BOTTOM.equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
        }
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i) {
        reactEditText.setCompoundDrawablePadding(i);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i) {
        reactEditText.setLines(i);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, Integer num) {
        InputFilter[] filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < filters.length; i++) {
                    if (!(filters[i] instanceof InputFilter.LengthFilter)) {
                        linkedList.add(filters[i]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof InputFilter.LengthFilter) {
                    filters[i2] = new InputFilter.LengthFilter(num.intValue());
                    z = true;
                }
            }
            if (!z) {
                inputFilterArr = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(num.intValue());
            } else {
                inputFilterArr = filters;
            }
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(name = "autoComplete")
    public void setTextContentType(ReactEditText reactEditText, String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
        } else if ("username".equals(str)) {
            setAutofillHints(reactEditText, "username");
        } else if ("password".equals(str)) {
            setAutofillHints(reactEditText, "password");
        } else if ("email".equals(str)) {
            setAutofillHints(reactEditText, "emailAddress");
        } else if ("name".equals(str)) {
            setAutofillHints(reactEditText, "name");
        } else if ("tel".equals(str)) {
            setAutofillHints(reactEditText, "phone");
        } else if ("street-address".equals(str)) {
            setAutofillHints(reactEditText, "postalAddress");
        } else if ("postal-code".equals(str)) {
            setAutofillHints(reactEditText, "postalCode");
        } else if ("cc-number".equals(str)) {
            setAutofillHints(reactEditText, "creditCardNumber");
        } else if ("cc-csc".equals(str)) {
            setAutofillHints(reactEditText, "creditCardSecurityCode");
        } else if ("cc-exp".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationDate");
        } else if ("cc-exp-month".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationMonth");
        } else if ("cc-exp-year".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationYear");
        } else if ("off".equals(str)) {
            setImportantForAutofill(reactEditText, 2);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid autocomplete option: " + str);
        }
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, Boolean bool) {
        updateStagedInputTypeFlag(reactEditText, 557056, bool != null ? bool.booleanValue() ? TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG : 524288 : 0);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 131072;
        if (z) {
            i = 131072;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
        if (z) {
            i = 128;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, int i) {
        updateStagedInputTypeFlag(reactEditText, 28672, i);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, String str) {
        int i;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i = INPUT_TYPE_KEYBOARD_DECIMAL_PAD;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            i = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i = 3;
        } else {
            i = KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str) ? IjkMediaMeta.FF_PROFILE_H264_HIGH_444 : 1;
        }
        updateStagedInputTypeFlag(reactEditText, KEYBOARD_TYPE_FLAGS, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z) {
        reactEditText.setDisableFullscreenUI(z);
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        if (i == 0) {
            reactEditText.setBorderRadius(f2);
        } else {
            reactEditText.setBorderRadius(f2, i - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, String str) {
        reactEditText.setBorderStyle(str);
    }

    @ReactProp(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setShowSoftInputOnFocus(z);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        reactEditText.setBorderWidth(SPACING_TYPES[i], f2);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i, Integer num) {
        float f2 = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f2 = (float) (num.intValue() >>> 24);
        }
        reactEditText.setBorderColor(SPACING_TYPES[i], intValue, f2);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction(reactEditText);
        reactEditText.commitStagedInputType();
    }

    private static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    private static int parseNumericFontWeight(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }

    private static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i, int i2) {
        reactEditText.setStagedInputType(((i ^ -1) & reactEditText.getStagedInputType()) | i2);
    }

    private class ReactTextInputTextWatcher implements TextWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private String mPreviousText = null;

        public void afterTextChanged(Editable editable) {
        }

        public ReactTextInputTextWatcher(ReactContext reactContext, ReactEditText reactEditText) {
            this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
            this.mEditText = reactEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreviousText = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 != 0 || i2 != 0) {
                Assertions.assertNotNull(this.mPreviousText);
                String substring = charSequence.toString().substring(i, i + i3);
                int i4 = i + i2;
                String substring2 = this.mPreviousText.substring(i, i4);
                if (i3 != i2 || !substring.equals(substring2)) {
                    this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mEditText.getId(), charSequence.toString(), this.mEditText.incrementAndGetEventCounter()));
                    this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mEditText.getId(), substring, substring2, i, i4));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
                if (z) {
                    eventDispatcher.dispatchEvent(new ReactTextInputFocusEvent(reactEditText.getId()));
                    return;
                }
                eventDispatcher.dispatchEvent(new ReactTextInputBlurEvent(reactEditText.getId()));
                eventDispatcher.dispatchEvent(new ReactTextInputEndEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) > 0 || i == 0) {
                    boolean blurOnSubmit = reactEditText.getBlurOnSubmit();
                    boolean z = (reactEditText.getInputType() & 131072) != 0;
                    ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactTextInputSubmitEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
                    if (blurOnSubmit) {
                        reactEditText.clearFocus();
                    }
                    if (blurOnSubmit || !z) {
                        return true;
                    }
                    return false;
                } else if (i == 5) {
                    return textView.focusSearch(2) != null && !textView.requestFocus(2);
                } else {
                    return true;
                }
            }
        });
    }

    private class ReactContentSizeWatcher implements ContentSizeWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private int mPreviousContentHeight = 0;
        private int mPreviousContentWidth = 0;

        public ReactContentSizeWatcher(ReactEditText reactEditText) {
            this.mEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onLayout() {
            int width = this.mEditText.getWidth();
            int height = this.mEditText.getHeight();
            if (this.mEditText.getLayout() != null) {
                width = this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
                height = this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
            }
            if (width != this.mPreviousContentWidth || height != this.mPreviousContentHeight) {
                this.mPreviousContentHeight = height;
                this.mPreviousContentWidth = width;
                this.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.mEditText.getId(), PixelUtil.toDIPFromPixel((float) width), PixelUtil.toDIPFromPixel((float) height)));
            }
        }
    }

    private class ReactSelectionWatcher implements SelectionWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousSelectionEnd;
        private int mPreviousSelectionStart;
        private ReactEditText mReactEditText;

        public ReactSelectionWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onSelectionChanged(int i, int i2) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            if (this.mPreviousSelectionStart != min || this.mPreviousSelectionEnd != max) {
                this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), min, max));
                this.mPreviousSelectionStart = min;
                this.mPreviousSelectionEnd = max;
            }
        }
    }

    private class ReactScrollWatcher implements ScrollWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousHoriz;
        private int mPreviousVert;
        private ReactEditText mReactEditText;

        public ReactScrollWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            if (this.mPreviousHoriz != i || this.mPreviousVert != i2) {
                this.mEventDispatcher.dispatchEvent(ScrollEvent.obtain(this.mReactEditText.getId(), ScrollEventType.SCROLL, i, i2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, 0, this.mReactEditText.getWidth(), this.mReactEditText.getHeight()));
                this.mPreviousHoriz = i;
                this.mPreviousVert = i2;
            }
        }
    }

    public Map getExportedViewConstants() {
        return MapBuilder.of("AutoCapitalizationType", MapBuilder.of(ViewProps.NONE, 0, "characters", 4096, "words", 8192, "sentences", Integer.valueOf(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE)));
    }
}
