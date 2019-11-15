package com.emilioaraos;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Valledupar");
        placesToVisit.add("Barranquilla");
        placesToVisit.add("Bogota");
        placesToVisit.add("Patillal");
        placesToVisit.add("Medellin");
        placesToVisit.add("Cali");

        System.out.println("Printing : " + placesToVisit);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        printList(placesToVisit);



        LinkedList<String> newPlacesToVisit= new LinkedList<String>();

        addInOrder(newPlacesToVisit, "New York");
        addInOrder(newPlacesToVisit, "Miami");
        addInOrder(newPlacesToVisit, "Denver");
        addInOrder(newPlacesToVisit, "Washington");
        addInOrder(newPlacesToVisit, "New Jersey");
        addInOrder(newPlacesToVisit, "Kansas City");
        addInOrder(newPlacesToVisit, "Orlando");
        addInOrder(newPlacesToVisit, "Charlotte");
//        addInOrder(newPlacesToVisit, "Charlotte");
        printList(newPlacesToVisit);


        System.out.println("Printing : " + newPlacesToVisit);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        visit(newPlacesToVisit);



    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> iterator = linkedList.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0 ){
                System.out.println(newCity + " is already in the list");
                return false;
            }else if( comparison > 0){
                //next city should appear before.
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }else if(comparison < 0){
                //move to next city.
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
    public static void visit (LinkedList cities){
        Scanner scanner = new Scanner (System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator= cities.listIterator();

        if (cities.isEmpty()){
            System.out.println("No cities in  itinerary");
            return;
        }else{
            System.out.println("Now visiting "+ listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Holiday (vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("now visiting " + listIterator.next());
                    }else{
                        System.out.println("Reached the end of the list");
                        goingForward = false;

                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("Now Visiting "+ listIterator.previous());
                    }else{
                        System.out.println("We are at the start of the list");
                        goingForward = true;

                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n"+
                "1 - go to next city\n" +
                "2- go to previous city\n" +
                " 3- print menu options: ");
    }



}
