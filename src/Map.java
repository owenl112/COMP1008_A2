import java.util.ArrayList;

public class Map {
    private String name;
    private String pool;
    private String authorUUID;
    private int maxPlayers;
    private boolean rage;
    private boolean blitz;
    private boolean team;
    private int timer;

    public Map() {
    }


    public Map(String name, String pool, String authorUUID, int maxPlayers, boolean rage, boolean blitz, boolean team, int timer) {
        this.name = name;
        this.pool = pool;
        this.authorUUID = authorUUID;
        this.maxPlayers = maxPlayers;
        this.rage = rage;
        this.blitz = blitz;
        this.team = team;
        this.timer = timer;
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
        try {
            for (int i = 0; i < pools.length; i++) {
                if (pools[i].compareTo(pool) == 0) {
                    this.pool = pool;
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println("Pool must be either pico, nano, micro, centi, hecto, mega or giga");
        }
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

    public boolean isTeam() {
        return team;
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimeSize(int timer) {
        if(timer >= 0)
            this.timer = timer;
        else throw new IllegalArgumentException("Timer must be greater than 0");
    }
}
