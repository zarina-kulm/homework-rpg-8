package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.Monster;
import com.narxoz.rpg.state.PoisonedState;
import java.util.List;
public class BattleFloor extends TowerFloor {
    private Monster monster;
    @Override
    protected String getFloorName(){
        return "Battle Floor";
    }
    @Override
    protected void setup(List<Hero> party){
        System.out.println("Monster appears!");
        monster = new Monster("Goblin", 60, 15);
    }
    @Override
    protected FloorResult resolveChallenge(List<Hero> party){
        System.out.println("Fight starts");
        for(Hero h : party){
            if(!h.isAlive()) continue;
            if(!monster.isAlive()) break;

            h.startTurn();

            int dmg = h.attack();
            monster.takeDamage(dmg);

            System.out.println(h.getName() + " hits for " + dmg);

            if(Math.random() < 0.3){
                h.setState(new PoisonedState());
            }
            h.endTurn();
        }
        return new FloorResult(!monster.isAlive(), 0, "Battle finished");
    }
    @Override
    protected void awardLoot(List<Hero> party, FloorResult result){
        System.out.println("You got gold");
    }
}
