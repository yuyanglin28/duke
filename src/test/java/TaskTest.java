import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void testTransferState(){
        Task tester = new Task("test");
        assertEquals(0, tester.getStatus(), "a newly created task should be undo, 0");

        tester.changeStatusIcon();
        assertEquals(1, tester.getStatus(), "after call changeStatusIcon() task should be done, 1");
    }
}
