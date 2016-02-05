//filter for sample size
//what they suck at
//attempts at shooting
import java.util.ArrayList;
public class TeamAnalysis extends Analyzer {
	public TeamAnalysis(Team t){
		//same as match but for team
		calculateWinrate(t.matchesWon, t.matchesPlayed);
	}
	public double calculateWinrate(int x, int y){//where x is matches won and y is matches played
		return (double)x/(double)y;
	}
	//need to find a way to get a list of teams 1 team has played against
	public String[] bestWorstVersusTeam(ArrayList<String> x, ArrayList<Integer> y, ArrayList<Integer> z){
		ArrayList<String> tags = x; //copy so no modification
		ArrayList<Integer> instances = y;
		ArrayList<Integer> winsAgainst = z; //sort all greatest to least, change string least
		ArrayList<Double> winRateVs = new ArrayList<Double>();
		//and instances list as according to wins against percentage
		for (int i=0; i<winsAgainst.size();i++){
			winRateVs.set(i, ((double)winsAgainst.get(i))/((double)instances.get(i)));
		}
		int l = winRateVs.size();
		for(int j=1;j<l;j++){
			double key = winRateVs.get(j);
			String key1 = tags.get(j);
			int key2 = instances.get(j);
			int i = j-1;
			while ((i>-1)&&(winRateVs.get(i)<key)){
				winRateVs.set(i+1, winRateVs.get(i));
				tags.set(i+1, tags.get(i));
				instances.set(i+1, instances.get(i));
				i--;
			}//needs filtering
			winRateVs.set(i+1, key);
			tags.set(i+1, key1);
			instances.set(i+1, key2);
		}
		return new String[] {tags.get(0), tags.get(tags.size()-1)};//as according to percentage
	}

	public String[] bestVersusDefenses(int[] x){
		//take most crossed compared to least crossed
		//refine sorting pls
		String[] tag = {"Portcullis", "Rough Terrain", "Moat", "Ramparts", "Sally Port", 
				"Draw Bridge", "Chival de Frise", "Lowbar", "'Rock Wall'"};
		int hold;
		String holdS;
		for(int i=0; i<x.length; i++){
			for(int c=0; c<x.length; c++){
				if(x[c]<x[c+1]){
					holdS = tag[c];
					hold = x[c];
					tag[c] = tag[c+1];
					x[c] = x[c+1];
					tag[c+1] = holdS;
					x[c+1] = hold;
				}
			}
		}
		return tag;
	}

	public String[] topActionsTO(int x[]){
		//take top action, and also return everything within 30% instances of top action
		//in TeleOP
		//will need testing, adjusting, and exceptions.
		String [] tag = {"Cross Defenses", "High Goal", "Intake Boulders", "Low Goal",
				"Hang", "Challenge"};
		String holdS;
		int hold;
		for(int i=0; i<x.length; i++){
			for (int c=0; c<x.length; c++){
				hold = x[c];
				holdS = tag[c];
				x[c] = x[c+1];
				tag[c] = tag[c+1];
				x[c+1] = hold;
				tag[c+1] = holdS;
			}
		}
		return tag;
	}

	public int[] mostPickedDefensesNum(int[] dcross){
		//returns most picked defenses by flat #
		//add tags
		int[] x = dcross;//copy by value
		int l = x.length;
		for (int j=1;j<l;j++){
			int key = x[j];
			int i = j - 1;
			while ((i>-1)&&(x[i]<key)){
				x[i+1] = x[i];
				i--;
			}
			x[i+1] = key;
		}
		return x;
	}
	public double[] mostPickedDefenses(int[] dcross){
		//returns the most picked defenses by percentage
		//need to add tag swaps here too to match end results
		int[] x = dcross;
		int l = x.length;
		double[] p = new double[l];
		int sum = 0;
		for(int i=0;i<l;i++){
			sum+=x[i];
		}
		for(int i=0;i<l;i++){
			p[i] = ((double)x[i])/((double)sum);
		}
		for (int j=1;j<l;j++){
			double key = p[j];
			int i = j - 1;
			while ((i>-1)&&(p[i]<key)){
				p[i+1] = p[i];
				i--;
			}
			p[i+1] = key;
		}//should return a string end result, add later
		return p;
	}

	public double highGoalRate(int x, int y){//returns high goal success rate
		return (double)x/(double)y;
	}

	public double lowGoalRate(int x, int y){//returns low goal success rate
		return (double)(x)/(double)y;
	}

	public int avgScrMatch(){//returns the average score per match
		return 0;
	}

	public int [] getMatchesIn(){//returns matches participated in
		return (new int[]{});
	}
}
