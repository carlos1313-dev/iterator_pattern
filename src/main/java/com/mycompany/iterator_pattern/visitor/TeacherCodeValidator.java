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
// TeacherCodeValidator.java  — Recorrido 2
// Solo actúa sobre Teacher; valida código máximo 4 dígitos.
public class TeacherCodeValidator implements PersonVisitor {

    private final Notifier notifier = new Notifier();

    @Override
    public void visit(Student student) {
        // Para estudiantes no aplica esta validación
        System.out.println("  — Estudiante " + student.getName()
                + ": validacion de código docente no aplica.");
    }

    @Override
    public void visit(Teacher teacher) {
        String code = teacher.getCode();
        boolean valid = code != null
                && code.matches("\\d{1,4}");   // solo dígitos, máximo 4
        if (!valid) {
            System.out.println("   Docente " + teacher.getName()
                    + ": codigo \"" + code + "\" invalido (máx. 4 dígitos).");
            notifier.sendNotification(teacher);
        } else {
            System.out.println("   Docente " + teacher.getName()
                    + ": codigo \"" + code + "\" valido.");
        }
    }
}
