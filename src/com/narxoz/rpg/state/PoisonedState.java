package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class PoisonedState implements HeroState{
    private int turns= 3;
    @Override
    public String getName(){
        return "Poisoned";
    }
    @Override
    public int modifyOutgoingDamage(int basePower){
        return (int)(basePower * 0.8);
    }
    @Override
    public int modifyIncomingDamage(int rawDamage){
        return rawDamage;
    }
    @Override
    public void onTurnStart(Hero hero){
        System.out.println("Poison damage");
        hero.takeDamage(5);
    }
    @Override
    public void onTurnEnd(Hero hero){
        turns--;
        if (turns == 0) {
            hero.setState(new NormalState());
        }
    }
    @Override
    public boolean canAct(){
        return true;
    }
}
