public class DTM extends Map {
    private int numOfMonuments;
    private int monumentSize;
    private boolean monumentObs;
    private boolean monumentModes;

    public DTM() {

    }

    /**
     * Very similar to the destroy the core but with monument stuff. including size (number of blocks)
     * @param name
     * @param pool
     * @param authorUUID
     * @param maxPlayers
     * @param rage
     * @param blitz
     * @param teams
     * @param timer
     * @param numOfMonuments
     * @param monumentSize
     * @param monumentObs
     * @param monumentModes
     */
    public DTM(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, int numOfMonuments, int monumentSize, boolean monumentObs, boolean monumentModes) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        setNumOfMonuments(numOfMonuments);
        setMonumentSize(monumentSize);
        setMonumentObs(monumentObs);
        setMonumentModes(monumentModes);
    }

    public int getNumOfMonuments() {
        return numOfMonuments;
    }

    public void setNumOfMonuments(int numOfMonuments) {
        if(numOfMonuments > 1 && numOfMonuments % 2 == 0) // at least 2 and even
            this.numOfMonuments = numOfMonuments;
        else throw new IllegalArgumentException("Must be an even number of monuments per team");
    }

    public int getMonumentSize() {
        return monumentSize;
    }

    public void setMonumentSize(int monumentSize) {
        if(monumentSize >0)
            this.monumentSize = monumentSize;
        else throw new IllegalArgumentException("The monument must be at least 1 block in size");
    }

    public boolean isMonumentObs() {
        return monumentObs;
    }

    public void setMonumentObs(boolean monumentObs) {
        this.monumentObs = monumentObs;
    }

    public boolean isMonumentModes() {
        return monumentModes;
    }

    public void setMonumentModes(boolean monumentModes) {
        this.monumentModes = monumentModes;
    }

    public int monPerTeam() {
        if(this.getTeams() != 0)
            return this.getNumOfMonuments() / this.getTeams();
        else return 0;
    }
}
