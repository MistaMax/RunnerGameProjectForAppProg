package Model;

public class Score implements Comparable {
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

	@Override
	public int compareTo(Object arg){
		
		int score2 = ((Score) arg).getScore();
		String name2 = ((Score) arg).getName();
		
		if( score < score2){
			return 1;
		} else if(score > score2){
			return -1;
		} else {
			int i = name.compareTo(name2);
			if(i > 0){
				return -1;
			} else if(i < 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	

}
