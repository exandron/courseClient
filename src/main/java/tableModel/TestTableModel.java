package tableModel;

import model.Test;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class TestTableModel implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Test> tests;


    public TestTableModel(List<Test> tests){
        this.tests = tests;
    }

//    public String getSurname(Visits visit){
//        for (int i = 0; i < clients.size(); i++) {
//            if (visit.getClient_id() == clients.get(i).getId()) {
//                return clients.get(i).getSurname();
//            }
//        }
//        return "";
//    }



    @Override
    public int getRowCount() {
        return tests.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Предмет";
            case 1:
                return "Сдан/не сдан";
            case 2:
                return "Дата зачета";
            case 3:
                return "Преподаватель";
            case 4:
                return "Семестр";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return String.class;
            case 1: return Integer.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return Integer.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Test test = tests.get(rowIndex);
        switch (columnIndex){
            case 0:
//                return visit.getDate();
                return test.getSubject();
            case 1:
                return test.getDate();
            case 2:
                return test.getDate();
            case 3:
                return test.getTeacher();
            case 4:
                return test.getSemester();
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

}
