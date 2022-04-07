public class Vecin {
    String end;
    Vecin next;
    int cost;
    int suplimentaryCost;
    int size;


    public Vecin() {
        end = null;
        next = null;
        cost = 0;
        suplimentaryCost = 0;
        size = 0;
    }

    /**
     * adauga o strada noua la finalul listei de strazi
     */


    public void AddNeighbour(String nume, int cost, int size) {
        if (end == null) {
            end = nume;
            this.cost = cost;
            this.size = size;
        } else {
            if (next != null) {
                Vecin copie = next;
                while (copie.next != null) {
                    copie = copie.next;
                }

                copie.next = new Vecin();
                copie.next.end = nume;
                copie.next.cost = cost;
                copie.next.size = size;
            } else {
                next = new Vecin();
                next.end = nume;
                next.cost = cost;
                next.size = size;
            }
        }
    }

    /**
     * adauga un cost suplimentar in cazul unui accident/blocaj
     */

    public void addCost(String nume, int acost) {

        if (end == null) {
            return;
        } else {
            if (end.equals(nume)) {
                //schimb costul
                suplimentaryCost = suplimentaryCost + acost;
                return;
            }
        }

        Vecin copie = next;
        if (copie.end.equals(nume)) {
            //fac vecin
            copie.suplimentaryCost = copie.suplimentaryCost + acost;
            return;
        }

        while (copie.next != null) {
            copie = copie.next;

            if (copie.end.equals(nume)) {
                copie.suplimentaryCost = copie.suplimentaryCost + acost;
                return;
            }
        }
    }
}