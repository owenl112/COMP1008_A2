public class KOTH extends Map {
    private int numOfHills, maxScore;

    public KOTH() {
    }

    public KOTH(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, int numOfHills, int maxScore) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        this.numOfHills = numOfHills;
        this.maxScore = maxScore;
    }

    public int getNumOfHills() {
        return numOfHills;
    }

    public void setNumOfHills(int numOfHills) {
        if(numOfHills >0)
            this.numOfHills = numOfHills;
        else throw new IllegalArgumentException("You need at least 1 hill");
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        if(maxScore >0)
            this.maxScore = maxScore;
        else throw new IllegalArgumentException("The max score must be at least 1");
    }
}
