/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.collection;

import com.mycompany.iterator_pattern.model.Teacher;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sangr
 */
public class ListTeacherArray implements Iterable<Teacher> {

    private final ArrayList<Teacher> list = new ArrayList<>();

    public void add(Teacher t) { list.add(t); }

    // Delega al Iterator concreto de ArrayList (iteración en orden de inserción)
    @Override
    public Iterator<Teacher> iterator() {
        return list.iterator();
    }
}