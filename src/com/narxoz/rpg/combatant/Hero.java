package com.narxoz.rpg.combatant;
import com.narxoz.rpg.state.HeroState;
public class Hero {
    private final String name;
    private int hp;
    private final int maxHp;
    private final int attackPower;
    private final int defense;
    private HeroState state;

    public Hero(String name, int hp, int attackPower, int defense,  HeroState state) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.defense = defense;
        this.state = state;
    }

    public String getName()        { return name; }
    public int getHp()             { return hp; }
    public int getMaxHp()          { return maxHp; }
    public int getAttackPower()    { return attackPower; }
    public int getDefense()        { return defense; }
    public boolean isAlive()       { return hp > 0; }

    public int attack() {
        if (!state.canAct()) {
            System.out.println(name + " cannot act (" + state.getName() + ")");
            return 0;
        }
        return state.modifyOutgoingDamage(attackPower);
    }
    public void takeDamage(int amount) {
        amount = state.modifyIncomingDamage(amount);
        hp = Math.max(0, hp - amount);
    }
    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }
    public void startTurn() {
        state.onTurnStart(this);
    }
    public void endTurn() {
        state.onTurnEnd(this);
    }
    public void setState(HeroState newState) {
        System.out.println(name + " -> " + newState.getName());
        this.state = newState;
    }
}
