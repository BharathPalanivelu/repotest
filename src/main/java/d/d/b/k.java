package d.d.b;

import java.io.Serializable;

public abstract class k<R> implements i<R>, Serializable {
    private final int arity;

    public k(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a2 = p.a(this);
        j.a((Object) a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
