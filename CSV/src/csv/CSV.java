package csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args)  {
        try (PrintWriter writer = new PrintWriter(args[1]);
             Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            writer.println("<! DOCTYPE   HTML> \n" + " <HTML> \n" + "<head> \n" + "<Meta   Charset = \"UTF-8\"> \n" +
                    "<title>Задача CSV</title> \n" + "</head> \n" + "<body> \n" + "<table>");

            boolean isInQuotes = false;
            while (scanner.hasNextLine()) {
                if (!isInQuotes) {
                    writer.print("<tr><td>");
                }
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (symbol == '"') {
                        if (i == line.length() - 1) {
                            isInQuotes = !isInQuotes;
                        } else if (line.charAt(i + 1) == '"' && isInQuotes) {
                            writer.print(symbol);
                            i++;
                        } else {
                            isInQuotes = !isInQuotes;
                        }
                    } else if (symbol == ',') {
                        if (isInQuotes) {
                            writer.print(",");
                        } else {
                            writer.print("</td><td>");
                        }
                    } else if (symbol == '<') {
                        writer.print("&lt;");
                    } else if (symbol == '>') {
                        writer.print("&gt;");
                    } else if (symbol == '&') {
                        writer.print("&amp;");
                    } else {
                        writer.print(symbol);
                    }
                }
                if (isInQuotes) {
                    writer.print("<br/>");
                } else {
                    writer.print("</td></tr>\n");
                }
            }
            writer.println("</table>\n" + "</body>\n" + "</HTML>");
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден");
        }
    }
}
