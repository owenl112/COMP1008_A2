public class DTM extends Map {
    private int numOfMonuments;
    private int monumentSize;
    private boolean monumentObs;
    private boolean monumentModes;

    public DTM() {

    }

    public DTM(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, int numOfMonuments, int monumentSize, boolean monumentObs, boolean monumentModes) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        this.numOfMonuments = numOfMonuments;
        this.monumentSize = monumentSize;
        this.monumentObs = monumentObs;
        this.monumentModes = monumentModes;
    }

}
