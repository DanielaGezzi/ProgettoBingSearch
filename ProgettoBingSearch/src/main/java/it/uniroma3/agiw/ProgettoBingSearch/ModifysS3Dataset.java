package it.uniroma3.agiw.ProgettoBingSearch;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintStream;
	import java.text.DecimalFormat;

	import com.amazonaws.AmazonClientException;
	import com.amazonaws.AmazonServiceException;
	import com.amazonaws.auth.profile.ProfileCredentialsProvider;
	import com.amazonaws.services.s3.AmazonS3;
	import com.amazonaws.services.s3.AmazonS3Client;
	import com.amazonaws.services.s3.model.GetObjectRequest;
	import com.amazonaws.services.s3.model.ListObjectsRequest;
	import com.amazonaws.services.s3.model.ObjectListing;
	import com.amazonaws.services.s3.model.S3Object;
	import com.amazonaws.services.s3.model.S3ObjectSummary;

	public class ModifysS3Dataset {
		

		
		public static void main(String[] args) throws IOException {
			
			String bucketName = "prova-agiw";
			//String prefix = "prova8/";
			AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
			
			
		}
			
		public void mergePrefixes(AmazonS3 s3client, String bucketName){	
	 
	        try {
	        	  int cont = 0;
	            ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
	                .withBucketName(bucketName);
	                //.withPrefix(prefix);
	            ObjectListing objectListing;            
	            do {
	                objectListing = s3client.listObjects(listObjectsRequest);
	              
	                for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
	                	
	                	DecimalFormat myFormatter = new DecimalFormat("0000000");
	                    String output = myFormatter.format(cont);
	                    System.out.println("page_"+output);
	                    cont++;
	                    objectSummary.getKey();
	                	//System.out.println(objectSummary.);
	                	//downloadS3Object(bucketName, objectSummary.getKey(),s3client);             
	                }
	                
	                listObjectsRequest.setMarker(objectListing.getNextMarker());
	            } while (objectListing.isTruncated());
	         } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, " +
	            		"which means your request made it " +
	                    "to Amazon S3, but was rejected with an error response " +
	                    "for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, " +
	            		"which means the client encountered " +
	                    "an internal error while trying to communicate" +
	                    " with S3, " +
	                    "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	        }
	        
	    }
		
		public void getDatasetInfo(AmazonS3 s3client, String bucketName){

	        try {
	        	  int cont = 0;
	            ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
	                .withBucketName(bucketName);
	                //.withPrefix(prefix);
	            ObjectListing objectListing;            
	            do {
	                objectListing = s3client.listObjects(listObjectsRequest);
	              
	                for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
	                	
	                	DecimalFormat myFormatter = new DecimalFormat("0000000");
	                    String output = myFormatter.format(cont);
	                    System.out.println("page_"+output);
	                    cont++;
	                    objectSummary.getSize();
	                	//System.out.println(objectSummary.);
	                	//downloadS3Object(bucketName, objectSummary.getKey(),s3client);             
	                }
	                
	                listObjectsRequest.setMarker(objectListing.getNextMarker());
	            } while (objectListing.isTruncated());
	         } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, " +
	            		"which means your request made it " +
	                    "to Amazon S3, but was rejected with an error response " +
	                    "for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, " +
	            		"which means the client encountered " +
	                    "an internal error while trying to communicate" +
	                    " with S3, " +
	                    "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	        }
	        
	    }
		
		
}