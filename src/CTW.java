public class CTW extends Map{
    private int numOfWool;

    public CTW() {
    }

    public CTW(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, int numOfWool) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        setNumOfWool(numOfWool);
    }

    public int getNumOfWool() {
        return numOfWool;
    }

    public void setNumOfWool(int numOfWool) {
        if(numOfWool >1 && numOfWool <= 16 && numOfWool % 2 == 0)
            this.numOfWool = numOfWool;
        else throw new IllegalArgumentException("Must be between 1 and 16 wools");
    }

    public int woolsPerTeam() {
        if(this.getTeams() != 0)
            return this.getNumOfWool() / this.getTeams();
        else return 0;
    }
}
