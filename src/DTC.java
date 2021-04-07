public class DTC extends Map{
    private int numOfCores, leakDown;
    private String coreMaterial;
    private boolean coreModes;

    public DTC() {

    }

    /**
     * Adds the number of cores, what they are made of, how much the inside needs to leak and if it has modes that change it
     * @param name
     * @param pool
     * @param authorUUID
     * @param maxPlayers
     * @param rage
     * @param blitz
     * @param teams
     * @param timer
     * @param numOfCores
     * @param coreMaterial
     * @param leakDown
     * @param coreModes
     */
    public DTC(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, int numOfCores, String coreMaterial, int leakDown, boolean coreModes) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        setNumOfCores(numOfCores);
        setCoreMaterial(coreMaterial);
        setLeakDown(leakDown);
        setCoreModes(coreModes);
    }

    public int getNumOfCores() {
        return numOfCores;
    }

    /**
     * makes sure the number of cores makes sense. same as for capture the wool
     * @param numOfCores
     */
    public void setNumOfCores(int numOfCores) {
        if(numOfCores >1 && numOfCores % this.getTeams() == 0)
            this.numOfCores = numOfCores;
        else throw new IllegalArgumentException("Must be an even amount of cores");
    }

    public String getCoreMaterial() {
        return coreMaterial;
    }

    public void setCoreMaterial(String coreMaterial) {
        // This *should* check if it's a valid block in minecraft but that is a lot to check so I'm just going to pretend it does
        this.coreMaterial = coreMaterial;
    }

    public int getLeakDown() {
        return leakDown;
    }

    public void setLeakDown(int leakDown) {
        if(leakDown >0)
            this.leakDown = leakDown;
        else throw new IllegalArgumentException("leakDown must be at least 1 block");
    }

    public boolean isCoreModes() {
        return coreModes;
    }

    public void setCoreModes(boolean coreModes) {
        this.coreModes = coreModes;
    }

    public int coresPerTeam() {
        if(this.getTeams() != 0)
            return this.getNumOfCores() / this.getTeams();
        else return 0;
    }
}
