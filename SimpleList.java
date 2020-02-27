package cse360assign2;

import java.util.Scanner;
import java.util.Arrays;

/**
 *  Write SimpleList code to practice with Javadoc, creating unit tests and using Junit. 
 * 
 * @author Timothy Lee
 * CSE360
 * Class ID: 243
 */
public class SimpleList {
	
	 //define the variables
	 public int list[];
	 public int count;

	 /**
	  *  Create an array to hold 10 integers and set count to 0
	  */
	 public SimpleList() {   
	      list = new int[10];
	      this.count = 0;
	 }
	 
	 /**
	  * This method adds an integer to the list and move all the other integers in the list over so there is room. 
	  * If the list was full, then the last element falls off the list.  Increment the count as needed.
	  *  
	  * @param data This is an integer to be added
	  */
	 public void add(int data) {
	      if (count == list.length) {       //if array is full, then increase the size by 50% 
	          int NewSize = count + count / 2;
	          int newList[] = new int[NewSize];  //resize the list
	             
	          for (int index = 0; index < NewSize && index < count; index++) {    //copy elements to new array
	               newList[index] = list[index];
	          }
	 	      list = newList;
	 	      if (NewSize < count) {
	 	          count = NewSize;
	 	      }
	      }
	      
          for (int index = count; index > 0; index--) {
	           list[index] = list[index - 1];
	      }
	      list[0] = data;
	      count++;
	 }
	 
	 /**
	  * This method removes an integer from the list. The other values in the list may need to be moved down. 
	  * Adjust the count as needed. 
	  * 
	  * @param data This is an integer to be removed
	  */
     public void remove(int data) {
    	  if (count == 1)  {
    		  System.out.println("The list cannot be reduced to less than 1 entry!");
	    	  return;
	      }  
    	  
          int result = search(data);  //find the location of input data in the list

	      if (result != -1) {   //if found
	          for (int index = result; index < count - 1; index++) {
	               list[index] = list[index + 1];
	          }
	          count--;           
	      } 
	      
	      int NewSize = list.length * 3 / 4;
	      
	      if (count < NewSize) {   //if the list has more than 25% empty places
	    	  int newList[] = new int[NewSize];  //resize the list
           
	          for (int index = 0; index < NewSize && index < count; index++) {    //copy elements to new array
	               newList[index] = list[index];
	          }
	 	      list = newList;
	 	      if (NewSize < count) {
	 	          count = NewSize;
	 	      }

	      }      
     }
	 
     /**
      * This method returns the number of elements stored in the list. 
      * 
      * @return the number of elements stored in the list.
      */
     public int count() {
          return count;
	 }	 
  
     @Override  
     /**
      * This method returns the list as a string.The elements must be separated by a space.
      * This means there is not space after the last integer. 
      * 
      * @return the list as a string.
      */
	 public String toString(){
	      String output = "";   //define an string for output
	      
	      for (int index = 0; index < count; index++) {   //move each element of the list to output 
	           output += list[index];
	           if (index != count - 1) {
	               output += " ";
	           }
	      }
	      return output;   
	  } 
	  
     /**
      * This method returns the location of the parameter in the list. 
      * If the parameter is not in the list, then return -1. 
      * 
      * @param data this is an integer to be searched.
      * @return the location of the parameter
      */
	 public int search(int data) {
	       int result = -1;  //variable for the location
	       
	       for (int index = 0; index < count; index++) {  //loop for searching 
	            if (list[index] == data) {
	                result = index;
	            }
	       }
	       return result;
	 }
	 
	 /**
	  * This method appends the parameter to the end of the list
	  * 
	  * @param data this is an integer to be appended
	  */
	 public void append(int data) {	 
	        if (count == list.length) {   //if the list is full
	        	int NewSize = count + count / 2;
		        int newList[] = new int[NewSize];  //resize the list
		             
		        for (int index = 0; index < NewSize && index < count; index++) {    //copy elements to new array
		             newList[index] = list[index];
		        }
		 	    list = newList;
		        if (NewSize < count) {
			        count = NewSize;
		 	    }
	        }
	        list[count] = data;
	        count++;
	 }

	 /**
	  *  This method returns the first element in the list
	  */
     public int first() {
          if (count == 0) {    //if no element
              return -1;
          }
          return list[0];
     }

     /**
	  *  This method returns the last element in the list
	  */
     public int last() {
          if (count == 0) {    //if no element
              return -1;
          }
          return list[count - 1];
     }

     /**
      *  This method return the current number of possible locations in the list
      */
	 public int size() {
	        return list.length;
	 }  
}
