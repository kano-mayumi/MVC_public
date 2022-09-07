package jp.co.kano.util;

import java.util.Random;

public class RandomNumberUtil {

    
    public Integer getClassNo() {
        Integer classNo;
        Random rand = new Random();
        classNo = rand.nextInt(11)+1;
        return classNo;
    }
    
    public Integer getAge() {
        Integer age;
        Random rand = new Random();
        age = rand.nextInt(12)+18;
        return age;
    }
}
