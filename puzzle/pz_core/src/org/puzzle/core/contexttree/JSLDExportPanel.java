/*
 *    Puzzle GIS - Desktop GIS Platform
 *    http://puzzle-gis.codehaus.org
 *
 *    (C) 2009, Johann Sorel
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 3 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */

package org.puzzle.core.contexttree;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.xml.bind.JAXBException;
import org.geotoolkit.gui.swing.propertyedit.PropertyPane;
import org.geotoolkit.map.MapLayer;
import org.geotoolkit.sld.xml.Specification.StyledLayerDescriptor;
import org.geotoolkit.sld.xml.XMLUtilities;
import org.geotoolkit.style.MutableStyle;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.puzzle.core.resources.MessageBundle;

/**
 *
 * @author Johann Sorel (Puzzle-GIS)
 */
public class JSLDExportPanel extends javax.swing.JPanel implements PropertyPane{

    private MapLayer layer = null;

    /** Creates new form JSLDExportPanel */
    public JSLDExportPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText(MessageBundle.getString("sld_100")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exp100(evt);
            }
        });

        jButton2.setText(MessageBundle.getString("sld_110")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exp110(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exp100(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exp100
        write(StyledLayerDescriptor.V_1_0_0);
    }//GEN-LAST:event_exp100

    private void exp110(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exp110
        write(StyledLayerDescriptor.V_1_1_0);
    }//GEN-LAST:event_exp110

    private void write(StyledLayerDescriptor version){
        if(layer != null && layer.getStyle() != null){
            final MutableStyle style = layer.getStyle();
            final JFileChooser chooser = new JFileChooser();
            final int result = chooser.showSaveDialog(this);

            if(result == JFileChooser.APPROVE_OPTION){
                XMLUtilities tool = new XMLUtilities();
                try {
                    tool.writeStyle(chooser.getSelectedFile(), style, version);
                } catch (JAXBException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }

    @Override
    public void setTarget(Object candidate) {
        if(candidate instanceof MapLayer){
            this.layer = (MapLayer) candidate;
        }
    }

    @Override
    public void apply() {
    }

    @Override
    public void reset() {
    }

    @Override
    public String getTitle() {
        return MessageBundle.getString("sld_export");
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon(ImageUtilities.loadImage("org/puzzle/core/resources/colors.png"));
    }

    @Override
    public String getToolTip() {
        return "";
    }

    @Override
    public Component getComponent() {
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

}
