/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.collection;

import com.mycompany.iterator_pattern.model.Student;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author sangr
 */
public class ListStudentTree implements Iterable<Student> {

    private final TreeSet<Student> set = new TreeSet<>();

    public void add(Student s) { set.add(s); }

    // Iteración ascendente (orden natural por código)
    @Override
    public Iterator<Student> iterator() {
        return set.iterator();
    }

    // Iteración descendente — expone el descending iterator del TreeSet
    public Iterator<Student> descendingIterator() {
        return set.descendingIterator();
    }
}
