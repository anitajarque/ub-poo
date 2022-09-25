package fr.ubx.poo.td2;

public class Robot extends Vehicule{

    public Robot(Position position, double energy, double cost) {
        super(position, energy, cost);
    }
    @Override
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
