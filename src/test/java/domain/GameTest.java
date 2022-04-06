package domain;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Game;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    List<Player> players = new ArrayList<>();

    Player first = new Player(1, "Alex", 24);
    Player second = new Player(2, "Denis", 17);
    Player third = new Player(3, "Vasily", 14);
    Player fourth = new Player(4, "Joel", 28);
    Player fiveth = new Player(5, "Leo", 24);

    @Test
    void shouldAddPlayers() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fiveth);

        Player[] expected = new Player[]{first, second, third, fourth, fiveth};
        Player[] actual = game.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldTestRoundWinFirst() throws NotRegisteredException {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fiveth);


        assertEquals(1, game.round("Alex", "Denis"));

    }

    @Test
    void shouldTestRoundWinSecond() throws NotRegisteredException {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fiveth);

        assertEquals(2, game.round("Vasily", "Denis"));

    }

    @Test
    void shouldTestRoundTieGame() throws NotRegisteredException {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fiveth);

        assertEquals(0, game.round("Leo", "Alex"));

    }

    @Test
    void shouldTestRoundNotRegisteredFirst() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fiveth);

        assertThrows(NotRegisteredException.class, () -> game.round("Dima", "Alex"));

    }

    @Test
    void shouldTestRoundNotRegisteredSecond() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fiveth);

        assertThrows(NotRegisteredException.class, () -> game.round("Joel", "Dima"));

    }


    @Test
    void shouldSaveAllPlayers() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.saveAll(players);

        assertEquals(4, game.findAll().length);

    }
}