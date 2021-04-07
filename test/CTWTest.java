import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTWTest {
    CTW test;
    @BeforeEach
    void setUp() {
        test = new CTW("Race For Victory 2","centi","ef4ea031-998f-4ec9-b7b6-1bdd428bcef8",64,false,false,2,-1,4);
    }

    @Test
    void setNumOfWools() {
       assertThrows(IllegalArgumentException.class , ()-> test.setNumOfWool(1));
    }

    @Test
    void woolPerTeam(){
        assertEquals(2,test.woolsPerTeam());
    }
}