package com.netflix.example;

import com.netflix.example.domain.Movie;
import com.netflix.example.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class NetflixExampleApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(NetflixExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner init(MovieRepository movieRepository)
    {
        return (args) ->
        {
            movieRepository.deleteAll()
                    .thenMany(Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                            "Back to the Future", "Meet the Fluxes", "Lord of the Fluxex"))
                    .map(str -> new Movie("", str))
                    .flatMap(movieRepository::save)
                    .subscribe(null, null, () -> movieRepository.findAll()
                            .subscribe(System.out::println));
        };
    }

}
