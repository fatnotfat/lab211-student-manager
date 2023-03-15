/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import dto.StudentList;
import dto.SubjectList;
import dto.Transcript;
import dto.TranscriptList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Menu {

    StudentList stList = new StudentList();
    SubjectList sbList = new SubjectList();
    TranscriptList trsList = new TranscriptList();

    public Menu(StudentList stList, SubjectList sbList, TranscriptList trsList) {
        this.stList = stList;
        this.sbList = sbList;
        this.trsList = trsList;
    }

    public Menu() {
    }
    
    // ham nay de nhan du lieu cua nguoi dung nhap vao va in ra menu
    public int getUserChoice() {
        int choice;
        System.out.println("======================Menu======================");
        System.out.println("1. Add new student.");
        System.out.println("2. Update student.");
        System.out.println("3. Add new subject.");
        System.out.println("4. Update subject.");
        System.out.println("5. Enter grade.");
        System.out.println("6. Student grade report.");
        System.out.println("7. Subject grade report.");
        System.out.println("Other- Quit.");
        System.out.println("Your choice: ");
        try {
            choice = Validation.inputNumber("Select the number of function you want to execute: ");
        } catch (Exception e) {
            choice = 8;
        }
        return choice;
    }
    
    //nhap thong tin sinh vien, neu sai format hoac sinh vien khong ton tai thi hoi co muon tiep tuc hay khong
    public void function1() {
        boolean flags = true;
        while (flags) {
            try {
                if (stList.addStudent(stList.inputInformationOfStudent())) {
                    System.out.println("");
                } else {
                    System.out.println("Added failed!");
                }
                stList.displayStudent();
                String s = Validation.inputString("Do you want add more student (yes/no): ");
                flags = s.equalsIgnoreCase("yes");
                if (flags == false) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("You just entered the wrong format, please re-type again!");
                break;
            }
        }
    }

    public void function2() {
        int choice1 = 0;
        boolean flags = true;
        if (!stList.checkList()) {
            while (flags) {
                do {
                    System.out.println("-------------------------------------");
                    System.out.println("    2.1. Update student.");
                    System.out.println("    2.2. Delete student.");
                    System.out.println("    Others. Quit!");
                    System.out.println("*Note: Choice must be an integer number (1 or 2).");
                    try {
                        choice1 = Validation.inputNumber("Input choice: ");
                        //type function code here
                        switch (choice1) {
                            case 1: {
                                //TH1: Update student, nhap ID va kiem tra student
                                String s = Validation.inputString("Input student's ID: ");
                                if (stList.checkStudentByID(s) == false) {
                                    System.out.println("Student not found!");
                                } else {
                                    if (stList.updateStudent(s)) {
                                        System.out.println("Updated successfull!");
                                    } else {
                                        System.out.println("Updated failed!");
                                    }
                                }
                                break;
                            }
                            case 2: {
                                //TH2: Remove student, nhap ID vao kiem tra student
                                String s = Validation.inputString("Input student's ID: ");
                                if (stList.checkStudentByID(s) == false) {
                                    System.out.println("Student not found!");
                                } else {
                                    String choice2;
                                    choice2 = Validation.inputString("Are you sure that delete this student? (yes/no): ");
                                    if (choice2.equalsIgnoreCase("yes")) {
                                        stList.removeStudent(s);
                                        System.out.println("Deleted successfull!");
                                    } else {
                                        System.out.println("Deleted failed!");
                                    }
                                }
                                break;
                            }
                            default:
                                System.out.println("Backing to the main menu .....");
                                flags = false;
                                break;
                        }

                        if (flags == false) {
                            break;
                        }
                        stList.displayStudent();
                        System.out.println("Do you want to continue or back to the main menu?");
                        String msg = Validation.inputString("Input yes or no and others are quit: ");
                        flags = msg.equalsIgnoreCase("yes");
                        if (flags == false) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Backing to the main menu .....");
                        flags = false;
                    }
                } while (choice1 > 0 && choice1 < 3);
            }
        } else {
            System.out.println("You must add student before to do this function!");
        }
    }

    public void function3() {
        boolean flags = true;
        while (flags) {
            try {
                if (sbList.addSubject(sbList.inputSubjectInformation())) {
                    System.out.println("");
                } else {
                    System.out.println("Added failed!");
                }
                sbList.displaySubject();
                String s = Validation.inputString("Do you want add more subject (yes/no): ");
                flags = s.equalsIgnoreCase("yes");
                if (flags == false) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("You just entered the wrong format, please re-type again!");
                break;
            }
        }
    }

    public void function4() {
        int choice2 = 0;
        boolean flags = true;
        if (!sbList.checkList()) {
            while (flags) {
                do {
                    System.out.println("-------------------------------------");
                    System.out.println("    2.1. Update subject.");
                    System.out.println("    2.2. Delete subject.");
                    System.out.println("    Others. Quit!");
                    System.out.println("*Note: Choice must be an integer number (1 or 2).");
                    try {
                        choice2 = Validation.inputNumber("Input choice: ");
                        //type function code here
                        switch (choice2) {
                            case 1: {
                                //TH1: Update subject, nhap ID va kiem tra subject
                                String s = Validation.inputString("Input subject's ID that you want to update: ");
                                if (sbList.checkSubjectByID(s) == false) {
                                    System.out.println("Subject not found!");
                                } else {
                                    sbList.updateSubject(s);
                                    System.out.println("Updated successfull!");
                                }
                                break;
                            }
                            case 2: {
                                //TH2: Remove student, nhap ID vao kiem tra student
                                String s = Validation.inputString("Input subject's ID that you want to delete: ");
                                if (sbList.checkSubjectByID(s) == false) {
                                    System.out.println("Subject not found!");
                                } else {
                                    String choice3;
                                    choice3 = Validation.inputString("Are you sure that delete this subject? (yes/no): ");
                                    if (choice3.equalsIgnoreCase("yes")) {
                                        sbList.removeSubject(s);
                                        System.out.println("Deleted successfull!");
                                    } else {
                                        System.out.println("Deleted failed!");
                                    }
                                }
                                break;
                            }
                            default:
                                System.out.println("Backing to the main menu .....");
                                flags = false;
                                break;
                        }
                        if (flags == false) {
                            break;
                        }
                        sbList.displaySubject();
                        System.out.println("Do you want to continue or back to the main menu?");
                        String msg = Validation.inputString("Input yes or no and others are quit: ");
                        flags = msg.equalsIgnoreCase("yes");
                        if (flags == false) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Backing to the main menu .....");
                        flags = false;
                    }
                } while (choice2 > 0 && choice2 < 3);
            }
        } else {
            System.out.println("You must add subject before to do this function!");
        }
    }

    public void function5() {
        Transcript trs = new Transcript();
        boolean flags;
        if (!stList.checkList() && !sbList.checkList()) {
            do {
                try {
                    String stID = Validation.inputString("Input student's ID: ");
                    if (stList.checkStudentByID(stID)) {
                        String sbID = Validation.inputString("Input subject's ID: ");
                        if (sbList.checkSubjectByID(sbID)) {
                            trs = trsList.returnTranscriptByStudentIDAndSubjectID(stID, sbID);
                            if (!trsList.checkOverwrite(trs)) {
                                trs = trsList.inputTranscriptInformation(stList.returnStudent(stID), sbList.returnSubject(sbID));
                                trsList.addToTranscriptList(trs);
                                System.out.println("Added successfull!");
                            } else {
                                String choice3 = Validation.inputString("Student have already graded this subject, do you want to overwrite it or not? (type yes or no and upper case or lower case are allowed): ");
                                if (choice3.equalsIgnoreCase("yes")) {
                                    Transcript trs2 = trsList.returnTranscriptByStudentIDAndSubjectID(stID, sbID);
                                    trsList.updateTranscriptInformation(trs2);
                                }
                            }
                        } else {
                            System.out.println("Subject not found!");
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    System.out.println("Do you want to continue or back to the main menu?");
                    String msg = Validation.inputString("Input yes or no and others are quit: ");
                    flags = msg.equalsIgnoreCase("yes");
                    if (flags == false) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        } else {
            System.out.println("The student list or subject list is empty, please add them first!");
        }
    }

    public void function6() {
        boolean flags;
        if (!stList.checkList() && !sbList.checkList() && !trsList.checkList()) {
            do {
                try {
                    String stID = Validation.inputString("Input student's ID: ");
                    Scanner sc = new Scanner(System.in);
                    if (stList.checkStudentByID(stID)) {
                        trsList.displayStudentGradeReport(stID);
                    } else {
                        System.out.println("Student not found!");
                    }
                    System.out.println("Do you want to continue or back to the main menu?");
                    String msg = Validation.inputString("Input yes or no and others are quit: ");
                    flags = msg.equalsIgnoreCase("yes");
                    if (flags == false) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        } else if (stList.checkList() || sbList.checkList()) {
            System.out.println("The student list or subject list is empty, please add them first!");
        } else if (trsList.checkList()) {
            System.out.println("The transcript is empty! Please input marks before do this function!");
        }
    }

    public void function7() {
        boolean flags;
        if (!stList.checkList() && !sbList.checkList() && !trsList.checkList()) {
            do {
                try {
                    String sbID = Validation.inputString("Input subject's ID: ");
                    if (sbList.checkSubjectByID(sbID)) {
                        trsList.displaySubjectGradeReport(sbID);
                    } else {
                        System.out.println("Subject not found!");
                    }
                    System.out.println("Do you want to continue or back to the main menu?");
                    String msg = Validation.inputString("Input yes or no and others are quit: ");
                    flags = msg.equalsIgnoreCase("yes");
                    if (flags == false) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        } else if (stList.checkList() || sbList.checkList()) {
            System.out.println("The student list or subject list is empty, please add them first!");
        } else if (trsList.checkList()) {
            System.out.println("The transcript is empty! Please input marks before do this function!");
        }
    }

}
