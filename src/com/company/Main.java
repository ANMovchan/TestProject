package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scn = new Scanner(System.in);


        if (scn.hasNext()) {
            final String input = scn.nextLine();
            String[] prepData = input.split(" ");
            if (isBothNumsRom(prepData[0], prepData[2]) || isBothNumsArab(prepData[0], prepData[2])) {
                if (isBothNumsArab(prepData[0], prepData[2])) {
                    Integer fInt = Integer.valueOf(prepData[0]);
                    Integer sInt = Integer.valueOf(prepData[2]);
                    if (!isInRange(fInt) || !isInRange(sInt)) {
                        throw new RuntimeException();
                    }
                    switch (prepData[1]) {
                        case "+":
                            System.out.println(fInt + sInt);
                            break;
                        case "-":
                            System.out.println(fInt - sInt);
                            break;
                        case "/":
                            System.out.println(fInt / sInt);
                            break;
                        case "*":
                            System.out.println(fInt * sInt);
                            break;
                        default:
                            throw new RuntimeException();
                    }
                } else {
                    Integer fInt = convertToArab(prepData[0]);
                    Integer sInt = convertToArab(prepData[2]);
                    if (!isInRange(fInt) && !isInRange(sInt)) {
                        throw new RuntimeException();
                    }
                    switch (prepData[1]) {
                        case "+":
                            System.out.println(convertToRom(fInt + sInt));
                            break;
                        case "-":
                            System.out.println(convertToRom(fInt - sInt));
                            break;
                        case "/":
                            System.out.println(convertToRom(fInt / sInt));
                            break;
                        case "*":
                            System.out.println(convertToRom(fInt * sInt));
                            break;
                        default:
                            throw new RuntimeException();
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    private static boolean isInRange(int a) {
        return a <= 10 && a >= 1;
    }

    private static boolean isBothNumsArab(String fNumber, String sNumber) {
        try {
            Integer.valueOf(fNumber);
            Integer.valueOf(sNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isBothNumsRom(String fNumber, String sNumber) {
        if (fNumber.replace("I", "").replace("X", "").replace("V", "").length() == 0) {
            if (sNumber.replace("I", "").replace("X", "").replace("V", "").length() == 0) {
                return true;
            }
        }
        return false;
    }

    private static int convertToArab(String fNumber) {
        switch (fNumber) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new RuntimeException();
        }

    }

    private static String convertToRom(int fNumber) {
        if(fNumber < 1){
            throw new RuntimeException();
        }
        int amountOfTen = fNumber / 10;
        int ost = fNumber % 10;
        String fPart = "";
        String sPart = "";
        switch (amountOfTen) {
            case 1:
                fPart = "X";
                break;
            case 2:
                fPart = "XX";
                break;
            case 3:
                fPart = "XXX";
                break;
            case 4:
                fPart = "XL";
                break;
            case 5:
                fPart = "L";
                break;
            case 6:
                fPart = "LX";
                break;
            case 7:
                fPart = "LXX";
                break;
            case 8:
                fPart = "LXXX";
                break;
            case 9:
                fPart = "XC";
                break;
            case 10:
                fPart = "C";
                break;
        }
        switch (ost) {
            case 1:
                sPart = "I";
                break;
            case 2:
                sPart = "II";
                break;
            case 3:
                sPart = "III";
                break;
            case 4:
                sPart = "IV";
                break;
            case 5:
                sPart = "V";
                break;
            case 6:
                sPart = "VI";
                break;
            case 7:
                sPart = "VII";
                break;
            case 8:
                sPart = "VIII";
                break;
            case 9:
                sPart = "IX";
                break;
        }
        return fPart + sPart;
    }
}



