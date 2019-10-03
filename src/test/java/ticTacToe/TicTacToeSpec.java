package ticTacToe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {
    TicTacToe ticTacToe;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 3);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(3, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerReturnX() {
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXThenNextPlayerReturnO() {
        ticTacToe.play(2, 1);
        Assert.assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasOThenNextPlayerReturnX() {
        ticTacToe.play(2, 1);
        ticTacToe.play(3, 3);
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1, 1);
        Assert.assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 2);
        Assert.assertEquals("X is the winner", ticTacToe.play(3, 1));
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(2, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(3, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        Assert.assertEquals("O is the winner", ticTacToe.play(1, 3));
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 3);
        Assert.assertEquals("X is the winner", ticTacToe.play(3, 3));
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToe.play(3, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 2);
        Assert.assertEquals("X is the winner", ticTacToe.play(1, 3));
    }
}
