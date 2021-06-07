package com.oracle.api.beans;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class datacheck {
  
  protected datacheck() {
    
  }
 public static final int a;
  String b;
  public final int c=20;
 // datacheck dp = new datacheck();
  
   void pleasecheck() {
   datacheck dp = new datacheck();
   // a=20;
    //c=20;
    System.out.println(dp.c);
    setup();
  }
  static {
    a=10;
   // c=20;
  }
  
  public static void setup() {
    
  }
}
