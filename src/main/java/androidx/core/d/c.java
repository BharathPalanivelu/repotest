package androidx.core.d;

public class c extends RuntimeException {
    public c() {
        this((String) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(str == null ? "The operation has been canceled." : str);
    }
}
