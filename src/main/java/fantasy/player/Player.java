package fantasy.player;

import fantasy.room.Treasure;

import java.util.ArrayList;

public abstract class Player {

    protected Equipment equipment;
    protected int HP;
    protected int strength;
    protected ArrayList<Treasure> treasure;

    public Player(int HP, int strength, Equipment equipment) {
        this.HP = HP;
        this.strength = strength;
        this.equipment = equipment;
        this.treasure = new ArrayList<>();
    }

    public int getHP(){
        return this.HP;
    }

    public int getStrength(){
        return this.strength;
    }

    public Equipment getEquipment(){
        return this.equipment;
    }

    public int countTreasure(){
        return this.treasure.size();
    }

    public void addTreasure(Treasure treasure){ this.treasure.add(treasure);
    }


    public void setHP(int newHP){
        this.HP = newHP;
    }

    public int getAttackPower(){
        return this.getStrength() * equipment.getValue();
    }
}
