package d.e;

class g extends f {
    public static final int c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final a a(int i, int i2) {
        return a.f32673a.a(i, i2, -1);
    }

    public static final c b(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return c.f32681b.a();
        }
        return new c(i, i2 - 1);
    }

    public static final int a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }
}
