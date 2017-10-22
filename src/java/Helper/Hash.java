/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author shimantta
 */
public class Hash {
    String hash = "";
    
    public static String makeHash(String value) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
        byte[] bytes = md.digest();
        String hashString = DatatypeConverter.printHexBinary(bytes);
        return hashString;
    }
}
