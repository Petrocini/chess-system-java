package chess;

import java.io.Serial;

public class ChessExcepetion extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ChessExcepetion(String msg) {
        super(msg);
    }
}
