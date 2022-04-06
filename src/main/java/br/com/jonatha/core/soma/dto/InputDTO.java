package br.com.jonatha.core.soma.dto;

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
