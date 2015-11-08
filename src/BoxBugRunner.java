
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import javax.swing.*;
import java.awt.Color;

public class BoxBugRunner extends Bug {
public static void main(String[]args){
        ActorWorld world = new ActorWorld();
        BoxBugRunner alice = new BoxBugRunner();
        alice.setColor(Color.ORANGE);
        BoxBugRunner bob = new BoxBugRunner();
        world.add( new Location(7,8), alice);
        world.add( new Location(5, 5), bob);
        world.show();

        }
        }
