package com.koutsilis1999.blog

import com.koutsilis1999.blog.entities.Article
import com.koutsilis1999.blog.entities.User
import com.koutsilis1999.blog.repositories.ArticleRepository
import com.koutsilis1999.blog.repositories.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {
        val johnDoe = userRepository.save(User("johnDoe", "John", "Doe"))
        articleRepository.save(
            Article(
                title = "Lorem", headline = "Lorem", content = "dolor sit amet", author = johnDoe
            )
        )
        articleRepository.save(
            Article(
                title = "Ipsum", headline = "Ipsum", content = "dolor sit amet", author = johnDoe
            )
        )

    }
}
