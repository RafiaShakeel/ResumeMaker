import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Main implements ActionListener {

    private JFrame home,register,login,home2,resume_form,temp11,temp22;
    private JButton j1,j2;
    private int tempSelected;
    JTextArea coverLetterTextArea;
    private JPasswordField password,passwordlogin;
    private JTextField Name1,HE,HEC,YOHE,skill1,skill2,skill3,phone_no,City,Country,email2,username,name,email,usernamelogin;
    private JLabel UserName,Name,Password,Email,UserType,UserNameLogin,PasswordLogin;
    private JButton registerbutton,submitButton,loginbutton,registerButton,loginButton;
    private JMenu usertype;
    private ButtonGroup group;
    private JMenuItem applicant,admin;
    private JMenuBar user;
    private String usertyp;
    Main(){


        home=new JFrame("Home");
        home.setLayout(null);
        JLabel img=new JLabel();
        ImageIcon imgicon=new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\project\\src\\logo.png");
        img.setIcon(imgicon);
        img.setBounds(80,40,250,50);

        registerbutton=new JButton("Register");
        loginbutton=new JButton("LogIn");
        registerbutton.addActionListener(this);
        registerbutton.setBounds(140,120,150,30);
        registerbutton.setBackground(new Color(255, 255, 255));

        loginbutton.addActionListener(this);
        loginbutton.setBounds(140,170,150,30);
        loginbutton.setBackground(new Color(255, 255, 255));

        home.add(img);
        home.add(registerbutton);
        home.add(loginbutton);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setSize(450,450);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        home.getContentPane().setBackground(new Color(187, 255, 153));

        ///////////////////REGISTER PAGE////////////////////////
        register=new JFrame("Register Yourself");
        register.setLayout(null);

        registerButton=new JButton("Register");
        registerButton.setBounds(80,330,140,30);
        registerButton.setBackground(new Color(255,255,255));
        registerButton.addActionListener(this);


        username=new JTextField("Username");
        email=new JTextField("Email....");
        name=new JTextField("Name");
        password=new JPasswordField("Password");

        username.setBounds(140,60,100,20);
        name.setBounds(140,110,100,20);
        email.setBounds(140,160,100,20);
        password.setBounds(140,210,100,20);

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\project\\src\\download.jpeg"); // Specify the path to your image
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(260, 40, 200, 300);

        user=new JMenuBar();
        applicant=new JMenuItem("Applicant");
        applicant.addActionListener(this);
        admin=new JMenuItem("Admin");
        admin.addActionListener(this);
        usertype=new JMenu("Select");
        usertype.add(applicant);
        usertype.add(admin);
        user.add(usertype);


        user.setBounds(140,260,100,20);

        JLabel j=new JLabel("Already have an account?");
        j.setBounds(80,360,180,30);
        j2=new JButton("Login");
        j2.setBounds(80,390,140,30);
        j2.addActionListener(this);
        register.add(imageLabel);
        register.add(username);
        register.add(name);
        register.add(email);
        register.add(password);
        register.add(j);
        register.add(j2);
//        register.add(user);
        register.add(registerButton);
        register.getContentPane().setBackground(new Color(187, 255, 153));


        UserName=new JLabel("Enter UserName :");
        Email=new JLabel("Enter Email:");
        Name=new JLabel("Enter Name:");
        Password=new JLabel("Enter Password:");
        UserType=new JLabel("Register As:");

        UserName.setBounds(20,50,100,40);
        Name.setBounds(20,100,100,40);
        Email.setBounds(20,150,100,40);
        Password.setBounds(20,200,100,40);
        UserType.setBounds(20,250,100,40);



        register.add(UserName);
        register.add(Email);
        register.add(Name);
        register.add(Password);
        //register.add(UserType);
        register.setSize(550,600);
        register.setLocationRelativeTo(null);
        register.setVisible(false);

        ////////////////LOGIN/////////////////////
        login=new JFrame("Login");
        UserNameLogin=new JLabel("Username :");
        PasswordLogin=new JLabel("Password :");

        JLabel imageLabel2 = new JLabel();
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\project\\src\\Logo.PNG"); // Specify the path to your image
        imageLabel2.setIcon(imageIcon2);
        imageLabel2.setBounds(20, -100, 250, 300);



        UserNameLogin.setBounds(20,110,100,40);
        PasswordLogin.setBounds(20,160,100,40);
        login.add(imageLabel2);
        login.add(UserNameLogin);
        login.add(PasswordLogin);
        login.getContentPane().setBackground(new Color(187, 255, 153));

        usernamelogin=new JTextField("Username");
        passwordlogin=new JPasswordField("Password");

        usernamelogin.setBounds(140,120,100,20);
        passwordlogin.setBounds(140,170,100,20);
        login.add(usernamelogin);
        login.add(passwordlogin);

        loginButton=new JButton("Login");
        loginButton.setBounds(80,220,140,30);
        loginButton.setBackground(new Color(255,255,255));
        loginButton.addActionListener(this);
        login.add(loginButton);


        login.setLayout(null);
        login.setSize(300,400);
        login.setLocationRelativeTo(null);
        login.setVisible(false);

        ///////////////HOME 2///////////////////
        home2=new JFrame("Welcome");
        home2.getContentPane().setBackground(new Color(187, 255, 153));

        //heading
        JLabel headingLabel = new JLabel("Welcome to Resume nerd");
        headingLabel.setFont(new Font("Arial", Font.ITALIC, 30));
        headingLabel.setBounds(20,80,400,50);

        //heading bold
        JLabel template = new JLabel("Templates:");
        template.setFont(new Font("Arial", Font.BOLD |Font.ITALIC, 16));
        template.setBounds(20,120,200,50);

        //select templates
        JLabel tempOptions=new JLabel("Select A Template From The Following:");
        tempOptions.setFont(new Font("Arial", Font.ITALIC, 13));
        tempOptions.setBounds(20,150,300,40);


        //template samples
        JPanel p1=new JPanel();
        p1.setBackground(new Color(187, 255, 153));
        p1.setBounds(40,210,100,200);
        JLabel temp1=new JLabel();
        ImageIcon temp1_1=new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\project\\src\\temp3.PNG");
        temp1.setIcon(temp1_1);
        temp1.setBounds(0,0,100,140);
        JLabel t1=new JLabel("Basic");
        t1.setBounds(0,160,100,20);
        p1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                resume_form.setVisible(true);
                tempSelected=1;
                home2.setVisible(false);
            }
        });
        p1.setLayout(null);
        p1.add(temp1);
        p1.add(t1);

        JPanel p2=new JPanel();
        p2.setBackground(new Color(187, 255, 153));
        p2.setBounds(210,210,100,200);
        JLabel temp2=new JLabel();
        ImageIcon temp2_2=new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\project\\src\\temp2.PNG");
        temp2.setIcon(temp2_2);
        temp2.setBounds(0,0,100,140);
        JLabel t2=new JLabel("Professional");
        t2.setBounds(0,160,100,20);
        p2.setLayout(null);
        p2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                resume_form.setVisible(true);
                tempSelected=2;
                home2.setVisible(false);
            }
        });
        p2.add(temp2);
        p2.add(t2);


        //adding logo
        JLabel img2=new JLabel();
        img2.setIcon(imgicon);
        img2.setBounds(20,20,250,50);
        j1=new JButton("Log Out");
        j1.setBackground(new Color(255,255,255));
        j1.setBounds(400,20,120,30);
        j1.addActionListener(this);

        //additions
        home2.add(p2);
        home2.add(p1);
        home2.add(tempOptions);
        home2.add(template);
        home2.add(img2);
        home2.add(headingLabel);
        home2.setVisible(false);
        home2.setSize(600,600);
        home2.setLayout(null);
        home2.add(j1);


        //////////////RESUME FORM///////////////////
        resume_form=new JFrame("Resume Creation");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(255, 255, 255));
        // First tab - Personal Information
        JPanel personalInfoPanel = createPersonalInfoPanel();
        tabbedPane.addTab("Personal Information", personalInfoPanel);

        // Second tab - Educational Information
        JPanel educationalInfoPanel = createEducationalInfoPanel();
        tabbedPane.addTab("Educational Information", educationalInfoPanel);

        JPanel skillsPanel = createSkillsPanel();
        tabbedPane.addTab("Skills", skillsPanel);
        JPanel submitPanel = createSubmitPanel();

        JPanel coverLetterPanel = createCoverLetterPanel();
        tabbedPane.addTab("Cover Letter", coverLetterPanel);


        // Setting up the frame
        resume_form.getContentPane().setLayout(new BorderLayout());
        resume_form.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        resume_form.getContentPane().add(submitPanel, BorderLayout.SOUTH);
        resume_form.setSize(700, 700);
        resume_form.setLocationRelativeTo(null); // Center the frame
        resume_form.setVisible(true);
        resume_form.getContentPane().setBackground(new Color(187, 255, 153));


        resume_form.setVisible(false);
        resume_form.setSize(400,400);




        ///////////////////Resume temp1////////////////////////
        temp11=new JFrame("Resume");
        temp11.setSize(600,700);
        temp11.setLayout(null);
        temp11.setVisible(false);


        ///////////////////Resume temp2////////////////////////
        temp22=new JFrame("Resume2");
        temp22.setSize(600,800);
        temp22.setLayout(null);
        temp22.setVisible(false);



    }

    private void resumetemp1(){

        JLabel name=new JLabel(Name1.getText());
        name.setBounds(150,10,300,100);
        name.setFont(new Font("Arial", Font.ITALIC, 30));

        JSeparator horizontalLine = new JSeparator(SwingConstants.HORIZONTAL);
        horizontalLine.setBounds(10,90,560,5);

        JLabel pInfo=new JLabel("Personal Information:");
        pInfo.setFont(new Font("Arial", Font.BOLD, 25));
        pInfo.setBounds(20,80,300,100);
        JLabel phone=new JLabel("Contact: ");
        phone.setFont(new Font("Arial", Font.BOLD, 16));
        phone.setBounds(30,140,100,50);
        JLabel phone2=new JLabel(phone_no.getText());
        phone2.setFont(new Font("Arial", Font.PLAIN, 12));
        phone2.setBounds(120,140,100,50);
        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Arial", Font.BOLD, 16));
        city.setBounds(30,160,100,50);

        JLabel city2=new JLabel(City.getText());
        city2.setFont(new Font("Arial", Font.PLAIN, 12));
        city2.setBounds(120,160,100,50);

        JLabel country=new JLabel("Country: ");
        country.setFont(new Font("Arial", Font.BOLD, 16));
        country.setBounds(30,180,100,50);

        JLabel country2=new JLabel(Country.getText());
        country2.setFont(new Font("Arial", Font.PLAIN, 12));
        country2.setBounds(120,180,100,50);

        JLabel email=new JLabel("Email: ");
        email.setFont(new Font("Arial", Font.BOLD, 16));
        email.setBounds(30,200,100,50);

        JLabel email1=new JLabel(email2.getText());
        email1.setFont(new Font("Arial", Font.PLAIN, 12));
        email1.setBounds(120,200,100,50);


        JLabel cv=new JLabel("Cover Letter:");
        cv.setBounds(20,210,200,100);
        cv.setFont(new Font( "Arial",Font.BOLD,20));
        JTextArea cv1=new JTextArea(coverLetterTextArea.getText());
        cv1.setLineWrap(true);
        cv1.setWrapStyleWord(true);
//        cv1.setFont(new Font( "Arial",Font.PLAIN,15));
        cv1.setBounds(30,280,550,80);
        cv1.setEditable(false);

        JLabel Education=new JLabel("Education:");
        Education.setFont(new Font("Arial", Font.BOLD, 25));
        Education.setBounds(20,340,300,100);
        JLabel HighestEducation=new JLabel("Degree Name: ");
        HighestEducation.setFont(new Font("Arial", Font.BOLD, 16));
        HighestEducation.setBounds(30,400,200,50);
        JLabel HighestEducation2=new JLabel(HE.getText());
        HighestEducation2.setFont(new Font("Arial", Font.PLAIN, 12));
        HighestEducation2.setBounds(200,400,200,50);

        JLabel EducationInstitute=new JLabel("Education Institute: ");
        EducationInstitute.setFont(new Font("Arial", Font.BOLD, 16));
        EducationInstitute.setBounds(30,430,200,50);

        JLabel EducationInstitute2=new JLabel(HEC.getText());
        EducationInstitute2.setFont(new Font("Arial", Font.PLAIN, 12));
        EducationInstitute2.setBounds(200,430,200,50);

        JLabel Year=new JLabel("Year(Completed) : ");
        Year.setFont(new Font("Arial", Font.BOLD, 16));
        Year.setBounds(30,460,200,50);

        JLabel Year2=new JLabel(YOHE.getText());
        Year2.setFont(new Font("Arial", Font.PLAIN, 12));
        Year2.setBounds(200,460,100,50);

        JLabel Skills=new JLabel("Skills : ");
        Skills.setFont(new Font("Arial", Font.BOLD, 25));
        Skills.setBounds(20,500,100,50);

        JLabel skill11=new JLabel("•"+skill1.getText());
        skill11.setFont(new Font("Arial", Font.PLAIN, 12));
        skill11.setBounds(40,530,100,50);

        JLabel skill22=new JLabel("•"+skill2.getText());
        skill22.setFont(new Font("Arial", Font.PLAIN, 12));
        skill22.setBounds(40,550,100,50);

        JLabel skill33=new JLabel("•"+skill3.getText());
        skill33.setFont(new Font("Arial", Font.PLAIN, 12));
        skill33.setBounds(40,570,100,50);


        temp11.add(name);
        temp11.add(horizontalLine);
        temp11.add(pInfo);
        temp11.add(phone);
        temp11.add(phone2);
        temp11.add(city);
        temp11.add(city2);
        temp11.add(country);
        temp11.add(country2);
        temp11.add(email);
        temp11.add(email1);
        temp11.add(cv);
        temp11.add(cv1);
        temp11.add(Education);
        temp11.add(HighestEducation);
        temp11.add(HighestEducation2);
        temp11.add(EducationInstitute);
        temp11.add(EducationInstitute2);
        temp11.add(Year);
        temp11.add(Year2);
        temp11.add(Skills);
        temp11.add(skill11);
        temp11.add(skill22);
        temp11.add(skill33);


        temp11.setVisible(true);

    }
    private void resumetemp2(){
        if(temp11.isVisible()){
            temp11.setVisible(false);
        }
        temp22.setVisible(true);
        JPanel p1=new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setBounds(0,150,150,800);
        p1.setLayout(null);
        JLabel Skills=new JLabel("Skills : ");
        Skills.setForeground(Color.DARK_GRAY);
        Skills.setFont(new Font("Arial", Font.BOLD, 20));
        Skills.setBounds(10,150,100,50);

        JLabel skill11=new JLabel("•"+skill1.getText());
        skill11.setFont(new Font("Arial", Font.PLAIN, 12));
        skill11.setForeground(Color.DARK_GRAY);
        skill11.setBounds(20,180,100,50);

        JLabel skill22=new JLabel("•"+skill2.getText());
        skill22.setFont(new Font("Arial", Font.PLAIN, 12));
        skill22.setForeground(Color.DARK_GRAY);
        skill22.setBounds(20,200,100,50);

        JLabel skill33=new JLabel("•"+skill3.getText());
        skill33.setFont(new Font("Arial", Font.PLAIN, 12));
        skill33.setForeground(Color.DARK_GRAY);
        skill33.setBounds(20,220,100,50);
        p1.add(Skills);
        p1.add(skill11);
        p1.add(skill22);
        p1.add(skill33);



        JPanel p2=new JPanel();
        p2.setBackground(Color.gray);
        p2.setBounds(0,0,600,150);
        p2.setLayout(null);
        JLabel name=new JLabel(Name1.getText());
        name.setBounds(200,20,450,100);
        name.setFont(new Font("Arial", Font.ITALIC, 30));
        name.setForeground(Color.WHITE);
        JLabel email1=new JLabel(email2.getText());
        email1.setFont(new Font("Arial", Font.ITALIC, 15));
        email1.setForeground(Color.WHITE);
        email1.setBounds(230,70,200,50);
        p2.add(name);
        p2.add(email1);




        JLabel pInfo=new JLabel("Personal Information:");
        pInfo.setFont(new Font("Arial", Font.BOLD, 25));
        pInfo.setBounds(170,170,300,100);
        JLabel phone=new JLabel("Contact: ");
        phone.setFont(new Font("Arial", Font.BOLD, 16));
        phone.setBounds(180,220,100,50);
        JLabel phone2=new JLabel(phone_no.getText());
        phone2.setFont(new Font("Arial", Font.PLAIN, 12));
        phone2.setBounds(260,220,100,50);

        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Arial", Font.BOLD, 16));
        city.setBounds(180,240,100,50);
        JLabel city2=new JLabel(City.getText());
        city2.setFont(new Font("Arial", Font.PLAIN, 12));
        city2.setBounds(260,240,100,50);

        JLabel country=new JLabel("Country: ");
        country.setFont(new Font("Arial", Font.BOLD, 16));
        country.setBounds(180,260,100,50);
        JLabel country2=new JLabel(Country.getText());
        country2.setFont(new Font("Arial", Font.PLAIN, 12));
        country2.setBounds(260,260,100,50);

        JLabel cv=new JLabel("Cover Letter:");
        cv.setBounds(170,280,220,100);
        cv.setFont(new Font( "Arial",Font.BOLD,20));
        JTextArea cv1=new JTextArea(coverLetterTextArea.getText());
        cv1.setLineWrap(true);
        cv1.setWrapStyleWord(true);
//        cv1.setFont(new Font( "Arial",Font.PLAIN,15));
        cv1.setBounds(190,370,350,100);
        cv1.setEditable(false);


        JLabel Education=new JLabel("Education:");
        Education.setFont(new Font("Arial", Font.BOLD, 25));
        Education.setBounds(170,470,300,100);
        JLabel HighestEducation=new JLabel("Degree Name: ");
        HighestEducation.setFont(new Font("Arial", Font.BOLD, 16));
        HighestEducation.setBounds(180,530,200,50);
        JLabel HighestEducation2=new JLabel(HE.getText());
        HighestEducation2.setFont(new Font("Arial", Font.PLAIN, 12));
        HighestEducation2.setBounds(360,530,200,50);

        JLabel EducationInstitute=new JLabel("Education Institute: ");
        EducationInstitute.setFont(new Font("Arial", Font.BOLD, 16));
        EducationInstitute.setBounds(180,560,200,50);

        JLabel EducationInstitute2=new JLabel(HEC.getText());
        EducationInstitute2.setFont(new Font("Arial", Font.PLAIN, 12));
        EducationInstitute2.setBounds(360,560,200,50);

        JLabel Year=new JLabel("Year(Completed) : ");
        Year.setFont(new Font("Arial", Font.BOLD, 16));
        Year.setBounds(180,590,200,50);
        JLabel Year2=new JLabel(YOHE.getText());
        Year2.setFont(new Font("Arial", Font.PLAIN, 12));
        Year2.setBounds(360,590,100,50);

        temp22.add(pInfo);
        temp22.add(phone);
        temp22.add(phone2);
        temp22.add(city);
        temp22.add(city2);
        temp22.add(country);
        temp22.add(country2);
        temp22.add(cv);
        temp22.add(cv1);
        temp22.add(Education);
        temp22.add(HighestEducation);
        temp22.add(HighestEducation2);
        temp22.add(EducationInstitute);
        temp22.add(EducationInstitute2);
        temp22.add(Year);
        temp22.add(Year2);


        temp22.getContentPane().add(p1);
        temp22.getContentPane().add(p2);

    }
    private JPanel createCoverLetterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(187, 255, 153));
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Cover Letter / Introduction:");
        coverLetterTextArea= new JTextArea("I am writing to express my enthusiastic interest in the Graphic Designer position at [Company Name], as advertised on [where you found the job posting]. With a strong background in visual communication and a passion for creating compelling designs, I am confident in my ability to contribute effectively to your dynamic team");
        coverLetterTextArea.setLineWrap(true);
        coverLetterTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(coverLetterTextArea);

        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(187, 255, 153));
        Name1=new JTextField("Rafia Shakeel");
        phone_no=new JTextField("03355371478");
        City=new JTextField("Rawalpindi");
        Country=new JTextField("Pakistan");
        email2=new JTextField("rafii@gmail.com");
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Name:"));
        panel.add(Name1);
        // Adding components to the panel
        panel.add(new JLabel("Contact No:"));
        panel.add(phone_no);

        panel.add(new JLabel("City:"));
        panel.add(City);

        panel.add(new JLabel("Country:"));
        panel.add(Country);

        panel.add(new JLabel("Email:"));
        panel.add(email2);

        return panel;
    }
    private JPanel createSkillsPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(187, 255, 153));
        skill1=new JTextField("coding");
        skill2=new JTextField("designing");
        skill3=new JTextField("documentation");
        panel.setLayout(new GridLayout(4, 2));

        // Adding components to the panel
        panel.add(new JLabel("Skill 1:"));
        panel.add(skill1);

        panel.add(new JLabel("Skill 2:"));
        panel.add(skill2);

        panel.add(new JLabel("Skill 3:"));
        panel.add(skill3);

        panel.add(new JLabel("Proficiency Level:"));
        panel.add(createProficiencyRadioButtons());

        return panel;
    }
    private JPanel createProficiencyRadioButtons() {
        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(new Color(187, 255, 153));
        group = new ButtonGroup();

        JRadioButton beginnerRadio = new JRadioButton("Beginner");
        JRadioButton intermediateRadio = new JRadioButton("Intermediate");
        JRadioButton advancedRadio = new JRadioButton("Advanced");

        group.add(beginnerRadio);
        group.add(intermediateRadio);
        group.add(advancedRadio);

        radioPanel.add(beginnerRadio);
        radioPanel.add(intermediateRadio);
        radioPanel.add(advancedRadio);

        return radioPanel;
    }
    private JPanel createEducationalInfoPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(187, 255, 153));
        HE=new JTextField("Education");
        HEC=new JTextField("Hec");
        YOHE=new JTextField("Yohe");
        panel.setLayout(new GridLayout(3, 2));

        // Adding components to the panel
        panel.add(new JLabel("Highest Education:"));
        panel.add(HE);

        panel.add(new JLabel("College of Highest Education:"));
        panel.add(HEC);

        panel.add(new JLabel("Years of Completing Degree:"));
        panel.add(YOHE);

        return panel;
    }
    private  JPanel createSubmitPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(187, 255, 153));
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(255,255,255));
        submitButton.addActionListener(this);
        panel.add(submitButton);
        return panel;
    }
    private static String getSelectedProficiency(ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements();
             buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;  // No button selected
    }
    private boolean validateUsername(String username) {
        // Use regular expression for username validation
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean validateName(String name) {
        // Use regular expression for name validation
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean validateEmail(String email) {
        // Use regular expression for email validation
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean validateFields() {
        // Validation logic for each field
        if (!validateUsername(username.getText())) {
            showErrorDialog("Invalid username. Use alphabets and numbers only.");
            return false;
        }

        if (!validateName(name.getText())) {
            showErrorDialog("Invalid name. Use alphabets only.");
            return false;
        }

        if (!validateEmail(email.getText())) {
            showErrorDialog("Invalid email address.");
            return false;
        }

        if (!validatePassword(new String(password.getPassword()))) {
            showErrorDialog("Invalid password. Use alphanumeric characters with at least one special symbol.");
            return false;
        }

        // Additional validation logic can be added if needed

        return true;
    }

    private boolean validatePassword(String password) {
        // Use regular expression for password validation
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton){
            String selectedProficiency = getSelectedProficiency(group);
            System.out.println(selectedProficiency);
            String skills=skill1.getText()+" "+skill2.getText()+" "+skill3.getText();
            System.out.println(skills);
            if(email2.getText()==null||Name1.getText()==null||phone_no.getText()==null||City.getText()==null||Country.getText()==null||coverLetterTextArea.getText()==null||skills==null||HE.getText()==null||HEC.getText()==null||YOHE.getText()==null||selectedProficiency==null){
                JOptionPane.showMessageDialog(null, "Kindly fill the form Completely", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);

            }
            else {
                resume r = new resume();
                int result = r.create_resume(Name1.getText(), email2.getText(), phone_no.getText(), City.getText(), Country.getText(), skills, HE.getText(), HEC.getText(), YOHE.getText(), selectedProficiency, coverLetterTextArea.getText());
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "SuccessFully saved the Details", "SAVE", JOptionPane.INFORMATION_MESSAGE);
                    if (tempSelected == 1) {
                        resume_form.setVisible(false);
                        resumetemp1();
                    } else if (tempSelected == 2) {
                        resume_form.setVisible(false);
                        resumetemp2();
                    }
                }

            }

        }
        if(e.getSource()==registerbutton){
            register.setVisible(true);
            home.setVisible(false);
        }
        else if(e.getSource()==loginbutton) {
            login.setVisible(true);
            home.setVisible(false);
        }
        else if(e.getSource()==loginButton){
                user u = new user();
                String username = usernamelogin.getText();
                String password = passwordlogin.getText();
                int a = u.login(username, password);
                if (a == 1) {
                    login.setVisible(false);
                    home2.setVisible(true);
                    System.out.println();

                } else {
                    showErrorDialog("Invalid Credentials. Try again.");

                }
        }
        else if(e.getSource()==j1){
            System.out.println("logout");
            home2.setVisible(false);
            home.setVisible(true);
        }
        else if(e.getSource()==j2){
            register.setVisible(false);
            login.setVisible(true);
        }
        else if(e.getSource()==registerButton){
            if(validateFields()){
            String usr=username.getText();
            String n=name.getText();
            String e_mail=email.getText();
            String passWord=password.getText();
            String check=e.getActionCommand();
//            if(check=="Admin"){
//                usertyp="admin";
//            }
//            else if (check=="Applicant") {
//                usertyp="applicant";
//            }
            if(e.getSource()==registerButton){
                registerUser r=new registerUser();
                if(n==null||e_mail==null||passWord==null||usr==null){
                    JOptionPane.showMessageDialog(null, "Kindly Fill the Form completely", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                }
                int a=r.register(n,e_mail,passWord,usr);
                if(a==1){
                    JOptionPane.showMessageDialog(null, "Welcome to Home", "welcome", JOptionPane.INFORMATION_MESSAGE);
                    register.setVisible(false);
                    home2.setVisible(true);

                }
            }

            }}


    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        new Main();
        System.out.println("Hello and welcome!");
    }
}