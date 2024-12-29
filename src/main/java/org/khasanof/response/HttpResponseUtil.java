package org.khasanof.response;

import lombok.extern.slf4j.Slf4j;
import org.khasanof.result.ClientResultData;
import org.springframework.http.ResponseEntity;

/**
 * @author Nurislom
 * @see org.khasanof.response
 * @since 12/29/2024 9:02 PM
 */
@Slf4j
public abstract class HttpResponseUtil {

    /**
     * @param response
     * @param <T>
     * @return
     */
    public static <T> ClientResultData<T> validateAndReturnResult(ResponseEntity<T> response) {
        if (response == null) {
            log.warn("response entity is null");
            return new ClientResultData<>(false, "response is null", null);
        }

        if (response.getBody() == null) {
            log.warn("response entity body is null");
            return new ClientResultData<>(false, response.getStatusCode().toString(), null);
        }

        if (response.getStatusCode().isError()) {
            log.warn("response http status is NOT success: {}", response.getStatusCode());
            return new ClientResultData<>(false, String.valueOf(response.getBody()), response.getBody());
        }

        log.debug("Response entity status code is OK : {}", response.getBody());
        return new ClientResultData<>(response.getBody());
    }
}
