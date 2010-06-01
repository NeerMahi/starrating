/*
 * @(#)DemoPanel.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating.demo;

import com.googlecode.starrating.Star;
import com.googlecode.starrating.StarRating;
import com.googlecode.starrating.StarTableCellEditor;
import com.googlecode.starrating.StarTableCellRenderer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 * The demo panel
 * @author lordovol
 * @since version 0.9
 */
public class DemoPanel extends javax.swing.JPanel {

  DefaultComboBoxModel starModel;

  /** Creates new form DemoPanel */
  public DemoPanel() {
    createStarModel();
    initComponents();
    DefaultTableModel model = new DefaultTableModel(new String[]{"Title", "Rating"}, 0);
    table.setModel(model);
    model.addRow(new Object[]{"PHP", new Double(3.0)});
    model.addRow(new Object[]{"Java", 2.5});
    model.addRow(new Object[]{"VBScript", 3});
    model.addRow(new Object[]{"C++", 1.5});
    StarTableCellRenderer rend = new StarTableCellRenderer(true, false);
    StarTableCellEditor ed = new StarTableCellEditor(true);
    table.getColumnModel().getColumn(1).setCellRenderer(rend);
    table.getColumnModel().getColumn(1).setCellEditor(ed);
    table.setRowHeight(22);
    /**
     * Adds a CellEditorListener to the CellEditor to receive changes in the cells value
     */
    ed.addCellEditorListener(new CellEditorListener() {

      public void editingStopped(ChangeEvent e) {
        StarTableCellEditor s = (StarTableCellEditor) e.getSource();
        System.out.println("CellEditorListener notified (Editing stopped), value: " + s.getValue());
      }

      public void editingCanceled(ChangeEvent e) {
        StarTableCellEditor s = (StarTableCellEditor) e.getSource();
        System.out.println("CellEditorListener notified (Editing Cancelled), value: " + s.getValue());
      }
    });
    srating.setRate(2.5);
    srating.changeStarImage(StarRating.class.getResource(StarRating.EURO_IMAGE));
    /**
     * Adds a PropertyChangeListener to the StarRating and listens for property
     * {@link StarRating#RATE_CHANGED} change.
     */
    srating.addPropertyChangeListener(new PropertyChangeListener() {

      public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(StarRating.RATE_CHANGED)) {
          System.out.println("PropertyChangeListener notified (property: " + StarRating.RATE_CHANGED + "), value: " + evt.getNewValue());
        }
      }
    });
    
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel = new javax.swing.JPanel();
    scrollPane = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    srating = new com.googlecode.starrating.StarRating(0.0, 5);
    label_title = new javax.swing.JLabel();
    label_table_title = new javax.swing.JLabel();
    label_standAlone_title = new javax.swing.JLabel();
    checkbox_enabled = new javax.swing.JCheckBox();
    checkbox_label = new javax.swing.JCheckBox();
    label_maxrate = new javax.swing.JLabel();
    combo_maxRate = new javax.swing.JComboBox();
    label_table_hint = new javax.swing.JLabel();
    label_starImage = new javax.swing.JLabel();
    combo_starImage = new javax.swing.JComboBox();

    scrollPane.setPreferredSize(new java.awt.Dimension(452, 200));

    table.setBackground(new java.awt.Color(255, 204, 204));
    scrollPane.setViewportView(table);

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+3));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText("Star Rating Demo");

    label_table_title.setFont(label_table_title.getFont().deriveFont(label_table_title.getFont().getStyle() | java.awt.Font.BOLD));
    label_table_title.setText("As a TableCellRenderer / Editor");

    label_standAlone_title.setFont(label_standAlone_title.getFont().deriveFont(label_standAlone_title.getFont().getStyle() | java.awt.Font.BOLD));
    label_standAlone_title.setText("Stand alone with custom image");

    checkbox_enabled.setSelected(srating.isRatingEnabled());
    checkbox_enabled.setText("enabled");
    checkbox_enabled.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkbox_enabledActionPerformed(evt);
      }
    });

    checkbox_label.setSelected(srating.isValueLabelVisible());
    checkbox_label.setText("Show label");
    checkbox_label.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkbox_labelActionPerformed(evt);
      }
    });

    label_maxrate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_maxrate.setText("Max Rate :");

    combo_maxRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "15" }));
    combo_maxRate.setToolTipText("Select the maximum rate");
    combo_maxRate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_maxRateActionPerformed(evt);
      }
    });

    label_table_hint.setFont(label_table_hint.getFont().deriveFont((label_table_hint.getFont().getStyle() | java.awt.Font.ITALIC)));
    label_table_hint.setText("(Double click to edit the rate)");

    label_starImage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_starImage.setText("Star image :");

    combo_starImage.setModel(starModel);
    combo_starImage.setRenderer(new StarComboRenderer());
    combo_starImage.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_starImageActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(label_table_title, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(label_table_hint, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(63, 63, 63))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(label_standAlone_title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(panelLayout.createSequentialGroup()
                    .addComponent(checkbox_enabled, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label_maxrate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(panelLayout.createSequentialGroup()
                    .addComponent(checkbox_label, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label_starImage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(combo_maxRate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(combo_starImage, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE))))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(srating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label_title)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(label_table_title)
          .addComponent(label_table_hint))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(label_standAlone_title)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(checkbox_enabled)
          .addComponent(label_maxrate)
          .addComponent(combo_maxRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(checkbox_label)
          .addComponent(label_starImage)
          .addComponent(combo_starImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(srating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
  }// </editor-fold>//GEN-END:initComponents

    private void checkbox_enabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_enabledActionPerformed
      srating.setEnabled(checkbox_enabled.isSelected());
}//GEN-LAST:event_checkbox_enabledActionPerformed

    private void checkbox_labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_labelActionPerformed
      srating.setValueLabelVisible(checkbox_label.isSelected());
}//GEN-LAST:event_checkbox_labelActionPerformed

    private void combo_maxRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_maxRateActionPerformed
      srating.setMaxRate(Integer.parseInt((String) combo_maxRate.getSelectedItem()));
      srating.validate();
      srating.repaint();
      panel.validate();
      panel.repaint();
}//GEN-LAST:event_combo_maxRateActionPerformed

    private void combo_starImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_starImageActionPerformed
      File f = (File) combo_starImage.getSelectedItem();
      URL url = null;
      try {
        url = f.toURI().toURL();
        srating.changeStarImage(url);
        srating.validate();
        srating.repaint();
        panel.validate();
        panel.repaint();
      } catch (MalformedURLException ex) {
      }
    }//GEN-LAST:event_combo_starImageActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox checkbox_enabled;
  private javax.swing.JCheckBox checkbox_label;
  private javax.swing.JComboBox combo_maxRate;
  private javax.swing.JComboBox combo_starImage;
  private javax.swing.JLabel label_maxrate;
  private javax.swing.JLabel label_standAlone_title;
  private javax.swing.JLabel label_starImage;
  private javax.swing.JLabel label_table_hint;
  private javax.swing.JLabel label_table_title;
  private javax.swing.JLabel label_title;
  private javax.swing.JPanel panel;
  private javax.swing.JScrollPane scrollPane;
  private com.googlecode.starrating.StarRating srating;
  private javax.swing.JTable table;
  // End of variables declaration//GEN-END:variables

  private void createStarModel() {
    starModel = new DefaultComboBoxModel();
    URL res = getClass().getResource("../images");
    File dir = null;
    try {
      dir = new File(res.toURI());
    } catch (URISyntaxException ex) {
    }
    if (dir.isDirectory()) {
      File[] files = dir.listFiles(new FilenameFilter() {

        public boolean accept(File dir, String name) {
          if (name.startsWith("remove")) {
            return false;
          } else {
            return true;
          }
        }
      });
      starModel = new DefaultComboBoxModel(files);
    }

  }
}
