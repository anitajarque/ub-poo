package model;

import fr.ubx.poo.td2.Position;
import model.Vehicule;

public class Drone extends Vehicule {


    public Drone (Position position, double energy, double cost) {
            super(position, energy, cost);
        }
    @Override
    public String toString() {
        return "Drone(energy="+energy+")";
    }

    @Override
    public Position[] getPathTo(Position target) {
        Position[] positionPath = new Position[2]; //movimiento euclideo
        positionPath[0]=position;
        positionPath[1]=target;
        return positionPath;
    }
}
