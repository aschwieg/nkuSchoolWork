//Alex Schwiegeraht
//Description: Finds the maximum increasing subsequence of characters in a string 

import java.util.*; 

public class MaxIncreasingSubseq {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = in.next();
		in.close();
		
		int[] score = new int[s.length()];
		int[] prev = new int[s.length()];
		
		for(int i = 0; i < s.length(); i++){
			score[i] = 1;
			prev[i] = -1;
			for(int j = 0; j < i; j++){
				
				if(s.charAt(j) < s.charAt(i) && score[j] >= score[i]){
					score[i] = score[j] + 1;
					prev[i] = j;
				}	
			}			
		}
		
		int max = score[0];
		int indexOfMax = 0;
		for(int i = 1; i < score.length; i++){
			if(score[i] > max){
				max = score[i];
				indexOfMax = i;
			}
		}
		
		int[] subSeq = new int[max]; 
		for(int i = 0; i < subSeq.length; i++){
			subSeq[i] = indexOfMax;
			indexOfMax = prev[indexOfMax];
		}
		for(int i = subSeq.length-1; i >= 0; i--){
			System.out.print(s.charAt(subSeq[i]));
		}
		
	}

}
