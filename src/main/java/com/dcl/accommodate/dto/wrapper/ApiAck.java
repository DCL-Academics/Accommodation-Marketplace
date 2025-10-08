package com.dcl.accommodate.dto.wrapper;

public record ApiAck(boolean success, String message) {
}


//for all records

//Why record?
//
//Immutability by default:
//
//A record automatically creates final fields, so once an object is created, its values cannot be changed.
//
//This is perfect for DTOs and response wrappers where data should not be modified after being sent.
//
//Less boilerplate code:
//
//Records automatically generate:
//
//Constructor
//
//Getters (no get prefix, just the field name)
//
//equals() / hashCode() / toString()
//
//Example:
//
//ApiAck ack = new ApiAck(true, "Success");
//System.out.println(ack.message()); // prints "Success"