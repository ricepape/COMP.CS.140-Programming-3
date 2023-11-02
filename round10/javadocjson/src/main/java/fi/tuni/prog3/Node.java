/**
 * Provides the classes needed for Programming 3 exercise JSON
 * <p>
 * @author N.N.
 * @since 1.0
 */
package fi.tuni.prog3.json;

/**
 * An abstract class representing nodes in a JSON structure.
 * <p>
 * @author Thi Vu
 * @since 1.0
 */
public abstract class Node {

  /**
   * Check if the node is an array node.
   *
   * @return true if the node is an array node, otherwise false.
   */
  public boolean isArray() {
    return this instanceof ArrayNode;
  }

  /**
   * Check if the node is an object node.
   *
   * @return true if the node is an object node, otherwise false.
   */
  public boolean isObject() {
    return this instanceof ObjectNode;
  }

  /**
   * Check if the node is a value node.
   *
   * @return true if the node is a value node, otherwise false.
   */
  public boolean isValue() {
    return this instanceof ValueNode;
  }

  /**
   * Print the JSON representation of the node to the standard output.
   */
  public void printJson() {
    StringBuilder sb = new StringBuilder();
    printJson(this, sb, 0);
    System.out.println(sb.toString());
  }

  private static final String NL = System.lineSeparator();

  private static String numberToString(Double d) {
    String str = Double.toString(d);
    if(str.endsWith(".0")) {
      str = str.substring(0, str.length() - 2);
    }
    return str;
  }

  private static final String CNL = "," + System.lineSeparator();

  private void printJson(Node node, StringBuilder sb, int depth) {
    final String indent = "  ".repeat(depth);
    final String subIndent = "  ".repeat(depth + 1);
    if(node.isObject()) {
      ObjectNode objNode = (ObjectNode) node;
      if(objNode.size() > 0) {
        sb.append("{");
        String end = NL;
        for(String name : objNode) {
          sb.append(end).append(subIndent).append("\"").append(name).append(
                  "\": ");
          printJson(objNode.get(name), sb, depth + 1);
          end = CNL;
        }
        sb.append(NL).append(indent).append("}");
      }
      else {
        sb.append("{}");
      }
    }
    else if(node.isArray()) {
      ArrayNode arrNode = (ArrayNode) node;
      if(arrNode.size() > 0) {
        sb.append("[");
        String end = NL;
        for(Node aNode : arrNode) {
          sb.append(end).append(subIndent);
          printJson(aNode, sb, depth + 1);
          end = CNL;
        }
        sb.append(NL).append(indent).append("]");
      }
      else {
        sb.append("[]");
      }
    }
    else if(node.isValue()) {
      ValueNode valNode = (ValueNode) node;
      String valStr = "";
      if(valNode.isNumber()) {
        valStr = numberToString(valNode.getNumber());
      }
      else if(valNode.isBoolean()) {
        valStr = Boolean.toString(valNode.getBoolean());
      }
      else if(valNode.isString()) {
        valStr = "\"" + valNode.getString() + "\"";
      }
      else if(valNode.isNull()) {
        valStr += valNode.getNull();
      }
      sb.append(valStr);
    }
  }
}
