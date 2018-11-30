package com.srm.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
*
* @author kwon37xi
*/
public class Encryption {
    public static final int KEY_SIZE = 1024;

    public void createKeyRSA(HttpServletRequest request) throws Exception 
    {
    	try
    	{
	        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
	        generator.initialize(KEY_SIZE);
	        
	        KeyPair keyPair = generator.genKeyPair();
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	
	        PublicKey publicKey = keyPair.getPublic();
	        PrivateKey privateKey = keyPair.getPrivate();
	
	        HttpSession session = request.getSession();
	        session.setAttribute("__rsaPrivateKey__", privateKey);
	
	        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
	
	        String publicKeyModulus = publicSpec.getModulus().toString(16);
	        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
	
	        request.setAttribute("publicKeyModulus", publicKeyModulus);
	        request.setAttribute("publicKeyExponent", publicKeyExponent);
    	}
    	catch (NoSuchAlgorithmException e)
    	{
    		throw new Exception("Encryption/createKeyRSA : NoSuchAlgorithmException " + e.getMessage());
    	}
    	catch (InvalidKeySpecException e)
    	{
    		throw new Exception("Encryption/createKeyRSA : InvalidKeySpecException " + e.getMessage());
    	}
    	catch (Exception e)
    	{
    		throw new Exception("Encryption/createKeyRSA : Exception " + e.getMessage());
    	}
    }
    
    public String decryptToRSA(PrivateKey privateKey, String str) throws Exception
    {
    	try
    	{
    		if (privateKey == null) throw new RuntimeException("Encryption/decryptToRSA : privateKey == null");
    		
			Cipher cipher = Cipher.getInstance("RSA");
		    byte[] encryptedBytes = hexToByteArray(str);
		    cipher.init(Cipher.DECRYPT_MODE, privateKey);
		    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		    return new String(decryptedBytes, "utf-8");
    	}
	    catch (NoSuchAlgorithmException e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : NoSuchAlgorithmException " + e.getMessage());
    	}
	    catch (NoSuchPaddingException e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : NoSuchPaddingException " + e.getMessage());
    	}
	    catch (InvalidKeyException e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : InvalidKeyException " + e.getMessage());
    	}
	    catch (IllegalBlockSizeException e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : IllegalBlockSizeException " + e.getMessage());
    	}
	    catch (BadPaddingException e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : BadPaddingException " + e.getMessage());
    	}
	    catch (UnsupportedEncodingException e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : UnsupportedEncodingException " + e.getMessage());
    	}
    	catch (Exception e)
    	{
    		throw new Exception("Encryption/decryptFuncToRSA : Exception " + e.getMessage());
    	}
    }
    
    private static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) {
            return new byte[]{};
        }

        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }
    
    public String encryptToSha512(String str) throws Exception
    {
    	try
    	{
	    	MessageDigest di = MessageDigest.getInstance("SHA-512");
			di.update(str.getBytes());
			byte messageDigest[] = di.digest();
			
			StringBuffer hexString = new StringBuffer();
			for(int i = 0; i < messageDigest.length ; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			
			return hexString.toString();
    	}
    	catch (NoSuchAlgorithmException e)
    	{
    		throw new Exception("Encryption/encryptToSha512 : NoSuchAlgorithmException " + e.getMessage());
    	}
    	catch (Exception e)
    	{
    		throw new Exception("Encryption/encryptToSha512 : Exception " + e.getMessage());
    	}
	}
}
