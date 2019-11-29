package com.shopee.feeds.feedlibrary.editor.text;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;

public class TextEditorDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private TextEditorDialogFragment f28084b;

    public TextEditorDialogFragment_ViewBinding(TextEditorDialogFragment textEditorDialogFragment, View view) {
        this.f28084b = textEditorDialogFragment;
        textEditorDialogFragment.rlWindowView = (RelativeLayout) b.a(view, c.e.rl_edit_window_view, "field 'rlWindowView'", RelativeLayout.class);
        textEditorDialogFragment.rlEditContainer = (RelativeLayout) b.a(view, c.e.rl_edit_container, "field 'rlEditContainer'", RelativeLayout.class);
        textEditorDialogFragment.mHighLightCheck = (CheckBox) b.a(view, c.e.rb_check_high_light, "field 'mHighLightCheck'", CheckBox.class);
        textEditorDialogFragment.mDone = (TextView) b.a(view, c.e.tv_add_done, "field 'mDone'", TextView.class);
        textEditorDialogFragment.mEditText = (AutoSizeEditText) b.a(view, c.e.et_add_text, "field 'mEditText'", AutoSizeEditText.class);
        textEditorDialogFragment.mColorPicker = (ColorPickerContainer) b.a(view, c.e.color_picker, "field 'mColorPicker'", ColorPickerContainer.class);
    }
}
