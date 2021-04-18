public class Graf
	{
		String start;
		Graf urm;
		Vecin primul;

		public Graf()
		{
			start= null;
			urm = null;
			primul = new Vecin();
		}



/**
*
	metoda gasire graf primeste numele unei celule a grafului 
	si returneaza locatia  acesteia

*/


public Graf gasireGraf (String sNume)
		{
			if ( start == null)
				{
					return null;
				}
				else
				{
 					
					if (start.equals(sNume))
					{	
 						return this;
					}

				}

				Graf copie = urm;
				if (copie.start.equals (sNume))
				{
 					return copie;
				}

				while (copie.urm != null)

				{
					copie = copie.urm;

					if (copie.start.equals (sNume))
					{

						return copie;
					}

				}

				return null;
		}



/**
*
	adaugare adauga o celula goala de tipul graf 

*/


		public void adaugare (String nume )
		{	


			if ( start == null)
			{
				 start = nume;
			}
			else
			{
				if ( urm != null)
				{		
					Graf copie =  urm;
					while ( copie.urm != null)
					{
						copie = copie.urm;
					}

					copie.urm = new Graf();
					copie.urm.start = nume;
				}
				else 
				{
					 urm = new Graf();
					 urm.start = nume;

				}
			}


		}


/**
*
	adauga o noua starda in graf (se numeste vecin deoarece 
	nu am avut inspiratia sa le denumesc dupa cerinta)

*/
		public void adaugareVecin (String gnume, String vnume,int cost, int size)
		{
				
 				Graf cevaInspirat = gasireGraf(gnume);
 				cevaInspirat.primul.Invecinare (vnume,cost,size);

		}


		/**
*
	adauga o restrictie de un anumit cost

*/


		public void adaugareRestrictie (String gnume, String vnume,int cost)
		{

			 Graf restrictie = gasireGraf(gnume);
			 restrictie.primul.adaugeCost (vnume, cost);

		}


		

		public void dijsktra (Graf inceput, String destinatie , int size, int nr, int vehicul)
		{

			Graf cincept = inceput;
			int contor =0,k,costcurent =0;
			String[] vizitat = new String[nr*3];
			String suntGata =inceput.start;

			QQQ lor = new QQQ();

			while (vizitat[nr-1] == null)
			{
				
				k=1;



				Vecin verific = cincept.primul;				

				if (verific.end != null)
				{

					int varCost = verific.cost*vehicul +verific.supliment +costcurent;


					k = getK(size, nr, k, vizitat, suntGata, lor, verific, varCost);

					if (verific.urm != null)
					{
						Vecin copie = verific.urm;
						

						varCost = copie.cost*vehicul +copie.supliment +costcurent;


						k = getK(size, nr, k, vizitat, suntGata, lor, copie, varCost);
						while (copie.urm != null)
						{
							copie = copie.urm;

							varCost = copie.cost*vehicul +copie.supliment +costcurent;


							k = getK(size, nr, k, vizitat, suntGata, lor, copie, varCost);
						}
					}
				}



				//lor.printareCoada();
				

				vizitat[contor] = cincept.start;
				if (vizitat[contor].equals(destinatie))
				{
					break;
				}		



				contor ++;
				
				//System.out.println ("SUNTGATA1=" + suntGata +costcurent);

				costcurent = lor.cost;
				suntGata = lor.drum;

				//System.out.println ("SUNTGATA2=" + suntGata+ costcurent);


				String numeDeVariabila = lor.scoatePrimul();
				if (numeDeVariabila == null)
				{
					System.out.println (inceput.start +" "+ destinatie +" null" );

					return;
				

				}
				cincept= gasireGraf(numeDeVariabila);



			}



			
	
			
				System.out.println (suntGata +" "+ costcurent);


		}

		private int getK(int size, int nr, int k, String[] vizitat, String suntGata, QQQ lor, Vecin verific, int varCost) {
			int i;
			for (i =0; i< nr; i++)
			{
				if (verific.end.equals(vizitat[i]))
					k =0;
			}

			if (size > verific.size)
			{
				k=0;
			}


			if (k == 1)
			{
				int a= lor.adaptareCoada(verific.end,varCost,suntGata+ " " + verific.end);
				if (a ==1)
					lor.adaugareInCoada(verific.end,varCost, suntGata +" "+ verific.end);

				//adaug in q?
			}
			k=1;
			return k;
		}


		public void drive(String sNume, String eNume,int size,int inmultire, int nr)
		{
			

			Graf inceput = gasireGraf(sNume);
			dijsktra(inceput, eNume, size, nr, inmultire);

		
		}
	}