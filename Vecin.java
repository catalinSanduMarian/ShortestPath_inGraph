	public class Vecin
	{
		String end;
		Vecin urm;
		int cost;
		int supliment;
		int size;


		public Vecin()
		{
			end = null;
			urm = null;
			cost = 0;
			supliment =0;
			size = 0;
		}
/**
*
	adauga o strada noua la finalul listei de strazi

*/



		public void Invecinare (String nume, int acost, int asize )
		{	


			if ( end == null)
			{
				 end = nume;
				 cost = acost;
				 size = asize;
			}
			else
			{
				if ( urm != null)
				{		
					Vecin copie =  urm;
					while ( copie.urm != null)
					{
						copie = copie.urm;
					}

					copie.urm = new Vecin();
					copie.urm.end = nume;
					copie.urm.cost = acost;
					copie.urm.size = asize;
				}
				else 
				{
					 urm = new Vecin();
					 urm.end = nume;
					 urm.cost = acost;
					 urm.size = asize;
				}
			}
		}

		/**
*
	adauga un cost suplimentar in cazul unui accident/blocaj

*/

		public void adaugeCost (String nume, int acost)
		{

 				if ( end == null)
				{

					return;
				}
				else
				{
 					


					if (end.equals(nume))
					{	
						//schimb costul
						supliment = supliment + acost;

 						return;

					}


				}

				Vecin copie = urm;
				if (copie.end.equals (nume))
				{
					//fac vecin
					copie.supliment = copie.supliment + acost;
 					return;
				}



				while (copie.urm != null)

				{
					copie = copie.urm;

					if (copie.end.equals (nume))
					{
						copie.supliment = copie.supliment + acost;
						return;
					}

				}



		}
		


	}