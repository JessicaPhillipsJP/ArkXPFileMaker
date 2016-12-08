package writeengram;

public class WriteOut {
	
	
	public void xpOverride(){
		System.out.println("[/script/shootergame.shootergamemode]");
		System.out.print("LevelExperienceRampOverrides=(");
		for(int i = 0; i<501; i++){
			if(i == 0){
				System.out.print("ExperiencePointsForLevel["+i+"]="+2+",");
			}
			else if( i <500){
			System.out.print("ExperiencePointsForLevel["+i+"]="+i*5+",");
			}
			else{
				System.out.print("ExperiencePointsForLevel["+i+"]="+i*5+")");
			}
			
		}
	}
	public void engramOverride(){
		for(int i = 0; i<501; i++){
			System.out.println("OverridePlayerLevelEngramPoints="+ i*10);
		}
		
	}
//	public static void main(String[] args){
//		WriteOut out = new WriteOut();
//		out.xpOverride();
//		out.engramOverride();
//	}

}
