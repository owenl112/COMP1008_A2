package models;

public class CTW extends Map{
    private int numOfWool; // tracks the number of wools across the whole map

    public CTW() {
    }

    /**
     * Like the map but with the extra wool int
     * @param name
     * @param pool
     * @param authorUUID
     * @param maxPlayers
     * @param rage
     * @param blitz
     * @param teams
     * @param timer
     * @param numOfWool
     */
    public CTW(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, int numOfWool) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        setNumOfWool(numOfWool);
    }

    public int getNumOfWool() {
        return numOfWool;
    }

    /**
     * if the wool can be divided by the number of teams (not uneven) and is greater than 1
     * @param numOfWool
     */
    public void setNumOfWool(int numOfWool) {
        if(numOfWool >1 && numOfWool <= 16 && numOfWool % this.getTeams() == 0)
            this.numOfWool = numOfWool;
        else throw new IllegalArgumentException("Must be between 1 and 16 wools");
    }

    /**
     * calculates the number of wools per team
     * @return
     */
    public int woolsPerTeam() {
        if(this.getTeams() != 0)
            return this.getNumOfWool() / this.getTeams();
        else return 0;
    }
}
