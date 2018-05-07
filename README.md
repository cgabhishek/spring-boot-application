# spring-boot-application
basic spring boot application 

Integration testing:-

Integration testing is nothing but running application through junits, in case of springboot application we have to run the application from junits, if our service having any rest endpoints we can test it by using int test, how it is working with tets cases.
same can be found here @AccountApplicationTest.java class.

ExecutorService executor = Executors.newCachedThreadPool();
Callable<Object> task = new Callable<Object>() {
   public Object call() {
      return something.blockingMethod();
   }
};
Future<Object> future = executor.submit(task);
try {
   Object result = future.get(5, TimeUnit.SECONDS); 
} catch (TimeoutException ex) {
   // handle the timeout
} catch (InterruptedException e) {
   // handle the interrupts
} catch (ExecutionException e) {
   // handle other exceptions
} finally {
   future.cancel(true); // may or may not desire this
}

