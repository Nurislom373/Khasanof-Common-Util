package org.khasanof.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Nurislom
 * @see org.khasanof
 * @since 12/2/2023 12:41 AM
 */
@Getter
@Setter
@ToString
public class ClientResult {

    private boolean success;
    private String responseText;

    public ClientResult(boolean success, String responseText) {
        this.success = success;
        this.responseText = responseText;
    }

    public ClientResult success(boolean success) {
        this.success = success;
        return this;
    }

    public ClientResult responseText(String responseText) {
        this.responseText = responseText;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientResult that = (ClientResult) o;

        if (success != that.success) return false;
        return Objects.equals(responseText, that.responseText);
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (responseText != null ? responseText.hashCode() : 0);
        return result;
    }

}
