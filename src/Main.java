import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // TASK №1
        System.out.printf("essay(10,7 hello my name is Bessie and this is my essay) -> \n");
        essay(10,7, "hello my name is Bessie and this is my essay");
        // TASK №2
        System.out.print("split(\"()()()\") ->"); printRes(split("()()()"));
        System.out.print("split(\"((()))\") ->"); printRes(split("((()))"));
        System.out.print("split(\"((()))(())()()(()())\") ->"); printRes(split("((()))(())()()(()())"));
        System.out.print("split(\"((())())(()(()()))\") ->"); printRes(split("((())())(()(()()))"));
        System.out.println();
        // TASK №3
        System.out.printf("toCamelCase(\"hello_edabit\") -> \"%s\"\n", toCamelCase("hello_edabit"));
        System.out.printf("toSnakeCase(\"helloEdabit\") -> \"%s\"\n", toSnakeCase("helloEdabit"));
        System.out.printf("toCamelCase(\"is_modal_open\") -> \"%s\"\n", toCamelCase("is_modal_open"));
        System.out.printf("toSnakeCase(\"getColor\") -> \"%s\"\n\n", toSnakeCase("getColor"));
        // TASK №4
        System.out.printf("overTime([9, 17, 30, 1.5]) -> \"$%.2f\"\n", overTime(new double[]{9, 17, 30, 1.5}));
        System.out.printf("overTime([16, 18, 30, 1.8]) -> \"$%.2f\"\n", overTime(new double[]{16, 18, 30, 1.8}));
        System.out.printf("overTime([13.25, 15, 30, 1.5]) -> \"$%.2f\"\n\n", overTime(new double[]{13.25, 15, 30, 1.5}));
        // TASK №5
        System.out.print("BMI(\"205 pounds\", \"73 inches\") ->"); BMI("205 pounds", "73 inches");
        System.out.print("BMI(\"55 kilos\", \"1.65 meters\") ->"); BMI("55 kilos", "1.65 meters");
        System.out.print("BMI(\"154 pounds\", \"2 meters\") ->"); BMI("154 pounds", "2 meters");
        System.out.println();
        // TASK №6
        System.out.printf("bugger(39) -> %d\n", bugger(39));
        System.out.printf("bugger(999) -> %d\n", bugger(999));
        System.out.printf("bugger(4) -> %d\n\n", bugger(4));
        // TASK №7
        System.out.printf("toStarShorthand(\"abbccc\") -> \"%s\"\n", toStarShorthand("abbccc"));
        System.out.printf("toStarShorthand(\"77777geff\") -> \"%s\"\n", toStarShorthand("77777geff"));
        System.out.printf("toStarShorthand(\"abc\") -> \"%s\"\n", toStarShorthand("abc"));
        System.out.printf("toStarShorthand(\"\") -> \"%s\"\n\n", toStarShorthand(""));
        // TASK №8
        System.out.printf("doesRhyme(\"Sam I am!\", \"Green eggs and ham.\") -> %b\n", doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.printf("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") -> %b\n", doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.printf("doesRhyme(\"You are off to the races\", \"a splendid day.\") -> %b\n", doesRhyme("You are off to the races", "a splendid day."));
        System.out.printf("doesRhyme(\"and frequently do?\", \"you gotta move.\") -> %b\n\n", doesRhyme("and frequently do?", "you gotta move."));
        // TASK №9
        System.out.printf("trouble(451999277, 41177722899) -> %b\n", trouble(451999277, 41177722899L));
        System.out.printf("trouble(1222345, 12345) -> %b\n", trouble(1222345, 12345));
        System.out.printf("trouble(666789, 12345667) -> %b\n", trouble(666789, 12345667));
        System.out.printf("trouble(33789, 12345337) -> %b\n\n", trouble(33789, 12345337));
        // TASK №10
        System.out.printf("countUniqueBooks(\"AZYWABBCATTTA\", 'A') -> %d\n", countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.printf("countUniqueBooks(\"$AA$BBCATT$C$$B$\", '$') -> %d\n", countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.printf("countUniqueBooks(\"ZZABCDEF\", 'Z') -> %d\n", countUniqueBooks("ZZABCDEF", 'Z'));

    }
    // TASK №1
    public static void essay(int n, int k, String s){ // переписать в строки содержащие k символов без учёта пробелов
        /* Если не известно как строка выглядит изначально:
           String tmp, l="";
           for(int i=0;i<n;i++){
           Scaner in = new Scaner(System in);
           tmp = in.next();
           if(i!=n-1){ l += tmp + ' '; }
           else{ l += tmp; }
           }
        */
        String[] new_s=s.split(" ");
        String res = "";
        int count = 0;
        for(int i=0; i<new_s.length; i++){
            count += new_s[i].length();
            if(count > k){
                System.out.println(res);
                count = new_s[i].length();
                res = "";
            }
            res += new_s[i] + " ";

        }
        if(res!=""){System.out.println(res);}
        System.out.println();
    }
    // TASK №2
    public static String[] split(String s){ // разделить строку скобок на массив закрытых скобок
        int count = 0, elements = 0;
        String new_s="";
        String[] res={};
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else if (s.charAt(i) == ')'){
                count--;
            }
            new_s+=s.charAt(i);
            if(count == 0){
                res = addElement(elements, res, new_s);
                elements++;
                new_s = "";
            }
        }
        return res;

    }
    // Метод для добавления элемента
    public static String[] addElement(int elements, String[] res, String new_s){
        String[] new_res = new String[elements+1];
        for (int i=0; i<elements; i++){
            new_res[i] = res[i];
        }
        new_res[elements] = new_s;
        return new_res;
    }

    // Метод для отображения результата как в примере
    public static void printRes(String[] res){
        System.out.print("[\"");
        for (int i=0;i<res.length; i++){
            if(i== res.length-1){
                System.out.print(res[i] + "\"]");
            }else {
                System.out.print(res[i] + "\", \"");
            }
        }
        System.out.println();
    }
    // TASK №3
    public static String toCamelCase(String s){ // переписать название переменной в формат с заглавными буквами
        String[] new_s = s.split("_");
        String res = new_s[0];
        for(int j=1; j< new_s.length; j++) {
            for (int i = 0; i < new_s[j].length(); i++) {
                if (i == 0) {
                    res += (char) (new_s[j].charAt(0) - 'a' + 'A');
                } else {
                    res += new_s[j].charAt(i);
                }
            }
        }
        return res;
    }
    public static String toSnakeCase(String s){ // переписать название переменной в формат с '_'
        String res = "";
        for (int i=0;i<s.length(); i++){
            if(s.charAt(i)>'A' && s.charAt(i)<'Z'){
                res += '_';
                res += (char)(s.charAt(i)-'A'+'a');
            }else{
                res += s.charAt(i);
            }
        }
        return res;
    }
    // TASK №4
    public static double overTime(double[] s){ // посчитать сколько человек зарабатывает в сутки
        double start = 0.0, finish = 0.0;
        if(s[0]<9.0){ // если человек начал работать раньше рабочего дня
            start = 9.0-s[0];
        }
        if(s[1]>17){ // если человек работает после окончания рабочего дня
            finish = s[1]-17.0;
        }
        //System.out.println();
        return (s[1]-s[0])*s[2]+start*(s[3]-1)+finish*(s[3]-1);
    }
    // TASK №5
    public static void BMI(String s1, String s2){ // посчитать отношение веса к квадрату роста
        double weight=0.0, length = 0.0, res = 0.0;
        int decimal_check = 0; // индекс '.' в числе
        String[] new_s1 = s1.split(" "), new_s2 = s2.split(" ");
        for(int i = 0; i<new_s1[0].length(); i++){
            if(decimal_check == 0) {
                if ((new_s1[0].charAt(new_s1[0].length() - i - 1) >= '0') && (new_s1[0].charAt(new_s1[0].length() - i - 1) <= '9')) {
                    weight += Math.pow(10, i) * ((double) new_s1[0].charAt(new_s1[0].length() - i - 1) - '0');
                    //System.out.println(weight + " " + Math.pow(10, i) + " " + (double)(new_s1[0].charAt(i)-'0'));
                }else{
                    decimal_check = i; // число не целое
                    weight *= Math.pow(10, -i);
                }
            }else{
                weight += Math.pow(10, i-decimal_check-1) * ((double) new_s1[0].charAt(new_s1[0].length() - i - 1) - '0');
            }
        }
        if(new_s1[1].contains("pounds")){ // если вес был задан в пудах
            weight *= 0.454;
        }
        //System.out.println(new_s1[1]);

        decimal_check = 0;
        for(int i=0; i<new_s2[0].length(); i++){
            if(decimal_check == 0) {
                if ((new_s2[0].charAt(new_s2[0].length() - i - 1) >= '0') && (new_s2[0].charAt(new_s2[0].length() - i - 1) <= '9')) {
                    length += Math.pow(10, i) * ((double) new_s2[0].charAt(new_s2[0].length() - i - 1) - '0');
                } else {
                    decimal_check = i; // число не целое
                    length*=Math.pow(10,-i);
                }
            }
            else{
                length += Math.pow(10, i-decimal_check-1) * ((double) new_s2[0].charAt(new_s2[0].length() - i - 1) - '0');
            }
        }
        if(new_s2[1].contains("inches")){ // если рост был задан в дюймах
            length *= 0.0254;
        }

        res = weight/(length*length);

        if(res >= 25){
            System.out.printf("\"%.2f  Overweight\"\n", res);
        }else if(res<18.5){
            System.out.printf("\"%.2f  Underweight\"\n", res);
        }else{
            System.out.printf("\"%.2f  Normal weight\"\n", res);
        }
    }
    // TASK №6
    public static int bugger(int s){ // посчитать через сколько итераций перемножения цифр числа, число будет меньше 10
        int res = 0, check = 0, new_s;
        if(s<10){
            return 0;
        }
        while (check == 0){
            new_s = 1;
            while (s>0){
                new_s *= s%10;
                s/=10;
            }
            res++;
            s = new_s;
            if(new_s<=10) {
                check = 1;
            }
        }
        return res;
    }
    // TASK №7
    public static String toStarShorthand(String s){ // записать строку по типу "(буква)*(количсетво этих букв)"
        if(s.length() == 0){
            return "";
        }
        String res = "";
        char tmp = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == tmp){
                count++;
            }else{
                if(count>1) {
                    res += s.charAt(i-1);
                    res += '*';
                    res += count;
                }else{
                    res+=s.charAt(i-1);
                }
                count=1;
                tmp = s.charAt(i);
            }
        }
        if(count>1) {
            res += s.charAt(s.length()-1);
            res += '*';
            res += count;
        }else{
            res += s.charAt(s.length()-1);
        }
        return res;
    }
    // TASK №8
    public static boolean doesRhyme(String s, String k){ // проверить совпадение гласных в последнем слове
        if(s=="" || k==""){
            return false;
        }
        char tmp;
        int count = 0;
        String[] new_s = s.split(" "), new_k = k.split(" ");
        String s_vowels=""; // строка хранящая в себе гласные последнего слова строки s
        for(int i=0; i <new_s[new_s.length-1].length();i++){
            if(new_s[new_s.length-1].charAt(i)>='A' && new_s[new_s.length-1].charAt(i)<='Z'){
                tmp = (char) (new_s[new_s.length-1].charAt(i)-'A'+'a');
            }else{
                tmp = new_s[new_s.length-1].charAt(i);
            }
            if(tmp == 'a' || tmp == 'o' || tmp == 'i' || tmp == 'e' || tmp == 'y'){
                s_vowels += tmp; // запись гласых последнего слова
            }
        }
        for(int i=0; i <new_k[new_k.length-1].length();i++){
            if(new_k[new_k.length-1].charAt(i)>='A' && new_k[new_k.length-1].charAt(i)<='Z'){
                tmp = (char) (new_k[new_k.length-1].charAt(i)-'A'+'a');
            }else{
                tmp = new_k[new_k.length-1].charAt(i);
            }
            if(tmp == 'a' || tmp == 'o' || tmp == 'i' || tmp == 'e' || tmp == 'y'){
                if(s_vowels.length()==count){ // проверка, если в последнем слове строки k гласных оказалось больше, чем в последнем слове строки s
                    return false;
                }
                if(tmp != s_vowels.charAt(count)){
                    return false;
                }
                count++;
            }
        }
        return true;
    }
    // TASK №9
    public static boolean trouble(long s, long k){ // встречается ли любая цифра в числе s 3 раза подряд, а в числе k 2 раза подряд
        long tmp = s%10;
        s/=10;
        int elements=0, check = 0;
        long[] s_digits={}; // массив цифр, которые встретились 3 раза подряд в числе s
        while (s>0){
            if(s%10 == tmp){
                if(check == 0){
                    check = 1;
                }else if(check == 1){
                    s_digits = addElementInt(elements, s_digits, tmp); //добавить цифру в массив
                    check = 0;
                    //System.out.println(tmp);
                }
            }else{
                tmp = s%10;
                check = 0;
            }
            s/=10;
        }
        //check = 0;
        tmp = k%10;
        k/=10;
        while (k>0){
            if(k%10==tmp){
                for (int i=0; i<s_digits.length; i++){
                    if(tmp == s_digits[i]){
                        return true;
                    }
                }
            }
            else{
                tmp = k%10;
            }
            k/=10;
        }
        return false;
    }
    // Функция для добавления элемента в массив
    public static long[] addElementInt(int elements, long[] res, long new_s){
        long[] new_res = new long[elements+1];
        for (int i=0; i<elements; i++){
            new_res[i] = res[i];
        }
        new_res[elements] = new_s;
        return new_res;
    }
    // TASK №10
    public static int countUniqueBooks(String s, char k){ // Количество уникальных символов в строке s между символами k
        Set<String> letters = new HashSet<String>();
        int check = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == k){
                check = 1-check;
            }else if(check == 1){
                String f = "" + s.charAt(i);
                letters.add(f);
            }
        }
        return letters.size();
        /*String new_k = "";
        new_k += k;
        if(new_k.contains("$")){
            new_k = "\\$";
        }
        String[] new_s = s.split(new_k);
        for(int i=1; i<new_s.length; i+=2){
            //System.out.println(new_s[i]);
            for(int j=0; j<new_s[i].length(); j++){
                String f = ""+new_s[i].charAt(j);
                letters.add(f);
            }
        }
        return letters.size();
        */
    }
}