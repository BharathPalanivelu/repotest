package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface DirectMessage extends Serializable, EntitySupport, TwitterResponse {
    Date getCreatedAt();

    long getId();

    User getRecipient();

    long getRecipientId();

    String getRecipientScreenName();

    User getSender();

    long getSenderId();

    String getSenderScreenName();

    String getText();
}
