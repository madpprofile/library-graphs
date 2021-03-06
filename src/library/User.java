package library;

import java.util.Scanner;

/**
 * The main class of the project, used only to call and test functions from
 * {@link library.LibraryGraphs}.
 */
public class User {
	public static void main(String[] args) {

		LibraryGraphs lib = new LibraryGraphs();
		Graph g = lib.readFileAsAdjacencyList(args[0]);
		String path, encoding;

		Scanner scan = new Scanner(System.in);
		System.out.println(" Welcome to library Graphs. What do you want to know? Enter the number of desired option");
		do {
			System.out.println("For:");
			System.out.println(" 1- Represent the graph in a matrix");
			System.out.println("2- Width search");
			System.out.println("3- Depth search");
			System.out.println("4- Analyse Connected Components of the Graph");
			System.out.println("5- Distance Between Vertices");
			System.out.println("6- Minimum Path");
			System.out.println("7- Minimum Spanning Tree");
			System.out.println("8- Average Distance");
			System.out.println("9- Generate file containing info");
			System.out.println("0- Exit the program");
			int resp = scan.nextInt(), a, b;
			scan.nextLine();

			switch (resp) {
			case 1:
				double[][] m = g.adjacencyMatrix();
				lib.printMatrix(m);
				break;

			case 2:
				System.out.println("Which vertice do you want to search? Enter the number");
				int nvert = scan.nextInt();
				scan.nextLine();
				Vertice s = new Vertice(nvert);
				LibraryGraphs.BFS(g, s);
				break;

			case 3:
				lib.DFS(g);
				break;

			case 4:
				try {
					g.analyseComponentesConex();
					break;
				} catch (NullPointerException e) {
					System.out.println("You must first search with Deepth Search, then analyse the components");
					break;
				}

			case 5:
				System.out.println("What is the value of the first Vertice?");
				a = scan.nextInt();
				scan.nextLine();
				System.out.println("What is the value of the second Vertice?");
				b = scan.nextInt();
				scan.nextLine();
				//Internally, the graph starts at 0, not 1.
				LibraryGraphs.distanceBetween(g, a-1, b-1);
				break;

			case 6:
				System.out.println("What is the value of the first Vertice?");
				a = scan.nextInt();
				scan.nextLine();
				System.out.println("What is the value of the second Vertice?");
				b = scan.nextInt();
				scan.nextLine();
				//Internally, the graph starts at 0, not 1.
				LibraryGraphs.distanceBetween(g, a-1, b-1);
				break;

			case 7:
				System.out.println("Which vertice would you like to take as root?");
				a = scan.nextInt();
				scan.nextLine();
				System.out.println("What is the output file path?");
				path = scan.nextLine();
				System.out.println("What file encoding would you like to use? (e.g. UTF-8)");
				encoding = scan.nextLine();
				Graph r = LibraryGraphs.dijkstra(g, a-1);
				r.createGraphFile(path, encoding);
				break;

			case 8:
				System.out.println("The average distance of this graph is " + g.averageDistance());
				break;

			case 9:
				System.out.println("Type the output file path:");
				path = scan.nextLine();
				System.out.println("Type the file encoding (e.g. UTF-8):");
				encoding = scan.nextLine();
				g.createInfoFile(path, encoding);
				break;

			case 0:
				scan.close();
				System.exit(0);

			default:
				System.out.println("Option not available. Enter one of the options below.");
				break;
			}

		} while (true);
	}
}
