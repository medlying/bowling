package com.sodacar.dojo.roman;

import java.util.List;

/**
 * @author Hu bosong
 * @date 2018/5/2
 */
public class Roman {

    public int romanToDecimal(String roman) {
        int result = 0;
        char[] chars = roman.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (getValueBySymbol(chars[i]) >= getValueBySymbol(chars[i + 1])) {
                result += getValueBySymbol(chars[i]);
            } else {
                result = result + getValueBySymbol(chars[i + 1]) - getValueBySymbol(chars[i]);
                i++;
            }
        }
        if(getValueBySymbol(chars[chars.length - 2]) >= getValueBySymbol(chars[chars.length - 1])) {
            result += getValueBySymbol(chars[chars.length - 1]);
        }
        return result;
    }

    public String decimalToRoman(int decimal) {
        StringBuilder sb = new StringBuilder();
        int countM = decimal / 1000;
        int countC = (decimal % 1000)/100;
        int countX = (decimal % 100) / 10;
        int countI = decimal % 10;
        for (int i = countM; i > 0; i--) {
            sb.append("M");
        }
        sb.append(handle(countC, "M", "D", "C"))
            .append(handle(countX, "C", "L", "X"))
            .append(handle(countI, "X", "V", "I"));

        return sb.toString();
    }

    String handle(int count, String previous, String present, String next) {
        StringBuilder sb = new StringBuilder();
        if(count == 9) {
            sb.append(next).append(previous);
        }else if(count > 5 && count < 9){
            sb.append(present);
            for (int i = 0; i < count - 5; i++) {
                sb.append(next);
            }
        } else if(count == 5) {
            sb.append(present);
        } else if(count == 4){
            sb.append(next).append(present);
        } else if(count > 0 && count < 4){
            for (int i = 0; i < count; i++) {
                sb.append(next);
            }
        }
        return sb.toString();
    }

    int getValueBySymbol(char symbol) {
        return RomanNumber.valueOf(String.valueOf(symbol)).getValue();
    }

    enum RomanNumber {
        I("I", 1),
        V("V", 5),
        X("X", 10),
        L("L", 50),
        C("C", 100),
        D("D", 500),
        M("M", 1000);


        private String symbol;

        private int value;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        RomanNumber(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }
}
