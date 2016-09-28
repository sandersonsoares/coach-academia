package br.com.projetoacademia.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MeuModelo extends DefaultTableCellRenderer {

    /**
     * 
     */
    private static final long   serialVersionUID    = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color c = new Color(26, 188, 156);
        Object text = table.getValueAt(row, 2);
        if (text != null && "VENCIDO".equals(text.toString()))
            c = new Color(255, 94, 76);
        label.setBackground(c);
        return label;
    }
}