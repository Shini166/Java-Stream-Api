package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        filterAndCollect();
//        transformElements();
//        fIndMinMax();
//        countOccurences();
//        sortDesc();
//        sortDescForInt();
//        sortAndPickTop2numbers();
//        concatenateListOfStringIntoSingleString();
//        findFirstDuplicateElement();
//        startsWithSomeChar();
//        removeDuplicateNumsFromList();
//        sumOfNumbersInList();
        avgOfNumbersInList();




        admin obj = new admin();
        obj.setName("Saurabh");
//        System.out.print(obj.getName());
    }

    private static void filterAndCollect() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> odd = numbers.stream().filter(x->x%2!=0).toList();
        odd.forEach(System.out::println);
    }

    private static void transformElements() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
//        List<String> Uppercase = fruits.stream().map(x->x.toUpperCase()).toList();
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private static void fIndMinMax()
    {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1);
        int min = numbers.stream().min(Integer::compare).orElseThrow();
        int max = numbers.stream().max(Integer::compare).orElseThrow();
        System.out.println("Min : " + min + " , Max : " + max);
    }

    private static void countOccurences()
    {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        Map<String,Long> fruitsCounts = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        fruitsCounts.forEach((x,y)->System.out.println(x + " : " + y));
        System.out.print(fruitsCounts);
    }

    private static void sortDesc()
    {
        List<String> fruits = Arrays.asList("apple", "kiwi", "banana", "cherry");
        fruits.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static void sortDescForInt()
    {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1);
//        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        numbers.stream().sorted((x,y)->Integer.compare(y,x)).forEach(System.out::println);
    }

    private static void sortAndPickTop2numbers() {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1);
        List<Integer> list1 = numbers.stream().sorted((x,y)->Integer.compare(y,x)).collect(Collectors.toList());
        List<Integer> top2 = list1.stream().skip(1).limit(2).collect(Collectors.toList());
        top2.forEach(System.out::println);
    }

    //Find duplicate entries and return a concatnated string with a delimiter ", "
    private static void concatenateListOfStringIntoSingleString()
    {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
//        String fruitsCounts = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).collect(Collectors.joining(", "));
//        String fruitsCounts = fruits.stream().collect(Collectors.groupingBy(Function.identity(),TreeMap::new,Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).collect(Collectors.joining(", "));
        Map<String , Long> map = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String fruitsCounts = map.entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).collect(Collectors.joining(", "));
        System.out.print(fruitsCounts);
    }

    private static void findFirstDuplicateElement()
    {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        Map<String,Long> map = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Optional<String> fruitsCounts = fruits.stream().filter(x -> map.get(x)>1).findFirst();
        fruitsCounts.ifPresent(System.out::println);
    }

    private static void startsWithSomeChar()
    {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        List<String> fruitsCounts = fruits.stream().filter(x->x.startsWith("o")).toList();
        System.out.print(fruitsCounts);
    }

    private static void removeDuplicateNumsFromList()
    {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1, 8, 5, 0);
        numbers.stream().distinct().forEach(System.out::println);
    }

    private static void sumOfNumbersInList()
    {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    private static void avgOfNumbersInList()
    {
        List<Double> numbers = Arrays.asList(3.8, 5.0, 7.0, 2.0, 8.0, 1.0);
        double avg = numbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(avg);
    }








    /* Find no of duplicates in a list of string
       Find max duplicate element
       Find first duplicate
       Check if given string is palindrome if its palindrom replace it with palindrome
       prime number
       non repeating chars in a string
       print smallest element in a array
       remove space from a string
       swap values of 2 numbers

            */

    public static class admin
    {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

