import com.oizovita.exeptions.MaxMinException;
import com.oizovita.transform.IntegerTransform;
import com.oizovita.transform.Transform;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TransformTest {
    private Transform transform;

    @Test
    public void testMinBiggerMax() {
        transform = new IntegerTransform();

        assertThrows(MaxMinException.class, () -> transform.range("100", "50", "1"));
    }
}
