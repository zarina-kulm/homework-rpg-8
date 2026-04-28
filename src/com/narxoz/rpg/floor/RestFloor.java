package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class RestFloor extends TowerFloor {
    @Override
    protected String getFloorName(){
        return "Rest Floor";
    }
    @Override
    protected void setup(List<Hero> party){
        System.out.println("The party takes a rest...");
    }
    @Override
    protected FloorResult resolveChallenge(List<Hero> party){
        for(Hero h : party){
            if(!h.isAlive()) continue;
            h.heal(20);
            System.out.println(h.getName() + " healed");
        }
        return new FloorResult(true, 0, "Rested");
    }
    @Override
    protected boolean shouldAwardLoot(FloorResult result){
        return false;
    }
    @Override
    protected void awardLoot(List<Hero> party, FloorResult result){
    }
    @Override
    protected void cleanup(List<Hero> party){
        System.out.println("Party feels refreshed");
    }
}
