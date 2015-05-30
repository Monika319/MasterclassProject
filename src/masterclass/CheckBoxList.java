package masterclass;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author rafal
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxList extends JList {
    protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

    public CheckBoxList() {
        setCellRenderer(new CellRenderer());
        addMouseListener(new MouseAdapter() {
                             public void mousePressed(MouseEvent e) {
                                 int index = locationToIndex(e.getPoint());

                                 if (index != -1) {
                                     JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
                                     checkbox.setSelected(!checkbox.isSelected());
                                     repaint();
                                 }
                             }
                         }
        );

        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    protected class CellRenderer implements ListCellRenderer {
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            JCheckBox checkbox = (JCheckBox) value;
            checkbox.setBackground(isSelected ? getSelectionBackground() : getBackground());
            checkbox.setForeground(isSelected ? getSelectionForeground() : getForeground());
            checkbox.setEnabled(isEnabled());
            checkbox.setFont(getFont());
            checkbox.setFocusPainted(false);
            checkbox.setBorderPainted(true);
            checkbox.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
            return checkbox;
        }
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Test");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CheckBoxList list = new CheckBoxList();
        JCheckBox[] boxes = new JCheckBox[4];
        boxes[0] = new JCheckBox("Option 1");
        boxes[1] = new JCheckBox("Option 2");
        boxes[2] = new JCheckBox("Option 3");
        boxes[3] = new JCheckBox("Option 4");
        list.setListData(boxes);

        frame.add(list, BorderLayout.WEST);
        frame.setVisible(true);


    }
}
