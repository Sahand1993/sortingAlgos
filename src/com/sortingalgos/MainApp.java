package com.sortingalgos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        QuickSorter<Integer> sorter = (QuickSorter<Integer>) context.getBean("integerQuickSorter");
        Integer[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        Integer[] sortedArray = sorter.sort(array, array.length - 1);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
