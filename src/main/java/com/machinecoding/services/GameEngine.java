package com.machinecoding.services;

import com.machinecoding.factory.BattleFieldFactory;
import com.machinecoding.factory.PlayerFactory;
import com.machinecoding.factory.ServiceFactory;
import com.machinecoding.models.IBattleField;
import com.machinecoding.models.Player;
import com.machinecoding.models.Ship;

public class GameEngine {

    private IBattleField battlefield;
    private Player playerA;
    private Player playerB;
    private IMissileService missileService;

    public void initGame(int N) {
        this.battlefield = BattleFieldFactory.createBattleField(N);
        this.playerA = PlayerFactory.createPlayer("PlayerA");
        this.playerB = PlayerFactory.createPlayer("PlayerB");
        this.missileService = ServiceFactory.createMissileService();
        System.out.println("BattleField of size " + N + "x" + N + " initialized.");
    }

    /**
     * Adds the same ship (same id & size) for PlayerA and PlayerB
     * but at different coordinates (Ax, Ay) vs. (Bx, By).
     */
    public void addShip(String id, int size, int Ax, int Ay, int Bx, int By) {
        // Validate and place for PlayerA
        if (!battlefield.canPlaceShip(playerA, Ax, Ay, size)) {
            throw new IllegalArgumentException("Cannot place ship for PlayerA at (" + Ax + "," + Ay + ").");
        }
        Ship shipA = new Ship(id, size, Ax, Ay);
        playerA.addShip(shipA);

        // Validate and place for PlayerB
        // check with playerA's ships to ensure no overlap
        if (!battlefield.canPlaceShip(playerB, Bx, By, size) && !battlefield.canPlaceShip(playerA, Bx, By, size)) {
            throw new IllegalArgumentException("Cannot place ship for PlayerB at (" + Bx + "," + By + ").");
        }
        Ship shipB = new Ship(id, size, Bx, By);
        playerB.addShip(shipB);

        System.out.println("Ship " + id + " added for PlayerA at (" + Ax + "," + Ay + "), and for PlayerB at ("
                + Bx + "," + By + ")");
    }

    public void startGame() {
        System.out.println("Starting the turn-based missile game...");

        Player current = playerA;
        Player opponent = playerB;
        int size = battlefield.getSize();

        // Keep firing until one player has no ships left
        while (playerA.hasShipsRemaining() && playerB.hasShipsRemaining()) {
            missileService.fireMissile(current, opponent, size);

            // Switch turns
            Player temp = current;
            current = opponent;
            opponent = temp;
        }

        // Determine winner
        if (!playerA.hasShipsRemaining() && !playerB.hasShipsRemaining()) {
            System.out.println("It's a draw! Both fleets destroyed simultaneously?!");
        } else if (!playerA.hasShipsRemaining()) {
            System.out.println("PlayerB wins the game!");
        } else if (!playerB.hasShipsRemaining()) {
            System.out.println("PlayerA wins the game!");
        }
    }
}
