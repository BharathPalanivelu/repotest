package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;

public interface ListsResources {
    UserList createUserList(String str, boolean z, String str2) throws TwitterException;

    UserList createUserListMember(long j, long j2) throws TwitterException;

    UserList createUserListMember(long j, String str, long j2) throws TwitterException;

    UserList createUserListMember(String str, String str2, long j) throws TwitterException;

    UserList createUserListMembers(long j, String str, long... jArr) throws TwitterException;

    UserList createUserListMembers(long j, String str, String... strArr) throws TwitterException;

    UserList createUserListMembers(long j, long... jArr) throws TwitterException;

    UserList createUserListMembers(long j, String... strArr) throws TwitterException;

    UserList createUserListMembers(String str, String str2, long... jArr) throws TwitterException;

    UserList createUserListMembers(String str, String str2, String... strArr) throws TwitterException;

    UserList createUserListSubscription(long j) throws TwitterException;

    UserList createUserListSubscription(long j, String str) throws TwitterException;

    UserList createUserListSubscription(String str, String str2) throws TwitterException;

    UserList destroyUserList(long j) throws TwitterException;

    UserList destroyUserList(long j, String str) throws TwitterException;

    UserList destroyUserList(String str, String str2) throws TwitterException;

    UserList destroyUserListMember(long j, long j2) throws TwitterException;

    UserList destroyUserListMember(long j, String str) throws TwitterException;

    UserList destroyUserListMember(long j, String str, long j2) throws TwitterException;

    UserList destroyUserListMember(String str, String str2, long j) throws TwitterException;

    UserList destroyUserListMembers(long j, long[] jArr) throws TwitterException;

    UserList destroyUserListMembers(long j, String[] strArr) throws TwitterException;

    UserList destroyUserListMembers(String str, String str2, String[] strArr) throws TwitterException;

    UserList destroyUserListSubscription(long j) throws TwitterException;

    UserList destroyUserListSubscription(long j, String str) throws TwitterException;

    UserList destroyUserListSubscription(String str, String str2) throws TwitterException;

    PagableResponseList<User> getUserListMembers(long j, int i, long j2) throws TwitterException;

    PagableResponseList<User> getUserListMembers(long j, int i, long j2, boolean z) throws TwitterException;

    PagableResponseList<User> getUserListMembers(long j, long j2) throws TwitterException;

    PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2) throws TwitterException;

    PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2, boolean z) throws TwitterException;

    PagableResponseList<User> getUserListMembers(long j, String str, long j2) throws TwitterException;

    PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j) throws TwitterException;

    PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j, boolean z) throws TwitterException;

    PagableResponseList<User> getUserListMembers(String str, String str2, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(int i, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(long j) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2, boolean z) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(long j, long j2) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(long j, long j2, boolean z) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(String str, int i, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(String str, int i, long j, boolean z) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(String str, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListMemberships(String str, long j, boolean z) throws TwitterException;

    ResponseList<Status> getUserListStatuses(long j, String str, Paging paging) throws TwitterException;

    ResponseList<Status> getUserListStatuses(long j, Paging paging) throws TwitterException;

    ResponseList<Status> getUserListStatuses(String str, String str2, Paging paging) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(long j, int i, long j2) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(long j, int i, long j2, boolean z) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(long j, long j2) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2, boolean z) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(long j, String str, long j2) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j, boolean z) throws TwitterException;

    PagableResponseList<User> getUserListSubscribers(String str, String str2, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListSubscriptions(long j, int i, long j2) throws TwitterException;

    PagableResponseList<UserList> getUserListSubscriptions(long j, long j2) throws TwitterException;

    PagableResponseList<UserList> getUserListSubscriptions(String str, int i, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListSubscriptions(String str, long j) throws TwitterException;

    ResponseList<UserList> getUserLists(long j) throws TwitterException;

    ResponseList<UserList> getUserLists(long j, boolean z) throws TwitterException;

    ResponseList<UserList> getUserLists(String str) throws TwitterException;

    ResponseList<UserList> getUserLists(String str, boolean z) throws TwitterException;

    PagableResponseList<UserList> getUserListsOwnerships(long j, int i, long j2) throws TwitterException;

    PagableResponseList<UserList> getUserListsOwnerships(long j, long j2) throws TwitterException;

    PagableResponseList<UserList> getUserListsOwnerships(String str, int i, long j) throws TwitterException;

    PagableResponseList<UserList> getUserListsOwnerships(String str, long j) throws TwitterException;

    UserList showUserList(long j) throws TwitterException;

    UserList showUserList(long j, String str) throws TwitterException;

    UserList showUserList(String str, String str2) throws TwitterException;

    User showUserListMembership(long j, long j2) throws TwitterException;

    User showUserListMembership(long j, String str, long j2) throws TwitterException;

    User showUserListMembership(String str, String str2, long j) throws TwitterException;

    User showUserListSubscription(long j, long j2) throws TwitterException;

    User showUserListSubscription(long j, String str, long j2) throws TwitterException;

    User showUserListSubscription(String str, String str2, long j) throws TwitterException;

    UserList updateUserList(long j, String str, String str2, boolean z, String str3) throws TwitterException;

    UserList updateUserList(long j, String str, boolean z, String str2) throws TwitterException;

    UserList updateUserList(String str, String str2, String str3, boolean z, String str4) throws TwitterException;
}
