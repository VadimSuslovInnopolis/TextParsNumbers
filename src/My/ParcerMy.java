package My;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by admin on 08.04.2017.
 */
public class ParcerMy implements Runnable{
    private String namePotok;
    //Thread thrd;
    private String namefile;
    private static volatile int sum = 0;
    private static boolean BreakAllThreads;

    private static Object obj = new Object();

    public ParcerMy(String namePotok, String namefile) {
        this.namePotok = namePotok;
        this.namefile = namefile;
    }

    @Override
    public void run() {
        if (BreakAllThreads)
            return;

        System.out.println("Поток " + this.namePotok + " вошли ");

        ValidateNumberString validateNumberString = new ValidateNumberString();
        try (BufferedReader br = new BufferedReader(new FileReader(namefile))) {
            int c;

            boolean flagMinus = false;
            String curNumber = "";
            String curSimv;
            String s;
            //while ((c = br.read()) != -1) {
            while ((s = br.readLine()) != null) {
                if (BreakAllThreads)
                    return;

                for (String retval : s.split(" ")) {
                    flagMinus = false;

//                    for (int numSimb =0; numSimb <retval.length(); numSimb++)
//                    {
//                        c = retval.charAt(numSimb);
//                        if ((c < 48) || (c > 57)) {
//                            BreakAllThreads = true;
//                            System.out.println("Внимание: потоки прервались с ошибкой!!!!!!!!!!!");
//                            return;
//                        }
//                    }

                    if (!validateNumberString.validateString(retval)) {
                        BreakAllThreads = true;
                        System.out.println("Внимание: потоки прервались с ошибкой. Нечисловой символ!!!!!!!!!!!"+retval);
                        return;
                    }

                    if ((Integer.parseInt(retval) > 0) && (retval.length() != 0) && ((Integer.parseInt(retval) % 2) == 0 )) {
                        synchronized (obj) {
                            sum += Integer.parseInt(retval);
                            System.out.println("Поток " + namePotok + ", сумма " + sum);
                        }
                    }

                 }
            }
//            // возможно красивее можно сделать, без выхода из цикла
//            if ((!flagMinus) && (curNumber.length() != 0) && ((Integer.parseInt(curNumber) % 2) == 0 )) {
//                sum += Integer.parseInt(curNumber);
//                System.out.println("Поток " + namePotok + ", сумма " + sum);
//            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static boolean isBreakAllThreads() {
        return BreakAllThreads;
    }

    public static int getSum() {
        return sum;
    }
}
