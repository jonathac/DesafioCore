package br.com.jonatha.core.soma.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class InputDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double input;

    public InputDTO() {
    }

    public Double getInput() {
        return input;
    }

    public void setInput(Double input) {
        this.input = input;
    }
}
