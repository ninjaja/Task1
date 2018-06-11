package com.matrizaev.shape.action;

import com.matrizaev.shape.entity.Cube;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionCube {

    static Logger LOGGER = LogManager.getLogger();

    public static double calcCubeSurfArea(Cube cube) { // method defines cube's surface area
        double result = 6 * Math.pow(cube.getSideLength(), 2);
        return result;
    }

    public static double calcCubeVol(Cube cube) { // method defines volume of a cube
        double result = Math.pow(cube.getSideLength(), 3);
        return result;
    }

    public static String calcProportionXY(Cube cube) {
        double largerPartProportion = 0;
        double smallerPartProportion = 0;
        StringBuilder result = new StringBuilder("");

        if (Math.abs(cube.getCenter().getZ()) < cube.getSideLength() / 2) {
            double largerPartOfSide = Math.abs(cube.getCenter().getZ()) + cube.getSideLength() / 2;
            double largerPartVol = largerPartOfSide * Math.pow(cube.getSideLength(), 2);
            double smallerPartOfSide = cube.getSideLength() - largerPartOfSide;
            double smallerPartVol = smallerPartOfSide * Math.pow(cube.getSideLength(), 2);
            largerPartProportion = largerPartVol / Math.pow(cube.getSideLength(), 3);
            smallerPartProportion = smallerPartVol / Math.pow(cube.getSideLength(), 3);
            result.append(Double.toString(largerPartProportion)).append("/").append(Double.toString(smallerPartProportion));
        } else {
            result.append("The cube has no crossings with XY-plane");
            LOGGER.log(Level.INFO, "The cube has no crossings with XY-plane");
        }
        LOGGER.log(Level.INFO, "Proportion by crossing with XY-plane is: " + largerPartProportion + "/" + smallerPartProportion);
        return result.toString();
    }

    public static String calcProportionXZ(Cube cube) {
        double largerPartProportion = 0;
        double smallerPartProportion = 0;
        StringBuilder result = new StringBuilder("");

        if (Math.abs(cube.getCenter().getY()) < cube.getSideLength() / 2) {
            double largerPartOfSide = Math.abs(cube.getCenter().getY()) + cube.getSideLength() / 2;
            double largerPartVol = largerPartOfSide * Math.pow(cube.getSideLength(), 2);
            double smallerPartOfSide = cube.getSideLength() - largerPartOfSide;
            double smallerPartVol = smallerPartOfSide * Math.pow(cube.getSideLength(), 2);
            largerPartProportion = largerPartVol / Math.pow(cube.getSideLength(), 3);
            smallerPartProportion = smallerPartVol / Math.pow(cube.getSideLength(), 3);
            result.append(Double.toString(largerPartProportion)).append("/").append(Double.toString(smallerPartProportion));
        } else {
            result.append("The cube has no crossings with XZ-plane");
            LOGGER.log(Level.INFO, "The cube has no crossings with XZ-plane");
        }
        LOGGER.log(Level.INFO, "Proportion by crossing with XZ-plane is: " + largerPartProportion + "/" + smallerPartProportion);
        return result.toString();
    }

    public static String calcProportionYZ(Cube cube) {
        double largerPartProportion = 0;
        double smallerPartProportion = 0;
        StringBuilder result = new StringBuilder("");

        if (Math.abs(cube.getCenter().getX()) < cube.getSideLength() / 2) {
            double largerPartOfSide = Math.abs(cube.getCenter().getX()) + cube.getSideLength() / 2;
            double largerPartVol = largerPartOfSide * Math.pow(cube.getSideLength(), 2);
            double smallerPartOfSide = cube.getSideLength() - largerPartOfSide;
            double smallerPartVol = smallerPartOfSide * Math.pow(cube.getSideLength(), 2);
            largerPartProportion = largerPartVol / Math.pow(cube.getSideLength(), 3);
            smallerPartProportion = smallerPartVol / Math.pow(cube.getSideLength(), 3);
            result.append(Double.toString(largerPartProportion)).append("/").append(Double.toString(smallerPartProportion));
        } else {
            result.append("The cube has no crossings with YZ-plane");
            LOGGER.log(Level.INFO, "The cube has no crossings with YZ-plane");
        }
        LOGGER.log(Level.INFO, "Proportion by crossing with YZ-plane is: " + largerPartProportion + "/" + smallerPartProportion);
        return result.toString();
    }

    public static String tangencyToPlanes(Cube cube) {
        StringBuilder result = new StringBuilder("The cube is tangent to plane(s): ");
        boolean XY = Math.abs(cube.getCenter().getZ()) - cube.getSideLength() / 2 == 0;
        boolean XZ = Math.abs(cube.getCenter().getY()) - cube.getSideLength() / 2 == 0;
        boolean YZ = Math.abs(cube.getCenter().getX()) - cube.getSideLength() / 2 == 0;
        if (XY) {
            result.append("XY ");
        }
        if (XZ) {
            result.append("XZ ");
        }
        if (YZ) {
            result.append("YZ ");
        } if (!XY && !XZ && !YZ) {
            result.append("to none of the planes");
        }
        LOGGER.log(Level.INFO, result.toString());
        return result.toString();
    }

    // TODO: 02.06.2018 является ли объект кубом


}
