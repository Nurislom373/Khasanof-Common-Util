package org.khasanof.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nurislom
 * @see org.khasanof.result
 * @since 12/29/2024 7:51 PM
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ClientResultData<D> extends ClientResult{

    private D data;

    public ClientResultData(boolean success, String responseText, D data) {
        super(success, responseText);
        this.data = data;
    }

    public ClientResultData(boolean success, String message) {
        super(success, message);
    }

    public ClientResultData(D data) {
        super(true, "success");
        this.data = data;
    }

    public ClientResultData<D> data(D data) {
        this.data = data;
        return this;
    }

    public ClientResultData<D> success(boolean success) {
        super.success(success);
        return this;
    }

    public ClientResultData<D> responseText(String responseText) {
        super.responseText(responseText);
        return this;
    }
}
