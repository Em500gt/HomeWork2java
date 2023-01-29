// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
// Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” …

/**
 * Task1
 */
public class Task1 {

    public static void main(String[] args) {
        String str = "'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'";
        StringBuilder builder = new StringBuilder();

        str = str.replaceAll(":", "")
                .replaceAll(" ", "")
                .replaceAll(",", "");
        String firstString = "";
        String secondString = "";

        builder.append("select * from students where");

        int count = 0;
        int of = 0;
        int last = 0;
        int index = 1;

        while(!str.isEmpty())
        {
            of = str.indexOf("'");
            last = str.lastIndexOf("'", index++);
            if(of != last && firstString == "") {
                firstString = str.substring(of, last + 1);
                str = str.substring(last + 1);
                index = 0;
                last = of;
            }
            
            if(of != last && firstString != ""){
                secondString = str.substring(of, last + 1);
                str = str.substring(last + 1);
                index = 0;
            }

            if(firstString != "" && secondString != "")
            {
                if(!secondString.equals("'null'"))
                {
                    if(count > 0) builder.append("and");

                    builder.append(firstString).append(" = ").append(secondString);
                    firstString = "";
                    secondString = "";
                    count++;
                }
            }
        }
        System.out.println(builder);       
    }
}