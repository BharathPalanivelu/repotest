package com.airpay.paysdk.libs.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.Message.Builder;
import e.f;
import java.io.IOException;
import java.lang.reflect.Array;

public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {
    public final int describeContents() {
        return 0;
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        return new ProtoAdapterCreator(protoAdapter);
    }

    protected AndroidMessage(ProtoAdapter<M> protoAdapter, f fVar) {
        super(protoAdapter, fVar);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(encode());
    }

    private static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        ProtoAdapterCreator(ProtoAdapter<M> protoAdapter) {
            this.adapter = protoAdapter;
        }

        public M createFromParcel(Parcel parcel) {
            try {
                return this.adapter.decode(parcel.createByteArray());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        public M[] newArray(int i) {
            return (Object[]) Array.newInstance(this.adapter.javaType, i);
        }
    }
}
