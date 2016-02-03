
public abstract class Analyzer {
	public Analyzer(){
		
	}
	
	public double[] usageDefenses(int[] defenses){//calculates the usage of defenses in proportion to total crossed
		int total = 0;
		double[] x = new double[defenses.length];
		for(int i=0; i<defenses.length; i++){
			total += defenses[i];
		}
		for(int i=0; i<defenses.length; i++){
			x[i] = ((double)defenses[i]) / ((double)total);
		}
		return x;
	}
	
	public int[] avgActions(int[] actions, int matchesPlayed){//finds the average instances of every action taken per game
		int[] arr = new int[actions.length];
		for(int i=0; i<actions.length; i++){
			arr[i] = actions[i] / matchesPlayed;
		}
		return arr;
	}
	public double standardDevActions(int[] actions, int matchesPlayed){//maybe will work, returns the standard distribution of actions
		int sum = 0;
		int counter = 0;
		for (int x:actions){
			for (int y=0; y<x; y++){
				sum+=(x-avgActions(actions, matchesPlayed)[counter])^2;
			}
			counter++;
		}
		return (1/counter)*java.lang.Math.sqrt(sum);
	}
}
