import java.util.Random;
public class Individual {
	

    static int defaultGeneLength = 8;
    private int[] genes = new int[defaultGeneLength];
    // Cache
    private int fitness = 0;
    Random rand = new Random();
    // Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
        	int gene =  Math.abs((rand.nextInt()%8));
            System.out.print(gene+" ");
            genes[i] = gene;
        }
        System.out.println();
    }
     Individual()
     {
    	 for(int i = 0 ; i<8;i++)
 		{
    		 genes[i]=-1;
 		}
     }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    
    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int i) {
        genes[index] = i;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        
        return geneString;
    }
}