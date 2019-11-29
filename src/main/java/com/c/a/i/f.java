package com.c.a.i;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class f extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f6253a = RNCartPanelDataEntity.NULL_VALUE;

    public f(InputStream inputStream) {
        super(inputStream);
    }

    public void mark(int i) {
        super.mark(i);
        this.f6253a = i;
    }

    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int a2 = (int) a((long) i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b((long) read);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        this.f6253a = RNCartPanelDataEntity.NULL_VALUE;
    }

    public long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return 0;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }

    public int available() throws IOException {
        int i = this.f6253a;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    private long a(long j) {
        int i = this.f6253a;
        if (i == 0) {
            return -1;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : (long) i;
    }

    private void b(long j) {
        int i = this.f6253a;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.f6253a = (int) (((long) i) - j);
        }
    }
}
