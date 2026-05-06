package com.samuel.workshopmongo.Repository;

import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
