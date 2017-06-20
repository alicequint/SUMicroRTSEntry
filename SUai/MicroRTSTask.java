package SUai;

import java.util.ArrayList;
import java.util.List;


import rts.PhysicalGameState;

/**
 * @author alicequint
 * evolves NNs for microRTS against opponents 
 * that are Not controlled by a NN.
 * @param <T> NN
 */
public class MicroRTSTask<T extends Network> implements HyperNEATTask { //extends NoisyLonerTask<T>
	
	NNEvaluationFunction<T> ef;
	//PhysicalGameState pgs = ef.getPhysicalGameState();
	
	@SuppressWarnings("unchecked")
	public MicroRTSTask() {}

	/**
	 * default behavior
	 */
	@Override
	public int numCPPNInputs() {
		return HyperNEATTask.DEFAULT_NUM_CPPN_INPUTS;
	}

	/**
	 * default behavior
	 */
	@Override
	public double[] filterCPPNInputs(double[] fullInputs) {
		return fullInputs;
	}

	/**
	 * Method that returns a list of information about the substrate layers
	 * contained in the network.
	 *
	 * @return List of Substrates in order from inputs to hidden to output
	 *         layers
	 */
	@Override
	public List<Substrate> getSubstrateInformation() {
		// TODO: Get actual height from game map somehow
		// In the meantime, hard code
		int height = 8; //pgs.getHeight();
		int width = 8; //pgs.getWidth();
		ArrayList<Substrate> subs = new ArrayList<Substrate>();
		
		Substrate inputsBoardState = new Substrate(new Pair<Integer, Integer>(width, height),
				Substrate.INPUT_SUBSTRATE, new Triple<Integer, Integer, Integer>(0, Substrate.INPUT_SUBSTRATE, 0), "Inputs Board State");
		subs.add(inputsBoardState);
		
		
		Substrate processing = new Substrate(new Pair<Integer, Integer>(width, height), 
				Substrate.PROCCESS_SUBSTRATE, new Triple<Integer, Integer, Integer>(0, Substrate.PROCCESS_SUBSTRATE, 0), "Processing");
		subs.add(processing);
		Substrate output = new Substrate(new Pair<Integer, Integer>(1,1),
				Substrate.OUTPUT_SUBSTRATE, new Triple<Integer, Integer, Integer>(0, Substrate.OUTPUT_SUBSTRATE, 0), "Output");
		subs.add(output);
		
		return subs;
	} 

	@Override
	public List<Pair<String, String>> getSubstrateConnectivity() {
		ArrayList<Pair<String, String>> conn = new ArrayList<Pair<String, String>>();
		
		conn.add(new Pair<String, String>("Inputs Board State", "Processing"));
		
		conn.add(new Pair<String, String>("Processing","Output"));
//		if(Parameters.parameters.booleanParameter("extraHNLinks")) {
//				conn.add(new Pair<String, String>("Inputs Board State","Output"));
//		}
		return conn;
	}

}
