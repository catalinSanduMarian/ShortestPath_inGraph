import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static Graf grafare(int numarNoduri) {
        Graf graph = new Graf();
        String seg = "P";
        for (int i = 0; i < numarNoduri; i++) {
            String t = seg + i;
            graph.adaugare(t);
        }
        return graph;
    }

    public static void main(String[] args) throws IOException {
        int numarStrazi, numarNoduri;
        String readInput;
        Scanner myObj = new Scanner(new File("map.in"));
        Graf graph;
        numarStrazi = myObj.nextInt();
        numarNoduri = myObj.nextInt();
        graph = grafare(numarNoduri);
        myObj.nextLine();

        for (int i = 0; i < numarStrazi; i++) {
            readInput = myObj.nextLine();
            String[] spatiere = readInput.split(" ");
            int cost = Integer.parseInt(spatiere[2]);
            int size = Integer.parseInt(spatiere[3]);
            graph.adaugareVecin(spatiere[0], spatiere[1], cost, size);
        }

        while (myObj.hasNextLine()) {
            readInput = myObj.nextLine();
            String[] spacing = readInput.split(" ");


            if (spacing[0].equals("drive")) {
                if (spacing[1].equals("b"))
                    graph.drive(spacing[2], spacing[3], 1, 1, numarNoduri);
                if (spacing[1].equals("m"))
                    graph.drive(spacing[2], spacing[3], 1, 2, numarNoduri);
                if (spacing[1].equals("a"))
                    graph.drive(spacing[2], spacing[3], 2, 4, numarNoduri);
                if (spacing[1].equals("c"))
                    graph.drive(spacing[2], spacing[3], 3, 6, numarNoduri);
            }

            if (spacing[0].equals("accident")) {
                int cost = Integer.parseInt(spacing[3]);
                graph.adaugareRestrictie(spacing[1], spacing[2], cost);
            }

            if (spacing[0].equals("blocaj")) {
                int cost = Integer.parseInt(spacing[3]);
                graph.adaugareRestrictie(spacing[1], spacing[2], cost);
            }
        }
    }
}