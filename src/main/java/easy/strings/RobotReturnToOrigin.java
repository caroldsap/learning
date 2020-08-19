package easy.strings;

public class RobotReturnToOrigin {

    public static void main (String args[]){

    }
    public boolean judgeCircle(String moves) {
        int result = 0;
        for(char c: moves.toCharArray()){
            result =  result + value(c);
        }
        if(result==0) return true;
        return false;
    }
    int value(char r)
    {
        if (r == 'L' )
            return 1;
        if (r == 'R')
            return -1;
        if (r == 'U')
            return 2;
        if (r == 'D')
            return -2;

        return -1;
    }
}
