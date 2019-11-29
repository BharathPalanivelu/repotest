package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.io.StreamException;
import java.io.IOException;
import java.io.Writer;

public class QuickWriter {
    private char[] buffer;
    private int pointer;
    private final Writer writer;

    public QuickWriter(Writer writer2) {
        this(writer2, 1024);
    }

    public QuickWriter(Writer writer2, int i) {
        this.writer = writer2;
        this.buffer = new char[i];
    }

    public void write(String str) {
        int length = str.length();
        if (this.pointer + length >= this.buffer.length) {
            flush();
            if (length > this.buffer.length) {
                raw(str.toCharArray());
                return;
            }
        }
        str.getChars(0, length, this.buffer, this.pointer);
        this.pointer += length;
    }

    public void write(char c2) {
        if (this.pointer + 1 >= this.buffer.length) {
            flush();
            if (this.buffer.length == 0) {
                raw(c2);
                return;
            }
        }
        char[] cArr = this.buffer;
        int i = this.pointer;
        this.pointer = i + 1;
        cArr[i] = c2;
    }

    public void write(char[] cArr) {
        int length = cArr.length;
        if (this.pointer + length >= this.buffer.length) {
            flush();
            if (length > this.buffer.length) {
                raw(cArr);
                return;
            }
        }
        System.arraycopy(cArr, 0, this.buffer, this.pointer, length);
        this.pointer += length;
    }

    public void flush() {
        try {
            this.writer.write(this.buffer, 0, this.pointer);
            this.pointer = 0;
            this.writer.flush();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void close() {
        try {
            this.writer.write(this.buffer, 0, this.pointer);
            this.pointer = 0;
            this.writer.close();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    private void raw(char[] cArr) {
        try {
            this.writer.write(cArr);
            this.writer.flush();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    private void raw(char c2) {
        try {
            this.writer.write(c2);
            this.writer.flush();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }
}
