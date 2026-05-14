/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.model;

/**
 *
 * @author sangr
 */
import com.mycompany.iterator_pattern.visitor.PersonVisitor;
import java.util.List;

public class Teacher extends Person implements Comparable<Teacher> {
    public Teacher(String code, String name, String address, List<String> phones) {
        super(code, name, address, phones);
    }

    @Override
    public void accept(PersonVisitor visitor) {
        visitor.visit(this);   // double dispatch
    }

    @Override
    public int compareTo(Teacher other) {
        return this.code.compareTo(other.code);
    }
}