package com.single;

public class SingleTonTest {
    private static final SingleTonTest s= new SingleTonTest();
   private SingleTonTest(){

   };
   public static SingleTonTest getResult(){
       return s;
   }

}
