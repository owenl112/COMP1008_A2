import models.DTM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DTMTest {

    DTM test;

    @BeforeEach
    void setUp() {
        test = new DTM("Race For Victory 2","centi","ef4ea031-998f-4ec9-b7b6-1bdd428bcef8",64,false,false,2,-1,2,3,true,false);
    }

    @Test
    void setNumOfMonuments() {
        test.setNumOfMonuments(4);
        assertEquals(4,test.getNumOfMonuments());
        assertThrows(IllegalArgumentException.class, ()-> test.setNumOfMonuments(1));
    }

}