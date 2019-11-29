package com.google.android.material.internal;

import android.view.SubMenu;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.r;

public class g extends androidx.appcompat.view.menu.g {
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        i iVar = (i) a(i, i2, i3, charSequence);
        i iVar2 = new i(f(), this, iVar);
        iVar.a((r) iVar2);
        return iVar2;
    }
}
