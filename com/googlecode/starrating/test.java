/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * test.java
 *
 * Created on 25 Μαϊ 2010, 10:08:46 πμ
 */
package com.googlecode.starrating;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ssoldatos
 */
public class test extends javax.swing.JFrame {

  /** Creates new form test */
  public test() {
    initComponents();
    setLocationRelativeTo(null);
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
    srating.addPropertyChangeListener(new PropertyChangeListener() {

      public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(StarRating.RATE_CHANGED)) {
          System.out.println("PropertyChangeListener notified (property: "+StarRating.RATE_CHANGED+"), value: " + evt.getNewValue());
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
    jScrollPane1 = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    srating = new com.googlecode.starrating.StarRating(0.0, 3);
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jCheckBox1 = new javax.swing.JCheckBox();
    jCheckBox2 = new javax.swing.JCheckBox();
    jLabel1 = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox();
    jLabel5 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

    table.setBackground(new java.awt.Color(255, 204, 204));
    jScrollPane1.setViewportView(table);

    jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+3));
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Star Rating Demo");

    jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD));
    jLabel3.setText("As a TableCellRenderer / Editor");

    jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD));
    jLabel4.setText("Stand alone");

    jCheckBox1.setSelected(srating.isRatingEnabled());
    jCheckBox1.setText("enabled");
    jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox1ActionPerformed(evt);
      }
    });

    jCheckBox2.setSelected(srating.isValueLabelShown());
    jCheckBox2.setText("Show label");
    jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox2ActionPerformed(evt);
      }
    });

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("Max Rate :");

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "15" }));
    jComboBox1.setToolTipText("Select the maximum rate");
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    jLabel5.setFont(jLabel5.getFont().deriveFont((jLabel5.getFont().getStyle() | java.awt.Font.ITALIC)));
    jLabel5.setText("(Double click to edit the rate)");

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(srating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(63, 63, 63)))
        .addContainerGap())
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jCheckBox1)
          .addComponent(jCheckBox2)
          .addComponent(jLabel1)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
        .addComponent(srating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    srating.setEnabled(jCheckBox1.isSelected());
  }//GEN-LAST:event_jCheckBox1ActionPerformed

  private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
    srating.setValueLabelShown(jCheckBox2.isSelected());
  }//GEN-LAST:event_jCheckBox2ActionPerformed

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    srating.setMaxRate(Integer.parseInt((String) jComboBox1.getSelectedItem()));
    srating.validate();
    srating.repaint();
    panel.validate();
    panel.repaint();
  }//GEN-LAST:event_jComboBox1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new test().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JCheckBox jCheckBox2;
  private javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JPanel panel;
  private com.googlecode.starrating.StarRating srating;
  private javax.swing.JTable table;
  // End of variables declaration//GEN-END:variables
}