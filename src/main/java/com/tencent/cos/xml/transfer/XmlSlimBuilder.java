package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.model.tag.CompleteMultipartUpload;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class XmlSlimBuilder {
    public static String buildCompleteMultipartUpload(CompleteMultipartUpload completeMultipartUpload) throws IOException, XmlPullParserException {
        if (completeMultipartUpload == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "CompleteMultipartUpload");
        if (completeMultipartUpload.parts != null) {
            for (CompleteMultipartUpload.Part next : completeMultipartUpload.parts) {
                if (next != null) {
                    newSerializer.startTag("", "Part");
                    addElement(newSerializer, "PartNumber", String.valueOf(next.partNumber));
                    addElement(newSerializer, "ETag", next.eTag);
                    newSerializer.endTag("", "Part");
                }
            }
        }
        newSerializer.endTag("", "CompleteMultipartUpload");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    private static void addElement(XmlSerializer xmlSerializer, String str, String str2) throws IOException {
        if (str2 != null) {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        }
    }

    private static String removeXMLHeader(String str) {
        return (str == null || !str.startsWith("<?xml")) ? str : str.substring(str.indexOf("?>") + 2);
    }
}
