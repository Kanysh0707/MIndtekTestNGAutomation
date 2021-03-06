package utilities;

import java.util.Random;

public class DataUtils {
    /*
    This method will generate random email.
    Ex:
    .generateEmail();->"abc1234@gmail.com"
     */
    public static String generateEmail(){
        Random random=new Random();
        int emailID=random.nextInt(1000);
        String email="abc"+emailID+"@gmail.com";
        return email;

    }
    /*
    This method will generate btw 1 and provided param.
    Ex;
    .generateRandomNumber(30);
     */
    public static int generateRandomNumber(int range){
        Random random=new Random();
        int randomNum=random.nextInt(range);
        return randomNum;
    }
    /*
    This method will remove dollar sign from String
    and will convert it to double.
    Ex.
    .remove$AndConvertToDouble($16.51)->returns double->16.51
     */
    public static double remove$AndConvertToDouble(String amount){
        amount=amount.substring(1);
        return Double.parseDouble(amount);
    }
}
