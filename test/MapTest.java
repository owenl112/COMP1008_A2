import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map test1;
    Map test2;
    @BeforeEach
    void setUp() {
         test1 = new Map("Airship Battle", "mega","30e27366-0b14-4076-8f55-0819ece49ce3",100,false,false,true,-1);
         test2 = new Map("Chinatown","micro","a37e4da3-1c6c-4dc9-b085-63783406a963",20,true,true,true,-1);

    }

    @Test
    void setName() {
        assertThrows(IllegalArgumentException.class, ()-> test1.setName("o"));
    }

    @Test
    void setPool() {
        test1.setPool("giga");
        assertEquals("giga", test1.getPool());
        assertThrows(IllegalArgumentException.class, ()-> test2.setPool("ahh"));

    }

    @Test
    void setAuthorUUID() {
        test1.setAuthorUUID("d943b497-0b4b-4eb6-a5e1-3ba0b3fd57a0");
        assertEquals("d943b497-0b4b-4eb6-a5e1-3ba0b3fd57a0", test1.getAuthorUUID());
        assertThrows(IllegalArgumentException.class,()-> test2.setAuthorUUID("this isn't right"));
    }

    @Test
    void setMaxPlayers() {
        assertThrows(IllegalArgumentException.class,()-> test1.setMaxPlayers(1));
        assertThrows(IllegalArgumentException.class,()-> test2.setMaxPlayers(3000));
    }

    @Test
    void setTimer() {
        test1.setTimer(500);
        assertEquals(500,test1.getTimer());
        assertThrows(IllegalArgumentException.class,()-> test2.setTimer(-2));
    }
}