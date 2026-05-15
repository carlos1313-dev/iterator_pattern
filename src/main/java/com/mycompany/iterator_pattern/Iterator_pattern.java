/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.iterator_pattern;


import com.mycompany.iterator_pattern.collection.ListStudentArray;
import com.mycompany.iterator_pattern.collection.ListTeacherTree;
import com.mycompany.iterator_pattern.model.Person;
import com.mycompany.iterator_pattern.model.Student;
import com.mycompany.iterator_pattern.model.Teacher;
import com.mycompany.iterator_pattern.visitor.PersonVisitor;
import com.mycompany.iterator_pattern.visitor.CompletenessValidator;
import com.mycompany.iterator_pattern.visitor.TeacherCodeValidator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Nota: Para crear el menú interactivo, se crean algunos datos con los métodos buildStudents() y buildTeachers(), para ello la clase conoce a
las entidades directamente. Sin embargo, para aplicar rigurosamente el patrón Iterator y visitor, los datos deberían venir precargados, así 
no conocería a estas clases, el cliente sólo tendría relación con la interfaz Iterable<T> , cuyo tipo sería Student o Teacher, que devuelve un 
iterador<T> con iterator(): Iterador<T>, y a la clase personVisitor, para hacer uso del patrón Visitor, como se establece en el UML.

La razón de que en esta clase el Cliente importe directamente Person, Student, Teacher y listas concretas, es sólo para crear los objetos de prueba,
Esto se ve reflejado en el método transverse(), donde realmente se aplica el patrón limpiamente, y está aislado de estas clases particulares.
*/

public class Iterator_pattern {

    // ---- datos de ejemplo ------------------------------------------------
    private static ListStudentArray buildStudents() {
        ListStudentArray list = new ListStudentArray();
        list.add(new Student("2301", "Ana Gomez",  "Calle 10",   List.of("3001234567")));
        list.add(new Student("2302", "",            "Carrera 5",  List.of()));
        list.add(new Student("2303", "Luis Vera",   null,         List.of("3109876543")));
        return list;
    }

    private static ListTeacherTree buildTeachers() {
        ListTeacherTree tree = new ListTeacherTree();
        tree.add(new Teacher("101",   "Pedro Ruiz",  "Av. 68",   List.of("3204567890")));
        tree.add(new Teacher("20001", "Marta Leon",  "Calle 80", List.of("3157654321")));
        tree.add(new Teacher("303",   "Clara Nino",  "",         List.of()));
        tree.add(new Teacher("4",     "Juan Moya",   "Cra. 15",  List.of("3006543210")));
        return tree;
    }

    // ---- recorrido generico con Iterator + Visitor -----------------------
    private static <T extends com.mycompany.iterator_pattern.model.Person> void traverse(
            Iterable<T> collection,
            PersonVisitor visitor) {

        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            it.next().accept(visitor);
        }
    }

    // ---- separador de consola ----------------
    private static void line() {
        System.out.println("----------------------------------------");
    }

    private static void header(String title) {
        line();
        System.out.println("  " + title);
        line();
    }

    // ---- opciones del menu -----------------------------------------------
    private static void recorrido1(ListStudentArray students, ListTeacherTree teachers) {
        PersonVisitor v = new CompletenessValidator();
        header("Recorrido 1 - Validacion de datos completos");

        System.out.println("[ Estudiantes - ArrayList, orden de insercion ]");
        traverse(students, v);

        System.out.println();
        System.out.println("[ Docentes - TreeSet, orden ascendente por codigo ]");
        traverse(teachers, v);
    }

    private static void recorrido2(ListStudentArray students, ListTeacherTree teachers) {
        PersonVisitor v = new TeacherCodeValidator();
        header("Recorrido 2 - Validacion de codigo de docente");

        System.out.println("[ Docentes - TreeSet, orden DESCENDENTE por codigo ]");
        Iterator<Teacher> desc = teachers.descendingIterator();
        while (desc.hasNext()) {
            desc.next().accept(v);
        }

        System.out.println();
        System.out.println("[ Estudiantes - validacion de codigo docente no aplica ]");
        traverse(students, v);
    }

    private static void recorrido3(ListStudentArray students, ListTeacherTree teachers) {
        header("Recorrido 3 - Ambas validaciones combinadas");

        PersonVisitor comp = new CompletenessValidator();
        PersonVisitor code = new TeacherCodeValidator();

        System.out.println("[ Estudiantes - completitud ]");
        traverse(students, comp);

        System.out.println();
        System.out.println("[ Docentes - completitud ]");
        traverse(teachers, comp);

        System.out.println();
        System.out.println("[ Docentes - codigo (descendente) ]");
        Iterator<Teacher> desc = teachers.descendingIterator();
        while (desc.hasNext()) {
            desc.next().accept(code);
        }
    }

    private static void mostrarDatos(ListStudentArray students, ListTeacherTree teachers) {
        header("Datos cargados en memoria");

        System.out.println("Estudiantes (ArrayList):");
        for (Student s : students) {
            System.out.println("  Cod: " + s.getCode()
                    + " | Nombre: " + (s.getName().isBlank() ? "[vacio]" : s.getName())
                    + " | Dir: "    + (s.getAddress() == null || s.getAddress().isBlank() ? "[vacio]" : s.getAddress())
                    + " | Tels: "   + s.getPhones());
        }

        System.out.println();
        System.out.println("Docentes (TreeSet - orden ascendente):");
        for (Teacher t : teachers) {
            System.out.println("  Cod: " + t.getCode()
                    + " | Nombre: " + (t.getName().isBlank() ? "[vacio]" : t.getName())
                    + " | Dir: "    + (t.getAddress() == null || t.getAddress().isBlank() ? "[vacio]" : t.getAddress())
                    + " | Tels: "   + t.getPhones());
        }
    }

    // ---- menu principal --------------------------------------------------
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("  SISTEMA DE VALIDACION DE PERSONAS");
        line();
        System.out.println("  1. Ver datos cargados");
        System.out.println("  2. Recorrido 1 - Validar datos completos");
        System.out.println("  3. Recorrido 2 - Validar codigo de docente");
        System.out.println("  4. Recorrido 3 - Ambas validaciones");
        System.out.println("  0. Salir");
        line();
        System.out.print("  Ingrese una opcion: ");
    }

    // ---- main ------------------------------------------------------------
    public static void main(String[] args) {
        ListStudentArray students = buildStudents();
        ListTeacherTree  teachers = buildTeachers();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println();
        System.out.println("  Patrones Iterator + Visitor");
        System.out.println("  Universidad - Gestion de Personas");

        while (running) {
            mostrarMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> mostrarDatos(students, teachers);
                case "2" -> recorrido1(students, teachers);
                case "3" -> recorrido2(students, teachers);
                case "4" -> recorrido3(students, teachers);
                case "0" -> {
                    line();
                    System.out.println("  Programa finalizado.");
                    line();
                    running = false;
                }
                default -> {
                    System.out.println("  Opcion no valida. Intente de nuevo.");
                }
            }
        }

        scanner.close();
    }
}