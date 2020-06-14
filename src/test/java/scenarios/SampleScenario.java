package scenarios;

import amazonUtils.AmazonCredentials;
import amazonUtils.EventSender;
import amazonUtils.SQSEventBody;
import com.amazonaws.services.sqs.AmazonSQS;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.BaseSettings;

public class SampleScenario extends BaseSettings {

    private AmazonSQS sqs;

    @BeforeClass
    public void loginToAmazonAWS() {
        sqs = AmazonCredentials.loginWithLocalCredentials();
    }

    @Test
    public void sampleAmazonSQSTest() {
        String sampleSqsMessageBody = SQSEventBody.getSampleMessageBody("sample value for test");
        EventSender.sendSampleSQSMessage(sqs, sampleSqsMessageBody);

        //check affected API or UI steps in below....
    }
}
