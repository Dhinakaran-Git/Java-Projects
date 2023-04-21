package in.bassure.training.batch7.java.exceptions;

import java.util.EmptyStackException;

public class MultiCatch {

    public static void main(String[] args) {
        try{
            
        }catch(ClassCastException | NullPointerException ex){
            ex.printStackTrace();
        }catch(IllegalArgumentException | EmptyStackException iwex){
            
        }
        
        try {

        } catch (ClassCastException cce) {
            cce.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

}
