package org.sadovodBase.service;

import java.util.UUID;

public class SessionData {

    private final UUID sessionId;

    public SessionData() {
        this.sessionId = UUID.randomUUID();
        System.out.println("SessionData created: " + sessionId);
    }

    public UUID getSessionId() {
        return sessionId;
    }
}