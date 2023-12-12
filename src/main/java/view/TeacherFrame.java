package view;

import model.*;
import tableModel.GroupmatesTableModel;
import tableModel.SubjectTableModel;
import tableModel.TeachersStudentTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TeacherFrame extends JFrame{
    private JPanel mainPanel;
    private JButton closeFrameButton;
    private JTextField mySurnameField;
    private JTextField myNameField;
    private JTextField myLastnameField;
    private JTextField myPhoneField;
    private JTextField myEmailField;
    private JTextField myLoginField;
    private JPasswordField myPasswordField1;
    private JTextField myPostField;
    private JTextField myAddressField;
    private JTextField myDOBField;
    private JTextField myDepartmentField;
    private JTextField mySpecialityField;
    private JTextField myFacultyField;
    private JTabbedPane tabbedPane1;
    private JTable resultsOfExams;
    private JTable resultsOfTests;
    private JTable myGroupmatesTable;
    private JComboBox semesterComboBox;
    private JTextField averageGradeField;
    private JTable teachersStudentTable;
    private JTable subjectsTable;
    private JComboBox groupExamComboBox;
    private JTextField subjectNameField;
    private JTable studentsExamTable;
    private JTable mySubjectsExamTable;
    private JComboBox gradeExamComboBox;
    private JTextField dateExamField;
    private JComboBox semesterExamComboBox;
    private JButton examButton;
    private JTextField studentIDField;
    private JTextField amountOfStateStudentsField;
    private JTextField amountOfPayersStudentsField;
    private JTextField myScholarshipField;

    private SubjectTeacher selectedSubjectTeacher = new SubjectTeacher();
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private DefaultComboBoxModel<String> groupExamComboBoxModel = new DefaultComboBoxModel<>();
    private ArrayList<Group> groups = new ArrayList<>();

    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Subject> mySubjects = new ArrayList<>();

    private ArrayList<Exam> exams = new ArrayList<>();
    private ArrayList<Exam> myExams = new ArrayList<>();

    private ArrayList<Test> tests = new ArrayList<>();
    private ArrayList<Test> myTests = new ArrayList<>();
    private ArrayList<Student> examStudents = new ArrayList<>();
    private ArrayList<Subject> subjectClicked = new ArrayList<>();
    private ObjectOutputStream output = MainFrame.output;
    private ObjectInputStream input = MainFrame.input;
//    private ArrayList<Visits> visits = new ArrayList<>();
//    private ArrayList<Client> clients = new ArrayList<>();
// Создаем объект DefaultTableCellRenderer
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    private int USER_ID;
    private int teacher_id;
    private int group_id;

    //-------------------------------ИНИЦИАЛИЗАЦИЯ ФРЕЙМА-------------------------------


    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Преподаватель");
        setContentPane(mainPanel);
        setResizable(false);
        readData();
        //calculateMyScholarship();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        groupExamComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                groupExamTableMouseClickedActionPerformed();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }


    //-------------------------------КОНСТРУКТОР ФРЕЙМА-------------------------------


    public TeacherFrame(int user_id) {
        this.USER_ID = user_id;
        initComponents();
        closeFrameButton.addActionListener(e -> closeFrameActionPerformed());
//        statsButton.addActionListener(e -> statsButtonActionPerformed());
        groupExamComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupExamTableMouseClickedActionPerformed();
            }
        });
        mySubjectsExamTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                subjectExamTableMouseClickedActionPerformed();
            }
        });
        studentsExamTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                studentIDExamTableMouseClickedActionPerformed();
            }
        });

        teachersStudentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                subjectTeacherTableMouseClickedActionPerformed();
            }
        });

        examButton.addActionListener(e -> addNewExamButtonActionPerformed());

    }

    //-------------------------------ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ-------------------------------


    public void readData(){
        try {
            output.writeObject("getAllTeachers");
            this.teachers = (ArrayList<Teacher>) input.readObject();
            for (int i = 0; i < teachers.size(); i++) {
                if (USER_ID == teachers.get(i).getUserId()) {
                    Teacher teacher = teachers.get(i);
                    mySurnameField.setText(teacher.getSurname());
                    myNameField.setText(teacher.getName());
                    myLastnameField.setText(teacher.getPatronymic());
                    myPhoneField.setText(teacher.getPhone());
                    myEmailField.setText(teacher.getEmail());
                    myLoginField.setText(teacher.getLogin());
                    myPasswordField1.setText(teacher.getPassword());
                    myPostField.setText(teacher.getPost());
                    myDepartmentField.setText(teacher.getDepartment());
                    teacher_id = teacher.getId();
                    output.writeObject("getAllSubjectTeacher");
                    output.writeObject(teacher);
                    this.mySubjects = (ArrayList<Subject>) input.readObject();
                }
            }

            output.writeObject("getAllGroups");
            this.groups = (ArrayList<Group>) input.readObject();
            groupExamComboBox.removeAllItems();
            for(int i = 0; i < groups.size(); i++){
                Group group = groups.get(i);
                int groupNumber = group.getNumberOfGroup();
                String groupNumberString = String.valueOf(groupNumber);
                groupExamComboBoxModel.addElement(groupNumberString);
            }
            groupExamComboBox.setModel(groupExamComboBoxModel);

            SubjectTableModel tableModel1 = new SubjectTableModel(mySubjects);
            mySubjectsExamTable.setModel(tableModel1);
            for (int columnIndex = 0; columnIndex < mySubjectsExamTable.getColumnCount(); columnIndex++) {
                mySubjectsExamTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }

            TeachersStudentTableModel tableModel = new TeachersStudentTableModel(teachers);
            teachersStudentTable.setModel(tableModel);

            // Применяем центрирование ко всем ячейкам таблицы
            for (int columnIndex = 0; columnIndex < teachersStudentTable.getColumnCount(); columnIndex++) {
                teachersStudentTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    //-------------------------------ФУНКЦИИ-СЛУШАТЕЛИ-------------------------------


    private void subjectTeacherTableMouseClickedActionPerformed() {
        try{
            Teacher teacher = teachers.get(teachersStudentTable.getSelectedRow());
                output.writeObject("getAllSubjectTeacher");
                output.writeObject(teacher);
                this.subjects = (ArrayList<Subject>) input.readObject();
                SubjectTableModel tableModel = new SubjectTableModel(subjects);
                subjectsTable.setModel(tableModel);
            for (int columnIndex = 0; columnIndex < subjectsTable.getColumnCount(); columnIndex++) {
                subjectsTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }
        }
        catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
    }

    public void refreshData(){
        admins.clear();
        users.clear();
        students.clear();
        subjects.clear();
        groups.clear();
        mySubjects.clear();
        examStudents.clear();
        readData();
    }

//

    private void closeFrameActionPerformed(){
        new MainFrame().setVisible(true);
        dispose();
    }

    private void groupExamTableMouseClickedActionPerformed(){
        try{
            Object selectedItem = groupExamComboBox.getSelectedItem();
            if (selectedItem != null) {
                String selectedValueString = (String) groupExamComboBox.getSelectedItem();

                int selectedValue = Integer.parseInt(selectedValueString);

                Student student = new Student();
                student.setNumberOfGroup(selectedValue);
                output.writeObject("findStudentsByGroupNumber");
                output.writeObject(student);
                this.examStudents = (ArrayList<Student>) input.readObject();
                TableModel groupmatesModel = new GroupmatesTableModel(examStudents);
                studentsExamTable.setModel(groupmatesModel);
                for (int columnIndex = 0; columnIndex < studentsExamTable.getColumnCount(); columnIndex++) {
                    studentsExamTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
                }
                //group_id = selectedGroup.getGroupId();
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void subjectExamTableMouseClickedActionPerformed() {
        try{
        Subject subject = mySubjects.get(mySubjectsExamTable.getSelectedRow());
        subjectNameField.setText(subject.getSubjectName());
        SubjectTeacher subjectTeacher = new SubjectTeacher();
        subjectTeacher.setSubjectId(subject.getSubjectId());
        subjectTeacher.setId(teacher_id);
        output.writeObject("getSubjectTeacher");
        output.writeObject(subjectTeacher);
        this.selectedSubjectTeacher = (SubjectTeacher) input.readObject();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void studentIDExamTableMouseClickedActionPerformed(){
        Student student = examStudents.get(studentsExamTable.getSelectedRow());
        studentIDField.setText(String.valueOf(student.getId()));
    }



    private void addNewExamButtonActionPerformed(){
        try{
            Exam exam = new Exam();
            String dateRegex = "\\d{4}-\\d{2}-\\d{2}"; // Регулярное выражение для формата год-месяц-день
            String inputDate = dateExamField.getText();

            if (inputDate.matches(dateRegex)) {
                String[] dateParts = inputDate.split("-");
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);

                if (month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >=  1) {
                    exam.setDate(inputDate);
                } else {
                    JOptionPane.showMessageDialog(null, "Вы не правильно ввели дату экзамена!\nВводите дату в формате (год-месяц-день)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Вы не правильно ввели дату экзамена!\nВводите дату в формате (год-месяц-день)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            exam.setSemester(Integer.parseInt(semesterExamComboBox.getSelectedItem().toString()));
            exam.setSubjectTeacherId(selectedSubjectTeacher.getSubjectTeacherId());
            exam.setGrade(Integer.parseInt(gradeExamComboBox.getSelectedItem().toString()));
            exam.setSubject(subjectNameField.getText());
            exam.setStudentId(Integer.parseInt(studentIDField.getText()));
            output.writeObject("insertExamResult");
            output.writeObject(exam);
            String result = (String) input.readObject();
            JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
//    private void statsButtonActionPerformed(){
//        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(clients.size(), "", "Количество клиентов");
//        dataSet.setValue(visits.size(), "", "Количество записей на будущее время");
//        MainFrame.createGraph(dataSet, "Статистика активности клиентов у текущего врача");
//    }
}
