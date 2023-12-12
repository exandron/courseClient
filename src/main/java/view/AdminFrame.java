package view;

import model.*;
//import model.Doctor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import tableModel.*;
//import org.jfree.data.category.DefaultCategoryDataset;
//import tableModel.AdminTableModel;
//import tableModel.DoctorTableModel;
//import tableModel.UserTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminFrame extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane Admin;
    private JButton closeFrameButton;
    private JTextField mySurnameField;
    private JTextField myNameField;
    private JTextField myLastnameField;
    private JTextField myEmailField;
    private JButton editMyPersonalDataButton;
    private JTextField myLoginField;
    private JPasswordField myPasswordField1;
    private JPasswordField myPasswordField2;
    private JButton editMyAuthorizationDataButton;
    private JTable tableAdmins;
    private JTabbedPane tabbedPane1;
    private JTable tableTeachers;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTextField myPhoneField;
    private JButton addNewAdminButton;
    private JButton clearNewAdminFormButton;
    private JTextField newAdminLoginField;
    private JPasswordField newAdminPasswordField1;
    private JPasswordField newAdminPasswordField2;
    private JComboBox newAdminRightsComboBox;
    private JComboBox newAdminBlockComboBox;
    private JTextField newAdminSurnameField;
    private JTextField newAdminNameField;
    private JTextField newAdminLastnameField;
    private JTextField newAdminPhoneField;
    private JTextField newAdminEmailField;
    private JCheckBox deleteAdminCheckBox;
    private JButton deleteAdminButton;
    private JTextField editAdminLoginField;
    private JTextField editAdminSurnameField;
    private JTextField editAdminNameField;
    private JTextField editAdminLastnameField;
    private JTextField editAdminPhoneField;
    private JTextField editAdminEmailField;
    private JButton editAdminButton;
    private JPasswordField editAdminPasswordField1;
    private JPasswordField editAdminPasswordField2;
    private JButton editAdminPasswordButton;
    private JTextField newTeacherLoginField;
    private JButton clearNewTeacherFormButton;
    private JTextField editTeacherLoginField;
    private JTextField editTeacherSurnameField;
    private JTextField editTeacherNameField;
    private JTextField editTeacherLastnameField;
    private JTextField editTeacherPhoneField;
    private JTextField editTeacherEmailField;
    private JButton editTeacherButton;
    private JPasswordField editTeacherPasswordField1;
    private JPasswordField editTeacherPasswordField2;
    private JButton editTeacherPasswordButton;
    private JTable tableStudents;
    private JCheckBox deleteTeacherCheckBox;
    private JButton deleteTeacherButton;
    private JButton addNewStudentButton;
    private JButton clearNewStudentFormButton;
    private JTextField newStudentSurnameField;
    private JTextField newStudentNameField;
    private JTextField newStudentPatronymicField;
    private JTextField newStudentLoginField;
    private JPasswordField newStudentPasswordField1;
    private JPasswordField newStudentPasswordField2;
    private JTextField newStudentDOBField;
    private JTextField newStudentEmailField;

    private JTextField newStudentPhoneField;
    private JButton editStudentButton;
    private JTextField editStudentLoginField;
    private JTextField editStudentDOBField;
    private JTextField editStudentSurnameField;
    private JTextField editStudentNameField;
    private JTextField editStudentLastnameField;
    private JTextField editStudentPhoneField;
    private JTextField editStudentEmailField;
    private JPasswordField editStudentPasswordField1;
    private JPasswordField editStudentPasswordField2;
    private JButton editStudentPasswordButton;
    private JCheckBox deleteStudentCheckBox;
    private JButton deleteStudentButton;
    private JTextField myRightsField;
    private JTextField myBlockField;
    private JComboBox editAdminRightsComboBox;
    private JComboBox editAdminBlockComboBox;

    private JComboBox newStudentFOEComboBox;
    private JTextField newStudentFacultyField;
    private JTextField newStudentSpecialityField;
    private JTextField newStudentAddressField;
    private JComboBox newStudentGroupComboBox;
    private JTextField editStudentAddressField;
    private JComboBox editStudentGroupComboBox;
    private JTextField editStudentSpecialityField;
    private JTextField editStudentFacultyField;
    private JComboBox editStudentFOEComboBox;
    private JTabbedPane tabbedPane4;
    private JTable tableSubjects;
    private JButton addNewTeacherButton;
    private JTextField newTeacherNameField;
    private JTextField newTeacherLastnameField;
    private JTextField newTeacherPhoneField;
    private JTextField newTeacherSurnameField;
    private JTextField newTeacherEmailField;
    private JComboBox newTeacherPostComboBox;
    private JComboBox newTeacherDepartmentComboBox;
    private JPasswordField newTeacherPasswordField1;
    private JPasswordField newTeacherPasswordField2;
    private JComboBox editTeacherPostComboBox;
    private JComboBox editTeacherDepartmentComboBox;
    private JTable tableGroups;
    private JTextField newSubjectNameField;
    private JTextField editSubjectNameField;
    private JButton deleteSubjectButton;
    private JButton editSubjectButton;
    private JButton addSubjectButton;
    private JButton clearSubjectButton;
    private JCheckBox deleteSubjectCheckBox;
    private JTextField newGroupNumberField;
    private JComboBox newGroupSpecialityComboBox;
    private JTextField newGroupFacultyField;
    private JTextField editGroupNumberField;
    private JComboBox editGroupSpecialityComboBox;
    private JTextField editGroupFacultyField;
    private JButton addGroupButton;
    private JButton clearGroupButton;
    private JButton editGroupButton;
    private JButton deleteGroupButton;
    private JCheckBox deleteGroupCheckBox;
    private JButton statsAdminBlockButton;
    private JButton statsAdminRightsButton;
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<Speciality> specialities = new ArrayList<>();

    private ArrayList<Subject> subjects = new ArrayList<>();
    private DefaultComboBoxModel<String> newGroupComboBoxModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> newGroupSpecialityBoxModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> editGroupComboBoxModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> editGroupSpecialityBoxModel = new DefaultComboBoxModel<>();
    private Group selectedGroup = new Group();
    private Speciality selectedSpeciality = new Speciality();
    private int group_id;
    private ObjectOutputStream output = MainFrame.output;
    private ObjectInputStream input = MainFrame.input;
    private int USER_ID;
    private String rights;
    private String block;

    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();


    //-------------------------------ИНИЦИАЛИЗАЦИЯ ФРЕЙМА-------------------------------


    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Администратор");
        setContentPane(mainPanel);
        setResizable(false);
        readData();

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        TableModel adminsModel = new AdminTableModel(admins);
        tableAdmins.setModel(adminsModel);
        tableAdmins.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        TableModel teachersModel = new TeacherTableModel(teachers);
        tableTeachers.setModel(teachersModel);
        tableTeachers.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        TableModel studentsModel = new StudentTableModel(students);
        tableStudents.setModel(studentsModel);
        tableStudents.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        TableModel subjectsModel = new SubjectTableModel(subjects);
        tableSubjects.setModel(subjectsModel);
        tableSubjects.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        for (int columnIndex = 0; columnIndex < tableSubjects.getColumnCount(); columnIndex++) {
            tableSubjects.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        TableModel groupsModel = new GroupsTableModel(groups);
        tableGroups.setModel(groupsModel);
        tableGroups.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        for (int columnIndex = 0; columnIndex < tableGroups.getColumnCount(); columnIndex++) {
            tableGroups.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        pack();
        setLocationRelativeTo(null);
        for (int i = 0; i < admins.size(); i++) {
            if (USER_ID == admins.get(i).getUserId()) {
                rights = admins.get(i).getRights();
                block = admins.get(i).getBlock();
            }
        }
    }


    //-------------------------------КОНСТРУКТОР ФРЕЙМА-------------------------------


    public AdminFrame(int user_id){
        this.USER_ID = user_id;
        initComponents();

        closeFrameButton.addActionListener(e -> closeFrameActionPerformed());
        editMyPersonalDataButton.addActionListener(e -> editMyPersonalDataActionPerformed());
        editMyAuthorizationDataButton.addActionListener(e -> editMyAuthorizationDataActionPerformed());
        tableAdmins.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableAdminsMouseClickedActionPerformed();
            }
        });
        addNewAdminButton.addActionListener(e -> addNewAdminActionPerformed());
        clearNewAdminFormButton.addActionListener(e -> clearNewAdminFormActionPerformed());
        deleteAdminButton.addActionListener(e -> deleteAdminActionPerformed());
        editAdminButton.addActionListener(e -> editAdminActionPerformed());
        editAdminPasswordButton.addActionListener(e -> editAdminPasswordActionPerformed());
//        statsAdminBlockButton.addActionListener(e -> statsAdminBlockActionPerformed());
        statsAdminRightsButton.addActionListener(e -> statsAdminRightsActionPerformed());
        clearNewTeacherFormButton.addActionListener(e -> clearNewTeacherFormActionPerformed());
        addNewTeacherButton.addActionListener(e -> addNewTeacherActionPerformed());
        tableTeachers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableTeachersMouseClickedActionPerformed();
            }
        });
        editTeacherPasswordButton.addActionListener(e -> editTeacherPasswordActionPerformed());
        editTeacherButton.addActionListener(e -> editTeacherActionPerformed());
        deleteTeacherButton.addActionListener(e -> deleteTeacherActionPerformed());
        clearNewStudentFormButton.addActionListener(e -> clearNewStudentFormActionPerformed());
        addNewStudentButton.addActionListener(e -> addNewStudentButtonActionPerformed());
        tableStudents.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableStudentsMouseClickedActionPerformed();
            }
        });
        newStudentGroupComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGroupMouseClickedActionPerformed();
            }
        });
        editStudentGroupComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editGroupMouseClickedActionPerformed();
            }
        });
        newGroupSpecialityComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGroupSpecialityMouseClickedActionPerformed();
            }
        });
        editGroupSpecialityComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editGroupSpecialityMouseClickedActionPerformed();
            }
        });
        editStudentButton.addActionListener(e -> editStudentActionPerformed());
        editStudentPasswordButton.addActionListener(e -> editStudentPasswordActionPerformed());

        deleteStudentButton.addActionListener(e -> deleteStudentActionPerformed());
        tableSubjects.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableSubjectsMouseClickedActionPerformed();
            }
        });
        addSubjectButton.addActionListener(e -> addNewSubjectActionPerformed());
        clearSubjectButton.addActionListener(e -> clearNewSubjectFormActionPerformed());
        tableGroups.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableGroupsMouseClickedActionPerformed();
            }
        });
        clearGroupButton.addActionListener(e -> clearNewGroupFormActionPerformed());
        editSubjectButton.addActionListener(e -> editSubjectActionPerformed());
        editGroupButton.addActionListener(e -> editGroupActionPerformed());
        deleteSubjectButton.addActionListener(e -> deleteSubjectActionPerformed());
        deleteGroupButton.addActionListener(e -> deleteGroupActionPerformed());
        addGroupButton.addActionListener(e -> addNewGroupActionPerformed());
        Admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isBlock();
            }
        });
//        tableSubjects.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                tableSubjectsMouseClickedActionPerformed();
//            }
//        });
    }


    //-------------------------------ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ-------------------------------

    private void isBlock(){
        if(block.equals("Да")) {
            JOptionPane.showMessageDialog(null, "Ваша учетная запись заблокирована!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            closeFrameActionPerformed();
        }
    }


    public void readData(){
        try{
            output.writeObject("getAllAdmins");
            this.admins = (ArrayList<Admin>) input.readObject();
            for(int i = 0; i < admins.size(); i++){
                if(USER_ID == admins.get(i).getUserId()){
                    Admin admin = admins.get(i);
                    mySurnameField.setText(admin.getSurname());
                    myNameField.setText(admin.getName());
                    myLastnameField.setText(admin.getPatronymic());
                    myPhoneField.setText(admin.getPhone());
                    myEmailField.setText(admin.getEmail());
                    myLoginField.setText(admin.getLogin());
                    myPasswordField1.setText(admin.getPassword());
                    myPasswordField2.setText(admin.getPassword());
                    myRightsField.setText(admin.getRights());
                    myBlockField.setText(admin.getBlock());
                }
            }
            output.writeObject("getAllTeachers");
            this.teachers = (ArrayList<Teacher>) input.readObject();
            output.writeObject("getAllStudents");
            this.students = (ArrayList<Student>) input.readObject();
            output.writeObject("getAllGroups");
            this.groups = (ArrayList<Group>) input.readObject();
            output.writeObject("getAllSpecialities");
            this.specialities = (ArrayList<Speciality>) input.readObject();
            output.writeObject("getAllSubjects");
            this.subjects = (ArrayList<Subject>) input.readObject();
            newStudentGroupComboBox.removeAllItems();
            for(int i = 0; i < groups.size(); i++){
                Group group = groups.get(i);
                int groupNumber = group.getNumberOfGroup();
                String groupNumberString = String.valueOf(groupNumber);
                newGroupComboBoxModel.addElement(groupNumberString);
            }
            newStudentGroupComboBox.setModel(newGroupComboBoxModel);

            newGroupSpecialityComboBox.removeAllItems();
            for(int i = 0; i < specialities.size(); i++){
                Speciality speciality = specialities.get(i);
                String nameOfSpeciality = speciality.getSpecialityName();
                newGroupSpecialityBoxModel.addElement(nameOfSpeciality);
            }
            newGroupSpecialityComboBox.setModel(newGroupSpecialityBoxModel);

            editStudentGroupComboBox.removeAllItems();
            for(int i = 0; i < groups.size(); i++){
                Group group = groups.get(i);
                int groupNumber = group.getNumberOfGroup();
                String groupNumberString = String.valueOf(groupNumber);
                editGroupComboBoxModel.addElement(groupNumberString);
            }
            editStudentGroupComboBox.setModel(editGroupComboBoxModel);

            editGroupSpecialityComboBox.removeAllItems();
            for(int i = 0; i < specialities.size(); i++){
                Speciality speciality = specialities.get(i);
                String nameOfSpeciality = speciality.getSpecialityName();
                editGroupSpecialityBoxModel.addElement(nameOfSpeciality);
            }
            editGroupSpecialityComboBox.setModel(editGroupSpecialityBoxModel);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshData(){
        admins.clear();
        teachers.clear();
        students.clear();
        subjects.clear();
        groups.clear();
        readData();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        TableModel adminsModel = new AdminTableModel(admins);
        tableAdmins.setModel(adminsModel);
        TableModel teachersModel = new TeacherTableModel(teachers);
        tableTeachers.setModel(teachersModel);
        TableModel studentsModel = new StudentTableModel(students);
        tableStudents.setModel(studentsModel);
        TableModel subjectsModel = new SubjectTableModel(subjects);
        tableSubjects.setModel(subjectsModel);
        for (int columnIndex = 0; columnIndex < tableSubjects.getColumnCount(); columnIndex++) {
            tableSubjects.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        TableModel groupsModel = new GroupsTableModel(groups);
        tableGroups.setModel(groupsModel);
        for (int columnIndex = 0; columnIndex < tableGroups.getColumnCount(); columnIndex++) {
            tableGroups.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
    }

    public void clearEditAndPasswordForm(){
        editAdminLoginField.setText("");
        editAdminRightsComboBox.setSelectedIndex(0);
        editAdminBlockComboBox.setSelectedIndex(0);
        editAdminSurnameField.setText("");
        editAdminNameField.setText("");
        editAdminLastnameField.setText("");
        editAdminPhoneField.setText("");
        editAdminEmailField.setText("");
        editAdminPasswordField1.setText("");
        editAdminPasswordField2.setText("");

        editTeacherLoginField.setText("");
        editTeacherSurnameField.setText("");
        editTeacherNameField.setText("");
        editTeacherLastnameField.setText("");
        editTeacherPhoneField.setText("");
        editTeacherEmailField.setText("");
        editTeacherPasswordField1.setText("");
        editTeacherPasswordField2.setText("");
        editTeacherPostComboBox.setSelectedIndex(0);
        editTeacherDepartmentComboBox.setSelectedIndex(0);

        editStudentLoginField.setText("");
        editStudentFacultyField.setText("");
        editStudentSpecialityField.setText("");
        editStudentDOBField.setText("");
        editStudentAddressField.setText("");
        editStudentSurnameField.setText("");
        editStudentNameField.setText("");
        editStudentLastnameField.setText("");
        editStudentPhoneField.setText("");
        editStudentEmailField.setText("");
        editStudentPasswordField1.setText("");
        editStudentPasswordField2.setText("");
        editStudentGroupComboBox.setSelectedIndex(0);
        editStudentFOEComboBox.setSelectedIndex(0);

        editSubjectNameField.setText("");

        editGroupFacultyField.setText("");
        editGroupFacultyField.setText("");
        editGroupSpecialityComboBox.setSelectedIndex(0);

        deleteAdminCheckBox.setSelected(false);
        deleteStudentCheckBox.setSelected(false);
        deleteTeacherCheckBox.setSelected(false);
        deleteSubjectCheckBox.setSelected(false);
        deleteGroupCheckBox.setSelected(false);
    }

    private Boolean checkLogin(String login) {
        if (login.equals("")) {
            JOptionPane.showMessageDialog(null, "Вы не ввели логин!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (login.length() <= 4 || login.length() >= 15) {
            JOptionPane.showMessageDialog(null, "Логин должен быть больше 4 и меньше 15 символов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            for (int i = 0; i < admins.size(); i++) {
                if (login.equals(admins.get(i).getLogin())) {
                    JOptionPane.showMessageDialog(null, "Данный логин уже есть в системе!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            for (int i = 0; i < teachers.size(); i++) {
                if (login.equals(teachers.get(i).getLogin())) {
                    JOptionPane.showMessageDialog(null, "Данный логин уже есть в системе!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            for (int i = 0; i < students.size(); i++) {
                if (login.equals(students.get(i).getLogin())) {
                    JOptionPane.showMessageDialog(null, "Данный логин уже есть в системе!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            return true;
        }
    }

    private Boolean checkPassword(String password, String provePassword) {
        if(password.equals("") || provePassword.equals("")) {
            JOptionPane.showMessageDialog(null, "Вы не ввели пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(password.length() <= 4 || password.length() >= 15) {
            JOptionPane.showMessageDialog(null, "Пароль должен быть больше 4 и меньше 15 символов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!password.equals(provePassword)){
            JOptionPane.showMessageDialog(null, "Пароль и его подтверждение не совпадают!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }


    //-------------------------------ФУНКЦИИ-СЛУШАТЕЛИ-------------------------------

    private void closeFrameActionPerformed(){
        new MainFrame().setVisible(true);
        dispose();
    }

    private void editMyPersonalDataActionPerformed(){
        if(mySurnameField.isEditable()) {
            try {
                User user = new User();
                user.setId(USER_ID);
                user.setSurname(mySurnameField.getText());
                user.setName(myNameField.getText());
                user.setPatronymic(myLastnameField.getText());
                user.setPhone(myPhoneField.getText());
                user.setEmail(myEmailField.getText());
                output.writeObject("updatePerson");
                output.writeObject(user);
                String result = (String) input.readObject();
                JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                if (result.equals("Успешно сохранено!")) {
                    for (int i = 0; i < admins.size(); i++) {
                        if (USER_ID == admins.get(i).getUserId()) {
                            Admin admin = admins.get(i);
                            admin.setSurname(user.getSurname());
                            admin.setName(user.getName());
                            admin.setPatronymic(user.getPatronymic());
                            admin.setPhone(user.getPhone());
                            admin.setEmail(user.getEmail());
                            admins.set(i, admin);
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            mySurnameField.setEditable(false);
            myNameField.setEditable(false);
            myLastnameField.setEditable(false);
            myPhoneField.setEditable(false);
            myEmailField.setEditable(false);
            editMyPersonalDataButton.setText("Редактировать личные данные");
        }
        else{
            mySurnameField.setEditable(true);
            myNameField.setEditable(true);
            myLastnameField.setEditable(true);
            myPhoneField.setEditable(true);
            myEmailField.setEditable(true);
            editMyPersonalDataButton.setText("Сохранить");
        }
    }

    private void editMyAuthorizationDataActionPerformed(){
        if(myLoginField.isEditable()){
            if(!checkLogin(myLoginField.getText())) return;
            if(!checkPassword(myPasswordField1.getText(), myPasswordField2.getText())) return;
            try{
                ObjectOutputStream output = MainFrame.output;
                ObjectInputStream input = MainFrame.input;
                User user = new User();
                user.setId(USER_ID);
                user.setLogin(myLoginField.getText());
                user.setPassword(myPasswordField1.getText());
                output.writeObject("updateMyUserData");
                output.writeObject(user);
                String result = (String) input.readObject();
                JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                if (result.equals("Успешно сохранено!")) {
                    for (int i = 0; i < admins.size(); i++) {
                        if (USER_ID == admins.get(i).getUserId()) {
                            Admin admin = admins.get(i);
                            admin.setLogin(user.getLogin());
                            admins.set(i, admin);
                        }
                    }
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            myLoginField.setEditable(false);
            myPasswordField1.setEditable(false);
            myPasswordField2.setEditable(false);
            editMyAuthorizationDataButton.setText("Редактировать данные авторизации");
        }
        else{
            myLoginField.setEditable(true);
            myPasswordField1.setEditable(true);
            myPasswordField2.setEditable(true);
            editMyAuthorizationDataButton.setText("Сохранить");
        }
    }


    private void tableAdminsMouseClickedActionPerformed(){
        Admin admin = admins.get(tableAdmins.getSelectedRow());
        editAdminLoginField.setText(admin.getLogin());
        if(admin.getRights().equals("Полные")) editAdminRightsComboBox.setSelectedIndex(0);
        else editAdminRightsComboBox.setSelectedIndex(1);
        if(admin.getBlock().equals("Нет")) editAdminBlockComboBox.setSelectedIndex(0);
        else editAdminBlockComboBox.setSelectedIndex(1);
        editAdminSurnameField.setText(admin.getSurname());
        editAdminNameField.setText(admin.getName());
        editAdminLastnameField.setText(admin.getSurname());
        editAdminPhoneField.setText(admin.getPatronymic());
        editAdminEmailField.setText(admin.getEmail());
        editAdminPasswordField1.setText(admin.getPassword());
        editAdminPasswordField2.setText(admin.getPassword());
    }

    private void tableTeachersMouseClickedActionPerformed(){
        Teacher teacher = teachers.get(tableTeachers.getSelectedRow());
        editTeacherLoginField.setText(teacher.getLogin());
        editTeacherSurnameField.setText(teacher.getSurname());
        editTeacherNameField.setText(teacher.getName());
        editTeacherLastnameField.setText(teacher.getPatronymic());
        editTeacherPhoneField.setText(teacher.getPhone());
        editTeacherEmailField.setText(teacher.getEmail());
        editTeacherPasswordField1.setText(teacher.getPassword());
        editTeacherPasswordField2.setText(teacher.getPassword());
        String post = teacher.getPost();
        String department = teacher.getDepartment();
        int indexPost = -1;
        int indexDepartment = -1;
        for (int i = 0; i < editTeacherPostComboBox.getItemCount(); i++) {
            if (editTeacherPostComboBox.getItemAt(i).equals(post)) {
                indexPost = i;
                break;
            }
        }
        for (int i = 0; i < editTeacherDepartmentComboBox.getItemCount(); i++) {
            if (editTeacherDepartmentComboBox.getItemAt(i).equals(department)) {
                indexDepartment = i;
                break;
            }
        }
        editTeacherPostComboBox.setSelectedIndex(indexPost);
        editTeacherDepartmentComboBox.setSelectedIndex(indexDepartment);
    }

    private void tableStudentsMouseClickedActionPerformed(){
        Student student = students.get(tableStudents.getSelectedRow());
        editStudentLoginField.setText(student.getLogin());
        editStudentSurnameField.setText(student.getSurname());
        editStudentNameField.setText(student.getName());
        editStudentLastnameField.setText(student.getPatronymic());
        editStudentPhoneField.setText(student.getPhone());
        editStudentEmailField.setText(student.getEmail());
        editStudentAddressField.setText(student.getAddress());
        editStudentDOBField.setText(student.getDOB());
        editStudentGroupComboBox.setSelectedItem(student.getNumberOfGroup());
        if(student.getFormOfEducation()== 0) editStudentFOEComboBox.setSelectedIndex(0);
        else editStudentFOEComboBox.setSelectedIndex(1);
        if(student.getFormOfEducation()== 1) editStudentFOEComboBox.setSelectedIndex(1);
        else editStudentFOEComboBox.setSelectedIndex(0);
    }

    private void tableSubjectsMouseClickedActionPerformed(){
        Subject subject = subjects.get(tableSubjects.getSelectedRow());
        editSubjectNameField.setText(subject.getSubjectName());
    }

    private void tableGroupsMouseClickedActionPerformed(){
        Group group = groups.get(tableGroups.getSelectedRow());
        editGroupNumberField.setText(String.valueOf(group.getNumberOfGroup()));
        editGroupSpecialityComboBox.setSelectedItem(group.getSpecialityName());
        editGroupFacultyField.setText(group.getFacultyName());
    }

    private void editGroupMouseClickedActionPerformed(){
        try{
            Object selectedItem = editStudentGroupComboBox.getSelectedItem();
            if (selectedItem != null) {
                String selectedValueString = (String) editStudentGroupComboBox.getSelectedItem();
                int selectedValue = Integer.parseInt(selectedValueString);
                Group group = new Group();
                group.setNumberOfGroup(selectedValue);
                output.writeObject("getGroup");
                output.writeObject(group);
                this.selectedGroup = (Group) input.readObject();
                group_id = selectedGroup.getGroupId();
                editStudentFacultyField.setText(selectedGroup.getFacultyName());
                editStudentSpecialityField.setText(selectedGroup.getSpecialityName());}
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editGroupSpecialityMouseClickedActionPerformed(){
        try{
            Object selectedItem = editGroupSpecialityComboBox.getSelectedItem();
            if (selectedItem != null) {
                String selectedValue = (String) editGroupSpecialityComboBox.getSelectedItem();
                Speciality speciality = new Speciality();
                speciality.setSpecialityName(selectedValue);
                output.writeObject("getSpeciality");
                output.writeObject(speciality);
                this.selectedSpeciality = (Speciality) input.readObject();
                //group_id = selectedGroup.getGroupId();
                editGroupFacultyField.setText(selectedSpeciality.getFacultyName());
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newGroupMouseClickedActionPerformed(){
        try{
            Object selectedItem = newStudentGroupComboBox.getSelectedItem();
            if (selectedItem != null) {
            String selectedValueString = (String) newStudentGroupComboBox.getSelectedItem();
            int selectedValue = Integer.parseInt(selectedValueString);
            Group group = new Group();
            group.setNumberOfGroup(selectedValue);
            output.writeObject("getGroup");
            output.writeObject(group);
            this.selectedGroup = (Group) input.readObject();
            group_id = selectedGroup.getGroupId();
            newStudentFacultyField.setText(selectedGroup.getFacultyName());
            newStudentSpecialityField.setText(selectedGroup.getSpecialityName());}
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newGroupSpecialityMouseClickedActionPerformed(){
        try{
            Object selectedItem = newGroupSpecialityComboBox.getSelectedItem();
            if (selectedItem != null) {
                String selectedValue = (String) newGroupSpecialityComboBox.getSelectedItem();
                Speciality speciality = new Speciality();
                speciality.setSpecialityName(selectedValue);
                output.writeObject("getSpeciality");
                output.writeObject(speciality);
                this.selectedSpeciality = (Speciality) input.readObject();
                //group_id = selectedGroup.getGroupId();
                newGroupFacultyField.setText(selectedSpeciality.getFacultyName());
                }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void addNewAdminActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkLogin(newAdminLoginField.getText())) return;
        if(!checkPassword(newAdminPasswordField1.getText(), newAdminPasswordField2.getText())) return;
        try{
            Admin admin = new Admin();
            admin.setLogin(newAdminLoginField.getText());
            admin.setPassword(newAdminPasswordField1.getText());
            admin.setRights(String.valueOf(newAdminRightsComboBox.getSelectedItem()));
            admin.setBlock(String.valueOf(newAdminBlockComboBox.getSelectedItem()));
            admin.setSurname(newAdminSurnameField.getText());
            admin.setName(newAdminNameField.getText());
            admin.setPatronymic(newAdminLastnameField.getText());
            admin.setPhone(newAdminPhoneField.getText());
            admin.setEmail(newAdminEmailField.getText());
            admin.setRole("admin");
            output.writeObject("insertAdmin");
            output.writeObject(admin);
            String result = (String) input.readObject();
            JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNewTeacherActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkLogin(newTeacherLoginField.getText())) return;
        if(!checkPassword(newTeacherPasswordField1.getText(), newTeacherPasswordField2.getText())) return;
        try{
            Teacher teacher = new Teacher();
            teacher.setLogin(newTeacherLoginField.getText());
            teacher.setPassword(newTeacherPasswordField1.getText());
            teacher.setSurname(newTeacherSurnameField.getText());
            teacher.setName(newTeacherNameField.getText());
            teacher.setPatronymic(newTeacherLastnameField.getText());
            teacher.setPhone(newTeacherPhoneField.getText());
            teacher.setEmail(newTeacherEmailField.getText());
            teacher.setDepartment(String.valueOf( newTeacherDepartmentComboBox.getSelectedItem()));
            teacher.setPost(String.valueOf(newTeacherPostComboBox.getSelectedItem()));
            teacher.setRole("teacher");
            output.writeObject("insertTeacher");
            output.writeObject(teacher);
            String result = (String) input.readObject();
            JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNewStudentButtonActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkLogin(newStudentLoginField.getText())) return;
        if(!checkPassword(newStudentPasswordField1.getText(), newStudentPasswordField2.getText())) return;
        if(newStudentSurnameField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели фамилию студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(newStudentNameField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели имя студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(newStudentPatronymicField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели отчество студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(newStudentDOBField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели дату рождения студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(newStudentSpecialityField.getText().equals("") && newStudentFacultyField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не выбрали группу студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            Student student = new Student();
            String dateRegex = "\\d{4}-\\d{2}-\\d{2}"; // Регулярное выражение для формата год-месяц-день
            String inputDate = newStudentDOBField.getText();

            if (inputDate.matches(dateRegex)) {
                String[] dateParts = inputDate.split("-");
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);

                if (month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >=  1) {
                    student.setDOB(inputDate);
                } else {
                    JOptionPane.showMessageDialog(null, "Вы не правильно ввели дату рождения студента!\nВводите дату в формате (год-месяц-день)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Вы не правильно ввели дату рождения студента!\nВводите дату в формате (год-месяц-день)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            student.setSurname(newStudentSurnameField.getText());
            student.setName(newStudentNameField.getText());
            student.setPatronymic(newStudentPatronymicField.getText());
            student.setLogin(newStudentLoginField.getText());
            student.setPassword(newStudentPasswordField1.getText());
            student.setNumberOfGroup(Integer.parseInt(newStudentGroupComboBox.getSelectedItem().toString()));
            student.setFacultyName(newStudentFacultyField.getText());
            student.setSpecialityName(newStudentSpecialityField.getText());
            student.setAddress(newStudentAddressField.getText());
            if(String.valueOf(newStudentFOEComboBox.getSelectedItem()).equals("Бюджетная")){
                student.setFormOfEducation(0);
            }
            if(String.valueOf(newStudentFOEComboBox.getSelectedItem()).equals("Платная")){
                student.setFormOfEducation(1);
            }
            student.setDOB(newStudentDOBField.getText());
            student.setPhone(newStudentPhoneField.getText());
            student.setEmail(newStudentEmailField.getText());
            student.setGroupId(group_id);
            student.setRole("student");
            output.writeObject("insertStudent");
            output.writeObject(student);
            String result = (String) input.readObject();
            JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNewSubjectActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            Subject subject = new Subject();
            subject.setSubjectName(newSubjectNameField.getText());
            output.writeObject("insertSubject");
            output.writeObject(subject);
            String result = (String) input.readObject();
            JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNewGroupActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            Group group = new Group();
            group.setNumberOfGroup(Integer.parseInt(newGroupNumberField.getText()));
            group.setSpecialityName(String.valueOf(newGroupSpecialityComboBox.getSelectedItem()));
            group.setFacultyName(newGroupFacultyField.getText());
            output.writeObject("insertGroup");
            output.writeObject(group);
            String result = (String) input.readObject();
            JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearNewAdminFormActionPerformed(){
        newAdminLoginField.setText("");
        newAdminPasswordField1.setText("");
        newAdminPasswordField2.setText("");
        newAdminRightsComboBox.setSelectedIndex(0);
        newAdminBlockComboBox.setSelectedIndex(0);
        newAdminSurnameField.setText("");
        newAdminNameField.setText("");
        newAdminLastnameField.setText("");
        newAdminPhoneField.setText("");
        newAdminEmailField.setText("");
    }

    private void clearNewTeacherFormActionPerformed(){
        newTeacherLoginField.setText("");
        newTeacherSurnameField.setText("");
        newTeacherNameField.setText("");
        newTeacherLastnameField.setText("");
        newTeacherPhoneField.setText("");
        newTeacherEmailField.setText("");
        newTeacherPasswordField1.setText("");
        newTeacherPasswordField2.setText("");
        newTeacherPostComboBox.setSelectedIndex(0);
        newTeacherDepartmentComboBox.setSelectedIndex(0);
    }

    private void clearNewStudentFormActionPerformed(){
        newStudentSurnameField.setText("");
        newStudentNameField.setText("");
        newStudentPatronymicField.setText("");
        newStudentLoginField.setText("");
        newStudentPasswordField1.setText("");
        newStudentPasswordField2.setText("");

        newStudentAddressField.setText("");
        newStudentDOBField.setText("");
        newStudentPhoneField.setText("");
        newStudentEmailField.setText("");
        newStudentFacultyField.setText("");
        newStudentSpecialityField.setText("");
        newStudentGroupComboBox.setSelectedIndex(0);
        newStudentFOEComboBox.setSelectedIndex(0);
    }

    private void clearNewGroupFormActionPerformed(){
        newGroupNumberField.setText("");
        newGroupFacultyField.setText("");
        newGroupSpecialityComboBox.setSelectedIndex(0);
    }
    private void clearNewSubjectFormActionPerformed(){
        newSubjectNameField.setText("");
    }

    private void deleteAdminActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            if(deleteAdminCheckBox.isSelected()){
                Admin admin = admins.get(tableAdmins.getSelectedRow());
                if(admin.getUserId() != USER_ID){
                    output.writeObject("deleteAdmin");
                    output.writeObject(admin);
                    String result = (String) input.readObject();
                    JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                    refreshData();
                    clearEditAndPasswordForm();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Вы не можете удалить свою учетную запись!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        deleteAdminCheckBox.setSelected(false);
    }

    private void deleteStudentActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            if(deleteStudentCheckBox.isSelected()){
                try{
                    Student student = students.get(tableStudents.getSelectedRow());
                    output.writeObject("deleteStudent");
                    output.writeObject(student);
                    String result = (String) input.readObject();
                    JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Вы не выбрали запись для удаления!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                refreshData();
                clearEditAndPasswordForm();
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTeacherActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            if(deleteTeacherCheckBox.isSelected()) {
                try {
                    Teacher teacher = teachers.get(tableTeachers.getSelectedRow());
                    System.out.println(teacher.getSurname());
                    output.writeObject("deleteTeacher");
                    output.writeObject(teacher);
                    String result = (String) input.readObject();
                    JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Вы не выбрали запись для удаления!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                refreshData();
                clearEditAndPasswordForm();
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSubjectActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            if(deleteSubjectCheckBox.isSelected()){
                try{
                    Subject subject = subjects.get(tableSubjects.getSelectedRow());
                    output.writeObject("deleteSubject");
                    output.writeObject(subject);
                    String result = (String) input.readObject();
                    JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Вы не выбрали предмет для удаления!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                refreshData();
                clearEditAndPasswordForm();
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteGroupActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            if(deleteGroupCheckBox.isSelected()){
                try{
                    Group group = groups.get(tableGroups.getSelectedRow());
                    output.writeObject("deleteGroup");
                    output.writeObject(group);
                    String result = (String) input.readObject();
                    JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Вы не выбрали группу для удаления!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                refreshData();
                clearEditAndPasswordForm();
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
//    private void statsAdminBlockActionPerformed(){
//        int notBlock = 0;
//        int block = 0;
//        for(int i = 0; i < admins.size(); i++){
//            if(admins.get(i).getBlock().equals("Нет")) notBlock++;
//            else block++;
//        }
//        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(notBlock, "", "Не блокированы");
//        dataSet.setValue(block, "", "Блокированы");
//
//        MainFrame.createGraph(dataSet, "Статистика блокированных/не блокированных администраторов");
//    }
//
    private void statsAdminRightsActionPerformed(){
        int full = 0;
        int read = 0;
        for(int i = 0; i < admins.size(); i++){
            if(admins.get(i).getRights().equals("Полные")) full++;
            else read++;
        }
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(full, "", "Полные");
        dataSet.setValue(read, "", "Чтение");

        MainFrame.createGraph(dataSet, "Статистика прав доступа");
    }



    private void editAdminActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Admin admin;
            try {
                admin = admins.get(tableAdmins.getSelectedRow());
                if(admin.getUserId() == USER_ID){
                    JOptionPane.showMessageDialog(null, "Вы не можете редактировать Ваши личные данные в этой вкладке! Перейдите во владку \"Мои данные\"" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!editAdminLoginField.getText().equals(admin.getLogin())){
                    if(!checkLogin(editAdminLoginField.getText())) return;
                }
                admin.setLogin(editAdminLoginField.getText());
                admin.setRights(String.valueOf(editAdminRightsComboBox.getSelectedItem()));
                admin.setBlock(String.valueOf(editAdminBlockComboBox.getSelectedItem()));
                admin.setSurname(editAdminSurnameField.getText());
                admin.setName(editAdminNameField.getText());
                admin.setPatronymic(editAdminLastnameField.getText());
                admin.setPhone(editAdminPhoneField.getText());
                admin.setEmail(editAdminEmailField.getText());
            }
            catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Нужно выбрать пользователя из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            output.writeObject("updateAdmin");
            output.writeObject(admin);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editTeacherActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Teacher teacher;
            try {
                teacher = teachers.get(tableTeachers.getSelectedRow());
                if(!editTeacherLoginField.getText().equals(teacher.getLogin())){
                    if(!checkLogin(editTeacherLoginField.getText())) return;
                }
                teacher.setLogin(editTeacherLoginField.getText());
                teacher.setSurname(editTeacherSurnameField.getText());
                teacher.setName(editTeacherNameField.getText());
                teacher.setPatronymic(editTeacherLastnameField.getText());
                teacher.setPhone(editTeacherPhoneField.getText());
                teacher.setEmail(editTeacherEmailField.getText());
                teacher.setDepartment((String)editTeacherDepartmentComboBox.getSelectedItem());
                teacher.setPost((String)editTeacherPostComboBox.getSelectedItem());
//                teacher.setDepartment(String.valueOf( newTeacherDepartmentComboBox.getSelectedItem()));
//                teacher.setPost(String.valueOf( newTeacherPostComboBox.getSelectedItem()));
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать преподавателя из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            output.writeObject("updateTeacher");
            output.writeObject(teacher);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editStudentActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(editStudentSurnameField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели фамилию студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(editStudentNameField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели имя студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(editStudentLastnameField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели отчество студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(editStudentDOBField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не ввели дату рождения студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(editStudentSpecialityField.getText().equals("") && editStudentFacultyField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Вы не выбрали группу студента!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            Student student;
            student = students.get(tableStudents.getSelectedRow());
            if(!editStudentLoginField.getText().equals(student.getLogin())){
                if(!checkLogin(editStudentLoginField.getText())) return;
            }
            String dateRegex = "\\d{4}-\\d{2}-\\d{2}"; // Регулярное выражение для формата год-месяц-день
            String inputDate = editStudentDOBField.getText();

            if (inputDate.matches(dateRegex)) {
                String[] dateParts = inputDate.split("-");
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);

                if (month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >=  1) {
                    student.setDOB(editStudentDOBField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Вы не правильно ввели дату рождения студента!\nВводите дату в формате (год-месяц-день)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Вы не правильно ввели дату рождения студента!\nВводите дату в формате (год-месяц-день)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
                student.setLogin(editStudentLoginField.getText());
                student.setSurname(editStudentSurnameField.getText());
                student.setName(editStudentNameField.getText());
                student.setPatronymic(editStudentLastnameField.getText());
                student.setPhone(editStudentPhoneField.getText());
                student.setAddress(editStudentAddressField.getText());
                student.setEmail(editStudentEmailField.getText());
                student.setSpecialityName(editStudentSpecialityField.getText());
                student.setFacultyName(editStudentFacultyField.getText());
                student.setNumberOfGroup(Integer.parseInt(newStudentGroupComboBox.getSelectedItem().toString()));
                student.setGroupId(group_id);
                if(String.valueOf(editStudentFOEComboBox.getSelectedItem()).equals("Бюджетная")){
                    student.setFormOfEducation(0);
                }
                if(String.valueOf(editStudentFOEComboBox.getSelectedItem()).equals("Платная")){
                    student.setFormOfEducation(1);
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать студента из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            output.writeObject("updateStudent");
            output.writeObject(student);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editSubjectActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Subject subject;
            try {
                subject = subjects.get(tableSubjects.getSelectedRow());
                subject.setSubjectName(editSubjectNameField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать предмет из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            output.writeObject("updateSubject");
            output.writeObject(subject);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editGroupActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Group group;
            try {
                group = groups.get(tableGroups.getSelectedRow());
                group.setNumberOfGroup(Integer.parseInt(editGroupNumberField.getText()));
                group.setSpecialityName(String.valueOf(editGroupSpecialityComboBox.getSelectedItem()));
                group.setFacultyName(editGroupFacultyField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать группу из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            output.writeObject("updateGroup");
            output.writeObject(group);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void editAdminPasswordActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkPassword(editAdminPasswordField1.getText(), editAdminPasswordField2.getText())) return;
        try{
            Admin admin;
            User user = new User();
            try{
                admin = admins.get(tableAdmins.getSelectedRow());
                if(admin.getUserId() == USER_ID){
                    JOptionPane.showMessageDialog(null, "Вы не можете редактировать Ваши личные данные в этой вкладке! Перейдите во владку \"Мои данные\"" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                user.setId(admin.getUserId());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать пользователя из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            user.setPassword(editAdminPasswordField1.getText());
            output.writeObject("updatePassword");
            output.writeObject(user);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editTeacherPasswordActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkPassword(editTeacherPasswordField1.getText(), editTeacherPasswordField2.getText())) return;
        try{
            Teacher teacher;
            try {
                teacher = teachers.get(tableTeachers.getSelectedRow());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать пользователя из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            teacher.setPassword(editTeacherPasswordField1.getText());
            output.writeObject("updatePassword");
            output.writeObject(teacher);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editStudentPasswordActionPerformed(){
        if(!rights.equals("Полные")) {
            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkPassword(editStudentPasswordField1.getText(), editStudentPasswordField2.getText())) return;
        try{
            Student student;
            User user = new User();
            try {
                student = students.get(tableStudents.getSelectedRow());
                user.setId(student.getUserId());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Нужно выбрать студента из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            user.setPassword(editStudentPasswordField1.getText());
            output.writeObject("updatePassword");
            output.writeObject(user);
            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
            clearEditAndPasswordForm();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }


//    private void editDoctorScheduleActionPerformed(){
//        if(!rights.equals("Полные")) {
//            JOptionPane.showMessageDialog(null, "Отказано в доступе", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        try{
//            Doctor doctor;
//            try{
//                doctor = doctors.get(tableDoctors.getSelectedRow());
//            }
//            catch (Exception ex){
//                JOptionPane.showMessageDialog(null, "Нужно выбрать доктора из списка!" , "Ошибка", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            String newSchedule[] = new String[14];
//            newSchedule[0] = (String)moIn.getSelectedItem();
//            if(moIn.getSelectedIndex() != 0) newSchedule[1] = (String)moOut.getSelectedItem();
//            else newSchedule[1] = "";
//            newSchedule[2] = (String)tuIn.getSelectedItem();
//            if(tuIn.getSelectedIndex() != 0) newSchedule[3] = (String)tuOut.getSelectedItem();
//            else newSchedule[3] = "";
//            newSchedule[4] = (String)weIn.getSelectedItem();
//            if(weIn.getSelectedIndex() != 0) newSchedule[5] = (String)weOut.getSelectedItem();
//            else newSchedule[5] = "";
//            newSchedule[6] = (String)thIn.getSelectedItem();
//            if(thIn.getSelectedIndex() != 0) newSchedule[7] = (String)thOut.getSelectedItem();
//            else newSchedule[7] = "";
//            newSchedule[8] = (String)frIn.getSelectedItem();
//            if(frIn.getSelectedIndex() != 0) newSchedule[9] = (String)frOut.getSelectedItem();
//            else newSchedule[9] = "";
//            newSchedule[10] = (String)saIn.getSelectedItem();
//            if(saIn.getSelectedIndex() != 0) newSchedule[11] = (String)saOut.getSelectedItem();
//            else newSchedule[11] = "";
//            newSchedule[12] = (String)suIn.getSelectedItem();
//            if(suIn.getSelectedIndex() != 0) newSchedule[13] = (String)suOut.getSelectedItem();
//            else newSchedule[13] = "";
//            doctor.setSchedule(newSchedule);
//            output.writeObject("updateDoctor");
//            output.writeObject(doctor);
//            JOptionPane.showMessageDialog(null, input.readObject(), "Результат", JOptionPane.INFORMATION_MESSAGE);
//            refreshData();
//            clearEditAndPasswordForm();
//        }catch (Exception ex){
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
//        }
//    }



}
