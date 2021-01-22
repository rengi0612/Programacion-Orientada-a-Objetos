/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

public enum CardSuit {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    private final char suitChar;

    CardSuit(final char suitChar) {
        this.suitChar = suitChar;
    }

    char getSuitChar() {
        return suitChar;
    }
}
