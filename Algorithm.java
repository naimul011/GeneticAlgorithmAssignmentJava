import java.util.Random;

public class Algorithm {

    /* GA parameters */
    private  double uniformRate ;
    private  double mutationRate;
    
    private  final int tournamentSize = 5;
    private  final boolean elitism = true;

    /* Public methods */
    private  Random rand = new Random();
    
    public Algorithm(double uniformRate,double mutationRate)
    {
    	this.uniformRate = uniformRate;
    	this.mutationRate = mutationRate;
    }
    // Evolve a population
    public  Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // Keep our best individual
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = rouletteWheelSelection(pop);
            Individual indiv2 = rouletteWheelSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
          
        }

        return newPopulation;
    }

    // Davis Order Crossover
    private  Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        
        if(Math.random()<=uniformRate)
        {
        int i,j,c=0;
        int r1 = Math.abs(rand.nextInt()%(8));
		int r2 = Math.abs(rand.nextInt()%(8));
		while(r1 >= r2) {r1 = Math.abs(rand.nextInt()%(8)); r2 = Math.abs(rand.nextInt()%(8));}
		
		for(i = r1 ; i<=r2;i++)
		{
			newSol.setGene(i, indiv1.getGene(i));
		}
		
		while(c<7)
		{
			if(i==8)
			i=0;
			boolean chk=true;
			for(j = r1 ; j<=r2;j++)
			{
				if(newSol.getGene(j)==indiv2.getGene(i))
					{chk=false;break;}
			}
			if(chk)
				newSol.setGene(i,indiv2.getGene(i));
			i++;
			c++;
		}
		for(i = 0 ; i<8;i++)
		{
			if(newSol.getGene(i) == -1)
				newSol.setGene(i,indiv2.getGene(i));
		}
        }
        else
        {
        	for(int i = 0 ; i<8;i++)
    		{
    			if(newSol.getGene(i) == -1)
    				newSol.setGene(i,indiv2.getGene(i));
    		}
        }
        return newSol;
    }

  
    // Mutate an individual
    private  void mutate(Individual indiv) {    
            if (Math.random() <= mutationRate) {
            	scrambleMutation(indiv);
            }
            Random rand = new Random();
            for (int i = 0; i < indiv.size(); i++) {
            	if (Math.random() <= mutationRate) {
            	// Create random gene
            	int gene = (int) Math.abs(rand.nextInt()%8);
            	indiv.setGene(i, gene);
            	}
            }
        
    }
    
    
    ///SCRAMBLING MUTATION!!!
    public  void scrambleMutation(Individual indiv){
		
		int l = indiv.size();
			int r1 = Math.abs(rand.nextInt()%(l));
			int r2 = Math.abs(rand.nextInt()%(l));
			//to make sure the r1 < r2
			while(r1 >= r2) {r1 = Math.abs(rand.nextInt()%(l)); r2 = Math.abs(rand.nextInt()%(l));}
			//this code scrambles (i.e. randomises) elements between r1..r2
			for(int i = 0; i < 8; i++){
				int i1 = r1+ (int)(Math.random() * ((r2 - r1) + 1));// add 1 to include actual value of r2
				int i2 = r1+ (int)(Math.random() * ((r2 - r1) + 1));
				int a = indiv.getGene(i1);
				indiv.setGene(i1,indiv.getGene(i2));
				indiv.setGene(i2,a);
			 
		}
		return ;
	}
    

    // Select individuals for crossover
private  Individual rouletteWheelSelection(Population pop) {
        
        double weightSum = 0;
        
        for(int i = 0; i< pop.size(); i++)
        {
        	weightSum += pop.individuals[i].getFitness();
        }
        
        
        double value = randUniformPositive() * weightSum;
        
        for(int i = 0; i < pop.size(); i++)
        {
        	value -= pop.individuals[i].getFitness();
        	if(value <= 0)
        		return pop.individuals[i];
        }
        
        return pop.individuals[pop.size()-1];
    }
 double randUniformPositive() {
	// easiest implementation
	return new Random().nextDouble();
}

public  void setMutationRate(double mutationRate)
{
	this.mutationRate = mutationRate;
}
}