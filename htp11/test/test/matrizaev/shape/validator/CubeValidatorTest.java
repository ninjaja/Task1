package test.matrizaev.shape.validator;

import com.matrizaev.shape.exception.CubeFilePathException;
import com.matrizaev.shape.exception.CubeValidationException;
import com.matrizaev.shape.reader.CubeReader;
import com.matrizaev.shape.validator.CubeValidator;
import org.testng.annotations.*;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeValidatorTest {
    CubeReader reader;
    CubeReader readerEmptyFile;
    CubeValidator validator;
    CubeValidator validatorEmptyData;
    List<String> listToValidate;
    List<String> listToValidateEmpty;

    @BeforeClass
    public void setUp() {
        reader = new CubeReader();
        readerEmptyFile = new CubeReader();
        validator = new CubeValidator();
        validatorEmptyData = new CubeValidator();
        listToValidate = reader.readCube();
        try {
            listToValidateEmpty = readerEmptyFile.readCube("./inputFiles/empty.txt");
        } catch (CubeFilePathException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown() {
        reader = null;
        readerEmptyFile = null;
        validator = null;
        validatorEmptyData = null;
        listToValidate = null;
        listToValidateEmpty = null;
    }

    @Test
    public void cubeValidateTest() {
        String expected = "[1.0 2.0 3.0 8.1, -3.2 4.8 5.1 12.3, 3.4 -5.1 2.8 3.7, -12.2 -6.2 -2.6 15.8]";
        String actual = null;
        try {
            actual = validator.cubeValidate(listToValidate).toString();
        } catch (CubeValidationException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = CubeValidationException.class)
    public void cubeValidateTestException() throws CubeValidationException {
        validatorEmptyData.cubeValidate(listToValidateEmpty);
    }
}
