/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Jason Retana
 */
public class Poker {
    private final List<Hand> hands;

    public Poker(final List<String> hands1) {
        //Convert strings to Hand objects
        this.hands = hands1.stream()
                .map(Hand::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getBestHands() {
        //Check if list of hands is empty
        if (hands.isEmpty()) {
            return Collections.emptyList();
        }
        
        //Get first hand to compare against the others
        Hand bestHand = hands.get(hands.size() - 1);
        return hands.stream()
                .filter(hand -> hand.compareTo(bestHand) == 0)
                .sorted()
                .map(Hand::toString)
                .collect(Collectors.toList());

    }    
}