import java.io.*;
import java.util.*;
public class ConfigReader {
	public void read(Team t){
		// The name of the file to open.
		String fileName = "config.txt";
		HashMap<String, String> mainHM = new HashMap<String, String>();
		// This will reference one line at a time
		String line = null;
		String[] splitInput = {};
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);
				splitInput = line.split("=");
				if(splitInput.length == 2)
					mainHM.put(splitInput[0], splitInput[1]);
				//System.out.printf("t.%s += Integer.parseInt(mainHM.get(\"%s\"));\n", splitInput[0], splitInput[0]);
			}   
			/*System.out.println(mainHM.get("matchesPlayed"));
			System.out.println(mainHM.get("matchesWon"));
			t.matchesPlayed += Integer.parseInt(mainHM.get("matchesPlayed"));
			System.out.println(t.matchesPlayed);*/
			t.defensesReached_AUTO += Integer.parseInt(mainHM.get("defensesReached_AUTO"));
			t.totalDefensesCrossed += Integer.parseInt(mainHM.get("totalDefensesCrossed"));
			t.crossPort_TO += Integer.parseInt(mainHM.get("crossPort_TO"));
			t.crossRT_TO += Integer.parseInt(mainHM.get("crossRT_TO"));
			t.crossRW_TO += Integer.parseInt(mainHM.get("crossRW_TO"));
			t.crossMoat_TO += Integer.parseInt(mainHM.get("crossMoat_TO"));
			t.crossRamparts_TO += Integer.parseInt(mainHM.get("crossRamparts_TO"));
			t.crossSP_TO += Integer.parseInt(mainHM.get("crossSP_TO"));
			t.crossDB_TO += Integer.parseInt(mainHM.get("crossDB_TO"));
			t.crossCDF_TO += Integer.parseInt(mainHM.get("crossCDF_TO"));
			t.crossLB_TO += Integer.parseInt(mainHM.get("crossLB_TO"));
			t.crossPort_AUTO += Integer.parseInt(mainHM.get("crossPort_AUTO"));
			t.crossRT_AUTO += Integer.parseInt(mainHM.get("crossRT_AUTO"));
			t.crossRW_AUTO += Integer.parseInt(mainHM.get("crossRW_AUTO"));
			t.crossMoat_AUTO += Integer.parseInt(mainHM.get("crossMoat_AUTO"));
			t.crossRamparts_AUTO += Integer.parseInt(mainHM.get("crossRamparts_AUTO"));
			t.crossSP_AUTO += Integer.parseInt(mainHM.get("crossSP_AUTO"));
			t.crossDB_AUTO += Integer.parseInt(mainHM.get("crossDB_AUTO"));
			t.crossCDF_AUTO += Integer.parseInt(mainHM.get("crossCDF_AUTO"));
			t.crossLB_AUTO += Integer.parseInt(mainHM.get("crossLB_AUTO"));
			t.bouldersIntaked_AUTO += Integer.parseInt(mainHM.get("bouldersIntaked_AUTO"));
			t.bouldersIntaked_TO += Integer.parseInt(mainHM.get("bouldersIntaked_TO"));
			t.lowGoalsAttempted_TO += Integer.parseInt(mainHM.get("lowGoalsAttempted_TO"));
			t.lowGoalsScored_TO += Integer.parseInt(mainHM.get("lowGoalsScored_TO"));
			t.lowGoalsAttempted_AUTO += Integer.parseInt(mainHM.get("lowGoalsAttempted_AUTO"));
			t.lowGoalsScored_AUTO += Integer.parseInt(mainHM.get("lowGoalsScored_AUTO"));
			t.highGoalsAttempted_TO += Integer.parseInt(mainHM.get("highGoalsAttempted_TO"));
			t.highGoalsScored_TO += Integer.parseInt(mainHM.get("highGoalsScored_TO"));
			t.highGoalsAttempted_AUTO += Integer.parseInt(mainHM.get("highGoalsAttempted_AUTO"));
			t.highGoalsScored_AUTO += Integer.parseInt(mainHM.get("highGoalsScored_AUTO"));
			t.timesHung += Integer.parseInt(mainHM.get("timesHung"));
			t.timesChallenged += Integer.parseInt(mainHM.get("timesChallenged"));
			t.timesMidStart += Integer.parseInt(mainHM.get("timesMidStart"));
			t.timesSpyStart += Integer.parseInt(mainHM.get("timesSpyStart"));
			t.collectiveAllianceScore += Integer.parseInt(mainHM.get("collectiveAllianceScore"));
			t.collectiveTeamScore += Integer.parseInt(mainHM.get("collectiveTeamScore"));
			t.timesDOA += Integer.parseInt(mainHM.get("timesDOA"));
			t.timesKilled += Integer.parseInt(mainHM.get("timesKilled"));
			t.timesBreached += Integer.parseInt(mainHM.get("timesBreached"));
			t.timesCaptured += Integer.parseInt(mainHM.get("timesCaptured"));
			t.totalRP += Integer.parseInt(mainHM.get("totalRP"));
			t.compAttended += Integer.parseInt(mainHM.get("compAttended"));
			t.matchesPlayed += Integer.parseInt(mainHM.get("matchesPlayed"));
			t.matchesWon += Integer.parseInt(mainHM.get("matchesWon"));
			// Always close files.
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                  
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}
}
