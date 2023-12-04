package tableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CenteredTextRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Integer) {
            value = String.valueOf(value);
        }
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((DefaultTableCellRenderer) rendererComponent).setHorizontalAlignment(SwingConstants.CENTER);
        return rendererComponent;
    }
}