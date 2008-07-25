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
package org.puzzle.format.geotiff.service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.filechooser.FileFilter;
import org.geotools.gui.swing.misc.filter.FileFilterFactory;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.util.Exceptions;
import org.puzzle.puzzlecore.project.GISProject;
import org.puzzle.puzzlecore.project.source.GISFileSourceService;
import org.puzzle.puzzlecore.project.source.GISSource;

/**
 * This is the service linked with the {@code GeoTiffSource}.
 * The service is used to manage this kind of source.
 * 
 * @author  Thomas Bonavia
 * 
 * @see     org.puzzle.puzzlecore.project.source.GISFileSourceService
 */
public class GeoTiffSourceService implements GISFileSourceService{
    private static final String TITLE = "Geotiff";
        
    /** {@inheritDoc} */
    public FileFilter createFilter() {
        return FileFilterFactory.createFileFilter(FileFilterFactory.FORMAT.GEOTIFF);
    }

    /** {@inheritDoc} */
    public String getIdentifier() {
        return "SingleGeoTiff";
    }

    /** {@inheritDoc} */
    public GISSource restoreSource(Map<String, String> parameters, int id) throws IllegalArgumentException {
        final String url = parameters.get("url");
        
        if(url == null) throw new IllegalArgumentException("missing parameter url");

        File geotiff = null;
        try{
            geotiff = new File(new URI(url));
        }catch(URISyntaxException urise){
            Exceptions.printStackTrace(urise);
        }
            
        GISSource geotiffSource = new GeoTiffSource(geotiff,getIdentifier(),id,parameters);
        return geotiffSource;
    }
    
    /** {@inheritDoc} */
    public GISSource createSource(File file) throws IllegalArgumentException {
        String url = null;
        Map<String,String> params = new HashMap<String, String>();
        try {
            url = file.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        if(url == null){
            throw new IllegalArgumentException("Not a valid File");
        }
        
        params.put("url", url);
        
        Project mainProject = OpenProjects.getDefault().getMainProject();
        int id = -1;
        
        if(mainProject != null && mainProject instanceof GISProject){
            GISProject gis = (GISProject) mainProject;
            id = gis.getNextSourceID();
        }else{
            throw new IllegalArgumentException("Not a valid GIS project open");
        }
        
        return restoreSource(params, id);
    }
    
    /** {@inheritDoc} */
    public boolean isValidFile(File file) {
        String name = file.getName().toLowerCase();
        if(name.endsWith("tiff") || name.endsWith("tif")) return true;
        else return false;
    }
    
    /** {@inheritDoc} */
    public String getTitle(){
        return TITLE;
    }
}
