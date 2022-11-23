package com.demo.labpracticals.data;

import com.demo.labpracticals.R;
import java.util.Arrays;
import java.util.Random;

public class StaticData {
    private static StaticData dataObj = null;
    private StaticData(){}

    private final Animals[] animalList = {
            new Animals(R.drawable.animal01, "Deer", "Deer is a wild animal that belongs to the Cervidae family"),
            new Animals(R.drawable.animal02, "Giraffe", "Giraffes are the world's tallest mammals, thanks to their towering legs and long necks"),
            new Animals(R.drawable.animal03, "Peacock", "Peacocks, also known as “peafowl, are large colorful birds that live in India and Asia"),
            new Animals(R.drawable.animal04, "Fish", "Fish are aquatic vertebrate animals that have gills but lack limbs with digits, like fingers or toes"),
            new Animals(R.drawable.animal05, "Lion", "Lions have strong, compact bodies and powerful forelegs, teeth and jaws for pulling down and killing prey"),
            new Animals(R.drawable.animal06, "Tiger", "The tiger has a muscular body with strong forelimbs, a large head and a tail that is about half the length of its body"),
            new Animals(R.drawable.animal07, "Elephant", "Elephants are the largest land mammals on earth and have distinctly massive bodies, large ears, and long trunks"),
            new Animals(R.drawable.animal08, "Parrot", "Characteristic features of parrots include a strong, curved bill, an upright stance, strong legs, and clawed zygodactyl feet"),
            new Animals(R.drawable.animal09, "Fox", "Foxes are small to medium-sized, omnivorous mammals belonging to several genera of the family Canidae"),
            new Animals(R.drawable.animal10, "Squirrel", "Squirrels are generally small rodents with slender bodies, bushy tails and large eyes"),
            new Animals(R.drawable.animal11, "Chameleon", "Most chameleons, however, are 17–25 cm (7–10 inches) long. The body is laterally compressed, the tail is sometimes curled, and the bulged eyes move independently of one another"),
            new Animals(R.drawable.animal12, "Chimpanzee", "The characteristic chimpanzee shape includes arms that extend beyond the knees, opposable thumbs, and a prominent mouth")
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

    public int getListLength(){
        return this.animalList.length;
    }
}
