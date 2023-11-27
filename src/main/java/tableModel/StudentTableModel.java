package tableModel;

import model.Student;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentTableModel implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Student> students;

    public StudentTableModel(List<Student> students){
        this.students = students;
    }


    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
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
                return "Телефон";
            case 6:
                return "Дата рождения";
            case 7:
                return "Форма обучения";
            case 8:
                return "Адрес";
            case 9:
                return "Участок";
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
            case 9: return String.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex){
            case 0:
                return student.getUserId();
            case 1:
                return student.getSurname();
            case 2:
                return student.getName();
            case 3:
                return student.getPatronymic();
            case 4:
                return student.getLogin();
            case 5:
                return student.getPhone_number();
            case 6:
                return student.getDOB();
            case 7:
                return student.getFormOfEducation();
            case 8:
                return student.getAddress();
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

    public void addRow(Student admin){
        students.add(admin);
    }
}
