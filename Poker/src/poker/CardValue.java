/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

public enum CardValue {
    TWO("2"), //0
    THREE("3"), //1
    FOUR("4"), //2
    FIVE("5"), //3
    SIX("6"), //4
    SEVEN("7"), //5
    EIGHT("8"), //6
    NINE("9"), //7
    TEN("10"), //8
    JACK("J"), //9
    QUEEN("Q"), //10
    KING("K"), //11
    ACE("A"); //12

    private final String valueString;

    CardValue(final String valueString) {
        this.valueString = valueString;
    }

    String getValueString() {
        return valueString;
    }
    
    int getValueInt() {
    	return Integer.valueOf(valueString);
    }
}
