/*
 *  Puzzle-GIS - OpenSource mapping program
 *  http://docs.codehaus.org/display/PUZZLEGIS
 *  Copyright (C) 2007 Puzzle-GIS
 *  
 *  GPLv3 + Classpath exception
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.puzzle.puzzlemap2d.actions;

import org.geotools.gui.swing.map.map2d.Map2D;
import org.geotools.gui.swing.map.map2d.control.PreviousAreaAction;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.puzzle.puzzlemap2d.struct.Map2DManager;

/**
 * 
 * @author johann sorel
 */
public final class NavPreviousAreaAction extends CallableSystemAction {

    private PreviousAreaAction action = new PreviousAreaAction();

    public NavPreviousAreaAction() {
        setMap(Map2DManager.getInstance().getMap2D());
    }

    public Map2D getMap() {
        return action.getMap();
    }

    public void setMap(Map2D map) {
        action.setMap(map);
    }

    public void performAction() {
        action.actionPerformed(null);
    }

    public String getName() {
        return NbBundle.getMessage(NavPreviousAreaAction.class, "CTL_PreviousAreaMapAction");
    }

    @Override
    protected String iconResource() {
        return "org/puzzle/puzzlemap2d/actions/previous.png";
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
}
