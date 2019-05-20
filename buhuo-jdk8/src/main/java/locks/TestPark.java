package locks;

import java.util.concurrent.locks.LockSupport;

public class TestPark {
 public void testPark(){
  LockSupport.park();//(1)
 }
 public static void main(String[] args) {
  TestPark testPark = new TestPark();
  testPark.testPark();
 }
}
