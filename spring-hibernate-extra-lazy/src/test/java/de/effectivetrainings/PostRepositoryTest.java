package de.effectivetrainings;

import de.effectivetrainings.entities.Comment;
import de.effectivetrainings.entities.Post;
import de.effectivetrainings.repositories.PostRepository;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@Test(expected = LazyInitializationException.class)
	public void test() {
        Post post = savePostWithComments();
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getTitle());
        //you can get the size of the lazy initialized list
        assertEquals(new Integer(2), dbpost.getCommentsCount());
        //but the elements are not loaded
        dbpost.getComments().get(0);
	}


    private Post savePostWithComments() {
        Post post = new Post();
        Comment firstComment = new Comment("Kommentar Text1","Martin");
        post.addComment(firstComment);
        Comment secondComment = new Comment("Kommentar Text1","Martin");
        post.addComment(secondComment);
        post.setTitle("First Post");

        repository.save(post);
        return post;
    }

}
