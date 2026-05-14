/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.model;

/**
 *
 * @author sangr
 */
public interface Visitable {
    void accept(PersonVisitor visitor);
}