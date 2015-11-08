import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class LangtonTermite extends Termite {


    Location dropLoc, addLoc = null;
    boolean steps = false;


    public void act() {
        if (getGrid() == null && !canMove())
            return;

        /*If location has flower*/
       Actor loc = getGrid().get(getNextLocation());
        if( loc instanceof Flower){
            move();

            dropLoc = getLocation();
            if(steps){
                turn(45);
            } else {
                turn (-90);
            }
            if(steps){
                steps = false;
            } else{
                steps = true;
            }
        }
         else {
            move();
            addLoc = getLocation();
            if(steps){
                turn(-45);
            } else {
                turn (90);
            }
            if(steps){
                steps = false;
            } else{
                steps = true;
            }

        }

    }

    public void move() {
        Location next = getNextLocation();
        if (isValid(next)) {
            moveTo(next);
        } else {
            removeSelfFromGrid();
        }

        if(addLoc != null) {
            Flower act = new Flower();
            act.putSelfInGrid(getGrid(), addLoc);
            addLoc = null;

        }
    }

    private boolean isValid(Location loc) {
        return getGrid().isValid(loc);
    }

    /*
    * Gets the location the termite is facing.
    */
    private Location getNextLocation() {
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        return next;
    }
}
