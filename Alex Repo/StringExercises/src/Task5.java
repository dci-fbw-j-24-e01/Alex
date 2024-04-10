public class Task5 {
    public static void main(String[] args) {
        String[] names = { "Donald", "Daisy", "Huey", "Dewey", "Louie", "Scrooge", "Ludvig" };
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n\t");
        for (int i = 0; i < names.length; i++) {
            if (i % 2 == 0) {
                sb.append("<tr style='background-color:green;color:white;'>\n\t\t");
            }
            else {
                sb.append("<tr style='background-color:yellow;color:black;'>\n\t\t");
            }
            sb.append("<td>Row ")
                    .append(i + 1)
                    .append(": ")
                    .append(names[i])
                    .append("</td>\n\t")
                    .append("</tr>\n");
        }
        sb.append("</table>");

        System.out.print(sb);
    }
}
