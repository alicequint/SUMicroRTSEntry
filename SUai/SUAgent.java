package SUai;

import java.util.ArrayList;
import java.util.List;

import ai.core.AI;
import ai.core.ParameterSpecification;
import ai.mcts.mlps.MLPSMCTS;
import rts.GameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;

//TODO: complete this and add to list of possible agents
public class SUAgent extends AI {

	AI internalAgent;
	
	// TODO: Need a way to pass the map size in at construction
	public SUAgent(UnitTypeTable utt) {
		internalAgent = new MLPSMCTS(utt);
	}
	
	/**
	 * constructor for use in frontEnd
	 */
	public SUAgent(){
		UnitTypeTable utt = new UnitTypeTable();
		internalAgent = new MLPSMCTS(utt);
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlayerAction getAction(int player, GameState gs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AI clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParameterSpecification> getParameters() {
		List<ParameterSpecification> parameters = new ArrayList<>();
		parameters.add(new ParameterSpecification("Neural Network File Name",String.class,"RandomNetwork.xml"));
        parameters.add(new ParameterSpecification("map width",int.class,8));
        parameters.add(new ParameterSpecification("map height",int.class,8));
        
        return parameters;
	}

}
