package by.ruslan.radzevich.task9;

import java.util.Objects;
import java.util.Optional;

public class ExceptionExample {

    public static class GenericEx extends RuntimeException{
        private Object info;

        public GenericEx (String message, Object info){
            super(message);
            this.info = info;
        }
    }
//
//    public static void main(String[] args) {
//        try{
//            doLogic();
//        } catch (Exception unespective){
//            handleUnexpectedExeception(unespective);
//        }catch (GenericEx  genericEx){
//            handleGenerickExeception(genericEx);
//        }
//    }

    static Optional<byte[]> bytes (int size){
        try{
            return Optional.of(new byte[size]);
        }catch (OutOfMemoryError error){
            error.printStackTrace();
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        if(bytes(Integer.MAX_VALUE).isPresent()){
            System.out.println("www");
        }else {
            System.out.println("wwwww");
        }
    }
}
