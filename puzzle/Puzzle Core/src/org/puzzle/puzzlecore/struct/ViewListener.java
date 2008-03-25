/*
 *  Puzzle-GIS - OpenSource mapping program
 *  http://docs.codehaus.org/display/PUZZLEGIS
 *  Copyright (C) 2007-2008 Puzzle-GIS
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

package org.puzzle.puzzlecore.struct;

import java.util.EventListener;

/**
 * Listener for views
 * 
 * @author johann sorel
 */
public interface ViewListener extends EventListener{
        
    /**
     * When a mapview is added
     * 
     * @param event the event
     */
    public void viewAdded(ViewEvent event) ;
      
    /**
     * When a mapview is removed
     * 
     * @param event the event
     */
    public void viewRemoved(ViewEvent event);
      
    /**
     * When a mapview is activated
     * 
     * @param event the event
     */
    public void viewActivated(ViewEvent event);
    
    /**
     * when a mapgroup is added
     * @param event
     */
    public void groupAdded(GroupEvent event);
    
    /**
     * when a mapgroup is removed
     * @param event
     */
    public void groupRemoved(GroupEvent event);
    
    /**
     * when the content of the group 
     * @param event
     */
    public void groupChanged(GroupEvent event);
              
}
