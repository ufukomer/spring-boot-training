package thymereact.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Ömer Ufuk Efendio?lu
 */
public class Comment {

    private Long id;

    @NotEmpty(message = "Message is required.")
    private String text;

    @NotEmpty(message = "Summary is required.")
    private String summary;

    public Comment(Long id, String text, String summary) {
        this.id = id;
        this.text = text;
        this.summary = summary;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}