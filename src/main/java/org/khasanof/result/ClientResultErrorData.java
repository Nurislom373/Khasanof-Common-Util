package org.khasanof.result;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClientResponseException;

/**
 * @author Nurislom
 * @see org.khasanof.result
 * @since 12/29/2024 7:54 PM
 */
@Getter
@Setter
public class ClientResultErrorData<D> extends ClientResultData<D> {

    private String message;
    private String statusText;
    private String responseBody;
    private HttpStatusCode statusCode;

    public ClientResultErrorData(boolean success, String message) {
        super(success, message);
    }

    public ClientResultErrorData(RestClientResponseException exception) {
        super(false, null);
        this.message = exception.getMessage();
        this.statusCode = exception.getStatusCode();
        this.statusText = exception.getStatusText();
        this.responseBody = exception.getResponseBodyAsString();
        super.setResponseText(createResponseText());
    }

    public ClientResultErrorData(D data, RestClientResponseException exception) {
        super(false, null, data);
        this.message = exception.getMessage();
        this.statusCode = exception.getStatusCode();
        this.statusText = exception.getStatusText();
        this.responseBody = exception.getResponseBodyAsString();
        super.setResponseText(createResponseText());
    }

    public String createResponseText() {
        return "Status: " + getStatusCode() + ", " +
                "StatusText: " + getStatusText() + ", " +
                "Message: " + getMessage() + ", " +
                "Response: " + getResponseBody();
    }
}
