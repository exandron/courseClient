package view;

import model.*;
import tableModel.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentFrame extends JFrame {
    private JPanel mainPanel;
    private JButton closeFrameButton;
    private JTextField mySurnameField;
    private JTextField myNameField;
    private JTextField myLastnameField;
    private JTextField myPhoneField;
    private JTextField myEmailField;
    private JTextField myLoginField;
    private JPasswordField myPasswordField1;
    private JTextField myFOEField;
    private JTextField myAddressField;
    private JTextField myDOBField;
    private JTextField myGroupField;
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
    private JTextField amountOfStateStudentsField;
    private JTextField amountOfPayersStudentsField;
    private JTextField myScholarshipField;
    private JButton printCheckButton;

    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    Map<Teacher, List<Subject>> teacherSubjectMap = new HashMap<>();

    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<SubjectTeacher> subjectsTeachers = new ArrayList<>();

    private ArrayList<Exam> exams = new ArrayList<>();
    private ArrayList<Exam> myExams = new ArrayList<>();

    private ArrayList<Test> tests = new ArrayList<>();
    private ArrayList<Test> myTests = new ArrayList<>();
    private ArrayList<Student> myGroupmates = new ArrayList<>();
    private ArrayList<Subject> subjectClicked = new ArrayList<>();
    private ObjectOutputStream output = MainFrame.output;
    private ObjectInputStream input = MainFrame.input;
    //    private ArrayList<Visits> visits = new ArrayList<>();
//    private ArrayList<Client> clients = new ArrayList<>();
// Создаем объект DefaultTableCellRenderer
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    private int USER_ID;
    private int student_id;
    private int group_id;

    //-------------------------------ИНИЦИАЛИЗАЦИЯ ФРЕЙМА-------------------------------


    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Студент");
        setContentPane(mainPanel);
        setResizable(false);
        readData();
        calculateAmountOfStudents();
        //calculateMyScholarship();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        TableModel groupmatesModel = new GroupmatesTableModel(myGroupmates);
        myGroupmatesTable.setModel(groupmatesModel);
        for (int columnIndex = 0; columnIndex < myGroupmatesTable.getColumnCount(); columnIndex++) {
            myGroupmatesTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        teachersStudentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                subjectTeacherTableMouseClickedActionPerformed();
            }
        });
        printCheckButton.addActionListener(e -> printCheckButtonActionPerformed());
        pack();
        setLocationRelativeTo(null);
    }


    //-------------------------------КОНСТРУКТОР ФРЕЙМА-------------------------------


    public StudentFrame(int user_id) {
        this.USER_ID = user_id;
        initComponents();
        closeFrameButton.addActionListener(e -> closeFrameActionPerformed());
//        statsButton.addActionListener(e -> statsButtonActionPerformed());
        semesterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsOfExamsMouseClickedActionPerformed();
                resultsOfTestsMouseClickedActionPerformed();
                calculateMyScholarship();
            }
        });
    }

    //-------------------------------ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ-------------------------------


    public void readData() {
        try {
            output.writeObject("getAllStudents");
            this.students = (ArrayList<Student>) input.readObject();
            for (int i = 0; i < students.size(); i++) {
                if (USER_ID == students.get(i).getUserId()) {
                    Student student = students.get(i);
                    mySurnameField.setText(student.getSurname());
                    myNameField.setText(student.getName());
                    myLastnameField.setText(student.getPatronymic());
                    myPhoneField.setText(student.getPhone());
                    myEmailField.setText(student.getEmail());
                    myLoginField.setText(student.getLogin());
                    myPasswordField1.setText(student.getPassword());
                    if (student.getFormOfEducation() == 0) {
                        myFOEField.setText("Бюджетная");
                    } else {
                        myFOEField.setText("Платная");
                    }
                    myDOBField.setText(String.valueOf(student.getDOB()));
                    myAddressField.setText(student.getAddress());
                    myGroupField.setText(String.valueOf(student.getNumberOfGroup()));
                    mySpecialityField.setText(student.getSpecialityName());
                    myFacultyField.setText(student.getFacultyName());
                    student_id = student.getId();
                    group_id = student.getGroupId();
                }
            }

            output.writeObject("getAllTeachers");
            this.teachers = (ArrayList<Teacher>) input.readObject();

            for (int i = 0; i < students.size(); i++) {
                if (group_id == students.get(i).getGroupId()) {
                    myGroupmates.add(students.get(i));
                }
            }

            TeachersStudentTableModel tableModel = new TeachersStudentTableModel(teachers);
            teachersStudentTable.setModel(tableModel);

            // Применяем центрирование ко всем ячейкам таблицы
            for (int columnIndex = 0; columnIndex < teachersStudentTable.getColumnCount(); columnIndex++) {
                teachersStudentTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void calculateAmountOfStudents() {
        int amountOfStateStudents = 0;
        int amountOfPayersStudents = 0;
        for (int i = 0; i < myGroupmates.size(); i++) {
            if (myGroupmates.get(i).getFormOfEducation() == 0) {
                amountOfStateStudents++;
            }
            if (myGroupmates.get(i).getFormOfEducation() == 1) {
                amountOfPayersStudents++;
            }
        }
        amountOfStateStudentsField.setText(String.valueOf(amountOfStateStudents));
        amountOfPayersStudentsField.setText(String.valueOf(amountOfPayersStudents));
    }

    //-------------------------------ФУНКЦИИ-СЛУШАТЕЛИ-------------------------------
    private void resultsOfExamsMouseClickedActionPerformed() {
        try {
            String selectedValueString = (String) semesterComboBox.getSelectedItem();
            int selectedValue = 0;
            selectedValue = Integer.parseInt(selectedValueString);
            Exam exam = new Exam();
            exam.setSemester(selectedValue);
            output.writeObject("getAllExams");
            output.writeObject(exam);
            this.exams = (ArrayList<Exam>) input.readObject();
            myExams.clear();
            double sum = 0;
            for (int i = 0; i < exams.size(); i++) {
                if (student_id == exams.get(i).getStudentId()) {
                    myExams.add(exams.get(i));
                    sum += myExams.get(i).getGrade();
                }
            }
            double averageGrade = sum / myExams.size();
            if (String.valueOf(averageGrade) == "NaN") {
                averageGradeField.setText("Нет оценок за семестр");
            } else {
                averageGradeField.setText(String.valueOf(averageGrade));
            }
            TableModel examsModel = new ExamTableModel(myExams);
            resultsOfExams.setModel(examsModel);
            //resultsOfExams.setDefaultRenderer(Integer.class, new CenteredTextRenderer());
            for (int columnIndex = 0; columnIndex < resultsOfExams.getColumnCount(); columnIndex++) {
                resultsOfExams.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resultsOfTestsMouseClickedActionPerformed() {
        try {
            String selectedValueString = (String) semesterComboBox.getSelectedItem();
            int selectedValue = 0;
            selectedValue = Integer.parseInt(selectedValueString);
            Test test = new Test();
            test.setSemester(selectedValue);
            output.writeObject("getAllTests");
            output.writeObject(test);
            this.tests = (ArrayList<Test>) input.readObject();
            myTests.clear();
            for (int i = 0; i < tests.size(); i++) {
                if (student_id == tests.get(i).getStudentId()) {
                    myTests.add(tests.get(i));
                }
            }
            TableModel testsModel = new TestTableModel(myTests);
            resultsOfTests.setModel(testsModel);
            //resultsOfTests.setDefaultRenderer(Integer.class, new CenteredTextRenderer());
            for (int columnIndex = 0; columnIndex < resultsOfTests.getColumnCount(); columnIndex++) {
                resultsOfTests.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void calculateMyScholarship() {
        try {
            myScholarshipField.setText("");
            double averageGrade;
            double sum = 0;
            double amount = 0;
            amount = myExams.size();
            if (myFOEField.getText().equals("Бюджетная")) {
                for (int i = 0; i < myExams.size(); i++) {
                    sum += myExams.get(i).getGrade();
                }
                averageGrade = sum / amount;
                for (int i = 0; i < myTests.size(); i++) {
                    if (myTests.get(i).isPassed().equals("Не сдан")) {
                        myScholarshipField.setText("Вы не сдали все зачеты!");
                        return;
                    } else {
                        if (averageGrade <= 5) {
                            myScholarshipField.setText("Средний балл ниже 5, вы лишаетесь стипендии!");
                        } else if (averageGrade > 5 && averageGrade <= 6) {
                            myScholarshipField.setText("110.50 р.");
                        } else if (averageGrade > 6 && averageGrade <= 8) {
                            myScholarshipField.setText("130.50 р.");
                        } else if (averageGrade > 8 && averageGrade <= 9) {
                            myScholarshipField.setText("150.50 р.");
                        } else if (averageGrade > 9 && averageGrade <= 10) {
                            myScholarshipField.setText("180.50 р.");
                        } else {
                            myScholarshipField.setText("");
                        }
                    }
                }
            } else if (myFOEField.getText().equals("Платная")) {
                myScholarshipField.setText("Вы платник. У вас нет стипендии.");
            } else {
                myScholarshipField.setText("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void subjectTeacherTableMouseClickedActionPerformed() {
        try {
            Teacher teacher = teachers.get(teachersStudentTable.getSelectedRow());
            output.writeObject("getAllSubjectTeacher");
            output.writeObject(teacher);
            this.subjects = (ArrayList<Subject>) input.readObject();
            SubjectTableModel tableModel = new SubjectTableModel(subjects);
            subjectsTable.setModel(tableModel);
            for (int columnIndex = 0; columnIndex < subjectsTable.getColumnCount(); columnIndex++) {
                subjectsTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshData() {
        admins.clear();
        users.clear();
        students.clear();
        subjects.clear();
        semesterComboBox.setSelectedIndex(0);
        readData();
        subjects.clear();
        //заблицай
    }

//

    private void closeFrameActionPerformed() {
        new MainFrame().setVisible(true);
        dispose();
    }

    private void printCheckButtonActionPerformed() {
        try {
            String filePath = "D:\\result.txt";
            File file = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false)); // Открыть файл в режиме дозаписи
            writer.write("------Результаты экзаменов------\r\n");
            for (int m = 0; m < myExams.size(); m++) {
                Exam exam = myExams.get(m);
                System.out.println(exam.getSubject());
                output.writeObject("getCheckExam");
                output.writeObject(exam);

                String result = (String) input.readObject();
                String[] message = result.split("#");
                for (int i = 0; i < message.length; i++) {
                    if (message[i] == null) {
                        message[i] = "";
                    }
                }

                writer.write("------Экзамен " + (m+1) + "------\r\n");
                writer.write("Семестр:" + message[3] + "\r\n");
                writer.write("Название предмета:" + message[5] + "\r\n");
                writer.write("Оценка:" + message[8] + "\r\n");
                writer.write("Дата экзамена:" + message[1] + "\r\n");
                writer.write("Фамилия преподавателя:" + message[6] + "\r\n");
                writer.write("--------------------------\r\n");
            }

            writer.write("------Результаты зачетов------\r\n");
            for (int k = 0; k < myTests.size(); k++) {
                Test test = myTests.get(k);
                System.out.println(test.getSubject());
                output.writeObject("getCheckTest");
                output.writeObject(test);

                String result = (String) input.readObject();
                String[] message = result.split("#");
                for (int i = 0; i < message.length; i++) {
                    if (message[i] == null) {
                        message[i] = "";
                    }
                }

                writer.write("------Зачет " + (k+1) + "------\r\n");
                writer.write("Семестр:" + message[3] + "\r\n");
                writer.write("Название предмета:" + message[5] + "\r\n");
                writer.write("Сдан/не сдан:" + message[8] + "\r\n");
                writer.write("Дата зачета:" + message[1] + "\r\n");
                writer.write("Фамилия преподавателя:" + message[6] + "\r\n");
                writer.write("--------------------------\r\n");
            }

            writer.write("--------------------------\r\n");
            writer.write("Средний балл за семестр: " +averageGradeField.getText() +"\r\n");
            writer.write("Размер стипендии за семестр: " +myScholarshipField.getText() +"\r\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Результаты распечатаны в файл на диске D!", "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
//    private void statsButtonActionPerformed(){
//        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(clients.size(), "", "Количество клиентов");
//        dataSet.setValue(visits.size(), "", "Количество записей на будущее время");
//        MainFrame.createGraph(dataSet, "Статистика активности клиентов у текущего врача");
//
