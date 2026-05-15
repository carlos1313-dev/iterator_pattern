/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.collection;

/**
 *
 * @author sangr
 */
// ListTeacherTree.java  — ConcreteCollection sobre TreeSet
import com.mycompany.iterator_pattern.model.Teacher;
import java.util.Iterator;
import java.util.TreeSet;

public class ListTeacherTree implements Iterable<Teacher> {

    private final TreeSet<Teacher> set = new TreeSet<>();

    public void add(Teacher t) { set.add(t); }

    // Iteración ascendente (orden natural por código)
    @Override
    public Iterator<Teacher> iterator() {
        return set.iterator();
    }

    // Iteración descendente — expone el descending iterator del TreeSet
    public Iterator<Teacher> descendingIterator() {
        return set.descendingIterator();
    }
}