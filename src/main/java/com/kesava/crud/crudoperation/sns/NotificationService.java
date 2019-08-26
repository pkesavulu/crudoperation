package com.kesava.crud.crudoperation.sns;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;

public class NotificationService {
	static Logger logger = Logger.getLogger(NotificationService.class);

	public static void sendSMS(String name, String currentbalance, String phoneno) {
		BasicAWSCredentials credentials = null;
		String topicArn = null;
		String transactionMessage = "Hi " + name + " your current balance is : " + currentbalance + " /-";
		try (InputStream propertyfile = NotificationService.class.getResourceAsStream("/application.properties")) {
			Properties pros = new Properties();
			pros.load(propertyfile);
			String accessKey = pros.getProperty("accessKey");
			String secretKey = pros.getProperty("secretKey");
			topicArn = pros.getProperty("topicArn");
			credentials = new BasicAWSCredentials(accessKey, secretKey);
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		AmazonSNS snsClient = AmazonSNSClient.builder().withRegion(Regions.US_EAST_1)
				.withCredentials((new AWSStaticCredentialsProvider(credentials))).build();
		SubscribeRequest subRequest = new SubscribeRequest(topicArn, "SMS", "+91" + phoneno);
		SubscribeResult response = snsClient.subscribe(subRequest);
		PublishRequest publishRequest = new PublishRequest(topicArn, transactionMessage);
		PublishResult publishResult = snsClient.publish(publishRequest);
		publishResult.getSdkHttpMetadata().getHttpStatusCode();
		logger.info("unsubscribing user in aws");
		snsClient.unsubscribe(response.getSubscriptionArn());
	}
}
