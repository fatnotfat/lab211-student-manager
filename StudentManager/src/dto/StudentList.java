/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Collection;
import java.util.HashMap;
import mylib.Validation;

/**
 *
 * @author admin
 */
public class StudentList {

    private HashMap<String, Student> stList;

    public StudentList() {
        stList = new HashMap<>();
    }

    public Student inputInformationOfStudent() {
        //nhap thong tin hoc sinh
        boolean error;
        Student st = new Student();
        //nhap id student: co 2 dieu kien: dieu kien dau tien sinh vien nhap phai dung format, dieu kien tiep theo 
        //la sinh vien nhap phai khong duoc duplicated, neu co loi thi in thong bao ra man hinh va khi thuc hien
        //xong cau lenh thi phai in ra man hinh thong bao co muon tiep tuc hay khong.
        do {
            try {
                String studentID;
                do {
                    studentID = Validation.inputString("Input student ID: ");
                    if (!checkStudentByID(studentID)) {
                        st.setStudentID(studentID);
                    } else {
                        System.out.println("Student ID was duplicated! Please try again!");
                    }
                } while (Validation.checkStudentIDFormat(studentID) == false || checkStudentByID(studentID));
                error = false;
            } catch (Exception e) {
                System.out.println("The input should not be the blank! Please try again!");
                error = true;
            }
        } while (error);
        //nhap first name
        do {
            try {
                String firstName = Validation.inputString("Input first name of student: ");
                st.setFirstName(firstName);
                error = false;
            } catch (Exception e) {
                System.out.println("The input should not be the blank! Please try again!");
                error = true;
            }
        } while (error);
        //nhap last name
        do {
            try {
                String lastName = Validation.inputString("Input last name of student: ");
                st.setLastName(lastName);
                error = false;
            } catch (Exception e) {
                System.out.println("The input should not be the blank! Please try again!");
                error = true;
            }
        } while (error);
        //nhap gioi tinh co dung format hay ko
        boolean gender;
        do {
            try {
                gender = Validation.inputBoolean("Input gender (male or female. If male, type TRUE else if female, type FALSE): ");
                st.setGender(gender);
                error = false;
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again!");
                error = true;
            }
        } while (error);
        //kiem tra ngay thang nam sinh
        do {
            try {
                String dateOfBirth;
                do {
                    dateOfBirth = Validation.inputString("Input date of birth follow the format dd/mm/yyyy: ");
                    st.setDateOfBirth(dateOfBirth);
                } while (Validation.checkDateFormatValid(dateOfBirth) == false);
                error = false;
            } catch (Exception e) {
                System.out.println("The input should not be the blank! Please try again!");
                error = true;
            }
        } while (error);
        //kiem tra email co dung format hay ko
        do {
            try {
                String email;
                do {
                    email = Validation.inputString("Input email: ");
                    st.setEmail(email);
                } while (Validation.checkEmailFormat(email) == false);
                error = false;
            } catch (Exception e) {
                System.out.println("The input should not be the blank! Please try again!");
                error = true;
            }
        } while (error);

        //kiem tra phone format
        do {
            try {
                String phone;
                do {
                    phone = Validation.inputString("Input phone number: ");
                    st.setPhone(phone);
                } while (Validation.checkPhoneFormat(phone) == false);
                error = false;
            } catch (Exception e) {
                System.out.println("The input should not be the blank! Please try again!");
                error = true;
            }
        } while (error);
        System.out.println("Added successfull!");
        return st;
    }

    public boolean addStudent(Student s) {
        //them student va key vao hashmap
        //key: studentID
        //value: Student(Bao gom cac thuoc tinh con lai cua student)

        if (checkStudent(s)) {
            return false;
        }
        stList.put(s.getStudentID(), s);
        return true;
    }

    public void displayStudent() {
        if (stList.isEmpty()) {
            System.out.println("The student list is empty!");
        } else {
            Collection<Student> value = stList.values();
            System.out.println("=====================================================STUDENT_LIST=====================================================");
            System.out.println("|++ Student ID ++|++ First name ++|++ Last name ++|++ Date of Birth ++|++             Email          ++|++    Phone    ++|");
            for (Student student : value) {
                System.out.format("|%-16S|%-16S|%-15S|%-19s|%-32s|%-17s|%n", student.getStudentID(), student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getEmail(), student.getPhone());
            }

        }
    }

    //kiem tra list co trong hay khong
    public boolean checkList() {
        return stList.isEmpty();
    }

    //kiem tra student co trong danh sach hay khong
    public boolean checkStudent(Student s) {
        return stList.containsKey(s.getStudentID());
    }

    //kiem tra student trong danh sach bang id
    public boolean checkStudentByID(String ID) {
        Collection<Student> value = stList.values();
        for (Student student : value) {
            if (student.getStudentID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public Student returnStudent(String ID) {
        Collection<String> value = stList.keySet();
        for (String string : value) {
            if(string.equalsIgnoreCase(ID)){
                return stList.get(string);
            }
        }
        return null;
    }

    public boolean removeStudent(String ID) {
        Student s = stList.get(ID);
        if (s == null) {
            return false;
        } else if (checkStudentByID(ID)) {
            stList.remove(s.getStudentID(), s);
            return true;
        }
        return false;
    }

    public boolean updateStudent(String ID) {
        if (checkStudentByID(ID)) {
            try {
                Student st = returnStudent(ID);
                System.out.println("Student has first name, last name, gender, date of birth, email and phone.");
                System.out.println("- If you want to update first name, type 'FN'. ");
                System.out.println("- If you want to update last name, type 'LN'. ");
                System.out.println("- If you want to update gender, type 'G'. ");
                System.out.println("- If you want to update date of birth, type 'DOB'. ");
                System.out.println("- If you want to update email, type 'E'. ");
                System.out.println("- If you want to update phone, type 'P'. ");
                System.out.println("*Note: Uppercase or lowercase accepted for all the data input: ");
                String s = Validation.inputString("Input which information that you want to update: ");
                if (s.equalsIgnoreCase("FN")) {
                    try {
                        String firstName = Validation.inputString("Input first name of student you want to change: ");
                        st.setFirstName(firstName);
                    } catch (Exception e) {
                        System.out.println("The name of student is unchange!");
                        return false;
                    }
                } else if (s.equalsIgnoreCase("LN")) {
                    try {
                        String lastName = Validation.inputString("Input last name of student you want to change: ");
                        st.setLastName(lastName);
                    } catch (Exception e) {
                        System.out.println("The name of student is unchange!");
                        return false;
                    }
                } else if (s.equalsIgnoreCase("G")) {
                    try {
                        boolean gender = Validation.inputBoolean("Input gender you want to change (male or female. If male, type TRUE else if female, type FALSE): ");
                        st.setGender(gender);
                    } catch (Exception e) {
                        System.out.println("The gender of student is unchange!");
                        return false;
                    }
                } else if (s.equalsIgnoreCase("DOB")) {

                    try {
                        String dateOfBirth;
                        do {
                            dateOfBirth = Validation.inputString("Input date of birth you want to change that need to follow the format dd/mm/yyyy: ");
                            st.setDateOfBirth(dateOfBirth);
                        } while (Validation.checkDateFormatValid(dateOfBirth) == false);
                    } catch (Exception e) {
                        System.out.println("The date of birth of student is unchange!");
                        return false;
                    }
                } else if (s.equalsIgnoreCase("E")) {

                    try {
                        String email;
                        do {
                            email = Validation.inputString("Input email of student you want to change: ");
                            st.setEmail(email);
                        } while (Validation.checkEmailFormat(email) == false);
                    } catch (Exception e) {
                        System.out.println("The email of student is unchange!");
                        return false;
                    }
                } else if (s.equalsIgnoreCase("P")) {

                    try {
                        String phone;
                        do {
                            phone = Validation.inputString("Input phone number of student that you want to change: ");
                            st.setPhone(phone);
                        } while (Validation.checkPhoneFormat(phone) == false);
                    } catch (Exception e) {
                        System.out.println("The phone number of student is unchange!");
                        return false;
                    }
                } else {
                    System.out.println("The student information is unchange!");
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again!");
                return false;
            }
            return true;
        }
        return false;
    }
}
