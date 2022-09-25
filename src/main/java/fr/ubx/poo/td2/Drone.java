package fr.ubx.poo.td2;

public class Drone extends Vehicule{


    public Drone (Position position, double energy, double cost) {
            super(position, energy, cost);
        }
    @Override
    public String toString() {
        return "Drone(energy="+energy+")";
    }

}
