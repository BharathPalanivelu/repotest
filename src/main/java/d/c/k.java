package d.c;

import com.facebook.common.util.UriUtil;
import d.d.b.j;
import java.io.File;

public final class k extends e {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(File file, File file2, String str, int i, g gVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(File file, File file2, String str) {
        super(file, file2, str);
        j.b(file, UriUtil.LOCAL_FILE_SCHEME);
    }
}
