package tableModel;

import model.Subject;
import model.Teacher;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.*;

public class TeachersStudentTableModel implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Teacher> teachers;

    public TeachersStudentTableModel(List<Teacher> teachers){
        this.teachers = teachers;
    }


    @Override
    public int getRowCount() {
        return teachers.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Фамилия";
            case 2:
                return "Имя";
            case 3:
                return "Отчество";
            case 4:
                return "Почта";
            case 5:
                return "Кафедра";
            case 6:
                return "Должность";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            case 5: return String.class;
            case 6: return String.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = teachers.get(rowIndex);
        switch (columnIndex){
            case 0:
                return teacher.getId();
            case 1:
               return teacher.getSurname();
            case 2:
                return teacher.getName();
            case 3:
                return teacher.getPatronymic();
            case 4:
                return teacher.getEmail();
            case 5:
                return teacher.getDepartment();
            case 6:
                return teacher.getPost();
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

    public void addRow(Teacher teacher){
        teachers.add(teacher);
    }
}
