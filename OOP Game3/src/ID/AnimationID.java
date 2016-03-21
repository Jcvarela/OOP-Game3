package ID;

public class AnimationID implements ID{

	public enum ActionID {
		// (actionName where)
		Stand("stand"), Move("move"), Attack1("attack1"), Hit("hit");

		private String name;

		private ActionID(String name) {
			this.name = name.trim();
		}
		
		@Override
		public String toString() {
			return name;
		}
		
		public static ActionID getValue(String name){
			for(ActionID option: ActionID.values()){
				if(name.trim().equalsIgnoreCase(option.toString().trim())){
					return option;
				}
					
			}
			return null;
		}

	}

	public enum DirectionID {
		 Down("down"), Up("up"), Left("left"), Right("right");

		private String directionName;

		private DirectionID(String name) {
			this.directionName = name.trim();
		}
		@Override
		public String toString() {
			return directionName;
		}


		public static DirectionID getValue(String name){
			for(DirectionID option: DirectionID.values()){
				if(name.trim().equalsIgnoreCase(option.toString()))
					return option;
			}
			return null;
		}
	}
	
	public static int getID(DirectionID dID,ActionID aID){ return getID(aID, dID);}
	public static int getID(ActionID aID,DirectionID dID){
		if(aID == null || dID == null)
			return -1;
		
		return aID.ordinal()*dID.values().length + dID.ordinal();
	}

}