package com.srm.util;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
*
* @author kwon37xi
*/
public class Encryption {
    public static final int KEY_SIZE = 1024;

    public void createKeyRSA(HttpServletRequest request)
            throws ServletException, IOException 
    {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(KEY_SIZE);
            
            KeyPair keyPair = generator.genKeyPair();
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            HttpSession session = request.getSession();
            // ���ǿ� ����Ű�� ���ڿ��� Ű���Ͽ� ����Ű�� �����Ѵ�.
            session.setAttribute("__rsaPrivateKey__", privateKey);

            // ����Ű�� ���ڿ��� ��ȯ�Ͽ� JavaScript RSA ���̺귯�� �Ѱ��ش�.
            RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

            String publicKeyModulus = publicSpec.getModulus().toString(16);
            String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

            request.setAttribute("publicKeyModulus", publicKeyModulus);
            request.setAttribute("publicKeyExponent", publicKeyExponent);

        } catch (Exception e) {
            throw new ServletException(e.getMessage(), e);
        }
    }
    
    public void decryptToRSA(HttpServletRequest request)
            throws ServletException, IOException 
    {
        String securedUsername = request.getParameter("securedUsername");
        String securedPassword = request.getParameter("securedPassword");
        
        HttpSession session = request.getSession();
        PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // Ű�� ������ ���´�. �׻� ���ο� Ű�� �޵��� ����.

        if (privateKey == null) throw new RuntimeException("��ȣȭ ���Ű ������ ã�� �� �����ϴ�");
 
        try {
            String username = decryptFuncToRSA(privateKey, securedUsername);
            String password = decryptFuncToRSA(privateKey, securedPassword);
            
            request.setAttribute("username", username);
            request.setAttribute("password", password);
        } catch (Exception e) {
            throw new ServletException(e.getMessage(), e);
        }
    }
    
    private String decryptFuncToRSA(PrivateKey privateKey, String securedValue) throws Exception 
    {
        Cipher cipher = Cipher.getInstance("RSA");
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        
        return new String(decryptedBytes, "utf-8");
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
		try{
			MessageDigest di = MessageDigest.getInstance("SHA-512");
			di.update(str.getBytes());
			byte messageDigest[] = di.digest();
			
			StringBuffer hexString = new StringBuffer();
			for(int i = 0; i < messageDigest.length ; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			
			return hexString.toString();
		} 
		catch(Exception e)
		{
			throw new Exception(e.getMessage(), e);
		}
	}
}
