package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingK4QU38-4MZ/
public class lesson5_GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
        int[] A = new int[S.length()];
        int[] C = new int[S.length()];
        int[] G = new int[S.length()];
        char[] ch = S.toCharArray();
        int[] ans = new int[P.length];
        if(ch[0]=='A'){
            A[0]++;
        } else if(ch[0]=='C'){
            C[0]++;
        } else if(ch[0]=='G'){
            G[0]++;
        }
        for(int i = 1; i < ch.length; i++){
            A[i] = A[i-1];
            C[i] = C[i-1];
            G[i] = G[i-1];
            switch(ch[i]){
                case 'A':
                    A[i]++;
                    break;
                case 'C':
                    C[i]++;
                    break;
                case 'G':
                    G[i]++;
                    break;         
            }            
        }
        for(int i = 0; i < P.length; i++){            
            int left = P[i];
            int right = Q[i];            
            char min = 'T';
            if(left==0){
                if(A[right]>0)min='A';
                else if(C[right]>0)min='C';
                else if(G[right]>0)min='G';
            } else {
                if(A[left-1]!=A[right])min='A';
                else if(C[left-1]!=C[right])min='C';
                else if(G[left-1]!=G[right])min='G';
            }
            switch(min){
                case 'A':
                    ans[i] = 1;
                    break;
                case 'C':
                    ans[i] = 2;
                    break;
                case 'G':
                    ans[i] = 3;
                    break;
                case 'T':
                    ans[i] = 4;
                    break;       
            }
        }
        return ans;
    }
}
