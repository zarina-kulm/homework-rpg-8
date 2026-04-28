package com.narxoz.rpg;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.state.*;
import com.narxoz.rpg.tower.*;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("Knight", 100, 30, 20, new NormalState());
        Hero h2 = new Hero("Mage", 80, 40, 10, new BerserkState());
        Hero h3 = new Hero("Rogue", 90, 35, 15, new NormalState());

        List<Hero> party = Arrays.asList(h1, h2, h3);
        List<TowerFloor> floors = Arrays.asList(
                new BattleFloor(),
                new TrapFloor(),
                new RestFloor(),
                new BattleFloor());

        TowerRunner runner = new TowerRunner();
        TowerRunResult result = runner.run(party, floors);

        System.out.println("\n=== FINAL RESULT ===");
        System.out.println("Floors cleared: " + result.getFloorsCleared());
        System.out.println("Heroes surviving: " + result.getHeroesSurviving());
        System.out.println("Reached top: " + result.isReachedTop());
    }
}
