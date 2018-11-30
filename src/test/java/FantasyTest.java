import fantasy.Fantasy;
import fantasy.player.Player;
import fantasy.player.fighter.Barbarian;
import fantasy.player.fighter.Dwarf;
import fantasy.player.fighter.Fighter;
import fantasy.player.healer.Cleric;
import fantasy.player.healer.Healer;
import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.Spellcaster;
import fantasy.player.spellcaster.Witch;
import fantasy.room.Enemy;
import fantasy.room.Room;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FantasyTest {
    Fantasy fantasy;
    Room room;
    Treasure treasure;
    Player player;
    Fighter fighter;
    Spellcaster spellcaster;
    Creature creature;
    Enemy enemy;
    Healer healer;

    @Before
    public void before(){
        fantasy = new Fantasy();
        treasure = new Treasure("Gem", 150);
        room = new Room(treasure);
        player = new Dwarf(23, 67, "axe");
        fighter = new Barbarian(35, 54, "club");
        creature = new Creature("Cat", 10);
        spellcaster = new Witch(25, 28, "wand", creature);
        enemy = new Enemy ("Orc", 30);
        healer = new Cleric(100, 10, "Potion");
        fantasy.createPlayer(player);
        fantasy.createRoom(room);
        fantasy.createRoom(room);
        fantasy.addPlayersToRoom();
    }

//    @Test
//    public void startsWithNoRooms(){
//        assertEquals(0, fantasy.countRooms());
//    }
//    @Test
//    public void startsWithNoPlayers(){
//        assertEquals(0, fantasy.countPlayers());
//    }
    @Test
    public void canAddPlayers(){
        assertEquals(1, fantasy.countPlayers());
    }
    @Test
    public void canAddRooms(){
        assertEquals(1, fantasy.countRooms());
    }
    @Test
    public void canAddPlayerToRoom(){
        assertEquals(1, room.countPlayers());
    }

    @Test
    public void canCheckForTreasure(){
        assertEquals("You picked up Gem", fantasy.checkRoomForTreasure(room, player));
        assertEquals(1, player.countTreasure());
    }

    @Test
    public void noEnemyInRoom(){
        assertEquals("No enemies in room", fantasy.roomHasEnemy(room, fighter, null));
    }
    @Test
    public void canFightEnemy(){

        fantasy.addEnemyToRoom(enemy);
        assertEquals("Player wins!", fantasy.roomHasEnemy(room, fighter, enemy));
    }

    @Test
    public void canCastSpell(){
        fantasy.addEnemyToRoom(enemy);
        assertEquals("Enemy wins!", fantasy.roomHasEnemy(room, spellcaster, enemy));
    }
    @Test
    public void canHeal(){
        fantasy.addEnemyToRoom(enemy);
        assertEquals("Enemies present, can't heal!", fantasy.roomHasHealer(room, player, healer));
    }

}


