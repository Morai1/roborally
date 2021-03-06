/*
 *  This file is part of the initial project provided for the
 *  course "Project in Software Development (02362)" held at
 *  DTU Compute at the Technical University of Denmark.
 *
 *  Copyright (C) 2019, 2020: Ekkart Kindler, ekki@dtu.dk
 *
 *  This software is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; version 2 of the License.
 *
 *  This project is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this project; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package dk.dtu.compute.se.pisd.roborally.controller;

import dk.dtu.compute.se.pisd.roborally.model.Board;
import dk.dtu.compute.se.pisd.roborally.model.Heading;
import dk.dtu.compute.se.pisd.roborally.model.Player;
import dk.dtu.compute.se.pisd.roborally.model.Space;
import org.jetbrains.annotations.NotNull;

/**
 * ...
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 * @version $Id: $Id
 */
public class ConveyorBelt extends FieldAction {

    private Heading heading;

    /**
     * <p>Getter for the field <code>heading</code>.</p>
     *
     * @return a {@link dk.dtu.compute.se.pisd.roborally.model.Heading} object.
     */
    public Heading getHeading() {
        return heading;
    }

    /**
     * <p>Setter for the field <code>heading</code>.</p>
     *
     * @param heading a {@link dk.dtu.compute.se.pisd.roborally.model.Heading} object.
     */
    public void setHeading(Heading heading) {
        this.heading = heading;
    }


    public ConveyorBelt(Heading heading){
        this.heading = heading;
    }

    /**
     * {@inheritDoc}
     * <p>
    * Here we do it in the order of the players.
     * @author Mohamad Anwar Meri
     */
    @Override
    public boolean doAction(@NotNull GameController gameController, @NotNull Space space) {
        // TODO needs to be implemented
        Board board = space.board;
        if (board != null && gameController.board == board){
            Player player = space.getPlayer();
            if (player != null){
                Space target = board.getNeighbour(space, heading);
                if (target != null){
                    try {
                        gameController.moveToSpace(player, target, heading);
                    } catch (GameController.ImpossibleMoveException e){}
                    return true;
                }
            }
        }
        return false;
    }

}


