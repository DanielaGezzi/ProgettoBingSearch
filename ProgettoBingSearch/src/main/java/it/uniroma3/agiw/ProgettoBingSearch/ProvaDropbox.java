package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

public class ProvaDropbox {
	
	private static final String ACCESS_TOKEN = "***";

    public static void main(String args[]) throws DbxException, IOException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    
        
        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());
        
        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata m : result.getEntries()) {
                System.out.println(m.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }
        
        // Upload "test.txt" to Dropbox
        try (InputStream in = new FileInputStream("../ProgettoBingSearch/src/listaResults.txt")) {
            FileMetadata m = client.files().uploadBuilder("/listaResults.txt").uploadAndFinish(in);
        }
    
    }

}
