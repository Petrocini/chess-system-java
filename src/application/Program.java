package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessExcepetion;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import javax.swing.text.html.Option;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.isCheckMate()) {
            try {
                UI.clearScrenn();
                UI.printMatch(chessMatch, captured);
                System.out.println("");
                System.out.println("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScrenn();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

            } catch (ChessExcepetion | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScrenn();
        UI.printMatch(chessMatch, captured);
    }

}
