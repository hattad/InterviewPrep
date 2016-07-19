import java.util.InputMismatchException;
import java.util.Scanner;


public class GraphMatrix {

    private java.util.Queue<Integer> queue;
    
    private java.util.Stack<Integer> stack;
 
    public GraphMatrix()
    {
        queue = new java.util.LinkedList<Integer>();
        stack = new java.util.Stack<Integer>();
    }
    
    public void dfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
 
        int visited[] = new int[number_of_nodes + 1];		
        int element = source;		
        int i = source;		
        System.out.print(element + "\t");		
        visited[source] = 1;		
        stack.push(source);
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element;	
	    while (i <= number_of_nodes)
	    {
     	        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
	        {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    System.out.print(element + "\t");
	            continue;
                }
                i++;
	    }
            stack.pop();	
        }	
    }
 
    public void bfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
 
        int[] visited = new int[number_of_nodes + 1];
        int i, element;
 
        visited[source] = 1;
        queue.add(source);
 
        while (!queue.isEmpty())
        {
            element = queue.remove();
            i = element;
            System.out.print(i + "\t");
            while (i <= number_of_nodes)
            {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                    queue.add(i);
                    visited[i] = 1;
                }
                i++;
            }
        }
    }
 
    public static void main(String... arg)
    {
        int number_no_nodes, source;
        Scanner scanner = null;
 
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_no_nodes = scanner.nextInt();
 
            int adjacency_matrix[][] = new int[number_no_nodes + 1][number_no_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_no_nodes; i++)
                for (int j = 1; j <= number_no_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();
 
            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();
 
            System.out.println("The BFS traversal of the graph is ");
            GraphMatrix graph = new GraphMatrix();
            graph.bfs(adjacency_matrix, source);
            graph.dfs(adjacency_matrix, source);
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scanner.close();
    }
}
