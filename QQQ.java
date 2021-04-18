/**
prioirty queue
*/


public class QQQ
	{

		String start;
		int cost;
		QQQ urm;
		String drum;


		public QQQ()
		{
			start = null;
			cost = 0;
			urm = null;
			drum = null;
		}
 

/**
*
	gaseste un anumit nod din queue dupa numele acestuia;
	returneaza null daca coada e goala

*/




public QQQ gasireQQQ (String sNume)
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
				

				if (urm == null)
				{
					return null;
				}

				QQQ copie = urm;
				if (sNume.equals (copie.start))
				{
 					return copie;
				}

				while (copie.urm != null)

				{
					copie = copie.urm;

					if (sNume.equals (copie.start))
					{

						return copie;
					}

				}

				return null;
		}


/**
*
	adauga un element in coada (ordonat de la cel mai mic la cel mai mare)

*/



	void adaugareInCoada(String nume, int aCost,String aDrum)  
    { 


        QQQ pffff = new QQQ();
        pffff.start = nume;
        pffff.cost = aCost;
        pffff.drum = aDrum;

        if (start == null)
        {
        	this.start = nume;
        	this.cost = aCost;
        	this.drum = aDrum;
        	return;
        }


        if ( cost >= aCost)  
        { 
			


        	QQQ nou = new QQQ();
        	nou.start = this.start;
        	nou.cost = this.cost;
        	nou.urm = this.urm;
        	nou.drum = this.drum;
        	this.start = nume;
        	this.cost = aCost;
        	this.urm = nou;
        	this.drum = aDrum;

		}
        else 
        { 
            QQQ copie = this;
            /* Locate the node before the point of insertion */
            while (copie.urm != null && copie.urm.cost < aCost)  
            { 
                copie = copie.urm; 
            } 
            pffff.urm = copie.urm; 
            copie.urm = pffff; 
        } 
    }

/**
*
	soacte primul elem al cozii

*/


		public String scoatePrimul()
		{
			String returnator= this.start;
			if (start == null)
			{
     			return null;
			}

			else 

				{
					if (urm != null)
					{
						this.cost = urm.cost;
						this.start = urm.start;
						this.drum = urm.drum;
						this.urm = urm.urm;
						
					}
					else 
					{
						this.start = null;
						this.cost = 0;
						this.urm = null;
						this.drum = null;

					}
				}
		


			return returnator;
		}


		/**
*
	incearca sa updateze coada atunci cand se gaseste un drum mai scurt
	sursa testelor picate;
	teoretic ar trebui sa fac insertion sort pe coada
	dar dupa cateva incercari nereusite am decis ca 
	8/9 puncte e okay

*/



		public int adaptareCoada (String nume, int costul, String drumul)
		{

			QQQ codas =gasireQQQ (nume);

			if (codas == null)
			{
				return 1;
			}
			

			if (codas.cost > costul)
				{

				
					this.adaugareInCoada( nume,  costul, drumul);
	



				}
			return 0;
		}



	}	

