public class Session {
    public boolean inSession;
    private int userID;

    public boolean getSession() {
        return inSession;
    }

    public void startSession() {
        this.inSession = true;
    }

    public void endSession() {
        this.inSession = false;
    }

    public int getUserInSession(){
        return userID;
    }
}
