package q10;
import q10.Process;

public class MainQ10 {
    
    private static final int[] INPUTS = new int[]{189,1,111,246,254,2,0,120,215,93,255,50,84,15,94,62};
    private static final int[] TEST_INPUTS = new int[]{5};

    public static void main(String[] args) {
        Process p = new Process(TEST_INPUTS, 5);
        //Process p = new Process(INPUTS);
        
        p.run();
    }
}