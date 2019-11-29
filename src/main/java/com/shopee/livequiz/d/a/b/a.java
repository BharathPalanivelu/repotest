package com.shopee.livequiz.d.a.b;

import com.google.a.a.c;
import java.io.Serializable;

public class a implements Serializable {
    @c(a = "answer_id")
    public int answer_id;
    @c(a = "revive")
    public boolean revive;

    public a(int i, boolean z) {
        this.answer_id = i;
        this.revive = z;
    }
}
