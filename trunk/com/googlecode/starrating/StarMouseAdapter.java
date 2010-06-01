/*
 * @(#)StarMouseAdapter.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 * A MouseAdapter for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
class StarMouseAdapter extends MouseAdapter {

  /** The source object's index if it's a {@link Star} or -1 if the source is a
   * {@link RemoveButton} or {@link ValueLabel} */
  private int index = -1;
  /** The {@link #sourceType} for a {@link Star} source  */
  static int STAR = 0;
  /** The {@link #sourceType} for a {@link RemoveButton} source  */
  static int REMOVE_BUTTON = 1;
  /** The {@link #sourceType} for {@link ValueLabel}   source   */
  static int VALUE_LABEL = 2;
  /** The event's source type:<br />
   *           <code>STAR</code>,
   *           <code>REMOVE_BUTTON</code>,
   *           <code>VALUE_LABEL</code>,
   */
  private int sourceType = REMOVE_BUTTON;
  /** The component that originated the mouse event */
  private Component source;
  /** The {@link StarRating} that the source component belongs */
  private StarRating starRating;
  /** If starrating is a table editor **/
  private boolean isTableEditor;

  /**
   * Creates a {@link StarMouseAdapter} for a component that can be a {@link Star}
   * or a {@link RemoveButton} or a {@link ValueLabel}
   * If the component is not of one of these types an IllegalArgument exception is thrown
   * @param source The source component of this event
   */
  public StarMouseAdapter(Component source) {
    this.source = source;
    if (source instanceof Star) {
      Star star = (Star) source;
      this.index = star.getIndex();
      this.sourceType = STAR;
    } else if (source instanceof RemoveButton) {
      this.index = -1;
      this.sourceType = REMOVE_BUTTON;
    } else if (source instanceof ValueLabel) {
      this.index = -1;
      this.sourceType = VALUE_LABEL;
    } else {
      throw new IllegalArgumentException("Wrong source component, must be a Star, ValueLabel or RemoveButton");
    }
    this.starRating = (StarRating) source.getParent();

  }

  /**
   * If {@link StarRating} rating is enabled it sets it's background color to
   * white and opaque to true<br />
   * If source is {@link RemoveButton} sets it's icon to the enabled one and
   * the {@link ValueLabel} text to 0.0
   * If the source is a {@link Star} it sets the {@link ValueLabel} text according
   * to the {@link Star} index
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    if (starRating.isEnabled()) {
      if (starRating.getParent() instanceof JTable) {
        isTableEditor = true;
      }
      starRating.setOpaque(true);
      if (!isTableEditor) {
        this.starRating.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
      } else {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      }
      this.starRating.setBackground(Color.WHITE);
      if (sourceType == REMOVE_BUTTON) {
        RemoveButton removeButton = (RemoveButton) e.getSource();
        removeButton.setIcon(new ImageIcon(getClass().getResource(RemoveButton.REMOVE_IMAGE)));
        starRating.previewRate((double) (index + 1) / 2);
      } else if (sourceType == STAR) {
        starRating.previewRate((double) (index + 1) / 2);
      }
      super.mouseEntered(e);
    }
  }

  /**
   * If {@link StarRating} rating is enabled it sets it's opaque to false<br />
   * If source is {@link RemoveButton} sets it's icon to the disabled one and
   * sets the {@link ValueLabel} text to the {@link StarRating} rate
   */
  @Override
  public void mouseExited(MouseEvent e) {
    if (starRating.isEnabled()) {
      starRating.setOpaque(false);
      if (!isTableEditor) {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      } else {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      }

      if (sourceType == REMOVE_BUTTON) {
        RemoveButton removeButton = (RemoveButton) e.getSource();
        removeButton.setIcon(removeButton.getDisabledIcon());
      }
      starRating.setRate(starRating.getRate());
      super.mouseExited(e);
    }
  }

  /**
   * If {@link StarRating} rating is enabled it sets the {@link StarRating} rate
   * and the {@link ValueLabel} text to the one selected.<br />
   * If {@link StarRating} is used as a {@link StarTableCellEditor} it stops the
   * cell editing by calling {@link StarTableCellEditor#stopCellEditing()}
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    if (starRating.isEnabled() && sourceType != VALUE_LABEL) {
      starRating.setRate((double) (index + 1) / 2);
      starRating.previewRate((double) (index + 1) / 2);
      if (!isTableEditor) {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      } else {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      }
      this.starRating.setOpaque(false);
      if (isTableEditor) {
        JTable table = (JTable) starRating.getParent();
        table.getCellEditor().stopCellEditing();
      }
      super.mouseClicked(e);
    }
  }
}