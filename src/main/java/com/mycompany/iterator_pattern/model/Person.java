/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iterator_pattern.model;

/**
 *
 * @author sangr
 */
import java.util.List;

public abstract class Person implements Visitable {
    protected String code;
    protected String name;
    protected String address;
    protected List<String> phones;

    public Person(String code, String name, String address, List<String> phones) {
        this.code = code; this.name = name;
        this.address = address; this.phones = phones;
    }

    public String getCode()    { return code; }
    public String getName()    { return name; }
    public String getAddress() { return address; }
    public List<String> getPhones() { return phones; }
}