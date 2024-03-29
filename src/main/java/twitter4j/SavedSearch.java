package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface SavedSearch extends Serializable, Comparable<SavedSearch>, TwitterResponse {
    Date getCreatedAt();

    long getId();

    String getName();

    int getPosition();

    String getQuery();
}
