public class Graf {
    String name;
    Graf urm;
    Vecin neighbours;

    public Graf() {
        name = null;
        urm = null;
        neighbours = new Vecin();
    }

    public Graf gasireGraf(String graphName) {
        if (name == null) {
            return null;
        } else {
            if (name.equals(graphName)) {
                return this;
            }
        }

        Graf copie = urm;
        if (copie.name.equals(graphName)) {
            return copie;
        }

        while (copie.urm != null) {
            copie = copie.urm;
            if (copie.name.equals(graphName)) {
                return copie;
            }
        }
        return null;
    }

    public void adaugare(String nume) {

        if (name == null) {
            name = nume;
        } else {
            if (urm != null) {
                Graf copie = urm;
                while (copie.urm != null) {
                    copie = copie.urm;
                }

                copie.urm = new Graf();
                copie.urm.name = nume;
            } else {
                urm = new Graf();
                urm.name = nume;
            }
        }
    }

    public void adaugareVecin(String graphName, String neighbourName, int cost, int size) {

        Graf graph = gasireGraf(graphName);
        graph.neighbours.AddNeighbour(neighbourName, cost, size);

    }

    public void adaugareRestrictie(String graphName, String neighbourName, int cost) {

        Graf restrictie = gasireGraf(graphName);
        restrictie.neighbours.addCost(neighbourName, cost);

    }

    public void dijsktra(Graf startPoint, String destinatie, int size, int costVehicul, int numarNoduri) {

        Graf auxStartPoint = startPoint;
        int visitedCounter = 0, visited, costcurent = 0;
        String[] vizitat = new String[numarNoduri * 3];
        String path = startPoint.name;
        NodePriorityQueue queue = new NodePriorityQueue();

        while (vizitat[numarNoduri - 1] == null) {
            visited = 1;
            Vecin verific = auxStartPoint.neighbours;
            if (verific.end != null) {
                int varCost = verific.cost * costVehicul + verific.suplimentaryCost + costcurent;
                visited = checkVisited(size, numarNoduri, visited, vizitat, path, queue, verific, varCost);
                if (verific.next != null) {
                    Vecin copie = verific.next;
                    varCost = copie.cost * costVehicul + copie.suplimentaryCost + costcurent;
                    visited = checkVisited(size, numarNoduri, visited, vizitat, path, queue, copie, varCost);
                    while (copie.next != null) {
                        copie = copie.next;
                        varCost = copie.cost * costVehicul + copie.suplimentaryCost + costcurent;
                        visited = checkVisited(size, numarNoduri, visited, vizitat, path, queue, copie, varCost);
                    }
                }
            }

            vizitat[visitedCounter] = auxStartPoint.name;
            if (vizitat[visitedCounter].equals(destinatie)) {
                break;
            }

            visitedCounter++;
            costcurent = queue.cost;
            path = queue.drum;
            String numeDeVariabila = queue.getNeighbours();
            if (numeDeVariabila == null) {
                System.out.println(startPoint.name + " " + destinatie + " null");
                return;
            }
            auxStartPoint = gasireGraf(numeDeVariabila);
        }
        System.out.println(path + " " + costcurent);
    }

    private int checkVisited(int size, int numarNoduri, int Visited, String[] vizitat, String path, NodePriorityQueue queue, Vecin verific, int varCost) {
        int i;
        for (i = 0; i < numarNoduri; i++) {
            if (verific.end.equals(vizitat[i]))
                Visited = 0;
        }

        if (size > verific.size) {
            Visited = 0;
        }

        if (Visited == 1) {
            int a = queue.adaptareCoada(verific.end, varCost, path + " " + verific.end);
            if (a == 1)
                queue.adaugareInCoada(verific.end, varCost, path + " " + verific.end);
        }

        return Visited;
    }

    public void drive(String startPoint, String destinatie, int size, int costVehicul, int numarNoduri) {
        Graf inceput = gasireGraf(startPoint);
        dijsktra(inceput, destinatie, size, costVehicul, numarNoduri);
    }
}