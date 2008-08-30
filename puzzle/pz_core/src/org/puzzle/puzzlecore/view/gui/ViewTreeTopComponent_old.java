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
package org.puzzle.puzzlecore.view.gui;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.logging.Logger;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.NodeTableModel;
import org.openide.explorer.view.TreeTableView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node.Property;
import org.openide.nodes.PropertySupport;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.puzzle.puzzlecore.view.MapGroup;
import org.puzzle.puzzlecore.view.MapView;
import org.puzzle.puzzlecore.view.ViewService;

/**
 * Top component which displays something.
 * @author : johann sorel
 */
final class ViewTreeTopComponent_old extends TopComponent implements LookupListener, ExplorerManager.Provider {

    
    static final String ICON_PATH = "org/puzzle/puzzlecore/view/gui/background.png";
    
    private Lookup.Result result = null;
    private final ExplorerManager mgr = new ExplorerManager();
    private static ViewTreeTopComponent_old instance;
    private static final String PREFERRED_ID = "ViewTreeTopComponent";
    private NodeTableModel model = new NodeTableModel();

    private ViewTreeTopComponent_old() {
        initComponents();
        setName(NbBundle.getMessage(ViewTreeTopComponent_old.class, "CTL_ViewTreeTopComponent"));
        setToolTipText(NbBundle.getMessage(ViewTreeTopComponent_old.class, "HINT_ViewTreeTopComponent"));
        setIcon(Utilities.loadImage(ICON_PATH, true));
        
        Property<Boolean> propTL = new PropertySupport<Boolean>("translationLink",boolean.class,"T","TranslationLink",true,true) {

            private Boolean v = null;
                        
            @Override
            public Boolean getValue() throws IllegalAccessException, InvocationTargetException {
                return v;
            }

            @Override
            public void setValue(Boolean arg0) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                v = arg0;
            }
        };
        
        
        
        TreeTableView view = ((TreeTableView)guiTreeView);
        view.setRootVisible(false);
        view.setProperties(new Property[]{propTL});

    }

    //ExplorerManager.Provider
    public ExplorerManager getExplorerManager() {
        mgr.setRootContext(new AbstractNode(new ViewNodeModel()));
        return mgr;
    }
    

    //LookupListener
    public void resultChanged(LookupEvent lookupEvent) {
        
        Lookup.Result r = (Lookup.Result) lookupEvent.getSource();
        Collection c = r.allInstances();
        if (!c.isEmpty()) {
            lbl_nom.setText(new Integer(c.size()).toString());
//            MapView o = (MapView) c.iterator().next();
//            lbl_nom.setText(o.getName() );
        } else {
            lbl_nom.setText("[no selection]");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        guiNewGroup = new javax.swing.JButton();
        guiNewView = new javax.swing.JButton();
        guiTreeView = new TreeTableView(new ViewTableNodeModel());
        jPanel1 = new javax.swing.JPanel();
        lbl_nom = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        guiNewGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/puzzlecore/gtextend/widget/iconset/group_add.png"))); // NOI18N
        guiNewGroup.setFocusable(false);
        guiNewGroup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guiNewGroup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guiNewGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiNewGroupActionPerformed(evt);
            }
        });
        jToolBar1.add(guiNewGroup);

        guiNewView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/puzzle/puzzlecore/view/gui/view_add.png"))); // NOI18N
        guiNewView.setFocusable(false);
        guiNewView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guiNewView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guiNewView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiNewViewActionPerformed(evt);
            }
        });
        jToolBar1.add(guiNewView);

        add(jToolBar1, java.awt.BorderLayout.PAGE_START);
        add(guiTreeView, java.awt.BorderLayout.CENTER);

        lbl_nom.setText("jLabel1");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(lbl_nom, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(lbl_nom)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void guiNewViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiNewViewActionPerformed
//        MapView view = new MapView(new JStreamNavMap());
//        view.setName("2D view");
//
//        view.open();
//        view.requestActive();
    }//GEN-LAST:event_guiNewViewActionPerformed

    private void guiNewGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiNewGroupActionPerformed
        MapGroup group = new MapGroup();
        group.setTitle("2D view");

//        CORE.getViewManager().addGroup(group);

    }//GEN-LAST:event_guiNewGroupActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guiNewGroup;
    private javax.swing.JButton guiNewView;
    private javax.swing.JScrollPane guiTreeView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_nom;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized ViewTreeTopComponent_old getDefault() {
        if (instance == null) {
            instance = new ViewTreeTopComponent_old();
        }
        return instance;
    }

    /**
     * Obtain the ViewTreeTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ViewTreeTopComponent_old findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(ViewTreeTopComponent_old.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ViewTreeTopComponent_old) {
            return (ViewTreeTopComponent_old) win;
        }
        Logger.getLogger(ViewTreeTopComponent_old.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    public void componentOpened() {
        ViewService v = Lookup.getDefault().lookup(ViewService.class);

        if (v != null) {
            result = v.getLookup().lookupResult(MapView.class);
//        result = Lookup.getDefault().lookupResult(MapView.class);//Utilities.actionsGlobalContext().lookupResult(MapView.class);
            result.addLookupListener(this);
        }

    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
        result = null;
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return ViewTreeTopComponent_old.getDefault();
        }
    }
}
