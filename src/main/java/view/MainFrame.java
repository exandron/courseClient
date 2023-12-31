package view;

import model.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainFrame extends JFrame{
    private JPanel panelMain;
    private JLabel LoginLabel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JButton clearButton;
    private JButton entranceButton;

    public static Socket clientSocket;
    public static ObjectOutputStream output;
    public static ObjectInputStream input;
    public static int user_id;

    public static void connect(){
        try{
            clientSocket = new Socket("127.0.0.1", 2626);
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Клиент подключился.");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Главное меню");
        setContentPane(panelMain);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public static void createGraph(DefaultCategoryDataset dataSet, String title){
        JFreeChart chart = ChartFactory.createBarChart(title, "", "", dataSet, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        // Настройка шрифта меток на оси x для серии "Полные"
        CategoryAxis domainAxis = catPlot.getDomainAxis();
        domainAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 12));

// Настройка шрифта меток на оси y для серии "Полные"
        ValueAxis rangeAxis = catPlot.getRangeAxis();
        rangeAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 12));

// Настройка шрифта меток на оси x для серии "Чтение"
        CategoryAxis domainAxis2 = new CategoryAxis();
        domainAxis2.setTickLabelFont(new Font("Arial", Font.BOLD, 12));
        catPlot.setDomainAxis(1, domainAxis2);

// Настройка шрифта меток на оси y для серии "Чтение"
        ValueAxis rangeAxis2 = new NumberAxis();
        rangeAxis2.setTickLabelFont(new Font("Arial", Font.BOLD, 12));
        catPlot.setRangeAxis(1, rangeAxis2);
        //catPlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame(title);
        frame.setSize(1000,600);
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel.removeAll();
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();
        frame.add(panel);
        frame.setVisible(true);
    }


    public MainFrame() {
        initComponents();
        entranceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ObjectOutputStream output = MainFrame.output;
                    ObjectInputStream input = MainFrame.input;
                    User user = new User();
                    user.setLogin(loginField.getText());
                    user.setPassword(passwordField.getText());
                    if(user.getLogin().equals("")){
                        JOptionPane.showMessageDialog(null, "Вы не ввели логин!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if (user.getLogin().length() <= 4 || user.getLogin().length() >= 15){
                        JOptionPane.showMessageDialog(null, "Логин должен быть больше 4 и меньше 15 символов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(user.getPassword().equals("")) {
                        JOptionPane.showMessageDialog(null, "Вы не ввели пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(user.getPassword().length() <= 4 || user.getPassword().length() >= 15) {
                        JOptionPane.showMessageDialog(null, "Пароль должен быть больше 4 и меньше 15 символов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else{
                        output.writeObject("authorization");
                        output.writeObject(user);
                        user = (User) input.readObject();
                        if(user.getRole().equals("wrong")){
                            JOptionPane.showMessageDialog(null, "Неправильно введён логин/пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else if(user.getRole().equals("admin")) {
                            new AdminFrame(user.getId()).setVisible(true);
                            dispose();
                        }
                        else if(user.getRole().equals("student")){
                            new StudentFrame(user.getId()).setVisible(true);
                            dispose();
                        }
                        else if(user.getRole().equals("teacher")){
                            new TeacherFrame(user.getId()).setVisible(true);
                            dispose();
                        }
                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginField.setText("");
                passwordField.setText("");
            }
        });
    }

    public static void main(String args[]) {
        MainFrame.connect();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}