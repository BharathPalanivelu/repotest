package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;

public final class Constant extends Message {
    private static final long serialVersionUID = 0;

    public int hashCode() {
        return 0;
    }

    public Constant() {
    }

    private Constant(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof Constant;
    }

    public static final class Builder extends Message.Builder<Constant> {
        public Builder() {
        }

        public Builder(Constant constant) {
            super(constant);
        }

        public Constant build() {
            return new Constant(this);
        }
    }

    public enum ContentType implements ProtoEnum {
        SMS(0),
        CONTACT(1),
        PHONE(2),
        LOCATION(3),
        DEVICEHF(4),
        DEVICELF(5),
        DEVICEMF(6),
        INSTALLAPP(7);
        
        private final int value;

        private ContentType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ContentStatus implements ProtoEnum {
        DELETE(0),
        NORMAL(1),
        PUSHED(2);
        
        private final int value;

        private ContentStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum PlatformType implements ProtoEnum {
        NONE(0),
        ANDROID(1),
        IOS(2);
        
        private final int value;

        private PlatformType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum FlowType implements ProtoEnum {
        SEND(0),
        RECEIVE(1);
        
        private final int value;

        private FlowType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ErrorCode implements ProtoEnum {
        ERROR_INVALID_TYPE(200000),
        ERROR_DATABASE(200001),
        ERROR_RSA(200002),
        ERROR_AES(200003),
        ERROR_PROTO(200004),
        ERROR_REPEAT_REPORT(200005);
        
        private final int value;

        private ErrorCode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
