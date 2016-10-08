package me.adriel.coderdecoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static HashMap<Character, Integer> a1 = new HashMap<>();
	static String abc = "abcdefghijklmnopqrstuvwxyz" ;
	static ArrayList<Character> newchar = new ArrayList<Character>();

	public static void main(String[] args){
		
		for (int j = 0; j < abc.length(); j++) {
			a1.put(abc.charAt(j), j);
		}
		
		System.out.println(coder("zygomatique", 28));
		System.out.println(decoder("baiqocvkswg", 2));

	}

	public static String coder(String s, int i){
		
		newchar.clear();

		for(char c : s.toCharArray()){

			int pos = a1.get(c);
			int newpos;

			if(pos + i < 26){
				newpos = pos + (i);
			}else{
				newpos = (pos + i)%26;	
			}

			char nc = (char) a1.keySet().toArray()[newpos];
			newchar.add(nc);
		}
		return chartoString(newchar);
	}




	public static String decoder(String s, int i){

		newchar.clear();
		
		for(char c : s.toCharArray()){

			int pos = a1.get(c);
			int newpos;

			if(pos - i >= 0){
				newpos = pos - (i);
			}else if((i - pos) <= 26){
				newpos = 26 - (i - pos);
			}else{
				newpos = 26%(26 - (i - pos));
			}

			char nc = (char) a1.keySet().toArray()[newpos];
			newchar.add(nc);
		}
		return chartoString(newchar);
	}


	public static String chartoString(ArrayList<Character> c){

		Iterator<Character> it = c.iterator();
		StringBuilder sb = new StringBuilder();

		while(it.hasNext()) {
			sb.append(it.next());
		}
		return sb.toString();

	}

}
