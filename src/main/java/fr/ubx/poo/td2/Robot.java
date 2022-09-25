package fr.ubx.poo.td2;

public class Robot extends Vehicule{

    public Robot(Position position, double energy, double cost) {
        super(position, energy, cost);
    }

    @Override
    public String toString() {
        return "Robot(energy="+energy+")";
    }
}
