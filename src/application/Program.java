package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessExcepetion;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import javax.swing.text.html.Option;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScrenn();
                UI.printMatch(chessMatch);
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

            } catch (ChessExcepetion | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }

}
