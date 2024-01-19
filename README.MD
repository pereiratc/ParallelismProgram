import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismProgram {
    public static void main(String[] args) {
        // cria um pool de 5 threads fixos
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // envia 10 tarefas para serem executadas simultaneamente
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i));
        }

        // Shutdown o executor
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
        }
    }
}
This program demonstrates parallelism in Java using a fixed thread pool. It creates a pool of 5 threads and submits 10 tasks to be executed concurrently. Each task is represented by the Task class, which implements the Runnable interface. The run method of each task prints a message indicating the task ID and the thread it is running on.
To achieve parallelism, we use the ExecutorService interface and the Executors.newFixedThreadPool method to create a fixed thread pool. The submit method of the executor is used to submit tasks for execution. Finally, we call the shutdown method to gracefully shut down the executor after all tasks have completed.
By utilizing parallelism, we can improve the performance of our programs by executing multiple tasks concurrently, taking advantage of the available processing power of the system.
Note: It's important to handle synchronization and thread safety when working with parallelism to avoid race conditions and other concurrency issues.
