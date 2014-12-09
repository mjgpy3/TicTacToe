package com.example.michael.tictactoe;

/**
 * Created by michael on 12/7/14.
 */
public class BoardCoordinate {
    public int X;
    public int Y;

    public BoardCoordinate(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int hashCode() {
        return X*103 + Y;
    }

    public boolean equals(Object o) {
        return X == ((BoardCoordinate) o).X &&
                Y == ((BoardCoordinate) o).Y;
    }
}
