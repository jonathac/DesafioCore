    package br.com.jonatha.core.soma.domain;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import java.io.Serializable;
    import java.util.Objects;

    @Entity
    public class Input implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private Double input;
        private Double output;

        public Input (){

        }

        public Input(Double input) {
            this.input = input;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Double getInput() {
            return input;
        }

        public void setInput(Double input) {
            this.input = input;
        }

        public Double getOutput() {
            return output;
        }

        public void setOutput(Double output) {
            this.output = output;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Input)) return false;
            Input input = (Input) o;
            return getId().equals(input.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId());
        }

    }
