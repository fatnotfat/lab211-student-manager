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
public class SubjectList {

    private HashMap<String, Subject> sbList;

    public SubjectList() {
        sbList = new HashMap<>();
    }

    public boolean addSubject(Subject sb) {
        //them subject va key vao hashmap
        //key: subjectID
        //value: Subject(Bao gom cac thuoc tinh con lai cua subject)
        String k = sb.getSubjectID();
        if (sbList.containsKey(k)) {
            return false;
        }
        sbList.put(k, sb);
        return true;
    }

    public Subject inputSubjectInformation() {
        //nhap thong tin mon hoc
        boolean error;
        Subject sb = new Subject();

        //nhap ma mon hoc
        do {
            try {
                String subjectID;
                do {
                    subjectID = Validation.inputString("Input subject ID: ");
                    if (!checkSubjectByID(subjectID)) {
                        sb.setSubjectID(subjectID);
                        error = false;
                    } else {
                        System.out.println("The subject's ID was duplicated!");
                        error = true;
                    }
                } while (checkSubjectByID(subjectID));
            } catch (Exception e) {
                System.out.println("Error! Please try again!");
                error = true;
            }
        } while (error);

        //nhap ten mon hoc
        do {
            try {
                String subjectName;
                do {
                    subjectName = Validation.inputString("Input subject name: ");
                    if (!checkSubjectName(subjectName)) {
                        sb.setSubjectName(subjectName);
                        error = false;
                    } else {
                        System.out.println("The subject's name was duplicated!");
                        error = true;
                    }
                } while (checkSubjectName(subjectName));
            } catch (Exception e) {
                System.out.println("Error! Please try again!");
                error = true;
            }
        } while (error);
        //nhap so tin chi
        do {
            try {
                int credit;
                credit = Validation.inputNumber("Input credit: ");
                sb.setCredit(credit);
                error = false;
            } catch (Exception e) {
                System.out.println("Error! Please try again!");
                error = true;
            }
        } while (error);
        System.out.println("Added successfull!");
        return sb;
    }

    public void displaySubject() {
        if (sbList.isEmpty()) {
            System.out.println("Subject list is empty!");
        } else {
            Collection<Subject> value = sbList.values();
            System.out.println("|++ No ++|+++++++ Subject name ++++++++|+++ Credit +++|");
            for (Subject subject : value) {
                System.out.printf("|%-8S|%-29S|%-14d| %n", subject.getSubjectID(), subject.getSubjectName(), subject.getCredit());
            }
        }
    }
    
    public void displaySubject1(){
        if(sbList.isEmpty()){
            System.out.println("Subject list is empty!");
        } else{
            Collection<Subject> value = sbList.values();
            
        }
    }

    public boolean checkSubjectName(String name) {
        Collection<Subject> value = sbList.values();
        for (Subject subject : value) {
            if (subject.getSubjectName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkList() {
        return sbList.isEmpty();
    }
    
    public Subject returnSubject(String ID){
        Collection<String> value = sbList.keySet();
        for (String string : value) {
            if(string.equalsIgnoreCase(ID)){
                return sbList.get(string);
            }
        }
        return null;
    }
    
    public boolean checkSubject(Subject sb) {
        return sbList.containsKey(sb.getSubjectID());
    }

    public boolean checkSubjectByID(String ID) {
        return sbList.containsKey(ID);
    }

    public boolean removeSubject(String ID) {
        Subject sb = sbList.get(ID);
        if (sb == null) {
            return false;
        } else if (checkSubjectByID(ID)) {
            sbList.remove(sb.getSubjectID(), sb);
            return true;
        }
        return false;
    }

    public boolean updateSubject(String ID) {
        if (checkSubjectByID(ID)) {
            try {
                Subject sb = returnSubject(ID);
                System.out.println("Subject has name and credit");
                System.out.println("- If you want to update name of subject, type 'N'. ");
                System.out.println("- IF you want to update credit of subject, type 'C'. ");
                System.out.println("*Note: Uppercase or lowercase accepted for all the data input: ");
                String s = Validation.inputString("Input which information that you want to update: ");
                if (s.equalsIgnoreCase("N")) {
                    try {
                        String subjectName;
                        do {
                            subjectName = Validation.inputString("Input subject's name you want to change: ");
                            if (!checkSubjectName(subjectName)) {
                                sb.setSubjectName(subjectName);
                            } else {
                                System.out.println("Subject's name was duplicated! Please try again!");
                            }
                        } while (!checkSubjectName(subjectName));
                    } catch (Exception e) {
                        System.out.println("The subject's name is unchange!");
                        return false;
                    }
                } else if (s.equalsIgnoreCase("C")) {
                    try {
                        int subjectCredit;
                        subjectCredit = Validation.inputNumber("Input subject's credit you want to change: ");
                        if (subjectCredit > 0 && subjectCredit < 10) {
                            sb.setCredit(subjectCredit);
                            System.out.println("Updated successfull!");
                        } else {
                            System.out.println("The subject's credit is unchange!");
                            return false;
                        }
                    } catch (Exception e) {
                        System.out.println("The subject's credit is unchange!");
                        return false;
                    }
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
