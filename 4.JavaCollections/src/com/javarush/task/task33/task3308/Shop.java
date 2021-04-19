package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Shop {

    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    private static class Goods {
        List names = new ArrayList<String>();
    }
}
