/*Asya Akkus*/
/*Homework Two. This class mimics the most common operations of word processor machines*/

import java.util.NoSuchElementException; 

public class HW2 {
  
  /*a method that takes the average of all the values of a single-element array*/
  public static double average (double[]array) {
    
    double sum = 0; 
    
    if (array.length != 0)
      /*loops through array and adds all indices together*/
      for (int i = 0; i < array.length; i++) {
      sum = array[i] + sum; 
    }
    
    else 
      throw new NoSuchElementException();  
    
    return (sum / array.length);
  }
  
  /*a method that takes the average of all the values of a multidimensional array*/
  public static double average (double [][] array) throws NoSuchElementException {
    
    double sum = 0; 
    int count = 0; 
    
    if (array.length != 0)
      /*both loops loop through all values of both arrays
       * to return sum of all indices*/
      for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        sum = array[i][j] + sum; 
        count++; 
      }
    }
    
    else 
      throw new NoSuchElementException(); 
    
    return (sum/count);
  }
  
  /*a method that counts the number of words, defined as consecutive non-whitespace
   * characters, in a string*/
  public static int countWords (String s) {
    
    /*Special case: if-then determining what happens if length of string
     * is zero */
    int word = 0; 
    if (s.length() == 0)
      return word = 0; 
    
    /*Special case: if-then determining what happens if string starts with
     * a space */
    if (s.charAt(0) != ' ') {
      word = word + 1;
    } 
    
    /*for loop determining how words are added together regardless of
     * what character they start with */
    for (int i = 0; i < s.length() - 1; i = i + 1) {
      if (s.charAt(i) == ' '&& s.charAt(i + 1) != ' ') {
        word = word + 1;
      }
    }
    
    return word; 
  }
  
  /*a method that truncates a string after a specified number of characters*/
  public static String truncate(String s, int maxLength) {
    
    StringBuilder builder = new StringBuilder();
    
    /*first if statement and for loop establish what you do when the 
     * string length is less than max length*/ 
    int a; 
    if (s.length() < maxLength) {
      for (a = 0; a < s.length(); a = a + 1)
        builder.append(s.charAt(a)); 
    }  
    
    /*second if statement and while loop establish what you do when 
     * the string starts with a space*/
    /*first for loop loops through the string to establish where to stop the
     * truncation and the while loop creates the string*/
    if(s.length() > maxLength && s.charAt(0) == ' ') {
      int b;
      int i; 
      for (i = maxLength; (s.charAt(i) != ' ' && i > 0); i = i + 1) {
        ;
      }
      b = i; 
      while (s.charAt(i) != ' ' && HW2.countWords(s) >= 0) {
        builder.append(s.charAt(b));
        b = b + 1; 
      }
    }
    
    /*third if-then and for loops establish what you do if the max length
     * is in the middle of a word*/
    else if (s.length() > maxLength && HW2.countWords(s) > 1) {
      
      /*first for loop establishes where you are supposed to stop when creating the string*/
      /*second for loop establishes the length of the new string*/
      /*third while loop creates the new string*/
      int i;
      int j; 
      for (i = maxLength; ((s.charAt(i) != ' ' && i > 0)) ; i = i - 1) {
        ;
      }
      for (j = i; (s.charAt(i) == ' ' && i > 0) ; i = i - 1) {
        ;
      }
      
      int newStringLength = 0;
      while (newStringLength <= i) {
        builder.append(s.charAt(newStringLength));
        newStringLength = newStringLength + 1; 
      }
    }
    return builder.toString();  
  }
  
  /*a method that adds extra space in between words*/
  public static String padString (String s, int desiredLength) {
    
    StringBuilder builder = new StringBuilder(); 
    
    int spaces =  HW2.countWords(s) - 1; 
    
    /*Special case: if there are no spaces, input string is returned.*/
    if (spaces == 0){ 
      return s; 
    }
    
    int desiredSpaces = desiredLength - s.length(); 
    int numberSpaces = desiredSpaces / spaces; 
    int excessSpaces = desiredSpaces % spaces; 
    
    /*if-then statement entered if no excess spaces are to be inserted*/
    /*first for loop loops through the length of the string*/
    /*second for loop loops through the spaces and adds the appropriate amount*/
    if (excessSpaces == 0){
      for(int j = 0; j < s.length(); j = j + 1){
        if (s.charAt(j) == ' ') {
          for(int g = 0; g < numberSpaces+1; g = g + 1){
            char a = ' '; 
            builder.append(a);} 
        }
        else 
          builder.append(s.charAt(j)); 
      }
    }
    
    /*if-then statement entered if there are excess spaces are to be inserted*/
    /*first for loop in if statement loops through string and if there is a space 
     * and appends non-excess spaces*/
    /*second for loop appends excess spaces*/
    if(excessSpaces > 0) {
      
      int h = 0;
      
      for(int j = 0; j < s.length(); j = j + 1){
        if (s.charAt(j) == ' ') {
          if(h < spaces-excessSpaces){
            for(int l = 0; l<numberSpaces; l++){
              builder.append(' ');
            }
          }
          else {
            for(int i = 0; i<(numberSpaces+1); i++){
              builder.append(' ');
            }
          }
          h = h+1;
          builder.append(' ');
        }
        
        else 
          builder.append(s.charAt(j)); 
      }
    }
    return builder.toString();
  }
  
  /*a method that prints a string onto the screen where each line has the same number of characters*/
  public static void prettyPrint(String s, int lineWidth) {
    
    String currentString = s;
    
    /*first while loop loops through original string*/
    /*second for loop creates a truncated and version of the string that is then padded and printed. 
     * It makes sure that the letters line up to the right */
    while (currentString.length() > 0) {
      
      StringBuilder builder = new StringBuilder();
      
      for (int j = HW2.truncate(currentString, lineWidth).length(); j < currentString.length(); j = j + 1) {
        if (builder.length() == 0 && currentString.charAt(j) == ' ') {
        }
        else {
          builder.append(currentString.charAt(j)); 
        }
      }
      
      System.out.println(HW2.padString(HW2.truncate(currentString, lineWidth), lineWidth));   
      currentString = builder.toString();
    } 
  }
}

