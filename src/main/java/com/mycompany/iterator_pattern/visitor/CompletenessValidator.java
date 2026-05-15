/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.visitor;

import com.mycompany.iterator_pattern.model.Person;
import com.mycompany.iterator_pattern.model.Student;
import com.mycompany.iterator_pattern.model.Teacher;

/**
 *
 * @author sangr
 */
// CompletenessValidator.java  — Recorrido 1
// Valida que código, nombre, dirección y al menos un teléfono existan.
public class CompletenessValidator implements PersonVisitor {

    private final Notifier notifier = new Notifier();

    private boolean isComplete(Person p) {
        return p.getCode()    != null && !p.getCode().isBlank()
            && p.getName()    != null && !p.getName().isBlank()
            && p.getAddress() != null && !p.getAddress().isBlank()
            && p.getPhones()  != null && !p.getPhones().isEmpty();
    }

    @Override
    public void visit(Student student) {
        if (!isComplete(student)) notifier.sendNotification(student);
        else System.out.println("  Estudiante " + student.getName() + " — datos completos.");
    }

    @Override
    public void visit(Teacher teacher) {
        if (!isComplete(teacher)) notifier.sendNotification(teacher);
        else System.out.println("  Docente " + teacher.getName() + " — datos completos.");
    }
}