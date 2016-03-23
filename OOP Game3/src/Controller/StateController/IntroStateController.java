package Controller.StateController;

import Controller.ImputController.BasicInputController;
import Manager.GameStateManager;
import Model.Model;
import Model.StateModel.IntroStateModel;
import Model.StateModel.StateModel;
import View.View;
import View.StateViewport.IntroStateViewport;

public class IntroStateController extends StateController{
	
	private BasicInputController basicInputController;
	
	public IntroStateController(GameStateManager gsm, IntroStateModel model) {
		super(gsm, model, new IntroStateViewport(model));
		init();
	}
	
	@Override
	public void init() {
		basicInputController = new BasicInputController(model);
	}

	@Override
	public void update() {
		basicInputController.update();
		gsm.setState(getModel().nextState());
		getModel().update();
	}

	@Override
	protected IntroStateViewport getView() {
		return (IntroStateViewport)view;
	}

	@Override
	protected IntroStateModel getModel() {
		return (IntroStateModel)model;
	}

}
