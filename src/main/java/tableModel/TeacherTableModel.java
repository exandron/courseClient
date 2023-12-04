package tableModel;

import model.Student;
import model.Teacher;
import model.User;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeacherTableModel implements TableModel{

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Teacher> teachers;

    public TeacherTableModel(List<Teacher> teachers){
        this.teachers = teachers;
    }

    @Override
    public int getRowCount() {
        return teachers.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
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
                return "Логин";
            case 5:
                return "Личный телефон";
            case 6:
                return "Почта";
            case 7:
                return "Кафедра";
            case 8:
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
            case 7: return String.class;
            case 8: return String.class;
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
                return teacher.getUserId();
            case 1:
                return teacher.getSurname();
            case 2:
                return teacher.getName();
            case 3:
                return teacher.getPatronymic();
            case 4:
                return teacher.getLogin();
            case 5:
                return teacher.getPhone();
            case 6:
                return teacher.getEmail();
            case 7:
                return teacher.getDepartment();
            case 8:
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
