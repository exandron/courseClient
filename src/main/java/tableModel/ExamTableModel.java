package tableModel;

import model.Exam;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExamTableModel implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Exam> exams;


    public ExamTableModel(List<Exam> exams){
        this.exams = exams;
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
        return exams.size();
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
                return "Оценка";
            case 2:
                return "Дата экзамена";
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
        Exam exam = exams.get(rowIndex);
        switch (columnIndex){
            case 0:
//                return visit.getDate();
                return exam.getSubject();
            case 1:
 //               return visit.getTime();
                return exam.getGrade();
            case 2:
 //               return visit.getRegistrationDate();
                return exam.getDate();
            case 3:
 //               return getSurname(visit);
                return exam.getTeacher();
            case 4:
 //               return visit.getComment();
                return exam.getSemester();
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
