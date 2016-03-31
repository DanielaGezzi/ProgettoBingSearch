package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.io.BufferedReader;

import com.dropbox.core.*;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;
import com.dropbox.core.v2.DbxClientV2;

import java.io.*;
import java.util.Locale;

public class ProvaDropbox {

//    public static void main(String args[]) throws DbxException, IOException, IOException {
//
//        final String APP_KEY = "zbho9efejgv73oo";
//        final String APP_SECRET = "1o5fln8q4g6hcmw";
//    	final String ACCESS_TOKEN = "z6WyyNOBJxwAAAAAAAAGuXEhadqZd19_Pvv8YVbpcacZPbv3z6m9MHLxLEL4pJ0T";
//    	
//    	DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
//
//        DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",Locale.getDefault().toString());
//        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
//
//        // Have the user sign in and authorize your app.
//        String authorizeUrl = webAuth.start();
////        System.out.println("1. Go to: " + authorizeUrl);
////        System.out.println("2. Click \"Allow\" (you might have to log in first)");
////        System.out.println("3. Copy the authorization code.");
//        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
//
//        // This will fail if the user enters an invalid authorization code.
//        DbxAuthFinish authFinish = webAuth.finish(code);
//        String accessToken = authFinish.getAccessToken();
//
//        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
//
////        System.out.println("Linked account: " + client.getAccountInfo().displayName);
//
//        File inputFile = new File("prova_scrittura.txt");
//        FileInputStream inputStream = new FileInputStream(inputFile);
//        try {
//        	
//            DbxEntry.File uploadedFile = client.uploadFile("/prova_scrittura.txt",DbxWriteMode.add(), inputFile.length(), inputStream);
//            System.out.println("Uploaded: " + uploadedFile.toString());
//        } finally {
//            inputStream.close();
//        }
//
//        DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
//        System.out.println("Files in the root path:");
//        for (DbxEntry child : listing.children) {
//            System.out.println("	" + child.name + ": " + child.toString());
//        }
//
//        FileOutputStream outputStream = new FileOutputStream("prova_scrittura.txt");
//        try {
//            DbxEntry.File downloadedFile = client.getFile("/prova_scrittura.txt", null,outputStream);
//            System.out.println("Metadata: " + downloadedFile.toString());
//        } finally {
//            outputStream.close();
//        }
    

    	
    	
    	
    	
    	
    	
    	// Create Dropbox client
//        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
//        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    
        
        // Get current account info
//        FullAccount account = client.users().getCurrentAccount();
//        System.out.println(account.getName().getDisplayName());
        
        // Get files and folder metadata from Dropbox root directory
//        ListFolderResult result = client.files().listFolder("");
//        while (true) {
//            for (Metadata m : result.getEntries()) {
//                System.out.println(m.getPathLower());
//            }
//
//            if (!result.getHasMore()) {
//                break;
//            }
//
//            result = client.files().listFolderContinue(result.getCursor());
//        }
        
        // Upload "test.txt" to Dropbox
//        try (InputStream in = new FileInputStream("../ProgettoBingSearch/src/listaResults.txt")) {
//            FileMetadata m = client.files().uploadBuilder("/listaResults.txt").uploadAndFinish(in);
//        }
    
//    }

}
