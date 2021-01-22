/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

public final class Card implements Comparable<Card> {
    private final CardSuit suit;
    private final CardValue value;
    CardSuit arreglo[] = CardSuit.values();
    CardValue arreglo2[] = CardValue.values();

    Card(final String cardAsString) {
    	char suitChar;
    	String valueChar;
    	if(cardAsString.length()==3)
    	{
    		suitChar = cardAsString.charAt(2);
    		valueChar = cardAsString.substring(0,2);
    	}
    	else
    	{
    		suitChar = cardAsString.charAt(1);
        	valueChar = cardAsString.substring(0,1);
    	}
    	CardSuit preSuit = null;
    	CardValue preValue = null;
    	for (CardSuit sui:arreglo)
    	{
    		if(sui.getSuitChar()==suitChar)
    		{
    			preSuit = sui;
    			break;
    		}
    		else
    		{
    			preSuit=null;
    		}
    	}
    	for (CardValue val:arreglo2)
    	{
    		if(val.getValueString().equals(valueChar))
    		{
    			preValue = val;
    			break;
    		}
    		else
    		{
    			preValue=null;
    		}
    	}
        suit = preSuit;
        value = preValue;
    }

    CardSuit getSuit() {
        return suit;
    }

    CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
    	char suitStr2 = suit.getSuitChar();
    	String suitStr = String.valueOf(suitStr2);
    	String valueStr = value.getValueString();
        return valueStr.concat(suitStr);
    }

    @Override
    public int compareTo(Card o) {
    	
    	if(o.value.ordinal() == value.ordinal() )
    	{
    		return 0;
    	}
    	else if(value.ordinal() < o.value.ordinal())
    	{
    		return 1;
    	}
    	else
    	{
    		return -1;
    	}   
    	
    }
    
    public boolean compareSuit(Card o)
    {
    	if(this.suit == o.suit)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
}