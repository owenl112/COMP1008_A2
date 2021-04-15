package models;

import java.security.PublicKey;
import java.util.ArrayList;

public class Map {
    private String name; // name of the map
    private String pool; // what pool it can be found in (more players -> bigger maps)
    private String authorUUID; // who made it, use UUID if they change name
    private int maxPlayers; // how many players total
    private boolean rage; // is it rage (one shot kill)
    private boolean blitz; // is it blitz (only live once)
    private int teams; // how many teams
    private int timer; // what is the timer?

    public Map() {
    }


    /**
     * Creates the map
     * @param name
     * @param pool
     * @param authorUUID
     * @param maxPlayers
     * @param rage
     * @param blitz
     * @param teams
     * @param timer
     */
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

    /**
     * sets the name, makes sure it's at least 2 chars long
     * @param name
     */
    public void setName(String name) {
        if(name.length() >= 2){
        this.name = name;
        }
        else throw new IllegalArgumentException("models.Map name must be longer than 2 characters");
    }

    public String getPool() {
        return pool;
    }

    /**
     * makes sure the pool is correct
     * @param pool
     */
    public void setPool(String pool) {
        pool.toLowerCase();
        String[] pools = {"pico","nano","micro","centi","hecto","mega","giga"};
        int all = 0;
        for (int i = 0; i < pools.length; i++) {
            if (pool.equalsIgnoreCase(pools[i]))
                this.pool = pool;
            else all++;
        }
        if(all == pools.length)
            throw new IllegalArgumentException("Pool must be either pico, nano, micro, centi, hecto, mega or giga. you entered: " + pool);
    }

    public String getAuthorUUID() {
        return authorUUID;
    }

    /**
     * Checks the UUID to make sure the author is correct.. might be better to make it an ArrayList of strings if there is multiple
     * @param authorUUID
     */
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
