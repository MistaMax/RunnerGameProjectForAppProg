package Model;

public class Score {
	private int score;
	private String name;
	
	public Score(){
		this.score = 0;
	}
	
	public int getScore(){
		return score;
	}
	public void setScore(int nScore){
		this.score = nScore;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
