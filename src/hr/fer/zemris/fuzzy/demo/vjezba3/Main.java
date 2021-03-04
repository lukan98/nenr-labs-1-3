package hr.fer.zemris.fuzzy.demo.vjezba3;
import java.io.*;
import java.util.Scanner;

import hr.fer.zemris.fuzzy.system.*;

public class Main {


    public static void main(String[] args) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      	
      	Defuzzifier defuzz = new CoADefuzzifier();
      	AccelerationFuzzySystem afs = new AccelerationFuzzySystem(defuzz);
      	RudderFuzzySystem rfs = new RudderFuzzySystem(defuzz);
      	
	    int L=0,D=0,LK=0,DK=0,V=0,S=0,akcel,kormilo;
	    String line = null;
		  while(true){
			      if((line = input.readLine())!=null){
      				if(line.charAt(0)=='K') break;
      				@SuppressWarnings("resource")
					Scanner s = new Scanner(line);
      				L = s.nextInt();
      				D = s.nextInt();
      				LK = s.nextInt();
      				DK = s.nextInt();
      				V = s.nextInt();
      				S = s.nextInt();
	          }

  	        akcel = afs.determineProd(new int[] {L, D, LK, DK, V, S});
  	        kormilo = rfs.determineProd(new int[] {L, D, LK, DK, V, S});
  	        System.out.println(akcel + " " + kormilo);
  	        System.out.flush();
	   }
    }

}
