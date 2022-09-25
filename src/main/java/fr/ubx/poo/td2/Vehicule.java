package fr.ubx.poo.td2;

public class Vehicule {
    protected final double cost;
    protected Position position;
    protected double energy;


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
        return (int) Math.sqrt(Math.pow(position.getY() - target.getY(), 2) + Math.pow(position.getX() - target.getX(), 2));
    }

        // TODO
    public boolean canMove(Position target) {

        return this.range() >= this.distance(target);
    }

    // TODO
    public void move(Position target) {
        this.position = target; //new Position(position.getX(), position.getY());
        System.out.println("Move completed: " + this);
    }

    // TODO
    public Position[] getPathTo(Position target) {

        Position[] positions = new Position[1000];
        int numPositions=0;

        if(target.getX()>= position.getX()){
            for(int i =position.getX(); i<target.getX(); i++){
                positions[numPositions] = new Position(i, getPosition().getY());
                numPositions++;
            }
        }
        else{
            for(int i =position.getX(); i<target.getX(); i--){
                positions[numPositions] = new Position(i, getPosition().getY());
                numPositions++;
            }
        }


        if(target.getY()>= position.getY()){
            for(int i =position.getY(); i<target.getY(); i++){
                positions[numPositions] = new Position(target.getX(), i);
                numPositions++;
            }
        }
        else{
            for(int i =position.getY(); i<target.getY(); i--){
                positions[numPositions] = new Position(target.getX(), i);
                numPositions++;
            }
        }
        Position[] positions1 = new Position[numPositions];
        for(int i=0; i<numPositions; i++){
            positions1[i]=positions[i];
        }
        return positions1;
    }
}




