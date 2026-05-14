/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.visitor;

import com.mycompany.iterator_pattern.model.Student;
import com.mycompany.iterator_pattern.model.Teacher;

/**
 *
 * @author sangr
 */
//  (Visitor)
public interface PersonVisitor {
    void visit(Student student);
    void visit(Teacher teacher);
}
