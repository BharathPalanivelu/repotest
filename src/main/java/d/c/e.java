package d.c;

import com.facebook.common.util.UriUtil;
import d.d.b.j;
import java.io.File;
import java.io.IOException;

public class e extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(File file2, File file3, String str) {
        super(c.b(file2, file3, str));
        j.b(file2, UriUtil.LOCAL_FILE_SCHEME);
        this.file = file2;
        this.other = file3;
        this.reason = str;
    }
}
