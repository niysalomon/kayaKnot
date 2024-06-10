package kaya.knot.kayaKnot.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

public class AppUtils {
    public static byte[] convertBase64String(String base64String) {
        String[] base64Image = base64String.split(",");
   return Base64.getDecoder().decode(base64Image[1]);
    }
}
