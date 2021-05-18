package es.upm.grise;


public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(){
		this.firstThrow = 0;
		this.secondThrow = 0;
	}
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		//to be implemented
		return 0;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}

	public int getThrow1() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getThrow2() {
		// TODO Auto-generated method stub
		return 0;
	}

}
