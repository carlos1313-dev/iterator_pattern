/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.collection;

/**
 *
 * @author sangr
 */
// ListStudentArray.java  — ConcreteCollection sobre ArrayList
import com.mycompany.iterator_pattern.model.Student;
import java.util.ArrayList;
import java.util.Iterator;

public class ListStudentArray implements Iterable<Student> {

    private final ArrayList<Student> list = new ArrayList<>();

    public void add(Student s) { list.add(s); }

    // Delega al Iterator concreto de ArrayList (iteración en orden de inserción)
    @Override
    public Iterator<Student> iterator() {
        return list.iterator();
    }
}
