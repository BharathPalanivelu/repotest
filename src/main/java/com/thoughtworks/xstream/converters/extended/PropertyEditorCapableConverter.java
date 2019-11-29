package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.core.util.ThreadSafePropertyEditor;

public class PropertyEditorCapableConverter implements SingleValueConverter {
    private final ThreadSafePropertyEditor editor;
    private final Class type;

    public PropertyEditorCapableConverter(Class cls, Class cls2) {
        this.type = cls2;
        this.editor = new ThreadSafePropertyEditor(cls, 2, 5);
    }

    public boolean canConvert(Class cls) {
        return this.type == cls;
    }

    public Object fromString(String str) {
        return this.editor.setAsText(str);
    }

    public String toString(Object obj) {
        return this.editor.getAsText(obj);
    }
}
