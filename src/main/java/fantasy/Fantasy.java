package fantasy;

import fantasy.player.Player;
import fantasy.player.fighter.Fighter;
import fantasy.player.healer.Healer;
import fantasy.player.spellcaster.Spellcaster;
import fantasy.room.Enemy;
import fantasy.room.Room;
import fantasy.room.Treasure;

import java.util.ArrayList;

public class Fantasy {
    private ArrayList<Player> players;
    private ArrayList<Room> rooms;

    public Fantasy() {
        this.players = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public int countPlayers() {
        return this.players.size();
    }

    public int countRooms() {
        return this.rooms.size();
    }

    public void createPlayer(Player player) {
        this.players.add(player);
    }

    public void createRoom(Room room) {
        this.rooms.add(room);
    }

    public void addPlayersToRoom() {
        Room room = this.rooms.remove(0);
        for (Player player : this.players) {
            room.addPlayer(player);
        }
    }
    public void addEnemyToRoom(Enemy enemy){
        Room room = this.rooms.remove(0);
        room.addEnemy(enemy);
    }

    public String checkRoomForTreasure(Room room, Player player) {
        if (room.getTreasure() != null) {
            Treasure treasure = room.getTreasure();
            player.addTreasure(treasure);
            room.clearPlayers();
            return "You picked up " + treasure.getType();
        }
        return "Sorry, no treasure for you!";
    }

    public String roomHasEnemy(Room room, Fighter fighter, Enemy enemy) {
        if (room.countEnemies() > 0) {
                return fighter.fight(enemy);
            }

        return "No enemies in room";
    }

    public String roomHasEnemy(Room room, Spellcaster spellcaster, Enemy enemy ) {
        if (room.countEnemies() > 0) {
                return spellcaster.castSpell(enemy);
            }
        return "No enemies in room";
    }

    public String roomHasHealer(Room room, Player player, Healer healer) {
        if (room.countEnemies() > 0) {
                return "Enemies present, can't heal!";
            }
            return healer.heal(player);
        }
    }




