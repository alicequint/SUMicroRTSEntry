package SUai;

import ai.evaluation.EvaluationFunction;
import rts.GameState;
import rts.PhysicalGameState;

/**
 * 
 * @author alicequint
 *
 * @param NN
 */
public abstract class NNEvaluationFunction<T extends Network> extends EvaluationFunction{

	protected Network nn;
	protected PhysicalGameState pgs;
	
	public NNEvaluationFunction(){
	}
	
	public void setNetwork(Genotype<T> g) {
		nn = g.getPhenotype();
	}
	
	/**
	 *  creates the array to be given to the NN
	 */
	protected abstract double[] gameStateToArray(GameState gs);
	
	/**
	 * 
	 * @return labels of sensors given to nn
	 */
	public abstract String[] sensorLabels();
	
	/**
	 * maximum possible thing returned by the evaluation function
	 */
	@Override
	public float upperBound(GameState gs) {
		return 1;
	}
	
	public void givePhysicalGameState(PhysicalGameState pgs) {
		this.pgs = pgs;
	}
	
	//used in (this) microRTSTask 
	public PhysicalGameState getPhysicalGameState(){
		return pgs;
	}
}
