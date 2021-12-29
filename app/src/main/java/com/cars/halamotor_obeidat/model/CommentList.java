package com.cars.halamotor_obeidat.model;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class CommentList {
    public ArrayList<Comment> peopleCommentsDetailsArrayL ;

    public  CommentList(ArrayList<Comment> peopleCommentsDetailsArrayL)
    {
        this.peopleCommentsDetailsArrayL=peopleCommentsDetailsArrayL;
    }

    public ArrayList<Comment> getPeopleCommentsDetailsArrayL() {
        return peopleCommentsDetailsArrayL;
    }

    public void setPeopleCommentsDetailsArrayL(ArrayList<Comment> peopleCommentsDetailsArrayL) {
        this.peopleCommentsDetailsArrayL = peopleCommentsDetailsArrayL;
    }
}
