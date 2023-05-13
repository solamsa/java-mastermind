package za.co.wethinkcode.mastermind;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.mockito.Mockito;
//import java.util.
public class CodeGeneratorTest {

    @Test
    public void is4digitCode() {
        CodeGenerator codeGenerator = new CodeGenerator();
        assertEquals(4, (codeGenerator.generateCode()).length());
    }
    @Test
    void testGenerateCode() {
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt()))
                .thenReturn(0, 1, 2, 3);
        CodeGenerator generator = new CodeGenerator(randomNumberMock);
        assertEquals("1234", generator.generateCode());
    }
    @Test
    void testValidCode() {
        CodeGenerator generator = new CodeGenerator();
        char one = Integer.toString(1).charAt(0);
        char eight = Integer.toString(8).charAt(0);
        for(int i = 0; i < 100; i++){
            String code = generator.generateCode();
            code.chars().forEach(digit -> {
                assertTrue(digit >= one && digit <= eight);
            });
        }
    }
}
