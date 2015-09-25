package main;

import java.util.HashMap;
import java.util.Map;


public class AccountService {
    private Map<String, UserProfile> users = new HashMap<>();
    private Map<String, UserProfile> sessions = new HashMap<>();

    public boolean addUser(String userName, UserProfile userProfile) {
        if (users.containsKey(userName))
            return false;
        users.put(userName, userProfile);
        return true;
    }

    public void addSessions(String sessionId, UserProfile userProfile) {
        sessions.put(sessionId, userProfile);
    }

    public UserProfile getUser(String userName) {
        return users.get(userName);
    }

    public String isSignedIn(String sessionId) {
        if (sessions.containsKey(sessionId))
            return sessionId;
        else return null;
    }

    public boolean removeSessions(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return true;
        }
        return false;
    }

    public int countSignIn(){
        return sessions.size();
    }

    public int countSignUp(){
        return  users.size();
    }
}

