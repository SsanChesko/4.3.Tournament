package ru.netology.domain;

import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {

    private final List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);

    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

//    public void checkRegister(String name) throws NotRegisteredException {
//        if (findByName(name) == null) {
//            throw new NotRegisteredException("Игрок не зарегистрирован");
//        }
//    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }

        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");
        }
//        checkRegister(playerName1);
//        checkRegister(playerName2);


        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player[] findAll() {
        return players.toArray(new Player[0]);
    }

    public void saveAll(Collection<Player> players) {
        this.players.addAll(players);
    }
}
