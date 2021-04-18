import java.util.Scanner; 
import java.io.File;
import java.io.*;


public class Main{


/**
*
	am modelat graful dupa numarul de noduri primit ca parametru

*/

	public static Graf grafare(int numarNoduri)
     	{	
     		Graf foame = new Graf();
     		String seg = "P";
      		for (int i=0;i<numarNoduri; i++)
     		{
     			String t= seg+i;
     			foame.adaugare (t);
     		}	
     		

     		return foame;
     	}

	public static void main(String[] args)  throws IOException
	{

		int numarStrazi, numarNoduri;
		String nimereala;

/*

	am initializat parsatorul graful si celalte entitati primite ca parametru

*/


     	Scanner myObj = new Scanner(new File ("map.in"));




     	Graf foame;


		numarStrazi = myObj.nextInt();
        numarNoduri = myObj.nextInt();
 
/*

	initializez graful cu numarul de noduri dat

*/

    	foame = grafare (numarNoduri);


		myObj.nextLine();

         for (int i=0; i<numarStrazi; i++)
         {
         	nimereala= myObj.nextLine();
 
         	String[] spatiere = nimereala.split(" ");
 
         	int costul = Integer.parseInt(spatiere[2]);
         	int sizeul = Integer.parseInt(spatiere[3]);

/*

	apelez metoda addstreet (doar ca am denumit-o diferit)

*/

			foame.adaugareVecin (spatiere[0], spatiere[1],costul, sizeul);

         }

         while ( myObj.hasNextLine() )
         {
         	nimereala= myObj.nextLine();
          	String[] spatiere = nimereala.split(" ");


         	if (spatiere[0].equals("drive"))
         	{

/*

	apelez metoda drive (pentru a evita creearea claselor de tipul autoturism, 
	metoda drive primeste direct size-ul si costul autoturismelor)

*/

         		if (spatiere[1].equals ("b"))

         			foame.drive(spatiere[2], spatiere[3],1,1, numarNoduri);

         		if (spatiere[1].equals ("m"))
         			foame.drive(spatiere[2], spatiere[3],1,2,numarNoduri);
				if (spatiere[1].equals ("a"))
					foame.drive(spatiere[2], spatiere[3],2,4,numarNoduri);
				if (spatiere[1].equals ("c"))
					foame.drive(spatiere[2], spatiere[3],3,6,numarNoduri);


         	}

/*

	atat comanda "accident" cat si "blocaj" fac acelasi lucri 
	asa ca aceeasi functie este apelata in ambele cazuris

*/



			if (spatiere[0].equals("accident"))
			{
				//fac accident
				int costul = Integer.parseInt(spatiere[3]);

				foame.adaugareRestrictie (spatiere[1], spatiere[2],costul);


			}
			if (spatiere[0].equals("blocaj"))
			{
				//fac ac lucru
				int costul = Integer.parseInt(spatiere[3]);
				foame.adaugareRestrictie (spatiere[1], spatiere[2],costul);
			}




         }





		}



     	

   


}