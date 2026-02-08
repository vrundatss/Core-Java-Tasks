package com.tss.ExceptionHandlingAssign;

import com.tss.ExceptionAssign.exceptions.AgeNotValidException;

public class VoterTest {
    public static void main(String[] args) {
        Voter voter = null;
        try{
            voter = new Voter(1 , "abc" , 10);

        }catch(AgeNotValidException e){
            System.out.println(e.getMessage());
        }
//        System.out.println(voter);
    }
}
