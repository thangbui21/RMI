/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author Thắng Bùi
 */
public class Student {

    private String fullName;
    private String code;
    private String spec;
    private float gpa;

    public Student() {
    }

    public Student(String fullName, String code, String spec, float gpa) {
        this.fullName = fullName;
        this.code = code;
        this.spec = spec;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String certificate() {
        if (this.gpa >= 2.5 && this.gpa < 3.5) {
            return "Khá";
        } else if (this.gpa >= 3.5) {
            return "Giỏi";
        } else {
            return "Tạch";
        }
    }

    @Override
    public String toString() {
        return "Student{" + "fullName=" + fullName + ", code=" + code + ", spec=" + spec + ", gpa=" + gpa + '}';
    }

}
