package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.bb;
import com.google.android.libraries.places.internal.go;
import com.google.android.libraries.places.internal.ha;
import java.util.List;

public abstract class AddressComponent implements Parcelable {

    public static abstract class Builder {
        public abstract Builder a(String str);

        public abstract Builder a(List<String> list);

        public abstract AddressComponent a();

        public abstract Builder setShortName(String str);

        public AddressComponent build() {
            AddressComponent a2 = a();
            go.b(!a2.getName().isEmpty(), (Object) "Name must not be empty.");
            List<String> types = a2.getTypes();
            go.b(!types.isEmpty(), (Object) "Types must not be empty.");
            for (String isEmpty : types) {
                go.b(!TextUtils.isEmpty(isEmpty), (Object) "Types must not contain null or empty values.");
            }
            a((List<String>) ha.a(types));
            return a();
        }
    }

    public abstract String getName();

    public abstract String getShortName();

    public abstract List<String> getTypes();

    public static Builder builder(String str, List<String> list) {
        return new bb().a(str).a(list);
    }
}
