package ThreadDemo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class RequestIDGenerator implements CircularSeqGenerator {
    /*
    * Save the unique instance of this class
     */
    private final static RequestIDGenerator INSTANCE = new RequestIDGenerator();
    private final static short SEQ_UPPER_LIMIT = 999;
    private short sequence = -1;

    // private constructor, do nothing
    private RequestIDGenerator() {

    }
/*
* @description: Generate recycle increase number
* @return
*/
    @Override
    public short nextSequence(){
        if(sequence >= SEQ_UPPER_LIMIT) {
            sequence = 0;
        } else {
            sequence++;
        }
        return  sequence;
    }

    /*
    * @description: Generate a new ID
    * @return
    */
    public String nextID() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");
        //Generate request sequence number
        short sequenceNo = nextSequence();
        return "0049" + timestamp + df.format(sequenceNo);
    }

    /*
    * @description: Return the unique instance of this class
    * @return
    */
    public static RequestIDGenerator getInstance() {
        return INSTANCE;
    }
}
