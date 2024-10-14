package org.modules.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonSerializer {
  public static void serializePerson(Person person) {
    try(FileOutputStream fos = new FileOutputStream("./src/main/resources/test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(person);
      System.out.println("Person object has been serialized");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
