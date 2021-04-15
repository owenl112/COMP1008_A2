package utilities;

import  models.*;
import java.util.ArrayList;

public class DBUtility {
    public static ArrayList<Object> getMaps(){
        ArrayList<Object> maps = new ArrayList<>();
        maps.add(new CTW("Dynamo","giga","6968cbde-c2b7-479c-a8da-f33f109f013b",16,false,false,2,-1,2));
     //   maps.add(new KOTH());
     //   maps.add(new DM());
    //    maps.add(new DTC());
          maps.add(new DTM("Warlock","mega","e5953ddf-c1fc-4405-9ac9-6939631cd185",40,false,false,2,-1,2,3,true,false));
     return maps;
    }
}
