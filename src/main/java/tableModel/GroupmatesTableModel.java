package tableModel;

import model.Student;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupmatesTableModel implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Student> students;

    public GroupmatesTableModel(List<Student> students){
        this.students = students;
    }


    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
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
                return "Группа";
            case 5:
                return "Телефон";
            case 6:
                return "Дата рождения";
            case 7:
                return "Форма обучения";
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
                return student.getId();
            case 1:
                return student.getSurname();
            case 2:
                return student.getName();
            case 3:
                return student.getPatronymic();
            case 4:
                return student.getNumberOfGroup();
            case 5:
                return student.getPhone();
            case 6:
                return student.getDOB();
            case 7:
                if(student.getFormOfEducation() == 0)
                    return "Бюджетная";
                else return "Платная";
            case 8:
                return student.getAddress();
            case 9:
                return student.getLogin();
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

    public void addRow(Student student){
        students.add(student);
    }
}