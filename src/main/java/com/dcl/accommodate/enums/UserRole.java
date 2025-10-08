package com.dcl.accommodate.enums;

public enum UserRole {
    HOST,
    GUEST;

}


//An enum is chosen here because UserRole is a fixed set of constants, it ensures type safety, is readable,
// and maps cleanly to the database. A class or interface would be overkill and less safe.
