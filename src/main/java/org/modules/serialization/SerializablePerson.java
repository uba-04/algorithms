package org.modules.serialization;

import java.io.Serializable;

public class SerializablePerson implements Person, Serializable {
  private String name;
  private int age;
  private transient String address;

  public SerializablePerson(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Age: " + age + ", Address: " + address;
  }
}
