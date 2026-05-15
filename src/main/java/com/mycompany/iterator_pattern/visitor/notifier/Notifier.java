/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.visitor.notifier;

import com.mycompany.iterator_pattern.model.Person;

/**
 *
 * @author sangr
 */
public class Notifier {
    public void sendNotification(Person p) {
        System.out.println("  NOTIFICACION  -- " + p.getName()
                + " [" + p.getCode() + "] tiene datos incompletos.");
    }
}
