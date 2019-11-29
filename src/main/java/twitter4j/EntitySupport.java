package twitter4j;

public interface EntitySupport {
    HashtagEntity[] getHashtagEntities();

    MediaEntity[] getMediaEntities();

    SymbolEntity[] getSymbolEntities();

    URLEntity[] getURLEntities();

    UserMentionEntity[] getUserMentionEntities();
}
