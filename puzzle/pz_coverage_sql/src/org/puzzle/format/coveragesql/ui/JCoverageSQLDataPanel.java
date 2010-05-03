/*
 *    Puzzle GIS - Desktop GIS Platform
 *    http://puzzle-gis.codehaus.org
 *
 *    (C) 2007-2009, Johann Sorel
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
package org.puzzle.format.coveragesql.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import org.geotoolkit.data.DataStore;
import org.geotoolkit.storage.DataStoreException;
import org.geotoolkit.data.DataStoreFinder;

import org.openide.util.Exceptions;

import org.puzzle.core.project.source.capabilities.SourceCreationPane;
import org.puzzle.core.project.source.GISSourceInfo;
import org.puzzle.format.coveragesql.resources.CoverageSQLResource;
import org.puzzle.format.coveragesql.service.CoverageSQLSourceService;

import static org.puzzle.format.coveragesql.service.CoverageSQLSource.*;

/**
 * PostGIS databaseChooser
 * 
 * @author Johann Sorel
 */
public class JCoverageSQLDataPanel extends SourceCreationPane {

    private DataStore store;
    private final Map<String,Serializable> params = new HashMap<String, Serializable>();

    /** Creates new form DefaultShapeTypeChooser */
    public JCoverageSQLDataPanel() {
        initComponents();
        params.put(KEY_SERVER, "localhost");
        params.put(KEY_PORT, 5432);
        params.put(KEY_SCHEMA, "public");
        params.put(KEY_DATABASE, "");
        params.put(KEY_USER, "");
        params.put(KEY_PASSWORD, "");

        setProperties(params);
    }

    public Map getProperties() {
        return params;
    }

    private void setProperties(Map map) {

        if(map == null){
            throw new NullPointerException();
        }
        
        Object val = null;
        
        val = map.get(KEY_SERVER);
        jtf_host.setText( (val == null) ? "" : val.toString());
        val = map.get(KEY_PORT);
        jtf_port.setValue((val == null) ? "" : val);
        val = map.get(KEY_SCHEMA);
        jtf_schema.setText((val == null) ? "" : val.toString());
        val = map.get(KEY_DATABASE);
        jtf_database.setText((val == null) ? "" : val.toString());
        val = map.get(KEY_USER);
        jtf_user.setText((val == null) ? "" : val.toString());
        val = map.get(KEY_PASSWORD);
        jtf_password.setText((val == null) ? "" : val.toString());
        
    }

    private void refreshTable() {

        if (store != null) {
            try {
                guiLayerList.setModel(new DefaultComboBoxModel(store.getTypeNames()));
            } catch (DataStoreException ex) {
                System.out.println(ex);
            }
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        but_refresh = new JButton();
        jScrollPane1 = new JScrollPane();
        guiLayerList = new JList();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jtf_host = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jtf_schema = new JTextField();
        jLabel4 = new JLabel();
        jtf_database = new JTextField();
        jLabel5 = new JLabel();
        jtf_user = new JTextField();
        jLabel6 = new JLabel();
        jtf_password = new JPasswordField();
        jtf_port = new JSpinner();
        jLabel7 = new JLabel();
        jtf_directory = new JTextField();

        but_refresh.setText(CoverageSQLResource.getString("test")); // NOI18N
        but_refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionRefresh(evt);
            }
        });

        jScrollPane1.setViewportView(guiLayerList);








        jLabel1.setText(CoverageSQLResource.getString("host")); // NOI18N
        jLabel2.setText(CoverageSQLResource.getString("port")); // NOI18N
        jLabel3.setText(CoverageSQLResource.getString("schema")); // NOI18N
        jLabel4.setText(CoverageSQLResource.getString("database")); // NOI18N
        jLabel5.setText(CoverageSQLResource.getString("user")); // NOI18N
        jLabel6.setText(CoverageSQLResource.getString("password")); // NOI18N
        jtf_port.setModel(new SpinnerNumberModel(Integer.valueOf(5432), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel7.setText(CoverageSQLResource.getString("imgDirectory")); // NOI18N
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jtf_host, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jtf_port, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_password, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jtf_user, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jtf_database, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jtf_schema, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jtf_directory, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_host, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_schema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_database, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtf_user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtf_directory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(but_refresh, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(but_refresh)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void actionRefresh(ActionEvent evt) {//GEN-FIRST:event_actionRefresh

        params.clear();
        params.put(KEY_SERVER, jtf_host.getText());
        params.put(KEY_PORT, (Integer)jtf_port.getValue());
        params.put(KEY_SCHEMA, jtf_schema.getText());
        params.put(KEY_DATABASE, jtf_database.getText());
        params.put(KEY_USER, jtf_user.getText());
        params.put(KEY_PASSWORD, new String(jtf_password.getPassword()));
        params.put(KEY_ROOT_DIRECTORY, jtf_directory.getText());

        but_refresh.setEnabled(false);
        new Thread() {

            @Override
            public void run() {
                try {
                    store = DataStoreFinder.getDataStore(params);
                    refreshTable();
                } catch (DataStoreException ex) {
                    Exceptions.printStackTrace(ex);
                    store = null;
                }

            but_refresh.setEnabled(true);
            }
        }.start();
        
    }//GEN-LAST:event_actionRefresh

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton but_refresh;
    private JList guiLayerList;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField jtf_database;
    private JTextField jtf_directory;
    private JTextField jtf_host;
    private JPasswordField jtf_password;
    private JSpinner jtf_port;
    private JTextField jtf_schema;
    private JTextField jtf_user;
    // End of variables declaration//GEN-END:variables
    
    public Map<String,GISSourceInfo> createSources() {
        final Map<String,Serializable> params = new HashMap<String,Serializable>();
        params.put(KEY_SERVER, jtf_host.getText());
        params.put(KEY_PORT, (Integer)jtf_port.getValue());
        params.put(KEY_SCHEMA, jtf_schema.getText());
        params.put(KEY_DATABASE, jtf_database.getText());
        params.put(KEY_USER, jtf_user.getText());
        params.put(KEY_PASSWORD, new String(jtf_password.getPassword()));
        params.put(KEY_ROOT_DIRECTORY, jtf_directory.getText());

        final GISSourceInfo info = new GISSourceInfo(-1, CoverageSQLSourceService.SERVICE_ID, params);
        final String name = jtf_host.getText() +"_"+jtf_schema.getText()+"_"+jtf_database.getText();
        final Map<String,GISSourceInfo> sources = new HashMap<String, GISSourceInfo>();
        sources.put(name, info);
        return sources;
    }
}
