package org.modules.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Contacts {
  private static List<Integer> findCommandResults = new LinkedList<>();
  private static Node trie = new Node();

  public static List<Integer> contacts(List<List<String>> queries) {
    for(List<String> query : queries) {
      executeCommand(query);
    }
    return findCommandResults;
  }

  private static void executeCommand(List<String> query) {
    String command = query.get(0);
    String stringParameter = query.get(1);
    if("add".equals(command)) addName(stringParameter);
    else if("find".equals(command)) executeFindCommand(stringParameter);
    else System.out.println("Command does not exist.");
  }

  private static void addName(String word) {
    addCharacters(trie, word, 0);
  }

  private static void addCharacters(Node node, String word, int index) {
    node.traversals++;
    if(index == word.length()) return;
    char character = word.charAt(index);
    Node child = node.children.get(character);
    if(child == null) {
      node.children.put(character, new Node());
      addCharacters(node.children.get(character), word, index + 1);
    } else {
      addCharacters(child, word, index + 1);
    }
  }

  private static void executeFindCommand(String prefix) {
    findCharacters(trie, prefix, 0);
  }

  private static void findCharacters(Node node, String prefix, int index) {
    if(index == prefix.length()) {
      findCommandResults.add(node.traversals);
      return;
    }
    char character = prefix.charAt(index);
    Node child = node.children.get(character);
    if(child == null) {
      findCommandResults.add(0);
    } else {
      findCharacters(child, prefix, index + 1);
    }
  }

  static class Node {
    int traversals = 0;
    public Map<Character, Node> children = new HashMap<>();
  }
}
