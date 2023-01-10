import java.util.*;
public class tasks4 {

    //Функция итерирует по всем словам и в зависимости от
    // суммы результирующей строки и следующего слова определяет
    // добавить ли слово в рез. строку или вывести и очистить её
    public static void bessie(int n, int k, String essay){//n-слов k-символов
        String[] words = essay.split(" ");//делит строку на части после пробела
        StringBuilder result = new StringBuilder();
        result.append(words[0]);//Метод append() – обновляет значение объекта, который вызвал метод.
        //цикл
        for(int i = 1; i < n; i++){//идем по каждому слову в строке
            if(words[i].length() + result.length() <= k) {//тк у нас задано количество символов сравниваем длину строки
                result.append(" " + words[i]);
            } else {//если больше к создаем новую строку
                System.out.println(result.toString());
                result = new StringBuilder();
                result.append(words[i]);
            }
        }
        System.out.println(result.toString());
    }

    // Функция считает кол-во кластеров, а затем повторно
    // считывает их в массив посчитанной длины
    public static ArrayList<String> split(String s) {
        String str = new String();
        ArrayList<String> list = new ArrayList<>();//создаем новый список
        int count = 0;
        for (int i = 0; i < s.length(); i++) {//идем по кадому символу строки
            if (s.charAt(i) == '(') {//если находит то добавляет в каунте и в строку
                count++;
                str += "(";
            }
            if (s.charAt(i) == ')') {//если находит то вычитает в каунте и добавляет в строку
                count--;
                str += ")";
            }
            if (count == 0) {//если количество равно 0 то создаем новую строку
                list.add(str);
                str = new String();
            }
        }
        return list;
    }

    // Функция разбивает строку по '_' а затем собирает снова капитализируя каждое слово
    public static String toCamelCase(String str){
        String[] words = str.split("_");//делит строку на части после подчеркивания
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){//проходим по каждому символу
            if(i == 0)sb.append(words[i].toLowerCase());//Метод  возвращает значение строки, на которой он был вызван, преобразованное в нижний регистр.
            else sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
        }
        return sb.toString();
    }

    // Функция разбивает строку по заглавным буквам и собирает снова с '_' в нижнем регистре
    public static String toSnakeCase(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){//перебор алфавита заглавных букв
                sb.append("_" + str.substring(i, i + 1).toLowerCase());//берем заглавную и делаем строчную
            } else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Функция считает кол-во часов обычной работы и кол-во часов сверхурочных, и по ним высчитывает итоговую стоимость
    public static String overTime(double[] arr){//
        double sum = 0;
        double EVENING = 17;//5 часов
        double start = arr[0];//начало раб дня
        double end = arr[1];//конец
        double payment = arr[2];//почасовая ставка
        double bonus = arr[3];//множитель
        if(start > EVENING){
            sum += (end - start) * payment * bonus;
        } else if(end > EVENING){
            sum += (EVENING - start) * payment;
            sum += (end - EVENING) * payment * bonus;
        } else {//если нормальный график
            sum += (end - start) * payment;
        }
        return "$" + sum;
    }

    // Функция считывает вес и рост, и в зависимости от значений и входных величин возвращает BMI
    public static String BMI(String weight, String height) {
        double w = Double.parseDouble(weight.split(" ")[0]);//преобразовать строку в двойной тип данных,
        double h = Double.parseDouble(height.split(" ")[0]);
        String weightType = weight.split(" ")[1].toLowerCase();
        String heightType = height.split(" ")[1].toLowerCase();
        if(weightType.equals("pounds"))w *= 0.453592;
        if(heightType.equals("inches"))h *= 0.0254;
        double bmi = w / (h * h);
        if(bmi <= 18.5)return String.format("%.1f", bmi) + " Underweight";
        else if(bmi <= 25)return String.format("%.1f", bmi) + " Normal weight";
        else return String.format("%.1f", bmi) + " Overweight";
    }

    // Функция возвращает кол-во перемножений цифр числа
    public static int bugger(int x){
        int counter = 0;//количество умножений
        int mull = 1;
        while (x > 9){
            while(x > 0){
                mull *= (x % 10);//39=9
                x /= 10;
            }
            x = mull;
            mull = 1;
            counter++;
        }
        return counter;
    }

    // Подсчитывает кол-во повторений символов и выводит в виде AAAsdg = A*3sdg
    public static String toStarShorthand(String word){
        word += " ";
        StringBuilder sb = new StringBuilder();
        for (char a: word.toCharArray()) {//перебираем каждвый символ строки
            //Метод charAt() возвращает указанный символ из строки.
            int length = word.split(String.valueOf(a)).length - 1;//делит строку на части по символьно
            if(sb.indexOf(String.valueOf(a)) == -1){//если буквы нет то добавляем
                sb.append(a);
                if(length > 1) sb.append("*" + length);
            }
        }
        return sb.toString();
    }

    // Проверяет рифмуются ли слова сравнивая гласные последних слов
    //возвращает true, если две строки рифмуются
    //последнее слово из каждого предложения содержит одни и те же гласные.
    public static boolean doesRhyme(String word1, String word2){
        String vowels = "aeiou";
        StringBuilder vW1 = new StringBuilder();
        StringBuilder vW2 = new StringBuilder();
        String words[] = word1.split(" ");//делит строку на части массив из слов
        for(char lit: words[words.length - 1].toLowerCase().toCharArray()){//берем последнее слова массива
            //Метод toLowerCase() возвращает значение строки, преобразованное в нижний регистр.
            if(vowels.contains(String.valueOf(lit))){//проверка на гласную в последнем слове
                vW1.append(lit);
            }
        }
        words = word2.split(" ");//тоже самое для второй строки
        for(char lit: words[words.length - 1].toLowerCase().toCharArray()){
            if(vowels.contains(String.valueOf(lit))){
                vW2.append(lit);
            }
        }
        return vW1.toString().equals(vW2.toString());
    }

    // Фукнция ищет символ, повторяющийся три раза и затем ищет его во второй строке, где он должен повторятся дважды
    //и в этом случае выводит тру
    public static boolean trouble(long num1, long num2){//нам даны два числа
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        for(int i = 0; i < str1.length() - 2; i++){//идем по кадой цифре первой строки
            //Метод charAt() возвращает указанный символ из строки.
            if(str1.charAt(i) == str1.charAt(i + 1) && str1.charAt(i) == str1.charAt(i + 2)){
                //если какой то символ равен следующему
                for(int j = 0; j < str2.length() - 1; j++){
                    //тоже самое во второй строке
                    //идем по каждому символу
                    if(str2.charAt(j) == str2.charAt(j + 1) && str2.charAt(j) == str1.charAt(i)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Функция считает кол-во уникальных символов в подстроках строки, которые начинаются и заканчиваются с char c
    //и считает длину строки этих уникальных символов
    public static int countUniqueBooks(String str, char c){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean inside = false;
        while (idx < str.length()){
            if(str.charAt(idx) == c){
                inside = !inside;
            } else if(inside && sb.indexOf(String.valueOf(str.charAt(idx))) == -1){
                sb.append(str.charAt(idx));
            }
            idx++;
        }
        return sb.toString().length();
    }
    public static void main(String[] args){
        System.out.println("Задача 1");
        bessie(10, 7, "Hello my name is Bessie and this is my essay");
        System.out.println("Задача2");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
        System.out.println("Задача3");
        System.out.println("toCamelCase(\"hello_edabit\") = " + toCamelCase("hello_edabit"));
        System.out.println("toSnakeCase(\"helloEdabit\") = " + toSnakeCase("helloEdabit"));
        System.out.println("toCamelCase(\"is_modal_open\") = " + toCamelCase("is_modal_open"));
        System.out.println("toSnakeCase(\"getColor\") = " + toSnakeCase("getColor"));
        System.out.println("Задача4");
        System.out.println("overTime([9, 17, 30, 1.5]) = " + overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println("overTime([16, 18, 30, 1.8]) = " + overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println("overTime([13.25, 15, 30, 1.5]) = " + overTime(new double[]{13.25, 15, 30, 1.5}));
        System.out.println("Задача5");
        System.out.println("BMI(\"205 pounds\", \"73 inches\") = " + BMI("205 pounds", "73 inches"));
        System.out.println("BMI(\"55 kilos\", \"1.65 meters\") = " + BMI("55 kilos", "1.65 meters"));
        System.out.println("BMI(\"154 pounds\", \"2 meters\") = " + BMI("154 pounds", "2 meters"));
        System.out.println("Задача6");
        System.out.println("bugger(39) = " + bugger(39));
        System.out.println("bugger(999) = " + bugger(999));
        System.out.println("bugger(4) = " + bugger(4));
        System.out.println("Задача7");
        System.out.println("toStarShorthand(\"abbccc\") = " + toStarShorthand("abbccc"));
        System.out.println("toStarShorthand(\"77777geff\") = " + toStarShorthand("77777geff"));
        System.out.println("toStarShorthand(\"abc\") = " + toStarShorthand("abc"));
        System.out.println("toStarShorthand(\"\") = " + toStarShorthand(""));
        System.out.println("Задача8");
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and ham.\") = " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") = " + doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println("doesRhyme(\"You are off to the races\", \"a splendid day.\") = " + doesRhyme("You are off to the races", "a splendid day."));
        System.out.println("doesRhyme(\"and frequently do?\", \"you gotta move.\") = " + doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("Задача9");
        System.out.println("trouble(451999277, 41177722899) = " + trouble(451999277, 41177722899L));
        System.out.println("trouble(1222345, 12345) = " + trouble(1222345, 12345));
        System.out.println("trouble(666789, 12345667) = " + trouble(666789, 12345667));
        System.out.println("trouble(33789, 12345337) = " + trouble(33789, 12345337));
        System.out.println("Задача10");
        System.out.println("countUniqueBooks(\"AZYWABBCATTTA\", 'A') = " + countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println("countUniqueBooks(\"$AA$BBCATT$C$$B$\", '$') = " + countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println("countUniqueBooks(\"ZZABCDEF\", 'Z') = " + countUniqueBooks("ZZABCDEF", 'Z'));
    }
}
