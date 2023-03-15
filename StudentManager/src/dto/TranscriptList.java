/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Collections;
import mylib.Validation;

/**
 *
 * @author admin
 */
public class TranscriptList {

    private ArrayList<Transcript> trsList;

    public TranscriptList() {
        trsList = new ArrayList<>();
    }

    public void addToTranscriptList(Transcript t) {
        this.trsList.add(t);
    }

    //ham nay de tra ve bang diem dua tren student id va subject id
    public Transcript returnTranscriptByStudentIDAndSubjectID(String stID, String sbID) {
        for (Transcript transcript : trsList) {
            if (transcript.getStObj().getStudentID().equalsIgnoreCase(stID) && transcript.getsObj().getSubjectID().equalsIgnoreCase(sbID)) {
                return transcript;
            }
        }
        return null;
    }

    //ham nay de tra ve bang diem hoc sinh dua tren student id
    public Transcript returnTranscriptByStudentID(ArrayList<Transcript> trsList, String stID) {
        for (Transcript transcript : trsList) {
            if(transcript.getStObj().getStudentID().equalsIgnoreCase(stID)){
                return transcript;
            }
        }
        return null;
    }

    //ham nay de tra ve danh sach dua tren subject id
    public Transcript returnTranscriptBySubjectID(ArrayList<Transcript> trsList, String sbID) {
        for (Transcript transcript : trsList) {
            if (transcript.getsObj().getSubjectID().equalsIgnoreCase(sbID)) {
                return transcript;
            }
        }
        return null;
    }
    //ham nay de nhap thong tin bang diem cua sinh vien
    public Transcript inputTranscriptInformation(Student st, Subject sb) {
        boolean error;
        Transcript trs = new Transcript();
        //phan nay de truyen du lieu student va subject vao bang diem
        trs.setStObj(st);
        trs.setsObj(sb);
        //phan code nay dung de nhap diem lab
        do {
            try {
                double labMark = Validation.inputDouble("Input lab mark: ");
                if (labMark < 0.0 || labMark > 10.0) {
                    System.out.println("The number of marks you enter must be between 0 and 10!");
                    error = true;
                } else {
                    trs.setLabMark(labMark);
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again! ");
                error = true;
            }
        } while (error);

        //phan code nay de nhap diem progress test
        do {
            try {
                double progressTestMark = Validation.inputDouble("Input progress test mark: ");
                if (progressTestMark < 0.0 || progressTestMark > 10.0) {
                    System.out.println("The number of marks you enter must be between 0 and 10!");
                    error = true;
                } else {
                    trs.setProgressTestMark(progressTestMark);
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again! ");
                error = true;
            }
        } while (error);

        //phan code nay de nhap diem final
        do {
            try {
                double finalMark = Validation.inputDouble("Input final mark: ");
                if (finalMark < 0.0 || finalMark > 10.0) {
                    System.out.println("The number of marks you enter must be between 0 and 10!");
                    error = true;
                } else {
                    trs.setFinalMark(finalMark);
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again! ");
                error = true;
            }
        } while (error);
        return trs;
    }
    
    
    //ham nay de kiem tra xem du lieu da duoc nhap truoc do hay chua
    public boolean checkOverwrite(Transcript trs) {
        if (trs != null) {
            return trs.getLabMark() != -1 || trs.getProgressTestMark() != -1 || trs.getFinalMark() != -1;
        }
        return false;
    }
    //kiem tra danh sach co trong hay khong
    public boolean checkList() {
        return trsList.isEmpty();
    }

    
    //ham nay de cap nhat thong tin cua bang diem 
    public Transcript updateTranscriptInformation(Transcript trs) {
        boolean error;
        //phan code nay dung de override diem lab

        do {
            try {
                double labMark = Validation.inputDouble("Input new lab mark: ");
                if (labMark < 0.0 || labMark > 10.0) {
                    System.out.println("The number of marks you enter must be between 0 and 10!");
                    error = true;
                } else {
                    trs.setLabMark(labMark);
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again! ");
                error = true;
            }
        } while (error);

        //phan code nay de override diem progress
        do {
            try {
                double progressTestMark = Validation.inputDouble("Input new progress test mark: ");
                if (progressTestMark < 0.0 || progressTestMark > 10.0) {
                    System.out.println("The number of marks you enter must be between 0 and 10!");
                    error = true;
                } else {
                    trs.setProgressTestMark(progressTestMark);
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again! ");
                error = true;
            }
        } while (error);
        //phan code nay de override diem final

        do {
            try {
                double finalMark = Validation.inputDouble("Input new final mark: ");
                if (finalMark < 0.0 || finalMark > 10.0) {
                    System.out.println("The number of marks you enter must be between 0 and 10!");
                    error = true;
                } else {
                    trs.setFinalMark(finalMark);
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Wrong format! Please try again! ");
                error = true;
            }
        } while (error);
        return trs;
    }
    //ham nay de xoa bang diem cua sinh vien do trong danh sach
    public void removeTranscript(Transcript trs) {
        for (Transcript transcript : trsList) {
            if (transcript == trs) {
                trsList.remove(transcript);
            }
        }
    }
    
    //ham nay de check co pass hay khong 
    public String checkStatus(Transcript trs) {
        if (trs.average() > 4.0) {
            return "PASS";
        }
        return "NOT PASS";
    }
    //ham nay de sort list bang ten cua mon hoc
    public void sortBySubjectName() {
        Collections.sort(this.trsList, (Transcript trs1, Transcript trs2) -> trs1.getsObj().getSubjectName().compareToIgnoreCase(trs2.getsObj().getSubjectName()));
    }
    //ham nay de sort list bang ten cua sinh vien
    public void sortByStudentName() {
        Collections.sort(this.trsList, (Transcript trs1, Transcript trs2) -> trs1.getStObj().getFirstName().compareToIgnoreCase(trs2.getStObj().getFirstName()));
    }

    //ham nay de in ra bang diem theo sinh vien
    public void displayStudentGradeReport(String stID) {
        sortBySubjectName();
        if (trsList != null) {
            Transcript trs = returnTranscriptByStudentID(trsList, stID);
            System.out.println("=================STUDENT_GRADE_REPORT====================");
            System.out.println("- Student ID: " + trs.getStObj().getStudentID().toUpperCase());
            System.out.println("- Student name: " + trs.getStObj().getFirstName().toUpperCase() + " " + trs.getStObj().getLastName().toUpperCase());
            System.out.println("List of student sort by Subject Name: ");
            System.out.println("|++  No  ++|+++++++ Subject name ++++++++|++	Average	mark   ++|++ Status ++|");
            System.out.println("-------------------------------------------------------------------------------");
            for (Transcript transcript : trsList) {
                if (transcript.getStObj().getStudentID().equalsIgnoreCase(stID)) {
                    System.out.printf("    %-5S|           %-10S|        %-5.2f     |        %-3S   |%n", transcript.getsObj().getSubjectID(), transcript.getsObj().getSubjectName(), transcript.average(), checkStatus(transcript));
                }
            }
        } else {
            System.out.println("The student's ID is not found!");
        }
    }
    //ham nay de in ra bang diem theo mon hoc
    public void displaySubjectGradeReport(String sbID) {
        sortByStudentName();
        if (trsList != null) {
            Transcript trs = returnTranscriptBySubjectID(trsList, sbID);
            System.out.println("=================SUBJECT_GRADE_REPORT====================");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("- Subject ID: " + trs.getsObj().getSubjectID().toUpperCase());
            System.out.println("- Subject name: " + trs.getsObj().getSubjectName().toUpperCase());
            System.out.println("List of subject sort by Student Name: ");
            System.out.println("|++  Student ID  ++|+++++++ Student name ++++++++|++	Average	mark   ++|++ Status ++|");
            System.out.println("---------------------------------------------------------------------------------------");
            for (Transcript transcript : trsList) {
                if (transcript.getsObj().getSubjectID().equalsIgnoreCase(sbID)) {
                    System.out.printf("    %-5S|           %-10S|        %-5.2f     |        %-3s   |%n", transcript.getStObj().getStudentID(), transcript.getStObj().getFirstName() + " " + transcript.getStObj().getLastName(), transcript.average(), checkStatus(transcript));
                }
            }
        } else {
            System.out.println("The subject's ID is not found!");
        }
    }

}
