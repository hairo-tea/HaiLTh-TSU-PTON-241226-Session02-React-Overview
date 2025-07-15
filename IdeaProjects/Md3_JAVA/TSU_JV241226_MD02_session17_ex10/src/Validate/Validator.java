package Validate;

import dao.StudentDao;

public class Validator {
    public static boolean validateName(String data) {

        if(data!=null && !data.isEmpty()){
           return true;
        }
        return false;
    }
    public static boolean validateEmail(String email) {
        if(email==null || email.isEmpty()){
           return false;
        }
        if(StudentDao.isStudentExists(email)){
            return false;
        }
        return true;

    }
}
