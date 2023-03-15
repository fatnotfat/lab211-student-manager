/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

public class Transcript {

    private Subject sObj;
    private Student stObj;
    private double labMark;
    private double progressTestMark;
    private double finalMark;

    public Transcript() {
    }

    public Transcript(Subject sObj, Student stObj) {
        this.sObj = sObj;
        this.stObj = stObj;
        this.labMark = -1;
        this.progressTestMark = -1;
        this.finalMark = -1;
    }
    
    

    public Transcript(Subject sObj, Student stObj, double labMark, double progressTestMark, double finalMark) {
        this.sObj = sObj;
        this.stObj = stObj;
        this.labMark = labMark;
        this.progressTestMark = progressTestMark;
        this.finalMark = finalMark;
    }

    public Subject getsObj() {
        return sObj;
    }

    public void setsObj(Subject sObj) {
        this.sObj = sObj;
    }

    public Student getStObj() {
        return stObj;
    }

    public void setStObj(Student stObj) {
        this.stObj = stObj;
    }

    public double getLabMark() {
        return labMark;
    }

    public void setLabMark(double labMark) {
        this.labMark = labMark;
    }

    public double getProgressTestMark() {
        return progressTestMark;
    }

    public void setProgressTestMark(double progressTestMark) {
        this.progressTestMark = progressTestMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double average() {
        return (this.progressTestMark * 0.3 + this.labMark * 0.3 + this.finalMark * 0.4);
    }

}
