package Model.StateModel;

import Model.Model;

import javax.swing.plaf.nimbus.State;

/**
 * Created by jcvarela on 3/17/2016.
 */
public interface StateModel extends Model{
	
	//return -1 if is false
	public abstract int nextState();
}
