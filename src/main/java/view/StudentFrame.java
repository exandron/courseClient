package view;

import model.*;
import tableModel.CenteredTextRenderer;
import tableModel.ExamTableModel;
import tableModel.GroupmatesTableModel;
import tableModel.TestTableModel;
//import org.jfree.data.category.DefaultCategoryDataset;
//import tableModel.VisitTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentFrame extends JFrame{
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
    private JTextField myGroupField;
    private JTextField mySpecialityField;
    private JTextField myFacultyField;
    private JTabbedPane tabbedPane1;
    private JTable resultsOfExams;
    private JTable resultsOfTests;
    private JTable myGroupmatesTable;
    private JComboBox semesterComboBox;

    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    private ArrayList<Exam> exams = new ArrayList<>();
    private ArrayList<Exam> myExams = new ArrayList<>();

    private ArrayList<Test> tests = new ArrayList<>();
    private ArrayList<Test> myTests = new ArrayList<>();
    private ArrayList<Student> myGroupmates = new ArrayList<>();
    private ObjectOutputStream output = MainFrame.output;
    private ObjectInputStream input = MainFrame.input;
//    private ArrayList<Visits> visits = new ArrayList<>();
//    private ArrayList<Client> clients = new ArrayList<>();
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
//        TableModel examsModel = new ExamTableModel(myExams);
//        resultsOfExams.setModel(examsModel);
//        resultsOfExams.setDefaultRenderer(Integer.class, new CenteredTextRenderer());

//        TableModel testsModel = new TestTableModel(myTests);
//        resultsOfTests.setModel(testsModel);
//        resultsOfTests.setDefaultRenderer(Integer.class, new CenteredTextRenderer());

        TableModel groupmatesModel = new GroupmatesTableModel(myGroupmates);
        myGroupmatesTable.setModel(groupmatesModel);
        myGroupmatesTable.setDefaultRenderer(Integer.class, new CenteredTextRenderer());

        pack();
        setLocationRelativeTo(null);
    }


    //-------------------------------КОНСТРУКТОР ФРЕЙМА-------------------------------


    public StudentFrame(int user_id) {
        this.USER_ID = user_id;
        initComponents();
//        editMyPersonalDataButton.addActionListener(e -> editMyPersonalDataActionPerformed());
//        editMyAuthorizationDataButton.addActionListener(e -> editMyAuthorizationDataActionPerformed());
        closeFrameButton.addActionListener(e -> closeFrameActionPerformed());
//        statsButton.addActionListener(e -> statsButtonActionPerformed());
        semesterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsOfExamsMouseClickedActionPerformed();
                resultsOfTestsMouseClickedActionPerformed();
            }
        });
    }

    //-------------------------------ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ-------------------------------


    public void readData(){
        try{
            output.writeObject("getAllStudents");
            this.students = (ArrayList<Student>) input.readObject();
            for(int i = 0; i < students.size(); i++){
                if(USER_ID == students.get(i).getUserId()){
                    Student student = students.get(i);
                    mySurnameField.setText(student.getSurname());
                    myNameField.setText(student.getName());
                    myLastnameField.setText(student.getPatronymic());
                    myPhoneField.setText(student.getPhone());
                    myEmailField.setText(student.getEmail());
                    myLoginField.setText(student.getLogin());
                    myPasswordField1.setText(student.getPassword());
                    myFOEField.setText(String.valueOf(student.getFormOfEducation()));
                    myAddressField.setText(student.getAddress());
                    myGroupField.setText(String.valueOf(student.getNumberOfGroup()));
                    mySpecialityField.setText(student.getSpecialityName());
                    myFacultyField.setText(student.getFacultyName());
                    student_id = student.getId();
                    group_id = student.getGroupId();
                }
            }
            System.out.println(student_id);
//            output.writeObject("getAllUsers");
//            this.users = (ArrayList<User>) input.readObject();
//            output.writeObject("getAllAdmins");
//            this.admins = (ArrayList<Admin>) input.readObject();
//            output.writeObject("getAllVisits");
//            this.visits = (ArrayList<Visits>) input.readObject();


            output.writeObject("getAllTeachers");
            this.teachers = (ArrayList<Teacher>) input.readObject();
//            output.writeObject("getAllExams");
//            this.exams = (ArrayList<Exam>) input.readObject();
//            for(int i = 0; i < exams.size(); i++){
//                if(student_id == exams.get(i).getStudentId()){
//                    myExams.add(exams.get(i));
//                }
//            }

//            output.writeObject("getAllTests");
//            this.tests = (ArrayList<Test>) input.readObject();
//            for(int i = 0; i < tests.size(); i++){
//                if(student_id == tests.get(i).getStudentId()){
//                    myTests.add(tests.get(i));
//                }
//            }

            for(int i = 0; i < students.size(); i++){
                if(group_id == students.get(i).getGroupId()){
                    myGroupmates.add(students.get(i));
                }
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }


    //-------------------------------ФУНКЦИИ-СЛУШАТЕЛИ-------------------------------
    private void resultsOfExamsMouseClickedActionPerformed(){
        try{
        String selectedValueString = (String) semesterComboBox.getSelectedItem();
        int selectedValue = 0;
        selectedValue = Integer.parseInt(selectedValueString);
        Exam exam = new Exam();
        exam.setSemester(selectedValue);
        output.writeObject("getAllExams");
        output.writeObject(exam);
            this.exams = (ArrayList<Exam>) input.readObject();

            myExams.clear();

            for(int i = 0; i < exams.size(); i++){
                if(student_id == exams.get(i).getStudentId()){
                    myExams.add(exams.get(i));
                }
            }
            TableModel examsModel = new ExamTableModel(myExams);
            resultsOfExams.setModel(examsModel);
            resultsOfExams.setDefaultRenderer(Integer.class, new CenteredTextRenderer());
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resultsOfTestsMouseClickedActionPerformed(){
        try{
            String selectedValueString = (String) semesterComboBox.getSelectedItem();
            int selectedValue = 0;
            selectedValue = Integer.parseInt(selectedValueString);
            Test test = new Test();
            test.setSemester(selectedValue);
            output.writeObject("getAllTests");
            output.writeObject(test);
            this.tests = (ArrayList<Test>) input.readObject();

            myTests.clear();

            for(int i = 0; i < tests.size(); i++){
                if(student_id == tests.get(i).getStudentId()){
                    myTests.add(tests.get(i));
                }
            }
            TableModel testsModel = new TestTableModel(myTests);
            resultsOfTests.setModel(testsModel);
            resultsOfTests.setDefaultRenderer(Integer.class, new CenteredTextRenderer());
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

//    private Boolean checkLogin(String login) {
//        if (login.equals("")) {
//            JOptionPane.showMessageDialog(null, "Вы не ввели логин!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            return false;
//        } else if (login.length() <= 4 || login.length() >= 15) {
//            JOptionPane.showMessageDialog(null, "Логин должен быть больше 4 и меньше 15 символов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            return false;
//        } else {
//            for (int i = 0; i < admins.size(); i++) {
//                if (login.equals(admins.get(i).getLogin())) {
//                    JOptionPane.showMessageDialog(null, "Данный логин уже есть в системе!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//            for (int i = 0; i < users.size(); i++) {
//                if (login.equals(users.get(i).getLogin())) {
//                    JOptionPane.showMessageDialog(null, "Данный логин уже есть в системе!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//            for (int i = 0; i < doctors.size(); i++) {
//                if (login.equals(doctors.get(i).getLogin())) {
//                    JOptionPane.showMessageDialog(null, "Данный логин уже есть в системе!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    private Boolean checkPassword(String password, String provePassword) {
//        if(password.equals("") || provePassword.equals("")) {
//            JOptionPane.showMessageDialog(null, "Вы не ввели пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        else if(password.length() <= 4 || password.length() >= 15) {
//            JOptionPane.showMessageDialog(null, "Пароль должен быть больше 4 и меньше 15 символов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        else if(!password.equals(provePassword)){
//            JOptionPane.showMessageDialog(null, "Пароль и его подтверждение не совпадают!", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        else return true;
//    }
//
////    private void editMyPersonalDataActionPerformed(){
////        if(mySurnameField.isEditable()) {
////            try {
////                User user = new User();
////                user.setId(USER_ID);
////                user.setSurname(mySurnameField.getText());
////                user.setName(myNameField.getText());
////                user.setLastname(myLastnameField.getText());
////                user.setPhone(myPhoneField.getText());
////                output.writeObject("updatePerson");
////                output.writeObject(user);
////                String result = (String) input.readObject();
////                JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
////                if (result.equals("Успешно сохранено!")) {
////                    for (int i = 0; i < doctors.size(); i++) {
////                        if (USER_ID == doctors.get(i).getUserId()) {
////                            Doctor doctor = doctors.get(i);
////                            doctor.setSurname(user.getSurname());
////                            doctor.setName(user.getName());
////                            doctor.setLastname(user.getLastname());
////                            doctor.setPhone(user.getPhone());
////                            doctors.set(i, doctor);
////                        }
////                    }
////                }
////            } catch (Exception ex) {
////                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
////            }
////            mySurnameField.setEditable(false);
////            myNameField.setEditable(false);
////            myLastnameField.setEditable(false);
////            myPhoneField.setEditable(false);
////            editMyPersonalDataButton.setText("Редактировать личные данные");
////        }
////        else{
////            mySurnameField.setEditable(true);
////            myNameField.setEditable(true);
////            myLastnameField.setEditable(true);
////            myPhoneField.setEditable(true);
////            editMyPersonalDataButton.setText("Сохранить");
////        }
////    }

    public void refreshData(){
        admins.clear();
        users.clear();
        students.clear();
        semesterComboBox.setSelectedIndex(0);
        readData();
        //заблица
    }

//    private void editMyAuthorizationDataActionPerformed(){
//        if(myLoginField.isEditable()){
//            if(!checkLogin(myLoginField.getText())) return;
//            if(!checkPassword(myPasswordField1.getText(), myPasswordField2.getText())) return;
//            try{
//                ObjectOutputStream output = MainFrame.output;
//                ObjectInputStream input = MainFrame.input;
//                User user = new User();
//                user.setId(USER_ID);
//                user.setLogin(myLoginField.getText());
//                user.setPassword(myPasswordField1.getText());
//                user.setWork_phone(myWorkPhoneField.getText());
//                output.writeObject("updateMyUserData");
//                output.writeObject(user);
//                String result = (String) input.readObject();
//                JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
//                if (result.equals("Успешно сохранено!")) {
//                    for (int i = 0; i < doctors.size(); i++) {
//                        if (USER_ID == doctors.get(i).getUserId()) {
//                            Doctor doctor = doctors.get(i);
//                            doctor.setLogin(user.getLogin());
//                            doctor.setWork_phone(user.getWork_phone());
//                            doctors.set(i, doctor);
//                        }
//                    }
//                }
//            }
//            catch (Exception ex){
//                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
//            }
//            myLoginField.setEditable(false);
//            myPasswordField1.setEditable(false);
//            myPasswordField2.setEditable(false);
//            myWorkPhoneField.setEditable(false);
//            editMyAuthorizationDataButton.setText("Редактировать данные авторизации");
//        }
//        else{
//            myLoginField.setEditable(true);
//            myPasswordField1.setEditable(true);
//            myPasswordField2.setEditable(true);
//            myWorkPhoneField.setEditable(true);
//            editMyAuthorizationDataButton.setText("Сохранить");
//        }
//    }

    private void closeFrameActionPerformed(){
        new MainFrame().setVisible(true);
        dispose();
    }

//    private void statsButtonActionPerformed(){
//        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(clients.size(), "", "Количество клиентов");
//        dataSet.setValue(visits.size(), "", "Количество записей на будущее время");
//        MainFrame.createGraph(dataSet, "Статистика активности клиентов у текущего врача");
//    }
}
