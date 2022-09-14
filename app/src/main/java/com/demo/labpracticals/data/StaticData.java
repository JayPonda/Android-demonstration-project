package com.demo.labpracticals.data;

import com.demo.labpracticals.R;
import java.util.Arrays;
import java.util.Random;

public class StaticData {
    private static StaticData dataObj = null;
    private StaticData(){}

    private final Animals[] animalList = {
            new Animals(R.drawable.animal01, "Deer"),
            new Animals(R.drawable.animal02, "Giraffe"),
            new Animals(R.drawable.animal03, "Peacock"),
            new Animals(R.drawable.animal04, "Fish"),
            new Animals(R.drawable.animal05, "Lion"),
            new Animals(R.drawable.animal06, "Tiger"),
            new Animals(R.drawable.animal07, "Elephant"),
            new Animals(R.drawable.animal08, "Parrot"),
            new Animals(R.drawable.animal09, "Fox"),
            new Animals(R.drawable.animal10, "Squirrel"),
            new Animals(R.drawable.animal11, "Chameleon"),
            new Animals(R.drawable.animal12, "Chimpanzee")
    };

    public static StaticData getInstance(){
        if(dataObj == null)
            dataObj = new StaticData();

        return dataObj;
    }

    private Animals[] shuffleAnimalList(int itr){
        Animals[] cloneList = animalList.clone();
        Random random = new Random();
        Animals tempObj;
        int sourceIndex, destinationIndex;

        int numberOfIteration =
                itr < 0 || itr > cloneList.length * 2 ?
                cloneList.length > 25 ?
                        25 : cloneList.length * 2 :
                itr;

        for (int i = 0; i < numberOfIteration; i++){
            sourceIndex = i % cloneList.length;
            destinationIndex = random.nextInt(cloneList.length);
            tempObj = cloneList[sourceIndex];
            cloneList[sourceIndex] = cloneList[destinationIndex];
            cloneList[destinationIndex] = tempObj;
        }

        return cloneList;
    }

    public Animals[] getAnimalList(){
        return animalList;
    }

    public Animals[] getAnimalList(int iteration){
       System.out.println(Arrays.toString(animalList));
       return shuffleAnimalList(iteration);
    }
}
