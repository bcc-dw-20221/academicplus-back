//package com.academicplus.domain.userv2;
//
//import com.academicplus.domain.Identifier;
//
//import java.util.UUID;
//
//public class UserV2ID extends Identifier {
//
//    private UserV2ID(String value) {
//        super(value);
//    }
//
//    public static UserV2ID unique() {
//        return UserV2ID.from(UUID.randomUUID().toString());
//    }
//
//    public static UserV2ID from(final String id) {
//        return new UserV2ID(id);
//    }
//}
