package test.matrizaev.shape.action;

import com.matrizaev.shape.entity.Cube;
import static com.matrizaev.shape.action.ActionCube.*;
import com.matrizaev.shape.entity.CenterPoint;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class ActionCubeTest {
    CenterPoint center;
    CenterPoint center1;
    Cube cube1;
    Cube cube2;
    Cube cube3;
    @BeforeClass
    public void setUp() {
        center = new CenterPoint(1.0, 2.0, -1.0);
        center1 = new CenterPoint(-2.0, -2.0, -2.0);
        cube1 = new Cube(center, 4.0);
        cube2 = new Cube(center, 3.0); // tangent to NONE of the planes
        cube3 = new Cube(center1, 4.0); // tangent to ALL of the planes
    }

    @AfterClass
    public void tearDown() {
        center = null;
        center1 = null;
        cube1 = null;
        cube2 = null;
        cube3 = null;
    }

    @Test
    public void calcCubeSurfAreaTest() {
        double expected = 96.0;
        double actual = calcCubeSurfArea(cube1);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calcCubeVolTest() {
        double expected = 64;
        double actual = calcCubeVol(cube1);
    }

    @Test
    public void calcProportionXYTest() {
        String expected = "0.75/0.25";
        String actual = calcProportionXY(cube1);
        assertEquals(expected, actual);
    }

    @Test
    public void calcProportionXZTest() {
        String expected = "The cube has no crossings with XZ-plane";
        String actual = calcProportionXZ(cube1);
        assertEquals(expected, actual);
    }

    @Test
    public void calcProportionYZTest() {
        String expected = "0.75/0.25";
        String actual = calcProportionYZ(cube1);
        assertEquals(expected, actual);
    }

    @Test
    public void tangencyToPlanesTestXZ() {
        String expected = "The cube is tangent to plane(s): XZ ";
        String actual = tangencyToPlanes(cube1);
        assertEquals(expected, actual);
    }

    @Test
    public void tangencyToPlanesTestNoneOfPlanes() {
        String expected = "The cube is tangent to plane(s): to none of the planes";
        String actual = tangencyToPlanes(cube2);
        assertEquals(expected, actual);
    }

    @Test
    public void tangencyToPlanesTestAllPlanes() {
        String expected = "The cube is tangent to plane(s): XY XZ YZ ";
        String actual = tangencyToPlanes(cube3);
        assertEquals(expected, actual);
    }
}
