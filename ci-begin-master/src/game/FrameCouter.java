package game;

public class FrameCouter {
    int count;
    int countMax;

    public FrameCouter(int countMax){
        this.countMax = countMax;
        this.count = 0;
    }

    public boolean run(){
        if (this.count >= this.countMax) {
            return true;
        }
        count ++;
        return false;
    }

    public void reset(){
        this.count = 0;
    }
}
