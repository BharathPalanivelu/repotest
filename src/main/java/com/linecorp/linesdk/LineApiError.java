package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LineApiError implements Parcelable {
    public static final Parcelable.Creator<LineApiError> CREATOR = new Parcelable.Creator<LineApiError>() {
        /* renamed from: a */
        public final LineApiError createFromParcel(Parcel parcel) {
            return new LineApiError(parcel);
        }

        /* renamed from: a */
        public final LineApiError[] newArray(int i) {
            return new LineApiError[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final LineApiError f14985a = new LineApiError(-1, "");

    /* renamed from: b  reason: collision with root package name */
    private final int f14986b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14987c;

    public int describeContents() {
        return 0;
    }

    public LineApiError(Exception exc) {
        this(-1, a(exc));
    }

    public LineApiError(String str) {
        this(-1, str);
    }

    public LineApiError(int i, Exception exc) {
        this(i, a(exc));
    }

    public LineApiError(int i, String str) {
        this.f14986b = i;
        this.f14987c = str;
    }

    private LineApiError(Parcel parcel) {
        this.f14986b = parcel.readInt();
        this.f14987c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f14986b);
        parcel.writeString(this.f14987c);
    }

    private static String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LineApiError lineApiError = (LineApiError) obj;
            if (this.f14986b != lineApiError.f14986b) {
                return false;
            }
            String str = this.f14987c;
            if (str != null) {
                return str.equals(lineApiError.f14987c);
            }
            if (lineApiError.f14987c == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f14986b * 31;
        String str = this.f14987c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "LineApiError{httpResponseCode=" + this.f14986b + ", message='" + this.f14987c + '\'' + '}';
    }
}
