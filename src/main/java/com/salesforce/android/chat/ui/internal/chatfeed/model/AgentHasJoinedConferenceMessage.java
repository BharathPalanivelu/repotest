package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.Date;

public final class AgentHasJoinedConferenceMessage {
    private final String agentName;
    private final Date date;

    public static /* synthetic */ AgentHasJoinedConferenceMessage copy$default(AgentHasJoinedConferenceMessage agentHasJoinedConferenceMessage, String str, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentHasJoinedConferenceMessage.agentName;
        }
        if ((i & 2) != 0) {
            date2 = agentHasJoinedConferenceMessage.date;
        }
        return agentHasJoinedConferenceMessage.copy(str, date2);
    }

    public final String component1() {
        return this.agentName;
    }

    public final Date component2() {
        return this.date;
    }

    public final AgentHasJoinedConferenceMessage copy(String str, Date date2) {
        j.b(str, "agentName");
        j.b(date2, "date");
        return new AgentHasJoinedConferenceMessage(str, date2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentHasJoinedConferenceMessage)) {
            return false;
        }
        AgentHasJoinedConferenceMessage agentHasJoinedConferenceMessage = (AgentHasJoinedConferenceMessage) obj;
        return j.a((Object) this.agentName, (Object) agentHasJoinedConferenceMessage.agentName) && j.a((Object) this.date, (Object) agentHasJoinedConferenceMessage.date);
    }

    public int hashCode() {
        String str = this.agentName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date2 = this.date;
        if (date2 != null) {
            i = date2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AgentHasJoinedConferenceMessage(agentName=" + this.agentName + ", date=" + this.date + SQLBuilder.PARENTHESES_RIGHT;
    }

    public AgentHasJoinedConferenceMessage(String str, Date date2) {
        j.b(str, "agentName");
        j.b(date2, "date");
        this.agentName = str;
        this.date = date2;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final Date getDate() {
        return this.date;
    }
}
