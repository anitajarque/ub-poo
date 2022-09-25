package fr.ubx.poo.td2;

public class Vehicule {
    private final double cost;
    protected Position position;
    private double energy;


    public Vehicule(Position position, double energy, double cost) {
        //this.position = position; for having a not independant variable of position
        this.position=new Position(position.getX(), position.getY()); //for having an independant variable of position
        this.energy = energy;
        this.cost = cost;
    }

    public Position getPosition() {
        return position;
    }

    // TODO
    private int range() {
        return (int) (this.energy/this.cost);
    }

    // TODO
    public int distance(Position target) {
        return 0;
    }

    // TODO
    public boolean canMove(Position target) {

        return this.range() >= this.distance(target);
    }

    // TODO
    public void move(Position target) {
        this.position = target; //new Position(position.getX(), position.getY());
    }

    // TODO
    public Position[] getPathTo(Position target) {
        return null;
    }
}




