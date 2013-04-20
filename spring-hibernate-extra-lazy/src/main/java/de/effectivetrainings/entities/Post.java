package de.effectivetrainings.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="POST")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	Integer postId;
	
	@Column(name="TITLE")
	String title;
	
	@Column(name="POST_DATE")
	Date postDate;

    //initialize this collection lazy
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="POST_ID",referencedColumnName = "POST_ID")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Comment> comments = new ArrayList<Comment>();


	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

    public Integer getCommentsCount(){
        return comments.size();
    }

    public List<Comment> getComments(){
        return comments;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }


    @PrePersist
	public void setPostDate() {
		this.postDate = new Date();
	}

    @PostLoad
    private void initCommentCount(){
        comments.size();
    }

}
