package org.example;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private int score;
    private boolean lastFrame;
    private final IGenerateur generator;
    private List<Roll> rolls;
    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public Frame(IGenerateur generator, boolean lastFrame)
    {
        this.lastFrame = lastFrame;
        this.generator = generator;
        rolls = new ArrayList<>();
    }

    public int getScore() {
        score = 0;
        rolls.forEach(s ->
                {
                        score += s.getPins();
                });
        return score;

    }


//    public boolean makeRoll()
//    {
//        int max = 10;
//        if (!lastFrame)
//        {
//
//            if (rolls.size() >= 2)
//            {
//                return false;
//            }
//            if (!rolls.isEmpty())
//            {
//                int firstRollPins = rolls.get(0).getPins();
//                if (firstRollPins == 10)
//                {
//                    return false;
//                }
//                max = 10 - firstRollPins;
//
//            }
//            int p = generator.randomPin(max);
//            Roll r = new Roll(p);
//            rolls.add(r);
//            return true;
//        }
//        else
//        {
//            if(rolls.size() <= 2 && (rolls.get(0).getPins() == 10 || (rolls.get(0).getPins() + rolls.get(1).getPins() == 10))) {
//                int firstRollPins = rolls.get(0).getPins();
//                if(rolls.size() <= 1)
//                {
//                    max = (firstRollPins == 10) ? 10 : 10 - firstRollPins;
//                }
//                else
//                {
//                    max = (rolls.get(1).getPins() == 10 || rolls.get(0).getPins() + rolls.get(1).getPins()== 10) ? 10 : 10 - rolls.get(1).getPins();
//                }
//                int p = generator.randomPin(max);
//                Roll r = new Roll(p);
//                rolls.add(r);
//                return true;
//            }
//            return false;
//        }
//    }


    public boolean makeRoll()
    {
        int max = 10;
        if (!lastFrame)
        {
            if(rolls.isEmpty() || (rolls.size() < 2 && rolls.get(0).getPins()< 10))
            {
                max = rolls.isEmpty() ? 10 : 10 - rolls.get(0).getPins();
                rolls.add(new Roll(generator.randomPin(max)));
                return true;
            }
            return false;
        }
        else
        {
            if (rolls.size() <= 2 && (rolls.get(0).getPins() == 10 || (rolls.get(0).getPins() + rolls.get(1).getPins() == 10)))
            {
                max = (rolls.size() == 2 && rolls.get(0).getPins() + rolls.get(1).getPins() != 10) ? 10 - rolls.get(1).getPins() : 10;
                rolls.add(new Roll(generator.randomPin(max)));
                return true;
            }
            return false;
        }
    }
}
