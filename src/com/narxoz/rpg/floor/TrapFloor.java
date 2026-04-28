package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.state.StunnedState;
import java.util.List;
public class TrapFloor extends TowerFloor {
    @Override
    protected String getFloorName(){
        return "Trap Floor";
    }
    @Override
    protected void setup(List<Hero> party){
        System.out.println("Traps are activated!");
    }
    @Override
    protected FloorResult resolveChallenge(List<Hero> party){
        for(Hero h : party){
            if(!h.isAlive()) continue;
            if(Math.random() < 0.5){
                System.out.println(h.getName() + " triggered a trap!");
                h.takeDamage(10);
                if (Math.random() < 0.5) {
                    h.setState(new StunnedState());
                }
            }
        }
        return new FloorResult(true, 10, "Trap triggered");
    }
    @Override
    protected void awardLoot(List<Hero> party, FloorResult result){
        System.out.println("Nothing useful found...");
    }
}
