package com.narxoz.rpg.tower;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.FloorResult;
import com.narxoz.rpg.floor.TowerFloor;
import java.util.List;
public class TowerRunner {
    public TowerRunResult run(List<Hero> party, List<TowerFloor> floors){
        int clearedFloors = 0;
        for(TowerFloor floor : floors){

            FloorResult result = floor.explore(party);

            if(!result.isCleared()){
                break;
            }
            clearedFloors++;
        }
        int survivors = 0;
        for(Hero h : party){
            if(h.isAlive()){
                survivors++;
            }
        }
        boolean reachedTop = clearedFloors == floors.size();
        return new TowerRunResult(clearedFloors, survivors, reachedTop);
    }
}
