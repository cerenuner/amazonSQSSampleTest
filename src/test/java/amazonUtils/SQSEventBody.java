package amazonUtils;

import net.minidev.json.JSONObject;
import settings.BaseSettings;

public final class SQSEventBody extends BaseSettings {

    public static String getSampleMessageBody(String sampleValue) {

        String message = "{" +
                "\"sampleValue1\":3," +
                "\"sampleValue2\":\"value2\"," +
                "\"sampleValue3\":\"" + sampleValue + "\"}";

        JSONObject eventMessage = new JSONObject();
        eventMessage.put("Type", "Notification");
        eventMessage.put("Message", message);
        
        return eventMessage.toJSONString();
    }
}
