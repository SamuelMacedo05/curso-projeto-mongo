package com.samuel.workshopmongo.config;

import com.samuel.workshopmongo.Repository.PostRepository;
import com.samuel.workshopmongo.Repository.UserRepository;
import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.User;
import com.samuel.workshopmongo.dto.AuthorDTO;
import com.samuel.workshopmongo.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository posRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        posRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para São Paulo", new AuthorDTO( maria)  );
        Post p2 = new Post(null, sdf.parse("27/09/2012"), "Hello word", "vou viajar pelo mundo", new AuthorDTO(alex) );

        CommentDTO c1 = new CommentDTO("Boa viagem mano!" , sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(maria));

        p1.getComments().addAll(Arrays.asList(c1,c2));
        p2.getComments().add(c3);

        posRepository.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll( Arrays.asList(p1,p2));
        userRepository.save(maria);

    }
}
