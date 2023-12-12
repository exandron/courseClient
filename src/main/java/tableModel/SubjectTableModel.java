package tableModel;

import model.Subject;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubjectTableModel implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Subject> subjects;

    public SubjectTableModel(List<Subject> subjects){
        this.subjects = subjects;
    }


    @Override
    public int getRowCount() {
        return subjects.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Предмет";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: return String.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subject subject = subjects.get(rowIndex);
        switch (columnIndex){
            case 0:
                return subject.getSubjectId();
            case 1:
                return subject.getSubjectName();
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

    public void addRow(Subject subject){
        subjects.add(subject);
    }
}
