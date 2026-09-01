// ============================================================
// STUDENT PERFORMANCE HUB
// FRONTEND JAVASCRIPT
// ============================================================


// ============================================================
// SUBJECTS
// ============================================================

const subjects = [
    "Java Programming",
    "Data Structures",
    "Database Management",
    "Computer Networks",
    "Operating Systems"
];


// ============================================================
// STUDENT DATA
// ============================================================

let student = {
    name: "",
    rollNumber: "",
    department: "",
    year: ""
};


// ============================================================
// PAGE NAVIGATION
// ============================================================

function showPage(pageName) {

    const pages =
        document.querySelectorAll(".page");

    pages.forEach(page => {

        page.classList.remove("active");

    });


    const selectedPage =
        document.getElementById(pageName);

    if (selectedPage) {

        selectedPage.classList.add("active");

    }


    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}


// ============================================================
// VALIDATE STUDENT
// ============================================================

function validateStudent() {

    const name =
        document.getElementById("studentName")
            .value
            .trim();

    const roll =
        document.getElementById("rollNumber")
            .value
            .trim();

    const department =
        document.getElementById("department")
            .value
            .trim();

    const year =
        document.getElementById("academicYear")
            .value;


    // NAME VALIDATION

    if (name === "") {

        alert("Please enter student name.");

        return;
    }


    // ROLL NUMBER VALIDATION

    if (roll === "") {

        alert("Please enter roll number.");

        return;
    }


    // DEPARTMENT VALIDATION

    if (department === "") {

        alert("Please enter department.");

        return;
    }


    // SAVE STUDENT DATA

    student.name = name;

    student.rollNumber = roll;

    student.department = department;

    student.year = year;


    // MOVE TO MARKS PAGE

    showPage("marks");
}


// ============================================================
// GET MARKS
// ============================================================

function getMarks() {

    let marks = [];

    for (let i = 0; i < 5; i++) {

        const input =
            document.getElementById(
                "mark" + i
            );

        const value =
            input.value.trim();


        // EMPTY

        if (value === "") {

            alert(
                "Enter marks for "
                + subjects[i]
            );

            return null;
        }


        const mark =
            Number(value);


        // NUMBER VALIDATION

        if (isNaN(mark)) {

            alert(
                "Please enter valid numeric marks for "
                + subjects[i]
            );

            return null;
        }


        // RANGE VALIDATION

        if (mark < 0 || mark > 100) {

            alert(
                "Marks must be between 0 and 100 for "
                + subjects[i]
            );

            return null;
        }


        marks.push(mark);
    }


    return marks;
}


// ============================================================
// CALCULATE TOTAL
// ============================================================

function calculateTotal(marks) {

    let total = 0;

    for (let mark of marks) {

        total += mark;
    }

    return total;
}


// ============================================================
// CALCULATE AVERAGE
// ============================================================

function calculateAverage(marks) {

    const total =
        calculateTotal(marks);

    return total / marks.length;
}


// ============================================================
// CALCULATE PERCENTAGE
// ============================================================

function calculatePercentage(marks) {

    const total =
        calculateTotal(marks);

    return (total / 500) * 100;
}


// ============================================================
// PASS / FAIL
// ============================================================

function isPass(marks) {

    for (let mark of marks) {

        if (mark < 35) {

            return false;
        }
    }

    return true;
}


// ============================================================
// CALCULATE GRADE
// ============================================================

function calculateGrade(percentage, pass) {

    if (!pass) {

        return "F";
    }


    if (percentage >= 90) {

        return "A+";
    }


    if (percentage >= 80) {

        return "A";
    }


    if (percentage >= 70) {

        return "B";
    }


    if (percentage >= 60) {

        return "C";
    }


    if (percentage >= 50) {

        return "D";
    }


    return "F";
}


// ============================================================
// PERFORMANCE REMARK
// ============================================================

function getRemark(percentage, pass) {

    if (!pass) {

        return "One or more subjects are below the passing mark. Focus on improving those subjects.";
    }


    if (percentage >= 90) {

        return "Outstanding performance! Keep maintaining this level.";
    }


    if (percentage >= 80) {

        return "Excellent performance! You are doing very well.";
    }


    if (percentage >= 70) {

        return "Very good performance. Keep working consistently.";
    }


    if (percentage >= 60) {

        return "Good performance. There is still room for improvement.";
    }


    if (percentage >= 50) {

        return "Average performance. More practice can improve your score.";
    }


    return "Needs improvement. Create a regular study plan.";
}


// ============================================================
// CALCULATE RESULT
// ============================================================

function calculateResult() {

    const marks =
        getMarks();


    // STOP IF INVALID

    if (marks === null) {

        return;
    }


    // CALCULATIONS

    const total =
        calculateTotal(marks);

    const average =
        calculateAverage(marks);

    const percentage =
        calculatePercentage(marks);

    const pass =
        isPass(marks);

    const grade =
        calculateGrade(
            percentage,
            pass
        );

    const remark =
        getRemark(
            percentage,
            pass
        );


    // ========================================================
    // DISPLAY STUDENT
    // ========================================================

    document.getElementById(
        "resultName"
    ).textContent =
        student.name;


    document.getElementById(
        "resultDetails"
    ).textContent =
        student.rollNumber
        + " | "
        + student.department
        + " | "
        + student.year;


    // ========================================================
    // DISPLAY GRADE
    // ========================================================

    document.getElementById(
        "resultGrade"
    ).textContent =
        grade;


    // ========================================================
    // DISPLAY STATISTICS
    // ========================================================

    document.getElementById(
        "totalMarks"
    ).textContent =
        total + " / 500";


    document.getElementById(
        "average"
    ).textContent =
        average.toFixed(2);


    document.getElementById(
        "percentage"
    ).textContent =
        percentage.toFixed(2) + "%";


    document.getElementById(
        "status"
    ).textContent =
        pass ? "PASS" : "FAIL";


    // ========================================================
    // CHANGE STATUS COLOR
    // ========================================================

    const statusCard =
        document.getElementById(
            "statusCard"
        );


    if (pass) {

        statusCard.classList.remove(
            "red-border"
        );

        statusCard.classList.add(
            "green-border"
        );

    } else {

        statusCard.classList.remove(
            "green-border"
        );

        statusCard.classList.add(
            "red-border"
        );
    }


    // ========================================================
    // SUBJECT PERFORMANCE
    // ========================================================

    for (let i = 0; i < 5; i++) {

        const progress =
            document.getElementById(
                "progress" + i
            );

        const score =
            document.getElementById(
                "score" + i
            );


        progress.style.width =
            marks[i] + "%";


        score.textContent =
            marks[i] + " / 100";
    }


    // ========================================================
    // REMARK
    // ========================================================

    document.getElementById(
        "remark"
    ).textContent =
        remark;


    // ========================================================
    // SHOW RESULT
    // ========================================================

    showPage("result");
}


// ============================================================
// RESET APPLICATION
// ============================================================

function resetApplication() {

    // RESET STUDENT

    student = {
        name: "",
        rollNumber: "",
        department: "",
        year: ""
    };


    // RESET STUDENT FORM

    document.getElementById(
        "studentName"
    ).value = "";


    document.getElementById(
        "rollNumber"
    ).value = "";


    document.getElementById(
        "department"
    ).value = "";


    document.getElementById(
        "academicYear"
    ).selectedIndex = 0;


    // RESET MARKS

    for (let i = 0; i < 5; i++) {

        document.getElementById(
            "mark" + i
        ).value = "";
    }


    // GO TO DASHBOARD

    showPage("dashboard");
}