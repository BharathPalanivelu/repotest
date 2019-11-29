package d.c;

import com.facebook.common.util.UriUtil;
import d.d.b.j;
import java.io.File;

public final class d extends e {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(File file, File file2, String str) {
        super(file, file2, str);
        j.b(file, UriUtil.LOCAL_FILE_SCHEME);
    }
}
