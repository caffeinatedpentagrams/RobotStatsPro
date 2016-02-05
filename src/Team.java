import java.util.ArrayList;
public class Team {
	public String teamTag;
	//the following list of attributes are integers recording instances of game actions
	//the suffix TO means TeleOp, AUTO is autonomous
	public int defensesReached_AUTO = 0; //reaching a defense in autonomous
	public int totalDefensesCrossed = 0;
	public int crossPort_TO = 0;
	public int crossRT_TO = 0; //rough terrain
	public int crossRW_TO = 0; //"rock" wall
	public int crossMoat_TO = 0;
	public int crossRamparts_TO = 0;
	public int crossSP_TO = 0; //sally port
	public int crossDB_TO = 0; //drawbridge
	public int crossCDF_TO = 0; //Chival de Frise
	public int crossLB_TO = 0; //lowbar
	public int crossPort_AUTO = 0;
	public int crossRT_AUTO = 0; //rough terrain
	public int crossRW_AUTO = 0; //"rock" wall
	public int crossMoat_AUTO = 0;
	public int crossRamparts_AUTO = 0;
	public int crossSP_AUTO = 0; //sally port
	public int crossDB_AUTO = 0; //drawbridge
	public int crossCDF_AUTO = 0; //Chival de Frise
	public int crossLB_AUTO = 0; //lowbar
	public int bouldersIntaked_AUTO = 0;
	public int bouldersIntaked_TO = 0;
	//-------------------------------------
	public int lowGoalsAttempted_TO = 0;
	public int lowGoalsScored_TO = 0;
	public int lowGoalsAttempted_AUTO = 0;
	public int lowGoalsScored_AUTO = 0;
	public int highGoalsAttempted_TO = 0;
	public int highGoalsScored_TO = 0;
	public int highGoalsAttempted_AUTO = 0;
	public int highGoalsScored_AUTO = 0;
	//-------------------------------------
	public int timesHung = 0;
	public int timesChallenged = 0;
	public int timesMidStart = 0;
	public int timesSpyStart = 0;
	public int collectiveAllianceScore = 0;
	public int collectiveTeamScore = 0;
	public int timesDOA = 0; //DOA = dead on arrival
	public int timesKilled = 0; //dead during round
	public int timesBreached = 0;
	public int timesCaptured = 0;
	public int totalRP = 0; //total ranking points
	public int compAttended = 0; //number of competitions attended
	public int matchesPlayed = 0;
	public int matchesWon = 0;
	//the following is a list of attributes pertaining to robot design in terms of capability
	//the following is a list of attributes pertaining to robot design in terms of mechanism
	//the following is a list of utility arrays
	public int[] pActions_TO = {totalDefensesCrossed, highGoalsScored_TO, crossPort_TO,
			crossRT_TO, crossMoat_TO, crossRamparts_TO, crossSP_TO, crossDB_TO,
			crossCDF_TO, crossLB_TO, bouldersIntaked_TO, lowGoalsScored_TO, timesHung,
			timesChallenged};//list of actions in TeleOp which score points, in addition to total
	public ArrayList<String> tags = new ArrayList<String>(); //stores team #s of teams this team has
	//played against
	public ArrayList<Integer> instances = new ArrayList<Integer>();
	//scores instances of tags above
	public ArrayList<Integer> winsAgainst = new ArrayList<Integer>();
	//records wins against above teams
	//crossed defenses
	public int[] pActions_AUTO = {crossPort_AUTO, crossRT_AUTO, crossMoat_AUTO,
			crossRamparts_AUTO, crossSP_AUTO, crossDB_AUTO, crossCDF_AUTO, crossLB_AUTO,
			bouldersIntaked_AUTO, lowGoalsScored_AUTO, highGoalsScored_AUTO,
			defensesReached_AUTO}; //list of possible actions in Autonomous
	public int[] defensesCrossedTotal = {crossPort_TO+crossPort_AUTO,
			crossRT_TO+crossRT_AUTO, crossMoat_TO+crossMoat_AUTO,
			crossRamparts_TO+crossRamparts_AUTO, crossSP_TO+crossSP_AUTO, crossDB_TO+crossDB_AUTO,
			crossCDF_TO+crossCDF_AUTO, crossLB_TO+crossLB_AUTO, crossRW_TO+crossRW_AUTO};

	public Team(){
		calcTotalTS();
	}
	//to do: per match data, ranking points/playoff data
	public int calcAssistAuto(){ //calculates autonomous total score
		int rollingSum = 0;
		int[] defenses = {crossPort_AUTO, crossRT_AUTO, crossMoat_AUTO,
				crossRamparts_AUTO, crossSP_AUTO, crossDB_AUTO, crossCDF_AUTO, crossLB_AUTO};
		for (int i : defenses){
			rollingSum+= i*10;
		}
		rollingSum+= highGoalsScored_AUTO*10;
		rollingSum+= lowGoalsScored_AUTO*5;
		rollingSum+= defensesReached_AUTO*2;
		return rollingSum;
	}

	public int calcAssistTeleOp(){//calculates TeleOp total score
		int rollingSum = 0;
		int[] defenses = {crossPort_TO, crossRT_TO, crossMoat_TO,
				crossRamparts_TO, crossSP_TO, crossDB_TO, crossCDF_TO, crossLB_TO};
		for (int i : defenses){
			rollingSum+= i*5;
		}
		rollingSum+= highGoalsScored_TO*5;
		rollingSum+= lowGoalsScored_TO*2;
		rollingSum+= timesHung*15 + timesChallenged*5;
		return rollingSum;
	}
	public void calcTotalTS(){//calculate total team score
		collectiveTeamScore = calcAssistAuto() + calcAssistTeleOp();
	}
	
	public String toString(){
		System.out.println(compAttended);
		System.out.println(matchesWon);
		return "";
	}
}
