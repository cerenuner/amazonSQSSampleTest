package amazonUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import settings.BaseSettings;

public class AmazonCredentials extends BaseSettings {

    public static AmazonSQS loginWithLocalCredentials() {
        ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider(getAmazonProfile());
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (~/.aws/credentials), and is in valid format.",
                    e);
        }
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(getAmazonRegion())
                .build();
        System.out.println("Logged in Amazon with local credentials.\n");
        return sqs;
    }
}
