package tableModel;

import model.Group;
import model.Subject;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupsTableModel implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Group> groups;

    public GroupsTableModel(List<Group> groups){
        this.groups = groups;
    }


    @Override
    public int getRowCount() {
        return groups.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Номер группы";
            case 2:
                return "Специальность";
            case 3:
                return "Факультет";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return String.class;
            case 3: return String.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Group group = groups.get(rowIndex);
        switch (columnIndex){
            case 0:
                return group.getGroupId();
            case 1:
                return group.getNumberOfGroup();
            case 2:
                return group.getSpecialityName();
            case 3:
                return group.getFacultyName();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void addRow(Group group){
        groups.add(group);
    }
}
