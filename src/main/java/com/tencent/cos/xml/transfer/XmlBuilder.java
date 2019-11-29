package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.model.tag.Delete;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.model.tag.RestoreConfigure;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class XmlBuilder extends XmlSlimBuilder {
    public static String buildCORSConfigurationXML(CORSConfiguration cORSConfiguration) throws XmlPullParserException, IOException {
        if (cORSConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "CORSConfiguration");
        if (cORSConfiguration.corsRules != null) {
            for (CORSConfiguration.CORSRule next : cORSConfiguration.corsRules) {
                if (next != null) {
                    newSerializer.startTag("", "CORSRule");
                    addElement(newSerializer, "ID", next.id);
                    addElement(newSerializer, "AllowedOrigin", next.allowedOrigin);
                    if (next.allowedMethod != null) {
                        for (String addElement : next.allowedMethod) {
                            addElement(newSerializer, "AllowedMethod", addElement);
                        }
                    }
                    if (next.allowedHeader != null) {
                        for (String addElement2 : next.allowedHeader) {
                            addElement(newSerializer, "AllowedHeader", addElement2);
                        }
                    }
                    if (next.exposeHeader != null) {
                        for (String addElement3 : next.exposeHeader) {
                            addElement(newSerializer, "ExposeHeader", addElement3);
                        }
                    }
                    addElement(newSerializer, "MaxAgeSeconds", String.valueOf(next.maxAgeSeconds));
                    newSerializer.endTag("", "CORSRule");
                }
            }
        }
        newSerializer.endTag("", "CORSConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildLifecycleConfigurationXML(LifecycleConfiguration lifecycleConfiguration) throws XmlPullParserException, IOException {
        if (lifecycleConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "LifecycleConfiguration");
        if (lifecycleConfiguration.rules != null) {
            for (LifecycleConfiguration.Rule next : lifecycleConfiguration.rules) {
                if (next != null) {
                    newSerializer.startTag("", "Rule");
                    addElement(newSerializer, "ID", next.id);
                    if (next.filter != null) {
                        newSerializer.startTag("", "Filter");
                        addElement(newSerializer, "Prefix", next.filter.prefix);
                        newSerializer.endTag("", "Filter");
                    }
                    addElement(newSerializer, "Status", next.status);
                    if (next.transition != null) {
                        newSerializer.startTag("", "Transition");
                        addElement(newSerializer, "Days", String.valueOf(next.transition.days));
                        addElement(newSerializer, "StorageClass", next.transition.storageClass);
                        addElement(newSerializer, HttpConstants.Header.DATE, next.transition.date);
                        newSerializer.endTag("", "Transition");
                    }
                    if (next.expiration != null) {
                        newSerializer.startTag("", "Expiration");
                        addElement(newSerializer, "Days", String.valueOf(next.expiration.days));
                        addElement(newSerializer, "ExpiredObjectDeleteMarker", next.expiration.expiredObjectDeleteMarker);
                        addElement(newSerializer, HttpConstants.Header.DATE, next.expiration.date);
                        newSerializer.endTag("", "Expiration");
                    }
                    if (next.noncurrentVersionTransition != null) {
                        newSerializer.startTag("", "NoncurrentVersionTransition");
                        addElement(newSerializer, "NoncurrentDays", String.valueOf(next.noncurrentVersionTransition.noncurrentDays));
                        addElement(newSerializer, "StorageClass", next.noncurrentVersionTransition.storageClass);
                        newSerializer.endTag("", "NoncurrentVersionTransition");
                    }
                    if (next.noncurrentVersionExpiration != null) {
                        newSerializer.startTag("", "NoncurrentVersionExpiration");
                        addElement(newSerializer, "NoncurrentDays", String.valueOf(next.noncurrentVersionExpiration.noncurrentDays));
                        newSerializer.endTag("", "NoncurrentVersionExpiration");
                    }
                    if (next.abortIncompleteMultiUpload != null) {
                        newSerializer.startTag("", "AbortIncompleteMultipartUpload");
                        addElement(newSerializer, "DaysAfterInitiation", String.valueOf(next.abortIncompleteMultiUpload.daysAfterInitiation));
                        newSerializer.endTag("", "AbortIncompleteMultipartUpload");
                    }
                    newSerializer.endTag("", "Rule");
                }
            }
        }
        newSerializer.endTag("", "LifecycleConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildReplicationConfiguration(ReplicationConfiguration replicationConfiguration) throws XmlPullParserException, IOException {
        if (replicationConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "ReplicationConfiguration");
        addElement(newSerializer, "Role", replicationConfiguration.role);
        if (replicationConfiguration.rules != null) {
            for (ReplicationConfiguration.Rule next : replicationConfiguration.rules) {
                if (next != null) {
                    newSerializer.startTag("", "Rule");
                    addElement(newSerializer, "Status", next.status);
                    addElement(newSerializer, "ID", next.id);
                    addElement(newSerializer, "Prefix", next.prefix);
                    if (next.destination != null) {
                        newSerializer.startTag("", "Destination");
                        addElement(newSerializer, "Bucket", next.destination.bucket);
                        addElement(newSerializer, "StorageClass", next.destination.storageClass);
                        newSerializer.endTag("", "Destination");
                    }
                    newSerializer.endTag("", "Rule");
                }
            }
        }
        newSerializer.endTag("", "ReplicationConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildVersioningConfiguration(VersioningConfiguration versioningConfiguration) throws XmlPullParserException, IOException {
        if (versioningConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "VersioningConfiguration");
        addElement(newSerializer, "Status", versioningConfiguration.status);
        newSerializer.endTag("", "VersioningConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildDelete(Delete delete) throws XmlPullParserException, IOException {
        if (delete == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "Delete");
        addElement(newSerializer, "Quiet", String.valueOf(delete.quiet));
        if (delete.deleteObjects != null) {
            for (Delete.DeleteObject next : delete.deleteObjects) {
                if (next != null) {
                    newSerializer.startTag("", "Object");
                    addElement(newSerializer, "Key", next.key);
                    addElement(newSerializer, "VersionId", next.versionId);
                    newSerializer.endTag("", "Object");
                }
            }
        }
        newSerializer.endTag("", "Delete");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildRestore(RestoreConfigure restoreConfigure) throws XmlPullParserException, IOException {
        if (restoreConfigure == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", (Boolean) null);
        newSerializer.startTag("", "RestoreRequest");
        addElement(newSerializer, "Days", String.valueOf(restoreConfigure.days));
        if (restoreConfigure.casJobParameters != null) {
            newSerializer.startTag("", "CASJobParameters");
            addElement(newSerializer, "Tier", restoreConfigure.casJobParameters.tier);
            newSerializer.endTag("", "CASJobParameters");
        }
        newSerializer.endTag("", "RestoreRequest");
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
