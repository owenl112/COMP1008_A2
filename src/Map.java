import java.util.ArrayList;

public class Map {
    private String name;
    private String pool;
    private String authorUUID;
    private int maxPlayers;
    private boolean rage;
    private boolean blitz;
    private int teams;
    private int timer;

    public Map() {
    }


    public Map(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, int teams, int timer) {
        setName(name);
        setPool(pool);
        setAuthorUUID(authorUUID);
        setMaxPlayers(maxPlayers);
        setRage(rage);
        setBlitz(blitz);
        setTeams(teams);
        setTimer(timer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2){
        this.name = name;
        }
        else throw new IllegalArgumentException("Map name must be longer than 2 characters");
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        pool.toLowerCase();
        String[] pools = {"pico","nano","micro","centi","hecto","mega","giga"};
        int all = 0;
        for (int i = 0; i < pools.length; i++) {
            if (pool == pools[i])
                this.pool = pool;
            else all++;
        }
        if(all == pools.length)
            throw new IllegalArgumentException("Pool must be either pico, nano, micro, centi, hecto, mega or giga");
    }

    public String getAuthorUUID() {
        return authorUUID;
    }

    public void setAuthorUUID(String authorUUID) {
        // seeing if the UUID is correct (8-4-4-12 characters)
        if(authorUUID.charAt(8) == '-' && authorUUID.charAt(13) == '-' && authorUUID.charAt(18) =='-' && authorUUID.charAt(23) == '-' ){
            this.authorUUID = authorUUID;
        }
        else throw new IllegalArgumentException("Must be a valid UUID");
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        if(maxPlayers >=2 && maxPlayers <=2674) { // this is the max for minecraft.. I'm not sure why
            this.maxPlayers = maxPlayers;
        }
        else throw new IllegalArgumentException("Max players must be at least 2 or less than 2674");
    }

    public boolean isRage() {
        return rage;
    }

    public void setRage(boolean rage) {
        this.rage = rage;
    }

    public boolean isBlitz() {
        return blitz;
    }

    public void setBlitz(boolean blitz) {
        this.blitz = blitz;
    }

    public int getTeams() {
        return teams;
    }

    public void setTeams(int teams) {
        if(teams >=0 )
            this.teams = teams;
        else throw new IllegalArgumentException("There must be 0 teams or more");
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        if(timer >= -1) {// -1 for no timer set by default
            this.timer = timer;
        }
        else throw new IllegalArgumentException("Timer must be greater than 0");
    }
}
