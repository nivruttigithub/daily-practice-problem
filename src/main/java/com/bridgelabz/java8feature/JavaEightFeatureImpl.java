package com.bridgelabz.java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class JavaEightFeatureImpl {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Amit", 10, "Maharashtra", "Computer", "9999990001", 21, "Male"),
                new Student("Priya", 55, "Karnataka", "Mechanical", "9999990002", 22, "Female"),
                new Student("Ravi", 70, "Karnataka", "Computer", "9999990003", 23, "Male"),
                new Student("Sneha", 95, "Tamil Nadu", "Electrical", "9999990004", 24, "Female"),
                new Student("John", 5, "Karnataka", "Electronics", "9999990005", 22, "Male"),
                new Student("Meera", 12, "Kerala", "Computer", "9999990006", 20, "Female"),
                new Student("Vinay", 2, "Karnataka", "Mechanical", "9999990007", 21, "Male"),
                new Student("Divya", 101, "Maharashtra", "Electrical", "9999990008", 23, "Female"),
                new Student("Arjun", 150, "Karnataka", "Computer", "9999990009", 22, "Male"),
                new Student("Kavya", 78, "Karnataka", "Civil", "9999990010", 24, "Female")
        );

         //1. Find students with rank between 50 and 100
          List<Student> result = students
                                .stream()
                                .filter(s -> s.getRank() >= 50 && s.getRank() <= 100)
                                .collect(Collectors.toList());
          System.out.println(result);
          System.out.println();

          //2. Find students from Karnataka, sorted by name
        List<Student> karnatakaStudents = students.stream()
                .filter(s -> "Karnataka".equalsIgnoreCase(s.getState()))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println(karnatakaStudents);
        System.out.println();

        //3. Find all department names
        List<String> departments = students
                .stream().map(Student::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(departments);
        System.out.println();

        //4. Find all contact numbers
        List<String> contacts = students
                .stream()
                .map(Student::getContactNumber)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(contacts);
        System.out.println();

        //5. Group students by department name
        Map<String, List<Student>> groupedByDepartment = students
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println(groupedByDepartment);
        System.out.println();

        //6. Department with max number of students

        // Counting the Department
        Map<String, Long> departmentCount = students
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        //Department having the Maximum number Of Student
        String deptWithMaxStudents = departmentCount
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Department Found !");
        System.out.println(deptWithMaxStudents);
        System.out.println();

        // 7. Average age by gender
        Map<String, Double> avgAgeByGender = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeByGender);
        System.out.println();

        //8. Highest rank in each department
        Map<String, Optional<Student>> highestRankPerDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.minBy(Comparator.comparingInt(Student::getRank))));
        System.out.println(highestRankPerDept);
        System.out.println();

        //9. Student who has second rank
        Optional<Student> secondRanker = students
                .stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst();
        System.out.println(secondRanker);
        System.out.println();

        //String & Array Based Java 8 Problems

        //1. Count occurrences of each character
        String input = "programming";
        Map<Character, Long> countMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(countMap);
        System.out.println();

        // 2. Find duplicate characters
        Set<Character> duplicates = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(duplicates);
        System.out.println();

        //3. First non-repeating character
        Optional<Character> firstNonRepeating = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(firstNonRepeating);
        System.out.println();

        //4. Second largest in array
        int[] arr = {4, 1, 7, 2, 9, 9};
        OptionalInt secondLargest = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();
        System.out.println(secondLargest);
        System.out.println();

        // 5. Longest string in a list
        List<String> list = Arrays.asList("apple", "banana", "pineapple");
        Optional<String> longest = list.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println(list);
        System.out.println();

        //6. Max number in array
        int max = Arrays.stream(arr)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Array is empty"));
        System.out.println(max);
        System.out.println();

        //7. Elements starting with 1
        List<Integer> numbers = Arrays.asList(10, 12, 23, 17, 45);
        List<String> startingWith1 = numbers.stream()
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println();

        //8. String.join example
        List<String> names = Arrays.asList("Amit", "Sumit", "Ravi");
        String joined = String.join(", ", names);
        System.out.println(names);
        System.out.println();

        //9. skip() and limit() example
        List<Integer> resultList = numbers.stream()
                .skip(2)      // skips first 2 elements
                .limit(3)     // takes next 3
                .collect(Collectors.toList());
        System.out.println(resultList);
        System.out.println();



    }
}

