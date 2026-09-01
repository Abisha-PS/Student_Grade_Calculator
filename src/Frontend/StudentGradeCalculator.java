package Frontend;
import Backend.GradeCalculator;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeCalculator extends JFrame {

    // ============================================================
    // COLORS
    // ============================================================

    Color navy = new Color(25, 35, 55);
    Color blue = new Color(30, 120, 230);
    Color purple = new Color(125, 60, 190);
    Color green = new Color(25, 170, 90);
    Color red = new Color(215, 55, 55);
    Color orange = new Color(235, 135, 15);

    Color background = new Color(244, 247, 251);
    Color grey = new Color(100, 110, 125);
    Color lightGrey = new Color(225, 230, 236);

    // ============================================================
    // FONTS
    // ============================================================

    Font titleFont =
            new Font("Segoe UI", Font.BOLD, 30);

    Font headingFont =
            new Font("Segoe UI", Font.BOLD, 23);

    Font normalFont =
            new Font("Segoe UI", Font.PLAIN, 16);

    Font boldFont =
            new Font("Segoe UI", Font.BOLD, 16);

    Font smallFont =
            new Font("Segoe UI", Font.PLAIN, 13);

    // ============================================================
    // MAIN PANEL
    // ============================================================

    JPanel mainPanel =
            new JPanel(new BorderLayout());

    // ============================================================
    // STUDENT DATA
    // ============================================================

    String studentName = "";
    String rollNumber = "";
    String department = "";
    String year = "";

    String[] subjects = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Computer Networks",
            "Operating Systems"
    };

    int[] marks = new int[5];

    // ============================================================
    // INPUT FIELDS
    // ============================================================

    JTextField nameField;
    JTextField rollField;
    JTextField departmentField;

    JComboBox<String> yearBox;

    JTextField[] markFields =
            new JTextField[5];

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public StudentGradeCalculator() {

        setTitle("Student Performance Hub");

        setSize(1050, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        mainPanel.setBackground(background);

        add(mainPanel);

        showDashboard();
    }

    // ============================================================
    // DASHBOARD
    // ============================================================

    void showDashboard() {

        mainPanel.removeAll();

        mainPanel.add(
                createSidebar(),
                BorderLayout.WEST
        );

        JPanel dashboard = new JPanel();

        dashboard.setBackground(background);

        dashboard.setLayout(
                new BoxLayout(
                        dashboard,
                        BoxLayout.Y_AXIS
                )
        );

        dashboard.setBorder(
                new EmptyBorder(
                        30, 35, 30, 35
                )
        );

        JLabel welcome =
                new JLabel(
                        "Student Performance Dashboard"
                );

        welcome.setFont(titleFont);
        welcome.setForeground(navy);

        dashboard.add(welcome);

        dashboard.add(
                Box.createVerticalStrut(5)
        );

        JLabel subtitle =
                new JLabel(
                        "Manage marks, calculate grades and understand your academic performance."
                );

        subtitle.setFont(normalFont);
        subtitle.setForeground(grey);

        dashboard.add(subtitle);

        dashboard.add(
                Box.createVerticalStrut(30)
        );

        JPanel hero =
                new JPanel(new BorderLayout());

        hero.setBackground(navy);

        hero.setBorder(
                new EmptyBorder(
                        25, 30, 25, 30
                )
        );

        JLabel heroTitle =
                new JLabel(
                        "<html><b>Calculate Your Academic Success</b><br>"
                                + "<font size='4'>"
                                + "Enter your details and marks to generate "
                                + "a complete performance report."
                                + "</font></html>"
                );

        heroTitle.setForeground(Color.WHITE);

        JButton beginButton =
                createButton(
                        "BEGIN",
                        blue,
                        Color.WHITE
                );

        beginButton.addActionListener(
                e -> showStudentPage()
        );

        hero.add(
                heroTitle,
                BorderLayout.CENTER
        );

        hero.add(
                beginButton,
                BorderLayout.EAST
        );

        dashboard.add(hero);

        dashboard.add(
                Box.createVerticalStrut(30)
        );

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                1, 3, 20, 20
                        )
                );

        cards.setOpaque(false);

        cards.add(
                createDashboardCard(
                        "01",
                        "Student Profile",
                        "Enter student information",
                        blue
                )
        );

        cards.add(
                createDashboardCard(
                        "02",
                        "Mark Analysis",
                        "Enter and validate subject marks",
                        purple
                )
        );

        cards.add(
                createDashboardCard(
                        "03",
                        "Smart Result",
                        "Get grade and performance insights",
                        green
                )
        );

        dashboard.add(cards);

        dashboard.add(
                Box.createVerticalStrut(30)
        );

        JPanel info =
                new JPanel(new BorderLayout());

        info.setBackground(Color.WHITE);

        info.setBorder(
                new CompoundBorder(
                        new LineBorder(lightGrey),
                        new EmptyBorder(
                                20, 25, 20, 25
                        )
                )
        );

        JLabel infoTitle =
                new JLabel(
                        "What this application provides"
                );

        infoTitle.setFont(boldFont);
        infoTitle.setForeground(navy);

        JLabel infoText =
                new JLabel(
                        "<html>✓ Total Marks &nbsp;&nbsp;&nbsp;"
                                + "✓ Average &nbsp;&nbsp;&nbsp;"
                                + "✓ Percentage &nbsp;&nbsp;&nbsp;"
                                + "✓ Grade &nbsp;&nbsp;&nbsp;"
                                + "✓ Pass/Fail &nbsp;&nbsp;&nbsp;"
                                + "✓ Subject Analysis</html>"
                );

        infoText.setFont(normalFont);
        infoText.setForeground(grey);

        info.add(
                infoTitle,
                BorderLayout.NORTH
        );

        info.add(
                infoText,
                BorderLayout.CENTER
        );

        dashboard.add(info);

        mainPanel.add(
                dashboard,
                BorderLayout.CENTER
        );

        refresh();
    }

    // ============================================================
    // SIDEBAR
    // ============================================================

    JPanel createSidebar() {

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(
                new Dimension(210, 700)
        );

        sidebar.setBackground(navy);

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(
                        25, 15, 25, 15
                )
        );

        JLabel logo =
                new JLabel(
                        "<html><center>"
                                + "🎓<br>"
                                + "<b>STUDENT</b><br>"
                                + "HUB"
                                + "</center></html>"
                );

        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        logo.setForeground(Color.WHITE);

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(logo);

        sidebar.add(
                Box.createVerticalStrut(45)
        );

        sidebar.add(
                createSideButton(
                        "⌂  Dashboard",
                        blue,
                        e -> showDashboard()
                )
        );

        sidebar.add(
                Box.createVerticalStrut(12)
        );

        sidebar.add(
                createSideButton(
                        "👤  Student Profile",
                        purple,
                        e -> showStudentPage()
                )
        );

        sidebar.add(
                Box.createVerticalStrut(12)
        );

        sidebar.add(
                createSideButton(
                        "📝  Enter Marks",
                        green,
                        e -> showMarksPage()
                )
        );

        sidebar.add(
                Box.createVerticalStrut(12)
        );

        sidebar.add(
                createSideButton(
                        "📊  Grade System",
                        orange,
                        e -> showGradePage()
                )
        );

        sidebar.add(
                Box.createVerticalGlue()
        );

        JLabel footer =
                new JLabel(
                        "<html><center>"
                                + "Student Performance Hub<br>"
                                + "Java Swing Project"
                                + "</center></html>"
                );

        footer.setForeground(
                new Color(180, 190, 205)
        );

        footer.setFont(smallFont);

        footer.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(footer);

        return sidebar;
    }

    // ============================================================
    // SIDEBAR BUTTON
    // ============================================================

    JButton createSideButton(
            String text,
            Color color,
            ActionListener action) {

        JButton button =
                new JButton(text);

        button.setUI(
                new BasicButtonUI()
        );

        button.setFont(boldFont);

        button.setForeground(Color.WHITE);

        button.setBackground(color);

        button.setOpaque(true);

        button.setContentAreaFilled(true);

        button.setBorderPainted(false);

        button.setFocusPainted(false);

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setMaximumSize(
                new Dimension(180, 48)
        );

        button.setPreferredSize(
                new Dimension(180, 48)
        );

        button.setBorder(
                new EmptyBorder(
                        10, 15, 10, 10
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.addActionListener(action);

        button.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent e) {

                        button.setBackground(
                                color.brighter()
                        );
                    }

                    public void mouseExited(
                            MouseEvent e) {

                        button.setBackground(color);
                    }
                }
        );

        return button;
    }

    // ============================================================
    // GENERAL BUTTON
    // ============================================================

    JButton createButton(
            String text,
            Color color,
            Color fontColor) {

        JButton button =
                new JButton(text);

        button.setUI(
                new BasicButtonUI()
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        button.setForeground(fontColor);

        button.setBackground(color);

        button.setOpaque(true);

        button.setContentAreaFilled(true);

        button.setBorderPainted(false);

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                color.darker(),
                                1
                        ),
                        new EmptyBorder(
                                12, 25, 12, 25
                        )
                )
        );

        button.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent e) {

                        button.setBackground(
                                color.brighter()
                        );
                    }

                    public void mouseExited(
                            MouseEvent e) {

                        button.setBackground(color);
                    }
                }
        );

        return button;
    }

    // ============================================================
    // DASHBOARD CARD
    // ============================================================

    JPanel createDashboardCard(
            String number,
            String title,
            String description,
            Color color) {

        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(Color.WHITE);

        card.setBorder(
                new CompoundBorder(
                        new LineBorder(lightGrey),
                        new EmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );

        JLabel numberLabel =
                new JLabel(number);

        numberLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        numberLabel.setForeground(color);

        numberLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        titleLabel.setForeground(navy);

        titleLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel descLabel =
                new JLabel(
                        "<html>"
                                + description
                                + "</html>"
                );

        descLabel.setFont(smallFont);

        descLabel.setForeground(grey);

        descLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        card.add(numberLabel);

        card.add(
                Box.createVerticalStrut(10)
        );

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(descLabel);

        return card;
    }

    // ============================================================
    // STUDENT PAGE
    // ============================================================

    void showStudentPage() {

        mainPanel.removeAll();

        mainPanel.add(
                createSidebar(),
                BorderLayout.WEST
        );

        JPanel page =
                createPagePanel();

        page.add(
                createPageTitle(
                        "Student Profile",
                        "Create your academic profile before entering marks."
                )
        );

        page.add(
                Box.createVerticalStrut(25)
        );

        JPanel form =
                new JPanel(
                        new GridBagLayout()
                );

        form.setBackground(Color.WHITE);

        form.setBorder(
                new CompoundBorder(
                        new LineBorder(lightGrey),
                        new EmptyBorder(
                                30, 40, 30, 40
                        )
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        12, 12, 12, 12
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        addFormRow(
                form,
                gbc,
                0,
                "Student Name",
                nameField =
                        createTextField()
        );

        addFormRow(
                form,
                gbc,
                1,
                "Roll Number",
                rollField =
                        createTextField()
        );

        addFormRow(
                form,
                gbc,
                2,
                "Department",
                departmentField =
                        createTextField()
        );

        yearBox =
                new JComboBox<>(
                        new String[]{
                                "First Year",
                                "Second Year",
                                "Third Year",
                                "Final Year"
                        }
                );

        yearBox.setFont(normalFont);

        addFormRow(
                form,
                gbc,
                3,
                "Academic Year",
                yearBox
        );

        page.add(form);

        page.add(
                Box.createVerticalStrut(25)
        );

        JButton next =
                createButton(
                        "CONTINUE TO MARKS  →",
                        blue,
                        Color.WHITE
                );

        next.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        next.addActionListener(
                e -> validateStudent()
        );

        page.add(next);

        mainPanel.add(
                page,
                BorderLayout.CENTER
        );

        refresh();
    }

    // ============================================================
    // PAGE PANEL
    // ============================================================

    JPanel createPagePanel() {

        JPanel page = new JPanel();

        page.setBackground(background);

        page.setLayout(
                new BoxLayout(
                        page,
                        BoxLayout.Y_AXIS
                )
        );

        page.setBorder(
                new EmptyBorder(
                        30, 40, 30, 40
                )
        );

        return page;
    }

    // ============================================================
    // PAGE TITLE
    // ============================================================

    JLabel createPageTitle(
            String title,
            String subtitle) {

        JLabel label =
                new JLabel(
                        "<html><b>"
                                + title
                                + "</b><br>"
                                + "<font size='4'>"
                                + subtitle
                                + "</font></html>"
                );

        label.setFont(titleFont);

        label.setForeground(navy);

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }

    // ============================================================
    // FORM ROW
    // ============================================================

    void addFormRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            String labelText,
            JComponent field) {

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;

        JLabel label =
                new JLabel(labelText);

        label.setFont(boldFont);

        label.setForeground(navy);

        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        panel.add(field, gbc);
    }

    // ============================================================
    // TEXT FIELD
    // ============================================================

    JTextField createTextField() {

        JTextField field =
                new JTextField();

        field.setFont(normalFont);

        field.setPreferredSize(
                new Dimension(350, 42)
        );

        field.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                new Color(
                                        200, 205, 215
                                )
                        ),
                        new EmptyBorder(
                                5, 12, 5, 12
                        )
                )
        );

        return field;
    }

    // ============================================================
    // VALIDATE STUDENT
    // ============================================================

    void validateStudent() {

        if (
                nameField.getText()
                        .trim()
                        .isEmpty()
        ) {

            error("Please enter student name.");

            return;
        }

        if (
                rollField.getText()
                        .trim()
                        .isEmpty()
        ) {

            error("Please enter roll number.");

            return;
        }

        if (
                departmentField.getText()
                        .trim()
                        .isEmpty()
        ) {

            error("Please enter department.");

            return;
        }

        studentName =
                nameField.getText().trim();

        rollNumber =
                rollField.getText().trim();

        department =
                departmentField.getText().trim();

        year =
                yearBox.getSelectedItem()
                        .toString();

        showMarksPage();
    }

    // ============================================================
    // MARKS PAGE
    // ============================================================

    void showMarksPage() {

        mainPanel.removeAll();

        mainPanel.add(
                createSidebar(),
                BorderLayout.WEST
        );

        JPanel page =
                createPagePanel();

        page.add(
                createPageTitle(
                        "Subject Performance",
                        "Enter marks for all five subjects."
                )
        );

        page.add(
                Box.createVerticalStrut(25)
        );

        JPanel subjectsPanel =
                new JPanel();

        subjectsPanel.setBackground(background);

        subjectsPanel.setLayout(
                new BoxLayout(
                        subjectsPanel,
                        BoxLayout.Y_AXIS
                )
        );

        for (int i = 0; i < subjects.length; i++) {

            JPanel row =
                    new JPanel(
                            new BorderLayout()
                    );

            row.setBackground(Color.WHITE);

            row.setBorder(
                    new CompoundBorder(
                            new LineBorder(lightGrey),
                            new EmptyBorder(
                                    12, 18, 12, 18
                            )
                    )
            );

            row.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            65
                    )
            );

            JLabel subject =
                    new JLabel(
                            (i + 1) + ". "
                                    + subjects[i]
                    );

            subject.setFont(boldFont);

            subject.setForeground(navy);

            markFields[i] =
                    createTextField();

            markFields[i].setPreferredSize(
                    new Dimension(
                            100, 38
                    )
            );

            row.add(
                    subject,
                    BorderLayout.CENTER
            );

            row.add(
                    markFields[i],
                    BorderLayout.EAST
            );

            subjectsPanel.add(row);

            subjectsPanel.add(
                    Box.createVerticalStrut(10)
            );
        }

        JScrollPane scroll =
                new JScrollPane(
                        subjectsPanel
                );

        scroll.setBorder(null);

        page.add(scroll);

        page.add(
                Box.createVerticalStrut(20)
        );

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        buttons.setOpaque(false);

        JButton back =
                createButton(
                        "← BACK",
                        navy,
                        Color.WHITE
                );

        JButton calculate =
                createButton(
                        "GENERATE RESULT",
                        green,
                        Color.WHITE
                );

        back.addActionListener(
                e -> showStudentPage()
        );

        calculate.addActionListener(
                e -> calculateResult()
        );

        buttons.add(back);
        buttons.add(calculate);

        page.add(buttons);

        mainPanel.add(
                page,
                BorderLayout.CENTER
        );

        refresh();
    }

    // ============================================================
    // CALCULATE RESULT
    // ============================================================

    void calculateResult() {

        try {

            for (int i = 0; i < markFields.length; i++) {

                String value =
                        markFields[i]
                                .getText()
                                .trim();

                if (value.isEmpty()) {

                    error(
                            "Enter marks for "
                                    + subjects[i]
                    );

                    return;
                }

                int mark =
                        Integer.parseInt(value);

                if (mark < 0 || mark > 100) {

                    error(
                            "Marks must be between 0 and 100."
                    );

                    return;
                }

                marks[i] = mark;
            }

            showResultPage();

        } catch (NumberFormatException e) {

            error(
                    "Please enter valid numeric marks."
            );
        }
    }

    // ============================================================
    // RESULT PAGE
    // ============================================================

    void showResultPage() {

        mainPanel.removeAll();

        mainPanel.add(
                createSidebar(),
                BorderLayout.WEST
        );

        JPanel page =
                createPagePanel();

        page.add(
                createPageTitle(
                        "Performance Report",
                        "Detailed academic analysis of your marks."
                )
        );

        page.add(
                Box.createVerticalStrut(20)
        );

        // BACKEND CONNECTION
        GradeCalculator calculator =
                new GradeCalculator(marks);

        int total =
                calculator.calculateTotal();

        double average =
                calculator.calculateAverage();

        double percentage =
                calculator.calculatePercentage();

        String grade =
                calculator.calculateGrade();

        boolean pass =
                calculator.isPass();

        // --------------------------------------------------------
        // STUDENT HEADER
        // --------------------------------------------------------

        JPanel profile =
                new JPanel(
                        new BorderLayout()
                );

        profile.setBackground(navy);

        profile.setBorder(
                new EmptyBorder(
                        18, 25, 18, 25
                )
        );

        JLabel student =
                new JLabel(
                        "<html><b>"
                                + studentName
                                + "</b><br>"
                                + rollNumber
                                + " | "
                                + department
                                + " | "
                                + year
                                + "</html>"
                );

        student.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        student.setForeground(Color.WHITE);

        profile.add(
                student,
                BorderLayout.CENTER
        );

        JLabel gradeBadge =
                new JLabel(
                        "GRADE  " + grade
                );

        gradeBadge.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        gradeBadge.setForeground(Color.WHITE);

        profile.add(
                gradeBadge,
                BorderLayout.EAST
        );

        page.add(profile);

        page.add(
                Box.createVerticalStrut(20)
        );

        // --------------------------------------------------------
        // STATISTICS
        // --------------------------------------------------------

        JPanel stats =
                new JPanel(
                        new GridLayout(
                                1, 4, 15, 15
                        )
                );

        stats.setOpaque(false);

        stats.add(
                createStatCard(
                        "TOTAL",
                        total + " / 500",
                        blue
                )
        );

        stats.add(
                createStatCard(
                        "AVERAGE",
                        String.format(
                                "%.2f",
                                average
                        ),
                        purple
                )
        );

        stats.add(
                createStatCard(
                        "PERCENTAGE",
                        String.format(
                                "%.2f%%",
                                percentage
                        ),
                        orange
                )
        );

        stats.add(
                createStatCard(
                        "STATUS",
                        pass ? "PASS" : "FAIL",
                        pass ? green : red
                )
        );

        page.add(stats);

        page.add(
                Box.createVerticalStrut(20)
        );

        // --------------------------------------------------------
        // SUBJECT PERFORMANCE
        // --------------------------------------------------------

        JPanel performance =
                new JPanel();

        performance.setBackground(Color.WHITE);

        performance.setLayout(
                new BoxLayout(
                        performance,
                        BoxLayout.Y_AXIS
                )
        );

        performance.setBorder(
                new CompoundBorder(
                        new LineBorder(lightGrey),
                        new EmptyBorder(
                                15, 20, 15, 20
                        )
                )
        );

        JLabel performanceTitle =
                new JLabel(
                        "Subject-wise Performance"
                );

        performanceTitle.setFont(headingFont);

        performanceTitle.setForeground(navy);

        performance.add(performanceTitle);

        performance.add(
                Box.createVerticalStrut(12)
        );

        for (int i = 0; i < subjects.length; i++) {

            performance.add(
                    createSubjectPerformance(
                            subjects[i],
                            marks[i]
                    )
            );

            performance.add(
                    Box.createVerticalStrut(8)
            );
        }

        JScrollPane scroll =
                new JScrollPane(performance);

        scroll.setBorder(null);

        page.add(scroll);

        page.add(
                Box.createVerticalStrut(15)
        );

        // --------------------------------------------------------
        // REMARK FROM BACKEND
        // --------------------------------------------------------

        JLabel remark =
                new JLabel(
                        "<html><b>Performance Remark:</b> "
                                + calculator.getRemark()
                                + "</html>"
                );

        remark.setFont(normalFont);

        remark.setForeground(navy);

        page.add(remark);

        page.add(
                Box.createVerticalStrut(15)
        );

        // --------------------------------------------------------
        // BUTTONS
        // --------------------------------------------------------

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        buttons.setOpaque(false);

        JButton edit =
                createButton(
                        "← EDIT MARKS",
                        navy,
                        Color.WHITE
                );

        JButton gradeInfo =
                createButton(
                        "GRADE SYSTEM",
                        purple,
                        Color.WHITE
                );

        JButton newStudent =
                createButton(
                        "NEW STUDENT",
                        blue,
                        Color.WHITE
                );

        edit.addActionListener(
                e -> showMarksPage()
        );

        gradeInfo.addActionListener(
                e -> showGradePage()
        );

        newStudent.addActionListener(
                e -> resetApplication()
        );

        buttons.add(edit);
        buttons.add(gradeInfo);
        buttons.add(newStudent);

        page.add(buttons);

        mainPanel.add(
                page,
                BorderLayout.CENTER
        );

        refresh();
    }

    // ============================================================
    // STAT CARD
    // ============================================================

    JPanel createStatCard(
            String title,
            String value,
            Color color) {

        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(Color.WHITE);

        card.setBorder(
                new CompoundBorder(
                        new LineBorder(color, 2),
                        new EmptyBorder(
                                12, 10, 12, 10
                        )
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        titleLabel.setForeground(grey);

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21
                )
        );

        valueLabel.setForeground(color);

        valueLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(6)
        );

        card.add(valueLabel);

        return card;
    }

    // ============================================================
    // SUBJECT PERFORMANCE
    // ============================================================

    JPanel createSubjectPerformance(
            String subject,
            int mark) {

        JPanel panel =
                new JPanel(
                        new BorderLayout(15, 0)
                );

        panel.setBackground(Color.WHITE);

        JLabel label =
                new JLabel(subject);

        label.setFont(boldFont);

        label.setForeground(navy);

        label.setPreferredSize(
                new Dimension(190, 30)
        );

        JProgressBar progress =
                new JProgressBar(0, 100);

        progress.setValue(mark);

        progress.setStringPainted(true);

        progress.setString(
                mark + " / 100"
        );

        progress.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        panel.add(
                label,
                BorderLayout.WEST
        );

        panel.add(
                progress,
                BorderLayout.CENTER
        );

        return panel;
    }

    // ============================================================
    // GRADE PAGE
    // ============================================================

    void showGradePage() {

        mainPanel.removeAll();

        mainPanel.add(
                createSidebar(),
                BorderLayout.WEST
        );

        JPanel page =
                createPagePanel();

        page.add(
                createPageTitle(
                        "Academic Grading System",
                        "Understand how percentage is converted into grades."
                )
        );

        page.add(
                Box.createVerticalStrut(30)
        );

        JPanel table =
                new JPanel(
                        new GridLayout(
                                7, 3, 1, 1
                        )
                );

        table.setBackground(lightGrey);

        String[][] data = {

                {"PERCENTAGE", "GRADE", "DESCRIPTION"},

                {"90 - 100%", "A+",
                        "Outstanding"},

                {"80 - 89%", "A",
                        "Excellent"},

                {"70 - 79%", "B",
                        "Very Good"},

                {"60 - 69%", "C",
                        "Good"},

                {"50 - 59%", "D",
                        "Average"},

                {"Below 50%", "F",
                        "Needs Improvement"}
        };

        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data[i].length; j++) {

                JLabel cell =
                        new JLabel(
                                data[i][j],
                                SwingConstants.CENTER
                        );

                cell.setOpaque(true);

                cell.setBackground(
                        i == 0
                                ? navy
                                : Color.WHITE
                );

                cell.setForeground(
                        i == 0
                                ? Color.WHITE
                                : navy
                );

                cell.setFont(
                        i == 0
                                ? boldFont
                                : normalFont
                );

                table.add(cell);
            }
        }

        page.add(table);

        page.add(
                Box.createVerticalStrut(30)
        );

        JPanel rule =
                new JPanel(new BorderLayout());

        rule.setBackground(
                new Color(
                        255, 245, 230
                )
        );

        rule.setBorder(
                new CompoundBorder(
                        new LineBorder(orange),
                        new EmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );

        JLabel ruleText =
                new JLabel(
                        "<html><b>PASSING RULE</b><br>"
                                + "A minimum of 35 marks is required "
                                + "in every individual subject."
                                + "</html>"
                );

        ruleText.setFont(normalFont);

        ruleText.setForeground(navy);

        rule.add(ruleText);

        page.add(rule);

        page.add(
                Box.createVerticalGlue()
        );

        JButton home =
                createButton(
                        "← BACK TO DASHBOARD",
                        blue,
                        Color.WHITE
                );

        home.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        home.addActionListener(
                e -> showDashboard()
        );

        page.add(home);

        mainPanel.add(
                page,
                BorderLayout.CENTER
        );

        refresh();
    }

    // ============================================================
    // RESET
    // ============================================================

    void resetApplication() {

        studentName = "";
        rollNumber = "";
        department = "";
        year = "";

        marks = new int[5];

        nameField = null;
        rollField = null;
        departmentField = null;
        yearBox = null;

        markFields = new JTextField[5];

        showDashboard();
    }

    // ============================================================
    // ERROR
    // ============================================================

    void error(String message) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Input Required",
                JOptionPane.WARNING_MESSAGE
        );
    }

    // ============================================================
    // REFRESH
    // ============================================================

    void refresh() {

        mainPanel.revalidate();

        mainPanel.repaint();
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {

                UIManager.setLookAndFeel(
                        UIManager
                                .getSystemLookAndFeelClassName()
                );

            } catch (Exception ignored) {
            }

            StudentGradeCalculator app =
                    new StudentGradeCalculator();

            app.setVisible(true);
        });
    }
}
