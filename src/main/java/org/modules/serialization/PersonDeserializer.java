package org.modules.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonDeserializer {
  public static void deserializePerson() {
    try(FileInputStream fis = new FileInputStream("./src/main/resources/test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      Person person = (Person) ois.readObject();
      System.out.println("Person object has been deserialized");
      System.out.println(person.toString());
    } catch(IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
