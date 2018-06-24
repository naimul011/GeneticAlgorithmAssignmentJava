public class FitnessCalc {

    static int[] solution = new int[8];

    /* Public methods */
    // Set a candidate solution as a byte array
    public static void setSolution(int[] newSolution) {
        solution = newSolution;
    }

    // To make it easier we can use this method to set our candidate solution 
    // with string of 0s and 1s
    //I DONT NEED THIS METHOD
    static void setSolution(String newSolution) {
        solution = new int[newSolution.length()];
        // Loop through each character of our string and save it in our byte 
        // array
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static int getFitness(Individual individual) {
        int fitness = 28;
        int attackingPair=0;
      ///For Rook
    	/*
        for(int i = 0 ;i <8;i++)
        {
        	
        	  int chk= individual.getGene(i);
        	for(int j = 0 ;j <8;j++)
        	{
        		
        		int chk2 =individual.getGene(j);
        		if(i!=j)
        		{
        			if(chk==chk2)
        				attackingPair++;
        		}
        	}
        }
        */
        
        ///FOR QUEEN
        for(int i = 0 ;i <8;i++)
        {
        	
        	  int chk= individual.getGene(i);
        	for(int j = 0 ;j <8;j++)
        	{
        		
        		int chk2 =individual.getGene(j);
        		if(i!=j)
        		{
        			if(chk==chk2||Math.abs(chk-chk2) == Math.abs(i-j))
        				attackingPair++;
        		}
        		
        	}
        }
        
        fitness= fitness-attackingPair;
       
        return fitness;
    }
    
    // Get optimum fitness
    static int getMaxFitness() {
        int maxFitness = 28;
        return maxFitness;
    }
}
    