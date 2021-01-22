/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.*;
import java.util.stream.Collectors;


public final class Hand implements Comparable<Hand> {
    private List<Card> cardsProvided;
    private HandType handType = null;
    private List<Card> cardsProvidedInitial;
    List<CardSuit> listSuit;
    List<CardValue> listValue;
    CardSuit arreglo[]= new CardSuit[5];
    CardValue arreglo2[]= new CardValue[5];
    String inicial = null;

    Hand(final String handAsString) {
        // TODO
    	inicial = handAsString;
    	String [] cards = handAsString.split(" ");
    	this.cardsProvided = Arrays.asList(cards).stream()
						    			.map(Card::new)
						    			.sorted()
						                .collect(Collectors.toList());
    	this.cardsProvidedInitial = Arrays.asList(cards).stream()
						    			.map(Card::new)
						                .collect(Collectors.toList());

    	determineHandType();
    }

    @Override
    public String toString() {
    	String resultado = cardsProvidedInitial.get(cardsProvidedInitial.size()-1).toString();
    	for(int i=cardsProvidedInitial.size()-2; i>=0 ;i--)
    	{
    		resultado = cardsProvidedInitial.get(i).toString() + " " + resultado ;
    	}
    	
        return resultado; // TODO
    }

    @Override
    public int compareTo(Hand o) 
    {
    	List<Integer> bestHand = o.cardsProvided.stream().map(a -> {return a.getValue().ordinal();}).collect(Collectors.toList());
		List<Integer> thisHand = this.cardsProvided.stream().map(a -> {return a.getValue().ordinal();}).collect(Collectors.toList());
    	int totalBest = bestHand.stream().mapToInt(i->i).sum();
    	int totalThis = thisHand.stream().mapToInt(i->i).sum();
		
		if(this.handType.ordinal() > o.handType.ordinal())
		{
			return 1;
		}
		else if(this.handType.ordinal()==o.handType.ordinal())
		{
			if(this.cardsProvided.equals(o.cardsProvided)) 
	    	{
	    		return 0;
	    	}
			
	    	else if(totalBest == totalThis)
	    	{
	    		return 0;
	    	}
	    	else if(totalBest < totalThis)
	    	{
	    		return 1;
	    	}/*
	    	else if(bestHand.stream().mapToInt(i -> i).max().getAsInt() == thisHand.stream().mapToInt(i -> i).max().getAsInt())
			{
				return 0;
			}
			else if(bestHand.stream().mapToInt(i -> i).max().getAsInt() < thisHand.stream().mapToInt(i -> i).max().getAsInt())
			{
				return 1; 
			}*/
	    	else
	    	{
	    		return -1;
	    	}
		}
		else
		{
			return -1;
		}
    }
    /*@Override
    public boolean equals(Object obj)
    {
    	if(obj==this)
    	{
    		return true;
    	}
    	if (!(obj instanceof Hand)) { 
            return false; 
        } 
    	Hand mano = (Hand) obj;
    	
    	return true;
    }*/
    
    /*private boolean pares(Hand o)
    {
    	List<Integer> thisHand = this.cardsProvided.stream().map(a -> {return a.getValue().ordinal();}).collect(Collectors.toList());
    	int totalThis = thisHand.stream().mapToInt(i->i).sum();
    	int mayorThis = 0;
    	int menorThis = 0;
    	
    	List<Integer> bestHand = o.cardsProvided.stream().map(a -> {return a.getValue().ordinal();}).collect(Collectors.toList());
    	int totalBest = bestHand.stream().mapToInt(i->i).sum();
    	int mayorBest = 0;
    	int menorBest = 0;
    	
    	List<List<Integer>> thisTrans = new ArrayList<List<Integer>> ();
    	List<Integer> temporal; 
    	for(int i=0; i<thisHand.size();i++)
    	{
    		temporal = new ArrayList<>();
    		
    		for(int j=0; j<thisHand.size();j++)
    		{
    			if( (thisHand.get(i)/thisHand.get(j)) == 1)
    			{
    				temporal.add(1);
    			}
    			else
    			{
    				temporal.add(0);
    			}
    		}
    		thisTrans.add(temporal);
    	}
    	int eliminator = -1;
    	for(int i = 0; i<thisTrans.size(); i++)
    	{
    		for (int j = 0; j<thisTrans.size(); j++)
    		{
    			if(thisTrans.get(i).get(j)==1)
    			{
    				eliminator = -1;
    				break;
    			}
    			else
    			{
    				eliminator = i;
    			}
    		}
    	}
    	thisTrans.remove(eliminator);
    	return true;
    }*/
    
    private void determineHandType()
    {
    	
    	if(sameSuit())
    	{
    		if(sequence())
    		{
    			if(cardsProvided.get(0).getValue().ordinal() == 13)
    			{
    				this.handType = HandType.ROYAL_FLUSH;
    			}
    			else
    			{
    				this.handType = HandType.STRAIGHT_FLUSH;
    			}
    		}
    		else
    		{
    			this.handType = HandType.FLUSH;
    		}
    		
    	}
    	else 
    	{
    		int [] mayores = sameValue();
    		
    		switch(mayores[0])
    		{
    		case 4:
    			this.handType = HandType.FOUR_OF_A_KIND;
    			break;
    		case 3:
    			if(mayores[1]==2)
    			{
    				this.handType = HandType.FULL_HOUSE;
    			}
    			else
    			{
    				this.handType = HandType.THREE_OF_A_KIND;
    			}
    			break;
    		case 2:
    			if(mayores[1]==2)
    			{
    				this.handType = HandType.TWO_PAIRS;
    			}
    			else
    			{
    				this.handType = HandType.PAIR;
    			}
    			break;
    		case 1:
    			if(sequence())
    			{
    				this.handType = HandType.STRAIGHT;
    			}
    			else
    			{
    				this.handType = HandType.HIGH_CARD;
    			}
    			break;
    			
    		}
    	}
    	
    }
    
    private boolean sameSuit()
    {
    	boolean flag =  false;
    	
    	for(int k = 0; k<cardsProvided.size();k++)
    	{
    		for(int l = k+1; l<cardsProvided.size();l++)
    		{
    			if(cardsProvided.get(k).compareSuit(cardsProvided.get(l)))
    			{
    				flag = true;
    			}
    			else
    			{
    				flag = false;
    				break;
    			}
    		}
    		if(flag == false)
    		{
    			break;
    		}
    	}
    	return flag;
    }
    
    private boolean sequence()
    {
    	boolean flag =  false;
    	int orientation = minMax();
    	if(orientation == 1)
    	{
    		for(int k = 0; k<cardsProvided.size(); k++)
        	{
        		for(int l = k+1; l<cardsProvided.size();l++)
        		{
        			if(cardsProvided.get(l).getValue().ordinal() == cardsProvided.get(k).getValue().ordinal() + (1))
        			{
        				flag = true;
        				break;
        			}
        			else
        			{
        				flag = false;
        			}
        		}
        		if(flag==false)
        		{
        			break;
        		}
        	}
    		return flag;
    	}
    	else
    	{
    		for(int k = 0; k<cardsProvided.size(); k++)
        	{
        		for(int l = k+1; l<cardsProvided.size();l++)
        		{
        			if(cardsProvided.get(l).getValue().ordinal() == cardsProvided.get(k).getValue().ordinal() - (1))
        			{
        				flag = true;
        				break;
        			}
        			else
        			{
        				flag = false;
        			}
        		}
        		if(flag==false)
        		{
        			break;
        		}
        	}
    		return flag;
    	}
   	
    }
    
    private int minMax()
    {
    	for(int k = 0; k<cardsProvided.size(); k++)
    	{
    		for(int l = k+1; l<cardsProvided.size();l++)
    		{
    			if(cardsProvided.get(k).compareTo(cardsProvided.get(l)) == 1)
    			{
    				return 1; //Increasing
    			}

    		}
    	}
    	return 0;
    	
    }
    
    private int[] sameValue()
    {
    	List<CardValue> arreglo = new ArrayList<CardValue>();
    	int arreglo2[] = new int[5];
    	int[] mayor = new int[2];
    	for(int k = 0; k<5; k++)
    	{
    		arreglo.add(cardsProvided.get(k).getValue());
    	}
    	for(int l = 0; l<5; l++)
    	{
    		arreglo2[l] = Collections.frequency(arreglo,cardsProvided.get(l).getValue());
    	}
    	int max = arreglo2[0];
    	int min = arreglo2[0];	
    	int contador = 0;
    	for (int m = 0; m<5; m++)
    	{
    		if(max<arreglo2[m])
    		{
    			max = arreglo2[m];
    		}
    		else
    		{
    			contador++;
    		}
    		if(min>arreglo2[m])
    		{
    			min = arreglo2[m];
    		}
    	}
    	int max2 = min;
    	for (int m = 0; m<5; m++)
    	{
    		if(max2<arreglo2[m] && max!=arreglo2[m])
    		{
    			max2 = arreglo2[m];
    		}
    		else if(max == 2 && contador >= 4)
    		{
    			max2 = 2;
    		}

    	}
    	mayor[0] = max;
    	mayor[1] = max2;
    	return mayor;
    }
    
    public List<Integer> frequencyValue()
    {
    	List<CardValue> arreglo = new ArrayList<CardValue>();
    	//int arreglo2[] = new int[cardsProvided.size()];
    	List<Integer> total = new ArrayList<Integer>();
    	for(int k = 0; k<5; k++)
    	{
    		arreglo.add(cardsProvided.get(k).getValue());
    	}
    	for(int l = 0; l<5; l++)
    	{
    		//arreglo2[l] = Collections.frequency(arreglo,cardsProvided.get(l).getValue());
    		total.add(Collections.frequency(arreglo,cardsProvided.get(l).getValue()));
    	}
    	return total;
    }
    

}
