public class Model {
    private int Score= 0;
    public Model(){

    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }
    public int Correct(){
        return getScore ()+100;
    }
    public int InCorrect(){
        if(Score <= 0 || Score <=100){
            return 0;
        }
        else {
            return  getScore ()-100;

        }

    }
}

