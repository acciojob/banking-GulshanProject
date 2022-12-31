package com.driver;
import java.util.Objects;
public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name,balance,5000);
        if(balance==5000)
        {
            System.out.println(" it is minimum required money");
        }
        else if(balance < 5000)                     // may be error
        {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String finalString = checkValidOrNot(tradeLicenseId);

        if (Objects.equals(finalString, ""))
            throw new Exception("Valid License can not be generated");


    }


   public String checkValidOrNot(String str){

        int len = str.length();
        if (len == 0)
            return "";
   // freuncy arr
        int[] frequency = new int[26];
        for (int i = 0; i < 26; i++) {
            frequency[i] = 0;
        }
        for (char cher : str.toCharArray()) {
            frequency[(int)cher - (int)'a']++;
        }

        char char_max = maxCountCharacter(frequency);
        int maxCount = frequency[(int)char_max - (int)'a'];

        // check if rearranged  is possible or not
        if (maxCount > (len + 1) / 2)
            return "";

        String resultString = "";
        for (int i = 0; i < len; i++) {
            resultString += ' ';
        }

        int ind = 0;     // ind =index;

        // even indices check for string
        while (maxCount > 0) {
            resultString = resultString.substring(0, ind) + char_max+ resultString.substring(ind + 1);
            ind = ind + 2;
           maxCount--;
        }
        frequency[(int)char_max - (int)'a'] = 0;

        // now filling the other Chars, first filling the
        // even positions and then the odd positions
        for (int i = 0; i < 26; i++) {
            while (frequency[i] > 0) {
                ind = (ind >= len) ? 1 : ind;
                resultString = resultString.substring(0, ind)
                        + (char)((int)'a' + i)
                        + resultString.substring(ind + 1);
                ind += 2;
                frequency[i]--;
            }
        }
        return resultString;
    }


    public char maxCountCharacter(int[] countCharr)
    {
        int max = 0;
        char cha = 0;
        for (int i = 0; i < 26; i++) {
            if (countCharr[i] > max) {
                max = countCharr[i];
                cha = (char)((int)'a' + i);
            }
        }
        return cha;
    }

}
