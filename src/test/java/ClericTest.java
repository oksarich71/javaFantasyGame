import fantasy.player.Equipment;
import fantasy.player.Player;
import fantasy.player.fighter.Dwarf;
import fantasy.player.healer.Cleric;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {
    Cleric cleric;
    Player player;

    @Before
    public void before(){
        cleric = new Cleric(100, 10, Equipment.POTION);
        player = new Dwarf(20, 30, Equipment.AXE);

    }

    @Test
    public void canHeal(){
        cleric.heal(player);
        assertEquals(25, player.getHP());
    }
    @Test
    public void hasHP() {
        assertEquals(100, cleric.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(10, cleric.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals(Equipment.POTION, cleric.getEquipment());
    }
    @Test
    public void canSetHP(){
        cleric.setHP(15);
        assertEquals(Equipment.AXE, cleric.getHP());
    }

}
