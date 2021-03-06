package com.linsirui.demo.tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWhenNextPlayerThenO() {
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayTwiceThenDifferentPlayer() {
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
        ticTacToe.play(1, 2);
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayNoWinners() {
        String actual = ticTacToe.play(1, 1);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1);
        ticTacToe.snapshot();
        assertEquals("X is the winner", actual);
    }

//    @Test
//    public void whenPlayAndWholeVerticalLineThenWinner() {
//        ticTacToe.play(2, 1); // X
//        ticTacToe.play(1, 1); // O
//        ticTacToe.play(3, 1); // X
//        ticTacToe.play(1, 2); // O
//        ticTacToe.play(2, 2); // X
//        String actual = ticTacToe.play(1, 3); // O
//        ticTacToe.snapshot();
//        assertEquals("O is the winner", actual);
//    }



}