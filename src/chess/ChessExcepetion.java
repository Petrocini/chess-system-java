package chess;

import boardgame.BoardException;

import java.io.Serial;

public class ChessExcepetion extends BoardException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ChessExcepetion(String msg) {
        super(msg);
    }
}
