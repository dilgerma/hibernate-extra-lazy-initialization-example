package de.effectivetrainings.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Martin Dilger
 * @since: 20.04.13
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "author")
    private String author;

    public Comment(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (author != null ? !author.equals(comment1.author) : comment1.author != null) return false;
        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        if (id != null ? !id.equals(comment1.id) : comment1.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
