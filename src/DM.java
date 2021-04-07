public class DM extends Map {
    private boolean free4All, randomSpawns; // whether it is a free for all and if spawns are random

    public DM() {

    }

    /**
     * Same as the Map but with two booleans for if there are teams or not and if the spawns are random or fixed
     * @param name
     * @param pool
     * @param authorUUID
     * @param maxPlayers
     * @param rage
     * @param blitz
     * @param teams
     * @param timer
     * @param free4All
     * @param randomSpawns
     */
    public DM(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer, boolean free4All, boolean randomSpawns) {
        super(name, pool, authorUUID, maxPlayers, rage, blitz, teams, timer);
        setFree4All(free4All);
        setRandomSpawns(randomSpawns);
    }

    public boolean isFree4All() {
        return free4All;
    }

    public void setFree4All(boolean free4All) {
        this.free4All = free4All;
    }

    public boolean isRandomSpawns() {
        return randomSpawns;
    }

    public void setRandomSpawns(boolean randomSpawns) {
        this.randomSpawns = randomSpawns;
    }
}
