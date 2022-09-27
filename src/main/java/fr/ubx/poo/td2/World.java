package fr.ubx.poo.td2;

public class World {
    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;
    public static int width = 20;
    public static int height = 20;

    public World(int width, int height, int percentageRock, int percentageDust) {
        this.width = width;
        this.height = height;
    }

    public int get(Position position) {

        return 0; //para que no me de error de momento
    }
    public void set(Position position, int kind) {

    }
}