import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GA {
	static Scanner scanner;
	static Population myPop;
	static Algorithm algorithm;
    public static void main(String[] args) {

        // Set a candidate solution
        //FitnessCalc.setSolution("12345678");
    	
		try {
			scanner = new Scanner(new File("E:\\4.1\\AI Lab\\Week1\\Genetic Algorith Assignment\\src\\input"));
			// Create an initial population
	        myPop = new Population(scanner.nextInt(), true);
	        algorithm = new Algorithm(scanner.nextDouble(), scanner.nextDouble());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
        
        for(int i = 0; i < myPop.size(); i++)
        {
        	if(myPop.individuals[i].getFitness()==myPop.getFittest().getFitness())
        		System.out.println(myPop.individuals[i]+" "+myPop.individuals[i].getFitness());
        }
        System.out.println(myPop.size());

    }
}