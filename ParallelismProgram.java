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
            System.out.println("Tarefa " + taskId + " está sendo executada no thread " + Thread.currentThread().getName());
        }
    }
}
