package com.matrizaev.shape.creator;


import com.matrizaev.shape.entity.Cube;
import com.matrizaev.shape.entity.CenterPoint;
import com.matrizaev.shape.parser.CubeParser;
import com.matrizaev.shape.reader.CubeReader;
import com.matrizaev.shape.validator.CubeValidator;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {

    /*public static void main(String[] args) {
        CubeReader reader = new CubeReader();
        List list = reader.readCube();
        CubeValidator validator = new CubeValidator();
        List list1 = validator.cubeValidate(list);
        CubeParser parser = new CubeParser();
        List list2 = parser.cubeParse(list1);
        CubeCreator creator = new CubeCreator();
        List<Cube> list3 = creator.createCubeList(list2);
        for (Cube cube : list3) {
            System.out.println(cube.toString());
        }

    }*/

    public List<Cube> createCubeList (List<Double> cubeDataList) {

        ArrayList<Cube> createdCubesList = new ArrayList<>();
        int count = 0;

        while (count < cubeDataList.size()) {
            CenterPoint CenterPoint = new CenterPoint();
            Cube cube = new Cube();
            CenterPoint.setX(cubeDataList.get(count));
            count++;
            CenterPoint.setY(cubeDataList.get(count));
            count++;
            CenterPoint.setZ(cubeDataList.get(count));
            cube.setCenter(CenterPoint);
            count++;
            cube.setSideLength(cubeDataList.get(count));
            createdCubesList.add(cube);
            count++;
        }
        return createdCubesList;
    }
}
